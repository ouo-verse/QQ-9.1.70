package com.tencent.mobileqq.zootopia.portal.aigc.preview;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.data.FetchActionData;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene$loadCompleteAction$2$fetchActionsJob$1", f = "AigcPreviewBusinessScene.kt", i = {}, l = {296}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class AigcPreviewBusinessScene$loadCompleteAction$2$fetchActionsJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanAction[]>, Object> {
    final /* synthetic */ EnumUserGender $gender;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AigcPreviewBusinessScene this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AigcPreviewBusinessScene$loadCompleteAction$2$fetchActionsJob$1(AigcPreviewBusinessScene aigcPreviewBusinessScene, EnumUserGender enumUserGender, Continuation<? super AigcPreviewBusinessScene$loadCompleteAction$2$fetchActionsJob$1> continuation) {
        super(2, continuation);
        this.this$0 = aigcPreviewBusinessScene;
        this.$gender = enumUserGender;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AigcPreviewBusinessScene$loadCompleteAction$2$fetchActionsJob$1 aigcPreviewBusinessScene$loadCompleteAction$2$fetchActionsJob$1 = new AigcPreviewBusinessScene$loadCompleteAction$2$fetchActionsJob$1(this.this$0, this.$gender, continuation);
        aigcPreviewBusinessScene$loadCompleteAction$2$fetchActionsJob$1.L$0 = obj;
        return aigcPreviewBusinessScene$loadCompleteAction$2$fetchActionsJob$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZPlanAction[]> continuation) {
        return ((AigcPreviewBusinessScene$loadCompleteAction$2$fetchActionsJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object awaitAll;
        int i3;
        Deferred async$default;
        Deferred async$default2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ArrayList arrayList = new ArrayList();
            FetchActionData[] completeActionDataArray = this.this$0.getCompleteActionDataArray();
            if (completeActionDataArray != null) {
                AigcPreviewBusinessScene aigcPreviewBusinessScene = this.this$0;
                EnumUserGender enumUserGender = this.$gender;
                int length = completeActionDataArray.length;
                int i17 = 0;
                while (i17 < length) {
                    FetchActionData fetchActionData = completeActionDataArray[i17];
                    if (fetchActionData.getActionId() > 0) {
                        i3 = i17;
                        async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AigcPreviewBusinessScene$loadCompleteAction$2$fetchActionsJob$1$1$1(aigcPreviewBusinessScene, enumUserGender, fetchActionData, null), 3, null);
                        arrayList.add(async$default2);
                    } else {
                        i3 = i17;
                        async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AigcPreviewBusinessScene$loadCompleteAction$2$fetchActionsJob$1$1$2(aigcPreviewBusinessScene, enumUserGender, fetchActionData, null), 3, null);
                        arrayList.add(async$default);
                    }
                    i17 = i3 + 1;
                }
            }
            this.label = 1;
            awaitAll = AwaitKt.awaitAll(arrayList, this);
            if (awaitAll == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i16 == 1) {
            ResultKt.throwOnFailure(obj);
            awaitAll = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Object[] array = ((Collection) awaitAll).toArray(new ZPlanAction[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }
}
