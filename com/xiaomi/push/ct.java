package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ct extends dp {
    private int A;

    /* renamed from: a, reason: collision with root package name */
    private boolean f388494a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f388496c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f388498e;

    /* renamed from: g, reason: collision with root package name */
    private boolean f388500g;

    /* renamed from: i, reason: collision with root package name */
    private boolean f388502i;

    /* renamed from: k, reason: collision with root package name */
    private boolean f388504k;

    /* renamed from: m, reason: collision with root package name */
    private boolean f388506m;

    /* renamed from: o, reason: collision with root package name */
    private boolean f388508o;

    /* renamed from: q, reason: collision with root package name */
    private boolean f388510q;

    /* renamed from: s, reason: collision with root package name */
    private boolean f388512s;

    /* renamed from: u, reason: collision with root package name */
    private boolean f388514u;

    /* renamed from: v, reason: collision with root package name */
    private a f388515v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f388516w;

    /* renamed from: x, reason: collision with root package name */
    private a f388517x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f388518y;

    /* renamed from: z, reason: collision with root package name */
    private int f388519z;

    /* renamed from: b, reason: collision with root package name */
    private int f388495b = 0;

    /* renamed from: d, reason: collision with root package name */
    private String f388497d = "";

    /* renamed from: f, reason: collision with root package name */
    private String f388499f = "";

    /* renamed from: h, reason: collision with root package name */
    private String f388501h = "";

    /* renamed from: j, reason: collision with root package name */
    private int f388503j = 0;

    /* renamed from: l, reason: collision with root package name */
    private String f388505l = "";

    /* renamed from: n, reason: collision with root package name */
    private String f388507n = "";

    /* renamed from: p, reason: collision with root package name */
    private String f388509p = "";

    /* renamed from: r, reason: collision with root package name */
    private cp f388511r = null;

    /* renamed from: t, reason: collision with root package name */
    private int f388513t = 0;

    public ct() {
        a aVar = a.f388122c;
        this.f388515v = aVar;
        this.f388517x = aVar;
        this.f388519z = 0;
        this.A = -1;
    }

    public ct A(String str) {
        this.f388500g = true;
        this.f388501h = str;
        return this;
    }

    public String B() {
        return this.f388501h;
    }

    public boolean C() {
        return this.f388498e;
    }

    public int D() {
        return this.f388503j;
    }

    public ct E(int i3) {
        this.f388518y = true;
        this.f388519z = i3;
        return this;
    }

    public ct F(String str) {
        this.f388504k = true;
        this.f388505l = str;
        return this;
    }

    public String G() {
        return this.f388505l;
    }

    public boolean H() {
        return this.f388500g;
    }

    public int I() {
        return this.f388513t;
    }

    public ct J(String str) {
        this.f388506m = true;
        this.f388507n = str;
        return this;
    }

    public String K() {
        return this.f388507n;
    }

    public boolean L() {
        return this.f388502i;
    }

    public int M() {
        return this.f388519z;
    }

    public ct N(String str) {
        this.f388508o = true;
        this.f388509p = str;
        return this;
    }

    public String O() {
        return this.f388509p;
    }

    public boolean P() {
        return this.f388504k;
    }

    public boolean Q() {
        return this.f388506m;
    }

    public boolean R() {
        return this.f388508o;
    }

    public boolean S() {
        return this.f388510q;
    }

    public boolean T() {
        return this.f388512s;
    }

    public boolean U() {
        return this.f388514u;
    }

    public boolean V() {
        return this.f388516w;
    }

    public boolean W() {
        return this.f388518y;
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
        if (r()) {
            cVar.M(1, y());
        }
        if (x()) {
            cVar.x(2, q());
        }
        if (C()) {
            cVar.x(3, w());
        }
        if (H()) {
            cVar.x(4, B());
        }
        if (L()) {
            cVar.t(5, D());
        }
        if (P()) {
            cVar.x(6, G());
        }
        if (Q()) {
            cVar.x(7, K());
        }
        if (R()) {
            cVar.x(8, O());
        }
        if (S()) {
            cVar.w(9, k());
        }
        if (T()) {
            cVar.t(10, I());
        }
        if (U()) {
            cVar.v(11, j());
        }
        if (V()) {
            cVar.v(12, s());
        }
        if (W()) {
            cVar.t(13, M());
        }
    }

    @Override // com.xiaomi.push.dp
    public int i() {
        int i3 = 0;
        if (r()) {
            i3 = 0 + c.H(1, y());
        }
        if (x()) {
            i3 += c.g(2, q());
        }
        if (C()) {
            i3 += c.g(3, w());
        }
        if (H()) {
            i3 += c.g(4, B());
        }
        if (L()) {
            i3 += c.c(5, D());
        }
        if (P()) {
            i3 += c.g(6, G());
        }
        if (Q()) {
            i3 += c.g(7, K());
        }
        if (R()) {
            i3 += c.g(8, O());
        }
        if (S()) {
            i3 += c.f(9, k());
        }
        if (T()) {
            i3 += c.c(10, I());
        }
        if (U()) {
            i3 += c.e(11, j());
        }
        if (V()) {
            i3 += c.e(12, s());
        }
        if (W()) {
            i3 += c.c(13, M());
        }
        this.A = i3;
        return i3;
    }

    public a j() {
        return this.f388515v;
    }

    public cp k() {
        return this.f388511r;
    }

    public ct l(int i3) {
        this.f388494a = true;
        this.f388495b = i3;
        return this;
    }

    public ct m(a aVar) {
        this.f388514u = true;
        this.f388515v = aVar;
        return this;
    }

    @Override // com.xiaomi.push.dp
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public ct b(ac acVar) {
        while (true) {
            int b16 = acVar.b();
            switch (b16) {
                case 0:
                    return this;
                case 8:
                    l(acVar.u());
                    break;
                case 18:
                    p(acVar.h());
                    break;
                case 26:
                    v(acVar.h());
                    break;
                case 34:
                    A(acVar.h());
                    break;
                case 40:
                    t(acVar.p());
                    break;
                case 50:
                    F(acVar.h());
                    break;
                case 58:
                    J(acVar.h());
                    break;
                case 66:
                    N(acVar.h());
                    break;
                case 74:
                    cp cpVar = new cp();
                    acVar.k(cpVar);
                    o(cpVar);
                    break;
                case 80:
                    z(acVar.p());
                    break;
                case 90:
                    m(acVar.e());
                    break;
                case 98:
                    u(acVar.e());
                    break;
                case 104:
                    E(acVar.p());
                    break;
                default:
                    if (!g(acVar, b16)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public ct o(cp cpVar) {
        cpVar.getClass();
        this.f388510q = true;
        this.f388511r = cpVar;
        return this;
    }

    public ct p(String str) {
        this.f388496c = true;
        this.f388497d = str;
        return this;
    }

    public String q() {
        return this.f388497d;
    }

    public boolean r() {
        return this.f388494a;
    }

    public a s() {
        return this.f388517x;
    }

    public ct t(int i3) {
        this.f388502i = true;
        this.f388503j = i3;
        return this;
    }

    public ct u(a aVar) {
        this.f388516w = true;
        this.f388517x = aVar;
        return this;
    }

    public ct v(String str) {
        this.f388498e = true;
        this.f388499f = str;
        return this;
    }

    public String w() {
        return this.f388499f;
    }

    public boolean x() {
        return this.f388496c;
    }

    public int y() {
        return this.f388495b;
    }

    public ct z(int i3) {
        this.f388512s = true;
        this.f388513t = i3;
        return this;
    }
}
