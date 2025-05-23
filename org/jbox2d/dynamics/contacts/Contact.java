package org.jbox2d.dynamics.contacts;

import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.ContactID;
import org.jbox2d.collision.Manifold;
import org.jbox2d.collision.ManifoldPoint;
import org.jbox2d.collision.WorldManifold;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Transform;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.pooling.IWorldPool;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class Contact {
    public static final int BULLET_HIT_FLAG = 16;
    public static final int ENABLED_FLAG = 4;
    public static final int FILTER_FLAG = 8;
    public static final int ISLAND_FLAG = 1;
    public static final int TOI_FLAG = 32;
    public static final int TOUCHING_FLAG = 2;
    public int m_flags;
    public float m_friction;
    public int m_indexA;
    public int m_indexB;
    public Contact m_next;
    public ContactEdge m_nodeA;
    public ContactEdge m_nodeB;
    public Contact m_prev;
    public float m_restitution;
    public float m_tangentSpeed;
    public float m_toi;
    public float m_toiCount;
    protected final IWorldPool pool;
    private final Manifold oldManifold = new Manifold();
    public Fixture m_fixtureA = null;
    public Fixture m_fixtureB = null;
    public final Manifold m_manifold = new Manifold();

    /* JADX INFO: Access modifiers changed from: protected */
    public Contact(IWorldPool iWorldPool) {
        this.m_nodeA = null;
        this.m_nodeB = null;
        this.m_nodeA = new ContactEdge();
        this.m_nodeB = new ContactEdge();
        this.pool = iWorldPool;
    }

    public static final float mixFriction(float f16, float f17) {
        return MathUtils.sqrt(f16 * f17);
    }

    public static final float mixRestitution(float f16, float f17) {
        if (f16 <= f17) {
            return f17;
        }
        return f16;
    }

    public abstract void evaluate(Manifold manifold, Transform transform, Transform transform2);

    public void flagForFiltering() {
        this.m_flags |= 8;
    }

    public int getChildIndexA() {
        return this.m_indexA;
    }

    public int getChildIndexB() {
        return this.m_indexB;
    }

    public Fixture getFixtureA() {
        return this.m_fixtureA;
    }

    public Fixture getFixtureB() {
        return this.m_fixtureB;
    }

    public float getFriction() {
        return this.m_friction;
    }

    public Manifold getManifold() {
        return this.m_manifold;
    }

    public Contact getNext() {
        return this.m_next;
    }

    public float getRestitution() {
        return this.m_restitution;
    }

    public float getTangentSpeed() {
        return this.m_tangentSpeed;
    }

    public void getWorldManifold(WorldManifold worldManifold) {
        Body body = this.m_fixtureA.getBody();
        Body body2 = this.m_fixtureB.getBody();
        worldManifold.initialize(this.m_manifold, body.getTransform(), this.m_fixtureA.getShape().m_radius, body2.getTransform(), this.m_fixtureB.getShape().m_radius);
    }

    public void init(Fixture fixture, int i3, Fixture fixture2, int i16) {
        this.m_flags = 0;
        this.m_fixtureA = fixture;
        this.m_fixtureB = fixture2;
        this.m_indexA = i3;
        this.m_indexB = i16;
        this.m_manifold.pointCount = 0;
        this.m_prev = null;
        this.m_next = null;
        ContactEdge contactEdge = this.m_nodeA;
        contactEdge.contact = null;
        contactEdge.prev = null;
        contactEdge.next = null;
        contactEdge.other = null;
        ContactEdge contactEdge2 = this.m_nodeB;
        contactEdge2.contact = null;
        contactEdge2.prev = null;
        contactEdge2.next = null;
        contactEdge2.other = null;
        this.m_toiCount = 0.0f;
        this.m_friction = mixFriction(fixture.m_friction, fixture2.m_friction);
        this.m_restitution = mixRestitution(fixture.m_restitution, fixture2.m_restitution);
        this.m_tangentSpeed = 0.0f;
    }

    public boolean isEnabled() {
        if ((this.m_flags & 4) == 4) {
            return true;
        }
        return false;
    }

    public boolean isTouching() {
        if ((this.m_flags & 2) == 2) {
            return true;
        }
        return false;
    }

    public void resetFriction() {
        this.m_friction = mixFriction(this.m_fixtureA.m_friction, this.m_fixtureB.m_friction);
    }

    public void resetRestitution() {
        this.m_restitution = mixRestitution(this.m_fixtureA.m_restitution, this.m_fixtureB.m_restitution);
    }

    public void setEnabled(boolean z16) {
        if (z16) {
            this.m_flags |= 4;
        } else {
            this.m_flags &= -5;
        }
    }

    public void setFriction(float f16) {
        this.m_friction = f16;
    }

    public void setRestitution(float f16) {
        this.m_restitution = f16;
    }

    public void setTangentSpeed(float f16) {
        this.m_tangentSpeed = f16;
    }

    public void update(ContactListener contactListener) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        this.oldManifold.set(this.m_manifold);
        int i3 = this.m_flags | 4;
        this.m_flags = i3;
        if ((i3 & 2) == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isSensor = this.m_fixtureA.isSensor();
        boolean isSensor2 = this.m_fixtureB.isSensor();
        if (!isSensor && !isSensor2) {
            z17 = false;
        } else {
            z17 = true;
        }
        Body body = this.m_fixtureA.getBody();
        Body body2 = this.m_fixtureB.getBody();
        Transform transform = body.getTransform();
        Transform transform2 = body2.getTransform();
        if (z17) {
            z19 = this.pool.getCollision().testOverlap(this.m_fixtureA.getShape(), this.m_indexA, this.m_fixtureB.getShape(), this.m_indexB, transform, transform2);
            this.m_manifold.pointCount = 0;
        } else {
            evaluate(this.m_manifold, transform, transform2);
            if (this.m_manifold.pointCount > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            int i16 = 0;
            while (true) {
                Manifold manifold = this.m_manifold;
                if (i16 >= manifold.pointCount) {
                    break;
                }
                ManifoldPoint manifoldPoint = manifold.points[i16];
                manifoldPoint.normalImpulse = 0.0f;
                manifoldPoint.tangentImpulse = 0.0f;
                ContactID contactID = manifoldPoint.f423627id;
                int i17 = 0;
                while (true) {
                    Manifold manifold2 = this.oldManifold;
                    if (i17 < manifold2.pointCount) {
                        ManifoldPoint manifoldPoint2 = manifold2.points[i17];
                        if (manifoldPoint2.f423627id.isEqual(contactID)) {
                            manifoldPoint.normalImpulse = manifoldPoint2.normalImpulse;
                            manifoldPoint.tangentImpulse = manifoldPoint2.tangentImpulse;
                            break;
                        }
                        i17++;
                    }
                }
                i16++;
            }
            if (z18 != z16) {
                body.setAwake(true);
                body2.setAwake(true);
            }
            z19 = z18;
        }
        if (z19) {
            this.m_flags = 2 | this.m_flags;
        } else {
            this.m_flags &= -3;
        }
        if (contactListener == null) {
            return;
        }
        if (!z16 && z19) {
            contactListener.beginContact(this);
        }
        if (z16 && !z19) {
            contactListener.endContact(this);
        }
        if (!z17 && z19) {
            contactListener.preSolve(this, this.oldManifold);
        }
    }
}
