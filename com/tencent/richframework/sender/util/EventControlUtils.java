package com.tencent.richframework.sender.util;

import android.os.SystemClock;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public class EventControlUtils {
    private static final Map<String, Long> sConcurrentHashMap = new ConcurrentHashMap();
    private static final Map<String, Timer> sTimers = new ConcurrentHashMap();

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface OnDebounceListener {
        void onExecute();
    }

    public static void debounceDelay(final String str, long j3, final OnDebounceListener onDebounceListener) {
        Map<String, Timer> map = sTimers;
        Timer timer = map.get(str);
        if (timer != null) {
            timer.cancel();
        }
        BaseTimer baseTimer = new BaseTimer();
        baseTimer.schedule(new TimerTask() { // from class: com.tencent.richframework.sender.util.EventControlUtils.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                EventControlUtils.removeTimer(str);
                OnDebounceListener onDebounceListener2 = onDebounceListener;
                if (onDebounceListener2 != null) {
                    onDebounceListener2.onExecute();
                }
            }
        }, j3);
        map.put(str, baseTimer);
    }

    public static Long getLastTime(String str) {
        return sConcurrentHashMap.get(str);
    }

    public static Timer getTimer(String str) {
        return sTimers.get(str);
    }

    public static void removeTimer(String str) {
        sTimers.remove(str);
    }

    public static void setLastTime(String str, long j3) {
        sConcurrentHashMap.put(str, Long.valueOf(j3));
    }

    public static void setTimer(String str, Timer timer) {
        sTimers.put(str, timer);
    }

    public static boolean throttlingAtOnce(String str, long j3) {
        Map<String, Long> map = sConcurrentHashMap;
        Long l3 = map.get(str);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (l3 != null && elapsedRealtime - l3.longValue() < j3) {
            return false;
        }
        map.put(str, Long.valueOf(elapsedRealtime));
        return true;
    }

    public static void throttlingDelay(final String str, long j3, final OnDebounceListener onDebounceListener) {
        Map<String, Long> map = sConcurrentHashMap;
        Long l3 = map.get(str);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (l3 == null || elapsedRealtime - l3.longValue() >= j3) {
            map.put(str, Long.valueOf(elapsedRealtime));
            Map<String, Timer> map2 = sTimers;
            Timer timer = map2.get(str);
            if (timer != null) {
                timer.cancel();
            }
            BaseTimer baseTimer = new BaseTimer();
            baseTimer.schedule(new TimerTask() { // from class: com.tencent.richframework.sender.util.EventControlUtils.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    EventControlUtils.removeTimer(str);
                    OnDebounceListener onDebounceListener2 = onDebounceListener;
                    if (onDebounceListener2 != null) {
                        onDebounceListener2.onExecute();
                    }
                }
            }, j3);
            map2.put(str, baseTimer);
        }
    }
}
