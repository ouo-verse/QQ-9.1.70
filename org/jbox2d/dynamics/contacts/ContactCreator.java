package org.jbox2d.dynamics.contacts;

import org.jbox2d.dynamics.Fixture;
import org.jbox2d.pooling.IWorldPool;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface ContactCreator {
    Contact contactCreateFcn(IWorldPool iWorldPool, Fixture fixture, Fixture fixture2);

    void contactDestroyFcn(IWorldPool iWorldPool, Contact contact);
}
