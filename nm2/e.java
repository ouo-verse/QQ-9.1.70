package nm2;

import android.graphics.PointF;
import java.util.Random;
import km2.g;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e {
    private float C;
    private float D;
    private float E;
    private float F;
    private float G;
    private Object H;
    private g I;

    /* renamed from: a, reason: collision with root package name */
    private int f420468a;

    /* renamed from: b, reason: collision with root package name */
    private int f420469b;

    /* renamed from: c, reason: collision with root package name */
    private float f420470c;

    /* renamed from: d, reason: collision with root package name */
    private float f420471d;

    /* renamed from: e, reason: collision with root package name */
    private float f420472e;

    /* renamed from: f, reason: collision with root package name */
    private float f420473f;

    /* renamed from: g, reason: collision with root package name */
    private float f420474g;

    /* renamed from: h, reason: collision with root package name */
    private float f420475h;

    /* renamed from: i, reason: collision with root package name */
    private float f420476i;

    /* renamed from: z, reason: collision with root package name */
    private om2.g f420493z;

    /* renamed from: j, reason: collision with root package name */
    private float f420477j = 1.0f;

    /* renamed from: k, reason: collision with root package name */
    private float f420478k = 0.0f;

    /* renamed from: l, reason: collision with root package name */
    private float f420479l = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    private float f420480m = 0.0f;

    /* renamed from: n, reason: collision with root package name */
    private float f420481n = 0.0f;

    /* renamed from: o, reason: collision with root package name */
    private float f420482o = 0.0f;

    /* renamed from: p, reason: collision with root package name */
    private float f420483p = 0.0f;

    /* renamed from: q, reason: collision with root package name */
    private float f420484q = 0.0f;

    /* renamed from: r, reason: collision with root package name */
    private float f420485r = 0.0f;

    /* renamed from: s, reason: collision with root package name */
    private float f420486s = 0.0f;

    /* renamed from: t, reason: collision with root package name */
    private float f420487t = 0.0f;

    /* renamed from: u, reason: collision with root package name */
    private float f420488u = 0.0f;

    /* renamed from: v, reason: collision with root package name */
    private float f420489v = 0.0f;

    /* renamed from: w, reason: collision with root package name */
    private float f420490w = 0.0f;

    /* renamed from: x, reason: collision with root package name */
    private float f420491x = 0.0f;

    /* renamed from: y, reason: collision with root package name */
    private float f420492y = 1.0f;
    private final jm2.b A = new jm2.b();
    private int B = 1;
    private final Random J = new Random();

    public void A(float f16) {
        this.f420491x = f16;
    }

    public void B(float f16) {
        this.f420477j = f16;
    }

    public void C(float f16) {
        this.f420478k = f16;
    }

    public void D(float f16) {
        this.f420479l = f16;
    }

    public void E(float f16) {
        this.f420474g = f16;
    }

    public void F(float f16) {
        this.f420473f = f16;
    }

    public void G(float f16) {
        this.f420470c = f16;
        J();
    }

    public void H(float f16) {
        this.f420471d = f16;
        J();
    }

    public void I(Object obj) {
        this.H = obj;
    }

    void J() {
        float f16 = this.f420470c;
        if (f16 == 0.0f && this.f420471d == 0.0f) {
            this.f420472e = 0.0f;
            return;
        }
        if (f16 == 0.0f) {
            this.f420472e = Math.abs(this.f420471d);
            return;
        }
        if (this.f420471d == 0.0f) {
            this.f420472e = Math.abs(f16);
        } else {
            this.f420472e = (float) Math.sqrt((f16 * f16) + (r2 * r2));
        }
    }

    public com.tencent.mobileqq.richmedia.particlesystem.a a(int i3) {
        PointF b16 = b();
        PointF c16 = c();
        com.tencent.mobileqq.richmedia.particlesystem.a aVar = new com.tencent.mobileqq.richmedia.particlesystem.a(i3, this.f420468a, this.f420469b, b16.x, b16.y, this.E, c16.x, c16.y, this.f420475h, this.f420476i, this.f420492y, this.f420493z, f(), this.A.a(), this.I);
        aVar.f281691m = d(this.f420477j, this.f420478k);
        aVar.f281692n = this.f420479l;
        aVar.f281693o = d(this.f420480m, this.f420481n);
        aVar.f281694p = d(this.f420482o, this.f420483p);
        aVar.f281695q = d(this.f420484q, this.f420485r);
        aVar.f281696r = d(this.f420486s, this.f420489v);
        aVar.f281697s = d(this.f420487t, this.f420490w);
        aVar.f281698t = d(this.f420488u, this.f420491x);
        lm2.c.a("ParticleView", "create particle, position=" + b16.x + "," + b16.y);
        return aVar;
    }

    PointF b() {
        if (this.F == 0.0f && this.G == 0.0f) {
            return new PointF(this.C, this.D);
        }
        return new PointF((this.J.nextFloat() * this.F) + this.C, (this.J.nextFloat() * this.G) + this.D);
    }

    PointF c() {
        float f16 = this.f420472e;
        if (f16 == 0.0f) {
            return new PointF(0.0f, 0.0f);
        }
        double d16 = d(f16, this.f420473f);
        double d17 = d(e(), this.f420474g);
        return new PointF((float) (Math.sin(d17) * d16), (float) (d16 * Math.cos(d17)));
    }

    float d(float f16, float f17) {
        if (f17 == 0.0f) {
            return f16;
        }
        return f16 + (((this.J.nextFloat() * 2.0f) - 1.0f) * f17);
    }

    float e() {
        double d16;
        float f16 = this.f420470c;
        if (f16 == 0.0f && this.f420471d == 0.0f) {
            return 0.0f;
        }
        if (f16 == 0.0f && this.f420471d < 0.0f) {
            return -3.1415927f;
        }
        if (f16 == 0.0f && this.f420471d > 0.0f) {
            return 0.0f;
        }
        float f17 = this.f420471d;
        if (f17 == 0.0f && f16 < 0.0f) {
            return -1.5707964f;
        }
        if (f17 == 0.0f && f16 > 0.0f) {
            return 1.5707964f;
        }
        double atan = Math.atan(f16 / f17);
        if (atan > 0.0d) {
            if (this.f420470c > 0.0f) {
                return (float) atan;
            }
            d16 = 3.141592653589793d;
        } else if (this.f420470c > 0.0f) {
            d16 = 3.1415927410125732d;
        } else {
            return (float) atan;
        }
        return (float) (atan + d16);
    }

    public Object f() {
        return this.H;
    }

    public void g(float f16) {
        this.f420475h = f16;
    }

    public void h(float f16) {
        this.f420476i = f16;
    }

    public void i(g gVar) {
        this.I = gVar;
    }

    public void j(long j3) {
        this.A.f410607d = j3;
    }

    public void k(long j3) {
        this.A.f410606c = j3;
    }

    public void l(float f16, float f17, float f18, float f19, float f26) {
        this.C = f16;
        this.D = f17;
        this.E = f18;
        this.F = f19;
        this.G = f26;
    }

    public void m(om2.g gVar) {
        this.f420493z = gVar;
    }

    public void n(int i3) {
        this.f420469b = i3;
    }

    public void o(int i3) {
        this.f420468a = i3;
    }

    public void p(float f16) {
        this.f420480m = f16;
    }

    public void q(float f16) {
        this.f420481n = f16;
    }

    public void r(float f16) {
        this.f420486s = f16;
    }

    public void s(float f16) {
        this.f420489v = f16;
    }

    public void t(float f16) {
        this.f420482o = f16;
    }

    public void u(float f16) {
        this.f420483p = f16;
    }

    public void v(float f16) {
        this.f420487t = f16;
    }

    public void w(float f16) {
        this.f420490w = f16;
    }

    public void x(float f16) {
        this.f420484q = f16;
    }

    public void y(float f16) {
        this.f420485r = f16;
    }

    public void z(float f16) {
        this.f420488u = f16;
    }
}
