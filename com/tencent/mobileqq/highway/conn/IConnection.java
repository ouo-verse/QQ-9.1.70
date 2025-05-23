package com.tencent.mobileqq.highway.conn;

import com.tencent.mobileqq.highway.utils.EndPoint;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface IConnection {
    boolean connect();

    void disConnect();

    int getConnId();

    EndPoint getEndPoint();

    int getProtoType();

    boolean isIpv6();

    boolean isWritable();

    void setConnectListener(IConnectionListener iConnectionListener);

    void setUrgentFlag(boolean z16);

    void wakeupChannel();
}
