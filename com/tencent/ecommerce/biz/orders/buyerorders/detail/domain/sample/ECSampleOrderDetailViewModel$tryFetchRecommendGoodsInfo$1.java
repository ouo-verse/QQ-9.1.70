package com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.sample;

import com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailRelatedInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.qshop.ECOrderDetailState;
import com.tencent.ecommerce.biz.recommend.models.ECProductRecommendItemData;
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
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.detail.domain.sample.ECSampleOrderDetailViewModel$tryFetchRecommendGoodsInfo$1", f = "ECSampleOrderDetailViewModel.kt", i = {}, l = {237}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECSampleOrderDetailViewModel$tryFetchRecommendGoodsInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $params;
    int label;
    final /* synthetic */ ECSampleOrderDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECSampleOrderDetailViewModel$tryFetchRecommendGoodsInfo$1(ECSampleOrderDetailViewModel eCSampleOrderDetailViewModel, JSONObject jSONObject, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCSampleOrderDetailViewModel;
        this.$params = jSONObject;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECSampleOrderDetailViewModel$tryFetchRecommendGoodsInfo$1(this.this$0, this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECSampleOrderDetailViewModel$tryFetchRecommendGoodsInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        List list;
        ECOrderDetailState q26;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            IECShopProductDetailRepository shopProductDetailRepository = com.tencent.ecommerce.biz.detail.repo.shop.a.f102322a.getShopProductDetailRepository();
            JSONObject jSONObject = this.$params;
            this.label = 1;
            obj = shopProductDetailRepository.getShopProductDetailRelatedData(jSONObject, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ECShopProductDetailRelatedInfo eCShopProductDetailRelatedInfo = (ECShopProductDetailRelatedInfo) obj;
        this.this$0.isLoadingRecommendData = false;
        if (eCShopProductDetailRelatedInfo == null) {
            cg0.a.a("ECSampleOrderDetailViewModel", "requestRecommendProduct", "request recommend product error");
            return Unit.INSTANCE;
        }
        List<ECProductRecommendItemData> d16 = ti0.a.f436377a.d(eCShopProductDetailRelatedInfo.infoData);
        cg0.a.b("ECSampleOrderDetailViewModel", "fetch recommend info: size = " + d16.size());
        list = this.this$0.recommendDatas;
        list.addAll(d16);
        ECSampleOrderDetailViewModel eCSampleOrderDetailViewModel = this.this$0;
        q26 = eCSampleOrderDetailViewModel.q2(eCSampleOrderDetailViewModel.m2().getValue());
        eCSampleOrderDetailViewModel.v2(q26);
        this.this$0.recommendCookie = eCShopProductDetailRelatedInfo.infoData.optString("cookie");
        this.this$0._hasMoreRecommendData = !eCShopProductDetailRelatedInfo.infoData.optBoolean("is_end");
        return Unit.INSTANCE;
    }
}
