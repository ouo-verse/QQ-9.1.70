package h7;

import com.qzone.jbox2d.collision.Manifold;
import com.qzone.jbox2d.common.Rot;
import com.qzone.jbox2d.common.Transform;
import com.qzone.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes38.dex */
class o {

    /* renamed from: a, reason: collision with root package name */
    public final Vec2 f404546a = new Vec2();

    /* renamed from: b, reason: collision with root package name */
    public final Vec2 f404547b = new Vec2();

    /* renamed from: c, reason: collision with root package name */
    public float f404548c;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f404549a;

        static {
            int[] iArr = new int[Manifold.ManifoldType.values().length];
            f404549a = iArr;
            try {
                iArr[Manifold.ManifoldType.CIRCLES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f404549a[Manifold.ManifoldType.FACE_A.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f404549a[Manifold.ManifoldType.FACE_B.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public void a(f fVar, Transform transform, Transform transform2, int i3) {
        Rot rot = transform.f48118q;
        Rot rot2 = transform2.f48118q;
        Vec2 vec2 = fVar.f404489a[i3];
        int i16 = a.f404549a[fVar.f404500l.ordinal()];
        if (i16 == 1) {
            Vec2 vec22 = fVar.f404491c;
            Vec2 vec23 = fVar.f404489a[0];
            float f16 = rot.f48110c;
            float f17 = vec22.f48119x;
            float f18 = rot.f48111s;
            float f19 = vec22.f48120y;
            Vec2 vec24 = transform.f48117p;
            float f26 = ((f16 * f17) - (f18 * f19)) + vec24.f48119x;
            float f27 = (f18 * f17) + (f16 * f19) + vec24.f48120y;
            float f28 = rot2.f48110c;
            float f29 = vec23.f48119x;
            float f36 = rot2.f48111s;
            float f37 = vec23.f48120y;
            Vec2 vec25 = transform2.f48117p;
            float f38 = ((f28 * f29) - (f36 * f37)) + vec25.f48119x;
            float f39 = (f36 * f29) + (f28 * f37) + vec25.f48120y;
            Vec2 vec26 = this.f404546a;
            float f46 = f38 - f26;
            vec26.f48119x = f46;
            float f47 = f39 - f27;
            vec26.f48120y = f47;
            vec26.normalize();
            Vec2 vec27 = this.f404547b;
            vec27.f48119x = (f26 + f38) * 0.5f;
            vec27.f48120y = (f27 + f39) * 0.5f;
            Vec2 vec28 = this.f404546a;
            this.f404548c = (((f46 * vec28.f48119x) + (f47 * vec28.f48120y)) - fVar.f404501m) - fVar.f404502n;
            return;
        }
        if (i16 == 2) {
            Vec2 vec29 = fVar.f404490b;
            Vec2 vec210 = fVar.f404491c;
            Vec2 vec211 = this.f404546a;
            float f48 = rot.f48110c;
            float f49 = vec29.f48119x * f48;
            float f56 = rot.f48111s;
            float f57 = vec29.f48120y;
            float f58 = f49 - (f56 * f57);
            vec211.f48119x = f58;
            float f59 = (vec29.f48119x * f56) + (f57 * f48);
            vec211.f48120y = f59;
            float f65 = vec210.f48119x;
            float f66 = vec210.f48120y;
            Vec2 vec212 = transform.f48117p;
            float f67 = ((f48 * f65) - (f56 * f66)) + vec212.f48119x;
            float f68 = (f56 * f65) + (f48 * f66) + vec212.f48120y;
            float f69 = rot2.f48110c;
            float f75 = vec2.f48119x;
            float f76 = rot2.f48111s;
            float f77 = vec2.f48120y;
            Vec2 vec213 = transform2.f48117p;
            float f78 = ((f69 * f75) - (f76 * f77)) + vec213.f48119x;
            float f79 = (f76 * f75) + (f69 * f77) + vec213.f48120y;
            this.f404548c = ((((f78 - f67) * f58) + ((f79 - f68) * f59)) - fVar.f404501m) - fVar.f404502n;
            Vec2 vec214 = this.f404547b;
            vec214.f48119x = f78;
            vec214.f48120y = f79;
            return;
        }
        if (i16 != 3) {
            return;
        }
        Vec2 vec215 = fVar.f404490b;
        Vec2 vec216 = fVar.f404491c;
        Vec2 vec217 = this.f404546a;
        float f85 = rot2.f48110c;
        float f86 = vec215.f48119x * f85;
        float f87 = rot2.f48111s;
        float f88 = vec215.f48120y;
        float f89 = f86 - (f87 * f88);
        vec217.f48119x = f89;
        float f95 = (vec215.f48119x * f87) + (f88 * f85);
        vec217.f48120y = f95;
        float f96 = vec216.f48119x;
        float f97 = vec216.f48120y;
        Vec2 vec218 = transform2.f48117p;
        float f98 = ((f85 * f96) - (f87 * f97)) + vec218.f48119x;
        float f99 = (f87 * f96) + (f85 * f97) + vec218.f48120y;
        float f100 = rot.f48110c;
        float f101 = vec2.f48119x;
        float f102 = rot.f48111s;
        float f103 = vec2.f48120y;
        Vec2 vec219 = transform.f48117p;
        float f104 = ((f100 * f101) - (f102 * f103)) + vec219.f48119x;
        float f105 = (f102 * f101) + (f100 * f103) + vec219.f48120y;
        this.f404548c = ((((f104 - f98) * f89) + ((f105 - f99) * f95)) - fVar.f404501m) - fVar.f404502n;
        Vec2 vec220 = this.f404547b;
        vec220.f48119x = f104;
        vec220.f48120y = f105;
        vec217.f48119x *= -1.0f;
        vec217.f48120y *= -1.0f;
    }
}
