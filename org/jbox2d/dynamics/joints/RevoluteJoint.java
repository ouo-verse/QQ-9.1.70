package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Mat22;
import org.jbox2d.common.Mat33;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Vec2;
import org.jbox2d.common.Vec3;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.SolverData;
import org.jbox2d.dynamics.contacts.Position;
import org.jbox2d.dynamics.contacts.Velocity;
import org.jbox2d.pooling.IWorldPool;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RevoluteJoint extends Joint {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean m_enableLimit;
    private boolean m_enableMotor;
    private final Vec3 m_impulse;
    private int m_indexA;
    private int m_indexB;
    private float m_invIA;
    private float m_invIB;
    private float m_invMassA;
    private float m_invMassB;
    private LimitState m_limitState;
    protected final Vec2 m_localAnchorA;
    protected final Vec2 m_localAnchorB;
    private final Vec2 m_localCenterA;
    private final Vec2 m_localCenterB;
    private float m_lowerAngle;
    private final Mat33 m_mass;
    private float m_maxMotorTorque;
    private float m_motorImpulse;
    private float m_motorMass;
    private float m_motorSpeed;
    private final Vec2 m_rA;
    private final Vec2 m_rB;
    protected float m_referenceAngle;
    private float m_upperAngle;

    /* JADX INFO: Access modifiers changed from: protected */
    public RevoluteJoint(IWorldPool iWorldPool, RevoluteJointDef revoluteJointDef) {
        super(iWorldPool, revoluteJointDef);
        Vec2 vec2 = new Vec2();
        this.m_localAnchorA = vec2;
        Vec2 vec22 = new Vec2();
        this.m_localAnchorB = vec22;
        this.m_impulse = new Vec3();
        this.m_rA = new Vec2();
        this.m_rB = new Vec2();
        this.m_localCenterA = new Vec2();
        this.m_localCenterB = new Vec2();
        this.m_mass = new Mat33();
        vec2.set(revoluteJointDef.localAnchorA);
        vec22.set(revoluteJointDef.localAnchorB);
        this.m_referenceAngle = revoluteJointDef.referenceAngle;
        this.m_motorImpulse = 0.0f;
        this.m_lowerAngle = revoluteJointDef.lowerAngle;
        this.m_upperAngle = revoluteJointDef.upperAngle;
        this.m_maxMotorTorque = revoluteJointDef.maxMotorTorque;
        this.m_motorSpeed = revoluteJointDef.motorSpeed;
        this.m_enableLimit = revoluteJointDef.enableLimit;
        this.m_enableMotor = revoluteJointDef.enableMotor;
        this.m_limitState = LimitState.INACTIVE;
    }

    public void enableLimit(boolean z16) {
        if (z16 != this.m_enableLimit) {
            this.m_bodyA.setAwake(true);
            this.m_bodyB.setAwake(true);
            this.m_enableLimit = z16;
            this.m_impulse.f423653z = 0.0f;
        }
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

    public float getJointAngle() {
        return (this.m_bodyB.m_sweep.f423643a - this.m_bodyA.m_sweep.f423643a) - this.m_referenceAngle;
    }

    public float getJointSpeed() {
        return this.m_bodyB.m_angularVelocity - this.m_bodyA.m_angularVelocity;
    }

    public Vec2 getLocalAnchorA() {
        return this.m_localAnchorA;
    }

    public Vec2 getLocalAnchorB() {
        return this.m_localAnchorB;
    }

    public float getLowerLimit() {
        return this.m_lowerAngle;
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
        Vec3 vec3 = this.m_impulse;
        vec2.set(vec3.f423651x, vec3.f423652y).mulLocal(f16);
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public float getReactionTorque(float f16) {
        return f16 * this.m_impulse.f423653z;
    }

    public float getReferenceAngle() {
        return this.m_referenceAngle;
    }

    public float getUpperLimit() {
        return this.m_upperAngle;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void initVelocityConstraints(SolverData solverData) {
        boolean z16;
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
        Rot popRot = this.pool.popRot();
        Rot popRot2 = this.pool.popRot();
        Vec2 popVec2 = this.pool.popVec2();
        popRot.set(f18);
        popRot2.set(f26);
        Rot.mulToOutUnsafe(popRot, popVec2.set(this.m_localAnchorA).subLocal(this.m_localCenterA), this.m_rA);
        Rot.mulToOutUnsafe(popRot2, popVec2.set(this.m_localAnchorB).subLocal(this.m_localCenterB), this.m_rB);
        float f28 = this.m_invMassA;
        float f29 = this.m_invMassB;
        float f36 = this.m_invIA;
        float f37 = this.m_invIB;
        float f38 = f36 + f37;
        if (f38 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        Mat33 mat33 = this.m_mass;
        Vec3 vec3 = mat33.f423638ex;
        float f39 = f28 + f29;
        Vec2 vec23 = this.m_rA;
        float f46 = vec23.f423650y;
        Vec2 vec24 = this.m_rB;
        float f47 = vec24.f423650y;
        vec3.f423651x = f39 + (f46 * f46 * f36) + (f47 * f47 * f37);
        Vec3 vec32 = mat33.f423639ey;
        float f48 = vec23.f423649x;
        float f49 = vec24.f423649x;
        vec32.f423651x = (((-f46) * f48) * f36) - ((f47 * f49) * f37);
        Vec3 vec33 = mat33.f423640ez;
        float f56 = ((-f46) * f36) - (f47 * f37);
        vec33.f423651x = f56;
        vec3.f423652y = vec32.f423651x;
        vec32.f423652y = f39 + (f48 * f48 * f36) + (f49 * f49 * f37);
        float f57 = (f48 * f36) + (f49 * f37);
        vec33.f423652y = f57;
        vec3.f423653z = f56;
        vec32.f423653z = f57;
        vec33.f423653z = f38;
        this.m_motorMass = f38;
        if (f38 > 0.0f) {
            this.m_motorMass = 1.0f / f38;
        }
        if (!this.m_enableMotor || z16) {
            this.m_motorImpulse = 0.0f;
        }
        if (this.m_enableLimit && !z16) {
            float f58 = (f26 - f18) - this.m_referenceAngle;
            if (MathUtils.abs(this.m_upperAngle - this.m_lowerAngle) < 0.06981318f) {
                this.m_limitState = LimitState.EQUAL;
            } else if (f58 <= this.m_lowerAngle) {
                LimitState limitState = this.m_limitState;
                LimitState limitState2 = LimitState.AT_LOWER;
                if (limitState != limitState2) {
                    this.m_impulse.f423653z = 0.0f;
                }
                this.m_limitState = limitState2;
            } else if (f58 >= this.m_upperAngle) {
                LimitState limitState3 = this.m_limitState;
                LimitState limitState4 = LimitState.AT_UPPER;
                if (limitState3 != limitState4) {
                    this.m_impulse.f423653z = 0.0f;
                }
                this.m_limitState = limitState4;
            } else {
                this.m_limitState = LimitState.INACTIVE;
                this.m_impulse.f423653z = 0.0f;
            }
        } else {
            this.m_limitState = LimitState.INACTIVE;
        }
        if (solverData.step.warmStarting) {
            Vec2 popVec22 = this.pool.popVec2();
            Vec3 vec34 = this.m_impulse;
            float f59 = vec34.f423651x;
            float f65 = solverData.step.dtRatio;
            float f66 = f59 * f65;
            vec34.f423651x = f66;
            float f67 = vec34.f423652y * f65;
            vec34.f423652y = f67;
            this.m_motorImpulse *= f65;
            popVec22.f423649x = f66;
            popVec22.f423650y = f67;
            vec2.f423649x -= f28 * f66;
            vec2.f423650y -= f28 * f67;
            f17 = f19 - (f36 * ((Vec2.cross(this.m_rA, popVec22) + this.m_motorImpulse) + this.m_impulse.f423653z));
            vec22.f423649x += f29 * popVec22.f423649x;
            vec22.f423650y += f29 * popVec22.f423650y;
            f16 = f27 + (f37 * (Vec2.cross(this.m_rB, popVec22) + this.m_motorImpulse + this.m_impulse.f423653z));
            this.pool.pushVec2(1);
        } else {
            this.m_impulse.setZero();
            this.m_motorImpulse = 0.0f;
            f16 = f27;
            f17 = f19;
        }
        Velocity[] velocityArr2 = solverData.velocities;
        velocityArr2[this.m_indexA].f423667w = f17;
        velocityArr2[this.m_indexB].f423667w = f16;
        this.pool.pushVec2(1);
        this.pool.pushRot(2);
    }

    public boolean isLimitEnabled() {
        return this.m_enableLimit;
    }

    public boolean isMotorEnabled() {
        return this.m_enableMotor;
    }

    public void setLimits(float f16, float f17) {
        if (f16 != this.m_lowerAngle || f17 != this.m_upperAngle) {
            this.m_bodyA.setAwake(true);
            this.m_bodyB.setAwake(true);
            this.m_impulse.f423653z = 0.0f;
            this.m_lowerAngle = f16;
            this.m_upperAngle = f17;
        }
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

    @Override // org.jbox2d.dynamics.joints.Joint
    public boolean solvePositionConstraints(SolverData solverData) {
        boolean z16;
        LimitState limitState;
        float f16;
        Rot popRot = this.pool.popRot();
        Rot popRot2 = this.pool.popRot();
        Position[] positionArr = solverData.positions;
        Position position = positionArr[this.m_indexA];
        Vec2 vec2 = position.f423665c;
        float f17 = position.f423664a;
        Position position2 = positionArr[this.m_indexB];
        Vec2 vec22 = position2.f423665c;
        float f18 = position2.f423664a;
        popRot.set(f17);
        popRot2.set(f18);
        float f19 = 0.0f;
        if (this.m_invIA + this.m_invIB == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.m_enableLimit && (limitState = this.m_limitState) != LimitState.INACTIVE && !z16) {
            float f26 = (f18 - f17) - this.m_referenceAngle;
            if (limitState == LimitState.EQUAL) {
                float clamp = MathUtils.clamp(f26 - this.m_lowerAngle, -0.13962635f, 0.13962635f);
                f19 = (-this.m_motorMass) * clamp;
                f16 = MathUtils.abs(clamp);
            } else if (limitState == LimitState.AT_LOWER) {
                float f27 = f26 - this.m_lowerAngle;
                f19 = (-this.m_motorMass) * MathUtils.clamp(f27 + 0.03490659f, -0.13962635f, 0.0f);
                f16 = -f27;
            } else if (limitState == LimitState.AT_UPPER) {
                f16 = f26 - this.m_upperAngle;
                f19 = MathUtils.clamp(f16 - 0.03490659f, 0.0f, 0.13962635f) * (-this.m_motorMass);
            } else {
                f16 = 0.0f;
            }
            f17 -= this.m_invIA * f19;
            f18 += this.m_invIB * f19;
            f19 = f16;
        }
        popRot.set(f17);
        popRot2.set(f18);
        Vec2 popVec2 = this.pool.popVec2();
        Vec2 popVec22 = this.pool.popVec2();
        Vec2 popVec23 = this.pool.popVec2();
        Vec2 popVec24 = this.pool.popVec2();
        Rot.mulToOutUnsafe(popRot, popVec23.set(this.m_localAnchorA).subLocal(this.m_localCenterA), popVec2);
        Rot.mulToOutUnsafe(popRot2, popVec23.set(this.m_localAnchorB).subLocal(this.m_localCenterB), popVec22);
        popVec23.set(vec22).addLocal(popVec22).subLocal(vec2).subLocal(popVec2);
        float length = popVec23.length();
        float f28 = this.m_invMassA;
        float f29 = this.m_invMassB;
        float f36 = this.m_invIA;
        float f37 = this.m_invIB;
        float f38 = f19;
        Mat22 popMat22 = this.pool.popMat22();
        Vec2 vec23 = popMat22.f423636ex;
        float f39 = f28 + f29;
        float f46 = popVec2.f423650y;
        float f47 = popVec22.f423650y;
        float f48 = f18;
        vec23.f423649x = f39 + (f36 * f46 * f46) + (f37 * f47 * f47);
        float f49 = (((-f36) * popVec2.f423649x) * f46) - ((popVec22.f423649x * f37) * f47);
        vec23.f423650y = f49;
        Vec2 vec24 = popMat22.f423637ey;
        vec24.f423649x = f49;
        float f56 = popVec2.f423649x;
        float f57 = f39 + (f36 * f56 * f56);
        float f58 = popVec22.f423649x;
        vec24.f423650y = f57 + (f37 * f58 * f58);
        popMat22.solveToOut(popVec23, popVec24);
        popVec24.negateLocal();
        vec2.f423649x -= popVec24.f423649x * f28;
        vec2.f423650y -= f28 * popVec24.f423650y;
        float cross = f17 - (f36 * Vec2.cross(popVec2, popVec24));
        vec22.f423649x += f29 * popVec24.f423649x;
        vec22.f423650y += f29 * popVec24.f423650y;
        float cross2 = f48 + (f37 * Vec2.cross(popVec22, popVec24));
        this.pool.pushVec2(4);
        this.pool.pushMat22(1);
        Position[] positionArr2 = solverData.positions;
        positionArr2[this.m_indexA].f423664a = cross;
        positionArr2[this.m_indexB].f423664a = cross2;
        this.pool.pushRot(2);
        if (length <= 0.005f && f38 <= 0.03490659f) {
            return true;
        }
        return false;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void solveVelocityConstraints(SolverData solverData) {
        boolean z16;
        float cross;
        float cross2;
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
        if (f26 + f27 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.m_enableMotor && this.m_limitState != LimitState.EQUAL && !z16) {
            float f28 = (-this.m_motorMass) * ((f17 - f16) - this.m_motorSpeed);
            float f29 = this.m_motorImpulse;
            float f36 = solverData.step.f423654dt * this.m_maxMotorTorque;
            float clamp = MathUtils.clamp(f28 + f29, -f36, f36);
            this.m_motorImpulse = clamp;
            float f37 = clamp - f29;
            f16 -= f26 * f37;
            f17 += f37 * f27;
        }
        Vec2 popVec2 = this.pool.popVec2();
        if (this.m_enableLimit && this.m_limitState != LimitState.INACTIVE && !z16) {
            Vec2 popVec22 = this.pool.popVec2();
            Vec3 popVec3 = this.pool.popVec3();
            Vec2.crossToOutUnsafe(f16, this.m_rA, popVec2);
            Vec2.crossToOutUnsafe(f17, this.m_rB, popVec22);
            popVec22.addLocal(vec22).subLocal(vec2).subLocal(popVec2);
            popVec3.set(popVec22.f423649x, popVec22.f423650y, f17 - f16);
            Vec3 popVec32 = this.pool.popVec3();
            this.m_mass.solve33ToOut(popVec3, popVec32);
            popVec32.negateLocal();
            LimitState limitState = this.m_limitState;
            if (limitState == LimitState.EQUAL) {
                this.m_impulse.addLocal(popVec32);
            } else if (limitState == LimitState.AT_LOWER) {
                Vec3 vec3 = this.m_impulse;
                if (vec3.f423653z + popVec32.f423653z < 0.0f) {
                    Vec2 popVec23 = this.pool.popVec2();
                    Vec3 vec32 = this.m_mass.f423640ez;
                    popVec23.set(vec32.f423651x, vec32.f423652y).mulLocal(this.m_impulse.f423653z).subLocal(popVec22);
                    this.m_mass.solve22ToOut(popVec23, popVec2);
                    float f38 = popVec2.f423649x;
                    popVec32.f423651x = f38;
                    float f39 = popVec2.f423650y;
                    popVec32.f423652y = f39;
                    Vec3 vec33 = this.m_impulse;
                    popVec32.f423653z = -vec33.f423653z;
                    vec33.f423651x += f38;
                    vec33.f423652y += f39;
                    vec33.f423653z = 0.0f;
                    this.pool.pushVec2(1);
                } else {
                    vec3.addLocal(popVec32);
                }
            } else if (limitState == LimitState.AT_UPPER) {
                Vec3 vec34 = this.m_impulse;
                if (vec34.f423653z + popVec32.f423653z > 0.0f) {
                    Vec2 popVec24 = this.pool.popVec2();
                    Vec3 vec35 = this.m_mass.f423640ez;
                    popVec24.set(vec35.f423651x, vec35.f423652y).mulLocal(this.m_impulse.f423653z).subLocal(popVec22);
                    this.m_mass.solve22ToOut(popVec24, popVec2);
                    float f46 = popVec2.f423649x;
                    popVec32.f423651x = f46;
                    float f47 = popVec2.f423650y;
                    popVec32.f423652y = f47;
                    Vec3 vec36 = this.m_impulse;
                    popVec32.f423653z = -vec36.f423653z;
                    vec36.f423651x += f46;
                    vec36.f423652y += f47;
                    vec36.f423653z = 0.0f;
                    this.pool.pushVec2(1);
                } else {
                    vec34.addLocal(popVec32);
                }
            }
            Vec2 popVec25 = this.pool.popVec2();
            popVec25.set(popVec32.f423651x, popVec32.f423652y);
            vec2.f423649x -= popVec25.f423649x * f18;
            vec2.f423650y -= f18 * popVec25.f423650y;
            cross = f16 - (f26 * (Vec2.cross(this.m_rA, popVec25) + popVec32.f423653z));
            vec22.f423649x += popVec25.f423649x * f19;
            vec22.f423650y += f19 * popVec25.f423650y;
            cross2 = f17 + (f27 * (Vec2.cross(this.m_rB, popVec25) + popVec32.f423653z));
            this.pool.pushVec2(2);
            this.pool.pushVec3(2);
        } else {
            Vec2 popVec26 = this.pool.popVec2();
            Vec2 popVec27 = this.pool.popVec2();
            Vec2.crossToOutUnsafe(f16, this.m_rA, popVec2);
            Vec2.crossToOutUnsafe(f17, this.m_rB, popVec26);
            popVec26.addLocal(vec22).subLocal(vec2).subLocal(popVec2);
            this.m_mass.solve22ToOut(popVec26.negateLocal(), popVec27);
            Vec3 vec37 = this.m_impulse;
            float f48 = vec37.f423651x;
            float f49 = popVec27.f423649x;
            vec37.f423651x = f48 + f49;
            float f56 = vec37.f423652y;
            float f57 = popVec27.f423650y;
            vec37.f423652y = f56 + f57;
            vec2.f423649x -= f49 * f18;
            vec2.f423650y -= f18 * f57;
            cross = f16 - (f26 * Vec2.cross(this.m_rA, popVec27));
            vec22.f423649x += popVec27.f423649x * f19;
            vec22.f423650y += f19 * popVec27.f423650y;
            cross2 = f17 + (f27 * Vec2.cross(this.m_rB, popVec27));
            this.pool.pushVec2(2);
        }
        Velocity[] velocityArr2 = solverData.velocities;
        velocityArr2[this.m_indexA].f423667w = cross;
        velocityArr2[this.m_indexB].f423667w = cross2;
        this.pool.pushVec2(1);
    }
}
