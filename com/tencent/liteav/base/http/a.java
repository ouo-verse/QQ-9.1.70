package com.tencent.liteav.base.http;

import com.tencent.liteav.base.http.HttpClientAndroid;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final HttpClientAndroid f118964a;

    /* renamed from: b, reason: collision with root package name */
    private final HttpClientAndroid.d f118965b;

    a(HttpClientAndroid httpClientAndroid, HttpClientAndroid.d dVar) {
        this.f118964a = httpClientAndroid;
        this.f118965b = dVar;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid, HttpClientAndroid.d dVar) {
        return new a(httpClientAndroid, dVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f118964a.doRequest(this.f118965b);
    }
}
