package org.jbox2d.dynamics;

import java.lang.reflect.Array;
import org.jbox2d.callbacks.ContactFilter;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.callbacks.DestructionListener;
import org.jbox2d.callbacks.QueryCallback;
import org.jbox2d.callbacks.RayCastCallback;
import org.jbox2d.collision.AABB;
import org.jbox2d.collision.RayCastInput;
import org.jbox2d.collision.TimeOfImpact;
import org.jbox2d.collision.broadphase.BroadPhase;
import org.jbox2d.collision.broadphase.BroadPhaseStrategy;
import org.jbox2d.collision.broadphase.DynamicTree;
import org.jbox2d.collision.shapes.ChainShape;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.ShapeType;
import org.jbox2d.common.Color3f;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Sweep;
import org.jbox2d.common.Timer;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.contacts.Contact;
import org.jbox2d.dynamics.contacts.ContactEdge;
import org.jbox2d.dynamics.contacts.ContactRegister;
import org.jbox2d.dynamics.joints.Joint;
import org.jbox2d.dynamics.joints.JointDef;
import org.jbox2d.dynamics.joints.JointEdge;
import org.jbox2d.dynamics.joints.JointType;
import org.jbox2d.dynamics.joints.PulleyJoint;
import org.jbox2d.pooling.IDynamicStack;
import org.jbox2d.pooling.IWorldPool;
import org.jbox2d.pooling.arrays.Vec2Array;
import org.jbox2d.pooling.normal.DefaultWorldPool;

/* compiled from: P */
/* loaded from: classes29.dex */
public class World {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CLEAR_FORCES = 4;
    private static Integer LIQUID_INT = new Integer(1234598372);
    public static final int LOCKED = 2;
    public static final int NEW_FIXTURE = 1;
    public static final int WORLD_POOL_CONTAINER_SIZE = 10;
    public static final int WORLD_POOL_SIZE = 100;
    public int activeContacts;
    private float averageLinearVel;
    private final Vec2Array avs;
    private final Vec2 axis;
    private final Sweep backup1;
    private final Sweep backup2;
    private final Timer broadphaseTimer;
    private final Vec2 cA;
    private final Vec2 cB;
    private final Vec2 center;
    private final Vec2 circCenterMoved;
    private final Color3f color;
    public int contactPoolCount;
    private ContactRegister[][] contactStacks;
    private final RayCastInput input;
    private final Island island;
    private final Profile islandProfile;
    private final Color3f liquidColor;
    private float liquidLength;
    private final Vec2 liquidOffset;
    private boolean m_allowSleep;
    private int m_bodyCount;
    private Body m_bodyList;
    protected ContactManager m_contactManager;
    private boolean m_continuousPhysics;
    private DebugDraw m_debugDraw;
    private DestructionListener m_destructionListener;
    protected int m_flags;
    private final Vec2 m_gravity;
    private float m_inv_dt0;
    private int m_jointCount;
    private Joint m_jointList;
    private Profile m_profile;
    private boolean m_stepComplete;
    private boolean m_subStepping;
    private boolean m_warmStarting;
    private final IWorldPool pool;
    private Body[] stack;
    private final TimeStep step;
    private final Timer stepTimer;
    private final TimeStep subStep;
    private final Body[] tempBodies;
    private final Timer tempTimer;
    private final Vec2Array tlvertices;
    private final TimeOfImpact.TOIInput toiInput;
    private final Island toiIsland;
    private final TimeOfImpact.TOIOutput toiOutput;

    /* renamed from: v1, reason: collision with root package name */
    private final Vec2 f423655v1;

    /* renamed from: v2, reason: collision with root package name */
    private final Vec2 f423656v2;
    private final WorldQueryWrapper wqwrapper;
    private final WorldRayCastWrapper wrcwrapper;

    /* renamed from: xf, reason: collision with root package name */
    private final Transform f423657xf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: org.jbox2d.dynamics.World$1, reason: invalid class name */
    /* loaded from: classes29.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jbox2d$collision$shapes$ShapeType;
        static final /* synthetic */ int[] $SwitchMap$org$jbox2d$dynamics$joints$JointType;

