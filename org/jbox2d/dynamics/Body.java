package org.jbox2d.dynamics;

import org.jbox2d.collision.broadphase.BroadPhase;
import org.jbox2d.collision.shapes.MassData;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Sweep;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.contacts.Contact;
import org.jbox2d.dynamics.contacts.ContactEdge;
import org.jbox2d.dynamics.joints.JointEdge;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Body {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int e_activeFlag = 32;
    public static final int e_autoSleepFlag = 4;
    public static final int e_awakeFlag = 2;
    public static final int e_bulletFlag = 8;
    public static final int e_fixedRotationFlag = 16;
    public static final int e_islandFlag = 1;
    public static final int e_toiFlag = 64;
    private final FixtureDef fixDef;
    public float m_I;
    public float m_angularDamping;
    public float m_angularVelocity;
    public ContactEdge m_contactList;
    public int m_fixtureCount;
    public Fixture m_fixtureList;
    public int m_flags;
    public final Vec2 m_force;
    public float m_gravityScale;
    public float m_invI;
    public float m_invMass;
    public int m_islandIndex;
    public JointEdge m_jointList;
    public float m_linearDamping;
    public final Vec2 m_linearVelocity;
    public float m_mass;
    public Body m_next;
    public Body m_prev;
    public float m_sleepTime;
    public final Sweep m_sweep;
    public float m_torque;
    public BodyType m_type;
    public Object m_userData;
    public World m_world;
    public final Transform m_xf;
    private final MassData pmd;
    private final Transform pxf;

    public Body(BodyDef bodyDef, World world) {
        Transform transform = new Transform();
        this.m_xf = transform;
        Sweep sweep = new Sweep();
        this.m_sweep = sweep;
        Vec2 vec2 = new Vec2();
        this.m_linearVelocity = vec2;
        this.m_angularVelocity = 0.0f;
        Vec2 vec22 = new Vec2();
        this.m_force = vec22;
        this.m_torque = 0.0f;
        this.fixDef = new FixtureDef();
        this.pmd = new MassData();
        this.pxf = new Transform();
        this.m_flags = 0;
        if (bodyDef.bullet) {
            this.m_flags = 0 | 8;
        }
        if (bodyDef.fixedRotation) {
            this.m_flags |= 16;
        }
        if (bodyDef.allowSleep) {
            this.m_flags |= 4;
        }
        if (bodyDef.awake) {
            this.m_flags |= 2;
        }
        if (bodyDef.active) {
            this.m_flags |= 32;
        }
        this.m_world = world;
        transform.f423647p.set(bodyDef.position);
        transform.f423648q.set(bodyDef.angle);
        sweep.localCenter.setZero();
        sweep.f423646c0.set(transform.f423647p);
        sweep.f423645c.set(transform.f423647p);
        float f16 = bodyDef.angle;
        sweep.f423644a0 = f16;
        sweep.f423643a = f16;
        sweep.alpha0 = 0.0f;
        this.m_jointList = null;
        this.m_contactList = null;
        this.m_prev = null;
        this.m_next = null;
        vec2.set(bodyDef.linearVelocity);
        this.m_angularVelocity = bodyDef.angularVelocity;
        this.m_linearDamping = bodyDef.linearDamping;
        this.m_angularDamping = bodyDef.angularDamping;
        this.m_gravityScale = bodyDef.gravityScale;
        vec22.setZero();
        this.m_torque = 0.0f;
        this.m_sleepTime = 0.0f;
        BodyType bodyType = bodyDef.type;
        this.m_type = bodyType;
        if (bodyType == BodyType.DYNAMIC) {
            this.m_mass = 1.0f;
            this.m_invMass = 1.0f;
        } else {
            this.m_mass = 0.0f;
            this.m_invMass = 0.0f;
        }
        this.m_I = 0.0f;
        this.m_invI = 0.0f;
        this.m_userData = bodyDef.userData;
        this.m_fixtureList = null;
        this.m_fixtureCount = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void advance(float f16) {
        this.m_sweep.advance(f16);
        Sweep sweep = this.m_sweep;
        sweep.f423645c.set(sweep.f423646c0);
        Sweep sweep2 = this.m_sweep;
        float f17 = sweep2.f423644a0;
        sweep2.f423643a = f17;
        this.m_xf.f423648q.set(f17);
        Transform transform = this.m_xf;
        Rot.mulToOutUnsafe(transform.f423648q, this.m_sweep.localCenter, transform.f423647p);
        this.m_xf.f423647p.mulLocal(-1.0f).addLocal(this.m_sweep.f423645c);
    }

    public void applyAngularImpulse(float f16) {
        if (this.m_type != BodyType.DYNAMIC) {
            return;
        }
        if (!isAwake()) {
            setAwake(true);
        }
        this.m_angularVelocity += this.m_invI * f16;
    }

    public final void applyForce(Vec2 vec2, Vec2 vec22) {
        if (this.m_type != BodyType.DYNAMIC) {
            return;
        }
        if (!isAwake()) {
            setAwake(true);
        }
        Vec2 vec23 = this.m_force;
        vec23.f423649x += vec2.f423649x;
        vec23.f423650y += vec2.f423650y;
        float f16 = this.m_torque;
        float f17 = vec22.f423649x;
        Vec2 vec24 = this.m_sweep.f423645c;
        this.m_torque = f16 + (((f17 - vec24.f423649x) * vec2.f423650y) - ((vec22.f423650y - vec24.f423650y) * vec2.f423649x));
    }

    public final void applyForceToCenter(Vec2 vec2) {
        if (this.m_type != BodyType.DYNAMIC) {
            return;
        }
        if (!isAwake()) {
            setAwake(true);
        }
        Vec2 vec22 = this.m_force;
        vec22.f423649x += vec2.f423649x;
        vec22.f423650y += vec2.f423650y;
    }

    public final void applyLinearImpulse(Vec2 vec2, Vec2 vec22) {
        if (this.m_type != BodyType.DYNAMIC) {
            return;
        }
        if (!isAwake()) {
            setAwake(true);
        }
        Vec2 vec23 = this.m_linearVelocity;
        float f16 = vec23.f423649x;
        float f17 = vec2.f423649x;
        float f18 = this.m_invMass;
        vec23.f423649x = f16 + (f17 * f18);
        vec23.f423650y += vec2.f423650y * f18;
        float f19 = this.m_angularVelocity;
        float f26 = this.m_invI;
        float f27 = vec22.f423649x;
        Vec2 vec24 = this.m_sweep.f423645c;
        this.m_angularVelocity = f19 + (f26 * (((f27 - vec24.f423649x) * vec2.f423650y) - ((vec22.f423650y - vec24.f423650y) * vec2.f423649x)));
    }

    public final void applyTorque(float f16) {
        if (this.m_type != BodyType.DYNAMIC) {
            return;
        }
        if (!isAwake()) {
            setAwake(true);
        }
        this.m_torque += f16;
    }

    public final Fixture createFixture(FixtureDef fixtureDef) {
        if (this.m_world.isLocked()) {
            return null;
        }
        Fixture fixture = new Fixture();
        fixture.create(this, fixtureDef);
        if ((this.m_flags & 32) == 32) {
            fixture.createProxies(this.m_world.m_contactManager.m_broadPhase, this.m_xf);
        }
        fixture.m_next = this.m_fixtureList;
        this.m_fixtureList = fixture;
        this.m_fixtureCount++;
        fixture.m_body = this;
        if (fixture.m_density > 0.0f) {
            resetMassData();
        }
        World world = this.m_world;
        world.m_flags = 1 | world.m_flags;
        return fixture;
    }

    public final void destroyFixture(Fixture fixture) {
        if (this.m_world.isLocked()) {
            return;
        }
        Fixture fixture2 = this.m_fixtureList;
        Fixture fixture3 = null;
        while (true) {
            if (fixture2 == null) {
                break;
            }
            if (fixture2 == fixture) {
                Fixture fixture4 = fixture.m_next;
                break;
            } else {
                fixture3 = fixture2;
                fixture2 = fixture2.m_next;
            }
        }
        if (fixture3 == null) {
            this.m_fixtureList = fixture.m_next;
        } else {
            fixture3.m_next = fixture.m_next;
        }
        ContactEdge contactEdge = this.m_contactList;
        while (contactEdge != null) {
            Contact contact = contactEdge.contact;
            contactEdge = contactEdge.next;
            Fixture fixtureA = contact.getFixtureA();
            Fixture fixtureB = contact.getFixtureB();
            if (fixture == fixtureA || fixture == fixtureB) {
                this.m_world.m_contactManager.destroy(contact);
            }
        }
        if ((this.m_flags & 32) == 32) {
            fixture.destroyProxies(this.m_world.m_contactManager.m_broadPhase);
        }
        fixture.destroy();
        fixture.m_body = null;
        fixture.m_next = null;
        this.m_fixtureCount--;
        resetMassData();
    }

    public final float getAngle() {
        return this.m_sweep.f423643a;
    }

    public final float getAngularDamping() {
        return this.m_angularDamping;
    }

    public final float getAngularVelocity() {
        return this.m_angularVelocity;
    }

    public final ContactEdge getContactList() {
        return this.m_contactList;
    }

    public final Fixture getFixtureList() {
        return this.m_fixtureList;
    }

    public float getGravityScale() {
        return this.m_gravityScale;
    }

    public final float getInertia() {
        float f16 = this.m_I;
        float f17 = this.m_mass;
        Vec2 vec2 = this.m_sweep.localCenter;
        float f18 = vec2.f423649x;
        float f19 = vec2.f423650y;
        return f16 + (f17 * ((f18 * f18) + (f19 * f19)));
    }

    public final JointEdge getJointList() {
        return this.m_jointList;
    }

    public final float getLinearDamping() {
        return this.m_linearDamping;
    }

    public final Vec2 getLinearVelocity() {
        return this.m_linearVelocity;
    }

    public final Vec2 getLinearVelocityFromLocalPoint(Vec2 vec2) {
        Vec2 vec22 = new Vec2();
        getLinearVelocityFromLocalPointToOut(vec2, vec22);
        return vec22;
    }

    public final void getLinearVelocityFromLocalPointToOut(Vec2 vec2, Vec2 vec22) {
        getWorldPointToOut(vec2, vec22);
        getLinearVelocityFromWorldPointToOut(vec22, vec22);
    }

    public final Vec2 getLinearVelocityFromWorldPoint(Vec2 vec2) {
        Vec2 vec22 = new Vec2();
        getLinearVelocityFromWorldPointToOut(vec2, vec22);
        return vec22;
    }

    public final void getLinearVelocityFromWorldPointToOut(Vec2 vec2, Vec2 vec22) {
        vec22.set(vec2).subLocal(this.m_sweep.f423645c);
        Vec2.crossToOut(this.m_angularVelocity, vec22, vec22);
        vec22.addLocal(this.m_linearVelocity);
    }

    public final Vec2 getLocalCenter() {
        return this.m_sweep.localCenter;
    }

    public final Vec2 getLocalPoint(Vec2 vec2) {
        Vec2 vec22 = new Vec2();
        getLocalPointToOut(vec2, vec22);
        return vec22;
    }

    public final void getLocalPointToOut(Vec2 vec2, Vec2 vec22) {
        Transform.mulTransToOut(this.m_xf, vec2, vec22);
    }

    public final Vec2 getLocalVector(Vec2 vec2) {
        Vec2 vec22 = new Vec2();
        getLocalVectorToOut(vec2, vec22);
        return vec22;
    }

    public final void getLocalVectorToOut(Vec2 vec2, Vec2 vec22) {
        Rot.mulTrans(this.m_xf.f423648q, vec2, vec22);
    }

    public final void getLocalVectorToOutUnsafe(Vec2 vec2, Vec2 vec22) {
        Rot.mulTransUnsafe(this.m_xf.f423648q, vec2, vec22);
    }

    public final float getMass() {
        return this.m_mass;
    }

    public final void getMassData(MassData massData) {
        float f16 = this.m_mass;
        massData.mass = f16;
        float f17 = this.m_I;
        Vec2 vec2 = this.m_sweep.localCenter;
        float f18 = vec2.f423649x;
        float f19 = vec2.f423650y;
        massData.I = f17 + (f16 * ((f18 * f18) + (f19 * f19)));
        Vec2 vec22 = massData.center;
        vec22.f423649x = f18;
        vec22.f423650y = f19;
    }

    public final Body getNext() {
        return this.m_next;
    }

    public final Vec2 getPosition() {
        return this.m_xf.f423647p;
    }

    public final Transform getTransform() {
        return this.m_xf;
    }

    public BodyType getType() {
        return this.m_type;
    }

    public final Object getUserData() {
        return this.m_userData;
    }

    public final World getWorld() {
        return this.m_world;
    }

    public final Vec2 getWorldCenter() {
        return this.m_sweep.f423645c;
    }

    public final Vec2 getWorldPoint(Vec2 vec2) {
        Vec2 vec22 = new Vec2();
        getWorldPointToOut(vec2, vec22);
        return vec22;
    }

    public final void getWorldPointToOut(Vec2 vec2, Vec2 vec22) {
        Transform.mulToOut(this.m_xf, vec2, vec22);
    }

    public final Vec2 getWorldVector(Vec2 vec2) {
        Vec2 vec22 = new Vec2();
        getWorldVectorToOut(vec2, vec22);
        return vec22;
    }

    public final void getWorldVectorToOut(Vec2 vec2, Vec2 vec22) {
        Rot.mulToOut(this.m_xf.f423648q, vec2, vec22);
    }

    public final void getWorldVectorToOutUnsafe(Vec2 vec2, Vec2 vec22) {
        Rot.mulToOutUnsafe(this.m_xf.f423648q, vec2, vec22);
    }

    public boolean isActive() {
        if ((this.m_flags & 32) == 32) {
            return true;
        }
        return false;
    }

    public boolean isAwake() {
        if ((this.m_flags & 2) == 2) {
            return true;
        }
        return false;
    }

    public final boolean isBullet() {
        if ((this.m_flags & 8) == 8) {
            return true;
        }
        return false;
    }

    public boolean isFixedRotation() {
        if ((this.m_flags & 16) == 16) {
            return true;
        }
        return false;
    }

    public boolean isSleepingAllowed() {
        if ((this.m_flags & 4) == 4) {
            return true;
        }
        return false;
    }

    public final void resetMassData() {
        this.m_mass = 0.0f;
        this.m_invMass = 0.0f;
        this.m_I = 0.0f;
        this.m_invI = 0.0f;
        this.m_sweep.localCenter.setZero();
        BodyType bodyType = this.m_type;
        if (bodyType != BodyType.STATIC && bodyType != BodyType.KINEMATIC) {
            Vec2 popVec2 = this.m_world.getPool().popVec2();
            popVec2.setZero();
            Vec2 popVec22 = this.m_world.getPool().popVec2();
            MassData massData = this.pmd;
            for (Fixture fixture = this.m_fixtureList; fixture != null; fixture = fixture.m_next) {
                if (fixture.m_density != 0.0f) {
                    fixture.getMassData(massData);
                    this.m_mass += massData.mass;
                    popVec22.set(massData.center).mulLocal(massData.mass);
                    popVec2.addLocal(popVec22);
                    this.m_I += massData.I;
                }
            }
            float f16 = this.m_mass;
            if (f16 > 0.0f) {
                float f17 = 1.0f / f16;
                this.m_invMass = f17;
                popVec2.mulLocal(f17);
            } else {
                this.m_mass = 1.0f;
                this.m_invMass = 1.0f;
            }
            float f18 = this.m_I;
            if (f18 > 0.0f && (this.m_flags & 16) == 0) {
                float dot = f18 - (this.m_mass * Vec2.dot(popVec2, popVec2));
                this.m_I = dot;
                this.m_invI = 1.0f / dot;
            } else {
                this.m_I = 0.0f;
                this.m_invI = 0.0f;
            }
            Vec2 popVec23 = this.m_world.getPool().popVec2();
            popVec23.set(this.m_sweep.f423645c);
            this.m_sweep.localCenter.set(popVec2);
            Transform transform = this.m_xf;
            Sweep sweep = this.m_sweep;
            Transform.mulToOutUnsafe(transform, sweep.localCenter, sweep.f423646c0);
            Sweep sweep2 = this.m_sweep;
            sweep2.f423645c.set(sweep2.f423646c0);
            popVec22.set(this.m_sweep.f423645c).subLocal(popVec23);
            Vec2.crossToOutUnsafe(this.m_angularVelocity, popVec22, popVec23);
            this.m_linearVelocity.addLocal(popVec23);
            this.m_world.getPool().pushVec2(3);
            return;
        }
        this.m_sweep.f423646c0.set(this.m_xf.f423647p);
        this.m_sweep.f423645c.set(this.m_xf.f423647p);
        Sweep sweep3 = this.m_sweep;
        sweep3.f423644a0 = sweep3.f423643a;
    }

    public void setActive(boolean z16) {
        if (z16 == isActive()) {
            return;
        }
        if (z16) {
            this.m_flags |= 32;
            BroadPhase broadPhase = this.m_world.m_contactManager.m_broadPhase;
            for (Fixture fixture = this.m_fixtureList; fixture != null; fixture = fixture.m_next) {
                fixture.createProxies(broadPhase, this.m_xf);
            }
            return;
        }
        this.m_flags &= -33;
        BroadPhase broadPhase2 = this.m_world.m_contactManager.m_broadPhase;
        for (Fixture fixture2 = this.m_fixtureList; fixture2 != null; fixture2 = fixture2.m_next) {
            fixture2.destroyProxies(broadPhase2);
        }
        ContactEdge contactEdge = this.m_contactList;
        while (contactEdge != null) {
            ContactEdge contactEdge2 = contactEdge.next;
            this.m_world.m_contactManager.destroy(contactEdge.contact);
            contactEdge = contactEdge2;
        }
        this.m_contactList = null;
    }

    public final void setAngularDamping(float f16) {
        this.m_angularDamping = f16;
    }

    public final void setAngularVelocity(float f16) {
        if (this.m_type == BodyType.STATIC) {
            return;
        }
        if (f16 * f16 > 0.0f) {
            setAwake(true);
        }
        this.m_angularVelocity = f16;
    }

    public void setAwake(boolean z16) {
        if (z16) {
            int i3 = this.m_flags;
            if ((i3 & 2) == 0) {
                this.m_flags = i3 | 2;
                this.m_sleepTime = 0.0f;
                return;
            }
            return;
        }
        this.m_flags &= -3;
        this.m_sleepTime = 0.0f;
        this.m_linearVelocity.setZero();
        this.m_angularVelocity = 0.0f;
        this.m_force.setZero();
        this.m_torque = 0.0f;
    }

    public final void setBullet(boolean z16) {
        if (z16) {
            this.m_flags |= 8;
        } else {
            this.m_flags &= -9;
        }
    }

    public void setFixedRotation(boolean z16) {
        if (z16) {
            this.m_flags |= 16;
        } else {
            this.m_flags &= -17;
        }
        resetMassData();
    }

    public void setGravityScale(float f16) {
        this.m_gravityScale = f16;
    }

    public final void setLinearDamping(float f16) {
        this.m_linearDamping = f16;
    }

    public final void setLinearVelocity(Vec2 vec2) {
        if (this.m_type == BodyType.STATIC) {
            return;
        }
        if (Vec2.dot(vec2, vec2) > 0.0f) {
            setAwake(true);
        }
        this.m_linearVelocity.set(vec2);
    }

    public final void setMassData(MassData massData) {
        if (this.m_world.isLocked() || this.m_type != BodyType.DYNAMIC) {
            return;
        }
        this.m_invMass = 0.0f;
        this.m_I = 0.0f;
        this.m_invI = 0.0f;
        float f16 = massData.mass;
        this.m_mass = f16;
        if (f16 <= 0.0f) {
            this.m_mass = 1.0f;
        }
        float f17 = this.m_mass;
        this.m_invMass = 1.0f / f17;
        float f18 = massData.I;
        if (f18 > 0.0f && (this.m_flags & 16) == 0) {
            Vec2 vec2 = massData.center;
            float dot = f18 - (f17 * Vec2.dot(vec2, vec2));
            this.m_I = dot;
            this.m_invI = 1.0f / dot;
        }
        Vec2 popVec2 = this.m_world.getPool().popVec2();
        popVec2.set(this.m_sweep.f423645c);
        this.m_sweep.localCenter.set(massData.center);
        Transform transform = this.m_xf;
        Sweep sweep = this.m_sweep;
        Transform.mulToOutUnsafe(transform, sweep.localCenter, sweep.f423646c0);
        Sweep sweep2 = this.m_sweep;
        sweep2.f423645c.set(sweep2.f423646c0);
        Vec2 popVec22 = this.m_world.getPool().popVec2();
        popVec22.set(this.m_sweep.f423645c).subLocal(popVec2);
        Vec2.crossToOut(this.m_angularVelocity, popVec22, popVec22);
        this.m_linearVelocity.addLocal(popVec22);
        this.m_world.getPool().pushVec2(2);
    }

    public void setSleepingAllowed(boolean z16) {
        if (z16) {
            this.m_flags |= 4;
        } else {
            this.m_flags &= -5;
            setAwake(true);
        }
    }

    public final void setTransform(Vec2 vec2, float f16) {
        if (this.m_world.isLocked()) {
            return;
        }
        this.m_xf.f423648q.set(f16);
        this.m_xf.f423647p.set(vec2);
        Transform transform = this.m_xf;
        Sweep sweep = this.m_sweep;
        Transform.mulToOutUnsafe(transform, sweep.localCenter, sweep.f423645c);
        Sweep sweep2 = this.m_sweep;
        sweep2.f423643a = f16;
        sweep2.f423646c0.set(sweep2.f423645c);
        Sweep sweep3 = this.m_sweep;
        sweep3.f423644a0 = sweep3.f423643a;
        BroadPhase broadPhase = this.m_world.m_contactManager.m_broadPhase;
        for (Fixture fixture = this.m_fixtureList; fixture != null; fixture = fixture.m_next) {
            Transform transform2 = this.m_xf;
            fixture.synchronize(broadPhase, transform2, transform2);
        }
        this.m_world.m_contactManager.findNewContacts();
    }

    public void setType(BodyType bodyType) {
        if (this.m_world.isLocked() || this.m_type == bodyType) {
            return;
        }
        this.m_type = bodyType;
        resetMassData();
        if (this.m_type == BodyType.STATIC) {
            this.m_linearVelocity.setZero();
            this.m_angularVelocity = 0.0f;
            Sweep sweep = this.m_sweep;
            sweep.f423644a0 = sweep.f423643a;
            sweep.f423646c0.set(sweep.f423645c);
            synchronizeFixtures();
        }
        setAwake(true);
        this.m_force.setZero();
        this.m_torque = 0.0f;
        ContactEdge contactEdge = this.m_contactList;
        while (contactEdge != null) {
            ContactEdge contactEdge2 = contactEdge.next;
            this.m_world.m_contactManager.destroy(contactEdge.contact);
            contactEdge = contactEdge2;
        }
        this.m_contactList = null;
        BroadPhase broadPhase = this.m_world.m_contactManager.m_broadPhase;
        for (Fixture fixture = this.m_fixtureList; fixture != null; fixture = fixture.m_next) {
            int i3 = fixture.m_proxyCount;
            for (int i16 = 0; i16 < i3; i16++) {
                broadPhase.touchProxy(fixture.m_proxies[i16].proxyId);
            }
        }
    }

    public final void setUserData(Object obj) {
        this.m_userData = obj;
    }

    public boolean shouldCollide(Body body) {
        BodyType bodyType = this.m_type;
        BodyType bodyType2 = BodyType.DYNAMIC;
        if (bodyType != bodyType2 && body.m_type != bodyType2) {
            return false;
        }
        for (JointEdge jointEdge = this.m_jointList; jointEdge != null; jointEdge = jointEdge.next) {
            if (jointEdge.other == body && !jointEdge.joint.getCollideConnected()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void synchronizeFixtures() {
        Transform transform = this.pxf;
        transform.f423648q.f423642s = MathUtils.sin(this.m_sweep.f423644a0);
        transform.f423648q.f423641c = MathUtils.cos(this.m_sweep.f423644a0);
        Vec2 vec2 = transform.f423647p;
        Sweep sweep = this.m_sweep;
        Vec2 vec22 = sweep.f423646c0;
        float f16 = vec22.f423649x;
        Rot rot = transform.f423648q;
        float f17 = rot.f423641c;
        Vec2 vec23 = sweep.localCenter;
        float f18 = f16 - (vec23.f423649x * f17);
        float f19 = rot.f423642s;
        float f26 = vec23.f423650y;
        vec2.f423649x = f18 + (f19 * f26);
        vec2.f423650y = (vec22.f423650y - (f19 * vec23.f423649x)) - (f17 * f26);
        for (Fixture fixture = this.m_fixtureList; fixture != null; fixture = fixture.m_next) {
            fixture.synchronize(this.m_world.m_contactManager.m_broadPhase, transform, this.m_xf);
        }
    }

    public final void synchronizeTransform() {
        this.m_xf.f423648q.f423642s = MathUtils.sin(this.m_sweep.f423643a);
        this.m_xf.f423648q.f423641c = MathUtils.cos(this.m_sweep.f423643a);
        Transform transform = this.m_xf;
        Rot rot = transform.f423648q;
        Sweep sweep = this.m_sweep;
        Vec2 vec2 = sweep.localCenter;
        Vec2 vec22 = transform.f423647p;
        Vec2 vec23 = sweep.f423645c;
        float f16 = vec23.f423649x;
        float f17 = rot.f423641c;
        float f18 = f16 - (vec2.f423649x * f17);
        float f19 = rot.f423642s;
        float f26 = vec2.f423650y;
        vec22.f423649x = f18 + (f19 * f26);
        vec22.f423650y = (vec23.f423650y - (f19 * vec2.f423649x)) - (f17 * f26);
    }

    public final Fixture createFixture(Shape shape, float f16) {
        FixtureDef fixtureDef = this.fixDef;
        fixtureDef.shape = shape;
        fixtureDef.density = f16;
        return createFixture(fixtureDef);
    }
}
