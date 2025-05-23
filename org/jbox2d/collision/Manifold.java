package org.jbox2d.collision;

import org.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Manifold {
    public final Vec2 localNormal;
    public final Vec2 localPoint;
    public int pointCount;
    public final ManifoldPoint[] points;
    public ManifoldType type;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum ManifoldType {
        CIRCLES,
        FACE_A,
        FACE_B
    }

    public Manifold() {
        this.points = new ManifoldPoint[2];
        for (int i3 = 0; i3 < 2; i3++) {
            this.points[i3] = new ManifoldPoint();
        }
        this.localNormal = new Vec2();
        this.localPoint = new Vec2();
        this.pointCount = 0;
    }

    public void set(Manifold manifold) {
        for (int i3 = 0; i3 < manifold.pointCount; i3++) {
            this.points[i3].set(manifold.points[i3]);
        }
        this.type = manifold.type;
        this.localNormal.set(manifold.localNormal);
        this.localPoint.set(manifold.localPoint);
        this.pointCount = manifold.pointCount;
    }

    public Manifold(Manifold manifold) {
        this.points = new ManifoldPoint[2];
        this.localNormal = manifold.localNormal.clone();
        this.localPoint = manifold.localPoint.clone();
        this.pointCount = manifold.pointCount;
        this.type = manifold.type;
        for (int i3 = 0; i3 < 2; i3++) {
            this.points[i3] = new ManifoldPoint(manifold.points[i3]);
        }
    }
}
