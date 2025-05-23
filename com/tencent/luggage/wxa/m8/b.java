package com.tencent.luggage.wxa.m8;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements d {
    private static b sInstance;

    b() {
    }

    public static b getInstance() {
        if (sInstance == null) {
            sInstance = new b();
        }
        return sInstance;
    }

    @Override // com.tencent.luggage.wxa.m8.d
    public c createClientProxy() {
        return new a();
    }
}
