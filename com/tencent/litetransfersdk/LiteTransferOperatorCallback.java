package com.tencent.litetransfersdk;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface LiteTransferOperatorCallback {
    void GetThumbFilePath(int i3, Session session);

    void HandleSession(int i3, long j3, int i16, MsgHeader msgHeader);

    void InvokeReport(ReportItem reportItem);

    boolean OnQueryAutoDownload(long j3, byte b16);

    void SendPbMsg(int i3, MsgCSBody msgCSBody);

    boolean getAutoDownload();
}
