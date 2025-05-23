package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Mat22;
import org.jbox2d.common.Mat33;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Vec2;
import org.jbox2d.common.Vec3;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.SolverData;
import org.jbox2d.dynamics.TimeStep;
import org.jbox2d.dynamics.contacts.Position;
import org.jbox2d.dynamics.contacts.Velocity;
import org.jbox2d.pooling.IWorldPool;

/* loaded from: classes29.dex */
public class PrismaticJoint extends Joint {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Mat33 m_K;
    private float m_a1;
    private float m_a2;
    private final Vec2 m_axis;
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
    protected final Vec2 m_localXAxisA;
    protected final Vec2 m_localYAxisA;
    private float m_lowerTranslation;
    private float m_maxMotorForce;
    private float m_motorImpulse;
    private float m_motorMass;
    private float m_motorSpeed;
    private final Vec2 m_perp;
    protected float m_referenceAngle;
    private float m_s1;
    private float m_s2;
    private float m_upperTranslation;

    /* JADX INFO: Access modifiers changed from: protected */
    public PrismaticJoint(IWorldPool iWorldPool, PrismaticJointDef prismaticJointDef) {
        super(iWorldPool, prismaticJointDef);
        this.m_localCenterA = new Vec2();
        this.m_localCenterB = new Vec2();
        this.m_localAnchorA = new Vec2(prismaticJointDef.localAnchorA);
        this.m_localAnchorB = new Vec2(prismaticJointDef.localAnchorB);
        Vec2 vec2 = new Vec2(prismaticJointDef.localAxisA);
        this.m_localXAxisA = vec2;
        vec2.normalize();
        Vec2 vec22 = new Vec2();
        this.m_localYAxisA = vec22;
        Vec2.crossToOutUnsafe(1.0f, vec2, vec22);
        this.m_referenceAngle = prismaticJointDef.referenceAngle;
        this.m_impulse = new Vec3();
        this.m_motorMass = 0.0f;
        this.m_motorImpulse = 0.0f;
        this.m_lowerTranslation = prismaticJointDef.lowerTranslation;
        this.m_upperTranslation = prismaticJointDef.upperTranslation;
        this.m_maxMotorForce = prismaticJointDef.maxMotorForce;
        this.m_motorSpeed = prismaticJointDef.motorSpeed;
        this.m_enableLimit = prismaticJointDef.enableLimit;
        this.m_enableMotor = prismaticJointDef.enableMotor;
        this.m_limitState = LimitState.INACTIVE;
        this.m_K = new Mat33();
        this.m_axis = new Vec2();
        this.m_perp = new Vec2();
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

    public float getJointSpeed() {
        Body body = this.m_bodyA;
        Body body2 = this.m_bodyB;
        Vec2 popVec2 = this.pool.popVec2();
        Vec2 popVec22 = this.pool.popVec2();
        Vec2 popVec23 = this.pool.popVec2();
        Vec2 popVec24 = this.pool.popVec2();
        Vec2 popVec25 = this.pool.popVec2();
        Vec2 popVec26 = this.pool.popVec2();
        Vec2 popVec27 = this.pool.popVec2();
        Vec2 popVec28 = this.pool.popVec2();
        Vec2 popVec29 = this.pool.popVec2();
        popVec2.set(this.m_localAnchorA).subLocal(body.m_sweep.localCenter);
        Rot.mulToOutUnsafe(body.m_xf.f423648q, popVec2, popVec22);
        popVec2.set(this.m_localAnchorB).subLocal(body2.m_sweep.localCenter);
        Rot.mulToOutUnsafe(body2.m_xf.f423648q, popVec2, popVec23);
        popVec24.set(body.m_sweep.f423645c).addLocal(popVec22);
        popVec25.set(body2.m_sweep.f423645c).addLocal(popVec23);
        popVec26.set(popVec25).subLocal(popVec24);
        Rot.mulToOutUnsafe(body.m_xf.f423648q, this.m_localXAxisA, popVec27);
        Vec2 vec2 = body.m_linearVelocity;
        Vec2 vec22 = body2.m_linearVelocity;
        float f16 = body.m_angularVelocity;
        float f17 = body2.m_angularVelocity;
        Vec2.crossToOutUnsafe(f16, popVec27, popVec2);
        Vec2.crossToOutUnsafe(f17, popVec23, popVec28);
        Vec2.crossToOutUnsafe(f16, popVec22, popVec29);
        popVec28.addLocal(vec22).subLocal(vec2).subLocal(popVec29);
        float dot = Vec2.dot(popVec26, popVec2) + Vec2.dot(popVec27, popVec28);
        this.pool.pushVec2(9);
        return dot;
    }

    public float getJointTranslation() {
        Vec2 popVec2 = this.pool.popVec2();
        Vec2 popVec22 = this.pool.popVec2();
        Vec2 popVec23 = this.pool.popVec2();
        this.m_bodyA.getWorldPointToOut(this.m_localAnchorA, popVec2);
        this.m_bodyB.getWorldPointToOut(this.m_localAnchorB, popVec22);
        this.m_bodyA.getWorldVectorToOutUnsafe(this.m_localXAxisA, popVec23);
        popVec22.subLocal(popVec2);
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

    public float getLowerLimit() {
        return this.m_lowerTranslation;
    }

    public float getMaxMotorForce() {
        return this.m_maxMotorForce;
    }

    public float getMotorForce(float f16) {
        return this.m_motorImpulse * f16;
    }

    public float getMotorSpeed() {
        return this.m_motorSpeed;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getReactionForce(float f16, Vec2 vec2) {
        Vec2 popVec2 = this.pool.popVec2();
        popVec2.set(this.m_axis).mulLocal(this.m_motorImpulse + this.m_impulse.f423653z);
        vec2.set(this.m_perp).mulLocal(this.m_impulse.f423651x).addLocal(popVec2).mulLocal(f16);
        this.pool.pushVec2(1);
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public float getReactionTorque(float f16) {
        return f16 * this.m_impulse.f423652y;
    }

    public float getReferenceAngle() {
        return this.m_referenceAngle;
    }

    public float getUpperLimit() {
        return this.m_upperTranslation;
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
        Vec2 popVec2 = this.pool.popVec2();
        Vec2 popVec22 = this.pool.popVec2();
        Vec2 popVec23 = this.pool.popVec2();
        Vec2 popVec24 = this.pool.popVec2();
        popRot.set(f19);
        popRot2.set(f27);
        Rot.mulToOutUnsafe(popRot, popVec2.set(this.m_localAnchorA).subLocal(this.m_localCenterA), popVec23);
        Rot.mulToOutUnsafe(popRot2, popVec2.set(this.m_localAnchorB).subLocal(this.m_localCenterB), popVec24);
        popVec2.set(vec23).subLocal(vec2).addLocal(popVec24).subLocal(popVec23);
        float f29 = this.m_invMassA;
        float f36 = this.m_invMassB;
        float f37 = this.m_invIA;
        float f38 = this.m_invIB;
        Rot.mulToOutUnsafe(popRot, this.m_localXAxisA, this.m_axis);
        popVec22.set(popVec2).addLocal(popVec23);
        this.m_a1 = Vec2.cross(popVec22, this.m_axis);
        float cross = Vec2.cross(popVec24, this.m_axis);
        this.m_a2 = cross;
        float f39 = f29 + f36;
        float f46 = this.m_a1;
        float f47 = f39 + (f37 * f46 * f46) + (f38 * cross * cross);
        this.m_motorMass = f47;
        if (f47 > 0.0f) {
            this.m_motorMass = 1.0f / f47;
        }
        Rot.mulToOutUnsafe(popRot, this.m_localYAxisA, this.m_perp);
        popVec22.set(popVec2).addLocal(popVec23);
        this.m_s1 = Vec2.cross(popVec22, this.m_perp);
        float cross2 = Vec2.cross(popVec24, this.m_perp);
        this.m_s2 = cross2;
        float f48 = this.m_s1;
        float f49 = (f37 * f48 * f48) + f39 + (f38 * cross2 * cross2);
        float f56 = (f37 * f48) + (f38 * cross2);
        float f57 = this.m_a1;
        float f58 = this.m_a2;
        float f59 = (f48 * f37 * f57) + (cross2 * f38 * f58);
        float f65 = f37 + f38;
        if (f65 == 0.0f) {
            f65 = 1.0f;
        }
        float f66 = (f37 * f57) + (f38 * f58);
        this.m_K.f423638ex.set(f49, f56, f59);
        this.m_K.f423639ey.set(f56, f65, f66);
        this.m_K.f423640ez.set(f59, f66, f39 + (f37 * f57 * f57) + (f38 * f58 * f58));
        if (this.m_enableLimit) {
            float dot = Vec2.dot(this.m_axis, popVec2);
            if (MathUtils.abs(this.m_upperTranslation - this.m_lowerTranslation) < 0.01f) {
                this.m_limitState = LimitState.EQUAL;
            } else if (dot <= this.m_lowerTranslation) {
                LimitState limitState = this.m_limitState;
                LimitState limitState2 = LimitState.AT_LOWER;
                if (limitState != limitState2) {
                    this.m_limitState = limitState2;
                    f16 = 0.0f;
                    this.m_impulse.f423653z = 0.0f;
                }
            } else {
                f16 = 0.0f;
                if (dot >= this.m_upperTranslation) {
                    LimitState limitState3 = this.m_limitState;
                    LimitState limitState4 = LimitState.AT_UPPER;
                    if (limitState3 != limitState4) {
                        this.m_limitState = limitState4;
                        this.m_impulse.f423653z = 0.0f;
                    }
                } else {
                    this.m_limitState = LimitState.INACTIVE;
                    this.m_impulse.f423653z = 0.0f;
                }
            }
            f16 = 0.0f;
        } else {
            f16 = 0.0f;
            this.m_limitState = LimitState.INACTIVE;
            this.m_impulse.f423653z = 0.0f;
        }
        if (!this.m_enableMotor) {
            this.m_motorImpulse = f16;
        }
        TimeStep timeStep = solverData.step;
        if (timeStep.warmStarting) {
            this.m_impulse.mulLocal(timeStep.dtRatio);
            this.m_motorImpulse *= solverData.step.dtRatio;
            Vec2 popVec25 = this.pool.popVec2();
            popVec22.set(this.m_axis).mulLocal(this.m_motorImpulse + this.m_impulse.f423653z);
            popVec25.set(this.m_perp).mulLocal(this.m_impulse.f423651x).addLocal(popVec22);
            Vec3 vec3 = this.m_impulse;
            float f67 = vec3.f423651x;
            float f68 = this.m_s1 * f67;
            float f69 = vec3.f423652y;
            float f75 = this.m_motorImpulse;
            float f76 = vec3.f423653z;
            float f77 = f68 + f69 + ((f75 + f76) * this.m_a1);
            float f78 = (f67 * this.m_s2) + f69 + ((f75 + f76) * this.m_a2);
            vec22.f423649x -= popVec25.f423649x * f29;
            vec22.f423650y -= f29 * popVec25.f423650y;
            vec24.f423649x += popVec25.f423649x * f36;
            vec24.f423650y += popVec25.f423650y * f36;
            f17 = f28 + (f38 * f78);
            this.pool.pushVec2(1);
            f18 = f26 - (f37 * f77);
        } else {
            this.m_impulse.setZero();
            this.m_motorImpulse = 0.0f;
            f17 = f28;
            f18 = f26;
        }
        Velocity[] velocityArr2 = solverData.velocities;
        velocityArr2[this.m_indexA].f423667w = f18;
        velocityArr2[this.m_indexB].f423667w = f17;
        this.pool.pushRot(2);
        this.pool.pushVec2(4);
    }

    public boolean isLimitEnabled() {
        return this.m_enableLimit;
    }

    public boolean isMotorEnabled() {
        return this.m_enableMotor;
    }

    public void setLimits(float f16, float f17) {
        if (f16 != this.m_lowerTranslation || f17 != this.m_upperTranslation) {
            this.m_bodyA.setAwake(true);
            this.m_bodyB.setAwake(true);
            this.m_lowerTranslation = f16;
            this.m_upperTranslation = f17;
            this.m_impulse.f423653z = 0.0f;
        }
    }

    public void setMaxMotorForce(float f16) {
        this.m_bodyA.setAwake(true);
        this.m_bodyB.setAwake(true);
        this.m_maxMotorForce = f16;
    }

    public void setMotorSpeed(float f16) {
        this.m_bodyA.setAwake(true);
        this.m_bodyB.setAwake(true);
        this.m_motorSpeed = f16;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0147  */
    @Override // org.jbox2d.dynamics.joints.Joint
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean solvePositionConstraints(SolverData solverData) {
        Vec2 vec2;
        boolean z16;
        float f16;
        float f17;
        float f18;
        float f19;
        Vec2 vec22;
        Vec3 vec3;
        float f26;
        float f27;
        Rot popRot = this.pool.popRot();
        Rot popRot2 = this.pool.popRot();
        Vec2 popVec2 = this.pool.popVec2();
        Vec2 popVec22 = this.pool.popVec2();
        Vec2 popVec23 = this.pool.popVec2();
        Vec2 popVec24 = this.pool.popVec2();
        Vec2 popVec25 = this.pool.popVec2();
        Vec2 popVec26 = this.pool.popVec2();
        Vec2 popVec27 = this.pool.popVec2();
        Vec3 popVec3 = this.pool.popVec3();
        Position[] positionArr = solverData.positions;
        Position position = positionArr[this.m_indexA];
        Vec2 vec23 = position.f423665c;
        float f28 = position.f423664a;
        Position position2 = positionArr[this.m_indexB];
        Vec2 vec24 = position2.f423665c;
        float f29 = position2.f423664a;
        popRot.set(f28);
        popRot2.set(f29);
        float f36 = this.m_invMassA;
        float f37 = this.m_invMassB;
        float f38 = this.m_invIA;
        float f39 = this.m_invIB;
        Rot.mulToOutUnsafe(popRot, popVec26.set(this.m_localAnchorA).subLocal(this.m_localCenterA), popVec2);
        Rot.mulToOutUnsafe(popRot2, popVec26.set(this.m_localAnchorB).subLocal(this.m_localCenterB), popVec22);
        popVec23.set(vec24).addLocal(popVec22).subLocal(vec23).subLocal(popVec2);
        Rot.mulToOutUnsafe(popRot, this.m_localXAxisA, popVec24);
        float cross = Vec2.cross(popVec26.set(popVec23).addLocal(popVec2), popVec24);
        float cross2 = Vec2.cross(popVec22, popVec24);
        Rot.mulToOutUnsafe(popRot, this.m_localYAxisA, popVec25);
        float cross3 = Vec2.cross(popVec26.set(popVec23).addLocal(popVec2), popVec25);
        float cross4 = Vec2.cross(popVec22, popVec25);
        float dot = Vec2.dot(popVec25, popVec23);
        popVec27.f423649x = dot;
        popVec27.f423650y = (f29 - f28) - this.m_referenceAngle;
        float abs = MathUtils.abs(dot);
        float abs2 = MathUtils.abs(popVec27.f423650y);
        if (this.m_enableLimit) {
            float dot2 = Vec2.dot(popVec24, popVec23);
            vec2 = vec24;
            if (MathUtils.abs(this.m_upperTranslation - this.m_lowerTranslation) < 0.01f) {
                f16 = MathUtils.clamp(dot2, -0.2f, 0.2f);
                abs = MathUtils.max(abs, MathUtils.abs(dot2));
            } else {
                float f46 = this.m_lowerTranslation;
                if (dot2 <= f46) {
                    float clamp = MathUtils.clamp((dot2 - f46) + 0.005f, -0.2f, 0.0f);
                    abs = MathUtils.max(abs, this.m_lowerTranslation - dot2);
                    f16 = clamp;
                } else {
                    float f47 = this.m_upperTranslation;
                    if (dot2 >= f47) {
                        float clamp2 = MathUtils.clamp((dot2 - f47) - 0.005f, 0.0f, 0.2f);
                        abs = MathUtils.max(abs, dot2 - this.m_upperTranslation);
                        f16 = clamp2;
                    }
                }
            }
            z16 = true;
            if (!z16) {
                float f48 = f36 + f37;
                float f49 = f38 * cross3;
                float f56 = f39 * cross4;
                float f57 = (f49 * cross3) + f48 + (f56 * cross4);
                float f58 = f49 + f56;
                float f59 = (f49 * cross) + (f56 * cross2);
                float f65 = f38 + f39;
                f18 = abs;
                if (f65 == 0.0f) {
                    f27 = 1.0f;
                } else {
                    f27 = f65;
                }
                float f66 = f38 * cross;
                float f67 = f39 * cross2;
                f19 = f28;
                float f68 = f66 + f67;
                float f69 = f48 + (f66 * cross) + (f67 * cross2);
                vec22 = vec23;
                Mat33 popMat33 = this.pool.popMat33();
                f17 = cross2;
                popMat33.f423638ex.set(f57, f58, f59);
                popMat33.f423639ey.set(f58, f27, f68);
                popMat33.f423640ez.set(f59, f68, f69);
                Vec3 popVec32 = this.pool.popVec3();
                popVec32.f423651x = popVec27.f423649x;
                popVec32.f423652y = popVec27.f423650y;
                popVec32.f423653z = f16;
                vec3 = popVec3;
                popMat33.solve33ToOut(popVec32.negateLocal(), vec3);
                this.pool.pushVec3(1);
                this.pool.pushMat33(1);
            } else {
                f17 = cross2;
                f18 = abs;
                f19 = f28;
                vec22 = vec23;
                vec3 = popVec3;
                float f75 = f38 * cross3;
                float f76 = f36 + f37 + (f75 * cross3);
                float f77 = f39 * cross4;
                float f78 = f76 + (f77 * cross4);
                float f79 = f75 + f77;
                float f85 = f38 + f39;
                if (f85 == 0.0f) {
                    f26 = 1.0f;
                } else {
                    f26 = f85;
                }
                Mat22 popMat22 = this.pool.popMat22();
                popMat22.f423636ex.set(f78, f79);
                popMat22.f423637ey.set(f79, f26);
                popMat22.solveToOut(popVec27.negateLocal(), popVec26);
                popVec27.negateLocal();
                vec3.f423651x = popVec26.f423649x;
                vec3.f423652y = popVec26.f423650y;
                vec3.f423653z = 0.0f;
                this.pool.pushMat22(1);
            }
            float f86 = vec3.f423651x;
            float f87 = popVec25.f423649x * f86;
            float f88 = vec3.f423653z;
            float f89 = f87 + (popVec24.f423649x * f88);
            float f95 = (popVec25.f423650y * f86) + (popVec24.f423650y * f88);
            float f96 = vec3.f423652y;
            float f97 = (cross3 * f86) + f96 + (cross * f88);
            Vec2 vec25 = vec22;
            vec25.f423649x -= f36 * f89;
            vec25.f423650y -= f36 * f95;
            float f98 = f19 - (f38 * f97);
            Vec2 vec26 = vec2;
            vec26.f423649x += f37 * f89;
            vec26.f423650y += f37 * f95;
            float f99 = f29 + (f39 * ((f86 * cross4) + f96 + (f88 * f17)));
            Position[] positionArr2 = solverData.positions;
            positionArr2[this.m_indexA].f423664a = f98;
            positionArr2[this.m_indexB].f423664a = f99;
            this.pool.pushVec2(7);
            this.pool.pushVec3(1);
            this.pool.pushRot(2);
            if (f18 <= 0.005f || abs2 > 0.03490659f) {
                return false;
            }
            return true;
        }
        vec2 = vec24;
        z16 = false;
        f16 = 0.0f;
        if (!z16) {
        }
        float f862 = vec3.f423651x;
        float f872 = popVec25.f423649x * f862;
        float f882 = vec3.f423653z;
        float f892 = f872 + (popVec24.f423649x * f882);
        float f952 = (popVec25.f423650y * f862) + (popVec24.f423650y * f882);
        float f962 = vec3.f423652y;
        float f972 = (cross3 * f862) + f962 + (cross * f882);
        Vec2 vec252 = vec22;
        vec252.f423649x -= f36 * f892;
        vec252.f423650y -= f36 * f952;
        float f982 = f19 - (f38 * f972);
        Vec2 vec262 = vec2;
        vec262.f423649x += f37 * f892;
        vec262.f423650y += f37 * f952;
        float f992 = f29 + (f39 * ((f862 * cross4) + f962 + (f882 * f17)));
        Position[] positionArr22 = solverData.positions;
        positionArr22[this.m_indexA].f423664a = f982;
        positionArr22[this.m_indexB].f423664a = f992;
        this.pool.pushVec2(7);
        this.pool.pushVec3(1);
        this.pool.pushRot(2);
        if (f18 <= 0.005f) {
        }
        return false;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void solveVelocityConstraints(SolverData solverData) {
        float f16;
        float f17;
        int i3;
        SolverData solverData2;
        Velocity[] velocityArr = solverData.velocities;
        Velocity velocity = velocityArr[this.m_indexA];
        Vec2 vec2 = velocity.f423666v;
        float f18 = velocity.f423667w;
        Velocity velocity2 = velocityArr[this.m_indexB];
        Vec2 vec22 = velocity2.f423666v;
        float f19 = velocity2.f423667w;
        float f26 = this.m_invMassA;
        float f27 = this.m_invMassB;
        float f28 = this.m_invIA;
        float f29 = this.m_invIB;
        Vec2 popVec2 = this.pool.popVec2();
        if (this.m_enableMotor && this.m_limitState != LimitState.EQUAL) {
            popVec2.set(vec22).subLocal(vec2);
            float dot = this.m_motorMass * (this.m_motorSpeed - ((Vec2.dot(this.m_axis, popVec2) + (this.m_a2 * f19)) - (this.m_a1 * f18)));
            float f36 = this.m_motorImpulse;
            float f37 = solverData.step.f423654dt * this.m_maxMotorForce;
            float clamp = MathUtils.clamp(dot + f36, -f37, f37);
            this.m_motorImpulse = clamp;
            float f38 = clamp - f36;
            Vec2 popVec22 = this.pool.popVec2();
            popVec22.set(this.m_axis).mulLocal(f38);
            float f39 = this.m_a1 * f38;
            float f46 = f38 * this.m_a2;
            vec2.f423649x -= popVec22.f423649x * f26;
            vec2.f423650y -= popVec22.f423650y * f26;
            f18 -= f39 * f28;
            vec22.f423649x += popVec22.f423649x * f27;
            vec22.f423650y += popVec22.f423650y * f27;
            f19 += f46 * f29;
            this.pool.pushVec2(1);
        }
        Vec2 popVec23 = this.pool.popVec2();
        popVec2.set(vec22).subLocal(vec2);
        popVec23.f423649x = (Vec2.dot(this.m_perp, popVec2) + (this.m_s2 * f19)) - (this.m_s1 * f18);
        popVec23.f423650y = f19 - f18;
        if (this.m_enableLimit && this.m_limitState != LimitState.INACTIVE) {
            popVec2.set(vec22).subLocal(vec2);
            float dot2 = (Vec2.dot(this.m_axis, popVec2) + (this.m_a2 * f19)) - (this.m_a1 * f18);
            Vec3 popVec3 = this.pool.popVec3();
            popVec3.set(popVec23.f423649x, popVec23.f423650y, dot2);
            Vec3 popVec32 = this.pool.popVec3();
            Vec3 popVec33 = this.pool.popVec3();
            popVec32.set(this.m_impulse);
            this.m_K.solve33ToOut(popVec3.negateLocal(), popVec33);
            this.m_impulse.addLocal(popVec33);
            LimitState limitState = this.m_limitState;
            if (limitState == LimitState.AT_LOWER) {
                Vec3 vec3 = this.m_impulse;
                vec3.f423653z = MathUtils.max(vec3.f423653z, 0.0f);
            } else if (limitState == LimitState.AT_UPPER) {
                Vec3 vec32 = this.m_impulse;
                vec32.f423653z = MathUtils.min(vec32.f423653z, 0.0f);
            }
            Vec2 popVec24 = this.pool.popVec2();
            Vec2 popVec25 = this.pool.popVec2();
            Vec3 vec33 = this.m_K.f423640ez;
            float f47 = f19;
            popVec2.set(vec33.f423651x, vec33.f423652y).mulLocal(this.m_impulse.f423653z - popVec32.f423653z);
            popVec24.set(popVec23).negateLocal().subLocal(popVec2);
            this.m_K.solve22ToOut(popVec24, popVec25);
            popVec25.addLocal(popVec32.f423651x, popVec32.f423652y);
            Vec3 vec34 = this.m_impulse;
            vec34.f423651x = popVec25.f423649x;
            vec34.f423652y = popVec25.f423650y;
            popVec33.set(vec34).subLocal(popVec32);
            Vec2 popVec26 = this.pool.popVec2();
            popVec2.set(this.m_axis).mulLocal(popVec33.f423653z);
            popVec26.set(this.m_perp).mulLocal(popVec33.f423651x).addLocal(popVec2);
            float f48 = popVec33.f423651x;
            float f49 = this.m_s1 * f48;
            float f56 = popVec33.f423652y;
            float f57 = popVec33.f423653z;
            float f58 = f49 + f56 + (this.m_a1 * f57);
            float f59 = (f48 * this.m_s2) + f56 + (f57 * this.m_a2);
            vec2.f423649x -= popVec26.f423649x * f26;
            vec2.f423650y -= f26 * popVec26.f423650y;
            f16 = f18 - (f28 * f58);
            vec22.f423649x += popVec26.f423649x * f27;
            vec22.f423650y += f27 * popVec26.f423650y;
            f17 = f47 + (f29 * f59);
            this.pool.pushVec2(3);
            this.pool.pushVec3(3);
            solverData2 = solverData;
            i3 = 2;
        } else {
            float f65 = f19;
            Vec2 popVec27 = this.pool.popVec2();
            this.m_K.solve22ToOut(popVec23.negateLocal(), popVec27);
            popVec23.negateLocal();
            Vec3 vec35 = this.m_impulse;
            vec35.f423651x += popVec27.f423649x;
            vec35.f423652y += popVec27.f423650y;
            Vec2 popVec28 = this.pool.popVec2();
            popVec28.set(this.m_perp).mulLocal(popVec27.f423649x);
            float f66 = popVec27.f423649x;
            float f67 = this.m_s1 * f66;
            float f68 = popVec27.f423650y;
            float f69 = (f66 * this.m_s2) + f68;
            vec2.f423649x -= popVec28.f423649x * f26;
            vec2.f423650y -= f26 * popVec28.f423650y;
            f16 = f18 - (f28 * (f67 + f68));
            vec22.f423649x += popVec28.f423649x * f27;
            vec22.f423650y += f27 * popVec28.f423650y;
            f17 = f65 + (f69 * f29);
            i3 = 2;
            this.pool.pushVec2(2);
            solverData2 = solverData;
        }
        Velocity[] velocityArr2 = solverData2.velocities;
        velocityArr2[this.m_indexA].f423667w = f16;
        velocityArr2[this.m_indexB].f423667w = f17;
        this.pool.pushVec2(i3);
    }
}
