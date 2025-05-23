package com.tencent.mobileqq.webview.swift.component.navigate;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.webview.swift.d;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b implements d {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.d
    public boolean navigateToAnotherActivity(Intent intent, Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, intent, activity, str)).booleanValue();
        }
        IWeatherCommApi iWeatherCommApi = (IWeatherCommApi) QRoute.api(IWeatherCommApi.class);
        if (iWeatherCommApi.isWeatherArkPageUrl(str)) {
            try {
                if (!intent.getBooleanExtra("is_to_ark", false)) {
                    String transformUrlToScheme = iWeatherCommApi.transformUrlToScheme(str);
                    if (!TextUtils.isEmpty(transformUrlToScheme)) {
                        iWeatherCommApi.openWeatherByScheme(activity, transformUrlToScheme);
                        return true;
                    }
                }
            } catch (Exception e16) {
                QLog.i("WeatherNavigationItem", 1, "weather", e16);
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.d
    public boolean needSwitchFragment(Intent intent, Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, intent, activity, str)).booleanValue();
        }
        return false;
    }
}
