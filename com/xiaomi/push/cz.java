package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class cz extends dp {

    /* renamed from: a, reason: collision with root package name */
    private boolean f388556a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f388558c;

    /* renamed from: b, reason: collision with root package name */
    private a f388557b = a.f388122c;

    /* renamed from: d, reason: collision with root package name */
    private cp f388559d = null;

    /* renamed from: e, reason: collision with root package name */
    private int f388560e = -1;

    public static cz o(byte[] bArr) {
        return (cz) new cz().c(bArr);
    }

    @Override // com.xiaomi.push.dp
    public int a() {
        if (this.f388560e < 0) {
            i();
        }
        return this.f388560e;
    }

    @Override // com.xiaomi.push.dp
    public void e(c cVar) {
        if (p()) {
            cVar.v(1, j());
        }
        if (q()) {
            cVar.w(2, k());
        }
    }

    @Override // com.xiaomi.push.dp
    public int i() {
        int i3 = 0;
        if (p()) {
            i3 = 0 + c.e(1, j());
        }
        if (q()) {
            i3 += c.f(2, k());
        }
        this.f388560e = i3;
        return i3;
    }

    public a j() {
        return this.f388557b;
    }

    public cp k() {
        return this.f388559d;
    }

    public cz l(a aVar) {
        this.f388556a = true;
        this.f388557b = aVar;
        return this;
    }

    @Override // com.xiaomi.push.dp
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public cz b(ac acVar) {
        while (true) {
            int b16 = acVar.b();
            if (b16 != 0) {
                if (b16 != 10) {
                    if (b16 != 18) {
                        if (!g(acVar, b16)) {
                            return this;
                        }
                    } else {
                        cp cpVar = new cp();
                        acVar.k(cpVar);
                        n(cpVar);
                    }
                } else {
                    l(acVar.e());
                }
            } else {
                return this;
            }
        }
    }

    public cz n(cp cpVar) {
        cpVar.getClass();
        this.f388558c = true;
        this.f388559d = cpVar;
        return this;
    }

    public boolean p() {
        return this.f388556a;
    }

    public boolean q() {
        return this.f388558c;
    }
}
