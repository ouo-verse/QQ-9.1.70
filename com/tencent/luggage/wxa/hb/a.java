package com.tencent.luggage.wxa.hb;

import android.graphics.Point;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.luggage.wxa.eb.d;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static final C6259a F = new C6259a(null);
    public ByteBuffer A;
    public Point B;
    public Point C;
    public long D;
    public boolean E;

    /* renamed from: a, reason: collision with root package name */
    public int f126948a;

    /* renamed from: b, reason: collision with root package name */
    public int f126949b;

    /* renamed from: c, reason: collision with root package name */
    public int f126950c;

    /* renamed from: d, reason: collision with root package name */
    public int f126951d;

    /* renamed from: e, reason: collision with root package name */
    public int f126952e;

    /* renamed from: f, reason: collision with root package name */
    public int f126953f;

    /* renamed from: g, reason: collision with root package name */
    public FloatBuffer f126954g;

    /* renamed from: h, reason: collision with root package name */
    public FloatBuffer f126955h;

    /* renamed from: i, reason: collision with root package name */
    public d f126956i;

    /* renamed from: j, reason: collision with root package name */
    public com.tencent.luggage.wxa.eb.a f126957j;

    /* renamed from: k, reason: collision with root package name */
    public ByteBuffer f126958k;

    /* renamed from: l, reason: collision with root package name */
    public float[] f126959l;

    /* renamed from: m, reason: collision with root package name */
    public int f126960m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f126961n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f126962o;

    /* renamed from: p, reason: collision with root package name */
    public Rect f126963p;

    /* renamed from: q, reason: collision with root package name */
    public Function1 f126964q;

    /* renamed from: r, reason: collision with root package name */
    public Function1 f126965r;

    /* renamed from: s, reason: collision with root package name */
    public Function1 f126966s;

    /* renamed from: t, reason: collision with root package name */
    public Function3 f126967t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f126968u;

    /* renamed from: v, reason: collision with root package name */
    public volatile boolean f126969v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f126970w;

    /* renamed from: x, reason: collision with root package name */
    public int f126971x;

    /* renamed from: y, reason: collision with root package name */
    public int f126972y;

    /* renamed from: z, reason: collision with root package name */
    public LinkedBlockingQueue f126973z;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.hb.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6259a {
        public C6259a() {
        }

        public /* synthetic */ C6259a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(int i3, int i16, int i17, int i18, int i19, int i26) {
        this.f126948a = i3;
        this.f126949b = i16;
        this.f126950c = i17;
        this.f126951d = i18;
        this.f126952e = i19;
        this.f126953f = i26;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(com.tencent.luggage.wxa.jb.a.f130931d.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        Intrinsics.checkNotNullExpressionValue(asFloatBuffer, "allocateDirect(GLEnviron\u2026eOrder()).asFloatBuffer()");
        this.f126954g = asFloatBuffer;
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(com.tencent.luggage.wxa.jb.a.f130930c.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        Intrinsics.checkNotNullExpressionValue(asFloatBuffer2, "allocateDirect(GLEnviron\u2026eOrder()).asFloatBuffer()");
        this.f126955h = asFloatBuffer2;
        this.f126959l = new float[16];
        this.f126968u = true;
        this.f126971x = -1;
        this.f126972y = -1;
        this.f126973z = new LinkedBlockingQueue();
        this.B = new Point(0, this.f126949b);
        this.C = new Point(this.f126948a, 0);
        int i27 = this.f126952e;
        if (i27 == 2) {
            this.f126956i = com.tencent.luggage.wxa.eb.c.a(true, 3L);
            this.f126957j = com.tencent.luggage.wxa.eb.c.f124603a.a(3L);
        } else if (i27 == 3) {
            c();
        }
    }

    public void a(int i3) {
    }

    public void b(int i3) {
        this.f126960m = i3;
    }

    public void c(int i3) {
        this.f126972y = i3;
    }

    public void d(int i3) {
        this.f126971x = i3;
    }

    public final void e() {
        if (this.f126969v) {
            if (this.f126956i == null) {
                this.f126956i = com.tencent.luggage.wxa.eb.c.a(true, 3L);
                this.f126957j = com.tencent.luggage.wxa.eb.c.f124603a.a(3L);
            }
            com.tencent.luggage.wxa.jb.a.f130928a.a(this.f126957j, this.f126956i, j(), i());
            GLES20.glViewport(0, 0, j(), i());
            int i3 = this.f126960m;
            if (i3 != 90 && i3 != 270) {
                Matrix.scaleM(this.f126959l, 0, 1.0f, -1.0f, 1.0f);
            } else {
                Matrix.scaleM(this.f126959l, 0, -1.0f, 1.0f, 1.0f);
            }
            this.f126970w = true;
        }
    }

    public final FloatBuffer f() {
        return this.f126955h;
    }

    public final int g() {
        return this.f126951d;
    }

    public final int h() {
        return this.f126950c;
    }

    public int i() {
        return this.f126972y;
    }

    public int j() {
        return this.f126971x;
    }

    public final FloatBuffer k() {
        return this.f126954g;
    }

    public final int l() {
        return this.f126949b;
    }

    public final int m() {
        return this.f126948a;
    }

    public final float[] n() {
        return this.f126959l;
    }

    public void o() {
        boolean z16;
        int i3;
        float f16;
        if (this.f126953f == 2) {
            int i16 = this.f126960m;
            if (i16 != 90 && i16 != 270) {
                z16 = false;
            } else {
                z16 = true;
            }
            Point point = this.C;
            int i17 = point.x;
            Point point2 = this.B;
            int i18 = i17 - point2.x;
            int i19 = point2.y - point.y;
            if (z16) {
                i3 = i19;
            } else {
                i3 = i18;
            }
            if (!z16) {
                i18 = i19;
            }
            float f17 = this.f126950c;
            float f18 = i3;
            float f19 = f17 / f18;
            float f26 = this.f126951d;
            float f27 = i18;
            float f28 = f26 / f27;
            float f29 = 0.0f;
            if (f19 < f28) {
                f16 = f18 - (f17 / f28);
            } else if (f19 > f28) {
                f16 = 0.0f;
                f29 = f27 - (f26 / f19);
            } else {
                f16 = 0.0f;
            }
            d(i3 - ((int) f16));
            c(i18 - ((int) f29));
        }
        this.f126954g.position(0);
        FloatBuffer floatBuffer = this.f126954g;
        com.tencent.luggage.wxa.ib.b bVar = com.tencent.luggage.wxa.ib.b.f129680a;
        floatBuffer.put(bVar.a(this.f126953f, this.f126948a, this.f126949b, this.B, this.C, this.f126960m, this.f126950c, this.f126951d, this.f126963p));
        this.f126954g.position(0);
        this.f126955h.position(0);
        this.f126955h.put(bVar.a(this.f126953f, this.f126948a, this.f126949b, this.B, this.C, this.f126960m, this.f126950c, this.f126951d));
        this.f126955h.position(0);
    }

    public void p() {
        Matrix.setIdentityM(this.f126959l, 0);
        Matrix.setRotateM(this.f126959l, 0, this.f126960m, 0.0f, 0.0f, -1.0f);
        if (!this.f126961n && this.f126952e != 3) {
            Matrix.scaleM(this.f126959l, 0, 1.0f, 1.0f, 1.0f);
        } else {
            int i3 = this.f126960m;
            if (i3 != 90 && i3 != 270) {
                Matrix.scaleM(this.f126959l, 0, 1.0f, -1.0f, 1.0f);
            } else {
                Matrix.scaleM(this.f126959l, 0, -1.0f, 1.0f, 1.0f);
            }
        }
        if (this.f126962o) {
            Matrix.scaleM(this.f126959l, 0, 1.0f, -1.0f, 1.0f);
        }
        if (this.f126953f == 5) {
            a(this.f126950c / this.f126951d, this.f126948a / this.f126949b);
        }
    }

    public void q() {
        w.d("MicroMsg.GLTextureRenderProc", hashCode() + " release renderOutputTexture:" + this.f126956i + ", renderOutputTextureFbo:" + this.f126957j + ", drawWidth:" + this.f126950c + ", drawHeight:" + this.f126951d);
        d dVar = this.f126956i;
        if (dVar != null) {
            dVar.close();
        }
        com.tencent.luggage.wxa.eb.a aVar = this.f126957j;
        if (aVar != null) {
            aVar.close();
        }
    }

    public void r() {
        b();
        if (this.E) {
            GLES20.glFinish();
        }
        long a16 = w0.a();
        s();
        if (this.E) {
            GLES20.glFinish();
            this.D = w0.e(a16);
        }
        a();
    }

    public abstract void s();

    public final void t() {
        if (this.f126952e == 2) {
            if (this.f126956i == null) {
                this.f126956i = com.tencent.luggage.wxa.eb.c.a(true, 3L);
                this.f126957j = com.tencent.luggage.wxa.eb.c.f124603a.a(3L);
            }
            com.tencent.luggage.wxa.jb.a.f130928a.a(this.f126957j, this.f126956i, this.f126950c, this.f126951d);
        }
        GLES20.glViewport(0, 0, this.f126950c, this.f126951d);
        e();
    }

    public void a(boolean z16) {
        this.f126962o = z16;
    }

    public void b() {
        p();
        o();
        t();
    }

    public final void c() {
        int i3;
        int i16 = this.f126950c;
        if (i16 <= 0 || (i3 = this.f126951d) <= 0 || this.f126958k != null) {
            return;
        }
        this.f126958k = ByteBuffer.allocateDirect(i16 * i3 * 4).order(ByteOrder.nativeOrder());
    }

    public final void d() {
        if (j() <= 0 || i() <= 0 || this.f126973z.size() >= 2) {
            return;
        }
        int i3 = 0;
        if (this.f126968u) {
            int size = 2 - this.f126973z.size();
            while (i3 < size) {
                this.f126973z.add(ByteBuffer.allocateDirect(j() * i() * 4).order(ByteOrder.nativeOrder()));
                i3++;
            }
            return;
        }
        int size2 = 2 - this.f126973z.size();
        while (i3 < size2) {
            this.f126973z.add(ByteBuffer.allocate(j() * i() * 4).order(ByteOrder.nativeOrder()));
            i3++;
        }
    }

    public final void a(int i3, int i16) {
        if (i3 != j() || i16 != i()) {
            this.f126973z.clear();
        }
        d(i3);
        c(i16);
    }

    public void c(int i3, int i16) {
        this.f126948a = i3;
        this.f126949b = i16;
        Point point = this.B;
        point.x = 0;
        point.y = i16;
        Point point2 = this.C;
        point2.x = i3;
        point2.y = 0;
    }

    public void b(int i3, int i16) {
        if (this.f126950c != i3 || this.f126951d != i16) {
            w.d("MicroMsg.GLTextureRenderProc", "updateDrawViewSize: current width=" + this.f126950c + ", height=" + this.f126951d + ". new width=" + i3 + ", height=" + i16);
        }
        this.f126951d = i16;
        this.f126950c = i3;
        a(i3, i16);
        if (this.f126952e == 3) {
            c();
        }
    }

    public final void a(float f16, float f17) {
        float f18;
        float f19;
        float f26;
        float f27;
        if (f17 > f16) {
            float f28 = f17 / f16;
            f26 = -f28;
            f27 = f28;
            f18 = -1.0f;
            f19 = 1.0f;
        } else {
            float f29 = (-f16) / f17;
            f18 = f29;
            f19 = -f29;
            f26 = -1.0f;
            f27 = 1.0f;
        }
        Matrix.orthoM(this.f126959l, 0, f18, f19, f26, f27, 1.0f, -1.0f);
    }

    public void a() {
        IntBuffer asIntBuffer;
        if (this.f126969v && this.f126970w) {
            w0.a();
            this.f126970w = false;
            if (this.f126973z.size() < 2) {
                d();
            }
            if (this.f126973z.size() >= 2 && j() >= 0 && i() >= 0) {
                com.tencent.luggage.wxa.eb.a aVar = this.f126957j;
                if (aVar != null) {
                    aVar.a();
                }
                ByteBuffer order = this.f126973z.size() > 0 ? (ByteBuffer) this.f126973z.take() : ByteBuffer.allocate(j() * i() * 4).order(ByteOrder.nativeOrder());
                if (order != null) {
                    order.position(0);
                }
                GLES20.glReadPixels(0, 0, j(), i(), 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, order);
                GLES20.glFinish();
                Function1 function1 = this.f126966s;
                if (function1 != null) {
                    Intrinsics.checkNotNull(order);
                    function1.invoke(order);
                }
                Function3 function3 = this.f126967t;
                if (function3 != null) {
                    Intrinsics.checkNotNull(order);
                    function3.invoke(order, Integer.valueOf(j()), Integer.valueOf(i()));
                }
                Function1 function12 = this.f126965r;
                if (function12 != null) {
                    asIntBuffer = order != null ? order.asIntBuffer() : null;
                    Intrinsics.checkNotNull(asIntBuffer);
                    function12.invoke(asIntBuffer);
                }
                GLES20.glBindFramebuffer(36160, 0);
                this.f126969v = false;
                if (this.f126973z.size() < 2) {
                    this.f126973z.add(order);
                }
                this.A = order;
                return;
            }
            this.f126969v = false;
            return;
        }
        int i3 = this.f126952e;
        if (i3 == 3) {
            if (this.f126958k == null) {
                c();
            }
            ByteBuffer byteBuffer = this.f126958k;
            if (byteBuffer != null) {
                byteBuffer.clear();
                GLES20.glReadPixels(0, 0, this.f126950c, this.f126951d, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.f126958k);
                GLES20.glFinish();
                Function1 function13 = this.f126965r;
                if (function13 != null) {
                    ByteBuffer byteBuffer2 = this.f126958k;
                    asIntBuffer = byteBuffer2 != null ? byteBuffer2.asIntBuffer() : null;
                    Intrinsics.checkNotNull(asIntBuffer);
                    function13.invoke(asIntBuffer);
                }
            }
        } else if (i3 == 2) {
            GLES20.glBindFramebuffer(36160, 0);
            Function1 function14 = this.f126964q;
            if (function14 != null) {
                function14.invoke(this.f126956i);
            }
        }
        GLES20.glUseProgram(0);
        GLES20.glBindFramebuffer(36160, 0);
    }
}
