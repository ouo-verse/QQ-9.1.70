package com.tencent.ecommerce.biz.commission.subsidy;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.repo.ServiceLocator;
import java.util.ArrayList;
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
import sj0.ECBillModel;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.commission.subsidy.ECSubsidyOverviewViewModel$loadMorePaidBillList$1", f = "ECSubsidyOverviewViewModel.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECSubsidyOverviewViewModel$loadMorePaidBillList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ECSubsidyOverviewViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECSubsidyOverviewViewModel$loadMorePaidBillList$1(ECSubsidyOverviewViewModel eCSubsidyOverviewViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCSubsidyOverviewViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECSubsidyOverviewViewModel$loadMorePaidBillList$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECSubsidyOverviewViewModel$loadMorePaidBillList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0042, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r0);
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String str;
        MutableLiveData mutableLiveData;
        List arrayList;
        List Z1;
        MutableLiveData mutableLiveData2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            com.tencent.ecommerce.repo.commission.subsidy.a r16 = ServiceLocator.f104891i.r();
            str = this.this$0.cookie;
            this.label = 1;
            obj = r16.c(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ECBillModel eCBillModel = (ECBillModel) obj;
        if (eCBillModel != null) {
            mutableLiveData = this.this$0._paidBills;
            List list = (List) mutableLiveData.getValue();
            if (list == null || arrayList == null) {
                arrayList = new ArrayList();
            }
            Z1 = this.this$0.Z1(eCBillModel);
            arrayList.addAll(Z1);
            mutableLiveData2 = this.this$0._paidBills;
            mutableLiveData2.setValue(arrayList);
            this.this$0.job = null;
        }
        return Unit.INSTANCE;
    }
}
