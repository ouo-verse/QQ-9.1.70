package org.jbox2d.dynamics.joints;

import java.util.ArrayList;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.SolverData;
import org.jbox2d.dynamics.TimeStep;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.contacts.Position;
import org.jbox2d.dynamics.contacts.Velocity;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ConstantVolumeJoint extends Joint {
    private final Body[] bodies;
    private DistanceJoint[] distanceJoints;
    private float m_impulse;
    private Vec2[] normals;
    private float[] targetLengths;
    private float targetVolume;
    private World world;

    public ConstantVolumeJoint(World world, ConstantVolumeJointDef constantVolumeJointDef) {
        super(world.getPool(), constantVolumeJointDef);
        int i3;
        int i16;
        this.m_impulse = 0.0f;
        this.world = world;
        if (constantVolumeJointDef.bodies.size() > 2) {
            int i17 = 0;
            Body[] bodyArr = (Body[]) constantVolumeJointDef.bodies.toArray(new Body[0]);
            this.bodies = bodyArr;
            this.targetLengths = new float[bodyArr.length];
            int i18 = 0;
            while (true) {
                if (i18 >= this.targetLengths.length) {
                    break;
                }
                if (i18 == r1.length - 1) {
                    i16 = 0;
                } else {
                    i16 = i18 + 1;
                }
                this.targetLengths[i18] = this.bodies[i18].getWorldCenter().sub(this.bodies[i16].getWorldCenter()).length();
                i18++;
            }
            this.targetVolume = getBodyArea();
            ArrayList<DistanceJoint> arrayList = constantVolumeJointDef.joints;
            if (arrayList != null && arrayList.size() != constantVolumeJointDef.bodies.size()) {
                throw new IllegalArgumentException("Incorrect joint definition.  Joints have to correspond to the bodies");
            }
            ArrayList<DistanceJoint> arrayList2 = constantVolumeJointDef.joints;
            if (arrayList2 == null) {
                DistanceJointDef distanceJointDef = new DistanceJointDef();
                this.distanceJoints = new DistanceJoint[this.bodies.length];
                int i19 = 0;
                while (true) {
                    if (i19 >= this.targetLengths.length) {
                        break;
                    }
                    if (i19 == r2.length - 1) {
                        i3 = 0;
                    } else {
                        i3 = i19 + 1;
                    }
                    distanceJointDef.frequencyHz = constantVolumeJointDef.frequencyHz;
                    distanceJointDef.dampingRatio = constantVolumeJointDef.dampingRatio;
                    distanceJointDef.collideConnected = constantVolumeJointDef.collideConnected;
                    Body[] bodyArr2 = this.bodies;
                    Body body = bodyArr2[i19];
                    distanceJointDef.initialize(body, bodyArr2[i3], body.getWorldCenter(), this.bodies[i3].getWorldCenter());
                    this.distanceJoints[i19] = (DistanceJoint) this.world.createJoint(distanceJointDef);
                    i19++;
                }
            } else {
                this.distanceJoints = (DistanceJoint[]) arrayList2.toArray(new DistanceJoint[0]);
            }
            this.normals = new Vec2[this.bodies.length];
            while (true) {
                Vec2[] vec2Arr = this.normals;
                if (i17 < vec2Arr.length) {
                    vec2Arr[i17] = new Vec2();
                    i17++;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("You cannot create a constant volume joint with less than three bodies.");
        }
    }

    private boolean constrainEdges(Position[] positionArr) {
        int i3;
        int i16;
        float f16 = 0.0f;
        int i17 = 0;
        while (true) {
            Body[] bodyArr = this.bodies;
            if (i17 >= bodyArr.length) {
                break;
            }
            if (i17 == bodyArr.length - 1) {
                i16 = 0;
            } else {
                i16 = i17 + 1;
            }
            Vec2 vec2 = positionArr[bodyArr[i16].m_islandIndex].f423665c;
            float f17 = vec2.f423649x;
            Vec2 vec22 = positionArr[bodyArr[i17].m_islandIndex].f423665c;
            float f18 = f17 - vec22.f423649x;
            float f19 = vec2.f423650y - vec22.f423650y;
            float sqrt = MathUtils.sqrt((f18 * f18) + (f19 * f19));
            if (sqrt < 1.1920929E-7f) {
                sqrt = 1.0f;
            }
            Vec2 vec23 = this.normals[i17];
            vec23.f423649x = f19 / sqrt;
            vec23.f423650y = (-f18) / sqrt;
            f16 += sqrt;
            i17++;
        }
        Vec2 popVec2 = this.pool.popVec2();
        float solverArea = ((this.targetVolume - getSolverArea(positionArr)) * 0.5f) / f16;
        int i18 = 0;
        boolean z16 = true;
        while (true) {
            Body[] bodyArr2 = this.bodies;
            if (i18 < bodyArr2.length) {
                if (i18 == bodyArr2.length - 1) {
                    i3 = 0;
                } else {
                    i3 = i18 + 1;
                }
                Vec2[] vec2Arr = this.normals;
                Vec2 vec24 = vec2Arr[i18];
                float f26 = vec24.f423649x;
                Vec2 vec25 = vec2Arr[i3];
                popVec2.set((f26 + vec25.f423649x) * solverArea, (vec24.f423650y + vec25.f423650y) * solverArea);
                float lengthSquared = popVec2.lengthSquared();
                if (lengthSquared > 0.040000003f) {
                    popVec2.mulLocal(0.2f / MathUtils.sqrt(lengthSquared));
                }
                if (lengthSquared > 2.5E-5f) {
                    z16 = false;
                }
                Vec2 vec26 = positionArr[this.bodies[i3].m_islandIndex].f423665c;
                vec26.f423649x += popVec2.f423649x;
                vec26.f423650y += popVec2.f423650y;
                i18++;
            } else {
                this.pool.pushVec2(1);
                return z16;
            }
        }
    }

    private float getBodyArea() {
        int i3;
        float f16 = 0.0f;
        int i16 = 0;
        while (true) {
            Body[] bodyArr = this.bodies;
            if (i16 < bodyArr.length - 1) {
                if (i16 == bodyArr.length - 1) {
                    i3 = 0;
                } else {
                    i3 = i16 + 1;
                }
                f16 += (bodyArr[i16].getWorldCenter().f423649x * this.bodies[i3].getWorldCenter().f423650y) - (this.bodies[i3].getWorldCenter().f423649x * this.bodies[i16].getWorldCenter().f423650y);
                i16++;
            } else {
                return f16 * 0.5f;
            }
        }
    }

    private float getSolverArea(Position[] positionArr) {
        int i3;
        float f16 = 0.0f;
        int i16 = 0;
        while (true) {
            Body[] bodyArr = this.bodies;
            if (i16 < bodyArr.length) {
                if (i16 == bodyArr.length - 1) {
                    i3 = 0;
                } else {
                    i3 = i16 + 1;
                }
                Vec2 vec2 = positionArr[bodyArr[i16].m_islandIndex].f423665c;
                float f17 = vec2.f423649x;
                Vec2 vec22 = positionArr[bodyArr[i3].m_islandIndex].f423665c;
                f16 += (f17 * vec22.f423650y) - (vec22.f423649x * vec2.f423650y);
                i16++;
            } else {
                return f16 * 0.5f;
            }
        }
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void destructor() {
        int i3 = 0;
        while (true) {
            DistanceJoint[] distanceJointArr = this.distanceJoints;
            if (i3 < distanceJointArr.length) {
                this.world.destroyJoint(distanceJointArr[i3]);
                i3++;
            } else {
                return;
            }
        }
    }

    public Body[] getBodies() {
        return this.bodies;
    }

    public DistanceJoint[] getJoints() {
        return this.distanceJoints;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public float getReactionTorque(float f16) {
        return 0.0f;
    }

    public void inflate(float f16) {
        this.targetVolume *= f16;
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void initVelocityConstraints(SolverData solverData) {
        int i3;
        int i16;
        Velocity[] velocityArr = solverData.velocities;
        Position[] positionArr = solverData.positions;
        Vec2[] vec2Array = this.pool.getVec2Array(this.bodies.length);
        int i17 = 0;
        int i18 = 0;
        while (true) {
            Body[] bodyArr = this.bodies;
            if (i18 >= bodyArr.length) {
                break;
            }
            if (i18 == 0) {
                i3 = bodyArr.length - 1;
            } else {
                i3 = i18 - 1;
            }
            if (i18 == bodyArr.length - 1) {
                i16 = 0;
            } else {
                i16 = i18 + 1;
            }
            vec2Array[i18].set(positionArr[bodyArr[i16].m_islandIndex].f423665c);
            vec2Array[i18].subLocal(positionArr[this.bodies[i3].m_islandIndex].f423665c);
            i18++;
        }
        TimeStep timeStep = solverData.step;
        if (timeStep.warmStarting) {
            this.m_impulse *= timeStep.dtRatio;
            while (true) {
                Body[] bodyArr2 = this.bodies;
                if (i17 < bodyArr2.length) {
                    Body body = bodyArr2[i17];
                    Vec2 vec2 = velocityArr[body.m_islandIndex].f423666v;
                    float f16 = vec2.f423649x;
                    float f17 = body.m_invMass;
                    Vec2 vec22 = vec2Array[i17];
                    float f18 = vec22.f423650y * f17 * 0.5f;
                    float f19 = this.m_impulse;
                    vec2.f423649x = f16 + (f18 * f19);
                    vec2.f423650y += f17 * (-vec22.f423649x) * 0.5f * f19;
                    i17++;
                } else {
                    return;
                }
            }
        } else {
            this.m_impulse = 0.0f;
        }
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public boolean solvePositionConstraints(SolverData solverData) {
        return constrainEdges(solverData.positions);
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void solveVelocityConstraints(SolverData solverData) {
        int i3;
        int i16;
        Velocity[] velocityArr = solverData.velocities;
        Position[] positionArr = solverData.positions;
        Vec2[] vec2Array = this.pool.getVec2Array(this.bodies.length);
        float f16 = 0.0f;
        int i17 = 0;
        float f17 = 0.0f;
        int i18 = 0;
        while (true) {
            Body[] bodyArr = this.bodies;
            if (i18 >= bodyArr.length) {
                break;
            }
            if (i18 == 0) {
                i3 = bodyArr.length - 1;
            } else {
                i3 = i18 - 1;
            }
            if (i18 == bodyArr.length - 1) {
                i16 = 0;
            } else {
                i16 = i18 + 1;
            }
            vec2Array[i18].set(positionArr[bodyArr[i16].m_islandIndex].f423665c);
            vec2Array[i18].subLocal(positionArr[this.bodies[i3].m_islandIndex].f423665c);
            f17 += vec2Array[i18].lengthSquared() / this.bodies[i18].getMass();
            f16 += Vec2.cross(velocityArr[this.bodies[i18].m_islandIndex].f423666v, vec2Array[i18]);
            i18++;
        }
        float f18 = (f16 * (-2.0f)) / f17;
        this.m_impulse += f18;
        while (true) {
            Body[] bodyArr2 = this.bodies;
            if (i17 < bodyArr2.length) {
                Body body = bodyArr2[i17];
                Vec2 vec2 = velocityArr[body.m_islandIndex].f423666v;
                float f19 = vec2.f423649x;
                float f26 = body.m_invMass;
                Vec2 vec22 = vec2Array[i17];
                vec2.f423649x = f19 + (vec22.f423650y * f26 * 0.5f * f18);
                vec2.f423650y += f26 * (-vec22.f423649x) * 0.5f * f18;
                i17++;
            } else {
                return;
            }
        }
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getAnchorA(Vec2 vec2) {
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getAnchorB(Vec2 vec2) {
    }

    @Override // org.jbox2d.dynamics.joints.Joint
    public void getReactionForce(float f16, Vec2 vec2) {
    }
}
