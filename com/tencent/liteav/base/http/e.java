package com.tencent.liteav.base.http;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final HttpClientAndroid f118971a;

    e(HttpClientAndroid httpClientAndroid) {
        this.f118971a = httpClientAndroid;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid) {
        return new e(httpClientAndroid);
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpClientAndroid.lambda$destroy$4(this.f118971a);
    }
}
