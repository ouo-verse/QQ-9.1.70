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
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/filament/zplan/avatar/model/b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.utils.AIGCHelper$fetchWhiteModel$whiteModelDeferred$1", f = "AIGCHelper.kt", i = {}, l = {228}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class AIGCHelper$fetchWhiteModel$whiteModelDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Resource>, Object> {
    final /* synthetic */ long $itemID;
    final /* synthetic */ long $slotID;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIGCHelper$fetchWhiteModel$whiteModelDeferred$1(long j3, long j16, Continuation<? super AIGCHelper$fetchWhiteModel$whiteModelDeferred$1> continuation) {
        super(2, continuation);
        this.$slotID = j3;
        this.$itemID = j16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AIGCHelper$fetchWhiteModel$whiteModelDeferred$1(this.$slotID, this.$itemID, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            FilamentUrlTemplate F = FilamentFeatureUtil.f106409g.F();
            ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
            String p06 = zPlanAvatarResourceHelper.p0(this.$slotID, this.$itemID, F);
            long j3 = this.$slotID;
            long j16 = this.$itemID;
            this.label = 1;
            obj = zPlanAvatarResourceHelper.y(null, p06, j3, j16, F, this);
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
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Resource> continuation) {
        return ((AIGCHelper$fetchWhiteModel$whiteModelDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
