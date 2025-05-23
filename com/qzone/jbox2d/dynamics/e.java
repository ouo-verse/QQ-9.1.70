package com.qzone.jbox2d.dynamics;

import com.qzone.jbox2d.collision.shapes.ShapeType;
import com.qzone.jbox2d.common.Transform;
import com.qzone.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public float f48208a;

    /* renamed from: e, reason: collision with root package name */
    public float f48212e;

    /* renamed from: f, reason: collision with root package name */
    public float f48213f;

    /* renamed from: j, reason: collision with root package name */
    public boolean f48217j;

    /* renamed from: l, reason: collision with root package name */
    private final com.qzone.jbox2d.collision.a f48219l = new com.qzone.jbox2d.collision.a();

    /* renamed from: m, reason: collision with root package name */
    private final com.qzone.jbox2d.collision.a f48220m = new com.qzone.jbox2d.collision.a();

    /* renamed from: n, reason: collision with root package name */
    private final Vec2 f48221n = new Vec2();

    /* renamed from: k, reason: collision with root package name */
    public Object f48218k = null;

    /* renamed from: c, reason: collision with root package name */
    public a f48210c = null;

    /* renamed from: b, reason: collision with root package name */
    public e f48209b = null;

    /* renamed from: g, reason: collision with root package name */
    public g[] f48214g = null;

    /* renamed from: h, reason: collision with root package name */
    public int f48215h = 0;

    /* renamed from: d, reason: collision with root package name */
    public com.qzone.jbox2d.collision.shapes.f f48211d = null;

    /* renamed from: i, reason: collision with root package name */
    public final d f48216i = new d();

    public void a(a aVar, f fVar) {
        this.f48218k = fVar.f48223b;
        this.f48212e = fVar.f48224c;
        this.f48213f = fVar.f48225d;
        this.f48210c = aVar;
        this.f48209b = null;
        this.f48216i.a(fVar.f48228g);
        this.f48217j = fVar.f48227f;
        com.qzone.jbox2d.collision.shapes.f a16 = fVar.f48222a.a();
        this.f48211d = a16;
        int d16 = a16.d();
        if (this.f48214g == null) {
            this.f48214g = new g[d16];
            for (int i3 = 0; i3 < d16; i3++) {
                this.f48214g[i3] = new g();
                g gVar = this.f48214g[i3];
                gVar.f48230b = null;
                gVar.f48232d = -1;
            }
        }
        g[] gVarArr = this.f48214g;
        if (gVarArr.length < d16) {
            int k3 = com.qzone.jbox2d.common.b.k(gVarArr.length * 2, d16);
            g[] gVarArr2 = new g[k3];
            this.f48214g = gVarArr2;
            System.arraycopy(gVarArr, 0, gVarArr2, 0, gVarArr.length);
            for (int i16 = 0; i16 < k3; i16++) {
                if (i16 >= gVarArr.length) {
                    this.f48214g[i16] = new g();
                }
                g gVar2 = this.f48214g[i16];
                gVar2.f48230b = null;
                gVar2.f48232d = -1;
            }
        }
        this.f48215h = 0;
        this.f48208a = fVar.f48226e;
    }

    public void b(g7.a aVar, Transform transform) {
        this.f48215h = this.f48211d.d();
        for (int i3 = 0; i3 < this.f48215h; i3++) {
            g gVar = this.f48214g[i3];
            this.f48211d.b(gVar.f48229a, transform, i3);
            gVar.f48232d = aVar.c(gVar.f48229a, gVar);
            gVar.f48230b = this;
            gVar.f48231c = i3;
        }
    }

    public com.qzone.jbox2d.collision.a e(int i3) {
        return this.f48214g[i3].f48229a;
    }

    public a f() {
        return this.f48210c;
    }

    public d g() {
        return this.f48216i;
    }

    public void h(com.qzone.jbox2d.collision.shapes.d dVar) {
        this.f48211d.c(dVar, this.f48208a);
    }

    public com.qzone.jbox2d.collision.shapes.f i() {
        return this.f48211d;
    }

    public ShapeType j() {
        return this.f48211d.f();
    }

    public boolean k() {
        return this.f48217j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(g7.a aVar, Transform transform, Transform transform2) {
        if (this.f48215h == 0) {
            return;
        }
        for (int i3 = 0; i3 < this.f48215h; i3++) {
            g gVar = this.f48214g[i3];
            com.qzone.jbox2d.collision.a aVar2 = this.f48219l;
            com.qzone.jbox2d.collision.a aVar3 = this.f48220m;
            this.f48211d.b(aVar2, transform, gVar.f48231c);
            this.f48211d.b(aVar3, transform2, gVar.f48231c);
            com.qzone.jbox2d.collision.a aVar4 = gVar.f48229a;
            Vec2 vec2 = aVar4.f47986a;
            Vec2 vec22 = aVar2.f47986a;
            float f16 = vec22.f48119x;
            Vec2 vec23 = aVar3.f47986a;
            float f17 = vec23.f48119x;
            if (f16 >= f17) {
                f16 = f17;
            }
            vec2.f48119x = f16;
            float f18 = vec22.f48120y;
            float f19 = vec23.f48120y;
            if (f18 >= f19) {
                f18 = f19;
            }
            vec2.f48120y = f18;
            Vec2 vec24 = aVar4.f47987b;
            Vec2 vec25 = aVar2.f47987b;
            float f26 = vec25.f48119x;
            Vec2 vec26 = aVar3.f47987b;
            float f27 = vec26.f48119x;
            if (f26 <= f27) {
                f26 = f27;
            }
            vec24.f48119x = f26;
            float f28 = vec25.f48120y;
            float f29 = vec26.f48120y;
            if (f28 <= f29) {
                f28 = f29;
            }
            vec24.f48120y = f28;
            Vec2 vec27 = this.f48221n;
            Vec2 vec28 = transform2.f48117p;
            float f36 = vec28.f48119x;
            Vec2 vec29 = transform.f48117p;
            vec27.f48119x = f36 - vec29.f48119x;
            vec27.f48120y = vec28.f48120y - vec29.f48120y;
            aVar.b(gVar.f48232d, aVar4, vec27);
        }
    }

    public void c() {
        this.f48211d = null;
        this.f48214g = null;
        this.f48209b = null;
    }

    public void d(g7.a aVar) {
        for (int i3 = 0; i3 < this.f48215h; i3++) {
            g gVar = this.f48214g[i3];
            aVar.destroyProxy(gVar.f48232d);
            gVar.f48232d = -1;
        }
        this.f48215h = 0;
    }
}
