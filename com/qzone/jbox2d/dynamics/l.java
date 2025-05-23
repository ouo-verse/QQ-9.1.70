package com.qzone.jbox2d.dynamics;

import com.qzone.jbox2d.collision.TimeOfImpact;
import com.qzone.jbox2d.collision.shapes.ShapeType;
import com.qzone.jbox2d.common.Sweep;
import com.qzone.jbox2d.common.Transform;
import com.qzone.jbox2d.common.Vec2;
import java.lang.reflect.Array;

/* compiled from: P */
/* loaded from: classes39.dex */
public class l {
    private static Integer Y = new Integer(1234598372);
    private final l7.a A;
    private final m B;
    private final n C;
    private final com.qzone.jbox2d.collision.f D;
    private final h E;
    private a[] F;
    private final com.qzone.jbox2d.common.e G;
    private final h H;
    private final TimeOfImpact.a I;
    private final TimeOfImpact.b J;
    private final k K;
    private final a[] L;
    private final Sweep M;
    private final Sweep N;
    private float O;
    private float P;
    private final Vec2 Q;
    private final Vec2 R;
    private final com.qzone.jbox2d.common.a S;
    private final Vec2 T;
    private final Vec2 U;
    private final Vec2 V;
    private final Vec2 W;
    private final l7.a X;

    /* renamed from: a, reason: collision with root package name */
    public int f48275a;

    /* renamed from: b, reason: collision with root package name */
    public int f48276b;

    /* renamed from: c, reason: collision with root package name */
    protected int f48277c;

    /* renamed from: d, reason: collision with root package name */
    protected c f48278d;

    /* renamed from: e, reason: collision with root package name */
    private a f48279e;

    /* renamed from: f, reason: collision with root package name */
    private i7.a f48280f;

    /* renamed from: g, reason: collision with root package name */
    private int f48281g;

    /* renamed from: h, reason: collision with root package name */
    private int f48282h;

    /* renamed from: i, reason: collision with root package name */
    private final Vec2 f48283i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f48284j;

    /* renamed from: k, reason: collision with root package name */
    private final k7.b f48285k;

    /* renamed from: l, reason: collision with root package name */
    private float f48286l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f48287m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f48288n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f48289o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f48290p;

    /* renamed from: q, reason: collision with root package name */
    private i f48291q;

    /* renamed from: r, reason: collision with root package name */
    private j7.f f48292r;

    /* renamed from: s, reason: collision with root package name */
    private h7.g[][] f48293s;

    /* renamed from: t, reason: collision with root package name */
    private final k f48294t;

    /* renamed from: u, reason: collision with root package name */
    private final com.qzone.jbox2d.common.e f48295u;

    /* renamed from: v, reason: collision with root package name */
    private final com.qzone.jbox2d.common.e f48296v;

    /* renamed from: w, reason: collision with root package name */
    private final com.qzone.jbox2d.common.a f48297w;

    /* renamed from: x, reason: collision with root package name */
    private final Transform f48298x;

    /* renamed from: y, reason: collision with root package name */
    private final Vec2 f48299y;

    /* renamed from: z, reason: collision with root package name */
    private final Vec2 f48300z;

    public l(Vec2 vec2) {
        this(vec2, new m7.a(100, 10));
    }

    private void a(k7.a<h7.d> aVar, ShapeType shapeType, ShapeType shapeType2) {
        h7.g gVar = new h7.g();
        gVar.f404504a = aVar;
        gVar.f404505b = true;
        this.f48293s[shapeType.ordinal()][shapeType2.ordinal()] = gVar;
        if (shapeType != shapeType2) {
            h7.g gVar2 = new h7.g();
            gVar2.f404504a = aVar;
            gVar2.f404505b = false;
            this.f48293s[shapeType2.ordinal()][shapeType.ordinal()] = gVar2;
        }
    }

    private void h() {
        k7.a<h7.d> circleContactStack = this.f48285k.getCircleContactStack();
        ShapeType shapeType = ShapeType.CIRCLE;
        a(circleContactStack, shapeType, shapeType);
        k7.a<h7.d> polyCircleContactStack = this.f48285k.getPolyCircleContactStack();
        ShapeType shapeType2 = ShapeType.POLYGON;
        a(polyCircleContactStack, shapeType2, shapeType);
        a(this.f48285k.getPolyContactStack(), shapeType2, shapeType2);
        k7.a<h7.d> edgeCircleContactStack = this.f48285k.getEdgeCircleContactStack();
        ShapeType shapeType3 = ShapeType.EDGE;
        a(edgeCircleContactStack, shapeType3, shapeType);
        a(this.f48285k.getEdgePolyContactStack(), shapeType3, shapeType2);
        k7.a<h7.d> chainCircleContactStack = this.f48285k.getChainCircleContactStack();
        ShapeType shapeType4 = ShapeType.CHAIN;
        a(chainCircleContactStack, shapeType4, shapeType);
        a(this.f48285k.getChainPolyContactStack(), shapeType4, shapeType2);
    }

