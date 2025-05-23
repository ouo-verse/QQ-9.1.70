package com.tencent.mapsdk.internal;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public class mx extends mv {

    /* renamed from: b, reason: collision with root package name */
    private static final String f149352b = "Tencent_MapSDK_SUB_CONFIG";

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, mv> f149353c = new HashMap();

    mx(Context context, String str) {
        this.f149346a = context.getSharedPreferences("Tencent_MapSDK_SUB_CONFIG_".concat(String.valueOf(str)), 0);
    }

    public static mv a(Context context, String str) {
        if (hs.a(str)) {
            return my.a(context);
        }
        if (f149353c.get(str) == null) {
            synchronized (mx.class) {
                if (f149353c.get(str) == null) {
                    mx mxVar = new mx(context, str);
                    f149353c.put(str, mxVar);
                    return mxVar;
                }
            }
        }
        return f149353c.get(str);
    }

    private static boolean b(Context context, String str) {
        if (hs.a(str)) {
            return false;
        }
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(context.getFilesDir().getParent());
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append("shared_prefs");
            sb5.append(str2);
            sb5.append("Tencent_MapSDK_SUB_CONFIG_");
            sb5.append(str);
            File file = new File(sb5.toString());
            if (file.exists()) {
                return file.delete();
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void b() {
        Map<String, mv> map = f149353c;
        if (map != null) {
            map.clear();
        }
    }

    public static void a(Context context) {
        try {
            File[] listFiles = new File(context.getFilesDir().getParent() + File.separator + "shared_prefs").listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file : listFiles) {
                if (file.getName().startsWith(f149352b)) {
                    file.delete();
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
