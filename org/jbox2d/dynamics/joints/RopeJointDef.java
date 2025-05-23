package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RopeJointDef extends JointDef {
    public final Vec2 localAnchorA;
    public final Vec2 localAnchorB;
    public float maxLength;

    public RopeJointDef() {
        Vec2 vec2 = new Vec2();
        this.localAnchorA = vec2;
        Vec2 vec22 = new Vec2();
        this.localAnchorB = vec22;
        this.type = JointType.ROPE;
        vec2.set(-1.0f, 0.0f);
        vec22.set(1.0f, 0.0f);
    }
}
