package com.tencent.mobileqq.qqcommon.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqcommon.api.IViewUtilsApi;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ViewUtilsApiImpl implements IViewUtilsApi {
    static IPatchRedirector $redirector_;

    public ViewUtilsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IViewUtilsApi
    public int dpToPx(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16))).intValue();
        }
        return ViewUtils.dpToPx(f16);
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IViewUtilsApi
    public int getScreenHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return ViewUtils.getScreenHeight();
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IViewUtilsApi
    public int getScreenWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return ViewUtils.getScreenWidth();
    }
}
