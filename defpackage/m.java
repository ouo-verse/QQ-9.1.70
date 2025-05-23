package defpackage;

import com.tencent.richframework.thread.factory.RFWThreadFactory;
import com.tencent.richframework.thread.pool.RFWThreadPool;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lm;", "Lcom/tencent/richframework/thread/pool/RFWThreadPool;", "", "corePoolSize", "maximumPoolSize", "", "keepAliveTime", "Ljava/util/concurrent/TimeUnit;", "unit", "Ljava/util/concurrent/BlockingQueue;", "Ljava/lang/Runnable;", "workQueue", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "<init>", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V", "threadmanager_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class m extends RFWThreadPool {
    public m() {
        this(0, 0, 0L, null, null, null, 63, null);
    }

    public /* synthetic */ m(int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 1 : i3, (i17 & 2) == 0 ? i16 : 1, (i17 & 4) != 0 ? 2L : j3, (i17 & 8) != 0 ? TimeUnit.MINUTES : timeUnit, (i17 & 16) != 0 ? new LinkedBlockingQueue() : blockingQueue, (i17 & 32) != 0 ? new RFWThreadFactory("RFWLog") : threadFactory);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(int i3, int i16, long j3, @NotNull TimeUnit unit, @NotNull BlockingQueue<Runnable> workQueue, @NotNull ThreadFactory threadFactory) {
        super(i3, i16, j3, unit, workQueue, threadFactory);
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(workQueue, "workQueue");
        Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
    }
}
