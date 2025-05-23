package com.tencent.mobileqq.weather.util;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;

/* compiled from: P */
/* loaded from: classes20.dex */
public class i {
    static IPatchRedirector $redirector_;

    public static boolean a(Context context, String str) {
        return ((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).hasCoarseLocationPermission(context, str);
    }

    public static boolean b(Context context, String str) {
        if (!((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).hasLocationPermission(context, str) && !a(context, str)) {
            return false;
        }
        return true;
    }
}
