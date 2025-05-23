package com.tencent.liteav.base.util;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
@JNINamespace("liteav")
/* loaded from: classes7.dex */
public class HandlerThreadHolder {
    private final HandlerThread mHandlerThread;

    public HandlerThreadHolder(String str) {
        this.mHandlerThread = new BaseHandlerThread(str);
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }

    public void start() {
        this.mHandlerThread.start();
    }
}
