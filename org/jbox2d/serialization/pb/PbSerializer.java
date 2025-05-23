package org.jbox2d.serialization.pb;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.box2d.proto.Box2D;
import org.jbox2d.collision.shapes.ChainShape;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.collision.shapes.ShapeType;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.Filter;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.joints.ConstantVolumeJoint;
import org.jbox2d.dynamics.joints.DistanceJoint;
import org.jbox2d.dynamics.joints.FrictionJoint;
import org.jbox2d.dynamics.joints.GearJoint;
import org.jbox2d.dynamics.joints.Joint;
import org.jbox2d.dynamics.joints.JointType;
import org.jbox2d.dynamics.joints.MouseJoint;
import org.jbox2d.dynamics.joints.PrismaticJoint;
import org.jbox2d.dynamics.joints.PulleyJoint;
import org.jbox2d.dynamics.joints.RevoluteJoint;
import org.jbox2d.dynamics.joints.RopeJoint;
import org.jbox2d.dynamics.joints.WeldJoint;
import org.jbox2d.dynamics.joints.WheelJoint;
import org.jbox2d.serialization.JbSerializer;
import org.jbox2d.serialization.SerializationHelper;
import org.jbox2d.serialization.SerializationResult;
import org.jbox2d.serialization.UnsupportedListener;
import org.jbox2d.serialization.UnsupportedObjectException;

/* loaded from: classes29.dex */
public class PbSerializer implements JbSerializer {
    private UnsupportedListener listener;
    private JbSerializer.ObjectSigner signer;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.jbox2d.serialization.pb.PbSerializer$6, reason: invalid class name */
    /* loaded from: classes29.dex */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$org$jbox2d$collision$shapes$ShapeType;
        static final /* synthetic */ int[] $SwitchMap$org$jbox2d$dynamics$BodyType;
        static final /* synthetic */ int[] $SwitchMap$org$jbox2d$dynamics$joints$JointType;

