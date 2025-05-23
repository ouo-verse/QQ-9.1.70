package com.tribe.async.objectpool;

import com.tribe.async.utils.MonotonicClock;
import java.util.HashMap;

/* loaded from: classes27.dex */
public class ObjectPoolManager {
    private final MonotonicClock mClock;
    private final HashMap<Class, ObjectPool> mObjectPools = new HashMap<>();

    public ObjectPoolManager(MonotonicClock monotonicClock) {
        this.mClock = monotonicClock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> void addPool(Class<T> cls, ObjectPool<T> objectPool) {
        this.mObjectPools.put(cls, objectPool);
    }

    public <T> T allocate(Class<T> cls) {
        ObjectPool<T> pool = getPool(cls);
        if (pool != null) {
            return pool.allocate();
        }
        return null;
    }

    public <T> ObjectPoolBuilder<T> createPoolBuilder(Class<T> cls) {
        return new ObjectPoolBuilder<>(this, cls, this.mClock);
    }

    public <T> ObjectPool<T> getPool(Class<T> cls) {
        return this.mObjectPools.get(cls);
    }

    public <T> void release(Class<T> cls, T t16) {
        ObjectPool<T> pool = getPool(cls);
        if (pool != null) {
            pool.release(t16);
        }
    }
}
