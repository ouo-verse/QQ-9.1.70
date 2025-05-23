package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DistanceJointDef extends JointDef {
    public float dampingRatio;
    public float frequencyHz;
    public float length;
    public final Vec2 localAnchorA;
    public final Vec2 localAnchorB;

    public DistanceJointDef() {
        this.type = JointType.DISTANCE;
        this.localAnchorA = new Vec2(0.0f, 0.0f);
        this.localAnchorB = new Vec2(0.0f, 0.0f);
        this.length = 1.0f;
        this.frequencyHz = 0.0f;
        this.dampingRatio = 0.0f;
    }

    public void initialize(Body body, Body body2, Vec2 vec2, Vec2 vec22) {
        this.bodyA = body;
        this.bodyB = body2;
        this.localAnchorA.set(body.getLocalPoint(vec2));
        this.localAnchorB.set(this.bodyB.getLocalPoint(vec22));
        this.length = vec22.sub(vec2).length();
    }
}
