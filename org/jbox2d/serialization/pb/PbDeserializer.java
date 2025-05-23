package org.jbox2d.serialization.pb;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.box2d.proto.Box2D;
import org.jbox2d.collision.shapes.ChainShape;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.joints.ConstantVolumeJointDef;
import org.jbox2d.dynamics.joints.DistanceJoint;
import org.jbox2d.dynamics.joints.DistanceJointDef;
import org.jbox2d.dynamics.joints.FrictionJointDef;
import org.jbox2d.dynamics.joints.GearJointDef;
import org.jbox2d.dynamics.joints.Joint;
import org.jbox2d.dynamics.joints.MouseJointDef;
import org.jbox2d.dynamics.joints.PrismaticJointDef;
import org.jbox2d.dynamics.joints.PulleyJointDef;
import org.jbox2d.dynamics.joints.RevoluteJointDef;
import org.jbox2d.dynamics.joints.RopeJointDef;
import org.jbox2d.dynamics.joints.WeldJointDef;
import org.jbox2d.dynamics.joints.WheelJointDef;
import org.jbox2d.serialization.JbDeserializer;
import org.jbox2d.serialization.UnsupportedListener;
import org.jbox2d.serialization.UnsupportedObjectException;

/* loaded from: classes29.dex */
public class PbDeserializer implements JbDeserializer {
    private JbDeserializer.ObjectListener listener;
    private UnsupportedListener ulistener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.jbox2d.serialization.pb.PbDeserializer$1, reason: invalid class name */
    /* loaded from: classes29.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$box2d$proto$Box2D$PbBodyType;
        static final /* synthetic */ int[] $SwitchMap$org$box2d$proto$Box2D$PbJointType;
        static final /* synthetic */ int[] $SwitchMap$org$box2d$proto$Box2D$PbShapeType;

