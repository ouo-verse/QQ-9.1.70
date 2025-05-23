package com.tencent.mobileqq.mini.entry.util;

import android.content.Context;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class DeviceUtils {
    private static final String TAG = "Mini.DeviceUtils";

    public static boolean isPad(Context context) {
        boolean isPadOfDefault;
        if (Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI)) {
            isPadOfDefault = isPadOfMiui(context);
        } else {
            isPadOfDefault = isPadOfDefault(context);
        }
        QLog.i(TAG, 1, "isPad = " + isPadOfDefault);
        return isPadOfDefault;
    }

    private static boolean isPadOfDefault(Context context) {
        if ((context.getResources().getConfiguration().screenLayout & 15) >= 3) {
            return true;
        }
        return false;
    }

    private static boolean isPadOfMiui(Context context) {
        try {
            String str = (String) SystemProperties.class.getMethod("get", String.class).invoke(SystemProperties.class, "ro.build.characteristics");
            if (!TextUtils.isEmpty(str)) {
                return str.contains("tablet");
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        return isPadOfDefault(context);
    }
}
