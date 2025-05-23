package com.tencent.hippykotlin.demo.pages.vas_base.krequest;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class Middlewares {
    public static final Middlewares INSTANCE = new Middlewares();
    public static final Function3<RequestConfig, Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object>, Continuation<? super Response>, Object> qqLogin = new Middlewares$qqLogin$1(null);

    static {
        new Middlewares$traceContext$1(null);
    }
}
