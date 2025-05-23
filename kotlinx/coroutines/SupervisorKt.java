package kotlinx.coroutines;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007\u00a2\u0006\u0002\b\u0000\u001aM\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b\u00a2\u0006\u0002\b\fH\u0086@\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"SupervisorJob", "Lkotlinx/coroutines/CompletableJob;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lkotlinx/coroutines/Job;", "SupervisorJob0", "supervisorScope", BdhLogUtil.LogTag.Tag_Req, "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class SupervisorKt {
    @NotNull
    public static final CompletableJob SupervisorJob(@Nullable Job job) {
        return new SupervisorJobImpl(job);
    }

    public static /* synthetic */ CompletableJob SupervisorJob$default(Job job, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            job = null;
        }
        return SupervisorJob(job);
    }

    @Nullable
    public static final <R> Object supervisorScope(@NotNull Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation) {
        Object coroutine_suspended;
        SupervisorCoroutine supervisorCoroutine = new SupervisorCoroutine(continuation.get$context(), continuation);
        Object startUndispatchedOrReturn = UndispatchedKt.startUndispatchedOrReturn(supervisorCoroutine, supervisorCoroutine, function2);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (startUndispatchedOrReturn == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return startUndispatchedOrReturn;
    }

    /* renamed from: SupervisorJob$default */
    public static /* synthetic */ Job m1995SupervisorJob$default(Job job, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            job = null;
        }
        return SupervisorJob(job);
    }
}
