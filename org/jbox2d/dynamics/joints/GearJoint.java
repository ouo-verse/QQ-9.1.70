package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Rot;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.SolverData;
import org.jbox2d.dynamics.contacts.Position;
import org.jbox2d.dynamics.contacts.Velocity;
import org.jbox2d.pooling.IWorldPool;

/* compiled from: P */
/* loaded from: classes29.dex */
public class GearJoint extends Joint {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Vec2 m_JvAC;
    private final Vec2 m_JvBD;
    private float m_JwA;
    private float m_JwB;
    private float m_JwC;
    private float m_JwD;
    private final Body m_bodyC;
    private final Body m_bodyD;
    private float m_constant;
    private float m_iA;
    private float m_iB;
    private float m_iC;
    private float m_iD;
    private float m_impulse;
    private int m_indexA;
    private int m_indexB;
    private int m_indexC;
    private int m_indexD;
    private final Joint m_joint1;
    private final Joint m_joint2;
    private final Vec2 m_lcA;
    private final Vec2 m_lcB;
    private final Vec2 m_lcC;
    private final Vec2 m_lcD;
    private final Vec2 m_localAnchorA;
    private final Vec2 m_localAnchorB;
    private final Vec2 m_localAnchorC;
    private final Vec2 m_localAnchorD;
    private final Vec2 m_localAxisC;
    private final Vec2 m_localAxisD;
    private float m_mA;
    private float m_mB;
    private float m_mC;
    private float m_mD;
    private float m_mass;
    private float m_ratio;
    private float m_referenceAngleA;
    private float m_referenceAngleB;
    private final JointType m_typeA;
    private final JointType m_typeB;

