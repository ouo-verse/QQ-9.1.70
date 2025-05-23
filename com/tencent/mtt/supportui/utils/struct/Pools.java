package com.tencent.mtt.supportui.utils.struct;

import com.tencent.mtt.hippy.utils.LogUtils;

/* loaded from: classes21.dex */
public final class Pools {

    /* loaded from: classes21.dex */
    public interface Pool<T> {
        T acquire();

        boolean release(T t16);
    }

    /* loaded from: classes21.dex */
    public static class SimplePool<T> implements Pool<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Object[] f337729a;

        /* renamed from: b, reason: collision with root package name */
        private int f337730b;

        public SimplePool(int i3) {
            if (i3 > 0) {
                this.f337729a = new Object[i3];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean a(T t16) {
            for (int i3 = 0; i3 < this.f337730b; i3++) {
                if (this.f337729a[i3] == t16) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.tencent.mtt.supportui.utils.struct.Pools.Pool
        public T acquire() {
            int i3 = this.f337730b;
            if (i3 <= 0) {
                return null;
            }
            int i16 = i3 - 1;
            Object[] objArr = this.f337729a;
            T t16 = (T) objArr[i16];
            objArr[i16] = null;
            this.f337730b = i3 - 1;
            return t16;
        }

        @Override // com.tencent.mtt.supportui.utils.struct.Pools.Pool
        public boolean release(T t16) {
            if (a(t16)) {
                LogUtils.e("Pools", "Already in the pool!");
                return false;
            }
            int i3 = this.f337730b;
            if (i3 >= 0) {
                Object[] objArr = this.f337729a;
                if (i3 < objArr.length) {
                    objArr[i3] = t16;
                    this.f337730b = i3 + 1;
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes21.dex */
    public static class SynchronizedPool<T> extends SimplePool<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Object f337731a;

        public SynchronizedPool(int i3) {
            super(i3);
            this.f337731a = new Object();
        }

        @Override // com.tencent.mtt.supportui.utils.struct.Pools.SimplePool, com.tencent.mtt.supportui.utils.struct.Pools.Pool
        public T acquire() {
            T t16;
            synchronized (this.f337731a) {
                t16 = (T) super.acquire();
            }
            return t16;
        }

        @Override // com.tencent.mtt.supportui.utils.struct.Pools.SimplePool, com.tencent.mtt.supportui.utils.struct.Pools.Pool
        public boolean release(T t16) {
            boolean release;
            synchronized (this.f337731a) {
                release = super.release(t16);
            }
            return release;
        }
    }
}
