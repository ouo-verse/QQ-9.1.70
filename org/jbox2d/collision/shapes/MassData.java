package org.jbox2d.collision.shapes;

import org.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MassData {
    public float I;
    public final Vec2 center;
    public float mass;

    public MassData() {
        this.I = 0.0f;
        this.mass = 0.0f;
        this.center = new Vec2();
    }

    public void set(MassData massData) {
        this.mass = massData.mass;
        this.I = massData.I;
        this.center.set(massData.center);
    }

    public MassData clone() {
        return new MassData(this);
    }

    public MassData(MassData massData) {
        this.mass = massData.mass;
        this.I = massData.I;
        this.center = massData.center.clone();
    }
}
