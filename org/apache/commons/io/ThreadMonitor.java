package org.apache.commons.io;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes29.dex */
class ThreadMonitor implements Runnable {
    private final Thread thread;
    private final long timeout;

    ThreadMonitor(Thread thread, long j3) {
        this.thread = thread;
        this.timeout = j3;
    }

    private static void sleep(long j3) throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis() + j3;
        do {
            LockMethodProxy.sleep(j3);
            j3 = currentTimeMillis - System.currentTimeMillis();
        } while (j3 > 0);
    }

    public static Thread start(long j3) {
        return start(Thread.currentThread(), j3);
    }

    public static void stop(Thread thread) {
        if (thread != null) {
            thread.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            sleep(this.timeout);
            this.thread.interrupt();
        } catch (InterruptedException unused) {
        }
    }

    public static Thread start(Thread thread, long j3) {
        if (j3 <= 0) {
            return null;
        }
        BaseThread baseThread = new BaseThread(new ThreadMonitor(thread, j3), ThreadMonitor.class.getSimpleName());
        baseThread.setDaemon(true);
        baseThread.start();
        return baseThread;
    }
}
