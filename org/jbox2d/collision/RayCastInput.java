package org.jbox2d.collision;

import org.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RayCastInput {

    /* renamed from: p1, reason: collision with root package name */
    public final Vec2 f423628p1 = new Vec2();

    /* renamed from: p2, reason: collision with root package name */
    public final Vec2 f423629p2 = new Vec2();
    public float maxFraction = 0.0f;

    public void set(RayCastInput rayCastInput) {
        this.f423628p1.set(rayCastInput.f423628p1);
        this.f423629p2.set(rayCastInput.f423629p2);
        this.maxFraction = rayCastInput.maxFraction;
    }
}
