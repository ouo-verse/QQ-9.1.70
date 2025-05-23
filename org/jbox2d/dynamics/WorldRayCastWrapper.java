package org.jbox2d.dynamics;

import org.jbox2d.callbacks.RayCastCallback;
import org.jbox2d.callbacks.TreeRayCastCallback;
import org.jbox2d.collision.RayCastInput;
import org.jbox2d.collision.RayCastOutput;
import org.jbox2d.collision.broadphase.BroadPhase;
import org.jbox2d.common.Vec2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public class WorldRayCastWrapper implements TreeRayCastCallback {
    BroadPhase broadPhase;
    RayCastCallback callback;
    private final RayCastOutput output = new RayCastOutput();
    private final Vec2 temp = new Vec2();
    private final Vec2 point = new Vec2();

    @Override // org.jbox2d.callbacks.TreeRayCastCallback
    public float raycastCallback(RayCastInput rayCastInput, int i3) {
        FixtureProxy fixtureProxy = (FixtureProxy) this.broadPhase.getUserData(i3);
        Fixture fixture = fixtureProxy.fixture;
        if (fixture.raycast(this.output, rayCastInput, fixtureProxy.childIndex)) {
            float f16 = this.output.fraction;
            this.temp.set(rayCastInput.f423629p2).mulLocal(f16);
            this.point.set(rayCastInput.f423628p1).mulLocal(1.0f - f16).addLocal(this.temp);
            return this.callback.reportFixture(fixture, this.point, this.output.normal, f16);
        }
        return rayCastInput.maxFraction;
    }
}
