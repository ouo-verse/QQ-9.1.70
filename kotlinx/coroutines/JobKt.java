package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, k = 4, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class JobKt {
    @InternalCoroutinesApi
    @NotNull
    public static final DisposableHandle DisposableHandle(@NotNull Function0<Unit> function0) {
        return JobKt__JobKt.DisposableHandle(function0);
    }

    @NotNull
    public static final CompletableJob Job(@Nullable Job job) {
        return JobKt__JobKt.Job(job);
    }

    public static /* synthetic */ CompletableJob Job$default(Job job, int i3, Object obj) {
        return JobKt__JobKt.Job$default(job, i3, obj);
    }

    @Nullable
    public static final Object cancelAndJoin(@NotNull Job job, @NotNull Continuation<? super Unit> continuation) {
        return JobKt__JobKt.cancelAndJoin(job, continuation);
    }

    public static final void cancelFutureOnCancellation(@NotNull CancellableContinuation<?> cancellableContinuation, @NotNull Future<?> future) {
        JobKt__FutureKt.cancelFutureOnCancellation(cancellableContinuation, future);
    }

    @InternalCoroutinesApi
    @NotNull
    public static final DisposableHandle cancelFutureOnCompletion(@NotNull Job job, @NotNull Future<?> future) {
        return JobKt__FutureKt.cancelFutureOnCompletion(job, future);
    }

    @NotNull
    public static final DisposableHandle disposeOnCompletion(@NotNull Job job, @NotNull DisposableHandle disposableHandle) {
        return JobKt__JobKt.disposeOnCompletion(job, disposableHandle);
    }

    public static final void ensureActive(@NotNull CoroutineContext coroutineContext) {
        JobKt__JobKt.ensureActive(coroutineContext);
    }

    @NotNull
    public static final Job getJob(@NotNull CoroutineContext coroutineContext) {
        return JobKt__JobKt.getJob(coroutineContext);
    }

    public static final boolean isActive(@NotNull CoroutineContext coroutineContext) {
        return JobKt__JobKt.isActive(coroutineContext);
    }

    public static final void cancel(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        JobKt__JobKt.cancel(coroutineContext, cancellationException);
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, CancellationException cancellationException, int i3, Object obj) {
        JobKt__JobKt.cancelChildren$default(coroutineContext, cancellationException, i3, obj);
    }

    public static final void ensureActive(@NotNull Job job) {
        JobKt__JobKt.ensureActive(job);
    }

    public static final void cancel(@NotNull Job job, @NotNull String str, @Nullable Throwable th5) {
        JobKt__JobKt.cancel(job, str, th5);
    }

    public static final void cancelChildren(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        JobKt__JobKt.cancelChildren(coroutineContext, cancellationException);
    }

    public static final void cancelChildren(@NotNull Job job, @Nullable CancellationException cancellationException) {
        JobKt__JobKt.cancelChildren(job, cancellationException);
    }
}
