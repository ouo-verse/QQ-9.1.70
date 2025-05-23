package com.tencent.avcore.util;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVCoreLog {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AVCoreLog";
    protected static IAVLog sProxy;
    protected static long sSeq;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17113);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sSeq = 0L;
            sProxy = null;
        }
    }

    public AVCoreLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str, String str2) {
        IAVLog iAVLog = sProxy;
        if (iAVLog != null) {
            iAVLog.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        IAVLog iAVLog = sProxy;
        if (iAVLog != null) {
            iAVLog.e(str, str2);
        }
    }

    public static long genDebugSeq() {
        IAVLog iAVLog = sProxy;
        if (iAVLog != null) {
            return iAVLog.genDebugSeq();
        }
        long j3 = sSeq;
        sSeq = 1 + j3;
        return j3;
    }

    public static String getVersion() {
        IAVLog iAVLog = sProxy;
        if (iAVLog != null) {
            return iAVLog.getVersion();
        }
        return null;
    }

    public static void i(String str, String str2) {
        IAVLog iAVLog = sProxy;
        if (iAVLog != null) {
            iAVLog.i(str, str2);
        }
    }

    public static void init(IAVLog iAVLog) {
        sProxy = iAVLog;
    }

    public static boolean isColorLevel() {
        IAVLog iAVLog = sProxy;
        if (iAVLog != null && iAVLog.isColorLevel()) {
            return true;
        }
        return false;
    }

    public static boolean isDebugVersion() {
        IAVLog iAVLog = sProxy;
        if (iAVLog != null) {
            return iAVLog.isDebugVersion();
        }
        return false;
    }

    public static boolean isDevelopLevel() {
        IAVLog iAVLog = sProxy;
        if (iAVLog != null && iAVLog.isDevelopLevel()) {
            return true;
        }
        return false;
    }

    public static boolean isGrayVersion() {
        IAVLog iAVLog = sProxy;
        if (iAVLog != null) {
            return iAVLog.isGrayVersion();
        }
        return false;
    }

    public static boolean isInit() {
        if (sProxy != null) {
            return true;
        }
        return false;
    }

    public static boolean isLogColorOrGary() {
        IAVLog iAVLog = sProxy;
        if (iAVLog != null && (iAVLog.isColorLevel() || sProxy.isDebugVersion() || sProxy.isGrayVersion())) {
            return true;
        }
        return false;
    }

    public static <T1, T2> void print(String str, Map<T1, T2> map, boolean z16) {
        if (z16 || isDevelopLevel()) {
            String str2 = "MapValue[" + str + "]:\n";
            try {
                if (map != null) {
                    for (T1 t16 : map.keySet()) {
                        T2 t26 = map.get(t16);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str2);
                        sb5.append("    [");
                        sb5.append(t16);
                        sb5.append("]=[");
                        sb5.append("" + t26);
                        sb5.append("], [");
                        sb5.append(t26 == null ? null : t26.getClass().getSimpleName());
                        sb5.append("]\n");
                        str2 = sb5.toString();
                    }
                } else {
                    str2 = str2 + "bundle\u4e3a\u7a7a";
                }
                e(TAG, str2);
            } catch (Exception e16) {
                if (isDevelopLevel()) {
                    e(TAG, "log", e16);
                }
            }
        }
    }

    public static void printAllUserLog(String str, String str2) {
        IAVLog iAVLog = sProxy;
        if (iAVLog != null) {
            iAVLog.printAllUserLog(str, str2);
        }
    }

    @Deprecated
    public static void printColorLog(String str, String str2) {
        IAVLog iAVLog = sProxy;
        if (iAVLog != null) {
            iAVLog.printColorLog(str, str2);
        }
    }

    @Deprecated
    public static void printDebugLog(String str, String str2) {
        IAVLog iAVLog = sProxy;
        if (iAVLog != null) {
            iAVLog.printDebugLog(str, str2);
        }
    }

    public static void printErrorLog(String str, String str2) {
        IAVLog iAVLog = sProxy;
        if (iAVLog != null) {
            iAVLog.printErrorLog(str, str2);
        }
    }

    @Deprecated
    public static void printInfoLog(String str, String str2) {
        IAVLog iAVLog = sProxy;
        if (iAVLog != null) {
            iAVLog.printInfoLog(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th5) {
        IAVLog iAVLog = sProxy;
        if (iAVLog != null) {
            iAVLog.e(str, str2, th5);
        }
    }

    public static void print(String str, Bundle bundle, boolean z16) {
        String str2;
        if (z16 || isDevelopLevel()) {
            String str3 = "BundleValue[" + str + "]:\n";
            try {
                if (bundle != null) {
                    for (String str4 : bundle.keySet()) {
                        Object obj = bundle.get(str4);
                        String str5 = null;
                        if (obj == null || !(obj instanceof long[])) {
                            str2 = null;
                        } else {
                            long[] jArr = (long[]) obj;
                            str2 = "" + jArr.length;
                            for (int i3 = 0; i3 < jArr.length && i3 < 5; i3++) {
                                str2 = str2 + "[" + jArr[i3] + "]";
                            }
                        }
                        if (str2 == null) {
                            str2 = "" + obj;
                        }
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(str3);
                        sb5.append("    [");
                        sb5.append(str4);
                        sb5.append("]=[");
                        sb5.append(str2);
                        sb5.append("], [");
                        if (obj != null) {
                            str5 = obj.getClass().getSimpleName();
                        }
                        sb5.append(str5);
                        sb5.append("]\n");
                        str3 = sb5.toString();
                    }
                } else {
                    str3 = str3 + "bundle\u4e3a\u7a7a";
                }
                e(TAG, str3);
            } catch (Exception e16) {
                if (isDevelopLevel()) {
                    e(TAG, "log", e16);
                }
            }
        }
    }
}
