package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class cx extends dp {

    /* renamed from: a, reason: collision with root package name */
    private boolean f388548a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f388550c;

    /* renamed from: b, reason: collision with root package name */
    private int f388549b = 0;

    /* renamed from: d, reason: collision with root package name */
    private String f388551d = "";

    /* renamed from: e, reason: collision with root package name */
    private int f388552e = -1;

    public static cx m(byte[] bArr) {
        return (cx) new cx().c(bArr);
    }

    @Override // com.xiaomi.push.dp
    public int a() {
        if (this.f388552e < 0) {
            i();
        }
        return this.f388552e;
    }

    @Override // com.xiaomi.push.dp
    public void e(c cVar) {
        if (o()) {
            cVar.t(1, q());
        }
        if (p()) {
            cVar.x(2, n());
        }
    }

    @Override // com.xiaomi.push.dp
    public int i() {
        int i3 = 0;
        if (o()) {
            i3 = 0 + c.c(1, q());
        }
        if (p()) {
            i3 += c.g(2, n());
        }
        this.f388552e = i3;
        return i3;
    }

    public cx j(int i3) {
        this.f388548a = true;
        this.f388549b = i3;
        return this;
    }

    @Override // com.xiaomi.push.dp
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public cx b(ac acVar) {
        while (true) {
            int b16 = acVar.b();
            if (b16 != 0) {
                if (b16 != 8) {
                    if (b16 != 18) {
                        if (!g(acVar, b16)) {
                            return this;
                        }
                    } else {
                        l(acVar.h());
                    }
                } else {
                    j(acVar.p());
                }
            } else {
                return this;
            }
        }
    }

    public cx l(String str) {
        this.f388550c = true;
        this.f388551d = str;
        return this;
    }

    public String n() {
        return this.f388551d;
    }

    public boolean o() {
        return this.f388548a;
    }

    public boolean p() {
        return this.f388550c;
    }

    public int q() {
        return this.f388549b;
    }
}