    private void n(k kVar) {
        this.f48291q.f48256f.d();
        this.f48291q.f48257g.d();
        this.f48291q.f48258h.d();
        for (a aVar = this.f48279e; aVar != null; aVar = aVar.f48172m) {
            aVar.f48164e.set(aVar.f48163d);
        }
        h hVar = this.E;
        int i3 = this.f48281g;
        c cVar = this.f48278d;
        int i16 = cVar.f48202c;
        int i17 = this.f48282h;
        cVar.getClass();
        hVar.d(i3, i16, i17, null);
        for (a aVar2 = this.f48279e; aVar2 != null; aVar2 = aVar2.f48172m) {
            aVar2.f48161b &= -2;
        }
        for (h7.d dVar = this.f48278d.f48201b; dVar != null; dVar = dVar.f404470c) {
            dVar.f404468a &= -2;
        }
        for (i7.a aVar3 = this.f48280f; aVar3 != null; aVar3 = aVar3.f407326a) {
            aVar3.f407327b = false;
        }
        int i18 = this.f48281g;
        if (this.F.length < i18) {
            this.F = new a[i18];
        }
        for (a aVar4 = this.f48279e; aVar4 != null; aVar4 = aVar4.f48172m) {
            if ((aVar4.f48161b & 1) != 1 && aVar4.o() && aVar4.n() && aVar4.l() != BodyType.STATIC) {
                this.E.c();
                this.F[0] = aVar4;
                aVar4.f48161b |= 1;
                int i19 = 1;
                while (i19 > 0) {
                    i19--;
                    a aVar5 = this.F[i19];
                    this.E.a(aVar5);
                    aVar5.r(true);
                    if (aVar5.l() != BodyType.STATIC) {
                        for (h7.e eVar = aVar5.f48175p; eVar != null; eVar = eVar.f404488d) {
                            h7.d dVar2 = eVar.f404486b;
                            if ((dVar2.f404468a & 1) != 1 && dVar2.i() && dVar2.j()) {
                                boolean z16 = dVar2.f404473f.f48217j;
                                boolean z17 = dVar2.f404474g.f48217j;
                                if (!z16 && !z17) {
                                    this.E.b(dVar2);
                                    dVar2.f404468a |= 1;
                                    a aVar6 = eVar.f404485a;
                                    int i26 = aVar6.f48161b;
                                    if ((i26 & 1) != 1) {
                                        this.F[i19] = aVar6;
                                        aVar6.f48161b = i26 | 1;
                                        i19++;
                                    }
                                }
                            }
                        }
                    }
                }
                this.E.f(this.f48291q, kVar, this.f48283i, this.f48284j);
                int i27 = 0;
                while (true) {
                    h hVar2 = this.E;
                    if (i27 < hVar2.f48238f) {
                        a aVar7 = hVar2.f48233a[i27];
                        if (aVar7.l() == BodyType.STATIC) {
                            aVar7.f48161b &= -2;
                        }
                        i27++;
                    }
                }
            }
        }
        this.f48291q.f48256f.b();
        this.f48291q.f48257g.b();
        this.f48291q.f48258h.b();
        this.G.b();
        for (a aVar8 = this.f48279e; aVar8 != null; aVar8 = aVar8.i()) {
            if ((aVar8.f48161b & 1) != 0 && aVar8.l() != BodyType.STATIC) {
                aVar8.u();
            }
        }
        this.f48278d.c();
        this.f48291q.f48259i.c(this.G.a());
    }

    public void b() {
        for (a aVar = this.f48279e; aVar != null; aVar = aVar.i()) {
            aVar.f48168i.setZero();
            aVar.f48169j = 0.0f;
        }
    }

    public a c(b bVar) {
        if (i()) {
            return null;
        }
        a aVar = new a(bVar, this);
        aVar.f48171l = null;
        a aVar2 = this.f48279e;
        aVar.f48172m = aVar2;
        if (aVar2 != null) {
            aVar2.f48171l = aVar;
        }
        this.f48279e = aVar;
        this.f48281g++;
        return aVar;
    }

