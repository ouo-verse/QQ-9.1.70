package org.jbox2d.dynamics.contacts;

import org.jbox2d.collision.Manifold;
import org.jbox2d.collision.shapes.ChainShape;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.common.Transform;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.pooling.IWorldPool;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ChainAndCircleContact extends Contact {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final EdgeShape edge;

    public ChainAndCircleContact(IWorldPool iWorldPool) {
        super(iWorldPool);
        this.edge = new EdgeShape();
    }

    @Override // org.jbox2d.dynamics.contacts.Contact
    public void evaluate(Manifold manifold, Transform transform, Transform transform2) {
        ((ChainShape) this.m_fixtureA.getShape()).getChildEdge(this.edge, this.m_indexA);
        this.pool.getCollision().collideEdgeAndCircle(manifold, this.edge, transform, (CircleShape) this.m_fixtureB.getShape(), transform2);
    }

    @Override // org.jbox2d.dynamics.contacts.Contact
    public void init(Fixture fixture, int i3, Fixture fixture2, int i16) {
        super.init(fixture, i3, fixture2, i16);
    }
}
