package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

/* loaded from: classes29.dex */
public class PulleyJointDef extends JointDef {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public Vec2 groundAnchorA;
    public Vec2 groundAnchorB;
    public float lengthA;
    public float lengthB;
    public Vec2 localAnchorA;
    public Vec2 localAnchorB;
    public float ratio;

    public PulleyJointDef() {
        this.type = JointType.PULLEY;
        this.groundAnchorA = new Vec2(-1.0f, 1.0f);
        this.groundAnchorB = new Vec2(1.0f, 1.0f);
        this.localAnchorA = new Vec2(-1.0f, 0.0f);
        this.localAnchorB = new Vec2(1.0f, 0.0f);
        this.lengthA = 0.0f;
        this.lengthB = 0.0f;
        this.ratio = 1.0f;
        this.collideConnected = true;
    }

    public void initialize(Body body, Body body2, Vec2 vec2, Vec2 vec22, Vec2 vec23, Vec2 vec24, float f16) {
        this.bodyA = body;
        this.bodyB = body2;
        this.groundAnchorA = vec2;
        this.groundAnchorB = vec22;
        this.localAnchorA = body.getLocalPoint(vec23);
        this.localAnchorB = this.bodyB.getLocalPoint(vec24);
        this.lengthA = vec23.sub(vec2).length();
        this.lengthB = vec24.sub(vec22).length();
        this.ratio = f16;
    }
}
