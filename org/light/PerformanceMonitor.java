package org.light;

/* loaded from: classes29.dex */
public class PerformanceMonitor {
    private static final String TAG = "PerformanceMonitor";

    public static String getBenchData() {
        return nativeGetBenchData();
    }

    public static String getPerformanceData() {
        return nativeGetPerformanceData();
    }

    private static native String nativeGetBenchData();

    private static native String nativeGetPerformanceData();

    private static native boolean nativeSavePerformanceData();

    private static native void nativeSetBenchConfig(String str);

    private static native void nativeSetBenchConfigWithThreshold(String str, float f16);

    private static native void nativeSetBenchEnable(boolean z16);

    private static native void nativeSetBenchEnableWithThreshold(boolean z16, float f16);

    private static native void nativeSetPerfEnable(boolean z16, boolean z17, boolean z18, String str);

    private static native void nativeSetPerformanceRunMode(int i3);

    public static boolean savePerformanceData() {
        return nativeSavePerformanceData();
    }

    public static void setBenchConfig(String str) {
        nativeSetBenchConfig(str);
    }

    public static void setBenchConfigWithThreshold(String str, float f16) {
        nativeSetBenchConfigWithThreshold(str, f16);
    }

    public static void setBenchEnable(boolean z16) {
        nativeSetBenchEnable(z16);
    }

    public static void setBenchEnableWithThreshold(boolean z16, float f16) {
        nativeSetBenchEnableWithThreshold(z16, f16);
    }

    public static void setPerfEnable(boolean z16, boolean z17, boolean z18, String str) {
        nativeSetPerfEnable(z16, z17, z18, str);
    }

    public static void setPerformanceRunMode(int i3) {
        nativeSetPerformanceRunMode(i3);
    }
}
