package com.tencent.mapsdk.internal;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class th extends jn {

    /* renamed from: b, reason: collision with root package name */
    public static final long f150455b = 500;

    /* renamed from: c, reason: collision with root package name */
    public static final int f150456c = 10000;
    public int I;
    public int J;
    public int K;
    public int L;
    public boolean M;
    public boolean N;
    public boolean O;
    public double P;
    public boolean Q;
    public int R;
    public int S;
    public boolean T;
    int U;
    int V;
    int W;
    int X;
    int Y;
    int Z;

    /* renamed from: a, reason: collision with root package name */
    public a f150457a;

    /* renamed from: aa, reason: collision with root package name */
    public int f150458aa;

    /* renamed from: ab, reason: collision with root package name */
    public int f150459ab;

    /* renamed from: ac, reason: collision with root package name */
    public boolean f150460ac;

    /* renamed from: ad, reason: collision with root package name */
    float f150461ad;

    /* renamed from: ae, reason: collision with root package name */
    float f150462ae;

    /* renamed from: af, reason: collision with root package name */
    float f150463af;

    /* renamed from: ag, reason: collision with root package name */
    public float f150464ag;

    /* renamed from: ah, reason: collision with root package name */
    public boolean f150465ah;

    /* renamed from: ai, reason: collision with root package name */
    float f150466ai;

    /* renamed from: aj, reason: collision with root package name */
    float f150467aj;

    /* renamed from: ak, reason: collision with root package name */
    float f150468ak;

    /* renamed from: al, reason: collision with root package name */
    public float f150469al;

    /* renamed from: am, reason: collision with root package name */
    private final Runnable f150470am;

    /* renamed from: an, reason: collision with root package name */
    private final Runnable f150471an;

    /* renamed from: ao, reason: collision with root package name */
    private boolean f150472ao;

    /* renamed from: ap, reason: collision with root package name */
    private Interpolator f150473ap;

    /* renamed from: aq, reason: collision with root package name */
    private boolean f150474aq;

    /* renamed from: ar, reason: collision with root package name */
    private int f150475ar;

    /* renamed from: as, reason: collision with root package name */
    private int f150476as;

    /* renamed from: at, reason: collision with root package name */
    private boolean f150477at;

    /* renamed from: au, reason: collision with root package name */
    private float f150478au;

    /* renamed from: av, reason: collision with root package name */
    private float f150479av;

    /* renamed from: aw, reason: collision with root package name */
    private double f150480aw;

    /* renamed from: ax, reason: collision with root package name */
    private double f150481ax;

    /* renamed from: ay, reason: collision with root package name */
    private double f150482ay;

    /* renamed from: az, reason: collision with root package name */
    private double f150483az;

    /* renamed from: d, reason: collision with root package name */
    protected long f150484d;

    /* renamed from: e, reason: collision with root package name */
    protected long f150485e;

    /* renamed from: f, reason: collision with root package name */
    public TencentMap.CancelableCallback f150486f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f150487g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f150488h;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        float a();

        void a(Runnable runnable);

        int b();

        GeoPoint c();

        float d();

        float e();

        float f();

        GeoPoint g();

        boolean h();
    }

    public th() {
        super(10000, null);
        this.f150470am = new Runnable() { // from class: com.tencent.mapsdk.internal.th.1
            @Override // java.lang.Runnable
            public final void run() {
                if (th.this.f150486f == null) {
                    return;
                }
                th.this.f150486f.onFinish();
            }
        };
        this.f150471an = new Runnable() { // from class: com.tencent.mapsdk.internal.th.2
            @Override // java.lang.Runnable
            public final void run() {
                if (th.this.f150486f == null) {
                    return;
                }
                th.this.f150486f.onCancel();
            }
        };
        this.f150457a = null;
        this.f150484d = 500L;
        this.f150472ao = false;
        this.f150485e = 0L;
        this.f150473ap = new LinearInterpolator();
        this.f150486f = null;
        this.f150487g = false;
        this.f150474aq = false;
        this.f150488h = false;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.f150475ar = 0;
        this.L = 0;
        this.f150476as = 0;
        this.M = false;
        this.N = false;
        this.O = false;
        this.f150477at = false;
        this.f150478au = 0.0f;
        this.f150479av = 0.0f;
        this.f150480aw = 0.0d;
        this.f150481ax = 0.0d;
        this.P = 0.0d;
        this.f150482ay = 0.0d;
        this.f150483az = 1.0d;
        this.Q = false;
        this.R = 0;
        this.S = 0;
        this.T = false;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.f150458aa = 0;
        this.f150459ab = 0;
        this.f150460ac = false;
        this.f150461ad = 0.0f;
        this.f150462ae = 0.0f;
        this.f150463af = 0.0f;
        this.f150464ag = 0.0f;
        this.f150465ah = false;
        this.f150466ai = 0.0f;
        this.f150467aj = 0.0f;
        this.f150468ak = 0.0f;
        this.f150469al = 0.0f;
    }

    private static long c() {
        return SystemClock.uptimeMillis();
    }

    private boolean d() {
        return this.f150488h;
    }

    private static float e(float f16) {
        return ((f16 % 360.0f) + 360.0f) % 360.0f;
    }

    private static float f(float f16) {
        return ((f16 % 360.0f) + 360.0f) % 360.0f;
    }

    private boolean g() {
        if (!this.N && !this.M && !this.O) {
            return false;
        }
        return true;
    }

    private float h() {
        return (float) this.P;
    }

    private boolean i() {
        return this.Q;
    }

    private int j() {
        return this.R;
    }

    private int k() {
        return this.S;
    }

    private boolean l() {
        return this.T;
    }

    private int m() {
        return this.f150458aa;
    }

    private int n() {
        return this.f150459ab;
    }

    private float o() {
        return this.f150464ag;
    }

    private boolean p() {
        return this.f150460ac;
    }

    private boolean q() {
        return this.f150465ah;
    }

    private float r() {
        return this.f150469al;
    }

    private void s() {
        this.f150487g = true;
    }

    private boolean t() {
        return this.f150487g;
    }

    public final void b(float f16) {
        if (f16 == 0.0f) {
            return;
        }
        this.f150479av = f16;
        this.N = true;
    }

    private void a(a aVar) {
        this.f150457a = aVar;
    }

    private void c(int i3, int i16) {
        if (i3 == 0 && i16 == 0) {
            this.f150488h = false;
        }
        this.I = i3;
        this.J = i16;
        this.f150488h = true;
    }

    private int e() {
        return this.K;
    }

    private int f() {
        return this.L;
    }

    public final void d(float f16) {
        this.f150466ai = f(f16);
        this.f150465ah = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0129, code lost:
    
        if (r0 > 1.0f) goto L69;
     */
    @Override // com.tencent.mapsdk.internal.jn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a() {
        float f16;
        a aVar;
        a aVar2;
        a aVar3;
        GeoPoint c16;
        if (!this.f150472ao) {
            this.f150472ao = true;
            if (this.f150488h) {
                this.f150475ar = 0;
                this.f150476as = 0;
            }
            if (this.M || this.N || this.O) {
                this.f150481ax = 1.0d / Math.pow(2.0d, 20.0f - this.f150457a.f());
            }
            if (this.M) {
                int i3 = this.f150457a.h() ? 22 : 20;
                a aVar4 = this.f150457a;
                if (aVar4 != null) {
                    i3 = Math.min(aVar4.b(), i3);
                }
                float f17 = i3;
                if (this.f150478au >= f17) {
                    this.f150478au = f17;
                }
                if (this.f150457a != null) {
                    if (Math.abs(this.f150478au - r0.f()) < 0.001d) {
                        this.f150477at = true;
                    }
                }
                this.f150480aw = 1.0d / Math.pow(2.0d, 20.0f - this.f150478au);
            } else if (this.N) {
                if (Math.abs(this.f150479av) < 0.001d) {
                    this.f150477at = true;
                }
                this.f150480aw = 1.0d / Math.pow(2.0d, 20.0f - (this.f150457a.f() + this.f150479av));
            }
            if (this.T && (aVar3 = this.f150457a) != null) {
                if (this.f150487g) {
                    c16 = aVar3.g();
                } else {
                    c16 = aVar3.c();
                }
                if (c16 != null) {
                    this.W = c16.getLatitudeE6();
                    int longitudeE6 = c16.getLongitudeE6();
                    this.X = longitudeE6;
                    this.Y = this.U - this.W;
                    this.Z = this.V - longitudeE6;
                }
            }
            if (this.f150460ac) {
                a aVar5 = this.f150457a;
                if (aVar5 != null) {
                    this.f150462ae = aVar5.d();
                }
                float f18 = this.f150461ad - this.f150462ae;
                this.f150463af = f18;
                if (f18 > 180.0f) {
                    this.f150463af = f18 - 360.0f;
                } else if (f18 < -180.0f) {
                    this.f150463af = f18 + 360.0f;
                }
            }
            if (this.f150465ah && (aVar2 = this.f150457a) != null) {
                float e16 = aVar2.e();
                this.f150467aj = e16;
                this.f150468ak = this.f150466ai - e16;
            }
            this.f150485e = SystemClock.uptimeMillis();
        }
        if (!this.f150474aq) {
            f16 = ((float) (SystemClock.uptimeMillis() - this.f150485e)) / ((float) this.f150484d);
        }
        f16 = 1.0f;
        float interpolation = this.f150473ap.getInterpolation(f16);
        this.f150474aq = true;
        if (this.f150488h) {
            int i16 = this.I;
            int i17 = (int) (i16 * interpolation);
            int i18 = (int) (this.J * interpolation);
            int i19 = i17 - this.f150475ar;
            int i26 = i18 - this.f150476as;
            this.f150475ar = i17;
            this.f150476as = i18;
            this.K = i19;
            this.L = i26;
            if (Math.abs(i16) > 0 || Math.abs(this.J) > 0) {
                this.f150474aq = false;
            }
        }
        if (this.M || this.N || this.O) {
            double d16 = this.f150481ax;
            this.P = d16 + ((this.f150480aw - d16) * interpolation);
            if (!this.f150477at) {
                this.f150474aq = false;
            }
        }
        if (this.T) {
            int i27 = this.W;
            int i28 = this.Y;
            this.f150458aa = i27 + ((int) (i28 * interpolation));
            this.f150459ab = this.X + ((int) (this.Z * interpolation));
            if (Math.abs(i28) > 1 || Math.abs(this.Z) > 1) {
                this.f150474aq = false;
            }
        }
        if (this.f150460ac) {
            float f19 = this.f150462ae;
            float f26 = this.f150463af;
            this.f150464ag = f19 + (f26 * interpolation);
            if (Math.abs(f26) > 1.0f) {
                this.f150474aq = false;
            }
        }
        if (this.f150465ah) {
            float f27 = this.f150467aj;
            float f28 = this.f150468ak;
            this.f150469al = f27 + (interpolation * f28);
            if (Math.abs(f28) > 1.0f) {
                this.f150474aq = false;
            }
        }
        if (f16 < 1.0f) {
            return false;
        }
        if (this.f150486f != null && (aVar = this.f150457a) != null) {
            aVar.a(this.f150470am);
        }
        return true;
    }

    public final void b(int i3, int i16) {
        this.U = i3;
        this.V = i16;
        this.T = true;
    }

    @Override // com.tencent.mapsdk.internal.jn
    public final void b() {
        a aVar;
        super.b();
        this.f150474aq = true;
        if (this.f150486f == null || (aVar = this.f150457a) == null) {
            return;
        }
        aVar.a(this.f150471an);
    }

    public final void c(float f16) {
        this.f150461ad = e(f16);
        this.f150460ac = true;
    }

    public final void a(float f16) {
        if (f16 <= 0.0f) {
            return;
        }
        this.f150478au = f16;
        this.M = true;
    }

    private void a(double d16) {
        this.f150480aw = d16;
        this.O = true;
    }

    public final void a(int i3, int i16) {
        this.R = i3;
        this.S = i16;
        this.Q = true;
    }

    private void a(TencentMap.CancelableCallback cancelableCallback) {
        this.f150486f = cancelableCallback;
    }

    public final void a(long j3) {
        this.f150484d = j3;
    }
}
