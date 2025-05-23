package com.tencent.ecommerce.biz.orders.buyerorders.orderlist;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0082@"}, d2 = {"Lorg/json/JSONArray;", "priorityArray", "Lorg/json/JSONObject;", "wxMiniAppLinkInfo", "qqMiniAppLinkInfo", "", "h5Url", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "tryLauncherDetailPage"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.orderlist.ECOrderListFragment", f = "ECOrderListFragment.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {547, 552}, m = "tryLauncherDetailPage", n = {"this", "priorityArray", "wxMiniAppLinkInfo", "qqMiniAppLinkInfo", "h5Url", "i", "this", "priorityArray", "wxMiniAppLinkInfo", "qqMiniAppLinkInfo", "h5Url", "i"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
/* loaded from: classes31.dex */
public final class ECOrderListFragment$tryLauncherDetailPage$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECOrderListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECOrderListFragment$tryLauncherDetailPage$1(ECOrderListFragment eCOrderListFragment, Continuation continuation) {
        super(continuation);
        this.this$0 = eCOrderListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.ui(null, null, null, null, this);
    }
}
