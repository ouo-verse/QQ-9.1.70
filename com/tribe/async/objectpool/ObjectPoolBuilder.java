package com.tribe.async.objectpool;

import android.support.annotation.Nullable;
import com.tribe.async.objectpool.ObjectPool;
import com.tribe.async.utils.MonotonicClock;

/* loaded from: classes27.dex */
public class ObjectPoolBuilder<T> {
    public static final long DEFAULT_COMPACTION_DELAY_MS = 60000;
    public static final int DEFAULT_INCREMENT_SIZE = 16;
    public static final int DEFAULT_MAX_SIZE = 1024;
    public static final int DEFAULT_MIN_SIZE = 16;
    private ObjectPool.Allocator<T> mAllocator;
    private Class<T> mClazz;
    private MonotonicClock mClock;
    private long mCompactionDelayMs;
    private int mIncrementSize;
    private final ObjectPoolManager mManager;
    private int mMaxSize;
    private int mMinSize;

    public ObjectPoolBuilder(Class<T> cls, MonotonicClock monotonicClock) {
        this(null, cls, monotonicClock);
    }

    public ObjectPool<T> build() {
        if (this.mClock != null) {
            ObjectPool.Allocator allocator = this.mAllocator;
            if (allocator == null) {
                allocator = new ObjectPool.BasicAllocator(this.mClazz);
            }
            ObjectPool<T> objectPool = new ObjectPool<>(this.mClazz, this.mMinSize, this.mMaxSize, this.mIncrementSize, this.mCompactionDelayMs, allocator, this.mClock);
            ObjectPoolManager objectPoolManager = this.mManager;
            if (objectPoolManager != null) {
                objectPoolManager.addPool(this.mClazz, objectPool);
            }
            return objectPool;
        }
        throw new IllegalArgumentException("Must add a clock to the object pool builder");
    }

    public ObjectPool.Allocator<T> getAllocator() {
        return this.mAllocator;
    }

    public MonotonicClock getClock() {
        return this.mClock;
    }

    public long getCompactionDelay() {
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

    public ObjectPoolBuilder<T> setAllocator(ObjectPool.Allocator<T> allocator) {
        this.mAllocator = allocator;
        return this;
    }

    public ObjectPoolBuilder<T> setClock(MonotonicClock monotonicClock) {
        this.mClock = monotonicClock;
        return this;
    }

    public ObjectPoolBuilder<T> setCompactionDelay(long j3) {
        this.mCompactionDelayMs = j3;
        return this;
    }

    public ObjectPoolBuilder<T> setIncrementSize(int i3) {
        this.mIncrementSize = i3;
        return this;
    }

    public ObjectPoolBuilder<T> setMaximumSize(int i3) {
        this.mMaxSize = i3;
        return this;
    }

    public ObjectPoolBuilder<T> setMinimumSize(int i3) {
        this.mMinSize = i3;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectPoolBuilder(@Nullable ObjectPoolManager objectPoolManager, Class<T> cls, MonotonicClock monotonicClock) {
        this.mMinSize = 16;
        this.mMaxSize = 1024;
        this.mIncrementSize = 16;
        this.mCompactionDelayMs = 60000L;
        this.mManager = objectPoolManager;
        this.mClazz = cls;
        this.mClock = monotonicClock;
    }
}