    /* JADX INFO: Access modifiers changed from: protected */
    public GearJoint(IWorldPool iWorldPool, GearJointDef gearJointDef) {
        super(iWorldPool, gearJointDef);
        float dot;
        float dot2;
        Vec2 vec2 = new Vec2();
        this.m_localAnchorA = vec2;
        Vec2 vec22 = new Vec2();
        this.m_localAnchorB = vec22;
        Vec2 vec23 = new Vec2();
        this.m_localAnchorC = vec23;
        Vec2 vec24 = new Vec2();
        this.m_localAnchorD = vec24;
        Vec2 vec25 = new Vec2();
        this.m_localAxisC = vec25;
        Vec2 vec26 = new Vec2();
        this.m_localAxisD = vec26;
        this.m_lcA = new Vec2();
        this.m_lcB = new Vec2();
        this.m_lcC = new Vec2();
        this.m_lcD = new Vec2();
        this.m_JvAC = new Vec2();
        this.m_JvBD = new Vec2();
        Joint joint = gearJointDef.joint1;
        this.m_joint1 = joint;
        Joint joint2 = gearJointDef.joint2;
        this.m_joint2 = joint2;
        JointType type = joint.getType();
        this.m_typeA = type;
        JointType type2 = joint2.getType();
        this.m_typeB = type2;
        Body bodyA = joint.getBodyA();
        this.m_bodyC = bodyA;
        Body bodyB = joint.getBodyB();
        this.m_bodyA = bodyB;
        Transform transform = bodyB.m_xf;
        float f16 = bodyB.m_sweep.f423643a;
        Transform transform2 = bodyA.m_xf;
        float f17 = bodyA.m_sweep.f423643a;
        JointType jointType = JointType.REVOLUTE;
        if (type == jointType) {
            RevoluteJoint revoluteJoint = (RevoluteJoint) gearJointDef.joint1;
            vec23.set(revoluteJoint.m_localAnchorA);
            vec2.set(revoluteJoint.m_localAnchorB);
            this.m_referenceAngleA = revoluteJoint.m_referenceAngle;
            vec25.setZero();
            dot = (f16 - f17) - this.m_referenceAngleA;
        } else {
            Vec2 popVec2 = this.pool.popVec2();
            Vec2 popVec22 = this.pool.popVec2();
            PrismaticJoint prismaticJoint = (PrismaticJoint) gearJointDef.joint1;
            vec23.set(prismaticJoint.m_localAnchorA);
            vec2.set(prismaticJoint.m_localAnchorB);
            this.m_referenceAngleA = prismaticJoint.m_referenceAngle;
            vec25.set(prismaticJoint.m_localXAxisA);
            Rot.mulToOutUnsafe(transform.f423648q, vec2, popVec22);
            popVec22.addLocal(transform.f423647p).subLocal(transform2.f423647p);
            Rot.mulTransUnsafe(transform2.f423648q, popVec22, popVec2);
            dot = Vec2.dot(popVec2.subLocal(vec23), vec25);
            this.pool.pushVec2(2);
        }
        Body bodyA2 = joint2.getBodyA();
        this.m_bodyD = bodyA2;
        Body bodyB2 = joint2.getBodyB();
        this.m_bodyB = bodyB2;
        Transform transform3 = bodyB2.m_xf;
        float f18 = bodyB2.m_sweep.f423643a;
        Transform transform4 = bodyA2.m_xf;
        float f19 = bodyA2.m_sweep.f423643a;
        if (type2 == jointType) {
            RevoluteJoint revoluteJoint2 = (RevoluteJoint) gearJointDef.joint2;
            vec24.set(revoluteJoint2.m_localAnchorA);
            vec22.set(revoluteJoint2.m_localAnchorB);
            this.m_referenceAngleB = revoluteJoint2.m_referenceAngle;
            vec26.setZero();
            dot2 = (f18 - f19) - this.m_referenceAngleB;
        } else {
            Vec2 popVec23 = this.pool.popVec2();
            Vec2 popVec24 = this.pool.popVec2();
            PrismaticJoint prismaticJoint2 = (PrismaticJoint) gearJointDef.joint2;
            vec24.set(prismaticJoint2.m_localAnchorA);
            vec22.set(prismaticJoint2.m_localAnchorB);
            this.m_referenceAngleB = prismaticJoint2.m_referenceAngle;
            vec26.set(prismaticJoint2.m_localXAxisA);
            Rot.mulToOutUnsafe(transform3.f423648q, vec22, popVec24);
            popVec24.addLocal(transform3.f423647p).subLocal(transform4.f423647p);
            Rot.mulTransUnsafe(transform4.f423648q, popVec24, popVec23);
            dot2 = Vec2.dot(popVec23.subLocal(vec24), vec26);
            this.pool.pushVec2(2);
        }
        float f26 = gearJointDef.ratio;
        this.m_ratio = f26;
        this.m_constant = dot + (f26 * dot2);
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

    public Joint getJoint1() {
        return this.m_joint1;
    }

    public Joint getJoint2() {
        return this.m_joint2;
    }

    public float getRatio() {
        return this.m_ratio;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getReactionForce(float f16, Vec2 vec2) {
        vec2.set(this.m_JvAC).mulLocal(this.m_impulse);
        vec2.mulLocal(f16);
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public float getReactionTorque(float f16) {
        return f16 * this.m_impulse * this.m_JwA;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void initVelocityConstraints(SolverData solverData) {
        float f16;
        Vec2 vec2;
        float f17;
        float f18;
        float f19;
        Body body = this.m_bodyA;
        this.m_indexA = body.m_islandIndex;
        this.m_indexB = this.m_bodyB.m_islandIndex;
        this.m_indexC = this.m_bodyC.m_islandIndex;
        this.m_indexD = this.m_bodyD.m_islandIndex;
        this.m_lcA.set(body.m_sweep.localCenter);
        this.m_lcB.set(this.m_bodyB.m_sweep.localCenter);
        this.m_lcC.set(this.m_bodyC.m_sweep.localCenter);
        this.m_lcD.set(this.m_bodyD.m_sweep.localCenter);
        Body body2 = this.m_bodyA;
        this.m_mA = body2.m_invMass;
        Body body3 = this.m_bodyB;
        this.m_mB = body3.m_invMass;
        Body body4 = this.m_bodyC;
        this.m_mC = body4.m_invMass;
        Body body5 = this.m_bodyD;
        this.m_mD = body5.m_invMass;
        this.m_iA = body2.m_invI;
        this.m_iB = body3.m_invI;
        this.m_iC = body4.m_invI;
        this.m_iD = body5.m_invI;
        Position[] positionArr = solverData.positions;
        int i3 = this.m_indexA;
        float f26 = positionArr[i3].f423664a;
        Velocity[] velocityArr = solverData.velocities;
        Velocity velocity = velocityArr[i3];
        Vec2 vec22 = velocity.f423666v;
        float f27 = velocity.f423667w;
        int i16 = this.m_indexB;
        float f28 = positionArr[i16].f423664a;
        Velocity velocity2 = velocityArr[i16];
        Vec2 vec23 = velocity2.f423666v;
        float f29 = velocity2.f423667w;
        int i17 = this.m_indexC;
        float f36 = positionArr[i17].f423664a;
        Velocity velocity3 = velocityArr[i17];
        Vec2 vec24 = velocity3.f423666v;
        float f37 = velocity3.f423667w;
        int i18 = this.m_indexD;
        float f38 = positionArr[i18].f423664a;
        Velocity velocity4 = velocityArr[i18];
        Vec2 vec25 = velocity4.f423666v;
        float f39 = velocity4.f423667w;
        Rot popRot = this.pool.popRot();
        Rot popRot2 = this.pool.popRot();
        Rot popRot3 = this.pool.popRot();
        Rot popRot4 = this.pool.popRot();
        popRot.set(f26);
        popRot2.set(f28);
        popRot3.set(f36);
        popRot4.set(f38);
        this.m_mass = 0.0f;
        Vec2 popVec2 = this.pool.popVec2();
        JointType jointType = this.m_typeA;
        JointType jointType2 = JointType.REVOLUTE;
        if (jointType == jointType2) {
            this.m_JvAC.setZero();
            this.m_JwA = 1.0f;
            this.m_JwC = 1.0f;
            this.m_mass += this.m_iA + this.m_iC;
            f16 = f37;
            vec2 = vec24;
        } else {
            Vec2 popVec22 = this.pool.popVec2();
            Vec2 popVec23 = this.pool.popVec2();
            f16 = f37;
            vec2 = vec24;
            Rot.mulToOutUnsafe(popRot3, this.m_localAxisC, this.m_JvAC);
            Rot.mulToOutUnsafe(popRot3, popVec2.set(this.m_localAnchorC).subLocal(this.m_lcC), popVec22);
            Rot.mulToOutUnsafe(popRot, popVec2.set(this.m_localAnchorA).subLocal(this.m_lcA), popVec23);
            this.m_JwC = Vec2.cross(popVec22, this.m_JvAC);
            float cross = Vec2.cross(popVec23, this.m_JvAC);
            this.m_JwA = cross;
            float f46 = this.m_mass;
            float f47 = this.m_mC + this.m_mA;
            float f48 = this.m_iC;
            float f49 = this.m_JwC;
            this.m_mass = f46 + f47 + (f48 * f49 * f49) + (this.m_iA * cross * cross);
            this.pool.pushVec2(2);
        }
        if (this.m_typeB == jointType2) {
            this.m_JvBD.setZero();
            float f56 = this.m_ratio;
            this.m_JwB = f56;
            this.m_JwD = f56;
            this.m_mass += f56 * f56 * (this.m_iB + this.m_iD);
        } else {
            Vec2 popVec24 = this.pool.popVec2();
            Vec2 popVec25 = this.pool.popVec2();
            Vec2 popVec26 = this.pool.popVec2();
            Rot.mulToOutUnsafe(popRot4, this.m_localAxisD, popVec24);
            Rot.mulToOutUnsafe(popRot4, popVec2.set(this.m_localAnchorD).subLocal(this.m_lcD), popVec25);
            Rot.mulToOutUnsafe(popRot2, popVec2.set(this.m_localAnchorB).subLocal(this.m_lcB), popVec26);
            this.m_JvBD.set(popVec24).mulLocal(this.m_ratio);
            this.m_JwD = this.m_ratio * Vec2.cross(popVec25, popVec24);
            float cross2 = this.m_ratio * Vec2.cross(popVec26, popVec24);
            this.m_JwB = cross2;
            float f57 = this.m_mass;
            float f58 = this.m_ratio;
            float f59 = f58 * f58 * (this.m_mD + this.m_mB);
            float f65 = this.m_iD;
            float f66 = this.m_JwD;
            this.m_mass = f57 + f59 + (f65 * f66 * f66) + (this.m_iB * cross2 * cross2);
            this.pool.pushVec2(3);
        }
        float f67 = this.m_mass;
        if (f67 > 0.0f) {
            f17 = 1.0f / f67;
        } else {
            f17 = 0.0f;
        }
        this.m_mass = f17;
        if (solverData.step.warmStarting) {
            float f68 = vec22.f423649x;
            float f69 = this.m_mA;
            float f75 = this.m_impulse;
            Vec2 vec26 = this.m_JvAC;
            vec22.f423649x = f68 + (f69 * f75 * vec26.f423649x);
            vec22.f423650y += f69 * f75 * vec26.f423650y;
            f27 += this.m_iA * f75 * this.m_JwA;
            float f76 = vec23.f423649x;
            float f77 = this.m_mB;
            Vec2 vec27 = this.m_JvBD;
            vec23.f423649x = f76 + (f77 * f75 * vec27.f423649x);
            vec23.f423650y += f77 * f75 * vec27.f423650y;
            f29 += this.m_iB * f75 * this.m_JwB;
            Vec2 vec28 = vec2;
            float f78 = vec28.f423649x;
            float f79 = this.m_mC;
            vec28.f423649x = f78 - ((f79 * f75) * vec26.f423649x);
            vec28.f423650y -= (f79 * f75) * vec26.f423650y;
            f19 = f16 - ((this.m_iC * f75) * this.m_JwC);
            float f85 = vec25.f423649x;
            float f86 = this.m_mD;
            vec25.f423649x = f85 - ((f86 * f75) * vec27.f423649x);
            vec25.f423650y -= (f86 * f75) * vec27.f423650y;
            f18 = f39 - ((this.m_iD * f75) * this.m_JwD);
        } else {
            this.m_impulse = 0.0f;
            f18 = f39;
            f19 = f16;
        }
        this.pool.pushVec2(1);
        this.pool.pushRot(4);
        Velocity[] velocityArr2 = solverData.velocities;
        velocityArr2[this.m_indexA].f423667w = f27;
        velocityArr2[this.m_indexB].f423667w = f29;
        velocityArr2[this.m_indexC].f423667w = f19;
        velocityArr2[this.m_indexD].f423667w = f18;
    }

    public void setRatio(float f16) {
        this.m_ratio = f16;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public boolean solvePositionConstraints(SolverData solverData) {
        float f16;
        float f17;
        Rot rot;
        float f18;
        float f19;
        float f26;
        float f27;
        float f28;
        Vec2 vec2;
        float f29;
        float cross;
        float cross2;
        Vec2 vec22;
        float f36;
        Vec2 vec23;
        Vec2 vec24;
        float dot;
        Position[] positionArr = solverData.positions;
        Position position = positionArr[this.m_indexA];
        Vec2 vec25 = position.f423665c;
        float f37 = position.f423664a;
        Position position2 = positionArr[this.m_indexB];
        Vec2 vec26 = position2.f423665c;
        float f38 = position2.f423664a;
        Position position3 = positionArr[this.m_indexC];
        Vec2 vec27 = position3.f423665c;
        float f39 = position3.f423664a;
        Position position4 = positionArr[this.m_indexD];
        Vec2 vec28 = position4.f423665c;
        float f46 = position4.f423664a;
        Rot popRot = this.pool.popRot();
        Rot popRot2 = this.pool.popRot();
        Rot popRot3 = this.pool.popRot();
        Rot popRot4 = this.pool.popRot();
        popRot.set(f37);
        popRot2.set(f38);
        popRot3.set(f39);
        popRot4.set(f46);
        Vec2 popVec2 = this.pool.popVec2();
        Vec2 popVec22 = this.pool.popVec2();
        Vec2 popVec23 = this.pool.popVec2();
        JointType jointType = this.m_typeA;
        JointType jointType2 = JointType.REVOLUTE;
        float f47 = 0.0f;
        if (jointType == jointType2) {
            popVec22.setZero();
            f27 = this.m_iA + this.m_iC + 0.0f;
            f28 = (f37 - f39) - this.m_referenceAngleA;
            f26 = 1.0f;
            f18 = f46;
            f17 = f37;
            f16 = f39;
            f19 = 1.0f;
            rot = popRot4;
        } else {
            Vec2 popVec24 = this.pool.popVec2();
            Vec2 popVec25 = this.pool.popVec2();
            f16 = f39;
            Vec2 popVec26 = this.pool.popVec2();
            f17 = f37;
            Vec2 popVec27 = this.pool.popVec2();
            rot = popRot4;
            Rot.mulToOutUnsafe(popRot3, this.m_localAxisC, popVec22);
            f18 = f46;
            Rot.mulToOutUnsafe(popRot3, popVec2.set(this.m_localAnchorC).subLocal(this.m_lcC), popVec24);
            Rot.mulToOutUnsafe(popRot, popVec2.set(this.m_localAnchorA).subLocal(this.m_lcA), popVec25);
            float cross3 = Vec2.cross(popVec24, popVec22);
            float cross4 = Vec2.cross(popVec25, popVec22);
            float f48 = this.m_mC + this.m_mA + (this.m_iC * cross3 * cross3) + (this.m_iA * cross4 * cross4) + 0.0f;
            f19 = cross3;
            popVec26.set(this.m_localAnchorC).subLocal(this.m_lcC);
            Rot.mulTransUnsafe(popRot3, popVec2.set(popVec25).addLocal(vec25).subLocal(vec27), popVec27);
            float dot2 = Vec2.dot(popVec27.subLocal(popVec26), this.m_localAxisC);
            this.pool.pushVec2(4);
            f26 = cross4;
            f27 = f48;
            f28 = dot2;
        }
        if (this.m_typeB == jointType2) {
            popVec23.setZero();
            cross2 = this.m_ratio;
            f36 = f27 + (cross2 * cross2 * (this.m_iB + this.m_iD));
            vec22 = popVec23;
            dot = (f38 - f18) - this.m_referenceAngleB;
            f29 = f38;
            vec2 = vec27;
            vec24 = vec28;
            vec23 = vec26;
            cross = cross2;
        } else {
            Vec2 popVec28 = this.pool.popVec2();
            Vec2 popVec29 = this.pool.popVec2();
            Vec2 popVec210 = this.pool.popVec2();
            Vec2 popVec211 = this.pool.popVec2();
            Vec2 popVec212 = this.pool.popVec2();
            vec2 = vec27;
            Rot rot2 = rot;
            Rot.mulToOutUnsafe(rot2, this.m_localAxisD, popVec28);
            f29 = f38;
            Rot.mulToOutUnsafe(rot2, popVec2.set(this.m_localAnchorD).subLocal(this.m_lcD), popVec29);
            Rot.mulToOutUnsafe(popRot2, popVec2.set(this.m_localAnchorB).subLocal(this.m_lcB), popVec210);
            popVec23.set(popVec28).mulLocal(this.m_ratio);
            cross = Vec2.cross(popVec29, popVec28);
            cross2 = Vec2.cross(popVec210, popVec28);
            float f49 = this.m_ratio;
            vec22 = popVec23;
            f36 = f27 + (f49 * f49 * (this.m_mD + this.m_mB)) + (this.m_iD * cross * cross) + (this.m_iB * cross2 * cross2);
            popVec211.set(this.m_localAnchorD).subLocal(this.m_lcD);
            vec23 = vec26;
            Vec2 addLocal = popVec2.set(popVec210).addLocal(vec23);
            vec24 = vec28;
            Rot.mulTransUnsafe(rot2, addLocal.subLocal(vec24), popVec212);
            dot = Vec2.dot(popVec212.subLocal(popVec211), this.m_localAxisD);
            this.pool.pushVec2(5);
        }
        float f56 = (f28 + (this.m_ratio * dot)) - this.m_constant;
        if (f36 > 0.0f) {
            f47 = (-f56) / f36;
        }
        this.pool.pushVec2(3);
        this.pool.pushRot(4);
        float f57 = vec25.f423649x;
        float f58 = this.m_mA;
        vec25.f423649x = f57 + (f58 * f47 * popVec22.f423649x);
        vec25.f423650y += f58 * f47 * popVec22.f423650y;
        float f59 = f17 + (this.m_iA * f47 * f26);
        float f65 = vec23.f423649x;
        float f66 = this.m_mB;
        Vec2 vec29 = vec22;
        vec23.f423649x = f65 + (f66 * f47 * vec29.f423649x);
        vec23.f423650y += f66 * f47 * vec29.f423650y;
        float f67 = f29 + (this.m_iB * f47 * cross2);
        Vec2 vec210 = vec2;
        float f68 = vec210.f423649x;
        float f69 = this.m_mC;
        vec210.f423649x = f68 - ((f69 * f47) * popVec22.f423649x);
        vec210.f423650y -= (f69 * f47) * popVec22.f423650y;
        float f75 = f16 - ((this.m_iC * f47) * f19);
        float f76 = vec24.f423649x;
        float f77 = this.m_mD;
        vec24.f423649x = f76 - ((f77 * f47) * vec29.f423649x);
        vec24.f423650y -= (f77 * f47) * vec29.f423650y;
        float f78 = f18 - ((this.m_iD * f47) * cross);
        Position[] positionArr2 = solverData.positions;
        positionArr2[this.m_indexA].f423664a = f59;
        positionArr2[this.m_indexB].f423664a = f67;
        positionArr2[this.m_indexC].f423664a = f75;
        positionArr2[this.m_indexD].f423664a = f78;
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
        Velocity velocity3 = velocityArr[this.m_indexC];
        Vec2 vec23 = velocity3.f423666v;
        float f18 = velocity3.f423667w;
        Velocity velocity4 = velocityArr[this.m_indexD];
        Vec2 vec24 = velocity4.f423666v;
        float f19 = velocity4.f423667w;
        float dot = Vec2.dot(this.m_JvAC, this.pool.popVec2().set(vec2).subLocal(vec23)) + Vec2.dot(this.m_JvBD, this.pool.popVec2().set(vec22).subLocal(vec24)) + ((this.m_JwA * f16) - (this.m_JwC * f18)) + ((this.m_JwB * f17) - (this.m_JwD * f19));
        this.pool.pushVec2(2);
        float f26 = (-this.m_mass) * dot;
        this.m_impulse += f26;
        float f27 = vec2.f423649x;
        float f28 = this.m_mA;
        Vec2 vec25 = this.m_JvAC;
        vec2.f423649x = f27 + (f28 * f26 * vec25.f423649x);
        vec2.f423650y += f28 * f26 * vec25.f423650y;
        float f29 = f16 + (this.m_iA * f26 * this.m_JwA);
        float f36 = vec22.f423649x;
        float f37 = this.m_mB;
        Vec2 vec26 = this.m_JvBD;
        vec22.f423649x = f36 + (f37 * f26 * vec26.f423649x);
        vec22.f423650y += f37 * f26 * vec26.f423650y;
        float f38 = f17 + (this.m_iB * f26 * this.m_JwB);
        float f39 = vec23.f423649x;
        float f46 = this.m_mC;
        vec23.f423649x = f39 - ((f46 * f26) * vec25.f423649x);
        vec23.f423650y -= (f46 * f26) * vec25.f423650y;
        float f47 = f18 - ((this.m_iC * f26) * this.m_JwC);
        float f48 = vec24.f423649x;
        float f49 = this.m_mD;
        vec24.f423649x = f48 - ((f49 * f26) * vec26.f423649x);
        vec24.f423650y -= (f49 * f26) * vec26.f423650y;
        float f56 = f19 - ((this.m_iD * f26) * this.m_JwD);
        Velocity[] velocityArr2 = solverData.velocities;
        velocityArr2[this.m_indexA].f423667w = f29;
        velocityArr2[this.m_indexB].f423667w = f38;
        velocityArr2[this.m_indexC].f423667w = f47;
        velocityArr2[this.m_indexD].f423667w = f56;
    }
}
