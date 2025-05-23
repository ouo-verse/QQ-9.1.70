package com.qzone.jbox2d.dynamics;

import com.qzone.jbox2d.common.Rot;
import com.qzone.jbox2d.common.Sweep;
import com.qzone.jbox2d.common.Transform;
import com.qzone.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {
    private final com.qzone.jbox2d.collision.shapes.d A;
    private final Transform B;

    /* renamed from: a, reason: collision with root package name */
    public BodyType f48160a;

    /* renamed from: b, reason: collision with root package name */
    public int f48161b;

    /* renamed from: c, reason: collision with root package name */
    public int f48162c;

    /* renamed from: d, reason: collision with root package name */
    public final Transform f48163d;

    /* renamed from: e, reason: collision with root package name */
    public final Transform f48164e;

    /* renamed from: f, reason: collision with root package name */
    public final Sweep f48165f;

    /* renamed from: g, reason: collision with root package name */
    public final Vec2 f48166g;

    /* renamed from: h, reason: collision with root package name */
    public float f48167h;

    /* renamed from: i, reason: collision with root package name */
    public final Vec2 f48168i;

    /* renamed from: j, reason: collision with root package name */
    public float f48169j;

    /* renamed from: k, reason: collision with root package name */
    public l f48170k;

    /* renamed from: l, reason: collision with root package name */
    public a f48171l;

    /* renamed from: m, reason: collision with root package name */
    public a f48172m;

    /* renamed from: n, reason: collision with root package name */
    public e f48173n;

    /* renamed from: o, reason: collision with root package name */
    public int f48174o;

    /* renamed from: p, reason: collision with root package name */
    public h7.e f48175p;

    /* renamed from: q, reason: collision with root package name */
    public float f48176q;

    /* renamed from: r, reason: collision with root package name */
    public float f48177r;

    /* renamed from: s, reason: collision with root package name */
    public float f48178s;

    /* renamed from: t, reason: collision with root package name */
    public float f48179t;

    /* renamed from: u, reason: collision with root package name */
    public float f48180u;

    /* renamed from: v, reason: collision with root package name */
    public float f48181v;

    /* renamed from: w, reason: collision with root package name */
    public float f48182w;

    /* renamed from: x, reason: collision with root package name */
    public float f48183x;

    /* renamed from: y, reason: collision with root package name */
    public Object f48184y;

    /* renamed from: z, reason: collision with root package name */
    private final f f48185z;

    public a(b bVar, l lVar) {
        Transform transform = new Transform();
        this.f48163d = transform;
        this.f48164e = new Transform();
        Sweep sweep = new Sweep();
        this.f48165f = sweep;
        Vec2 vec2 = new Vec2();
        this.f48166g = vec2;
        this.f48167h = 0.0f;
        Vec2 vec22 = new Vec2();
        this.f48168i = vec22;
        this.f48169j = 0.0f;
        this.f48185z = new f();
        this.A = new com.qzone.jbox2d.collision.shapes.d();
        this.B = new Transform();
        this.f48161b = 0;
        if (bVar.f48197l) {
            this.f48161b = 0 | 8;
        }
        if (bVar.f48196k) {
            this.f48161b |= 16;
        }
        if (bVar.f48194i) {
            this.f48161b |= 4;
        }
        if (bVar.f48195j) {
            this.f48161b |= 2;
        }
        if (bVar.f48198m) {
            this.f48161b |= 32;
        }
        this.f48170k = lVar;
        transform.f48117p.set(bVar.f48188c);
        transform.f48118q.set(bVar.f48189d);
        sweep.localCenter.setZero();
        sweep.f48115c0.set(transform.f48117p);
        sweep.f48114c.set(transform.f48117p);
        float f16 = bVar.f48189d;
        sweep.f48113a0 = f16;
        sweep.f48112a = f16;
        sweep.alpha0 = 0.0f;
        this.f48175p = null;
        this.f48171l = null;
        this.f48172m = null;
        vec2.set(bVar.f48190e);
        this.f48167h = bVar.f48191f;
        this.f48180u = bVar.f48192g;
        this.f48181v = bVar.f48193h;
        this.f48182w = bVar.f48199n;
        vec22.setZero();
        this.f48169j = 0.0f;
        this.f48183x = 0.0f;
        BodyType bodyType = bVar.f48186a;
        this.f48160a = bodyType;
        if (bodyType == BodyType.DYNAMIC) {
            this.f48176q = 1.0f;
            this.f48177r = 1.0f;
        } else {
            this.f48176q = 0.0f;
            this.f48177r = 0.0f;
        }
        this.f48178s = 0.0f;
        this.f48179t = 0.0f;
        this.f48184y = bVar.f48187b;
        this.f48173n = null;
        this.f48174o = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(float f16) {
        this.f48165f.advance(f16);
        Sweep sweep = this.f48165f;
        sweep.f48114c.set(sweep.f48115c0);
        Sweep sweep2 = this.f48165f;
        float f17 = sweep2.f48113a0;
        sweep2.f48112a = f17;
        this.f48163d.f48118q.set(f17);
        Transform transform = this.f48163d;
        Rot.mulToOutUnsafe(transform.f48118q, this.f48165f.localCenter, transform.f48117p);
        this.f48163d.f48117p.mulLocal(-1.0f).addLocal(this.f48165f.f48114c);
    }

    public final void b(Vec2 vec2, Vec2 vec22, boolean z16) {
        if (this.f48160a != BodyType.DYNAMIC) {
            return;
        }
        if (!o()) {
            if (!z16) {
                return;
            } else {
                r(true);
            }
        }
        Vec2 vec23 = this.f48166g;
        float f16 = vec23.f48119x;
        float f17 = vec2.f48119x;
        float f18 = this.f48177r;
        vec23.f48119x = f16 + (f17 * f18);
        vec23.f48120y += vec2.f48120y * f18;
        float f19 = this.f48167h;
        float f26 = this.f48179t;
        float f27 = vec22.f48119x;
        Vec2 vec24 = this.f48165f.f48114c;
        this.f48167h = f19 + (f26 * (((f27 - vec24.f48119x) * vec2.f48120y) - ((vec22.f48120y - vec24.f48120y) * vec2.f48119x)));
    }

    public final e c(f fVar) {
        if (this.f48170k.i()) {
            return null;
        }
        e eVar = new e();
        eVar.a(this, fVar);
        if ((this.f48161b & 32) == 32) {
            eVar.b(this.f48170k.f48278d.f48200a, this.f48163d);
        }
        eVar.f48209b = this.f48173n;
        this.f48173n = eVar;
        this.f48174o++;
        eVar.f48210c = this;
        if (eVar.f48208a > 0.0f) {
            q();
        }
        l lVar = this.f48170k;
        lVar.f48277c = 1 | lVar.f48277c;
        return eVar;
    }

    public final float d() {
        return this.f48165f.f48112a;
    }

    public final h7.e e() {
        return this.f48175p;
    }

    public final float f() {
        float f16 = this.f48178s;
        float f17 = this.f48176q;
        Vec2 vec2 = this.f48165f.localCenter;
        float f18 = vec2.f48119x;
        float f19 = vec2.f48120y;
        return f16 + (f17 * ((f18 * f18) + (f19 * f19)));
    }

    public final Vec2 g() {
        return this.f48165f.localCenter;
    }

    public final float h() {
        return this.f48176q;
    }

    public final a i() {
        return this.f48172m;
    }

    public final Vec2 j() {
        return this.f48163d.f48117p;
    }

    public final Transform k() {
        return this.f48163d;
    }

    public BodyType l() {
        return this.f48160a;
    }

    public final Vec2 m() {
        return this.f48165f.f48114c;
    }

    public boolean n() {
        return (this.f48161b & 32) == 32;
    }

    public boolean o() {
        return (this.f48161b & 2) == 2;
    }

    public final boolean p() {
        return (this.f48161b & 8) == 8;
    }

    public final void s(Vec2 vec2) {
        if (this.f48160a == BodyType.STATIC) {
            return;
        }
        if (Vec2.dot(vec2, vec2) > 0.0f) {
            r(true);
        }
        this.f48166g.set(vec2);
    }

    public boolean t(a aVar) {
        BodyType bodyType = this.f48160a;
        BodyType bodyType2 = BodyType.DYNAMIC;
        return bodyType == bodyType2 || aVar.f48160a == bodyType2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void u() {
        Transform transform = this.B;
        transform.f48118q.f48111s = com.qzone.jbox2d.common.b.n(this.f48165f.f48113a0);
        transform.f48118q.f48110c = com.qzone.jbox2d.common.b.d(this.f48165f.f48113a0);
        Vec2 vec2 = transform.f48117p;
        Sweep sweep = this.f48165f;
        Vec2 vec22 = sweep.f48115c0;
        float f16 = vec22.f48119x;
        Rot rot = transform.f48118q;
        float f17 = rot.f48110c;
        Vec2 vec23 = sweep.localCenter;
        float f18 = f16 - (vec23.f48119x * f17);
        float f19 = rot.f48111s;
        float f26 = vec23.f48120y;
        vec2.f48119x = f18 + (f19 * f26);
        vec2.f48120y = (vec22.f48120y - (f19 * vec23.f48119x)) - (f17 * f26);
        for (e eVar = this.f48173n; eVar != null; eVar = eVar.f48209b) {
            eVar.l(this.f48170k.f48278d.f48200a, transform, this.f48163d);
        }
    }

    public final void v() {
        this.f48163d.f48118q.f48111s = com.qzone.jbox2d.common.b.n(this.f48165f.f48112a);
        this.f48163d.f48118q.f48110c = com.qzone.jbox2d.common.b.d(this.f48165f.f48112a);
        Transform transform = this.f48163d;
        Rot rot = transform.f48118q;
        Sweep sweep = this.f48165f;
        Vec2 vec2 = sweep.localCenter;
        Vec2 vec22 = transform.f48117p;
        Vec2 vec23 = sweep.f48114c;
        float f16 = vec23.f48119x;
        float f17 = rot.f48110c;
        float f18 = f16 - (vec2.f48119x * f17);
        float f19 = rot.f48111s;
        float f26 = vec2.f48120y;
        vec22.f48119x = f18 + (f19 * f26);
        vec22.f48120y = (vec23.f48120y - (f19 * vec2.f48119x)) - (f17 * f26);
    }

    public final void q() {
        this.f48176q = 0.0f;
        this.f48177r = 0.0f;
        this.f48178s = 0.0f;
        this.f48179t = 0.0f;
        this.f48165f.localCenter.setZero();
        BodyType bodyType = this.f48160a;
        if (bodyType != BodyType.STATIC && bodyType != BodyType.KINEMATIC) {
            Vec2 popVec2 = this.f48170k.g().popVec2();
            popVec2.setZero();
            Vec2 popVec22 = this.f48170k.g().popVec2();
            com.qzone.jbox2d.collision.shapes.d dVar = this.A;
            for (e eVar = this.f48173n; eVar != null; eVar = eVar.f48209b) {
                if (eVar.f48208a != 0.0f) {
                    eVar.h(dVar);
                    this.f48176q += dVar.f48091a;
                    popVec22.set(dVar.f48092b).mulLocal(dVar.f48091a);
                    popVec2.addLocal(popVec22);
                    this.f48178s += dVar.f48093c;
                }
            }
            float f16 = this.f48176q;
            if (f16 > 0.0f) {
                float f17 = 1.0f / f16;
                this.f48177r = f17;
                popVec2.mulLocal(f17);
            } else {
                this.f48176q = 1.0f;
                this.f48177r = 1.0f;
            }
            float f18 = this.f48178s;
            if (f18 > 0.0f && (this.f48161b & 16) == 0) {
                float dot = f18 - (this.f48176q * Vec2.dot(popVec2, popVec2));
                this.f48178s = dot;
                this.f48179t = 1.0f / dot;
            } else {
                this.f48178s = 0.0f;
                this.f48179t = 0.0f;
            }
            Vec2 popVec23 = this.f48170k.g().popVec2();
            popVec23.set(this.f48165f.f48114c);
            this.f48165f.localCenter.set(popVec2);
            Transform transform = this.f48163d;
            Sweep sweep = this.f48165f;
            Transform.mulToOutUnsafe(transform, sweep.localCenter, sweep.f48115c0);
            Sweep sweep2 = this.f48165f;
            sweep2.f48114c.set(sweep2.f48115c0);
            popVec22.set(this.f48165f.f48114c).subLocal(popVec23);
            Vec2.crossToOutUnsafe(this.f48167h, popVec22, popVec23);
            this.f48166g.addLocal(popVec23);
            this.f48170k.g().pushVec2(3);
            return;
        }
        this.f48165f.f48115c0.set(this.f48163d.f48117p);
        this.f48165f.f48114c.set(this.f48163d.f48117p);
        Sweep sweep3 = this.f48165f;
        sweep3.f48113a0 = sweep3.f48112a;
    }

    public void r(boolean z16) {
        if (z16) {
            int i3 = this.f48161b;
            if ((i3 & 2) == 0) {
                this.f48161b = i3 | 2;
                this.f48183x = 0.0f;
                return;
            }
            return;
        }
        this.f48161b &= -3;
        this.f48183x = 0.0f;
        this.f48166g.setZero();
        this.f48167h = 0.0f;
        this.f48168i.setZero();
        this.f48169j = 0.0f;
    }
}
