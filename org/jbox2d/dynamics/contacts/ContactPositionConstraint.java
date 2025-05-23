package org.jbox2d.dynamics.contacts;

import org.jbox2d.collision.Manifold;
import org.jbox2d.common.Vec2;

/* loaded from: classes29.dex */
public class ContactPositionConstraint {
    int indexA;
    int indexB;
    float invIA;
    float invIB;
    float invMassA;
    float invMassB;
    int pointCount;
    float radiusA;
    float radiusB;
    Manifold.ManifoldType type;
    Vec2[] localPoints = new Vec2[2];
    final Vec2 localNormal = new Vec2();
    final Vec2 localPoint = new Vec2();
    final Vec2 localCenterA = new Vec2();
    final Vec2 localCenterB = new Vec2();

    public ContactPositionConstraint() {
        int i3 = 0;
        while (true) {
            Vec2[] vec2Arr = this.localPoints;
            if (i3 < vec2Arr.length) {
                vec2Arr[i3] = new Vec2();
                i3++;
            } else {
                return;
            }
        }
    }
}
