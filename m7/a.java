package m7;

import com.qzone.jbox2d.collision.Collision;
import com.qzone.jbox2d.collision.TimeOfImpact;
import com.qzone.jbox2d.common.Mat22;
import com.qzone.jbox2d.common.Mat33;
import com.qzone.jbox2d.common.Rot;
import com.qzone.jbox2d.common.Vec2;
import com.qzone.jbox2d.common.Vec3;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements k7.b {

    /* renamed from: a, reason: collision with root package name */
    private final m7.c<Vec2> f416324a;

    /* renamed from: b, reason: collision with root package name */
    private final m7.c<Vec3> f416325b;

    /* renamed from: c, reason: collision with root package name */
    private final m7.c<Mat22> f416326c;

    /* renamed from: d, reason: collision with root package name */
    private final m7.c<Mat33> f416327d;

    /* renamed from: e, reason: collision with root package name */
    private final m7.c<com.qzone.jbox2d.collision.a> f416328e;

    /* renamed from: f, reason: collision with root package name */
    private final m7.c<Rot> f416329f;

    /* renamed from: g, reason: collision with root package name */
    private final HashMap<Integer, float[]> f416330g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private final HashMap<Integer, int[]> f416331h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private final HashMap<Integer, Vec2[]> f416332i = new HashMap<>();

    /* renamed from: j, reason: collision with root package name */
    private final k7.b f416333j = this;

    /* renamed from: k, reason: collision with root package name */
    private final m7.b<h7.d> f416334k = new e(com.qzone.jbox2d.common.d.f48137e);

    /* renamed from: l, reason: collision with root package name */
    private final m7.b<h7.d> f416335l = new f(com.qzone.jbox2d.common.d.f48137e);

    /* renamed from: m, reason: collision with root package name */
    private final m7.b<h7.d> f416336m = new g(com.qzone.jbox2d.common.d.f48137e);

    /* renamed from: n, reason: collision with root package name */
    private final m7.b<h7.d> f416337n = new h(com.qzone.jbox2d.common.d.f48137e);

    /* renamed from: o, reason: collision with root package name */
    private final m7.b<h7.d> f416338o = new i(com.qzone.jbox2d.common.d.f48137e);

    /* renamed from: p, reason: collision with root package name */
    private final m7.b<h7.d> f416339p = new j(com.qzone.jbox2d.common.d.f48137e);

    /* renamed from: q, reason: collision with root package name */
    private final m7.b<h7.d> f416340q = new k(com.qzone.jbox2d.common.d.f48137e);

    /* renamed from: t, reason: collision with root package name */
    private final com.qzone.jbox2d.collision.b f416343t = new com.qzone.jbox2d.collision.b();

    /* renamed from: r, reason: collision with root package name */
    private final Collision f416341r = new Collision(this);

    /* renamed from: s, reason: collision with root package name */
    private final TimeOfImpact f416342s = new TimeOfImpact(this);

    /* compiled from: P */
    /* renamed from: m7.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    class C10770a extends m7.c<Mat22> {
        C10770a(int i3, int i16) {
            super(i3, i16);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m7.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Mat22 a() {
            return new Mat22();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class b extends m7.c<com.qzone.jbox2d.collision.a> {
        b(int i3, int i16) {
            super(i3, i16);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m7.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public com.qzone.jbox2d.collision.a a() {
            return new com.qzone.jbox2d.collision.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class c extends m7.c<Rot> {
        c(int i3, int i16) {
            super(i3, i16);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m7.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Rot a() {
            return new Rot();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class d extends m7.c<Mat33> {
        d(int i3, int i16) {
            super(i3, i16);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m7.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Mat33 a() {
            return new Mat33();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class e extends m7.b<h7.d> {
        e(int i3) {
            super(i3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m7.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public h7.d[] b(int i3) {
            return new h7.m[i3];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m7.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public h7.d c() {
            return new h7.m(a.this.f416333j);
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class f extends m7.b<h7.d> {
        f(int i3) {
            super(i3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m7.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public h7.d[] b(int i3) {
            return new h7.c[i3];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m7.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public h7.d c() {
            return new h7.c(a.this.f416333j);
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class g extends m7.b<h7.d> {
        g(int i3) {
            super(i3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m7.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public h7.d[] b(int i3) {
            return new h7.l[i3];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m7.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public h7.d c() {
            return new h7.l(a.this.f416333j);
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class h extends m7.b<h7.d> {
        h(int i3) {
            super(i3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m7.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public h7.d[] b(int i3) {
            return new h7.j[i3];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m7.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public h7.d c() {
            return new h7.j(a.this.f416333j);
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class i extends m7.b<h7.d> {
        i(int i3) {
            super(i3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m7.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public h7.d[] b(int i3) {
            return new h7.k[i3];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m7.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public h7.d c() {
            return new h7.k(a.this.f416333j);
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class j extends m7.b<h7.d> {
        j(int i3) {
            super(i3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m7.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public h7.d[] b(int i3) {
            return new h7.a[i3];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m7.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public h7.d c() {
            return new h7.a(a.this.f416333j);
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class k extends m7.b<h7.d> {
        k(int i3) {
            super(i3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m7.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public h7.d[] b(int i3) {
            return new h7.b[i3];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m7.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public h7.d c() {
            return new h7.b(a.this.f416333j);
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class l extends m7.c<Vec2> {
        l(int i3, int i16) {
            super(i3, i16);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m7.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Vec2 a() {
            return new Vec2();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class m extends m7.c<Vec3> {
        m(int i3, int i16) {
            super(i3, i16);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m7.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Vec3 a() {
            return new Vec3();
        }
    }

    public a(int i3, int i16) {
        this.f416324a = new l(i3, i16);
        this.f416325b = new m(i3, i16);
        this.f416326c = new C10770a(i3, i16);
        this.f416328e = new b(i3, i16);
        this.f416329f = new c(i3, i16);
        this.f416327d = new d(i3, i16);
    }

    @Override // k7.b
    public k7.a<h7.d> getChainCircleContactStack() {
        return this.f416339p;
    }

    @Override // k7.b
    public k7.a<h7.d> getChainPolyContactStack() {
        return this.f416340q;
    }

    @Override // k7.b
    public final k7.a<h7.d> getCircleContactStack() {
        return this.f416335l;
    }

    @Override // k7.b
    public final Collision getCollision() {
        return this.f416341r;
    }

    @Override // k7.b
    public final com.qzone.jbox2d.collision.b getDistance() {
        return this.f416343t;
    }

    @Override // k7.b
    public k7.a<h7.d> getEdgeCircleContactStack() {
        return this.f416337n;
    }

    @Override // k7.b
    public k7.a<h7.d> getEdgePolyContactStack() {
        return this.f416338o;
    }

    @Override // k7.b
    public final k7.a<h7.d> getPolyCircleContactStack() {
        return this.f416336m;
    }

    @Override // k7.b
    public final k7.a<h7.d> getPolyContactStack() {
        return this.f416334k;
    }

    @Override // k7.b
    public final TimeOfImpact getTimeOfImpact() {
        return this.f416342s;
    }

    @Override // k7.b
    public final Vec2 popVec2() {
        return this.f416324a.b();
    }

    @Override // k7.b
    public final void pushVec2(int i3) {
        this.f416324a.c(i3);
    }
}
