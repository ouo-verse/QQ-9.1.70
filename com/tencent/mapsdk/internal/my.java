package com.tencent.mapsdk.internal;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes9.dex */
public class my extends mv {

    /* renamed from: b, reason: collision with root package name */
    private static volatile my f149354b = null;

    /* renamed from: c, reason: collision with root package name */
    private static final String f149355c = "com.tencent.tencentmap.mapsdk.maps.offlinemap";

    my(Context context) {
        if (context == null) {
            return;
        }
        this.f149346a = context.getSharedPreferences(f149355c, 0);
        if (f149354b != null) {
            a(new String[]{"taiwanClearCacheVersion", "taiwanStyle", "taiwanVersion", "mapPoiIcon", "worldTileCount", "rttConfigVersion", "rttConfigMd5", "closeRoadSytleNomalModeVersion", "closeRoadSytleNomalModeMd5", "closeRoadStyleTrafficModeVersion", "closeRoadStyleTrafficModeMd5", "offlineCityListVersion", "offlineCityListMd5"});
            String a16 = a("sdkVersion");
            if (a16 != null && ho.b("4.1.0", a16) > 0) {
                a();
            }
        }
    }

    public static my a(Context context) {
        if (f149354b == null) {
            synchronized (my.class) {
                if (f149354b == null) {
                    f149354b = new my(context);
                }
            }
        }
        return f149354b;
    }

    private void b() {
        if (f149354b == null) {
            return;
        }
        a(new String[]{"taiwanClearCacheVersion", "taiwanStyle", "taiwanVersion", "mapPoiIcon", "worldTileCount", "rttConfigVersion", "rttConfigMd5", "closeRoadSytleNomalModeVersion", "closeRoadSytleNomalModeMd5", "closeRoadStyleTrafficModeVersion", "closeRoadStyleTrafficModeMd5", "offlineCityListVersion", "offlineCityListMd5"});
        String a16 = a("sdkVersion");
        if (a16 != null && ho.b("4.1.0", a16) > 0) {
            a();
        }
    }
}
