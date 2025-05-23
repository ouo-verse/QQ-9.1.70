package com.tencent.mobileqq.zplan.aio.panel.panel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aK\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"T", "U", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlin/Function1;", "block", "b", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class PanelAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T, U> Object b(StateFlow<? extends T> stateFlow, CoroutineScope coroutineScope, Function1<? super T, ? extends U> function1, Continuation<? super StateFlow<? extends U>> continuation) {
        return FlowKt.stateIn(FlowKt.flow(new PanelAdapterKt$mapStateIn$2(stateFlow, function1, null)), coroutineScope, continuation);
    }
}
