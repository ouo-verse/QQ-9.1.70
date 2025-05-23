package com.tencent.mobileqq.qqcommon.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqcommon.api.ILiuHaiUtilsApi;
import com.tencent.util.LiuHaiUtils;

/* compiled from: P */
/* loaded from: classes16.dex */
public class LiuHaiUtilsApiImpl implements ILiuHaiUtilsApi {
    static IPatchRedirector $redirector_;

    public LiuHaiUtilsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.ILiuHaiUtilsApi
    public int getNotchHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return LiuHaiUtils.sNotchHeight;
    }

    @Override // com.tencent.mobileqq.qqcommon.api.ILiuHaiUtilsApi
    public void initLiuHaiProperty(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
        } else {
            LiuHaiUtils.initLiuHaiProperty(activity);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.ILiuHaiUtilsApi
    public boolean isHasNotch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return LiuHaiUtils.sHasNotch;
    }
}
