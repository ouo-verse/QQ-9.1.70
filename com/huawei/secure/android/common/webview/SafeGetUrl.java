package com.huawei.secure.android.common.webview;

import android.util.Log;
import android.webkit.WebView;
import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SafeGetUrl {

    /* renamed from: c, reason: collision with root package name */
    private static final String f38042c = "SafeGetUrl";

    /* renamed from: d, reason: collision with root package name */
    private static final long f38043d = 200;

    /* renamed from: a, reason: collision with root package name */
    private String f38044a;

    /* renamed from: b, reason: collision with root package name */
    private WebView f38045b;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f38046a;

        a(CountDownLatch countDownLatch) {
            this.f38046a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            SafeGetUrl safeGetUrl = SafeGetUrl.this;
            safeGetUrl.setUrl(safeGetUrl.f38045b.getUrl());
            this.f38046a.countDown();
        }
    }

    public SafeGetUrl() {
    }

    public String getUrlMethod() {
        if (this.f38045b == null) {
            return "";
        }
        if (com.huawei.secure.android.common.util.b.a()) {
            return this.f38045b.getUrl();
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        com.huawei.secure.android.common.util.c.a(new a(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e16) {
            Log.e(f38042c, "getUrlMethod: InterruptedException " + e16.getMessage(), e16);
        }
        return this.f38044a;
    }

    public WebView getWebView() {
        return this.f38045b;
    }

    public void setUrl(String str) {
        this.f38044a = str;
    }

    public void setWebView(WebView webView) {
        this.f38045b = webView;
    }

    public SafeGetUrl(WebView webView) {
        this.f38045b = webView;
    }
}
