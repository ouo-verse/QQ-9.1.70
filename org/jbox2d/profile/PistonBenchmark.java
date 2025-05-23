package org.jbox2d.profile;

import org.jbox2d.collision.broadphase.DynamicTree;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.Filter;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.joints.PrismaticJoint;
import org.jbox2d.dynamics.joints.PrismaticJointDef;
import org.jbox2d.dynamics.joints.RevoluteJoint;
import org.jbox2d.dynamics.joints.RevoluteJointDef;
import org.jbox2d.pooling.normal.DefaultWorldPool;

/* loaded from: classes29.dex */
public class PistonBenchmark extends SettingsPerformanceTest {
    public static int frames = 800;
    public static int iters = 5;
    public static int posIters = 3;
    public static float timeStep = 0.016666668f;
    public static int velIters = 8;
    public RevoluteJoint m_joint1;
    public PrismaticJoint m_joint2;
    public World world;

    public PistonBenchmark() {
        super(iters);
    }

    public static void main(String[] strArr) {
        new PistonBenchmark().go();
    }

    @Override // org.jbox2d.profile.BasicPerformanceTest
    public int getFrames(int i3) {
        return frames;
    }

    @Override // org.jbox2d.profile.SettingsPerformanceTest
    public void runBenchmarkWorld() {
        this.world = new World(new Vec2(0.0f, -10.0f), new DefaultWorldPool(100, 10), new DynamicTree());
        Body createBody = this.world.createBody(new BodyDef());
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(5.0f, 100.0f);
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyType.STATIC;
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = polygonShape;
        fixtureDef.density = 0.0f;
        fixtureDef.friction = 0.0f;
        fixtureDef.restitution = 0.8f;
        Filter filter = fixtureDef.filter;
        filter.categoryBits = 4;
        filter.maskBits = 2;
        bodyDef.position.set(-10.01f, 50.0f);
        this.world.createBody(bodyDef).createFixture(fixtureDef);
        bodyDef.position.set(10.01f, 50.0f);
        this.world.createBody(bodyDef).createFixture(fixtureDef);
        FixtureDef fixtureDef2 = new FixtureDef();
        BodyDef bodyDef2 = new BodyDef();
        bodyDef2.type = BodyType.DYNAMIC;
        bodyDef2.position = new Vec2(0.0f, 25.0f);
        Body createBody2 = this.world.createBody(bodyDef2);
        for (int i3 = 0; i3 < 5; i3++) {
            CircleShape circleShape = new CircleShape();
            circleShape.m_radius = 0.5f;
            fixtureDef2.shape = circleShape;
            fixtureDef2.density = 25.0f;
            fixtureDef2.friction = 0.1f;
            fixtureDef2.restitution = 0.9f;
            double d16 = (i3 / 5) * 6.283185307179586d;
            circleShape.m_p.set(((float) Math.cos(d16)) * 4.0f, 4.0f * ((float) Math.sin(d16)));
            createBody2.createFixture(fixtureDef2);
        }
        RevoluteJointDef revoluteJointDef = new RevoluteJointDef();
        revoluteJointDef.initialize(createBody2, createBody, createBody2.getPosition());
        revoluteJointDef.motorSpeed = 3.1415927f;
        revoluteJointDef.maxMotorTorque = 1000000.0f;
        revoluteJointDef.enableMotor = true;
        this.world.createJoint(revoluteJointDef);
        PolygonShape polygonShape2 = new PolygonShape();
        polygonShape2.setAsBox(0.5f, 2.0f);
        BodyDef bodyDef3 = new BodyDef();
        BodyType bodyType = BodyType.DYNAMIC;
        bodyDef3.type = bodyType;
        bodyDef3.position.set(0.0f, 7.0f);
        Body createBody3 = this.world.createBody(bodyDef3);
        createBody3.createFixture(polygonShape2, 2.0f);
        RevoluteJointDef revoluteJointDef2 = new RevoluteJointDef();
        revoluteJointDef2.initialize(createBody, createBody3, new Vec2(0.0f, 5.0f));
        revoluteJointDef2.motorSpeed = 3.1415927f;
        revoluteJointDef2.maxMotorTorque = 20000.0f;
        revoluteJointDef2.enableMotor = true;
        this.m_joint1 = (RevoluteJoint) this.world.createJoint(revoluteJointDef2);
        PolygonShape polygonShape3 = new PolygonShape();
        polygonShape3.setAsBox(0.5f, 4.0f);
        BodyDef bodyDef4 = new BodyDef();
        bodyDef4.type = bodyType;
        bodyDef4.position.set(0.0f, 13.0f);
        Body createBody4 = this.world.createBody(bodyDef4);
        createBody4.createFixture(polygonShape3, 2.0f);
        RevoluteJointDef revoluteJointDef3 = new RevoluteJointDef();
        revoluteJointDef3.initialize(createBody3, createBody4, new Vec2(0.0f, 9.0f));
        revoluteJointDef3.enableMotor = false;
        this.world.createJoint(revoluteJointDef3);
        PolygonShape polygonShape4 = new PolygonShape();
        polygonShape4.setAsBox(7.0f, 2.0f);
        BodyDef bodyDef5 = new BodyDef();
        bodyDef5.type = bodyType;
        bodyDef5.position.set(0.0f, 17.0f);
        Body createBody5 = this.world.createBody(bodyDef5);
        FixtureDef fixtureDef3 = new FixtureDef();
        fixtureDef3.shape = polygonShape4;
        fixtureDef3.density = 2.0f;
        Filter filter2 = fixtureDef3.filter;
        filter2.categoryBits = 1;
        filter2.maskBits = 2;
        createBody5.createFixture(fixtureDef3);
        RevoluteJointDef revoluteJointDef4 = new RevoluteJointDef();
        revoluteJointDef4.initialize(createBody4, createBody5, new Vec2(0.0f, 17.0f));
        this.world.createJoint(revoluteJointDef4);
        PrismaticJointDef prismaticJointDef = new PrismaticJointDef();
        prismaticJointDef.initialize(createBody, createBody5, new Vec2(0.0f, 17.0f), new Vec2(0.0f, 1.0f));
        prismaticJointDef.maxMotorForce = 1000.0f;
        prismaticJointDef.enableMotor = true;
        this.m_joint2 = (PrismaticJoint) this.world.createJoint(prismaticJointDef);
        PolygonShape polygonShape5 = new PolygonShape();
        BodyDef bodyDef6 = new BodyDef();
        bodyDef6.type = bodyType;
        FixtureDef fixtureDef4 = new FixtureDef();
        for (int i16 = 0; i16 < 100; i16++) {
            polygonShape5.setAsBox(0.4f, 0.3f);
            bodyDef6.position.set(-1.0f, i16 + 23.0f);
            bodyDef6.bullet = false;
            Body createBody6 = this.world.createBody(bodyDef6);
            fixtureDef4.shape = polygonShape5;
            fixtureDef4.density = 0.1f;
            Filter filter3 = fixtureDef4.filter;
            filter3.categoryBits = 2;
            filter3.maskBits = 7;
            createBody6.createFixture(fixtureDef4);
        }
        CircleShape circleShape2 = new CircleShape();
        circleShape2.m_radius = 0.36f;
        for (int i17 = 0; i17 < 100; i17++) {
            bodyDef6.position.set(1.0f, i17 + 23.0f);
            bodyDef6.bullet = false;
            fixtureDef4.shape = circleShape2;
            fixtureDef4.density = 2.0f;
            Filter filter4 = fixtureDef4.filter;
            filter4.categoryBits = 2;
            filter4.maskBits = 7;
            this.world.createBody(bodyDef6).createFixture(fixtureDef4);
        }
        Vec2[] vec2Arr = new Vec2[6];
        float f16 = 0.0f;
        for (int i18 = 0; i18 < 6; i18++) {
            vec2Arr[i18] = new Vec2(MathUtils.cos(f16) * 0.3f, MathUtils.sin(f16) * 0.3f);
            f16 += 1.0471976f;
        }
        PolygonShape polygonShape6 = new PolygonShape();
        polygonShape6.set(vec2Arr, 6);
        for (int i19 = 0; i19 < 100; i19++) {
            bodyDef6.position.set(0.0f, i19 + 23.0f);
            bodyDef6.type = BodyType.DYNAMIC;
            bodyDef6.fixedRotation = true;
            bodyDef6.bullet = false;
            fixtureDef4.shape = polygonShape6;
            fixtureDef4.density = 1.0f;
            Filter filter5 = fixtureDef4.filter;
            filter5.categoryBits = 2;
            filter5.maskBits = 7;
            this.world.createBody(bodyDef6).createFixture(fixtureDef4);
        }
        for (int i26 = 0; i26 < frames; i26++) {
            this.world.step(timeStep, posIters, velIters);
        }
    }
}
