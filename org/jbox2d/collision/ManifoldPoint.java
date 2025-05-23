package org.jbox2d.collision;

import org.jbox2d.common.Vec2;

/* loaded from: classes29.dex */
public class ManifoldPoint {

    /* renamed from: id, reason: collision with root package name */
    public final ContactID f423627id;
    public final Vec2 localPoint;
    public float normalImpulse;
    public float tangentImpulse;

    public ManifoldPoint() {
        this.localPoint = new Vec2();
        this.tangentImpulse = 0.0f;
        this.normalImpulse = 0.0f;
        this.f423627id = new ContactID();
    }

    public void set(ManifoldPoint manifoldPoint) {
        this.localPoint.set(manifoldPoint.localPoint);
        this.normalImpulse = manifoldPoint.normalImpulse;
        this.tangentImpulse = manifoldPoint.tangentImpulse;
        this.f423627id.set(manifoldPoint.f423627id);
    }

    public ManifoldPoint(ManifoldPoint manifoldPoint) {
        this.localPoint = manifoldPoint.localPoint.clone();
        this.normalImpulse = manifoldPoint.normalImpulse;
        this.tangentImpulse = manifoldPoint.tangentImpulse;
        this.f423627id = new ContactID(manifoldPoint.f423627id);
    }
}
