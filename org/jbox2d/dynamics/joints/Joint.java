package org.jbox2d.dynamics.joints;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.SolverData;
import org.jbox2d.dynamics.World;
import org.jbox2d.pooling.IWorldPool;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class Joint {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected Body m_bodyA;
    protected Body m_bodyB;
    private boolean m_collideConnected;
    public JointEdge m_edgeA;
    public JointEdge m_edgeB;
    private final JointType m_type;
    public Object m_userData;
    protected IWorldPool pool;
    public Joint m_prev = null;
    public Joint m_next = null;
    public boolean m_islandFlag = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: org.jbox2d.dynamics.joints.Joint$1, reason: invalid class name */
    /* loaded from: classes29.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jbox2d$dynamics$joints$JointType;

        static {
            int[] iArr = new int[JointType.values().length];
            $SwitchMap$org$jbox2d$dynamics$joints$JointType = iArr;
            try {
                iArr[JointType.MOUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.DISTANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.PRISMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.REVOLUTE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.WELD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.FRICTION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.WHEEL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.GEAR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.PULLEY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.CONSTANT_VOLUME.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.ROPE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.UNKNOWN.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Joint(IWorldPool iWorldPool, JointDef jointDef) {
        this.pool = iWorldPool;
        this.m_type = jointDef.type;
        this.m_bodyA = jointDef.bodyA;
        this.m_bodyB = jointDef.bodyB;
        this.m_collideConnected = jointDef.collideConnected;
        this.m_userData = jointDef.userData;
        JointEdge jointEdge = new JointEdge();
        this.m_edgeA = jointEdge;
        jointEdge.joint = null;
        jointEdge.other = null;
        jointEdge.prev = null;
        jointEdge.next = null;
        JointEdge jointEdge2 = new JointEdge();
        this.m_edgeB = jointEdge2;
        jointEdge2.joint = null;
        jointEdge2.other = null;
        jointEdge2.prev = null;
        jointEdge2.next = null;
    }

    public static Joint create(World world, JointDef jointDef) {
        switch (AnonymousClass1.$SwitchMap$org$jbox2d$dynamics$joints$JointType[jointDef.type.ordinal()]) {
            case 1:
                return new MouseJoint(world.getPool(), (MouseJointDef) jointDef);
            case 2:
                return new DistanceJoint(world.getPool(), (DistanceJointDef) jointDef);
            case 3:
                return new PrismaticJoint(world.getPool(), (PrismaticJointDef) jointDef);
            case 4:
                return new RevoluteJoint(world.getPool(), (RevoluteJointDef) jointDef);
            case 5:
                return new WeldJoint(world.getPool(), (WeldJointDef) jointDef);
            case 6:
                return new FrictionJoint(world.getPool(), (FrictionJointDef) jointDef);
            case 7:
                return new WheelJoint(world.getPool(), (WheelJointDef) jointDef);
            case 8:
                return new GearJoint(world.getPool(), (GearJointDef) jointDef);
            case 9:
                return new PulleyJoint(world.getPool(), (PulleyJointDef) jointDef);
            case 10:
                return new ConstantVolumeJoint(world, (ConstantVolumeJointDef) jointDef);
            case 11:
                return new RopeJoint(world.getPool(), (RopeJointDef) jointDef);
            default:
                return null;
        }
    }

    public static void destroy(Joint joint) {
        joint.destructor();
    }

    public abstract void getAnchorA(Vec2 vec2);

    public abstract void getAnchorB(Vec2 vec2);

    public final Body getBodyA() {
        return this.m_bodyA;
    }

    public final Body getBodyB() {
        return this.m_bodyB;
    }

    public final boolean getCollideConnected() {
        return this.m_collideConnected;
    }

    public Joint getNext() {
        return this.m_next;
    }

    public abstract void getReactionForce(float f16, Vec2 vec2);

    public abstract float getReactionTorque(float f16);

    public JointType getType() {
        return this.m_type;
    }

    public Object getUserData() {
        return this.m_userData;
    }

    public abstract void initVelocityConstraints(SolverData solverData);

    public boolean isActive() {
        if (this.m_bodyA.isActive() && this.m_bodyB.isActive()) {
            return true;
        }
        return false;
    }

    public void setUserData(Object obj) {
        this.m_userData = obj;
    }

    public abstract boolean solvePositionConstraints(SolverData solverData);

    public abstract void solveVelocityConstraints(SolverData solverData);

    public void destructor() {
    }
}
