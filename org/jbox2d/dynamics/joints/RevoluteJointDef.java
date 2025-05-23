package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RevoluteJointDef extends JointDef {
    public boolean enableLimit;
    public boolean enableMotor;
    public Vec2 localAnchorA;
    public Vec2 localAnchorB;
    public float lowerAngle;
    public float maxMotorTorque;
    public float motorSpeed;
    public float referenceAngle;
    public float upperAngle;

    public RevoluteJointDef() {
        this.type = JointType.REVOLUTE;
        this.localAnchorA = new Vec2(0.0f, 0.0f);
        this.localAnchorB = new Vec2(0.0f, 0.0f);
        this.referenceAngle = 0.0f;
        this.lowerAngle = 0.0f;
        this.upperAngle = 0.0f;
        this.maxMotorTorque = 0.0f;
        this.motorSpeed = 0.0f;
        this.enableLimit = false;
        this.enableMotor = false;
    }

    public void initialize(Body body, Body body2, Vec2 vec2) {
        this.bodyA = body;
        this.bodyB = body2;
        body.getLocalPointToOut(vec2, this.localAnchorA);
        this.bodyB.getLocalPointToOut(vec2, this.localAnchorB);
        this.referenceAngle = this.bodyB.getAngle() - this.bodyA.getAngle();
    }
}
