package com.tencent.tav;

import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes26.dex */
public class RCHandlerThread extends BaseHandlerThread {

    /* renamed from: rc, reason: collision with root package name */
    private final AtomicInteger f374238rc;

    public RCHandlerThread(String str) {
        super(str);
        this.f374238rc = new AtomicInteger(0);
    }

    public void dereference() {
        this.f374238rc.decrementAndGet();
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        dereference();
        if (this.f374238rc.get() <= 0) {
            return super.quit();
        }
        return false;
    }

    @Override // android.os.HandlerThread
    public boolean quitSafely() {
        dereference();
        if (this.f374238rc.get() <= 0) {
            return super.quitSafely();
        }
        return false;
    }

    public void reference() {
        this.f374238rc.incrementAndGet();
    }
}
