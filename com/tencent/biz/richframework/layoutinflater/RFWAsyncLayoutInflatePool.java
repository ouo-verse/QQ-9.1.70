package com.tencent.biz.richframework.layoutinflater;

import com.tencent.richframework.thread.factory.RFWThreadFactory;
import com.tencent.richframework.thread.pool.RFWThreadPool;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fBG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/RFWAsyncLayoutInflatePool;", "Lcom/tencent/richframework/thread/pool/RFWThreadPool;", "corePoolSize", "", "maximumPoolSize", "keepAliveTime", "", "unit", "Ljava/util/concurrent/TimeUnit;", "workQueue", "Ljava/util/concurrent/BlockingQueue;", "Ljava/lang/Runnable;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V", "Companion", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class RFWAsyncLayoutInflatePool extends RFWThreadPool {
    public RFWAsyncLayoutInflatePool() {
        this(0, 0, 0L, null, null, null, 63, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ RFWAsyncLayoutInflatePool(int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(r14, i16, (i17 & 4) != 0 ? 2L : j3, (i17 & 8) != 0 ? TimeUnit.MINUTES : timeUnit, (i17 & 16) != 0 ? new LinkedBlockingQueue(256) : blockingQueue, (i17 & 32) != 0 ? new RFWThreadFactory("RFW_AsyncInflate") : threadFactory);
        int coerceAtLeast;
        int i18 = (i17 & 1) != 0 ? 3 : i3;
        if ((i17 & 2) != 0) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(3, RFWThreadPool.DEFAULT_MAX_POOL_SIZE);
            i16 = coerceAtLeast * 2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWAsyncLayoutInflatePool(int i3, int i16, long j3, @NotNull TimeUnit unit, @NotNull BlockingQueue<Runnable> workQueue, @NotNull ThreadFactory threadFactory) {
        super(i3, i16, j3, unit, workQueue, threadFactory);
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(workQueue, "workQueue");
        Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
    }
}
