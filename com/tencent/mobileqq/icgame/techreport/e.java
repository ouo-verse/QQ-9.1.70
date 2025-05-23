package com.tencent.mobileqq.icgame.techreport;

import android.content.Context;
import com.tencent.mobileqq.utils.NetworkUtil;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static String f237812a = "none";

    /* renamed from: b, reason: collision with root package name */
    private static long f237813b;

    public static String a(Context context) {
        if (context == null) {
            return "unknown";
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f237813b > 60000) {
            f237813b = currentTimeMillis;
            f237812a = c(NetworkUtil.getNetworkType(context));
        }
        return f237812a;
    }

    public static String b(Context context) {
        if (context == null) {
            return "unknown";
        }
        f237813b = System.currentTimeMillis();
        String c16 = c(NetworkUtil.getNetworkType(context));
        f237812a = c16;
        return c16;
    }

    private static String c(int i3) {
        if (i3 < 0) {
            return "notReachable";
        }
        if (i3 == 1) {
            return "WiFi";
        }
        return "WWAN";
    }
}
