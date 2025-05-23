package com.tencent.liteav.base.http;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final HttpClientAndroid f118967a;

    /* renamed from: b, reason: collision with root package name */
    private final Long f118968b;

    c(HttpClientAndroid httpClientAndroid, Long l3) {
        this.f118967a = httpClientAndroid;
        this.f118968b = l3;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid, Long l3) {
        return new c(httpClientAndroid, l3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpClientAndroid.lambda$resumeRepeatDownload$2(this.f118967a, this.f118968b);
    }
}
