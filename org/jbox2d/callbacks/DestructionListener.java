package org.jbox2d.callbacks;

import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.joints.Joint;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface DestructionListener {
    void sayGoodbye(Fixture fixture);

    void sayGoodbye(Joint joint);
}
