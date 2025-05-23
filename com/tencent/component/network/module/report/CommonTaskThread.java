package com.tencent.component.network.module.report;

import android.os.Handler;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CommonTaskThread extends BaseHandlerThread {
    private Handler handler;

    public CommonTaskThread(String str) {
        super(str, 10);
        start();
    }

    public synchronized void post(Runnable runnable) {
        if (this.handler == null) {
            this.handler = new Handler(getLooper());
        }
        this.handler.post(runnable);
    }

    public synchronized void postDelay(Runnable runnable, long j3) {
        if (this.handler == null) {
            this.handler = new Handler(getLooper());
        }
        this.handler.postDelayed(runnable, j3);
    }
}
