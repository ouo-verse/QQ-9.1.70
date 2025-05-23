package kotlinx.coroutines.intrinsics;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u001a\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0082\b\u001a>\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u001aR\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u0002*\u001e\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b2\u0006\u0010\f\u001a\u0002H\n2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u001a>\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u001aR\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u0002*\u001e\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b2\u0006\u0010\f\u001a\u0002H\n2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\r\u001aY\u0010\u000f\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\f\u001a\u0002H\n2'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b\u00a2\u0006\u0002\b\u0011H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012\u001aY\u0010\u0013\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\f\u001a\u0002H\n2'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b\u00a2\u0006\u0002\b\u0011H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012\u001a?\u0010\u0014\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00062\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0019H\u0082\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"startDirect", "", "T", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function1;", "", "startCoroutineUndispatched", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "startCoroutineUnintercepted", "startUndispatchedOrReturn", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "undispatchedResult", "shouldThrow", "", "", "startBlock", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class UndispatchedKt {
    public static final <T> void startCoroutineUndispatched(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Object coroutine_suspended;
        Continuation probeCoroutineCreated = DebugProbes.probeCoroutineCreated(continuation);
        try {
            CoroutineContext coroutineContext = continuation.get$context();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext, null);
            try {
                if (function1 != null) {
                    Object invoke = ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(probeCoroutineCreated);
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (invoke != coroutine_suspended) {
                        probeCoroutineCreated.resumeWith(Result.m476constructorimpl(invoke));
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            } finally {
                ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
            }
        } catch (Throwable th5) {
            Result.Companion companion = Result.INSTANCE;
            probeCoroutineCreated.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(th5)));
        }
    }

    public static final <T> void startCoroutineUnintercepted(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Object coroutine_suspended;
        Continuation probeCoroutineCreated = DebugProbes.probeCoroutineCreated(continuation);
        try {
            if (function1 != null) {
                Object invoke = ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(probeCoroutineCreated);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (invoke != coroutine_suspended) {
                    probeCoroutineCreated.resumeWith(Result.m476constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th5) {
            Result.Companion companion = Result.INSTANCE;
            probeCoroutineCreated.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(th5)));
        }
    }

    private static final <T> void startDirect(Continuation<? super T> continuation, Function1<? super Continuation<? super T>, ? extends Object> function1) {
        Object coroutine_suspended;
        Continuation probeCoroutineCreated = DebugProbes.probeCoroutineCreated(continuation);
        try {
            Object invoke = function1.invoke(probeCoroutineCreated);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (invoke != coroutine_suspended) {
                probeCoroutineCreated.resumeWith(Result.m476constructorimpl(invoke));
            }
        } catch (Throwable th5) {
            Result.Companion companion = Result.INSTANCE;
            probeCoroutineCreated.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(th5)));
        }
    }

    @Nullable
    public static final <T, R> Object startUndispatchedOrReturn(@NotNull ScopeCoroutine<? super T> scopeCoroutine, R r16, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object completedExceptionally;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        Object coroutine_suspended3;
        try {
        } catch (Throwable th5) {
            completedExceptionally = new CompletedExceptionally(th5, false, 2, null);
        }
        if (function2 != null) {
            completedExceptionally = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r16, scopeCoroutine);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (completedExceptionally == coroutine_suspended) {
                coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return coroutine_suspended3;
            }
            Object makeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally);
            if (makeCompletingOnce$kotlinx_coroutines_core == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return coroutine_suspended2;
            }
            if (!(makeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                return JobSupportKt.unboxState(makeCompletingOnce$kotlinx_coroutines_core);
            }
            throw ((CompletedExceptionally) makeCompletingOnce$kotlinx_coroutines_core).cause;
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    @Nullable
    public static final <T, R> Object startUndispatchedOrReturnIgnoreTimeout(@NotNull ScopeCoroutine<? super T> scopeCoroutine, R r16, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object completedExceptionally;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        Object coroutine_suspended3;
        boolean z16 = false;
        try {
        } catch (Throwable th5) {
            completedExceptionally = new CompletedExceptionally(th5, false, 2, null);
        }
        if (function2 != null) {
            completedExceptionally = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r16, scopeCoroutine);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (completedExceptionally == coroutine_suspended) {
                coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return coroutine_suspended3;
            }
            Object makeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally);
            if (makeCompletingOnce$kotlinx_coroutines_core == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return coroutine_suspended2;
            }
            if (makeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                Throwable th6 = ((CompletedExceptionally) makeCompletingOnce$kotlinx_coroutines_core).cause;
                if (!(th6 instanceof TimeoutCancellationException) || ((TimeoutCancellationException) th6).coroutine != scopeCoroutine) {
                    z16 = true;
                }
                if (!z16) {
                    if (completedExceptionally instanceof CompletedExceptionally) {
                        throw ((CompletedExceptionally) completedExceptionally).cause;
                    }
                } else {
                    throw th6;
                }
            } else {
                completedExceptionally = JobSupportKt.unboxState(makeCompletingOnce$kotlinx_coroutines_core);
            }
            return completedExceptionally;
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    private static final <T> Object undispatchedResult(ScopeCoroutine<? super T> scopeCoroutine, Function1<? super Throwable, Boolean> function1, Function0<? extends Object> function0) {
        Object completedExceptionally;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        Object coroutine_suspended3;
        try {
            completedExceptionally = function0.invoke();
        } catch (Throwable th5) {
            completedExceptionally = new CompletedExceptionally(th5, false, 2, null);
        }
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (completedExceptionally == coroutine_suspended) {
            coroutine_suspended3 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return coroutine_suspended3;
        }
        Object makeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally);
        if (makeCompletingOnce$kotlinx_coroutines_core == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return coroutine_suspended2;
        }
        if (makeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            CompletedExceptionally completedExceptionally2 = (CompletedExceptionally) makeCompletingOnce$kotlinx_coroutines_core;
            if (!function1.invoke(completedExceptionally2.cause).booleanValue()) {
                if (completedExceptionally instanceof CompletedExceptionally) {
                    throw ((CompletedExceptionally) completedExceptionally).cause;
                }
                return completedExceptionally;
            }
            throw completedExceptionally2.cause;
        }
        return JobSupportKt.unboxState(makeCompletingOnce$kotlinx_coroutines_core);
    }

    public static final <R, T> void startCoroutineUnintercepted(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r16, @NotNull Continuation<? super T> continuation) {
        Object coroutine_suspended;
        Continuation probeCoroutineCreated = DebugProbes.probeCoroutineCreated(continuation);
        try {
            if (function2 != null) {
                Object invoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r16, probeCoroutineCreated);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (invoke != coroutine_suspended) {
                    probeCoroutineCreated.resumeWith(Result.m476constructorimpl(invoke));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th5) {
            Result.Companion companion = Result.INSTANCE;
            probeCoroutineCreated.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(th5)));
        }
    }

    public static final <R, T> void startCoroutineUndispatched(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r16, @NotNull Continuation<? super T> continuation) {
        Object coroutine_suspended;
        Continuation probeCoroutineCreated = DebugProbes.probeCoroutineCreated(continuation);
        try {
            CoroutineContext coroutineContext = continuation.get$context();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext, null);
            try {
                if (function2 != null) {
                    Object invoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r16, probeCoroutineCreated);
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (invoke != coroutine_suspended) {
                        probeCoroutineCreated.resumeWith(Result.m476constructorimpl(invoke));
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            } finally {
                ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
            }
        } catch (Throwable th5) {
            Result.Companion companion = Result.INSTANCE;
            probeCoroutineCreated.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(th5)));
        }
    }
}
