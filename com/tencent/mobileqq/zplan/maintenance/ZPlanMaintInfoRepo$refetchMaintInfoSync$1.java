package com.tencent.mobileqq.zplan.maintenance;

import com.tencent.mobileqq.zplan.model.MaintEntryType;
import com.tencent.mobileqq.zplan.model.ZPlanMaintInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/zplan/model/i;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.maintenance.ZPlanMaintInfoRepo$refetchMaintInfoSync$1", f = "ZPlanMaintInfoRepo.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class ZPlanMaintInfoRepo$refetchMaintInfoSync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanMaintInfo>, Object> {
    final /* synthetic */ MaintEntryType $type;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanMaintInfoRepo$refetchMaintInfoSync$1(MaintEntryType maintEntryType, Continuation<? super ZPlanMaintInfoRepo$refetchMaintInfoSync$1> continuation) {
        super(2, continuation);
        this.$type = maintEntryType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanMaintInfoRepo$refetchMaintInfoSync$1(this.$type, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ZPlanMaintInfoRepo zPlanMaintInfoRepo = ZPlanMaintInfoRepo.f333853a;
            MaintEntryType maintEntryType = this.$type;
            this.label = 1;
            obj = zPlanMaintInfoRepo.c(maintEntryType, this);
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
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZPlanMaintInfo> continuation) {
        return ((ZPlanMaintInfoRepo$refetchMaintInfoSync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
