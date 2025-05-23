package com.tencent.qqlive.tvkplayer.tools.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.perf.block.LockMethodProxy;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKSynchronousHandler {
    private static final String TAG = "TVKSynchronousHandler";

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static final class BlockingRunnable implements Runnable {
        private boolean mIsDone;
        private final Runnable mTask;

        public BlockingRunnable(Runnable runnable) {
            this.mTask = runnable;
        }

        private synchronized boolean letCallerThreadWait(long j3) {
            if (j3 > 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime() + j3;
                while (!this.mIsDone) {
                    long elapsedRealtime2 = elapsedRealtime - SystemClock.elapsedRealtime();
                    if (elapsedRealtime2 <= 0) {
                        return false;
                    }
                    try {
                        wait(elapsedRealtime2);
                    } catch (InterruptedException e16) {
                        TVKLogUtil.e(TVKSynchronousHandler.TAG, e16);
                    }
                }
                return true;
            }
            while (!this.mIsDone) {
                try {
                    LockMethodProxy.wait(this);
                } catch (InterruptedException e17) {
                    TVKLogUtil.e(TVKSynchronousHandler.TAG, e17);
                }
            }
            return true;
        }

        public boolean postAndWait(Handler handler, long j3) {
            if (!handler.post(this)) {
                return false;
            }
            return letCallerThreadWait(j3);
        }

        public boolean postAtQueueFrontAndWait(Handler handler, long j3) {
            if (!handler.postAtFrontOfQueue(this)) {
                return false;
            }
            return letCallerThreadWait(j3);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mTask.run();
                synchronized (this) {
                    this.mIsDone = true;
                    notifyAll();
                }
            } catch (Throwable th5) {
                synchronized (this) {
                    this.mIsDone = true;
                    notifyAll();
                    throw th5;
                }
            }
        }
    }

    public static boolean postAndWait(@NonNull Handler handler, @NonNull Runnable runnable, long j3) throws IllegalArgumentException {
        if (j3 >= 0) {
            if (handler.getLooper() == Looper.myLooper()) {
                runnable.run();
                return true;
            }
            return new BlockingRunnable(runnable).postAndWait(handler, j3);
        }
        throw new IllegalArgumentException("timeout must be non-negative");
    }

    public static boolean postAtQueueFrontAndWait(@NonNull Handler handler, @NonNull Runnable runnable, long j3) throws IllegalArgumentException {
        if (j3 >= 0) {
            if (handler.getLooper() == Looper.myLooper()) {
                runnable.run();
                return true;
            }
            return new BlockingRunnable(runnable).postAtQueueFrontAndWait(handler, j3);
        }
        throw new IllegalArgumentException("timeout must be non-negative");
    }
}
