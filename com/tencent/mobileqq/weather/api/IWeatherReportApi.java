package com.tencent.mobileqq.weather.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IWeatherReportApi extends QRouteApi {
    void reportMaskAd(AppInterface appInterface, String str, Object obj);

    void reportWeather(AppRuntime appRuntime, String str);
}
