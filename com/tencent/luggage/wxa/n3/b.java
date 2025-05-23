package com.tencent.luggage.wxa.n3;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f135138a;

    /* renamed from: b, reason: collision with root package name */
    public final b0 f135139b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f135140c;

    /* renamed from: d, reason: collision with root package name */
    public final String f135141d;

    /* renamed from: e, reason: collision with root package name */
    public final w f135142e;

    /* renamed from: f, reason: collision with root package name */
    public final int f135143f;

    public b(int i3, b0 cryptoAlgo, byte[] reqData, String url, w netType, int i16) {
        Intrinsics.checkNotNullParameter(cryptoAlgo, "cryptoAlgo");
        Intrinsics.checkNotNullParameter(reqData, "reqData");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(netType, "netType");
        this.f135138a = i3;
        this.f135139b = cryptoAlgo;
        this.f135140c = reqData;
        this.f135141d = url;
        this.f135142e = netType;
        this.f135143f = i16;
    }

    public final int a() {
        return this.f135138a;
    }

    public final b0 b() {
        return this.f135139b;
    }

    public final w c() {
        return this.f135142e;
    }

    public final byte[] d() {
        return this.f135140c;
    }

    public final String e() {
        return this.f135141d;
    }
}
