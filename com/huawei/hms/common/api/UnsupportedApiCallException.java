package com.huawei.hms.common.api;

import com.huawei.hms.common.Feature;

/* compiled from: P */
@Deprecated
/* loaded from: classes2.dex */
public final class UnsupportedApiCallException extends UnsupportedOperationException {
    private final Feature feature;

    public UnsupportedApiCallException(Feature feature) {
        this.feature = feature;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.feature + " is unsupported";
    }
}
