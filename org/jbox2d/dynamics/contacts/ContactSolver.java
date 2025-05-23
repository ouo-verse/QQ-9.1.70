package org.jbox2d.dynamics.contacts;

import org.jbox2d.collision.Manifold;
import org.jbox2d.collision.ManifoldPoint;
import org.jbox2d.collision.WorldManifold;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Mat22;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.TimeStep;
import org.jbox2d.dynamics.contacts.ContactVelocityConstraint;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ContactSolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final boolean DEBUG_SOLVER = false;
    public static final int INITIAL_NUM_CONSTRAINTS = 256;
    public static final float k_errorTol = 0.001f;
    public static final float k_maxConditionNumber = 100.0f;
    public Contact[] m_contacts;
    public int m_count;
    public Position[] m_positions;
    public TimeStep m_step;
    public Velocity[] m_velocities;
    private final Vec2 tangent = new Vec2();
    private final Vec2 temp1 = new Vec2();
    private final Vec2 temp2 = new Vec2();
    private final Vec2 P = new Vec2();
    private final Vec2 temp = new Vec2();
    private final Transform xfA = new Transform();
    private final Transform xfB = new Transform();
    private final WorldManifold worldManifold = new WorldManifold();

    /* renamed from: a, reason: collision with root package name */
    private final Vec2 f423658a = new Vec2();

    /* renamed from: b, reason: collision with root package name */
    private final Vec2 f423659b = new Vec2();

    /* renamed from: dv1, reason: collision with root package name */
    private final Vec2 f423661dv1 = new Vec2();

    /* renamed from: dv2, reason: collision with root package name */
    private final Vec2 f423662dv2 = new Vec2();

    /* renamed from: x, reason: collision with root package name */
    private final Vec2 f423663x = new Vec2();

    /* renamed from: d, reason: collision with root package name */
    private final Vec2 f423660d = new Vec2();
    private final Vec2 P1 = new Vec2();
    private final Vec2 P2 = new Vec2();
    private final PositionSolverManifold psolver = new PositionSolverManifold();
    private final Vec2 rA = new Vec2();
    private final Vec2 rB = new Vec2();
    public ContactPositionConstraint[] m_positionConstraints = new ContactPositionConstraint[256];
    public ContactVelocityConstraint[] m_velocityConstraints = new ContactVelocityConstraint[256];

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class ContactSolverDef {
        public Contact[] contacts;
        public int count;
        public Position[] positions;
        public TimeStep step;
        public Velocity[] velocities;
    }

    public ContactSolver() {
        for (int i3 = 0; i3 < 256; i3++) {
            this.m_positionConstraints[i3] = new ContactPositionConstraint();
            this.m_velocityConstraints[i3] = new ContactVelocityConstraint();
        }
    }

    public final void init(ContactSolverDef contactSolverDef) {
        this.m_step = contactSolverDef.step;
        int i3 = contactSolverDef.count;
        this.m_count = i3;
        ContactPositionConstraint[] contactPositionConstraintArr = this.m_positionConstraints;
        if (contactPositionConstraintArr.length < i3) {
            ContactPositionConstraint[] contactPositionConstraintArr2 = new ContactPositionConstraint[MathUtils.max(contactPositionConstraintArr.length * 2, i3)];
            this.m_positionConstraints = contactPositionConstraintArr2;
            System.arraycopy(contactPositionConstraintArr, 0, contactPositionConstraintArr2, 0, contactPositionConstraintArr.length);
            int length = contactPositionConstraintArr.length;
            while (true) {
                ContactPositionConstraint[] contactPositionConstraintArr3 = this.m_positionConstraints;
                if (length >= contactPositionConstraintArr3.length) {
                    break;
                }
                contactPositionConstraintArr3[length] = new ContactPositionConstraint();
                length++;
            }
        }
        ContactVelocityConstraint[] contactVelocityConstraintArr = this.m_velocityConstraints;
        int length2 = contactVelocityConstraintArr.length;
        int i16 = this.m_count;
        if (length2 < i16) {
            ContactVelocityConstraint[] contactVelocityConstraintArr2 = new ContactVelocityConstraint[MathUtils.max(contactVelocityConstraintArr.length * 2, i16)];
            this.m_velocityConstraints = contactVelocityConstraintArr2;
            System.arraycopy(contactVelocityConstraintArr, 0, contactVelocityConstraintArr2, 0, contactVelocityConstraintArr.length);
            int length3 = contactVelocityConstraintArr.length;
            while (true) {
                ContactVelocityConstraint[] contactVelocityConstraintArr3 = this.m_velocityConstraints;
                if (length3 >= contactVelocityConstraintArr3.length) {
                    break;
                }
                contactVelocityConstraintArr3[length3] = new ContactVelocityConstraint();
                length3++;
            }
        }
        this.m_positions = contactSolverDef.positions;
        this.m_velocities = contactSolverDef.velocities;
        this.m_contacts = contactSolverDef.contacts;
        for (int i17 = 0; i17 < this.m_count; i17++) {
            Contact contact = this.m_contacts[i17];
            Fixture fixture = contact.m_fixtureA;
            Fixture fixture2 = contact.m_fixtureB;
            Shape shape = fixture.getShape();
            Shape shape2 = fixture2.getShape();
            float f16 = shape.m_radius;
            float f17 = shape2.m_radius;
            Body body = fixture.getBody();
            Body body2 = fixture2.getBody();
            Manifold manifold = contact.getManifold();
            int i18 = manifold.pointCount;
            ContactVelocityConstraint contactVelocityConstraint = this.m_velocityConstraints[i17];
            contactVelocityConstraint.friction = contact.m_friction;
            contactVelocityConstraint.restitution = contact.m_restitution;
            contactVelocityConstraint.tangentSpeed = contact.m_tangentSpeed;
            contactVelocityConstraint.indexA = body.m_islandIndex;
            contactVelocityConstraint.indexB = body2.m_islandIndex;
            contactVelocityConstraint.invMassA = body.m_invMass;
            contactVelocityConstraint.invMassB = body2.m_invMass;
            contactVelocityConstraint.invIA = body.m_invI;
            contactVelocityConstraint.invIB = body2.m_invI;
            contactVelocityConstraint.contactIndex = i17;
            contactVelocityConstraint.pointCount = i18;
            contactVelocityConstraint.K.setZero();
            contactVelocityConstraint.normalMass.setZero();
            ContactPositionConstraint contactPositionConstraint = this.m_positionConstraints[i17];
            contactPositionConstraint.indexA = body.m_islandIndex;
            contactPositionConstraint.indexB = body2.m_islandIndex;
            contactPositionConstraint.invMassA = body.m_invMass;
            contactPositionConstraint.invMassB = body2.m_invMass;
            contactPositionConstraint.localCenterA.set(body.m_sweep.localCenter);
            contactPositionConstraint.localCenterB.set(body2.m_sweep.localCenter);
            contactPositionConstraint.invIA = body.m_invI;
            contactPositionConstraint.invIB = body2.m_invI;
            contactPositionConstraint.localNormal.set(manifold.localNormal);
            contactPositionConstraint.localPoint.set(manifold.localPoint);
            contactPositionConstraint.pointCount = i18;
            contactPositionConstraint.radiusA = f16;
            contactPositionConstraint.radiusB = f17;
            contactPositionConstraint.type = manifold.type;
            for (int i19 = 0; i19 < i18; i19++) {
                ManifoldPoint manifoldPoint = manifold.points[i19];
                ContactVelocityConstraint.VelocityConstraintPoint velocityConstraintPoint = contactVelocityConstraint.points[i19];
                TimeStep timeStep = this.m_step;
                if (timeStep.warmStarting) {
                    float f18 = timeStep.dtRatio;
                    velocityConstraintPoint.normalImpulse = manifoldPoint.normalImpulse * f18;
                    velocityConstraintPoint.tangentImpulse = f18 * manifoldPoint.tangentImpulse;
                } else {
                    velocityConstraintPoint.normalImpulse = 0.0f;
                    velocityConstraintPoint.tangentImpulse = 0.0f;
                }
                velocityConstraintPoint.rA.setZero();
                velocityConstraintPoint.rB.setZero();
                velocityConstraintPoint.normalMass = 0.0f;
                velocityConstraintPoint.tangentMass = 0.0f;
                velocityConstraintPoint.velocityBias = 0.0f;
                Vec2 vec2 = contactPositionConstraint.localPoints[i19];
                Vec2 vec22 = manifoldPoint.localPoint;
                vec2.f423649x = vec22.f423649x;
                vec2.f423650y = vec22.f423650y;
            }
        }
    }

    public final void initializeVelocityConstraints() {
        float f16;
        ContactSolver contactSolver = this;
        int i3 = 0;
        while (i3 < contactSolver.m_count) {
            ContactVelocityConstraint contactVelocityConstraint = contactSolver.m_velocityConstraints[i3];
            ContactPositionConstraint contactPositionConstraint = contactSolver.m_positionConstraints[i3];
            float f17 = contactPositionConstraint.radiusA;
            float f18 = contactPositionConstraint.radiusB;
            Manifold manifold = contactSolver.m_contacts[contactVelocityConstraint.contactIndex].getManifold();
            int i16 = contactVelocityConstraint.indexA;
            int i17 = contactVelocityConstraint.indexB;
            float f19 = contactVelocityConstraint.invMassA;
            float f26 = contactVelocityConstraint.invMassB;
            float f27 = contactVelocityConstraint.invIA;
            float f28 = contactVelocityConstraint.invIB;
            Vec2 vec2 = contactPositionConstraint.localCenterA;
            Vec2 vec22 = contactPositionConstraint.localCenterB;
            Position[] positionArr = contactSolver.m_positions;
            Position position = positionArr[i16];
            int i18 = i3;
            Vec2 vec23 = position.f423665c;
            float f29 = position.f423664a;
            Velocity[] velocityArr = contactSolver.m_velocities;
            Velocity velocity = velocityArr[i16];
            Vec2 vec24 = velocity.f423666v;
            float f36 = velocity.f423667w;
            Position position2 = positionArr[i17];
            Vec2 vec25 = vec24;
            Vec2 vec26 = position2.f423665c;
            float f37 = position2.f423664a;
            Velocity velocity2 = velocityArr[i17];
            Vec2 vec27 = velocity2.f423666v;
            float f38 = velocity2.f423667w;
            contactSolver.xfA.f423648q.set(f29);
            contactSolver.xfB.f423648q.set(f37);
            Transform transform = contactSolver.xfA;
            Vec2 vec28 = transform.f423647p;
            float f39 = vec23.f423649x;
            Rot rot = transform.f423648q;
            Vec2 vec29 = vec27;
            float f46 = rot.f423641c;
            float f47 = vec2.f423649x * f46;
            float f48 = rot.f423642s;
            float f49 = vec2.f423650y;
            vec28.f423649x = f39 - (f47 - (f48 * f49));
            vec28.f423650y = vec23.f423650y - ((f48 * vec2.f423649x) + (f46 * f49));
            Transform transform2 = contactSolver.xfB;
            Vec2 vec210 = transform2.f423647p;
            float f56 = vec26.f423649x;
            Rot rot2 = transform2.f423648q;
            float f57 = rot2.f423641c;
            float f58 = vec22.f423649x * f57;
            float f59 = rot2.f423642s;
            float f65 = vec22.f423650y;
            vec210.f423649x = f56 - (f58 - (f59 * f65));
            vec210.f423650y = vec26.f423650y - ((f59 * vec22.f423649x) + (f57 * f65));
            contactSolver.worldManifold.initialize(manifold, transform, f17, transform2, f18);
            contactVelocityConstraint.normal.set(contactSolver.worldManifold.normal);
            int i19 = contactVelocityConstraint.pointCount;
            int i26 = 0;
            while (i26 < i19) {
                ContactVelocityConstraint.VelocityConstraintPoint velocityConstraintPoint = contactVelocityConstraint.points[i26];
                velocityConstraintPoint.rA.set(contactSolver.worldManifold.points[i26]).subLocal(vec23);
                velocityConstraintPoint.rB.set(contactSolver.worldManifold.points[i26]).subLocal(vec26);
                Vec2 vec211 = velocityConstraintPoint.rA;
                float f66 = vec211.f423649x;
                Vec2 vec212 = contactVelocityConstraint.normal;
                float f67 = vec212.f423650y;
                float f68 = vec211.f423650y;
                float f69 = vec212.f423649x;
                float f75 = (f66 * f67) - (f68 * f69);
                Vec2 vec213 = velocityConstraintPoint.rB;
                float f76 = vec213.f423649x;
                float f77 = vec213.f423650y;
                float f78 = (f76 * f67) - (f77 * f69);
                float f79 = f19 + f26;
                float f85 = f79 + (f27 * f75 * f75) + (f28 * f78 * f78);
                float f86 = 0.0f;
                if (f85 > 0.0f) {
                    f86 = 1.0f / f85;
                }
                velocityConstraintPoint.normalMass = f86;
                float f87 = f67 * 1.0f;
                float f88 = f69 * (-1.0f);
                float f89 = (f66 * f88) - (f68 * f87);
                float f95 = (f88 * f76) - (f87 * f77);
                float f96 = f79 + (f27 * f89 * f89) + (f28 * f95 * f95);
                if (f96 > 0.0f) {
                    f16 = 1.0f / f96;
                } else {
                    f16 = 0.0f;
                }
                velocityConstraintPoint.tangentMass = f16;
                velocityConstraintPoint.velocityBias = 0.0f;
                Vec2 vec214 = vec29;
                int i27 = i19;
                Vec2 vec215 = vec25;
                float f97 = (f69 * (((vec214.f423649x + ((-f38) * f77)) - vec215.f423649x) - ((-f36) * f68))) + (f67 * (((vec214.f423650y + (f38 * f76)) - vec215.f423650y) - (f66 * f36)));
                if (f97 < -1.0f) {
                    velocityConstraintPoint.velocityBias = (-contactVelocityConstraint.restitution) * f97;
                }
                i26++;
                vec29 = vec214;
                vec25 = vec215;
                i19 = i27;
                contactSolver = this;
            }
            if (contactVelocityConstraint.pointCount == 2) {
                ContactVelocityConstraint.VelocityConstraintPoint[] velocityConstraintPointArr = contactVelocityConstraint.points;
                ContactVelocityConstraint.VelocityConstraintPoint velocityConstraintPoint2 = velocityConstraintPointArr[0];
                ContactVelocityConstraint.VelocityConstraintPoint velocityConstraintPoint3 = velocityConstraintPointArr[1];
                float cross = Vec2.cross(velocityConstraintPoint2.rA, contactVelocityConstraint.normal);
                float cross2 = Vec2.cross(velocityConstraintPoint2.rB, contactVelocityConstraint.normal);
                float cross3 = Vec2.cross(velocityConstraintPoint3.rA, contactVelocityConstraint.normal);
                float cross4 = Vec2.cross(velocityConstraintPoint3.rB, contactVelocityConstraint.normal);
                float f98 = f19 + f26;
                float f99 = f27 * cross;
                float f100 = f28 * cross2;
                float f101 = (cross * f99) + f98 + (cross2 * f100);
                float f102 = (f27 * cross3 * cross3) + f98 + (f28 * cross4 * cross4);
                float f103 = f98 + (f99 * cross3) + (f100 * cross4);
                if (f101 * f101 < ((f101 * f102) - (f103 * f103)) * 100.0f) {
                    contactVelocityConstraint.K.f423636ex.set(f101, f103);
                    contactVelocityConstraint.K.f423637ey.set(f103, f102);
                    contactVelocityConstraint.K.invertToOut(contactVelocityConstraint.normalMass);
                } else {
                    contactVelocityConstraint.pointCount = 1;
                }
            }
            i3 = i18 + 1;
            contactSolver = this;
        }
    }

    public final boolean solvePositionConstraints() {
        float f16;
        int i3 = 0;
        float f17 = 0.0f;
        while (i3 < this.m_count) {
            ContactPositionConstraint contactPositionConstraint = this.m_positionConstraints[i3];
            int i16 = contactPositionConstraint.indexA;
            int i17 = contactPositionConstraint.indexB;
            float f18 = contactPositionConstraint.invMassA;
            float f19 = contactPositionConstraint.invIA;
            Vec2 vec2 = contactPositionConstraint.localCenterA;
            float f26 = contactPositionConstraint.invMassB;
            float f27 = contactPositionConstraint.invIB;
            Vec2 vec22 = contactPositionConstraint.localCenterB;
            int i18 = contactPositionConstraint.pointCount;
            Position[] positionArr = this.m_positions;
            Position position = positionArr[i16];
            Vec2 vec23 = position.f423665c;
            float f28 = position.f423664a;
            Position position2 = positionArr[i17];
            Vec2 vec24 = position2.f423665c;
            int i19 = 0;
            int i26 = i3;
            float f29 = position2.f423664a;
            float f36 = f17;
            float f37 = f28;
            while (i19 < i18) {
                int i27 = i18;
                this.xfA.f423648q.set(f37);
                this.xfB.f423648q.set(f29);
                Transform transform = this.xfA;
                int i28 = i16;
                Rot.mulToOutUnsafe(transform.f423648q, vec2, transform.f423647p);
                this.xfA.f423647p.negateLocal().addLocal(vec23);
                Transform transform2 = this.xfB;
                Rot.mulToOutUnsafe(transform2.f423648q, vec22, transform2.f423647p);
                this.xfB.f423647p.negateLocal().addLocal(vec24);
                PositionSolverManifold positionSolverManifold = this.psolver;
                Vec2 vec25 = vec2;
                positionSolverManifold.initialize(contactPositionConstraint, this.xfA, this.xfB, i19);
                Vec2 vec26 = positionSolverManifold.normal;
                Vec2 vec27 = positionSolverManifold.point;
                float f38 = positionSolverManifold.separation;
                ContactPositionConstraint contactPositionConstraint2 = contactPositionConstraint;
                this.rA.set(vec27).subLocal(vec23);
                this.rB.set(vec27).subLocal(vec24);
                f36 = MathUtils.min(f36, f38);
                float clamp = MathUtils.clamp((f38 + 0.005f) * 0.2f, -0.2f, 0.0f);
                float cross = Vec2.cross(this.rA, vec26);
                float cross2 = Vec2.cross(this.rB, vec26);
                float f39 = f18 + f26 + (f19 * cross * cross) + (f27 * cross2 * cross2);
                if (f39 > 0.0f) {
                    f16 = (-clamp) / f39;
                } else {
                    f16 = 0.0f;
                }
                this.P.set(vec26).mulLocal(f16);
                vec23.subLocal(this.temp.set(this.P).mulLocal(f18));
                f37 -= Vec2.cross(this.rA, this.P) * f19;
                vec24.addLocal(this.temp.set(this.P).mulLocal(f26));
                f29 += Vec2.cross(this.rB, this.P) * f27;
                i19++;
                i18 = i27;
                i16 = i28;
                vec2 = vec25;
                contactPositionConstraint = contactPositionConstraint2;
            }
            Position[] positionArr2 = this.m_positions;
            positionArr2[i16].f423664a = f37;
            positionArr2[i17].f423664a = f29;
            i3 = i26 + 1;
            f17 = f36;
        }
        if (f17 >= -0.015f) {
            return true;
        }
        return false;
    }

    public boolean solveTOIPositionConstraints(int i3, int i16) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        int i17 = i3;
        int i18 = i16;
        int i19 = 0;
        float f27 = 0.0f;
        while (i19 < this.m_count) {
            ContactPositionConstraint contactPositionConstraint = this.m_positionConstraints[i19];
            int i26 = contactPositionConstraint.indexA;
            int i27 = contactPositionConstraint.indexB;
            Vec2 vec2 = contactPositionConstraint.localCenterA;
            Vec2 vec22 = contactPositionConstraint.localCenterB;
            int i28 = contactPositionConstraint.pointCount;
            if (i26 != i17 && i26 != i18) {
                f16 = 0.0f;
                f17 = 0.0f;
            } else {
                f16 = contactPositionConstraint.invMassA;
                f17 = contactPositionConstraint.invIA;
            }
            if (i27 != i17 && i27 != i18) {
                f19 = 0.0f;
                f18 = 0.0f;
            } else {
                f18 = contactPositionConstraint.invMassB;
                f19 = contactPositionConstraint.invIB;
            }
            Position[] positionArr = this.m_positions;
            Position position = positionArr[i26];
            Vec2 vec23 = position.f423665c;
            float f28 = position.f423664a;
            Position position2 = positionArr[i27];
            Vec2 vec24 = position2.f423665c;
            int i29 = 0;
            float f29 = f27;
            float f36 = position2.f423664a;
            float f37 = f28;
            int i36 = i19;
            float f38 = f29;
            while (i29 < i28) {
                int i37 = i28;
                this.xfA.f423648q.set(f37);
                this.xfB.f423648q.set(f36);
                Transform transform = this.xfA;
                int i38 = i26;
                Rot.mulToOutUnsafe(transform.f423648q, vec2, transform.f423647p);
                this.xfA.f423647p.negateLocal().addLocal(vec23);
                Transform transform2 = this.xfB;
                Rot.mulToOutUnsafe(transform2.f423648q, vec22, transform2.f423647p);
                this.xfB.f423647p.negateLocal().addLocal(vec24);
                PositionSolverManifold positionSolverManifold = this.psolver;
                Vec2 vec25 = vec2;
                positionSolverManifold.initialize(contactPositionConstraint, this.xfA, this.xfB, i29);
                Vec2 vec26 = positionSolverManifold.normal;
                Vec2 vec27 = positionSolverManifold.point;
                float f39 = positionSolverManifold.separation;
                ContactPositionConstraint contactPositionConstraint2 = contactPositionConstraint;
                this.rA.set(vec27).subLocal(vec23);
                this.rB.set(vec27).subLocal(vec24);
                f38 = MathUtils.min(f38, f39);
                float clamp = MathUtils.clamp((f39 + 0.005f) * 0.75f, -0.2f, 0.0f);
                float cross = Vec2.cross(this.rA, vec26);
                float cross2 = Vec2.cross(this.rB, vec26);
                float f46 = f16 + f18 + (f17 * cross * cross) + (f19 * cross2 * cross2);
                if (f46 > 0.0f) {
                    f26 = (-clamp) / f46;
                } else {
                    f26 = 0.0f;
                }
                this.P.set(vec26).mulLocal(f26);
                vec23.subLocal(this.temp.set(this.P).mulLocal(f16));
                f37 -= Vec2.cross(this.rA, this.P) * f17;
                vec24.addLocal(this.temp.set(this.P).mulLocal(f18));
                f36 += Vec2.cross(this.rB, this.P) * f19;
                i29++;
                i28 = i37;
                i26 = i38;
                vec2 = vec25;
                contactPositionConstraint = contactPositionConstraint2;
            }
            Position[] positionArr2 = this.m_positions;
            positionArr2[i26].f423664a = f37;
            positionArr2[i27].f423664a = f36;
            i18 = i16;
            f27 = f38;
            i19 = i36 + 1;
            i17 = i3;
        }
        if (f27 >= -0.0075f) {
            return true;
        }
        return false;
    }

    public final void solveVelocityConstraints() {
        ContactSolver contactSolver;
        float f16;
        float f17;
        float f18;
        float f19;
        ContactSolver contactSolver2 = this;
        int i3 = 0;
        while (i3 < contactSolver2.m_count) {
            ContactVelocityConstraint contactVelocityConstraint = contactSolver2.m_velocityConstraints[i3];
            int i16 = contactVelocityConstraint.indexA;
            int i17 = contactVelocityConstraint.indexB;
            float f26 = contactVelocityConstraint.invMassA;
            float f27 = contactVelocityConstraint.invMassB;
            float f28 = contactVelocityConstraint.invIA;
            float f29 = contactVelocityConstraint.invIB;
            int i18 = contactVelocityConstraint.pointCount;
            Velocity[] velocityArr = contactSolver2.m_velocities;
            Velocity velocity = velocityArr[i16];
            Vec2 vec2 = velocity.f423666v;
            float f36 = velocity.f423667w;
            Velocity velocity2 = velocityArr[i17];
            Vec2 vec22 = velocity2.f423666v;
            float f37 = velocity2.f423667w;
            Vec2 vec23 = contactVelocityConstraint.normal;
            Vec2 vec24 = contactSolver2.tangent;
            vec24.f423649x = vec23.f423650y * 1.0f;
            vec24.f423650y = vec23.f423649x * (-1.0f);
            float f38 = contactVelocityConstraint.friction;
            float f39 = f37;
            int i19 = i3;
            int i26 = 0;
            while (i26 < i18) {
                int i27 = i18;
                ContactVelocityConstraint.VelocityConstraintPoint velocityConstraintPoint = contactVelocityConstraint.points[i26];
                int i28 = i17;
                Vec2 vec25 = velocityConstraintPoint.rA;
                int i29 = i16;
                Vec2 vec26 = vec23;
                Vec2 vec27 = velocityConstraintPoint.rB;
                int i36 = i26;
                float f46 = ((((-f39) * vec27.f423650y) + vec22.f423649x) - vec2.f423649x) + (vec25.f423650y * f36);
                float f47 = (((vec27.f423649x * f39) + vec22.f423650y) - vec2.f423650y) - (vec25.f423649x * f36);
                Vec2 vec28 = contactSolver2.tangent;
                float f48 = velocityConstraintPoint.tangentMass * (-(((f46 * vec28.f423649x) + (f47 * vec28.f423650y)) - contactVelocityConstraint.tangentSpeed));
                float f49 = velocityConstraintPoint.normalImpulse * f38;
                float clamp = MathUtils.clamp(velocityConstraintPoint.tangentImpulse + f48, -f49, f49);
                float f56 = clamp - velocityConstraintPoint.tangentImpulse;
                velocityConstraintPoint.tangentImpulse = clamp;
                Vec2 vec29 = contactSolver2.tangent;
                float f57 = vec29.f423649x * f56;
                float f58 = vec29.f423650y * f56;
                vec2.f423649x -= f57 * f26;
                vec2.f423650y -= f58 * f26;
                Vec2 vec210 = velocityConstraintPoint.rA;
                f36 -= ((vec210.f423649x * f58) - (vec210.f423650y * f57)) * f28;
                vec22.f423649x += f57 * f27;
                vec22.f423650y += f58 * f27;
                Vec2 vec211 = velocityConstraintPoint.rB;
                f39 += ((vec211.f423649x * f58) - (vec211.f423650y * f57)) * f29;
                i26 = i36 + 1;
                i18 = i27;
                i17 = i28;
                i16 = i29;
                vec23 = vec26;
            }
            int i37 = i16;
            int i38 = i17;
            Vec2 vec212 = vec23;
            if (contactVelocityConstraint.pointCount == 1) {
                ContactVelocityConstraint.VelocityConstraintPoint velocityConstraintPoint2 = contactVelocityConstraint.points[0];
                Vec2 vec213 = velocityConstraintPoint2.rB;
                float f59 = ((-f39) * vec213.f423650y) + vec22.f423649x;
                float f65 = vec2.f423649x;
                Vec2 vec214 = velocityConstraintPoint2.rA;
                float f66 = (f59 - f65) + (vec214.f423650y * f36);
                float f67 = (vec213.f423649x * f39) + vec22.f423650y;
                float f68 = vec2.f423650y;
                float f69 = (f67 - f68) - (vec214.f423649x * f36);
                float f75 = f39;
                float f76 = vec212.f423649x;
                float f77 = vec212.f423650y;
                float f78 = (-velocityConstraintPoint2.normalMass) * (((f66 * f76) + (f69 * f77)) - velocityConstraintPoint2.velocityBias);
                float f79 = velocityConstraintPoint2.normalImpulse;
                float f85 = f78 + f79;
                if (f85 <= 0.0f) {
                    f85 = 0.0f;
                }
                float f86 = f85 - f79;
                velocityConstraintPoint2.normalImpulse = f85;
                float f87 = f76 * f86;
                float f88 = f77 * f86;
                vec2.f423649x = f65 - (f87 * f26);
                vec2.f423650y = f68 - (f26 * f88);
                f19 = f36 - (f28 * ((vec214.f423649x * f88) - (vec214.f423650y * f87)));
                vec22.f423649x += f87 * f27;
                vec22.f423650y += f27 * f88;
                f18 = f75 + (f29 * ((vec213.f423649x * f88) - (vec213.f423650y * f87)));
                contactSolver = this;
            } else {
                float f89 = f39;
                ContactVelocityConstraint.VelocityConstraintPoint[] velocityConstraintPointArr = contactVelocityConstraint.points;
                ContactVelocityConstraint.VelocityConstraintPoint velocityConstraintPoint3 = velocityConstraintPointArr[0];
                ContactVelocityConstraint.VelocityConstraintPoint velocityConstraintPoint4 = velocityConstraintPointArr[1];
                contactSolver = this;
                Vec2 vec215 = contactSolver.f423658a;
                vec215.f423649x = velocityConstraintPoint3.normalImpulse;
                vec215.f423650y = velocityConstraintPoint4.normalImpulse;
                Vec2 vec216 = contactSolver.f423661dv1;
                float f95 = -f89;
                Vec2 vec217 = velocityConstraintPoint3.rB;
                float f96 = ((vec217.f423650y * f95) + vec22.f423649x) - vec2.f423649x;
                Vec2 vec218 = velocityConstraintPoint3.rA;
                vec216.f423649x = f96 + (vec218.f423650y * f36);
                vec216.f423650y = (((vec217.f423649x * f89) + vec22.f423650y) - vec2.f423650y) - (vec218.f423649x * f36);
                Vec2 vec219 = contactSolver.f423662dv2;
                Vec2 vec220 = velocityConstraintPoint4.rB;
                float f97 = ((f95 * vec220.f423650y) + vec22.f423649x) - vec2.f423649x;
                Vec2 vec221 = velocityConstraintPoint4.rA;
                float f98 = f97 + (vec221.f423650y * f36);
                vec219.f423649x = f98;
                float f99 = (((vec220.f423649x * f89) + vec22.f423650y) - vec2.f423650y) - (vec221.f423649x * f36);
                vec219.f423650y = f99;
                float f100 = vec216.f423649x;
                float f101 = vec212.f423649x;
                float f102 = vec216.f423650y;
                float f103 = vec212.f423650y;
                float f104 = (f98 * f101) + (f99 * f103);
                Vec2 vec222 = contactSolver.f423659b;
                float f105 = ((f100 * f101) + (f102 * f103)) - velocityConstraintPoint3.velocityBias;
                vec222.f423649x = f105;
                float f106 = f104 - velocityConstraintPoint4.velocityBias;
                vec222.f423650y = f106;
                Mat22 mat22 = contactVelocityConstraint.K;
                Vec2 vec223 = mat22.f423636ex;
                float f107 = vec223.f423649x * vec215.f423649x;
                Vec2 vec224 = mat22.f423637ey;
                float f108 = vec224.f423649x;
                float f109 = f36;
                float f110 = vec215.f423650y;
                vec222.f423649x = f105 - (f107 + (f108 * f110));
                vec222.f423650y = f106 - ((vec223.f423650y * vec215.f423649x) + (vec224.f423650y * f110));
                Mat22.mulToOutUnsafe(contactVelocityConstraint.normalMass, vec222, contactSolver.f423663x);
                Vec2 vec225 = contactSolver.f423663x;
                float f111 = vec225.f423649x * (-1.0f);
                vec225.f423649x = f111;
                float f112 = vec225.f423650y * (-1.0f);
                vec225.f423650y = f112;
                if (f111 >= 0.0f && f112 >= 0.0f) {
                    contactSolver.f423660d.set(vec225).subLocal(contactSolver.f423658a);
                    contactSolver.P1.set(vec212).mulLocal(contactSolver.f423660d.f423649x);
                    contactSolver.P2.set(vec212).mulLocal(contactSolver.f423660d.f423650y);
                    contactSolver.temp1.set(contactSolver.P1).addLocal(contactSolver.P2);
                    contactSolver.temp2.set(contactSolver.temp1).mulLocal(f26);
                    vec2.subLocal(contactSolver.temp2);
                    contactSolver.temp2.set(contactSolver.temp1).mulLocal(f27);
                    vec22.addLocal(contactSolver.temp2);
                    f19 = f109 - (f28 * (Vec2.cross(velocityConstraintPoint3.rA, contactSolver.P1) + Vec2.cross(velocityConstraintPoint4.rA, contactSolver.P2)));
                    f18 = f89 + (f29 * (Vec2.cross(velocityConstraintPoint3.rB, contactSolver.P1) + Vec2.cross(velocityConstraintPoint4.rB, contactSolver.P2)));
                    Vec2 vec226 = contactSolver.f423663x;
                    velocityConstraintPoint3.normalImpulse = vec226.f423649x;
                    velocityConstraintPoint4.normalImpulse = vec226.f423650y;
                } else {
                    float f113 = -velocityConstraintPoint3.normalMass;
                    Vec2 vec227 = contactSolver.f423659b;
                    float f114 = f113 * vec227.f423649x;
                    vec225.f423649x = f114;
                    vec225.f423650y = 0.0f;
                    Mat22 mat222 = contactVelocityConstraint.K;
                    float f115 = mat222.f423636ex.f423650y * f114;
                    float f116 = vec227.f423650y;
                    float f117 = f115 + f116;
                    if (f114 < 0.0f) {
                        f16 = 0.0f;
                    } else if (f117 >= 0.0f) {
                        contactSolver.f423660d.set(vec225).subLocal(contactSolver.f423658a);
                        contactSolver.P1.set(vec212).mulLocal(contactSolver.f423660d.f423649x);
                        contactSolver.P2.set(vec212).mulLocal(contactSolver.f423660d.f423650y);
                        contactSolver.temp1.set(contactSolver.P1).addLocal(contactSolver.P2);
                        contactSolver.temp2.set(contactSolver.temp1).mulLocal(f26);
                        vec2.subLocal(contactSolver.temp2);
                        contactSolver.temp2.set(contactSolver.temp1).mulLocal(f27);
                        vec22.addLocal(contactSolver.temp2);
                        f19 = f109 - (f28 * (Vec2.cross(velocityConstraintPoint3.rA, contactSolver.P1) + Vec2.cross(velocityConstraintPoint4.rA, contactSolver.P2)));
                        f18 = f89 + (f29 * (Vec2.cross(velocityConstraintPoint3.rB, contactSolver.P1) + Vec2.cross(velocityConstraintPoint4.rB, contactSolver.P2)));
                        Vec2 vec228 = contactSolver.f423663x;
                        velocityConstraintPoint3.normalImpulse = vec228.f423649x;
                        velocityConstraintPoint4.normalImpulse = vec228.f423650y;
                    } else {
                        f16 = 0.0f;
                    }
                    vec225.f423649x = f16;
                    float f118 = (-velocityConstraintPoint4.normalMass) * f116;
                    vec225.f423650y = f118;
                    float f119 = (mat222.f423637ey.f423649x * f118) + vec227.f423649x;
                    if (f118 < f16) {
                        f17 = f16;
                    } else if (f119 >= f16) {
                        contactSolver.f423660d.set(vec225).subLocal(contactSolver.f423658a);
                        contactSolver.P1.set(vec212).mulLocal(contactSolver.f423660d.f423649x);
                        contactSolver.P2.set(vec212).mulLocal(contactSolver.f423660d.f423650y);
                        contactSolver.temp1.set(contactSolver.P1).addLocal(contactSolver.P2);
                        contactSolver.temp2.set(contactSolver.temp1).mulLocal(f26);
                        vec2.subLocal(contactSolver.temp2);
                        contactSolver.temp2.set(contactSolver.temp1).mulLocal(f27);
                        vec22.addLocal(contactSolver.temp2);
                        f19 = f109 - (f28 * (Vec2.cross(velocityConstraintPoint3.rA, contactSolver.P1) + Vec2.cross(velocityConstraintPoint4.rA, contactSolver.P2)));
                        f18 = f89 + (f29 * (Vec2.cross(velocityConstraintPoint3.rB, contactSolver.P1) + Vec2.cross(velocityConstraintPoint4.rB, contactSolver.P2)));
                        Vec2 vec229 = contactSolver.f423663x;
                        velocityConstraintPoint3.normalImpulse = vec229.f423649x;
                        velocityConstraintPoint4.normalImpulse = vec229.f423650y;
                    } else {
                        f17 = 0.0f;
                    }
                    vec225.f423649x = f17;
                    vec225.f423650y = f17;
                    float f120 = vec227.f423649x;
                    float f121 = vec227.f423650y;
                    if (f120 < f17 || f121 < f17) {
                        f18 = f89;
                        f19 = f109;
                    } else {
                        contactSolver.f423660d.set(vec225).subLocal(contactSolver.f423658a);
                        contactSolver.P1.set(vec212).mulLocal(contactSolver.f423660d.f423649x);
                        contactSolver.P2.set(vec212).mulLocal(contactSolver.f423660d.f423650y);
                        contactSolver.temp1.set(contactSolver.P1).addLocal(contactSolver.P2);
                        contactSolver.temp2.set(contactSolver.temp1).mulLocal(f26);
                        vec2.subLocal(contactSolver.temp2);
                        contactSolver.temp2.set(contactSolver.temp1).mulLocal(f27);
                        vec22.addLocal(contactSolver.temp2);
                        f19 = f109 - (f28 * (Vec2.cross(velocityConstraintPoint3.rA, contactSolver.P1) + Vec2.cross(velocityConstraintPoint4.rA, contactSolver.P2)));
                        f18 = f89 + (f29 * (Vec2.cross(velocityConstraintPoint3.rB, contactSolver.P1) + Vec2.cross(velocityConstraintPoint4.rB, contactSolver.P2)));
                        Vec2 vec230 = contactSolver.f423663x;
                        velocityConstraintPoint3.normalImpulse = vec230.f423649x;
                        velocityConstraintPoint4.normalImpulse = vec230.f423650y;
                    }
                }
            }
            Velocity[] velocityArr2 = contactSolver.m_velocities;
            velocityArr2[i37].f423667w = f19;
            velocityArr2[i38].f423667w = f18;
            ContactSolver contactSolver3 = contactSolver;
            i3 = i19 + 1;
            contactSolver2 = contactSolver3;
        }
    }

    public void storeImpulses() {
        for (int i3 = 0; i3 < this.m_count; i3++) {
            ContactVelocityConstraint contactVelocityConstraint = this.m_velocityConstraints[i3];
            Manifold manifold = this.m_contacts[contactVelocityConstraint.contactIndex].getManifold();
            for (int i16 = 0; i16 < contactVelocityConstraint.pointCount; i16++) {
                ManifoldPoint manifoldPoint = manifold.points[i16];
                ContactVelocityConstraint.VelocityConstraintPoint velocityConstraintPoint = contactVelocityConstraint.points[i16];
                manifoldPoint.normalImpulse = velocityConstraintPoint.normalImpulse;
                manifoldPoint.tangentImpulse = velocityConstraintPoint.tangentImpulse;
            }
        }
    }

    public void warmStart() {
        int i3 = 0;
        while (i3 < this.m_count) {
            ContactVelocityConstraint contactVelocityConstraint = this.m_velocityConstraints[i3];
            int i16 = contactVelocityConstraint.indexA;
            int i17 = contactVelocityConstraint.indexB;
            float f16 = contactVelocityConstraint.invMassA;
            float f17 = contactVelocityConstraint.invIA;
            float f18 = contactVelocityConstraint.invMassB;
            float f19 = contactVelocityConstraint.invIB;
            int i18 = contactVelocityConstraint.pointCount;
            Velocity[] velocityArr = this.m_velocities;
            Velocity velocity = velocityArr[i16];
            Vec2 vec2 = velocity.f423666v;
            float f26 = velocity.f423667w;
            Velocity velocity2 = velocityArr[i17];
            Vec2 vec22 = velocity2.f423666v;
            float f27 = velocity2.f423667w;
            Vec2 vec23 = contactVelocityConstraint.normal;
            float f28 = vec23.f423650y * 1.0f;
            float f29 = vec23.f423649x * (-1.0f);
            int i19 = i3;
            float f36 = f26;
            float f37 = f27;
            int i26 = 0;
            while (i26 < i18) {
                int i27 = i18;
                ContactVelocityConstraint.VelocityConstraintPoint velocityConstraintPoint = contactVelocityConstraint.points[i26];
                ContactVelocityConstraint contactVelocityConstraint2 = contactVelocityConstraint;
                float f38 = velocityConstraintPoint.tangentImpulse;
                float f39 = f28 * f38;
                float f46 = f28;
                float f47 = vec23.f423649x;
                int i28 = i16;
                float f48 = velocityConstraintPoint.normalImpulse;
                float f49 = f39 + (f47 * f48);
                float f56 = (f38 * f29) + (vec23.f423650y * f48);
                Vec2 vec24 = velocityConstraintPoint.rA;
                f36 -= ((vec24.f423649x * f56) - (vec24.f423650y * f49)) * f17;
                vec2.f423649x -= f49 * f16;
                vec2.f423650y -= f56 * f16;
                Vec2 vec25 = velocityConstraintPoint.rB;
                f37 += ((vec25.f423649x * f56) - (vec25.f423650y * f49)) * f19;
                vec22.f423649x += f49 * f18;
                vec22.f423650y += f56 * f18;
                i26++;
                i18 = i27;
                contactVelocityConstraint = contactVelocityConstraint2;
                f28 = f46;
                i16 = i28;
            }
            Velocity[] velocityArr2 = this.m_velocities;
            velocityArr2[i16].f423667w = f36;
            velocityArr2[i17].f423667w = f37;
            i3 = i19 + 1;
        }
    }
}
