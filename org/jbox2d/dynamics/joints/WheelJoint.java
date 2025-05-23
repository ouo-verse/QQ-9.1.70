package org.jbox2d.dynamics.joints;

import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.SolverData;
import org.jbox2d.dynamics.contacts.Position;
import org.jbox2d.dynamics.contacts.Velocity;
import org.jbox2d.pooling.IWorldPool;

/* compiled from: P */
/* loaded from: classes29.dex */
public class WheelJoint extends Joint {

    /* renamed from: d, reason: collision with root package name */
    private final Vec2 f423668d;
    private final Vec2 m_ax;
    private final Vec2 m_ay;
    private float m_bias;
    private float m_dampingRatio;
    private boolean m_enableMotor;
    private float m_frequencyHz;
    private float m_gamma;
    private float m_impulse;
    private int m_indexA;
    private int m_indexB;
    private float m_invIA;
    private float m_invIB;
    private float m_invMassA;
    private float m_invMassB;
    private final Vec2 m_localAnchorA;
    private final Vec2 m_localAnchorB;
    private final Vec2 m_localCenterA;
    private final Vec2 m_localCenterB;
    private final Vec2 m_localXAxisA;
    private final Vec2 m_localYAxisA;
    private float m_mass;
    private float m_maxMotorTorque;
    private float m_motorImpulse;
    private float m_motorMass;
    private float m_motorSpeed;
    private float m_sAx;
    private float m_sAy;
    private float m_sBx;
    private float m_sBy;
    private float m_springImpulse;
    private float m_springMass;
    private final Vec2 rA;
    private final Vec2 rB;

    /* JADX INFO: Access modifiers changed from: protected */
    public WheelJoint(IWorldPool iWorldPool, WheelJointDef wheelJointDef) {
        super(iWorldPool, wheelJointDef);
        Vec2 vec2 = new Vec2();
        this.m_localAnchorA = vec2;
        Vec2 vec22 = new Vec2();
        this.m_localAnchorB = vec22;
        Vec2 vec23 = new Vec2();
        this.m_localXAxisA = vec23;
        Vec2 vec24 = new Vec2();
        this.m_localYAxisA = vec24;
        this.m_localCenterA = new Vec2();
        this.m_localCenterB = new Vec2();
        this.m_ax = new Vec2();
        this.m_ay = new Vec2();
        this.rA = new Vec2();
        this.rB = new Vec2();
        this.f423668d = new Vec2();
        vec2.set(wheelJointDef.localAnchorA);
        vec22.set(wheelJointDef.localAnchorB);
        vec23.set(wheelJointDef.localAxisA);
        Vec2.crossToOutUnsafe(1.0f, vec23, vec24);
        this.m_motorMass = 0.0f;
        this.m_motorImpulse = 0.0f;
        this.m_maxMotorTorque = wheelJointDef.maxMotorTorque;
        this.m_motorSpeed = wheelJointDef.motorSpeed;
        this.m_enableMotor = wheelJointDef.enableMotor;
        this.m_frequencyHz = wheelJointDef.frequencyHz;
        this.m_dampingRatio = wheelJointDef.dampingRatio;
    }

