package com.qzone.jbox2d.collision.shapes;

import com.qzone.jbox2d.common.Rot;
import com.qzone.jbox2d.common.Transform;
import com.qzone.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends f {

    /* renamed from: c, reason: collision with root package name */
    public final Vec2 f48083c;

    public b() {
        super(ShapeType.CIRCLE);
        this.f48083c = new Vec2();
        this.f48104b = 0.0f;
    }

    @Override // com.qzone.jbox2d.collision.shapes.f
    /* renamed from: a */
    public final f clone() {
        b bVar = new b();
        Vec2 vec2 = bVar.f48083c;
        Vec2 vec22 = this.f48083c;
        vec2.f48119x = vec22.f48119x;
        vec2.f48120y = vec22.f48120y;
        bVar.f48104b = this.f48104b;
        return bVar;
    }

    @Override // com.qzone.jbox2d.collision.shapes.f
    public final void b(com.qzone.jbox2d.collision.a aVar, Transform transform, int i3) {
        Rot rot = transform.f48118q;
        Vec2 vec2 = transform.f48117p;
        float f16 = rot.f48110c;
        Vec2 vec22 = this.f48083c;
        float f17 = vec22.f48119x;
        float f18 = rot.f48111s;
        float f19 = vec22.f48120y;
        float f26 = ((f16 * f17) - (f18 * f19)) + vec2.f48119x;
        float f27 = (f18 * f17) + (f16 * f19) + vec2.f48120y;
        Vec2 vec23 = aVar.f47986a;
        float f28 = this.f48104b;
        vec23.f48119x = f26 - f28;
        vec23.f48120y = f27 - f28;
        Vec2 vec24 = aVar.f47987b;
        vec24.f48119x = f26 + f28;
        vec24.f48120y = f27 + f28;
    }

    @Override // com.qzone.jbox2d.collision.shapes.f
    public final int d() {
        return 1;
    }

    @Override // com.qzone.jbox2d.collision.shapes.f
    public final void c(d dVar, float f16) {
        float f17 = this.f48104b;
        float f18 = f16 * 3.1415927f * f17 * f17;
        dVar.f48091a = f18;
        Vec2 vec2 = dVar.f48092b;
        Vec2 vec22 = this.f48083c;
        vec2.f48119x = vec22.f48119x;
        vec2.f48120y = vec22.f48120y;
        float f19 = 0.5f * f17 * f17;
        float f26 = vec22.f48119x;
        float f27 = vec22.f48120y;
        dVar.f48093c = f18 * (f19 + (f26 * f26) + (f27 * f27));
    }
}
