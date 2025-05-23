package org.jbox2d.collision;

import org.jbox2d.collision.Distance;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Sweep;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public class SeparationFunction {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public Distance.DistanceProxy m_proxyA;
    public Distance.DistanceProxy m_proxyB;
    public Sweep m_sweepA;
    public Sweep m_sweepB;
    public Type m_type;
    public final Vec2 m_localPoint = new Vec2();
    public final Vec2 m_axis = new Vec2();
    private final Vec2 localPointA = new Vec2();
    private final Vec2 localPointB = new Vec2();
    private final Vec2 pointA = new Vec2();
    private final Vec2 pointB = new Vec2();
    private final Vec2 localPointA1 = new Vec2();
    private final Vec2 localPointA2 = new Vec2();
    private final Vec2 normal = new Vec2();
    private final Vec2 localPointB1 = new Vec2();
    private final Vec2 localPointB2 = new Vec2();
    private final Vec2 temp = new Vec2();
    private final Transform xfa = new Transform();
    private final Transform xfb = new Transform();
    private final Vec2 axisA = new Vec2();
    private final Vec2 axisB = new Vec2();

    /* compiled from: P */
    /* renamed from: org.jbox2d.collision.SeparationFunction$1, reason: invalid class name */
    /* loaded from: classes29.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jbox2d$collision$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$org$jbox2d$collision$Type = iArr;
            try {
                iArr[Type.POINTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jbox2d$collision$Type[Type.FACE_A.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jbox2d$collision$Type[Type.FACE_B.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public float evaluate(int i3, int i16, float f16) {
        this.m_sweepA.getTransform(this.xfa, f16);
        this.m_sweepB.getTransform(this.xfb, f16);
        int i17 = AnonymousClass1.$SwitchMap$org$jbox2d$collision$Type[this.m_type.ordinal()];
        if (i17 != 1) {
            if (i17 != 2) {
                if (i17 != 3) {
                    return 0.0f;
                }
                Rot.mulToOutUnsafe(this.xfb.f423648q, this.m_axis, this.normal);
                Transform.mulToOutUnsafe(this.xfb, this.m_localPoint, this.pointB);
                Rot.mulTransUnsafe(this.xfa.f423648q, this.normal.negateLocal(), this.axisA);
                this.normal.negateLocal();
                this.localPointA.set(this.m_proxyA.getVertex(i3));
                Transform.mulToOutUnsafe(this.xfa, this.localPointA, this.pointA);
                return Vec2.dot(this.pointA.subLocal(this.pointB), this.normal);
            }
            Rot.mulToOutUnsafe(this.xfa.f423648q, this.m_axis, this.normal);
            Transform.mulToOutUnsafe(this.xfa, this.m_localPoint, this.pointA);
            Rot.mulTransUnsafe(this.xfb.f423648q, this.normal.negateLocal(), this.axisB);
            this.normal.negateLocal();
            this.localPointB.set(this.m_proxyB.getVertex(i16));
            Transform.mulToOutUnsafe(this.xfb, this.localPointB, this.pointB);
            return Vec2.dot(this.pointB.subLocal(this.pointA), this.normal);
        }
        Rot.mulTransUnsafe(this.xfa.f423648q, this.m_axis, this.axisA);
        Rot.mulTransUnsafe(this.xfb.f423648q, this.m_axis.negateLocal(), this.axisB);
        this.m_axis.negateLocal();
        this.localPointA.set(this.m_proxyA.getVertex(i3));
        this.localPointB.set(this.m_proxyB.getVertex(i16));
        Transform.mulToOutUnsafe(this.xfa, this.localPointA, this.pointA);
        Transform.mulToOutUnsafe(this.xfb, this.localPointB, this.pointB);
        return Vec2.dot(this.pointB.subLocal(this.pointA), this.m_axis);
    }

    public float findMinSeparation(int[] iArr, float f16) {
        this.m_sweepA.getTransform(this.xfa, f16);
        this.m_sweepB.getTransform(this.xfb, f16);
        int i3 = AnonymousClass1.$SwitchMap$org$jbox2d$collision$Type[this.m_type.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    iArr[0] = -1;
                    iArr[1] = -1;
                    return 0.0f;
                }
                Rot.mulToOutUnsafe(this.xfb.f423648q, this.m_axis, this.normal);
                Transform.mulToOutUnsafe(this.xfb, this.m_localPoint, this.pointB);
                Rot.mulTransUnsafe(this.xfa.f423648q, this.normal.negateLocal(), this.axisA);
                this.normal.negateLocal();
                iArr[1] = -1;
                int support = this.m_proxyA.getSupport(this.axisA);
                iArr[0] = support;
                this.localPointA.set(this.m_proxyA.getVertex(support));
                Transform.mulToOutUnsafe(this.xfa, this.localPointA, this.pointA);
                return Vec2.dot(this.pointA.subLocal(this.pointB), this.normal);
            }
            Rot.mulToOutUnsafe(this.xfa.f423648q, this.m_axis, this.normal);
            Transform.mulToOutUnsafe(this.xfa, this.m_localPoint, this.pointA);
            Rot.mulTransUnsafe(this.xfb.f423648q, this.normal.negateLocal(), this.axisB);
            this.normal.negateLocal();
            iArr[0] = -1;
            int support2 = this.m_proxyB.getSupport(this.axisB);
            iArr[1] = support2;
            this.localPointB.set(this.m_proxyB.getVertex(support2));
            Transform.mulToOutUnsafe(this.xfb, this.localPointB, this.pointB);
            return Vec2.dot(this.pointB.subLocal(this.pointA), this.normal);
        }
        Rot.mulTransUnsafe(this.xfa.f423648q, this.m_axis, this.axisA);
        Rot.mulTransUnsafe(this.xfb.f423648q, this.m_axis.negateLocal(), this.axisB);
        this.m_axis.negateLocal();
        iArr[0] = this.m_proxyA.getSupport(this.axisA);
        iArr[1] = this.m_proxyB.getSupport(this.axisB);
        this.localPointA.set(this.m_proxyA.getVertex(iArr[0]));
        this.localPointB.set(this.m_proxyB.getVertex(iArr[1]));
        Transform.mulToOutUnsafe(this.xfa, this.localPointA, this.pointA);
        Transform.mulToOutUnsafe(this.xfb, this.localPointB, this.pointB);
        return Vec2.dot(this.pointB.subLocal(this.pointA), this.m_axis);
    }

    public float initialize(Distance.SimplexCache simplexCache, Distance.DistanceProxy distanceProxy, Sweep sweep, Distance.DistanceProxy distanceProxy2, Sweep sweep2, float f16) {
        this.m_proxyA = distanceProxy;
        this.m_proxyB = distanceProxy2;
        int i3 = simplexCache.count;
        this.m_sweepA = sweep;
        this.m_sweepB = sweep2;
        sweep.getTransform(this.xfa, f16);
        this.m_sweepB.getTransform(this.xfb, f16);
        if (i3 == 1) {
            this.m_type = Type.POINTS;
            this.localPointA.set(this.m_proxyA.getVertex(simplexCache.indexA[0]));
            this.localPointB.set(this.m_proxyB.getVertex(simplexCache.indexB[0]));
            Transform.mulToOutUnsafe(this.xfa, this.localPointA, this.pointA);
            Transform.mulToOutUnsafe(this.xfb, this.localPointB, this.pointB);
            this.m_axis.set(this.pointB).subLocal(this.pointA);
            return this.m_axis.normalize();
        }
        int[] iArr = simplexCache.indexA;
        int i16 = iArr[0];
        if (i16 == iArr[1]) {
            this.m_type = Type.FACE_B;
            this.localPointB1.set(this.m_proxyB.getVertex(simplexCache.indexB[0]));
            this.localPointB2.set(this.m_proxyB.getVertex(simplexCache.indexB[1]));
            this.temp.set(this.localPointB2).subLocal(this.localPointB1);
            Vec2.crossToOutUnsafe(this.temp, 1.0f, this.m_axis);
            this.m_axis.normalize();
            Rot.mulToOutUnsafe(this.xfb.f423648q, this.m_axis, this.normal);
            this.m_localPoint.set(this.localPointB1).addLocal(this.localPointB2).mulLocal(0.5f);
            Transform.mulToOutUnsafe(this.xfb, this.m_localPoint, this.pointB);
            this.localPointA.set(distanceProxy.getVertex(simplexCache.indexA[0]));
            Transform.mulToOutUnsafe(this.xfa, this.localPointA, this.pointA);
            this.temp.set(this.pointA).subLocal(this.pointB);
            float dot = Vec2.dot(this.temp, this.normal);
            if (dot < 0.0f) {
                this.m_axis.negateLocal();
                return -dot;
            }
            return dot;
        }
        this.m_type = Type.FACE_A;
        this.localPointA1.set(this.m_proxyA.getVertex(i16));
        this.localPointA2.set(this.m_proxyA.getVertex(simplexCache.indexA[1]));
        this.temp.set(this.localPointA2).subLocal(this.localPointA1);
        Vec2.crossToOutUnsafe(this.temp, 1.0f, this.m_axis);
        this.m_axis.normalize();
        Rot.mulToOutUnsafe(this.xfa.f423648q, this.m_axis, this.normal);
        this.m_localPoint.set(this.localPointA1).addLocal(this.localPointA2).mulLocal(0.5f);
        Transform.mulToOutUnsafe(this.xfa, this.m_localPoint, this.pointA);
        this.localPointB.set(this.m_proxyB.getVertex(simplexCache.indexB[0]));
        Transform.mulToOutUnsafe(this.xfb, this.localPointB, this.pointB);
        this.temp.set(this.pointB).subLocal(this.pointA);
        float dot2 = Vec2.dot(this.temp, this.normal);
        if (dot2 < 0.0f) {
            this.m_axis.negateLocal();
            return -dot2;
        }
        return dot2;
    }
}
