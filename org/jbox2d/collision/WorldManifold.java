package org.jbox2d.collision;

import org.jbox2d.collision.Manifold;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes29.dex */
public class WorldManifold {
    private final Vec2 pool3 = new Vec2();
    private final Vec2 pool4 = new Vec2();
    public final Vec2 normal = new Vec2();
    public final Vec2[] points = new Vec2[2];

    /* compiled from: P */
    /* renamed from: org.jbox2d.collision.WorldManifold$1, reason: invalid class name */
    /* loaded from: classes29.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jbox2d$collision$Manifold$ManifoldType;

        static {
            int[] iArr = new int[Manifold.ManifoldType.values().length];
            $SwitchMap$org$jbox2d$collision$Manifold$ManifoldType = iArr;
            try {
                iArr[Manifold.ManifoldType.CIRCLES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jbox2d$collision$Manifold$ManifoldType[Manifold.ManifoldType.FACE_A.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jbox2d$collision$Manifold$ManifoldType[Manifold.ManifoldType.FACE_B.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public WorldManifold() {
        for (int i3 = 0; i3 < 2; i3++) {
            this.points[i3] = new Vec2();
        }
    }

    public final void initialize(Manifold manifold, Transform transform, float f16, Transform transform2, float f17) {
        if (manifold.pointCount == 0) {
            return;
        }
        int i3 = AnonymousClass1.$SwitchMap$org$jbox2d$collision$Manifold$ManifoldType[manifold.type.ordinal()];
        int i16 = 0;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    Vec2 vec2 = this.pool3;
                    Rot.mulToOutUnsafe(transform2.f423648q, manifold.localNormal, this.normal);
                    Transform.mulToOut(transform2, manifold.localPoint, vec2);
                    Vec2 vec22 = this.pool4;
                    while (i16 < manifold.pointCount) {
                        Transform.mulToOut(transform, manifold.points[i16].localPoint, vec22);
                        float f18 = vec22.f423649x;
                        float f19 = f18 - vec2.f423649x;
                        Vec2 vec23 = this.normal;
                        float f26 = vec23.f423649x;
                        float f27 = vec22.f423650y;
                        float f28 = f27 - vec2.f423650y;
                        float f29 = vec23.f423650y;
                        float f36 = f17 - ((f19 * f26) + (f28 * f29));
                        float f37 = (f26 * f36) + f18;
                        float f38 = (f36 * f29) + f27;
                        float f39 = ((-f26) * f16) + f18;
                        float f46 = ((-f29) * f16) + f27;
                        Vec2 vec24 = this.points[i16];
                        vec24.f423649x = (f39 + f37) * 0.5f;
                        vec24.f423650y = (f46 + f38) * 0.5f;
                        i16++;
                    }
                    Vec2 vec25 = this.normal;
                    vec25.f423649x = -vec25.f423649x;
                    vec25.f423650y = -vec25.f423650y;
                    return;
                }
                return;
            }
            Vec2 vec26 = this.pool3;
            Rot.mulToOutUnsafe(transform.f423648q, manifold.localNormal, this.normal);
            Transform.mulToOut(transform, manifold.localPoint, vec26);
            Vec2 vec27 = this.pool4;
            while (i16 < manifold.pointCount) {
                Transform.mulToOut(transform2, manifold.points[i16].localPoint, vec27);
                float f47 = vec27.f423649x;
                float f48 = f47 - vec26.f423649x;
                Vec2 vec28 = this.normal;
                float f49 = vec28.f423649x;
                float f56 = vec27.f423650y;
                float f57 = f56 - vec26.f423650y;
                float f58 = vec28.f423650y;
                float f59 = f16 - ((f48 * f49) + (f57 * f58));
                float f65 = (f49 * f59) + f47;
                float f66 = (f59 * f58) + f56;
                float f67 = ((-f49) * f17) + f47;
                float f68 = ((-f58) * f17) + f56;
                Vec2 vec29 = this.points[i16];
                vec29.f423649x = (f65 + f67) * 0.5f;
                vec29.f423650y = (f66 + f68) * 0.5f;
                i16++;
            }
            return;
        }
        Vec2 vec210 = this.pool3;
        Vec2 vec211 = this.pool4;
        Vec2 vec212 = this.normal;
        vec212.f423649x = 1.0f;
        vec212.f423650y = 0.0f;
        Transform.mulToOut(transform, manifold.localPoint, vec210);
        Transform.mulToOut(transform2, manifold.points[0].localPoint, vec211);
        if (MathUtils.distanceSquared(vec210, vec211) > 1.4210855E-14f) {
            Vec2 vec213 = this.normal;
            vec213.f423649x = vec211.f423649x - vec210.f423649x;
            vec213.f423650y = vec211.f423650y - vec210.f423650y;
            vec213.normalize();
        }
        Vec2 vec214 = this.normal;
        float f69 = vec214.f423649x;
        float f75 = (f69 * f16) + vec210.f423649x;
        float f76 = vec214.f423650y;
        float f77 = (f16 * f76) + vec210.f423650y;
        float f78 = ((-f69) * f17) + vec211.f423649x;
        float f79 = ((-f76) * f17) + vec211.f423650y;
        Vec2 vec215 = this.points[0];
        vec215.f423649x = (f75 + f78) * 0.5f;
        vec215.f423650y = (f77 + f79) * 0.5f;
    }
}
