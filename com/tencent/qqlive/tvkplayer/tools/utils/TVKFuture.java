package com.tencent.qqlive.tvkplayer.tools.utils;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.perf.block.LockMethodProxy;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKFuture implements ITVKFutureSetter, ITVKFutureGetter {
    private static final int INTERRUPTED_TIMES = 2;
    private static final String TAG = "TVKFuture";
    private Object mRealResult = null;
    private boolean mIsReady = false;
    private Throwable mException = null;

    private void waitAndDealInterrupted() {
        int i3 = 2;
        boolean z16 = false;
        while (true) {
            i3--;
            if (i3 < 0) {
                break;
            }
            try {
                LockMethodProxy.wait(this);
                break;
            } catch (InterruptedException unused) {
                TVKLogUtil.i(TAG, "getResult wait has InterruptedException, interrupted:" + i3);
                z16 = true;
            }
        }
        if (z16) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.utils.ITVKFutureGetter
    public synchronized Object getResult() throws Throwable {
        if (!this.mIsReady) {
            waitAndDealInterrupted();
        }
        Throwable th5 = this.mException;
        if (th5 == null) {
        } else {
            throw th5;
        }
        return this.mRealResult;
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.utils.ITVKFutureSetter
    public synchronized void setException(@NonNull Throwable th5) {
        this.mException = th5;
        this.mIsReady = true;
        notifyAll();
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.utils.ITVKFutureSetter
    public synchronized void setResult(Object obj) {
        if (this.mIsReady) {
            return;
        }
        this.mRealResult = obj;
        this.mIsReady = true;
        notifyAll();
    }

    private synchronized void waitAndDealInterrupted(long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z16 = false;
        while (j3 > 0) {
            try {
                wait(j3);
                break;
            } catch (InterruptedException unused) {
                j3 -= SystemClock.elapsedRealtime() - elapsedRealtime;
                TVKLogUtil.i(TAG, "getResult wait has InterruptedException, remainTimeMs:" + j3);
                z16 = true;
            }
        }
        if (z16) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.tools.utils.ITVKFutureGetter
    public synchronized Object getResult(long j3) throws Throwable {
        if (!this.mIsReady) {
            waitAndDealInterrupted(j3);
        }
        Throwable th5 = this.mException;
        if (th5 == null) {
        } else {
            throw th5;
        }
        return this.mRealResult;
    }
}
