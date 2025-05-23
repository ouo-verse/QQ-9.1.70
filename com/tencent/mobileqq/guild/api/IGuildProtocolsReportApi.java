package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IGuildProtocolsReportApi extends QRouteApi {
    void endGuildMsgProtocolReport(int i3, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object... objArr);

    void startGuildMsgProtocolReport(ToServiceMsg toServiceMsg);
}
