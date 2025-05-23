package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IServerInfoHandler extends IMsfHandler {
    void onReportResp(int i3, int i16, String str, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);
}
