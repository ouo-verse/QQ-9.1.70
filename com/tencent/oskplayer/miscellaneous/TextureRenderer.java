package com.tencent.oskplayer.miscellaneous;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.oskplayer.support.log.ILogger;
import com.tencent.oskplayer.support.log.Logger;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
@TargetApi(17)
/* loaded from: classes22.dex */
public class TextureRenderer {
    private static final int FLOAT_SIZE_BYTES = 4;
    private static final String FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    public static final String TAG = "TextureRenderer";
    private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
    private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 20;
    private static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 3;
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
    private int mProgram;
    private FloatBuffer mTriangleVertices;
    private final float[] mTriangleVerticesData;
    private int maPositionHandle;
    private int maTextureHandle;
    private int muMVPMatrixHandle;
    private int muSTMatrixHandle;
    private float[] mMVPMatrix = new float[16];
    private float[] mSTMatrix = new float[16];
    private int mTextureID = -12345;

    public TextureRenderer() {
        float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.mTriangleVerticesData = fArr;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTriangleVertices = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        Matrix.setIdentityM(this.mSTMatrix, 0);
    }

    private boolean checkGlError(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Logger.g().e(TAG, "[checkGlError] " + str + ", " + glGetError);
            return true;
        }
        return false;
    }

    public static boolean checkLocationError(int i3, String str) {
        if (i3 < 0) {
            Logger.g().e(TAG, "[checkLocationError] Unable to locate '" + str + "' in program");
            return true;
        }
        return false;
    }

    private int createProgram(String str, String str2) {
        int loadShader = loadShader(35633, str);
        if (loadShader == 0) {
            Logger.g().e(TAG, "[createProgram] load vertex failed");
            return 10012;
        }
        int loadShader2 = loadShader(35632, str2);
        if (loadShader2 == 0) {
            Logger.g().e(TAG, "[createProgram] load fragment failed");
            return 10013;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        this.mProgram = glCreateProgram;
        if (glCreateProgram == 0) {
            Logger.g().e(TAG, "[createProgram] create program failed");
            return 10011;
        }
        GLES20.glAttachShader(glCreateProgram, loadShader);
        if (checkGlError("glAttachShader vertexShader")) {
            this.mProgram = 0;
            return 10014;
        }
        GLES20.glAttachShader(this.mProgram, loadShader2);
        if (checkGlError("glAttachShader pixelShader")) {
            this.mProgram = 0;
            return 10015;
        }
        GLES20.glLinkProgram(this.mProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(this.mProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return 0;
        }
        ILogger g16 = Logger.g();
        String str3 = TAG;
        g16.e(str3, "[createProgram] Could not link program: ");
        Logger.g().e(str3, "[createProgram] " + GLES20.glGetProgramInfoLog(this.mProgram));
        GLES20.glDeleteProgram(this.mProgram);
        this.mProgram = 0;
        return 10016;
    }

    private int loadShader(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        if (checkGlError("glCreateShader type=" + i3)) {
            Logger.g().e(TAG, "[loadShader] glCreateShader failed, shader=" + glCreateShader);
            return 0;
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            ILogger g16 = Logger.g();
            String str2 = TAG;
            g16.e(str2, "[loadShader] Could not compile shader " + i3 + ":");
            Logger.g().e(str2, "[loadShader] " + GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }

    public int createTexture() {
        int createProgram = createProgram(VERTEX_SHADER, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        if (createProgram != 0) {
            return createProgram;
        }
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.mProgram, "aPosition");
        this.maPositionHandle = glGetAttribLocation;
        if (checkLocationError(glGetAttribLocation, "aPosition")) {
            Logger.g().e(TAG, "[createTexture] glGetAttribLocation aPosition failed");
            return 10017;
        }
        this.maTextureHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
        if (checkLocationError(this.maPositionHandle, "aTextureCoord")) {
            Logger.g().e(TAG, "[createTexture] glGetAttribLocation aTextureCoord failed");
            return 10017;
        }
        this.muMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
        if (checkLocationError(this.maPositionHandle, "uMVPMatrix")) {
            Logger.g().e(TAG, "[createTexture] glGetAttribLocation uMVPMatrix failed");
            return 10018;
        }
        this.muSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
        if (checkLocationError(this.maPositionHandle, "uSTMatrix")) {
            Logger.g().e(TAG, "[createTexture] glGetAttribLocation uSTMatrix failed");
            return 10018;
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i3 = iArr[0];
        this.mTextureID = i3;
        GLES20.glBindTexture(36197, i3);
        if (checkGlError("glBindTexture mTextureID")) {
            Logger.g().e(TAG, "[createTexture] glBindTexture failed");
            return 10019;
        }
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        if (!checkGlError("glTexParameter")) {
            return 0;
        }
        return 10020;
    }

    public void drawFrame(SurfaceTexture surfaceTexture, boolean z16) {
        checkGlError("onDrawFrame start");
        surfaceTexture.getTransformMatrix(this.mSTMatrix);
        if (z16) {
            float[] fArr = this.mSTMatrix;
            fArr[5] = -fArr[5];
            fArr[13] = 1.0f - fArr[13];
        }
        GLES20.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.mProgram);
        checkGlError("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.mTextureID);
        this.mTriangleVertices.position(0);
        GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, 20, (Buffer) this.mTriangleVertices);
        checkGlError("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.maPositionHandle);
        checkGlError("glEnableVertexAttribArray maPositionHandle");
        this.mTriangleVertices.position(3);
        GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, 20, (Buffer) this.mTriangleVertices);
        checkGlError("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.maTextureHandle);
        checkGlError("glEnableVertexAttribArray maTextureHandle");
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        GLES20.glUniformMatrix4fv(this.muMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
        GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
        GLES20.glDrawArrays(5, 0, 4);
        checkGlError("glDrawArrays");
        GLES20.glBindTexture(36197, 0);
    }

    public int getTextureId() {
        return this.mTextureID;
    }
}
