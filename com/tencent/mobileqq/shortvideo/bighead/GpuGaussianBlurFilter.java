package com.tencent.mobileqq.shortvideo.bighead;

import android.opengl.GLES20;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qqmini.miniapp.widget.camera.CameraFilterEngine;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GpuGaussianBlurFilter {
    public static final int FLOAT_SIZE_BYTES = 4;
    public static final String FRAGMENT_SHADER_3 = "const lowp int GAUSSIAN_SAMPLES = 9;\nuniform sampler2D inputImageTexture;\nuniform lowp float weight[GAUSSIAN_SAMPLES]; \n\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n\nvoid main()\n{\n\t lowp vec3 sum = vec3(0.0);\n   lowp vec4 fragColor=texture2D(inputImageTexture,textureCoordinate);\n\t\n    for (int i = 0; i < GAUSSIAN_SAMPLES; i++) {\n        sum += texture2D(inputImageTexture, blurCoordinates[i]).rgb * weight[i];\n    }\n\n    if(sum.r >= 0.79){\n\t      gl_FragColor = vec4(1.0,sum.gb,fragColor.a);\n    }else{\n         gl_FragColor = vec4(0.0,sum.gb,fragColor.a);\n    }\n}";
    public static final FloatBuffer TEXTURE_BUF;
    public static final float[] TEXUTURE_COORDS;
    public static final FloatBuffer VERTEXT_BUF;
    public static final float[] VERTEXT_COORDS;
    public static final String VERTEX_SHADER_3 = "precision highp float;\nattribute vec4 aPosition;\nattribute vec4 inputTextureCoordinate;\nconst int GAUSSIAN_SAMPLES = 9;\n\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\nuniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\n\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n\nvoid main()\n{\n\tgl_Position = uMVPMatrix * aPosition;\n\ttextureCoordinate = (uTextureMatrix * inputTextureCoordinate).xy;\n\tblurCoordinates[0] = textureCoordinate.xy + vec2(-texelWidthOffset,-texelHeightOffset);\n\tblurCoordinates[1] = textureCoordinate.xy + vec2(0,-texelHeightOffset);\n\tblurCoordinates[2] = textureCoordinate.xy + vec2(texelWidthOffset,-texelHeightOffset);\n\tblurCoordinates[3] = textureCoordinate.xy + vec2(-texelWidthOffset,0);\n\tblurCoordinates[4] = textureCoordinate.xy + vec2(0,0);\n\tblurCoordinates[5] = textureCoordinate.xy + vec2(texelWidthOffset,0);\n\tblurCoordinates[6] = textureCoordinate.xy + vec2(-texelWidthOffset,texelHeightOffset);\n\tblurCoordinates[7] = textureCoordinate.xy + vec2(0,texelHeightOffset);\n\tblurCoordinates[8] = textureCoordinate.xy + vec2(texelWidthOffset,texelHeightOffset);\n}\n";
    private boolean mIsInitialized;
    private float mOutputHeight;
    private float mOutputWidth;
    private int mProgram;
    private float[] mWeights;
    public int mTextureType = GLSLRender.GL_TEXTURE_2D;
    private float mWidthStepRatio = 1.0f;
    private float mHeightStepRatio = 1.0f;

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        VERTEXT_COORDS = fArr;
        float[] fArr2 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        TEXUTURE_COORDS = fArr2;
        VERTEXT_BUF = GlUtil.createFloatBuffer(fArr);
        TEXTURE_BUF = GlUtil.createFloatBuffer(fArr2);
    }

    public void destroy() {
        if (this.mIsInitialized) {
            this.mIsInitialized = false;
            GLES20.glDeleteProgram(this.mProgram);
            this.mProgram = 0;
        }
    }

    public void drawTexture(int i3, float[] fArr, float[] fArr2) {
        int i16 = this.mProgram;
        if (fArr == null) {
            fArr = BigHeadBuckler.sGIdentity;
        }
        if (fArr2 == null) {
            fArr2 = BigHeadBuckler.sGIdentity;
        }
        GLES20.glUseProgram(i16);
        int glGetAttribLocation = GLES20.glGetAttribLocation(i16, "aPosition");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(i16, "inputTextureCoordinate");
        int glGetUniformLocation = GLES20.glGetUniformLocation(i16, "uMVPMatrix");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i16, CameraFilterEngine.TEXTURE_MATRIX_UNIFORM);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, (Buffer) VERTEXT_BUF);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, (Buffer) TEXTURE_BUF);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        GLES20.glUniformMatrix4fv(glGetUniformLocation, 1, false, fArr2, 0);
        GLES20.glUniformMatrix4fv(glGetUniformLocation2, 1, false, fArr, 0);
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(i16, "weight");
        float[] fArr3 = this.mWeights;
        GLES20.glUniform1fv(glGetUniformLocation3, fArr3.length, fArr3, 0);
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(i16, "texelWidthOffset");
        int glGetUniformLocation5 = GLES20.glGetUniformLocation(i16, "texelHeightOffset");
        GLES20.glUniform1f(glGetUniformLocation4, this.mWidthStepRatio / this.mOutputWidth);
        GLES20.glUniform1f(glGetUniformLocation5, this.mHeightStepRatio / this.mOutputHeight);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureType, i3);
        GLES20.glUniform1i(GLES20.glGetUniformLocation(i16, "inputImageTexture"), 0);
        GLES20.glDrawArrays(5, 0, 4);
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        throw new RuntimeException("error =" + glGetError);
    }

    public void init(int i3, int i16, float[] fArr) {
        if (this.mIsInitialized) {
            return;
        }
        this.mWeights = fArr;
        int createProgram = GlUtil.createProgram(VERTEX_SHADER_3, FRAGMENT_SHADER_3);
        this.mProgram = createProgram;
        if (fArr.length == 9) {
            if (createProgram == 0) {
                new RuntimeException("failed creating program " + getClass().getSimpleName()).printStackTrace();
            }
            this.mOutputWidth = i3;
            this.mOutputHeight = i16;
            this.mIsInitialized = true;
            return;
        }
        throw new RuntimeException(MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR);
    }

    public void setStepRatio(float f16, float f17) {
        this.mWidthStepRatio = f16;
        this.mHeightStepRatio = f17;
    }
}
