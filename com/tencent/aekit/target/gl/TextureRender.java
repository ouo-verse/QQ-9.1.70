package com.tencent.aekit.target.gl;

import android.opengl.GLES20;
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
public class TextureRender {
    static IPatchRedirector $redirector_ = null;
    private static final int FLOAT_SIZE_BYTES = 4;
    private static final String FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
    private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 20;
    private static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 3;
    private static final String VERTEX_SHADER = "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = aPosition;\n  vTextureCoord = aTextureCoord.xy;\n}\n";
    private final String TAG;
    private float[] mMVPMatrix;
    private int mProgram;
    private FloatBuffer mTriangleVertices;
    private float[] mTriangleVerticesData;
    private int maPositionHandle;
    private int maTextureHandle;

    public TextureRender() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.TAG = "TextureRender-" + Integer.toHexString(hashCode());
        float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.mTriangleVerticesData = fArr;
        this.mMVPMatrix = new float[16];
        this.mProgram = 0;
        this.maPositionHandle = 0;
        this.maTextureHandle = 0;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTriangleVertices = asFloatBuffer;
        asFloatBuffer.put(this.mTriangleVerticesData).position(0);
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

    public void drawFrame(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        System.currentTimeMillis();
        GLES20.glUseProgram(this.mProgram);
        GlUtil.checkGlError("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
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
        GLES20.glDrawArrays(5, 0, 4);
        GlUtil.checkGlError("glDrawArrays");
    }

    public void prepare() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
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
                    return;
                } else {
                    throw new RuntimeException("Could not get attrib location for aTextureCoord");
                }
            }
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
        throw new RuntimeException("failed creating program");
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        int i3 = this.mProgram;
        if (i3 != 0) {
            GLES20.glDeleteProgram(i3);
            this.mProgram = 0;
        }
    }
}
