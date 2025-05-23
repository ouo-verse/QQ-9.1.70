package com.tencent.aelight.camera.ae.flashshow.ui;

import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.wink.event.QFSAggregationUpdateEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialPanel$onFavoriteClickEventToServer$1$1", f = "AEFlashShowMaterialPanel.kt", i = {}, l = {434}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes32.dex */
public final class AEFlashShowMaterialPanel$onFavoriteClickEventToServer$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AEMaterialMetaData $it;
    int label;
    final /* synthetic */ AEFlashShowMaterialPanel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AEFlashShowMaterialPanel$onFavoriteClickEventToServer$1$1(AEFlashShowMaterialPanel aEFlashShowMaterialPanel, AEMaterialMetaData aEMaterialMetaData, Continuation<? super AEFlashShowMaterialPanel$onFavoriteClickEventToServer$1$1> continuation) {
        super(2, continuation);
        this.this$0 = aEFlashShowMaterialPanel;
        this.$it = aEMaterialMetaData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AEFlashShowMaterialPanel$onFavoriteClickEventToServer$1$1(this.this$0, this.$it, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        boolean z16;
        AEFlashShowMaterialManager mTemplateManager;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            AEFlashShowMaterialProviderView aEFlashShowMaterialProviderView = this.this$0.mContentView;
            if (aEFlashShowMaterialProviderView != null && (mTemplateManager = aEFlashShowMaterialProviderView.getMTemplateManager()) != null) {
                AEMaterialMetaData aEMaterialMetaData = this.$it;
                this.label = 1;
                obj = mTemplateManager.f0(aEMaterialMetaData, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                z16 = false;
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                String str = this.$it.f69050id;
                Intrinsics.checkNotNullExpressionValue(str, "it.id");
                simpleEventBus.dispatchEvent(new QFSAggregationUpdateEvent(str, "meterial", !z16), true);
                return Unit.INSTANCE;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        z16 = ((Boolean) obj).booleanValue();
        SimpleEventBus simpleEventBus2 = SimpleEventBus.getInstance();
        String str2 = this.$it.f69050id;
        Intrinsics.checkNotNullExpressionValue(str2, "it.id");
        simpleEventBus2.dispatchEvent(new QFSAggregationUpdateEvent(str2, "meterial", !z16), true);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AEFlashShowMaterialPanel$onFavoriteClickEventToServer$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
