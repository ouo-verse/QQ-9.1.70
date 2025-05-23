package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class cu extends dp {

    /* renamed from: a, reason: collision with root package name */
    private boolean f388520a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f388522c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f388524e;

    /* renamed from: b, reason: collision with root package name */
    private String f388521b = "";

    /* renamed from: d, reason: collision with root package name */
    private String f388523d = "";

    /* renamed from: f, reason: collision with root package name */
    private cp f388525f = null;

    /* renamed from: g, reason: collision with root package name */
    private int f388526g = -1;

    public static cu n(byte[] bArr) {
        return (cu) new cu().c(bArr);
    }

    @Override // com.xiaomi.push.dp
    public int a() {
        if (this.f388526g < 0) {
            i();
        }
        return this.f388526g;
    }

    @Override // com.xiaomi.push.dp
    public void e(c cVar) {
        if (p()) {
            cVar.x(1, o());
        }
        if (s()) {
            cVar.x(2, r());
        }
        if (t()) {
            cVar.w(3, j());
        }
    }

    @Override // com.xiaomi.push.dp
    public int i() {
        int i3 = 0;
        if (p()) {
            i3 = 0 + c.g(1, o());
        }
        if (s()) {
            i3 += c.g(2, r());
        }
        if (t()) {
            i3 += c.f(3, j());
        }
        this.f388526g = i3;
        return i3;
    }

    public cp j() {
        return this.f388525f;
    }

    @Override // com.xiaomi.push.dp
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public cu b(ac acVar) {
        while (true) {
            int b16 = acVar.b();
            if (b16 != 0) {
                if (b16 != 10) {
                    if (b16 != 18) {
                        if (b16 != 26) {
                            if (!g(acVar, b16)) {
                                return this;
                            }
                        } else {
                            cp cpVar = new cp();
                            acVar.k(cpVar);
                            l(cpVar);
                        }
                    } else {
                        q(acVar.h());
                    }
                } else {
                    m(acVar.h());
                }
            } else {
                return this;
            }
        }
    }

    public cu l(cp cpVar) {
        cpVar.getClass();
        this.f388524e = true;
        this.f388525f = cpVar;
        return this;
    }

    public cu m(String str) {
        this.f388520a = true;
        this.f388521b = str;
        return this;
    }

    public String o() {
        return this.f388521b;
    }

    public boolean p() {
        return this.f388520a;
    }

    public cu q(String str) {
        this.f388522c = true;
        this.f388523d = str;
        return this;
    }

    public String r() {
        return this.f388523d;
    }

    public boolean s() {
        return this.f388522c;
    }

    public boolean t() {
        return this.f388524e;
    }
}
