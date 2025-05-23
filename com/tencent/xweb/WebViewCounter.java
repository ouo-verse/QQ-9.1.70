package com.tencent.xweb;

import com.tencent.luggage.wxa.ar.x0;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WebViewCounter {
    public static final String TAG = "WebViewCounter";

    /* renamed from: a, reason: collision with root package name */
    public static volatile int f385016a;

    public static synchronized void decrease() {
        synchronized (WebViewCounter.class) {
            f385016a--;
            x0.d(TAG, "decrease, count:" + f385016a);
        }
    }

    public static synchronized int getCount() {
        int i3;
        synchronized (WebViewCounter.class) {
            i3 = f385016a;
        }
        return i3;
    }

    public static synchronized void increase() {
        synchronized (WebViewCounter.class) {
            f385016a++;
            x0.d(TAG, "increase, count:" + f385016a);
        }
    }
}