        static {
            int[] iArr = new int[JointType.values().length];
            $SwitchMap$org$jbox2d$dynamics$joints$JointType = iArr;
            try {
                iArr[JointType.REVOLUTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.PRISMATIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.DISTANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.PULLEY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.MOUSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.GEAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.FRICTION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.CONSTANT_VOLUME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.WHEEL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.ROPE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.WELD.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr2 = new int[ShapeType.values().length];
            $SwitchMap$org$jbox2d$collision$shapes$ShapeType = iArr2;
            try {
                iArr2[ShapeType.CIRCLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$jbox2d$collision$shapes$ShapeType[ShapeType.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$jbox2d$collision$shapes$ShapeType[ShapeType.EDGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$jbox2d$collision$shapes$ShapeType[ShapeType.CHAIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr3 = new int[BodyType.values().length];
            $SwitchMap$org$jbox2d$dynamics$BodyType = iArr3;
            try {
                iArr3[BodyType.DYNAMIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$BodyType[BodyType.KINEMATIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$BodyType[BodyType.STATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    public PbSerializer() {
        this.signer = null;
        this.listener = null;
    }

    private Box2D.PbVec2 vecToPb(Vec2 vec2) {
        if (vec2 == null) {
            return null;
        }
        return Box2D.PbVec2.newBuilder().setX(vec2.f423649x).setY(vec2.f423650y).build();
    }

    @Override // org.jbox2d.serialization.JbSerializer
    public SerializationResult serialize(World world) {
        final Box2D.PbWorld build = serializeWorld(world).build();
        return new SerializationResult() { // from class: org.jbox2d.serialization.pb.PbSerializer.1
            @Override // org.jbox2d.serialization.SerializationResult
            public Object getValue() {
                return build;
            }

            @Override // org.jbox2d.serialization.SerializationResult
            public void writeTo(OutputStream outputStream) throws IOException {
                build.writeTo(outputStream);
            }
        };
    }

    public Box2D.PbBody.Builder serializeBody(Body body) {
        Long tag;
        Box2D.PbBody.Builder newBuilder = Box2D.PbBody.newBuilder();
        JbSerializer.ObjectSigner objectSigner = this.signer;
        if (objectSigner != null && (tag = objectSigner.getTag(body)) != null) {
            newBuilder.setTag(tag.longValue());
        }
        int i3 = AnonymousClass6.$SwitchMap$org$jbox2d$dynamics$BodyType[body.getType().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    UnsupportedObjectException unsupportedObjectException = new UnsupportedObjectException("Unknown body type: " + body.getType(), UnsupportedObjectException.Type.BODY);
                    UnsupportedListener unsupportedListener = this.listener;
                    if (unsupportedListener != null) {
                        if (!unsupportedListener.isUnsupported(unsupportedObjectException)) {
                            return null;
                        }
                        throw unsupportedObjectException;
                    }
                    throw unsupportedObjectException;
                }
                newBuilder.setType(Box2D.PbBodyType.STATIC);
            } else {
                newBuilder.setType(Box2D.PbBodyType.KINEMATIC);
            }
        } else {
            newBuilder.setType(Box2D.PbBodyType.DYNAMIC);
        }
        newBuilder.setPosition(vecToPb(body.getPosition()));
        newBuilder.setAngle(body.getAngle());
        newBuilder.setLinearVelocity(vecToPb(body.getLinearVelocity()));
        newBuilder.setAngularVelocity(body.getAngularVelocity());
        newBuilder.setLinearDamping(body.getLinearDamping());
        newBuilder.setAngularDamping(body.getAngularDamping());
        newBuilder.setGravityScale(body.getGravityScale());
        newBuilder.setBullet(body.isBullet());
        newBuilder.setAllowSleep(body.isSleepingAllowed());
        newBuilder.setAwake(body.isAwake());
        newBuilder.setActive(body.isActive());
        newBuilder.setFixedRotation(body.isFixedRotation());
        for (Fixture fixture = body.m_fixtureList; fixture != null; fixture = fixture.m_next) {
            newBuilder.addFixtures(serializeFixture(fixture));
        }
        return newBuilder;
    }

    public Box2D.PbFilter.Builder serializeFilter(Filter filter) {
        Box2D.PbFilter.Builder newBuilder = Box2D.PbFilter.newBuilder();
        newBuilder.setCategoryBits(filter.categoryBits);
        newBuilder.setGroupIndex(filter.groupIndex);
        newBuilder.setMaskBits(filter.maskBits);
        return newBuilder;
    }

    public Box2D.PbFixture.Builder serializeFixture(Fixture fixture) {
        Long tag;
        Box2D.PbFixture.Builder newBuilder = Box2D.PbFixture.newBuilder();
        JbSerializer.ObjectSigner objectSigner = this.signer;
        if (objectSigner != null && (tag = objectSigner.getTag(fixture)) != null) {
            newBuilder.setTag(tag.longValue());
        }
        newBuilder.setDensity(fixture.m_density);
        newBuilder.setFriction(fixture.m_friction);
        newBuilder.setRestitution(fixture.m_restitution);
        newBuilder.setSensor(fixture.m_isSensor);
        newBuilder.setShape(serializeShape(fixture.m_shape));
        newBuilder.setFilter(serializeFilter(fixture.m_filter));
        return newBuilder;
    }

    public Box2D.PbJoint.Builder serializeJoint(Joint joint, Map<Body, Integer> map, Map<Joint, Integer> map2) {
        Box2D.PbJoint.Builder newBuilder = Box2D.PbJoint.newBuilder();
        JbSerializer.ObjectSigner objectSigner = this.signer;
        if (objectSigner != null) {
            Long tag = objectSigner.getTag(joint);
            if (tag != null) {
                newBuilder.setTag(tag.longValue());
            } else {
                newBuilder.clearTag();
            }
        }
        Body bodyA = joint.getBodyA();
        Body bodyB = joint.getBodyB();
        if (map.containsKey(bodyA)) {
            newBuilder.setBodyA(map.get(bodyA).intValue());
            if (map.containsKey(bodyB)) {
                newBuilder.setBodyB(map.get(bodyB).intValue());
                newBuilder.setCollideConnected(joint.getCollideConnected());
                switch (AnonymousClass6.$SwitchMap$org$jbox2d$dynamics$joints$JointType[joint.getType().ordinal()]) {
                    case 1:
                        RevoluteJoint revoluteJoint = (RevoluteJoint) joint;
                        newBuilder.setType(Box2D.PbJointType.REVOLUTE);
                        newBuilder.setLocalAnchorA(vecToPb(revoluteJoint.getLocalAnchorA()));
                        newBuilder.setLocalAnchorB(vecToPb(revoluteJoint.getLocalAnchorB()));
                        newBuilder.setRefAngle(revoluteJoint.getReferenceAngle());
                        newBuilder.setEnableLimit(revoluteJoint.isLimitEnabled());
                        newBuilder.setLowerLimit(revoluteJoint.getLowerLimit());
                        newBuilder.setUpperLimit(revoluteJoint.getUpperLimit());
                        newBuilder.setEnableMotor(revoluteJoint.isMotorEnabled());
                        newBuilder.setMotorSpeed(revoluteJoint.getMotorSpeed());
                        newBuilder.setMaxMotorTorque(revoluteJoint.getMaxMotorTorque());
                        return newBuilder;
                    case 2:
                        PrismaticJoint prismaticJoint = (PrismaticJoint) joint;
                        newBuilder.setType(Box2D.PbJointType.PRISMATIC);
                        newBuilder.setLocalAnchorA(vecToPb(prismaticJoint.getLocalAnchorA()));
                        newBuilder.setLocalAnchorB(vecToPb(prismaticJoint.getLocalAnchorB()));
                        newBuilder.setLocalAxisA(vecToPb(prismaticJoint.getLocalAxisA()));
                        newBuilder.setRefAngle(prismaticJoint.getReferenceAngle());
                        newBuilder.setEnableLimit(prismaticJoint.isLimitEnabled());
                        newBuilder.setLowerLimit(prismaticJoint.getLowerLimit());
                        newBuilder.setUpperLimit(prismaticJoint.getUpperLimit());
                        newBuilder.setEnableMotor(prismaticJoint.isMotorEnabled());
                        newBuilder.setMaxMotorForce(prismaticJoint.getMaxMotorForce());
                        newBuilder.setMotorSpeed(prismaticJoint.getMotorSpeed());
                        return newBuilder;
                    case 3:
                        DistanceJoint distanceJoint = (DistanceJoint) joint;
                        newBuilder.setType(Box2D.PbJointType.DISTANCE);
                        newBuilder.setLocalAnchorA(vecToPb(distanceJoint.getLocalAnchorA()));
                        newBuilder.setLocalAnchorB(vecToPb(distanceJoint.getLocalAnchorB()));
                        newBuilder.setLength(distanceJoint.getLength());
                        newBuilder.setFrequency(distanceJoint.getFrequency());
                        newBuilder.setDampingRatio(distanceJoint.getDampingRatio());
                        return newBuilder;
                    case 4:
                        PulleyJoint pulleyJoint = (PulleyJoint) joint;
                        newBuilder.setType(Box2D.PbJointType.PULLEY);
                        newBuilder.setLocalAnchorA(vecToPb(pulleyJoint.getLocalAnchorA()));
                        newBuilder.setLocalAnchorB(vecToPb(pulleyJoint.getLocalAnchorB()));
                        newBuilder.setGroundAnchorA(vecToPb(pulleyJoint.getGroundAnchorA()));
                        newBuilder.setGroundAnchorB(vecToPb(pulleyJoint.getGroundAnchorB()));
                        newBuilder.setLengthA(pulleyJoint.getLengthA());
                        newBuilder.setLengthB(pulleyJoint.getLengthB());
                        newBuilder.setRatio(pulleyJoint.getRatio());
                        return newBuilder;
                    case 5:
                        MouseJoint mouseJoint = (MouseJoint) joint;
                        newBuilder.setType(Box2D.PbJointType.MOUSE);
                        newBuilder.setTarget(vecToPb(mouseJoint.getTarget()));
                        newBuilder.setMaxForce(mouseJoint.getMaxForce());
                        newBuilder.setFrequency(mouseJoint.getFrequency());
                        newBuilder.setDampingRatio(mouseJoint.getDampingRatio());
                        return newBuilder;
                    case 6:
                        GearJoint gearJoint = (GearJoint) joint;
                        newBuilder.setType(Box2D.PbJointType.GEAR);
                        newBuilder.setRatio(gearJoint.getRatio());
                        if (map2.containsKey(gearJoint.getJoint1())) {
                            int intValue = map2.get(gearJoint.getJoint1()).intValue();
                            if (map2.containsKey(gearJoint.getJoint2())) {
                                int intValue2 = map2.get(gearJoint.getJoint2()).intValue();
                                newBuilder.setJoint1(intValue);
                                newBuilder.setJoint2(intValue2);
                                return newBuilder;
                            }
                            throw new IllegalArgumentException("Joint 2 not in map");
                        }
                        throw new IllegalArgumentException("Joint 1 not in map");
                    case 7:
                        FrictionJoint frictionJoint = (FrictionJoint) joint;
                        newBuilder.setType(Box2D.PbJointType.FRICTION);
                        newBuilder.setLocalAnchorA(vecToPb(frictionJoint.getLocalAnchorA()));
                        newBuilder.setLocalAnchorB(vecToPb(frictionJoint.getLocalAnchorB()));
                        newBuilder.setMaxForce(frictionJoint.getMaxForce());
                        newBuilder.setMaxTorque(frictionJoint.getMaxTorque());
                        return newBuilder;
                    case 8:
                        ConstantVolumeJoint constantVolumeJoint = (ConstantVolumeJoint) joint;
                        newBuilder.setType(Box2D.PbJointType.CONSTANT_VOLUME);
                        for (int i3 = 0; i3 < constantVolumeJoint.getBodies().length; i3++) {
                            Body body = constantVolumeJoint.getBodies()[i3];
                            DistanceJoint distanceJoint2 = constantVolumeJoint.getJoints()[i3];
                            if (map.containsKey(body)) {
                                newBuilder.addBodies(map.get(body).intValue());
                                if (map2.containsKey(distanceJoint2)) {
                                    newBuilder.addJoints(map2.get(distanceJoint2).intValue());
                                } else {
                                    throw new IllegalArgumentException("Joint " + distanceJoint2 + " is not present in the index map");
                                }
                            } else {
                                throw new IllegalArgumentException("Body " + body + " is not present in the index map");
                            }
                        }
                        return newBuilder;
                    case 9:
                        WheelJoint wheelJoint = (WheelJoint) joint;
                        newBuilder.setType(Box2D.PbJointType.WHEEL);
                        newBuilder.setLocalAnchorA(vecToPb(wheelJoint.getLocalAnchorA()));
                        newBuilder.setLocalAnchorB(vecToPb(wheelJoint.getLocalAnchorB()));
                        newBuilder.setLocalAxisA(vecToPb(wheelJoint.getLocalAxisA()));
                        newBuilder.setEnableMotor(wheelJoint.isMotorEnabled());
                        newBuilder.setMaxMotorTorque(wheelJoint.getMaxMotorTorque());
                        newBuilder.setMotorSpeed(wheelJoint.getMotorSpeed());
                        newBuilder.setFrequency(wheelJoint.getSpringFrequencyHz());
                        newBuilder.setDampingRatio(wheelJoint.getSpringDampingRatio());
                        return newBuilder;
                    case 10:
                        RopeJoint ropeJoint = (RopeJoint) joint;
                        newBuilder.setType(Box2D.PbJointType.ROPE);
                        newBuilder.setLocalAnchorA(vecToPb(ropeJoint.getLocalAnchorA()));
                        newBuilder.setLocalAnchorB(vecToPb(ropeJoint.getLocalAnchorB()));
                        newBuilder.setMaxLength(ropeJoint.getMaxLength());
                        return newBuilder;
                    case 11:
                        WeldJoint weldJoint = (WeldJoint) joint;
                        newBuilder.setType(Box2D.PbJointType.WELD);
                        newBuilder.setLocalAnchorA(vecToPb(weldJoint.getLocalAnchorA()));
                        newBuilder.setLocalAnchorB(vecToPb(weldJoint.getLocalAnchorB()));
                        newBuilder.setRefAngle(weldJoint.getReferenceAngle());
                        newBuilder.setFrequency(weldJoint.getFrequency());
                        newBuilder.setDampingRatio(weldJoint.getDampingRatio());
                        return newBuilder;
                    default:
                        UnsupportedObjectException unsupportedObjectException = new UnsupportedObjectException("Unknown joint type: " + joint.getType(), UnsupportedObjectException.Type.JOINT);
                        UnsupportedListener unsupportedListener = this.listener;
                        if (unsupportedListener != null) {
                            if (!unsupportedListener.isUnsupported(unsupportedObjectException)) {
                                return null;
                            }
                            throw unsupportedObjectException;
                        }
                        throw unsupportedObjectException;
                }
            }
            throw new IllegalArgumentException("Body " + bodyB + " is not present in the index map");
        }
        throw new IllegalArgumentException("Body " + bodyA + " is not present in the index map");
    }

    public Box2D.PbShape.Builder serializeShape(Shape shape) {
        Long tag;
        Box2D.PbShape.Builder newBuilder = Box2D.PbShape.newBuilder();
        JbSerializer.ObjectSigner objectSigner = this.signer;
        if (objectSigner != null && (tag = objectSigner.getTag(shape)) != null) {
            newBuilder.setTag(tag.longValue());
        }
        newBuilder.setRadius(shape.m_radius);
        int i3 = AnonymousClass6.$SwitchMap$org$jbox2d$collision$shapes$ShapeType[shape.m_type.ordinal()];
        if (i3 != 1) {
            int i16 = 0;
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        UnsupportedObjectException unsupportedObjectException = new UnsupportedObjectException("Currently only encodes circle and polygon shapes", UnsupportedObjectException.Type.SHAPE);
                        UnsupportedListener unsupportedListener = this.listener;
                        if (unsupportedListener != null) {
                            if (!unsupportedListener.isUnsupported(unsupportedObjectException)) {
                                return null;
                            }
                            throw unsupportedObjectException;
                        }
                        throw unsupportedObjectException;
                    }
                    ChainShape chainShape = (ChainShape) shape;
                    newBuilder.setType(Box2D.PbShapeType.CHAIN);
                    while (i16 < chainShape.m_count) {
                        newBuilder.addPoints(vecToPb(chainShape.m_vertices[i16]));
                        i16++;
                    }
                    newBuilder.setPrev(vecToPb(chainShape.m_prevVertex));
                    newBuilder.setNext(vecToPb(chainShape.m_nextVertex));
                    newBuilder.setHas0(chainShape.m_hasPrevVertex);
                    newBuilder.setHas3(chainShape.m_hasNextVertex);
                } else {
                    EdgeShape edgeShape = (EdgeShape) shape;
                    newBuilder.setType(Box2D.PbShapeType.EDGE);
                    newBuilder.setV0(vecToPb(edgeShape.m_vertex0));
                    newBuilder.setV1(vecToPb(edgeShape.m_vertex1));
                    newBuilder.setV2(vecToPb(edgeShape.m_vertex2));
                    newBuilder.setV3(vecToPb(edgeShape.m_vertex3));
                    newBuilder.setHas0(edgeShape.m_hasVertex0);
                    newBuilder.setHas3(edgeShape.m_hasVertex3);
                }
            } else {
                PolygonShape polygonShape = (PolygonShape) shape;
                newBuilder.setType(Box2D.PbShapeType.POLYGON);
                newBuilder.setCentroid(vecToPb(polygonShape.m_centroid));
                while (i16 < polygonShape.m_count) {
                    newBuilder.addPoints(vecToPb(polygonShape.m_vertices[i16]));
                    newBuilder.addNormals(vecToPb(polygonShape.m_normals[i16]));
                    i16++;
                }
            }
        } else {
            newBuilder.setType(Box2D.PbShapeType.CIRCLE);
            newBuilder.setCenter(vecToPb(((CircleShape) shape).m_p));
        }
        return newBuilder;
    }

    public Box2D.PbWorld.Builder serializeWorld(World world) {
        Long tag;
        Box2D.PbWorld.Builder newBuilder = Box2D.PbWorld.newBuilder();
        JbSerializer.ObjectSigner objectSigner = this.signer;
        if (objectSigner != null && (tag = objectSigner.getTag(world)) != null) {
            newBuilder.setTag(tag.longValue());
        }
        newBuilder.setGravity(vecToPb(world.getGravity()));
        newBuilder.setAllowSleep(world.isAllowSleep());
        newBuilder.setContinuousPhysics(world.isContinuousPhysics());
        newBuilder.setWarmStarting(world.isWarmStarting());
        newBuilder.setSubStepping(world.isSubStepping());
        HashMap hashMap = new HashMap();
        int i3 = 0;
        int i16 = 0;
        for (Body bodyList = world.getBodyList(); bodyList != null; bodyList = bodyList.m_next) {
            newBuilder.addBodies(serializeBody(bodyList));
            hashMap.put(bodyList, Integer.valueOf(i16));
            i16++;
        }
        HashMap hashMap2 = new HashMap();
        for (Joint jointList = world.getJointList(); jointList != null; jointList = jointList.m_next) {
            if (SerializationHelper.isIndependentJoint(jointList.getType())) {
                newBuilder.addJoints(serializeJoint(jointList, hashMap, hashMap2));
                hashMap2.put(jointList, Integer.valueOf(i3));
                i3++;
            }
        }
        for (Joint jointList2 = world.getJointList(); jointList2 != null; jointList2 = jointList2.m_next) {
            if (!SerializationHelper.isIndependentJoint(jointList2.getType())) {
                newBuilder.addJoints(serializeJoint(jointList2, hashMap, hashMap2));
                hashMap2.put(jointList2, Integer.valueOf(i3));
                i3++;
            }
        }
        return newBuilder;
    }

    @Override // org.jbox2d.serialization.JbSerializer
    public void setObjectSigner(JbSerializer.ObjectSigner objectSigner) {
        this.signer = objectSigner;
    }

    @Override // org.jbox2d.serialization.JbSerializer
    public void setUnsupportedListener(UnsupportedListener unsupportedListener) {
        this.listener = unsupportedListener;
    }

    @Override // org.jbox2d.serialization.JbSerializer
    public SerializationResult serialize(Body body) {
        Box2D.PbBody.Builder serializeBody = serializeBody(body);
        if (serializeBody == null) {
            return null;
        }
        final Box2D.PbBody build = serializeBody.build();
        return new SerializationResult() { // from class: org.jbox2d.serialization.pb.PbSerializer.2
            @Override // org.jbox2d.serialization.SerializationResult
            public Object getValue() {
                return build;
            }

            @Override // org.jbox2d.serialization.SerializationResult
            public void writeTo(OutputStream outputStream) throws IOException {
                build.writeTo(outputStream);
            }
        };
    }

    public PbSerializer(UnsupportedListener unsupportedListener) {
        this.signer = null;
        this.listener = unsupportedListener;
    }

    @Override // org.jbox2d.serialization.JbSerializer
    public SerializationResult serialize(Fixture fixture) {
        final Box2D.PbFixture build = serializeFixture(fixture).build();
        return new SerializationResult() { // from class: org.jbox2d.serialization.pb.PbSerializer.3
            @Override // org.jbox2d.serialization.SerializationResult
            public Object getValue() {
                return build;
            }

            @Override // org.jbox2d.serialization.SerializationResult
            public void writeTo(OutputStream outputStream) throws IOException {
                build.writeTo(outputStream);
            }
        };
    }

    public PbSerializer(JbSerializer.ObjectSigner objectSigner) {
        this.listener = null;
        this.signer = objectSigner;
    }

    @Override // org.jbox2d.serialization.JbSerializer
    public SerializationResult serialize(Shape shape) {
        Box2D.PbShape.Builder serializeShape = serializeShape(shape);
        if (serializeShape == null) {
            return null;
        }
        final Box2D.PbShape build = serializeShape.build();
        return new SerializationResult() { // from class: org.jbox2d.serialization.pb.PbSerializer.4
            @Override // org.jbox2d.serialization.SerializationResult
            public Object getValue() {
                return build;
            }

            @Override // org.jbox2d.serialization.SerializationResult
            public void writeTo(OutputStream outputStream) throws IOException {
                build.writeTo(outputStream);
            }
        };
    }

    public PbSerializer(UnsupportedListener unsupportedListener, JbSerializer.ObjectSigner objectSigner) {
        this.listener = unsupportedListener;
        this.signer = objectSigner;
    }

    @Override // org.jbox2d.serialization.JbSerializer
    public SerializationResult serialize(Joint joint, Map<Body, Integer> map, Map<Joint, Integer> map2) {
        Box2D.PbJoint.Builder serializeJoint = serializeJoint(joint, map, map2);
        if (serializeJoint == null) {
            return null;
        }
        final Box2D.PbJoint build = serializeJoint.build();
        return new SerializationResult() { // from class: org.jbox2d.serialization.pb.PbSerializer.5
            @Override // org.jbox2d.serialization.SerializationResult
            public Object getValue() {
                return build;
            }

            @Override // org.jbox2d.serialization.SerializationResult
            public void writeTo(OutputStream outputStream) throws IOException {
                build.writeTo(outputStream);
            }
        };
    }
}
