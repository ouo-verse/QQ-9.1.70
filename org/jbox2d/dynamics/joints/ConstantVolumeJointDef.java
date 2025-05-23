package org.jbox2d.dynamics.joints;

import java.util.ArrayList;
import org.jbox2d.dynamics.Body;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ConstantVolumeJointDef extends JointDef {
    ArrayList<Body> bodies;
    public float dampingRatio;
    public float frequencyHz;
    ArrayList<DistanceJoint> joints;

    public ConstantVolumeJointDef() {
        this.type = JointType.CONSTANT_VOLUME;
        this.bodies = new ArrayList<>();
        this.joints = null;
        this.collideConnected = false;
        this.frequencyHz = 0.0f;
        this.dampingRatio = 0.0f;
    }

    public void addBody(Body body) {
        this.bodies.add(body);
        if (this.bodies.size() == 1) {
            this.bodyA = body;
        }
        if (this.bodies.size() == 2) {
            this.bodyB = body;
        }
    }

    public void addBodyAndJoint(Body body, DistanceJoint distanceJoint) {
        addBody(body);
        if (this.joints == null) {
            this.joints = new ArrayList<>();
        }
        this.joints.add(distanceJoint);
    }
}
