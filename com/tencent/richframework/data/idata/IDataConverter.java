package com.tencent.richframework.data.idata;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IDataConverter<S> {
    @NonNull
    S cloneConvertData(S s16);

    String getObserverKey(S s16);

    void update(@NonNull S s16, @NonNull S s17);
}
