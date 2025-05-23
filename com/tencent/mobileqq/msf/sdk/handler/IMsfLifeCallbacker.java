package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IMsfLifeCallbacker {
    void onBindEnd(boolean z16);

    void onBindStart();

    void onReceiveResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void onRecvServicePushResp(FromServiceMsg fromServiceMsg);

    void onReqServiceConn();

    void onRespToApp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void onSendMsg(ToServiceMsg toServiceMsg, boolean z16);

    void onSendToService(ToServiceMsg toServiceMsg, int i3);

    void onServiceConnected();

    void onServiceDisconnected();
}
