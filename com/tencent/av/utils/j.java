package com.tencent.av.utils;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class j {
    private static String a() {
        try {
            String str = (String) SystemProperties.class.getMethod("get", String.class).invoke(SystemProperties.class, "ro.build.characteristics");
            QLog.d("DeviceUtil", 1, "characteristics = " + str);
            return str;
        } catch (Exception e16) {
            QLog.e("DeviceUtil", 1, e16, new Object[0]);
            return null;
        }
    }

    public static boolean b() {
        return CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean c() {
        String a16 = a();
        if (!TextUtils.isEmpty(a16)) {
            return a16.contains("tablet");
        }
        return false;
    }
}
