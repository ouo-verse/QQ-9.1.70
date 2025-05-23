package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.SafeCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BE\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u00a2\u0006\u0002\b\t\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0096A\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010R:\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u00a2\u0006\u0002\b\tX\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/flow/SubscribedFlowCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "action", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSubscription", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class SubscribedFlowCollector<T> implements FlowCollector<T> {

    @NotNull
    private final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> action;

    @NotNull
    private final FlowCollector<T> collector;

    /* JADX WARN: Multi-variable type inference failed */
    public SubscribedFlowCollector(@NotNull FlowCollector<? super T> flowCollector, @NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.collector = flowCollector;
        this.action = function2;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t16, @NotNull Continuation<? super Unit> continuation) {
        return this.collector.emit(t16, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onSubscription(@NotNull Continuation<? super Unit> continuation) {
        SubscribedFlowCollector$onSubscription$1 subscribedFlowCollector$onSubscription$1;
        Object coroutine_suspended;
        int i3;
        SafeCollector safeCollector;
        SubscribedFlowCollector<T> subscribedFlowCollector;
        FlowCollector<T> flowCollector;
        if (continuation instanceof SubscribedFlowCollector$onSubscription$1) {
            subscribedFlowCollector$onSubscription$1 = (SubscribedFlowCollector$onSubscription$1) continuation;
            int i16 = subscribedFlowCollector$onSubscription$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                subscribedFlowCollector$onSubscription$1.label = i16 - Integer.MIN_VALUE;
                Object obj = subscribedFlowCollector$onSubscription$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = subscribedFlowCollector$onSubscription$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    safeCollector = (SafeCollector) subscribedFlowCollector$onSubscription$1.L$1;
                    subscribedFlowCollector = (SubscribedFlowCollector) subscribedFlowCollector$onSubscription$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th5) {
                        th = th5;
                        safeCollector.releaseIntercepted();
                        throw th;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    SafeCollector safeCollector2 = new SafeCollector(this.collector, subscribedFlowCollector$onSubscription$1.getContext());
                    try {
                        Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> function2 = this.action;
                        subscribedFlowCollector$onSubscription$1.L$0 = this;
                        subscribedFlowCollector$onSubscription$1.L$1 = safeCollector2;
                        subscribedFlowCollector$onSubscription$1.label = 1;
                        if (function2.invoke(safeCollector2, subscribedFlowCollector$onSubscription$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        subscribedFlowCollector = this;
                        safeCollector = safeCollector2;
                    } catch (Throwable th6) {
                        th = th6;
                        safeCollector = safeCollector2;
                        safeCollector.releaseIntercepted();
                        throw th;
                    }
                }
                safeCollector.releaseIntercepted();
                flowCollector = subscribedFlowCollector.collector;
                if (!(flowCollector instanceof SubscribedFlowCollector)) {
                    subscribedFlowCollector$onSubscription$1.L$0 = null;
                    subscribedFlowCollector$onSubscription$1.L$1 = null;
                    subscribedFlowCollector$onSubscription$1.label = 2;
                    if (((SubscribedFlowCollector) flowCollector).onSubscription(subscribedFlowCollector$onSubscription$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        }
        subscribedFlowCollector$onSubscription$1 = new SubscribedFlowCollector$onSubscription$1(this, continuation);
        Object obj2 = subscribedFlowCollector$onSubscription$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = subscribedFlowCollector$onSubscription$1.label;
        if (i3 == 0) {
        }
        safeCollector.releaseIntercepted();
        flowCollector = subscribedFlowCollector.collector;
        if (!(flowCollector instanceof SubscribedFlowCollector)) {
        }
    }
}
