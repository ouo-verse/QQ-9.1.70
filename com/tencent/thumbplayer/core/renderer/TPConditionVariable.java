package com.tencent.thumbplayer.core.renderer;

import android.os.SystemClock;
import com.tencent.mobileqq.perf.block.LockMethodProxy;

/* loaded from: classes26.dex */
public class TPConditionVariable {
    private boolean isOpen;

    public synchronized void block() throws InterruptedException {
        while (!this.isOpen) {
            LockMethodProxy.wait(this);
        }
    }

    public synchronized void blockUninterruptible() {
        boolean z16 = false;
        while (!this.isOpen) {
            try {
                LockMethodProxy.wait(this);
            } catch (InterruptedException unused) {
                z16 = true;
            }
        }
        if (z16) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean close() {
        boolean z16;
        z16 = this.isOpen;
        this.isOpen = false;
        return z16;
    }

    public synchronized boolean isOpen() {
        return this.isOpen;
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
        if (j3 <= 0) {
            return this.isOpen;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j16 = j3 + elapsedRealtime;
        if (j16 < elapsedRealtime) {
            block();
        } else {
            while (!this.isOpen && elapsedRealtime < j16) {
                wait(j16 - elapsedRealtime);
                elapsedRealtime = SystemClock.elapsedRealtime();
            }
        }
        return this.isOpen;
    }
}
