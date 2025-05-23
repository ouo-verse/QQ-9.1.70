package com.tencent.mobileqq.highway.segment;

import com.tencent.mobileqq.highway.conn.IConnection;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface IRequestListener {
    void handleConnClosed();

    void handleError(int i3, String str, IConnection iConnection);

    void handleResponse(HwResponse hwResponse);

    void handleSendBegin(int i3);

    void handleSendEnd(int i3, int i16);

    void handleSendTimeOut();

    void handleWriteTimeout();
}
