package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.time.ExperimentalTime;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a_\u0010\u0006\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\b\"\b\b\u0001\u0010\t*\u0002H\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\n2'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u00a2\u0006\u0002\b\u000fH\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u001aU\u0010\u0011\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0012\u001a\u00020\u00032'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u00a2\u0006\u0002\b\u000fH\u0086@\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0002\u0010\u0013\u001a]\u0010\u0011\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0014\u001a\u00020\u00152'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u00a2\u0006\u0002\b\u000fH\u0087@\u00f8\u0001\u0000\u00f8\u0001\u0000\u00f8\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00a2\u0006\u0004\b\u0016\u0010\u0013\u001aJ\u0010\u0017\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0012\u001a\u00020\u00032'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u00a2\u0006\u0002\b\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013\u001aR\u0010\u0017\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0014\u001a\u00020\u00152'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f\u00a2\u0006\u0002\b\u000fH\u0087@\u00f8\u0001\u0000\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0013\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0019"}, d2 = {"TimeoutCancellationException", "Lkotlinx/coroutines/TimeoutCancellationException;", "time", "", "coroutine", "Lkotlinx/coroutines/Job;", "setupTimeout", "", "U", "T", "Lkotlinx/coroutines/TimeoutCoroutine;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/TimeoutCoroutine;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "withTimeout", "timeMillis", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timeout", "Lkotlin/time/Duration;", "withTimeout-KLykuaI", "withTimeoutOrNull", "withTimeoutOrNull-KLykuaI", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class TimeoutKt {
    @NotNull
    public static final TimeoutCancellationException TimeoutCancellationException(long j3, @NotNull Job job) {
        return new TimeoutCancellationException("Timed out waiting for " + j3 + " ms", job);
    }

    private static final <U, T extends U> Object setupTimeout(TimeoutCoroutine<U, ? super T> timeoutCoroutine, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        JobKt.disposeOnCompletion(timeoutCoroutine, DelayKt.getDelay(timeoutCoroutine.uCont.get$context()).invokeOnTimeout(timeoutCoroutine.time, timeoutCoroutine, timeoutCoroutine.get$context()));
        return UndispatchedKt.startUndispatchedOrReturnIgnoreTimeout(timeoutCoroutine, timeoutCoroutine, function2);
    }

    @Nullable
    public static final <T> Object withTimeout(long j3, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        Object coroutine_suspended;
        if (j3 > 0) {
            Object obj = setupTimeout(new TimeoutCoroutine(j3, continuation), function2);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (obj == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return obj;
        }
        throw new TimeoutCancellationException("Timed out immediately");
    }

    @ExperimentalTime
    @Nullable
    /* renamed from: withTimeout-KLykuaI, reason: not valid java name */
    public static final <T> Object m1997withTimeoutKLykuaI(long j3, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return withTimeout(DelayKt.m1989toDelayMillisLRDsOJo(j3), function2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.TimeoutCoroutine, T] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object withTimeoutOrNull(long j3, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        TimeoutKt$withTimeoutOrNull$1 timeoutKt$withTimeoutOrNull$1;
        Object coroutine_suspended;
        int i3;
        Ref.ObjectRef objectRef;
        Object coroutine_suspended2;
        if (continuation instanceof TimeoutKt$withTimeoutOrNull$1) {
            timeoutKt$withTimeoutOrNull$1 = (TimeoutKt$withTimeoutOrNull$1) continuation;
            int i16 = timeoutKt$withTimeoutOrNull$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                timeoutKt$withTimeoutOrNull$1.label = i16 - Integer.MIN_VALUE;
                Object obj = timeoutKt$withTimeoutOrNull$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = timeoutKt$withTimeoutOrNull$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        objectRef = (Ref.ObjectRef) timeoutKt$withTimeoutOrNull$1.L$1;
                        try {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        } catch (TimeoutCancellationException e16) {
                            e = e16;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (j3 <= 0) {
                        return null;
                    }
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    try {
                        timeoutKt$withTimeoutOrNull$1.L$0 = function2;
                        timeoutKt$withTimeoutOrNull$1.L$1 = objectRef2;
                        timeoutKt$withTimeoutOrNull$1.J$0 = j3;
                        timeoutKt$withTimeoutOrNull$1.label = 1;
                        ?? r26 = (T) new TimeoutCoroutine(j3, timeoutKt$withTimeoutOrNull$1);
                        objectRef2.element = r26;
                        Object obj2 = setupTimeout(r26, function2);
                        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (obj2 == coroutine_suspended2) {
                            DebugProbes.probeCoroutineSuspended(timeoutKt$withTimeoutOrNull$1);
                        }
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return obj2;
                    } catch (TimeoutCancellationException e17) {
                        e = e17;
                        objectRef = objectRef2;
                    }
                }
                if (e.coroutine != objectRef.element) {
                    return null;
                }
                throw e;
            }
        }
        timeoutKt$withTimeoutOrNull$1 = new TimeoutKt$withTimeoutOrNull$1(continuation);
        Object obj3 = timeoutKt$withTimeoutOrNull$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = timeoutKt$withTimeoutOrNull$1.label;
        if (i3 == 0) {
        }
        if (e.coroutine != objectRef.element) {
        }
    }

    @ExperimentalTime
    @Nullable
    /* renamed from: withTimeoutOrNull-KLykuaI, reason: not valid java name */
    public static final <T> Object m1998withTimeoutOrNullKLykuaI(long j3, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return withTimeoutOrNull(DelayKt.m1989toDelayMillisLRDsOJo(j3), function2, continuation);
    }
}
