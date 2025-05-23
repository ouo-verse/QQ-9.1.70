package com.tencent.mobileqq.zplan.manager;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadPoolParams;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/manager/ZPlanThreadManager;", "", "Ljava/lang/Runnable;", "runnable", "", "b", "", "delay", "c", "Ljava/util/concurrent/Executor;", "Ljava/util/concurrent/Executor;", "executor", "<init>", "()V", "WrapperRunnable", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanThreadManager {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanThreadManager f333874a = new ZPlanThreadManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Executor executor;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0001\u00a2\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/manager/ZPlanThreadManager$WrapperRunnable;", "Ljava/lang/Runnable;", "Lmqq/util/WeakReference;", "d", "Lmqq/util/WeakReference;", "e", "()Lmqq/util/WeakReference;", "innerRunnable", "task", "<init>", "(Ljava/lang/Runnable;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static abstract class WrapperRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<Runnable> innerRunnable;

        public WrapperRunnable(Runnable task) {
            Intrinsics.checkNotNullParameter(task, "task");
            this.innerRunnable = new WeakReference<>(task);
        }

        public final WeakReference<Runnable> e() {
            return this.innerRunnable;
        }
    }

    static {
        int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        ThreadPoolParams threadPoolParams = new ThreadPoolParams();
        threadPoolParams.poolThreadName = "ZPlanPool";
        threadPoolParams.corePoolsize = 5;
        threadPoolParams.maxPooolSize = Math.max(5, availableProcessors);
        threadPoolParams.priority = 5;
        Executor newFreeThreadPool = ThreadManagerV2.newFreeThreadPool(threadPoolParams);
        Intrinsics.checkNotNullExpressionValue(newFreeThreadPool, "newFreeThreadPool(params)");
        executor = newFreeThreadPool;
    }

    ZPlanThreadManager() {
    }

    public final void b(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        executor.execute(runnable);
    }

    public final void c(final Runnable runnable, long delay) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ThreadManagerV2.executeDelay(new WrapperRunnable(runnable) { // from class: com.tencent.mobileqq.zplan.manager.ZPlanThreadManager$executeDelay$wrapRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                Executor executor2;
                if (e().get() != null) {
                    executor2 = ZPlanThreadManager.executor;
                    executor2.execute(e().get());
                }
            }
        }, 16, null, false, delay);
    }
}
