package com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware;

import com.tencent.hippykotlin.demo.pages.vas_base.krequest.RequestConfig;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Response;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KClass;

/* compiled from: P */
/* loaded from: classes33.dex */
public abstract class Middleware {
    public abstract Object execute(RequestConfig requestConfig, Custom custom, Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object> function2, Continuation<? super Response> continuation);

    public KClass<? extends Custom> getCustom() {
        return null;
    }
}
