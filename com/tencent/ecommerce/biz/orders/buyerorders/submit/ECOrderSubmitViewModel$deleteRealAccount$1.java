package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0086@"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/realname/a;", "account", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "deleteRealAccount"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel", f = "ECOrderSubmitViewModel.kt", i = {0, 0, 0, 0, 1, 1, 2, 3}, l = {PlayerResources.ViewId.CURRUNT_TIME, 567, PlayerResources.ViewId.EXTENDED_VIEW_BTN_BUTTON_TEXT, PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT_CONTAINER}, m = "deleteRealAccount", n = {"this", "account", "orderDetail", "oldProductType", "this", "deleteResult", "deleteResult", "deleteResult"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "Z$0", "Z$0", "Z$0"})
/* loaded from: classes31.dex */
public final class ECOrderSubmitViewModel$deleteRealAccount$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ECOrderSubmitViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECOrderSubmitViewModel$deleteRealAccount$1(ECOrderSubmitViewModel eCOrderSubmitViewModel, Continuation continuation) {
        super(continuation);
        this.this$0 = eCOrderSubmitViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.r2(null, this);
    }
}
