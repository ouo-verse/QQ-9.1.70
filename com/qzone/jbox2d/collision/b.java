package com.qzone.jbox2d.collision;

import com.qzone.jbox2d.collision.shapes.ShapeType;
import com.qzone.jbox2d.common.Rot;
import com.qzone.jbox2d.common.Transform;
import com.qzone.jbox2d.common.Vec2;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: h, reason: collision with root package name */
    public static int f47988h = 0;

    /* renamed from: i, reason: collision with root package name */
    public static int f47989i = 0;

    /* renamed from: j, reason: collision with root package name */
    public static int f47990j = 20;

    /* renamed from: a, reason: collision with root package name */
    private c f47991a = new c();

    /* renamed from: b, reason: collision with root package name */
    private int[] f47992b = new int[3];

    /* renamed from: c, reason: collision with root package name */
    private int[] f47993c = new int[3];

    /* renamed from: d, reason: collision with root package name */
    private Vec2 f47994d = new Vec2();

    /* renamed from: e, reason: collision with root package name */
    private Vec2 f47995e = new Vec2();

    /* renamed from: f, reason: collision with root package name */
    private Vec2 f47996f = new Vec2();

    /* renamed from: g, reason: collision with root package name */
    private Vec2 f47997g = new Vec2();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f47998a;

        static {
            int[] iArr = new int[ShapeType.values().length];
            f47998a = iArr;
            try {
                iArr[ShapeType.CIRCLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47998a[ShapeType.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47998a[ShapeType.CHAIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47998a[ShapeType.EDGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.qzone.jbox2d.collision.b$b, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static class C0398b {

        /* renamed from: a, reason: collision with root package name */
        public final Vec2[] f47999a = new Vec2[com.qzone.jbox2d.common.d.f48142j];

        /* renamed from: b, reason: collision with root package name */
        public int f48000b;

        /* renamed from: c, reason: collision with root package name */
        public float f48001c;

        /* renamed from: d, reason: collision with root package name */
        public final Vec2[] f48002d;

        public C0398b() {
            int i3 = 0;
            while (true) {
                Vec2[] vec2Arr = this.f47999a;
                if (i3 < vec2Arr.length) {
                    vec2Arr[i3] = new Vec2();
                    i3++;
                } else {
                    this.f48002d = new Vec2[2];
                    this.f48000b = 0;
                    this.f48001c = 0.0f;
                    return;
                }
            }
        }

        public final int a(Vec2 vec2) {
            int i3 = 0;
            float dot = Vec2.dot(this.f47999a[0], vec2);
            for (int i16 = 1; i16 < this.f48000b; i16++) {
                float dot2 = Vec2.dot(this.f47999a[i16], vec2);
                if (dot2 > dot) {
                    i3 = i16;
                    dot = dot2;
                }
            }
            return i3;
        }

        public final Vec2 b(int i3) {
            return this.f47999a[i3];
        }

        public final void c(com.qzone.jbox2d.collision.shapes.f fVar, int i3) {
            int i16 = a.f47998a[fVar.f().ordinal()];
            if (i16 == 1) {
                com.qzone.jbox2d.collision.shapes.b bVar = (com.qzone.jbox2d.collision.shapes.b) fVar;
                this.f47999a[0].set(bVar.f48083c);
                this.f48000b = 1;
                this.f48001c = bVar.f48104b;
                return;
            }
            if (i16 == 2) {
                com.qzone.jbox2d.collision.shapes.e eVar = (com.qzone.jbox2d.collision.shapes.e) fVar;
                this.f48000b = eVar.f48097f;
                this.f48001c = eVar.f48104b;
                for (int i17 = 0; i17 < this.f48000b; i17++) {
                    this.f47999a[i17].set(eVar.f48095d[i17]);
                }
                return;
            }
            if (i16 != 3) {
                if (i16 != 4) {
                    return;
                }
                com.qzone.jbox2d.collision.shapes.c cVar = (com.qzone.jbox2d.collision.shapes.c) fVar;
                this.f47999a[0].set(cVar.f48084c);
                this.f47999a[1].set(cVar.f48085d);
                this.f48000b = 2;
                this.f48001c = cVar.f48104b;
                return;
            }
            com.qzone.jbox2d.collision.shapes.a aVar = (com.qzone.jbox2d.collision.shapes.a) fVar;
            Vec2[] vec2Arr = this.f48002d;
            Vec2[] vec2Arr2 = aVar.f48076c;
            Vec2 vec2 = vec2Arr2[i3];
            vec2Arr[0] = vec2;
            int i18 = i3 + 1;
            if (i18 < aVar.f48077d) {
                vec2Arr[1] = vec2Arr2[i18];
            } else {
                vec2Arr[1] = vec2Arr2[0];
            }
            this.f47999a[0].set(vec2);
            this.f47999a[1].set(this.f48002d[1]);
            this.f48000b = 2;
            this.f48001c = aVar.f48104b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public final e f48003a;

        /* renamed from: b, reason: collision with root package name */
        public final e f48004b;

        /* renamed from: c, reason: collision with root package name */
        public final e f48005c;

        /* renamed from: d, reason: collision with root package name */
        public final e[] f48006d;

        /* renamed from: e, reason: collision with root package name */
        public int f48007e;

        /* renamed from: f, reason: collision with root package name */
        private final Vec2 f48008f;

        /* renamed from: g, reason: collision with root package name */
        private final Vec2 f48009g;

        /* renamed from: h, reason: collision with root package name */
        private final Vec2 f48010h;

        /* renamed from: i, reason: collision with root package name */
        private final Vec2 f48011i;

        /* renamed from: j, reason: collision with root package name */
        private final Vec2 f48012j;

        /* renamed from: k, reason: collision with root package name */
        private final Vec2 f48013k;

        /* renamed from: l, reason: collision with root package name */
        private final Vec2 f48014l;

        /* renamed from: m, reason: collision with root package name */
        private final Vec2 f48015m;

        /* renamed from: n, reason: collision with root package name */
        private final Vec2 f48016n;

        /* renamed from: o, reason: collision with root package name */
        private final Vec2 f48017o;

        c() {
            e eVar = new e();
            this.f48003a = eVar;
            e eVar2 = new e();
            this.f48004b = eVar2;
            e eVar3 = new e();
            this.f48005c = eVar3;
            this.f48006d = new e[]{eVar, eVar2, eVar3};
            this.f48008f = new Vec2();
            this.f48009g = new Vec2();
            this.f48010h = new Vec2();
            this.f48011i = new Vec2();
            this.f48012j = new Vec2();
            this.f48013k = new Vec2();
            this.f48014l = new Vec2();
            this.f48015m = new Vec2();
            this.f48016n = new Vec2();
            this.f48017o = new Vec2();
        }

        public void a(Vec2 vec2) {
            int i3 = this.f48007e;
            if (i3 == 0) {
                vec2.setZero();
                return;
            }
            if (i3 == 1) {
                vec2.set(this.f48003a.f48025c);
                return;
            }
            if (i3 == 2) {
                this.f48010h.set(this.f48004b.f48025c).mulLocal(this.f48004b.f48026d);
                this.f48009g.set(this.f48003a.f48025c).mulLocal(this.f48003a.f48026d).addLocal(this.f48010h);
                vec2.set(this.f48009g);
            } else if (i3 != 3) {
                vec2.setZero();
            } else {
                vec2.setZero();
            }
        }

        public float b() {
            int i3 = this.f48007e;
            if (i3 == 0 || i3 == 1) {
                return 0.0f;
            }
            if (i3 == 2) {
                return com.qzone.jbox2d.common.b.e(this.f48003a.f48025c, this.f48004b.f48025c);
            }
            if (i3 != 3) {
                return 0.0f;
            }
            this.f48011i.set(this.f48004b.f48025c).subLocal(this.f48003a.f48025c);
            this.f48012j.set(this.f48005c.f48025c).subLocal(this.f48003a.f48025c);
            return Vec2.cross(this.f48011i, this.f48012j);
        }

        public final void c(Vec2 vec2) {
            int i3 = this.f48007e;
            if (i3 == 1) {
                vec2.set(this.f48003a.f48025c).negateLocal();
                return;
            }
            if (i3 != 2) {
                vec2.setZero();
                return;
            }
            this.f48008f.set(this.f48004b.f48025c).subLocal(this.f48003a.f48025c);
            vec2.set(this.f48003a.f48025c).negateLocal();
            if (Vec2.cross(this.f48008f, vec2) > 0.0f) {
                Vec2.crossToOutUnsafe(1.0f, this.f48008f, vec2);
            } else {
                Vec2.crossToOutUnsafe(this.f48008f, 1.0f, vec2);
            }
        }

        public void d(Vec2 vec2, Vec2 vec22) {
            int i3 = this.f48007e;
            if (i3 != 0) {
                if (i3 == 1) {
                    vec2.set(this.f48003a.f48023a);
                    vec22.set(this.f48003a.f48024b);
                    return;
                }
                if (i3 == 2) {
                    this.f48009g.set(this.f48003a.f48023a).mulLocal(this.f48003a.f48026d);
                    vec2.set(this.f48004b.f48023a).mulLocal(this.f48004b.f48026d).addLocal(this.f48009g);
                    this.f48009g.set(this.f48003a.f48024b).mulLocal(this.f48003a.f48026d);
                    vec22.set(this.f48004b.f48024b).mulLocal(this.f48004b.f48026d).addLocal(this.f48009g);
                    return;
                }
                if (i3 != 3) {
                    return;
                }
                vec2.set(this.f48003a.f48023a).mulLocal(this.f48003a.f48026d);
                this.f48011i.set(this.f48004b.f48023a).mulLocal(this.f48004b.f48026d);
                this.f48012j.set(this.f48005c.f48023a).mulLocal(this.f48005c.f48026d);
                vec2.addLocal(this.f48011i).addLocal(this.f48012j);
                vec22.set(vec2);
            }
        }

        public void e(d dVar, C0398b c0398b, Transform transform, C0398b c0398b2, Transform transform2) {
            int i3;
            this.f48007e = dVar.f48020b;
            int i16 = 0;
            while (true) {
                i3 = this.f48007e;
                if (i16 >= i3) {
                    break;
                }
                e eVar = this.f48006d[i16];
                int i17 = dVar.f48021c[i16];
                eVar.f48027e = i17;
                eVar.f48028f = dVar.f48022d[i16];
                Vec2 b16 = c0398b.b(i17);
                Vec2 b17 = c0398b2.b(eVar.f48028f);
                Transform.mulToOutUnsafe(transform, b16, eVar.f48023a);
                Transform.mulToOutUnsafe(transform2, b17, eVar.f48024b);
                eVar.f48025c.set(eVar.f48024b).subLocal(eVar.f48023a);
                eVar.f48026d = 0.0f;
                i16++;
            }
            if (i3 > 1) {
                float f16 = dVar.f48019a;
                float b18 = b();
                if (b18 < 0.5f * f16 || f16 * 2.0f < b18 || b18 < 1.1920929E-7f) {
                    this.f48007e = 0;
                }
            }
            if (this.f48007e == 0) {
                e eVar2 = this.f48006d[0];
                eVar2.f48027e = 0;
                eVar2.f48028f = 0;
                Vec2 b19 = c0398b.b(0);
                Vec2 b26 = c0398b2.b(0);
                Transform.mulToOutUnsafe(transform, b19, eVar2.f48023a);
                Transform.mulToOutUnsafe(transform2, b26, eVar2.f48024b);
                eVar2.f48025c.set(eVar2.f48024b).subLocal(eVar2.f48023a);
                this.f48007e = 1;
            }
        }

        public void f() {
            Vec2 vec2 = this.f48003a.f48025c;
            Vec2 vec22 = this.f48004b.f48025c;
            this.f48008f.set(vec22).subLocal(vec2);
            float f16 = -Vec2.dot(vec2, this.f48008f);
            if (f16 <= 0.0f) {
                this.f48003a.f48026d = 1.0f;
                this.f48007e = 1;
                return;
            }
            float dot = Vec2.dot(vec22, this.f48008f);
            if (dot <= 0.0f) {
                e eVar = this.f48004b;
                eVar.f48026d = 1.0f;
                this.f48007e = 1;
                this.f48003a.a(eVar);
                return;
            }
            float f17 = 1.0f / (dot + f16);
            this.f48003a.f48026d = dot * f17;
            this.f48004b.f48026d = f16 * f17;
            this.f48007e = 2;
        }

        public void g() {
            this.f48015m.set(this.f48003a.f48025c);
            this.f48016n.set(this.f48004b.f48025c);
            this.f48017o.set(this.f48005c.f48025c);
            this.f48008f.set(this.f48016n).subLocal(this.f48015m);
            float dot = Vec2.dot(this.f48015m, this.f48008f);
            float dot2 = Vec2.dot(this.f48016n, this.f48008f);
            float f16 = -dot;
            this.f48013k.set(this.f48017o).subLocal(this.f48015m);
            float dot3 = Vec2.dot(this.f48015m, this.f48013k);
            float dot4 = Vec2.dot(this.f48017o, this.f48013k);
            float f17 = -dot3;
            this.f48014l.set(this.f48017o).subLocal(this.f48016n);
            float dot5 = Vec2.dot(this.f48016n, this.f48014l);
            float dot6 = Vec2.dot(this.f48017o, this.f48014l);
            float f18 = -dot5;
            float cross = Vec2.cross(this.f48008f, this.f48013k);
            float cross2 = Vec2.cross(this.f48016n, this.f48017o) * cross;
            float cross3 = Vec2.cross(this.f48017o, this.f48015m) * cross;
            float cross4 = cross * Vec2.cross(this.f48015m, this.f48016n);
            if (f16 <= 0.0f && f17 <= 0.0f) {
                this.f48003a.f48026d = 1.0f;
                this.f48007e = 1;
                return;
            }
            if (dot2 > 0.0f && f16 > 0.0f && cross4 <= 0.0f) {
                float f19 = 1.0f / (dot2 + f16);
                this.f48003a.f48026d = dot2 * f19;
                this.f48004b.f48026d = f16 * f19;
                this.f48007e = 2;
                return;
            }
            if (dot4 > 0.0f && f17 > 0.0f && cross3 <= 0.0f) {
                float f26 = 1.0f / (dot4 + f17);
                this.f48003a.f48026d = dot4 * f26;
                e eVar = this.f48005c;
                eVar.f48026d = f17 * f26;
                this.f48007e = 2;
                this.f48004b.a(eVar);
                return;
            }
            if (dot2 <= 0.0f && f18 <= 0.0f) {
                e eVar2 = this.f48004b;
                eVar2.f48026d = 1.0f;
                this.f48007e = 1;
                this.f48003a.a(eVar2);
                return;
            }
            if (dot4 <= 0.0f && dot6 <= 0.0f) {
                e eVar3 = this.f48005c;
                eVar3.f48026d = 1.0f;
                this.f48007e = 1;
                this.f48003a.a(eVar3);
                return;
            }
            if (dot6 > 0.0f && f18 > 0.0f && cross2 <= 0.0f) {
                float f27 = 1.0f / (dot6 + f18);
                this.f48004b.f48026d = dot6 * f27;
                e eVar4 = this.f48005c;
                eVar4.f48026d = f18 * f27;
                this.f48007e = 2;
                this.f48003a.a(eVar4);
                return;
            }
            float f28 = 1.0f / ((cross2 + cross3) + cross4);
            this.f48003a.f48026d = cross2 * f28;
            this.f48004b.f48026d = cross3 * f28;
            this.f48005c.f48026d = cross4 * f28;
            this.f48007e = 3;
        }

        public void h(d dVar) {
            dVar.f48019a = b();
            dVar.f48020b = this.f48007e;
            for (int i3 = 0; i3 < this.f48007e; i3++) {
                int[] iArr = dVar.f48021c;
                e eVar = this.f48006d[i3];
                iArr[i3] = eVar.f48027e;
                dVar.f48022d[i3] = eVar.f48028f;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public float f48019a = 0.0f;

        /* renamed from: b, reason: collision with root package name */
        public int f48020b = 0;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f48021c;

        /* renamed from: d, reason: collision with root package name */
        public final int[] f48022d;

        public d() {
            this.f48021c = r1;
            this.f48022d = r0;
            int[] iArr = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
            int[] iArr2 = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e {

        /* renamed from: a, reason: collision with root package name */
        public final Vec2 f48023a = new Vec2();

        /* renamed from: b, reason: collision with root package name */
        public final Vec2 f48024b = new Vec2();

        /* renamed from: c, reason: collision with root package name */
        public final Vec2 f48025c = new Vec2();

        /* renamed from: d, reason: collision with root package name */
        public float f48026d;

        /* renamed from: e, reason: collision with root package name */
        public int f48027e;

        /* renamed from: f, reason: collision with root package name */
        public int f48028f;

        e() {
        }

        public void a(e eVar) {
            this.f48023a.set(eVar.f48023a);
            this.f48024b.set(eVar.f48024b);
            this.f48025c.set(eVar.f48025c);
            this.f48026d = eVar.f48026d;
            this.f48027e = eVar.f48027e;
            this.f48028f = eVar.f48028f;
        }
    }

    public final void a(com.qzone.jbox2d.collision.d dVar, d dVar2, com.qzone.jbox2d.collision.c cVar) {
        boolean z16;
        f47988h++;
        C0398b c0398b = cVar.f48030a;
        C0398b c0398b2 = cVar.f48031b;
        Transform transform = cVar.f48032c;
        Transform transform2 = cVar.f48033d;
        this.f47991a.e(dVar2, c0398b, transform, c0398b2, transform2);
        c cVar2 = this.f47991a;
        e[] eVarArr = cVar2.f48006d;
        cVar2.a(this.f47994d);
        this.f47994d.lengthSquared();
        int i3 = 0;
        while (i3 < 20) {
            int i16 = this.f47991a.f48007e;
            for (int i17 = 0; i17 < i16; i17++) {
                int[] iArr = this.f47992b;
                e eVar = eVarArr[i17];
                iArr[i17] = eVar.f48027e;
                this.f47993c[i17] = eVar.f48028f;
            }
            c cVar3 = this.f47991a;
            int i18 = cVar3.f48007e;
            if (i18 != 1) {
                if (i18 == 2) {
                    cVar3.f();
                } else if (i18 == 3) {
                    cVar3.g();
                }
            }
            c cVar4 = this.f47991a;
            if (cVar4.f48007e == 3) {
                break;
            }
            cVar4.a(this.f47994d);
            this.f47994d.lengthSquared();
            this.f47991a.c(this.f47995e);
            if (this.f47995e.lengthSquared() < 1.4210855E-14f) {
                break;
            }
            e eVar2 = eVarArr[this.f47991a.f48007e];
            Rot.mulTransUnsafe(transform.f48118q, this.f47995e.negateLocal(), this.f47996f);
            int a16 = c0398b.a(this.f47996f);
            eVar2.f48027e = a16;
            Transform.mulToOutUnsafe(transform, c0398b.b(a16), eVar2.f48023a);
            Rot.mulTransUnsafe(transform2.f48118q, this.f47995e.negateLocal(), this.f47996f);
            int a17 = c0398b2.a(this.f47996f);
            eVar2.f48028f = a17;
            Transform.mulToOutUnsafe(transform2, c0398b2.b(a17), eVar2.f48024b);
            eVar2.f48025c.set(eVar2.f48024b).subLocal(eVar2.f48023a);
            i3++;
            f47989i++;
            int i19 = 0;
            while (true) {
                if (i19 >= i16) {
                    z16 = false;
                    break;
                } else {
                    if (eVar2.f48027e == this.f47992b[i19] && eVar2.f48028f == this.f47993c[i19]) {
                        z16 = true;
                        break;
                    }
                    i19++;
                }
            }
            if (z16) {
                break;
            }
            this.f47991a.f48007e++;
        }
        f47990j = com.qzone.jbox2d.common.b.k(f47990j, i3);
        this.f47991a.d(dVar.f48035a, dVar.f48036b);
        dVar.f48037c = com.qzone.jbox2d.common.b.e(dVar.f48035a, dVar.f48036b);
        dVar.f48038d = i3;
        this.f47991a.h(dVar2);
        if (cVar.f48034e) {
            float f16 = c0398b.f48001c;
            float f17 = c0398b2.f48001c;
            float f18 = dVar.f48037c;
            float f19 = f16 + f17;
            if (f18 > f19 && f18 > 1.1920929E-7f) {
                dVar.f48037c = f18 - f19;
                this.f47997g.set(dVar.f48036b).subLocal(dVar.f48035a);
                this.f47997g.normalize();
                this.f47996f.set(this.f47997g).mulLocal(f16);
                dVar.f48035a.addLocal(this.f47996f);
                this.f47996f.set(this.f47997g).mulLocal(f17);
                dVar.f48036b.subLocal(this.f47996f);
                return;
            }
            dVar.f48035a.addLocal(dVar.f48036b).mulLocal(0.5f);
            dVar.f48036b.set(dVar.f48035a);
            dVar.f48037c = 0.0f;
        }
    }
}
