package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IErrorHandler {
    void onGrayError(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16);

    void onInvalidSign(boolean z16);

    void onKicked(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16);

    void onKickedAndClearToken(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16);

    void onRecvServerTip(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16);

    void onServerSuspended(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16);

    void onUserTokenExpired(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, boolean z16);
}
