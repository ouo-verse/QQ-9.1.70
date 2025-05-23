package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class Pools {

    /* loaded from: classes.dex */
    public interface Pool<T> {
        @Nullable
        T acquire();

        boolean release(@NonNull T t16);
    }

    /* loaded from: classes.dex */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int i3) {
            if (i3 > 0) {
                this.mPool = new Object[i3];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean isInPool(@NonNull T t16) {
            for (int i3 = 0; i3 < this.mPoolSize; i3++) {
                if (this.mPool[i3] == t16) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            int i3 = this.mPoolSize;
            if (i3 <= 0) {
                return null;
            }
            int i16 = i3 - 1;
            Object[] objArr = this.mPool;
            T t16 = (T) objArr[i16];
            objArr[i16] = null;
            this.mPoolSize = i3 - 1;
            return t16;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t16) {
            if (!isInPool(t16)) {
                int i3 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i3 < objArr.length) {
                    objArr[i3] = t16;
                    this.mPoolSize = i3 + 1;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    /* loaded from: classes.dex */
    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object mLock;

        public SynchronizedPool(int i3) {
            super(i3);
            this.mLock = new Object();
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public T acquire() {
            T t16;
            synchronized (this.mLock) {
                t16 = (T) super.acquire();
            }
            return t16;
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t16) {
            boolean release;
            synchronized (this.mLock) {
                release = super.release(t16);
            }
            return release;
        }
    }

    Pools() {
    }
}
