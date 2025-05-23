package com.tencent.mobileqq.qqlive.api.monitor;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.superplayer.api.ISuperPlayer;

@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface ISuperPlayerTrafficFlowReportApi extends QRouteApi {
    ISuperPlayerTrafficFlowReporter getTrafficFlowReporter(String str, ISuperPlayer iSuperPlayer, IResourceProvider iResourceProvider);
}
