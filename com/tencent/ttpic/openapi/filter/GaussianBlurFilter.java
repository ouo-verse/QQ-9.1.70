package com.tencent.ttpic.openapi.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.openrender.util.ProgramTools;
import com.tencent.filter.GLSLRender;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GaussianBlurFilter {
    public static final int FLOAT_SIZE_BYTES = 4;
    private static final String FRAGMENT_SHADER = "precision mediump float;\nuniform sampler2D inputImageTexture;\nvarying highp vec2 textureCoordinate;\nconst lowp int GAUSSIAN_WEIGHT_NUMBERS = 11;\n\nuniform float weight[GAUSSIAN_WEIGHT_NUMBERS]; \nvarying vec2 blurCoordinates[21];\n\nvoid main()\n{\n    lowp vec3 sum = vec3(0.0);\n    lowp vec4 fragColor=texture2D(inputImageTexture,textureCoordinate);\n\n    sum += texture2D(inputImageTexture, textureCoordinate.xy).rgb * weight[0];\n\n    int medium = GAUSSIAN_WEIGHT_NUMBERS - 1;\n    for (int i = 1; i <= medium; i++) {\n        sum += texture2D(inputImageTexture, blurCoordinates[medium + i]).rgb * weight[i];\n        sum += texture2D(inputImageTexture, blurCoordinates[medium - i]).rgb * weight[i];\n    }\n\n    gl_FragColor = vec4(sum,fragColor.a);\n}";
    private static final FloatBuffer TEXTURE_BUF;
    public static final float[] TEXUTURE_COORDS;
    private static final FloatBuffer VERTEXT_BUF;
    public static final float[] VERTEXT_COORDS;
    private static final String VERTEXT_SHADER = "attribute vec4 aPosition;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nuniform float hOffset;\nuniform float vOffset;\n\nconst int GAUSSIAN_VERTICAL_SAMPLES = 21;\nvarying vec2 blurCoordinates[21];\n\nvoid main()\n{\n    gl_Position = aPosition;\n    textureCoordinate = inputTextureCoordinate.xy;\n    // Calculate the positions for the blur\n    int multiplier = 0;\n    vec2 blurStep;\n    vec2 singleStepOffset = vec2(hOffset, vOffset);\n    for (int i = 0; i < GAUSSIAN_VERTICAL_SAMPLES; i++) {\n        multiplier = (i - ((GAUSSIAN_VERTICAL_SAMPLES - 1) / 2));\n        blurStep = float(multiplier) * singleStepOffset;\n        blurCoordinates[i] = inputTextureCoordinate.xy + blurStep;\n    }\n}";
    private boolean mIsInitialized;
    private float mOutputHeight;
    private float mOutputWidth;
    private int mProgram;
    private float[] mWeights;
    public int mTextureType = GLSLRender.GL_TEXTURE_2D;
    private float horizontalRadiusRatio = 1.0f;
    private float verticalRadiusRatio = 1.0f;

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

    public void drawTexture(int i3) {
        int i16 = this.mProgram;
        if (i16 == 0) {
            return;
        }
        GLES20.glUseProgram(i16);
        int glGetAttribLocation = GLES20.glGetAttribLocation(i16, "aPosition");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(i16, "inputTextureCoordinate");
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, (Buffer) VERTEXT_BUF);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, (Buffer) TEXTURE_BUF);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i16, "weight");
        float[] fArr = this.mWeights;
        GLES20.glUniform1fv(glGetUniformLocation, fArr.length, fArr, 0);
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i16, "hOffset");
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(i16, "vOffset");
        GLES20.glUniform1f(glGetUniformLocation2, this.horizontalRadiusRatio / this.mOutputWidth);
        GLES20.glUniform1f(glGetUniformLocation3, this.verticalRadiusRatio / this.mOutputHeight);
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

    public void init(int i3, int i16) {
        if (this.mIsInitialized) {
            return;
        }
        ProgramTools.ProgramInfo createProgram = ProgramTools.createProgram(VERTEXT_SHADER, FRAGMENT_SHADER);
        if (createProgram == null) {
            new RuntimeException("failed creating program " + getClass().getSimpleName()).printStackTrace();
            return;
        }
        this.mProgram = createProgram.programId;
        this.mOutputWidth = i3;
        this.mOutputHeight = i16;
        this.mIsInitialized = true;
    }

    public boolean isInitSucc() {
        if (this.mProgram != 0) {
            return true;
        }
        return false;
    }

    public void setStepRatio(float[] fArr, float f16, float f17) {
        this.horizontalRadiusRatio = f16;
        this.verticalRadiusRatio = f17;
        if (fArr != null) {
            this.mWeights = fArr;
        }
    }
}
