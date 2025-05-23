package com.tencent.liteav.base.http;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final HttpClientAndroid f118966a;

    b(HttpClientAndroid httpClientAndroid) {
        this.f118966a = httpClientAndroid;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid) {
        return new b(httpClientAndroid);
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpClientAndroid.lambda$cancelAll$1(this.f118966a);
    }
}
