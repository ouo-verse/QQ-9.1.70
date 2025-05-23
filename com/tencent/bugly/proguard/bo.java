package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.common.utils.ContextUtil;
import java.lang.reflect.Field;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class bo {
    public static boolean a() {
        try {
        } catch (Throwable th5) {
            av.b(th5);
        }
        if (!ai.c().b()) {
            av.a("isMainThreadForeBlocked, not foreground", new Object[0]);
            return false;
        }
        ContextUtil.getGlobalContext();
        if (!aj.r()) {
            av.a("isMainThreadForeBlocked, not vivo", new Object[0]);
            return false;
        }
        if (AndroidVersion.isOverM()) {
            MessageQueue queue = Looper.getMainLooper().getQueue();
            Field declaredField = queue.getClass().getDeclaredField("mMessages");
            boolean z16 = true;
            declaredField.setAccessible(true);
            Message message = (Message) declaredField.get(queue);
            if (message != null) {
                long when = message.getWhen();
                if (when == 0) {
                    av.a("isMainThreadForeBlocked, when == 0", new Object[0]);
                    return false;
                }
                if (SystemClock.uptimeMillis() - when <= 5000) {
                    z16 = false;
                }
                av.a("isMainThreadForeBlocked = ".concat(String.valueOf(z16)), new Object[0]);
                return z16;
            }
        }
        av.a("isMainThreadForeBlocked, return false", new Object[0]);
        return false;
    }

    public static ActivityManager.ProcessErrorStateInfo a(ActivityManager activityManager, long j3) {
        if (activityManager == null) {
            av.c("get anr state, ActivityManager is null", new Object[0]);
            return null;
        }
        av.c("get anr state, timeout:%d", Long.valueOf(j3));
        long j16 = j3 / 500;
        int i3 = 0;
        while (true) {
            ActivityManager.ProcessErrorStateInfo a16 = a(activityManager);
            if (a16 == null) {
                av.c("found proc state is null, wait for it", new Object[0]);
            } else {
                int i16 = a16.condition;
                if (i16 == 1) {
                    av.c("found proc state is crashed!", new Object[0]);
                    return null;
                }
                if (i16 == 2) {
                    av.c("found proc state is anr! proc:%s", a16.processName);
                    return a16;
                }
            }
            int i17 = i3 + 1;
            if (i3 >= j16) {
                return null;
            }
            av.c("try the %s times:", Integer.valueOf(i17));
            ba.b(500L);
            i3 = i17;
        }
    }

    private static ActivityManager.ProcessErrorStateInfo a(ActivityManager activityManager) {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
        if (processesInErrorState != null && !processesInErrorState.isEmpty()) {
            int myPid = Process.myPid();
            for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                if (processErrorStateInfo.pid == myPid) {
                    av.c("found current proc in the error state", new Object[0]);
                    return processErrorStateInfo;
                }
            }
            av.c("current proc not in the error state", new Object[0]);
            return null;
        }
        av.c("error state info list is null", new Object[0]);
        return null;
    }
}
