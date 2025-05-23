package com.huawei.hms.stats;

import android.content.Context;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hms.utils.HMSBIInitializer;
import java.util.LinkedHashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static HiAnalyticsInstance f37500a;

    private static HiAnalyticsInstance a(Context context) {
        HiAnalyticsInstance analyticsInstance = HMSBIInitializer.getInstance(context).getAnalyticsInstance();
        f37500a = analyticsInstance;
        return analyticsInstance;
    }

    public static void b(Context context, int i3, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a(context) != null) {
            f37500a.onStreamEvent(i3, str, linkedHashMap);
        }
    }

    public static void a(Context context, String str, String str2) {
        if (a(context) != null) {
            f37500a.onEvent(context, str, str2);
        }
    }

    public static void a(Context context, int i3, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a(context) != null) {
            f37500a.onEvent(i3, str, linkedHashMap);
        }
    }

    public static void a(Context context, int i3) {
        if (a(context) != null) {
            f37500a.onReport(i3);
        }
    }
}
