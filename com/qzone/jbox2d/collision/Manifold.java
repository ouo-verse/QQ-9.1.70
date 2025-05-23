package com.qzone.jbox2d.collision;

import com.qzone.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes39.dex */
public class Manifold {

    /* renamed from: a, reason: collision with root package name */
    public final e[] f47959a = new e[com.qzone.jbox2d.common.d.f48141i];

    /* renamed from: b, reason: collision with root package name */
    public final Vec2 f47960b;

    /* renamed from: c, reason: collision with root package name */
    public final Vec2 f47961c;

    /* renamed from: d, reason: collision with root package name */
    public ManifoldType f47962d;

    /* renamed from: e, reason: collision with root package name */
    public int f47963e;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public enum ManifoldType {
        CIRCLES,
        FACE_A,
        FACE_B
    }

    public Manifold() {
        for (int i3 = 0; i3 < com.qzone.jbox2d.common.d.f48141i; i3++) {
            this.f47959a[i3] = new e();
        }
        this.f47960b = new Vec2();
        this.f47961c = new Vec2();
        this.f47963e = 0;
    }

    public void a(Manifold manifold) {
        for (int i3 = 0; i3 < manifold.f47963e; i3++) {
            this.f47959a[i3].a(manifold.f47959a[i3]);
        }
        this.f47962d = manifold.f47962d;
        this.f47960b.set(manifold.f47960b);
        this.f47961c.set(manifold.f47961c);
        this.f47963e = manifold.f47963e;
    }
}
