package com.google.android.exoplayer2.util;

import android.os.Handler;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SimpleHandlerThread extends BaseHandlerThread {
    private Handler mHandler;

    public SimpleHandlerThread(String str, int i3) {
        super(str, i3);
    }

    public void postJob(Runnable runnable) {
        this.mHandler.post(runnable);
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread, java.lang.Thread
    public synchronized void start() {
        super.start();
        this.mHandler = new Handler(getLooper());
    }
}
