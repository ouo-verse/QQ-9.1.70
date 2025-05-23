package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class co extends dp {

    /* renamed from: a, reason: collision with root package name */
    private boolean f388428a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f388430c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f388432e;

    /* renamed from: g, reason: collision with root package name */
    private boolean f388434g;

    /* renamed from: i, reason: collision with root package name */
    private boolean f388436i;

    /* renamed from: k, reason: collision with root package name */
    private boolean f388438k;

    /* renamed from: m, reason: collision with root package name */
    private boolean f388440m;

    /* renamed from: o, reason: collision with root package name */
    private boolean f388442o;

    /* renamed from: q, reason: collision with root package name */
    private boolean f388444q;

    /* renamed from: s, reason: collision with root package name */
    private boolean f388446s;

    /* renamed from: u, reason: collision with root package name */
    private boolean f388448u;

    /* renamed from: w, reason: collision with root package name */
    private boolean f388450w;

    /* renamed from: y, reason: collision with root package name */
    private boolean f388452y;

    /* renamed from: b, reason: collision with root package name */
    private int f388429b = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f388431d = 0;

    /* renamed from: f, reason: collision with root package name */
    private String f388433f = "";

    /* renamed from: h, reason: collision with root package name */
    private String f388435h = "";

    /* renamed from: j, reason: collision with root package name */
    private String f388437j = "";

    /* renamed from: l, reason: collision with root package name */
    private String f388439l = "";

    /* renamed from: n, reason: collision with root package name */
    private String f388441n = "";

    /* renamed from: p, reason: collision with root package name */
    private int f388443p = 1;

    /* renamed from: r, reason: collision with root package name */
    private int f388445r = 0;

    /* renamed from: t, reason: collision with root package name */
    private int f388447t = 0;

    /* renamed from: v, reason: collision with root package name */
    private String f388449v = "";

    /* renamed from: x, reason: collision with root package name */
    private long f388451x = 0;

    /* renamed from: z, reason: collision with root package name */
    private long f388453z = 0;
    private int A = -1;

    public co A(long j3) {
        this.f388452y = true;
        this.f388453z = j3;
        return this;
    }

    public co B(String str) {
        this.f388436i = true;
        this.f388437j = str;
        return this;
    }

    public String C() {
        return this.f388437j;
    }

    public boolean D() {
        return this.f388432e;
    }

    public int E() {
        return this.f388443p;
    }

    public co F(int i3) {
        this.f388446s = true;
        this.f388447t = i3;
        return this;
    }

    public co G(String str) {
        this.f388438k = true;
        this.f388439l = str;
        return this;
    }

    public String H() {
        return this.f388439l;
    }

    public boolean I() {
        return this.f388434g;
    }

    public int J() {
        return this.f388445r;
    }

    public co K(String str) {
        this.f388440m = true;
        this.f388441n = str;
        return this;
    }

    public String L() {
        return this.f388441n;
    }

    public boolean M() {
        return this.f388436i;
    }

    public int N() {
        return this.f388447t;
    }

    public co O(String str) {
        this.f388448u = true;
        this.f388449v = str;
        return this;
    }

    public String P() {
        return this.f388449v;
    }

    public boolean Q() {
        return this.f388438k;
    }

    public boolean R() {
        return this.f388440m;
    }

    public boolean S() {
        return this.f388442o;
    }

    public boolean T() {
        return this.f388444q;
    }

    public boolean U() {
        return this.f388446s;
    }

    public boolean V() {
        return this.f388448u;
    }

    public boolean W() {
        return this.f388450w;
    }

    public boolean X() {
        return this.f388452y;
    }

    @Override // com.xiaomi.push.dp
    public int a() {
        if (this.A < 0) {
            i();
        }
        return this.A;
    }

    @Override // com.xiaomi.push.dp
    public void e(c cVar) {
        if (q()) {
            cVar.t(1, x());
        }
        if (w()) {
            cVar.N(2, j());
        }
        if (D()) {
            cVar.x(3, p());
        }
        if (I()) {
            cVar.x(4, v());
        }
        if (M()) {
            cVar.x(5, C());
        }
        if (Q()) {
            cVar.x(6, H());
        }
        if (R()) {
            cVar.x(7, L());
        }
        if (S()) {
            cVar.t(8, E());
        }
        if (T()) {
            cVar.t(9, J());
        }
        if (U()) {
            cVar.t(10, N());
        }
        if (V()) {
            cVar.x(11, P());
        }
        if (W()) {
            cVar.N(12, r());
        }
        if (X()) {
            cVar.N(13, y());
        }
    }

    @Override // com.xiaomi.push.dp
    public int i() {
        int i3 = 0;
        if (q()) {
            i3 = 0 + c.c(1, x());
        }
        if (w()) {
            i3 += c.I(2, j());
        }
        if (D()) {
            i3 += c.g(3, p());
        }
        if (I()) {
            i3 += c.g(4, v());
        }
        if (M()) {
            i3 += c.g(5, C());
        }
        if (Q()) {
            i3 += c.g(6, H());
        }
        if (R()) {
            i3 += c.g(7, L());
        }
        if (S()) {
            i3 += c.c(8, E());
        }
        if (T()) {
            i3 += c.c(9, J());
        }
        if (U()) {
            i3 += c.c(10, N());
        }
        if (V()) {
            i3 += c.g(11, P());
        }
        if (W()) {
            i3 += c.I(12, r());
        }
        if (X()) {
            i3 += c.I(13, y());
        }
        this.A = i3;
        return i3;
    }

    public long j() {
        return this.f388431d;
    }

    public co k() {
        this.f388438k = false;
        this.f388439l = "";
        return this;
    }

    public co l(int i3) {
        this.f388428a = true;
        this.f388429b = i3;
        return this;
    }

    public co m(long j3) {
        this.f388430c = true;
        this.f388431d = j3;
        return this;
    }

    @Override // com.xiaomi.push.dp
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public co b(ac acVar) {
        while (true) {
            int b16 = acVar.b();
            switch (b16) {
                case 0:
                    return this;
                case 8:
                    l(acVar.p());
                    break;
                case 16:
                    m(acVar.q());
                    break;
                case 26:
                    o(acVar.h());
                    break;
                case 34:
                    u(acVar.h());
                    break;
                case 42:
                    B(acVar.h());
                    break;
                case 50:
                    G(acVar.h());
                    break;
                case 58:
                    K(acVar.h());
                    break;
                case 64:
                    s(acVar.p());
                    break;
                case 72:
                    z(acVar.p());
                    break;
                case 80:
                    F(acVar.p());
                    break;
                case 90:
                    O(acVar.h());
                    break;
                case 96:
                    t(acVar.q());
                    break;
                case 104:
                    A(acVar.q());
                    break;
                default:
                    if (!g(acVar, b16)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public co o(String str) {
        this.f388432e = true;
        this.f388433f = str;
        return this;
    }

    public String p() {
        return this.f388433f;
    }

    public boolean q() {
        return this.f388428a;
    }

    public long r() {
        return this.f388451x;
    }

    public co s(int i3) {
        this.f388442o = true;
        this.f388443p = i3;
        return this;
    }

    public co t(long j3) {
        this.f388450w = true;
        this.f388451x = j3;
        return this;
    }

    public co u(String str) {
        this.f388434g = true;
        this.f388435h = str;
        return this;
    }

    public String v() {
        return this.f388435h;
    }

    public boolean w() {
        return this.f388430c;
    }

    public int x() {
        return this.f388429b;
    }

    public long y() {
        return this.f388453z;
    }

    public co z(int i3) {
        this.f388444q = true;
        this.f388445r = i3;
        return this;
    }
}
