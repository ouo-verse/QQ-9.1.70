package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FrictionJointDef extends JointDef {
    public final Vec2 localAnchorA;
    public final Vec2 localAnchorB;
    public float maxForce;
    public float maxTorque;

    public FrictionJointDef() {
        this.type = JointType.FRICTION;
        this.localAnchorA = new Vec2();
        this.localAnchorB = new Vec2();
        this.maxForce = 0.0f;
        this.maxTorque = 0.0f;
    }

    public void initialize(Body body, Body body2, Vec2 vec2) {
        this.bodyA = body;
        this.bodyB = body2;
        body.getLocalPointToOut(vec2, this.localAnchorA);
        body2.getLocalPointToOut(vec2, this.localAnchorB);
    }
}
