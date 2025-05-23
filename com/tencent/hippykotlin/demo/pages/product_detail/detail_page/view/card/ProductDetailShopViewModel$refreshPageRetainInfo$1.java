package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailShopViewModel", f = "ProductDetailShopViewModel.kt", i = {0}, l = {130}, m = "refreshPageRetainInfo", n = {"this"}, s = {"L$0"})
/* loaded from: classes31.dex */
public final class ProductDetailShopViewModel$refreshPageRetainInfo$1 extends ContinuationImpl {
    public ProductDetailShopViewModel L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ProductDetailShopViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailShopViewModel$refreshPageRetainInfo$1(ProductDetailShopViewModel productDetailShopViewModel, Continuation<? super ProductDetailShopViewModel$refreshPageRetainInfo$1> continuation) {
        super(continuation);
        this.this$0 = productDetailShopViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.refreshPageRetainInfo(null, this);
    }
}
