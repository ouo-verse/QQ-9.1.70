package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* loaded from: classes15.dex */
public interface IPushHandler extends IMsfHandler {
    void onOverloadPushNotify(String str);

    void onProxyIpChanged(String str);

    void onRecvCmdPush(FromServiceMsg fromServiceMsg);

    void onRegisterCmdPushResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void onRegisterPushResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void onResetCmdPushResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void onSecDispatchToAppEvent(FromServiceMsg fromServiceMsg);

    void onTicketChanged(FromServiceMsg fromServiceMsg);

    void onUnRegisterPushResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);
}