        static {
            int[] iArr = new int[ShapeType.values().length];
            $SwitchMap$org$jbox2d$collision$shapes$ShapeType = iArr;
            try {
                iArr[ShapeType.CIRCLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jbox2d$collision$shapes$ShapeType[ShapeType.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jbox2d$collision$shapes$ShapeType[ShapeType.EDGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jbox2d$collision$shapes$ShapeType[ShapeType.CHAIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[JointType.values().length];
            $SwitchMap$org$jbox2d$dynamics$joints$JointType = iArr2;
            try {
                iArr2[JointType.DISTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.PULLEY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.CONSTANT_VOLUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$jbox2d$dynamics$joints$JointType[JointType.MOUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public World(Vec2 vec2) {
        this(vec2, new DefaultWorldPool(100, 10));
    }

    private void addType(IDynamicStack<Contact> iDynamicStack, ShapeType shapeType, ShapeType shapeType2) {
        ContactRegister contactRegister = new ContactRegister();
        contactRegister.creator = iDynamicStack;
        contactRegister.primary = true;
        this.contactStacks[shapeType.ordinal()][shapeType2.ordinal()] = contactRegister;
        if (shapeType != shapeType2) {
            ContactRegister contactRegister2 = new ContactRegister();
            contactRegister2.creator = iDynamicStack;
            contactRegister2.primary = false;
            this.contactStacks[shapeType2.ordinal()][shapeType.ordinal()] = contactRegister2;
        }
    }

    private void drawJoint(Joint joint) {
        Body bodyA = joint.getBodyA();
        Body bodyB = joint.getBodyB();
        Transform transform = bodyA.getTransform();
        Transform transform2 = bodyB.getTransform();
        Vec2 vec2 = transform.f423647p;
        Vec2 vec22 = transform2.f423647p;
        Vec2 popVec2 = this.pool.popVec2();
        Vec2 popVec22 = this.pool.popVec2();
        joint.getAnchorA(popVec2);
        joint.getAnchorB(popVec22);
        this.color.set(0.5f, 0.8f, 0.8f);
        int i3 = AnonymousClass1.$SwitchMap$org$jbox2d$dynamics$joints$JointType[joint.getType().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3 && i3 != 4) {
                    this.m_debugDraw.drawSegment(vec2, popVec2, this.color);
                    this.m_debugDraw.drawSegment(popVec2, popVec22, this.color);
                    this.m_debugDraw.drawSegment(vec22, popVec22, this.color);
                }
            } else {
                PulleyJoint pulleyJoint = (PulleyJoint) joint;
                Vec2 groundAnchorA = pulleyJoint.getGroundAnchorA();
                Vec2 groundAnchorB = pulleyJoint.getGroundAnchorB();
                this.m_debugDraw.drawSegment(groundAnchorA, popVec2, this.color);
                this.m_debugDraw.drawSegment(groundAnchorB, popVec22, this.color);
                this.m_debugDraw.drawSegment(groundAnchorA, groundAnchorB, this.color);
            }
        } else {
            this.m_debugDraw.drawSegment(popVec2, popVec22, this.color);
        }
        this.pool.pushVec2(2);
    }

    private void drawShape(Fixture fixture, Transform transform, Color3f color3f) {
        int i3 = AnonymousClass1.$SwitchMap$org$jbox2d$collision$shapes$ShapeType[fixture.getType().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        ChainShape chainShape = (ChainShape) fixture.getShape();
                        int i16 = chainShape.m_count;
                        Vec2[] vec2Arr = chainShape.m_vertices;
                        Transform.mulToOutUnsafe(transform, vec2Arr[0], this.f423655v1);
                        for (int i17 = 1; i17 < i16; i17++) {
                            Transform.mulToOutUnsafe(transform, vec2Arr[i17], this.f423656v2);
                            this.m_debugDraw.drawSegment(this.f423655v1, this.f423656v2, color3f);
                            this.m_debugDraw.drawCircle(this.f423655v1, 0.05f, color3f);
                            this.f423655v1.set(this.f423656v2);
                        }
                        return;
                    }
                    return;
                }
                EdgeShape edgeShape = (EdgeShape) fixture.getShape();
                Transform.mulToOutUnsafe(transform, edgeShape.m_vertex1, this.f423655v1);
                Transform.mulToOutUnsafe(transform, edgeShape.m_vertex2, this.f423656v2);
                this.m_debugDraw.drawSegment(this.f423655v1, this.f423656v2, color3f);
                return;
            }
            PolygonShape polygonShape = (PolygonShape) fixture.getShape();
            int i18 = polygonShape.m_count;
            Vec2[] vec2Arr2 = this.tlvertices.get(8);
            for (int i19 = 0; i19 < i18; i19++) {
                Transform.mulToOutUnsafe(transform, polygonShape.m_vertices[i19], vec2Arr2[i19]);
            }
            this.m_debugDraw.drawSolidPolygon(vec2Arr2, i18, color3f);
            return;
        }
        CircleShape circleShape = (CircleShape) fixture.getShape();
        Transform.mulToOutUnsafe(transform, circleShape.m_p, this.center);
        float f16 = circleShape.m_radius;
        transform.f423648q.getXAxis(this.axis);
        if (fixture.getUserData() != null && fixture.getUserData().equals(LIQUID_INT)) {
            Body body = fixture.getBody();
            this.liquidOffset.set(body.m_linearVelocity);
            float length = body.m_linearVelocity.length();
            float f17 = this.averageLinearVel;
            if (f17 == -1.0f) {
                this.averageLinearVel = length;
            } else {
                this.averageLinearVel = (f17 * 0.98f) + (length * 0.02f);
            }
            this.liquidOffset.mulLocal((this.liquidLength / this.averageLinearVel) / 2.0f);
            this.circCenterMoved.set(this.center).addLocal(this.liquidOffset);
            this.center.subLocal(this.liquidOffset);
            this.m_debugDraw.drawSegment(this.center, this.circCenterMoved, this.liquidColor);
            return;
        }
        this.m_debugDraw.drawSolidCircle(this.center, f16, this.axis, color3f);
    }

    private void initializeRegisters() {
        IDynamicStack<Contact> circleContactStack = this.pool.getCircleContactStack();
        ShapeType shapeType = ShapeType.CIRCLE;
        addType(circleContactStack, shapeType, shapeType);
        IDynamicStack<Contact> polyCircleContactStack = this.pool.getPolyCircleContactStack();
        ShapeType shapeType2 = ShapeType.POLYGON;
        addType(polyCircleContactStack, shapeType2, shapeType);
        addType(this.pool.getPolyContactStack(), shapeType2, shapeType2);
        IDynamicStack<Contact> edgeCircleContactStack = this.pool.getEdgeCircleContactStack();
        ShapeType shapeType3 = ShapeType.EDGE;
        addType(edgeCircleContactStack, shapeType3, shapeType);
        addType(this.pool.getEdgePolyContactStack(), shapeType3, shapeType2);
        IDynamicStack<Contact> chainCircleContactStack = this.pool.getChainCircleContactStack();
        ShapeType shapeType4 = ShapeType.CHAIN;
        addType(chainCircleContactStack, shapeType4, shapeType);
        addType(this.pool.getChainPolyContactStack(), shapeType4, shapeType2);
    }

    private void solve(TimeStep timeStep) {
        Profile profile = this.m_profile;
        profile.solveInit = 0.0f;
        profile.solveVelocity = 0.0f;
        profile.solvePosition = 0.0f;
        Island island = this.island;
        int i3 = this.m_bodyCount;
        ContactManager contactManager = this.m_contactManager;
        island.init(i3, contactManager.m_contactCount, this.m_jointCount, contactManager.m_contactListener);
        for (Body body = this.m_bodyList; body != null; body = body.m_next) {
            body.m_flags &= -2;
        }
        for (Contact contact = this.m_contactManager.m_contactList; contact != null; contact = contact.m_next) {
            contact.m_flags &= -2;
        }
        for (Joint joint = this.m_jointList; joint != null; joint = joint.m_next) {
            joint.m_islandFlag = false;
        }
        int i16 = this.m_bodyCount;
        if (this.stack.length < i16) {
            this.stack = new Body[i16];
        }
        for (Body body2 = this.m_bodyList; body2 != null; body2 = body2.m_next) {
            if ((body2.m_flags & 1) != 1 && body2.isAwake() && body2.isActive() && body2.getType() != BodyType.STATIC) {
                this.island.clear();
                this.stack[0] = body2;
                body2.m_flags |= 1;
                int i17 = 1;
                while (i17 > 0) {
                    i17--;
                    Body body3 = this.stack[i17];
                    this.island.add(body3);
                    body3.setAwake(true);
                    if (body3.getType() != BodyType.STATIC) {
                        for (ContactEdge contactEdge = body3.m_contactList; contactEdge != null; contactEdge = contactEdge.next) {
                            Contact contact2 = contactEdge.contact;
                            if ((contact2.m_flags & 1) != 1 && contact2.isEnabled() && contact2.isTouching()) {
                                boolean z16 = contact2.m_fixtureA.m_isSensor;
                                boolean z17 = contact2.m_fixtureB.m_isSensor;
                                if (!z16 && !z17) {
                                    this.island.add(contact2);
                                    contact2.m_flags |= 1;
                                    Body body4 = contactEdge.other;
                                    int i18 = body4.m_flags;
                                    if ((i18 & 1) != 1) {
                                        this.stack[i17] = body4;
                                        body4.m_flags = i18 | 1;
                                        i17++;
                                    }
                                }
                            }
                        }
                        for (JointEdge jointEdge = body3.m_jointList; jointEdge != null; jointEdge = jointEdge.next) {
                            if (!jointEdge.joint.m_islandFlag) {
                                Body body5 = jointEdge.other;
                                if (body5.isActive()) {
                                    this.island.add(jointEdge.joint);
                                    jointEdge.joint.m_islandFlag = true;
                                    int i19 = body5.m_flags;
                                    if ((i19 & 1) != 1) {
                                        this.stack[i17] = body5;
                                        body5.m_flags = i19 | 1;
                                        i17++;
                                    }
                                }
                            }
                        }
                    }
                }
                this.island.solve(this.islandProfile, timeStep, this.m_gravity, this.m_allowSleep);
                Profile profile2 = this.m_profile;
                float f16 = profile2.solveInit;
                Profile profile3 = this.islandProfile;
                profile2.solveInit = f16 + profile3.solveInit;
                profile2.solveVelocity += profile3.solveVelocity;
                profile2.solvePosition += profile3.solvePosition;
                int i26 = 0;
                while (true) {
                    Island island2 = this.island;
                    if (i26 < island2.m_bodyCount) {
                        Body body6 = island2.m_bodies[i26];
                        if (body6.getType() == BodyType.STATIC) {
                            body6.m_flags &= -2;
                        }
                        i26++;
                    }
                }
            }
        }
        this.broadphaseTimer.reset();
        for (Body body7 = this.m_bodyList; body7 != null; body7 = body7.getNext()) {
            if ((body7.m_flags & 1) != 0 && body7.getType() != BodyType.STATIC) {
                body7.synchronizeFixtures();
            }
        }
        this.m_contactManager.findNewContacts();
        this.m_profile.broadphase = this.broadphaseTimer.getMilliseconds();
    }

    /* JADX WARN: Code restructure failed: missing block: B:161:0x02dd, code lost:
    
        r18.m_stepComplete = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x02e0, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void solveTOI(TimeStep timeStep) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        float f16;
        int i3;
        Island island = this.toiIsland;
        int i16 = 32;
        island.init(64, 32, 0, this.m_contactManager.m_contactListener);
        if (this.m_stepComplete) {
            for (Body body = this.m_bodyList; body != null; body = body.m_next) {
                body.m_flags &= -2;
                body.m_sweep.alpha0 = 0.0f;
            }
            for (Contact contact = this.m_contactManager.m_contactList; contact != null; contact = contact.m_next) {
                contact.m_flags &= -34;
                contact.m_toiCount = 0.0f;
                contact.m_toi = 1.0f;
            }
        }
        while (true) {
            Contact contact2 = this.m_contactManager.m_contactList;
            Contact contact3 = null;
            float f17 = 1.0f;
            while (contact2 != null) {
                if (contact2.isEnabled() && contact2.m_toiCount <= 8.0f) {
                    if ((contact2.m_flags & i16) != 0) {
                        f16 = contact2.m_toi;
                        i3 = i16;
                    } else {
                        Fixture fixtureA = contact2.getFixtureA();
                        Fixture fixtureB = contact2.getFixtureB();
                        if (!fixtureA.isSensor() && !fixtureB.isSensor()) {
                            Body body2 = fixtureA.getBody();
                            Body body3 = fixtureB.getBody();
                            BodyType bodyType = body2.m_type;
                            BodyType bodyType2 = body3.m_type;
                            if (body2.isAwake() && bodyType != BodyType.STATIC) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (body3.isAwake() && bodyType2 != BodyType.STATIC) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z16 || z17) {
                                if (!body2.isBullet() && bodyType == BodyType.DYNAMIC) {
                                    z18 = false;
                                } else {
                                    z18 = true;
                                }
                                if (!body3.isBullet() && bodyType2 == BodyType.DYNAMIC) {
                                    z19 = false;
                                } else {
                                    z19 = true;
                                }
                                if (z18 || z19) {
                                    Sweep sweep = body2.m_sweep;
                                    float f18 = sweep.alpha0;
                                    Sweep sweep2 = body3.m_sweep;
                                    float f19 = sweep2.alpha0;
                                    if (f18 < f19) {
                                        sweep.advance(f19);
                                        f18 = f19;
                                    } else if (f19 < f18) {
                                        sweep2.advance(f18);
                                    }
                                    int childIndexA = contact2.getChildIndexA();
                                    int childIndexB = contact2.getChildIndexB();
                                    TimeOfImpact.TOIInput tOIInput = this.toiInput;
                                    tOIInput.proxyA.set(fixtureA.getShape(), childIndexA);
                                    tOIInput.proxyB.set(fixtureB.getShape(), childIndexB);
                                    tOIInput.sweepA.set(body2.m_sweep);
                                    tOIInput.sweepB.set(body3.m_sweep);
                                    tOIInput.tMax = 1.0f;
                                    this.pool.getTimeOfImpact().timeOfImpact(this.toiOutput, tOIInput);
                                    TimeOfImpact.TOIOutput tOIOutput = this.toiOutput;
                                    float f26 = tOIOutput.f423630t;
                                    if (tOIOutput.state == TimeOfImpact.TOIOutputState.TOUCHING) {
                                        f16 = MathUtils.min(f18 + ((1.0f - f18) * f26), 1.0f);
                                    } else {
                                        f16 = 1.0f;
                                    }
                                    contact2.m_toi = f16;
                                    i3 = 32;
                                    contact2.m_flags |= 32;
                                }
                            }
                        }
                    }
                    if (f16 < f17) {
                        contact3 = contact2;
                        f17 = f16;
                    }
                    contact2 = contact2.m_next;
                    i16 = i3;
                }
                i3 = i16;
                contact2 = contact2.m_next;
                i16 = i3;
            }
            int i17 = i16;
            if (contact3 == null || 0.9999988f < f17) {
                break;
            }
            Fixture fixtureA2 = contact3.getFixtureA();
            Fixture fixtureB2 = contact3.getFixtureB();
            Body body4 = fixtureA2.getBody();
            Body body5 = fixtureB2.getBody();
            this.backup1.set(body4.m_sweep);
            this.backup2.set(body5.m_sweep);
            body4.advance(f17);
            body5.advance(f17);
            contact3.update(this.m_contactManager.m_contactListener);
            contact3.m_flags &= -33;
            contact3.m_toiCount += 1.0f;
            if (contact3.isEnabled() && contact3.isTouching()) {
                body4.setAwake(true);
                body5.setAwake(true);
                island.clear();
                island.add(body4);
                island.add(body5);
                island.add(contact3);
                body4.m_flags |= 1;
                body5.m_flags |= 1;
                contact3.m_flags |= 1;
                Body[] bodyArr = this.tempBodies;
                bodyArr[0] = body4;
                bodyArr[1] = body5;
                for (int i18 = 0; i18 < 2; i18++) {
                    Body body6 = this.tempBodies[i18];
                    if (body6.m_type == BodyType.DYNAMIC) {
                        for (ContactEdge contactEdge = body6.m_contactList; contactEdge != null && island.m_bodyCount != island.m_bodyCapacity && island.m_contactCount != island.m_contactCapacity; contactEdge = contactEdge.next) {
                            Contact contact4 = contactEdge.contact;
                            if ((contact4.m_flags & 1) == 0) {
                                Body body7 = contactEdge.other;
                                if (body7.m_type != BodyType.DYNAMIC || body6.isBullet() || body7.isBullet()) {
                                    boolean z26 = contact4.m_fixtureA.m_isSensor;
                                    boolean z27 = contact4.m_fixtureB.m_isSensor;
                                    if (!z26 && !z27) {
                                        this.backup1.set(body7.m_sweep);
                                        if ((body7.m_flags & 1) == 0) {
                                            body7.advance(f17);
                                        }
                                        contact4.update(this.m_contactManager.m_contactListener);
                                        if (!contact4.isEnabled()) {
                                            body7.m_sweep.set(this.backup1);
                                            body7.synchronizeTransform();
                                        } else if (!contact4.isTouching()) {
                                            body7.m_sweep.set(this.backup1);
                                            body7.synchronizeTransform();
                                        } else {
                                            contact4.m_flags |= 1;
                                            island.add(contact4);
                                            int i19 = body7.m_flags;
                                            if ((i19 & 1) == 0) {
                                                body7.m_flags = i19 | 1;
                                                if (body7.m_type != BodyType.STATIC) {
                                                    body7.setAwake(true);
                                                }
                                                island.add(body7);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                TimeStep timeStep2 = this.subStep;
                float f27 = (1.0f - f17) * timeStep.f423654dt;
                timeStep2.f423654dt = f27;
                timeStep2.inv_dt = 1.0f / f27;
                timeStep2.dtRatio = 1.0f;
                timeStep2.positionIterations = 20;
                timeStep2.velocityIterations = timeStep.velocityIterations;
                timeStep2.warmStarting = false;
                island.solveTOI(timeStep2, body4.m_islandIndex, body5.m_islandIndex);
                for (int i26 = 0; i26 < island.m_bodyCount; i26++) {
                    Body body8 = island.m_bodies[i26];
                    body8.m_flags &= -2;
                    if (body8.m_type == BodyType.DYNAMIC) {
                        body8.synchronizeFixtures();
                        for (ContactEdge contactEdge2 = body8.m_contactList; contactEdge2 != null; contactEdge2 = contactEdge2.next) {
                            contactEdge2.contact.m_flags &= -34;
                        }
                    }
                }
                this.m_contactManager.findNewContacts();
                if (this.m_subStepping) {
                    this.m_stepComplete = false;
                    return;
                }
                i16 = i17;
            } else {
                contact3.setEnabled(false);
                body4.m_sweep.set(this.backup1);
                body5.m_sweep.set(this.backup2);
                body4.synchronizeTransform();
                body5.synchronizeTransform();
                i16 = i17;
            }
        }
    }

    public void clearForces() {
        for (Body body = this.m_bodyList; body != null; body = body.getNext()) {
            body.m_force.setZero();
            body.m_torque = 0.0f;
        }
    }

    public Body createBody(BodyDef bodyDef) {
        if (isLocked()) {
            return null;
        }
        Body body = new Body(bodyDef, this);
        body.m_prev = null;
        Body body2 = this.m_bodyList;
        body.m_next = body2;
        if (body2 != null) {
            body2.m_prev = body;
        }
        this.m_bodyList = body;
        this.m_bodyCount++;
        return body;
    }

    public Joint createJoint(JointDef jointDef) {
        if (isLocked()) {
            return null;
        }
        Joint create = Joint.create(this, jointDef);
        create.m_prev = null;
        Joint joint = this.m_jointList;
        create.m_next = joint;
        if (joint != null) {
            joint.m_prev = create;
        }
        this.m_jointList = create;
        this.m_jointCount++;
        JointEdge jointEdge = create.m_edgeA;
        jointEdge.joint = create;
        jointEdge.other = create.getBodyB();
        JointEdge jointEdge2 = create.m_edgeA;
        jointEdge2.prev = null;
        jointEdge2.next = create.getBodyA().m_jointList;
        if (create.getBodyA().m_jointList != null) {
            create.getBodyA().m_jointList.prev = create.m_edgeA;
        }
        create.getBodyA().m_jointList = create.m_edgeA;
        JointEdge jointEdge3 = create.m_edgeB;
        jointEdge3.joint = create;
        jointEdge3.other = create.getBodyA();
        JointEdge jointEdge4 = create.m_edgeB;
        jointEdge4.prev = null;
        jointEdge4.next = create.getBodyB().m_jointList;
        if (create.getBodyB().m_jointList != null) {
            create.getBodyB().m_jointList.prev = create.m_edgeB;
        }
        create.getBodyB().m_jointList = create.m_edgeB;
        Body body = jointDef.bodyA;
        Body body2 = jointDef.bodyB;
        if (!jointDef.collideConnected) {
            for (ContactEdge contactList = body2.getContactList(); contactList != null; contactList = contactList.next) {
                if (contactList.other == body) {
                    contactList.contact.flagForFiltering();
                }
            }
        }
        return create;
    }

    public void destroyBody(Body body) {
        if (isLocked()) {
            return;
        }
        JointEdge jointEdge = body.m_jointList;
        while (jointEdge != null) {
            JointEdge jointEdge2 = jointEdge.next;
            DestructionListener destructionListener = this.m_destructionListener;
            if (destructionListener != null) {
                destructionListener.sayGoodbye(jointEdge.joint);
            }
            destroyJoint(jointEdge.joint);
            body.m_jointList = jointEdge2;
            jointEdge = jointEdge2;
        }
        body.m_jointList = null;
        ContactEdge contactEdge = body.m_contactList;
        while (contactEdge != null) {
            ContactEdge contactEdge2 = contactEdge.next;
            this.m_contactManager.destroy(contactEdge.contact);
            contactEdge = contactEdge2;
        }
        body.m_contactList = null;
        Fixture fixture = body.m_fixtureList;
        while (fixture != null) {
            Fixture fixture2 = fixture.m_next;
            DestructionListener destructionListener2 = this.m_destructionListener;
            if (destructionListener2 != null) {
                destructionListener2.sayGoodbye(fixture);
            }
            fixture.destroyProxies(this.m_contactManager.m_broadPhase);
            fixture.destroy();
            body.m_fixtureList = fixture2;
            body.m_fixtureCount--;
            fixture = fixture2;
        }
        body.m_fixtureList = null;
        body.m_fixtureCount = 0;
        Body body2 = body.m_prev;
        if (body2 != null) {
            body2.m_next = body.m_next;
        }
        Body body3 = body.m_next;
        if (body3 != null) {
            body3.m_prev = body2;
        }
        if (body == this.m_bodyList) {
            this.m_bodyList = body3;
        }
        this.m_bodyCount--;
    }

    public void destroyJoint(Joint joint) {
        if (isLocked()) {
            return;
        }
        boolean collideConnected = joint.getCollideConnected();
        Joint joint2 = joint.m_prev;
        if (joint2 != null) {
            joint2.m_next = joint.m_next;
        }
        Joint joint3 = joint.m_next;
        if (joint3 != null) {
            joint3.m_prev = joint2;
        }
        if (joint == this.m_jointList) {
            this.m_jointList = joint3;
        }
        Body bodyA = joint.getBodyA();
        Body bodyB = joint.getBodyB();
        bodyA.setAwake(true);
        bodyB.setAwake(true);
        JointEdge jointEdge = joint.m_edgeA;
        JointEdge jointEdge2 = jointEdge.prev;
        if (jointEdge2 != null) {
            jointEdge2.next = jointEdge.next;
        }
        JointEdge jointEdge3 = jointEdge.next;
        if (jointEdge3 != null) {
            jointEdge3.prev = jointEdge2;
        }
        if (jointEdge == bodyA.m_jointList) {
            bodyA.m_jointList = jointEdge3;
        }
        jointEdge.prev = null;
        jointEdge.next = null;
        JointEdge jointEdge4 = joint.m_edgeB;
        JointEdge jointEdge5 = jointEdge4.prev;
        if (jointEdge5 != null) {
            jointEdge5.next = jointEdge4.next;
        }
        JointEdge jointEdge6 = jointEdge4.next;
        if (jointEdge6 != null) {
            jointEdge6.prev = jointEdge5;
        }
        if (jointEdge4 == bodyB.m_jointList) {
            bodyB.m_jointList = jointEdge6;
        }
        jointEdge4.prev = null;
        jointEdge4.next = null;
        Joint.destroy(joint);
        this.m_jointCount--;
        if (!collideConnected) {
            for (ContactEdge contactList = bodyB.getContactList(); contactList != null; contactList = contactList.next) {
                if (contactList.other == bodyA) {
                    contactList.contact.flagForFiltering();
                }
            }
        }
    }

    public void drawDebugData() {
        DebugDraw debugDraw = this.m_debugDraw;
        if (debugDraw == null) {
            return;
        }
        int flags = debugDraw.getFlags();
        if ((flags & 1) == 1) {
            for (Body body = this.m_bodyList; body != null; body = body.getNext()) {
                this.f423657xf.set(body.getTransform());
                for (Fixture fixtureList = body.getFixtureList(); fixtureList != null; fixtureList = fixtureList.getNext()) {
                    if (!body.isActive()) {
                        this.color.set(0.5f, 0.5f, 0.3f);
                        drawShape(fixtureList, this.f423657xf, this.color);
                    } else if (body.getType() == BodyType.STATIC) {
                        this.color.set(0.5f, 0.9f, 0.3f);
                        drawShape(fixtureList, this.f423657xf, this.color);
                    } else if (body.getType() == BodyType.KINEMATIC) {
                        this.color.set(0.5f, 0.5f, 0.9f);
                        drawShape(fixtureList, this.f423657xf, this.color);
                    } else if (!body.isAwake()) {
                        this.color.set(0.5f, 0.5f, 0.5f);
                        drawShape(fixtureList, this.f423657xf, this.color);
                    } else {
                        this.color.set(0.9f, 0.7f, 0.7f);
                        drawShape(fixtureList, this.f423657xf, this.color);
                    }
                }
            }
        }
        if ((flags & 2) == 2) {
            for (Joint joint = this.m_jointList; joint != null; joint = joint.getNext()) {
                drawJoint(joint);
            }
        }
        if ((flags & 8) == 8) {
            this.color.set(0.3f, 0.9f, 0.9f);
            for (Contact contact = this.m_contactManager.m_contactList; contact != null; contact = contact.getNext()) {
                Fixture fixtureA = contact.getFixtureA();
                Fixture fixtureB = contact.getFixtureB();
                fixtureA.getAABB(contact.getChildIndexA()).getCenterToOut(this.cA);
                fixtureB.getAABB(contact.getChildIndexB()).getCenterToOut(this.cB);
                this.m_debugDraw.drawSegment(this.cA, this.cB, this.color);
            }
        }
        if ((flags & 4) == 4) {
            this.color.set(0.9f, 0.3f, 0.9f);
            for (Body body2 = this.m_bodyList; body2 != null; body2 = body2.getNext()) {
                if (body2.isActive()) {
                    for (Fixture fixtureList2 = body2.getFixtureList(); fixtureList2 != null; fixtureList2 = fixtureList2.getNext()) {
                        for (int i3 = 0; i3 < fixtureList2.m_proxyCount; i3++) {
                            AABB fatAABB = this.m_contactManager.m_broadPhase.getFatAABB(fixtureList2.m_proxies[i3].proxyId);
                            Vec2[] vec2Arr = this.avs.get(4);
                            Vec2 vec2 = vec2Arr[0];
                            Vec2 vec22 = fatAABB.lowerBound;
                            vec2.set(vec22.f423649x, vec22.f423650y);
                            vec2Arr[1].set(fatAABB.upperBound.f423649x, fatAABB.lowerBound.f423650y);
                            Vec2 vec23 = vec2Arr[2];
                            Vec2 vec24 = fatAABB.upperBound;
                            vec23.set(vec24.f423649x, vec24.f423650y);
                            vec2Arr[3].set(fatAABB.lowerBound.f423649x, fatAABB.upperBound.f423650y);
                            this.m_debugDraw.drawPolygon(vec2Arr, 4, this.color);
                        }
                    }
                }
            }
        }
        if ((flags & 16) == 16) {
            for (Body body3 = this.m_bodyList; body3 != null; body3 = body3.getNext()) {
                this.f423657xf.set(body3.getTransform());
                this.f423657xf.f423647p.set(body3.getWorldCenter());
                this.m_debugDraw.drawTransform(this.f423657xf);
            }
        }
        if ((flags & 32) == 32) {
            this.m_contactManager.m_broadPhase.drawTree(this.m_debugDraw);
        }
    }

    public boolean getAutoClearForces() {
        if ((this.m_flags & 4) == 4) {
            return true;
        }
        return false;
    }

    public int getBodyCount() {
        return this.m_bodyCount;
    }

    public Body getBodyList() {
        return this.m_bodyList;
    }

    public int getContactCount() {
        return this.m_contactManager.m_contactCount;
    }

    public Contact getContactList() {
        return this.m_contactManager.m_contactList;
    }

    public ContactManager getContactManager() {
        return this.m_contactManager;
    }

    public Vec2 getGravity() {
        return this.m_gravity;
    }

    public int getJointCount() {
        return this.m_jointCount;
    }

    public Joint getJointList() {
        return this.m_jointList;
    }

    public IWorldPool getPool() {
        return this.pool;
    }

    public Profile getProfile() {
        return this.m_profile;
    }

    public int getProxyCount() {
        return this.m_contactManager.m_broadPhase.getProxyCount();
    }

    public int getTreeBalance() {
        return this.m_contactManager.m_broadPhase.getTreeBalance();
    }

    public int getTreeHeight() {
        return this.m_contactManager.m_broadPhase.getTreeHeight();
    }

    public float getTreeQuality() {
        return this.m_contactManager.m_broadPhase.getTreeQuality();
    }

    public boolean isAllowSleep() {
        return this.m_allowSleep;
    }

    public boolean isContinuousPhysics() {
        return this.m_continuousPhysics;
    }

    public boolean isLocked() {
        if ((this.m_flags & 2) == 2) {
            return true;
        }
        return false;
    }

    public boolean isSleepingAllowed() {
        return this.m_allowSleep;
    }

    public boolean isSubStepping() {
        return this.m_subStepping;
    }

    public boolean isWarmStarting() {
        return this.m_warmStarting;
    }

    public Contact popContact(Fixture fixture, int i3, Fixture fixture2, int i16) {
        ContactRegister contactRegister = this.contactStacks[fixture.getType().ordinal()][fixture2.getType().ordinal()];
        IDynamicStack<Contact> iDynamicStack = contactRegister.creator;
        if (iDynamicStack != null) {
            if (contactRegister.primary) {
                Contact pop = iDynamicStack.pop();
                pop.init(fixture, i3, fixture2, i16);
                return pop;
            }
            Contact pop2 = iDynamicStack.pop();
            pop2.init(fixture2, i16, fixture, i3);
            return pop2;
        }
        return null;
    }

    public void pushContact(Contact contact) {
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();
        if (contact.m_manifold.pointCount > 0 && !fixtureA.isSensor() && !fixtureB.isSensor()) {
            fixtureA.getBody().setAwake(true);
            fixtureB.getBody().setAwake(true);
        }
        this.contactStacks[fixtureA.getType().ordinal()][fixtureB.getType().ordinal()].creator.push(contact);
    }

    public void queryAABB(QueryCallback queryCallback, AABB aabb) {
        WorldQueryWrapper worldQueryWrapper = this.wqwrapper;
        BroadPhase broadPhase = this.m_contactManager.m_broadPhase;
        worldQueryWrapper.broadPhase = broadPhase;
        worldQueryWrapper.callback = queryCallback;
        broadPhase.query(worldQueryWrapper, aabb);
    }

    public void raycast(RayCastCallback rayCastCallback, Vec2 vec2, Vec2 vec22) {
        WorldRayCastWrapper worldRayCastWrapper = this.wrcwrapper;
        worldRayCastWrapper.broadPhase = this.m_contactManager.m_broadPhase;
        worldRayCastWrapper.callback = rayCastCallback;
        RayCastInput rayCastInput = this.input;
        rayCastInput.maxFraction = 1.0f;
        rayCastInput.f423628p1.set(vec2);
        this.input.f423629p2.set(vec22);
        this.m_contactManager.m_broadPhase.raycast(this.wrcwrapper, this.input);
    }

    public void setAllowSleep(boolean z16) {
        if (z16 == this.m_allowSleep) {
            return;
        }
        this.m_allowSleep = z16;
        if (!z16) {
            for (Body body = this.m_bodyList; body != null; body = body.m_next) {
                body.setAwake(true);
            }
        }
    }

    public void setAutoClearForces(boolean z16) {
        if (z16) {
            this.m_flags |= 4;
        } else {
            this.m_flags &= -5;
        }
    }

    public void setContactFilter(ContactFilter contactFilter) {
        this.m_contactManager.m_contactFilter = contactFilter;
    }

    public void setContactListener(ContactListener contactListener) {
        this.m_contactManager.m_contactListener = contactListener;
    }

    public void setContinuousPhysics(boolean z16) {
        this.m_continuousPhysics = z16;
    }

    public void setDebugDraw(DebugDraw debugDraw) {
        this.m_debugDraw = debugDraw;
    }

    public void setDestructionListener(DestructionListener destructionListener) {
        this.m_destructionListener = destructionListener;
    }

    public void setGravity(Vec2 vec2) {
        this.m_gravity.set(vec2);
    }

    public void setSleepingAllowed(boolean z16) {
        this.m_allowSleep = z16;
    }

    public void setSubStepping(boolean z16) {
        this.m_subStepping = z16;
    }

    public void setWarmStarting(boolean z16) {
        this.m_warmStarting = z16;
    }

    public void step(float f16, int i3, int i16) {
        this.stepTimer.reset();
        if ((this.m_flags & 1) == 1) {
            this.m_contactManager.findNewContacts();
            this.m_flags &= -2;
        }
        this.m_flags |= 2;
        TimeStep timeStep = this.step;
        timeStep.f423654dt = f16;
        timeStep.velocityIterations = i3;
        timeStep.positionIterations = i16;
        if (f16 > 0.0f) {
            timeStep.inv_dt = 1.0f / f16;
        } else {
            timeStep.inv_dt = 0.0f;
        }
        timeStep.dtRatio = this.m_inv_dt0 * f16;
        timeStep.warmStarting = this.m_warmStarting;
        this.tempTimer.reset();
        this.m_contactManager.collide();
        this.m_profile.collide = this.tempTimer.getMilliseconds();
        if (this.m_stepComplete && this.step.f423654dt > 0.0f) {
            this.tempTimer.reset();
            solve(this.step);
            this.m_profile.solve = this.tempTimer.getMilliseconds();
        }
        if (this.m_continuousPhysics && this.step.f423654dt > 0.0f) {
            this.tempTimer.reset();
            solveTOI(this.step);
            this.m_profile.solveTOI = this.tempTimer.getMilliseconds();
        }
        TimeStep timeStep2 = this.step;
        if (timeStep2.f423654dt > 0.0f) {
            this.m_inv_dt0 = timeStep2.inv_dt;
        }
        if ((this.m_flags & 4) == 4) {
            clearForces();
        }
        this.m_flags &= -3;
        this.m_profile.step = this.stepTimer.getMilliseconds();
    }

    public World(Vec2 vec2, IWorldPool iWorldPool) {
        this(vec2, iWorldPool, new DynamicTree());
    }

    public World(Vec2 vec2, IWorldPool iWorldPool, BroadPhaseStrategy broadPhaseStrategy) {
        this.activeContacts = 0;
        this.contactPoolCount = 0;
        Vec2 vec22 = new Vec2();
        this.m_gravity = vec22;
        this.contactStacks = (ContactRegister[][]) Array.newInstance((Class<?>) ContactRegister.class, ShapeType.values().length, ShapeType.values().length);
        this.step = new TimeStep();
        this.stepTimer = new Timer();
        this.tempTimer = new Timer();
        this.color = new Color3f();
        this.f423657xf = new Transform();
        this.cA = new Vec2();
        this.cB = new Vec2();
        this.avs = new Vec2Array();
        this.wqwrapper = new WorldQueryWrapper();
        this.wrcwrapper = new WorldRayCastWrapper();
        this.input = new RayCastInput();
        this.island = new Island();
        this.stack = new Body[10];
        this.islandProfile = new Profile();
        this.broadphaseTimer = new Timer();
        this.toiIsland = new Island();
        this.toiInput = new TimeOfImpact.TOIInput();
        this.toiOutput = new TimeOfImpact.TOIOutput();
        this.subStep = new TimeStep();
        this.tempBodies = new Body[2];
        this.backup1 = new Sweep();
        this.backup2 = new Sweep();
        this.liquidLength = 0.12f;
        this.averageLinearVel = -1.0f;
        this.liquidOffset = new Vec2();
        this.circCenterMoved = new Vec2();
        this.liquidColor = new Color3f(0.4f, 0.4f, 1.0f);
        this.center = new Vec2();
        this.axis = new Vec2();
        this.f423655v1 = new Vec2();
        this.f423656v2 = new Vec2();
        this.tlvertices = new Vec2Array();
        this.pool = iWorldPool;
        this.m_destructionListener = null;
        this.m_debugDraw = null;
        this.m_bodyList = null;
        this.m_jointList = null;
        this.m_bodyCount = 0;
        this.m_jointCount = 0;
        this.m_warmStarting = true;
        this.m_continuousPhysics = true;
        this.m_subStepping = false;
        this.m_stepComplete = true;
        this.m_allowSleep = true;
        vec22.set(vec2);
        this.m_flags = 4;
        this.m_inv_dt0 = 0.0f;
        this.m_contactManager = new ContactManager(this, broadPhaseStrategy);
        this.m_profile = new Profile();
        initializeRegisters();
    }
}
