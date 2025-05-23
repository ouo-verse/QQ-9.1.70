package com.tencent.mobileqq.qqvideoedit.thirdparty.youtu.GLThread;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.filter.GLSLRender;
import com.tencent.qqmini.miniapp.widget.camera.CameraFilterEngine;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {

    /* renamed from: s, reason: collision with root package name */
    private static final float[] f276184s = {1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 0.0f, 1.0f, -1.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f};

    /* renamed from: h, reason: collision with root package name */
    private FloatBuffer f276192h;

    /* renamed from: a, reason: collision with root package name */
    protected int f276185a = -1;

    /* renamed from: b, reason: collision with root package name */
    protected int f276186b = -1;

    /* renamed from: c, reason: collision with root package name */
    protected int f276187c = -1;

    /* renamed from: d, reason: collision with root package name */
    protected int f276188d = 0;

    /* renamed from: e, reason: collision with root package name */
    protected int f276189e = 0;

    /* renamed from: f, reason: collision with root package name */
    protected int[] f276190f = {-1};

    /* renamed from: g, reason: collision with root package name */
    protected float[] f276191g = new float[16];

    /* renamed from: i, reason: collision with root package name */
    private int f276193i = -1;

    /* renamed from: j, reason: collision with root package name */
    private int f276194j = -1;

    /* renamed from: k, reason: collision with root package name */
    private int f276195k = -1;

    /* renamed from: l, reason: collision with root package name */
    private int f276196l = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f276197m = -1;

    /* renamed from: n, reason: collision with root package name */
    private int f276198n = -1;

    /* renamed from: o, reason: collision with root package name */
    private int f276199o = -1;

    /* renamed from: p, reason: collision with root package name */
    protected final String f276200p = "attribute vec4 aPosition;\nuniform mat4 uTextureMatrix;\nuniform mat4 uScreenMatrix;\nattribute vec4 aTextureCoordinate;\nvarying vec2 vTextureCoord;\nvoid main()\n{\n  vTextureCoord = (uTextureMatrix * aTextureCoordinate).xy;\n  gl_Position = aPosition * uScreenMatrix;\n}";

    /* renamed from: q, reason: collision with root package name */
    protected final String f276201q = "precision mediump float;\nuniform sampler2D uTextureSampler;\nvarying vec2 vTextureCoord;\nvoid main()\n{\n  vec4 vCameraColor = texture2D(uTextureSampler, vTextureCoord);\n  gl_FragColor = vCameraColor;\n}\n";

    /* renamed from: r, reason: collision with root package name */
    protected final String f276202r = "precision mediump float;\nuniform sampler2D uTextureSampler;\nvarying vec2 vTextureCoord;\nuniform highp float height;\nuniform highp float width;\nvoid main()\n{\nvec4 sourceColor = texture2D(uTextureSampler, vTextureCoord);\nvec3 resultColor = sourceColor.rgb;\n\nmediump float sum = texture2D(uTextureSampler,vec2(vTextureCoord.x - 0.6666666 / width, vTextureCoord.y - 0.6666666 / height)).g;\nsum += texture2D(uTextureSampler,vec2(vTextureCoord.x - 0.6666666 / width, vTextureCoord.y + 0.6666666 / height)).g;\nsum += texture2D(uTextureSampler,vec2(vTextureCoord.x + 0.6666666 / width, vTextureCoord.y - 0.6666666 / height)).g;\nsum += texture2D(uTextureSampler,vec2(vTextureCoord.x + 0.6666666 / width, vTextureCoord.y + 0.6666666 / height)).g;\nsum = sum * 0.25;\n\nfloat hPass = resultColor.g - sum + 0.5;\nfloat flag = step(0.5, hPass);\n\nhighp vec3 tmpColor = vec3(2.0 * hPass + resultColor - 1.0);\nvec3 sharpColor = mix(max(vec3(0.0), tmpColor), min(vec3(1.0), tmpColor), flag);\nresultColor = mix(resultColor, sharpColor, 0.7);\ngl_FragColor = vec4(resultColor, sourceColor.a);}\n";

    protected FloatBuffer a(float[] fArr) {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr, 0, fArr.length).position(0);
        return asFloatBuffer;
    }

    public void b() {
        GLES20.glDeleteShader(this.f276185a);
        GLES20.glDeleteShader(this.f276186b);
        GLES20.glDeleteProgram(this.f276187c);
        GLES20.glDeleteBuffers(1, this.f276190f, 0);
    }

    public void c(int i3, int i16, int i17, int i18, boolean z16) {
        this.f276188d = i17;
        this.f276189e = i18;
        GLES20.glUseProgram(this.f276187c);
        GLES20.glClear(16640);
        GLES20.glViewport(0, 0, this.f276188d, this.f276189e);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glBindFramebuffer(36160, this.f276190f[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i16, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i3);
        GLES20.glUniform1i(this.f276197m, 0);
        GLES20.glUniformMatrix4fv(this.f276195k, 1, false, this.f276191g, 0);
        GLES20.glUniformMatrix4fv(this.f276196l, 1, false, this.f276191g, 0);
        GLES20.glUniform1f(this.f276198n, i17);
        GLES20.glUniform1f(this.f276199o, i18);
        this.f276192h.position(0);
        GLES20.glEnableVertexAttribArray(this.f276193i);
        GLES20.glVertexAttribPointer(this.f276193i, 2, 5126, false, 16, (Buffer) this.f276192h);
        this.f276192h.position(2);
        GLES20.glEnableVertexAttribArray(this.f276194j);
        GLES20.glVertexAttribPointer(this.f276194j, 2, 5126, false, 16, (Buffer) this.f276192h);
        GLES20.glDrawArrays(4, 0, 6);
        GLES20.glBindFramebuffer(36160, 0);
        if (z16) {
            GLES20.glFinish();
        }
    }

    public void d() {
        e(false);
    }

    public void e(boolean z16) {
        String str;
        this.f276185a = g(35633, "attribute vec4 aPosition;\nuniform mat4 uTextureMatrix;\nuniform mat4 uScreenMatrix;\nattribute vec4 aTextureCoordinate;\nvarying vec2 vTextureCoord;\nvoid main()\n{\n  vTextureCoord = (uTextureMatrix * aTextureCoordinate).xy;\n  gl_Position = aPosition * uScreenMatrix;\n}");
        if (z16) {
            str = "precision mediump float;\nuniform sampler2D uTextureSampler;\nvarying vec2 vTextureCoord;\nuniform highp float height;\nuniform highp float width;\nvoid main()\n{\nvec4 sourceColor = texture2D(uTextureSampler, vTextureCoord);\nvec3 resultColor = sourceColor.rgb;\n\nmediump float sum = texture2D(uTextureSampler,vec2(vTextureCoord.x - 0.6666666 / width, vTextureCoord.y - 0.6666666 / height)).g;\nsum += texture2D(uTextureSampler,vec2(vTextureCoord.x - 0.6666666 / width, vTextureCoord.y + 0.6666666 / height)).g;\nsum += texture2D(uTextureSampler,vec2(vTextureCoord.x + 0.6666666 / width, vTextureCoord.y - 0.6666666 / height)).g;\nsum += texture2D(uTextureSampler,vec2(vTextureCoord.x + 0.6666666 / width, vTextureCoord.y + 0.6666666 / height)).g;\nsum = sum * 0.25;\n\nfloat hPass = resultColor.g - sum + 0.5;\nfloat flag = step(0.5, hPass);\n\nhighp vec3 tmpColor = vec3(2.0 * hPass + resultColor - 1.0);\nvec3 sharpColor = mix(max(vec3(0.0), tmpColor), min(vec3(1.0), tmpColor), flag);\nresultColor = mix(resultColor, sharpColor, 0.7);\ngl_FragColor = vec4(resultColor, sourceColor.a);}\n";
        } else {
            str = "precision mediump float;\nuniform sampler2D uTextureSampler;\nvarying vec2 vTextureCoord;\nvoid main()\n{\n  vec4 vCameraColor = texture2D(uTextureSampler, vTextureCoord);\n  gl_FragColor = vCameraColor;\n}\n";
        }
        int g16 = g(35632, str);
        this.f276186b = g16;
        this.f276187c = f(this.f276185a, g16);
        GLES20.glGenFramebuffers(1, this.f276190f, 0);
        GLES20.glBindFramebuffer(36160, 0);
        Matrix.setIdentityM(this.f276191g, 0);
        this.f276193i = GLES20.glGetAttribLocation(this.f276187c, "aPosition");
        this.f276194j = GLES20.glGetAttribLocation(this.f276187c, CameraFilterEngine.TEXTURE_COORD_ATTRIBUTE);
        this.f276195k = GLES20.glGetUniformLocation(this.f276187c, CameraFilterEngine.TEXTURE_MATRIX_UNIFORM);
        this.f276196l = GLES20.glGetUniformLocation(this.f276187c, "uScreenMatrix");
        this.f276197m = GLES20.glGetUniformLocation(this.f276187c, CameraFilterEngine.TEXTURE_SAMPLER_UNIFORM);
        this.f276198n = GLES20.glGetUniformLocation(this.f276187c, "width");
        this.f276199o = GLES20.glGetUniformLocation(this.f276187c, "height");
        this.f276192h = a(f276184s);
    }

    protected int f(int i3, int i16) {
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, i3);
            GLES20.glAttachShader(glCreateProgram, i16);
            GLES20.glLinkProgram(glCreateProgram);
            return glCreateProgram;
        }
        throw new RuntimeException("Create Program Failed!" + GLES20.glGetError());
    }

    protected int g(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            return glCreateShader;
        }
        throw new RuntimeException("Create Shader Failed!" + GLES20.glGetError());
    }
}
