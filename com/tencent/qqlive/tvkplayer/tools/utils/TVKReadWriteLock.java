package com.tencent.qqlive.tvkplayer.tools.utils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKReadWriteLock extends ReentrantReadWriteLock {
    private static final String TAG = "TVKPlayer[TVKReadWriteLock]";
    private final Condition mWriteLockCond = writeLock().newCondition();

    public boolean readTryLock(long j3) throws InterruptedException {
        int i3 = 3;
        while (true) {
            i3--;
            if (i3 >= 0) {
                try {
                    return readLock().tryLock(j3, TimeUnit.MICROSECONDS);
                } catch (InterruptedException e16) {
                    TVKLogUtil.e(TAG, e16);
                }
            } else {
                throw new InterruptedException("tryLock interrupted.");
            }
        }
    }

    public void writeLockCondSignal() {
        this.mWriteLockCond.signal();
    }

    public void writeLockCondSignalAll() {
        this.mWriteLockCond.signalAll();
    }

    public boolean writeLockCondWait(long j3) {
        int i3 = 3;
        while (true) {
            i3--;
            if (i3 >= 0) {
                try {
                    return this.mWriteLockCond.await(j3, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e16) {
                    TVKLogUtil.e(TAG, e16);
                }
            } else {
                return false;
            }
        }
    }

    public boolean writeTryLock(long j3) throws InterruptedException {
        int i3 = 3;
        while (true) {
            i3--;
            if (i3 >= 0) {
                try {
                    return writeLock().tryLock(j3, TimeUnit.MICROSECONDS);
                } catch (InterruptedException e16) {
                    TVKLogUtil.e(TAG, e16);
                }
            } else {
                throw new InterruptedException("tryLock interrupted.");
            }
        }
    }
}
