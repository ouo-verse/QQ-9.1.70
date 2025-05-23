package com.tencent.gamematrix.gmcg.base.helper;

import com.tencent.gamematrix.gmcg.base.utils.CGSharedPrefUtil;

/* loaded from: classes6.dex */
public class CGPersistHelper {
    public static void clearKV() {
        CGSharedPrefUtil.clear(CGBaseHelper.getAppContext());
    }

    public static boolean getKVasBoolean(String str, boolean z16) {
        return ((Boolean) CGSharedPrefUtil.get(CGBaseHelper.getAppContext(), str, Boolean.valueOf(z16))).booleanValue();
    }

    public static int getKVasInt(String str, int i3) {
        return ((Integer) CGSharedPrefUtil.get(CGBaseHelper.getAppContext(), str, Integer.valueOf(i3))).intValue();
    }

    public static long getKVasLong(String str, long j3) {
        return ((Long) CGSharedPrefUtil.get(CGBaseHelper.getAppContext(), str, Long.valueOf(j3))).longValue();
    }

    public static String getKVasString(String str, String str2) {
        return (String) CGSharedPrefUtil.get(CGBaseHelper.getAppContext(), str, str2);
    }

    public static void putKVasBoolean(String str, boolean z16) {
        CGSharedPrefUtil.put(CGBaseHelper.getAppContext(), str, Boolean.valueOf(z16));
    }

    public static void putKVasInt(String str, int i3) {
        CGSharedPrefUtil.put(CGBaseHelper.getAppContext(), str, Integer.valueOf(i3));
    }

    public static void putKVasLong(String str, long j3) {
        CGSharedPrefUtil.put(CGBaseHelper.getAppContext(), str, Long.valueOf(j3));
    }

    public static void putKVasString(String str, String str2) {
        CGSharedPrefUtil.put(CGBaseHelper.getAppContext(), str, str2);
    }

    public static void removeKV(String str) {
        CGSharedPrefUtil.remove(CGBaseHelper.getAppContext(), str);
    }
}
