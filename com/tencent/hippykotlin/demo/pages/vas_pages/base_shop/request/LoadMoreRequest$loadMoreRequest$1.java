package com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request;

import com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request.LoadMoreRequest", f = "LoadMoreRequest.kt", i = {0, 0}, l = {18}, m = "loadMoreRequest", n = {"cxt", "block"}, s = {"L$0", "L$1"})
/* loaded from: classes33.dex */
public final class LoadMoreRequest$loadMoreRequest$1 extends ContinuationImpl {
    public VasBasePage L$0;
    public Function2 L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ LoadMoreRequest this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadMoreRequest$loadMoreRequest$1(LoadMoreRequest loadMoreRequest, Continuation<? super LoadMoreRequest$loadMoreRequest$1> continuation) {
        super(continuation);
        this.this$0 = loadMoreRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadMoreRequest(null, null, null, null, this);
    }
}
