package kotlinx.coroutines;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u001a\u0019\u0010\b\u001a\u00020\t2\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0087\b\u001a\u0012\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u001a\u0019\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007\u00a2\u0006\u0002\b\r\u001a\f\u0010\u0011\u001a\u00020\f*\u00020\u0002H\u0007\u001a\u0018\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007\u001a\u001c\u0010\u0011\u001a\u00020\f*\u00020\u00022\u0010\b\u0002\u0010\u0012\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015\u001a\u001e\u0010\u0011\u001a\u00020\f*\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u001a\u0015\u0010\u0018\u001a\u00020\f*\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019\u001a\f\u0010\u001a\u001a\u00020\f*\u00020\u0002H\u0007\u001a\u0018\u0010\u001a\u001a\u00020\f*\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007\u001a\u001c\u0010\u001a\u001a\u00020\f*\u00020\u00022\u0010\b\u0002\u0010\u0012\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015\u001a\f\u0010\u001a\u001a\u00020\f*\u00020\u0005H\u0007\u001a\u0018\u0010\u001a\u001a\u00020\f*\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007\u001a\u001c\u0010\u001a\u001a\u00020\f*\u00020\u00052\u0010\b\u0002\u0010\u0012\u001a\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015\u001a\u0014\u0010\u001b\u001a\u00020\t*\u00020\u00052\u0006\u0010\u001c\u001a\u00020\tH\u0000\u001a\n\u0010\u001d\u001a\u00020\f*\u00020\u0002\u001a\n\u0010\u001d\u001a\u00020\f*\u00020\u0005\u001a\u001b\u0010\u001e\u001a\u00020\u0013*\u0004\u0018\u00010\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u00a2\u0006\u0002\b\u001f\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"isActive", "", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)Z", "job", "Lkotlinx/coroutines/Job;", "getJob", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Job;", "DisposableHandle", "Lkotlinx/coroutines/DisposableHandle;", "block", "Lkotlin/Function0;", "", "Job", "Lkotlinx/coroutines/CompletableJob;", HippyNestedScrollComponent.PRIORITY_PARENT, "Job0", "cancel", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "message", "", "cancelAndJoin", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelChildren", "disposeOnCompletion", "handle", "ensureActive", "orCancellation", "orCancellation$JobKt__JobKt", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "kotlinx/coroutines/JobKt")
/* loaded from: classes28.dex */
public final /* synthetic */ class JobKt__JobKt {
    @InternalCoroutinesApi
    @NotNull
    public static final DisposableHandle DisposableHandle(@NotNull final Function0<Unit> function0) {
        return new DisposableHandle() { // from class: kotlinx.coroutines.JobKt__JobKt$DisposableHandle$1
            @Override // kotlinx.coroutines.DisposableHandle
            public void dispose() {
                function0.invoke();
            }
        };
    }

    @NotNull
    public static final CompletableJob Job(@Nullable Job job) {
        return new JobImpl(job);
    }

    public static /* synthetic */ CompletableJob Job$default(Job job, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            job = null;
        }
        return JobKt.Job(job);
    }

    public static final void cancel(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job == null) {
            return;
        }
        job.cancel(cancellationException);
    }

    public static /* synthetic */ void cancel$default(CoroutineContext coroutineContext, CancellationException cancellationException, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancel(coroutineContext, cancellationException);
    }

    @Nullable
    public static final Object cancelAndJoin(@NotNull Job job, @NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        Object join = job.join(continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (join == coroutine_suspended) {
            return join;
        }
        return Unit.INSTANCE;
    }

    public static final void cancelChildren(@NotNull Job job, @Nullable CancellationException cancellationException) {
        Iterator<Job> it = job.getChildren().iterator();
        while (it.hasNext()) {
            it.next().cancel(cancellationException);
        }
    }

    public static /* synthetic */ void cancelChildren$default(Job job, CancellationException cancellationException, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancelChildren(job, cancellationException);
    }

    @NotNull
    public static final DisposableHandle disposeOnCompletion(@NotNull Job job, @NotNull DisposableHandle disposableHandle) {
        return job.invokeOnCompletion(new DisposeOnCompletion(disposableHandle));
    }

    public static final void ensureActive(@NotNull Job job) {
        if (!job.isActive()) {
            throw job.getCancellationException();
        }
    }

    @NotNull
    public static final Job getJob(@NotNull CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job != null) {
            return job;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("Current context doesn't contain Job in it: ", coroutineContext).toString());
    }

    public static final boolean isActive(@NotNull CoroutineContext coroutineContext) {
        Boolean valueOf;
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job == null) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(job.isActive());
        }
        return Intrinsics.areEqual(valueOf, Boolean.TRUE);
    }

    private static final Throwable orCancellation$JobKt__JobKt(Throwable th5, Job job) {
        if (th5 == null) {
            return new JobCancellationException("Job was cancelled", null, job);
        }
        return th5;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    @JvmName(name = "Job")
    /* renamed from: Job */
    public static final /* synthetic */ Job m1992Job(Job job) {
        return JobKt.Job(job);
    }

    /* renamed from: Job$default */
    public static /* synthetic */ Job m1993Job$default(Job job, int i3, Object obj) {
        Job m1992Job;
        if ((i3 & 1) != 0) {
            job = null;
        }
        m1992Job = m1992Job(job);
        return m1992Job;
    }

    public static /* synthetic */ void cancel$default(Job job, String str, Throwable th5, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            th5 = null;
        }
        JobKt.cancel(job, str, th5);
    }

    public static /* synthetic */ void cancelChildren$default(Job job, Throwable th5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            th5 = null;
        }
        cancelChildren(job, th5);
    }

    public static final void ensureActive(@NotNull CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job == null) {
            return;
        }
        JobKt.ensureActive(job);
    }

    public static final void cancel(@NotNull Job job, @NotNull String str, @Nullable Throwable th5) {
        job.cancel(ExceptionsKt.CancellationException(str, th5));
    }

    public static /* synthetic */ boolean cancel$default(CoroutineContext coroutineContext, Throwable th5, int i3, Object obj) {
        boolean cancel;
        if ((i3 & 1) != 0) {
            th5 = null;
        }
        cancel = cancel(coroutineContext, th5);
        return cancel;
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, CancellationException cancellationException, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancelChildren(coroutineContext, cancellationException);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ boolean cancel(CoroutineContext coroutineContext, Throwable th5) {
        CoroutineContext.Element element = coroutineContext.get(Job.INSTANCE);
        JobSupport jobSupport = element instanceof JobSupport ? (JobSupport) element : null;
        if (jobSupport == null) {
            return false;
        }
        jobSupport.cancelInternal(orCancellation$JobKt__JobKt(th5, jobSupport));
        return true;
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, Throwable th5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            th5 = null;
        }
        cancelChildren(coroutineContext, th5);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(Job job, Throwable th5) {
        for (Job job2 : job.getChildren()) {
            JobSupport jobSupport = job2 instanceof JobSupport ? (JobSupport) job2 : null;
            if (jobSupport != null) {
                jobSupport.cancelInternal(orCancellation$JobKt__JobKt(th5, job));
            }
        }
    }

    public static final void cancelChildren(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job == null) {
            return;
        }
        Iterator<Job> it = job.getChildren().iterator();
        while (it.hasNext()) {
            it.next().cancel(cancellationException);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(CoroutineContext coroutineContext, Throwable th5) {
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job == null) {
            return;
        }
        for (Job job2 : job.getChildren()) {
            JobSupport jobSupport = job2 instanceof JobSupport ? (JobSupport) job2 : null;
            if (jobSupport != null) {
                jobSupport.cancelInternal(orCancellation$JobKt__JobKt(th5, job));
            }
        }
    }
}
