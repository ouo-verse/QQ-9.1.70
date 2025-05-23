package org.light.utils;

import android.app.Application;
import android.os.Bundle;
import android.preference.PreferenceManager;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightDataUtils {
    public static HashMap<String, String> bundle2HashMap(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                hashMap.put(str, bundle.getString(str));
            }
        }
        return hashMap;
    }

    public static String getValue(String str) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(((Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext()).getString(str, "");
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static Bundle map2Bundle(Map<String, String> map) {
        Bundle bundle = new Bundle();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                bundle.putCharSequence(entry.getKey(), entry.getValue());
            }
        }
        return bundle;
    }

    public static void saveValue(String str, String str2) {
        try {
            PreferenceManager.getDefaultSharedPreferences(((Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext()).edit().putString(str, str2).apply();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
