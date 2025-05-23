package com.google.android.exoplayer2.util;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

/* loaded from: classes2.dex */
public final class PriorityTaskManager {
    private final Object lock = new Object();
    private final PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());
    private int highestPriority = Integer.MIN_VALUE;

    /* loaded from: classes2.dex */
    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i3, int i16) {
            super("Priority too low [priority=" + i3 + ", highest=" + i16 + "]");
        }
    }

    public void add(int i3) {
        synchronized (this.lock) {
            this.queue.add(Integer.valueOf(i3));
            this.highestPriority = Math.max(this.highestPriority, i3);
        }
    }

    public void proceed(int i3) throws InterruptedException {
        synchronized (this.lock) {
            while (this.highestPriority != i3) {
                LockMethodProxy.wait(this.lock);
            }
        }
    }

    public boolean proceedNonBlocking(int i3) {
        boolean z16;
        synchronized (this.lock) {
            if (this.highestPriority == i3) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    public void proceedOrThrow(int i3) throws PriorityTooLowException {
        synchronized (this.lock) {
            if (this.highestPriority != i3) {
                throw new PriorityTooLowException(i3, this.highestPriority);
            }
        }
    }

    public void remove(int i3) {
        int intValue;
        synchronized (this.lock) {
            this.queue.remove(Integer.valueOf(i3));
            if (this.queue.isEmpty()) {
                intValue = Integer.MIN_VALUE;
            } else {
                intValue = this.queue.peek().intValue();
            }
            this.highestPriority = intValue;
            this.lock.notifyAll();
        }
    }
}
