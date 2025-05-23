package org.jbox2d.dynamics.contacts;

import org.jbox2d.collision.Manifold;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;

/* loaded from: classes29.dex */
class PositionSolverManifold {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final Vec2 normal = new Vec2();
    public final Vec2 point = new Vec2();
    public float separation;

    /* renamed from: org.jbox2d.dynamics.contacts.PositionSolverManifold$1, reason: invalid class name */
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

    public void initialize(ContactPositionConstraint contactPositionConstraint, Transform transform, Transform transform2, int i3) {
        Rot rot = transform.f423648q;
        Rot rot2 = transform2.f423648q;
        Vec2 vec2 = contactPositionConstraint.localPoints[i3];
        int i16 = AnonymousClass1.$SwitchMap$org$jbox2d$collision$Manifold$ManifoldType[contactPositionConstraint.type.ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 == 3) {
                    Vec2 vec22 = contactPositionConstraint.localNormal;
                    Vec2 vec23 = contactPositionConstraint.localPoint;
                    Vec2 vec24 = this.normal;
                    float f16 = rot2.f423641c;
                    float f17 = vec22.f423649x * f16;
                    float f18 = rot2.f423642s;
                    float f19 = vec22.f423650y;
                    float f26 = f17 - (f18 * f19);
                    vec24.f423649x = f26;
                    float f27 = (vec22.f423649x * f18) + (f19 * f16);
                    vec24.f423650y = f27;
                    float f28 = vec23.f423649x;
                    float f29 = vec23.f423650y;
                    Vec2 vec25 = transform2.f423647p;
                    float f36 = ((f16 * f28) - (f18 * f29)) + vec25.f423649x;
                    float f37 = (f18 * f28) + (f16 * f29) + vec25.f423650y;
                    float f38 = rot.f423641c;
                    float f39 = vec2.f423649x;
                    float f46 = rot.f423642s;
                    float f47 = vec2.f423650y;
                    Vec2 vec26 = transform.f423647p;
                    float f48 = ((f38 * f39) - (f46 * f47)) + vec26.f423649x;
                    float f49 = (f46 * f39) + (f38 * f47) + vec26.f423650y;
                    this.separation = ((((f48 - f36) * f26) + ((f49 - f37) * f27)) - contactPositionConstraint.radiusA) - contactPositionConstraint.radiusB;
                    Vec2 vec27 = this.point;
                    vec27.f423649x = f48;
                    vec27.f423650y = f49;
                    vec24.f423649x *= -1.0f;
                    vec24.f423650y *= -1.0f;
                    return;
                }
                return;
            }
            Vec2 vec28 = contactPositionConstraint.localNormal;
            Vec2 vec29 = contactPositionConstraint.localPoint;
            Vec2 vec210 = this.normal;
            float f56 = rot.f423641c;
            float f57 = vec28.f423649x * f56;
            float f58 = rot.f423642s;
            float f59 = vec28.f423650y;
            float f65 = f57 - (f58 * f59);
            vec210.f423649x = f65;
            float f66 = (vec28.f423649x * f58) + (f59 * f56);
            vec210.f423650y = f66;
            float f67 = vec29.f423649x;
            float f68 = vec29.f423650y;
            Vec2 vec211 = transform.f423647p;
            float f69 = ((f56 * f67) - (f58 * f68)) + vec211.f423649x;
            float f75 = (f58 * f67) + (f56 * f68) + vec211.f423650y;
            float f76 = rot2.f423641c;
            float f77 = vec2.f423649x;
            float f78 = rot2.f423642s;
            float f79 = vec2.f423650y;
            Vec2 vec212 = transform2.f423647p;
            float f85 = ((f76 * f77) - (f78 * f79)) + vec212.f423649x;
            float f86 = (f78 * f77) + (f76 * f79) + vec212.f423650y;
            this.separation = ((((f85 - f69) * f65) + ((f86 - f75) * f66)) - contactPositionConstraint.radiusA) - contactPositionConstraint.radiusB;
            Vec2 vec213 = this.point;
            vec213.f423649x = f85;
            vec213.f423650y = f86;
            return;
        }
        Vec2 vec214 = contactPositionConstraint.localPoint;
        Vec2 vec215 = contactPositionConstraint.localPoints[0];
        float f87 = rot.f423641c;
        float f88 = vec214.f423649x;
        float f89 = rot.f423642s;
        float f95 = vec214.f423650y;
        Vec2 vec216 = transform.f423647p;
        float f96 = ((f87 * f88) - (f89 * f95)) + vec216.f423649x;
        float f97 = (f89 * f88) + (f87 * f95) + vec216.f423650y;
        float f98 = rot2.f423641c;
        float f99 = vec215.f423649x;
        float f100 = rot2.f423642s;
        float f101 = vec215.f423650y;
        Vec2 vec217 = transform2.f423647p;
        float f102 = ((f98 * f99) - (f100 * f101)) + vec217.f423649x;
        float f103 = (f100 * f99) + (f98 * f101) + vec217.f423650y;
        Vec2 vec218 = this.normal;
        float f104 = f102 - f96;
        vec218.f423649x = f104;
        float f105 = f103 - f97;
        vec218.f423650y = f105;
        vec218.normalize();
        Vec2 vec219 = this.point;
        vec219.f423649x = (f96 + f102) * 0.5f;
        vec219.f423650y = (f97 + f103) * 0.5f;
        Vec2 vec220 = this.normal;
        this.separation = (((f104 * vec220.f423649x) + (f105 * vec220.f423650y)) - contactPositionConstraint.radiusA) - contactPositionConstraint.radiusB;
    }
}
