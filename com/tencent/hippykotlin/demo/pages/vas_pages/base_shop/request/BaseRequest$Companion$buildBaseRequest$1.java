package com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request;

import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request.BaseRequest;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request.BaseRequest$Companion", f = "BaseRequest.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {17, 18, 19}, m = "buildBaseRequest", n = {"url", "req", "busi", "uin", "url", "req", "busi", "uin", "psKey"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
/* loaded from: classes33.dex */
public final class BaseRequest$Companion$buildBaseRequest$1 extends ContinuationImpl {
    public String L$0;
    public e L$1;
    public String L$2;
    public String L$3;
    public String L$4;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ BaseRequest.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseRequest$Companion$buildBaseRequest$1(BaseRequest.Companion companion, Continuation<? super BaseRequest$Companion$buildBaseRequest$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.buildBaseRequest(null, null, null, null, this);
    }
}
