package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.ViewConfiguration;
import com.tencent.mapsdk.internal.v;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class qj implements fd {

    /* renamed from: i, reason: collision with root package name */
    private static final int f149825i = 8;

    /* renamed from: j, reason: collision with root package name */
    private static final float f149826j = 10.0f;

    /* renamed from: a, reason: collision with root package name */
    boolean f149827a;

    /* renamed from: b, reason: collision with root package name */
    public qm f149828b;

    /* renamed from: d, reason: collision with root package name */
    public bb f149830d;

    /* renamed from: g, reason: collision with root package name */
    private float f149833g;

    /* renamed from: h, reason: collision with root package name */
    private float f149834h;

    /* renamed from: k, reason: collision with root package name */
    private bf f149835k;

    /* renamed from: l, reason: collision with root package name */
    private float f149836l;

    /* renamed from: m, reason: collision with root package name */
    private float f149837m;

    /* renamed from: n, reason: collision with root package name */
    private final float f149838n;

    /* renamed from: e, reason: collision with root package name */
    private final long f149831e = 250;

    /* renamed from: f, reason: collision with root package name */
    private final long f149832f = 1200;

    /* renamed from: c, reason: collision with root package name */
    public boolean f149829c = false;

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.qj$4, reason: invalid class name */
    /* loaded from: classes9.dex */
    final class AnonymousClass4 extends jn {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f149845a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f149846b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ PointF f149847c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(double[] dArr, long j3, long j16, PointF pointF) {
            super(3, dArr);
            this.f149845a = j3;
            this.f149846b = j16;
            this.f149847c = pointF;
        }

        @Override // com.tencent.mapsdk.internal.jn
        public final boolean a() {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f149845a;
            long j3 = this.f149846b;
            if (elapsedRealtime > j3) {
                qj.this.f149827a = false;
                return true;
            }
            float f16 = this.f149847c.x;
            if (f16 != 0.0f) {
                this.A[0] = jk.a(elapsedRealtime, f16, -f16, j3);
            }
            float f17 = this.f149847c.y;
            if (f17 != 0.0f) {
                this.A[1] = jk.a(elapsedRealtime, f17, -f17, this.f149846b);
            }
            return false;
        }

        @Override // com.tencent.mapsdk.internal.jn
        public final void b() {
            qj.this.f149827a = false;
        }
    }

    public qj(bf bfVar) {
        this.f149833g = ViewConfiguration.getMinimumFlingVelocity();
        this.f149834h = ViewConfiguration.getMaximumFlingVelocity();
        this.f149835k = bfVar;
        bb bbVar = (bb) bfVar.b();
        this.f149830d = bbVar;
        if (bbVar != null) {
            bbVar.a(this);
            Context H = this.f149830d.H();
            if (H != null) {
                ViewConfiguration viewConfiguration = ViewConfiguration.get(H);
                this.f149833g = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f149834h = viewConfiguration.getScaledMaximumFlingVelocity();
            }
        }
        this.f149828b = new qm();
        this.f149838n = bfVar.i() * 2.5f;
    }

    private void l(float f16, float f17) {
        this.f149829c = true;
        if (this.f149827a) {
            return;
        }
        float f18 = f16 / 64.0f;
        float f19 = f17 / 64.0f;
        if (Math.abs(f18) < this.f149838n && Math.abs(f19) < this.f149838n) {
            return;
        }
        float max = Math.max(Math.abs(f16), Math.abs(f17));
        float f26 = this.f149833g;
        PointF pointF = new PointF(f18, f19);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f149827a = true;
        this.f149835k.a().a(new AnonymousClass4(new double[]{0.0d, 0.0d}, elapsedRealtime, (((max - f26) / (this.f149834h - f26)) * 950.0f) + 250, pointF));
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final void a() {
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean b(float f16) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean c(float f16, float f17) {
        if (!this.f149828b.b() || !this.f149828b.c()) {
            return false;
        }
        this.f149829c = true;
        if (this.f149827a) {
            return false;
        }
        float f18 = f16 / 64.0f;
        float f19 = f17 / 64.0f;
        if (Math.abs(f18) < this.f149838n && Math.abs(f19) < this.f149838n) {
            return false;
        }
        float max = Math.max(Math.abs(f16), Math.abs(f17));
        float f26 = this.f149833g;
        PointF pointF = new PointF(f18, f19);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f149827a = true;
        this.f149835k.a().a(new AnonymousClass4(new double[]{0.0d, 0.0d}, elapsedRealtime, (((max - f26) / (this.f149834h - f26)) * 950.0f) + 250, pointF));
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean d() {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean e(float f16, float f17) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean f(float f16, float f17) {
        if (this.f149828b.f()) {
            this.f149836l = this.f149835k.a().A.f151253b.f151290p;
            this.f149837m = f17;
            return false;
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean g(float f16, float f17) {
        lc.a(Float.valueOf(f16), Float.valueOf(f17));
        if (this.f149828b.f()) {
            this.f149835k.a().c(Math.pow(2.0d, ((this.f149837m - f17) * 10.0f) / this.f149835k.h().height()) * this.f149836l);
            this.f149835k.a().a(true);
        }
        return true;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean h(float f16, float f17) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean i(float f16, float f17) {
        this.f149835k.a().f147732o.e();
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean j(float f16, float f17) {
        this.f149835k.a().a(false);
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean k(float f16, float f17) {
        return false;
    }

    private static /* synthetic */ boolean a(qj qjVar) {
        qjVar.f149827a = false;
        return false;
    }

    private boolean e() {
        boolean z16 = this.f149829c;
        this.f149829c = false;
        return z16;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean b(float f16, float f17) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean d(float f16, float f17) {
        ae a16;
        bf bfVar;
        tk g16;
        if (!this.f149828b.b() || (bfVar = (a16 = this.f149835k.a()).f147743z) == null || (g16 = bfVar.g()) == null) {
            return false;
        }
        g16.b(f16, f17);
        a16.c();
        a16.a(true);
        return false;
    }

    private void a(qm qmVar) {
        this.f149828b = qmVar;
        boolean a16 = qmVar.a();
        bb bbVar = this.f149830d;
        if (bbVar == null) {
            return;
        }
        if (a16) {
            bbVar.b(this);
        } else {
            bbVar.a(this);
        }
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean b() {
        lc.a(new Object[0]);
        if (this.f149828b.i()) {
            final ae a16 = this.f149835k.a();
            a16.b(new Runnable() { // from class: com.tencent.mapsdk.internal.qj.2
                @Override // java.lang.Runnable
                public final void run() {
                    a16.p();
                }
            });
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean a(float f16, float f17) {
        if (!this.f149828b.f()) {
            return false;
        }
        final ae a16 = this.f149835k.a();
        Runnable runnable = new Runnable() { // from class: com.tencent.mapsdk.internal.qj.1
            @Override // java.lang.Runnable
            public final void run() {
                a16.p();
            }
        };
        if (a16.L) {
            v.c cVar = a16.A.f151269r;
            if (cVar != null) {
                float width = a16.f147743z.h().width() * (cVar.f151295a + 0.5f);
                f17 = (cVar.f151296b + 0.5f) * a16.f147743z.h().height();
                f16 = width;
            } else {
                a16.a(runnable);
                return false;
            }
        }
        if (!a16.l()) {
            return false;
        }
        Rect rect = a16.A.f151265n;
        int height = rect.height();
        float t16 = a16.f147743z.g().t();
        if (f17 >= rect.top && f17 < (r2 + height) - t16) {
            f17 = (r2 + height) - t16;
        }
        a16.f147743z.g().c(f16, f17);
        runnable.run();
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean c() {
        if (this.f149827a) {
            this.f149835k.a().f147732o.e();
            this.f149827a = false;
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean a(float f16) {
        if (!this.f149828b.d()) {
            return false;
        }
        double d16 = (f16 / 8.0f) * 2.0f;
        ae a16 = this.f149835k.a();
        a16.f147732o.e();
        a16.b(new jn(102, new double[]{0.0d, d16}));
        this.f149835k.a().a(true);
        return true;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean a(PointF pointF, PointF pointF2, float f16) {
        if (!this.f149828b.e()) {
            return false;
        }
        this.f149835k.a().a(true);
        ae a16 = this.f149835k.a();
        double d16 = f16;
        double d17 = pointF.x;
        double d18 = pointF.y;
        double d19 = pointF2.x;
        double d26 = pointF2.y;
        a16.f147732o.e();
        float width = a16.f147743z.h().width() / 2.0f;
        float height = a16.f147743z.h().height() / 2.0f;
        v.c cVar = a16.A.f151269r;
        if (a16.M) {
            if (cVar != null) {
                d17 = width + (cVar.f151295a * width * 2.0f);
                d18 = height + (cVar.f151296b * height * 2.0f);
            } else {
                d17 = width;
                d18 = height;
            }
            d19 = d17;
            d26 = d18;
        }
        a16.c(new jn(103, new double[]{d16, d17, d18, d19, d26}));
        return false;
    }

    @Override // com.tencent.mapsdk.internal.fd
    public final boolean a(PointF pointF, PointF pointF2, double d16, double d17) {
        if (!this.f149828b.j()) {
            return false;
        }
        final ae a16 = this.f149835k.a();
        a16.a(true);
        a16.a(d17 / d16, pointF.x, pointF.y, pointF2.x, pointF2.y, new Runnable() { // from class: com.tencent.mapsdk.internal.qj.3
            @Override // java.lang.Runnable
            public final void run() {
                a16.p();
            }
        });
        return false;
    }
}
