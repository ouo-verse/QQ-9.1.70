package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0003"}, d2 = {"yield", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class YieldKt {
    @Nullable
    public static final Object yield(@NotNull Continuation<? super Unit> continuation) {
        Continuation intercepted;
        DispatchedContinuation dispatchedContinuation;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        Object coroutine_suspended3;
        CoroutineContext coroutineContext = continuation.get$context();
        JobKt.ensureActive(coroutineContext);
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        if (intercepted instanceof DispatchedContinuation) {
            dispatchedContinuation = (DispatchedContinuation) intercepted;
        } else {
            dispatchedContinuation = null;
        }
        if (dispatchedContinuation == null) {
            coroutine_suspended = Unit.INSTANCE;
        } else {
            if (dispatchedContinuation.dispatcher.isDispatchNeeded(coroutineContext)) {
                dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(coroutineContext, Unit.INSTANCE);
            } else {
                YieldContext yieldContext = new YieldContext();
                CoroutineContext plus = coroutineContext.plus(yieldContext);
                Unit unit = Unit.INSTANCE;
                dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(plus, unit);
                if (yieldContext.dispatcherWasUnconfined) {
                    coroutine_suspended = DispatchedContinuationKt.yieldUndispatched(dispatchedContinuation) ? IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() : unit;
                }
            }
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == coroutine_suspended2) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == coroutine_suspended3) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
