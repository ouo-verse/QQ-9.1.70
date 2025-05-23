package org.jbox2d.dynamics;

import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Settings;
import org.jbox2d.common.Sweep;
import org.jbox2d.common.Timer;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.contacts.Contact;
import org.jbox2d.dynamics.contacts.ContactSolver;
import org.jbox2d.dynamics.contacts.ContactVelocityConstraint;
import org.jbox2d.dynamics.contacts.Position;
import org.jbox2d.dynamics.contacts.Velocity;
import org.jbox2d.dynamics.joints.Joint;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Island {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public Body[] m_bodies;
    public int m_bodyCapacity;
    public int m_bodyCount;
    public int m_contactCapacity;
    public int m_contactCount;
    public Contact[] m_contacts;
    public int m_jointCapacity;
    public int m_jointCount;
    public Joint[] m_joints;
    public ContactListener m_listener;
    public Position[] m_positions;
    public Velocity[] m_velocities;
    private final ContactSolver contactSolver = new ContactSolver();
    private final Timer timer = new Timer();
    private final SolverData solverData = new SolverData();
    private final ContactSolver.ContactSolverDef solverDef = new ContactSolver.ContactSolverDef();
    private final ContactSolver toiContactSolver = new ContactSolver();
    private final ContactSolver.ContactSolverDef toiSolverDef = new ContactSolver.ContactSolverDef();
    private final ContactImpulse impulse = new ContactImpulse();

    public void add(Body body) {
        int i3 = this.m_bodyCount;
        body.m_islandIndex = i3;
        this.m_bodies[i3] = body;
        this.m_bodyCount = i3 + 1;
    }

    public void clear() {
        this.m_bodyCount = 0;
        this.m_contactCount = 0;
        this.m_jointCount = 0;
    }

    public void init(int i3, int i16, int i17, ContactListener contactListener) {
        this.m_bodyCapacity = i3;
        this.m_contactCapacity = i16;
        this.m_jointCapacity = i17;
        this.m_bodyCount = 0;
        this.m_contactCount = 0;
        this.m_jointCount = 0;
        this.m_listener = contactListener;
        Body[] bodyArr = this.m_bodies;
        if (bodyArr == null || i3 > bodyArr.length) {
            this.m_bodies = new Body[i3];
        }
        Joint[] jointArr = this.m_joints;
        if (jointArr == null || i17 > jointArr.length) {
            this.m_joints = new Joint[i17];
        }
        Contact[] contactArr = this.m_contacts;
        if (contactArr == null || i16 > contactArr.length) {
            this.m_contacts = new Contact[i16];
        }
        Velocity[] velocityArr = this.m_velocities;
        if (velocityArr == null || i3 > velocityArr.length) {
            if (velocityArr == null) {
                velocityArr = new Velocity[0];
            }
            Velocity[] velocityArr2 = new Velocity[i3];
            this.m_velocities = velocityArr2;
            System.arraycopy(velocityArr, 0, velocityArr2, 0, velocityArr.length);
            int length = velocityArr.length;
            while (true) {
                Velocity[] velocityArr3 = this.m_velocities;
                if (length >= velocityArr3.length) {
                    break;
                }
                velocityArr3[length] = new Velocity();
                length++;
            }
        }
        Position[] positionArr = this.m_positions;
        if (positionArr == null || this.m_bodyCapacity > positionArr.length) {
            if (positionArr == null) {
                positionArr = new Position[0];
            }
            Position[] positionArr2 = new Position[this.m_bodyCapacity];
            this.m_positions = positionArr2;
            System.arraycopy(positionArr, 0, positionArr2, 0, positionArr.length);
            int length2 = positionArr.length;
            while (true) {
                Position[] positionArr3 = this.m_positions;
                if (length2 < positionArr3.length) {
                    positionArr3[length2] = new Position();
                    length2++;
                } else {
                    return;
                }
            }
        }
    }

    public void report(ContactVelocityConstraint[] contactVelocityConstraintArr) {
        if (this.m_listener == null) {
            return;
        }
        for (int i3 = 0; i3 < this.m_contactCount; i3++) {
            Contact contact = this.m_contacts[i3];
            ContactVelocityConstraint contactVelocityConstraint = contactVelocityConstraintArr[i3];
            this.impulse.count = contactVelocityConstraint.pointCount;
            for (int i16 = 0; i16 < contactVelocityConstraint.pointCount; i16++) {
                ContactImpulse contactImpulse = this.impulse;
                float[] fArr = contactImpulse.normalImpulses;
                ContactVelocityConstraint.VelocityConstraintPoint velocityConstraintPoint = contactVelocityConstraint.points[i16];
                fArr[i16] = velocityConstraintPoint.normalImpulse;
                contactImpulse.tangentImpulses[i16] = velocityConstraintPoint.tangentImpulse;
            }
            this.m_listener.postSolve(contact, this.impulse);
        }
    }

    public void solve(Profile profile, TimeStep timeStep, Vec2 vec2, boolean z16) {
        boolean z17;
        float f16 = timeStep.f423654dt;
        for (int i3 = 0; i3 < this.m_bodyCount; i3++) {
            Body body = this.m_bodies[i3];
            Sweep sweep = body.m_sweep;
            Vec2 vec22 = sweep.f423645c;
            float f17 = sweep.f423643a;
            Vec2 vec23 = body.m_linearVelocity;
            float f18 = body.m_angularVelocity;
            sweep.f423646c0.set(vec22);
            Sweep sweep2 = body.m_sweep;
            sweep2.f423644a0 = sweep2.f423643a;
            if (body.m_type == BodyType.DYNAMIC) {
                float f19 = vec23.f423649x;
                float f26 = body.m_gravityScale;
                float f27 = vec2.f423649x * f26;
                float f28 = body.m_invMass;
                Vec2 vec24 = body.m_force;
                vec23.f423649x = f19 + ((f27 + (vec24.f423649x * f28)) * f16);
                vec23.f423650y += ((f26 * vec2.f423650y) + (f28 * vec24.f423650y)) * f16;
                float f29 = f18 + (body.m_invI * f16 * body.m_torque);
                float clamp = MathUtils.clamp(1.0f - (body.m_linearDamping * f16), 0.0f, 1.0f);
                vec23.f423649x *= clamp;
                vec23.f423650y *= clamp;
                f18 = f29 * MathUtils.clamp(1.0f - (body.m_angularDamping * f16), 0.0f, 1.0f);
            }
            Position position = this.m_positions[i3];
            Vec2 vec25 = position.f423665c;
            vec25.f423649x = vec22.f423649x;
            vec25.f423650y = vec22.f423650y;
            position.f423664a = f17;
            Velocity velocity = this.m_velocities[i3];
            Vec2 vec26 = velocity.f423666v;
            vec26.f423649x = vec23.f423649x;
            vec26.f423650y = vec23.f423650y;
            velocity.f423667w = f18;
        }
        this.timer.reset();
        SolverData solverData = this.solverData;
        solverData.step = timeStep;
        Position[] positionArr = this.m_positions;
        solverData.positions = positionArr;
        Velocity[] velocityArr = this.m_velocities;
        solverData.velocities = velocityArr;
        ContactSolver.ContactSolverDef contactSolverDef = this.solverDef;
        contactSolverDef.step = timeStep;
        contactSolverDef.contacts = this.m_contacts;
        contactSolverDef.count = this.m_contactCount;
        contactSolverDef.positions = positionArr;
        contactSolverDef.velocities = velocityArr;
        this.contactSolver.init(contactSolverDef);
        this.contactSolver.initializeVelocityConstraints();
        if (timeStep.warmStarting) {
            this.contactSolver.warmStart();
        }
        for (int i16 = 0; i16 < this.m_jointCount; i16++) {
            this.m_joints[i16].initVelocityConstraints(this.solverData);
        }
        profile.solveInit = this.timer.getMilliseconds();
        this.timer.reset();
        for (int i17 = 0; i17 < timeStep.velocityIterations; i17++) {
            for (int i18 = 0; i18 < this.m_jointCount; i18++) {
                this.m_joints[i18].solveVelocityConstraints(this.solverData);
            }
            this.contactSolver.solveVelocityConstraints();
        }
        this.contactSolver.storeImpulses();
        profile.solveVelocity = this.timer.getMilliseconds();
        for (int i19 = 0; i19 < this.m_bodyCount; i19++) {
            Position position2 = this.m_positions[i19];
            Vec2 vec27 = position2.f423665c;
            float f36 = position2.f423664a;
            Velocity velocity2 = this.m_velocities[i19];
            Vec2 vec28 = velocity2.f423666v;
            float f37 = velocity2.f423667w;
            float f38 = vec28.f423649x * f16;
            float f39 = vec28.f423650y * f16;
            float f46 = (f38 * f38) + (f39 * f39);
            if (f46 > 4.0f) {
                float sqrt = 2.0f / MathUtils.sqrt(f46);
                vec28.f423649x *= sqrt;
                vec28.f423650y *= sqrt;
            }
            float f47 = f16 * f37;
            if (f47 * f47 > Settings.maxRotationSquared) {
                f37 *= 1.5707964f / MathUtils.abs(f47);
            }
            vec27.f423649x += vec28.f423649x * f16;
            vec27.f423650y += vec28.f423650y * f16;
            this.m_positions[i19].f423664a = f36 + (f16 * f37);
            this.m_velocities[i19].f423667w = f37;
        }
        this.timer.reset();
        int i26 = 0;
        while (true) {
            if (i26 >= timeStep.positionIterations) {
                z17 = false;
                break;
            }
            boolean solvePositionConstraints = this.contactSolver.solvePositionConstraints();
            z17 = true;
            boolean z18 = true;
            for (int i27 = 0; i27 < this.m_jointCount; i27++) {
                z18 = z18 && this.m_joints[i27].solvePositionConstraints(this.solverData);
            }
            if (solvePositionConstraints && z18) {
                break;
            } else {
                i26++;
            }
        }
        for (int i28 = 0; i28 < this.m_bodyCount; i28++) {
            Body body2 = this.m_bodies[i28];
            Sweep sweep3 = body2.m_sweep;
            Vec2 vec29 = sweep3.f423645c;
            Position position3 = this.m_positions[i28];
            Vec2 vec210 = position3.f423665c;
            vec29.f423649x = vec210.f423649x;
            vec29.f423650y = vec210.f423650y;
            sweep3.f423643a = position3.f423664a;
            Vec2 vec211 = body2.m_linearVelocity;
            Velocity velocity3 = this.m_velocities[i28];
            Vec2 vec212 = velocity3.f423666v;
            vec211.f423649x = vec212.f423649x;
            vec211.f423650y = vec212.f423650y;
            body2.m_angularVelocity = velocity3.f423667w;
            body2.synchronizeTransform();
        }
        profile.solvePosition = this.timer.getMilliseconds();
        report(this.contactSolver.m_velocityConstraints);
        if (z16) {
            float f48 = Float.MAX_VALUE;
            for (int i29 = 0; i29 < this.m_bodyCount; i29++) {
                Body body3 = this.m_bodies[i29];
                if (body3.getType() != BodyType.STATIC) {
                    if ((body3.m_flags & 4) != 0) {
                        float f49 = body3.m_angularVelocity;
                        if (f49 * f49 <= 0.0012184699f) {
                            Vec2 vec213 = body3.m_linearVelocity;
                            if (Vec2.dot(vec213, vec213) <= 1.0E-4f) {
                                float f56 = body3.m_sleepTime + f16;
                                body3.m_sleepTime = f56;
                                f48 = MathUtils.min(f48, f56);
                            }
                        }
                    }
                    body3.m_sleepTime = 0.0f;
                    f48 = 0.0f;
                }
            }
            if (f48 < 0.5f || !z17) {
                return;
            }
            for (int i36 = 0; i36 < this.m_bodyCount; i36++) {
                this.m_bodies[i36].setAwake(false);
            }
        }
    }

    public void solveTOI(TimeStep timeStep, int i3, int i16) {
        for (int i17 = 0; i17 < this.m_bodyCount; i17++) {
            Position position = this.m_positions[i17];
            Vec2 vec2 = position.f423665c;
            Body body = this.m_bodies[i17];
            Sweep sweep = body.m_sweep;
            Vec2 vec22 = sweep.f423645c;
            vec2.f423649x = vec22.f423649x;
            vec2.f423650y = vec22.f423650y;
            position.f423664a = sweep.f423643a;
            Velocity velocity = this.m_velocities[i17];
            Vec2 vec23 = velocity.f423666v;
            Vec2 vec24 = body.m_linearVelocity;
            vec23.f423649x = vec24.f423649x;
            vec23.f423650y = vec24.f423650y;
            velocity.f423667w = body.m_angularVelocity;
        }
        ContactSolver.ContactSolverDef contactSolverDef = this.toiSolverDef;
        contactSolverDef.contacts = this.m_contacts;
        contactSolverDef.count = this.m_contactCount;
        contactSolverDef.step = timeStep;
        contactSolverDef.positions = this.m_positions;
        contactSolverDef.velocities = this.m_velocities;
        this.toiContactSolver.init(contactSolverDef);
        for (int i18 = 0; i18 < timeStep.positionIterations && !this.toiContactSolver.solveTOIPositionConstraints(i3, i16); i18++) {
        }
        Body[] bodyArr = this.m_bodies;
        Sweep sweep2 = bodyArr[i3].m_sweep;
        Vec2 vec25 = sweep2.f423646c0;
        Position[] positionArr = this.m_positions;
        Position position2 = positionArr[i3];
        Vec2 vec26 = position2.f423665c;
        vec25.f423649x = vec26.f423649x;
        vec25.f423650y = vec26.f423650y;
        sweep2.f423644a0 = position2.f423664a;
        bodyArr[i16].m_sweep.f423646c0.set(positionArr[i16].f423665c);
        this.m_bodies[i16].m_sweep.f423644a0 = this.m_positions[i16].f423664a;
        this.toiContactSolver.initializeVelocityConstraints();
        for (int i19 = 0; i19 < timeStep.velocityIterations; i19++) {
            this.toiContactSolver.solveVelocityConstraints();
        }
        float f16 = timeStep.f423654dt;
        for (int i26 = 0; i26 < this.m_bodyCount; i26++) {
            Position position3 = this.m_positions[i26];
            Vec2 vec27 = position3.f423665c;
            float f17 = position3.f423664a;
            Velocity velocity2 = this.m_velocities[i26];
            Vec2 vec28 = velocity2.f423666v;
            float f18 = velocity2.f423667w;
            float f19 = vec28.f423649x * f16;
            float f26 = vec28.f423650y * f16;
            float f27 = (f19 * f19) + (f26 * f26);
            if (f27 > 4.0f) {
                vec28.mulLocal(2.0f / MathUtils.sqrt(f27));
            }
            float f28 = f16 * f18;
            if (f28 * f28 > Settings.maxRotationSquared) {
                f18 *= 1.5707964f / MathUtils.abs(f28);
            }
            float f29 = vec27.f423649x + (vec28.f423649x * f16);
            vec27.f423649x = f29;
            float f36 = vec27.f423650y + (vec28.f423650y * f16);
            vec27.f423650y = f36;
            float f37 = f17 + (f16 * f18);
            Position position4 = this.m_positions[i26];
            Vec2 vec29 = position4.f423665c;
            vec29.f423649x = f29;
            vec29.f423650y = f36;
            position4.f423664a = f37;
            Velocity velocity3 = this.m_velocities[i26];
            Vec2 vec210 = velocity3.f423666v;
            vec210.f423649x = vec28.f423649x;
            vec210.f423650y = vec28.f423650y;
            velocity3.f423667w = f18;
            Body body2 = this.m_bodies[i26];
            Sweep sweep3 = body2.m_sweep;
            Vec2 vec211 = sweep3.f423645c;
            vec211.f423649x = vec27.f423649x;
            vec211.f423650y = vec27.f423650y;
            sweep3.f423643a = f37;
            Vec2 vec212 = body2.m_linearVelocity;
            vec212.f423649x = vec28.f423649x;
            vec212.f423650y = vec28.f423650y;
            body2.m_angularVelocity = f18;
            body2.synchronizeTransform();
        }
        report(this.toiContactSolver.m_velocityConstraints);
    }

    public void add(Contact contact) {
        Contact[] contactArr = this.m_contacts;
        int i3 = this.m_contactCount;
        this.m_contactCount = i3 + 1;
        contactArr[i3] = contact;
    }

    public void add(Joint joint) {
        Joint[] jointArr = this.m_joints;
        int i3 = this.m_jointCount;
        this.m_jointCount = i3 + 1;
        jointArr[i3] = joint;
    }
}
