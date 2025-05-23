package com.tencent.hippykotlin.demo.pages.qwallet.base.http;

import c45.d;
import com.tencent.hippykotlin.demo.pages.qwallet.base.http.interceptor.InterceptorData;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qwallet.base.http.QWalletGatewayServlet", f = "QWalletGatewayServlet.kt", i = {0, 0, 0, 0}, l = {70}, m = "sendRequest", n = {"this", "cacheId", "interceptorData", "finalInterceptors"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes33.dex */
public final class QWalletGatewayServlet$sendRequest$2<Req extends d, Rsp extends d> extends ContinuationImpl {
    public QWalletGatewayServlet L$0;
    public String L$1;
    public InterceptorData L$2;
    public List L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ QWalletGatewayServlet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QWalletGatewayServlet$sendRequest$2(QWalletGatewayServlet qWalletGatewayServlet, Continuation<? super QWalletGatewayServlet$sendRequest$2> continuation) {
        super(continuation);
        this.this$0 = qWalletGatewayServlet;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sendRequest(null, null, null, null, null, false, false, null, this);
    }
}
