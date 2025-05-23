package com.tencent.ecommerce.biz.detail.repo.shop;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\u0096@"}, d2 = {"", "productId", "extKeyString", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/b;", "continuation", "", "updateSkuInfoDataToCache"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.repo.shop.ECShopProductDetailRepository", f = "ECShopProductDetailRepository.kt", i = {}, l = {77, 79}, m = "updateSkuInfoDataToCache", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECShopProductDetailRepository$updateSkuInfoDataToCache$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECShopProductDetailRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopProductDetailRepository$updateSkuInfoDataToCache$1(ECShopProductDetailRepository eCShopProductDetailRepository, Continuation continuation) {
        super(continuation);
        this.this$0 = eCShopProductDetailRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateSkuInfoDataToCache(null, null, this);
    }
}
