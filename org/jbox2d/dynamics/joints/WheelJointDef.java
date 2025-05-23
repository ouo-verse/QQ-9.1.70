package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

/* compiled from: P */
/* loaded from: classes29.dex */
public class WheelJointDef extends JointDef {
    public float dampingRatio;
    public boolean enableMotor;
    public float frequencyHz;
    public final Vec2 localAnchorA = new Vec2();
    public final Vec2 localAnchorB = new Vec2();
    public final Vec2 localAxisA;
    public float maxMotorTorque;
    public float motorSpeed;

    public WheelJointDef() {
        Vec2 vec2 = new Vec2();
        this.localAxisA = vec2;
        this.type = JointType.WHEEL;
        vec2.set(1.0f, 0.0f);
        this.enableMotor = false;
        this.maxMotorTorque = 0.0f;
        this.motorSpeed = 0.0f;
    }

    public void initialize(Body body, Body body2, Vec2 vec2, Vec2 vec22) {
        this.bodyA = body;
        this.bodyB = body2;
        body.getLocalPointToOut(vec2, this.localAnchorA);
        body2.getLocalPointToOut(vec2, this.localAnchorB);
        this.bodyA.getLocalVectorToOut(vec22, this.localAxisA);
    }
}
