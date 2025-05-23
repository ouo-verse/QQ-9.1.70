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
public class DistanceJoint extends Joint {
    private float m_bias;
    private float m_dampingRatio;
    private float m_frequencyHz;
    private float m_gamma;
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
    private final Vec2 m_rA;
    private final Vec2 m_rB;
    private final Vec2 m_u;

    /* JADX INFO: Access modifiers changed from: protected */
    public DistanceJoint(IWorldPool iWorldPool, DistanceJointDef distanceJointDef) {
        super(iWorldPool, distanceJointDef);
        this.m_u = new Vec2();
        this.m_rA = new Vec2();
        this.m_rB = new Vec2();
        this.m_localCenterA = new Vec2();
        this.m_localCenterB = new Vec2();
        this.m_localAnchorA = distanceJointDef.localAnchorA.clone();
        this.m_localAnchorB = distanceJointDef.localAnchorB.clone();
        this.m_length = distanceJointDef.length;
        this.m_impulse = 0.0f;
        this.m_frequencyHz = distanceJointDef.frequencyHz;
        this.m_dampingRatio = distanceJointDef.dampingRatio;
        this.m_gamma = 0.0f;
        this.m_bias = 0.0f;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getAnchorA(Vec2 vec2) {
        this.m_bodyA.getWorldPointToOut(this.m_localAnchorA, vec2);
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getAnchorB(Vec2 vec2) {
        this.m_bodyB.getWorldPointToOut(this.m_localAnchorB, vec2);
    }

    public float getDampingRatio() {
        return this.m_dampingRatio;
    }

    public float getFrequency() {
        return this.m_frequencyHz;
    }

    public float getLength() {
        return this.m_length;
    }

    public Vec2 getLocalAnchorA() {
        return this.m_localAnchorA;
    }

    public Vec2 getLocalAnchorB() {
        return this.m_localAnchorB;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getReactionForce(float f16, Vec2 vec2) {
        float f17 = this.m_impulse;
        Vec2 vec22 = this.m_u;
        vec2.f423649x = vec22.f423649x * f17 * f16;
        vec2.f423650y = f17 * vec22.f423650y * f16;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public float getReactionTorque(float f16) {
        return 0.0f;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void initVelocityConstraints(SolverData solverData) {
        float f16;
        float f17;
        float f18;
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
        float f19 = position.f423664a;
        Velocity[] velocityArr = solverData.velocities;
        Velocity velocity = velocityArr[i3];
        Vec2 vec22 = velocity.f423666v;
        float f26 = velocity.f423667w;
        int i16 = this.m_indexB;
        Position position2 = positionArr[i16];
        Vec2 vec23 = position2.f423665c;
        float f27 = position2.f423664a;
        Velocity velocity2 = velocityArr[i16];
        Vec2 vec24 = velocity2.f423666v;
        float f28 = velocity2.f423667w;
        Rot popRot = this.pool.popRot();
        Rot popRot2 = this.pool.popRot();
        popRot.set(f19);
        popRot2.set(f27);
        Rot.mulToOutUnsafe(popRot, this.m_u.set(this.m_localAnchorA).subLocal(this.m_localCenterA), this.m_rA);
        Rot.mulToOutUnsafe(popRot2, this.m_u.set(this.m_localAnchorB).subLocal(this.m_localCenterB), this.m_rB);
        this.m_u.set(vec23).addLocal(this.m_rB).subLocal(vec2).subLocal(this.m_rA);
        this.pool.pushRot(2);
        float length = this.m_u.length();
        if (length > 0.005f) {
            Vec2 vec25 = this.m_u;
            float f29 = 1.0f / length;
            vec25.f423649x *= f29;
            vec25.f423650y *= f29;
        } else {
            this.m_u.set(0.0f, 0.0f);
        }
        float cross = Vec2.cross(this.m_rA, this.m_u);
        float cross2 = Vec2.cross(this.m_rB, this.m_u);
        float f36 = this.m_invMassA + (this.m_invIA * cross * cross) + this.m_invMassB + (this.m_invIB * cross2 * cross2);
        if (f36 != 0.0f) {
            f16 = 1.0f / f36;
        } else {
            f16 = 0.0f;
        }
        this.m_mass = f16;
        float f37 = this.m_frequencyHz;
        if (f37 > 0.0f) {
            float f38 = length - this.m_length;
            float f39 = f37 * 6.2831855f;
            float f46 = 2.0f * f16 * this.m_dampingRatio * f39;
            float f47 = f16 * f39 * f39;
            float f48 = solverData.step.f423654dt;
            float f49 = (f46 + (f48 * f47)) * f48;
            this.m_gamma = f49;
            if (f49 != 0.0f) {
                f17 = 1.0f / f49;
            } else {
                f17 = 0.0f;
            }
            this.m_gamma = f17;
            this.m_bias = f38 * f48 * f47 * f17;
            float f56 = f36 + f17;
            if (f56 != 0.0f) {
                f18 = 1.0f / f56;
            } else {
                f18 = 0.0f;
            }
            this.m_mass = f18;
        } else {
            this.m_gamma = 0.0f;
            this.m_bias = 0.0f;
        }
        TimeStep timeStep = solverData.step;
        if (timeStep.warmStarting) {
            this.m_impulse *= timeStep.dtRatio;
            Vec2 popVec2 = this.pool.popVec2();
            popVec2.set(this.m_u).mulLocal(this.m_impulse);
            float f57 = vec22.f423649x;
            float f58 = this.m_invMassA;
            vec22.f423649x = f57 - (popVec2.f423649x * f58);
            vec22.f423650y -= f58 * popVec2.f423650y;
            f26 -= this.m_invIA * Vec2.cross(this.m_rA, popVec2);
            float f59 = vec24.f423649x;
            float f65 = this.m_invMassB;
            vec24.f423649x = f59 + (popVec2.f423649x * f65);
            vec24.f423650y += f65 * popVec2.f423650y;
            f28 += this.m_invIB * Vec2.cross(this.m_rB, popVec2);
            this.pool.pushVec2(1);
        } else {
            this.m_impulse = 0.0f;
        }
        Velocity[] velocityArr2 = solverData.velocities;
        velocityArr2[this.m_indexA].f423667w = f26;
        velocityArr2[this.m_indexB].f423667w = f28;
    }

    public void setDampingRatio(float f16) {
        this.m_dampingRatio = f16;
    }

    public void setFrequency(float f16) {
        this.m_frequencyHz = f16;
    }

    public void setLength(float f16) {
        this.m_length = f16;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public boolean solvePositionConstraints(SolverData solverData) {
        if (this.m_frequencyHz > 0.0f) {
            return true;
        }
        Rot popRot = this.pool.popRot();
        Rot popRot2 = this.pool.popRot();
        Vec2 popVec2 = this.pool.popVec2();
        Vec2 popVec22 = this.pool.popVec2();
        Vec2 popVec23 = this.pool.popVec2();
        Position[] positionArr = solverData.positions;
        Position position = positionArr[this.m_indexA];
        Vec2 vec2 = position.f423665c;
        float f16 = position.f423664a;
        Position position2 = positionArr[this.m_indexB];
        Vec2 vec22 = position2.f423665c;
        float f17 = position2.f423664a;
        popRot.set(f16);
        popRot2.set(f17);
        Rot.mulToOutUnsafe(popRot, popVec23.set(this.m_localAnchorA).subLocal(this.m_localCenterA), popVec2);
        Rot.mulToOutUnsafe(popRot2, popVec23.set(this.m_localAnchorB).subLocal(this.m_localCenterB), popVec22);
        popVec23.set(vec22).addLocal(popVec22).subLocal(vec2).subLocal(popVec2);
        float clamp = MathUtils.clamp(popVec23.normalize() - this.m_length, -0.2f, 0.2f);
        float f18 = (-this.m_mass) * clamp;
        float f19 = popVec23.f423649x * f18;
        float f26 = f18 * popVec23.f423650y;
        float f27 = vec2.f423649x;
        float f28 = this.m_invMassA;
        vec2.f423649x = f27 - (f28 * f19);
        vec2.f423650y -= f28 * f26;
        float f29 = f16 - (this.m_invIA * ((popVec2.f423649x * f26) - (popVec2.f423650y * f19)));
        float f36 = vec22.f423649x;
        float f37 = this.m_invMassB;
        vec22.f423649x = f36 + (f37 * f19);
        vec22.f423650y += f37 * f26;
        float f38 = f17 + (this.m_invIB * ((popVec22.f423649x * f26) - (popVec22.f423650y * f19)));
        Position[] positionArr2 = solverData.positions;
        positionArr2[this.m_indexA].f423664a = f29;
        positionArr2[this.m_indexB].f423664a = f38;
        this.pool.pushVec2(3);
        this.pool.pushRot(2);
        if (MathUtils.abs(clamp) < 0.005f) {
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
        Vec2.crossToOutUnsafe(f16, this.m_rA, popVec2);
        popVec2.addLocal(vec2);
        Vec2.crossToOutUnsafe(f17, this.m_rB, popVec22);
        popVec22.addLocal(vec22);
        float dot = Vec2.dot(this.m_u, popVec22.subLocal(popVec2));
        float f18 = -this.m_mass;
        float f19 = dot + this.m_bias;
        float f26 = this.m_gamma;
        float f27 = this.m_impulse;
        float f28 = f18 * (f19 + (f26 * f27));
        this.m_impulse = f27 + f28;
        Vec2 vec23 = this.m_u;
        float f29 = vec23.f423649x * f28;
        float f36 = f28 * vec23.f423650y;
        float f37 = vec2.f423649x;
        float f38 = this.m_invMassA;
        vec2.f423649x = f37 - (f38 * f29);
        vec2.f423650y -= f38 * f36;
        float f39 = this.m_invIA;
        Vec2 vec24 = this.m_rA;
        float f46 = f16 - (f39 * ((vec24.f423649x * f36) - (vec24.f423650y * f29)));
        float f47 = vec22.f423649x;
        float f48 = this.m_invMassB;
        vec22.f423649x = f47 + (f48 * f29);
        vec22.f423650y += f48 * f36;
        float f49 = this.m_invIB;
        Vec2 vec25 = this.m_rB;
        float f56 = f17 + (f49 * ((vec25.f423649x * f36) - (vec25.f423650y * f29)));
        Velocity[] velocityArr2 = solverData.velocities;
        velocityArr2[this.m_indexA].f423667w = f46;
        velocityArr2[this.m_indexB].f423667w = f56;
        this.pool.pushVec2(2);
    }
}
