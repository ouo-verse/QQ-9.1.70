package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface INotifyHandler extends IMsfHandler {
    void onRecvNotify(long j3, FromServiceMsg fromServiceMsg);

    void onRegisterNotifyResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void onUnRegisterNotifyResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);
}
