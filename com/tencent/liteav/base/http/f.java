package com.tencent.liteav.base.http;

import com.tencent.liteav.base.http.HttpClientAndroid;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final HttpClientAndroid f118972a;

    /* renamed from: b, reason: collision with root package name */
    private final HttpClientAndroid.e f118973b;

    /* renamed from: c, reason: collision with root package name */
    private final long f118974c;

    f(HttpClientAndroid httpClientAndroid, HttpClientAndroid.e eVar, long j3) {
        this.f118972a = httpClientAndroid;
        this.f118973b = eVar;
        this.f118974c = j3;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid, HttpClientAndroid.e eVar, long j3) {
        return new f(httpClientAndroid, eVar, j3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpClientAndroid.lambda$doReadData$5(this.f118972a, this.f118973b, this.f118974c);
    }
}
