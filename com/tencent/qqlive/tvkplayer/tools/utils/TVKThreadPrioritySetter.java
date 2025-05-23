package com.tencent.qqlive.tvkplayer.tools.utils;

import android.os.Process;

/* loaded from: classes23.dex */
public class TVKThreadPrioritySetter {
    private static final ThreadLocal<Integer> sThreadPriorities = new ThreadLocal<>();

    public static void reset() {
        ThreadLocal<Integer> threadLocal = sThreadPriorities;
        Integer num = threadLocal.get();
        if (num == null) {
            return;
        }
        Process.setThreadPriority(num.intValue());
        threadLocal.remove();
    }

    public static void set(int i3) {
        ThreadLocal<Integer> threadLocal = sThreadPriorities;
        if (threadLocal.get() == null) {
            threadLocal.set(Integer.valueOf(Process.getThreadPriority(0)));
        }
        Process.setThreadPriority(i3);
    }
}
