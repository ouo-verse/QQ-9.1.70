package com.tencent.mobileqq.weather.api.impl;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.weather.a;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.weather.c;
import com.tencent.mobileqq.weather.debug.WeatherDebugFragment;
import com.tencent.mobileqq.weather.util.b;
import com.tencent.mobileqq.weather.util.g;
import com.tencent.mobileqq.weather.webpage.d;
import com.tencent.mobileqq.weather.webpage.f;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WeatherCommApiImpl implements IWeatherCommApi {
    static IPatchRedirector $redirector_;

    public WeatherCommApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherCommApi
    public void enterWeatherModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            QQPermission.enterModule("biz_src_qqweather");
        }
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherCommApi
    public void exitWeatherModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            QQPermission.exitModule("biz_src_qqweather");
        }
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherCommApi
    public String getGdtDeviceInfoBase64() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return f.f();
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherCommApi
    public Class getParserClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Class) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return a.class;
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherCommApi
    public boolean hasCoarseLocationPermission(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) context, (Object) str)).booleanValue();
        }
        Activity activity = QBaseActivity.sTopActivity;
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig("biz_src_qqweather", str));
        if (qQPermission != null && qQPermission.hasPermission(QQPermissionConstants.Business.ID.QQ_WEATHER, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherCommApi
    public boolean hasLocationPermission(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) context, (Object) str)).booleanValue();
        }
        Activity activity = QBaseActivity.sTopActivity;
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig("biz_src_qqweather", str));
        if (qQPermission != null && qQPermission.hasPermission(QQPermissionConstants.Business.ID.QQ_WEATHER, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherCommApi
    public boolean isWeatherArkPageUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str)).booleanValue();
        }
        return b.h(str);
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherCommApi
    public boolean isWeatherPA(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str)).booleanValue();
        }
        return b.i(str);
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherCommApi
    public void openWeatherByScheme(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) str);
        } else {
            f.h(context, str);
        }
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherCommApi
    public void openWeatherMainPage(Context context, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) context, (Object) hashMap);
        } else if (g.f313646a.G(hashMap)) {
            f.o(context, hashMap);
        } else {
            f.n(context, hashMap);
        }
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherCommApi
    public void openWeatherWebForHippy(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) context, (Object) str);
        } else {
            f.i(context, str, "");
        }
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherCommApi
    public void openWeatherWebPage(Context context, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, context, str, str2);
        } else {
            f.j(context, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherCommApi
    public void preloadWebProcessAsync(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            d.j(i3);
        }
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherCommApi
    public boolean startNewWeatherWebPageActivity(Context context, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? f.l(context, appInterface, "") : ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) appInterface)).booleanValue();
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherCommApi
    public void startNewWeatherWebPageActivityByFollowState(Context context, AppInterface appInterface, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, appInterface, Integer.valueOf(i3), str);
        } else {
            f.q(context, appInterface, i3, str);
        }
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherCommApi
    public boolean startNewWeatherWebPageActivityBySearch(Context context, AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) appInterface)).booleanValue();
        }
        return f.k(context, appInterface, new com.tencent.mobileqq.weather.util.a(false, "", true, String.valueOf(QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").decodeInt("cur_adcode", 0)), ""));
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherCommApi
    public void startWeatherDebugFragment(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) activity);
        } else {
            WeatherDebugFragment.Bh(activity);
        }
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherCommApi
    public void startWeatherWebPageActivity(Context context, AppInterface appInterface, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, appInterface, Integer.valueOf(i3), str);
        } else {
            f.q(context, appInterface, i3, str);
        }
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherCommApi
    public String transformUrlToScheme(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        return com.tencent.mobileqq.weather.util.d.o(str);
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherCommApi
    public void translate(AppInterface appInterface, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, appInterface, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            c.a(appInterface, i3, i16, i17);
        }
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherCommApi
    public boolean startNewWeatherWebPageActivity(Context context, AppInterface appInterface, com.tencent.mobileqq.weather.util.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? f.k(context, appInterface, aVar) : ((Boolean) iPatchRedirector.redirect((short) 3, this, context, appInterface, aVar)).booleanValue();
    }
}
