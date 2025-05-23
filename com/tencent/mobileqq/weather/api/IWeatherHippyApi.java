package com.tencent.mobileqq.weather.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IWeatherHippyApi extends QRouteApi {
    boolean canPreloadHippy();

    HippyAPIProvider createHippyProvider();

    boolean isWeatherModule(String str);
}
