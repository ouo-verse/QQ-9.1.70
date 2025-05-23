package com.tencent.biz.videostory.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import com.tencent.filter.GLSLRender;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f97183a;

    /* renamed from: b, reason: collision with root package name */
    private FloatBuffer f97184b;

    /* renamed from: e, reason: collision with root package name */
    private int f97187e;

    /* renamed from: g, reason: collision with root package name */
    private int f97189g;

    /* renamed from: h, reason: collision with root package name */
    private int f97190h;

    /* renamed from: i, reason: collision with root package name */
    private int f97191i;

    /* renamed from: j, reason: collision with root package name */
    private int f97192j;

    /* renamed from: c, reason: collision with root package name */
    private float[] f97185c = new float[16];

    /* renamed from: d, reason: collision with root package name */
    private float[] f97186d = new float[16];

    /* renamed from: f, reason: collision with root package name */
    private int f97188f = -12345;

    /* renamed from: k, reason: collision with root package name */
    private int[] f97193k = new int[1];

    public b() {
        float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.f97183a = fArr;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f97184b = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        Matrix.setIdentityM(this.f97186d, 0);
    }

    private int b(String str, String str2) {
        int f16;
        int f17 = f(35633, str);
        if (f17 == 0 || (f16 = f(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        a("glCreateProgram");
        if (glCreateProgram == 0) {
            Log.e("OESTextureRender", "Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, f17);
        a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, f16);
        a("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            Log.e("OESTextureRender", "Could not link program: ");
            Log.e("OESTextureRender", GLES20.glGetProgramInfoLog(glCreateProgram));
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        return glCreateProgram;
    }

    private int f(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        a("glCreateShader type=" + i3);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("OESTextureRender", "Could not compile shader " + i3 + ":");
            StringBuilder sb5 = new StringBuilder();
            sb5.append(" ");
            sb5.append(GLES20.glGetShaderInfoLog(glCreateShader));
            Log.e("OESTextureRender", sb5.toString());
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        return glCreateShader;
    }

    public void a(String str) {
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                Log.e("OESTextureRender", str + ": glError " + glGetError);
            } else {
                return;
            }
        }
    }

    public void c(SurfaceTexture surfaceTexture, int i3) {
        a("onDrawFrame start");
        surfaceTexture.getTransformMatrix(this.f97186d);
        GLES20.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        GLES20.glBindFramebuffer(36160, this.f97193k[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i3, 0);
        GLES20.glUseProgram(this.f97187e);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f97188f);
        this.f97184b.position(0);
        GLES20.glVertexAttribPointer(this.f97191i, 3, 5126, false, 20, (Buffer) this.f97184b);
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.f97191i);
        a("glEnableVertexAttribArray maPositionHandle");
        this.f97184b.position(3);
        GLES20.glVertexAttribPointer(this.f97192j, 2, 5126, false, 20, (Buffer) this.f97184b);
        a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.f97192j);
        a("glEnableVertexAttribArray maTextureHandle");
        Matrix.setIdentityM(this.f97185c, 0);
        GLES20.glUniformMatrix4fv(this.f97189g, 1, false, this.f97185c, 0);
        GLES20.glUniformMatrix4fv(this.f97190h, 1, false, this.f97186d, 0);
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glFinish();
        GLES20.glBindFramebuffer(36160, 0);
    }

    public void d(boolean z16) {
        this.f97184b.clear();
        if (!z16) {
            this.f97184b.put(this.f97183a).position(0);
            return;
        }
        FloatBuffer floatBuffer = this.f97184b;
        float[] fArr = this.f97183a;
        floatBuffer.put(new float[]{-1.0f, -1.0f, 0.0f, 0.0f, 1.0f - fArr[4], 1.0f, -1.0f, 0.0f, 1.0f, 1.0f - fArr[9], -1.0f, 1.0f, 0.0f, 0.0f, 1.0f - fArr[14], 1.0f, 1.0f, 0.0f, 1.0f, 1.0f - fArr[19]}).position(0);
    }

    public int e() {
        return this.f97188f;
    }

    public void g() {
        int b16 = b("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        this.f97187e = b16;
        if (b16 != 0) {
            this.f97191i = GLES20.glGetAttribLocation(b16, "aPosition");
            a("glGetAttribLocation aPosition");
            if (this.f97191i != -1) {
                this.f97192j = GLES20.glGetAttribLocation(this.f97187e, "aTextureCoord");
                a("glGetAttribLocation aTextureCoord");
                if (this.f97192j != -1) {
                    this.f97189g = GLES20.glGetUniformLocation(this.f97187e, "uMVPMatrix");
                    a("glGetUniformLocation uMVPMatrix");
                    if (this.f97189g != -1) {
                        this.f97190h = GLES20.glGetUniformLocation(this.f97187e, "uSTMatrix");
                        a("glGetUniformLocation uSTMatrix");
                        if (this.f97190h != -1) {
                            int[] iArr = new int[1];
                            GLES20.glGenTextures(1, iArr, 0);
                            int i3 = iArr[0];
                            this.f97188f = i3;
                            GLES20.glBindTexture(36197, i3);
                            a("glBindTexture mTextureID");
                            GLES20.glTexParameterf(36197, 10241, 9729.0f);
                            GLES20.glTexParameterf(36197, 10240, 9729.0f);
                            GLES20.glTexParameteri(36197, 10242, 33071);
                            GLES20.glTexParameteri(36197, 10243, 33071);
                            a("glTexParameter");
                            GLES20.glGenFramebuffers(1, this.f97193k, 0);
                            a("glGenFramebuffers");
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
}
