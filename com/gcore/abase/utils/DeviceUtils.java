package com.gcore.abase.utils;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DeviceUtils {
    static {
        try {
            System.loadLibrary("gcloudarch");
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
        }
    }

    public static String getCpuArch() {
        try {
            return nativeGetCpuArch();
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
            return "";
        }
    }

    private static native String nativeGetCpuArch();
}
