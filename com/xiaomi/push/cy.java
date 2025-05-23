package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class cy extends dp {

    /* renamed from: a, reason: collision with root package name */
    private boolean f388553a;

    /* renamed from: b, reason: collision with root package name */
    private a f388554b = a.f388122c;

    /* renamed from: c, reason: collision with root package name */
    private int f388555c = -1;

    public static cy m(byte[] bArr) {
        return (cy) new cy().c(bArr);
    }

    @Override // com.xiaomi.push.dp
    public int a() {
        if (this.f388555c < 0) {
            i();
        }
        return this.f388555c;
    }

    @Override // com.xiaomi.push.dp
    public void e(c cVar) {
        if (n()) {
            cVar.v(1, j());
        }
    }

    @Override // com.xiaomi.push.dp
    public int i() {
        int i3 = 0;
        if (n()) {
            i3 = 0 + c.e(1, j());
        }
        this.f388555c = i3;
        return i3;
    }

    public a j() {
        return this.f388554b;
    }

    public cy k(a aVar) {
        this.f388553a = true;
        this.f388554b = aVar;
        return this;
    }

    @Override // com.xiaomi.push.dp
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public cy b(ac acVar) {
        while (true) {
            int b16 = acVar.b();
            if (b16 != 0) {
                if (b16 != 10) {
                    if (!g(acVar, b16)) {
                        return this;
                    }
                } else {
                    k(acVar.e());
                }
            } else {
                return this;
            }
        }
    }

    public boolean n() {
        return this.f388553a;
    }
}
