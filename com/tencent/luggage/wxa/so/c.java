package com.tencent.luggage.wxa.so;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends g {

    /* renamed from: b, reason: collision with root package name */
    public final a f140562b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        Object a();
    }

    public c(a aVar) {
        this.f140562b = aVar;
    }

    public static c a(a aVar) {
        return new c(aVar);
    }

    public Object d() {
        if (c()) {
            return b();
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.so.g
    public Object a() {
        return this.f140562b.a();
    }
}
