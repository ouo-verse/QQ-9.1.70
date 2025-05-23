package com.tencent.mobileqq.zplan.aio.panel.panel;

import com.tencent.mobileqq.zplan.aio.panel.page.Page;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/tencent/mobileqq/zplan/aio/panel/page/Page;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.panel.PanelAdapter$onBindViewHolder$2", f = "PanelAdapter.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class PanelAdapter$onBindViewHolder$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super StateFlow<? extends Page>>, Object> {
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ PanelAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PanelAdapter$onBindViewHolder$2(PanelAdapter panelAdapter, int i3, Continuation<? super PanelAdapter$onBindViewHolder$2> continuation) {
        super(2, continuation);
        this.this$0 = panelAdapter;
        this.$position = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PanelAdapter$onBindViewHolder$2(this.this$0, this.$position, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        StateFlow stateFlow;
        CoroutineScope coroutineScope;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            stateFlow = this.this$0.dataSource;
            coroutineScope = this.this$0.scope;
            final int i16 = this.$position;
            Function1<Panel, Page> function1 = new Function1<Panel, Page>() { // from class: com.tencent.mobileqq.zplan.aio.panel.panel.PanelAdapter$onBindViewHolder$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Page invoke(Panel it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.b().get(i16);
                }
            };
            this.label = 1;
            obj = PanelAdapterKt.b(stateFlow, coroutineScope, function1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super StateFlow<? extends Page>> continuation) {
        return ((PanelAdapter$onBindViewHolder$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
