package com.tencent.thumbplayer.common;

import android.os.SystemClock;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thumbplayer.api.common.TPTimeoutException;

/* loaded from: classes26.dex */
public class TPFutureResult {
    private static final int MAX_NUMBER_OF_INTERRUPTED = 2;
    private boolean mIsReady = false;
    private Object mResult = null;
    private Throwable mThrowable = null;

    public synchronized Object getResult() throws Throwable {
        boolean z16;
        int i3 = 0;
        boolean z17 = false;
        while (true) {
            z16 = this.mIsReady;
            if (z16 || i3 >= 2) {
                break;
            }
            try {
                LockMethodProxy.wait(this);
            } catch (InterruptedException unused) {
                i3++;
                z17 = true;
            }
        }
        if (z16) {
            if (z17) {
                Thread.currentThread().interrupt();
            }
            Throwable th5 = this.mThrowable;
            if (th5 == null) {
            } else {
                throw th5;
            }
        } else {
            throw new InterruptedException("Interrupted count reaches maximum number: 2");
        }
        return this.mResult;
    }

    public synchronized void setResult(Object obj) {
        if (this.mIsReady) {
            return;
        }
        this.mResult = obj;
        this.mIsReady = true;
        notifyAll();
    }

    public synchronized void setThrowable(Throwable th5) {
        if (!this.mIsReady && th5 != null) {
            this.mThrowable = th5;
            this.mIsReady = true;
            notifyAll();
        }
    }

    public synchronized Object getResult(long j3) throws Throwable {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z16 = false;
        for (long j16 = j3; !this.mIsReady && j16 > 0; j16 -= SystemClock.elapsedRealtime() - elapsedRealtime) {
            try {
                wait(j16);
            } catch (InterruptedException unused) {
                z16 = true;
            }
        }
        if (z16) {
            Thread.currentThread().interrupt();
        }
        if (this.mIsReady) {
            Throwable th5 = this.mThrowable;
            if (th5 != null) {
                throw th5;
            }
        } else {
            throw new TPTimeoutException("Waiting for result timeout. Timeout period: " + j3 + "ms");
        }
        return this.mResult;
    }
}
