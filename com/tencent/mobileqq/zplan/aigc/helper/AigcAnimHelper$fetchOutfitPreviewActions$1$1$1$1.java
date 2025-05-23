package com.tencent.mobileqq.zplan.aigc.helper;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.mobileqq.zplan.aigc.data.SuitAnimationItem;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.helper.AigcAnimHelper$fetchOutfitPreviewActions$1$1$1$1", f = "AigcAnimHelper.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class AigcAnimHelper$fetchOutfitPreviewActions$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanAction>, Object> {
    final /* synthetic */ SuitAnimationItem $fetchActionData;
    final /* synthetic */ EnumUserGender $gender;
    int label;
    final /* synthetic */ AigcAnimHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AigcAnimHelper$fetchOutfitPreviewActions$1$1$1$1(SuitAnimationItem suitAnimationItem, AigcAnimHelper aigcAnimHelper, EnumUserGender enumUserGender, Continuation<? super AigcAnimHelper$fetchOutfitPreviewActions$1$1$1$1> continuation) {
        super(2, continuation);
        this.$fetchActionData = suitAnimationItem;
        this.this$0 = aigcAnimHelper;
        this.$gender = enumUserGender;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AigcAnimHelper$fetchOutfitPreviewActions$1$1$1$1(this.$fetchActionData, this.this$0, this.$gender, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.i("AigcAnimHelper_", 1, "fetchOutfitPreviewActions fetchPathAction headAction: " + this.$fetchActionData.getHeadAction() + " bodyAction: " + this.$fetchActionData.getBodyAction());
            AigcAnimHelper aigcAnimHelper = this.this$0;
            EnumUserGender enumUserGender = this.$gender;
            String headAction = this.$fetchActionData.getHeadAction();
            String bodyAction = this.$fetchActionData.getBodyAction();
            FilamentUrlTemplate urlTemplate = this.this$0.getUrlTemplate();
            this.label = 1;
            obj = aigcAnimHelper.d0(null, enumUserGender, headAction, bodyAction, urlTemplate, this);
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
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZPlanAction> continuation) {
        return ((AigcAnimHelper$fetchOutfitPreviewActions$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
