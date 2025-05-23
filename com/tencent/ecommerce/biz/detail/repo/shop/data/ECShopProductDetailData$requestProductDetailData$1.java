package com.tencent.ecommerce.biz.detail.repo.shop.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0086@"}, d2 = {"", "service", "method", "Lorg/json/JSONObject;", "requestParams", "Lkotlin/coroutines/Continuation;", "continuation", "", "requestProductDetailData"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailData", f = "ECShopProductDetailData.kt", i = {0}, l = {65}, m = "requestProductDetailData", n = {"response"}, s = {"L$0"})
/* loaded from: classes31.dex */
public final class ECShopProductDetailData$requestProductDetailData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECShopProductDetailData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopProductDetailData$requestProductDetailData$1(ECShopProductDetailData eCShopProductDetailData, Continuation continuation) {
        super(continuation);
        this.this$0 = eCShopProductDetailData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(null, null, null, this);
    }
}
