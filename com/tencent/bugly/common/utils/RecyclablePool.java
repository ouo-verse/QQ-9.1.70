package com.tencent.bugly.common.utils;

import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u001d\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0006J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/bugly/common/utils/RecyclablePool;", "", "clz", "Ljava/lang/Class;", "Lcom/tencent/bugly/common/utils/RecyclablePool$Recyclable;", "cap", "", "(Ljava/lang/Class;I)V", "capacity", "count", "Ljava/util/concurrent/atomic/AtomicInteger;", "obtainCount", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "Ljava/util/concurrent/ConcurrentLinkedQueue;", "recycleCount", "getObtainCount", "getRecycleCount", "obtain", "recycle", "", "recyclableObject", "Companion", "Recyclable", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class RecyclablePool {

    @NotNull
    public static final String TAG = "Bugly_RPool";
    private final int capacity;
    private AtomicInteger count;
    private AtomicInteger obtainCount;
    private final ConcurrentLinkedQueue<Recyclable> queue;
    private AtomicInteger recycleCount;

    public RecyclablePool(@NotNull Class<? extends Recyclable> clz, int i3) {
        Intrinsics.checkParameterIsNotNull(clz, "clz");
        this.queue = new ConcurrentLinkedQueue<>();
        this.capacity = i3;
        this.count = new AtomicInteger();
        this.obtainCount = new AtomicInteger();
        this.recycleCount = new AtomicInteger();
        for (int i16 = 0; i16 < i3; i16++) {
            try {
                recycle(clz.newInstance());
            } catch (Throwable th5) {
                Logger.f365497g.e(TAG, "init " + th5);
            }
        }
    }

    public final int getObtainCount() {
        return this.obtainCount.get();
    }

    public final int getRecycleCount() {
        return this.recycleCount.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Recyclable obtain(@NotNull Class<? extends Recyclable> clz) {
        Recyclable recyclable;
        Intrinsics.checkParameterIsNotNull(clz, "clz");
        this.obtainCount.incrementAndGet();
        if (!this.queue.isEmpty()) {
            recyclable = this.queue.poll();
            if (recyclable != null) {
                this.count.decrementAndGet();
                if (recyclable.getIsInPool()) {
                    recyclable.outPool();
                } else {
                    Logger.f365497g.e(TAG, "recyclable object not in pool");
                }
            }
            if (recyclable == null) {
                return recyclable;
            }
            try {
                return clz.newInstance();
            } catch (Throwable th5) {
                Logger.f365497g.e(TAG, "" + th5);
                return null;
            }
        }
        recyclable = null;
        if (recyclable == null) {
        }
    }

    public final void recycle(@Nullable Recyclable recyclableObject) {
        this.recycleCount.incrementAndGet();
        if (recyclableObject != null) {
            if (recyclableObject.getIsInPool()) {
                Logger.f365497g.e(TAG, "recyclable object already in pool");
                return;
            }
            recyclableObject.reset();
            if (this.count.get() < this.capacity && this.queue.offer(recyclableObject)) {
                this.count.incrementAndGet();
                recyclableObject.inPool();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/bugly/common/utils/RecyclablePool$Recyclable;", "", "()V", "isInPool", "", "inPool", "", "outPool", "reset", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public static class Recyclable {
        private boolean isInPool;

        public final void inPool() {
            this.isInPool = true;
        }

        /* renamed from: isInPool, reason: from getter */
        public final boolean getIsInPool() {
            return this.isInPool;
        }

        public final void outPool() {
            this.isInPool = false;
        }

        public void reset() {
        }
    }
}
