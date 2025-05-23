package com.tencent.ark;

import com.tencent.ark.ArkEnvironmentManager;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Logger {
    static ArkEnvironmentManager.ILog logCallback;
    private static final HashMap<String, Long> logTimestamp = new HashMap<>();

    static String combine(Object... objArr) {
        String str;
        StringBuilder sb5 = new StringBuilder(objArr.length * 30);
        for (Object obj : objArr) {
            if (obj != null) {
                str = obj.toString();
            } else {
                str = "(null)";
            }
            sb5.append(str);
        }
        sb5.append(getQueueKey());
        return sb5.toString();
    }

    static void doLogD(String str, String str2) {
        ArkEnvironmentManager.ILog iLog = logCallback;
        if (iLog != null) {
            iLog.d(str, str2);
        }
    }

    static String getQueueKey() {
        String str;
        try {
            str = ArkDispatchQueue.getCurrentQueueKey();
        } catch (UnsatisfiedLinkError unused) {
            str = "(none)";
        }
        return " QueueKey:" + str;
    }

    public static void logD(String str, String str2) {
        ArkEnvironmentManager.ILog iLog = logCallback;
        if (iLog == null) {
            return;
        }
        iLog.d(str, str2);
    }

    public static void logE(String str, String str2) {
        ArkEnvironmentManager.ILog iLog = logCallback;
        if (iLog == null) {
            return;
        }
        iLog.e(str, str2);
    }

    public static void logI(String str, String str2) {
        ArkEnvironmentManager.ILog iLog = logCallback;
        if (iLog == null) {
            return;
        }
        iLog.i(str, str2);
    }

    public static void logW(String str, String str2) {
        ArkEnvironmentManager.ILog iLog = logCallback;
        if (iLog == null) {
            return;
        }
        iLog.w(str, str2);
    }

    public static void logWithLimit(String str, String str2, String str3) {
        logWithLimit(str, str2, str3, 1000);
    }

    public static void setLogCallback(ArkEnvironmentManager.ILog iLog) {
        logCallback = iLog;
    }

    public static void logWithLimit(String str, String str2, String str3, int i3) {
        HashMap<String, Long> hashMap = logTimestamp;
        Long l3 = hashMap.get(str);
        if (l3 == null || System.currentTimeMillis() - l3.longValue() >= i3) {
            hashMap.put(str, Long.valueOf(System.currentTimeMillis()));
            logI(str2, str3);
        }
    }

    public static void logD(String str, Object... objArr) {
        ArkEnvironmentManager.ILog iLog = logCallback;
        if (iLog == null) {
            return;
        }
        iLog.d(str, combine(objArr));
    }

    public static void logE(String str, Object... objArr) {
        ArkEnvironmentManager.ILog iLog = logCallback;
        if (iLog == null) {
            return;
        }
        iLog.e(str, combine(objArr));
    }

    public static void logI(String str, Object... objArr) {
        ArkEnvironmentManager.ILog iLog = logCallback;
        if (iLog == null) {
            return;
        }
        iLog.i(str, combine(objArr));
    }

    public static void logW(String str, Object... objArr) {
        ArkEnvironmentManager.ILog iLog = logCallback;
        if (iLog == null) {
            return;
        }
        iLog.w(str, combine(objArr));
    }
}
