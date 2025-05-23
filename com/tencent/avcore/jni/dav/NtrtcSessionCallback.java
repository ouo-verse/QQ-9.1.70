package com.tencent.avcore.jni.dav;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface NtrtcSessionCallback {
    void onAnotherTerminalHaveProcessedInvitation(String str, boolean z16, long j3, long j16);

    void onAvsdkHaveAutoAcceptedInvitation(String str, int i3);

    void onChannelReadyResult(String str, int i3, long j3, boolean z16, boolean z17, String str2);

    void onCloseSession(String str, int i3, long j3, byte[] bArr, int i16, String str2, boolean z16);

    void onInvitationReached(String str, int i3, int i16, String str2);

    void onNotifyAnotherTerminalChatingState(String str, long j3, int i3);

    void onPeerSwitchTerminal(String str, boolean z16, int i3, int i16, long j3, String str2);

    void onPeerSwitchToMulti(String str);

    void onPeerSwitchToScreenShare(String str);

    void onProcessInvitationResult(String str, int i3, String str2);

    void onRecvInvitation(String str, boolean z16, int i3, long j3, long j16, int i16, int i17, byte[] bArr, byte[] bArr2);
}
