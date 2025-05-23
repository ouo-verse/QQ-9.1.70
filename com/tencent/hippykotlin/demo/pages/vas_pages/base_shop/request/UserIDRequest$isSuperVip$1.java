package com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request.UserIDRequest", f = "UserIDRequest.kt", i = {}, l = {9}, m = "isSuperVip", n = {}, s = {})
/* loaded from: classes33.dex */
public final class UserIDRequest$isSuperVip$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ UserIDRequest this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserIDRequest$isSuperVip$1(UserIDRequest userIDRequest, Continuation<? super UserIDRequest$isSuperVip$1> continuation) {
        super(continuation);
        this.this$0 = userIDRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.isSuperVip(null, this);
    }
}
