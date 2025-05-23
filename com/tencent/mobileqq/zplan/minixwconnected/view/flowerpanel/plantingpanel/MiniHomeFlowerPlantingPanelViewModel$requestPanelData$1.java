package com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.MiniHomeFlowerPlantingPanelViewModel", f = "MiniHomeFlowerPlantingPanelViewModel.kt", i = {0}, l = {164}, m = "requestPanelData", n = {"rsp$iv"}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class MiniHomeFlowerPlantingPanelViewModel$requestPanelData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MiniHomeFlowerPlantingPanelViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeFlowerPlantingPanelViewModel$requestPanelData$1(MiniHomeFlowerPlantingPanelViewModel miniHomeFlowerPlantingPanelViewModel, Continuation<? super MiniHomeFlowerPlantingPanelViewModel$requestPanelData$1> continuation) {
        super(continuation);
        this.this$0 = miniHomeFlowerPlantingPanelViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object P1;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        P1 = this.this$0.P1(this);
        return P1;
    }
}
