package com.tencent.mobileqq.shortvideo.bighead;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qqmini.miniapp.widget.camera.CameraFilterEngine;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class BigHeadBuckler {
    public static final int FLOAT_SIZE_BYTES = 4;
    public static final String NO_FILTER_FRAGMENT_SHADER = "precision mediump float;\n\nvarying vec2 vTextureCoord;\nvarying vec2 vTextureMaskCoord;\nuniform sampler2D uTexture;\nuniform sampler2D uTextureMask;\n\nvoid main() {\n    vec4 color;\n    vec4 frame = texture2D(uTexture, vTextureCoord);\n    vec4 mask  = texture2D(uTextureMask, vTextureMaskCoord);\n    if(mask.r == 1.0){\n       color = vec4(frame.rgb,mask.a);\n    }else{\n       color = vec4(0,0,0,0);\n    }\n    gl_FragColor = color;\n}\n";
    public static final String NO_FILTER_VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nuniform mat4 uTextureMaskMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvarying vec2 vTextureMaskCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n    vTextureMaskCoord = (uTextureMaskMatrix * aTextureCoord).xy;\n}\n";
    private static final FloatBuffer TEXTURE_BUF;
    public static final float[] TEXUTURE_COORDS;
    private static final FloatBuffer VERTEXT_BUF;
    public static final float[] VERTEXT_COORDS;
    public static final float[] sGIdentity;
    private final String mFragmentShader;
    private boolean mIsInitialized;
    private int mProgram;
    public int mTextureType;
    private final String mVertexShader;

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        VERTEXT_COORDS = fArr;
        float[] fArr2 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        TEXUTURE_COORDS = fArr2;
        VERTEXT_BUF = GlUtil.createFloatBuffer(fArr);
        TEXTURE_BUF = GlUtil.createFloatBuffer(fArr2);
        float[] fArr3 = new float[16];
        sGIdentity = fArr3;
        Matrix.setIdentityM(fArr3, 0);
    }

    public BigHeadBuckler() {
        this(NO_FILTER_VERTEX_SHADER, NO_FILTER_FRAGMENT_SHADER);
    }

    public void destroy() {
        this.mIsInitialized = false;
        GLES20.glDeleteProgram(this.mProgram);
        this.mProgram = 0;
    }

    public void drawTexture(int i3, int i16, float[] fArr, float[] fArr2, float[] fArr3) {
        float[] fArr4;
        float[] fArr5;
        float[] fArr6;
        int i17 = this.mProgram;
        if (fArr == null) {
            fArr4 = sGIdentity;
        } else {
            fArr4 = fArr;
        }
        if (fArr2 == null) {
            fArr5 = sGIdentity;
        } else {
            fArr5 = fArr2;
        }
        if (fArr3 == null) {
            fArr6 = sGIdentity;
        } else {
            fArr6 = fArr3;
        }
        GLES20.glUseProgram(i17);
        int glGetAttribLocation = GLES20.glGetAttribLocation(i17, "aPosition");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(i17, "aTextureCoord");
        int glGetUniformLocation = GLES20.glGetUniformLocation(i17, "uMVPMatrix");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(i17, CameraFilterEngine.TEXTURE_MATRIX_UNIFORM);
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(i17, "uTextureMaskMatrix");
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, (Buffer) VERTEXT_BUF);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, (Buffer) TEXTURE_BUF);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        GLES20.glUniformMatrix4fv(glGetUniformLocation, 1, false, fArr6, 0);
        GLES20.glUniformMatrix4fv(glGetUniformLocation2, 1, false, fArr4, 0);
        GLES20.glUniformMatrix4fv(glGetUniformLocation3, 1, false, fArr5, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureType, i3);
        GLES20.glUniform1i(GLES20.glGetUniformLocation(i17, "uTexture"), 0);
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(i17, "uTextureMask");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(this.mTextureType, i16);
        GLES20.glUniform1i(glGetUniformLocation4, 1);
        GLES20.glDrawArrays(5, 0, 4);
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        throw new RuntimeException("error =" + glGetError);
    }

    public void init() {
        if (this.mIsInitialized) {
            return;
        }
        int createProgram = GlUtil.createProgram(this.mVertexShader, this.mFragmentShader);
        this.mProgram = createProgram;
        if (createProgram == 0) {
            new RuntimeException("failed creating program " + getClass().getSimpleName()).printStackTrace();
        }
        this.mIsInitialized = true;
    }

    public BigHeadBuckler(String str, String str2) {
        this.mVertexShader = str;
        this.mFragmentShader = str2;
        this.mTextureType = GLSLRender.GL_TEXTURE_2D;
    }
}
