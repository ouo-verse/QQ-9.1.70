package org.jbox2d.collision.shapes;

import org.jbox2d.collision.AABB;
import org.jbox2d.collision.RayCastInput;
import org.jbox2d.collision.RayCastOutput;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.pooling.arrays.IntArray;
import org.jbox2d.pooling.arrays.Vec2Array;

/* loaded from: classes29.dex */
public class PolygonShape extends Shape {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean m_debug = false;
    public final Vec2 m_centroid;
    public int m_count;
    public final Vec2[] m_normals;
    public final Vec2[] m_vertices;
    private final Vec2 pool1;
    private final Vec2 pool2;
    private final Vec2 pool3;
    private final Vec2 pool4;
    private Transform poolt1;

    public PolygonShape() {
        super(ShapeType.POLYGON);
        this.m_centroid = new Vec2();
        this.pool1 = new Vec2();
        this.pool2 = new Vec2();
        this.pool3 = new Vec2();
        this.pool4 = new Vec2();
        this.poolt1 = new Transform();
        int i3 = 0;
        this.m_count = 0;
        this.m_vertices = new Vec2[8];
        int i16 = 0;
        while (true) {
            Vec2[] vec2Arr = this.m_vertices;
            if (i16 >= vec2Arr.length) {
                break;
            }
            vec2Arr[i16] = new Vec2();
            i16++;
        }
        this.m_normals = new Vec2[8];
        while (true) {
            Vec2[] vec2Arr2 = this.m_normals;
            if (i3 < vec2Arr2.length) {
                vec2Arr2[i3] = new Vec2();
                i3++;
            } else {
                setRadius(0.01f);
                this.m_centroid.setZero();
                return;
            }
        }
    }

    public Vec2 centroid(Transform transform) {
        return Transform.mul(transform, this.m_centroid);
    }

