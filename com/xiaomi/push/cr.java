package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class cr extends dp {

    /* renamed from: a, reason: collision with root package name */
    private boolean f388472a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f388474c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f388476e;

    /* renamed from: g, reason: collision with root package name */
    private boolean f388478g;

    /* renamed from: i, reason: collision with root package name */
    private boolean f388480i;

    /* renamed from: k, reason: collision with root package name */
    private boolean f388482k;

    /* renamed from: b, reason: collision with root package name */
    private String f388473b = "";

    /* renamed from: d, reason: collision with root package name */
    private String f388475d = "";

    /* renamed from: f, reason: collision with root package name */
    private String f388477f = "";

    /* renamed from: h, reason: collision with root package name */
    private String f388479h = "";

    /* renamed from: j, reason: collision with root package name */
    private String f388481j = "";

    /* renamed from: l, reason: collision with root package name */
    private String f388483l = "";

    /* renamed from: m, reason: collision with root package name */
    private int f388484m = -1;

    public String A() {
        return this.f388483l;
    }

    public boolean B() {
        return this.f388482k;
    }

    @Override // com.xiaomi.push.dp
    public int a() {
        if (this.f388484m < 0) {
            i();
        }
        return this.f388484m;
    }

    @Override // com.xiaomi.push.dp
    public void e(c cVar) {
        if (m()) {
            cVar.x(1, l());
        }
        if (p()) {
            cVar.x(2, o());
        }
        if (s()) {
            cVar.x(3, r());
        }
        if (v()) {
            cVar.x(4, u());
        }
        if (y()) {
            cVar.x(5, x());
        }
        if (B()) {
            cVar.x(6, A());
        }
    }

    @Override // com.xiaomi.push.dp
    public int i() {
        int i3 = 0;
        if (m()) {
            i3 = 0 + c.g(1, l());
        }
        if (p()) {
            i3 += c.g(2, o());
        }
        if (s()) {
            i3 += c.g(3, r());
        }
        if (v()) {
            i3 += c.g(4, u());
        }
        if (y()) {
            i3 += c.g(5, x());
        }
        if (B()) {
            i3 += c.g(6, A());
        }
        this.f388484m = i3;
        return i3;
    }

    @Override // com.xiaomi.push.dp
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public cr b(ac acVar) {
        while (true) {
            int b16 = acVar.b();
            if (b16 != 0) {
                if (b16 != 10) {
                    if (b16 != 18) {
                        if (b16 != 26) {
                            if (b16 != 34) {
                                if (b16 != 42) {
                                    if (b16 != 50) {
                                        if (!g(acVar, b16)) {
                                            return this;
                                        }
                                    } else {
                                        z(acVar.h());
                                    }
                                } else {
                                    w(acVar.h());
                                }
                            } else {
                                t(acVar.h());
                            }
                        } else {
                            q(acVar.h());
                        }
                    } else {
                        n(acVar.h());
                    }
                } else {
                    k(acVar.h());
                }
            } else {
                return this;
            }
        }
    }

    public cr k(String str) {
        this.f388472a = true;
        this.f388473b = str;
        return this;
    }

    public String l() {
        return this.f388473b;
    }

    public boolean m() {
        return this.f388472a;
    }

    public cr n(String str) {
        this.f388474c = true;
        this.f388475d = str;
        return this;
    }

    public String o() {
        return this.f388475d;
    }

    public boolean p() {
        return this.f388474c;
    }

    public cr q(String str) {
        this.f388476e = true;
        this.f388477f = str;
        return this;
    }

    public String r() {
        return this.f388477f;
    }

    public boolean s() {
        return this.f388476e;
    }

    public cr t(String str) {
        this.f388478g = true;
        this.f388479h = str;
        return this;
    }

    public String u() {
        return this.f388479h;
    }

    public boolean v() {
        return this.f388478g;
    }

    public cr w(String str) {
        this.f388480i = true;
        this.f388481j = str;
        return this;
    }

    public String x() {
        return this.f388481j;
    }

    public boolean y() {
        return this.f388480i;
    }

    public cr z(String str) {
        this.f388482k = true;
        this.f388483l = str;
        return this;
    }
}
