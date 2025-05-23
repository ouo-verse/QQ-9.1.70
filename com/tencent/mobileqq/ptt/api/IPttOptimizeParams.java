package com.tencent.mobileqq.ptt.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPttOptimizeParams extends QRouteApi {
    boolean doesSupportActivateNet(AppRuntime appRuntime);

    boolean doesSupportDirectDownload(AppRuntime appRuntime);

    boolean doesSupportHttpSideWay(AppRuntime appRuntime);

    boolean doesSupportSSCM(AppRuntime appRuntime);

    int getFixScheduleTryCount_dpc(AppRuntime appRuntime);

    long getOptString(AppRuntime appRuntime, boolean z16);

    int getTryCount_dpc(AppRuntime appRuntime);

    int getTryTime_dpc(AppRuntime appRuntime);

    void initOptimizeCfg(AppRuntime appRuntime, boolean z16);

    void savePttOptimizeCfg(AppRuntime appRuntime, String str);
}
