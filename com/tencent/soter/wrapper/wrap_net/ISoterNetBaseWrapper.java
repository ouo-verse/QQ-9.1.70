package com.tencent.soter.wrapper.wrap_net;

import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface ISoterNetBaseWrapper<W, T> {
    void execute();

    void setCallback(ISoterNetCallback<T> iSoterNetCallback);

    void setRequest(@NonNull W w3);
}
