package org.jbox2d.collision;

import org.jbox2d.collision.shapes.ChainShape;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.collision.shapes.ShapeType;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Distance {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static int GJK_CALLS = 0;
    public static int GJK_ITERS = 0;
    public static int GJK_MAX_ITERS = 20;
    private Simplex simplex = new Simplex(this, null);
    private int[] saveA = new int[3];
    private int[] saveB = new int[3];
    private Vec2 closestPoint = new Vec2();

    /* renamed from: d, reason: collision with root package name */
    private Vec2 f423619d = new Vec2();
    private Vec2 temp = new Vec2();
    private Vec2 normal = new Vec2();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: org.jbox2d.collision.Distance$1, reason: invalid class name */
    /* loaded from: classes29.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jbox2d$collision$shapes$ShapeType;

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
                $SwitchMap$org$jbox2d$collision$shapes$ShapeType[ShapeType.CHAIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jbox2d$collision$shapes$ShapeType[ShapeType.EDGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class DistanceProxy {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public final Vec2[] m_buffer;
        public int m_count;
        public float m_radius;
        public final Vec2[] m_vertices = new Vec2[8];

        public DistanceProxy() {
            int i3 = 0;
            while (true) {
                Vec2[] vec2Arr = this.m_vertices;
                if (i3 < vec2Arr.length) {
                    vec2Arr[i3] = new Vec2();
                    i3++;
                } else {
                    this.m_buffer = new Vec2[2];
                    this.m_count = 0;
                    this.m_radius = 0.0f;
                    return;
                }
            }
        }

        public final int getSupport(Vec2 vec2) {
            int i3 = 0;
            float dot = Vec2.dot(this.m_vertices[0], vec2);
            for (int i16 = 1; i16 < this.m_count; i16++) {
                float dot2 = Vec2.dot(this.m_vertices[i16], vec2);
                if (dot2 > dot) {
                    i3 = i16;
                    dot = dot2;
                }
            }
            return i3;
        }

        public final Vec2 getSupportVertex(Vec2 vec2) {
            int i3 = 0;
            float dot = Vec2.dot(this.m_vertices[0], vec2);
            for (int i16 = 1; i16 < this.m_count; i16++) {
                float dot2 = Vec2.dot(this.m_vertices[i16], vec2);
                if (dot2 > dot) {
                    i3 = i16;
                    dot = dot2;
                }
            }
            return this.m_vertices[i3];
        }

        public final Vec2 getVertex(int i3) {
            return this.m_vertices[i3];
        }

        public final int getVertexCount() {
            return this.m_count;
        }

        public final void set(Shape shape, int i3) {
            int i16 = AnonymousClass1.$SwitchMap$org$jbox2d$collision$shapes$ShapeType[shape.getType().ordinal()];
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 == 4) {
                            EdgeShape edgeShape = (EdgeShape) shape;
                            this.m_vertices[0].set(edgeShape.m_vertex1);
                            this.m_vertices[1].set(edgeShape.m_vertex2);
                            this.m_count = 2;
                            this.m_radius = edgeShape.m_radius;
                            return;
                        }
                        return;
                    }
                    ChainShape chainShape = (ChainShape) shape;
                    Vec2[] vec2Arr = this.m_buffer;
                    Vec2[] vec2Arr2 = chainShape.m_vertices;
                    Vec2 vec2 = vec2Arr2[i3];
                    vec2Arr[0] = vec2;
                    int i17 = i3 + 1;
                    if (i17 < chainShape.m_count) {
                        vec2Arr[1] = vec2Arr2[i17];
                    } else {
                        vec2Arr[1] = vec2Arr2[0];
                    }
                    this.m_vertices[0].set(vec2);
                    this.m_vertices[1].set(this.m_buffer[1]);
                    this.m_count = 2;
                    this.m_radius = chainShape.m_radius;
                    return;
                }
                PolygonShape polygonShape = (PolygonShape) shape;
                this.m_count = polygonShape.m_count;
                this.m_radius = polygonShape.m_radius;
                for (int i18 = 0; i18 < this.m_count; i18++) {
                    this.m_vertices[i18].set(polygonShape.m_vertices[i18]);
                }
                return;
            }
            CircleShape circleShape = (CircleShape) shape;
            this.m_vertices[0].set(circleShape.m_p);
            this.m_count = 1;
            this.m_radius = circleShape.m_radius;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class SimplexCache {
        public final int[] indexA;
        public final int[] indexB;
        public float metric = 0.0f;
        public int count = 0;

        public SimplexCache() {
            this.indexA = r1;
            this.indexB = r0;
            int[] iArr = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
            int[] iArr2 = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        }

        public void set(SimplexCache simplexCache) {
            int[] iArr = simplexCache.indexA;
            int[] iArr2 = this.indexA;
            System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
            int[] iArr3 = simplexCache.indexB;
            int[] iArr4 = this.indexB;
            System.arraycopy(iArr3, 0, iArr4, 0, iArr4.length);
            this.metric = simplexCache.metric;
            this.count = simplexCache.count;
        }
    }

    public final void distance(DistanceOutput distanceOutput, SimplexCache simplexCache, DistanceInput distanceInput) {
        boolean z16;
        GJK_CALLS++;
        DistanceProxy distanceProxy = distanceInput.proxyA;
        DistanceProxy distanceProxy2 = distanceInput.proxyB;
        Transform transform = distanceInput.transformA;
        Transform transform2 = distanceInput.transformB;
        this.simplex.readCache(simplexCache, distanceProxy, transform, distanceProxy2, transform2);
        Simplex simplex = this.simplex;
        SimplexVertex[] simplexVertexArr = simplex.vertices;
        simplex.getClosestPoint(this.closestPoint);
        this.closestPoint.lengthSquared();
        int i3 = 0;
        while (i3 < GJK_MAX_ITERS) {
            int i16 = this.simplex.m_count;
            for (int i17 = 0; i17 < i16; i17++) {
                int[] iArr = this.saveA;
                SimplexVertex simplexVertex = simplexVertexArr[i17];
                iArr[i17] = simplexVertex.indexA;
                this.saveB[i17] = simplexVertex.indexB;
            }
            Simplex simplex2 = this.simplex;
            int i18 = simplex2.m_count;
            if (i18 != 1) {
                if (i18 != 2) {
                    if (i18 == 3) {
                        simplex2.solve3();
                    }
                } else {
                    simplex2.solve2();
                }
            }
            Simplex simplex3 = this.simplex;
            if (simplex3.m_count == 3) {
                break;
            }
            simplex3.getClosestPoint(this.closestPoint);
            this.closestPoint.lengthSquared();
            this.simplex.getSearchDirection(this.f423619d);
            if (this.f423619d.lengthSquared() < 1.4210855E-14f) {
                break;
            }
            SimplexVertex simplexVertex2 = simplexVertexArr[this.simplex.m_count];
            Rot.mulTransUnsafe(transform.f423648q, this.f423619d.negateLocal(), this.temp);
            int support = distanceProxy.getSupport(this.temp);
            simplexVertex2.indexA = support;
            Transform.mulToOutUnsafe(transform, distanceProxy.getVertex(support), simplexVertex2.wA);
            Rot.mulTransUnsafe(transform2.f423648q, this.f423619d.negateLocal(), this.temp);
            int support2 = distanceProxy2.getSupport(this.temp);
            simplexVertex2.indexB = support2;
            Transform.mulToOutUnsafe(transform2, distanceProxy2.getVertex(support2), simplexVertex2.wB);
            simplexVertex2.f423626w.set(simplexVertex2.wB).subLocal(simplexVertex2.wA);
            i3++;
            GJK_ITERS++;
            int i19 = 0;
            while (true) {
                if (i19 < i16) {
                    if (simplexVertex2.indexA == this.saveA[i19] && simplexVertex2.indexB == this.saveB[i19]) {
                        z16 = true;
                        break;
                    }
                    i19++;
                } else {
                    z16 = false;
                    break;
                }
            }
            if (z16) {
                break;
            }
            this.simplex.m_count++;
        }
        GJK_MAX_ITERS = MathUtils.max(GJK_MAX_ITERS, i3);
        this.simplex.getWitnessPoints(distanceOutput.pointA, distanceOutput.pointB);
        distanceOutput.distance = MathUtils.distance(distanceOutput.pointA, distanceOutput.pointB);
        distanceOutput.iterations = i3;
        this.simplex.writeCache(simplexCache);
        if (distanceInput.useRadii) {
            float f16 = distanceProxy.m_radius;
            float f17 = distanceProxy2.m_radius;
            float f18 = distanceOutput.distance;
            float f19 = f16 + f17;
            if (f18 > f19 && f18 > 1.1920929E-7f) {
                distanceOutput.distance = f18 - f19;
                this.normal.set(distanceOutput.pointB).subLocal(distanceOutput.pointA);
                this.normal.normalize();
                this.temp.set(this.normal).mulLocal(f16);
                distanceOutput.pointA.addLocal(this.temp);
                this.temp.set(this.normal).mulLocal(f17);
                distanceOutput.pointB.subLocal(this.temp);
                return;
            }
            distanceOutput.pointA.addLocal(distanceOutput.pointB).mulLocal(0.5f);
            distanceOutput.pointB.set(distanceOutput.pointA);
            distanceOutput.distance = 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class SimplexVertex {

        /* renamed from: a, reason: collision with root package name */
        public float f423625a;
        public int indexA;
        public int indexB;

        /* renamed from: w, reason: collision with root package name */
        public final Vec2 f423626w;
        public final Vec2 wA;
        public final Vec2 wB;

        SimplexVertex() {
            this.wA = new Vec2();
            this.wB = new Vec2();
            this.f423626w = new Vec2();
        }

        public void set(SimplexVertex simplexVertex) {
            this.wA.set(simplexVertex.wA);
            this.wB.set(simplexVertex.wB);
            this.f423626w.set(simplexVertex.f423626w);
            this.f423625a = simplexVertex.f423625a;
            this.indexA = simplexVertex.indexA;
            this.indexB = simplexVertex.indexB;
        }

        /* synthetic */ SimplexVertex(Distance distance, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class Simplex {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Vec2 case2;
        private final Vec2 case22;
        private final Vec2 case3;
        private final Vec2 case33;

        /* renamed from: e12, reason: collision with root package name */
        private final Vec2 f423620e12;

        /* renamed from: e13, reason: collision with root package name */
        private final Vec2 f423621e13;

        /* renamed from: e23, reason: collision with root package name */
        private final Vec2 f423622e23;
        public int m_count;
        public final SimplexVertex m_v1;
        public final SimplexVertex m_v2;
        public final SimplexVertex m_v3;
        public final SimplexVertex[] vertices;

        /* renamed from: w1, reason: collision with root package name */
        private final Vec2 f423623w1;

        /* renamed from: w2, reason: collision with root package name */
        private final Vec2 f423624w2;
        private final Vec2 w3;

        Simplex() {
            AnonymousClass1 anonymousClass1 = null;
            SimplexVertex simplexVertex = new SimplexVertex(Distance.this, anonymousClass1);
            this.m_v1 = simplexVertex;
            SimplexVertex simplexVertex2 = new SimplexVertex(Distance.this, anonymousClass1);
            this.m_v2 = simplexVertex2;
            SimplexVertex simplexVertex3 = new SimplexVertex(Distance.this, anonymousClass1);
            this.m_v3 = simplexVertex3;
            this.vertices = new SimplexVertex[]{simplexVertex, simplexVertex2, simplexVertex3};
            this.f423620e12 = new Vec2();
            this.case2 = new Vec2();
            this.case22 = new Vec2();
            this.case3 = new Vec2();
            this.case33 = new Vec2();
            this.f423621e13 = new Vec2();
            this.f423622e23 = new Vec2();
            this.f423623w1 = new Vec2();
            this.f423624w2 = new Vec2();
            this.w3 = new Vec2();
        }

        public void getClosestPoint(Vec2 vec2) {
            int i3 = this.m_count;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            vec2.setZero();
                            return;
                        } else {
                            vec2.setZero();
                            return;
                        }
                    }
                    this.case22.set(this.m_v2.f423626w).mulLocal(this.m_v2.f423625a);
                    this.case2.set(this.m_v1.f423626w).mulLocal(this.m_v1.f423625a).addLocal(this.case22);
                    vec2.set(this.case2);
                    return;
                }
                vec2.set(this.m_v1.f423626w);
                return;
            }
            vec2.setZero();
        }

        public float getMetric() {
            int i3 = this.m_count;
            if (i3 == 0 || i3 == 1) {
                return 0.0f;
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    return 0.0f;
                }
                this.case3.set(this.m_v2.f423626w).subLocal(this.m_v1.f423626w);
                this.case33.set(this.m_v3.f423626w).subLocal(this.m_v1.f423626w);
                return Vec2.cross(this.case3, this.case33);
            }
            return MathUtils.distance(this.m_v1.f423626w, this.m_v2.f423626w);
        }

        public final void getSearchDirection(Vec2 vec2) {
            int i3 = this.m_count;
            if (i3 != 1) {
                if (i3 != 2) {
                    vec2.setZero();
                    return;
                }
                this.f423620e12.set(this.m_v2.f423626w).subLocal(this.m_v1.f423626w);
                vec2.set(this.m_v1.f423626w).negateLocal();
                if (Vec2.cross(this.f423620e12, vec2) > 0.0f) {
                    Vec2.crossToOutUnsafe(1.0f, this.f423620e12, vec2);
                    return;
                } else {
                    Vec2.crossToOutUnsafe(this.f423620e12, 1.0f, vec2);
                    return;
                }
            }
            vec2.set(this.m_v1.f423626w).negateLocal();
        }

        public void getWitnessPoints(Vec2 vec2, Vec2 vec22) {
            int i3 = this.m_count;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            vec2.set(this.m_v1.wA).mulLocal(this.m_v1.f423625a);
                            this.case3.set(this.m_v2.wA).mulLocal(this.m_v2.f423625a);
                            this.case33.set(this.m_v3.wA).mulLocal(this.m_v3.f423625a);
                            vec2.addLocal(this.case3).addLocal(this.case33);
                            vec22.set(vec2);
                            return;
                        }
                        return;
                    }
                    this.case2.set(this.m_v1.wA).mulLocal(this.m_v1.f423625a);
                    vec2.set(this.m_v2.wA).mulLocal(this.m_v2.f423625a).addLocal(this.case2);
                    this.case2.set(this.m_v1.wB).mulLocal(this.m_v1.f423625a);
                    vec22.set(this.m_v2.wB).mulLocal(this.m_v2.f423625a).addLocal(this.case2);
                    return;
                }
                vec2.set(this.m_v1.wA);
                vec22.set(this.m_v1.wB);
            }
        }

        public void readCache(SimplexCache simplexCache, DistanceProxy distanceProxy, Transform transform, DistanceProxy distanceProxy2, Transform transform2) {
            int i3;
            this.m_count = simplexCache.count;
            int i16 = 0;
            while (true) {
                i3 = this.m_count;
                if (i16 >= i3) {
                    break;
                }
                SimplexVertex simplexVertex = this.vertices[i16];
                int i17 = simplexCache.indexA[i16];
                simplexVertex.indexA = i17;
                simplexVertex.indexB = simplexCache.indexB[i16];
                Vec2 vertex = distanceProxy.getVertex(i17);
                Vec2 vertex2 = distanceProxy2.getVertex(simplexVertex.indexB);
                Transform.mulToOutUnsafe(transform, vertex, simplexVertex.wA);
                Transform.mulToOutUnsafe(transform2, vertex2, simplexVertex.wB);
                simplexVertex.f423626w.set(simplexVertex.wB).subLocal(simplexVertex.wA);
                simplexVertex.f423625a = 0.0f;
                i16++;
            }
            if (i3 > 1) {
                float f16 = simplexCache.metric;
                float metric = getMetric();
                if (metric < 0.5f * f16 || f16 * 2.0f < metric || metric < 1.1920929E-7f) {
                    this.m_count = 0;
                }
            }
            if (this.m_count == 0) {
                SimplexVertex simplexVertex2 = this.vertices[0];
                simplexVertex2.indexA = 0;
                simplexVertex2.indexB = 0;
                Vec2 vertex3 = distanceProxy.getVertex(0);
                Vec2 vertex4 = distanceProxy2.getVertex(0);
                Transform.mulToOutUnsafe(transform, vertex3, simplexVertex2.wA);
                Transform.mulToOutUnsafe(transform2, vertex4, simplexVertex2.wB);
                simplexVertex2.f423626w.set(simplexVertex2.wB).subLocal(simplexVertex2.wA);
                this.m_count = 1;
            }
        }

        public void solve2() {
            Vec2 vec2 = this.m_v1.f423626w;
            Vec2 vec22 = this.m_v2.f423626w;
            this.f423620e12.set(vec22).subLocal(vec2);
            float f16 = -Vec2.dot(vec2, this.f423620e12);
            if (f16 <= 0.0f) {
                this.m_v1.f423625a = 1.0f;
                this.m_count = 1;
                return;
            }
            float dot = Vec2.dot(vec22, this.f423620e12);
            if (dot <= 0.0f) {
                SimplexVertex simplexVertex = this.m_v2;
                simplexVertex.f423625a = 1.0f;
                this.m_count = 1;
                this.m_v1.set(simplexVertex);
                return;
            }
            float f17 = 1.0f / (dot + f16);
            this.m_v1.f423625a = dot * f17;
            this.m_v2.f423625a = f16 * f17;
            this.m_count = 2;
        }

        public void solve3() {
            this.f423623w1.set(this.m_v1.f423626w);
            this.f423624w2.set(this.m_v2.f423626w);
            this.w3.set(this.m_v3.f423626w);
            this.f423620e12.set(this.f423624w2).subLocal(this.f423623w1);
            float dot = Vec2.dot(this.f423623w1, this.f423620e12);
            float dot2 = Vec2.dot(this.f423624w2, this.f423620e12);
            float f16 = -dot;
            this.f423621e13.set(this.w3).subLocal(this.f423623w1);
            float dot3 = Vec2.dot(this.f423623w1, this.f423621e13);
            float dot4 = Vec2.dot(this.w3, this.f423621e13);
            float f17 = -dot3;
            this.f423622e23.set(this.w3).subLocal(this.f423624w2);
            float dot5 = Vec2.dot(this.f423624w2, this.f423622e23);
            float dot6 = Vec2.dot(this.w3, this.f423622e23);
            float f18 = -dot5;
            float cross = Vec2.cross(this.f423620e12, this.f423621e13);
            float cross2 = Vec2.cross(this.f423624w2, this.w3) * cross;
            float cross3 = Vec2.cross(this.w3, this.f423623w1) * cross;
            float cross4 = cross * Vec2.cross(this.f423623w1, this.f423624w2);
            if (f16 <= 0.0f && f17 <= 0.0f) {
                this.m_v1.f423625a = 1.0f;
                this.m_count = 1;
                return;
            }
            if (dot2 > 0.0f && f16 > 0.0f && cross4 <= 0.0f) {
                float f19 = 1.0f / (dot2 + f16);
                this.m_v1.f423625a = dot2 * f19;
                this.m_v2.f423625a = f16 * f19;
                this.m_count = 2;
                return;
            }
            if (dot4 > 0.0f && f17 > 0.0f && cross3 <= 0.0f) {
                float f26 = 1.0f / (dot4 + f17);
                this.m_v1.f423625a = dot4 * f26;
                SimplexVertex simplexVertex = this.m_v3;
                simplexVertex.f423625a = f17 * f26;
                this.m_count = 2;
                this.m_v2.set(simplexVertex);
                return;
            }
            if (dot2 <= 0.0f && f18 <= 0.0f) {
                SimplexVertex simplexVertex2 = this.m_v2;
                simplexVertex2.f423625a = 1.0f;
                this.m_count = 1;
                this.m_v1.set(simplexVertex2);
                return;
            }
            if (dot4 <= 0.0f && dot6 <= 0.0f) {
                SimplexVertex simplexVertex3 = this.m_v3;
                simplexVertex3.f423625a = 1.0f;
                this.m_count = 1;
                this.m_v1.set(simplexVertex3);
                return;
            }
            if (dot6 > 0.0f && f18 > 0.0f && cross2 <= 0.0f) {
                float f27 = 1.0f / (dot6 + f18);
                this.m_v2.f423625a = dot6 * f27;
                SimplexVertex simplexVertex4 = this.m_v3;
                simplexVertex4.f423625a = f18 * f27;
                this.m_count = 2;
                this.m_v1.set(simplexVertex4);
                return;
            }
            float f28 = 1.0f / ((cross2 + cross3) + cross4);
            this.m_v1.f423625a = cross2 * f28;
            this.m_v2.f423625a = cross3 * f28;
            this.m_v3.f423625a = cross4 * f28;
            this.m_count = 3;
        }

        public void writeCache(SimplexCache simplexCache) {
            simplexCache.metric = getMetric();
            simplexCache.count = this.m_count;
            for (int i3 = 0; i3 < this.m_count; i3++) {
                int[] iArr = simplexCache.indexA;
                SimplexVertex simplexVertex = this.vertices[i3];
                iArr[i3] = simplexVertex.indexA;
                simplexCache.indexB[i3] = simplexVertex.indexB;
            }
        }

        /* synthetic */ Simplex(Distance distance, AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
