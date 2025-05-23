package org.jbox2d.collision;

import org.jbox2d.collision.ContactID;
import org.jbox2d.collision.Distance;
import org.jbox2d.collision.Manifold;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;
import org.jbox2d.pooling.IWorldPool;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Collision {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int NULL_FEATURE = Integer.MAX_VALUE;

    /* renamed from: d, reason: collision with root package name */
    private static Vec2 f423603d = new Vec2();
    private final ClipVertex[] clipPoints1;
    private final ClipVertex[] clipPoints2;
    private final ClipVertex[] incidentEdge;
    private final IWorldPool pool;
    private final EdgeResults results1;
    private final EdgeResults results2;
    private final DistanceInput input = new DistanceInput();
    private final Distance.SimplexCache cache = new Distance.SimplexCache();
    private final DistanceOutput output = new DistanceOutput();
    private final Vec2 temp = new Vec2();
    private final Vec2 localTangent = new Vec2();
    private final Vec2 localNormal = new Vec2();
    private final Vec2 planePoint = new Vec2();
    private final Vec2 tangent = new Vec2();

    /* renamed from: v11, reason: collision with root package name */
    private final Vec2 f423608v11 = new Vec2();

    /* renamed from: v12, reason: collision with root package name */
    private final Vec2 f423609v12 = new Vec2();
    private final Vec2 Q = new Vec2();

    /* renamed from: e, reason: collision with root package name */
    private final Vec2 f423605e = new Vec2();

    /* renamed from: cf, reason: collision with root package name */
    private final ContactID f423604cf = new ContactID();

    /* renamed from: e1, reason: collision with root package name */
    private final Vec2 f423606e1 = new Vec2();
    private final Vec2 P = new Vec2();

    /* renamed from: n, reason: collision with root package name */
    private final Vec2 f423607n = new Vec2();
    private final EPCollider collider = new EPCollider();

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class ClipVertex {

        /* renamed from: v, reason: collision with root package name */
        public final Vec2 f423611v = new Vec2();

        /* renamed from: id, reason: collision with root package name */
        public final ContactID f423610id = new ContactID();

        public void set(ClipVertex clipVertex) {
            Vec2 vec2 = clipVertex.f423611v;
            Vec2 vec22 = this.f423611v;
            vec22.f423649x = vec2.f423649x;
            vec22.f423650y = vec2.f423650y;
            ContactID contactID = clipVertex.f423610id;
            ContactID contactID2 = this.f423610id;
            contactID2.indexA = contactID.indexA;
            contactID2.indexB = contactID.indexB;
            contactID2.typeA = contactID.typeA;
            contactID2.typeB = contactID.typeB;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class EPAxis {
        int index;
        float separation;
        Type type;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes29.dex */
        public enum Type {
            UNKNOWN,
            EDGE_A,
            EDGE_B
        }

        EPAxis() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static class EPCollider {
        boolean m_front;
        float m_radius;
        VertexType m_type1;
        VertexType m_type2;
        final TempPolygon m_polygonB = new TempPolygon();
        final Transform m_xf = new Transform();
        final Vec2 m_centroidB = new Vec2();
        Vec2 m_v0 = new Vec2();
        Vec2 m_v1 = new Vec2();
        Vec2 m_v2 = new Vec2();
        Vec2 m_v3 = new Vec2();
        final Vec2 m_normal0 = new Vec2();
        final Vec2 m_normal1 = new Vec2();
        final Vec2 m_normal2 = new Vec2();
        final Vec2 m_normal = new Vec2();
        final Vec2 m_lowerLimit = new Vec2();
        final Vec2 m_upperLimit = new Vec2();
        private final Vec2 edge1 = new Vec2();
        private final Vec2 temp = new Vec2();
        private final Vec2 edge0 = new Vec2();
        private final Vec2 edge2 = new Vec2();

        /* renamed from: ie, reason: collision with root package name */
        private final ClipVertex[] f423612ie = new ClipVertex[2];
        private final ClipVertex[] clipPoints1 = new ClipVertex[2];
        private final ClipVertex[] clipPoints2 = new ClipVertex[2];

        /* renamed from: rf, reason: collision with root package name */
        private final ReferenceFace f423614rf = new ReferenceFace();
        private final EPAxis edgeAxis = new EPAxis();
        private final EPAxis polygonAxis = new EPAxis();
        private final Vec2 perp = new Vec2();

        /* renamed from: n, reason: collision with root package name */
        private final Vec2 f423613n = new Vec2();

        /* compiled from: P */
        /* loaded from: classes29.dex */
        enum VertexType {
            ISOLATED,
            CONCAVE,
            CONVEX
        }

        public EPCollider() {
            for (int i3 = 0; i3 < 2; i3++) {
                this.f423612ie[i3] = new ClipVertex();
                this.clipPoints1[i3] = new ClipVertex();
                this.clipPoints2[i3] = new ClipVertex();
            }
        }

        public void collide(Manifold manifold, EdgeShape edgeShape, Transform transform, PolygonShape polygonShape, Transform transform2) {
            float f16;
            boolean z16;
            float f17;
            boolean z17;
            TempPolygon tempPolygon;
            int i3;
            Transform.mulTransToOutUnsafe(transform, transform2, this.m_xf);
            Transform.mulToOutUnsafe(this.m_xf, polygonShape.m_centroid, this.m_centroidB);
            this.m_v0 = edgeShape.m_vertex0;
            this.m_v1 = edgeShape.m_vertex1;
            Vec2 vec2 = edgeShape.m_vertex2;
            this.m_v2 = vec2;
            this.m_v3 = edgeShape.m_vertex3;
            boolean z18 = edgeShape.m_hasVertex0;
            boolean z19 = edgeShape.m_hasVertex3;
            this.edge1.set(vec2).subLocal(this.m_v1);
            this.edge1.normalize();
            Vec2 vec22 = this.m_normal1;
            Vec2 vec23 = this.edge1;
            vec22.set(vec23.f423650y, -vec23.f423649x);
            float dot = Vec2.dot(this.m_normal1, this.temp.set(this.m_centroidB).subLocal(this.m_v1));
            if (z18) {
                this.edge0.set(this.m_v1).subLocal(this.m_v0);
                this.edge0.normalize();
                Vec2 vec24 = this.m_normal0;
                Vec2 vec25 = this.edge0;
                vec24.set(vec25.f423650y, -vec25.f423649x);
                z16 = Vec2.cross(this.edge0, this.edge1) >= 0.0f;
                f16 = Vec2.dot(this.m_normal0, this.temp.set(this.m_centroidB).subLocal(this.m_v0));
            } else {
                f16 = 0.0f;
                z16 = false;
            }
            if (z19) {
                this.edge2.set(this.m_v3).subLocal(this.m_v2);
                this.edge2.normalize();
                Vec2 vec26 = this.m_normal2;
                Vec2 vec27 = this.edge2;
                vec26.set(vec27.f423650y, -vec27.f423649x);
                z17 = Vec2.cross(this.edge1, this.edge2) > 0.0f;
                f17 = Vec2.dot(this.m_normal2, this.temp.set(this.m_centroidB).subLocal(this.m_v2));
            } else {
                f17 = 0.0f;
                z17 = false;
            }
            if (z18 && z19) {
                if (z16 && z17) {
                    boolean z26 = f16 >= 0.0f || dot >= 0.0f || f17 >= 0.0f;
                    this.m_front = z26;
                    if (z26) {
                        Vec2 vec28 = this.m_normal;
                        Vec2 vec29 = this.m_normal1;
                        vec28.f423649x = vec29.f423649x;
                        vec28.f423650y = vec29.f423650y;
                        Vec2 vec210 = this.m_lowerLimit;
                        Vec2 vec211 = this.m_normal0;
                        vec210.f423649x = vec211.f423649x;
                        vec210.f423650y = vec211.f423650y;
                        Vec2 vec212 = this.m_upperLimit;
                        Vec2 vec213 = this.m_normal2;
                        vec212.f423649x = vec213.f423649x;
                        vec212.f423650y = vec213.f423650y;
                    } else {
                        Vec2 vec214 = this.m_normal;
                        Vec2 vec215 = this.m_normal1;
                        vec214.f423649x = -vec215.f423649x;
                        vec214.f423650y = -vec215.f423650y;
                        Vec2 vec216 = this.m_lowerLimit;
                        vec216.f423649x = -vec215.f423649x;
                        vec216.f423650y = -vec215.f423650y;
                        Vec2 vec217 = this.m_upperLimit;
                        vec217.f423649x = -vec215.f423649x;
                        vec217.f423650y = -vec215.f423650y;
                    }
                } else if (z16) {
                    boolean z27 = f16 >= 0.0f || (dot >= 0.0f && f17 >= 0.0f);
                    this.m_front = z27;
                    if (z27) {
                        Vec2 vec218 = this.m_normal;
                        Vec2 vec219 = this.m_normal1;
                        vec218.f423649x = vec219.f423649x;
                        vec218.f423650y = vec219.f423650y;
                        Vec2 vec220 = this.m_lowerLimit;
                        Vec2 vec221 = this.m_normal0;
                        vec220.f423649x = vec221.f423649x;
                        vec220.f423650y = vec221.f423650y;
                        Vec2 vec222 = this.m_upperLimit;
                        vec222.f423649x = vec219.f423649x;
                        vec222.f423650y = vec219.f423650y;
                    } else {
                        Vec2 vec223 = this.m_normal;
                        Vec2 vec224 = this.m_normal1;
                        vec223.f423649x = -vec224.f423649x;
                        vec223.f423650y = -vec224.f423650y;
                        Vec2 vec225 = this.m_lowerLimit;
                        Vec2 vec226 = this.m_normal2;
                        vec225.f423649x = -vec226.f423649x;
                        vec225.f423650y = -vec226.f423650y;
                        Vec2 vec227 = this.m_upperLimit;
                        vec227.f423649x = -vec224.f423649x;
                        vec227.f423650y = -vec224.f423650y;
                    }
                } else if (z17) {
                    boolean z28 = f17 >= 0.0f || (f16 >= 0.0f && dot >= 0.0f);
                    this.m_front = z28;
                    if (z28) {
                        Vec2 vec228 = this.m_normal;
                        Vec2 vec229 = this.m_normal1;
                        vec228.f423649x = vec229.f423649x;
                        vec228.f423650y = vec229.f423650y;
                        Vec2 vec230 = this.m_lowerLimit;
                        vec230.f423649x = vec229.f423649x;
                        vec230.f423650y = vec229.f423650y;
                        Vec2 vec231 = this.m_upperLimit;
                        Vec2 vec232 = this.m_normal2;
                        vec231.f423649x = vec232.f423649x;
                        vec231.f423650y = vec232.f423650y;
                    } else {
                        Vec2 vec233 = this.m_normal;
                        Vec2 vec234 = this.m_normal1;
                        vec233.f423649x = -vec234.f423649x;
                        vec233.f423650y = -vec234.f423650y;
                        Vec2 vec235 = this.m_lowerLimit;
                        vec235.f423649x = -vec234.f423649x;
                        vec235.f423650y = -vec234.f423650y;
                        Vec2 vec236 = this.m_upperLimit;
                        Vec2 vec237 = this.m_normal0;
                        vec236.f423649x = -vec237.f423649x;
                        vec236.f423650y = -vec237.f423650y;
                    }
                } else {
                    boolean z29 = f16 >= 0.0f && dot >= 0.0f && f17 >= 0.0f;
                    this.m_front = z29;
                    if (z29) {
                        Vec2 vec238 = this.m_normal;
                        Vec2 vec239 = this.m_normal1;
                        vec238.f423649x = vec239.f423649x;
                        vec238.f423650y = vec239.f423650y;
                        Vec2 vec240 = this.m_lowerLimit;
                        vec240.f423649x = vec239.f423649x;
                        vec240.f423650y = vec239.f423650y;
                        Vec2 vec241 = this.m_upperLimit;
                        vec241.f423649x = vec239.f423649x;
                        vec241.f423650y = vec239.f423650y;
                    } else {
                        Vec2 vec242 = this.m_normal;
                        Vec2 vec243 = this.m_normal1;
                        vec242.f423649x = -vec243.f423649x;
                        vec242.f423650y = -vec243.f423650y;
                        Vec2 vec244 = this.m_lowerLimit;
                        Vec2 vec245 = this.m_normal2;
                        vec244.f423649x = -vec245.f423649x;
                        vec244.f423650y = -vec245.f423650y;
                        Vec2 vec246 = this.m_upperLimit;
                        Vec2 vec247 = this.m_normal0;
                        vec246.f423649x = -vec247.f423649x;
                        vec246.f423650y = -vec247.f423650y;
                    }
                }
            } else if (z18) {
                if (z16) {
                    boolean z36 = f16 >= 0.0f || dot >= 0.0f;
                    this.m_front = z36;
                    if (z36) {
                        Vec2 vec248 = this.m_normal;
                        Vec2 vec249 = this.m_normal1;
                        vec248.f423649x = vec249.f423649x;
                        vec248.f423650y = vec249.f423650y;
                        Vec2 vec250 = this.m_lowerLimit;
                        Vec2 vec251 = this.m_normal0;
                        vec250.f423649x = vec251.f423649x;
                        vec250.f423650y = vec251.f423650y;
                        Vec2 vec252 = this.m_upperLimit;
                        vec252.f423649x = -vec249.f423649x;
                        vec252.f423650y = -vec249.f423650y;
                    } else {
                        Vec2 vec253 = this.m_normal;
                        Vec2 vec254 = this.m_normal1;
                        vec253.f423649x = -vec254.f423649x;
                        vec253.f423650y = -vec254.f423650y;
                        Vec2 vec255 = this.m_lowerLimit;
                        vec255.f423649x = vec254.f423649x;
                        vec255.f423650y = vec254.f423650y;
                        Vec2 vec256 = this.m_upperLimit;
                        vec256.f423649x = -vec254.f423649x;
                        vec256.f423650y = -vec254.f423650y;
                    }
                } else {
                    boolean z37 = f16 >= 0.0f && dot >= 0.0f;
                    this.m_front = z37;
                    if (z37) {
                        Vec2 vec257 = this.m_normal;
                        Vec2 vec258 = this.m_normal1;
                        vec257.f423649x = vec258.f423649x;
                        vec257.f423650y = vec258.f423650y;
                        Vec2 vec259 = this.m_lowerLimit;
                        vec259.f423649x = vec258.f423649x;
                        vec259.f423650y = vec258.f423650y;
                        Vec2 vec260 = this.m_upperLimit;
                        vec260.f423649x = -vec258.f423649x;
                        vec260.f423650y = -vec258.f423650y;
                    } else {
                        Vec2 vec261 = this.m_normal;
                        Vec2 vec262 = this.m_normal1;
                        vec261.f423649x = -vec262.f423649x;
                        vec261.f423650y = -vec262.f423650y;
                        Vec2 vec263 = this.m_lowerLimit;
                        vec263.f423649x = vec262.f423649x;
                        vec263.f423650y = vec262.f423650y;
                        Vec2 vec264 = this.m_upperLimit;
                        Vec2 vec265 = this.m_normal0;
                        vec264.f423649x = -vec265.f423649x;
                        vec264.f423650y = -vec265.f423650y;
                    }
                }
            } else if (!z19) {
                boolean z38 = dot >= 0.0f;
                this.m_front = z38;
                if (z38) {
                    Vec2 vec266 = this.m_normal;
                    Vec2 vec267 = this.m_normal1;
                    vec266.f423649x = vec267.f423649x;
                    vec266.f423650y = vec267.f423650y;
                    Vec2 vec268 = this.m_lowerLimit;
                    vec268.f423649x = -vec267.f423649x;
                    vec268.f423650y = -vec267.f423650y;
                    Vec2 vec269 = this.m_upperLimit;
                    vec269.f423649x = -vec267.f423649x;
                    vec269.f423650y = -vec267.f423650y;
                } else {
                    Vec2 vec270 = this.m_normal;
                    Vec2 vec271 = this.m_normal1;
                    vec270.f423649x = -vec271.f423649x;
                    vec270.f423650y = -vec271.f423650y;
                    Vec2 vec272 = this.m_lowerLimit;
                    vec272.f423649x = vec271.f423649x;
                    vec272.f423650y = vec271.f423650y;
                    Vec2 vec273 = this.m_upperLimit;
                    vec273.f423649x = vec271.f423649x;
                    vec273.f423650y = vec271.f423650y;
                }
            } else if (z17) {
                boolean z39 = dot >= 0.0f || f17 >= 0.0f;
                this.m_front = z39;
                if (z39) {
                    Vec2 vec274 = this.m_normal;
                    Vec2 vec275 = this.m_normal1;
                    vec274.f423649x = vec275.f423649x;
                    vec274.f423650y = vec275.f423650y;
                    Vec2 vec276 = this.m_lowerLimit;
                    vec276.f423649x = -vec275.f423649x;
                    vec276.f423650y = -vec275.f423650y;
                    Vec2 vec277 = this.m_upperLimit;
                    Vec2 vec278 = this.m_normal2;
                    vec277.f423649x = vec278.f423649x;
                    vec277.f423650y = vec278.f423650y;
                } else {
                    Vec2 vec279 = this.m_normal;
                    Vec2 vec280 = this.m_normal1;
                    vec279.f423649x = -vec280.f423649x;
                    vec279.f423650y = -vec280.f423650y;
                    Vec2 vec281 = this.m_lowerLimit;
                    vec281.f423649x = -vec280.f423649x;
                    vec281.f423650y = -vec280.f423650y;
                    Vec2 vec282 = this.m_upperLimit;
                    vec282.f423649x = vec280.f423649x;
                    vec282.f423650y = vec280.f423650y;
                }
            } else {
                boolean z46 = dot >= 0.0f && f17 >= 0.0f;
                this.m_front = z46;
                if (z46) {
                    Vec2 vec283 = this.m_normal;
                    Vec2 vec284 = this.m_normal1;
                    vec283.f423649x = vec284.f423649x;
                    vec283.f423650y = vec284.f423650y;
                    Vec2 vec285 = this.m_lowerLimit;
                    vec285.f423649x = -vec284.f423649x;
                    vec285.f423650y = -vec284.f423650y;
                    Vec2 vec286 = this.m_upperLimit;
                    vec286.f423649x = vec284.f423649x;
                    vec286.f423650y = vec284.f423650y;
                } else {
                    Vec2 vec287 = this.m_normal;
                    Vec2 vec288 = this.m_normal1;
                    vec287.f423649x = -vec288.f423649x;
                    vec287.f423650y = -vec288.f423650y;
                    Vec2 vec289 = this.m_lowerLimit;
                    Vec2 vec290 = this.m_normal2;
                    vec289.f423649x = -vec290.f423649x;
                    vec289.f423650y = -vec290.f423650y;
                    Vec2 vec291 = this.m_upperLimit;
                    vec291.f423649x = vec288.f423649x;
                    vec291.f423650y = vec288.f423650y;
                }
            }
            this.m_polygonB.count = polygonShape.m_count;
            for (int i16 = 0; i16 < polygonShape.m_count; i16++) {
                Transform.mulToOutUnsafe(this.m_xf, polygonShape.m_vertices[i16], this.m_polygonB.vertices[i16]);
                Rot.mulToOutUnsafe(this.m_xf.f423648q, polygonShape.m_normals[i16], this.m_polygonB.normals[i16]);
            }
            this.m_radius = 0.02f;
            manifold.pointCount = 0;
            computeEdgeSeparation(this.edgeAxis);
            EPAxis ePAxis = this.edgeAxis;
            EPAxis.Type type = ePAxis.type;
            EPAxis.Type type2 = EPAxis.Type.UNKNOWN;
            if (type != type2 && ePAxis.separation <= this.m_radius) {
                computePolygonSeparation(this.polygonAxis);
                EPAxis ePAxis2 = this.polygonAxis;
                EPAxis.Type type3 = ePAxis2.type;
                if (type3 == type2 || ePAxis2.separation <= this.m_radius) {
                    if (type3 == type2) {
                        ePAxis2 = this.edgeAxis;
                    } else {
                        float f18 = ePAxis2.separation;
                        EPAxis ePAxis3 = this.edgeAxis;
                        if (f18 <= (ePAxis3.separation * 0.98f) + 0.001f) {
                            ePAxis2 = ePAxis3;
                        }
                    }
                    ClipVertex[] clipVertexArr = this.f423612ie;
                    ClipVertex clipVertex = clipVertexArr[0];
                    ClipVertex clipVertex2 = clipVertexArr[1];
                    if (ePAxis2.type == EPAxis.Type.EDGE_A) {
                        manifold.type = Manifold.ManifoldType.FACE_A;
                        float dot2 = Vec2.dot(this.m_normal, this.m_polygonB.normals[0]);
                        int i17 = 1;
                        int i18 = 0;
                        while (true) {
                            tempPolygon = this.m_polygonB;
                            i3 = tempPolygon.count;
                            if (i17 >= i3) {
                                break;
                            }
                            float dot3 = Vec2.dot(this.m_normal, tempPolygon.normals[i17]);
                            if (dot3 < dot2) {
                                i18 = i17;
                                dot2 = dot3;
                            }
                            i17++;
                        }
                        int i19 = i18 + 1;
                        if (i19 >= i3) {
                            i19 = 0;
                        }
                        clipVertex.f423611v.set(tempPolygon.vertices[i18]);
                        ContactID contactID = clipVertex.f423610id;
                        contactID.indexA = (byte) 0;
                        contactID.indexB = (byte) i18;
                        ContactID.Type type4 = ContactID.Type.FACE;
                        contactID.typeA = (byte) type4.ordinal();
                        ContactID contactID2 = clipVertex.f423610id;
                        ContactID.Type type5 = ContactID.Type.VERTEX;
                        contactID2.typeB = (byte) type5.ordinal();
                        clipVertex2.f423611v.set(this.m_polygonB.vertices[i19]);
                        ContactID contactID3 = clipVertex2.f423610id;
                        contactID3.indexA = (byte) 0;
                        contactID3.indexB = (byte) i19;
                        contactID3.typeA = (byte) type4.ordinal();
                        clipVertex2.f423610id.typeB = (byte) type5.ordinal();
                        if (this.m_front) {
                            ReferenceFace referenceFace = this.f423614rf;
                            referenceFace.f423615i1 = 0;
                            referenceFace.f423616i2 = 1;
                            referenceFace.f423617v1.set(this.m_v1);
                            this.f423614rf.f423618v2.set(this.m_v2);
                            this.f423614rf.normal.set(this.m_normal1);
                        } else {
                            ReferenceFace referenceFace2 = this.f423614rf;
                            referenceFace2.f423615i1 = 1;
                            referenceFace2.f423616i2 = 0;
                            referenceFace2.f423617v1.set(this.m_v2);
                            this.f423614rf.f423618v2.set(this.m_v1);
                            this.f423614rf.normal.set(this.m_normal1).negateLocal();
                        }
                    } else {
                        manifold.type = Manifold.ManifoldType.FACE_B;
                        clipVertex.f423611v.set(this.m_v1);
                        ContactID contactID4 = clipVertex.f423610id;
                        contactID4.indexA = (byte) 0;
                        contactID4.indexB = (byte) ePAxis2.index;
                        ContactID.Type type6 = ContactID.Type.VERTEX;
                        contactID4.typeA = (byte) type6.ordinal();
                        ContactID contactID5 = clipVertex.f423610id;
                        ContactID.Type type7 = ContactID.Type.FACE;
                        contactID5.typeB = (byte) type7.ordinal();
                        clipVertex2.f423611v.set(this.m_v2);
                        ContactID contactID6 = clipVertex2.f423610id;
                        contactID6.indexA = (byte) 0;
                        contactID6.indexB = (byte) ePAxis2.index;
                        contactID6.typeA = (byte) type6.ordinal();
                        clipVertex2.f423610id.typeB = (byte) type7.ordinal();
                        ReferenceFace referenceFace3 = this.f423614rf;
                        int i26 = ePAxis2.index;
                        referenceFace3.f423615i1 = i26;
                        int i27 = i26 + 1;
                        TempPolygon tempPolygon2 = this.m_polygonB;
                        referenceFace3.f423616i2 = i27 < tempPolygon2.count ? i26 + 1 : 0;
                        referenceFace3.f423617v1.set(tempPolygon2.vertices[i26]);
                        ReferenceFace referenceFace4 = this.f423614rf;
                        referenceFace4.f423618v2.set(this.m_polygonB.vertices[referenceFace4.f423616i2]);
                        ReferenceFace referenceFace5 = this.f423614rf;
                        referenceFace5.normal.set(this.m_polygonB.normals[referenceFace5.f423615i1]);
                    }
                    ReferenceFace referenceFace6 = this.f423614rf;
                    Vec2 vec292 = referenceFace6.sideNormal1;
                    Vec2 vec293 = referenceFace6.normal;
                    vec292.set(vec293.f423650y, -vec293.f423649x);
                    ReferenceFace referenceFace7 = this.f423614rf;
                    referenceFace7.sideNormal2.set(referenceFace7.sideNormal1).negateLocal();
                    ReferenceFace referenceFace8 = this.f423614rf;
                    referenceFace8.sideOffset1 = Vec2.dot(referenceFace8.sideNormal1, referenceFace8.f423617v1);
                    ReferenceFace referenceFace9 = this.f423614rf;
                    referenceFace9.sideOffset2 = Vec2.dot(referenceFace9.sideNormal2, referenceFace9.f423618v2);
                    ClipVertex[] clipVertexArr2 = this.clipPoints1;
                    ClipVertex[] clipVertexArr3 = this.f423612ie;
                    ReferenceFace referenceFace10 = this.f423614rf;
                    if (Collision.clipSegmentToLine(clipVertexArr2, clipVertexArr3, referenceFace10.sideNormal1, referenceFace10.sideOffset1, referenceFace10.f423615i1) < 2) {
                        return;
                    }
                    ClipVertex[] clipVertexArr4 = this.clipPoints2;
                    ClipVertex[] clipVertexArr5 = this.clipPoints1;
                    ReferenceFace referenceFace11 = this.f423614rf;
                    if (Collision.clipSegmentToLine(clipVertexArr4, clipVertexArr5, referenceFace11.sideNormal2, referenceFace11.sideOffset2, referenceFace11.f423616i2) < 2) {
                        return;
                    }
                    if (ePAxis2.type == EPAxis.Type.EDGE_A) {
                        manifold.localNormal.set(this.f423614rf.normal);
                        manifold.localPoint.set(this.f423614rf.f423617v1);
                    } else {
                        manifold.localNormal.set(polygonShape.m_normals[this.f423614rf.f423615i1]);
                        manifold.localPoint.set(polygonShape.m_vertices[this.f423614rf.f423615i1]);
                    }
                    int i28 = 0;
                    for (int i29 = 0; i29 < 2; i29++) {
                        if (Vec2.dot(this.f423614rf.normal, this.temp.set(this.clipPoints2[i29].f423611v).subLocal(this.f423614rf.f423617v1)) <= this.m_radius) {
                            ManifoldPoint manifoldPoint = manifold.points[i28];
                            if (ePAxis2.type == EPAxis.Type.EDGE_A) {
                                Transform.mulTransToOutUnsafe(this.m_xf, this.clipPoints2[i29].f423611v, manifoldPoint.localPoint);
                                manifoldPoint.f423627id.set(this.clipPoints2[i29].f423610id);
                            } else {
                                manifoldPoint.localPoint.set(this.clipPoints2[i29].f423611v);
                                ContactID contactID7 = manifoldPoint.f423627id;
                                ContactID contactID8 = this.clipPoints2[i29].f423610id;
                                contactID7.typeA = contactID8.typeB;
                                contactID7.typeB = contactID8.typeA;
                                contactID7.indexA = contactID8.indexB;
                                contactID7.indexB = contactID8.indexA;
                            }
                            i28++;
                        }
                    }
                    manifold.pointCount = i28;
                }
            }
        }

        public void computeEdgeSeparation(EPAxis ePAxis) {
            ePAxis.type = EPAxis.Type.EDGE_A;
            ePAxis.index = !this.m_front ? 1 : 0;
            ePAxis.separation = Float.MAX_VALUE;
            Vec2 vec2 = this.m_normal;
            float f16 = vec2.f423649x;
            float f17 = vec2.f423650y;
            int i3 = 0;
            while (true) {
                TempPolygon tempPolygon = this.m_polygonB;
                if (i3 < tempPolygon.count) {
                    Vec2 vec22 = tempPolygon.vertices[i3];
                    float f18 = vec22.f423649x;
                    Vec2 vec23 = this.m_v1;
                    float f19 = ((f18 - vec23.f423649x) * f16) + ((vec22.f423650y - vec23.f423650y) * f17);
                    if (f19 < ePAxis.separation) {
                        ePAxis.separation = f19;
                    }
                    i3++;
                } else {
                    return;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x00ae  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x00b6 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void computePolygonSeparation(EPAxis ePAxis) {
            ePAxis.type = EPAxis.Type.UNKNOWN;
            ePAxis.index = -1;
            ePAxis.separation = -3.4028235E38f;
            Vec2 vec2 = this.perp;
            Vec2 vec22 = this.m_normal;
            vec2.f423649x = -vec22.f423650y;
            vec2.f423650y = vec22.f423649x;
            int i3 = 0;
            while (true) {
                TempPolygon tempPolygon = this.m_polygonB;
                if (i3 < tempPolygon.count) {
                    Vec2 vec23 = tempPolygon.normals[i3];
                    Vec2 vec24 = tempPolygon.vertices[i3];
                    Vec2 vec25 = this.f423613n;
                    float f16 = -vec23.f423649x;
                    vec25.f423649x = f16;
                    float f17 = -vec23.f423650y;
                    vec25.f423650y = f17;
                    float f18 = vec24.f423649x;
                    Vec2 vec26 = this.m_v1;
                    float f19 = f18 - vec26.f423649x;
                    float f26 = vec24.f423650y;
                    float f27 = (f19 * f16) + ((f26 - vec26.f423650y) * f17);
                    Vec2 vec27 = this.m_v2;
                    float min = MathUtils.min(f27, (f16 * (f18 - vec27.f423649x)) + (f17 * (f26 - vec27.f423650y)));
                    if (min > this.m_radius) {
                        ePAxis.type = EPAxis.Type.EDGE_B;
                        ePAxis.index = i3;
                        ePAxis.separation = min;
                        return;
                    }
                    Vec2 vec28 = this.f423613n;
                    float f28 = vec28.f423649x;
                    Vec2 vec29 = this.perp;
                    if ((f28 * vec29.f423649x) + (vec28.f423650y * vec29.f423650y) >= 0.0f) {
                        if (Vec2.dot(this.temp.set(vec28).subLocal(this.m_upperLimit), this.m_normal) < -0.03490659f) {
                            i3++;
                        }
                        if (min <= ePAxis.separation) {
                            ePAxis.type = EPAxis.Type.EDGE_B;
                            ePAxis.index = i3;
                            ePAxis.separation = min;
                        }
                        i3++;
                    } else {
                        if (Vec2.dot(this.temp.set(vec28).subLocal(this.m_lowerLimit), this.m_normal) < -0.03490659f) {
                            i3++;
                        }
                        if (min <= ePAxis.separation) {
                        }
                        i3++;
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class EdgeResults {
        public int edgeIndex;
        public float separation;

        EdgeResults() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum PointState {
        NULL_STATE,
        ADD_STATE,
        PERSIST_STATE,
        REMOVE_STATE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class ReferenceFace {

        /* renamed from: i1, reason: collision with root package name */
        int f423615i1;

        /* renamed from: i2, reason: collision with root package name */
        int f423616i2;
        float sideOffset1;
        float sideOffset2;

        /* renamed from: v1, reason: collision with root package name */
        final Vec2 f423617v1 = new Vec2();

        /* renamed from: v2, reason: collision with root package name */
        final Vec2 f423618v2 = new Vec2();
        final Vec2 normal = new Vec2();
        final Vec2 sideNormal1 = new Vec2();
        final Vec2 sideNormal2 = new Vec2();

        ReferenceFace() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class TempPolygon {
        int count;
        final Vec2[] vertices = new Vec2[8];
        final Vec2[] normals = new Vec2[8];

        public TempPolygon() {
            int i3 = 0;
            while (true) {
                Vec2[] vec2Arr = this.vertices;
                if (i3 < vec2Arr.length) {
                    vec2Arr[i3] = new Vec2();
                    this.normals[i3] = new Vec2();
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    public Collision(IWorldPool iWorldPool) {
        this.results1 = new EdgeResults();
        this.results2 = new EdgeResults();
        this.incidentEdge = r1;
        this.clipPoints1 = r2;
        this.clipPoints2 = r0;
        ClipVertex[] clipVertexArr = {new ClipVertex(), new ClipVertex()};
        ClipVertex[] clipVertexArr2 = {new ClipVertex(), new ClipVertex()};
        ClipVertex[] clipVertexArr3 = {new ClipVertex(), new ClipVertex()};
        this.pool = iWorldPool;
    }

    public static final int clipSegmentToLine(ClipVertex[] clipVertexArr, ClipVertex[] clipVertexArr2, Vec2 vec2, float f16, int i3) {
        int i16 = 0;
        ClipVertex clipVertex = clipVertexArr2[0];
        ClipVertex clipVertex2 = clipVertexArr2[1];
        Vec2 vec22 = clipVertex.f423611v;
        Vec2 vec23 = clipVertex2.f423611v;
        float dot = Vec2.dot(vec2, vec22) - f16;
        float dot2 = Vec2.dot(vec2, vec23) - f16;
        if (dot <= 0.0f) {
            clipVertexArr[0].set(clipVertex);
            i16 = 1;
        }
        if (dot2 <= 0.0f) {
            clipVertexArr[i16].set(clipVertex2);
            i16++;
        }
        if (dot * dot2 < 0.0f) {
            float f17 = dot / (dot - dot2);
            ClipVertex clipVertex3 = clipVertexArr[i16];
            Vec2 vec24 = clipVertex3.f423611v;
            float f18 = vec22.f423649x;
            vec24.f423649x = f18 + ((vec23.f423649x - f18) * f17);
            float f19 = vec22.f423650y;
            vec24.f423650y = f19 + (f17 * (vec23.f423650y - f19));
            ContactID contactID = clipVertex3.f423610id;
            contactID.indexA = (byte) i3;
            contactID.indexB = clipVertex.f423610id.indexB;
            contactID.typeA = (byte) ContactID.Type.VERTEX.ordinal();
            clipVertex3.f423610id.typeB = (byte) ContactID.Type.FACE.ordinal();
            return i16 + 1;
        }
        return i16;
    }

    public static final void getPointStates(PointState[] pointStateArr, PointState[] pointStateArr2, Manifold manifold, Manifold manifold2) {
        for (int i3 = 0; i3 < 2; i3++) {
            PointState pointState = PointState.NULL_STATE;
            pointStateArr[i3] = pointState;
            pointStateArr2[i3] = pointState;
        }
        for (int i16 = 0; i16 < manifold.pointCount; i16++) {
            ContactID contactID = manifold.points[i16].f423627id;
            pointStateArr[i16] = PointState.REMOVE_STATE;
            int i17 = 0;
            while (true) {
                if (i17 >= manifold2.pointCount) {
                    break;
                }
                if (manifold2.points[i17].f423627id.isEqual(contactID)) {
                    pointStateArr[i16] = PointState.PERSIST_STATE;
                    break;
                }
                i17++;
            }
        }
        for (int i18 = 0; i18 < manifold2.pointCount; i18++) {
            ContactID contactID2 = manifold2.points[i18].f423627id;
            pointStateArr2[i18] = PointState.ADD_STATE;
            int i19 = 0;
            while (true) {
                if (i19 >= manifold.pointCount) {
                    break;
                }
                if (manifold.points[i19].f423627id.isEqual(contactID2)) {
                    pointStateArr2[i18] = PointState.PERSIST_STATE;
                    break;
                }
                i19++;
            }
        }
    }

    public final void collideCircles(Manifold manifold, CircleShape circleShape, Transform transform, CircleShape circleShape2, Transform transform2) {
        manifold.pointCount = 0;
        Vec2 vec2 = circleShape.m_p;
        Vec2 vec22 = circleShape2.m_p;
        Rot rot = transform.f423648q;
        float f16 = rot.f423641c;
        float f17 = vec2.f423649x;
        float f18 = rot.f423642s;
        float f19 = vec2.f423650y;
        Vec2 vec23 = transform.f423647p;
        float f26 = ((f16 * f17) - (f18 * f19)) + vec23.f423649x;
        float f27 = (f18 * f17) + (f16 * f19) + vec23.f423650y;
        Rot rot2 = transform2.f423648q;
        float f28 = rot2.f423641c;
        float f29 = vec22.f423649x;
        float f36 = rot2.f423642s;
        float f37 = vec22.f423650y;
        Vec2 vec24 = transform2.f423647p;
        float f38 = (((f28 * f29) - (f36 * f37)) + vec24.f423649x) - f26;
        float f39 = (((f36 * f29) + (f28 * f37)) + vec24.f423650y) - f27;
        float f46 = (f38 * f38) + (f39 * f39);
        float f47 = circleShape.m_radius + circleShape2.m_radius;
        if (f46 > f47 * f47) {
            return;
        }
        manifold.type = Manifold.ManifoldType.CIRCLES;
        manifold.localPoint.set(vec2);
        manifold.localNormal.setZero();
        manifold.pointCount = 1;
        manifold.points[0].localPoint.set(vec22);
        manifold.points[0].f423627id.zero();
    }

    public void collideEdgeAndCircle(Manifold manifold, EdgeShape edgeShape, Transform transform, CircleShape circleShape, Transform transform2) {
        manifold.pointCount = 0;
        Transform.mulToOutUnsafe(transform2, circleShape.m_p, this.temp);
        Transform.mulTransToOutUnsafe(transform, this.temp, this.Q);
        Vec2 vec2 = edgeShape.m_vertex1;
        Vec2 vec22 = edgeShape.m_vertex2;
        this.f423605e.set(vec22).subLocal(vec2);
        float dot = Vec2.dot(this.f423605e, this.temp.set(vec22).subLocal(this.Q));
        float dot2 = Vec2.dot(this.f423605e, this.temp.set(this.Q).subLocal(vec2));
        float f16 = edgeShape.m_radius + circleShape.m_radius;
        ContactID contactID = this.f423604cf;
        contactID.indexB = (byte) 0;
        ContactID.Type type = ContactID.Type.VERTEX;
        contactID.typeB = (byte) type.ordinal();
        if (dot2 <= 0.0f) {
            f423603d.set(this.Q).subLocal(vec2);
            Vec2 vec23 = f423603d;
            if (Vec2.dot(vec23, vec23) > f16 * f16) {
                return;
            }
            if (edgeShape.m_hasVertex0) {
                this.f423606e1.set(vec2).subLocal(edgeShape.m_vertex0);
                if (Vec2.dot(this.f423606e1, this.temp.set(vec2).subLocal(this.Q)) > 0.0f) {
                    return;
                }
            }
            ContactID contactID2 = this.f423604cf;
            contactID2.indexA = (byte) 0;
            contactID2.typeA = (byte) type.ordinal();
            manifold.pointCount = 1;
            manifold.type = Manifold.ManifoldType.CIRCLES;
            manifold.localNormal.setZero();
            manifold.localPoint.set(vec2);
            manifold.points[0].f423627id.set(this.f423604cf);
            manifold.points[0].localPoint.set(circleShape.m_p);
            return;
        }
        if (dot <= 0.0f) {
            f423603d.set(this.Q).subLocal(vec22);
            Vec2 vec24 = f423603d;
            if (Vec2.dot(vec24, vec24) > f16 * f16) {
                return;
            }
            if (edgeShape.m_hasVertex3) {
                Vec2 vec25 = edgeShape.m_vertex3;
                Vec2 vec26 = this.f423606e1;
                vec26.set(vec25).subLocal(vec22);
                if (Vec2.dot(vec26, this.temp.set(this.Q).subLocal(vec22)) > 0.0f) {
                    return;
                }
            }
            ContactID contactID3 = this.f423604cf;
            contactID3.indexA = (byte) 1;
            contactID3.typeA = (byte) type.ordinal();
            manifold.pointCount = 1;
            manifold.type = Manifold.ManifoldType.CIRCLES;
            manifold.localNormal.setZero();
            manifold.localPoint.set(vec22);
            manifold.points[0].f423627id.set(this.f423604cf);
            manifold.points[0].localPoint.set(circleShape.m_p);
            return;
        }
        Vec2 vec27 = this.f423605e;
        float dot3 = Vec2.dot(vec27, vec27);
        this.P.set(vec2).mulLocal(dot).addLocal(this.temp.set(vec22).mulLocal(dot2));
        this.P.mulLocal(1.0f / dot3);
        f423603d.set(this.Q).subLocal(this.P);
        Vec2 vec28 = f423603d;
        if (Vec2.dot(vec28, vec28) > f16 * f16) {
            return;
        }
        Vec2 vec29 = this.f423607n;
        Vec2 vec210 = this.f423605e;
        vec29.f423649x = -vec210.f423650y;
        vec29.f423650y = vec210.f423649x;
        if (Vec2.dot(vec29, this.temp.set(this.Q).subLocal(vec2)) < 0.0f) {
            Vec2 vec211 = this.f423607n;
            vec211.set(-vec211.f423649x, -vec211.f423650y);
        }
        this.f423607n.normalize();
        ContactID contactID4 = this.f423604cf;
        contactID4.indexA = (byte) 0;
        contactID4.typeA = (byte) ContactID.Type.FACE.ordinal();
        manifold.pointCount = 1;
        manifold.type = Manifold.ManifoldType.FACE_A;
        manifold.localNormal.set(this.f423607n);
        manifold.localPoint.set(vec2);
        manifold.points[0].f423627id.set(this.f423604cf);
        manifold.points[0].localPoint.set(circleShape.m_p);
    }

    public void collideEdgeAndPolygon(Manifold manifold, EdgeShape edgeShape, Transform transform, PolygonShape polygonShape, Transform transform2) {
        this.collider.collide(manifold, edgeShape, transform, polygonShape, transform2);
    }

    public final void collidePolygonAndCircle(Manifold manifold, PolygonShape polygonShape, Transform transform, CircleShape circleShape, Transform transform2) {
        manifold.pointCount = 0;
        Vec2 vec2 = circleShape.m_p;
        Rot rot = transform2.f423648q;
        Rot rot2 = transform.f423648q;
        float f16 = rot.f423641c;
        float f17 = vec2.f423649x;
        float f18 = rot.f423642s;
        float f19 = vec2.f423650y;
        Vec2 vec22 = transform2.f423647p;
        float f26 = ((f16 * f17) - (f18 * f19)) + vec22.f423649x;
        float f27 = (f18 * f17) + (f16 * f19) + vec22.f423650y;
        Vec2 vec23 = transform.f423647p;
        float f28 = f26 - vec23.f423649x;
        float f29 = f27 - vec23.f423650y;
        float f36 = rot2.f423641c;
        float f37 = rot2.f423642s;
        float f38 = (f36 * f28) + (f37 * f29);
        float f39 = ((-f37) * f28) + (f36 * f29);
        float f46 = polygonShape.m_radius + circleShape.m_radius;
        int i3 = polygonShape.m_count;
        Vec2[] vec2Arr = polygonShape.m_vertices;
        Vec2[] vec2Arr2 = polygonShape.m_normals;
        float f47 = -3.4028235E38f;
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            Vec2 vec24 = vec2Arr[i17];
            float f48 = f38 - vec24.f423649x;
            float f49 = f39 - vec24.f423650y;
            Vec2 vec25 = vec2Arr2[i17];
            float f56 = (vec25.f423649x * f48) + (vec25.f423650y * f49);
            if (f56 > f46) {
                return;
            }
            if (f56 > f47) {
                i16 = i17;
                f47 = f56;
            }
        }
        int i18 = i16 + 1;
        if (i18 >= i3) {
            i18 = 0;
        }
        Vec2 vec26 = vec2Arr[i16];
        Vec2 vec27 = vec2Arr[i18];
        if (f47 < 1.1920929E-7f) {
            manifold.pointCount = 1;
            manifold.type = Manifold.ManifoldType.FACE_A;
            Vec2 vec28 = vec2Arr2[i16];
            Vec2 vec29 = manifold.localNormal;
            vec29.f423649x = vec28.f423649x;
            vec29.f423650y = vec28.f423650y;
            Vec2 vec210 = manifold.localPoint;
            vec210.f423649x = (vec26.f423649x + vec27.f423649x) * 0.5f;
            vec210.f423650y = (vec26.f423650y + vec27.f423650y) * 0.5f;
            ManifoldPoint manifoldPoint = manifold.points[0];
            Vec2 vec211 = manifoldPoint.localPoint;
            vec211.f423649x = vec2.f423649x;
            vec211.f423650y = vec2.f423650y;
            manifoldPoint.f423627id.zero();
            return;
        }
        float f57 = vec26.f423649x;
        float f58 = vec26.f423650y;
        float f59 = vec27.f423649x;
        float f65 = vec27.f423650y;
        float f66 = ((f38 - f59) * (f57 - f59)) + ((f39 - f65) * (f58 - f65));
        if (((f38 - f57) * (f59 - f57)) + ((f39 - f58) * (f65 - f58)) <= 0.0f) {
            float f67 = f38 - f57;
            float f68 = f39 - f58;
            if ((f67 * f67) + (f68 * f68) > f46 * f46) {
                return;
            }
            manifold.pointCount = 1;
            manifold.type = Manifold.ManifoldType.FACE_A;
            Vec2 vec212 = manifold.localNormal;
            vec212.f423649x = f38 - f57;
            vec212.f423650y = f39 - f58;
            vec212.normalize();
            manifold.localPoint.set(vec26);
            manifold.points[0].localPoint.set(vec2);
            manifold.points[0].f423627id.zero();
            return;
        }
        if (f66 <= 0.0f) {
            float f69 = f38 - f59;
            float f75 = f39 - f65;
            if ((f69 * f69) + (f75 * f75) > f46 * f46) {
                return;
            }
            manifold.pointCount = 1;
            manifold.type = Manifold.ManifoldType.FACE_A;
            Vec2 vec213 = manifold.localNormal;
            vec213.f423649x = f38 - f59;
            vec213.f423650y = f39 - f65;
            vec213.normalize();
            manifold.localPoint.set(vec27);
            manifold.points[0].localPoint.set(vec2);
            manifold.points[0].f423627id.zero();
            return;
        }
        float f76 = (f57 + f59) * 0.5f;
        float f77 = (f58 + f65) * 0.5f;
        Vec2 vec214 = vec2Arr2[i16];
        if (((f38 - f76) * vec214.f423649x) + ((f39 - f77) * vec214.f423650y) > f46) {
            return;
        }
        manifold.pointCount = 1;
        manifold.type = Manifold.ManifoldType.FACE_A;
        manifold.localNormal.set(vec214);
        Vec2 vec215 = manifold.localPoint;
        vec215.f423649x = f76;
        vec215.f423650y = f77;
        manifold.points[0].localPoint.set(vec2);
        manifold.points[0].f423627id.zero();
    }

    public final void collidePolygons(Manifold manifold, PolygonShape polygonShape, Transform transform, PolygonShape polygonShape2, Transform transform2) {
        Transform transform3;
        Transform transform4;
        int i3;
        boolean z16;
        PolygonShape polygonShape3;
        float f16;
        float f17;
        manifold.pointCount = 0;
        PolygonShape polygonShape4 = polygonShape2;
        float f18 = polygonShape.m_radius + polygonShape4.m_radius;
        findMaxSeparation(this.results1, polygonShape, transform, polygonShape2, transform2);
        if (this.results1.separation > f18) {
            return;
        }
        findMaxSeparation(this.results2, polygonShape2, transform2, polygonShape, transform);
        EdgeResults edgeResults = this.results2;
        float f19 = edgeResults.separation;
        if (f19 > f18) {
            return;
        }
        EdgeResults edgeResults2 = this.results1;
        if (f19 > (edgeResults2.separation * 0.98f) + 0.001f) {
            int i16 = edgeResults.edgeIndex;
            manifold.type = Manifold.ManifoldType.FACE_B;
            transform4 = transform;
            transform3 = transform2;
            i3 = i16;
            z16 = true;
            polygonShape3 = polygonShape;
        } else {
            int i17 = edgeResults2.edgeIndex;
            manifold.type = Manifold.ManifoldType.FACE_A;
            transform3 = transform;
            transform4 = transform2;
            i3 = i17;
            z16 = false;
            polygonShape3 = polygonShape4;
            polygonShape4 = polygonShape;
        }
        Rot rot = transform3.f423648q;
        findIncidentEdge(this.incidentEdge, polygonShape4, transform3, i3, polygonShape3, transform4);
        int i18 = polygonShape4.m_count;
        Vec2[] vec2Arr = polygonShape4.m_vertices;
        int i19 = i3 + 1;
        if (i19 >= i18) {
            i19 = 0;
        }
        this.f423608v11.set(vec2Arr[i3]);
        this.f423609v12.set(vec2Arr[i19]);
        Vec2 vec2 = this.localTangent;
        Vec2 vec22 = this.f423609v12;
        float f26 = vec22.f423649x;
        Vec2 vec23 = this.f423608v11;
        vec2.f423649x = f26 - vec23.f423649x;
        vec2.f423650y = vec22.f423650y - vec23.f423650y;
        vec2.normalize();
        Vec2 vec24 = this.localNormal;
        Vec2 vec25 = this.localTangent;
        vec24.f423649x = vec25.f423650y * 1.0f;
        vec24.f423650y = vec25.f423649x * (-1.0f);
        Vec2 vec26 = this.planePoint;
        Vec2 vec27 = this.f423608v11;
        float f27 = vec27.f423649x;
        Vec2 vec28 = this.f423609v12;
        vec26.f423649x = (f27 + vec28.f423649x) * 0.5f;
        vec26.f423650y = (vec27.f423650y + vec28.f423650y) * 0.5f;
        Vec2 vec29 = this.tangent;
        float f28 = rot.f423641c;
        float f29 = vec25.f423649x * f28;
        float f36 = rot.f423642s;
        float f37 = vec25.f423650y;
        float f38 = f29 - (f36 * f37);
        vec29.f423649x = f38;
        float f39 = (f36 * vec25.f423649x) + (f28 * f37);
        vec29.f423650y = f39;
        float f46 = f39 * 1.0f;
        float f47 = f38 * (-1.0f);
        Transform.mulToOut(transform3, vec27, vec27);
        Vec2 vec210 = this.f423609v12;
        Transform.mulToOut(transform3, vec210, vec210);
        Vec2 vec211 = this.f423608v11;
        float f48 = vec211.f423649x;
        float f49 = vec211.f423650y;
        float f56 = (f46 * f48) + (f47 * f49);
        Vec2 vec212 = this.tangent;
        float f57 = vec212.f423649x;
        float f58 = vec212.f423650y;
        float f59 = (-((f48 * f57) + (f49 * f58))) + f18;
        Vec2 vec213 = this.f423609v12;
        float f65 = (f57 * vec213.f423649x) + (f58 * vec213.f423650y) + f18;
        vec212.negateLocal();
        int clipSegmentToLine = clipSegmentToLine(this.clipPoints1, this.incidentEdge, this.tangent, f59, i3);
        this.tangent.negateLocal();
        if (clipSegmentToLine < 2 || clipSegmentToLine(this.clipPoints2, this.clipPoints1, this.tangent, f65, i19) < 2) {
            return;
        }
        manifold.localNormal.set(this.localNormal);
        manifold.localPoint.set(this.planePoint);
        int i26 = 0;
        int i27 = 0;
        for (int i28 = 2; i26 < i28; i28 = 2) {
            ClipVertex clipVertex = this.clipPoints2[i26];
            Vec2 vec214 = clipVertex.f423611v;
            float f66 = vec214.f423649x;
            float f67 = vec214.f423650y;
            if (((f46 * f66) + (f47 * f67)) - f56 <= f18) {
                ManifoldPoint manifoldPoint = manifold.points[i27];
                Vec2 vec215 = manifoldPoint.localPoint;
                Vec2 vec216 = transform4.f423647p;
                f16 = f56;
                float f68 = f66 - vec216.f423649x;
                float f69 = f67 - vec216.f423650y;
                Rot rot2 = transform4.f423648q;
                float f75 = rot2.f423641c;
                float f76 = rot2.f423642s;
                f17 = f47;
                vec215.f423649x = (f75 * f68) + (f76 * f69);
                vec215.f423650y = ((-f76) * f68) + (f75 * f69);
                manifoldPoint.f423627id.set(clipVertex.f423610id);
                if (z16) {
                    manifoldPoint.f423627id.flip();
                }
                i27++;
            } else {
                f16 = f56;
                f17 = f47;
            }
            i26++;
            f56 = f16;
            f47 = f17;
        }
        manifold.pointCount = i27;
    }

    public final float edgeSeparation(PolygonShape polygonShape, Transform transform, int i3, PolygonShape polygonShape2, Transform transform2) {
        int i16 = polygonShape.m_count;
        Vec2[] vec2Arr = polygonShape.m_vertices;
        Vec2[] vec2Arr2 = polygonShape.m_normals;
        int i17 = polygonShape2.m_count;
        Vec2[] vec2Arr3 = polygonShape2.m_vertices;
        Rot rot = transform.f423648q;
        Rot rot2 = transform2.f423648q;
        Vec2 vec2 = vec2Arr2[i3];
        float f16 = rot.f423641c;
        float f17 = vec2.f423649x;
        float f18 = rot.f423642s;
        float f19 = vec2.f423650y;
        float f26 = (f16 * f17) - (f18 * f19);
        float f27 = (f18 * f17) + (f16 * f19);
        float f28 = rot2.f423641c;
        float f29 = rot2.f423642s;
        float f36 = (f28 * f26) + (f29 * f27);
        float f37 = ((-f29) * f26) + (f28 * f27);
        float f38 = Float.MAX_VALUE;
        int i18 = 0;
        for (int i19 = 0; i19 < i17; i19++) {
            Vec2 vec22 = vec2Arr3[i19];
            float f39 = (vec22.f423649x * f36) + (vec22.f423650y * f37);
            if (f39 < f38) {
                i18 = i19;
                f38 = f39;
            }
        }
        Vec2 vec23 = vec2Arr[i3];
        float f46 = rot.f423641c;
        float f47 = vec23.f423649x;
        float f48 = rot.f423642s;
        float f49 = vec23.f423650y;
        Vec2 vec24 = transform.f423647p;
        float f56 = ((f46 * f47) - (f48 * f49)) + vec24.f423649x;
        float f57 = (f48 * f47) + (f46 * f49) + vec24.f423650y;
        Vec2 vec25 = vec2Arr3[i18];
        float f58 = rot2.f423641c;
        float f59 = vec25.f423649x;
        float f65 = rot2.f423642s;
        float f66 = vec25.f423650y;
        Vec2 vec26 = transform2.f423647p;
        return (((((f58 * f59) - (f65 * f66)) + vec26.f423649x) - f56) * f26) + (((((f65 * f59) + (f58 * f66)) + vec26.f423650y) - f57) * f27);
    }

    public final void findIncidentEdge(ClipVertex[] clipVertexArr, PolygonShape polygonShape, Transform transform, int i3, PolygonShape polygonShape2, Transform transform2) {
        int i16 = polygonShape.m_count;
        Vec2[] vec2Arr = polygonShape.m_normals;
        int i17 = polygonShape2.m_count;
        Vec2[] vec2Arr2 = polygonShape2.m_vertices;
        Vec2[] vec2Arr3 = polygonShape2.m_normals;
        int i18 = 0;
        ClipVertex clipVertex = clipVertexArr[0];
        ClipVertex clipVertex2 = clipVertexArr[1];
        Rot rot = transform.f423648q;
        Rot rot2 = transform2.f423648q;
        Vec2 vec2 = vec2Arr[i3];
        float f16 = rot.f423641c;
        float f17 = vec2.f423649x;
        float f18 = rot.f423642s;
        float f19 = vec2.f423650y;
        float f26 = (f16 * f17) - (f18 * f19);
        float f27 = (f18 * f17) + (f16 * f19);
        float f28 = rot2.f423641c;
        float f29 = rot2.f423642s;
        float f36 = (f28 * f26) + (f29 * f27);
        float f37 = ((-f29) * f26) + (f28 * f27);
        float f38 = Float.MAX_VALUE;
        int i19 = 0;
        for (int i26 = 0; i26 < i17; i26++) {
            Vec2 vec22 = vec2Arr3[i26];
            float f39 = (vec22.f423649x * f36) + (vec22.f423650y * f37);
            if (f39 < f38) {
                i19 = i26;
                f38 = f39;
            }
        }
        int i27 = i19 + 1;
        if (i27 < i17) {
            i18 = i27;
        }
        Vec2 vec23 = vec2Arr2[i19];
        Vec2 vec24 = clipVertex.f423611v;
        float f46 = rot2.f423641c;
        float f47 = vec23.f423649x * f46;
        float f48 = rot2.f423642s;
        float f49 = vec23.f423650y;
        Vec2 vec25 = transform2.f423647p;
        vec24.f423649x = (f47 - (f48 * f49)) + vec25.f423649x;
        vec24.f423650y = (f48 * vec23.f423649x) + (f46 * f49) + vec25.f423650y;
        ContactID contactID = clipVertex.f423610id;
        byte b16 = (byte) i3;
        contactID.indexA = b16;
        contactID.indexB = (byte) i19;
        ContactID.Type type = ContactID.Type.FACE;
        contactID.typeA = (byte) type.ordinal();
        ContactID contactID2 = clipVertex.f423610id;
        ContactID.Type type2 = ContactID.Type.VERTEX;
        contactID2.typeB = (byte) type2.ordinal();
        Vec2 vec26 = vec2Arr2[i18];
        Vec2 vec27 = clipVertex2.f423611v;
        float f56 = rot2.f423641c;
        float f57 = vec26.f423649x * f56;
        float f58 = rot2.f423642s;
        float f59 = vec26.f423650y;
        Vec2 vec28 = transform2.f423647p;
        vec27.f423649x = (f57 - (f58 * f59)) + vec28.f423649x;
        vec27.f423650y = (f58 * vec26.f423649x) + (f56 * f59) + vec28.f423650y;
        ContactID contactID3 = clipVertex2.f423610id;
        contactID3.indexA = b16;
        contactID3.indexB = (byte) i18;
        contactID3.typeA = (byte) type.ordinal();
        clipVertex2.f423610id.typeB = (byte) type2.ordinal();
    }

    public final void findMaxSeparation(EdgeResults edgeResults, PolygonShape polygonShape, Transform transform, PolygonShape polygonShape2, Transform transform2) {
        int i3;
        float f16;
        char c16;
        int i16;
        int i17 = polygonShape.m_count;
        Vec2[] vec2Arr = polygonShape.m_normals;
        Vec2 vec2 = polygonShape.m_centroid;
        Vec2 vec22 = polygonShape2.m_centroid;
        Rot rot = transform2.f423648q;
        Rot rot2 = transform.f423648q;
        float f17 = rot.f423641c;
        float f18 = vec22.f423649x;
        float f19 = rot.f423642s;
        float f26 = vec22.f423650y;
        Vec2 vec23 = transform2.f423647p;
        float f27 = ((f17 * f18) - (f19 * f26)) + vec23.f423649x;
        float f28 = (f19 * f18) + (f17 * f26) + vec23.f423650y;
        float f29 = rot2.f423641c;
        float f36 = vec2.f423649x;
        float f37 = rot2.f423642s;
        float f38 = vec2.f423650y;
        Vec2 vec24 = transform.f423647p;
        float f39 = f27 - (((f29 * f36) - (f37 * f38)) + vec24.f423649x);
        float f46 = f28 - (((f36 * f37) + (f38 * f29)) + vec24.f423650y);
        float f47 = (f29 * f39) + (f37 * f46);
        float f48 = ((-f37) * f39) + (f29 * f46);
        float f49 = -3.4028235E38f;
        int i18 = 0;
        for (int i19 = 0; i19 < i17; i19++) {
            Vec2 vec25 = vec2Arr[i19];
            float f56 = (vec25.f423649x * f47) + (vec25.f423650y * f48);
            if (f56 > f49) {
                i18 = i19;
                f49 = f56;
            }
        }
        float edgeSeparation = edgeSeparation(polygonShape, transform, i18, polygonShape2, transform2);
        int i26 = i18 - 1;
        if (i26 < 0) {
            i26 = i17 - 1;
        }
        int i27 = i26;
        float edgeSeparation2 = edgeSeparation(polygonShape, transform, i27, polygonShape2, transform2);
        int i28 = i18 + 1;
        if (i28 < i17) {
            i3 = i28;
        } else {
            i3 = 0;
        }
        float edgeSeparation3 = edgeSeparation(polygonShape, transform, i3, polygonShape2, transform2);
        char c17 = '\uffff';
        if (edgeSeparation2 > edgeSeparation && edgeSeparation2 > edgeSeparation3) {
            c16 = '\uffff';
            f16 = edgeSeparation2;
        } else if (edgeSeparation3 > edgeSeparation) {
            f16 = edgeSeparation3;
            c16 = 1;
            i27 = i3;
        } else {
            edgeResults.edgeIndex = i18;
            edgeResults.separation = edgeSeparation;
            return;
        }
        while (true) {
            if (c16 == c17) {
                i16 = i27 - 1;
                if (i16 < 0) {
                    i16 = i17 - 1;
                }
            } else {
                i16 = i27 + 1;
                if (i16 >= i17) {
                    i16 = 0;
                }
            }
            int i29 = i16;
            char c18 = c17;
            float edgeSeparation4 = edgeSeparation(polygonShape, transform, i29, polygonShape2, transform2);
            if (edgeSeparation4 > f16) {
                f16 = edgeSeparation4;
                i27 = i29;
                c17 = c18;
            } else {
                edgeResults.edgeIndex = i27;
                edgeResults.separation = f16;
                return;
            }
        }
    }

    public final boolean testOverlap(Shape shape, int i3, Shape shape2, int i16, Transform transform, Transform transform2) {
        this.input.proxyA.set(shape, i3);
        this.input.proxyB.set(shape2, i16);
        this.input.transformA.set(transform);
        this.input.transformB.set(transform2);
        this.input.useRadii = true;
        this.cache.count = 0;
        this.pool.getDistance().distance(this.output, this.cache, this.input);
        if (this.output.distance < 1.1920929E-6f) {
            return true;
        }
        return false;
    }
}
