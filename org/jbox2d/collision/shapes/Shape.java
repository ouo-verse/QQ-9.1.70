package org.jbox2d.collision.shapes;

import org.jbox2d.collision.AABB;
import org.jbox2d.collision.RayCastInput;
import org.jbox2d.collision.RayCastOutput;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class Shape {
    public float m_radius;
    public final ShapeType m_type;

    public Shape(ShapeType shapeType) {
        this.m_type = shapeType;
    }

    @Override // 
    public abstract Shape clone();

    public abstract void computeAABB(AABB aabb, Transform transform, int i3);

    public abstract void computeMass(MassData massData, float f16);

    public abstract int getChildCount();

    public float getRadius() {
        return this.m_radius;
    }

    public ShapeType getType() {
        return this.m_type;
    }

    public abstract boolean raycast(RayCastOutput rayCastOutput, RayCastInput rayCastInput, Transform transform, int i3);

    public void setRadius(float f16) {
        this.m_radius = f16;
    }

    public abstract boolean testPoint(Transform transform, Vec2 vec2);
}
