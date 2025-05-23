package com.tencent.gamecenter.wadl.util;

import com.tencent.gamecenter.wadl.api.IQQGameMMKVService;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GameCenterSpUtils {
    public static final String KEY_GAMECENTER_RES_TIME = "gamecenter_res_time";
    public static final String KEY_LAST_GET_CONF_TIME = "LAST_GET_CONF_TIME";
    public static final String KEY_LAST_GET_CONF_VERSION = "LAST_GET_CONF_VERSION";
    public static final String KEY_LAST_GET_INTERRUPT_FILE_TIME = "LAST_GET_INTERRUPT_FILE_TIME";
    public static final String KEY_LAST_GET_REGEX_CONFIG_VERSION = "KEY_LAST_GET_REGEX_CONFIG_VERSION";
    public static final String KEY_LAST_TIME_API_PRE = "LAST_TIME_API_PRE_";
    public static final String KEY_REQUEST_RED_POINT_TIME = "KEY_RED_POINT_TIME_";
    public static final String TAG = "Wadl_GameCenterSpUtils";

    public static boolean deleteToSp(String... strArr) {
        return ((IQQGameMMKVService) QRoute.api(IQQGameMMKVService.class)).deleteToSp(strArr);
    }

    public static String getStringOutAccount(String str) {
        return ((IQQGameMMKVService) QRoute.api(IQQGameMMKVService.class)).getStringOutAccount(str);
    }

    public static boolean readBoolFromSp(String str) {
        return ((IQQGameMMKVService) QRoute.api(IQQGameMMKVService.class)).readBoolFromSp(str);
    }

    public static String readFromSp(String str) {
        return ((IQQGameMMKVService) QRoute.api(IQQGameMMKVService.class)).readFromSp(str);
    }

    public static int readFromSpInt(String str) {
        return ((IQQGameMMKVService) QRoute.api(IQQGameMMKVService.class)).readFromSpInt(str);
    }

    public static long readFromSpLong(String str) {
        return ((IQQGameMMKVService) QRoute.api(IQQGameMMKVService.class)).readFromSpLong(str);
    }

    public static void setStringOutAccount(String str, String str2) {
        ((IQQGameMMKVService) QRoute.api(IQQGameMMKVService.class)).setStringOutAccount(str, str2);
    }

    public static boolean writeToSp(String str, String str2) {
        return ((IQQGameMMKVService) QRoute.api(IQQGameMMKVService.class)).writeToSp(str, str2);
    }

    public static boolean writeToSpBool(String str, boolean z16) {
        return ((IQQGameMMKVService) QRoute.api(IQQGameMMKVService.class)).writeToSpBool(str, z16);
    }

    public static void writeToSpInt(String str, int i3) {
        ((IQQGameMMKVService) QRoute.api(IQQGameMMKVService.class)).writeToSpInt(str, i3);
    }

    public static void writeToSpLong(String str, long j3) {
        ((IQQGameMMKVService) QRoute.api(IQQGameMMKVService.class)).writeToSpLong(str, j3);
    }
}
