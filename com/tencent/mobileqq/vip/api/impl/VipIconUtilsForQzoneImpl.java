package com.tencent.mobileqq.vip.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vip.api.IVipIconUtilsForQzone;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VipIconUtilsForQzoneImpl implements IVipIconUtilsForQzone {
    static IPatchRedirector $redirector_;

    public VipIconUtilsForQzoneImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.vip.api.IVipIconUtilsForQzone
    public Drawable getQzoneLetterSwitchIcon(String str, List<String> list, String str2, String str3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, this, str, list, str2, str3, Integer.valueOf(i3));
        }
        j jVar = new j(str, list, str2, str3);
        jVar.F(false);
        return jVar;
    }
}
