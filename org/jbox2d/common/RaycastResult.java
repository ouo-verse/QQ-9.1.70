package org.jbox2d.common;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RaycastResult {
    public float lambda = 0.0f;
    public final Vec2 normal = new Vec2();

    public RaycastResult set(RaycastResult raycastResult) {
        this.lambda = raycastResult.lambda;
        this.normal.set(raycastResult.normal);
        return this;
    }
}
