package j7;

import com.qzone.jbox2d.common.Rot;
import com.qzone.jbox2d.common.Transform;
import com.qzone.jbox2d.common.Vec2;
import com.qzone.jbox2d.dynamics.l;
import java.lang.reflect.Array;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes38.dex */
public class f {
    public j7.c[] A;
    public j7.a[] D;
    d[] G;
    j[] J;
    l V;

    /* renamed from: p, reason: collision with root package name */
    float[] f409591p;

    /* renamed from: q, reason: collision with root package name */
    Vec2[] f409592q;

    /* renamed from: r, reason: collision with root package name */
    float[] f409593r;

    /* renamed from: t, reason: collision with root package name */
    j7.e[] f409595t;

    /* renamed from: x, reason: collision with root package name */
    g[] f409599x;
    private final com.qzone.jbox2d.collision.a W = new com.qzone.jbox2d.collision.a();
    private final b X = new b();
    private final com.qzone.jbox2d.collision.a Y = new com.qzone.jbox2d.collision.a();
    private final Vec2 Z = new Vec2();

    /* renamed from: a0, reason: collision with root package name */
    private final Transform f409566a0 = new Transform();

    /* renamed from: b0, reason: collision with root package name */
    private final Transform f409568b0 = new Transform();

    /* renamed from: c0, reason: collision with root package name */
    private a f409570c0 = new a();

    /* renamed from: d0, reason: collision with root package name */
    private final j7.d f409572d0 = new j7.d();

    /* renamed from: e0, reason: collision with root package name */
    private final k f409574e0 = new k();

    /* renamed from: f0, reason: collision with root package name */
    private h f409576f0 = new h();

    /* renamed from: g0, reason: collision with root package name */
    private final Vec2 f409578g0 = new Vec2();

    /* renamed from: h0, reason: collision with root package name */
    private final Rot f409580h0 = new Rot();

    /* renamed from: i0, reason: collision with root package name */
    private final Transform f409582i0 = new Transform();

    /* renamed from: j0, reason: collision with root package name */
    private final Transform f409584j0 = new Transform();

    /* renamed from: k0, reason: collision with root package name */
    private final c f409586k0 = new c();

    /* renamed from: a, reason: collision with root package name */
    int f409565a = 0;

    /* renamed from: b, reason: collision with root package name */
    int f409567b = 0;

    /* renamed from: c, reason: collision with root package name */
    int f409569c = 0;

    /* renamed from: d, reason: collision with root package name */
    float f409571d = 1.0f;

    /* renamed from: e, reason: collision with root package name */
    float f409573e = 1.0f;

    /* renamed from: f, reason: collision with root package name */
    float f409575f = 1.0f;

    /* renamed from: g, reason: collision with root package name */
    float f409577g = 1.0f;

    /* renamed from: h, reason: collision with root package name */
    float f409579h = 1.0f;

    /* renamed from: i, reason: collision with root package name */
    float f409581i = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    int f409583j = 0;

    /* renamed from: k, reason: collision with root package name */
    int f409585k = 0;

    /* renamed from: l, reason: collision with root package name */
    int f409587l = 0;

    /* renamed from: v, reason: collision with root package name */
    int f409597v = 0;

    /* renamed from: w, reason: collision with root package name */
    int f409598w = 0;

    /* renamed from: y, reason: collision with root package name */
    public int f409600y = 0;

    /* renamed from: z, reason: collision with root package name */
    int f409601z = 0;
    public int B = 0;
    int C = 0;
    int E = 0;
    int F = 0;
    int H = 0;
    int I = 0;
    int K = 0;
    float L = 0.05f;
    float M = 1.0f;
    float N = 0.25f;
    float O = 0.25f;
    float P = 0.25f;
    float Q = 0.1f;
    float R = 0.2f;
    float S = 0.5f;
    float T = 0.5f;
    float U = 0.5f;

    /* renamed from: m, reason: collision with root package name */
    C10572f f409588m = new C10572f();

    /* renamed from: n, reason: collision with root package name */
    e<Vec2> f409589n = new e<>(Vec2.class);

    /* renamed from: o, reason: collision with root package name */
    e<Vec2> f409590o = new e<>(Vec2.class);

    /* renamed from: s, reason: collision with root package name */
    public e<j7.b> f409594s = new e<>(j7.b.class);

    /* renamed from: u, reason: collision with root package name */
    e<Object> f409596u = new e<>(Object.class);

