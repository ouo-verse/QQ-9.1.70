package com.tencent.mobileqq.zplan.proxy;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.record.FilamentRecordHelper;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.proxy.QQZPlanAssetsProxy$fetchAnimationAssetsForFilament$2$results$1$1", f = "QQZPlanAssetsProxy.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class QQZPlanAssetsProxy$fetchAnimationAssetsForFilament$2$results$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanAction>, Object> {
    final /* synthetic */ EnumUserGender $gender;
    final /* synthetic */ jx4.b $it;
    final /* synthetic */ FilamentUrlTemplate $urlTemplate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQZPlanAssetsProxy$fetchAnimationAssetsForFilament$2$results$1$1(jx4.b bVar, EnumUserGender enumUserGender, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super QQZPlanAssetsProxy$fetchAnimationAssetsForFilament$2$results$1$1> continuation) {
        super(2, continuation);
        this.$it = bVar;
        this.$gender = enumUserGender;
        this.$urlTemplate = filamentUrlTemplate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQZPlanAssetsProxy$fetchAnimationAssetsForFilament$2$results$1$1(this.$it, this.$gender, this.$urlTemplate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            JSONObject b16 = com.tencent.zplan.common.utils.h.f385294a.b(this.$it.f411140b);
            if (b16 == null) {
                return null;
            }
            FilamentRecordHelper filamentRecordHelper = FilamentRecordHelper.f105779a;
            EnumUserGender enumUserGender = this.$gender;
            FilamentUrlTemplate filamentUrlTemplate = this.$urlTemplate;
            this.label = 1;
            obj = FilamentRecordHelper.c(filamentRecordHelper, b16, enumUserGender, filamentUrlTemplate, null, this, 8, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return (ZPlanAction) ((Pair) obj).getFirst();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZPlanAction> continuation) {
        return ((QQZPlanAssetsProxy$fetchAnimationAssetsForFilament$2$results$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
