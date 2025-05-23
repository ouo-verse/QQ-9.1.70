package com.tencent.mobileqq.weather.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.weather.api.IWeatherReportApi;
import com.tencent.mobileqq.weather.b;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WeatherReportApiImpl implements IWeatherReportApi {
    static IPatchRedirector $redirector_;

    public WeatherReportApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherReportApi
    public void reportMaskAd(AppInterface appInterface, String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appInterface, str, obj);
        } else {
            b.a().f(appInterface, str, obj);
        }
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherReportApi
    public void reportWeather(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime, (Object) str);
        } else {
            b.a().e(appRuntime, "aio_page_arrive");
        }
    }
}
