package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class cv extends dp {

    /* renamed from: a, reason: collision with root package name */
    private boolean f388527a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f388529c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f388531e;

    /* renamed from: b, reason: collision with root package name */
    private String f388528b = "";

    /* renamed from: d, reason: collision with root package name */
    private String f388530d = "";

    /* renamed from: f, reason: collision with root package name */
    private String f388532f = "";

    /* renamed from: g, reason: collision with root package name */
    private int f388533g = -1;

    public static cv l(byte[] bArr) {
        return (cv) new cv().c(bArr);
    }

    @Override // com.xiaomi.push.dp
    public int a() {
        if (this.f388533g < 0) {
            i();
        }
        return this.f388533g;
    }

    @Override // com.xiaomi.push.dp
    public void e(c cVar) {
        if (n()) {
            cVar.x(1, m());
        }
        if (q()) {
            cVar.x(2, p());
        }
        if (t()) {
            cVar.x(3, s());
        }
    }

    @Override // com.xiaomi.push.dp
    public int i() {
        int i3 = 0;
        if (n()) {
            i3 = 0 + c.g(1, m());
        }
        if (q()) {
            i3 += c.g(2, p());
        }
        if (t()) {
            i3 += c.g(3, s());
        }
        this.f388533g = i3;
        return i3;
    }

    @Override // com.xiaomi.push.dp
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public cv b(ac acVar) {
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
                            r(acVar.h());
                        }
                    } else {
                        o(acVar.h());
                    }
                } else {
                    k(acVar.h());
                }
            } else {
                return this;
            }
        }
    }

    public cv k(String str) {
        this.f388527a = true;
        this.f388528b = str;
        return this;
    }

    public String m() {
        return this.f388528b;
    }

    public boolean n() {
        return this.f388527a;
    }

    public cv o(String str) {
        this.f388529c = true;
        this.f388530d = str;
        return this;
    }

    public String p() {
        return this.f388530d;
    }

    public boolean q() {
        return this.f388529c;
    }

    public cv r(String str) {
        this.f388531e = true;
        this.f388532f = str;
        return this;
    }

    public String s() {
        return this.f388532f;
    }

    public boolean t() {
        return this.f388531e;
    }
}
