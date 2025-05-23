package com.tencent.liteav.base.util;

import com.tencent.liteav.base.annotations.JNINamespace;

/* compiled from: P */
@JNINamespace("liteav")
/* loaded from: classes7.dex */
public class CommonUtil {
    private static long mNativeNtpTimeManagerListener;
    private static a sCallback;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface a {
        void a(int i3, String str);
    }

    static {
        SoLoader.loadAllLibraries();
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || !obj.equals(obj2)) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static String getFileExtension(String str) {
        int lastIndexOf;
        if (str != null && str.length() > 0 && (lastIndexOf = str.lastIndexOf(46)) >= 0 && lastIndexOf < str.length() - 1) {
            return str.substring(lastIndexOf + 1);
        }
        return null;
    }

    public static long getNetworkTimestamp() {
        if (nativeNtpTimeManagerListenerHasBeenCreated()) {
            return nativeGetNetworkTimestamp(mNativeNtpTimeManagerListener);
        }
        return 0L;
    }

    public static String getSDKVersionStr() {
        return nativeGetSDKVersion();
    }

    private static native long nativeCreate();

    private static native long nativeGetNetworkTimestamp(long j3);

    public static native String nativeGetSDKVersion();

    private static boolean nativeNtpTimeManagerListenerHasBeenCreated() {
        if (sCallback != null) {
            return true;
        }
        return false;
    }

    private static native int nativeSetGlobalEnv(String str);

    private static native boolean nativeSetSocks5Proxy(String str, int i3, String str2, String str3, boolean z16, boolean z17, boolean z18);

    private static native int nativeUpdateNetworkTime(long j3);

    public static void onUpdateNetworkTime(int i3, String str) {
        a aVar = sCallback;
        if (aVar != null) {
            aVar.a(i3, str);
        }
    }

    public static int setGlobalEnv(String str) {
        return nativeSetGlobalEnv(str);
    }

    public static boolean setSocks5Proxy(String str, int i3, String str2, String str3, boolean z16, boolean z17, boolean z18) {
        return nativeSetSocks5Proxy(str, i3, str2, str3, z16, z17, z18);
    }

    public static void setUpdateNetworkTimeCallback(a aVar) {
        if (nativeNtpTimeManagerListenerHasBeenCreated()) {
            return;
        }
        mNativeNtpTimeManagerListener = nativeCreate();
        sCallback = aVar;
    }

    public static int updateNetworkTime() {
        if (nativeNtpTimeManagerListenerHasBeenCreated()) {
            return nativeUpdateNetworkTime(mNativeNtpTimeManagerListener);
        }
        return -1;
    }
}
