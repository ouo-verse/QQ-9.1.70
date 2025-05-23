package com.tencent.luggage.wxa.za;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final a[] f146454a;

    /* renamed from: b, reason: collision with root package name */
    public int f146455b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f146456c = new Object();

    public b(int i3) {
        if (i3 > 0) {
            this.f146454a = new a[i3];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public a a() {
        synchronized (this.f146456c) {
            int i3 = this.f146455b;
            if (i3 <= 0) {
                return null;
            }
            int i16 = i3 - 1;
            a[] aVarArr = this.f146454a;
            a aVar = aVarArr[i16];
            aVarArr[i16] = null;
            this.f146455b = i16;
            return aVar;
        }
    }

    public boolean b(a aVar) {
        synchronized (this.f146456c) {
            if (!a(aVar)) {
                aVar.c();
                int i3 = this.f146455b;
                a[] aVarArr = this.f146454a;
                if (i3 < aVarArr.length) {
                    aVarArr[i3] = aVar;
                    this.f146455b = i3 + 1;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    public final boolean a(a aVar) {
        for (int i3 = 0; i3 < this.f146455b; i3++) {
            if (this.f146454a[i3] == aVar) {
                return true;
            }
        }
        return false;
    }
}
