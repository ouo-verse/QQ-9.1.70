package com.tencent.ad.tangram.widget.bubble;

import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
final class GdtLogger {
    public static WeakReference<GdtLogProxy> sWeakLogger;

    GdtLogger() {
    }

    public static void d(String str, String str2) {
        GdtLogProxy gdtLogProxy;
        WeakReference<GdtLogProxy> weakReference = sWeakLogger;
        if (weakReference != null) {
            gdtLogProxy = weakReference.get();
        } else {
            gdtLogProxy = null;
        }
        if (gdtLogProxy != null) {
            gdtLogProxy.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        GdtLogProxy gdtLogProxy;
        WeakReference<GdtLogProxy> weakReference = sWeakLogger;
        if (weakReference != null) {
            gdtLogProxy = weakReference.get();
        } else {
            gdtLogProxy = null;
        }
        if (gdtLogProxy != null) {
            gdtLogProxy.e(str, str2);
        }
    }
}
