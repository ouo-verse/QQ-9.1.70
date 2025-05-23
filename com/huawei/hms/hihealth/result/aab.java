package com.huawei.hms.hihealth.result;

import androidx.annotation.NonNull;
import com.huawei.hms.support.api.client.Result;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aab<T extends Result> {
    private T mResult;

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public T getResult() {
        return this.mResult;
    }

    public void setResult(@NonNull T t16) {
        this.mResult = t16;
    }
}
