package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.qphone.base.remote.FromServiceMsg;

/* loaded from: classes15.dex */
public interface IMsgPushMonitorHandler {
    void onMSFConnectSuccess(FromServiceMsg fromServiceMsg);

    void onMSFServiceInit();

    void onMSFStartConnect(FromServiceMsg fromServiceMsg);

    void onRegisterMSFService();

    void onRegisterProxyRsp();

    void onSendRegisterProxyReq();
}
