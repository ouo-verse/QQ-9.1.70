package com.tencent.richframework.argus.page.db;

import com.tencent.biz.richframework.delegate.util.RFWConfigExtKt;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.richframework.thread.defend.RFWExceptionHandler;
import com.tencent.richframework.thread.factory.RFWThreadFactory;
import com.tencent.richframework.thread.pool.RFWThreadPool;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fBG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/richframework/argus/page/db/ArgusDbThreadPool;", "Lcom/tencent/richframework/thread/pool/RFWThreadPool;", "corePoolSize", "", "maximumPoolSize", "keepAliveTime", "", "unit", "Ljava/util/concurrent/TimeUnit;", "workQueue", "Ljava/util/concurrent/BlockingQueue;", "Ljava/lang/Runnable;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V", "Companion", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class ArgusDbThreadPool extends RFWThreadPool {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ExecutorService instance = new ArgusDbThreadPool(0, 0, 0, null, null, null, 63, null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/richframework/argus/page/db/ArgusDbThreadPool$Companion;", "", "()V", "BLOCKING_QUEUE_SIZE", "", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Ljava/util/concurrent/ExecutorService;", "getInstance", "()Ljava/util/concurrent/ExecutorService;", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final ExecutorService getInstance() {
            return ArgusDbThreadPool.instance;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        if (RFWConfigExtKt.isInnerVerOrRemoteCfgEnabled("ARGUS_ANDROID_O_DB_FIX")) {
            RFWExceptionHandler.INSTANCE.registerExceptionDefender(new CursorWindowAllocationExceptionDefender());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ArgusDbThreadPool(int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(r14, i16, (i17 & 4) != 0 ? 2L : j3, (i17 & 8) != 0 ? TimeUnit.MINUTES : timeUnit, (i17 & 16) != 0 ? new LinkedBlockingQueue(1024) : blockingQueue, (i17 & 32) != 0 ? new RFWThreadFactory("ArgusDb") : threadFactory);
        int coerceAtLeast;
        int i18 = (i17 & 1) != 0 ? 2 : i3;
        if ((i17 & 2) != 0) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(2, RFWThreadPool.DEFAULT_MAX_POOL_SIZE);
            i16 = coerceAtLeast * 2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArgusDbThreadPool(int i3, int i16, long j3, @NotNull TimeUnit unit, @NotNull BlockingQueue<Runnable> workQueue, @NotNull ThreadFactory threadFactory) {
        super(i3, i16, j3, unit, workQueue, threadFactory);
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(workQueue, "workQueue");
        Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
    }
}
