package kotlinx.coroutines;

import com.tribe.async.log.SLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aU\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t\u00a2\u0006\u0002\b\rH\u0086@\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0002\u0010\u000e\u001a[\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0010\"\u0004\b\u0000\u0010\u0005*\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t\u00a2\u0006\u0002\b\r\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013\u001aF\u0010\u0014\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\u00020\u00152)\b\b\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t\u00a2\u0006\u0002\b\rH\u0086J\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016\u001aO\u0010\u0017\u001a\u00020\u0018*\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t\u00a2\u0006\u0002\b\r\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"RESUMED", "", DebugCoroutineInfoImplKt.SUSPENDED, "UNDECIDED", "withContext", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", SLog.LOG_TAG, "Lkotlinx/coroutines/Deferred;", "start", "Lkotlinx/coroutines/CoroutineStart;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "invoke", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launch", "Lkotlinx/coroutines/Job;", "", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "kotlinx/coroutines/BuildersKt")
/* loaded from: classes28.dex */
public final /* synthetic */ class BuildersKt__Builders_commonKt {
    private static final int RESUMED = 2;
    private static final int SUSPENDED = 1;
    private static final int UNDECIDED = 0;

    @NotNull
    public static final <T> Deferred<T> async(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, @NotNull CoroutineStart coroutineStart, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        DeferredCoroutine deferredCoroutine;
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
        if (coroutineStart.isLazy()) {
            deferredCoroutine = new LazyDeferredCoroutine(newCoroutineContext, function2);
        } else {
            deferredCoroutine = new DeferredCoroutine(newCoroutineContext, true);
        }
        ((AbstractCoroutine) deferredCoroutine).start(coroutineStart, deferredCoroutine, function2);
        return (Deferred<T>) deferredCoroutine;
    }

    public static /* synthetic */ Deferred async$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i3 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.async(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    @Nullable
    public static final <T> Object invoke(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return BuildersKt.withContext(coroutineDispatcher, function2, continuation);
    }

    private static final <T> Object invoke$$forInline(CoroutineDispatcher coroutineDispatcher, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(coroutineDispatcher, function2, continuation);
        InlineMarker.mark(1);
        return withContext;
    }

    @NotNull
    public static final Job launch(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, @NotNull CoroutineStart coroutineStart, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        AbstractCoroutine standaloneCoroutine;
        CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
        if (coroutineStart.isLazy()) {
            standaloneCoroutine = new LazyStandaloneCoroutine(newCoroutineContext, function2);
        } else {
            standaloneCoroutine = new StandaloneCoroutine(newCoroutineContext, true);
        }
        standaloneCoroutine.start(coroutineStart, standaloneCoroutine, function2);
        return standaloneCoroutine;
    }

    public static /* synthetic */ Job launch$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i3 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return BuildersKt.launch(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    @Nullable
    public static final <T> Object withContext(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        Object result;
        Object coroutine_suspended;
        CoroutineContext coroutineContext2 = continuation.get$context();
        CoroutineContext plus = coroutineContext2.plus(coroutineContext);
        JobKt.ensureActive(plus);
        if (plus == coroutineContext2) {
            ScopeCoroutine scopeCoroutine = new ScopeCoroutine(plus, continuation);
            result = UndispatchedKt.startUndispatchedOrReturn(scopeCoroutine, scopeCoroutine, function2);
        } else {
            ContinuationInterceptor.Companion companion = ContinuationInterceptor.INSTANCE;
            if (Intrinsics.areEqual(plus.get(companion), coroutineContext2.get(companion))) {
                UndispatchedCoroutine undispatchedCoroutine = new UndispatchedCoroutine(plus, continuation);
                Object updateThreadContext = ThreadContextKt.updateThreadContext(plus, null);
                try {
                    Object startUndispatchedOrReturn = UndispatchedKt.startUndispatchedOrReturn(undispatchedCoroutine, undispatchedCoroutine, function2);
                    ThreadContextKt.restoreThreadContext(plus, updateThreadContext);
                    result = startUndispatchedOrReturn;
                } catch (Throwable th5) {
                    ThreadContextKt.restoreThreadContext(plus, updateThreadContext);
                    throw th5;
                }
            } else {
                DispatchedCoroutine dispatchedCoroutine = new DispatchedCoroutine(plus, continuation);
                CancellableKt.startCoroutineCancellable$default(function2, dispatchedCoroutine, dispatchedCoroutine, null, 4, null);
                result = dispatchedCoroutine.getResult();
            }
        }
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
