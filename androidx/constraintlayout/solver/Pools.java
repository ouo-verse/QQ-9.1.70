package androidx.constraintlayout.solver;

/* loaded from: classes.dex */
final class Pools {
    private static final boolean DEBUG = false;

    /* loaded from: classes.dex */
    interface Pool<T> {
        T acquire();

        boolean release(T t16);

        void releaseAll(T[] tArr, int i3);
    }

    /* loaded from: classes.dex */
    static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SimplePool(int i3) {
            if (i3 > 0) {
                this.mPool = new Object[i3];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean isInPool(T t16) {
            for (int i3 = 0; i3 < this.mPoolSize; i3++) {
                if (this.mPool[i3] == t16) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.constraintlayout.solver.Pools.Pool
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

        @Override // androidx.constraintlayout.solver.Pools.Pool
        public boolean release(T t16) {
            int i3 = this.mPoolSize;
            Object[] objArr = this.mPool;
            if (i3 < objArr.length) {
                objArr[i3] = t16;
                this.mPoolSize = i3 + 1;
                return true;
            }
            return false;
        }

        @Override // androidx.constraintlayout.solver.Pools.Pool
        public void releaseAll(T[] tArr, int i3) {
            if (i3 > tArr.length) {
                i3 = tArr.length;
            }
            for (int i16 = 0; i16 < i3; i16++) {
                T t16 = tArr[i16];
                int i17 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i17 < objArr.length) {
                    objArr[i17] = t16;
                    this.mPoolSize = i17 + 1;
                }
            }
        }
    }

    Pools() {
    }
}
