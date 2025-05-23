package com.tencent.richframework.thread;

import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RFWHandlerThread extends BaseHandlerThread {
    public RFWHandlerThread(String str, int i3) {
        super(str, i3);
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        handleBeforeQuit();
        return super.quit();
    }

    @Override // android.os.HandlerThread
    public boolean quitSafely() {
        handleBeforeQuit();
        return super.quitSafely();
    }

    private void handleBeforeQuit() {
    }
}
