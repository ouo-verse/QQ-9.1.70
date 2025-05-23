package com.xiaomi.push;

import android.content.Context;
import android.preference.PreferenceManager;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class id {
    public static void b(Context context, String str, boolean z16) {
        a(context);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z16).commit();
    }

    public static void c(Map<String, String> map, String str, String str2) {
        if (map != null && str != null && str2 != null) {
            map.put(str, str2);
        }
    }

    public static boolean d(Context context, String str, boolean z16) {
        a(context);
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z16);
    }

    public static void a(Context context) {
    }
}
