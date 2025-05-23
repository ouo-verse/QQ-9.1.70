package org.jbox2d.dynamics.contacts;

import org.jbox2d.collision.Manifold;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Transform;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.pooling.IWorldPool;

/* loaded from: classes29.dex */
public class PolygonAndCircleContact extends Contact {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public PolygonAndCircleContact(IWorldPool iWorldPool) {
        super(iWorldPool);
    }

    @Override // org.jbox2d.dynamics.contacts.Contact
    public void evaluate(Manifold manifold, Transform transform, Transform transform2) {
        this.pool.getCollision().collidePolygonAndCircle(manifold, (PolygonShape) this.m_fixtureA.getShape(), transform, (CircleShape) this.m_fixtureB.getShape(), transform2);
    }

    public void init(Fixture fixture, Fixture fixture2) {
        super.init(fixture, 0, fixture2, 0);
    }
}
