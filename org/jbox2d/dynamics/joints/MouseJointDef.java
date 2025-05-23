package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MouseJointDef extends JointDef {
    public float dampingRatio;
    public float frequencyHz;
    public float maxForce;
    public final Vec2 target;

    public MouseJointDef() {
        Vec2 vec2 = new Vec2();
        this.target = vec2;
        this.type = JointType.MOUSE;
        vec2.set(0.0f, 0.0f);
        this.maxForce = 0.0f;
        this.frequencyHz = 5.0f;
        this.dampingRatio = 0.7f;
    }
}
