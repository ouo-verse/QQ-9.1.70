package com.huawei.hms.support.api.client;

import com.huawei.hms.support.api.client.Result;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class ConvertedResult<R extends Result> {
    public abstract <S extends Result> ConvertedResult<S> convertResult(ResultConvert<? super R, ? extends S> resultConvert);

    public abstract void finalExec(ResultCallbacks<? super R> resultCallbacks);
}
