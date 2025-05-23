package com.tencent.mobileqq.minigame.minigamecenter.utils;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniGameCenterHelper {
    private static String sAppInfoBuffer = "";
    private static String sAppInfoTraceInfo = "";

    public static void clearCacheData() {
        sAppInfoBuffer = "";
        sAppInfoTraceInfo = "";
    }

    public static String getAppInfoBuffer() {
        return sAppInfoBuffer;
    }

    public static String getAppInfoTraceInfo() {
        return sAppInfoTraceInfo;
    }

    public static void setAppInfoBuffer(String str) {
        sAppInfoBuffer = str;
    }

    public static void setAppInfoTraceInfo(String str) {
        sAppInfoTraceInfo = str;
    }
}
