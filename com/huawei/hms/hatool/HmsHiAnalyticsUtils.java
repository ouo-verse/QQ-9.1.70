package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HmsHiAnalyticsUtils {
    public static void enableLog() {
        c.a();
    }

    public static boolean getInitFlag() {
        return a.b();
    }

    public static void init(Context context, boolean z16, boolean z17, boolean z18, String str, String str2) {
        new b(context).a(z16).c(z17).b(z18).a(0, str).a(1, str).a(str2).a();
    }

    public static void onEvent(Context context, String str, String str2) {
        a.a(context, str, str2);
    }

    public static void onReport() {
        a.c();
    }

    public static void onStreamEvent(int i3, String str, LinkedHashMap<String, String> linkedHashMap) {
        a.b(i3, str, linkedHashMap);
    }

    public static void onEvent(int i3, String str, LinkedHashMap<String, String> linkedHashMap) {
        a.a(i3, str, linkedHashMap);
    }
}
