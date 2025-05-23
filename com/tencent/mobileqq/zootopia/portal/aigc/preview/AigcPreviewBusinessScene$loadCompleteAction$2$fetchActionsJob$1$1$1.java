package com.tencent.mobileqq.zootopia.portal.aigc.preview;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.data.FetchActionData;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
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
@DebugMetadata(c = "com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene$loadCompleteAction$2$fetchActionsJob$1$1$1", f = "AigcPreviewBusinessScene.kt", i = {}, l = {277}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class AigcPreviewBusinessScene$loadCompleteAction$2$fetchActionsJob$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanAction>, Object> {
    final /* synthetic */ FetchActionData $fetchActionData;
    final /* synthetic */ EnumUserGender $gender;
    int label;
    final /* synthetic */ AigcPreviewBusinessScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AigcPreviewBusinessScene$loadCompleteAction$2$fetchActionsJob$1$1$1(AigcPreviewBusinessScene aigcPreviewBusinessScene, EnumUserGender enumUserGender, FetchActionData fetchActionData, Continuation<? super AigcPreviewBusinessScene$loadCompleteAction$2$fetchActionsJob$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = aigcPreviewBusinessScene;
        this.$gender = enumUserGender;
        this.$fetchActionData = fetchActionData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AigcPreviewBusinessScene$loadCompleteAction$2$fetchActionsJob$1$1$1(this.this$0, this.$gender, this.$fetchActionData, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            AigcPreviewBusinessScene aigcPreviewBusinessScene = this.this$0;
            EnumUserGender enumUserGender = this.$gender;
            int actionId = this.$fetchActionData.getActionId();
            FilamentUrlTemplate urlTemplate = this.this$0.getUrlTemplate();
            this.label = 1;
            obj = aigcPreviewBusinessScene.fetchIdAction(null, enumUserGender, actionId, urlTemplate, this);
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
        return ((AigcPreviewBusinessScene$loadCompleteAction$2$fetchActionsJob$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
