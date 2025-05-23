package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class cs extends dp {

    /* renamed from: a, reason: collision with root package name */
    private boolean f388485a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f388487c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f388489e;

    /* renamed from: g, reason: collision with root package name */
    private boolean f388491g;

    /* renamed from: b, reason: collision with root package name */
    private boolean f388486b = false;

    /* renamed from: d, reason: collision with root package name */
    private String f388488d = "";

    /* renamed from: f, reason: collision with root package name */
    private String f388490f = "";

    /* renamed from: h, reason: collision with root package name */
    private String f388492h = "";

    /* renamed from: i, reason: collision with root package name */
    private int f388493i = -1;

    public static cs m(byte[] bArr) {
        return (cs) new cs().c(bArr);
    }

    @Override // com.xiaomi.push.dp
    public int a() {
        if (this.f388493i < 0) {
            i();
        }
        return this.f388493i;
    }

    @Override // com.xiaomi.push.dp
    public void e(c cVar) {
        if (r()) {
            cVar.y(1, o());
        }
        if (u()) {
            cVar.x(2, n());
        }
        if (v()) {
            cVar.x(3, q());
        }
        if (w()) {
            cVar.x(4, t());
        }
    }

    @Override // com.xiaomi.push.dp
    public int i() {
        int i3 = 0;
        if (r()) {
            i3 = 0 + c.h(1, o());
        }
        if (u()) {
            i3 += c.g(2, n());
        }
        if (v()) {
            i3 += c.g(3, q());
        }
        if (w()) {
            i3 += c.g(4, t());
        }
        this.f388493i = i3;
        return i3;
    }

    @Override // com.xiaomi.push.dp
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public cs b(ac acVar) {
        while (true) {
            int b16 = acVar.b();
            if (b16 != 0) {
                if (b16 != 8) {
                    if (b16 != 18) {
                        if (b16 != 26) {
                            if (b16 != 34) {
                                if (!g(acVar, b16)) {
                                    return this;
                                }
                            } else {
                                s(acVar.h());
                            }
                        } else {
                            p(acVar.h());
                        }
                    } else {
                        k(acVar.h());
                    }
                } else {
                    l(acVar.l());
                }
            } else {
                return this;
            }
        }
    }

    public cs k(String str) {
        this.f388487c = true;
        this.f388488d = str;
        return this;
    }

    public cs l(boolean z16) {
        this.f388485a = true;
        this.f388486b = z16;
        return this;
    }

    public String n() {
        return this.f388488d;
    }

    public boolean o() {
        return this.f388486b;
    }

    public cs p(String str) {
        this.f388489e = true;
        this.f388490f = str;
        return this;
    }

    public String q() {
        return this.f388490f;
    }

    public boolean r() {
        return this.f388485a;
    }

    public cs s(String str) {
        this.f388491g = true;
        this.f388492h = str;
        return this;
    }

    public String t() {
        return this.f388492h;
    }

    public boolean u() {
        return this.f388487c;
    }

    public boolean v() {
        return this.f388489e;
    }

    public boolean w() {
        return this.f388491g;
    }
}
