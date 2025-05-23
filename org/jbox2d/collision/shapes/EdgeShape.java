package org.jbox2d.collision.shapes;

import org.jbox2d.collision.AABB;
import org.jbox2d.collision.RayCastInput;
import org.jbox2d.collision.RayCastOutput;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes29.dex */
public class EdgeShape extends Shape {
    public boolean m_hasVertex0;
    public boolean m_hasVertex3;
    public final Vec2 m_vertex0;
    public final Vec2 m_vertex1;
    public final Vec2 m_vertex2;
    public final Vec2 m_vertex3;
    private final Vec2 normal;

    public EdgeShape() {
        super(ShapeType.EDGE);
        this.m_vertex1 = new Vec2();
        this.m_vertex2 = new Vec2();
        this.m_vertex0 = new Vec2();
        this.m_vertex3 = new Vec2();
        this.m_hasVertex0 = false;
        this.m_hasVertex3 = false;
        this.normal = new Vec2();
        this.m_radius = 0.01f;
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public void computeAABB(AABB aabb, Transform transform, int i3) {
        float f16;
        float f17;
        Vec2 vec2 = aabb.lowerBound;
        Vec2 vec22 = aabb.upperBound;
        Rot rot = transform.f423648q;
        float f18 = rot.f423641c;
        Vec2 vec23 = this.m_vertex1;
        float f19 = vec23.f423649x;
        float f26 = rot.f423642s;
        float f27 = vec23.f423650y;
        Vec2 vec24 = transform.f423647p;
        float f28 = vec24.f423649x;
        float f29 = ((f18 * f19) - (f26 * f27)) + f28;
        float f36 = vec24.f423650y;
        float f37 = (f19 * f26) + (f27 * f18) + f36;
        Vec2 vec25 = this.m_vertex2;
        float f38 = vec25.f423649x;
        float f39 = vec25.f423650y;
        float f46 = ((f18 * f38) - (f26 * f39)) + f28;
        float f47 = (f26 * f38) + (f18 * f39) + f36;
        if (f29 < f46) {
            f16 = f29;
        } else {
            f16 = f46;
        }
        vec2.f423649x = f16;
        if (f37 < f47) {
            f17 = f37;
        } else {
            f17 = f47;
        }
        vec2.f423650y = f17;
        if (f29 <= f46) {
            f29 = f46;
        }
        vec22.f423649x = f29;
        if (f37 <= f47) {
            f37 = f47;
        }
        vec22.f423650y = f37;
        float f48 = vec2.f423649x;
        float f49 = this.m_radius;
        vec2.f423649x = f48 - f49;
        vec2.f423650y -= f49;
        vec22.f423649x += f49;
        vec22.f423650y += f49;
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public void computeMass(MassData massData, float f16) {
        massData.mass = 0.0f;
        massData.center.set(this.m_vertex1).addLocal(this.m_vertex2).mulLocal(0.5f);
        massData.I = 0.0f;
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public int getChildCount() {
        return 1;
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public boolean raycast(RayCastOutput rayCastOutput, RayCastInput rayCastInput, Transform transform, int i3) {
        Vec2 vec2 = this.m_vertex1;
        Vec2 vec22 = this.m_vertex2;
        Rot rot = transform.f423648q;
        Vec2 vec23 = transform.f423647p;
        Vec2 vec24 = rayCastInput.f423628p1;
        float f16 = vec24.f423649x;
        float f17 = vec23.f423649x;
        float f18 = f16 - f17;
        float f19 = vec24.f423650y;
        float f26 = vec23.f423650y;
        float f27 = f19 - f26;
        float f28 = rot.f423641c;
        float f29 = rot.f423642s;
        float f36 = (f28 * f18) + (f29 * f27);
        float f37 = ((-f29) * f18) + (f27 * f28);
        Vec2 vec25 = rayCastInput.f423629p2;
        float f38 = vec25.f423649x - f17;
        float f39 = vec25.f423650y - f26;
        float f46 = ((f28 * f38) + (f29 * f39)) - f36;
        float f47 = (((-f29) * f38) + (f28 * f39)) - f37;
        Vec2 vec26 = this.normal;
        vec26.f423649x = vec22.f423650y - vec2.f423650y;
        vec26.f423650y = vec2.f423649x - vec22.f423649x;
        vec26.normalize();
        Vec2 vec27 = this.normal;
        float f48 = vec27.f423649x;
        float f49 = vec27.f423650y;
        float f56 = vec2.f423649x;
        float f57 = vec2.f423650y;
        float f58 = ((f56 - f36) * f48) + ((f57 - f37) * f49);
        float f59 = (f48 * f46) + (f49 * f47);
        if (f59 == 0.0f) {
            return false;
        }
        float f65 = f58 / f59;
        if (f65 >= 0.0f && 1.0f >= f65) {
            float f66 = f36 + (f46 * f65);
            float f67 = f37 + (f47 * f65);
            float f68 = vec22.f423649x - f56;
            float f69 = vec22.f423650y - f57;
            float f75 = (f68 * f68) + (f69 * f69);
            if (f75 == 0.0f) {
                return false;
            }
            float f76 = (((f66 - f56) * f68) + ((f67 - f57) * f69)) / f75;
            if (f76 >= 0.0f && 1.0f >= f76) {
                rayCastOutput.fraction = f65;
                if (f58 > 0.0f) {
                    Vec2 vec28 = rayCastOutput.normal;
                    vec28.f423649x = -f48;
                    vec28.f423650y = -f49;
                    return true;
                }
                Vec2 vec29 = rayCastOutput.normal;
                vec29.f423649x = f48;
                vec29.f423650y = f49;
                return true;
            }
        }
        return false;
    }

    public void set(Vec2 vec2, Vec2 vec22) {
        this.m_vertex1.set(vec2);
        this.m_vertex2.set(vec22);
        this.m_hasVertex3 = false;
        this.m_hasVertex0 = false;
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public boolean testPoint(Transform transform, Vec2 vec2) {
        return false;
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public Shape clone() {
        EdgeShape edgeShape = new EdgeShape();
        edgeShape.m_radius = this.m_radius;
        edgeShape.m_hasVertex0 = this.m_hasVertex0;
        edgeShape.m_hasVertex3 = this.m_hasVertex3;
        edgeShape.m_vertex0.set(this.m_vertex0);
        edgeShape.m_vertex1.set(this.m_vertex1);
        edgeShape.m_vertex2.set(this.m_vertex2);
        edgeShape.m_vertex3.set(this.m_vertex3);
        return edgeShape;
    }
}
