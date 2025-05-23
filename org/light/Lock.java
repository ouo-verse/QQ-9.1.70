package org.light;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Lock {
    public static boolean FORCE_USE_COMMON_LOCK = false;
    private AtomicInteger count;
    private Semaphore lock;
    private boolean useCAS;

    public Lock(int i3) {
        this(i3, true);
    }

    public void acquire() {
        if (this.useCAS) {
            acquire("");
            return;
        }
        try {
            this.lock.acquire();
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
    }

    public void release() {
        if (this.useCAS) {
            this.count.addAndGet(1);
        } else {
            this.lock.release();
        }
    }

    public Lock(int i3, boolean z16) {
        this.useCAS = z16;
        if (FORCE_USE_COMMON_LOCK) {
            this.useCAS = false;
        }
        if (this.useCAS) {
            this.count = new AtomicInteger(i3);
        } else {
            this.lock = new Semaphore(i3);
        }
    }

    public void acquire(String str) {
        if (!this.useCAS) {
            try {
                this.lock.acquire();
                return;
            } catch (InterruptedException e16) {
                e16.printStackTrace();
                return;
            }
        }
        do {
            Thread.yield();
        } while (this.count.get() == 0);
        this.count.decrementAndGet();
    }
}