    public void d(a aVar) {
        if (i()) {
            return;
        }
        aVar.getClass();
        h7.e eVar = aVar.f48175p;
        while (eVar != null) {
            h7.e eVar2 = eVar.f404488d;
            this.f48278d.b(eVar.f404486b);
            eVar = eVar2;
        }
        aVar.f48175p = null;
        e eVar3 = aVar.f48173n;
        while (eVar3 != null) {
            e eVar4 = eVar3.f48209b;
            eVar3.d(this.f48278d.f48200a);
            eVar3.c();
            aVar.f48173n = eVar4;
            aVar.f48174o--;
            eVar3 = eVar4;
        }
        aVar.f48173n = null;
        aVar.f48174o = 0;
        a aVar2 = aVar.f48171l;
        if (aVar2 != null) {
            aVar2.f48172m = aVar.f48172m;
        }
        a aVar3 = aVar.f48172m;
        if (aVar3 != null) {
            aVar3.f48171l = aVar2;
        }
        if (aVar == this.f48279e) {
            this.f48279e = aVar3;
        }
        this.f48281g--;
    }

    public Vec2 e() {
        return this.f48283i;
    }

    public f7.e f() {
        return null;
    }

    public k7.b g() {
        return this.f48285k;
    }

    public boolean i() {
        return (this.f48277c & 2) == 2;
    }

    public h7.d j(e eVar, int i3, e eVar2, int i16) {
        h7.g gVar = this.f48293s[eVar.j().ordinal()][eVar2.j().ordinal()];
        if (gVar == null) {
            return null;
        }
        if (gVar.f404505b) {
            h7.d pop = gVar.f404504a.pop();
            pop.h(eVar, i3, eVar2, i16);
            return pop;
        }
        h7.d pop2 = gVar.f404504a.pop();
        pop2.h(eVar2, i16, eVar, i3);
        return pop2;
    }

    public void k(h7.d dVar) {
        e d16 = dVar.d();
        e e16 = dVar.e();
        if (dVar.f404477j.f47963e > 0 && !d16.k() && !e16.k()) {
            d16.f().r(true);
            e16.f().r(true);
        }
        this.f48293s[d16.j().ordinal()][e16.j().ordinal()].f404504a.push(dVar);
    }

    public void l(f7.f fVar, com.qzone.jbox2d.collision.a aVar) {
        m mVar = this.B;
        g7.a aVar2 = this.f48278d.f48200a;
        mVar.f48301a = aVar2;
        mVar.f48302b = fVar;
        aVar2.a(mVar, aVar);
    }

    public void m(Vec2 vec2) {
        this.f48283i.set(vec2);
    }

    public void p(float f16, int i3, int i16) {
        this.f48295u.b();
        this.f48296v.b();
        if ((this.f48277c & 1) == 1) {
            this.f48278d.c();
            this.f48277c &= -2;
        }
        this.f48277c |= 2;
        k kVar = this.f48294t;
        kVar.f48269a = f16;
        kVar.f48272d = i3;
        kVar.f48273e = i16;
        if (f16 > 0.0f) {
            kVar.f48270b = 1.0f / f16;
        } else {
            kVar.f48270b = 0.0f;
        }
        kVar.f48271c = this.f48286l * f16;
        kVar.f48274f = this.f48287m;
        this.f48291q.f48252b.c(this.f48296v.a());
        this.f48296v.b();
        this.f48278d.a();
        this.f48291q.f48253c.c(this.f48296v.a());
        if (this.f48290p && this.f48294t.f48269a > 0.0f) {
            this.f48296v.b();
            this.f48292r.k(this.f48294t);
            this.f48291q.f48254d.c(this.f48296v.a());
            this.f48296v.b();
            n(this.f48294t);
            this.f48291q.f48255e.c(this.f48296v.a());
        }
        if (this.f48288n && this.f48294t.f48269a > 0.0f) {
            this.f48296v.b();
            o(this.f48294t);
            this.f48291q.f48260j.c(this.f48296v.a());
        }
        k kVar2 = this.f48294t;
        if (kVar2.f48269a > 0.0f) {
            this.f48286l = kVar2.f48270b;
        }
        if ((this.f48277c & 4) == 4) {
            b();
        }
        this.f48277c &= -3;
        this.f48291q.f48251a.c(this.f48295u.a());
    }

    public l(Vec2 vec2, k7.b bVar) {
        this(vec2, bVar, new g7.d());
    }

    public l(Vec2 vec2, k7.b bVar, g7.b bVar2) {
        this(vec2, bVar, new g7.c(bVar2));
    }