    public void enableMotor(boolean z16) {
        this.m_bodyA.setAwake(true);
        this.m_bodyB.setAwake(true);
        this.m_enableMotor = z16;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getAnchorA(Vec2 vec2) {
        this.m_bodyA.getWorldPointToOut(this.m_localAnchorA, vec2);
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getAnchorB(Vec2 vec2) {
        this.m_bodyB.getWorldPointToOut(this.m_localAnchorB, vec2);
    }

    public float getJointSpeed() {
        return this.m_bodyA.m_angularVelocity - this.m_bodyB.m_angularVelocity;
    }

    public float getJointTranslation() {
        Body body = this.m_bodyA;
        Body body2 = this.m_bodyB;
        Vec2 popVec2 = this.pool.popVec2();
        Vec2 popVec22 = this.pool.popVec2();
        Vec2 popVec23 = this.pool.popVec2();
        body.getWorldPointToOut(this.m_localAnchorA, popVec2);
        body2.getWorldPointToOut(this.m_localAnchorA, popVec22);
        popVec22.subLocal(popVec2);
        body.getWorldVectorToOut(this.m_localXAxisA, popVec23);
        float dot = Vec2.dot(popVec22, popVec23);
        this.pool.pushVec2(3);
        return dot;
    }

    public Vec2 getLocalAnchorA() {
        return this.m_localAnchorA;
    }

    public Vec2 getLocalAnchorB() {
        return this.m_localAnchorB;
    }

    public Vec2 getLocalAxisA() {
        return this.m_localXAxisA;
    }

    public float getMaxMotorTorque() {
        return this.m_maxMotorTorque;
    }

    public float getMotorSpeed() {
        return this.m_motorSpeed;
    }

    public float getMotorTorque(float f16) {
        return this.m_motorImpulse * f16;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getReactionForce(float f16, Vec2 vec2) {
        Vec2 popVec2 = this.pool.popVec2();
        popVec2.set(this.m_ay).mulLocal(this.m_impulse);
        vec2.set(this.m_ax).mulLocal(this.m_springImpulse).addLocal(popVec2).mulLocal(f16);
        this.pool.pushVec2(1);
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public float getReactionTorque(float f16) {
        return f16 * this.m_motorImpulse;
    }

    public float getSpringDampingRatio() {
        return this.m_dampingRatio;
    }

    public float getSpringFrequencyHz() {
        return this.m_frequencyHz;
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
        float f17 = body2.m_invMass;
        this.m_invMassA = f17;
        Body body3 = this.m_bodyB;
        float f18 = body3.m_invMass;
        this.m_invMassB = f18;
        float f19 = body2.m_invI;
        this.m_invIA = f19;
        float f26 = body3.m_invI;
        this.m_invIB = f26;
        Position[] positionArr = solverData.positions;
        int i3 = this.m_indexA;
        Position position = positionArr[i3];
        Vec2 vec2 = position.f423665c;
        float f27 = position.f423664a;
        Velocity[] velocityArr = solverData.velocities;
        Velocity velocity = velocityArr[i3];
        Vec2 vec22 = velocity.f423666v;
        float f28 = velocity.f423667w;
        int i16 = this.m_indexB;
        Position position2 = positionArr[i16];
        Vec2 vec23 = position2.f423665c;
        float f29 = position2.f423664a;
        Velocity velocity2 = velocityArr[i16];
        Vec2 vec24 = velocity2.f423666v;
        float f36 = velocity2.f423667w;
        Rot popRot = this.pool.popRot();
        Rot popRot2 = this.pool.popRot();
        Vec2 popVec2 = this.pool.popVec2();
        popRot.set(f27);
        popRot2.set(f29);
        Rot.mulToOutUnsafe(popRot, popVec2.set(this.m_localAnchorA).subLocal(this.m_localCenterA), this.rA);
        Rot.mulToOutUnsafe(popRot2, popVec2.set(this.m_localAnchorB).subLocal(this.m_localCenterB), this.rB);
        this.f423668d.set(vec23).addLocal(this.rB).subLocal(vec2).subLocal(this.rA);
        Rot.mulToOut(popRot, this.m_localYAxisA, this.m_ay);
        this.m_sAy = Vec2.cross(popVec2.set(this.f423668d).addLocal(this.rA), this.m_ay);
        float cross = Vec2.cross(this.rB, this.m_ay);
        this.m_sBy = cross;
        float f37 = f17 + f18;
        float f38 = this.m_sAy;
        float f39 = (f19 * f38 * f38) + f37 + (f26 * cross * cross);
        this.m_mass = f39;
        if (f39 > 0.0f) {
            this.m_mass = 1.0f / f39;
        }
        this.m_springMass = 0.0f;
        this.m_bias = 0.0f;
        this.m_gamma = 0.0f;
        if (this.m_frequencyHz > 0.0f) {
            Rot.mulToOut(popRot, this.m_localXAxisA, this.m_ax);
            this.m_sAx = Vec2.cross(popVec2.set(this.f423668d).addLocal(this.rA), this.m_ax);
            float cross2 = Vec2.cross(this.rB, this.m_ax);
            this.m_sBx = cross2;
            float f46 = this.m_sAx;
            float f47 = f37 + (f19 * f46 * f46) + (f26 * cross2 * cross2);
            if (f47 > 0.0f) {
                this.m_springMass = 1.0f / f47;
                float dot = Vec2.dot(this.f423668d, this.m_ax);
                float f48 = this.m_frequencyHz * 6.2831855f;
                float f49 = this.m_springMass;
                float f56 = 2.0f * f49 * this.m_dampingRatio * f48;
                float f57 = f49 * f48 * f48;
                float f58 = solverData.step.f423654dt;
                float f59 = (f56 + (f58 * f57)) * f58;
                this.m_gamma = f59;
                if (f59 > 0.0f) {
                    this.m_gamma = 1.0f / f59;
                }
                float f65 = dot * f58 * f57;
                float f66 = this.m_gamma;
                this.m_bias = f65 * f66;
                float f67 = f47 + f66;
                this.m_springMass = f67;
                if (f67 > 0.0f) {
                    this.m_springMass = 1.0f / f67;
                }
            }
        } else {
            this.m_springImpulse = 0.0f;
        }
        if (this.m_enableMotor) {
            float f68 = f19 + f26;
            this.m_motorMass = f68;
            if (f68 > 0.0f) {
                this.m_motorMass = 1.0f / f68;
            }
        } else {
            this.m_motorMass = 0.0f;
            this.m_motorImpulse = 0.0f;
        }
        if (solverData.step.warmStarting) {
            Vec2 popVec22 = this.pool.popVec2();
            float f69 = this.m_impulse;
            float f75 = solverData.step.dtRatio;
            float f76 = f69 * f75;
            this.m_impulse = f76;
            float f77 = this.m_springImpulse * f75;
            this.m_springImpulse = f77;
            float f78 = this.m_motorImpulse * f75;
            this.m_motorImpulse = f78;
            Vec2 vec25 = this.m_ay;
            float f79 = vec25.f423649x * f76;
            Vec2 vec26 = this.m_ax;
            float f85 = f79 + (vec26.f423649x * f77);
            popVec22.f423649x = f85;
            float f86 = (vec25.f423650y * f76) + (vec26.f423650y * f77);
            popVec22.f423650y = f86;
            float f87 = (this.m_sAy * f76) + (this.m_sAx * f77) + f78;
            float f88 = (f76 * this.m_sBy) + (f77 * this.m_sBx) + f78;
            float f89 = vec22.f423649x;
            float f95 = this.m_invMassA;
            vec22.f423649x = f89 - (f85 * f95);
            vec22.f423650y -= f95 * f86;
            f28 -= this.m_invIA * f87;
            float f96 = vec24.f423649x;
            float f97 = this.m_invMassB;
            vec24.f423649x = f96 + (popVec22.f423649x * f97);
            vec24.f423650y += f97 * popVec22.f423650y;
            f16 = f36 + (this.m_invIB * f88);
            this.pool.pushVec2(1);
        } else {
            this.m_impulse = 0.0f;
            this.m_springImpulse = 0.0f;
            this.m_motorImpulse = 0.0f;
            f16 = f36;
        }
        this.pool.pushRot(2);
        this.pool.pushVec2(1);
        Velocity[] velocityArr2 = solverData.velocities;
        velocityArr2[this.m_indexA].f423667w = f28;
        velocityArr2[this.m_indexB].f423667w = f16;
    }

    public boolean isMotorEnabled() {
        return this.m_enableMotor;
    }

    public void setMaxMotorTorque(float f16) {
        this.m_bodyA.setAwake(true);
        this.m_bodyB.setAwake(true);
        this.m_maxMotorTorque = f16;
    }

    public void setMotorSpeed(float f16) {
        this.m_bodyA.setAwake(true);
        this.m_bodyB.setAwake(true);
        this.m_motorSpeed = f16;
    }

    public void setSpringDampingRatio(float f16) {
        this.m_dampingRatio = f16;
    }

    public void setSpringFrequencyHz(float f16) {
        this.m_frequencyHz = f16;
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
        popRot.set(f16);
        popRot2.set(f17);
        Rot.mulToOut(popRot, popVec2.set(this.m_localAnchorA).subLocal(this.m_localCenterA), this.rA);
        Rot.mulToOut(popRot2, popVec2.set(this.m_localAnchorB).subLocal(this.m_localCenterB), this.rB);
        this.f423668d.set(vec22).subLocal(vec2).addLocal(this.rB).subLocal(this.rA);
        Vec2 popVec22 = this.pool.popVec2();
        Rot.mulToOut(popRot, this.m_localYAxisA, popVec22);
        float cross = Vec2.cross(popVec2.set(this.f423668d).addLocal(this.rA), popVec22);
        float cross2 = Vec2.cross(this.rB, popVec22);
        float dot = Vec2.dot(this.f423668d, popVec22);
        float f18 = this.m_invMassA + this.m_invMassB;
        float f19 = this.m_invIA;
        float f26 = this.m_sAy;
        float f27 = f18 + (f19 * f26 * f26);
        float f28 = this.m_invIB;
        float f29 = this.m_sBy;
        float f36 = f27 + (f28 * f29 * f29);
        float f37 = 0.0f;
        if (f36 != 0.0f) {
            f37 = (-dot) / f36;
        }
        Vec2 popVec23 = this.pool.popVec2();
        float f38 = popVec22.f423649x * f37;
        popVec23.f423649x = f38;
        float f39 = popVec22.f423650y * f37;
        popVec23.f423650y = f39;
        float f46 = cross * f37;
        float f47 = f37 * cross2;
        float f48 = vec2.f423649x;
        float f49 = this.m_invMassA;
        vec2.f423649x = f48 - (f38 * f49);
        vec2.f423650y -= f49 * f39;
        float f56 = f16 - (this.m_invIA * f46);
        float f57 = vec22.f423649x;
        float f58 = this.m_invMassB;
        vec22.f423649x = f57 + (popVec23.f423649x * f58);
        vec22.f423650y += f58 * popVec23.f423650y;
        float f59 = f17 + (this.m_invIB * f47);
        this.pool.pushVec2(3);
        this.pool.pushRot(2);
        Position[] positionArr2 = solverData.positions;
        positionArr2[this.m_indexA].f423664a = f56;
        positionArr2[this.m_indexB].f423664a = f59;
        if (MathUtils.abs(dot) <= 0.005f) {
            return true;
        }
        return false;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void solveVelocityConstraints(SolverData solverData) {
        float f16 = this.m_invMassA;
        float f17 = this.m_invMassB;
        float f18 = this.m_invIA;
        float f19 = this.m_invIB;
        Velocity[] velocityArr = solverData.velocities;
        Velocity velocity = velocityArr[this.m_indexA];
        Vec2 vec2 = velocity.f423666v;
        float f26 = velocity.f423667w;
        Velocity velocity2 = velocityArr[this.m_indexB];
        Vec2 vec22 = velocity2.f423666v;
        float f27 = velocity2.f423667w;
        Vec2 popVec2 = this.pool.popVec2();
        Vec2 popVec22 = this.pool.popVec2();
        float dot = Vec2.dot(this.m_ax, popVec2.set(vec22).subLocal(vec2));
        float f28 = this.m_sBx;
        float f29 = this.m_sAx;
        float f36 = -this.m_springMass;
        float f37 = ((dot + (f28 * f27)) - (f29 * f26)) + this.m_bias;
        float f38 = this.m_gamma;
        float f39 = this.m_springImpulse;
        float f46 = f36 * (f37 + (f38 * f39));
        this.m_springImpulse = f39 + f46;
        Vec2 vec23 = this.m_ax;
        float f47 = vec23.f423649x * f46;
        popVec22.f423649x = f47;
        float f48 = vec23.f423650y * f46;
        popVec22.f423650y = f48;
        vec2.f423649x -= f47 * f16;
        vec2.f423650y -= f48 * f16;
        float f49 = f26 - ((f29 * f46) * f18);
        vec22.f423649x += popVec22.f423649x * f17;
        vec22.f423650y += popVec22.f423650y * f17;
        float f56 = f27 + (f46 * f28 * f19);
        float f57 = (-this.m_motorMass) * ((f56 - f49) - this.m_motorSpeed);
        float f58 = this.m_motorImpulse;
        float f59 = solverData.step.f423654dt * this.m_maxMotorTorque;
        float clamp = MathUtils.clamp(f57 + f58, -f59, f59);
        this.m_motorImpulse = clamp;
        float f65 = clamp - f58;
        float f66 = f49 - (f18 * f65);
        float f67 = f56 + (f65 * f19);
        float dot2 = Vec2.dot(this.m_ay, popVec2.set(vec22).subLocal(vec2));
        float f68 = this.m_sBy;
        float f69 = this.m_sAy;
        float f75 = (-this.m_mass) * ((dot2 + (f68 * f67)) - (f69 * f66));
        this.m_impulse += f75;
        Vec2 vec24 = this.m_ay;
        float f76 = vec24.f423649x * f75;
        popVec22.f423649x = f76;
        float f77 = vec24.f423650y * f75;
        popVec22.f423650y = f77;
        vec2.f423649x -= f76 * f16;
        vec2.f423650y -= f16 * f77;
        vec22.f423649x += popVec22.f423649x * f17;
        vec22.f423650y += f17 * popVec22.f423650y;
        this.pool.pushVec2(2);
        Velocity[] velocityArr2 = solverData.velocities;
        velocityArr2[this.m_indexA].f423667w = f66 - (f18 * (f69 * f75));
        velocityArr2[this.m_indexB].f423667w = f67 + (f19 * f75 * f68);
    }
}
