package com.huawei.hms.support.api;

import com.huawei.hms.support.api.client.Result;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ResolveResult<T> extends Result {
    private T entity;

    public ResolveResult() {
        this.entity = null;
    }

    public T getValue() {
        return this.entity;
    }

    public ResolveResult(T t16) {
        this.entity = t16;
    }
}