    public Vec2 centroidToOut(Transform transform, Vec2 vec2) {
        Transform.mulToOutUnsafe(transform, this.m_centroid, vec2);
        return vec2;
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public final void computeAABB(AABB aabb, Transform transform, int i3) {
        Vec2 vec2 = aabb.lowerBound;
        Vec2 vec22 = aabb.upperBound;
        Vec2 vec23 = this.m_vertices[0];
        Rot rot = transform.f423648q;
        Vec2 vec24 = transform.f423647p;
        float f16 = rot.f423641c;
        float f17 = vec23.f423649x * f16;
        float f18 = rot.f423642s;
        float f19 = vec23.f423650y;
        float f26 = (f17 - (f18 * f19)) + vec24.f423649x;
        vec2.f423649x = f26;
        float f27 = (f18 * vec23.f423649x) + (f16 * f19) + vec24.f423650y;
        vec2.f423650y = f27;
        vec22.f423649x = f26;
        vec22.f423650y = f27;
        for (int i16 = 1; i16 < this.m_count; i16++) {
            Vec2 vec25 = this.m_vertices[i16];
            float f28 = rot.f423641c;
            float f29 = vec25.f423649x;
            float f36 = rot.f423642s;
            float f37 = vec25.f423650y;
            float f38 = ((f28 * f29) - (f36 * f37)) + vec24.f423649x;
            float f39 = (f36 * f29) + (f28 * f37) + vec24.f423650y;
            float f46 = vec2.f423649x;
            if (f46 >= f38) {
                f46 = f38;
            }
            vec2.f423649x = f46;
            float f47 = vec2.f423650y;
            if (f47 >= f39) {
                f47 = f39;
            }
            vec2.f423650y = f47;
            float f48 = vec22.f423649x;
            if (f48 > f38) {
                f38 = f48;
            }
            vec22.f423649x = f38;
            float f49 = vec22.f423650y;
            if (f49 > f39) {
                f39 = f49;
            }
            vec22.f423650y = f39;
        }
        float f56 = vec2.f423649x;
        float f57 = this.m_radius;
        vec2.f423649x = f56 - f57;
        vec2.f423650y -= f57;
        vec22.f423649x += f57;
        vec22.f423650y += f57;
    }

    public final void computeCentroidToOut(Vec2[] vec2Arr, int i3, Vec2 vec2) {
        Vec2 vec22;
        float f16 = 0.0f;
        vec2.set(0.0f, 0.0f);
        Vec2 vec23 = this.pool1;
        vec23.setZero();
        Vec2 vec24 = this.pool2;
        Vec2 vec25 = this.pool3;
        int i16 = 0;
        while (i16 < i3) {
            Vec2 vec26 = vec2Arr[i16];
            i16++;
            if (i16 < i3) {
                vec22 = vec2Arr[i16];
            } else {
                vec22 = vec2Arr[0];
            }
            vec24.set(vec26).subLocal(vec23);
            vec25.set(vec22).subLocal(vec23);
            float cross = Vec2.cross(vec24, vec25) * 0.5f;
            f16 += cross;
            vec24.set(vec23).addLocal(vec26).addLocal(vec22).mulLocal(cross * 0.33333334f);
            vec2.addLocal(vec24);
        }
        vec2.mulLocal(1.0f / f16);
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public void computeMass(MassData massData, float f16) {
        int i3;
        Vec2 vec2;
        Vec2 vec22 = this.pool1;
        vec22.setZero();
        Vec2 vec23 = this.pool2;
        vec23.setZero();
        int i16 = 0;
        while (true) {
            i3 = this.m_count;
            if (i16 >= i3) {
                break;
            }
            vec23.addLocal(this.m_vertices[i16]);
            i16++;
        }
        vec23.mulLocal(1.0f / i3);
        Vec2 vec24 = this.pool3;
        Vec2 vec25 = this.pool4;
        float f17 = 0.0f;
        int i17 = 0;
        float f18 = 0.0f;
        while (i17 < this.m_count) {
            vec24.set(this.m_vertices[i17]).subLocal(vec23);
            Vec2 negateLocal = vec25.set(vec23).negateLocal();
            i17++;
            if (i17 < this.m_count) {
                vec2 = this.m_vertices[i17];
            } else {
                vec2 = this.m_vertices[0];
            }
            negateLocal.addLocal(vec2);
            float cross = Vec2.cross(vec24, vec25);
            float f19 = 0.5f * cross;
            f17 += f19;
            float f26 = f19 * 0.33333334f;
            vec22.f423649x += (vec24.f423649x + vec25.f423649x) * f26;
            vec22.f423650y += f26 * (vec24.f423650y + vec25.f423650y);
            float f27 = vec24.f423649x;
            float f28 = vec24.f423650y;
            float f29 = vec25.f423649x;
            float f36 = vec25.f423650y;
            f18 += cross * 0.083333336f * ((f27 * f27) + (f27 * f29) + (f29 * f29) + (f28 * f28) + (f28 * f36) + (f36 * f36));
        }
        massData.mass = f16 * f17;
        vec22.mulLocal(1.0f / f17);
        massData.center.set(vec22).addLocal(vec23);
        float f37 = f18 * f16;
        massData.I = f37;
        float f38 = massData.mass;
        Vec2 vec26 = massData.center;
        massData.I = f37 + (f38 * Vec2.dot(vec26, vec26));
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public int getChildCount() {
        return 1;
    }

    public Vec2[] getNormals() {
        return this.m_normals;
    }

    public final Vec2 getVertex(int i3) {
        return this.m_vertices[i3];
    }

    public final int getVertexCount() {
        return this.m_count;
    }

    public Vec2[] getVertices() {
        return this.m_vertices;
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public final boolean raycast(RayCastOutput rayCastOutput, RayCastInput rayCastInput, Transform transform, int i3) {
        Rot rot = transform.f423648q;
        Vec2 vec2 = transform.f423647p;
        Vec2 vec22 = rayCastInput.f423628p1;
        float f16 = vec22.f423649x;
        float f17 = vec2.f423649x;
        float f18 = f16 - f17;
        float f19 = vec22.f423650y;
        float f26 = vec2.f423650y;
        float f27 = f19 - f26;
        float f28 = rot.f423641c;
        float f29 = rot.f423642s;
        float f36 = (f28 * f18) + (f29 * f27);
        float f37 = ((-f29) * f18) + (f27 * f28);
        Vec2 vec23 = rayCastInput.f423629p2;
        float f38 = vec23.f423649x - f17;
        float f39 = vec23.f423650y - f26;
        float f46 = ((f28 * f38) + (f29 * f39)) - f36;
        float f47 = (((-f29) * f38) + (f28 * f39)) - f37;
        float f48 = rayCastInput.maxFraction;
        int i16 = -1;
        float f49 = 0.0f;
        for (int i17 = 0; i17 < this.m_count; i17++) {
            Vec2 vec24 = this.m_normals[i17];
            Vec2 vec25 = this.m_vertices[i17];
            float f56 = vec25.f423649x - f36;
            float f57 = vec25.f423650y - f37;
            float f58 = vec24.f423649x;
            float f59 = vec24.f423650y;
            float f65 = (f56 * f58) + (f57 * f59);
            float f66 = (f58 * f46) + (f59 * f47);
            if (f66 == 0.0f) {
                if (f65 < 0.0f) {
                    return false;
                }
            } else if (f66 < 0.0f && f65 < f49 * f66) {
                f49 = f65 / f66;
                i16 = i17;
            } else if (f66 > 0.0f && f65 < f48 * f66) {
                f48 = f65 / f66;
            }
            if (f48 < f49) {
                return false;
            }
        }
        if (i16 >= 0) {
            rayCastOutput.fraction = f49;
            Vec2 vec26 = this.m_normals[i16];
            Vec2 vec27 = rayCastOutput.normal;
            float f67 = rot.f423641c;
            float f68 = vec26.f423649x * f67;
            float f69 = rot.f423642s;
            float f75 = vec26.f423650y;
            vec27.f423649x = f68 - (f69 * f75);
            vec27.f423650y = (f69 * vec26.f423649x) + (f67 * f75);
            return true;
        }
        return false;
    }

    public final void set(Vec2[] vec2Arr, int i3) {
        set(vec2Arr, i3, null, null);
    }

    public final void setAsBox(float f16, float f17) {
        this.m_count = 4;
        float f18 = -f16;
        float f19 = -f17;
        this.m_vertices[0].set(f18, f19);
        this.m_vertices[1].set(f16, f19);
        this.m_vertices[2].set(f16, f17);
        this.m_vertices[3].set(f18, f17);
        this.m_normals[0].set(0.0f, -1.0f);
        this.m_normals[1].set(1.0f, 0.0f);
        this.m_normals[2].set(0.0f, 1.0f);
        this.m_normals[3].set(-1.0f, 0.0f);
        this.m_centroid.setZero();
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public final boolean testPoint(Transform transform, Vec2 vec2) {
        Rot rot = transform.f423648q;
        float f16 = vec2.f423649x;
        Vec2 vec22 = transform.f423647p;
        float f17 = f16 - vec22.f423649x;
        float f18 = vec2.f423650y - vec22.f423650y;
        float f19 = rot.f423641c;
        float f26 = rot.f423642s;
        float f27 = (f19 * f17) + (f26 * f18);
        float f28 = ((-f26) * f17) + (f19 * f18);
        for (int i3 = 0; i3 < this.m_count; i3++) {
            Vec2 vec23 = this.m_vertices[i3];
            Vec2 vec24 = this.m_normals[i3];
            if ((vec24.f423649x * (f27 - vec23.f423649x)) + (vec24.f423650y * (f28 - vec23.f423650y)) > 0.0f) {
                return false;
            }
        }
        return true;
    }

    public boolean validate() {
        int i3;
        int i16 = 0;
        while (true) {
            int i17 = this.m_count;
            if (i16 < i17) {
                if (i16 < i17 - 1) {
                    i3 = i16 + 1;
                } else {
                    i3 = 0;
                }
                Vec2[] vec2Arr = this.m_vertices;
                Vec2 vec2 = vec2Arr[i16];
                Vec2 subLocal = this.pool1.set(vec2Arr[i3]).subLocal(vec2);
                for (int i18 = 0; i18 < this.m_count; i18++) {
                    if (i18 != i16 && i18 != i3 && Vec2.cross(subLocal, this.pool2.set(this.m_vertices[i18]).subLocal(vec2)) < 0.0f) {
                        return false;
                    }
                }
                i16++;
            } else {
                return true;
            }
        }
    }

    @Override // org.jbox2d.collision.shapes.Shape
    public final Shape clone() {
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.m_centroid.set(this.m_centroid);
        int i3 = 0;
        while (true) {
            Vec2[] vec2Arr = polygonShape.m_normals;
            if (i3 < vec2Arr.length) {
                vec2Arr[i3].set(this.m_normals[i3]);
                polygonShape.m_vertices[i3].set(this.m_vertices[i3]);
                i3++;
            } else {
                polygonShape.setRadius(getRadius());
                polygonShape.m_count = this.m_count;
                return polygonShape;
            }
        }
    }

    public final void set(Vec2[] vec2Arr, int i3, Vec2Array vec2Array, IntArray intArray) {
        if (i3 < 3) {
            setAsBox(1.0f, 1.0f);
            return;
        }
        int min = MathUtils.min(i3, 8);
        Vec2[] vec2Arr2 = vec2Array != null ? vec2Array.get(min) : new Vec2[min];
        for (int i16 = 0; i16 < min; i16++) {
            vec2Arr2[i16] = vec2Arr[i16];
        }
        float f16 = vec2Arr2[0].f423649x;
        int i17 = 0;
        for (int i18 = 1; i18 < i3; i18++) {
            Vec2 vec2 = vec2Arr2[i18];
            float f17 = vec2.f423649x;
            if (f17 > f16 || (f17 == f16 && vec2.f423650y < vec2Arr2[i17].f423650y)) {
                i17 = i18;
                f16 = f17;
            }
        }
        int[] iArr = intArray != null ? intArray.get(8) : new int[8];
        int i19 = 0;
        int i26 = i17;
        while (true) {
            iArr[i19] = i26;
            int i27 = 0;
            for (int i28 = 1; i28 < min; i28++) {
                if (i27 != i26) {
                    Vec2 subLocal = this.pool1.set(vec2Arr2[i27]).subLocal(vec2Arr2[iArr[i19]]);
                    Vec2 subLocal2 = this.pool2.set(vec2Arr2[i28]).subLocal(vec2Arr2[iArr[i19]]);
                    float cross = Vec2.cross(subLocal, subLocal2);
                    if (cross < 0.0f) {
                        i27 = i28;
                    }
                    if (cross == 0.0f) {
                        if (subLocal2.lengthSquared() <= subLocal.lengthSquared()) {
                        }
                    }
                }
                i27 = i28;
            }
            i19++;
            if (i27 == i17) {
                break;
            } else {
                i26 = i27;
            }
        }
        this.m_count = i19;
        for (int i29 = 0; i29 < this.m_count; i29++) {
            Vec2[] vec2Arr3 = this.m_vertices;
            if (vec2Arr3[i29] == null) {
                vec2Arr3[i29] = new Vec2();
            }
            this.m_vertices[i29].set(vec2Arr2[iArr[i29]]);
        }
        Vec2 vec22 = this.pool1;
        int i36 = 0;
        while (true) {
            int i37 = this.m_count;
            if (i36 < i37) {
                int i38 = i36 + 1;
                vec22.set(this.m_vertices[i38 < i37 ? i38 : 0]).subLocal(this.m_vertices[i36]);
                Vec2.crossToOutUnsafe(vec22, 1.0f, this.m_normals[i36]);
                this.m_normals[i36].normalize();
                i36 = i38;
            } else {
                computeCentroidToOut(this.m_vertices, i37, this.m_centroid);
                return;
            }
        }
    }

    public final void setAsBox(float f16, float f17, Vec2 vec2, float f18) {
        this.m_count = 4;
        float f19 = -f16;
        float f26 = -f17;
        this.m_vertices[0].set(f19, f26);
        this.m_vertices[1].set(f16, f26);
        this.m_vertices[2].set(f16, f17);
        this.m_vertices[3].set(f19, f17);
        this.m_normals[0].set(0.0f, -1.0f);
        this.m_normals[1].set(1.0f, 0.0f);
        this.m_normals[2].set(0.0f, 1.0f);
        this.m_normals[3].set(-1.0f, 0.0f);
        this.m_centroid.set(vec2);
        Transform transform = this.poolt1;
        transform.f423647p.set(vec2);
        transform.f423648q.set(f18);
        for (int i3 = 0; i3 < this.m_count; i3++) {
            Vec2 vec22 = this.m_vertices[i3];
            Transform.mulToOut(transform, vec22, vec22);
            Rot rot = transform.f423648q;
            Vec2 vec23 = this.m_normals[i3];
            Rot.mulToOut(rot, vec23, vec23);
        }
    }
}
