package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Mat22;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.SolverData;
import org.jbox2d.dynamics.TimeStep;
import org.jbox2d.dynamics.contacts.Position;
import org.jbox2d.dynamics.contacts.Velocity;
import org.jbox2d.pooling.IWorldPool;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MouseJoint extends Joint {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Vec2 m_C;
    private float m_beta;
    private float m_dampingRatio;
    private float m_frequencyHz;
    private float m_gamma;
    private final Vec2 m_impulse;
    private int m_indexB;
    private float m_invIB;
    private float m_invMassB;
    private final Vec2 m_localAnchorB;
    private final Vec2 m_localCenterB;
    private final Mat22 m_mass;
    private float m_maxForce;
    private final Vec2 m_rB;
    private final Vec2 m_targetA;

    /* JADX INFO: Access modifiers changed from: protected */
    public MouseJoint(IWorldPool iWorldPool, MouseJointDef mouseJointDef) {
        super(iWorldPool, mouseJointDef);
        Vec2 vec2 = new Vec2();
        this.m_localAnchorB = vec2;
        Vec2 vec22 = new Vec2();
        this.m_targetA = vec22;
        Vec2 vec23 = new Vec2();
        this.m_impulse = vec23;
        this.m_rB = new Vec2();
        this.m_localCenterB = new Vec2();
        this.m_mass = new Mat22();
        this.m_C = new Vec2();
        vec22.set(mouseJointDef.target);
        Transform.mulTransToOutUnsafe(this.m_bodyB.getTransform(), vec22, vec2);
        this.m_maxForce = mouseJointDef.maxForce;
        vec23.setZero();
        this.m_frequencyHz = mouseJointDef.frequencyHz;
        this.m_dampingRatio = mouseJointDef.dampingRatio;
        this.m_beta = 0.0f;
        this.m_gamma = 0.0f;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getAnchorA(Vec2 vec2) {
        vec2.set(this.m_targetA);
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

    public float getMaxForce() {
        return this.m_maxForce;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getReactionForce(float f16, Vec2 vec2) {
        vec2.set(this.m_impulse).mulLocal(f16);
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public float getReactionTorque(float f16) {
        return f16 * 0.0f;
    }

    public Vec2 getTarget() {
        return this.m_targetA;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void initVelocityConstraints(SolverData solverData) {
        Body body = this.m_bodyB;
        this.m_indexB = body.m_islandIndex;
        this.m_localCenterB.set(body.m_sweep.localCenter);
        Body body2 = this.m_bodyB;
        this.m_invMassB = body2.m_invMass;
        this.m_invIB = body2.m_invI;
        Position[] positionArr = solverData.positions;
        int i3 = this.m_indexB;
        Position position = positionArr[i3];
        Vec2 vec2 = position.f423665c;
        float f16 = position.f423664a;
        Velocity velocity = solverData.velocities[i3];
        Vec2 vec22 = velocity.f423666v;
        float f17 = velocity.f423667w;
        Rot popRot = this.pool.popRot();
        popRot.set(f16);
        float mass = this.m_bodyB.getMass();
        float f18 = this.m_frequencyHz * 6.2831855f;
        float f19 = 2.0f * mass * this.m_dampingRatio * f18;
        float f26 = mass * f18 * f18;
        float f27 = solverData.step.f423654dt;
        float f28 = f26 * f27;
        float f29 = f27 * (f19 + f28);
        this.m_gamma = f29;
        if (f29 != 0.0f) {
            this.m_gamma = 1.0f / f29;
        }
        this.m_beta = f28 * this.m_gamma;
        Rot.mulToOutUnsafe(popRot, this.pool.popVec2().set(this.m_localAnchorB).subLocal(this.m_localCenterB), this.m_rB);
        Mat22 popMat22 = this.pool.popMat22();
        Vec2 vec23 = popMat22.f423636ex;
        float f36 = this.m_invMassB;
        float f37 = this.m_invIB;
        Vec2 vec24 = this.m_rB;
        float f38 = vec24.f423650y;
        float f39 = this.m_gamma;
        vec23.f423649x = (f37 * f38 * f38) + f36 + f39;
        float f46 = (-f37) * vec24.f423649x * f38;
        vec23.f423650y = f46;
        Vec2 vec25 = popMat22.f423637ey;
        vec25.f423649x = f46;
        float f47 = vec24.f423649x;
        vec25.f423650y = f36 + (f37 * f47 * f47) + f39;
        popMat22.invertToOut(this.m_mass);
        this.m_C.set(vec2).addLocal(this.m_rB).subLocal(this.m_targetA);
        this.m_C.mulLocal(this.m_beta);
        float f48 = f17 * 0.98f;
        TimeStep timeStep = solverData.step;
        if (timeStep.warmStarting) {
            this.m_impulse.mulLocal(timeStep.dtRatio);
            float f49 = vec22.f423649x;
            float f56 = this.m_invMassB;
            Vec2 vec26 = this.m_impulse;
            vec22.f423649x = f49 + (vec26.f423649x * f56);
            vec22.f423650y += f56 * vec26.f423650y;
            f48 += this.m_invIB * Vec2.cross(this.m_rB, vec26);
        } else {
            this.m_impulse.setZero();
        }
        solverData.velocities[this.m_indexB].f423667w = f48;
        this.pool.pushVec2(1);
        this.pool.pushMat22(1);
        this.pool.pushRot(1);
    }

    public void setDampingRatio(float f16) {
        this.m_dampingRatio = f16;
    }

    public void setFrequency(float f16) {
        this.m_frequencyHz = f16;
    }

    public void setMaxForce(float f16) {
        this.m_maxForce = f16;
    }

    public void setTarget(Vec2 vec2) {
        if (!this.m_bodyB.isAwake()) {
            this.m_bodyB.setAwake(true);
        }
        this.m_targetA.set(vec2);
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public boolean solvePositionConstraints(SolverData solverData) {
        return true;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void solveVelocityConstraints(SolverData solverData) {
        Velocity velocity = solverData.velocities[this.m_indexB];
        Vec2 vec2 = velocity.f423666v;
        float f16 = velocity.f423667w;
        Vec2 popVec2 = this.pool.popVec2();
        Vec2.crossToOutUnsafe(f16, this.m_rB, popVec2);
        popVec2.addLocal(vec2);
        Vec2 popVec22 = this.pool.popVec2();
        Vec2 popVec23 = this.pool.popVec2();
        popVec23.set(this.m_impulse).mulLocal(this.m_gamma).addLocal(this.m_C).addLocal(popVec2).negateLocal();
        Mat22.mulToOutUnsafe(this.m_mass, popVec23, popVec22);
        popVec23.set(this.m_impulse);
        this.m_impulse.addLocal(popVec22);
        float f17 = solverData.step.f423654dt * this.m_maxForce;
        if (this.m_impulse.lengthSquared() > f17 * f17) {
            Vec2 vec22 = this.m_impulse;
            vec22.mulLocal(f17 / vec22.length());
        }
        popVec22.set(this.m_impulse).subLocal(popVec23);
        float f18 = vec2.f423649x;
        float f19 = this.m_invMassB;
        vec2.f423649x = f18 + (popVec22.f423649x * f19);
        vec2.f423650y += f19 * popVec22.f423650y;
        solverData.velocities[this.m_indexB].f423667w = f16 + (this.m_invIB * Vec2.cross(this.m_rB, popVec22));
        this.pool.pushVec2(3);
    }
}
