package com.tencent.taveffect.core;

import android.graphics.Matrix;
import android.opengl.GLES20;
import com.tencent.taveffect.utils.TAVGLUtils;
import com.tencent.taveffect.utils.TAVMatrixUtils;
import com.tencent.taveffect.utils.TVTGLProgramUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVRendererFilter extends TAVBaseFilter {
    protected static final int FLOAT_SIZE_BYTES = 4;
    protected static final String FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float uAlpha;\nvoid main() {\n   vec4 color = texture2D(sTexture, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
    protected static final String FRAGMENT_SHADER_OES = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTextureOES;\nuniform float uAlpha;\nvoid main() {\n  vec4 color = texture2D(sTextureOES, vTextureCoord);\n  gl_FragColor = mix(vec4(0,0,0,1), color, uAlpha);\n}\n";
    protected static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
    protected static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 8;
    protected static final String VERTEX_SHADER = "uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n";
    protected int aPositionHandle;
    protected FloatBuffer triangleVertices;
    private int uAlphaHandle;
    protected int uScreenSizeHandle;
    protected int uTextureSizeHandle;

    public TAVRendererFilter() {
        this(0, 0);
    }

    @Override // com.tencent.taveffect.core.TAVTextureProcessor
    public TAVTextureInfo applyNewTexture(TAVTextureInfo tAVTextureInfo) {
        if (tAVTextureInfo.textureType != this.textureType || this.program == 0) {
            initShaderForTextureInfo(tAVTextureInfo);
        }
        if (this.cropRect == null) {
            this.cropRect = new TAVRectangle(0.0f, 0.0f, tAVTextureInfo.width, tAVTextureInfo.height);
        }
        TAVRectangle tAVRectangle = this.cropRect;
        float f16 = tAVRectangle.f374471x;
        float f17 = tAVRectangle.f374472y;
        float f18 = tAVRectangle.height;
        float f19 = tAVRectangle.width;
        this.triangleVertices.rewind();
        this.triangleVertices.put(new float[]{f16, f17 + f18, f16, f17, f16 + f19, f18 + f17, f16 + f19, f17});
        GLES20.glGetIntegerv(2978, this.defaultViewport, 0);
        GLES20.glUseProgram(this.program);
        TAVGLUtils.checkEglError("glUseProgram");
        GLES20.glUniformMatrix3fv(this.stMatrixHandle, 1, false, TAVMatrixUtils.toOpenGL2DMatrix(this.stMatrix), 0);
        GLES20.glUniform1f(this.uAlphaHandle, this.alpha);
        prepareDraw(tAVTextureInfo, TAVMatrixUtils.toOpenGL2DMatrix(this.xyMatrix));
        GLES20.glDrawArrays(5, 0, 4);
        TAVGLUtils.checkEglError("glDrawArrays");
        finishDraw(tAVTextureInfo);
        return tAVTextureInfo;
    }

    protected void finishDraw(TAVTextureInfo tAVTextureInfo) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(tAVTextureInfo.textureType, 0);
        int[] iArr = this.defaultViewport;
        GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    public int hashCode() {
        return ((((((((((((((0 + this.program) * 31) + this.uScreenSizeHandle) * 31) + this.uTextureSizeHandle) * 31) + this.xyMatrixHandle) * 31) + this.uAlphaHandle) * 31) + this.stMatrixHandle) * 31) + this.aPositionHandle) * 31) + Arrays.hashCode(this.defaultViewport);
    }

    protected void initShaderForTextureInfo(TAVTextureInfo tAVTextureInfo) {
        if (tAVTextureInfo.textureType == 36197) {
            initShaders(VERTEX_SHADER, FRAGMENT_SHADER_OES);
        } else {
            initShaders(VERTEX_SHADER, FRAGMENT_SHADER);
        }
        this.textureType = tAVTextureInfo.textureType;
    }

    protected void initShaders(String str, String str2) {
        this.triangleVertices = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.vertexShaderCode = str;
        this.fragmentShaderCode = str2;
        int createProgram = TVTGLProgramUtils.createProgram(str, str2);
        this.program = createProgram;
        if (createProgram == 0) {
            new RuntimeException("failed creating program").printStackTrace();
            return;
        }
        this.aPositionHandle = GLES20.glGetAttribLocation(createProgram, "aPosition");
        TAVGLUtils.checkEglError("glGetAttribLocation aPosition");
        this.xyMatrixHandle = GLES20.glGetUniformLocation(this.program, "uMatrix");
        TAVGLUtils.checkEglError("glGetUniformLocation uMatrix");
        this.uAlphaHandle = GLES20.glGetUniformLocation(this.program, "uAlpha");
        TAVGLUtils.checkEglError("glGetUniformLocation uAlpha");
        this.stMatrixHandle = GLES20.glGetUniformLocation(this.program, "stMatrix");
        TAVGLUtils.checkEglError("glGetUniformLocation stMatrix");
        this.uScreenSizeHandle = GLES20.glGetUniformLocation(this.program, "uScreenSize");
        TAVGLUtils.checkEglError("glGetUniformLocation uScreenSize");
        this.uTextureSizeHandle = GLES20.glGetUniformLocation(this.program, "uTextureSize");
        TAVGLUtils.checkEglError("glGetUniformLocation uTextureSize");
    }

    protected void prepareDraw(TAVTextureInfo tAVTextureInfo, float[] fArr) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(tAVTextureInfo.textureType, tAVTextureInfo.textureID);
        this.triangleVertices.position(0);
        GLES20.glVertexAttribPointer(this.aPositionHandle, 2, 5126, false, 8, (Buffer) this.triangleVertices);
        TAVGLUtils.checkEglError("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.aPositionHandle);
        TAVGLUtils.checkEglError("glEnableVertexAttribArray aPositionHandle");
        GLES20.glUniformMatrix3fv(this.xyMatrixHandle, 1, false, fArr, 0);
        GLES20.glUniform2f(this.uTextureSizeHandle, tAVTextureInfo.width, tAVTextureInfo.height);
        GLES20.glUniform2f(this.uScreenSizeHandle, this.rendererWidth, this.rendererHeight);
    }

    @Override // com.tencent.taveffect.core.TAVTextureProcessor
    public void release() {
        GLES20.glDeleteProgram(this.program);
        this.program = 0;
    }

    @Override // com.tencent.taveffect.core.TAVBaseFilter
    public void setParams(Matrix matrix, Matrix matrix2, TAVRectangle tAVRectangle, float f16) {
        this.alpha = f16;
    }

    public TAVRendererFilter(int i3, int i16) {
        this.rendererWidth = i3;
        this.rendererHeight = i16;
    }

    @Override // com.tencent.taveffect.core.TAVBaseFilter
    /* renamed from: clone */
    public TAVRendererFilter mo93clone() {
        return (TAVRendererFilter) cloneFilter(new TAVRendererFilter());
    }
}
