package kotlinx.coroutines;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.time.Duration;
import kotlin.time.ExperimentalTime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0005\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u001a\u0019\u0010\u0000\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u001a!\u0010\u0000\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0087@\u00f8\u0001\u0000\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000b\u001a\u0019\u0010\u000f\u001a\u00020\n*\u00020\rH\u0001\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0012"}, d2 = {"delay", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "awaitCancellation", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "duration", "Lkotlin/time/Duration;", "delay-VtjQ1oo", "toDelayMillis", "toDelayMillis-LRDsOJo", "(J)J", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class DelayKt {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitCancellation(@NotNull Continuation<?> continuation) {
        DelayKt$awaitCancellation$1 delayKt$awaitCancellation$1;
        Object coroutine_suspended;
        int i3;
        Continuation intercepted;
        Object coroutine_suspended2;
        if (continuation instanceof DelayKt$awaitCancellation$1) {
            delayKt$awaitCancellation$1 = (DelayKt$awaitCancellation$1) continuation;
            int i16 = delayKt$awaitCancellation$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                delayKt$awaitCancellation$1.label = i16 - Integer.MIN_VALUE;
                Object obj = delayKt$awaitCancellation$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = delayKt$awaitCancellation$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    delayKt$awaitCancellation$1.label = 1;
                    intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(delayKt$awaitCancellation$1);
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
                    cancellableContinuationImpl.initCancellability();
                    Object result = cancellableContinuationImpl.getResult();
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (result == coroutine_suspended2) {
                        DebugProbes.probeCoroutineSuspended(delayKt$awaitCancellation$1);
                    }
                    if (result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                throw new KotlinNothingValueException();
            }
        }
        delayKt$awaitCancellation$1 = new DelayKt$awaitCancellation$1(continuation);
        Object obj2 = delayKt$awaitCancellation$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = delayKt$awaitCancellation$1.label;
        if (i3 == 0) {
        }
        throw new KotlinNothingValueException();
    }

    @Nullable
    public static final Object delay(long j3, @NotNull Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        if (j3 > 0) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            if (j3 < Long.MAX_VALUE) {
                getDelay(cancellableContinuationImpl.get$context()).mo2048scheduleResumeAfterDelay(j3, cancellableContinuationImpl);
            }
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended2) {
                return result;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @ExperimentalTime
    @Nullable
    /* renamed from: delay-VtjQ1oo, reason: not valid java name */
    public static final Object m1988delayVtjQ1oo(long j3, @NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object delay = delay(m1989toDelayMillisLRDsOJo(j3), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (delay == coroutine_suspended) {
            return delay;
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public static final Delay getDelay(@NotNull CoroutineContext coroutineContext) {
        Delay delay;
        CoroutineContext.Element element = coroutineContext.get(ContinuationInterceptor.INSTANCE);
        if (element instanceof Delay) {
            delay = (Delay) element;
        } else {
            delay = null;
        }
        if (delay == null) {
            return DefaultExecutorKt.getDefaultDelay();
        }
        return delay;
    }

    @ExperimentalTime
    /* renamed from: toDelayMillis-LRDsOJo, reason: not valid java name */
    public static final long m1989toDelayMillisLRDsOJo(long j3) {
        long coerceAtLeast;
        if (Duration.m1825compareToLRDsOJo(j3, Duration.INSTANCE.m1928getZEROUwyO8pc()) > 0) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(Duration.m1873toLongMillisecondsimpl(j3), 1L);
            return coerceAtLeast;
        }
        return 0L;
    }
}
