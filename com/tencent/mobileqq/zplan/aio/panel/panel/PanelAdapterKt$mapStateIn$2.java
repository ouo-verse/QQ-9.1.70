package com.tencent.mobileqq.zplan.aio.panel.panel;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: Add missing generic type declarations: [U] */
@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@"}, d2 = {"T", "U", "Lkotlinx/coroutines/flow/FlowCollector;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.panel.PanelAdapterKt$mapStateIn$2", f = "PanelAdapter.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class PanelAdapterKt$mapStateIn$2<U> extends SuspendLambda implements Function2<FlowCollector<? super U>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<T, U> $block;
    final /* synthetic */ StateFlow<T> $this_mapStateIn;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PanelAdapterKt$mapStateIn$2(StateFlow<? extends T> stateFlow, Function1<? super T, ? extends U> function1, Continuation<? super PanelAdapterKt$mapStateIn$2> continuation) {
        super(2, continuation);
        this.$this_mapStateIn = stateFlow;
        this.$block = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PanelAdapterKt$mapStateIn$2 panelAdapterKt$mapStateIn$2 = new PanelAdapterKt$mapStateIn$2(this.$this_mapStateIn, this.$block, continuation);
        panelAdapterKt$mapStateIn$2.L$0 = obj;
        return panelAdapterKt$mapStateIn$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            SharedFlow sharedFlow = this.$this_mapStateIn;
            PanelAdapterKt$mapStateIn$2$invokeSuspend$$inlined$collect$1 panelAdapterKt$mapStateIn$2$invokeSuspend$$inlined$collect$1 = new PanelAdapterKt$mapStateIn$2$invokeSuspend$$inlined$collect$1(flowCollector, this.$block);
            this.label = 1;
            if (sharedFlow.collect(panelAdapterKt$mapStateIn$2$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super U> flowCollector, Continuation<? super Unit> continuation) {
        return ((PanelAdapterKt$mapStateIn$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
