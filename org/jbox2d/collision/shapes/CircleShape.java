package org.jbox2d.collision.shapes;

import org.jbox2d.collision.AABB;
import org.jbox2d.collision.RayCastInput;
import org.jbox2d.collision.RayCastOutput;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CircleShape extends Shape {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final Vec2 m_p;

    public CircleShape() {
        super(ShapeType.CIRCLE);
        this.m_p = new Vec2();
        this.m_radius = 0.0f;
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public final void computeAABB(AABB aabb, Transform transform, int i3) {
        Rot rot = transform.f423648q;
        Vec2 vec2 = transform.f423647p;
        float f16 = rot.f423641c;
        Vec2 vec22 = this.m_p;
        float f17 = vec22.f423649x;
        float f18 = rot.f423642s;
        float f19 = vec22.f423650y;
        float f26 = ((f16 * f17) - (f18 * f19)) + vec2.f423649x;
        float f27 = (f18 * f17) + (f16 * f19) + vec2.f423650y;
        Vec2 vec23 = aabb.lowerBound;
        float f28 = this.m_radius;
        vec23.f423649x = f26 - f28;
        vec23.f423650y = f27 - f28;
        Vec2 vec24 = aabb.upperBound;
        vec24.f423649x = f26 + f28;
        vec24.f423650y = f27 + f28;
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public final void computeMass(MassData massData, float f16) {
        float f17 = this.m_radius;
        float f18 = f16 * 3.1415927f * f17 * f17;
        massData.mass = f18;
        Vec2 vec2 = massData.center;
        Vec2 vec22 = this.m_p;
        vec2.f423649x = vec22.f423649x;
        vec2.f423650y = vec22.f423650y;
        float f19 = 0.5f * f17 * f17;
        float f26 = vec22.f423649x;
        float f27 = vec22.f423650y;
        massData.I = f18 * (f19 + (f26 * f26) + (f27 * f27));
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public final int getChildCount() {
        return 1;
    }

    public final int getSupport(Vec2 vec2) {
        return 0;
    }

    public final Vec2 getSupportVertex(Vec2 vec2) {
        return this.m_p;
    }

    public final Vec2 getVertex(int i3) {
        return this.m_p;
    }

    public final int getVertexCount() {
        return 1;
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public final boolean raycast(RayCastOutput rayCastOutput, RayCastInput rayCastInput, Transform transform, int i3) {
        Vec2 vec2 = rayCastInput.f423628p1;
        Vec2 vec22 = rayCastInput.f423629p2;
        Rot rot = transform.f423648q;
        Vec2 vec23 = transform.f423647p;
        float f16 = rot.f423641c;
        Vec2 vec24 = this.m_p;
        float f17 = vec24.f423649x;
        float f18 = rot.f423642s;
        float f19 = vec24.f423650y;
        float f26 = ((f16 * f17) - (f18 * f19)) + vec23.f423649x;
        float f27 = (f18 * f17) + (f16 * f19) + vec23.f423650y;
        float f28 = vec2.f423649x;
        float f29 = f28 - f26;
        float f36 = vec2.f423650y;
        float f37 = f36 - f27;
        float f38 = this.m_radius;
        float f39 = ((f29 * f29) + (f37 * f37)) - (f38 * f38);
        float f46 = vec22.f423649x - f28;
        float f47 = vec22.f423650y - f36;
        float f48 = (f29 * f46) + (f37 * f47);
        float f49 = (f46 * f46) + (f47 * f47);
        float f56 = (f48 * f48) - (f39 * f49);
        if (f56 >= 0.0f && f49 >= 1.1920929E-7f) {
            float f57 = -(f48 + MathUtils.sqrt(f56));
            if (0.0f <= f57 && f57 <= rayCastInput.maxFraction * f49) {
                float f58 = f57 / f49;
                rayCastOutput.fraction = f58;
                Vec2 vec25 = rayCastOutput.normal;
                vec25.f423649x = (f46 * f58) + f29;
                vec25.f423650y = (f47 * f58) + f37;
                vec25.normalize();
                return true;
            }
        }
        return false;
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public final boolean testPoint(Transform transform, Vec2 vec2) {
        Rot rot = transform.f423648q;
        Vec2 vec22 = transform.f423647p;
        float f16 = rot.f423641c;
        Vec2 vec23 = this.m_p;
        float f17 = vec23.f423649x;
        float f18 = rot.f423642s;
        float f19 = vec23.f423650y;
        float f26 = -((((f16 * f17) - (f18 * f19)) + vec22.f423649x) - vec2.f423649x);
        float f27 = -((((f18 * f17) + (f16 * f19)) + vec22.f423650y) - vec2.f423650y);
        float f28 = (f26 * f26) + (f27 * f27);
        float f29 = this.m_radius;
        if (f28 <= f29 * f29) {
            return true;
        }
        return false;
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public final Shape clone() {
        CircleShape circleShape = new CircleShape();
        Vec2 vec2 = circleShape.m_p;
        Vec2 vec22 = this.m_p;
        vec2.f423649x = vec22.f423649x;
        vec2.f423650y = vec22.f423650y;
        circleShape.m_radius = this.m_radius;
        return circleShape;
    }
}
