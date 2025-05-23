package com.tencent.rdelivery.reshub.util;

import android.os.Handler;
import android.os.Looper;
import com.tencent.raft.standard.task.IRTask;
import com.tencent.rdelivery.reshub.core.ResLoadRequestPriority;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\nJ&\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\nR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0014\u001a\u00020\u00118FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u000e\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/rdelivery/reshub/util/ThreadUtil;", "", "Ljava/lang/Runnable;", "runnable", "", "e", "", "name", "Lcom/tencent/rdelivery/reshub/core/ResLoadRequestPriority;", "priority", "Lkotlin/Function0;", "b", "d", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "handler", "Ljava/util/concurrent/ExecutorService;", "Lkotlin/Lazy;", "()Ljava/util/concurrent/ExecutorService;", "executorService", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class ThreadUtil {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy executorService;

    /* renamed from: c, reason: collision with root package name */
    public static final ThreadUtil f364593c = new ThreadUtil();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Handler handler = new Handler(Looper.getMainLooper());

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ExecutorService>() { // from class: com.tencent.rdelivery.reshub.util.ThreadUtil$executorService$2
            @Override // kotlin.jvm.functions.Function0
            public final ExecutorService invoke() {
                return ProxyExecutors.newCachedThreadPool();
            }
        });
        executorService = lazy;
    }

    ThreadUtil() {
    }

    public static /* synthetic */ void c(ThreadUtil threadUtil, String str, ResLoadRequestPriority resLoadRequestPriority, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            resLoadRequestPriority = ResLoadRequestPriority.Normal;
        }
        threadUtil.b(str, resLoadRequestPriority, function0);
    }

    @NotNull
    public final ExecutorService a() {
        return (ExecutorService) executorService.getValue();
    }

    public final void b(@NotNull String name, @NotNull ResLoadRequestPriority priority, @NotNull Function0<Unit> runnable) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(priority, "priority");
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        com.tencent.rdelivery.reshub.core.j.L.K().startTask(IRTask.TaskType.SIMPLE_TASK, RTaskUtilKt.a(runnable, name, RTaskUtilKt.b(priority)));
    }

    public final void d(@NotNull String name, @NotNull ResLoadRequestPriority priority, @NotNull Function0<Unit> runnable) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(priority, "priority");
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        com.tencent.rdelivery.reshub.core.j.L.K().startTask(IRTask.TaskType.NETWORK_TASK, RTaskUtilKt.a(runnable, name, RTaskUtilKt.b(priority)));
    }

    public final void e(@NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }
}
