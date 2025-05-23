package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes19.dex */
public interface ITroopEnterEffectApi extends QRouteApi {
    void sendGetBaseVipInfoReq(AppRuntime appRuntime, String str, String str2);

    void sendTroopEnterEffectCMD(AppRuntime appRuntime, long j3, long j16);
}
