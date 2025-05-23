package com.tencent.mobileqq.activity.qqsettingme.api.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.qqsettingme.api.IVasApngUtilApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class VasApngUtilApiImpl implements IVasApngUtilApi {
    static IPatchRedirector $redirector_;

    public VasApngUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IVasApngUtilApi
    public String getAnimatePathByTag(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        return ThemeUtil.getAnimatePathByTag(i3);
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IVasApngUtilApi
    public URLDrawable getApngDrawable(AppRuntime appRuntime, String str, String str2, Drawable drawable, int[] iArr, String str3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 5, this, appRuntime, str, str2, drawable, iArr, str3, bundle);
        }
        return VasApngUtil.getApngDrawable(appRuntime, str, str2, drawable, iArr, str3, bundle);
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IVasApngUtilApi
    public URLDrawable getApngURLDrawable(String str, Drawable drawable, Bundle bundle, URLDrawable.URLDrawableListener uRLDrawableListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 2, this, str, drawable, bundle, uRLDrawableListener);
        }
        return VasApngUtil.getApngURLDrawable(str, new int[]{1}, drawable, bundle, uRLDrawableListener);
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IVasApngUtilApi
    public boolean isNowThemeIsAnimate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return ThemeUtil.isNowThemeIsAnimate();
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IVasApngUtilApi
    public boolean isSoundEffectsEnable(AppRuntime appRuntime, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime, (Object) context)).booleanValue();
        }
        ThemeUtil.ThemeInfo themeInfo = ThemeUtil.getThemeInfo(context, ThemeUtil.getUserCurrentThemeId(appRuntime));
        if (themeInfo != null && themeInfo.status.equals("5") && themeInfo.isVoiceTheme) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.api.IVasApngUtilApi
    public boolean updateIsDefaultTheme() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        String currentThemeId = ThemeUtil.getCurrentThemeId();
        if (!"1000".equals(currentThemeId) && !"999".equals(currentThemeId)) {
            return false;
        }
        return true;
    }
}
