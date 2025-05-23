package h7;

import com.qzone.jbox2d.collision.ContactID;
import com.qzone.jbox2d.collision.Manifold;
import com.qzone.jbox2d.common.Transform;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public int f404468a;

    /* renamed from: b, reason: collision with root package name */
    public d f404469b;

    /* renamed from: c, reason: collision with root package name */
    public d f404470c;

    /* renamed from: d, reason: collision with root package name */
    public e f404471d;

    /* renamed from: e, reason: collision with root package name */
    public e f404472e;

    /* renamed from: h, reason: collision with root package name */
    public int f404475h;

    /* renamed from: i, reason: collision with root package name */
    public int f404476i;

    /* renamed from: k, reason: collision with root package name */
    public float f404478k;

    /* renamed from: l, reason: collision with root package name */
    public float f404479l;

    /* renamed from: m, reason: collision with root package name */
    public float f404480m;

    /* renamed from: n, reason: collision with root package name */
    public float f404481n;

    /* renamed from: o, reason: collision with root package name */
    public float f404482o;

    /* renamed from: p, reason: collision with root package name */
    protected final k7.b f404483p;

    /* renamed from: q, reason: collision with root package name */
    private final Manifold f404484q = new Manifold();

    /* renamed from: f, reason: collision with root package name */
    public com.qzone.jbox2d.dynamics.e f404473f = null;

    /* renamed from: g, reason: collision with root package name */
    public com.qzone.jbox2d.dynamics.e f404474g = null;

    /* renamed from: j, reason: collision with root package name */
    public final Manifold f404477j = new Manifold();

    /* JADX INFO: Access modifiers changed from: protected */
    public d(k7.b bVar) {
        this.f404471d = null;
        this.f404472e = null;
        this.f404471d = new e();
        this.f404472e = new e();
        this.f404483p = bVar;
    }

    public static final float l(float f16, float f17) {
        if (f16 <= f17) {
            return f17;
        }
        return f16;
    }

    public abstract void a(Manifold manifold, Transform transform, Transform transform2);

    public int b() {
        return this.f404475h;
    }

    public int c() {
        return this.f404476i;
    }

    public com.qzone.jbox2d.dynamics.e d() {
        return this.f404473f;
    }

    public com.qzone.jbox2d.dynamics.e e() {
        return this.f404474g;
    }

    public Manifold f() {
        return this.f404477j;
    }

    public d g() {
        return this.f404470c;
    }

    public boolean i() {
        return (this.f404468a & 4) == 4;
    }

    public boolean j() {
        return (this.f404468a & 2) == 2;
    }

    public void n(f7.c cVar) {
        boolean z16;
        this.f404484q.a(this.f404477j);
        int i3 = this.f404468a | 4;
        this.f404468a = i3;
        boolean z17 = (i3 & 2) == 2;
        boolean z18 = this.f404473f.k() || this.f404474g.k();
        com.qzone.jbox2d.dynamics.a f16 = this.f404473f.f();
        com.qzone.jbox2d.dynamics.a f17 = this.f404474g.f();
        Transform k3 = f16.k();
        Transform k16 = f17.k();
        if (z18) {
            z16 = this.f404483p.getCollision().i(this.f404473f.i(), this.f404475h, this.f404474g.i(), this.f404476i, k3, k16);
            this.f404477j.f47963e = 0;
        } else {
            a(this.f404477j, k3, k16);
            boolean z19 = this.f404477j.f47963e > 0;
            int i16 = 0;
            while (true) {
                Manifold manifold = this.f404477j;
                if (i16 >= manifold.f47963e) {
                    break;
                }
                com.qzone.jbox2d.collision.e eVar = manifold.f47959a[i16];
                eVar.f48040b = 0.0f;
                eVar.f48041c = 0.0f;
                ContactID contactID = eVar.f48042d;
                int i17 = 0;
                while (true) {
                    Manifold manifold2 = this.f404484q;
                    if (i17 < manifold2.f47963e) {
                        com.qzone.jbox2d.collision.e eVar2 = manifold2.f47959a[i17];
                        if (eVar2.f48042d.j(contactID)) {
                            eVar.f48040b = eVar2.f48040b;
                            eVar.f48041c = eVar2.f48041c;
                            break;
                        }
                        i17++;
                    }
                }
                i16++;
            }
            if (z19 != z17) {
                f16.r(true);
                f17.r(true);
            }
            z16 = z19;
        }
        if (z16) {
            this.f404468a = 2 | this.f404468a;
        } else {
            this.f404468a &= -3;
        }
        if (cVar == null) {
            return;
        }
        if (!z17 && z16) {
            cVar.b(this);
        }
        if (z17 && !z16) {
            cVar.a(this);
        }
        if (z18 || !z16) {
            return;
        }
        cVar.c(this, this.f404484q);
    }

    public static final float k(float f16, float f17) {
        return com.qzone.jbox2d.common.b.p(f16 * f17);
    }

    public void h(com.qzone.jbox2d.dynamics.e eVar, int i3, com.qzone.jbox2d.dynamics.e eVar2, int i16) {
        this.f404468a = 4;
        this.f404473f = eVar;
        this.f404474g = eVar2;
        this.f404475h = i3;
        this.f404476i = i16;
        this.f404477j.f47963e = 0;
        this.f404469b = null;
        this.f404470c = null;
        e eVar3 = this.f404471d;
        eVar3.f404486b = null;
        eVar3.f404487c = null;
        eVar3.f404488d = null;
        eVar3.f404485a = null;
        e eVar4 = this.f404472e;
        eVar4.f404486b = null;
        eVar4.f404487c = null;
        eVar4.f404488d = null;
        eVar4.f404485a = null;
        this.f404478k = 0.0f;
        this.f404480m = k(eVar.f48212e, eVar2.f48212e);
        this.f404481n = l(eVar.f48213f, eVar2.f48213f);
        this.f404482o = 0.0f;
    }

    public void m(boolean z16) {
        if (z16) {
            this.f404468a |= 4;
        } else {
            this.f404468a &= -5;
        }
    }
}
