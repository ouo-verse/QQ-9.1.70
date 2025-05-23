package com.tencent.mobileqq.zplan.couple.processor;

import com.tencent.mobileqq.zplan.servlet.ZPlanCoupleAvatarRequest;
import k55.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.couple.processor.ZPlanCoupleProfileDataProcessor$setCoupleAvatarSwitchStatus$1", f = "ZPlanCoupleProfileDataProcessor.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class ZPlanCoupleProfileDataProcessor$setCoupleAvatarSwitchStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $friendUin;
    final /* synthetic */ boolean $status;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanCoupleProfileDataProcessor$setCoupleAvatarSwitchStatus$1(long j3, boolean z16, Continuation<? super ZPlanCoupleProfileDataProcessor$setCoupleAvatarSwitchStatus$1> continuation) {
        super(2, continuation);
        this.$friendUin = j3;
        this.$status = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanCoupleProfileDataProcessor$setCoupleAvatarSwitchStatus$1(this.$friendUin, this.$status, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanCoupleAvatarRequest zPlanCoupleAvatarRequest = ZPlanCoupleAvatarRequest.f335363a;
            long j3 = this.$friendUin;
            a aVar = new a();
            boolean z16 = this.$status;
            aVar.f411717a = 1;
            aVar.f411718b = z16;
            Unit unit = Unit.INSTANCE;
            this.label = 1;
            if (zPlanCoupleAvatarRequest.f(j3, aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanCoupleProfileDataProcessor$setCoupleAvatarSwitchStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
