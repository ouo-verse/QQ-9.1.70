package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Mat22;
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
public class FrictionJoint extends Joint {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private float m_angularImpulse;
    private float m_angularMass;
    private int m_indexA;
    private int m_indexB;
    private float m_invIA;
    private float m_invIB;
    private float m_invMassA;
    private float m_invMassB;
    private final Vec2 m_linearImpulse;
    private final Mat22 m_linearMass;
    private final Vec2 m_localAnchorA;
    private final Vec2 m_localAnchorB;
    private final Vec2 m_localCenterA;
    private final Vec2 m_localCenterB;
    private float m_maxForce;
    private float m_maxTorque;
    private final Vec2 m_rA;
    private final Vec2 m_rB;

    /* JADX INFO: Access modifiers changed from: protected */
    public FrictionJoint(IWorldPool iWorldPool, FrictionJointDef frictionJointDef) {
        super(iWorldPool, frictionJointDef);
        this.m_rA = new Vec2();
        this.m_rB = new Vec2();
        this.m_localCenterA = new Vec2();
        this.m_localCenterB = new Vec2();
        this.m_linearMass = new Mat22();
        this.m_localAnchorA = new Vec2(frictionJointDef.localAnchorA);
        this.m_localAnchorB = new Vec2(frictionJointDef.localAnchorB);
        this.m_linearImpulse = new Vec2();
        this.m_angularImpulse = 0.0f;
        this.m_maxForce = frictionJointDef.maxForce;
        this.m_maxTorque = frictionJointDef.maxTorque;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getAnchorA(Vec2 vec2) {
        this.m_bodyA.getWorldPointToOut(this.m_localAnchorA, vec2);
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getAnchorB(Vec2 vec2) {
        this.m_bodyB.getWorldPointToOut(this.m_localAnchorB, vec2);
    }

    public Vec2 getLocalAnchorA() {
        return this.m_localAnchorA;
    }

    public Vec2 getLocalAnchorB() {
        return this.m_localAnchorB;
    }

    public float getMaxForce() {
        return this.m_maxForce;
    }

    public float getMaxTorque() {
        return this.m_maxTorque;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getReactionForce(float f16, Vec2 vec2) {
        vec2.set(this.m_linearImpulse).mulLocal(f16);
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public float getReactionTorque(float f16) {
        return f16 * this.m_angularImpulse;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void initVelocityConstraints(SolverData solverData) {
        float f16;
        float f17;
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
        float f18 = positionArr[i3].f423664a;
        Velocity[] velocityArr = solverData.velocities;
        Velocity velocity = velocityArr[i3];
        Vec2 vec2 = velocity.f423666v;
        float f19 = velocity.f423667w;
        int i16 = this.m_indexB;
        float f26 = positionArr[i16].f423664a;
        Velocity velocity2 = velocityArr[i16];
        Vec2 vec22 = velocity2.f423666v;
        float f27 = velocity2.f423667w;
        Vec2 popVec2 = this.pool.popVec2();
        Rot popRot = this.pool.popRot();
        Rot popRot2 = this.pool.popRot();
        popRot.set(f18);
        popRot2.set(f26);
        Rot.mulToOutUnsafe(popRot, popVec2.set(this.m_localAnchorA).subLocal(this.m_localCenterA), this.m_rA);
        Rot.mulToOutUnsafe(popRot2, popVec2.set(this.m_localAnchorB).subLocal(this.m_localCenterB), this.m_rB);
        float f28 = this.m_invMassA;
        float f29 = this.m_invMassB;
        float f36 = this.m_invIA;
        float f37 = this.m_invIB;
        Mat22 popMat22 = this.pool.popMat22();
        Vec2 vec23 = popMat22.f423636ex;
        float f38 = f28 + f29;
        Vec2 vec24 = this.m_rA;
        float f39 = vec24.f423650y;
        Vec2 vec25 = this.m_rB;
        float f46 = vec25.f423650y;
        vec23.f423649x = f38 + (f36 * f39 * f39) + (f37 * f46 * f46);
        float f47 = (((-f36) * vec24.f423649x) * f39) - ((vec25.f423649x * f37) * f46);
        vec23.f423650y = f47;
        Vec2 vec26 = popMat22.f423637ey;
        vec26.f423649x = f47;
        float f48 = vec24.f423649x;
        float f49 = f38 + (f36 * f48 * f48);
        float f56 = vec25.f423649x;
        vec26.f423650y = f49 + (f37 * f56 * f56);
        popMat22.invertToOut(this.m_linearMass);
        float f57 = f36 + f37;
        this.m_angularMass = f57;
        if (f57 > 0.0f) {
            this.m_angularMass = 1.0f / f57;
        }
        TimeStep timeStep = solverData.step;
        if (timeStep.warmStarting) {
            this.m_linearImpulse.mulLocal(timeStep.dtRatio);
            this.m_angularImpulse *= solverData.step.dtRatio;
            Vec2 popVec22 = this.pool.popVec2();
            popVec22.set(this.m_linearImpulse);
            popVec2.set(popVec22).mulLocal(f28);
            vec2.subLocal(popVec2);
            float cross = f19 - (f36 * (Vec2.cross(this.m_rA, popVec22) + this.m_angularImpulse));
            popVec2.set(popVec22).mulLocal(f29);
            vec22.addLocal(popVec2);
            f17 = f27 + (f37 * (Vec2.cross(this.m_rB, popVec22) + this.m_angularImpulse));
            this.pool.pushVec2(1);
            f16 = cross;
        } else {
            this.m_linearImpulse.setZero();
            this.m_angularImpulse = 0.0f;
            f16 = f19;
            f17 = f27;
        }
        Velocity[] velocityArr2 = solverData.velocities;
        Velocity velocity3 = velocityArr2[this.m_indexA];
        int i17 = (velocity3.f423667w > f16 ? 1 : (velocity3.f423667w == f16 ? 0 : -1));
        velocity3.f423667w = f16;
        velocityArr2[this.m_indexB].f423667w = f17;
        this.pool.pushRot(2);
        this.pool.pushVec2(1);
        this.pool.pushMat22(1);
    }

    public void setMaxForce(float f16) {
        this.m_maxForce = f16;
    }

    public void setMaxTorque(float f16) {
        this.m_maxTorque = f16;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public boolean solvePositionConstraints(SolverData solverData) {
        return true;
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
        float f18 = this.m_invMassA;
        float f19 = this.m_invMassB;
        float f26 = this.m_invIA;
        float f27 = this.m_invIB;
        float f28 = solverData.step.f423654dt;
        float f29 = (-this.m_angularMass) * (f17 - f16);
        float f36 = this.m_angularImpulse;
        float f37 = this.m_maxTorque * f28;
        float clamp = MathUtils.clamp(f29 + f36, -f37, f37);
        this.m_angularImpulse = clamp;
        float f38 = clamp - f36;
        float f39 = f16 - (f26 * f38);
        float f46 = f17 + (f38 * f27);
        Vec2 popVec2 = this.pool.popVec2();
        Vec2 popVec22 = this.pool.popVec2();
        Vec2.crossToOutUnsafe(f39, this.m_rA, popVec22);
        Vec2.crossToOutUnsafe(f46, this.m_rB, popVec2);
        popVec2.addLocal(vec22).subLocal(vec2).subLocal(popVec22);
        Vec2 popVec23 = this.pool.popVec2();
        Mat22.mulToOutUnsafe(this.m_linearMass, popVec2, popVec23);
        popVec23.negateLocal();
        Vec2 popVec24 = this.pool.popVec2();
        popVec24.set(this.m_linearImpulse);
        this.m_linearImpulse.addLocal(popVec23);
        float f47 = f28 * this.m_maxForce;
        if (this.m_linearImpulse.lengthSquared() > f47 * f47) {
            this.m_linearImpulse.normalize();
            this.m_linearImpulse.mulLocal(f47);
        }
        popVec23.set(this.m_linearImpulse).subLocal(popVec24);
        popVec22.set(popVec23).mulLocal(f18);
        vec2.subLocal(popVec22);
        float cross = f39 - (f26 * Vec2.cross(this.m_rA, popVec23));
        popVec22.set(popVec23).mulLocal(f19);
        vec22.addLocal(popVec22);
        float cross2 = f46 + (f27 * Vec2.cross(this.m_rB, popVec23));
        Velocity[] velocityArr2 = solverData.velocities;
        Velocity velocity3 = velocityArr2[this.m_indexA];
        int i3 = (velocity3.f423667w > cross ? 1 : (velocity3.f423667w == cross ? 0 : -1));
        velocity3.f423667w = cross;
        velocityArr2[this.m_indexB].f423667w = cross2;
        this.pool.pushVec2(4);
    }
}
