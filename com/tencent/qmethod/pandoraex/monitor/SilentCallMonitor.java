package com.tencent.qmethod.pandoraex.monitor;

import android.content.Context;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SilentCallMonitor {
    private static final String KEY_SILENT_FOREGROUND_TIME = "key_silent_foreground_time";
    public static final String TAG = "SilentCallMonitor";
    private static final Object LOCK_SILENT_CALL = new Object();
    private static AtomicLong lastUserInteractionTime = new AtomicLong(0);
    public static final boolean ENABLE = silentDisable();
    private static boolean hookEnable = false;

    public static void clearUserInteractionTime() {
        synchronized (LOCK_SILENT_CALL) {
            lastUserInteractionTime.set(0L);
            Context b16 = com.tencent.qmethod.pandoraex.api.q.b();
            if (b16 != null) {
                com.tencent.qmethod.pandoraex.api.r.k(b16, KEY_SILENT_FOREGROUND_TIME);
            }
        }
    }

    public static long getLastUserInteractionTime() {
        long j3;
        synchronized (LOCK_SILENT_CALL) {
            Context b16 = com.tencent.qmethod.pandoraex.api.q.b();
            if (b16 != null && com.tencent.qmethod.pandoraex.api.r.c(b16, KEY_SILENT_FOREGROUND_TIME).booleanValue()) {
                long longValue = com.tencent.qmethod.pandoraex.api.r.g(b16, KEY_SILENT_FOREGROUND_TIME).longValue();
                if (longValue > lastUserInteractionTime.get()) {
                    lastUserInteractionTime.set(longValue);
                }
            }
            j3 = lastUserInteractionTime.get();
        }
        return j3;
    }

    public static boolean isHookEnable() {
        return hookEnable;
    }

    public static void onApplicationForeground() {
        synchronized (LOCK_SILENT_CALL) {
            onUserInteraction();
            if (com.tencent.qmethod.pandoraex.api.q.b() != null) {
                com.tencent.qmethod.pandoraex.api.r.o(com.tencent.qmethod.pandoraex.api.q.b(), KEY_SILENT_FOREGROUND_TIME, Long.valueOf(lastUserInteractionTime.get()));
                com.tencent.qmethod.pandoraex.core.o.a(TAG, "save lastUserInteractionTime:" + lastUserInteractionTime);
            }
        }
    }

    public static void onUserInteraction() {
        lastUserInteractionTime.set(SystemClock.uptimeMillis());
    }

    public static void setHookEnable(boolean z16) {
        hookEnable = z16;
    }

    private static boolean silentDisable() {
        return false;
    }

    public static boolean silentEnable() {
        return true;
    }
}
