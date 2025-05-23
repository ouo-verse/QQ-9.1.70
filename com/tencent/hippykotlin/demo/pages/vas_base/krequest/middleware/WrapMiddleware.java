package com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware;

import com.tencent.hippykotlin.demo.pages.vas_base.krequest.RequestConfig;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Response;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class WrapMiddleware extends Middleware {

    /* renamed from: fn, reason: collision with root package name */
    public final Function3<RequestConfig, Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object>, Continuation<? super Response>, Object> f114310fn;

    /* JADX WARN: Multi-variable type inference failed */
    public WrapMiddleware(Function3<? super RequestConfig, ? super Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object>, ? super Continuation<? super Response>, ? extends Object> function3) {
        this.f114310fn = function3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.Middleware
    public final Object execute(RequestConfig requestConfig, Custom custom, Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object> function2, Continuation<? super Response> continuation) {
        return this.f114310fn.invoke(requestConfig, function2, continuation);
    }
}
