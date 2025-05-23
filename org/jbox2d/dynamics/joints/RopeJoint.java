package org.jbox2d.dynamics.joints;

import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.SolverData;
import org.jbox2d.dynamics.TimeStep;
import org.jbox2d.dynamics.contacts.Position;
import org.jbox2d.dynamics.contacts.Velocity;
import org.jbox2d.pooling.IWorldPool;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RopeJoint extends Joint {
    private float m_impulse;
    private int m_indexA;
    private int m_indexB;
    private float m_invIA;
    private float m_invIB;
    private float m_invMassA;
    private float m_invMassB;
    private float m_length;
    private final Vec2 m_localAnchorA;
    private final Vec2 m_localAnchorB;
    private final Vec2 m_localCenterA;
    private final Vec2 m_localCenterB;
    private float m_mass;
    private float m_maxLength;
    private final Vec2 m_rA;
    private final Vec2 m_rB;
    private LimitState m_state;
    private final Vec2 m_u;

    /* JADX INFO: Access modifiers changed from: protected */
    public RopeJoint(IWorldPool iWorldPool, RopeJointDef ropeJointDef) {
        super(iWorldPool, ropeJointDef);
        Vec2 vec2 = new Vec2();
        this.m_localAnchorA = vec2;
        Vec2 vec22 = new Vec2();
        this.m_localAnchorB = vec22;
        this.m_u = new Vec2();
        this.m_rA = new Vec2();
        this.m_rB = new Vec2();
        this.m_localCenterA = new Vec2();
        this.m_localCenterB = new Vec2();
        vec2.set(ropeJointDef.localAnchorA);
        vec22.set(ropeJointDef.localAnchorB);
        this.m_maxLength = ropeJointDef.maxLength;
        this.m_mass = 0.0f;
        this.m_impulse = 0.0f;
        this.m_state = LimitState.INACTIVE;
        this.m_length = 0.0f;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getAnchorA(Vec2 vec2) {
        this.m_bodyA.getWorldPointToOut(this.m_localAnchorA, vec2);
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getAnchorB(Vec2 vec2) {
        this.m_bodyB.getWorldPointToOut(this.m_localAnchorB, vec2);
    }

    public LimitState getLimitState() {
        return this.m_state;
    }

    public Vec2 getLocalAnchorA() {
        return this.m_localAnchorA;
    }

    public Vec2 getLocalAnchorB() {
        return this.m_localAnchorB;
    }

    public float getMaxLength() {
        return this.m_maxLength;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getReactionForce(float f16, Vec2 vec2) {
        vec2.set(this.m_u).mulLocal(f16).mulLocal(this.m_impulse);
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public float getReactionTorque(float f16) {
        return 0.0f;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void initVelocityConstraints(SolverData solverData) {
        float f16;
        Body body = this.m_bodyA;
        this.m_indexA = body.m_islandIndex;
        this.m_indexB = this.m_bodyB.m_islandIndex;
        this.m_localCenterA.set(body.m_sweep.localCenter);
        this.m_localCenterB.set(this.m_bodyB.m_sweep.localCenter);
        Body body2 = this.m_bodyA;
        this.m_invMassA = body2.m_invMass;
        Body body3 = this.m_bodyB;
        this.m_invMassB = body3.m_invMass;
        this.m_invIA = body2.m_invI;
        this.m_invIB = body3.m_invI;
        Position[] positionArr = solverData.positions;
        int i3 = this.m_indexA;
        Position position = positionArr[i3];
        Vec2 vec2 = position.f423665c;
        float f17 = position.f423664a;
        Velocity[] velocityArr = solverData.velocities;
        Velocity velocity = velocityArr[i3];
        Vec2 vec22 = velocity.f423666v;
        float f18 = velocity.f423667w;
        int i16 = this.m_indexB;
        Position position2 = positionArr[i16];
        Vec2 vec23 = position2.f423665c;
        float f19 = position2.f423664a;
        Velocity velocity2 = velocityArr[i16];
        Vec2 vec24 = velocity2.f423666v;
        float f26 = velocity2.f423667w;
        Rot popRot = this.pool.popRot();
        Rot popRot2 = this.pool.popRot();
        Vec2 popVec2 = this.pool.popVec2();
        popRot.set(f17);
        popRot2.set(f19);
        Rot.mulToOutUnsafe(popRot, popVec2.set(this.m_localAnchorA).subLocal(this.m_localCenterA), this.m_rA);
        Rot.mulToOutUnsafe(popRot2, popVec2.set(this.m_localAnchorB).subLocal(this.m_localCenterB), this.m_rB);
        this.m_u.set(vec23).addLocal(this.m_rB).subLocal(vec2).subLocal(this.m_rA);
        float length = this.m_u.length();
        this.m_length = length;
        if (length - this.m_maxLength > 0.0f) {
            this.m_state = LimitState.AT_UPPER;
        } else {
            this.m_state = LimitState.INACTIVE;
        }
        if (length > 0.005f) {
            this.m_u.mulLocal(1.0f / length);
            float cross = Vec2.cross(this.m_rA, this.m_u);
            float cross2 = Vec2.cross(this.m_rB, this.m_u);
            float f27 = this.m_invMassA;
            float f28 = this.m_invIA;
            float f29 = (f28 * cross * cross) + f27;
            float f36 = this.m_invMassB;
            float f37 = this.m_invIB;
            float f38 = f29 + f36 + (f37 * cross2 * cross2);
            if (f38 != 0.0f) {
                f16 = 1.0f / f38;
            } else {
                f16 = 0.0f;
            }
            this.m_mass = f16;
            TimeStep timeStep = solverData.step;
            if (timeStep.warmStarting) {
                float f39 = this.m_impulse * timeStep.dtRatio;
                this.m_impulse = f39;
                Vec2 vec25 = this.m_u;
                float f46 = vec25.f423649x * f39;
                float f47 = f39 * vec25.f423650y;
                vec22.f423649x -= f27 * f46;
                vec22.f423650y -= f27 * f47;
                Vec2 vec26 = this.m_rA;
                f18 -= f28 * ((vec26.f423649x * f47) - (vec26.f423650y * f46));
                vec24.f423649x += f36 * f46;
                vec24.f423650y += f36 * f47;
                Vec2 vec27 = this.m_rB;
                f26 += f37 * ((vec27.f423649x * f47) - (vec27.f423650y * f46));
            } else {
                this.m_impulse = 0.0f;
            }
            this.pool.pushRot(2);
            this.pool.pushVec2(1);
            Velocity[] velocityArr2 = solverData.velocities;
            velocityArr2[this.m_indexA].f423667w = f18;
            velocityArr2[this.m_indexB].f423667w = f26;
            return;
        }
        this.m_u.setZero();
        this.m_mass = 0.0f;
        this.m_impulse = 0.0f;
    }

    public void setMaxLength(float f16) {
        this.m_maxLength = f16;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public boolean solvePositionConstraints(SolverData solverData) {
        Position[] positionArr = solverData.positions;
        Position position = positionArr[this.m_indexA];
        Vec2 vec2 = position.f423665c;
        float f16 = position.f423664a;
        Position position2 = positionArr[this.m_indexB];
        Vec2 vec22 = position2.f423665c;
        float f17 = position2.f423664a;
        Rot popRot = this.pool.popRot();
        Rot popRot2 = this.pool.popRot();
        Vec2 popVec2 = this.pool.popVec2();
        Vec2 popVec22 = this.pool.popVec2();
        Vec2 popVec23 = this.pool.popVec2();
        Vec2 popVec24 = this.pool.popVec2();
        popRot.set(f16);
        popRot2.set(f17);
        Rot.mulToOutUnsafe(popRot, popVec24.set(this.m_localAnchorA).subLocal(this.m_localCenterA), popVec22);
        Rot.mulToOutUnsafe(popRot2, popVec24.set(this.m_localAnchorB).subLocal(this.m_localCenterB), popVec23);
        popVec2.set(vec22).addLocal(popVec23).subLocal(vec2).subLocal(popVec22);
        float normalize = popVec2.normalize();
        float clamp = (-this.m_mass) * MathUtils.clamp(normalize - this.m_maxLength, 0.0f, 0.2f);
        float f18 = popVec2.f423649x * clamp;
        float f19 = clamp * popVec2.f423650y;
        float f26 = vec2.f423649x;
        float f27 = this.m_invMassA;
        vec2.f423649x = f26 - (f27 * f18);
        vec2.f423650y -= f27 * f19;
        float f28 = f16 - (this.m_invIA * ((popVec22.f423649x * f19) - (popVec22.f423650y * f18)));
        float f29 = vec22.f423649x;
        float f36 = this.m_invMassB;
        vec22.f423649x = f29 + (f36 * f18);
        vec22.f423650y += f36 * f19;
        float f37 = f17 + (this.m_invIB * ((popVec23.f423649x * f19) - (popVec23.f423650y * f18)));
        this.pool.pushRot(2);
        this.pool.pushVec2(4);
        Position[] positionArr2 = solverData.positions;
        positionArr2[this.m_indexA].f423664a = f28;
        positionArr2[this.m_indexB].f423664a = f37;
        if (normalize - this.m_maxLength < 0.005f) {
            return true;
        }
        return false;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void solveVelocityConstraints(SolverData solverData) {
        Velocity[] velocityArr = solverData.velocities;
        Velocity velocity = velocityArr[this.m_indexA];
        Vec2 vec2 = velocity.f423666v;
        float f16 = velocity.f423667w;
        Velocity velocity2 = velocityArr[this.m_indexB];
        Vec2 vec22 = velocity2.f423666v;
        float f17 = velocity2.f423667w;
        Vec2 popVec2 = this.pool.popVec2();
        Vec2 popVec22 = this.pool.popVec2();
        Vec2 popVec23 = this.pool.popVec2();
        Vec2.crossToOutUnsafe(f16, this.m_rA, popVec2);
        popVec2.addLocal(vec2);
        Vec2.crossToOutUnsafe(f17, this.m_rB, popVec22);
        popVec22.addLocal(vec22);
        float f18 = this.m_length - this.m_maxLength;
        float dot = Vec2.dot(this.m_u, popVec23.set(popVec22).subLocal(popVec2));
        if (f18 < 0.0f) {
            dot += solverData.step.inv_dt * f18;
        }
        float f19 = (-this.m_mass) * dot;
        float f26 = this.m_impulse;
        float min = MathUtils.min(0.0f, f19 + f26);
        this.m_impulse = min;
        float f27 = min - f26;
        Vec2 vec23 = this.m_u;
        float f28 = vec23.f423649x * f27;
        float f29 = f27 * vec23.f423650y;
        float f36 = vec2.f423649x;
        float f37 = this.m_invMassA;
        vec2.f423649x = f36 - (f37 * f28);
        vec2.f423650y -= f37 * f29;
        float f38 = this.m_invIA;
        Vec2 vec24 = this.m_rA;
        float f39 = f16 - (f38 * ((vec24.f423649x * f29) - (vec24.f423650y * f28)));
        float f46 = vec22.f423649x;
        float f47 = this.m_invMassB;
        vec22.f423649x = f46 + (f47 * f28);
        vec22.f423650y += f47 * f29;
        float f48 = this.m_invIB;
        Vec2 vec25 = this.m_rB;
        float f49 = f17 + (f48 * ((vec25.f423649x * f29) - (vec25.f423650y * f28)));
        this.pool.pushVec2(3);
        Velocity[] velocityArr2 = solverData.velocities;
        velocityArr2[this.m_indexA].f423667w = f39;
        velocityArr2[this.m_indexB].f423667w = f49;
    }
}
