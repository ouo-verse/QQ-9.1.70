package com.tencent.mobileqq.transfile.predownload.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface IMonitorNetPowerApi extends QRouteApi {
    void reportNetInBackground(String str, String str2, String str3);
}
