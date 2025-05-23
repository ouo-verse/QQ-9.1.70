package com.tencent.hippykotlin.demo.pages.vas_base.krequest.adapter;

import com.tencent.hippykotlin.demo.pages.vas_base.krequest.RequestConfig;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Response;
import kotlin.coroutines.Continuation;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface Adapter {
    boolean adapt(RequestConfig requestConfig);

    Object request(RequestConfig requestConfig, Continuation<? super Response> continuation);
}
