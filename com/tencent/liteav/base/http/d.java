package com.tencent.liteav.base.http;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final HttpClientAndroid f118969a;

    /* renamed from: b, reason: collision with root package name */
    private final long f118970b;

    d(HttpClientAndroid httpClientAndroid, long j3) {
        this.f118969a = httpClientAndroid;
        this.f118970b = j3;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid, long j3) {
        return new d(httpClientAndroid, j3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpClientAndroid.lambda$resumeRepeatDownload$3(this.f118969a, this.f118970b);
    }
}
