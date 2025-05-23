package com.tencent.ecommerce.repo.shoplist;

import com.tencent.component.network.downloader.impl.ipc.Const;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u00050\u0004H\u0082@"}, d2 = {"Lcom/tencent/ecommerce/repo/shoplist/b;", Const.BUNDLE_KEY_REQUEST, "", "cookie", "Lkotlin/coroutines/Continuation;", "Lcom/tencent/ecommerce/base/list/IListRepository$a;", "Lcom/tencent/ecommerce/biz/shoplist/a;", "continuation", "", "loadPageFromServer"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.repo.shoplist.ECPromoteShopListDataSource", f = "ECPromoteShopListDataSource.kt", i = {}, l = {61}, m = "loadPageFromServer", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECPromoteShopListDataSource$loadPageFromServer$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECPromoteShopListDataSource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECPromoteShopListDataSource$loadPageFromServer$1(ECPromoteShopListDataSource eCPromoteShopListDataSource, Continuation continuation) {
        super(continuation);
        this.this$0 = eCPromoteShopListDataSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.n(null, null, this);
    }
}
