package org.jbox2d.dynamics.joints;

/* compiled from: P */
/* loaded from: classes29.dex */
public class GearJointDef extends JointDef {
    public Joint joint1;
    public Joint joint2;
    public float ratio;

    public GearJointDef() {
        this.type = JointType.GEAR;
        this.joint1 = null;
        this.joint2 = null;
    }
}
