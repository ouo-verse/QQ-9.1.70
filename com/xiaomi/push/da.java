package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class da extends dp {

    /* renamed from: a, reason: collision with root package name */
    private boolean f388561a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f388563c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f388565e;

    /* renamed from: g, reason: collision with root package name */
    private boolean f388567g;

    /* renamed from: i, reason: collision with root package name */
    private boolean f388569i;

    /* renamed from: k, reason: collision with root package name */
    private boolean f388571k;

    /* renamed from: b, reason: collision with root package name */
    private String f388562b = "";

    /* renamed from: d, reason: collision with root package name */
    private String f388564d = "";

    /* renamed from: f, reason: collision with root package name */
    private long f388566f = 0;

    /* renamed from: h, reason: collision with root package name */
    private long f388568h = 0;

    /* renamed from: j, reason: collision with root package name */
    private boolean f388570j = false;

    /* renamed from: l, reason: collision with root package name */
    private int f388572l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f388573m = -1;

    public static da p(byte[] bArr) {
        return (da) new da().c(bArr);
    }

    public boolean A() {
        return this.f388570j;
    }

    public boolean B() {
        return this.f388569i;
    }

    public boolean C() {
        return this.f388571k;
    }

    @Override // com.xiaomi.push.dp
    public int a() {
        if (this.f388573m < 0) {
            i();
        }
        return this.f388573m;
    }

    @Override // com.xiaomi.push.dp
    public void e(c cVar) {
        if (r()) {
            cVar.x(1, q());
        }
        if (w()) {
            cVar.x(2, v());
        }
        if (y()) {
            cVar.u(3, j());
        }
        if (z()) {
            cVar.u(4, s());
        }
        if (B()) {
            cVar.y(5, A());
        }
        if (C()) {
            cVar.t(6, x());
        }
    }

    @Override // com.xiaomi.push.dp
    public int i() {
        int i3 = 0;
        if (r()) {
            i3 = 0 + c.g(1, q());
        }
        if (w()) {
            i3 += c.g(2, v());
        }
        if (y()) {
            i3 += c.d(3, j());
        }
        if (z()) {
            i3 += c.d(4, s());
        }
        if (B()) {
            i3 += c.h(5, A());
        }
        if (C()) {
            i3 += c.c(6, x());
        }
        this.f388573m = i3;
        return i3;
    }

    public long j() {
        return this.f388566f;
    }

    public da k(int i3) {
        this.f388571k = true;
        this.f388572l = i3;
        return this;
    }

    public da l(long j3) {
        this.f388565e = true;
        this.f388566f = j3;
        return this;
    }

    @Override // com.xiaomi.push.dp
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public da b(ac acVar) {
        while (true) {
            int b16 = acVar.b();
            if (b16 != 0) {
                if (b16 != 10) {
                    if (b16 != 18) {
                        if (b16 != 24) {
                            if (b16 != 32) {
                                if (b16 != 40) {
                                    if (b16 != 48) {
                                        if (!g(acVar, b16)) {
                                            return this;
                                        }
                                    } else {
                                        k(acVar.p());
                                    }
                                } else {
                                    o(acVar.l());
                                }
                            } else {
                                t(acVar.d());
                            }
                        } else {
                            l(acVar.d());
                        }
                    } else {
                        u(acVar.h());
                    }
                } else {
                    n(acVar.h());
                }
            } else {
                return this;
            }
        }
    }

    public da n(String str) {
        this.f388561a = true;
        this.f388562b = str;
        return this;
    }

    public da o(boolean z16) {
        this.f388569i = true;
        this.f388570j = z16;
        return this;
    }

    public String q() {
        return this.f388562b;
    }

    public boolean r() {
        return this.f388561a;
    }

    public long s() {
        return this.f388568h;
    }

    public da t(long j3) {
        this.f388567g = true;
        this.f388568h = j3;
        return this;
    }

    public da u(String str) {
        this.f388563c = true;
        this.f388564d = str;
        return this;
    }

    public String v() {
        return this.f388564d;
    }

    public boolean w() {
        return this.f388563c;
    }

    public int x() {
        return this.f388572l;
    }

    public boolean y() {
        return this.f388565e;
    }

    public boolean z() {
        return this.f388567g;
    }
}
