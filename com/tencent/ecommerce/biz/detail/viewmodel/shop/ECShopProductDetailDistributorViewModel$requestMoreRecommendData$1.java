package com.tencent.ecommerce.biz.detail.viewmodel.shop;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@"}, d2 = {"Lorg/json/JSONObject;", "requestParams", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "requestMoreRecommendData"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductDetailDistributorViewModel", f = "ECShopProductDetailDistributorViewModel.kt", i = {0, 0}, l = {113}, m = "requestMoreRecommendData", n = {"this", "requestParams"}, s = {"L$0", "L$1"})
/* loaded from: classes31.dex */
public final class ECShopProductDetailDistributorViewModel$requestMoreRecommendData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECShopProductDetailDistributorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopProductDetailDistributorViewModel$requestMoreRecommendData$1(ECShopProductDetailDistributorViewModel eCShopProductDetailDistributorViewModel, Continuation continuation) {
        super(continuation);
        this.this$0 = eCShopProductDetailDistributorViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.t2(null, this);
    }
}
