package com.tencent.hippy.qq.interpolators;

import com.tencent.hippy.qq.api.HippyInterpolator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weather.api.IWeatherHippyApi;

/* compiled from: P */
/* loaded from: classes7.dex */
public class WeatherInterpolator extends HippyInterpolator {
    @Override // com.tencent.hippy.qq.api.HippyInterpolator
    public boolean isCanPreload() {
        return ((IWeatherHippyApi) QRoute.api(IWeatherHippyApi.class)).canPreloadHippy();
    }
}
