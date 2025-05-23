package org.jbox2d.dynamics;

import org.jbox2d.callbacks.QueryCallback;
import org.jbox2d.callbacks.TreeCallback;
import org.jbox2d.collision.broadphase.BroadPhase;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public class WorldQueryWrapper implements TreeCallback {
    BroadPhase broadPhase;
    QueryCallback callback;

    @Override // org.jbox2d.callbacks.TreeCallback
    public boolean treeCallback(int i3) {
        return this.callback.reportFixture(((FixtureProxy) this.broadPhase.getUserData(i3)).fixture);
    }
}
