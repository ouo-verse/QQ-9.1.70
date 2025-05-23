package com.tencent.ecommerce.biz.shophome.repo;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0096@"}, d2 = {"", "shopId", "", "shareAction", "appId", "arkViewName", "version", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/ecommerce/biz/shophome/repo/b;", "continuation", "", "getShopShareInfo"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.shophome.repo.ECShopHomeDefaultRepository", f = "ECShopHomeDefaultRepository.kt", i = {}, l = {266}, m = "getShopShareInfo", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECShopHomeDefaultRepository$getShopShareInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECShopHomeDefaultRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopHomeDefaultRepository$getShopShareInfo$1(ECShopHomeDefaultRepository eCShopHomeDefaultRepository, Continuation continuation) {
        super(continuation);
        this.this$0 = eCShopHomeDefaultRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getShopShareInfo(null, 0, null, null, null, this);
    }
}
