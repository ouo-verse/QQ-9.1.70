package com.tencent.thumbplayer.core.drm.reuse;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.core.utils.TPNativeLog;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes26.dex */
public class TPDoubleQueueCachedPool<T> {
    private static final int DEFAULT_CORE_POOL_SIZE = 2;
    private static final String TAG = "[PlayerCore][TPDoubleQueueCachedPool]";
    private final int mCorePoolSize;
    private ITPObjectLifecycleMgr<T> mObjectLifecycleMgr;
    private final List<T> mIdleCacheList = new ArrayList();
    private final List<T> mBusyCacheList = new ArrayList();

    /* loaded from: classes26.dex */
    interface ITPObjectLifecycleMgr<T> {
        @Nullable
        T create(TPDoubleQueueCachedPool<T> tPDoubleQueueCachedPool);

        void release(TPDoubleQueueCachedPool<T> tPDoubleQueueCachedPool, @NonNull T t16);

        boolean reset(TPDoubleQueueCachedPool<T> tPDoubleQueueCachedPool, @NonNull T t16);
    }

    public TPDoubleQueueCachedPool(int i3, int i16, @NonNull ITPObjectLifecycleMgr<T> iTPObjectLifecycleMgr) {
        this.mCorePoolSize = i16 <= 0 ? 2 : i16;
        i3 = i3 <= 0 ? 2 : i3;
        this.mObjectLifecycleMgr = iTPObjectLifecycleMgr;
        for (int i17 = 0; i17 < i3; i17++) {
            T create = iTPObjectLifecycleMgr.create(this);
            if (create == null) {
                TPNativeLog.printLog(1, TAG, "TPDoubleQueueCachedPool, createObject failed.");
            } else {
                this.mIdleCacheList.add(create);
            }
        }
        TPNativeLog.printLog(2, TAG, "TPDoubleQueueCachedPool init size:" + this.mIdleCacheList.size());
    }

    @Nullable
    public synchronized T allocObject() {
        T remove;
        if (this.mIdleCacheList.isEmpty()) {
            remove = this.mObjectLifecycleMgr.create(this);
            if (remove == null) {
                return null;
            }
        } else {
            remove = this.mIdleCacheList.remove(0);
        }
        this.mBusyCacheList.add(remove);
        return remove;
    }

    public synchronized void freeObject(@NonNull T t16) {
        this.mBusyCacheList.remove(t16);
        this.mObjectLifecycleMgr.release(this, t16);
    }

    public synchronized void recycleObject(@NonNull T t16) {
        if (this.mBusyCacheList.remove(t16) && this.mIdleCacheList.size() < this.mCorePoolSize && this.mObjectLifecycleMgr.reset(this, t16)) {
            this.mIdleCacheList.add(t16);
        } else {
            this.mObjectLifecycleMgr.release(this, t16);
        }
    }

    public synchronized void release() {
        ListIterator<T> listIterator = this.mBusyCacheList.listIterator();
        while (listIterator.hasNext()) {
            this.mObjectLifecycleMgr.release(this, listIterator.next());
            listIterator.remove();
        }
        ListIterator<T> listIterator2 = this.mIdleCacheList.listIterator();
        while (listIterator2.hasNext()) {
            this.mObjectLifecycleMgr.release(this, listIterator2.next());
            listIterator2.remove();
        }
        this.mObjectLifecycleMgr = null;
    }
}
