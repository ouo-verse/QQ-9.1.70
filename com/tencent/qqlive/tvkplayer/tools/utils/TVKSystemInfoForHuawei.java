package com.tencent.qqlive.tvkplayer.tools.utils;

import android.text.TextUtils;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKSystemInfoForHuawei {
    private static final int INVALID_VERSION = -1;
    private static final String TAG = "TVKSystemInfoForHuawei";
    private static String sDisplayVersion = getDeviceDisplayVersion();
    private static String sPatchVersion = getDevicePatchVersion();

    private static String getDeviceDisplayVersion() {
        if (!TextUtils.equals(TVKVcSystemInfo.getBrand(), "HUAWEI") && !TextUtils.equals(TVKVcSystemInfo.getManufacturer(), CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR)) {
            return null;
        }
        return TVKVcSystemInfo.getSystemProperty("ro.build.display.id", "");
    }

    private static String getDevicePatchVersion() {
        if (!TextUtils.equals(TVKVcSystemInfo.getBrand(), "HUAWEI")) {
            return null;
        }
        return TVKVcSystemInfo.getSystemProperty("hwouc.hwpatch.version", "");
    }

    public static int getDisplayVersion() {
        String str;
        if (TextUtils.isEmpty(sDisplayVersion)) {
            return -1;
        }
        int[] iArr = {1, 1, 3};
        String str2 = sDisplayVersion;
        int indexOf = str2.indexOf(" ");
        if (indexOf != -1) {
            str2 = sDisplayVersion.substring(indexOf + 1);
        }
        int indexOf2 = str2.indexOf("(");
        if (indexOf2 != -1) {
            str2 = str2.substring(0, indexOf2);
        }
        String[] split = str2.split("\\.");
        if (split.length == 4 && (str = split[0]) != null && str.length() != 0) {
            for (int i3 = 1; i3 < 4; i3++) {
                String str3 = split[i3];
                if (str3 == null || str3.length() != iArr[i3 - 1]) {
                    return -1;
                }
            }
            try {
                return (Integer.parseInt(split[0]) * 100000) + (Integer.parseInt(split[1]) * 10000) + (Integer.parseInt(split[2]) * 1000) + Integer.parseInt(split[3]);
            } catch (NumberFormatException e16) {
                TVKLogUtil.e(TAG, "convertDisplayVersion failed:" + e16.getMessage());
            }
        }
        return -1;
    }

    public static int getPatchVersion() {
        String str;
        if (TextUtils.isEmpty(sPatchVersion)) {
            return -1;
        }
        String[] split = sPatchVersion.split("patch");
        if (split.length == 2 && (str = split[1]) != null && str.length() == 3) {
            try {
                return Integer.parseInt(split[1].substring(0, 2));
            } catch (NumberFormatException e16) {
                TVKLogUtil.e(TAG, "convertsPatchVersion failed:" + e16.getMessage());
            }
        }
        return -1;
    }
}
