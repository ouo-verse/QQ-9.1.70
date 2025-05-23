package com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minixwconnected.view.flowerpanel.plantingpanel.MiniHomeFlowerPlantingPanelViewModel$fetch$1", f = "MiniHomeFlowerPlantingPanelViewModel.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class MiniHomeFlowerPlantingPanelViewModel$fetch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MiniHomeFlowerPlantingPanelViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeFlowerPlantingPanelViewModel$fetch$1(MiniHomeFlowerPlantingPanelViewModel miniHomeFlowerPlantingPanelViewModel, Continuation<? super MiniHomeFlowerPlantingPanelViewModel$fetch$1> continuation) {
        super(2, continuation);
        this.this$0 = miniHomeFlowerPlantingPanelViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniHomeFlowerPlantingPanelViewModel$fetch$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        Object P1;
        MutableLiveData mutableLiveData2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableLiveData = this.this$0._flowerData;
            MiniHomeFlowerPlantingPanelViewModel miniHomeFlowerPlantingPanelViewModel = this.this$0;
            this.L$0 = mutableLiveData;
            this.label = 1;
            P1 = miniHomeFlowerPlantingPanelViewModel.P1(this);
            if (P1 == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData2 = mutableLiveData;
            obj = P1;
        } else if (i3 == 1) {
            mutableLiveData2 = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableLiveData2.setValue(obj);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniHomeFlowerPlantingPanelViewModel$fetch$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
