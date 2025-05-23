package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.mobileqq.perf.block.LockMethodProxy;

/* compiled from: P */
/* loaded from: classes23.dex */
public class WaitNotify {
    private static final String TAG = "WaitNotify";
    private final MonitorObject myMonitorObject = new MonitorObject();
    private volatile boolean wasSignalled = false;
    private volatile boolean isWaiting = false;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface WaitListener {
        boolean keepWaiting();
    }

    public void doNotify() {
        Logger.d(TAG, "doNotify " + Thread.currentThread().getName());
        synchronized (this.myMonitorObject) {
            this.wasSignalled = true;
            Logger.d(TAG, "doNotify internal " + Thread.currentThread().getName());
            this.myMonitorObject.notifyAll();
            Logger.d(TAG, "doNotify over " + Thread.currentThread().getName());
        }
    }

    public void doWait() {
        doWait(Long.MAX_VALUE, 0, new WaitListener() { // from class: com.tencent.qqmusic.mediaplayer.util.WaitNotify.1
            @Override // com.tencent.qqmusic.mediaplayer.util.WaitNotify.WaitListener
            public boolean keepWaiting() {
                return true;
            }
        });
    }

    public boolean isWaiting() {
        return this.isWaiting;
    }

    public void doWait(long j3, int i3, WaitListener waitListener) {
        Logger.d(TAG, "doWait " + Thread.currentThread().getName());
        synchronized (this.myMonitorObject) {
            this.wasSignalled = false;
            int i16 = 0;
            while (!this.wasSignalled) {
                try {
                    Logger.d(TAG, "doWait internal " + Thread.currentThread().getName() + " " + i16);
                    this.isWaiting = true;
                    if (i16 < i3) {
                        this.myMonitorObject.wait(j3, 0);
                        if (!waitListener.keepWaiting()) {
                            doNotify();
                            break;
                        }
                    } else {
                        LockMethodProxy.wait(this.myMonitorObject);
                    }
                    Logger.d(TAG, "doWait wake " + Thread.currentThread().getName() + " " + i16);
                } catch (InterruptedException e16) {
                    Logger.e(TAG, e16.toString());
                }
                i16++;
            }
            this.isWaiting = false;
        }
    }
}
