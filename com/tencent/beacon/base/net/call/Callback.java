package com.tencent.beacon.base.net.call;

import com.tencent.beacon.base.net.NetException;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface Callback<T> {
    void onFailure(com.tencent.beacon.base.net.d dVar);

    void onResponse(T t16) throws NetException;
}
