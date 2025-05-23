package com.tencent.mobileqq.activity.qqsettingme.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ThemeUtilApiImpl implements IThemeUtilApi {
    static IPatchRedirector $redirector_;

    public ThemeUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi
    public Bundle getCurrentThemeInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bundle) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return ThemeUtil.getCurrentThemeInfo();
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi
    public boolean isDartStatusBar(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, i3)).booleanValue();
        }
        return ThemeUtil.isDartStatusBar(context, i3);
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi
    public boolean isGoldenTheme() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return ThemeUtil.isGoldenTheme();
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi
    public boolean isInNightMode(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime)).booleanValue();
        }
        return ThemeUtil.isInNightMode(appRuntime);
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi
    public boolean isNowThemeIsDefault(AppRuntime appRuntime, boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, appRuntime, Boolean.valueOf(z16), str)).booleanValue();
        }
        return ThemeUtil.isNowThemeIsDefault(appRuntime, z16, str);
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi
    public boolean isNowThemeIsNight(AppRuntime appRuntime, boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, appRuntime, Boolean.valueOf(z16), str)).booleanValue();
        }
        return ThemeUtil.isNowThemeIsNight(appRuntime, z16, str);
    }
}
