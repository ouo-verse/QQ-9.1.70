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
public class ChainShape extends Shape {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public int m_count;
    public boolean m_hasNextVertex;
    public boolean m_hasPrevVertex;
    public final Vec2 m_nextVertex;
    public final Vec2 m_prevVertex;
    public Vec2[] m_vertices;
    private final EdgeShape pool0;

    public ChainShape() {
        super(ShapeType.CHAIN);
        this.m_prevVertex = new Vec2();
        this.m_nextVertex = new Vec2();
        this.m_hasPrevVertex = false;
        this.m_hasNextVertex = false;
        this.pool0 = new EdgeShape();
        this.m_vertices = null;
        this.m_radius = 0.01f;
        this.m_count = 0;
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public void computeAABB(AABB aabb, Transform transform, int i3) {
        float f16;
        float f17;
        Vec2 vec2 = aabb.lowerBound;
        Vec2 vec22 = aabb.upperBound;
        int i16 = i3 + 1;
        if (i16 == this.m_count) {
            i16 = 0;
        }
        Vec2[] vec2Arr = this.m_vertices;
        Vec2 vec23 = vec2Arr[i3];
        Vec2 vec24 = vec2Arr[i16];
        Rot rot = transform.f423648q;
        Vec2 vec25 = transform.f423647p;
        float f18 = rot.f423641c;
        float f19 = vec23.f423649x;
        float f26 = rot.f423642s;
        float f27 = vec23.f423650y;
        float f28 = vec25.f423649x;
        float f29 = ((f18 * f19) - (f26 * f27)) + f28;
        float f36 = vec25.f423650y;
        float f37 = (f19 * f26) + (f27 * f18) + f36;
        float f38 = vec24.f423649x;
        float f39 = vec24.f423650y;
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
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public void computeMass(MassData massData, float f16) {
        massData.mass = 0.0f;
        massData.center.setZero();
        massData.I = 0.0f;
    }

    public void createChain(Vec2[] vec2Arr, int i3) {
        this.m_count = i3;
        this.m_vertices = new Vec2[i3];
        for (int i16 = 1; i16 < this.m_count; i16++) {
            if (MathUtils.distanceSquared(vec2Arr[i16 - 1], vec2Arr[i16]) < 2.5E-5f) {
                throw new RuntimeException("Vertices of chain shape are too close together");
            }
        }
        for (int i17 = 0; i17 < this.m_count; i17++) {
            this.m_vertices[i17] = new Vec2(vec2Arr[i17]);
        }
        this.m_hasPrevVertex = false;
        this.m_hasNextVertex = false;
    }

    public void createLoop(Vec2[] vec2Arr, int i3) {
        int i16 = i3 + 1;
        this.m_count = i16;
        this.m_vertices = new Vec2[i16];
        for (int i17 = 1; i17 < i3; i17++) {
            if (MathUtils.distanceSquared(vec2Arr[i17 - 1], vec2Arr[i17]) < 2.5E-5f) {
                throw new RuntimeException("Vertices of chain shape are too close together");
            }
        }
        for (int i18 = 0; i18 < i3; i18++) {
            this.m_vertices[i18] = new Vec2(vec2Arr[i18]);
        }
        this.m_vertices[i3] = new Vec2(this.m_vertices[0]);
        this.m_prevVertex.set(this.m_vertices[this.m_count - 2]);
        this.m_nextVertex.set(this.m_vertices[1]);
        this.m_hasPrevVertex = true;
        this.m_hasNextVertex = true;
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public int getChildCount() {
        return this.m_count - 1;
    }

    public void getChildEdge(EdgeShape edgeShape, int i3) {
        edgeShape.m_radius = this.m_radius;
        Vec2[] vec2Arr = this.m_vertices;
        Vec2 vec2 = vec2Arr[i3 + 0];
        Vec2 vec22 = vec2Arr[i3 + 1];
        Vec2 vec23 = edgeShape.m_vertex1;
        vec23.f423649x = vec2.f423649x;
        vec23.f423650y = vec2.f423650y;
        Vec2 vec24 = edgeShape.m_vertex2;
        vec24.f423649x = vec22.f423649x;
        vec24.f423650y = vec22.f423650y;
        if (i3 > 0) {
            Vec2 vec25 = vec2Arr[i3 - 1];
            Vec2 vec26 = edgeShape.m_vertex0;
            vec26.f423649x = vec25.f423649x;
            vec26.f423650y = vec25.f423650y;
            edgeShape.m_hasVertex0 = true;
        } else {
            Vec2 vec27 = edgeShape.m_vertex0;
            Vec2 vec28 = this.m_prevVertex;
            vec27.f423649x = vec28.f423649x;
            vec27.f423650y = vec28.f423650y;
            edgeShape.m_hasVertex0 = this.m_hasPrevVertex;
        }
        if (i3 < this.m_count - 2) {
            Vec2 vec29 = vec2Arr[i3 + 2];
            Vec2 vec210 = edgeShape.m_vertex3;
            vec210.f423649x = vec29.f423649x;
            vec210.f423650y = vec29.f423650y;
            edgeShape.m_hasVertex3 = true;
            return;
        }
        Vec2 vec211 = edgeShape.m_vertex3;
        Vec2 vec212 = this.m_nextVertex;
        vec211.f423649x = vec212.f423649x;
        vec211.f423650y = vec212.f423650y;
        edgeShape.m_hasVertex3 = this.m_hasNextVertex;
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public boolean raycast(RayCastOutput rayCastOutput, RayCastInput rayCastInput, Transform transform, int i3) {
        EdgeShape edgeShape = this.pool0;
        int i16 = i3 + 1;
        if (i16 == this.m_count) {
            i16 = 0;
        }
        Vec2[] vec2Arr = this.m_vertices;
        Vec2 vec2 = vec2Arr[i3];
        Vec2 vec22 = edgeShape.m_vertex1;
        vec22.f423649x = vec2.f423649x;
        vec22.f423650y = vec2.f423650y;
        Vec2 vec23 = vec2Arr[i16];
        Vec2 vec24 = edgeShape.m_vertex2;
        vec24.f423649x = vec23.f423649x;
        vec24.f423650y = vec23.f423650y;
        return edgeShape.raycast(rayCastOutput, rayCastInput, transform, 0);
    }

    public void setNextVertex(Vec2 vec2) {
        this.m_nextVertex.set(vec2);
        this.m_hasNextVertex = true;
    }

    public void setPrevVertex(Vec2 vec2) {
        this.m_prevVertex.set(vec2);
        this.m_hasPrevVertex = true;
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public boolean testPoint(Transform transform, Vec2 vec2) {
        return false;
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public Shape clone() {
        ChainShape chainShape = new ChainShape();
        chainShape.createChain(this.m_vertices, this.m_count);
        chainShape.m_prevVertex.set(this.m_prevVertex);
        chainShape.m_nextVertex.set(this.m_nextVertex);
        chainShape.m_hasPrevVertex = this.m_hasPrevVertex;
        chainShape.m_hasNextVertex = this.m_hasNextVertex;
        return chainShape;
    }
}
