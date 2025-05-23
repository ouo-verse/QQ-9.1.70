package com.tencent.mobileqq.app.api.impl;

import android.content.Context;
import android.view.Window;
import com.tencent.mobileqq.app.ScreenShot;
import com.tencent.mobileqq.app.api.IScreenShot;
import com.tencent.mobileqq.app.api.IScreenShotService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ScreenShotServiceImpl implements IScreenShotService {
    static IPatchRedirector $redirector_;

    public ScreenShotServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.api.IScreenShotService
    public void logForDev(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            ScreenShot.s(str);
        }
    }

    @Override // com.tencent.mobileqq.app.api.IScreenShotService
    public IScreenShot newInstance(Context context, Window window) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IScreenShot) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) window);
        }
        return new a(context, window);
    }
}
