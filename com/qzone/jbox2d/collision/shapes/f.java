package com.qzone.jbox2d.collision.shapes;

import com.qzone.jbox2d.common.Transform;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public final ShapeType f48103a;

    /* renamed from: b, reason: collision with root package name */
    public float f48104b;

    public f(ShapeType shapeType) {
        this.f48103a = shapeType;
    }

    public abstract f a();

    public abstract void b(com.qzone.jbox2d.collision.a aVar, Transform transform, int i3);

    public abstract void c(d dVar, float f16);

    public abstract int d();

    public float e() {
        return this.f48104b;
    }

    public ShapeType f() {
        return this.f48103a;
    }

    public void g(float f16) {
        this.f48104b = f16;
    }
}
