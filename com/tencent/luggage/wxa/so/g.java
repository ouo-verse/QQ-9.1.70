package com.tencent.luggage.wxa.so;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f140578a = null;

    public abstract Object a();

    public final Object b() {
        if (this.f140578a == null) {
            synchronized (this) {
                if (this.f140578a == null) {
                    this.f140578a = a();
                }
            }
        }
        return this.f140578a;
    }

    public final boolean c() {
        boolean z16 = true;
        if (this.f140578a != null) {
            return true;
        }
        synchronized (this) {
            if (this.f140578a == null) {
                z16 = false;
            }
        }
        return z16;
    }
}
