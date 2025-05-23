package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IAuthHandler extends IMsfHandler {
    void onDelLoginedAccountResp(int i3, int i16, String str, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void onGetKeyResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void onGetSidResp(int i3, int i16, String str, String str2, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void onGetUinSignResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, byte[] bArr);

    void onReceVerifyCode(VerifyCodeInfo verifyCodeInfo, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void onRecvChangeTokenResp(int i3, int i16, String str, RespondCustomSig respondCustomSig, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void onRecvChangeUinLoginResp(int i3, int i16, String str, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void onRecvChangeUinResp(int i3, int i16, String str, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void onRecvLoginResp(int i3, int i16, String str, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void onRefreSidResp(int i3, int i16, String str, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);
}
