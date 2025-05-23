package org.jbox2d.collision;

import org.jbox2d.collision.Distance;
import org.jbox2d.common.Transform;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DistanceInput {
    public Distance.DistanceProxy proxyA = new Distance.DistanceProxy();
    public Distance.DistanceProxy proxyB = new Distance.DistanceProxy();
    public Transform transformA = new Transform();
    public Transform transformB = new Transform();
    public boolean useRadii;
}
