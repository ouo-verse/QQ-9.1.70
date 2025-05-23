package org.jbox2d.dynamics.joints;

import org.jbox2d.dynamics.Body;

/* compiled from: P */
/* loaded from: classes29.dex */
public class JointDef {
    public JointType type = JointType.UNKNOWN;
    public Object userData = null;
    public Body bodyA = null;
    public Body bodyB = null;
    public boolean collideConnected = false;
}
