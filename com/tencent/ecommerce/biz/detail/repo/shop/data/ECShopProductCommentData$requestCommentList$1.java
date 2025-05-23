package com.tencent.ecommerce.biz.detail.repo.shop.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0086@"}, d2 = {"", "spuId", "", "sortType", "", "isRefreshFetch", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/ecommerce/biz/detail/repo/shop/data/ECShopProductCommentData$a;", "continuation", "", "requestCommentList"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductCommentData", f = "ECShopProductCommentData.kt", i = {0}, l = {24}, m = "requestCommentList", n = {"this"}, s = {"L$0"})
/* loaded from: classes31.dex */
public final class ECShopProductCommentData$requestCommentList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECShopProductCommentData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopProductCommentData$requestCommentList$1(ECShopProductCommentData eCShopProductCommentData, Continuation continuation) {
        super(continuation);
        this.this$0 = eCShopProductCommentData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, 0, false, this);
    }
}
