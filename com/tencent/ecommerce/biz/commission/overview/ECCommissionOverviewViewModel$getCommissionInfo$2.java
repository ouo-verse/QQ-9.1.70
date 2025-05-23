package com.tencent.ecommerce.biz.commission.overview;

import androidx.lifecycle.MutableLiveData;
import cg0.a;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.biz.commission.forecast.IECCommissionForecastRepo;
import com.tencent.ecommerce.biz.commission.overview.ECCommissionOverviewViewModel;
import com.tencent.ecommerce.repo.proto.ecom.estimate_commission_svr.ECEstimateCommissionSvr$EntryRsp;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.commission.overview.ECCommissionOverviewViewModel$getCommissionInfo$2", f = "ECCommissionOverviewViewModel.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECCommissionOverviewViewModel$getCommissionInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ECCommissionOverviewViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECCommissionOverviewViewModel$getCommissionInfo$2(ECCommissionOverviewViewModel eCCommissionOverviewViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCCommissionOverviewViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECCommissionOverviewViewModel$getCommissionInfo$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECCommissionOverviewViewModel$getCommissionInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        IECCommissionForecastRepo iECCommissionForecastRepo;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            iECCommissionForecastRepo = this.this$0.commissionForecastRepo;
            this.label = 1;
            obj = iECCommissionForecastRepo.fetchEntry(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
        ECEstimateCommissionSvr$EntryRsp eCEstimateCommissionSvr$EntryRsp = (ECEstimateCommissionSvr$EntryRsp) eCNetworkResponse.b();
        if (eCNetworkResponse.getCode() == 0 && eCEstimateCommissionSvr$EntryRsp != null) {
            mutableLiveData2 = this.this$0._commissionForecastInfo;
            mutableLiveData2.setValue(new ECCommissionOverviewViewModel.CommissionForecastInfo(eCEstimateCommissionSvr$EntryRsp.commission_desc.get(), eCEstimateCommissionSvr$EntryRsp.commission_sum.get()));
            return Unit.INSTANCE;
        }
        a.a("ECCommissionOverviewViewModel", "getForecastCommission", "get forecast commission error code=" + eCNetworkResponse.getCode());
        mutableLiveData = this.this$0._commissionForecastInfo;
        mutableLiveData.setValue(new ECCommissionOverviewViewModel.CommissionForecastInfo("", 0L));
        return Unit.INSTANCE;
    }
}
