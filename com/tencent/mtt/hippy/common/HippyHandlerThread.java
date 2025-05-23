package com.tencent.mtt.hippy.common;

import android.os.Handler;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyHandlerThread extends BaseHandlerThread {
    final Handler mHandler;

    /* compiled from: P */
    /* renamed from: com.tencent.mtt.hippy.common.HippyHandlerThread$1, reason: invalid class name */
    /* loaded from: classes20.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HippyHandlerThread.super.quit();
        }
    }

    public HippyHandlerThread(String str) {
        super(str);
        setPriority(10);
        start();
        this.mHandler = new Handler(getLooper());
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public boolean isThreadAlive() {
        if (this.mHandler != null && getLooper() != null && isAlive()) {
            return true;
        }
        return false;
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        return super.quitSafely();
    }

    public void runOnQueue(Runnable runnable) {
        this.mHandler.post(runnable);
    }
}