    public l(Vec2 vec2, k7.b bVar, g7.a aVar) {
        this.f48275a = 0;
        this.f48276b = 0;
        Vec2 vec22 = new Vec2();
        this.f48283i = vec22;
        this.f48293s = (h7.g[][]) Array.newInstance((Class<?>) h7.g.class, ShapeType.values().length, ShapeType.values().length);
        this.f48294t = new k();
        this.f48295u = new com.qzone.jbox2d.common.e();
        this.f48296v = new com.qzone.jbox2d.common.e();
        this.f48297w = new com.qzone.jbox2d.common.a();
        this.f48298x = new Transform();
        this.f48299y = new Vec2();
        this.f48300z = new Vec2();
        this.A = new l7.a();
        this.B = new m();
        this.C = new n();
        this.D = new com.qzone.jbox2d.collision.f();
        this.E = new h();
        this.F = new a[10];
        this.G = new com.qzone.jbox2d.common.e();
        this.H = new h();
        this.I = new TimeOfImpact.a();
        this.J = new TimeOfImpact.b();
        this.K = new k();
        this.L = new a[2];
        this.M = new Sweep();
        this.N = new Sweep();
        this.O = 0.12f;
        this.P = -1.0f;
        this.Q = new Vec2();
        this.R = new Vec2();
        this.S = new com.qzone.jbox2d.common.a(0.4f, 0.4f, 1.0f);
        this.T = new Vec2();
        this.U = new Vec2();
        this.V = new Vec2();
        this.W = new Vec2();
        this.X = new l7.a();
        this.f48285k = bVar;
        this.f48279e = null;
        this.f48280f = null;
        this.f48281g = 0;
        this.f48282h = 0;
        this.f48287m = true;
        this.f48288n = true;
        this.f48289o = false;
        this.f48290p = true;
        this.f48284j = true;
        vec22.set(vec2);
        this.f48277c = 4;
        this.f48286l = 0.0f;
        this.f48278d = new c(this, aVar);
        this.f48291q = new i();
        this.f48292r = new j7.f(this);
        h();
    }

