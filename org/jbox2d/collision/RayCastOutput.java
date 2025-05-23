package org.jbox2d.collision;

import org.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RayCastOutput {
    public final Vec2 normal = new Vec2();
    public float fraction = 0.0f;

    public void set(RayCastOutput rayCastOutput) {
        this.normal.set(rayCastOutput.normal);
        this.fraction = rayCastOutput.fraction;
    }
}
