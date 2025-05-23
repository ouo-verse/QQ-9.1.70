package com.tencent.aekit.target.gl;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class OESTextureRender {
    static IPatchRedirector $redirector_ = null;
    private static final int FLOAT_SIZE_BYTES = 4;
    private static final String FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
    private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 20;
    private static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 3;
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
    private final String TAG;
    private int[] fbo;
    private float[] mMVPMatrix;
    private int mProgram;
    private float[] mSTMatrix;
    private int mTextureUniformHandle;
    private FloatBuffer mTriangleVertices;
    private final float[] mTriangleVerticesData;
    private int maPositionHandle;
    private int maTextureHandle;
    private int muMVPMatrixHandle;
    private int muSTMatrixHandle;
    private int textureId;

    public OESTextureRender() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.TAG = "OESTextureRender-" + Integer.toHexString(hashCode());
        float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.mTriangleVerticesData = fArr;
        this.mMVPMatrix = new float[16];
        this.mSTMatrix = new float[16];
        this.mProgram = 0;
        this.textureId = -12345;
        this.muMVPMatrixHandle = 0;
        this.muSTMatrixHandle = 0;
        this.maPositionHandle = 0;
        this.maTextureHandle = 0;
        this.fbo = new int[1];
        this.mTextureUniformHandle = 0;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTriangleVertices = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        Matrix.setIdentityM(this.mSTMatrix, 0);
    }

    private int createProgram(String str, String str2) {
        int loadShader = loadShader(35633, str);
        int loadShader2 = loadShader(35632, str2);
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, loadShader);
        GLES20.glAttachShader(glCreateProgram, loadShader2);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            LogUtils.e(this.TAG, "Could not link program:");
            LogUtils.e(this.TAG, GLES20.glGetProgramInfoLog(glCreateProgram));
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        return glCreateProgram;
    }

    private void drawFrameInternal(SurfaceTexture surfaceTexture) {
        GlUtil.checkGlError("onDrawFrame start");
        surfaceTexture.getTransformMatrix(this.mSTMatrix);
        GLES20.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        GLES20.glUseProgram(this.mProgram);
        GlUtil.checkGlError("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.textureId);
        GLES20.glUniform1i(this.mTextureUniformHandle, 0);
        this.mTriangleVertices.position(0);
        GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, 20, (Buffer) this.mTriangleVertices);
        GlUtil.checkGlError("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.maPositionHandle);
        GlUtil.checkGlError("glEnableVertexAttribArray maPositionHandle");
        this.mTriangleVertices.position(3);
        GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, 20, (Buffer) this.mTriangleVertices);
        GlUtil.checkGlError("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.maTextureHandle);
        GlUtil.checkGlError("glEnableVertexAttribArray maTextureHandle");
        Matrix.setIdentityM(this.mMVPMatrix, 0);
        GLES20.glUniformMatrix4fv(this.muMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
        GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
        GLES20.glDrawArrays(5, 0, 4);
        GlUtil.checkGlError("glDrawArrays");
    }

    private int loadShader(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            LogUtils.e(this.TAG, "Could not compile shader(TYPE=" + i3 + "):");
            LogUtils.e(this.TAG, GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }

    public static void saveFrame(String str, int i3, int i16) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    public void drawFrame(SurfaceTexture surfaceTexture, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) surfaceTexture, i3);
            return;
        }
        GlUtil.checkEglError("onDrawFrame start");
        GLES20.glBindFramebuffer(36160, this.fbo[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
        drawFrameInternal(surfaceTexture);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public void flipY(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        this.mTriangleVertices.clear();
        if (!z16) {
            this.mTriangleVertices.put(this.mTriangleVerticesData).position(0);
            return;
        }
        FloatBuffer floatBuffer = this.mTriangleVertices;
        float[] fArr = this.mTriangleVerticesData;
        floatBuffer.put(new float[]{-1.0f, -1.0f, 0.0f, 0.0f, 1.0f - fArr[4], 1.0f, -1.0f, 0.0f, 1.0f, 1.0f - fArr[9], -1.0f, 1.0f, 0.0f, 0.0f, 1.0f - fArr[14], 1.0f, 1.0f, 0.0f, 1.0f, 1.0f - fArr[19]}).position(0);
    }

    public int getTextureId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.textureId;
    }

    public void prepare() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        int createProgram = createProgram(VERTEX_SHADER, FRAGMENT_SHADER);
        this.mProgram = createProgram;
        if (createProgram != 0) {
            this.maPositionHandle = GLES20.glGetAttribLocation(createProgram, "aPosition");
            GlUtil.checkGlError("glGetAttribLocation aPosition");
            if (this.maPositionHandle != -1) {
                this.maTextureHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
                GlUtil.checkGlError("glGetAttribLocation aTextureCoord");
                if (this.maTextureHandle != -1) {
                    this.muMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
                    GlUtil.checkGlError("glGetUniformLocation uMVPMatrix");
                    if (this.muMVPMatrixHandle != -1) {
                        this.muSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
                        GlUtil.checkGlError("glGetUniformLocation uSTMatrix");
                        if (this.muSTMatrixHandle != -1) {
                            this.mTextureUniformHandle = GLES20.glGetUniformLocation(this.mProgram, "sTexture");
                            int[] iArr = new int[1];
                            GLES20.glGenTextures(1, iArr, 0);
                            int i3 = iArr[0];
                            this.textureId = i3;
                            GLES20.glBindTexture(36197, i3);
                            GlUtil.checkGlError("glBindTexture mTextureID");
                            GLES20.glTexParameteri(36197, 10241, 9729);
                            GLES20.glTexParameteri(36197, 10240, 9729);
                            GLES20.glTexParameteri(36197, 10242, 33071);
                            GLES20.glTexParameteri(36197, 10243, 33071);
                            GlUtil.checkGlError("glTexParameter");
                            GLES20.glGenFramebuffers(1, this.fbo, 0);
                            GlUtil.checkGlError("glGenFramebuffers");
                            return;
                        }
                        throw new RuntimeException("Could not get attrib location for uSTMatrix");
                    }
                    throw new RuntimeException("Could not get attrib location for uMVPMatrix");
                }
                throw new RuntimeException("Could not get attrib location for aTextureCoord");
            }
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
        throw new RuntimeException("failed creating program");
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            GlUtil.deleteTexture(this.textureId);
            GLES20.glDeleteFramebuffers(1, this.fbo, 0);
        }
    }

    public void drawFrame(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) surfaceTexture);
            return;
        }
        GlUtil.checkGlError("onDrawFrame start");
        System.currentTimeMillis();
        drawFrameInternal(surfaceTexture);
    }
}
