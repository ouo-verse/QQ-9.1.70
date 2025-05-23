package com.google.android.exoplayer2.util;

import com.tencent.mobileqq.perf.block.LockMethodProxy;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class ConditionVariable {
    private boolean isOpen;

    public synchronized void block() throws InterruptedException {
        while (!this.isOpen) {
            LockMethodProxy.wait(this);
        }
    }

    public synchronized boolean close() {
        boolean z16;
        z16 = this.isOpen;
        this.isOpen = false;
        return z16;
    }

    public synchronized boolean open() {
        if (this.isOpen) {
            return false;
        }
        this.isOpen = true;
        notifyAll();
        return true;
    }

    public synchronized boolean block(long j3) throws InterruptedException {
        boolean z16;
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        long j16 = j3 + elapsedRealtime;
        while (true) {
            z16 = this.isOpen;
            if (z16 || elapsedRealtime >= j16) {
                break;
            }
            wait(j16 - elapsedRealtime);
            elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        }
        return z16;
    }
}
