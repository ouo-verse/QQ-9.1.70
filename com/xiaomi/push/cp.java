package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class cp extends dp {

    /* renamed from: a, reason: collision with root package name */
    private boolean f388454a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f388456c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f388458e;

    /* renamed from: g, reason: collision with root package name */
    private boolean f388460g;

    /* renamed from: b, reason: collision with root package name */
    private boolean f388455b = false;

    /* renamed from: d, reason: collision with root package name */
    private int f388457d = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f388459f = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f388461h = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f388462i = -1;

    public static cp m(byte[] bArr) {
        return (cp) new cp().c(bArr);
    }

    @Override // com.xiaomi.push.dp
    public int a() {
        if (this.f388462i < 0) {
            i();
        }
        return this.f388462i;
    }

    @Override // com.xiaomi.push.dp
    public void e(c cVar) {
        if (p()) {
            cVar.y(1, n());
        }
        if (s()) {
            cVar.t(3, q());
        }
        if (u()) {
            cVar.t(4, t());
        }
        if (w()) {
            cVar.t(5, v());
        }
    }

    @Override // com.xiaomi.push.dp
    public int i() {
        int i3 = 0;
        if (p()) {
            i3 = 0 + c.h(1, n());
        }
        if (s()) {
            i3 += c.c(3, q());
        }
        if (u()) {
            i3 += c.c(4, t());
        }
        if (w()) {
            i3 += c.c(5, v());
        }
        this.f388462i = i3;
        return i3;
    }

    public cp j(int i3) {
        this.f388456c = true;
        this.f388457d = i3;
        return this;
    }

    @Override // com.xiaomi.push.dp
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public cp b(ac acVar) {
        while (true) {
            int b16 = acVar.b();
            if (b16 != 0) {
                if (b16 != 8) {
                    if (b16 != 24) {
                        if (b16 != 32) {
                            if (b16 != 40) {
                                if (!g(acVar, b16)) {
                                    return this;
                                }
                            } else {
                                r(acVar.p());
                            }
                        } else {
                            o(acVar.p());
                        }
                    } else {
                        j(acVar.p());
                    }
                } else {
                    l(acVar.l());
                }
            } else {
                return this;
            }
        }
    }

    public cp l(boolean z16) {
        this.f388454a = true;
        this.f388455b = z16;
        return this;
    }

    public boolean n() {
        return this.f388455b;
    }

    public cp o(int i3) {
        this.f388458e = true;
        this.f388459f = i3;
        return this;
    }

    public boolean p() {
        return this.f388454a;
    }

    public int q() {
        return this.f388457d;
    }

    public cp r(int i3) {
        this.f388460g = true;
        this.f388461h = i3;
        return this;
    }

    public boolean s() {
        return this.f388456c;
    }

    public int t() {
        return this.f388459f;
    }

    public boolean u() {
        return this.f388458e;
    }

    public int v() {
        return this.f388461h;
    }

    public boolean w() {
        return this.f388460g;
    }
}
