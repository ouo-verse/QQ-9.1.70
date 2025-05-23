package com.tencent.qqmini.v8rt.engine;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes23.dex */
public class V8TimerThread extends BaseThread {
    public static final String LOG_TAG = "V8Timer";
    private IListener mListener;
    private final AtomicInteger mPendingVSyncCount = new AtomicInteger();

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface IListener {
        void onExit();

        boolean onPrepare();
    }

    public V8TimerThread(IListener iListener) {
        this.mListener = iListener;
        setPriority(10);
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        IListener iListener = this.mListener;
        if (iListener == null) {
            return;
        }
        iListener.onPrepare();
        do {
            try {
            } catch (Throwable th5) {
                Logger.e(LOG_TAG, "run error " + th5.getMessage());
            }
        } while (!Engine.runLoop());
        Logger.e(LOG_TAG, "run exit");
        this.mListener.onExit();
    }
}
