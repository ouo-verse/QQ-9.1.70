package com.tencent.hippykotlin.demo.pages.vas_pages.background_shop;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopRequest", f = "BackgroundShopRequest.kt", i = {0}, l = {26}, m = "firstRequest", n = {"cxt"}, s = {"L$0"})
/* loaded from: classes33.dex */
public final class BackgroundShopRequest$firstRequest$1 extends ContinuationImpl {
    public BackgroundShopPage L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ BackgroundShopRequest this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundShopRequest$firstRequest$1(BackgroundShopRequest backgroundShopRequest, Continuation<? super BackgroundShopRequest$firstRequest$1> continuation) {
        super(continuation);
        this.this$0 = backgroundShopRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.firstRequest(null, this);
    }
}
