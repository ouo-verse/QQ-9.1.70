package kotlinx.coroutines.flow;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.raft.codegenmeta.utils.RLog;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ah\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012B\u0010\u0003\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004\u00a2\u0006\u0002\b\r\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u001a1\u0010\u000f\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0080@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u001a\u0019\u0010\u0012\u001a\u00020\u0013*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u00a2\u0006\u0002\b\u0016\u001a\u001b\u0010\u0017\u001a\u00020\u0013*\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0002\b\u0019\u001aB\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u001dH\u0007\u001a>\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u001dH\u0007\u001ac\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020!23\b\u0002\u0010\u001c\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\"\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#\u001a}\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012W\u0010\u001c\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110!\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\f0%\u00a2\u0006\u0002\b\r\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010'*\\\b\u0007\u0010(\"\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u001d2\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u001dB6\b)\u0012\n\b*\u0012\u0006\b\n0+8,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u001c\b/\u0012\u0018\b\u000bB\u0014\b0\u0012\u0006\b1\u0012\u0002\b\f\u0012\b\b2\u0012\u0004\b\b(3\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00064"}, d2 = {"catch", "Lkotlinx/coroutines/flow/Flow;", "T", "action", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/ParameterName;", "name", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "catchImpl", "collector", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCancellationCause", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "isCancellationCause$FlowKt__ErrorsKt", "isSameExceptionAs", "other", "isSameExceptionAs$FlowKt__ErrorsKt", "onErrorCollect", AdMetricTag.FALLBACK, "predicate", "Lkotlin/Function1;", TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, "retries", "", "", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/Flow;JLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "retryWhen", "Lkotlin/Function4;", "attempt", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "ExceptionPredicate", "Lkotlin/Deprecated;", "level", "Lkotlin/DeprecationLevel;", RLog.ERROR, "message", "Use (Throwable) -> Boolean functional type", "replaceWith", "Lkotlin/ReplaceWith;", Constants.Raft.IMPORTS, "expression", "(Throwable) -> Boolean", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes28.dex */
public final /* synthetic */ class FlowKt__ErrorsKt {
    @NotNull
    /* renamed from: catch */
    public static final <T> Flow<T> m2033catch(@NotNull Flow<? extends T> flow, @NotNull Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(flow, function3);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object catchImpl(@NotNull Flow<? extends T> flow, @NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Throwable> continuation) {
        FlowKt__ErrorsKt$catchImpl$1 flowKt__ErrorsKt$catchImpl$1;
        Object coroutine_suspended;
        int i3;
        Ref.ObjectRef objectRef;
        if (continuation instanceof FlowKt__ErrorsKt$catchImpl$1) {
            flowKt__ErrorsKt$catchImpl$1 = (FlowKt__ErrorsKt$catchImpl$1) continuation;
            int i16 = flowKt__ErrorsKt$catchImpl$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                flowKt__ErrorsKt$catchImpl$1.label = i16 - Integer.MIN_VALUE;
                Object obj = flowKt__ErrorsKt$catchImpl$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = flowKt__ErrorsKt$catchImpl$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        objectRef = (Ref.ObjectRef) flowKt__ErrorsKt$catchImpl$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            return null;
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    try {
                        FlowCollector<? super Object> flowKt__ErrorsKt$catchImpl$$inlined$collect$1 = new FlowKt__ErrorsKt$catchImpl$$inlined$collect$1<>(flowCollector, objectRef2);
                        flowKt__ErrorsKt$catchImpl$1.L$0 = objectRef2;
                        flowKt__ErrorsKt$catchImpl$1.label = 1;
                        if (flow.collect(flowKt__ErrorsKt$catchImpl$$inlined$collect$1, flowKt__ErrorsKt$catchImpl$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return null;
                    } catch (Throwable th6) {
                        th = th6;
                        objectRef = objectRef2;
                    }
                }
                if (isSameExceptionAs$FlowKt__ErrorsKt(th, (Throwable) objectRef.element) && !isCancellationCause$FlowKt__ErrorsKt(th, flowKt__ErrorsKt$catchImpl$1.get$context())) {
                    return th;
                }
                throw th;
            }
        }
        flowKt__ErrorsKt$catchImpl$1 = new FlowKt__ErrorsKt$catchImpl$1(continuation);
        Object obj2 = flowKt__ErrorsKt$catchImpl$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = flowKt__ErrorsKt$catchImpl$1.label;
        if (i3 == 0) {
        }
        if (isSameExceptionAs$FlowKt__ErrorsKt(th, (Throwable) objectRef.element)) {
        }
        throw th;
    }

    private static final boolean isCancellationCause$FlowKt__ErrorsKt(Throwable th5, CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job != null && job.isCancelled()) {
            return isSameExceptionAs$FlowKt__ErrorsKt(th5, job.getCancellationException());
        }
        return false;
    }

    private static final boolean isSameExceptionAs$FlowKt__ErrorsKt(Throwable th5, Throwable th6) {
        if (th6 != null && Intrinsics.areEqual(th6, th5)) {
            return true;
        }
        return false;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", imports = {}))
    @NotNull
    public static final <T> Flow<T> onErrorCollect(@NotNull Flow<? extends T> flow, @NotNull Flow<? extends T> flow2, @NotNull Function1<? super Throwable, Boolean> function1) {
        return FlowKt.m2026catch(flow, new FlowKt__ErrorsKt$onErrorCollect$2(function1, flow2, null));
    }

    public static /* synthetic */ Flow onErrorCollect$default(Flow flow, Flow flow2, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = new Function1<Throwable, Boolean>() { // from class: kotlinx.coroutines.flow.FlowKt__ErrorsKt$onErrorCollect$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(@NotNull Throwable th5) {
                    return true;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Throwable th5) {
                    return Boolean.valueOf(invoke2(th5));
                }
            };
        }
        return FlowKt.onErrorCollect(flow, flow2, function1);
    }

    @NotNull
    public static final <T> Flow<T> retry(@NotNull Flow<? extends T> flow, long j3, @NotNull Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        if (j3 > 0) {
            return FlowKt.retryWhen(flow, new FlowKt__ErrorsKt$retry$3(j3, function2, null));
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Expected positive amount of retries, but had ", Long.valueOf(j3)).toString());
    }

    public static /* synthetic */ Flow retry$default(Flow flow, long j3, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = Long.MAX_VALUE;
        }
        if ((i3 & 2) != 0) {
            function2 = new FlowKt__ErrorsKt$retry$1(null);
        }
        return FlowKt.retry(flow, j3, (Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object>) function2);
    }

    @NotNull
    public static final <T> Flow<T> retryWhen(@NotNull Flow<? extends T> flow, @NotNull Function4<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> function4) {
        return new FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(flow, function4);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "binary compatibility with retries: Int preview version")
    @FlowPreview
    public static final /* synthetic */ Flow retry(Flow flow, int i3, Function1 function1) {
        if (i3 > 0) {
            return FlowKt.retryWhen(flow, new FlowKt__ErrorsKt$retry$6(function1, i3, null));
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Expected positive amount of retries, but had ", Integer.valueOf(i3)).toString());
    }

    public static /* synthetic */ Flow retry$default(Flow flow, int i3, Function1 function1, int i16, Object obj) {
        Flow retry;
        if ((i16 & 1) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        if ((i16 & 2) != 0) {
            function1 = new Function1<Throwable, Boolean>() { // from class: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(@NotNull Throwable th5) {
                    return true;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(Throwable th5) {
                    return Boolean.valueOf(invoke2(th5));
                }
            };
        }
        retry = retry(flow, i3, function1);
        return retry;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use (Throwable) -> Boolean functional type", replaceWith = @ReplaceWith(expression = "(Throwable) -> Boolean", imports = {}))
    public static /* synthetic */ void ExceptionPredicate$annotations() {
    }
}
