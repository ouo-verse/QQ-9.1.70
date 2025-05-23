package com.tencent.qqmusic.mediaplayer;

import androidx.annotation.NonNull;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DataRangeTracker {
    private static final long LOCK_INTERVAL = 1000;
    private static final String TAG = "DataRangeTracker";
    private long waitingPosition;
    private int waitingSize;
    private final ArrayList<Range> mDownloadDataList = new ArrayList<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private long mFileTotalSize = 0;
    private boolean isUpstreamSizeSet = false;
    private Comparator<Range> mComparator = new Comparator<Range>() { // from class: com.tencent.qqmusic.mediaplayer.DataRangeTracker.1
        @Override // java.util.Comparator
        public int compare(Range range, Range range2) {
            return (int) (range.first - range2.first);
        }
    };

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface LockJudgerCallback {
        boolean isToAbandonLock();
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Range {
        private final long first;
        private final long second;

        @NonNull
        public String toString() {
            return "[" + this.first + ", " + this.second + ']';
        }

        Range(long j3, long j16) {
            this.first = j3;
            this.second = j16;
        }
    }

    private void lockRead() {
        this.lock.readLock().lock();
    }

    private synchronized void unlock() {
        Logger.i(TAG, "[unlock].");
        notifyAll();
    }

    private void unlockRead() {
        this.lock.readLock().unlock();
    }

    public void abandonLock() {
        Logger.i(TAG, "[abandonLock]");
        unblock();
        unlock();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00d0, code lost:
    
        if (isCached(r2, r0) != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addRange(long j3, long j16, boolean z16) {
        boolean z17 = true;
        if (j3 > j16) {
            Logger.e(TAG, "[addRange] illegal arguments! beginPos(%s) > endPos(%s)", Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        this.lock.writeLock().lock();
        try {
            ArrayList arrayList = new ArrayList();
            this.mDownloadDataList.add(new Range(j3, j16));
            Collections.sort(this.mDownloadDataList, this.mComparator);
            int size = this.mDownloadDataList.size() - 1;
            Range range = this.mDownloadDataList.get(0);
            if (size > 0) {
                for (int i3 = 1; i3 <= size; i3++) {
                    Range range2 = this.mDownloadDataList.get(i3);
                    if (range.second + 1 < range2.first) {
                        arrayList.add(new Range(range.first, range.second));
                        range = new Range(range2.first, range2.second);
                    } else {
                        range = new Range(range.first, Math.max(range.second, range2.second));
                    }
                    if (i3 >= size) {
                        arrayList.add(range);
                    }
                }
                this.mDownloadDataList.clear();
                this.mDownloadDataList.addAll(arrayList);
            }
            long j17 = this.waitingPosition;
            if (j17 >= 0 && (r0 = this.waitingSize) > 0) {
            }
            z17 = false;
            if (z17) {
                Logger.i(TAG, "[addRange] notify position: " + this.waitingPosition + ", size: " + this.waitingSize);
                synchronized (this) {
                    if (z16) {
                        unlock();
                    }
                    this.waitingPosition = 0L;
                    this.waitingSize = 0;
                }
            }
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public void block() {
        Logger.i(TAG, "[block]");
    }

    public long findEnd(long j3) {
        int i3;
        lockRead();
        try {
            int size = this.mDownloadDataList.size();
            if (size == 0) {
                unlockRead();
                return -1L;
            }
            for (int i16 = 0; i16 < size; i16++) {
                if (j3 < this.mDownloadDataList.get(i16).first) {
                    return this.mDownloadDataList.get(i16).first - 1;
                }
                if (j3 <= this.mDownloadDataList.get(i16).second && (i3 = i16 + 1) < size) {
                    return this.mDownloadDataList.get(i3).first - 1;
                }
            }
            unlockRead();
            return 0L;
        } finally {
            unlockRead();
        }
    }

    public long findStart(long j3) {
        lockRead();
        try {
            int size = this.mDownloadDataList.size();
            if (size == 0) {
                unlockRead();
                return -1L;
            }
            long j16 = this.mDownloadDataList.get(0).second + 1;
            for (int i3 = 0; i3 < size; i3++) {
                if (j3 < this.mDownloadDataList.get(i3).first) {
                    return j16;
                }
                j16 = this.mDownloadDataList.get(i3).second + 1;
                if (j3 <= this.mDownloadDataList.get(i3).second) {
                    return this.mDownloadDataList.get(i3).second + 1;
                }
            }
            return this.mDownloadDataList.get(r10.size() - 1).second + 1;
        } finally {
            unlockRead();
        }
    }

    public long getContinuousEnd() {
        lockRead();
        try {
            if (this.mDownloadDataList.size() != 0) {
                return this.mDownloadDataList.get(0).second;
            }
            unlockRead();
            return -1L;
        } finally {
            unlockRead();
        }
    }

    public long getContinuousStart() {
        lockRead();
        try {
            if (this.mDownloadDataList.size() != 0) {
                return this.mDownloadDataList.get(0).first;
            }
            unlockRead();
            return -1L;
        } finally {
            unlockRead();
        }
    }

    public boolean isCached(long j3, int i3) {
        lockRead();
        try {
            long findStart = findStart(j3);
            long j16 = i3 + j3;
            long findStart2 = findStart(j16);
            long findEnd = findEnd(j3);
            long findEnd2 = findEnd(j16);
            boolean z16 = false;
            if (findStart != findStart2 || findEnd != findEnd2) {
                return false;
            }
            if (findEnd == -1) {
                return false;
            }
            long j17 = this.mFileTotalSize;
            if (j17 > 0 && j16 > j17) {
                j16 = j17;
            }
            if (j16 <= findStart) {
                z16 = true;
            }
            return z16;
        } finally {
            unlockRead();
        }
    }

    public synchronized boolean lock(long j3, int i3, long j16, LockJudgerCallback lockJudgerCallback) throws InterruptedException {
        Logger.i(TAG, "[lock] position = [" + j3 + "]. size = [" + i3 + "]. timeout = [" + j16 + "].");
        this.waitingPosition = j3;
        this.waitingSize = i3;
        int i16 = (int) (j16 / 1000);
        if (i16 <= 0) {
            i16 = 1;
        }
        int i17 = 0;
        while (true) {
            if (i17 >= i16) {
                break;
            }
            wait(1000L);
            if (lockJudgerCallback != null && lockJudgerCallback.isToAbandonLock()) {
                Logger.i(TAG, "lockJudgerCallback.isToAbandonLock() is true, exit the wait loop");
                break;
            }
            if (isCached(this.waitingPosition, this.waitingSize)) {
                Logger.i(TAG, "isCached(waitingPosition, waitingSize) is true, exit the wait loop, wawaitingPosition = " + this.waitingPosition + ", waitingSize = " + this.waitingSize);
                break;
            }
            Logger.i(TAG, "continue [lock] position = [" + j3 + "]. size = [" + i3 + "]. totalSize = [" + this.mFileTotalSize + "]. findStart(position) = [" + findStart(j3) + "]. i = " + i17);
            i17++;
        }
        return true;
    }

    public void setFileTotalSize(long j3, boolean z16) {
        if (j3 > 0 && this.mFileTotalSize != j3) {
            Logger.i(TAG, "setFileTotalSize mFileTotalSize = " + this.mFileTotalSize + " isUpstreamSizeSet = " + this.isUpstreamSizeSet + " fileTotalSize = " + j3 + " isUpstreamSize = " + z16);
            if (this.isUpstreamSizeSet) {
                if (z16) {
                    this.mFileTotalSize = j3;
                }
            } else {
                this.mFileTotalSize = j3;
                this.isUpstreamSizeSet = z16;
            }
        }
    }

    public void unblock() {
        Logger.i(TAG, "[unblock]");
    }
}
