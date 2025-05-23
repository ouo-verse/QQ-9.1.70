package org.jbox2d.dynamics.joints;

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
public class WeldJoint extends Joint {
    private float m_bias;
    private float m_dampingRatio;
    private float m_frequencyHz;
    private float m_gamma;
    private final Vec3 m_impulse;
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
    private final Mat33 m_mass;
    private final Vec2 m_rA;
    private final Vec2 m_rB;
    private float m_referenceAngle;

    /* JADX INFO: Access modifiers changed from: protected */
    public WeldJoint(IWorldPool iWorldPool, WeldJointDef weldJointDef) {
        super(iWorldPool, weldJointDef);
        this.m_rA = new Vec2();
        this.m_rB = new Vec2();
        this.m_localCenterA = new Vec2();
        this.m_localCenterB = new Vec2();
        this.m_mass = new Mat33();
        this.m_localAnchorA = new Vec2(weldJointDef.localAnchorA);
        this.m_localAnchorB = new Vec2(weldJointDef.localAnchorB);
        this.m_referenceAngle = weldJointDef.referenceAngle;
        this.m_frequencyHz = weldJointDef.frequencyHz;
        this.m_dampingRatio = weldJointDef.dampingRatio;
        Vec3 vec3 = new Vec3();
        this.m_impulse = vec3;
        vec3.setZero();
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

    public Vec2 getLocalAnchorA() {
        return this.m_localAnchorA;
    }

    public Vec2 getLocalAnchorB() {
        return this.m_localAnchorB;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getReactionForce(float f16, Vec2 vec2) {
        Vec3 vec3 = this.m_impulse;
        vec2.set(vec3.f423651x, vec3.f423652y);
        vec2.mulLocal(f16);
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public float getReactionTorque(float f16) {
        return f16 * this.m_impulse.f423653z;
    }

    public float getReferenceAngle() {
        return this.m_referenceAngle;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void initVelocityConstraints(SolverData solverData) {
        float f16;
        float f17;
        float f18;
        float f19;
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
        float f26 = positionArr[i3].f423664a;
        Velocity[] velocityArr = solverData.velocities;
        Velocity velocity = velocityArr[i3];
        Vec2 vec2 = velocity.f423666v;
        float f27 = velocity.f423667w;
        int i16 = this.m_indexB;
        float f28 = positionArr[i16].f423664a;
        Velocity velocity2 = velocityArr[i16];
        Vec2 vec22 = velocity2.f423666v;
        float f29 = velocity2.f423667w;
        Rot popRot = this.pool.popRot();
        Rot popRot2 = this.pool.popRot();
        Vec2 popVec2 = this.pool.popVec2();
        popRot.set(f26);
        popRot2.set(f28);
        Rot.mulToOutUnsafe(popRot, popVec2.set(this.m_localAnchorA).subLocal(this.m_localCenterA), this.m_rA);
        Rot.mulToOutUnsafe(popRot2, popVec2.set(this.m_localAnchorB).subLocal(this.m_localCenterB), this.m_rB);
        float f36 = this.m_invMassA;
        float f37 = this.m_invMassB;
        float f38 = this.m_invIA;
        float f39 = this.m_invIB;
        Mat33 popMat33 = this.pool.popMat33();
        Vec3 vec3 = popMat33.f423638ex;
        float f46 = f36 + f37;
        Vec2 vec23 = this.m_rA;
        float f47 = vec23.f423650y;
        Vec2 vec24 = this.m_rB;
        float f48 = vec24.f423650y;
        vec3.f423651x = f46 + (f47 * f47 * f38) + (f48 * f48 * f39);
        Vec3 vec32 = popMat33.f423639ey;
        float f49 = vec23.f423649x;
        float f56 = vec24.f423649x;
        vec32.f423651x = (((-f47) * f49) * f38) - ((f48 * f56) * f39);
        Vec3 vec33 = popMat33.f423640ez;
        float f57 = ((-f47) * f38) - (f48 * f39);
        vec33.f423651x = f57;
        vec3.f423652y = vec32.f423651x;
        vec32.f423652y = f46 + (f49 * f49 * f38) + (f56 * f56 * f39);
        float f58 = (f49 * f38) + (f56 * f39);
        vec33.f423652y = f58;
        vec3.f423653z = f57;
        vec32.f423653z = f58;
        float f59 = f38 + f39;
        vec33.f423653z = f59;
        float f65 = 0.0f;
        if (this.m_frequencyHz > 0.0f) {
            popMat33.getInverse22(this.m_mass);
            if (f59 > 0.0f) {
                f18 = 1.0f / f59;
            } else {
                f18 = 0.0f;
            }
            float f66 = (f28 - f26) - this.m_referenceAngle;
            float f67 = this.m_frequencyHz * 6.2831855f;
            float f68 = 2.0f * f18 * this.m_dampingRatio * f67;
            float f69 = f18 * f67 * f67;
            float f75 = solverData.step.f423654dt;
            float f76 = (f68 + (f75 * f69)) * f75;
            this.m_gamma = f76;
            if (f76 != 0.0f) {
                f19 = 1.0f / f76;
            } else {
                f19 = 0.0f;
            }
            this.m_gamma = f19;
            this.m_bias = f66 * f75 * f69 * f19;
            float f77 = f59 + f19;
            Vec3 vec34 = this.m_mass.f423640ez;
            if (f77 != 0.0f) {
                f65 = 1.0f / f77;
            }
            vec34.f423653z = f65;
        } else {
            popMat33.getSymInverse33(this.m_mass);
            this.m_gamma = 0.0f;
            this.m_bias = 0.0f;
        }
        if (solverData.step.warmStarting) {
            Vec2 popVec22 = this.pool.popVec2();
            this.m_impulse.mulLocal(solverData.step.dtRatio);
            Vec3 vec35 = this.m_impulse;
            popVec22.set(vec35.f423651x, vec35.f423652y);
            vec2.f423649x -= f36 * popVec22.f423649x;
            vec2.f423650y -= f36 * popVec22.f423650y;
            f17 = f27 - (f38 * (Vec2.cross(this.m_rA, popVec22) + this.m_impulse.f423653z));
            vec22.f423649x += f37 * popVec22.f423649x;
            vec22.f423650y += f37 * popVec22.f423650y;
            f16 = f29 + (f39 * (Vec2.cross(this.m_rB, popVec22) + this.m_impulse.f423653z));
            this.pool.pushVec2(1);
        } else {
            this.m_impulse.setZero();
            f16 = f29;
            f17 = f27;
        }
        Velocity[] velocityArr2 = solverData.velocities;
        velocityArr2[this.m_indexA].f423667w = f17;
        velocityArr2[this.m_indexB].f423667w = f16;
        this.pool.pushVec2(1);
        this.pool.pushRot(2);
        this.pool.pushMat33(1);
    }

    public void setDampingRatio(float f16) {
        this.m_dampingRatio = f16;
    }

    public void setFrequency(float f16) {
        this.m_frequencyHz = f16;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public boolean solvePositionConstraints(SolverData solverData) {
        float cross;
        float cross2;
        SolverData solverData2;
        float f16;
        Position[] positionArr = solverData.positions;
        Position position = positionArr[this.m_indexA];
        Vec2 vec2 = position.f423665c;
        float f17 = position.f423664a;
        Position position2 = positionArr[this.m_indexB];
        Vec2 vec22 = position2.f423665c;
        float f18 = position2.f423664a;
        Rot popRot = this.pool.popRot();
        Rot popRot2 = this.pool.popRot();
        Vec2 popVec2 = this.pool.popVec2();
        Vec2 popVec22 = this.pool.popVec2();
        Vec2 popVec23 = this.pool.popVec2();
        popRot.set(f17);
        popRot2.set(f18);
        float f19 = this.m_invMassA;
        float f26 = this.m_invMassB;
        float f27 = this.m_invIA;
        float f28 = this.m_invIB;
        Rot.mulToOutUnsafe(popRot, popVec2.set(this.m_localAnchorA).subLocal(this.m_localCenterA), popVec22);
        Rot.mulToOutUnsafe(popRot2, popVec2.set(this.m_localAnchorB).subLocal(this.m_localCenterB), popVec23);
        Mat33 popMat33 = this.pool.popMat33();
        Vec2 popVec24 = this.pool.popVec2();
        Vec2 popVec25 = this.pool.popVec2();
        Vec3 vec3 = popMat33.f423638ex;
        float f29 = f19 + f26;
        float f36 = popVec22.f423650y;
        float f37 = popVec23.f423650y;
        vec3.f423651x = f29 + (f36 * f36 * f27) + (f37 * f37 * f28);
        Vec3 vec32 = popMat33.f423639ey;
        float f38 = popVec22.f423649x;
        float f39 = popVec23.f423649x;
        vec32.f423651x = (((-f36) * f38) * f27) - ((f37 * f39) * f28);
        Vec3 vec33 = popMat33.f423640ez;
        float f46 = ((-f36) * f27) - (f37 * f28);
        vec33.f423651x = f46;
        vec3.f423652y = vec32.f423651x;
        vec32.f423652y = f29 + (f38 * f38 * f27) + (f39 * f39 * f28);
        float f47 = (f38 * f27) + (f39 * f28);
        vec33.f423652y = f47;
        vec3.f423653z = f46;
        vec32.f423653z = f47;
        vec33.f423653z = f27 + f28;
        float f48 = 0.0f;
        if (this.m_frequencyHz > 0.0f) {
            popVec24.set(vec22).addLocal(popVec23).subLocal(vec2).subLocal(popVec22);
            f16 = popVec24.length();
            popMat33.solve22ToOut(popVec24, popVec25);
            popVec25.negateLocal();
            vec2.f423649x -= f19 * popVec25.f423649x;
            vec2.f423650y -= f19 * popVec25.f423650y;
            cross = f17 - (f27 * Vec2.cross(popVec22, popVec25));
            vec22.f423649x += f26 * popVec25.f423649x;
            vec22.f423650y += f26 * popVec25.f423650y;
            cross2 = f18 + (f28 * Vec2.cross(popVec23, popVec25));
            solverData2 = solverData;
        } else {
            popVec24.set(vec22).addLocal(popVec23).subLocal(vec2).subLocal(popVec22);
            float f49 = (f18 - f17) - this.m_referenceAngle;
            float length = popVec24.length();
            float abs = MathUtils.abs(f49);
            Vec3 popVec3 = this.pool.popVec3();
            Vec3 popVec32 = this.pool.popVec3();
            popVec3.set(popVec24.f423649x, popVec24.f423650y, f49);
            popMat33.solve33ToOut(popVec3, popVec32);
            popVec32.negateLocal();
            popVec25.set(popVec32.f423651x, popVec32.f423652y);
            vec2.f423649x -= popVec25.f423649x * f19;
            vec2.f423650y -= popVec25.f423650y * f19;
            cross = f17 - (f27 * (Vec2.cross(popVec22, popVec25) + popVec32.f423653z));
            vec22.f423649x += f26 * popVec25.f423649x;
            vec22.f423650y += f26 * popVec25.f423650y;
            cross2 = f18 + (f28 * (Vec2.cross(popVec23, popVec25) + popVec32.f423653z));
            this.pool.pushVec3(2);
            solverData2 = solverData;
            f16 = length;
            f48 = abs;
        }
        Position[] positionArr2 = solverData2.positions;
        positionArr2[this.m_indexA].f423664a = cross;
        positionArr2[this.m_indexB].f423664a = cross2;
        this.pool.pushVec2(5);
        this.pool.pushRot(2);
        this.pool.pushMat33(1);
        if (f16 <= 0.005f && f48 <= 0.03490659f) {
            return true;
        }
        return false;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void solveVelocityConstraints(SolverData solverData) {
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
        Vec2 popVec2 = this.pool.popVec2();
        Vec2 popVec22 = this.pool.popVec2();
        Vec2 popVec23 = this.pool.popVec2();
        if (this.m_frequencyHz > 0.0f) {
            float f28 = -this.m_mass.f423640ez.f423653z;
            float f29 = (f17 - f16) + this.m_bias;
            float f36 = this.m_gamma;
            Vec3 vec3 = this.m_impulse;
            float f37 = vec3.f423653z;
            float f38 = f28 * (f29 + (f36 * f37));
            vec3.f423653z = f37 + f38;
            float f39 = f16 - (f26 * f38);
            float f46 = f17 + (f38 * f27);
            Vec2.crossToOutUnsafe(f46, this.m_rB, popVec2);
            Vec2.crossToOutUnsafe(f39, this.m_rA, popVec23);
            popVec2.addLocal(vec22).subLocal(vec2).subLocal(popVec23);
            Mat33.mul22ToOutUnsafe(this.m_mass, popVec2, popVec22);
            popVec22.negateLocal();
            Vec3 vec32 = this.m_impulse;
            float f47 = vec32.f423651x;
            float f48 = popVec22.f423649x;
            vec32.f423651x = f47 + f48;
            float f49 = vec32.f423652y;
            float f56 = popVec22.f423650y;
            vec32.f423652y = f49 + f56;
            vec2.f423649x -= f48 * f18;
            vec2.f423650y -= f18 * f56;
            cross = f39 - (f26 * Vec2.cross(this.m_rA, popVec22));
            vec22.f423649x += f19 * popVec22.f423649x;
            vec22.f423650y += f19 * popVec22.f423650y;
            cross2 = f46 + (f27 * Vec2.cross(this.m_rB, popVec22));
        } else {
            Vec2.crossToOutUnsafe(f16, this.m_rA, popVec23);
            Vec2.crossToOutUnsafe(f17, this.m_rB, popVec2);
            popVec2.addLocal(vec22).subLocal(vec2).subLocal(popVec23);
            Vec3 popVec3 = this.pool.popVec3();
            popVec3.set(popVec2.f423649x, popVec2.f423650y, f17 - f16);
            Vec3 popVec32 = this.pool.popVec3();
            Mat33.mulToOutUnsafe(this.m_mass, popVec3, popVec32);
            popVec32.negateLocal();
            this.m_impulse.addLocal(popVec32);
            popVec22.set(popVec32.f423651x, popVec32.f423652y);
            vec2.f423649x -= popVec22.f423649x * f18;
            vec2.f423650y -= f18 * popVec22.f423650y;
            cross = f16 - (f26 * (Vec2.cross(this.m_rA, popVec22) + popVec32.f423653z));
            vec22.f423649x += f19 * popVec22.f423649x;
            vec22.f423650y += f19 * popVec22.f423650y;
            cross2 = f17 + (f27 * (Vec2.cross(this.m_rB, popVec22) + popVec32.f423653z));
            this.pool.pushVec3(2);
        }
        Velocity[] velocityArr2 = solverData.velocities;
        velocityArr2[this.m_indexA].f423667w = cross;
        velocityArr2[this.m_indexB].f423667w = cross2;
        this.pool.pushVec2(3);
    }
}
