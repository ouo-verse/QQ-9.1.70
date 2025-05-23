package com.qzone.util;

import com.qzone.proxy.feedcomponent.ui.FeedElement;

/* compiled from: P */
/* loaded from: classes37.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static long f59802a;

    /* renamed from: b, reason: collision with root package name */
    private static FeedElement f59803b;

    public static synchronized boolean a() {
        boolean b16;
        synchronized (h.class) {
            b16 = b(null);
        }
        return b16;
    }

    public static synchronized boolean b(FeedElement feedElement) {
        synchronized (h.class) {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = currentTimeMillis - f59802a;
            if (0 < j3 && j3 < 1000 && (feedElement == null || f59803b == feedElement)) {
                return true;
            }
            f59802a = currentTimeMillis;
            f59803b = feedElement;
            return false;
        }
    }
}
