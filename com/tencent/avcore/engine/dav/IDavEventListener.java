package com.tencent.avcore.engine.dav;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IDavEventListener {
    int getAPAndGateWayIP();

    long getMSFInviteMessageTimeStamp(long j3);

    int isOfflineSession(String str);

    void onCancelRequest(String str);

    void onChangePreviewSize(int i3, int i16);

    void onRejectVideo(String str);
}
