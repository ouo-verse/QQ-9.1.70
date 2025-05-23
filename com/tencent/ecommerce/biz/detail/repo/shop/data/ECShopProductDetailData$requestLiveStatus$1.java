package com.tencent.ecommerce.biz.detail.repo.shop.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\u0086@"}, d2 = {"", "shopId", "spuId", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/f;", "continuation", "", "requestLiveStatus"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailData", f = "ECShopProductDetailData.kt", i = {0}, l = {96}, m = "requestLiveStatus", n = {"shopId"}, s = {"L$0"})
/* loaded from: classes31.dex */
public final class ECShopProductDetailData$requestLiveStatus$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECShopProductDetailData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopProductDetailData$requestLiveStatus$1(ECShopProductDetailData eCShopProductDetailData, Continuation continuation) {
        super(continuation);
        this.this$0 = eCShopProductDetailData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(null, null, this);
    }
}
