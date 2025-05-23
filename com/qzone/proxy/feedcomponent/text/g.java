package com.qzone.proxy.feedcomponent.text;

/* compiled from: P */
/* loaded from: classes39.dex */
public class g<F, S> {

    /* renamed from: a, reason: collision with root package name */
    public F f50743a;

    /* renamed from: b, reason: collision with root package name */
    public S f50744b;

    public g(F f16, S s16) {
        this.f50743a = f16;
        this.f50744b = s16;
    }

    public g<F, S> a(F f16, S s16) {
        this.f50743a = f16;
        this.f50744b = s16;
        return this;
    }

    public int hashCode() {
        return ((527 + this.f50743a.hashCode()) * 31) + this.f50744b.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        try {
            g gVar = (g) obj;
            return this.f50743a.equals(gVar.f50743a) && this.f50744b.equals(gVar.f50744b);
        } catch (ClassCastException unused) {
            return false;
        }
    }
}
