package org.jbox2d.dynamics.contacts;

import org.jbox2d.collision.Manifold;
import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Transform;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.pooling.IWorldPool;

/* loaded from: classes29.dex */
public class EdgeAndPolygonContact extends Contact {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public EdgeAndPolygonContact(IWorldPool iWorldPool) {
        super(iWorldPool);
    }

    @Override // org.jbox2d.dynamics.contacts.Contact
    public void evaluate(Manifold manifold, Transform transform, Transform transform2) {
        this.pool.getCollision().collideEdgeAndPolygon(manifold, (EdgeShape) this.m_fixtureA.getShape(), transform, (PolygonShape) this.m_fixtureB.getShape(), transform2);
    }

    @Override // org.jbox2d.dynamics.contacts.Contact
    public void init(Fixture fixture, int i3, Fixture fixture2, int i16) {
        super.init(fixture, i3, fixture2, i16);
    }
}
