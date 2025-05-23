package com.tribe.async.dispatch;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.objectpool.ObjectPool;
import com.tribe.async.objectpool.ObjectPoolBuilder;
import com.tribe.async.utils.AssertUtils;
import com.tribe.async.utils.MonotonicClock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes27.dex */
public final class PendingPost {
    private static final ObjectPool<PendingPost> PENDING_POST_POOL;
    public Dispatcher.Dispatchable dispatchable;
    public String group;
    public PendingPost next;
    public Object tag;

    static {
        ObjectPoolBuilder objectPoolBuilder = new ObjectPoolBuilder(PendingPost.class, new MonotonicClock() { // from class: com.tribe.async.dispatch.PendingPost.1
            @Override // com.tribe.async.utils.MonotonicClock
            public long now() {
                return SystemClock.uptimeMillis();
            }
        });
        objectPoolBuilder.setAllocator(new ObjectPool.BasicAllocator<PendingPost>(PendingPost.class) { // from class: com.tribe.async.dispatch.PendingPost.2
            @Override // com.tribe.async.objectpool.ObjectPool.BasicAllocator, com.tribe.async.objectpool.ObjectPool.Allocator
            public PendingPost create() {
                return new PendingPost();
            }
        });
        PENDING_POST_POOL = objectPoolBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PendingPost obtainPendingPost(Object obj, String str, Dispatcher.Dispatchable dispatchable) {
        AssertUtils.checkNotNull(obj);
        AssertUtils.checkNotNull(str);
        AssertUtils.checkNotNull(dispatchable);
        PendingPost allocate = PENDING_POST_POOL.allocate();
        allocate.dispatchable = dispatchable;
        allocate.group = str;
        allocate.tag = obj;
        allocate.next = null;
        return allocate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void releasePendingPost(PendingPost pendingPost) {
        AssertUtils.checkNotNull(pendingPost);
        pendingPost.dispatchable = null;
        pendingPost.group = null;
        pendingPost.tag = null;
        pendingPost.next = null;
        PENDING_POST_POOL.release(pendingPost);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PendingPost)) {
            return false;
        }
        PendingPost pendingPost = (PendingPost) obj;
        if (!pendingPost.dispatchable.equals(this.dispatchable) || !TextUtils.equals(this.group, pendingPost.group) || !pendingPost.tag.equals(this.tag)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Dispatcher.Dispatchable dispatchable = this.dispatchable;
        if (dispatchable == null) {
            return 0;
        }
        return dispatchable.hashCode();
    }

    PendingPost() {
    }
}
