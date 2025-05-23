package org.light.service;

import com.tencent.mobileqq.perf.block.LockMethodProxy;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SingleLock {
    public synchronized void acquire() throws InterruptedException {
        LockMethodProxy.wait(this);
    }

    public synchronized void release() {
        notifyAll();
    }
}
