package com.qzone.jbox2d.collision.shapes;

import com.qzone.jbox2d.common.Rot;
import com.qzone.jbox2d.common.Transform;
import com.qzone.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e extends f {

    /* renamed from: c, reason: collision with root package name */
    public final Vec2 f48094c;

    /* renamed from: d, reason: collision with root package name */
    public final Vec2[] f48095d;

    /* renamed from: e, reason: collision with root package name */
    public final Vec2[] f48096e;

    /* renamed from: f, reason: collision with root package name */
    public int f48097f;

    /* renamed from: g, reason: collision with root package name */
    private final Vec2 f48098g;

    /* renamed from: h, reason: collision with root package name */
    private final Vec2 f48099h;

    /* renamed from: i, reason: collision with root package name */
    private final Vec2 f48100i;

    /* renamed from: j, reason: collision with root package name */
    private final Vec2 f48101j;

    /* renamed from: k, reason: collision with root package name */
    private Transform f48102k;

    public e() {
        super(ShapeType.POLYGON);
        this.f48094c = new Vec2();
        this.f48098g = new Vec2();
        this.f48099h = new Vec2();
        this.f48100i = new Vec2();
        this.f48101j = new Vec2();
        this.f48102k = new Transform();
        int i3 = 0;
        this.f48097f = 0;
        this.f48095d = new Vec2[com.qzone.jbox2d.common.d.f48142j];
        int i16 = 0;
        while (true) {
            Vec2[] vec2Arr = this.f48095d;
            if (i16 >= vec2Arr.length) {
                break;
            }
            vec2Arr[i16] = new Vec2();
            i16++;
        }
        this.f48096e = new Vec2[com.qzone.jbox2d.common.d.f48142j];
        while (true) {
            Vec2[] vec2Arr2 = this.f48096e;
            if (i3 < vec2Arr2.length) {
                vec2Arr2[i3] = new Vec2();
                i3++;
            } else {
                g(com.qzone.jbox2d.common.d.f48147o);
                this.f48094c.setZero();
                return;
            }
        }
    }

    @Override // com.qzone.jbox2d.collision.shapes.f
    /* renamed from: a */
    public final f clone() {
        e eVar = new e();
        eVar.f48094c.set(this.f48094c);
        int i3 = 0;
        while (true) {
            Vec2[] vec2Arr = eVar.f48096e;
            if (i3 < vec2Arr.length) {
                vec2Arr[i3].set(this.f48096e[i3]);
                eVar.f48095d[i3].set(this.f48095d[i3]);
                i3++;
            } else {
                eVar.g(e());
                eVar.f48097f = this.f48097f;
                return eVar;
            }
        }
    }

    @Override // com.qzone.jbox2d.collision.shapes.f
    public final void b(com.qzone.jbox2d.collision.a aVar, Transform transform, int i3) {
        Vec2 vec2 = aVar.f47986a;
        Vec2 vec22 = aVar.f47987b;
        Vec2 vec23 = this.f48095d[0];
        Rot rot = transform.f48118q;
        float f16 = rot.f48110c;
        float f17 = rot.f48111s;
        Vec2 vec24 = transform.f48117p;
        float f18 = vec24.f48119x;
        float f19 = vec24.f48120y;
        float f26 = vec23.f48119x * f16;
        float f27 = vec23.f48120y;
        float f28 = (f26 - (f17 * f27)) + f18;
        vec2.f48119x = f28;
        float f29 = (vec23.f48119x * f17) + (f27 * f16) + f19;
        vec2.f48120y = f29;
        vec22.f48119x = f28;
        vec22.f48120y = f29;
        for (int i16 = 1; i16 < this.f48097f; i16++) {
            Vec2 vec25 = this.f48095d[i16];
            float f36 = vec25.f48119x;
            float f37 = vec25.f48120y;
            float f38 = ((f16 * f36) - (f17 * f37)) + f18;
            float f39 = (f36 * f17) + (f37 * f16) + f19;
            float f46 = vec2.f48119x;
            if (f46 >= f38) {
                f46 = f38;
            }
            vec2.f48119x = f46;
            float f47 = vec2.f48120y;
            if (f47 >= f39) {
                f47 = f39;
            }
            vec2.f48120y = f47;
            float f48 = vec22.f48119x;
            if (f48 > f38) {
                f38 = f48;
            }
            vec22.f48119x = f38;
            float f49 = vec22.f48120y;
            if (f49 > f39) {
                f39 = f49;
            }
            vec22.f48120y = f39;
        }
        float f56 = vec2.f48119x;
        float f57 = this.f48104b;
        vec2.f48119x = f56 - f57;
        vec2.f48120y -= f57;
        vec22.f48119x += f57;
        vec22.f48120y += f57;
    }

    @Override // com.qzone.jbox2d.collision.shapes.f
    public int d() {
        return 1;
    }

    public final void h(float f16, float f17) {
        this.f48097f = 4;
        float f18 = -f16;
        float f19 = -f17;
        this.f48095d[0].set(f18, f19);
        this.f48095d[1].set(f16, f19);
        this.f48095d[2].set(f16, f17);
        this.f48095d[3].set(f18, f17);
        this.f48096e[0].set(0.0f, -1.0f);
        this.f48096e[1].set(1.0f, 0.0f);
        this.f48096e[2].set(0.0f, 1.0f);
        this.f48096e[3].set(-1.0f, 0.0f);
        this.f48094c.setZero();
    }

    @Override // com.qzone.jbox2d.collision.shapes.f
    public void c(d dVar, float f16) {
        int i3;
        Vec2 vec2;
        Vec2 vec22 = this.f48098g;
        vec22.setZero();
        Vec2 vec23 = this.f48099h;
        vec23.setZero();
        int i16 = 0;
        while (true) {
            i3 = this.f48097f;
            if (i16 >= i3) {
                break;
            }
            vec23.addLocal(this.f48095d[i16]);
            i16++;
        }
        vec23.mulLocal(1.0f / i3);
        Vec2 vec24 = this.f48100i;
        Vec2 vec25 = this.f48101j;
        float f17 = 0.0f;
        int i17 = 0;
        float f18 = 0.0f;
        while (i17 < this.f48097f) {
            vec24.set(this.f48095d[i17]).subLocal(vec23);
            Vec2 negateLocal = vec25.set(vec23).negateLocal();
            i17++;
            if (i17 < this.f48097f) {
                vec2 = this.f48095d[i17];
            } else {
                vec2 = this.f48095d[0];
            }
            negateLocal.addLocal(vec2);
            float cross = Vec2.cross(vec24, vec25);
            float f19 = 0.5f * cross;
            f17 += f19;
            float f26 = f19 * 0.33333334f;
            vec22.f48119x += (vec24.f48119x + vec25.f48119x) * f26;
            vec22.f48120y += f26 * (vec24.f48120y + vec25.f48120y);
            float f27 = vec24.f48119x;
            float f28 = vec24.f48120y;
            float f29 = vec25.f48119x;
            float f36 = vec25.f48120y;
            f18 += cross * 0.083333336f * ((f27 * f27) + (f27 * f29) + (f29 * f29) + (f28 * f28) + (f28 * f36) + (f36 * f36));
        }
        dVar.f48091a = f16 * f17;
        vec22.mulLocal(1.0f / f17);
        dVar.f48092b.set(vec22).addLocal(vec23);
        float f37 = f18 * f16;
        dVar.f48093c = f37;
        float f38 = dVar.f48091a;
        Vec2 vec26 = dVar.f48092b;
        dVar.f48093c = f37 + (f38 * Vec2.dot(vec26, vec26));
    }
}
