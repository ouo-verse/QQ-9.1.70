package com.tencent.mobileqq.ar.ARRenderModel;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.qfsmonet.api.data.MonetPacketDescriptor;
import com.tencent.qphone.base.util.QLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes11.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private int f197293a;

    /* renamed from: b, reason: collision with root package name */
    public final int f197294b;

    /* renamed from: c, reason: collision with root package name */
    private int f197295c;

    /* renamed from: d, reason: collision with root package name */
    private int f197296d;

    /* renamed from: e, reason: collision with root package name */
    private int f197297e;

    /* renamed from: f, reason: collision with root package name */
    private int f197298f;

    /* renamed from: g, reason: collision with root package name */
    private int f197299g;

    /* renamed from: h, reason: collision with root package name */
    private int f197300h;

    /* renamed from: i, reason: collision with root package name */
    private float[] f197301i;

    /* renamed from: r, reason: collision with root package name */
    private ByteBuffer f197310r;

    /* renamed from: s, reason: collision with root package name */
    private ByteBuffer f197311s;

    /* renamed from: w, reason: collision with root package name */
    public static float[] f197289w = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: x, reason: collision with root package name */
    public static float[] f197290x = {-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f};

    /* renamed from: y, reason: collision with root package name */
    static float[] f197291y = {-1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: z, reason: collision with root package name */
    static float[] f197292z = {0.0f, -1.0f, 1.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static float[] A = {-1.0f, -1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f};
    static float[] B = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static float[] C = {-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f};
    private static float[] D = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: j, reason: collision with root package name */
    private int f197302j = -1;

    /* renamed from: k, reason: collision with root package name */
    private int f197303k = -1;

    /* renamed from: l, reason: collision with root package name */
    private int f197304l = -1;

    /* renamed from: m, reason: collision with root package name */
    private int f197305m = -1;

    /* renamed from: n, reason: collision with root package name */
    private int f197306n = -1;

    /* renamed from: o, reason: collision with root package name */
    private int f197307o = -1;

    /* renamed from: p, reason: collision with root package name */
    private int f197308p = -1;

    /* renamed from: q, reason: collision with root package name */
    private int f197309q = -1;

    /* renamed from: t, reason: collision with root package name */
    private int f197312t = -1;

    /* renamed from: u, reason: collision with root package name */
    private int f197313u = -1;

    /* renamed from: v, reason: collision with root package name */
    private boolean f197314v = false;

    public m(int i3) {
        if ((i3 < 0 || i3 > 4) && QLog.isColorLevel()) {
            QLog.i("GreetingYUVProgram", 1, "Index can only be 0 to 4");
        }
        this.f197294b = i3;
        j(i3);
    }

    private void c(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            QLog.i("GreetingYUVProgram", 1, str + ": glError 0x" + Integer.toHexString(glGetError));
        }
    }

    private int i(int i3, String str) {
        int glCreateShader = GLES20.glCreateShader(i3);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                GLES20.glDeleteShader(glCreateShader);
                return 0;
            }
            return glCreateShader;
        }
        return glCreateShader;
    }

    public void a() {
        if (this.f197293a <= 0) {
            this.f197293a = e("attribute vec4 vPosition;\nattribute vec2 a_texCoord;\nvarying vec2 tc;\nvoid main() {\ngl_Position = vPosition;\ntc = a_texCoord;\n}\n", "precision mediump float;\nuniform sampler2D tex_y;\nuniform sampler2D tex_u;\nuniform sampler2D tex_v;\nvarying vec2 tc;\nvoid main() {\nvec4 c = vec4((texture2D(tex_y, tc).r - 16./255.) * 1.164);\nvec4 U = vec4(texture2D(tex_u, tc).r - 128./255.);\nvec4 V = vec4(texture2D(tex_v, tc).r - 128./255.);\nc += V * vec4(1.596, -0.813, 0, 0);\nc += U * vec4(0, -0.392, 2.017, 0);\nc.a = 1.0;\ngl_FragColor = c;\n}\n");
        }
        this.f197302j = GLES20.glGetAttribLocation(this.f197293a, "vPosition");
        c("glGetAttribLocation vPosition");
        if (this.f197302j == -1 && QLog.isColorLevel()) {
            QLog.i("GreetingYUVProgram", 1, "Could not get attribute location for vPosition");
        }
        this.f197303k = GLES20.glGetAttribLocation(this.f197293a, "a_texCoord");
        c("glGetAttribLocation a_texCoord");
        if (this.f197303k == -1 && QLog.isColorLevel()) {
            QLog.i("GreetingYUVProgram", 1, "Could not get attribute location for a_texCoord");
        }
        this.f197304l = GLES20.glGetUniformLocation(this.f197293a, "tex_y");
        c("glGetUniformLocation tex_y");
        if (this.f197304l == -1 && QLog.isColorLevel()) {
            QLog.i("GreetingYUVProgram", 1, "Could not get uniform location for tex_y");
        }
        this.f197305m = GLES20.glGetUniformLocation(this.f197293a, "tex_u");
        c("glGetUniformLocation tex_u");
        if (this.f197305m == -1 && QLog.isColorLevel()) {
            QLog.i("GreetingYUVProgram", 1, "Could not get uniform location for tex_u");
        }
        this.f197306n = GLES20.glGetUniformLocation(this.f197293a, "tex_v");
        c("glGetUniformLocation tex_v");
        if (this.f197306n == -1 && QLog.isColorLevel()) {
            QLog.i("GreetingYUVProgram", 1, "Could not get uniform location for tex_v");
        }
        this.f197314v = true;
    }

    public void b(Buffer buffer, Buffer buffer2, Buffer buffer3, int i3, int i16) {
        boolean z16;
        if (i3 == this.f197312t && i16 == this.f197313u) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.f197312t = i3;
            this.f197313u = i16;
        }
        int i17 = this.f197307o;
        if (i17 < 0 || z16) {
            if (i17 >= 0) {
                GLES20.glDeleteTextures(1, new int[]{i17}, 0);
                c("glDeleteTextures");
            }
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            c("glGenTextures");
            this.f197307o = iArr[0];
        }
        QLog.d("AVGAmeRender", 1, "buildTextures : w=" + this.f197312t + " h=" + this.f197313u + " yData=" + buffer.capacity());
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f197307o);
        c("glBindTexture");
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, MonetPacketDescriptor.MonetDataFormat.R8, this.f197312t, this.f197313u, 0, MonetPacketDescriptor.MonetDataFormat.R8, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, buffer);
        c("glTexImage2D");
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9728.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        int i18 = this.f197308p;
        if (i18 < 0 || z16) {
            if (i18 >= 0) {
                GLES20.glDeleteTextures(1, new int[]{i18}, 0);
                c("glDeleteTextures");
            }
            int[] iArr2 = new int[1];
            GLES20.glGenTextures(1, iArr2, 0);
            c("glGenTextures");
            this.f197308p = iArr2[0];
        }
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f197308p);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, MonetPacketDescriptor.MonetDataFormat.R8, this.f197312t / 2, this.f197313u / 2, 0, MonetPacketDescriptor.MonetDataFormat.R8, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, buffer2);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9728.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
        int i19 = this.f197309q;
        if (i19 < 0 || z16) {
            if (i19 >= 0) {
                GLES20.glDeleteTextures(1, new int[]{i19}, 0);
                c("glDeleteTextures");
            }
            int[] iArr3 = new int[1];
            GLES20.glGenTextures(1, iArr3, 0);
            c("glGenTextures");
            this.f197309q = iArr3[0];
        }
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f197309q);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, MonetPacketDescriptor.MonetDataFormat.R8, this.f197312t / 2, this.f197313u / 2, 0, MonetPacketDescriptor.MonetDataFormat.R8, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, buffer3);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9728.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
        GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
    }

    public void d(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        this.f197310r = allocateDirect;
        allocateDirect.order(ByteOrder.nativeOrder());
        this.f197310r.asFloatBuffer().put(fArr);
        this.f197310r.position(0);
        if (this.f197311s == null) {
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(D.length * 4);
            this.f197311s = allocateDirect2;
            allocateDirect2.order(ByteOrder.nativeOrder());
            this.f197311s.asFloatBuffer().put(D);
            this.f197311s.position(0);
        }
    }

    public int e(String str, String str2) {
        int i3 = i(35633, str);
        int i16 = i(35632, str2);
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, i3);
            c("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, i16);
            c("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
            return glCreateProgram;
        }
        return glCreateProgram;
    }

    public void f() {
        int i3 = this.f197307o;
        if (i3 != -1) {
            GLES20.glDeleteTextures(1, new int[]{i3}, 0);
            c("glDeleteTextures");
            this.f197307o = -1;
        }
        int i16 = this.f197308p;
        if (i16 != -1) {
            GLES20.glDeleteTextures(1, new int[]{i16}, 0);
            c("glDeleteTextures");
            this.f197308p = -1;
        }
        int i17 = this.f197309q;
        if (i17 != -1) {
            GLES20.glDeleteTextures(1, new int[]{i17}, 0);
            c("glDeleteTextures");
            this.f197309q = -1;
        }
        int i18 = this.f197293a;
        if (i18 > 0) {
            this.f197314v = false;
            GLES20.glDeleteProgram(i18);
            c("glDeleteProgram");
            this.f197293a = 0;
        }
    }

    public void g() {
        GLES20.glUseProgram(this.f197293a);
        c("glUseProgram");
        GLES20.glVertexAttribPointer(this.f197302j, 2, 5126, false, 8, (Buffer) this.f197310r);
        c("glVertexAttribPointer mPositionHandle");
        GLES20.glEnableVertexAttribArray(this.f197302j);
        GLES20.glVertexAttribPointer(this.f197303k, 2, 5126, false, 8, (Buffer) this.f197311s);
        c("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.f197303k);
        GLES20.glActiveTexture(this.f197295c);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f197307o);
        GLES20.glUniform1i(this.f197304l, this.f197298f);
        GLES20.glActiveTexture(this.f197296d);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f197308p);
        GLES20.glUniform1i(this.f197305m, this.f197299g);
        GLES20.glActiveTexture(this.f197297e);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f197309q);
        GLES20.glUniform1i(this.f197306n, this.f197300h);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFinish();
        GLES20.glDisableVertexAttribArray(this.f197302j);
        GLES20.glDisableVertexAttribArray(this.f197303k);
        GLES20.glUseProgram(0);
    }

    public boolean h() {
        return this.f197314v;
    }

    public void j(int i3) {
        int i16 = this.f197294b;
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 != 4) {
                        this.f197301i = f197289w;
                        this.f197295c = 33984;
                        this.f197296d = 33985;
                        this.f197297e = 33986;
                        this.f197298f = 0;
                        this.f197299g = 1;
                        this.f197300h = 2;
                        return;
                    }
                    this.f197301i = B;
                    this.f197295c = 33993;
                    this.f197296d = 33994;
                    this.f197297e = 33995;
                    this.f197298f = 9;
                    this.f197299g = 10;
                    this.f197300h = 11;
                    return;
                }
                this.f197301i = A;
                this.f197295c = 33990;
                this.f197296d = 33991;
                this.f197297e = 33992;
                this.f197298f = 6;
                this.f197299g = 7;
                this.f197300h = 8;
                return;
            }
            this.f197301i = f197292z;
            this.f197295c = 33987;
            this.f197296d = 33988;
            this.f197297e = 33989;
            this.f197298f = 3;
            this.f197299g = 4;
            this.f197300h = 5;
            return;
        }
        this.f197301i = f197291y;
        this.f197295c = 33984;
        this.f197296d = 33985;
        this.f197297e = 33986;
        this.f197298f = 0;
        this.f197299g = 1;
        this.f197300h = 2;
    }
}
