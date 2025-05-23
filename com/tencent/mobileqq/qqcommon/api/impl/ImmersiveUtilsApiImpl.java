package com.tencent.mobileqq.qqcommon.api.impl;

import android.content.Context;
import android.view.Window;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqcommon.api.IImmersiveUtilsApi;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ImmersiveUtilsApiImpl implements IImmersiveUtilsApi {
    static IPatchRedirector $redirector_;

    public ImmersiveUtilsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IImmersiveUtilsApi
    public int getStatusBarHeight(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context)).intValue();
        }
        return ImmersiveUtils.getStatusBarHeight(context);
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IImmersiveUtilsApi
    public boolean setStatusBarDarkMode(Window window, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, window, Boolean.valueOf(z16))).booleanValue();
        }
        return ImmersiveUtils.setStatusBarDarkMode(window, z16);
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IImmersiveUtilsApi
    public boolean setStatusTextColor(boolean z16, Window window) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), window)).booleanValue();
        }
        return ImmersiveUtils.setStatusTextColor(z16, window);
    }
}
