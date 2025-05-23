package com.qzone.jbox2d.collision;

import com.qzone.jbox2d.collision.Manifold;
import com.qzone.jbox2d.common.Rot;
import com.qzone.jbox2d.common.Transform;
import com.qzone.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes39.dex */
public class i {

    /* renamed from: b, reason: collision with root package name */
    public final Vec2[] f48071b;

    /* renamed from: c, reason: collision with root package name */
    public final float[] f48072c;

    /* renamed from: d, reason: collision with root package name */
    private final Vec2 f48073d = new Vec2();

    /* renamed from: e, reason: collision with root package name */
    private final Vec2 f48074e = new Vec2();

    /* renamed from: a, reason: collision with root package name */
    public final Vec2 f48070a = new Vec2();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f48075a;

        static {
            int[] iArr = new int[Manifold.ManifoldType.values().length];
            f48075a = iArr;
            try {
                iArr[Manifold.ManifoldType.CIRCLES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f48075a[Manifold.ManifoldType.FACE_A.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f48075a[Manifold.ManifoldType.FACE_B.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public i() {
        int i3 = com.qzone.jbox2d.common.d.f48141i;
        this.f48071b = new Vec2[i3];
        this.f48072c = new float[i3];
        for (int i16 = 0; i16 < com.qzone.jbox2d.common.d.f48141i; i16++) {
            this.f48071b[i16] = new Vec2();
        }
    }

    public final void a(Manifold manifold, Transform transform, float f16, Transform transform2, float f17) {
        if (manifold.f47963e == 0) {
            return;
        }
        int i3 = a.f48075a[manifold.f47962d.ordinal()];
        int i16 = 0;
        if (i3 == 1) {
            Vec2 vec2 = this.f48073d;
            Vec2 vec22 = this.f48074e;
            Vec2 vec23 = this.f48070a;
            vec23.f48119x = 1.0f;
            vec23.f48120y = 0.0f;
            Vec2 vec24 = manifold.f47961c;
            Rot rot = transform.f48118q;
            float f18 = rot.f48110c;
            float f19 = vec24.f48119x * f18;
            float f26 = rot.f48111s;
            float f27 = vec24.f48120y;
            Vec2 vec25 = transform.f48117p;
            vec2.f48119x = (f19 - (f26 * f27)) + vec25.f48119x;
            vec2.f48120y = (f26 * vec24.f48119x) + (f18 * f27) + vec25.f48120y;
            Vec2 vec26 = manifold.f47959a[0].f48039a;
            Rot rot2 = transform2.f48118q;
            float f28 = rot2.f48110c;
            float f29 = vec26.f48119x * f28;
            float f36 = rot2.f48111s;
            float f37 = vec26.f48120y;
            Vec2 vec27 = transform2.f48117p;
            vec22.f48119x = (f29 - (f36 * f37)) + vec27.f48119x;
            vec22.f48120y = (f36 * vec26.f48119x) + (f28 * f37) + vec27.f48120y;
            if (com.qzone.jbox2d.common.b.f(vec2, vec22) > 1.4210855E-14f) {
                Vec2 vec28 = this.f48070a;
                vec28.f48119x = vec22.f48119x - vec2.f48119x;
                vec28.f48120y = vec22.f48120y - vec2.f48120y;
                vec28.normalize();
            }
            Vec2 vec29 = this.f48070a;
            float f38 = vec29.f48119x;
            float f39 = (f38 * f16) + vec2.f48119x;
            float f46 = vec29.f48120y;
            float f47 = (f16 * f46) + vec2.f48120y;
            float f48 = ((-f38) * f17) + vec22.f48119x;
            float f49 = ((-f46) * f17) + vec22.f48120y;
            Vec2 vec210 = this.f48071b[0];
            vec210.f48119x = (f39 + f48) * 0.5f;
            vec210.f48120y = (f47 + f49) * 0.5f;
            this.f48072c[0] = ((f48 - f39) * vec29.f48119x) + ((f49 - f47) * vec29.f48120y);
            return;
        }
        if (i3 == 2) {
            Vec2 vec211 = this.f48073d;
            Rot.mulToOutUnsafe(transform.f48118q, manifold.f47960b, this.f48070a);
            Transform.mulToOut(transform, manifold.f47961c, vec211);
            Vec2 vec212 = this.f48074e;
            while (i16 < manifold.f47963e) {
                Transform.mulToOut(transform2, manifold.f47959a[i16].f48039a, vec212);
                float f56 = vec212.f48119x;
                float f57 = f56 - vec211.f48119x;
                Vec2 vec213 = this.f48070a;
                float f58 = vec213.f48119x;
                float f59 = vec212.f48120y;
                float f65 = f59 - vec211.f48120y;
                float f66 = vec213.f48120y;
                float f67 = f16 - ((f57 * f58) + (f65 * f66));
                float f68 = (f58 * f67) + f56;
                float f69 = (f67 * f66) + f59;
                float f75 = ((-f58) * f17) + f56;
                float f76 = ((-f66) * f17) + f59;
                Vec2 vec214 = this.f48071b[i16];
                vec214.f48119x = (f68 + f75) * 0.5f;
                vec214.f48120y = (f69 + f76) * 0.5f;
                this.f48072c[i16] = ((f75 - f68) * vec213.f48119x) + ((f76 - f69) * vec213.f48120y);
                i16++;
            }
            return;
        }
        if (i3 != 3) {
            return;
        }
        Vec2 vec215 = this.f48073d;
        Rot.mulToOutUnsafe(transform2.f48118q, manifold.f47960b, this.f48070a);
        Transform.mulToOut(transform2, manifold.f47961c, vec215);
        Vec2 vec216 = this.f48074e;
        while (i16 < manifold.f47963e) {
            Transform.mulToOut(transform, manifold.f47959a[i16].f48039a, vec216);
            float f77 = vec216.f48119x;
            float f78 = f77 - vec215.f48119x;
            Vec2 vec217 = this.f48070a;
            float f79 = vec217.f48119x;
            float f85 = vec216.f48120y;
            float f86 = f85 - vec215.f48120y;
            float f87 = vec217.f48120y;
            float f88 = f17 - ((f78 * f79) + (f86 * f87));
            float f89 = (f79 * f88) + f77;
            float f95 = (f88 * f87) + f85;
            float f96 = ((-f79) * f16) + f77;
            float f97 = ((-f87) * f16) + f85;
            Vec2 vec218 = this.f48071b[i16];
            vec218.f48119x = (f96 + f89) * 0.5f;
            vec218.f48120y = (f97 + f95) * 0.5f;
            this.f48072c[i16] = ((f96 - f89) * vec217.f48119x) + ((f97 - f95) * vec217.f48120y);
            i16++;
        }
        Vec2 vec219 = this.f48070a;
        vec219.f48119x = -vec219.f48119x;
        vec219.f48120y = -vec219.f48120y;
    }
}
