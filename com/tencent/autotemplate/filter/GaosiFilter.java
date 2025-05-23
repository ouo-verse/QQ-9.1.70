package com.tencent.autotemplate.filter;

import android.opengl.GLES20;
import android.util.Log;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
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
@Deprecated
/* loaded from: classes3.dex */
public class GaosiFilter extends TAVBaseFilter {
    static IPatchRedirector $redirector_ = null;
    protected static final int FLOAT_SIZE_BYTES = 4;
    public static final String FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputTexture;// \u539f\u59cb\u56fe\u50cf\n// \u9ad8\u65af\u7b97\u5b50\u5de6\u53f3\u504f\u79fb\u503c\uff0c\u5f53\u504f\u79fb\u503c\u4e3a2\u65f6\uff0c\u9ad8\u65af\u7b97\u5b50\u4e3a5 x 5\nconst int SHIFT_SIZE = 2;\nvarying vec4 blurShiftCoordinates[SHIFT_SIZE];\nvec4 drawGaosiImage(sampler2D targetTexture);\nvoid main() {\n    gl_FragColor = drawGaosiImage(inputTexture);\n}\n\nvec4 drawGaosiImage(sampler2D targetTexture) {\n    // \u8ba1\u7b97\u5f53\u524d\u5750\u6807\u7684\u989c\u8272\u503c\n    vec4 currentColor = texture2D(targetTexture, textureCoordinate);\n    mediump vec3 sum = currentColor.rgb;\n    // \u8ba1\u7b97\u504f\u79fb\u5750\u6807\u7684\u989c\u8272\u503c\u603b\u548c\n    for (int i = 0; i < SHIFT_SIZE; i++) {\n        sum += texture2D(targetTexture, blurShiftCoordinates[i].xy).rgb;\n        sum += texture2D(targetTexture, blurShiftCoordinates[i].zw).rgb;\n    }\n    // \u6c42\u51fa\u5e73\u5747\u503c\n    vec4 gaosiColor = vec4(sum * 1.0 / float(2 * SHIFT_SIZE + 1), currentColor.a);\n    return gaosiColor;\n}";
    protected static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
    protected static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 8;
    public static String VERTEX_SHADER_CODE;
    private int aPositionHandle;
    protected float blurSize;
    private int[] fbo;
    protected boolean horizontal;
    protected TAVTextureInfo outputTextureInfo;
    private int texelHeightOffsetLocation;
    private int texelWidthOffsetLocation;
    protected int[] textureID;
    protected FloatBuffer triangleVertices;
    private int uScreenSizeHandle;
    private int uTextureSizeHandle;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12875);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            VERTEX_SHADER_CODE = "uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\n// \u9ad8\u65af\u7b97\u5b50\u5de6\u53f3\u504f\u79fb\u503c\uff0c\u5f53\u504f\u79fb\u503c\u4e3a2\u65f6\uff0c\u9ad8\u65af\u7b97\u5b50\u4e3a5 x 5\nconst int SHIFT_SIZE = 2;\nattribute vec2 aPosition;\nvarying vec2 textureCoordinate;\nvarying vec4 blurShiftCoordinates[SHIFT_SIZE];\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  textureCoordinate = (stMatrix * coord).xy;\n\t\n// \u8bb0\u5f55\u504f\u79fb\u5750\u6807\n   vec2 singleStepOffset = vec2(texelHeightOffset, texelWidthOffset);\n    \n   for (int i = 0; i < SHIFT_SIZE; i++) \n   {\n       blurShiftCoordinates[i] = vec4(textureCoordinate.xy - float(i + 1) * singleStepOffset, textureCoordinate.xy + float(i + 1) * singleStepOffset);\n\t}\n}\n";
        }
    }

    public GaosiFilter(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
            return;
        }
        this.fbo = new int[1];
        this.textureID = new int[1];
        this.blurSize = 5.0f;
        this.horizontal = z16;
    }

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
    }

    protected void afterDraw(TAVTextureInfo tAVTextureInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) tAVTextureInfo);
        }
    }

    @Override // com.tencent.taveffect.core.TAVTextureProcessor
    public TAVTextureInfo applyNewTexture(TAVTextureInfo tAVTextureInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TAVTextureInfo) iPatchRedirector.redirect((short) 8, (Object) this, (Object) tAVTextureInfo);
        }
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

    protected void beforeDraw(TAVTextureInfo tAVTextureInfo) {
        float verticalTexelOffsetRatio;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) tAVTextureInfo);
            return;
        }
        float f16 = 0.0f;
        if (this.horizontal) {
            f16 = getHorizontalTexelOffsetRatio() / tAVTextureInfo.width;
            verticalTexelOffsetRatio = 0.0f;
        } else {
            verticalTexelOffsetRatio = getVerticalTexelOffsetRatio() / tAVTextureInfo.height;
        }
        GLES20.glUniform1f(this.texelWidthOffsetLocation, f16);
        GLES20.glUniform1f(this.texelHeightOffsetLocation, verticalTexelOffsetRatio);
    }

    protected String getFragmentShaderCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return FRAGMENT_SHADER;
    }

    public float getHorizontalTexelOffsetRatio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Float) iPatchRedirector.redirect((short) 12, (Object) this)).floatValue();
        }
        return this.blurSize;
    }

    protected TAVTextureInfo getOutputTextureInfo(TAVTextureInfo tAVTextureInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TAVTextureInfo) iPatchRedirector.redirect((short) 9, (Object) this, (Object) tAVTextureInfo);
        }
        if (this.outputTextureInfo == null) {
            this.outputTextureInfo = new TAVTextureInfo();
        }
        this.outputTextureInfo.setFrameTimeUs(tAVTextureInfo.frameTimeUs);
        this.outputTextureInfo.setWidth(tAVTextureInfo.width);
        this.outputTextureInfo.setHeight(tAVTextureInfo.height);
        this.outputTextureInfo.setPreRotation(tAVTextureInfo.getPreRotation());
        this.outputTextureInfo.setTextureType(GLSLRender.GL_TEXTURE_2D);
        this.outputTextureInfo.setTextureID(this.textureID[0]);
        return this.outputTextureInfo;
    }

    public float getVerticalTexelOffsetRatio() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Float) iPatchRedirector.redirect((short) 11, (Object) this)).floatValue();
        }
        return this.blurSize;
    }

    protected void initShader(TAVTextureInfo tAVTextureInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) tAVTextureInfo);
            return;
        }
        this.triangleVertices = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
        String fragmentShaderCode = getFragmentShaderCode();
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
        this.texelWidthOffsetLocation = GLES20.glGetUniformLocation(this.program, "texelWidthOffset");
        TAVGLUtils.checkEglError("glGetUniformLocation texelWidthOffset");
        this.texelHeightOffsetLocation = GLES20.glGetUniformLocation(this.program, "texelHeightOffset");
        TAVGLUtils.checkEglError("glGetUniformLocation texelHeightOffset");
    }

    protected void onDraw(TAVTextureInfo tAVTextureInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) tAVTextureInfo);
            return;
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
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

    protected void useProgram() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        GLES20.glUseProgram(this.program);
        TAVGLUtils.checkEglError("glUseProgram");
        GLES20.glUniformMatrix3fv(this.stMatrixHandle, 1, false, TAVMatrixUtils.toOpenGL2DMatrix(this.stMatrix), 0);
    }
}
