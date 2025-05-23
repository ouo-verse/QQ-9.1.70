package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u00a2\u0006\u0002\b\u0003\u001a\u0011\u0010\u0000\u001a\u00020\u0004*\u00020\u0005H\u0007\u00a2\u0006\u0002\b\u0003\u001a\n\u0010\u0006\u001a\u00020\u0002*\u00020\u0001\u00a8\u0006\u0007"}, d2 = {"asCoroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "from", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Ljava/util/concurrent/ExecutorService;", "asExecutor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class ExecutorsKt {
    @NotNull
    public static final Executor asExecutor(@NotNull CoroutineDispatcher coroutineDispatcher) {
        ExecutorCoroutineDispatcher executorCoroutineDispatcher;
        if (coroutineDispatcher instanceof ExecutorCoroutineDispatcher) {
            executorCoroutineDispatcher = (ExecutorCoroutineDispatcher) coroutineDispatcher;
        } else {
            executorCoroutineDispatcher = null;
        }
        if (executorCoroutineDispatcher == null) {
            return new DispatcherExecutor(coroutineDispatcher);
        }
        return executorCoroutineDispatcher.getExecutor();
    }

    @JvmName(name = "from")
    @NotNull
    public static final ExecutorCoroutineDispatcher from(@NotNull ExecutorService executorService) {
        return new ExecutorCoroutineDispatcherImpl(executorService);
    }

    @JvmName(name = "from")
    @NotNull
    public static final CoroutineDispatcher from(@NotNull Executor executor) {
        DispatcherExecutor dispatcherExecutor = executor instanceof DispatcherExecutor ? (DispatcherExecutor) executor : null;
        CoroutineDispatcher coroutineDispatcher = dispatcherExecutor != null ? dispatcherExecutor.dispatcher : null;
        return coroutineDispatcher == null ? new ExecutorCoroutineDispatcherImpl(executor) : coroutineDispatcher;
    }
}
