package com.tencent.taveffect.effects;

import android.graphics.Matrix;
import android.opengl.GLES20;
import android.os.SystemClock;
import android.util.Log;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.taveffect.core.TAVBaseFilter;
import com.tencent.taveffect.core.TAVRectangle;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.utils.TAVGLUtils;
import com.tencent.taveffect.utils.TAVMatrixUtils;
import com.tencent.taveffect.utils.TVTGLProgramUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class BaseEffect extends TAVBaseFilter {
    protected static final int FLOAT_SIZE_BYTES = 4;
    protected static final String FRAGMENT_SHADER_PREFIX = "uniform sampler2D ";
    protected static final String FRAGMENT_SHADER_PREFIX_OES = " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES ";
    protected static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
    protected static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 8;
    protected static String VERTEX_SHADER_CODE = "uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n";
    private int aPositionHandle;
    private float curFrameTime;
    protected float deltaTime;
    private float lastFrameTime;
    protected TAVTextureInfo outputTextureInfo;
    protected FloatBuffer triangleVertices;
    private int uScreenSizeHandle;
    private int uTextureSizeHandle;
    private int[] fbo = new int[1];
    protected int[] textureID = new int[1];

    private void bindFramebuffer() {
        GLES20.glGetIntegerv(2978, this.defaultViewport, 0);
        int i3 = this.fbo[0];
        if (i3 == 0) {
            GLES20.glGenTextures(1, this.textureID, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.textureID[0]);
            GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6407, this.rendererWidth, this.rendererHeight, 0, 6407, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
            GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
            GLES20.glGenFramebuffers(1, this.fbo, 0);
            GLES20.glBindFramebuffer(36160, this.fbo[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, this.textureID[0], 0);
            GLES20.glClear(16384);
            GLES20.glViewport(0, 0, this.rendererWidth, this.rendererHeight);
            return;
        }
        GLES20.glBindFramebuffer(36160, i3);
        GLES20.glClear(16384);
        GLES20.glViewport(0, 0, this.rendererWidth, this.rendererHeight);
    }

    private void finishDraw(TAVTextureInfo tAVTextureInfo) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(tAVTextureInfo.textureType, 0);
        GLES20.glBindFramebuffer(36160, 0);
        int[] iArr = this.defaultViewport;
        GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        this.lastFrameTime = this.curFrameTime;
    }

    @Override // com.tencent.taveffect.core.TAVTextureProcessor
    public TAVTextureInfo applyNewTexture(TAVTextureInfo tAVTextureInfo) {
        if (this.lastFrameTime == 0.0f) {
            this.lastFrameTime = (float) SystemClock.uptimeMillis();
        }
        float uptimeMillis = (float) SystemClock.uptimeMillis();
        this.curFrameTime = uptimeMillis;
        this.deltaTime = (uptimeMillis - this.lastFrameTime) / 1000.0f;
        if (this.rendererWidth == 0 || this.rendererHeight == 0) {
            Log.w(this.TAG, "rendererWidth = " + this.rendererWidth + ", rendererHeight = " + this.rendererHeight);
        }
        if (tAVTextureInfo.textureType != this.textureType || this.program == 0) {
            initShader(tAVTextureInfo);
        }
        bindFramebuffer();
        useProgram();
        beforeDraw(tAVTextureInfo);
        onDraw(tAVTextureInfo);
        afterDraw(tAVTextureInfo);
        finishDraw(tAVTextureInfo);
        return getOutputTextureInfo(tAVTextureInfo);
    }

    protected abstract String getFragmentShaderCode(TAVTextureInfo tAVTextureInfo);

    /* JADX INFO: Access modifiers changed from: protected */
    public TAVTextureInfo getOutputTextureInfo(TAVTextureInfo tAVTextureInfo) {
        if (this.outputTextureInfo == null) {
            this.outputTextureInfo = new TAVTextureInfo();
        }
        this.outputTextureInfo.setFrameTimeUs(tAVTextureInfo.frameTimeUs);
        this.outputTextureInfo.setWidth(this.rendererWidth);
        this.outputTextureInfo.setHeight(this.rendererHeight);
        this.outputTextureInfo.setPreRotation(tAVTextureInfo.getPreRotation());
        this.outputTextureInfo.setTextureType(GLSLRender.GL_TEXTURE_2D);
        this.outputTextureInfo.setTextureID(this.textureID[0]);
        return this.outputTextureInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initShader(TAVTextureInfo tAVTextureInfo) {
        this.triangleVertices = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
        String fragmentShaderCode = getFragmentShaderCode(tAVTextureInfo);
        String str = VERTEX_SHADER_CODE;
        this.vertexShaderCode = str;
        this.fragmentShaderCode = fragmentShaderCode;
        int createProgram = TVTGLProgramUtils.createProgram(str, fragmentShaderCode);
        this.program = createProgram;
        if (createProgram == 0) {
            new RuntimeException("failed creating program").printStackTrace();
            return;
        }
        this.aPositionHandle = GLES20.glGetAttribLocation(createProgram, "aPosition");
        TAVGLUtils.checkEglError("glGetAttribLocation aPosition");
        this.xyMatrixHandle = GLES20.glGetUniformLocation(this.program, "uMatrix");
        TAVGLUtils.checkEglError("glGetUniformLocation uMatrix");
        this.stMatrixHandle = GLES20.glGetUniformLocation(this.program, "stMatrix");
        TAVGLUtils.checkEglError("glGetUniformLocation stMatrix");
        this.uScreenSizeHandle = GLES20.glGetUniformLocation(this.program, "uScreenSize");
        TAVGLUtils.checkEglError("glGetUniformLocation uScreenSize");
        this.uTextureSizeHandle = GLES20.glGetUniformLocation(this.program, "uTextureSize");
        TAVGLUtils.checkEglError("glGetUniformLocation uTextureSize");
        this.stMatrixHandle = GLES20.glGetUniformLocation(this.program, "stMatrix");
        TAVGLUtils.checkEglError("glGetUniformLocation stMatrix");
        this.textureType = tAVTextureInfo.textureType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDraw(TAVTextureInfo tAVTextureInfo) {
        TAVRectangle tAVRectangle = new TAVRectangle(0.0f, 0.0f, tAVTextureInfo.width, tAVTextureInfo.height);
        this.cropRect = tAVRectangle;
        float f16 = tAVRectangle.f374471x;
        float f17 = tAVRectangle.f374472y;
        float f18 = tAVRectangle.height;
        float f19 = tAVRectangle.width;
        this.triangleVertices.rewind();
        this.triangleVertices.put(new float[]{f16, f17 + f18, f16, f17, f16 + f19, f18 + f17, f16 + f19, f17});
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(tAVTextureInfo.textureType, tAVTextureInfo.textureID);
        this.triangleVertices.position(0);
        GLES20.glVertexAttribPointer(this.aPositionHandle, 2, 5126, false, 8, (Buffer) this.triangleVertices);
        TAVGLUtils.checkEglError("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.aPositionHandle);
        TAVGLUtils.checkEglError("glEnableVertexAttribArray aPositionHandle");
        GLES20.glUniformMatrix3fv(this.xyMatrixHandle, 1, false, TAVMatrixUtils.toOpenGL2DMatrix(this.xyMatrix), 0);
        GLES20.glUniform2f(this.uTextureSizeHandle, tAVTextureInfo.width, tAVTextureInfo.height);
        GLES20.glUniform2f(this.uScreenSizeHandle, this.rendererWidth, this.rendererHeight);
        GLES20.glDrawArrays(5, 0, 4);
        TAVGLUtils.checkEglError("glDrawArrays");
    }

    @Override // com.tencent.taveffect.core.TAVTextureProcessor
    public void release() {
        int[] iArr = this.textureID;
        if (iArr[0] != 0) {
            GLES20.glDeleteTextures(1, iArr, 0);
            this.textureID[0] = 0;
        }
        int[] iArr2 = this.fbo;
        if (iArr2[0] != 0) {
            GLES20.glDeleteFramebuffers(1, iArr2, 0);
            this.fbo[0] = 0;
        }
        GLES20.glDeleteProgram(this.program);
        this.program = 0;
        this.xyMatrix = null;
        this.stMatrix = null;
        this.cropRect = null;
    }

    @Override // com.tencent.taveffect.core.TAVBaseFilter
    public void setParams(Matrix matrix, Matrix matrix2, TAVRectangle tAVRectangle, float f16) {
        this.alpha = f16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void useProgram() {
        GLES20.glUseProgram(this.program);
        TAVGLUtils.checkEglError("glUseProgram");
        GLES20.glUniformMatrix3fv(this.stMatrixHandle, 1, false, TAVMatrixUtils.toOpenGL2DMatrix(this.stMatrix), 0);
    }

    protected void afterDraw(TAVTextureInfo tAVTextureInfo) {
    }

    protected void beforeDraw(TAVTextureInfo tAVTextureInfo) {
    }
}
