package com.tencent.ecommerce.biz.productcenter.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.biz.productcenter.repo.ECSalesRankRepo;
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
import xj0.RankGoodsInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.productcenter.viewmodel.ECSalesRankViewModel$reqSalesRankList$1", f = "ECSalesRankViewModel.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECSalesRankViewModel$reqSalesRankList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ECSalesRankViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECSalesRankViewModel$reqSalesRankList$1(ECSalesRankViewModel eCSalesRankViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCSalesRankViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECSalesRankViewModel$reqSalesRankList$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECSalesRankViewModel$reqSalesRankList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ArrayList arrayList;
        ArrayList arrayList2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ECSalesRankRepo eCSalesRankRepo = ECSalesRankRepo.f103920a;
            ECSalesRankRepo.SalesRankType salesRankType = this.this$0.rankType;
            this.label = 1;
            obj = eCSalesRankRepo.e(salesRankType, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ArrayList arrayList3 = (ArrayList) obj;
        if (arrayList3 != null) {
            arrayList = this.this$0._salesRankList;
            arrayList.clear();
            this.this$0._salesRankList = arrayList3;
            MutableLiveData<List<RankGoodsInfo>> O1 = this.this$0.O1();
            arrayList2 = this.this$0._salesRankList;
            O1.postValue(arrayList2);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
