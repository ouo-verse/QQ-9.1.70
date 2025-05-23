package com.qzone.util;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ac {
    public static void a(Map<Integer, Boolean> map, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QZoneFeatureSwitchManager", 1, "uin is null");
            return;
        }
        if (map == null) {
            QLog.e("QZoneFeatureSwitchManager", 2, "map is null, return");
            return;
        }
        if (map.containsKey(1)) {
            QLog.d("QZoneFeatureSwitchManager", 2, "contain gallery key");
            d(str, map.get(1).booleanValue());
        }
        if (map.containsKey(2)) {
            QLog.d("QZoneFeatureSwitchManager", 2, "contain moment key");
            f(str, map.get(2).booleanValue());
        }
        if (map.containsKey(3)) {
            QLog.d("QZoneFeatureSwitchManager", 2, "contain intimate space user hase space key");
            e(str, map.get(3).booleanValue());
        }
    }

    public static boolean b(String str) {
        boolean d16 = com.qzone.reborn.util.i.b().d("gallery_feature_key", false);
        if (QLog.isColorLevel()) {
            QLog.i("QZoneFeatureSwitchManager", 2, "is gallery switch open:" + d16);
        }
        return d16;
    }

    public static boolean c() {
        boolean d16 = com.qzone.reborn.util.i.b().d("create_intimate_feature_key", false);
        if (QLog.isColorLevel()) {
            QLog.i("QZoneFeatureSwitchManager", 2, "isIntimateSwitchOpen switch open:" + d16);
        }
        return d16;
    }

    private static void d(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QZoneFeatureSwitchManager", 1, "[saveGalleryConfig] uin is null");
        } else {
            com.qzone.reborn.util.i.b().l("gallery_feature_key", z16);
        }
    }

    private static void e(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QZoneFeatureSwitchManager", 1, "[saveIntimateConfig] uin is null");
        } else {
            com.qzone.reborn.util.i.b().l("create_intimate_feature_key", z16);
        }
    }

    private static void f(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QZoneFeatureSwitchManager", 1, "[saveMomentConfig] uin is null");
        } else {
            com.qzone.reborn.util.i.b().l("moment_feature_key", z16);
        }
    }
}