    /* JADX WARN: Code restructure failed: missing block: B:162:0x02e9, code lost:
    
        r18.f48290p = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x02ec, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void o(k kVar) {
        float l3;
        h hVar = this.H;
        int i3 = com.qzone.jbox2d.common.d.f48149q;
        this.f48278d.getClass();
        h7.d dVar = null;
        hVar.d(i3 * 2, i3, 0, null);
        if (this.f48290p) {
            for (a aVar = this.f48279e; aVar != null; aVar = aVar.f48172m) {
                aVar.f48161b &= -2;
                aVar.f48165f.alpha0 = 0.0f;
            }
            for (h7.d dVar2 = this.f48278d.f48201b; dVar2 != null; dVar2 = dVar2.f404470c) {
                dVar2.f404468a &= -34;
                dVar2.f404478k = 0.0f;
                dVar2.f404479l = 1.0f;
            }
        }
        while (true) {
            float f16 = 1.0f;
            h7.d dVar3 = dVar;
            for (h7.d dVar4 = this.f48278d.f48201b; dVar4 != null; dVar4 = dVar4.f404470c) {
                if (dVar4.i() && dVar4.f404478k <= com.qzone.jbox2d.common.d.f48148p) {
                    if ((dVar4.f404468a & 32) != 0) {
                        l3 = dVar4.f404479l;
                    } else {
                        e d16 = dVar4.d();
                        e e16 = dVar4.e();
                        if (!d16.k() && !e16.k()) {
                            a f17 = d16.f();
                            a f18 = e16.f();
                            BodyType bodyType = f17.f48160a;
                            BodyType bodyType2 = f18.f48160a;
                            boolean z16 = f17.o() && bodyType != BodyType.STATIC;
                            boolean z17 = f18.o() && bodyType2 != BodyType.STATIC;
                            if (z16 || z17) {
                                boolean z18 = f17.p() || bodyType != BodyType.DYNAMIC;
                                boolean z19 = f18.p() || bodyType2 != BodyType.DYNAMIC;
                                if (z18 || z19) {
                                    Sweep sweep = f17.f48165f;
                                    float f19 = sweep.alpha0;
                                    Sweep sweep2 = f18.f48165f;
                                    float f26 = sweep2.alpha0;
                                    if (f19 < f26) {
                                        sweep.advance(f26);
                                        f19 = f26;
                                    } else if (f26 < f19) {
                                        sweep2.advance(f19);
                                    }
                                    int b16 = dVar4.b();
                                    int c16 = dVar4.c();
                                    TimeOfImpact.a aVar2 = this.I;
                                    aVar2.f47979a.c(d16.i(), b16);
                                    aVar2.f47980b.c(e16.i(), c16);
                                    aVar2.f47981c.set(f17.f48165f);
                                    aVar2.f47982d.set(f18.f48165f);
                                    aVar2.f47983e = 1.0f;
                                    this.f48285k.getTimeOfImpact().a(this.J, aVar2);
                                    TimeOfImpact.b bVar = this.J;
                                    l3 = bVar.f47984a == TimeOfImpact.TOIOutputState.TOUCHING ? com.qzone.jbox2d.common.b.l(f19 + ((1.0f - f19) * bVar.f47985b), 1.0f) : 1.0f;
                                    dVar4.f404479l = l3;
                                    dVar4.f404468a |= 32;
                                }
                            }
                        }
                    }
                    if (l3 < f16) {
                        dVar3 = dVar4;
                        f16 = l3;
                    }
                }
            }
            if (dVar3 == null || 0.9999988f < f16) {
                break;
            }
            e d17 = dVar3.d();
            e e17 = dVar3.e();
            a f27 = d17.f();
            a f28 = e17.f();
            this.M.set(f27.f48165f);
            this.N.set(f28.f48165f);
            f27.a(f16);
            f28.a(f16);
            this.f48278d.getClass();
            dVar3.n(null);
            dVar3.f404468a &= -33;
            dVar3.f404478k += 1.0f;
            if (dVar3.i() && dVar3.j()) {
                f27.r(true);
                f28.r(true);
                hVar.c();
                hVar.a(f27);
                hVar.a(f28);
                hVar.b(dVar3);
                f27.f48161b |= 1;
                f28.f48161b |= 1;
                dVar3.f404468a |= 1;
                a[] aVarArr = this.L;
                aVarArr[0] = f27;
                aVarArr[1] = f28;
                for (int i16 = 0; i16 < 2; i16++) {
                    a aVar3 = this.L[i16];
                    if (aVar3.f48160a == BodyType.DYNAMIC) {
                        for (h7.e eVar = aVar3.f48175p; eVar != null && hVar.f48238f != hVar.f48241i && hVar.f48240h != hVar.f48242j; eVar = eVar.f404488d) {
                            h7.d dVar5 = eVar.f404486b;
                            if ((dVar5.f404468a & 1) == 0) {
                                a aVar4 = eVar.f404485a;
                                if (aVar4.f48160a != BodyType.DYNAMIC || aVar3.p() || aVar4.p()) {
                                    boolean z26 = dVar5.f404473f.f48217j;
                                    boolean z27 = dVar5.f404474g.f48217j;
                                    if (!z26 && !z27) {
                                        this.M.set(aVar4.f48165f);
                                        if ((aVar4.f48161b & 1) == 0) {
                                            aVar4.a(f16);
                                        }
                                        this.f48278d.getClass();
                                        dVar5.n(null);
                                        if (!dVar5.i()) {
                                            aVar4.f48165f.set(this.M);
                                            aVar4.v();
                                        } else if (!dVar5.j()) {
                                            aVar4.f48165f.set(this.M);
                                            aVar4.v();
                                        } else {
                                            dVar5.f404468a |= 1;
                                            hVar.b(dVar5);
                                            int i17 = aVar4.f48161b;
                                            if ((i17 & 1) == 0) {
                                                aVar4.f48161b = i17 | 1;
                                                if (aVar4.f48160a != BodyType.STATIC) {
                                                    aVar4.r(true);
                                                }
                                                hVar.a(aVar4);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                k kVar2 = this.K;
                float f29 = (1.0f - f16) * kVar.f48269a;
                kVar2.f48269a = f29;
                kVar2.f48270b = 1.0f / f29;
                kVar2.f48271c = 1.0f;
                kVar2.f48273e = 20;
                kVar2.f48272d = kVar.f48272d;
                kVar2.f48274f = false;
                hVar.g(kVar2, f27.f48162c, f28.f48162c);
                for (int i18 = 0; i18 < hVar.f48238f; i18++) {
                    a aVar5 = hVar.f48233a[i18];
                    aVar5.f48161b &= -2;
                    if (aVar5.f48160a == BodyType.DYNAMIC) {
                        aVar5.u();
                        for (h7.e eVar2 = aVar5.f48175p; eVar2 != null; eVar2 = eVar2.f404488d) {
                            eVar2.f404486b.f404468a &= -34;
                        }
                    }
                }
                this.f48278d.c();
                if (this.f48289o) {
                    this.f48290p = false;
                    return;
                }
                dVar = null;
            } else {
                dVar3.m(false);
                f27.f48165f.set(this.M);
                f28.f48165f.set(this.N);
                f27.v();
                f28.v();
                dVar = null;
            }
        }
    }
}
