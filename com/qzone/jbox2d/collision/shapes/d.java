package com.qzone.jbox2d.collision.shapes;

import com.qzone.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public float f48091a;

    /* renamed from: b, reason: collision with root package name */
    public final Vec2 f48092b;

    /* renamed from: c, reason: collision with root package name */
    public float f48093c;

    public d() {
        this.f48093c = 0.0f;
        this.f48091a = 0.0f;
        this.f48092b = new Vec2();
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d clone() {
        return new d(this);
    }

    public d(d dVar) {
        this.f48091a = dVar.f48091a;
        this.f48093c = dVar.f48093c;
        this.f48092b = dVar.f48092b.m79clone();
    }
}
