package org.jbox2d.dynamics;

import org.jbox2d.collision.AABB;
import org.jbox2d.collision.RayCastInput;
import org.jbox2d.collision.RayCastOutput;
import org.jbox2d.collision.broadphase.BroadPhase;
import org.jbox2d.collision.shapes.MassData;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.collision.shapes.ShapeType;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.contacts.Contact;
import org.jbox2d.dynamics.contacts.ContactEdge;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Fixture {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public float m_density;
    public float m_friction;
    public boolean m_isSensor;
    public float m_restitution;
    private final AABB pool1 = new AABB();
    private final AABB pool2 = new AABB();
    private final Vec2 displacement = new Vec2();
    public Object m_userData = null;
    public Body m_body = null;
    public Fixture m_next = null;
    public FixtureProxy[] m_proxies = null;
    public int m_proxyCount = 0;
    public Shape m_shape = null;
    public final Filter m_filter = new Filter();

    public void create(Body body, FixtureDef fixtureDef) {
        this.m_userData = fixtureDef.userData;
        this.m_friction = fixtureDef.friction;
        this.m_restitution = fixtureDef.restitution;
        this.m_body = body;
        this.m_next = null;
        this.m_filter.set(fixtureDef.filter);
        this.m_isSensor = fixtureDef.isSensor;
        Shape clone = fixtureDef.shape.clone();
        this.m_shape = clone;
        int childCount = clone.getChildCount();
        if (this.m_proxies == null) {
            this.m_proxies = new FixtureProxy[childCount];
            for (int i3 = 0; i3 < childCount; i3++) {
                this.m_proxies[i3] = new FixtureProxy();
                FixtureProxy fixtureProxy = this.m_proxies[i3];
                fixtureProxy.fixture = null;
                fixtureProxy.proxyId = -1;
            }
        }
        FixtureProxy[] fixtureProxyArr = this.m_proxies;
        if (fixtureProxyArr.length < childCount) {
            int max = MathUtils.max(fixtureProxyArr.length * 2, childCount);
            FixtureProxy[] fixtureProxyArr2 = new FixtureProxy[max];
            this.m_proxies = fixtureProxyArr2;
            System.arraycopy(fixtureProxyArr, 0, fixtureProxyArr2, 0, fixtureProxyArr.length);
            for (int i16 = 0; i16 < max; i16++) {
                if (i16 >= fixtureProxyArr.length) {
                    this.m_proxies[i16] = new FixtureProxy();
                }
                FixtureProxy fixtureProxy2 = this.m_proxies[i16];
                fixtureProxy2.fixture = null;
                fixtureProxy2.proxyId = -1;
            }
        }
        this.m_proxyCount = 0;
        this.m_density = fixtureDef.density;
    }

    public void createProxies(BroadPhase broadPhase, Transform transform) {
        this.m_proxyCount = this.m_shape.getChildCount();
        for (int i3 = 0; i3 < this.m_proxyCount; i3++) {
            FixtureProxy fixtureProxy = this.m_proxies[i3];
            this.m_shape.computeAABB(fixtureProxy.aabb, transform, i3);
            fixtureProxy.proxyId = broadPhase.createProxy(fixtureProxy.aabb, fixtureProxy);
            fixtureProxy.fixture = this;
            fixtureProxy.childIndex = i3;
        }
    }

    public void destroy() {
        this.m_shape = null;
        this.m_proxies = null;
        this.m_next = null;
    }

    public void destroyProxies(BroadPhase broadPhase) {
        for (int i3 = 0; i3 < this.m_proxyCount; i3++) {
            FixtureProxy fixtureProxy = this.m_proxies[i3];
            broadPhase.destroyProxy(fixtureProxy.proxyId);
            fixtureProxy.proxyId = -1;
        }
        this.m_proxyCount = 0;
    }

    public AABB getAABB(int i3) {
        return this.m_proxies[i3].aabb;
    }

    public Body getBody() {
        return this.m_body;
    }

    public float getDensity() {
        return this.m_density;
    }

    public Filter getFilterData() {
        return this.m_filter;
    }

    public float getFriction() {
        return this.m_friction;
    }

    public void getMassData(MassData massData) {
        this.m_shape.computeMass(massData, this.m_density);
    }

    public Fixture getNext() {
        return this.m_next;
    }

    public float getRestitution() {
        return this.m_restitution;
    }

    public Shape getShape() {
        return this.m_shape;
    }

    public ShapeType getType() {
        return this.m_shape.getType();
    }

    public Object getUserData() {
        return this.m_userData;
    }

    public boolean isSensor() {
        return this.m_isSensor;
    }

    public boolean raycast(RayCastOutput rayCastOutput, RayCastInput rayCastInput, int i3) {
        return this.m_shape.raycast(rayCastOutput, rayCastInput, this.m_body.m_xf, i3);
    }

    public void refilter() {
        Body body = this.m_body;
        if (body == null) {
            return;
        }
        for (ContactEdge contactList = body.getContactList(); contactList != null; contactList = contactList.next) {
            Contact contact = contactList.contact;
            Fixture fixtureA = contact.getFixtureA();
            Fixture fixtureB = contact.getFixtureB();
            if (fixtureA == this || fixtureB == this) {
                contact.flagForFiltering();
            }
        }
        World world = this.m_body.getWorld();
        if (world == null) {
            return;
        }
        BroadPhase broadPhase = world.m_contactManager.m_broadPhase;
        for (int i3 = 0; i3 < this.m_proxyCount; i3++) {
            broadPhase.touchProxy(this.m_proxies[i3].proxyId);
        }
    }

    public void setDensity(float f16) {
        this.m_density = f16;
    }

    public void setFilterData(Filter filter) {
        this.m_filter.set(filter);
        refilter();
    }

    public void setFriction(float f16) {
        this.m_friction = f16;
    }

    public void setRestitution(float f16) {
        this.m_restitution = f16;
    }

    public void setSensor(boolean z16) {
        if (z16 != this.m_isSensor) {
            this.m_body.setAwake(true);
            this.m_isSensor = z16;
        }
    }

    public void setUserData(Object obj) {
        this.m_userData = obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void synchronize(BroadPhase broadPhase, Transform transform, Transform transform2) {
        if (this.m_proxyCount == 0) {
            return;
        }
        for (int i3 = 0; i3 < this.m_proxyCount; i3++) {
            FixtureProxy fixtureProxy = this.m_proxies[i3];
            AABB aabb = this.pool1;
            AABB aabb2 = this.pool2;
            this.m_shape.computeAABB(aabb, transform, fixtureProxy.childIndex);
            this.m_shape.computeAABB(aabb2, transform2, fixtureProxy.childIndex);
            AABB aabb3 = fixtureProxy.aabb;
            Vec2 vec2 = aabb3.lowerBound;
            Vec2 vec22 = aabb.lowerBound;
            float f16 = vec22.f423649x;
            Vec2 vec23 = aabb2.lowerBound;
            float f17 = vec23.f423649x;
            if (f16 >= f17) {
                f16 = f17;
            }
            vec2.f423649x = f16;
            float f18 = vec22.f423650y;
            float f19 = vec23.f423650y;
            if (f18 >= f19) {
                f18 = f19;
            }
            vec2.f423650y = f18;
            Vec2 vec24 = aabb3.upperBound;
            Vec2 vec25 = aabb.upperBound;
            float f26 = vec25.f423649x;
            Vec2 vec26 = aabb2.upperBound;
            float f27 = vec26.f423649x;
            if (f26 <= f27) {
                f26 = f27;
            }
            vec24.f423649x = f26;
            float f28 = vec25.f423650y;
            float f29 = vec26.f423650y;
            if (f28 <= f29) {
                f28 = f29;
            }
            vec24.f423650y = f28;
            Vec2 vec27 = this.displacement;
            Vec2 vec28 = transform2.f423647p;
            float f36 = vec28.f423649x;
            Vec2 vec29 = transform.f423647p;
            vec27.f423649x = f36 - vec29.f423649x;
            vec27.f423650y = vec28.f423650y - vec29.f423650y;
            broadPhase.moveProxy(fixtureProxy.proxyId, aabb3, vec27);
        }
    }

    public boolean testPoint(Vec2 vec2) {
        return this.m_shape.testPoint(this.m_body.m_xf, vec2);
    }

    public void dump(int i3) {
    }
}
