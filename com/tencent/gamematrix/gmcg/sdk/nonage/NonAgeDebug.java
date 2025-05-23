package com.tencent.gamematrix.gmcg.sdk.nonage;

/* compiled from: P */
/* loaded from: classes6.dex */
public class NonAgeDebug {
    public static boolean testChildren = false;
    public static boolean testExpire = false;
    public static boolean testGameIsProtect = false;
    public static boolean testHeartBeat = false;

    public static void deleteUser() {
        CGNonAgeProtectModule.getInstance().deleteUser();
    }

    public static void trigerProtect() {
        testGameIsProtect = true;
    }

    public static void trigerTestChildren() {
        testChildren = true;
        testExpire = false;
    }

    public static void trigerTestExpire() {
        testChildren = false;
        testExpire = true;
    }
}
