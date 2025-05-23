package com.tencent.mobileqq.zplan.couple.processor;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import java.util.List;
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
@DebugMetadata(c = "com.tencent.mobileqq.zplan.couple.processor.ZPlanCoupleProfileDataProcessor$fetchZPlanCoupleProfileInfos$1", f = "ZPlanCoupleProfileDataProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class ZPlanCoupleProfileDataProcessor$fetchZPlanCoupleProfileInfos$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<d> $ntFriendSimpleInfoList;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ZPlanCoupleProfileDataProcessor$fetchZPlanCoupleProfileInfos$1(List<? extends d> list, Continuation<? super ZPlanCoupleProfileDataProcessor$fetchZPlanCoupleProfileInfos$1> continuation) {
        super(2, continuation);
        this.$ntFriendSimpleInfoList = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanCoupleProfileDataProcessor$fetchZPlanCoupleProfileInfos$1(this.$ntFriendSimpleInfoList, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                ZPlanCoupleProfileDataProcessor.f332677a.b(this.$ntFriendSimpleInfoList);
            } catch (Throwable th5) {
                QLog.e("ZPlanCoupleProfileDataProcessor", 1, "friendListCallBack failed t:" + th5);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanCoupleProfileDataProcessor$fetchZPlanCoupleProfileInfos$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
