package com.tencent.ttpic.openapi.filter;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.openrender.util.ProgramTools;
import com.tencent.filter.GLSLRender;
import com.tencent.qqmini.miniapp.widget.camera.CameraFilterEngine;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: classes27.dex */
public class GPUBaseFilter {
    public static final int FILTER_BASE = 100;
    public static final int FLOAT_SIZE_BYTES = 4;
    public static final int MOSAIC_FILTER_ID = 106;
    public static final String NO_FILTER_FRAGMENT_SHADER = "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n";
    public static final int NO_FILTER_ID = 101;
    public static final int NO_FILTER_ID_OES = 102;
    public static final String NO_FILTER_VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n";
    private static final String TAG = "GPUBaseFilter";
    public static final float[] TEXUTURE_COORDS = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final FloatBuffer VERTEXT_BUF;
    public static float[] VERTEXT_COORDS;
    protected int mFilterType;
    private final String mFragmentShader;
    private boolean mIsInitialized;
    protected int mOutputHeight;
    protected int mOutputWidth;
    private int mProgram;
    public int mTextureType;
    private FloatBuffer mUserTextureCoord;
    private final String mVertexShader;

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        VERTEXT_COORDS = fArr;
        VERTEXT_BUF = GlUtil.createFloatBuffer(fArr);
    }

    public GPUBaseFilter() {
        this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", NO_FILTER_FRAGMENT_SHADER);
    }

    public static float[] caculateAbsoluteMvpMatrix(int i3, int i16, int i17, int i18) {
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        Matrix.scaleM(fArr, 0, i3 / i17, i16 / i18, 1.0f);
        return fArr;
    }

    public static float[] caculateCenterCropMvpMatrix(int i3, int i16, int i17, int i18) {
        float f16;
        float f17;
        float f18 = i17;
        float f19 = i18;
        float f26 = f18 / f19;
        float f27 = i3 / i16;
        if (f26 < f27) {
            f16 = (f27 * f19) / f18;
            f17 = 1.0f;
        } else if (f26 > f27) {
            f17 = f18 / (f27 * f19);
            f16 = 1.0f;
        } else {
            f16 = 1.0f;
            f17 = 1.0f;
        }
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        Matrix.scaleM(fArr, 0, f16, f17, 1.0f);
        return fArr;
    }

    public static float[] caculateFitCenterMvpMatrix(int i3, int i16, int i17, int i18) {
        float f16;
        float f17;
        float f18 = i17;
        float f19 = i18;
        float f26 = f18 / f19;
        float f27 = i3 / i16;
        if (f26 > f27) {
            f16 = (f27 * f19) / f18;
            f17 = 1.0f;
        } else if (f26 < f27) {
            f17 = f18 / (f27 * f19);
            f16 = 1.0f;
        } else {
            f16 = 1.0f;
            f17 = 1.0f;
        }
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        Matrix.scaleM(fArr, 0, f16, f17, 1.0f);
        return fArr;
    }

    public static void checkGlError(String str) {
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                new RuntimeException(str + ": glError " + glGetError);
            } else {
                return;
            }
        }
    }

    public static void checkLocation(int i3, String str) {
        if (i3 < 0) {
            new RuntimeException("Unable to locate '" + str + "' in program");
        }
    }

    public void destroy() {
        this.mIsInitialized = false;
        GLES20.glDeleteProgram(this.mProgram);
        this.mProgram = 0;
        onDestroy();
    }

    public void drawTexture(int i3, float[] fArr, float[] fArr2) {
        checkGlError("onDrawFrame start");
        int program = getProgram();
        if (fArr == null) {
            fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
        }
        if (fArr2 == null) {
            fArr2 = new float[16];
            Matrix.setIdentityM(fArr2, 0);
        }
        GLES20.glUseProgram(program);
        checkGlError("glUseProgram");
        int glGetAttribLocation = GLES20.glGetAttribLocation(program, "aPosition");
        checkLocation(glGetAttribLocation, "aPosition");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(program, "aTextureCoord");
        checkLocation(glGetAttribLocation2, "aTextureCoord");
        int glGetUniformLocation = GLES20.glGetUniformLocation(program, "uMVPMatrix");
        checkLocation(glGetUniformLocation, "uMVPMatrix");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(program, CameraFilterEngine.TEXTURE_MATRIX_UNIFORM);
        checkLocation(glGetUniformLocation2, CameraFilterEngine.TEXTURE_MATRIX_UNIFORM);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, (Buffer) VERTEXT_BUF);
        checkGlError("glVertexAttribPointer aPosition");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        checkGlError("glEnableVertexAttribArray mPositionHandle");
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, (Buffer) this.mUserTextureCoord);
        checkGlError("glVertexAttribPointer mTextureHandle");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        checkGlError("glEnableVertexAttribArray mTextureHandle");
        GLES20.glUniformMatrix4fv(glGetUniformLocation, 1, false, fArr2, 0);
        GLES20.glUniformMatrix4fv(glGetUniformLocation2, 1, false, fArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureType, i3);
        onDrawTexture();
        GLES20.glDrawArrays(5, 0, 4);
        checkGlError("glDrawArrays");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureType, 0);
    }

    public int getFilterType() {
        return this.mFilterType;
    }

    public int getProgram() {
        return this.mProgram;
    }

    public void init() {
        if (this.mIsInitialized) {
            return;
        }
        ProgramTools.ProgramInfo createProgram = ProgramTools.createProgram(this.mVertexShader, this.mFragmentShader);
        if (createProgram == null) {
            new RuntimeException("failed creating program " + getClass().getSimpleName());
            return;
        }
        this.mProgram = createProgram.programId;
        this.mIsInitialized = true;
        onInitialized();
    }

    public void initForce() {
        this.mIsInitialized = false;
        init();
    }

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    public void onOutputSizeChanged(int i3, int i16) {
        this.mOutputWidth = i3;
        this.mOutputHeight = i16;
    }

    public void setUserTextureCoords(float[] fArr) {
        this.mUserTextureCoord.position(0);
        this.mUserTextureCoord.put(fArr);
        this.mUserTextureCoord.position(0);
    }

    public GPUBaseFilter(String str, String str2) {
        this.mTextureType = GLSLRender.GL_TEXTURE_2D;
        this.mFilterType = 101;
        this.mUserTextureCoord = GlUtil.createFloatBuffer(TEXUTURE_COORDS);
        this.mVertexShader = str;
        this.mFragmentShader = str2;
        this.mTextureType = GLSLRender.GL_TEXTURE_2D;
        this.mFilterType = 101;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDrawTexture() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onInitialized() {
    }
}
