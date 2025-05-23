package kotlinx.coroutines.flow;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aV\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000323\b\u0004\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005H\u0080H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u001a$\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f\u001aH\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u001a+\u0010\u0012\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00132\u0006\u0010\b\u001a\u0002H\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a$\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f\u001aH\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u001ar\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00190\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0019*\b\u0012\u0004\u0012\u0002H\u00020\u00032D\b\u0001\u0010\u001a\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00190\u0013\u0012\u0013\u0012\u0011H\u0002\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001b\u00a2\u0006\u0002\b\u001cH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"collectWhile", "", "T", "Lkotlinx/coroutines/flow/Flow;", "predicate", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "drop", "count", "", "dropWhile", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "emitAbort", "Lkotlinx/coroutines/flow/FlowCollector;", "emitAbort$FlowKt__LimitKt", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "take", "takeWhile", "transformWhile", BdhLogUtil.LogTag.Tag_Req, "transform", "Lkotlin/Function3;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes28.dex */
public final /* synthetic */ class FlowKt__LimitKt {
    public static final /* synthetic */ Object access$emitAbort(FlowCollector flowCollector, Object obj, Continuation continuation) {
        return emitAbort$FlowKt__LimitKt(flowCollector, obj, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object collectWhile(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        FlowKt__LimitKt$collectWhile$1 flowKt__LimitKt$collectWhile$1;
        Object coroutine_suspended;
        int i3;
        FlowCollector<? super Object> flowCollector;
        if (continuation instanceof FlowKt__LimitKt$collectWhile$1) {
            flowKt__LimitKt$collectWhile$1 = (FlowKt__LimitKt$collectWhile$1) continuation;
            int i16 = flowKt__LimitKt$collectWhile$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                flowKt__LimitKt$collectWhile$1.label = i16 - Integer.MIN_VALUE;
                Object obj = flowKt__LimitKt$collectWhile$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = flowKt__LimitKt$collectWhile$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        flowCollector = (FlowKt__LimitKt$collectWhile$collector$1) flowKt__LimitKt$collectWhile$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (AbortFlowException e16) {
                            e = e16;
                            FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                            return Unit.INSTANCE;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    FlowCollector<? super Object> flowKt__LimitKt$collectWhile$collector$1 = new FlowKt__LimitKt$collectWhile$collector$1<>(function2);
                    try {
                        flowKt__LimitKt$collectWhile$1.L$0 = flowKt__LimitKt$collectWhile$collector$1;
                        flowKt__LimitKt$collectWhile$1.label = 1;
                        if (flow.collect(flowKt__LimitKt$collectWhile$collector$1, flowKt__LimitKt$collectWhile$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (AbortFlowException e17) {
                        e = e17;
                        flowCollector = flowKt__LimitKt$collectWhile$collector$1;
                        FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                        return Unit.INSTANCE;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        flowKt__LimitKt$collectWhile$1 = new FlowKt__LimitKt$collectWhile$1(continuation);
        Object obj2 = flowKt__LimitKt$collectWhile$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = flowKt__LimitKt$collectWhile$1.label;
        if (i3 == 0) {
        }
        return Unit.INSTANCE;
    }

    private static final <T> Object collectWhile$$forInline(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$1 = new FlowKt__LimitKt$collectWhile$collector$1(function2);
        try {
            InlineMarker.mark(0);
            flow.collect(flowKt__LimitKt$collectWhile$collector$1, continuation);
            InlineMarker.mark(1);
        } catch (AbortFlowException e16) {
            FlowExceptions_commonKt.checkOwnership(e16, flowKt__LimitKt$collectWhile$collector$1);
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public static final <T> Flow<T> drop(@NotNull final Flow<? extends T> flow, final int i3) {
        boolean z16;
        if (i3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__LimitKt$drop$$inlined$unsafeFlow$1
                @Override // kotlinx.coroutines.flow.Flow
                @Nullable
                public Object collect(@NotNull final FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
                    Object coroutine_suspended;
                    final Ref.IntRef intRef = new Ref.IntRef();
                    Flow flow2 = Flow.this;
                    final int i16 = i3;
                    Object collect = flow2.collect(new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__LimitKt$drop$lambda-2$$inlined$collect$1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @Nullable
                        public Object emit(T t16, @NotNull Continuation<? super Unit> continuation2) {
                            Object coroutine_suspended2;
                            Ref.IntRef intRef2 = Ref.IntRef.this;
                            int i17 = intRef2.element;
                            if (i17 >= i16) {
                                Object emit = flowCollector.emit(t16, continuation2);
                                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                if (emit == coroutine_suspended2) {
                                    return emit;
                                }
                            } else {
                                intRef2.element = i17 + 1;
                            }
                            return Unit.INSTANCE;
                        }
                    }, continuation);
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }
            };
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Drop count should be non-negative, but had ", Integer.valueOf(i3)).toString());
    }

    @NotNull
    public static final <T> Flow<T> dropWhile(@NotNull final Flow<? extends T> flow, @NotNull final Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new FlowKt__LimitKt$dropWhile$lambda4$$inlined$collect$1(new Ref.BooleanRef(), flowCollector, function2), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object emitAbort$FlowKt__LimitKt(FlowCollector<? super T> flowCollector, T t16, Continuation<? super Unit> continuation) {
        FlowKt__LimitKt$emitAbort$1 flowKt__LimitKt$emitAbort$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof FlowKt__LimitKt$emitAbort$1) {
            flowKt__LimitKt$emitAbort$1 = (FlowKt__LimitKt$emitAbort$1) continuation;
            int i16 = flowKt__LimitKt$emitAbort$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                flowKt__LimitKt$emitAbort$1.label = i16 - Integer.MIN_VALUE;
                Object obj = flowKt__LimitKt$emitAbort$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = flowKt__LimitKt$emitAbort$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    flowCollector = (FlowCollector) flowKt__LimitKt$emitAbort$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    flowKt__LimitKt$emitAbort$1.L$0 = flowCollector;
                    flowKt__LimitKt$emitAbort$1.label = 1;
                    if (flowCollector.emit(t16, flowKt__LimitKt$emitAbort$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                throw new AbortFlowException(flowCollector);
            }
        }
        flowKt__LimitKt$emitAbort$1 = new FlowKt__LimitKt$emitAbort$1(continuation);
        Object obj2 = flowKt__LimitKt$emitAbort$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = flowKt__LimitKt$emitAbort$1.label;
        if (i3 == 0) {
        }
        throw new AbortFlowException(flowCollector);
    }

    @NotNull
    public static final <T> Flow<T> take(@NotNull Flow<? extends T> flow, int i3) {
        boolean z16;
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(flow, i3);
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " should be positive").toString());
    }

    @NotNull
    public static final <T> Flow<T> takeWhile(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return new FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1(flow, function2);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T, R> Flow<R> transformWhile(@NotNull Flow<? extends T> flow, @BuilderInference @NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        return FlowKt.flow(new FlowKt__LimitKt$transformWhile$1(flow, function3, null));
    }
}
