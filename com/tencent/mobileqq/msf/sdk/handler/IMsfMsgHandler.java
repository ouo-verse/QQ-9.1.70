package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IMsfMsgHandler extends IMsfHandler {
    void onRecvResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);
}
