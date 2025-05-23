package org.jbox2d.pooling;

import org.jbox2d.collision.AABB;
import org.jbox2d.collision.Collision;
import org.jbox2d.collision.Distance;
import org.jbox2d.collision.TimeOfImpact;
import org.jbox2d.common.Mat22;
import org.jbox2d.common.Mat33;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Vec2;
import org.jbox2d.common.Vec3;
import org.jbox2d.dynamics.contacts.Contact;

/* loaded from: classes29.dex */
public interface IWorldPool {
    IDynamicStack<Contact> getChainCircleContactStack();

    IDynamicStack<Contact> getChainPolyContactStack();

    IDynamicStack<Contact> getCircleContactStack();

    Collision getCollision();

    Distance getDistance();

    IDynamicStack<Contact> getEdgeCircleContactStack();

    IDynamicStack<Contact> getEdgePolyContactStack();

    float[] getFloatArray(int i3);

    int[] getIntArray(int i3);

    IDynamicStack<Contact> getPolyCircleContactStack();

    IDynamicStack<Contact> getPolyContactStack();

    TimeOfImpact getTimeOfImpact();

    Vec2[] getVec2Array(int i3);

    AABB popAABB();

    AABB[] popAABB(int i3);

    Mat22 popMat22();

    Mat22[] popMat22(int i3);

    Mat33 popMat33();

    Rot popRot();

    Vec2 popVec2();

    Vec2[] popVec2(int i3);

    Vec3 popVec3();

    Vec3[] popVec3(int i3);

    void pushAABB(int i3);

    void pushMat22(int i3);

    void pushMat33(int i3);

    void pushRot(int i3);

    void pushVec2(int i3);

    void pushVec3(int i3);
}
