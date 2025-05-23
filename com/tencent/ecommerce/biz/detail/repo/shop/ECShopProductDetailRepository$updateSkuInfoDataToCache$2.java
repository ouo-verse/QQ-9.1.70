package com.tencent.ecommerce.biz.detail.repo.shop;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0082@"}, d2 = {"", "service", "method", "Lorg/json/JSONObject;", "params", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/b;", "continuation", "", "updateSkuInfoDataToCache"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.repo.shop.ECShopProductDetailRepository", f = "ECShopProductDetailRepository.kt", i = {}, l = {226}, m = "updateSkuInfoDataToCache", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECShopProductDetailRepository$updateSkuInfoDataToCache$2 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECShopProductDetailRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopProductDetailRepository$updateSkuInfoDataToCache$2(ECShopProductDetailRepository eCShopProductDetailRepository, Continuation continuation) {
        super(continuation);
        this.this$0 = eCShopProductDetailRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, null, null, this);
    }
}