    /* compiled from: P */
    /* loaded from: classes38.dex */
    static class a {
        a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    static class b {
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    private static class c {
        c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class d {
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class e<T> {

        /* renamed from: a, reason: collision with root package name */
        public T[] f409602a;

        /* renamed from: b, reason: collision with root package name */
        final Class<T> f409603b;

        public e(Class<T> cls) {
            this.f409603b = cls;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: j7.f$f, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static class C10572f {

        /* renamed from: a, reason: collision with root package name */
        int[] f409604a;

        C10572f() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class g implements Comparable<g> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class h implements f7.f {

        /* renamed from: a, reason: collision with root package name */
        f f409605a;

        /* renamed from: b, reason: collision with root package name */
        com.qzone.jbox2d.dynamics.k f409606b;

        /* renamed from: c, reason: collision with root package name */
        private final com.qzone.jbox2d.collision.f f409607c = new com.qzone.jbox2d.collision.f();

        /* renamed from: d, reason: collision with root package name */
        private final com.qzone.jbox2d.collision.g f409608d = new com.qzone.jbox2d.collision.g();

        /* renamed from: e, reason: collision with root package name */
        private final Vec2 f409609e = new Vec2();

        /* renamed from: f, reason: collision with root package name */
        private final Vec2 f409610f = new Vec2();

        h() {
        }

        @Override // f7.f
        public boolean a(com.qzone.jbox2d.dynamics.e eVar) {
            if (eVar.k()) {
                return true;
            }
            com.qzone.jbox2d.collision.shapes.f i3 = eVar.i();
            eVar.f();
            int d16 = i3.d();
            for (int i16 = 0; i16 < d16; i16++) {
                com.qzone.jbox2d.collision.a e16 = eVar.e(i16);
                Vec2 vec2 = e16.f47986a;
                float f16 = vec2.f48119x;
                f fVar = this.f409605a;
                float f17 = fVar.f409577g;
                float f18 = f16 - f17;
                float f19 = vec2.f48120y - f17;
                Vec2 vec22 = e16.f47987b;
                float f26 = vec22.f48119x + f17;
                float f27 = vec22.f48120y + f17;
                g[] gVarArr = fVar.f409599x;
                int i17 = fVar.f409597v;
                float f28 = fVar.f409579h;
                int h16 = f.h(gVarArr, i17, f.c(f18 * f28, f28 * f19));
                f fVar2 = this.f409605a;
                g[] gVarArr2 = fVar2.f409599x;
                int i18 = fVar2.f409597v;
                float f29 = fVar2.f409579h;
                if (h16 != f.A(gVarArr2, i18, f.c(f26 * f29, f29 * f27))) {
                    g gVar = this.f409605a.f409599x[h16];
                    throw null;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class i {
        static boolean a(j7.a aVar) {
            return aVar.f409549a < 0;
        }

        static boolean b(j7.c cVar) {
            return cVar.f409558a < 0 || cVar.f409559b < 0;
        }

        static boolean c(d dVar) {
            throw null;
        }

        static boolean d(g gVar) {
            throw null;
        }

        static boolean e(j jVar) {
            throw null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class j {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class k implements f7.f {

        /* renamed from: a, reason: collision with root package name */
        f f409611a;

        /* renamed from: b, reason: collision with root package name */
        private final Vec2 f409612b = new Vec2();

        k() {
        }

        @Override // f7.f
        public boolean a(com.qzone.jbox2d.dynamics.e eVar) {
            if (eVar.k()) {
                return true;
            }
            com.qzone.jbox2d.collision.shapes.f i3 = eVar.i();
            com.qzone.jbox2d.dynamics.a f16 = eVar.f();
            f16.m();
            f16.h();
            f16.f();
            f16.g().lengthSquared();
            int d16 = i3.d();
            for (int i16 = 0; i16 < d16; i16++) {
                com.qzone.jbox2d.collision.a e16 = eVar.e(i16);
                Vec2 vec2 = e16.f47986a;
                float f17 = vec2.f48119x;
                f fVar = this.f409611a;
                float f18 = fVar.f409577g;
                float f19 = f17 - f18;
                float f26 = vec2.f48120y - f18;
                Vec2 vec22 = e16.f47987b;
                float f27 = vec22.f48119x + f18;
                float f28 = vec22.f48120y + f18;
                g[] gVarArr = fVar.f409599x;
                int i17 = fVar.f409597v;
                float f29 = fVar.f409579h;
                int h16 = f.h(gVarArr, i17, f.c(f19 * f29, f29 * f26));
                f fVar2 = this.f409611a;
                g[] gVarArr2 = fVar2.f409599x;
                int i18 = fVar2.f409597v;
                float f36 = fVar2.f409579h;
                if (h16 != f.A(gVarArr2, i18, f.c(f27 * f36, f36 * f28))) {
                    g gVar = this.f409611a.f409599x[h16];
                    throw null;
                }
            }
            return true;
        }
    }

    public f(l lVar) {
        this.V = lVar;
    }

    static long c(float f16, float f17) {
        return ((f17 + 2048.0f) << 19) + (f16 * 128.0f) + 262144;
    }

    float d(com.qzone.jbox2d.dynamics.k kVar) {
        return this.f409571d * f(kVar);
    }

    float e(com.qzone.jbox2d.dynamics.k kVar) {
        return this.f409577g * kVar.f48270b;
    }

    float f(com.qzone.jbox2d.dynamics.k kVar) {
        float e16 = e(kVar);
        return e16 * e16;
    }

    public void k(com.qzone.jbox2d.dynamics.k kVar) {
        this.f409565a++;
        if (this.f409583j == 0) {
            return;
        }
        this.f409567b = 0;
        for (int i3 = 0; i3 < this.f409583j; i3++) {
            this.f409567b |= this.f409588m.f409604a[i3];
        }
        if ((this.f409567b & 2) != 0) {
            x();
        }
        if (this.f409583j == 0) {
            return;
        }
        this.f409569c = 0;
        float f16 = kVar.f48269a * this.f409575f * this.V.e().f48119x;
        float f17 = kVar.f48269a * this.f409575f * this.V.e().f48120y;
        float f18 = f(kVar);
        for (int i16 = 0; i16 < this.f409583j; i16++) {
            Vec2 vec2 = this.f409590o.f409602a[i16];
            float f19 = vec2.f48119x + f16;
            vec2.f48119x = f19;
            float f26 = vec2.f48120y + f17;
            vec2.f48120y = f26;
            float f27 = (f19 * f19) + (f26 * f26);
            if (f27 > f18) {
                float p16 = f27 == 0.0f ? Float.MAX_VALUE : com.qzone.jbox2d.common.b.p(f18 / f27);
                vec2.f48119x *= p16;
                vec2.f48120y *= p16;
            }
        }
        l(kVar);
        if ((this.f409569c & 2) != 0) {
            r(kVar);
        }
        if ((this.f409567b & 4) != 0) {
            w(kVar);
        }
        for (int i17 = 0; i17 < this.f409583j; i17++) {
            Vec2 vec22 = this.f409589n.f409602a[i17];
            Vec2 vec23 = this.f409590o.f409602a[i17];
            float f28 = vec22.f48119x;
            float f29 = kVar.f48269a;
            vec22.f48119x = f28 + (vec23.f48119x * f29);
            vec22.f48120y += f29 * vec23.f48120y;
        }
        y();
        z(false);
        if ((this.f409567b & 32) != 0) {
            v(kVar);
        }
        if ((this.f409567b & 64) != 0) {
            p(kVar);
        }
        if ((this.f409567b & 128) != 0) {
            u(kVar);
        }
        if ((this.f409567b & 16) != 0) {
            o(kVar);
        }
        if ((this.f409567b & 8) != 0) {
            t(kVar);
        }
        if ((this.f409569c & 1) != 0) {
            s(kVar);
        }
        if ((this.f409567b & 256) != 0) {
            m(kVar);
        }
        q(kVar);
        n(kVar);
    }

    public void l(com.qzone.jbox2d.dynamics.k kVar) {
        com.qzone.jbox2d.collision.a aVar = this.W;
        Vec2 vec2 = aVar.f47986a;
        Vec2 vec22 = aVar.f47987b;
        vec2.f48119x = Float.MAX_VALUE;
        vec2.f48120y = Float.MAX_VALUE;
        vec22.f48119x = -3.4028235E38f;
        vec22.f48120y = -3.4028235E38f;
        for (int i3 = 0; i3 < this.f409583j; i3++) {
            Vec2 vec23 = this.f409590o.f409602a[i3];
            Vec2 vec24 = this.f409589n.f409602a[i3];
            float f16 = vec24.f48119x;
            float f17 = vec24.f48120y;
            float f18 = kVar.f48269a;
            float f19 = (vec23.f48119x * f18) + f16;
            float f26 = (f18 * vec23.f48120y) + f17;
            float f27 = f16 < f19 ? f16 : f19;
            float f28 = f17 < f26 ? f17 : f26;
            float f29 = vec2.f48119x;
            if (f29 < f27) {
                f27 = f29;
            }
            vec2.f48119x = f27;
            float f36 = vec2.f48120y;
            if (f36 < f28) {
                f28 = f36;
            }
            vec2.f48120y = f28;
            if (f16 <= f19) {
                f16 = f19;
            }
            if (f17 <= f26) {
                f17 = f26;
            }
            float f37 = vec22.f48119x;
            if (f37 > f16) {
                f16 = f37;
            }
            vec22.f48119x = f16;
            float f38 = vec22.f48120y;
            if (f38 > f17) {
                f17 = f38;
            }
            vec22.f48120y = f17;
        }
        h hVar = this.f409576f0;
        hVar.f409606b = kVar;
        hVar.f409605a = this;
        this.V.l(hVar, aVar);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T[], java.lang.Object[]] */
    void m(com.qzone.jbox2d.dynamics.k kVar) {
        e<j7.b> eVar = this.f409594s;
        eVar.f409602a = j(j7.b.class, eVar.f409602a);
        int i3 = (int) (this.U * 256.0f);
        for (int i16 = 0; i16 < this.f409600y; i16++) {
            j7.c cVar = this.A[i16];
            int i17 = cVar.f409558a;
            int i18 = cVar.f409559b;
            int[] iArr = this.f409588m.f409604a;
            if ((iArr[i18] & iArr[i17] & 256) != 0) {
                j7.b[] bVarArr = this.f409594s.f409602a;
                j7.b bVar = bVarArr[i17];
                j7.b bVar2 = bVarArr[i18];
                int i19 = bVar2.f409554a & 255;
                byte b16 = bVar.f409554a;
                int i26 = ((i19 - (b16 & 255)) * i3) >> 8;
                int i27 = bVar2.f409555b & 255;
                byte b17 = bVar.f409555b;
                int i28 = ((i27 - (b17 & 255)) * i3) >> 8;
                int i29 = bVar2.f409556c & 255;
                byte b18 = bVar.f409556c;
                int i36 = ((i29 - (b18 & 255)) * i3) >> 8;
                int i37 = bVar2.f409557d & 255;
                byte b19 = bVar.f409557d;
                int i38 = ((i37 - (b19 & 255)) * i3) >> 8;
                bVar.f409554a = (byte) (b16 + i26);
                bVar.f409555b = (byte) (b17 + i28);
                bVar.f409556c = (byte) (b18 + i36);
                bVar.f409557d = (byte) (b19 + i38);
                bVar2.f409554a = (byte) (bVar2.f409554a - i26);
                bVar2.f409555b = (byte) (bVar2.f409555b - i28);
                bVar2.f409556c = (byte) (bVar2.f409556c - i36);
                bVar2.f409557d = (byte) (bVar2.f409557d - i38);
            }
        }
    }

    void n(com.qzone.jbox2d.dynamics.k kVar) {
        float f16 = this.M;
        for (int i3 = 0; i3 < this.B; i3++) {
            j7.a aVar = this.D[i3];
            int i16 = aVar.f409549a;
            com.qzone.jbox2d.dynamics.a aVar2 = aVar.f409550b;
            float f17 = aVar.f409551c;
            float f18 = aVar.f409553e;
            Vec2 vec2 = aVar.f409552d;
            Vec2 vec22 = this.f409589n.f409602a[i16];
            float f19 = vec22.f48119x;
            Vec2 vec23 = aVar2.f48165f.f48114c;
            float f26 = f19 - vec23.f48119x;
            float f27 = vec22.f48120y - vec23.f48120y;
            Vec2 vec24 = this.f409590o.f409602a[i16];
            float f28 = aVar2.f48167h;
            float f29 = (-f28) * f27;
            Vec2 vec25 = aVar2.f48166g;
            float f36 = (f29 + vec25.f48119x) - vec24.f48119x;
            float f37 = ((f28 * f26) + vec25.f48120y) - vec24.f48120y;
            float f38 = vec2.f48119x;
            float f39 = vec2.f48120y;
            float f46 = (f36 * f38) + (f37 * f39);
            if (f46 < 0.0f) {
                Vec2 vec26 = this.Z;
                float f47 = f17 * f16 * f18 * f46;
                vec26.f48119x = f38 * f47;
                vec26.f48120y = f47 * f39;
                float g16 = g();
                vec24.f48119x += vec26.f48119x * g16;
                vec24.f48120y += g16 * vec26.f48120y;
                vec26.f48119x = -vec26.f48119x;
                vec26.f48120y = -vec26.f48120y;
                aVar2.b(vec26, vec22, true);
            }
        }
        for (int i17 = 0; i17 < this.f409600y; i17++) {
            j7.c cVar = this.A[i17];
            int i18 = cVar.f409558a;
            int i19 = cVar.f409559b;
            float f48 = cVar.f409561d;
            Vec2 vec27 = cVar.f409562e;
            Vec2[] vec2Arr = this.f409590o.f409602a;
            Vec2 vec28 = vec2Arr[i18];
            Vec2 vec29 = vec2Arr[i19];
            float f49 = vec29.f48119x;
            float f56 = vec28.f48119x;
            float f57 = vec29.f48120y;
            float f58 = vec28.f48120y;
            float f59 = vec27.f48119x;
            float f65 = vec27.f48120y;
            float f66 = ((f49 - f56) * f59) + ((f57 - f58) * f65);
            if (f66 < 0.0f) {
                float f67 = f48 * f16 * f66;
                float f68 = f59 * f67;
                float f69 = f67 * f65;
                vec28.f48119x = f56 + f68;
                vec28.f48120y = f58 + f69;
                vec29.f48119x -= f68;
                vec29.f48120y -= f69;
            }
        }
    }

    void o(com.qzone.jbox2d.dynamics.k kVar) {
        float f16 = kVar.f48270b;
        if (this.H <= 0) {
            return;
        }
        j jVar = this.J[0];
        throw null;
    }

    void p(com.qzone.jbox2d.dynamics.k kVar) {
        float e16 = this.S * e(kVar);
        for (int i3 = 0; i3 < this.B; i3++) {
            j7.a aVar = this.D[i3];
            int i16 = aVar.f409549a;
            if ((this.f409588m.f409604a[i16] & 64) != 0) {
                float f16 = aVar.f409551c;
                if (f16 > 0.25f) {
                    com.qzone.jbox2d.dynamics.a aVar2 = aVar.f409550b;
                    float f17 = aVar.f409553e;
                    Vec2 vec2 = this.f409589n.f409602a[i16];
                    Vec2 vec22 = aVar.f409552d;
                    Vec2 vec23 = this.Z;
                    Vec2 vec24 = this.f409590o.f409602a[i16];
                    float f18 = f17 * e16 * (f16 - 0.25f);
                    float g16 = g();
                    float f19 = vec22.f48119x * f18;
                    vec23.f48119x = f19;
                    float f26 = f18 * vec22.f48120y;
                    vec23.f48120y = f26;
                    vec24.f48119x -= f19 * g16;
                    vec24.f48120y -= g16 * f26;
                    aVar2.b(vec23, vec2, true);
                }
            }
        }
        for (int i17 = 0; i17 < this.f409600y; i17++) {
            j7.c cVar = this.A[i17];
            if ((cVar.f409560c & 64) != 0) {
                float f27 = cVar.f409561d;
                if (f27 > 0.25f) {
                    int i18 = cVar.f409558a;
                    int i19 = cVar.f409559b;
                    Vec2 vec25 = cVar.f409562e;
                    Vec2[] vec2Arr = this.f409590o.f409602a;
                    Vec2 vec26 = vec2Arr[i18];
                    Vec2 vec27 = vec2Arr[i19];
                    float f28 = (f27 - 0.25f) * e16;
                    float f29 = vec25.f48119x * f28;
                    float f36 = f28 * vec25.f48120y;
                    vec26.f48119x -= f29;
                    vec26.f48120y -= f36;
                    vec27.f48119x += f29;
                    vec27.f48120y += f36;
                }
            }
        }
    }

    void s(com.qzone.jbox2d.dynamics.k kVar) {
        this.f409593r = i(this.f409593r);
        float f16 = kVar.f48270b;
        for (int i3 = 0; i3 < this.f409600y; i3++) {
            j7.c cVar = this.A[i3];
            int i16 = cVar.f409558a;
            int i17 = cVar.f409559b;
            j7.e[] eVarArr = this.f409595t;
            j7.e eVar = eVarArr[i16];
            j7.e eVar2 = eVarArr[i17];
        }
    }

    void t(com.qzone.jbox2d.dynamics.k kVar) {
        float f16 = kVar.f48270b;
        if (this.E <= 0) {
            return;
        }
        d dVar = this.G[0];
        throw null;
    }

    void u(com.qzone.jbox2d.dynamics.k kVar) {
        this.f409592q = (Vec2[]) j(Vec2.class, this.f409592q);
        for (int i3 = 0; i3 < this.f409583j; i3++) {
            this.f409591p[i3] = 0.0f;
            this.f409592q[i3].setZero();
        }
        for (int i16 = 0; i16 < this.f409600y; i16++) {
            j7.c cVar = this.A[i16];
            if ((cVar.f409560c & 128) != 0) {
                int i17 = cVar.f409558a;
                int i18 = cVar.f409559b;
                float f16 = cVar.f409561d;
                Vec2 vec2 = cVar.f409562e;
                float[] fArr = this.f409591p;
                fArr[i17] = fArr[i17] + f16;
                fArr[i18] = fArr[i18] + f16;
                Vec2[] vec2Arr = this.f409592q;
                Vec2 vec22 = vec2Arr[i17];
                Vec2 vec23 = vec2Arr[i18];
                float f17 = (1.0f - f16) * f16;
                vec22.f48119x -= vec2.f48119x * f17;
                vec22.f48120y -= vec2.f48120y * f17;
                vec23.f48119x += vec2.f48119x * f17;
                vec23.f48120y += f17 * vec2.f48120y;
            }
        }
        float e16 = this.Q * e(kVar);
        float e17 = this.R * e(kVar);
        for (int i19 = 0; i19 < this.f409600y; i19++) {
            j7.c cVar2 = this.A[i19];
            if ((cVar2.f409560c & 128) != 0) {
                int i26 = cVar2.f409558a;
                int i27 = cVar2.f409559b;
                float f18 = cVar2.f409561d;
                Vec2 vec24 = cVar2.f409562e;
                Vec2[] vec2Arr2 = this.f409592q;
                Vec2 vec25 = vec2Arr2[i26];
                Vec2 vec26 = vec2Arr2[i27];
                float[] fArr2 = this.f409591p;
                float f19 = fArr2[i26] + fArr2[i27];
                float f26 = vec26.f48119x - vec25.f48119x;
                float f27 = vec26.f48120y - vec25.f48120y;
                float f28 = vec24.f48119x;
                float f29 = vec24.f48120y;
                float f36 = (((f19 - 2.0f) * e16) + (((f26 * f28) + (f27 * f29)) * e17)) * f18;
                float f37 = f28 * f36;
                float f38 = f36 * f29;
                Vec2[] vec2Arr3 = this.f409590o.f409602a;
                Vec2 vec27 = vec2Arr3[i26];
                Vec2 vec28 = vec2Arr3[i27];
                vec27.f48119x -= f37;
                vec27.f48120y -= f38;
                vec28.f48119x += f37;
                vec28.f48120y += f38;
            }
        }
    }

    void v(com.qzone.jbox2d.dynamics.k kVar) {
        float f16 = this.P;
        for (int i3 = 0; i3 < this.B; i3++) {
            j7.a aVar = this.D[i3];
            int i16 = aVar.f409549a;
            if ((this.f409588m.f409604a[i16] & 32) != 0) {
                com.qzone.jbox2d.dynamics.a aVar2 = aVar.f409550b;
                float f17 = aVar.f409551c;
                float f18 = aVar.f409553e;
                Vec2 vec2 = this.f409589n.f409602a[i16];
                Vec2 vec22 = this.f409590o.f409602a[i16];
                float f19 = vec2.f48119x;
                Vec2 vec23 = aVar2.f48165f.f48114c;
                float f26 = f19 - vec23.f48119x;
                float f27 = vec2.f48120y - vec23.f48120y;
                float f28 = aVar2.f48167h;
                float f29 = (-f28) * f27;
                Vec2 vec24 = aVar2.f48166g;
                float f36 = (f29 + vec24.f48119x) - vec22.f48119x;
                float f37 = ((f28 * f26) + vec24.f48120y) - vec22.f48120y;
                Vec2 vec25 = this.Z;
                float g16 = g();
                float f38 = f18 * f16 * f17;
                float f39 = f36 * f38;
                vec25.f48119x = f39;
                float f46 = f38 * f37;
                vec25.f48120y = f46;
                vec22.f48119x += f39 * g16;
                vec22.f48120y += g16 * f46;
                vec25.f48119x = -vec25.f48119x;
                vec25.f48120y = -vec25.f48120y;
                aVar2.b(vec25, vec2, true);
            }
        }
        for (int i17 = 0; i17 < this.f409600y; i17++) {
            j7.c cVar = this.A[i17];
            if ((cVar.f409560c & 32) != 0) {
                int i18 = cVar.f409558a;
                int i19 = cVar.f409559b;
                float f47 = cVar.f409561d;
                Vec2[] vec2Arr = this.f409590o.f409602a;
                Vec2 vec26 = vec2Arr[i18];
                Vec2 vec27 = vec2Arr[i19];
                float f48 = vec27.f48119x;
                float f49 = vec26.f48119x;
                float f56 = vec27.f48120y;
                float f57 = vec26.f48120y;
                float f58 = f47 * f16;
                float f59 = (f48 - f49) * f58;
                float f65 = f58 * (f56 - f57);
                vec26.f48119x = f49 + f59;
                vec26.f48120y = f57 + f65;
                vec27.f48119x -= f59;
                vec27.f48120y -= f65;
            }
        }
    }

    void x() {
        int i3;
        int i16;
        int[] iArr = new int[this.f409583j];
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < this.f409583j; i19++) {
            int[] iArr2 = this.f409588m.f409604a;
            int i26 = iArr2[i19];
            if ((i26 & 2) != 0) {
                this.V.f();
                int i27 = i26 & 512;
                iArr[i19] = -1;
            } else {
                iArr[i19] = i18;
                if (i19 != i18) {
                    iArr2[i18] = iArr2[i19];
                    Vec2[] vec2Arr = this.f409589n.f409602a;
                    vec2Arr[i18].set(vec2Arr[i19]);
                    Vec2[] vec2Arr2 = this.f409590o.f409602a;
                    vec2Arr2[i18].set(vec2Arr2[i19]);
                    j7.e[] eVarArr = this.f409595t;
                    j7.e eVar = eVarArr[i19];
                    eVarArr[i18] = null;
                    float[] fArr = this.f409593r;
                    if (fArr != null) {
                        fArr[i18] = fArr[i19];
                    }
                    j7.b[] bVarArr = this.f409594s.f409602a;
                    if (bVarArr != null) {
                        bVarArr[i18].a(bVarArr[i19]);
                    }
                    Object[] objArr = this.f409596u.f409602a;
                    if (objArr != null) {
                        objArr[i18] = objArr[i19];
                    }
                }
                i18++;
            }
        }
        int i28 = this.f409597v;
        if (i28 <= 0) {
            int i29 = 0;
            while (i29 < i28) {
                g gVar = this.f409599x[i29];
                if (i.d(null)) {
                    i28--;
                    g[] gVarArr = this.f409599x;
                    g gVar2 = gVarArr[i28];
                    g gVar3 = gVarArr[i29];
                    gVarArr[i28] = null;
                    gVarArr[i29] = null;
                    i29--;
                }
                i29++;
            }
            this.f409597v = i28;
            int i36 = 0;
            while (true) {
                i3 = this.f409600y;
                if (i36 >= i3) {
                    break;
                }
                j7.c cVar = this.A[i36];
                cVar.f409558a = iArr[cVar.f409558a];
                cVar.f409559b = iArr[cVar.f409559b];
                i36++;
            }
            int i37 = 0;
            while (i37 < i3) {
                if (i.b(this.A[i37])) {
                    i3--;
                    j7.c[] cVarArr = this.A;
                    j7.c cVar2 = cVarArr[i3];
                    cVarArr[i3] = cVarArr[i37];
                    cVarArr[i37] = cVar2;
                    i37--;
                }
                i37++;
            }
            this.f409600y = i3;
            int i38 = 0;
            while (true) {
                i16 = this.B;
                if (i38 >= i16) {
                    break;
                }
                j7.a aVar = this.D[i38];
                aVar.f409549a = iArr[aVar.f409549a];
                i38++;
            }
            int i39 = 0;
            while (i39 < i16) {
                if (i.a(this.D[i39])) {
                    i16--;
                    j7.a[] aVarArr = this.D;
                    j7.a aVar2 = aVarArr[i16];
                    aVarArr[i16] = aVarArr[i39];
                    aVarArr[i39] = aVar2;
                    i39--;
                }
                i39++;
            }
            this.B = i16;
            int i46 = this.E;
            if (i46 <= 0) {
                int i47 = 0;
                while (i47 < i46) {
                    d dVar = this.G[i47];
                    if (i.c(null)) {
                        i46--;
                        d[] dVarArr = this.G;
                        d dVar2 = dVarArr[i46];
                        d dVar3 = dVarArr[i47];
                        dVarArr[i46] = null;
                        dVarArr[i47] = null;
                        i47--;
                    }
                    i47++;
                }
                this.E = i46;
                int i48 = this.H;
                if (i48 <= 0) {
                    while (i17 < i48) {
                        j jVar = this.J[i17];
                        if (i.e(null)) {
                            i48--;
                            j[] jVarArr = this.J;
                            j jVar2 = jVarArr[i48];
                            j jVar3 = jVarArr[i17];
                            jVarArr[i48] = null;
                            jVarArr[i17] = null;
                            i17--;
                        }
                        i17++;
                    }
                    this.H = i48;
                    this.f409583j = i18;
                    return;
                }
                j jVar4 = this.J[0];
                throw null;
            }
            d dVar4 = this.G[0];
            throw null;
        }
        g gVar4 = this.f409599x[0];
        throw null;
    }

    public void y() {
        com.qzone.jbox2d.collision.a aVar = this.W;
        Vec2 vec2 = aVar.f47986a;
        vec2.f48119x = Float.MAX_VALUE;
        vec2.f48120y = Float.MAX_VALUE;
        Vec2 vec22 = aVar.f47987b;
        vec22.f48119x = -3.4028235E38f;
        vec22.f48120y = -3.4028235E38f;
        for (int i3 = 0; i3 < this.f409583j; i3++) {
            Vec2 vec23 = this.f409589n.f409602a[i3];
            Vec2 vec24 = aVar.f47986a;
            Vec2.minToOut(vec24, vec23, vec24);
            Vec2 vec25 = aVar.f47987b;
            Vec2.maxToOut(vec25, vec23, vec25);
        }
        Vec2 vec26 = aVar.f47986a;
        float f16 = vec26.f48119x;
        float f17 = this.f409577g;
        vec26.f48119x = f16 - f17;
        vec26.f48120y -= f17;
        Vec2 vec27 = aVar.f47987b;
        vec27.f48119x += f17;
        vec27.f48120y += f17;
        this.B = 0;
        k kVar = this.f409574e0;
        kVar.f409611a = this;
        this.V.l(kVar, aVar);
    }

    public void z(boolean z16) {
        int i3 = this.f409597v;
        int i16 = 0;
        if (i3 <= 0) {
            Arrays.sort(this.f409599x, 0, i3);
            this.f409600y = 0;
            if (this.f409597v > 0) {
                g gVar = this.f409599x[0];
                throw null;
            }
            if (z16) {
                int i17 = 0;
                while (i16 < i17) {
                    j7.c[] cVarArr = this.A;
                    j7.c cVar = cVarArr[i16];
                    if ((cVar.f409560c & 2) != 0) {
                        i17--;
                        j7.c cVar2 = cVarArr[i17];
                        cVarArr[i17] = cVar;
                        cVarArr[i16] = cVar2;
                        i16--;
                    }
                    i16++;
                }
                this.f409600y = i17;
                return;
            }
            return;
        }
        g gVar2 = this.f409599x[0];
        throw null;
    }

    public void w(com.qzone.jbox2d.dynamics.k kVar) {
        for (int i3 = 0; i3 < this.f409583j; i3++) {
            if ((this.f409588m.f409604a[i3] & 4) != 0) {
                Vec2 vec2 = this.f409590o.f409602a[i3];
                vec2.f48119x = 0.0f;
                vec2.f48120y = 0.0f;
            }
        }
    }

    float[] i(float[] fArr) {
        return fArr == null ? new float[this.f409585k] : fArr;
    }

    <T> T[] j(Class<T> cls, T[] tArr) {
        if (tArr == null) {
            tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, this.f409585k));
            for (int i3 = 0; i3 < this.f409585k; i3++) {
                try {
                    tArr[i3] = cls.newInstance();
                } catch (Exception e16) {
                    throw new RuntimeException(e16);
                }
            }
        }
        return tArr;
    }

    void q(com.qzone.jbox2d.dynamics.k kVar) {
        for (int i3 = 0; i3 < this.f409583j; i3++) {
            this.f409591p[i3] = 0.0f;
        }
        for (int i16 = 0; i16 < this.B; i16++) {
            j7.a aVar = this.D[i16];
            int i17 = aVar.f409549a;
            float f16 = aVar.f409551c;
            float[] fArr = this.f409591p;
            fArr[i17] = fArr[i17] + f16;
        }
        for (int i18 = 0; i18 < this.f409600y; i18++) {
            j7.c cVar = this.A[i18];
            int i19 = cVar.f409558a;
            int i26 = cVar.f409559b;
            float f17 = cVar.f409561d;
            float[] fArr2 = this.f409591p;
            fArr2[i19] = fArr2[i19] + f17;
            fArr2[i26] = fArr2[i26] + f17;
        }
        if ((this.f409567b & 64) != 0) {
            for (int i27 = 0; i27 < this.f409583j; i27++) {
                if ((this.f409588m.f409604a[i27] & 64) != 0) {
                    this.f409591p[i27] = 0.0f;
                }
            }
        }
        float d16 = this.L * d(kVar);
        for (int i28 = 0; i28 < this.f409583j; i28++) {
            this.f409591p[i28] = com.qzone.jbox2d.common.b.j(0.0f, com.qzone.jbox2d.common.b.l(this.f409591p[i28], 5.0f) - 1.0f) * d16;
        }
        float f18 = kVar.f48269a / (this.f409571d * this.f409577g);
        for (int i29 = 0; i29 < this.B; i29++) {
            j7.a aVar2 = this.D[i29];
            int i36 = aVar2.f409549a;
            com.qzone.jbox2d.dynamics.a aVar3 = aVar2.f409550b;
            float f19 = aVar2.f409551c;
            float f26 = aVar2.f409553e;
            Vec2 vec2 = aVar2.f409552d;
            Vec2 vec22 = this.f409589n.f409602a[i36];
            float f27 = this.f409591p[i36] + (d16 * f19);
            Vec2 vec23 = this.Z;
            float f28 = f19 * f18 * f26 * f27;
            vec23.f48119x = vec2.f48119x * f28;
            vec23.f48120y = f28 * vec2.f48120y;
            Vec2 vec24 = this.f409590o.f409602a[i36];
            float g16 = g();
            vec24.f48119x -= vec23.f48119x * g16;
            vec24.f48120y -= g16 * vec23.f48120y;
            aVar3.b(vec23, vec22, true);
        }
        for (int i37 = 0; i37 < this.f409600y; i37++) {
            j7.c cVar2 = this.A[i37];
            int i38 = cVar2.f409558a;
            int i39 = cVar2.f409559b;
            float f29 = cVar2.f409561d;
            Vec2 vec25 = cVar2.f409562e;
            float[] fArr3 = this.f409591p;
            float f36 = f29 * f18 * (fArr3[i38] + fArr3[i39]);
            float f37 = vec25.f48119x * f36;
            float f38 = f36 * vec25.f48120y;
            Vec2[] vec2Arr = this.f409590o.f409602a;
            Vec2 vec26 = vec2Arr[i38];
            Vec2 vec27 = vec2Arr[i39];
            vec26.f48119x -= f37;
            vec26.f48120y -= f38;
            vec27.f48119x += f37;
            vec27.f48120y += f38;
        }
    }

    float g() {
        float f16 = this.f409573e * 1.777777f;
        float f17 = this.f409579h;
        return f16 * f17 * f17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int A(g[] gVarArr, int i3, long j3) {
        if (i3 <= 0) {
            return 0;
        }
        g gVar = gVarArr[0 + (i3 / 2)];
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int h(g[] gVarArr, int i3, long j3) {
        if (i3 <= 0) {
            return 0;
        }
        g gVar = gVarArr[0 + (i3 / 2)];
        throw null;
    }

    void r(com.qzone.jbox2d.dynamics.k kVar) {
    }
}
