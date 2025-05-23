package com.tencent.luggage.wxa.m1;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.qfsmonet.api.data.MonetPacketDescriptor;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements GLSurfaceView.Renderer {
    public static float[] C = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static float[] D = {-1.0f, -0.5f, 1.0f, -0.5f, -1.0f, 0.5f, 1.0f, 0.5f};
    public static final float[] E = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public int A;
    public ByteBuffer B;

    /* renamed from: h, reason: collision with root package name */
    public ByteBuffer f134052h;

    /* renamed from: i, reason: collision with root package name */
    public ByteBuffer f134053i;

    /* renamed from: j, reason: collision with root package name */
    public int f134054j;

    /* renamed from: k, reason: collision with root package name */
    public int f134055k;

    /* renamed from: l, reason: collision with root package name */
    public int f134056l;

    /* renamed from: m, reason: collision with root package name */
    public int f134057m;

    /* renamed from: n, reason: collision with root package name */
    public int f134058n;

    /* renamed from: o, reason: collision with root package name */
    public int f134059o;

    /* renamed from: p, reason: collision with root package name */
    public int f134060p;

    /* renamed from: q, reason: collision with root package name */
    public int f134061q;

    /* renamed from: r, reason: collision with root package name */
    public FloatBuffer f134062r;

    /* renamed from: s, reason: collision with root package name */
    public FloatBuffer f134063s;

    /* renamed from: w, reason: collision with root package name */
    public float[] f134067w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f134068x;

    /* renamed from: y, reason: collision with root package name */
    public int f134069y;

    /* renamed from: z, reason: collision with root package name */
    public int f134070z;

    /* renamed from: a, reason: collision with root package name */
    public int f134045a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f134046b = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f134047c = false;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f134048d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f134049e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f134050f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f134051g = 0;

    /* renamed from: t, reason: collision with root package name */
    public float[] f134064t = new float[16];

    /* renamed from: u, reason: collision with root package name */
    public boolean f134065u = false;

    /* renamed from: v, reason: collision with root package name */
    public float[] f134066v = C;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        ByteBuffer a();

        void b();
    }

    public c(int i3, int i16, int i17, int i18) {
        float[] fArr = E;
        this.f134067w = Arrays.copyOf(fArr, fArr.length);
        this.f134068x = false;
        this.f134069y = 0;
        this.f134070z = 0;
        this.A = 0;
        this.B = null;
        this.f134070z = b.b();
        int a16 = b.a();
        this.A = a16;
        GLES20.glBindFramebuffer(36160, a16);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f134070z);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, i17, i18, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, this.f134070z, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        GLES20.glViewport(0, 0, i17, i18);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001c A[Catch: Exception -> 0x00bb, TryCatch #0 {Exception -> 0x00bb, blocks: (B:3:0x0005, B:5:0x0009, B:7:0x000d, B:9:0x0011, B:15:0x001c, B:16:0x004d, B:18:0x0051, B:20:0x005a, B:22:0x006a, B:24:0x008f, B:25:0x0099, B:27:0x009d, B:29:0x00a1, B:35:0x0055), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006a A[Catch: Exception -> 0x00bb, TryCatch #0 {Exception -> 0x00bb, blocks: (B:3:0x0005, B:5:0x0009, B:7:0x000d, B:9:0x0011, B:15:0x001c, B:16:0x004d, B:18:0x0051, B:20:0x005a, B:22:0x006a, B:24:0x008f, B:25:0x0099, B:27:0x009d, B:29:0x00a1, B:35:0x0055), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(byte[] bArr, int i3, int i16, int i17, int i18) {
        boolean z16;
        byte[] bArr2;
        ByteBuffer byteBuffer;
        try {
            if (this.f134050f == i16 && this.f134049e == i3 && this.f134051g == i17 && this.f134069y == i18) {
                z16 = false;
                if (z16) {
                    w.a("MicroMsg.YUVDateRenderToRGBBufferRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", bArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(this.f134068x), Boolean.valueOf(z16), this);
                }
                bArr2 = this.f134048d;
                if (bArr2 != null || bArr2.length != bArr.length) {
                    this.f134048d = new byte[bArr.length];
                }
                System.arraycopy(bArr, 0, this.f134048d, 0, bArr.length);
                this.f134049e = i3;
                this.f134050f = i16;
                this.f134051g = i17;
                this.f134069y = i18;
                if (z16) {
                    int i19 = i16 * i3;
                    this.f134052h = ByteBuffer.allocateDirect(i19);
                    this.f134053i = ByteBuffer.allocateDirect(i19 / 2);
                    this.f134052h.order(ByteOrder.nativeOrder());
                    this.f134053i.order(ByteOrder.nativeOrder());
                    float[] fArr = this.f134066v;
                    if (fArr != null) {
                        this.f134062r.put(fArr);
                        this.f134062r.position(0);
                    }
                }
                byteBuffer = this.f134052h;
                if (byteBuffer != null || this.f134053i == null) {
                }
                int i26 = i3 * i16;
                byteBuffer.put(this.f134048d, 0, i26);
                this.f134052h.position(0);
                this.f134053i.put(this.f134048d, i26, i26 / 2);
                this.f134053i.position(0);
                return;
            }
            z16 = true;
            if (z16) {
            }
            bArr2 = this.f134048d;
            if (bArr2 != null) {
            }
            this.f134048d = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.f134048d, 0, bArr.length);
            this.f134049e = i3;
            this.f134050f = i16;
            this.f134051g = i17;
            this.f134069y = i18;
            if (z16) {
            }
            byteBuffer = this.f134052h;
            if (byteBuffer != null) {
            }
        } catch (Exception e16) {
            w.b("MicroMsg.YUVDateRenderToRGBBufferRenderer", "setDrawFrame error: %s", e16.getMessage());
        }
    }

    public void b() {
        int i3 = this.f134070z;
        if (i3 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i3}, 0);
        }
        int i16 = this.A;
        if (i16 != 0) {
            GLES20.glDeleteFramebuffers(1, new int[]{i16}, 0);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (this.B == null) {
            return;
        }
        long a16 = w0.a();
        this.f134047c = true;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        if (this.f134065u) {
            w.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "clearFrameRequest");
            this.f134065u = false;
            this.f134047c = false;
            this.f134048d = null;
            this.f134049e = -1;
            this.f134050f = -1;
            return;
        }
        a();
        this.f134047c = false;
        w.a("MicroMsg.YUVDateRenderToRGBBufferRenderer", "time cost : %d", Long.valueOf(w0.e(a16)));
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
        w.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", Integer.valueOf(i3), Integer.valueOf(i16), this);
        if (i3 != this.f134045a || i16 != this.f134046b) {
            w.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceChanged change viewpoint");
            GLES20.glViewport(0, 0, i3, i16);
            this.f134045a = i3;
            this.f134046b = i16;
            float f16 = (i3 / i16) / 2.0f;
            float f17 = -f16;
            D = new float[]{-1.0f, f17, 1.0f, f17, -1.0f, f16, 1.0f, f16};
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        w.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated this %s", this);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glDisable(2929);
        int a16 = b.a("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
        this.f134056l = a16;
        if (a16 == 0) {
            w.b("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated, load program failed!");
        }
        this.f134058n = GLES20.glGetAttribLocation(this.f134056l, "a_position");
        this.f134057m = GLES20.glGetAttribLocation(this.f134056l, "a_texCoord");
        this.f134059o = GLES20.glGetUniformLocation(this.f134056l, "y_texture");
        this.f134060p = GLES20.glGetUniformLocation(this.f134056l, "uv_texture");
        this.f134061q = GLES20.glGetUniformLocation(this.f134056l, "uMatrix");
        this.f134054j = b.b();
        this.f134055k = b.b();
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(this.f134066v.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f134062r = asFloatBuffer;
        asFloatBuffer.put(this.f134066v);
        this.f134062r.position(0);
        float[] fArr = E;
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f134063s = asFloatBuffer2;
        asFloatBuffer2.put(fArr);
        this.f134063s.position(0);
        w.d("MicroMsg.YUVDateRenderToRGBBufferRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", Integer.valueOf(this.f134054j), Integer.valueOf(this.f134055k), this);
    }

    public final void a() {
        if (this.f134056l == 0 || this.f134054j == -1 || this.f134055k == -1 || this.f134049e <= 0 || this.f134050f <= 0 || this.f134048d == null) {
            return;
        }
        GLES20.glBindFramebuffer(36160, this.A);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f134070z);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, this.f134045a, this.f134046b, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
        GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, this.f134070z, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        GLES20.glViewport(0, 0, this.f134045a, this.f134046b);
        GLES20.glUseProgram(this.f134056l);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f134054j);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, MonetPacketDescriptor.MonetDataFormat.R8, this.f134049e, this.f134050f, 0, MonetPacketDescriptor.MonetDataFormat.R8, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.f134052h);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
        GLES20.glUniform1i(this.f134059o, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f134055k);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, MonetPacketDescriptor.MonetDataFormat.RG8, this.f134049e / 2, this.f134050f / 2, 0, MonetPacketDescriptor.MonetDataFormat.RG8, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.f134053i);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
        GLES20.glUniform1i(this.f134060p, 1);
        Matrix.setIdentityM(this.f134064t, 0);
        int i3 = this.f134051g;
        int i16 = this.f134069y;
        if (i16 == 90 || i16 == 270) {
            i3 = (((i3 - i16) + 360) + 180) % 360;
        }
        Matrix.setRotateM(this.f134064t, 0, i3, 0.0f, 0.0f, -1.0f);
        int i17 = this.f134051g;
        if (i17 != 90 && i17 != 270) {
            Matrix.scaleM(this.f134064t, 0, 1.0f, -1.0f, 1.0f);
        } else {
            Matrix.scaleM(this.f134064t, 0, -1.0f, 1.0f, 1.0f);
        }
        GLES20.glUniformMatrix4fv(this.f134061q, 1, false, this.f134064t, 0);
        this.f134062r.position(0);
        GLES20.glVertexAttribPointer(this.f134058n, 2, 5126, false, 0, (Buffer) this.f134062r);
        GLES20.glEnableVertexAttribArray(this.f134058n);
        this.f134063s.position(0);
        GLES20.glVertexAttribPointer(this.f134057m, 2, 5126, false, 0, (Buffer) this.f134063s);
        GLES20.glEnableVertexAttribArray(this.f134057m);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f134058n);
        GLES20.glDisableVertexAttribArray(this.f134057m);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        GLES20.glFinish();
        this.B.position(0);
        GLES20.glReadPixels(0, 0, this.f134045a, this.f134046b, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.B);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
    }

    public void a(ByteBuffer byteBuffer) {
        this.B = byteBuffer;
    }
}
