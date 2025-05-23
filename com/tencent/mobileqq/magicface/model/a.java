package com.tencent.mobileqq.magicface.model;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qfsmonet.api.data.MonetPacketDescriptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ShaderUtil;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;
    private static final short[] I;
    private boolean A;
    private byte[] B;
    private byte[] C;
    private byte[] D;
    private byte[] E;
    private byte[] F;
    private byte[] G;
    private HashMap<String, ByteBuffer> H;

    /* renamed from: a, reason: collision with root package name */
    private int f243404a;

    /* renamed from: b, reason: collision with root package name */
    private int f243405b;

    /* renamed from: c, reason: collision with root package name */
    private int f243406c;

    /* renamed from: d, reason: collision with root package name */
    private int f243407d;

    /* renamed from: e, reason: collision with root package name */
    private int f243408e;

    /* renamed from: f, reason: collision with root package name */
    private int f243409f;

    /* renamed from: g, reason: collision with root package name */
    private int f243410g;

    /* renamed from: h, reason: collision with root package name */
    private int f243411h;

    /* renamed from: i, reason: collision with root package name */
    private int f243412i;

    /* renamed from: j, reason: collision with root package name */
    private int f243413j;

    /* renamed from: k, reason: collision with root package name */
    private int f243414k;

    /* renamed from: l, reason: collision with root package name */
    private int f243415l;

    /* renamed from: m, reason: collision with root package name */
    private int f243416m;

    /* renamed from: n, reason: collision with root package name */
    private int f243417n;

    /* renamed from: o, reason: collision with root package name */
    private int f243418o;

    /* renamed from: p, reason: collision with root package name */
    private int f243419p;

    /* renamed from: q, reason: collision with root package name */
    private FloatBuffer f243420q;

    /* renamed from: r, reason: collision with root package name */
    private FloatBuffer f243421r;

    /* renamed from: s, reason: collision with root package name */
    private ShortBuffer f243422s;

    /* renamed from: t, reason: collision with root package name */
    private int f243423t;

    /* renamed from: u, reason: collision with root package name */
    private int f243424u;

    /* renamed from: v, reason: collision with root package name */
    private int f243425v;

    /* renamed from: w, reason: collision with root package name */
    private int f243426w;

    /* renamed from: x, reason: collision with root package name */
    private int f243427x;

    /* renamed from: y, reason: collision with root package name */
    private int f243428y;

    /* renamed from: z, reason: collision with root package name */
    private float f243429z;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72907);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            I = new short[]{0, 1, 2, 2, 3, 0};
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f243411h = -1;
        this.f243412i = -1;
        this.f243413j = -1;
        this.f243417n = -1;
        this.f243418o = -1;
        this.f243419p = -1;
        this.f243420q = null;
        this.f243421r = null;
        this.f243422s = null;
        this.f243423t = 0;
        this.f243424u = 0;
        this.f243425v = 0;
        this.f243426w = 0;
        this.f243427x = 0;
        this.f243428y = 0;
        this.f243429z = -1.0f;
        this.A = false;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = new HashMap<>();
        d();
        c();
    }

    private void a(float f16) {
        double d16 = (f16 * 3.14159f) / 180.0f;
        float sin = (float) Math.sin(d16);
        float cos = (float) Math.cos(d16);
        float[] fArr = {cos, sin, 0.0f, 0.0f, -sin, cos, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(64);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        GLES20.glUniformMatrix4fv(this.f243410g, 1, false, asFloatBuffer);
    }

    private void d() {
        short[] sArr = I;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(sArr.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect.asShortBuffer();
        this.f243422s = asShortBuffer;
        asShortBuffer.put(sArr);
        this.f243422s.position(0);
    }

    private int e(byte[] bArr, int i3, int i16) {
        IntBuffer allocate = IntBuffer.allocate(1);
        GLES20.glGenTextures(1, allocate);
        int i17 = allocate.get();
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i17);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10241, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10240, 9729.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10242, 33071.0f);
        GLES20.glTexParameterf(GLSLRender.GL_TEXTURE_2D, 10243, 33071.0f);
        ByteBuffer byteBuffer = this.H.get(bArr.length + "");
        if (byteBuffer == null) {
            try {
                byteBuffer = ByteBuffer.allocateDirect(bArr.length);
                this.H.put(bArr.length + "", byteBuffer);
            } catch (OutOfMemoryError e16) {
                e16.printStackTrace();
                return MessageRecord.MSG_TYPE_QZONE_NEWEST_FEED;
            }
        }
        ByteBuffer byteBuffer2 = byteBuffer;
        byteBuffer2.order(ByteOrder.nativeOrder());
        byteBuffer2.put(bArr);
        byteBuffer2.position(0);
        GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, MonetPacketDescriptor.MonetDataFormat.R8, i3, i16, 0, MonetPacketDescriptor.MonetDataFormat.R8, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, byteBuffer2);
        return i17;
    }

    private void f(boolean z16) {
        float f16;
        if (z16) {
            f16 = 1.0f;
        } else {
            f16 = ((this.f243427x / this.f243425v) * this.f243426w) / this.f243428y;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicFaceGLDisplayer", 2, "func updateRenderParam, [yCord]=" + f16);
        }
        float f17 = ((r3 - this.f243425v) / this.f243423t) / 2.0f;
        float f18 = ((r6 - this.f243426w) / this.f243424u) / 2.0f;
        float f19 = -f16;
        float[] fArr = {1.0f, f19, 0.0f, 1.0f, f16, 0.0f, -1.0f, f16, 0.0f, -1.0f, f19, 0.0f};
        float f26 = 1.0f - f17;
        float f27 = 1.0f - f18;
        float[] fArr2 = {f26, f27, f26, f18, f17, f18, f17, f27};
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(48);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.f243420q = asFloatBuffer;
        asFloatBuffer.put(fArr);
        this.f243420q.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(32);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        this.f243421r = asFloatBuffer2;
        asFloatBuffer2.put(fArr2);
        this.f243421r.position(0);
    }

    public void b(byte[] bArr, byte[] bArr2, int i3, int i16, int i17, int i18, float f16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, bArr, bArr2, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Float.valueOf(f16), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicFaceGLDisplayer", 2, "func draw begins, _srcwidth:" + i3 + ",_srcheight:" + i16 + ",_dstWidth:" + i17 + ",_dstHeight:" + i18 + ",isFull:" + z16);
        }
        if (i3 <= 700 && i16 <= 900) {
            GLES20.glClear(16640);
            this.f243427x = i17;
            this.f243428y = i18;
            this.f243423t = i3;
            this.f243424u = i16;
            this.f243425v = i3;
            this.f243426w = i16;
            if (this.f243429z == -1.0f) {
                this.f243429z = f16;
                this.A = z16;
                f(z16);
                a(this.f243429z);
            }
            if (this.f243429z != f16) {
                this.f243429z = f16;
                a(f16);
            }
            if (this.A != z16) {
                this.A = z16;
                f(z16);
            }
            if (this.f243423t != this.f243425v || this.f243424u != this.f243426w) {
                f(this.A);
            }
            byte[] bArr3 = this.B;
            if (bArr3 == null) {
                this.B = new byte[this.f243423t * this.f243424u];
            } else {
                int length = bArr3.length;
                int i19 = this.f243423t;
                int i26 = this.f243424u;
                if (length != i19 * i26) {
                    this.B = new byte[i19 * i26];
                }
            }
            byte[] bArr4 = this.C;
            if (bArr4 == null) {
                this.C = new byte[(this.f243423t * this.f243424u) / 4];
            } else {
                int length2 = bArr4.length;
                int i27 = this.f243423t;
                int i28 = this.f243424u;
                if (length2 != (i27 * i28) / 4) {
                    this.C = new byte[(i27 * i28) / 4];
                }
            }
            byte[] bArr5 = this.D;
            if (bArr5 == null) {
                this.D = new byte[(this.f243423t * this.f243424u) / 4];
            } else {
                int length3 = bArr5.length;
                int i29 = this.f243423t;
                int i36 = this.f243424u;
                if (length3 != (i29 * i36) / 4) {
                    this.D = new byte[(i29 * i36) / 4];
                }
            }
            byte[] bArr6 = this.E;
            if (bArr6 == null) {
                this.E = new byte[this.f243423t * this.f243424u];
            } else {
                int length4 = bArr6.length;
                int i37 = this.f243423t;
                int i38 = this.f243424u;
                if (length4 != i37 * i38) {
                    this.E = new byte[i37 * i38];
                }
            }
            byte[] bArr7 = this.F;
            if (bArr7 == null) {
                this.F = new byte[(this.f243423t * this.f243424u) / 4];
            } else {
                int length5 = bArr7.length;
                int i39 = this.f243423t;
                int i46 = this.f243424u;
                if (length5 != (i39 * i46) / 4) {
                    this.F = new byte[(i39 * i46) / 4];
                }
            }
            byte[] bArr8 = this.G;
            if (bArr8 == null) {
                this.G = new byte[(this.f243423t * this.f243424u) / 4];
            } else {
                int length6 = bArr8.length;
                int i47 = this.f243423t;
                int i48 = this.f243424u;
                if (length6 != (i47 * i48) / 4) {
                    this.G = new byte[(i47 * i48) / 4];
                }
            }
            try {
                System.arraycopy(bArr, 0, this.B, 0, this.f243423t * this.f243424u);
                int i49 = this.f243423t;
                int i56 = this.f243424u;
                System.arraycopy(bArr, i49 * i56, this.C, 0, (i49 * i56) / 4);
                int i57 = this.f243423t;
                int i58 = this.f243424u;
                System.arraycopy(bArr, ((i57 * i58) * 5) / 4, this.D, 0, (i57 * i58) / 4);
                System.arraycopy(bArr2, 0, this.E, 0, this.f243423t * this.f243424u);
                int i59 = this.f243423t;
                int i65 = this.f243424u;
                System.arraycopy(bArr2, i59 * i65, this.F, 0, (i59 * i65) / 4);
                int i66 = this.f243423t;
                int i67 = this.f243424u;
                System.arraycopy(bArr2, ((i66 * i67) * 5) / 4, this.G, 0, (i66 * i67) / 4);
                int i68 = this.f243411h;
                if (i68 != -1) {
                    GLES20.glDeleteTextures(1, new int[]{i68}, 0);
                }
                int i69 = this.f243412i;
                if (i69 != -1) {
                    GLES20.glDeleteTextures(1, new int[]{i69}, 0);
                }
                int i75 = this.f243413j;
                if (i75 != -1) {
                    GLES20.glDeleteTextures(1, new int[]{i75}, 0);
                }
                int i76 = this.f243417n;
                if (i76 != -1) {
                    GLES20.glDeleteTextures(1, new int[]{i76}, 0);
                }
                int i77 = this.f243418o;
                if (i77 != -1) {
                    GLES20.glDeleteTextures(1, new int[]{i77}, 0);
                }
                int i78 = this.f243419p;
                if (i78 != -1) {
                    GLES20.glDeleteTextures(1, new int[]{i78}, 0);
                }
                this.f243411h = e(this.B, this.f243423t, this.f243424u);
                this.f243412i = e(this.C, this.f243423t / 2, this.f243424u / 2);
                this.f243413j = e(this.D, this.f243423t / 2, this.f243424u / 2);
                this.f243417n = e(this.E, this.f243423t, this.f243424u);
                this.f243418o = e(this.F, this.f243423t / 2, this.f243424u / 2);
                int e16 = e(this.G, this.f243423t / 2, this.f243424u / 2);
                this.f243419p = e16;
                if (this.f243411h != -2015 && this.f243412i != -2015 && this.f243413j != -2015 && this.f243417n != -2015 && this.f243418o != -2015 && e16 != -2015) {
                    GLES20.glVertexAttribPointer(this.f243405b, 3, 5126, false, 12, (Buffer) this.f243420q);
                    GLES20.glVertexAttribPointer(this.f243406c, 2, 5126, false, 8, (Buffer) this.f243421r);
                    GLES20.glActiveTexture(33984);
                    GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f243417n);
                    GLES20.glUniform1i(this.f243414k, 0);
                    GLES20.glActiveTexture(33985);
                    GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f243418o);
                    GLES20.glUniform1i(this.f243415l, 1);
                    GLES20.glActiveTexture(33986);
                    GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f243419p);
                    GLES20.glUniform1i(this.f243416m, 2);
                    GLES20.glActiveTexture(33987);
                    GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f243411h);
                    GLES20.glUniform1i(this.f243407d, 3);
                    GLES20.glActiveTexture(33988);
                    GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f243412i);
                    GLES20.glUniform1i(this.f243408e, 4);
                    GLES20.glActiveTexture(33989);
                    GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, this.f243413j);
                    GLES20.glUniform1i(this.f243409f, 5);
                    GLES20.glDrawElements(4, I.length, 5123, this.f243422s);
                    if (QLog.isColorLevel()) {
                        QLog.d("MagicFaceGLDisplayer", 2, "func draw ends");
                        return;
                    }
                    return;
                }
                return;
            } catch (OutOfMemoryError unused) {
                if (QLog.isColorLevel()) {
                    QLog.w("MagicFaceGLDisplayer", 2, "ooooom happens.");
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("MagicFaceGLDisplayer", 2, "func draw ends, video size is too big. something must be wrong");
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        int createProgram = ShaderUtil.createProgram("attribute vec4 position;\nattribute mediump vec2 textureCoordinate;\nvarying mediump vec2 coordinate;\nuniform mat4 transformMatrix;\nvoid main()\n{\n   gl_Position = position * transformMatrix; \n   coordinate = textureCoordinate; \n}\n", "precision highp float;\nuniform sampler2D SamplerY;\nuniform sampler2D SamplerU;\nuniform sampler2D SamplerV;\nuniform sampler2D SamplerY_Alpha;\nuniform sampler2D SamplerU_Alpha;\nuniform sampler2D SamplerV_Alpha;\nvarying highp vec2 coordinate;\nvoid main()\n{\n    highp vec3 yuv;\n    highp vec3 rgb;    \n    yuv.x = texture2D(SamplerY, coordinate).r;    \n    yuv.y = texture2D(SamplerU, coordinate).r-0.5;    \n    yuv.z = texture2D(SamplerV, coordinate).r-0.5 ;    \n    rgb = mat3(      1,       1,      1,\n                       0,         -.34414, 1.772,\n                       1.402,     -.71414, 0) * yuv;    \n    highp vec3 yuv_Alpha;\n    highp vec3 rgb_Alpha;    \n    yuv_Alpha.x = texture2D(SamplerY_Alpha, coordinate).r;    \n    yuv_Alpha.y = texture2D(SamplerU_Alpha, coordinate).r-0.5;    \n    yuv_Alpha.z = texture2D(SamplerV_Alpha, coordinate).r-0.5 ;    \n    rgb_Alpha = mat3(      1,       1,      1,\n                       0,         -.34414, 1.772,\n                       1.402,     -.71414, 0) * yuv_Alpha;    \n         if(rgb_Alpha[0]  <= 0.196 ){   \n               rgb_Alpha[0] = 0.0;}   \n         else if(rgb_Alpha[0]  >= 0.922){     \n               rgb_Alpha[0] = 1.0;}  \n    gl_FragColor = vec4(rgb.r * rgb_Alpha.r ,rgb.g * rgb_Alpha.r ,rgb.b * rgb_Alpha.r, rgb_Alpha.r) ;\n}\n");
        this.f243404a = createProgram;
        GLES20.glUseProgram(createProgram);
        this.f243405b = GLES20.glGetAttribLocation(this.f243404a, "position");
        this.f243406c = GLES20.glGetAttribLocation(this.f243404a, "textureCoordinate");
        this.f243407d = GLES20.glGetUniformLocation(this.f243404a, "SamplerY");
        this.f243408e = GLES20.glGetUniformLocation(this.f243404a, "SamplerU");
        this.f243409f = GLES20.glGetUniformLocation(this.f243404a, "SamplerV");
        this.f243414k = GLES20.glGetUniformLocation(this.f243404a, "SamplerY_Alpha");
        this.f243415l = GLES20.glGetUniformLocation(this.f243404a, "SamplerU_Alpha");
        this.f243416m = GLES20.glGetUniformLocation(this.f243404a, "SamplerV_Alpha");
        this.f243410g = GLES20.glGetUniformLocation(this.f243404a, "transformMatrix");
        GLES20.glEnableVertexAttribArray(this.f243405b);
        GLES20.glEnableVertexAttribArray(this.f243406c);
    }
}
