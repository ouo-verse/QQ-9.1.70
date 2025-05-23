package org.light.tavcodec;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.perf.block.LockMethodProxy;

/* compiled from: P */
/* loaded from: classes29.dex */
class SynchronizeHandler extends Handler {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static final class BlockingRunnable implements Runnable {
        private boolean isTimeout = false;
        private boolean mDone;
        private final TimeoutRunnable mTask;

        public BlockingRunnable(TimeoutRunnable timeoutRunnable) {
            this.mTask = timeoutRunnable;
        }

        public boolean postAndWait(Handler handler, long j3) {
            if (!handler.post(this)) {
                return false;
            }
            synchronized (this) {
                if (j3 > 0) {
                    long uptimeMillis = SystemClock.uptimeMillis() + j3;
                    while (!this.mDone) {
                        long uptimeMillis2 = uptimeMillis - SystemClock.uptimeMillis();
                        if (uptimeMillis2 <= 0) {
                            this.isTimeout = true;
                            return false;
                        }
                        try {
                            wait(uptimeMillis2);
                        } catch (InterruptedException unused) {
                        }
                    }
                } else {
                    while (!this.mDone) {
                        try {
                            LockMethodProxy.wait(this);
                        } catch (InterruptedException unused2) {
                        }
                    }
                }
                return true;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mTask.run();
                synchronized (this) {
                    this.mDone = true;
                    notifyAll();
                    this.mTask.afterRun(this.isTimeout);
                }
            } catch (Throwable th5) {
                synchronized (this) {
                    this.mDone = true;
                    notifyAll();
                    this.mTask.afterRun(this.isTimeout);
                    throw th5;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    interface TimeoutRunnable extends Runnable {
        void afterRun(boolean z16);
    }

    public SynchronizeHandler(Looper looper) {
        super(looper);
    }

    public final boolean runSync(TimeoutRunnable timeoutRunnable, long j3) {
        if (timeoutRunnable != null) {
            if (j3 >= 0) {
                if (Looper.myLooper() == getLooper()) {
                    timeoutRunnable.run();
                    return true;
                }
                return new BlockingRunnable(timeoutRunnable).postAndWait(this, j3);
            }
            throw new IllegalArgumentException("timeout must be non-negative");
        }
        throw new IllegalArgumentException("runnable must not be null");
    }
}
