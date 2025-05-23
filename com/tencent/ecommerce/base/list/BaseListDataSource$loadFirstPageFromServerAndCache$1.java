package com.tencent.ecommerce.base.list;

import com.tencent.component.network.downloader.impl.ipc.Const;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\b\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00050\u0004H\u0086@"}, d2 = {"REQUEST", "BEAN", "EXTRA", Const.BUNDLE_KEY_REQUEST, "Lkotlin/coroutines/Continuation;", "Lcom/tencent/ecommerce/base/list/IListRepository$a;", "continuation", "", "loadFirstPageFromServerAndCache"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.base.list.BaseListDataSource", f = "BaseListDataSource.kt", i = {0, 0}, l = {79}, m = "loadFirstPageFromServerAndCache", n = {"this", Const.BUNDLE_KEY_REQUEST}, s = {"L$0", "L$1"})
/* loaded from: classes32.dex */
public final class BaseListDataSource$loadFirstPageFromServerAndCache$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseListDataSource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseListDataSource$loadFirstPageFromServerAndCache$1(BaseListDataSource baseListDataSource, Continuation continuation) {
        super(continuation);
        this.this$0 = baseListDataSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, this);
    }
}
