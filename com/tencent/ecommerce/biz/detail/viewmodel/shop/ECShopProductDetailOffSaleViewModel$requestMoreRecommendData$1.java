package com.tencent.ecommerce.biz.detail.viewmodel.shop;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@"}, d2 = {"Lorg/json/JSONObject;", "requestParams", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "requestMoreRecommendData"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductDetailOffSaleViewModel", f = "ECShopProductDetailOffSaleViewModel.kt", i = {0, 0, 1, 1}, l = {203, 213}, m = "requestMoreRecommendData", n = {"this", "requestParams", "this", "relatedRequestParams"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes31.dex */
public final class ECShopProductDetailOffSaleViewModel$requestMoreRecommendData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECShopProductDetailOffSaleViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopProductDetailOffSaleViewModel$requestMoreRecommendData$1(ECShopProductDetailOffSaleViewModel eCShopProductDetailOffSaleViewModel, Continuation continuation) {
        super(continuation);
        this.this$0 = eCShopProductDetailOffSaleViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.A2(null, this);
    }
}
