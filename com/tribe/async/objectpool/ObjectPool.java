package com.tribe.async.objectpool;

import com.tribe.async.log.SLog;
import com.tribe.async.utils.MonotonicClock;
import java.lang.reflect.Array;

/* loaded from: classes27.dex */
public class ObjectPool<T> {
    private static final String TAG = "async.ObjectPool";
    private final Allocator<T> mAllocator;
    private final Class<T> mClazz;
    private final MonotonicClock mClock;
    private final long mCompactionDelayMs;
    private final int mIncrementSize;
    private long mLastLowSupplyTimeMs;
    private final int mMaxSize;
    private final int mMinSize;
    private T[] mPool;
    private int mSize;

    /* loaded from: classes27.dex */
    public interface Allocator<T> {
        T create();

        void onAllocate(T t16);

        void onRelease(T t16);
    }

    public ObjectPool(Class<T> cls, int i3, int i16, int i17, long j3, Allocator<T> allocator, MonotonicClock monotonicClock) {
        this.mClazz = cls;
        int max = Math.max(i3, 0);
        this.mMinSize = max;
        this.mMaxSize = Math.max(max, i16);
        this.mIncrementSize = Math.max(i17, 1);
        this.mCompactionDelayMs = j3;
        this.mAllocator = allocator;
        this.mClock = monotonicClock;
        this.mPool = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, max));
    }

    private void resizePool(int i3) {
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mClazz, i3));
        T[] tArr2 = this.mPool;
        System.arraycopy(tArr2, 0, tArr, 0, Math.min(tArr2.length, i3));
        this.mPool = tArr;
        this.mSize = Math.min(this.mSize, i3);
    }

    public synchronized T allocate() {
        T create;
        int i3 = this.mSize;
        if (i3 > 0) {
            int i16 = i3 - 1;
            this.mSize = i16;
            T[] tArr = this.mPool;
            create = tArr[i16];
            tArr[i16] = null;
        } else {
            create = this.mAllocator.create();
        }
        this.mAllocator.onAllocate(create);
        return create;
    }

    public synchronized void checkUsage() {
        long now = this.mClock.now();
        if (this.mSize < this.mIncrementSize * 2) {
            this.mLastLowSupplyTimeMs = now;
        }
        if (now - this.mLastLowSupplyTimeMs > this.mCompactionDelayMs) {
            SLog.d(TAG, "ObjectPool.checkUsage is compacting the pool.");
            compactUsage();
        }
    }

    public synchronized void compactUsage() {
        int max = Math.max(this.mPool.length - this.mIncrementSize, this.mMinSize);
        if (max != this.mPool.length) {
            resizePool(max);
        }
    }

    public long getCompactionDelayMs() {
        return this.mCompactionDelayMs;
    }

    public int getIncrementSize() {
        return this.mIncrementSize;
    }

    public int getMaximumSize() {
        return this.mMaxSize;
    }

    public int getMinimumSize() {
        return this.mMinSize;
    }

    public int getPoolSize() {
        return this.mPool.length;
    }

    public int getPooledObjectCount() {
        return this.mSize;
    }

    public synchronized void release(T t16) {
        checkUsage();
        this.mAllocator.onRelease(t16);
        int i3 = this.mSize;
        int i16 = this.mMaxSize;
        if (i3 < i16) {
            int i17 = i3 + 1;
            T[] tArr = this.mPool;
            if (i17 > tArr.length) {
                resizePool(Math.min(i16, tArr.length + this.mIncrementSize));
            }
            T[] tArr2 = this.mPool;
            int i18 = this.mSize;
            this.mSize = i18 + 1;
            tArr2[i18] = t16;
        }
    }

    /* loaded from: classes27.dex */
    public static class BasicAllocator<T> implements Allocator<T> {
        Class<T> mClazz;

        public BasicAllocator(Class<T> cls) {
            this.mClazz = cls;
        }

        @Override // com.tribe.async.objectpool.ObjectPool.Allocator
        public T create() {
            try {
                return this.mClazz.newInstance();
            } catch (IllegalAccessException e16) {
                SLog.e(ObjectPool.TAG, "Couldn't instantiate object", e16);
                return null;
            } catch (InstantiationException e17) {
                SLog.e(ObjectPool.TAG, "Couldn't instantiate object", e17);
                return null;
            }
        }

        @Override // com.tribe.async.objectpool.ObjectPool.Allocator
        public void onAllocate(T t16) {
        }

        @Override // com.tribe.async.objectpool.ObjectPool.Allocator
        public void onRelease(T t16) {
        }
    }
}
