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

/* loaded from: classes29.dex */
public class PulleyJoint extends Joint {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final float MIN_PULLEY_LENGTH = 2.0f;
    private float m_constant;
    private final Vec2 m_groundAnchorA;
    private final Vec2 m_groundAnchorB;
    private float m_impulse;
    private int m_indexA;
    private int m_indexB;
    private float m_invIA;
    private float m_invIB;
    private float m_invMassA;
    private float m_invMassB;
    private float m_lengthA;
    private float m_lengthB;
    private final Vec2 m_localAnchorA;
    private final Vec2 m_localAnchorB;
    private final Vec2 m_localCenterA;
    private final Vec2 m_localCenterB;
    private float m_mass;
    private final Vec2 m_rA;
    private final Vec2 m_rB;
    private float m_ratio;
    private final Vec2 m_uA;
    private final Vec2 m_uB;

    /* JADX INFO: Access modifiers changed from: protected */
    public PulleyJoint(IWorldPool iWorldPool, PulleyJointDef pulleyJointDef) {
        super(iWorldPool, pulleyJointDef);
        Vec2 vec2 = new Vec2();
        this.m_groundAnchorA = vec2;
        Vec2 vec22 = new Vec2();
        this.m_groundAnchorB = vec22;
        Vec2 vec23 = new Vec2();
        this.m_localAnchorA = vec23;
        Vec2 vec24 = new Vec2();
        this.m_localAnchorB = vec24;
        this.m_uA = new Vec2();
        this.m_uB = new Vec2();
        this.m_rA = new Vec2();
        this.m_rB = new Vec2();
        this.m_localCenterA = new Vec2();
        this.m_localCenterB = new Vec2();
        vec2.set(pulleyJointDef.groundAnchorA);
        vec22.set(pulleyJointDef.groundAnchorB);
        vec23.set(pulleyJointDef.localAnchorA);
        vec24.set(pulleyJointDef.localAnchorB);
        float f16 = pulleyJointDef.ratio;
        this.m_ratio = f16;
        float f17 = pulleyJointDef.lengthA;
        this.m_lengthA = f17;
        float f18 = pulleyJointDef.lengthB;
        this.m_lengthB = f18;
        this.m_constant = f17 + (f16 * f18);
        this.m_impulse = 0.0f;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getAnchorA(Vec2 vec2) {
        this.m_bodyA.getWorldPointToOut(this.m_localAnchorA, vec2);
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getAnchorB(Vec2 vec2) {
        this.m_bodyB.getWorldPointToOut(this.m_localAnchorB, vec2);
    }

    public float getCurrentLengthA() {
        Vec2 popVec2 = this.pool.popVec2();
        this.m_bodyA.getWorldPointToOut(this.m_localAnchorA, popVec2);
        popVec2.subLocal(this.m_groundAnchorA);
        float length = popVec2.length();
        this.pool.pushVec2(1);
        return length;
    }

    public float getCurrentLengthB() {
        Vec2 popVec2 = this.pool.popVec2();
        this.m_bodyB.getWorldPointToOut(this.m_localAnchorB, popVec2);
        popVec2.subLocal(this.m_groundAnchorB);
        float length = popVec2.length();
        this.pool.pushVec2(1);
        return length;
    }

    public Vec2 getGroundAnchorA() {
        return this.m_groundAnchorA;
    }

    public Vec2 getGroundAnchorB() {
        return this.m_groundAnchorB;
    }

    public float getLength1() {
        Vec2 popVec2 = this.pool.popVec2();
        this.m_bodyA.getWorldPointToOut(this.m_localAnchorA, popVec2);
        popVec2.subLocal(this.m_groundAnchorA);
        float length = popVec2.length();
        this.pool.pushVec2(1);
        return length;
    }

    public float getLength2() {
        Vec2 popVec2 = this.pool.popVec2();
        this.m_bodyB.getWorldPointToOut(this.m_localAnchorB, popVec2);
        popVec2.subLocal(this.m_groundAnchorB);
        float length = popVec2.length();
        this.pool.pushVec2(1);
        return length;
    }

    public float getLengthA() {
        return this.m_lengthA;
    }

    public float getLengthB() {
        return this.m_lengthB;
    }

    public Vec2 getLocalAnchorA() {
        return this.m_localAnchorA;
    }

    public Vec2 getLocalAnchorB() {
        return this.m_localAnchorB;
    }

    public float getRatio() {
        return this.m_ratio;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getReactionForce(float f16, Vec2 vec2) {
        vec2.set(this.m_uB).mulLocal(this.m_impulse).mulLocal(f16);
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public float getReactionTorque(float f16) {
        return 0.0f;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void initVelocityConstraints(SolverData solverData) {
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
        float f16 = position.f423664a;
        Velocity[] velocityArr = solverData.velocities;
        Velocity velocity = velocityArr[i3];
        Vec2 vec22 = velocity.f423666v;
        float f17 = velocity.f423667w;
        int i16 = this.m_indexB;
        Position position2 = positionArr[i16];
        Vec2 vec23 = position2.f423665c;
        float f18 = position2.f423664a;
        Velocity velocity2 = velocityArr[i16];
        Vec2 vec24 = velocity2.f423666v;
        float f19 = velocity2.f423667w;
        Rot popRot = this.pool.popRot();
        Rot popRot2 = this.pool.popRot();
        Vec2 popVec2 = this.pool.popVec2();
        popRot.set(f16);
        popRot2.set(f18);
        Rot.mulToOutUnsafe(popRot, popVec2.set(this.m_localAnchorA).subLocal(this.m_localCenterA), this.m_rA);
        Rot.mulToOutUnsafe(popRot2, popVec2.set(this.m_localAnchorB).subLocal(this.m_localCenterB), this.m_rB);
        this.m_uA.set(vec2).addLocal(this.m_rA).subLocal(this.m_groundAnchorA);
        this.m_uB.set(vec23).addLocal(this.m_rB).subLocal(this.m_groundAnchorB);
        float length = this.m_uA.length();
        float length2 = this.m_uB.length();
        if (length > 0.049999997f) {
            this.m_uA.mulLocal(1.0f / length);
        } else {
            this.m_uA.setZero();
        }
        if (length2 > 0.049999997f) {
            this.m_uB.mulLocal(1.0f / length2);
        } else {
            this.m_uB.setZero();
        }
        float cross = Vec2.cross(this.m_rA, this.m_uA);
        float cross2 = Vec2.cross(this.m_rB, this.m_uB);
        float f26 = this.m_invMassA + (this.m_invIA * cross * cross);
        float f27 = this.m_invMassB + (this.m_invIB * cross2 * cross2);
        float f28 = this.m_ratio;
        float f29 = f26 + (f28 * f28 * f27);
        this.m_mass = f29;
        if (f29 > 0.0f) {
            this.m_mass = 1.0f / f29;
        }
        TimeStep timeStep = solverData.step;
        if (timeStep.warmStarting) {
            this.m_impulse *= timeStep.dtRatio;
            Vec2 popVec22 = this.pool.popVec2();
            Vec2 popVec23 = this.pool.popVec2();
            popVec22.set(this.m_uA).mulLocal(-this.m_impulse);
            popVec23.set(this.m_uB).mulLocal((-this.m_ratio) * this.m_impulse);
            float f36 = vec22.f423649x;
            float f37 = this.m_invMassA;
            vec22.f423649x = f36 + (popVec22.f423649x * f37);
            vec22.f423650y += f37 * popVec22.f423650y;
            f17 += this.m_invIA * Vec2.cross(this.m_rA, popVec22);
            float f38 = vec24.f423649x;
            float f39 = this.m_invMassB;
            vec24.f423649x = f38 + (popVec23.f423649x * f39);
            vec24.f423650y += f39 * popVec23.f423650y;
            f19 += this.m_invIB * Vec2.cross(this.m_rB, popVec23);
            this.pool.pushVec2(2);
        } else {
            this.m_impulse = 0.0f;
        }
        Velocity[] velocityArr2 = solverData.velocities;
        velocityArr2[this.m_indexA].f423667w = f17;
        velocityArr2[this.m_indexB].f423667w = f19;
        this.pool.pushVec2(1);
        this.pool.pushRot(2);
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public boolean solvePositionConstraints(SolverData solverData) {
        Rot popRot = this.pool.popRot();
        Rot popRot2 = this.pool.popRot();
        Vec2 popVec2 = this.pool.popVec2();
        Vec2 popVec22 = this.pool.popVec2();
        Vec2 popVec23 = this.pool.popVec2();
        Vec2 popVec24 = this.pool.popVec2();
        Vec2 popVec25 = this.pool.popVec2();
        Vec2 popVec26 = this.pool.popVec2();
        Vec2 popVec27 = this.pool.popVec2();
        Position[] positionArr = solverData.positions;
        Position position = positionArr[this.m_indexA];
        Vec2 vec2 = position.f423665c;
        float f16 = position.f423664a;
        Position position2 = positionArr[this.m_indexB];
        Vec2 vec22 = position2.f423665c;
        float f17 = position2.f423664a;
        popRot.set(f16);
        popRot2.set(f17);
        Rot.mulToOutUnsafe(popRot, popVec25.set(this.m_localAnchorA).subLocal(this.m_localCenterA), popVec2);
        Rot.mulToOutUnsafe(popRot2, popVec25.set(this.m_localAnchorB).subLocal(this.m_localCenterB), popVec22);
        popVec23.set(vec2).addLocal(popVec2).subLocal(this.m_groundAnchorA);
        popVec24.set(vec22).addLocal(popVec22).subLocal(this.m_groundAnchorB);
        float length = popVec23.length();
        float length2 = popVec24.length();
        if (length > 0.049999997f) {
            popVec23.mulLocal(1.0f / length);
        } else {
            popVec23.setZero();
        }
        if (length2 > 0.049999997f) {
            popVec24.mulLocal(1.0f / length2);
        } else {
            popVec24.setZero();
        }
        float cross = Vec2.cross(popVec2, popVec23);
        float cross2 = Vec2.cross(popVec22, popVec24);
        float f18 = this.m_invMassA + (this.m_invIA * cross * cross);
        float f19 = this.m_invMassB + (this.m_invIB * cross2 * cross2);
        float f26 = this.m_ratio;
        float f27 = f18 + (f26 * f26 * f19);
        if (f27 > 0.0f) {
            f27 = 1.0f / f27;
        }
        float f28 = (this.m_constant - length) - (f26 * length2);
        float abs = MathUtils.abs(f28);
        float f29 = (-f27) * f28;
        popVec26.set(popVec23).mulLocal(-f29);
        popVec27.set(popVec24).mulLocal((-this.m_ratio) * f29);
        float f36 = vec2.f423649x;
        float f37 = this.m_invMassA;
        vec2.f423649x = f36 + (popVec26.f423649x * f37);
        vec2.f423650y += f37 * popVec26.f423650y;
        float cross3 = f16 + (this.m_invIA * Vec2.cross(popVec2, popVec26));
        float f38 = vec22.f423649x;
        float f39 = this.m_invMassB;
        vec22.f423649x = f38 + (popVec27.f423649x * f39);
        vec22.f423650y += f39 * popVec27.f423650y;
        float cross4 = f17 + (this.m_invIB * Vec2.cross(popVec22, popVec27));
        Position[] positionArr2 = solverData.positions;
        positionArr2[this.m_indexA].f423664a = cross3;
        positionArr2[this.m_indexB].f423664a = cross4;
        this.pool.pushRot(2);
        this.pool.pushVec2(7);
        if (abs < 0.005f) {
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
        Vec2 popVec24 = this.pool.popVec2();
        Vec2.crossToOutUnsafe(f16, this.m_rA, popVec2);
        popVec2.addLocal(vec2);
        Vec2.crossToOutUnsafe(f17, this.m_rB, popVec22);
        popVec22.addLocal(vec22);
        float dot = (-this.m_mass) * ((-Vec2.dot(this.m_uA, popVec2)) - (this.m_ratio * Vec2.dot(this.m_uB, popVec22)));
        this.m_impulse += dot;
        popVec23.set(this.m_uA).mulLocal(-dot);
        popVec24.set(this.m_uB).mulLocal((-this.m_ratio) * dot);
        float f18 = vec2.f423649x;
        float f19 = this.m_invMassA;
        vec2.f423649x = f18 + (popVec23.f423649x * f19);
        vec2.f423650y += f19 * popVec23.f423650y;
        float cross = f16 + (this.m_invIA * Vec2.cross(this.m_rA, popVec23));
        float f26 = vec22.f423649x;
        float f27 = this.m_invMassB;
        vec22.f423649x = f26 + (popVec24.f423649x * f27);
        vec22.f423650y += f27 * popVec24.f423650y;
        float cross2 = f17 + (this.m_invIB * Vec2.cross(this.m_rB, popVec24));
        Velocity[] velocityArr2 = solverData.velocities;
        velocityArr2[this.m_indexA].f423667w = cross;
        velocityArr2[this.m_indexB].f423667w = cross2;
        this.pool.pushVec2(4);
    }
}
