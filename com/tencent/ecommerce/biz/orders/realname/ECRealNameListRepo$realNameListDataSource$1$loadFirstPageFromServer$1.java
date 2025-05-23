package com.tencent.ecommerce.biz.orders.realname;

import com.tencent.component.network.downloader.impl.ipc.Const;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\u0096@"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/realname/b;", Const.BUNDLE_KEY_REQUEST, "Lkotlin/coroutines/Continuation;", "Lcom/tencent/ecommerce/base/list/IListRepository$a;", "Lcom/tencent/ecommerce/biz/orders/realname/a;", "", "continuation", "", "loadFirstPageFromServer"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.realname.ECRealNameListRepo$realNameListDataSource$1", f = "ECRealNameListRepo.kt", i = {0}, l = {53}, m = "loadFirstPageFromServer", n = {"this"}, s = {"L$0"})
/* loaded from: classes31.dex */
public final class ECRealNameListRepo$realNameListDataSource$1$loadFirstPageFromServer$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECRealNameListRepo$realNameListDataSource$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECRealNameListRepo$realNameListDataSource$1$loadFirstPageFromServer$1(ECRealNameListRepo$realNameListDataSource$1 eCRealNameListRepo$realNameListDataSource$1, Continuation continuation) {
        super(continuation);
        this.this$0 = eCRealNameListRepo$realNameListDataSource$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
