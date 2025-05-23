package com.tencent.mobileqq.zplan.aigc.utils;

import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.avatar.model.Resource;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/filament/zplan/avatar/model/b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.utils.AIGCHelper$fetchIblImage$indirectLightPathDeferred$1", f = "AIGCHelper.kt", i = {}, l = {216}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class AIGCHelper$fetchIblImage$indirectLightPathDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Resource>, Object> {
    int label;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AIGCHelper$fetchIblImage$indirectLightPathDeferred$1(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
            FilamentUrlTemplate F = FilamentFeatureUtil.f106409g.F();
            this.label = 1;
            obj = zPlanAvatarResourceHelper.N(null, F, this);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public AIGCHelper$fetchIblImage$indirectLightPathDeferred$1(Continuation<? super AIGCHelper$fetchIblImage$indirectLightPathDeferred$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Resource> continuation) {
        return ((AIGCHelper$fetchIblImage$indirectLightPathDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
