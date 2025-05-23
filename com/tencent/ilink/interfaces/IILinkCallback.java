package com.tencent.ilink.interfaces;

import com.tencent.luggage.wxa.s0.b;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IILinkCallback {
    void onAvatarUpdate(int i3, String str);

    void onCloseSdkAccount(int i3);

    void onContactUpdate(int i3, String str, b bVar);

    void onContactVerifyRequestUpdate(String str, byte[] bArr);

    void onContactsCleared();

    void onCreateRoom(int i3, long j3, String str);

    void onDeviceShadowUpdate(byte[] bArr);

    void onGetDeviceShadow(int i3, int i16, byte[] bArr);

    void onGetPublicAccountQrCode(int i3, String str, int i16, int i17);

    void onGetThingTicket(int i3, String str, int i16, int i17);

    void onHandleContactVerifyRequestComplete(String str, int i3);

    void onHangupVoipComplete(int i3, String str);

    void onInitContacts(int i3);

    void onInitContactsComplete(int i3);

    void onInviteVoipComplete(int i3, String str, String str2);

    void onLoginComplete(int i3);

    void onLogoutComplete(int i3);

    void onNetStatusChanged(int i3);

    void onNicknameUpdate(int i3, String str);

    void onReceiveCertainMessage(int i3, byte[] bArr);

    void onReceiveILinkThirdNotify(int i3, String str);

    void onReceiveILinkVoipNotify(long j3, String str, String str2, String str3, boolean z16, int i3);

    void onReceiveMessage(String str, String str2, String str3, String str4, int i3);

    void onReportDataWithCacheKey(int i3);

    void onSendMsgResult(int i3, String str);

    void onThingTicketAndQrCodeTimeout();

    void onUpdateContactAlias(int i3, String str, String str2);

    void onUpdateDeviceShadow(int i3, int i16, byte[] bArr);

    void onVoipHanguped(String str, String str2, String str3, int i3);
}
