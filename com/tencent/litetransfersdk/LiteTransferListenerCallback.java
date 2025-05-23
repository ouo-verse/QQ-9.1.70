package com.tencent.litetransfersdk;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface LiteTransferListenerCallback {
    void OnGroupComplete(int i3, int i16);

    void OnGroupStart(int i3);

    void OnSessionComplete(long j3, int i3, int i16);

    void OnSessionConnected(long j3, int i3, int i16);

    void OnSessionNew(Session session, NFCInfo nFCInfo, FTNInfo fTNInfo);

    void OnSessionProgress(long j3, long j16, long j17, int i3);

    void OnSessionStart(long j3);

    void OnSessionStartRun(long j3);

    void OnSessionUpdate(int i3, long j3, String str);
}
