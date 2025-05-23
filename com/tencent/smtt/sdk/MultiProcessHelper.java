package com.tencent.smtt.sdk;

import android.os.Bundle;

/* loaded from: classes23.dex */
public class MultiProcessHelper {
    private static Object a(String str, Bundle bundle) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            try {
                return a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMiscMethod", new Class[]{String.class, Bundle.class}, str, bundle);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static boolean getMultiProcessAutoRecoveryEnabled() {
        Object a16 = a("getMultiProcessAutoRecoveryEnabled", null);
        if (a16 instanceof Boolean) {
            return ((Boolean) a16).booleanValue();
        }
        return true;
    }

    public static String getMultiProcessChoseTypeReason() {
        Object a16 = a("getMultiProcessChoseTypeReason", null);
        if (a16 instanceof String) {
            return (String) a16;
        }
        return "";
    }

    public static boolean getMultiProcessFallbackServiceEnabled() {
        Object a16 = a("getMutliProcessFallbackServiceEnabled", null);
        if (a16 instanceof Boolean) {
            return ((Boolean) a16).booleanValue();
        }
        return false;
    }

    public static boolean getMultiProcessNoSandBoxEnabled() {
        Object a16 = a("getMultiProcessNoSandBoxIfNotIsolatedEnabled", null);
        if (a16 instanceof Boolean) {
            return ((Boolean) a16).booleanValue();
        }
        return true;
    }

    public static int getMultiProcessType() {
        Object a16 = a("getMultiProcessType", null);
        if (a16 instanceof Integer) {
            return ((Integer) a16).intValue();
        }
        return -1;
    }
}
