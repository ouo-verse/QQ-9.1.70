package com.tencent.mobileqq.minigame.utils.thread;

import android.os.Handler;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes33.dex */
public class TTHandleThread extends BaseHandlerThread {
    private static Handler handler;
    private static volatile TTHandleThread instance;

    TTHandleThread(String str) {
        super(str);
    }

    public static Handler getHandler() {
        return handler;
    }

    public static TTHandleThread getInstance() {
        if (instance == null) {
            synchronized (TTHandleThread.class) {
                if (instance == null) {
                    TTHandleThread tTHandleThread = new TTHandleThread("TTIOThread");
                    tTHandleThread.start();
                    handler = new Handler(tTHandleThread.getLooper());
                    instance = tTHandleThread;
                }
            }
        }
        return instance;
    }

    public final void post(Runnable runnable) {
        handler.post(runnable);
    }

    public final void postDelayed(Runnable runnable, long j3) {
        handler.postDelayed(runnable, j3);
    }

    public final void remove(Runnable runnable) {
        handler.removeCallbacks(runnable);
    }
}
