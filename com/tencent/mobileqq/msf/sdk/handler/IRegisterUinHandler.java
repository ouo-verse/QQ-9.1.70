package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IRegisterUinHandler extends IMsfHandler {
    void onCheckQuickRegisterResp(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void onGetQuickRegisterResp(int i3, String str, String str2, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void onRegQueryAccountResp(int i3, byte[] bArr, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void onRegisterCommitMobileResp(int i3, byte[] bArr, byte[] bArr2, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void onRegisterCommitPassResp(int i3, String str, byte[] bArr, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void onRegisterCommitSmsCodeResp(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void onRegisterQuerySmsStatResp(int i3, byte[] bArr, int i16, int i17, String str, String str2, String str3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void onRegisterSendResendSmsreqResp(int i3, byte[] bArr, int i16, int i17, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);
}
