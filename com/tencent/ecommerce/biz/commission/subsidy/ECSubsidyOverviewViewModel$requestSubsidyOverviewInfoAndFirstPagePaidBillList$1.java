package com.tencent.ecommerce.biz.commission.subsidy;

import androidx.lifecycle.MutableLiveData;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import sj0.ECBillModel;
import tj0.ECSubsidyIncomeInfo;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.commission.subsidy.ECSubsidyOverviewViewModel$requestSubsidyOverviewInfoAndFirstPagePaidBillList$1", f = "ECSubsidyOverviewViewModel.kt", i = {0}, l = {46, 53}, m = "invokeSuspend", n = {"billsModelDeferred"}, s = {"L$0"})
/* loaded from: classes31.dex */
public final class ECSubsidyOverviewViewModel$requestSubsidyOverviewInfoAndFirstPagePaidBillList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ECSubsidyOverviewViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECSubsidyOverviewViewModel$requestSubsidyOverviewInfoAndFirstPagePaidBillList$1(ECSubsidyOverviewViewModel eCSubsidyOverviewViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCSubsidyOverviewViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ECSubsidyOverviewViewModel$requestSubsidyOverviewInfoAndFirstPagePaidBillList$1 eCSubsidyOverviewViewModel$requestSubsidyOverviewInfoAndFirstPagePaidBillList$1 = new ECSubsidyOverviewViewModel$requestSubsidyOverviewInfoAndFirstPagePaidBillList$1(this.this$0, continuation);
        eCSubsidyOverviewViewModel$requestSubsidyOverviewInfoAndFirstPagePaidBillList$1.L$0 = obj;
        return eCSubsidyOverviewViewModel$requestSubsidyOverviewInfoAndFirstPagePaidBillList$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECSubsidyOverviewViewModel$requestSubsidyOverviewInfoAndFirstPagePaidBillList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x007d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        Deferred async$default2;
        Deferred deferred;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        ECBillModel eCBillModel;
        MutableLiveData mutableLiveData3;
        List Z1;
        MutableLiveData mutableLiveData4;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ECSubsidyOverviewViewModel$requestSubsidyOverviewInfoAndFirstPagePaidBillList$1$overviewIncomeInfoDeferred$1(null), 3, null);
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ECSubsidyOverviewViewModel$requestSubsidyOverviewInfoAndFirstPagePaidBillList$1$billsModelDeferred$1(null), 3, null);
            this.L$0 = async$default2;
            this.label = 1;
            Object await = async$default.await(this);
            if (await == coroutine_suspended) {
                return coroutine_suspended;
            }
            deferred = async$default2;
            obj = await;
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    eCBillModel = (ECBillModel) obj;
                    if (eCBillModel != null) {
                        mutableLiveData4 = this.this$0._paidBills;
                        mutableLiveData4.setValue(null);
                    } else {
                        mutableLiveData3 = this.this$0._paidBills;
                        Z1 = this.this$0.Z1(eCBillModel);
                        mutableLiveData3.setValue(Z1);
                    }
                    this.this$0.job = null;
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            deferred = (Deferred) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        ECSubsidyIncomeInfo eCSubsidyIncomeInfo = (ECSubsidyIncomeInfo) obj;
        if (eCSubsidyIncomeInfo == null) {
            mutableLiveData2 = this.this$0._overviewIncomeInfo;
            mutableLiveData2.setValue(null);
            this.this$0.job = null;
            return Unit.INSTANCE;
        }
        mutableLiveData = this.this$0._overviewIncomeInfo;
        mutableLiveData.setValue(eCSubsidyIncomeInfo);
        this.L$0 = null;
        this.label = 2;
        obj = deferred.await(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        eCBillModel = (ECBillModel) obj;
        if (eCBillModel != null) {
        }
        this.this$0.job = null;
        return Unit.INSTANCE;
    }
}
