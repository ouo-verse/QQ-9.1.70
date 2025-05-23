package com.tencent.mobileqq.highway.conn;

import com.tencent.mobileqq.highway.utils.EndPoint;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface IConnectionListener {
    void onConnect(boolean z16, int i3, IConnection iConnection, EndPoint endPoint, int i16, ConnReportInfo connReportInfo);

    void onConnectionIdle(int i3, boolean z16);

    void onDisConnect(int i3, IConnection iConnection);

    void onRecvInvalidData(EndPoint endPoint, IConnection iConnection);
}
