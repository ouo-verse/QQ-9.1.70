package com.tencent.mobileqq.zplan.web.impl;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/web/impl/CommonNative2JsEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "methodName", "", "params", "(Ljava/lang/String;Ljava/lang/String;)V", "getMethodName", "()Ljava/lang/String;", "getParams", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class CommonNative2JsEvent extends SimpleBaseEvent {
    private final String methodName;
    private final String params;

    public CommonNative2JsEvent(String methodName, String params) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(params, "params");
        this.methodName = methodName;
        this.params = params;
    }

    public final String getMethodName() {
        return this.methodName;
    }

    public final String getParams() {
        return this.params;
    }
}
