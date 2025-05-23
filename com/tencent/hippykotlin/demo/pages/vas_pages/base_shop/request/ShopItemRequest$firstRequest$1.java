package com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request.ShopItemRequest", f = "ShopItemRequest.kt", i = {}, l = {92}, m = "firstRequest", n = {}, s = {})
/* loaded from: classes33.dex */
public final class ShopItemRequest$firstRequest$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ShopItemRequest this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopItemRequest$firstRequest$1(ShopItemRequest shopItemRequest, Continuation<? super ShopItemRequest$firstRequest$1> continuation) {
        super(continuation);
        this.this$0 = shopItemRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.firstRequest(null, null, this);
    }
}
