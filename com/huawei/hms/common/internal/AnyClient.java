package com.huawei.hms.common.internal;

import com.huawei.hms.core.aidl.IMessageEntity;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface AnyClient {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface CallBack {
        void onCallback(IMessageEntity iMessageEntity, String str);
    }

    void connect(int i3);

    void connect(int i3, boolean z16);

    void disconnect();

    int getRequestHmsVersionCode();

    String getSessionId();

    boolean isConnected();

    boolean isConnecting();

    void post(IMessageEntity iMessageEntity, String str, CallBack callBack);
}
