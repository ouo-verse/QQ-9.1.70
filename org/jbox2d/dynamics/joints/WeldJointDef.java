package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

/* compiled from: P */
/* loaded from: classes29.dex */
public class WeldJointDef extends JointDef {
    public float dampingRatio;
    public float frequencyHz;
    public final Vec2 localAnchorA;
    public final Vec2 localAnchorB;
    public float referenceAngle;

    public WeldJointDef() {
        this.type = JointType.WELD;
        this.localAnchorA = new Vec2();
        this.localAnchorB = new Vec2();
        this.referenceAngle = 0.0f;
    }

    public void initialize(Body body, Body body2, Vec2 vec2) {
        this.bodyA = body;
        this.bodyB = body2;
        body.getLocalPointToOut(vec2, this.localAnchorA);
        this.bodyB.getLocalPointToOut(vec2, this.localAnchorB);
        this.referenceAngle = this.bodyB.getAngle() - this.bodyA.getAngle();
    }
}