        static {
            int[] iArr = new int[Box2D.PbJointType.values().length];
            $SwitchMap$org$box2d$proto$Box2D$PbJointType = iArr;
            try {
                iArr[Box2D.PbJointType.PRISMATIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$box2d$proto$Box2D$PbJointType[Box2D.PbJointType.REVOLUTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$box2d$proto$Box2D$PbJointType[Box2D.PbJointType.DISTANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$box2d$proto$Box2D$PbJointType[Box2D.PbJointType.PULLEY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$box2d$proto$Box2D$PbJointType[Box2D.PbJointType.MOUSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$box2d$proto$Box2D$PbJointType[Box2D.PbJointType.GEAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$box2d$proto$Box2D$PbJointType[Box2D.PbJointType.WHEEL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$box2d$proto$Box2D$PbJointType[Box2D.PbJointType.WELD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$box2d$proto$Box2D$PbJointType[Box2D.PbJointType.FRICTION.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$box2d$proto$Box2D$PbJointType[Box2D.PbJointType.ROPE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$box2d$proto$Box2D$PbJointType[Box2D.PbJointType.CONSTANT_VOLUME.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$box2d$proto$Box2D$PbJointType[Box2D.PbJointType.LINE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr2 = new int[Box2D.PbShapeType.values().length];
            $SwitchMap$org$box2d$proto$Box2D$PbShapeType = iArr2;
            try {
                iArr2[Box2D.PbShapeType.CIRCLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$box2d$proto$Box2D$PbShapeType[Box2D.PbShapeType.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$box2d$proto$Box2D$PbShapeType[Box2D.PbShapeType.EDGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$org$box2d$proto$Box2D$PbShapeType[Box2D.PbShapeType.CHAIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused16) {
            }
            int[] iArr3 = new int[Box2D.PbBodyType.values().length];
            $SwitchMap$org$box2d$proto$Box2D$PbBodyType = iArr3;
            try {
                iArr3[Box2D.PbBodyType.DYNAMIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$org$box2d$proto$Box2D$PbBodyType[Box2D.PbBodyType.KINEMATIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$org$box2d$proto$Box2D$PbBodyType[Box2D.PbBodyType.STATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    public PbDeserializer() {
        this.listener = null;
        this.ulistener = null;
    }

    private boolean isIndependentJoint(Box2D.PbJointType pbJointType) {
        if (pbJointType != Box2D.PbJointType.GEAR && pbJointType != Box2D.PbJointType.CONSTANT_VOLUME) {
            return true;
        }
        return false;
    }

    private Vec2 pbToVec(Box2D.PbVec2 pbVec2) {
        return new Vec2(pbVec2.getX(), pbVec2.getY());
    }

    @Override // org.jbox2d.serialization.JbDeserializer
    public Body deserializeBody(World world, InputStream inputStream) throws IOException {
        return deserializeBody(world, Box2D.PbBody.parseFrom(inputStream));
    }

    @Override // org.jbox2d.serialization.JbDeserializer
    public Fixture deserializeFixture(Body body, InputStream inputStream) throws IOException {
        return deserializeFixture(body, Box2D.PbFixture.parseFrom(inputStream));
    }

    @Override // org.jbox2d.serialization.JbDeserializer
    public Joint deserializeJoint(World world, InputStream inputStream, Map<Integer, Body> map, Map<Integer, Joint> map2) throws IOException {
        return deserializeJoint(world, Box2D.PbJoint.parseFrom(inputStream), map, map2);
    }

    @Override // org.jbox2d.serialization.JbDeserializer
    public Shape deserializeShape(InputStream inputStream) throws IOException {
        return deserializeShape(Box2D.PbShape.parseFrom(inputStream));
    }

    @Override // org.jbox2d.serialization.JbDeserializer
    public World deserializeWorld(InputStream inputStream) throws IOException {
        return deserializeWorld(Box2D.PbWorld.parseFrom(inputStream));
    }

    @Override // org.jbox2d.serialization.JbDeserializer
    public void setObjectListener(JbDeserializer.ObjectListener objectListener) {
        this.listener = objectListener;
    }

    @Override // org.jbox2d.serialization.JbDeserializer
    public void setUnsupportedListener(UnsupportedListener unsupportedListener) {
        this.ulistener = unsupportedListener;
    }

    public Body deserializeBody(World world, Box2D.PbBody pbBody) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(pbToVec(pbBody.getPosition()));
        bodyDef.angle = pbBody.getAngle();
        bodyDef.linearDamping = pbBody.getLinearDamping();
        bodyDef.angularDamping = pbBody.getAngularDamping();
        bodyDef.gravityScale = pbBody.getGravityScale();
        bodyDef.bullet = pbBody.getBullet();
        bodyDef.allowSleep = pbBody.getAllowSleep();
        bodyDef.awake = pbBody.getAwake();
        bodyDef.active = pbBody.getActive();
        bodyDef.fixedRotation = pbBody.getFixedRotation();
        int i3 = AnonymousClass1.$SwitchMap$org$box2d$proto$Box2D$PbBodyType[pbBody.getType().ordinal()];
        if (i3 == 1) {
            bodyDef.type = BodyType.DYNAMIC;
        } else if (i3 != 2) {
            if (i3 != 3) {
                UnsupportedObjectException unsupportedObjectException = new UnsupportedObjectException("Unknown body type: " + pbBody.getType(), UnsupportedObjectException.Type.BODY);
                UnsupportedListener unsupportedListener = this.ulistener;
                if (unsupportedListener == null) {
                    throw unsupportedObjectException;
                }
                if (unsupportedListener.isUnsupported(unsupportedObjectException)) {
                    throw unsupportedObjectException;
                }
                return null;
            }
            bodyDef.type = BodyType.STATIC;
        } else {
            bodyDef.type = BodyType.KINEMATIC;
        }
        Body createBody = world.createBody(bodyDef);
        for (int i16 = 0; i16 < pbBody.getFixturesCount(); i16++) {
            deserializeFixture(createBody, pbBody.getFixtures(i16));
        }
        createBody.m_linearVelocity.set(pbToVec(pbBody.getLinearVelocity()));
        createBody.m_angularVelocity = pbBody.getAngularVelocity();
        if (this.listener != null && pbBody.hasTag()) {
            this.listener.processBody(createBody, Long.valueOf(pbBody.getTag()));
        }
        return createBody;
    }

    public Fixture deserializeFixture(Body body, Box2D.PbFixture pbFixture) {
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.density = pbFixture.getDensity();
        fixtureDef.filter.categoryBits = pbFixture.getFilter().getCategoryBits();
        fixtureDef.filter.groupIndex = pbFixture.getFilter().getGroupIndex();
        fixtureDef.filter.maskBits = pbFixture.getFilter().getMaskBits();
        fixtureDef.friction = pbFixture.getFriction();
        fixtureDef.isSensor = pbFixture.getSensor();
        fixtureDef.restitution = pbFixture.getRestitution();
        fixtureDef.shape = deserializeShape(pbFixture.getShape());
        Fixture createFixture = body.createFixture(fixtureDef);
        if (this.listener != null && pbFixture.hasTag()) {
            this.listener.processFixture(createFixture, Long.valueOf(pbFixture.getTag()));
        }
        return createFixture;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [org.jbox2d.dynamics.joints.FrictionJointDef] */
    /* JADX WARN: Type inference failed for: r0v11, types: [org.jbox2d.dynamics.joints.JointDef] */
    /* JADX WARN: Type inference failed for: r0v13, types: [org.jbox2d.dynamics.joints.ConstantVolumeJointDef] */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.jbox2d.dynamics.joints.PrismaticJointDef] */
    /* JADX WARN: Type inference failed for: r0v3, types: [org.jbox2d.dynamics.joints.RevoluteJointDef] */
    /* JADX WARN: Type inference failed for: r0v4, types: [org.jbox2d.dynamics.joints.DistanceJointDef] */
    /* JADX WARN: Type inference failed for: r0v5, types: [org.jbox2d.dynamics.joints.PulleyJointDef] */
    /* JADX WARN: Type inference failed for: r0v6, types: [org.jbox2d.dynamics.joints.MouseJointDef] */
    /* JADX WARN: Type inference failed for: r0v7, types: [org.jbox2d.dynamics.joints.GearJointDef] */
    /* JADX WARN: Type inference failed for: r0v8, types: [org.jbox2d.dynamics.joints.WheelJointDef] */
    /* JADX WARN: Type inference failed for: r0v9, types: [org.jbox2d.dynamics.joints.WeldJointDef] */
    /* JADX WARN: Type inference failed for: r8v0, types: [org.jbox2d.dynamics.World] */
    public Joint deserializeJoint(World world, Box2D.PbJoint pbJoint, Map<Integer, Body> map, Map<Integer, Joint> map2) {
        ?? prismaticJointDef;
        switch (AnonymousClass1.$SwitchMap$org$box2d$proto$Box2D$PbJointType[pbJoint.getType().ordinal()]) {
            case 1:
                prismaticJointDef = new PrismaticJointDef();
                prismaticJointDef.enableLimit = pbJoint.getEnableLimit();
                prismaticJointDef.enableMotor = pbJoint.getEnableMotor();
                prismaticJointDef.localAnchorA.set(pbToVec(pbJoint.getLocalAnchorA()));
                prismaticJointDef.localAnchorB.set(pbToVec(pbJoint.getLocalAnchorB()));
                prismaticJointDef.localAxisA.set(pbToVec(pbJoint.getLocalAxisA()));
                prismaticJointDef.lowerTranslation = pbJoint.getLowerLimit();
                prismaticJointDef.maxMotorForce = pbJoint.getMaxMotorForce();
                prismaticJointDef.motorSpeed = pbJoint.getMotorSpeed();
                prismaticJointDef.referenceAngle = pbJoint.getRefAngle();
                prismaticJointDef.upperTranslation = pbJoint.getUpperLimit();
                break;
            case 2:
                prismaticJointDef = new RevoluteJointDef();
                prismaticJointDef.enableLimit = pbJoint.getEnableLimit();
                prismaticJointDef.enableMotor = pbJoint.getEnableMotor();
                prismaticJointDef.localAnchorA.set(pbToVec(pbJoint.getLocalAnchorA()));
                prismaticJointDef.localAnchorB.set(pbToVec(pbJoint.getLocalAnchorB()));
                prismaticJointDef.lowerAngle = pbJoint.getLowerLimit();
                prismaticJointDef.maxMotorTorque = pbJoint.getMaxMotorTorque();
                prismaticJointDef.motorSpeed = pbJoint.getMotorSpeed();
                prismaticJointDef.referenceAngle = pbJoint.getRefAngle();
                prismaticJointDef.upperAngle = pbJoint.getUpperLimit();
                break;
            case 3:
                prismaticJointDef = new DistanceJointDef();
                prismaticJointDef.localAnchorA.set(pbToVec(pbJoint.getLocalAnchorA()));
                prismaticJointDef.localAnchorB.set(pbToVec(pbJoint.getLocalAnchorB()));
                prismaticJointDef.dampingRatio = pbJoint.getDampingRatio();
                prismaticJointDef.frequencyHz = pbJoint.getFrequency();
                prismaticJointDef.length = pbJoint.getLength();
                break;
            case 4:
                prismaticJointDef = new PulleyJointDef();
                prismaticJointDef.localAnchorA.set(pbToVec(pbJoint.getLocalAnchorA()));
                prismaticJointDef.localAnchorB.set(pbToVec(pbJoint.getLocalAnchorB()));
                prismaticJointDef.groundAnchorA.set(pbToVec(pbJoint.getGroundAnchorA()));
                prismaticJointDef.groundAnchorB.set(pbToVec(pbJoint.getGroundAnchorB()));
                prismaticJointDef.lengthA = pbJoint.getLengthA();
                prismaticJointDef.lengthB = pbJoint.getLengthB();
                prismaticJointDef.ratio = pbJoint.getRatio();
                break;
            case 5:
                prismaticJointDef = new MouseJointDef();
                prismaticJointDef.dampingRatio = pbJoint.getDampingRatio();
                prismaticJointDef.frequencyHz = pbJoint.getFrequency();
                prismaticJointDef.maxForce = pbJoint.getMaxForce();
                prismaticJointDef.target.set(pbToVec(pbJoint.getTarget()));
                break;
            case 6:
                prismaticJointDef = new GearJointDef();
                if (map2.containsKey(Integer.valueOf(pbJoint.getJoint1()))) {
                    prismaticJointDef.joint1 = map2.get(Integer.valueOf(pbJoint.getJoint1()));
                    if (map2.containsKey(Integer.valueOf(pbJoint.getJoint2()))) {
                        prismaticJointDef.joint2 = map2.get(Integer.valueOf(pbJoint.getJoint2()));
                        prismaticJointDef.ratio = pbJoint.getRatio();
                        break;
                    } else {
                        throw new IllegalArgumentException("Index " + pbJoint.getJoint2() + " is not present in the joint map.");
                    }
                } else {
                    throw new IllegalArgumentException("Index " + pbJoint.getJoint1() + " is not present in the joint map.");
                }
            case 7:
                prismaticJointDef = new WheelJointDef();
                prismaticJointDef.localAnchorA.set(pbToVec(pbJoint.getLocalAnchorA()));
                prismaticJointDef.localAnchorB.set(pbToVec(pbJoint.getLocalAnchorB()));
                prismaticJointDef.localAxisA.set(pbToVec(pbJoint.getLocalAxisA()));
                prismaticJointDef.enableMotor = pbJoint.getEnableMotor();
                prismaticJointDef.maxMotorTorque = pbJoint.getMaxMotorTorque();
                prismaticJointDef.motorSpeed = pbJoint.getMotorSpeed();
                prismaticJointDef.frequencyHz = pbJoint.getFrequency();
                prismaticJointDef.dampingRatio = pbJoint.getDampingRatio();
                break;
            case 8:
                prismaticJointDef = new WeldJointDef();
                prismaticJointDef.localAnchorA.set(pbToVec(pbJoint.getLocalAnchorA()));
                prismaticJointDef.localAnchorB.set(pbToVec(pbJoint.getLocalAnchorB()));
                prismaticJointDef.referenceAngle = pbJoint.getRefAngle();
                prismaticJointDef.frequencyHz = pbJoint.getFrequency();
                prismaticJointDef.dampingRatio = pbJoint.getDampingRatio();
                break;
            case 9:
                prismaticJointDef = new FrictionJointDef();
                prismaticJointDef.localAnchorA.set(pbToVec(pbJoint.getLocalAnchorA()));
                prismaticJointDef.localAnchorB.set(pbToVec(pbJoint.getLocalAnchorB()));
                prismaticJointDef.maxForce = pbJoint.getMaxForce();
                prismaticJointDef.maxTorque = pbJoint.getMaxTorque();
                break;
            case 10:
                RopeJointDef ropeJointDef = new RopeJointDef();
                ropeJointDef.localAnchorA.set(pbToVec(pbJoint.getLocalAnchorA()));
                ropeJointDef.localAnchorB.set(pbToVec(pbJoint.getLocalAnchorB()));
                ropeJointDef.maxLength = pbJoint.getMaxLength();
                return null;
            case 11:
                prismaticJointDef = new ConstantVolumeJointDef();
                prismaticJointDef.dampingRatio = pbJoint.getDampingRatio();
                prismaticJointDef.frequencyHz = pbJoint.getFrequency();
                if (pbJoint.getBodiesCount() == pbJoint.getJointsCount()) {
                    for (int i3 = 0; i3 < pbJoint.getBodiesCount(); i3++) {
                        int bodies = pbJoint.getBodies(i3);
                        if (map.containsKey(Integer.valueOf(bodies))) {
                            int joints = pbJoint.getJoints(i3);
                            if (map2.containsKey(Integer.valueOf(joints))) {
                                Joint joint = map2.get(Integer.valueOf(joints));
                                if (joint instanceof DistanceJoint) {
                                    prismaticJointDef.addBodyAndJoint(map.get(Integer.valueOf(bodies)), (DistanceJoint) joint);
                                } else {
                                    throw new IllegalArgumentException("Joints for constant volume joint must be distance joints");
                                }
                            } else {
                                throw new IllegalArgumentException("Index " + joints + " is not present in the joint map");
                            }
                        } else {
                            throw new IllegalArgumentException("Index " + bodies + " is not present in the body map");
                        }
                    }
                    break;
                } else {
                    throw new IllegalArgumentException("Constant volume joint must have bodies and joints defined");
                }
            case 12:
                UnsupportedObjectException unsupportedObjectException = new UnsupportedObjectException("Line joint no longer supported.", UnsupportedObjectException.Type.JOINT);
                UnsupportedListener unsupportedListener = this.ulistener;
                if (unsupportedListener == null) {
                    throw unsupportedObjectException;
                }
                if (unsupportedListener.isUnsupported(unsupportedObjectException)) {
                    throw unsupportedObjectException;
                }
                return null;
            default:
                UnsupportedObjectException unsupportedObjectException2 = new UnsupportedObjectException("Unknown joint type: " + pbJoint.getType(), UnsupportedObjectException.Type.JOINT);
                UnsupportedListener unsupportedListener2 = this.ulistener;
                if (unsupportedListener2 == null) {
                    throw unsupportedObjectException2;
                }
                if (unsupportedListener2.isUnsupported(unsupportedObjectException2)) {
                    throw unsupportedObjectException2;
                }
                return null;
        }
        prismaticJointDef.collideConnected = pbJoint.getCollideConnected();
        if (map.containsKey(Integer.valueOf(pbJoint.getBodyA()))) {
            prismaticJointDef.bodyA = map.get(Integer.valueOf(pbJoint.getBodyA()));
            if (map.containsKey(Integer.valueOf(pbJoint.getBodyB()))) {
                prismaticJointDef.bodyB = map.get(Integer.valueOf(pbJoint.getBodyB()));
                Joint createJoint = world.createJoint(prismaticJointDef);
                if (this.listener != null && pbJoint.hasTag()) {
                    this.listener.processJoint(createJoint, Long.valueOf(pbJoint.getTag()));
                }
                return createJoint;
            }
            throw new IllegalArgumentException("Index " + pbJoint.getBodyB() + " is not present in the body map");
        }
        throw new IllegalArgumentException("Index " + pbJoint.getBodyA() + " is not present in the body map");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.jbox2d.collision.shapes.CircleShape] */
    /* JADX WARN: Type inference failed for: r0v3, types: [org.jbox2d.collision.shapes.Shape] */
    /* JADX WARN: Type inference failed for: r0v4, types: [org.jbox2d.collision.shapes.PolygonShape] */
    /* JADX WARN: Type inference failed for: r0v5, types: [org.jbox2d.collision.shapes.EdgeShape] */
    /* JADX WARN: Type inference failed for: r0v6, types: [org.jbox2d.collision.shapes.ChainShape] */
    /* JADX WARN: Type inference failed for: r1v7, types: [org.jbox2d.serialization.JbDeserializer$ObjectListener] */
    public Shape deserializeShape(Box2D.PbShape pbShape) {
        ?? circleShape;
        int i3 = AnonymousClass1.$SwitchMap$org$box2d$proto$Box2D$PbShapeType[pbShape.getType().ordinal()];
        if (i3 != 1) {
            int i16 = 0;
            if (i3 == 2) {
                circleShape = new PolygonShape();
                circleShape.m_centroid.set(pbToVec(pbShape.getCentroid()));
                circleShape.m_count = pbShape.getPointsCount();
                while (i16 < circleShape.m_count) {
                    circleShape.m_vertices[i16].set(pbToVec(pbShape.getPoints(i16)));
                    circleShape.m_normals[i16].set(pbToVec(pbShape.getNormals(i16)));
                    i16++;
                }
            } else if (i3 == 3) {
                circleShape = new EdgeShape();
                circleShape.m_vertex0.set(pbToVec(pbShape.getV0()));
                circleShape.m_vertex1.set(pbToVec(pbShape.getV1()));
                circleShape.m_vertex2.set(pbToVec(pbShape.getV2()));
                circleShape.m_vertex3.set(pbToVec(pbShape.getV3()));
                circleShape.m_hasVertex0 = pbShape.getHas0();
                circleShape.m_hasVertex3 = pbShape.getHas3();
            } else {
                if (i3 != 4) {
                    UnsupportedObjectException unsupportedObjectException = new UnsupportedObjectException("Unknown shape type: " + pbShape.getType(), UnsupportedObjectException.Type.SHAPE);
                    UnsupportedListener unsupportedListener = this.ulistener;
                    if (unsupportedListener == null) {
                        throw unsupportedObjectException;
                    }
                    if (unsupportedListener.isUnsupported(unsupportedObjectException)) {
                        throw unsupportedObjectException;
                    }
                    return null;
                }
                circleShape = new ChainShape();
                int pointsCount = pbShape.getPointsCount();
                circleShape.m_count = pointsCount;
                circleShape.m_vertices = new Vec2[pointsCount];
                while (i16 < circleShape.m_count) {
                    circleShape.m_vertices[i16] = new Vec2(pbToVec(pbShape.getPoints(i16)));
                    i16++;
                }
                circleShape.m_hasPrevVertex = pbShape.getHas0();
                circleShape.m_hasNextVertex = pbShape.getHas3();
                circleShape.m_prevVertex.set(pbToVec(pbShape.getPrev()));
                circleShape.m_nextVertex.set(pbToVec(pbShape.getNext()));
            }
        } else {
            circleShape = new CircleShape();
            circleShape.m_p.set(pbToVec(pbShape.getCenter()));
        }
        circleShape.m_radius = pbShape.getRadius();
        if (this.listener != null && pbShape.hasTag()) {
            this.listener.processShape(circleShape, Long.valueOf(pbShape.getTag()));
        }
        return circleShape;
    }

    public World deserializeWorld(Box2D.PbWorld pbWorld) {
        World world = new World(pbToVec(pbWorld.getGravity()));
        world.setAutoClearForces(pbWorld.getAutoClearForces());
        world.setContinuousPhysics(pbWorld.getContinuousPhysics());
        world.setWarmStarting(pbWorld.getWarmStarting());
        world.setSubStepping(pbWorld.getSubStepping());
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (int i3 = 0; i3 < pbWorld.getBodiesCount(); i3++) {
            hashMap.put(Integer.valueOf(i3), deserializeBody(world, pbWorld.getBodies(i3)));
        }
        int i16 = 0;
        for (int i17 = 0; i17 < pbWorld.getJointsCount(); i17++) {
            Box2D.PbJoint joints = pbWorld.getJoints(i17);
            if (isIndependentJoint(joints.getType())) {
                hashMap2.put(Integer.valueOf(i16), deserializeJoint(world, joints, hashMap, hashMap2));
                i16++;
            }
        }
        for (int i18 = 0; i18 < pbWorld.getJointsCount(); i18++) {
            Box2D.PbJoint joints2 = pbWorld.getJoints(i18);
            if (!isIndependentJoint(joints2.getType())) {
                hashMap2.put(Integer.valueOf(i16), deserializeJoint(world, joints2, hashMap, hashMap2));
                i16++;
            }
        }
        if (this.listener != null && pbWorld.hasTag()) {
            this.listener.processWorld(world, Long.valueOf(pbWorld.getTag()));
        }
        return world;
    }

    public PbDeserializer(UnsupportedListener unsupportedListener) {
        this.listener = null;
        this.ulistener = unsupportedListener;
    }

    public PbDeserializer(JbDeserializer.ObjectListener objectListener) {
        this.ulistener = null;
        this.listener = objectListener;
    }

    public PbDeserializer(UnsupportedListener unsupportedListener, JbDeserializer.ObjectListener objectListener) {
        this.ulistener = unsupportedListener;
        this.listener = objectListener;
    }
}
