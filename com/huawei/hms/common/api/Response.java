package com.huawei.hms.common.api;

import com.huawei.hms.support.api.client.Result;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Response<T extends Result> {
    protected T result;

    public Response() {
    }

    protected T getResult() {
        return this.result;
    }

    public void setResult(T t16) {
        this.result = t16;
    }

    protected Response(T t16) {
        this.result = t16;
    }
}
