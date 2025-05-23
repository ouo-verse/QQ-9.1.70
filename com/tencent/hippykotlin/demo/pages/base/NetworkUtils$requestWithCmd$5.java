package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.base.NetworkUtils", f = "NetworkUtils.kt", i = {0}, l = {159}, m = "requestWithCmd", n = {"rspFactory"}, s = {"L$0"})
/* loaded from: classes31.dex */
public final class NetworkUtils$requestWithCmd$5<REQ extends ISSOModel, RSP> extends ContinuationImpl {
    public ISSOModelFactory L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ NetworkUtils this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkUtils$requestWithCmd$5(NetworkUtils networkUtils, Continuation<? super NetworkUtils$requestWithCmd$5> continuation) {
        super(continuation);
        this.this$0 = networkUtils;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.requestWithCmd(null, null, null, this);
    }
}
