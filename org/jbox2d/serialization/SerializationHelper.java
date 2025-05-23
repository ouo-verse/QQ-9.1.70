package org.jbox2d.serialization;

import org.jbox2d.dynamics.joints.JointType;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SerializationHelper {
    SerializationHelper() {
    }

    public static boolean isIndependentJoint(JointType jointType) {
        if (jointType != JointType.GEAR && jointType != JointType.CONSTANT_VOLUME) {
            return true;
        }
        return false;
    }
}
