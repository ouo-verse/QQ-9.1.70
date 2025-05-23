package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.qphone.base.remote.FromServiceMsg;

/* loaded from: classes15.dex */
public interface IServerMsgPushHandler extends IMsfHandler {
    void onConnClose(FromServiceMsg fromServiceMsg);

    void onConnOpened(FromServiceMsg fromServiceMsg);

    void onOpenConnAllFailed(FromServiceMsg fromServiceMsg);

    void onReceFirstResp(FromServiceMsg fromServiceMsg);

    void onRecvServerConfigPush(FromServiceMsg fromServiceMsg);
}
