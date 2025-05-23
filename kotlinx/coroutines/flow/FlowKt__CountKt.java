package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004\u001aE\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"count", "", "T", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes28.dex */
public final /* synthetic */ class FlowKt__CountKt {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object count(@NotNull Flow<? extends T> flow, @NotNull Continuation<? super Integer> continuation) {
        FlowKt__CountKt$count$1 flowKt__CountKt$count$1;
        Object coroutine_suspended;
        int i3;
        Ref.IntRef intRef;
        if (continuation instanceof FlowKt__CountKt$count$1) {
            flowKt__CountKt$count$1 = (FlowKt__CountKt$count$1) continuation;
            int i16 = flowKt__CountKt$count$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                flowKt__CountKt$count$1.label = i16 - Integer.MIN_VALUE;
                Object obj = flowKt__CountKt$count$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = flowKt__CountKt$count$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Ref.IntRef intRef2 = new Ref.IntRef();
                    FlowCollector<T> flowCollector = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @Nullable
                        public Object emit(T t16, @NotNull Continuation<? super Unit> continuation2) {
                            Ref.IntRef.this.element++;
                            return Unit.INSTANCE;
                        }
                    };
                    flowKt__CountKt$count$1.L$0 = intRef2;
                    flowKt__CountKt$count$1.label = 1;
                    if (flow.collect(flowCollector, flowKt__CountKt$count$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    intRef = intRef2;
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    intRef = (Ref.IntRef) flowKt__CountKt$count$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxInt(intRef.element);
            }
        }
        flowKt__CountKt$count$1 = new FlowKt__CountKt$count$1(continuation);
        Object obj2 = flowKt__CountKt$count$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = flowKt__CountKt$count$1.label;
        if (i3 != 0) {
        }
        return Boxing.boxInt(intRef.element);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object count(@NotNull Flow<? extends T> flow, @NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super Integer> continuation) {
        FlowKt__CountKt$count$3 flowKt__CountKt$count$3;
        Object coroutine_suspended;
        int i3;
        Ref.IntRef intRef;
        if (continuation instanceof FlowKt__CountKt$count$3) {
            flowKt__CountKt$count$3 = (FlowKt__CountKt$count$3) continuation;
            int i16 = flowKt__CountKt$count$3.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                flowKt__CountKt$count$3.label = i16 - Integer.MIN_VALUE;
                Object obj = flowKt__CountKt$count$3.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = flowKt__CountKt$count$3.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    FlowCollector<? super Object> flowKt__CountKt$count$$inlined$collect$2 = new FlowKt__CountKt$count$$inlined$collect$2<>(function2, intRef2);
                    flowKt__CountKt$count$3.L$0 = intRef2;
                    flowKt__CountKt$count$3.label = 1;
                    if (flow.collect(flowKt__CountKt$count$$inlined$collect$2, flowKt__CountKt$count$3) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    intRef = intRef2;
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    intRef = (Ref.IntRef) flowKt__CountKt$count$3.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxInt(intRef.element);
            }
        }
        flowKt__CountKt$count$3 = new FlowKt__CountKt$count$3(continuation);
        Object obj2 = flowKt__CountKt$count$3.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = flowKt__CountKt$count$3.label;
        if (i3 != 0) {
        }
        return Boxing.boxInt(intRef.element);
    }
}
