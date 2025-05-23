package com.tencent.qqlive.module.videoreport;

import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;

/* compiled from: P */
/* loaded from: classes22.dex */
public class Log {
    public static void d(String str, String str2) {
        getLogger().d(str, str2);
    }

    public static void ddf(String str, String str2, Object... objArr) {
        try {
            str2 = String.format(str2, objArr);
        } catch (Exception e16) {
            d(str, "format exception" + e16);
        }
        d(str, str2);
    }

    public static void e(String str, String str2) {
        getLogger().e(str, str2);
    }

    private static ILogger getLogger() {
        return VideoReportInner.getInstance().getConfiguration().getLogger();
    }

    public static void i(String str, String str2) {
        getLogger().i(str, str2);
    }

    public static void v(String str, String str2) {
        getLogger().v(str, str2);
    }

    public static void w(String str, String str2) {
        getLogger().w(str, str2);
    }
}
