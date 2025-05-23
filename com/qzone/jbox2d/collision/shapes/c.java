package com.qzone.jbox2d.collision.shapes;

import com.qzone.jbox2d.common.Rot;
import com.qzone.jbox2d.common.Transform;
import com.qzone.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c extends f {

    /* renamed from: c, reason: collision with root package name */
    public final Vec2 f48084c;

    /* renamed from: d, reason: collision with root package name */
    public final Vec2 f48085d;

    /* renamed from: e, reason: collision with root package name */
    public final Vec2 f48086e;

    /* renamed from: f, reason: collision with root package name */
    public final Vec2 f48087f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f48088g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f48089h;

    /* renamed from: i, reason: collision with root package name */
    private final Vec2 f48090i;

    public c() {
        super(ShapeType.EDGE);
        this.f48084c = new Vec2();
        this.f48085d = new Vec2();
        this.f48086e = new Vec2();
        this.f48087f = new Vec2();
        this.f48088g = false;
        this.f48089h = false;
        this.f48090i = new Vec2();
        this.f48104b = com.qzone.jbox2d.common.d.f48147o;
    }

    @Override // com.qzone.jbox2d.collision.shapes.f
    /* renamed from: a */
    public f clone() {
        c cVar = new c();
        cVar.f48104b = this.f48104b;
        cVar.f48088g = this.f48088g;
        cVar.f48089h = this.f48089h;
        cVar.f48086e.set(this.f48086e);
        cVar.f48084c.set(this.f48084c);
        cVar.f48085d.set(this.f48085d);
        cVar.f48087f.set(this.f48087f);
        return cVar;
    }

    @Override // com.qzone.jbox2d.collision.shapes.f
    public void b(com.qzone.jbox2d.collision.a aVar, Transform transform, int i3) {
        Vec2 vec2 = aVar.f47986a;
        Vec2 vec22 = aVar.f47987b;
        Rot rot = transform.f48118q;
        float f16 = rot.f48110c;
        Vec2 vec23 = this.f48084c;
        float f17 = vec23.f48119x;
        float f18 = rot.f48111s;
        float f19 = vec23.f48120y;
        Vec2 vec24 = transform.f48117p;
        float f26 = vec24.f48119x;
        float f27 = ((f16 * f17) - (f18 * f19)) + f26;
        float f28 = vec24.f48120y;
        float f29 = (f17 * f18) + (f19 * f16) + f28;
        Vec2 vec25 = this.f48085d;
        float f36 = vec25.f48119x;
        float f37 = vec25.f48120y;
        float f38 = ((f16 * f36) - (f18 * f37)) + f26;
        float f39 = (f18 * f36) + (f16 * f37) + f28;
        vec2.f48119x = f27 < f38 ? f27 : f38;
        vec2.f48120y = f29 < f39 ? f29 : f39;
        if (f27 <= f38) {
            f27 = f38;
        }
        vec22.f48119x = f27;
        if (f29 <= f39) {
            f29 = f39;
        }
        vec22.f48120y = f29;
        float f46 = vec2.f48119x;
        float f47 = this.f48104b;
        vec2.f48119x = f46 - f47;
        vec2.f48120y -= f47;
        vec22.f48119x += f47;
        vec22.f48120y += f47;
    }

    @Override // com.qzone.jbox2d.collision.shapes.f
    public int d() {
        return 1;
    }

    @Override // com.qzone.jbox2d.collision.shapes.f
    public void c(d dVar, float f16) {
        dVar.f48091a = 0.0f;
        dVar.f48092b.set(this.f48084c).addLocal(this.f48085d).mulLocal(0.5f);
        dVar.f48093c = 0.0f;
    }
}
