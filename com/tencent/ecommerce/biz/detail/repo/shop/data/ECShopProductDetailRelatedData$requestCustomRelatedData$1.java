package com.tencent.ecommerce.biz.detail.repo.shop.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002H\u0086@"}, d2 = {"Lorg/json/JSONObject;", "requestParams", "Lkotlin/coroutines/Continuation;", "continuation", "", "requestCustomRelatedData"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailRelatedData", f = "ECShopProductDetailRelatedData.kt", i = {0}, l = {52}, m = "requestCustomRelatedData", n = {"this"}, s = {"L$0"})
/* loaded from: classes31.dex */
public final class ECShopProductDetailRelatedData$requestCustomRelatedData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECShopProductDetailRelatedData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopProductDetailRelatedData$requestCustomRelatedData$1(ECShopProductDetailRelatedData eCShopProductDetailRelatedData, Continuation continuation) {
        super(continuation);
        this.this$0 = eCShopProductDetailRelatedData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
