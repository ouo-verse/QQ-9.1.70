package com.tencent.mobileqq.app;

import android.app.Notification;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.AppStatusCallbackSingleton;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b implements AppStatusCallbackSingleton.IAppStatusCallback {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.AppStatusCallbackSingleton.IAppStatusCallback
    public String getKeyOfLeftViewText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return AppConstants.LeftViewText.LEFTVIEWTEXT;
    }

    @Override // com.tencent.mobileqq.app.AppStatusCallbackSingleton.IAppStatusCallback
    public String getKeyOfSelfSetLeftViewText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT;
    }

    @Override // com.tencent.mobileqq.app.AppStatusCallbackSingleton.IAppStatusCallback
    public boolean isDebugVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.AppStatusCallbackSingleton.IAppStatusCallback
    public boolean isTalkBackOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return AppSetting.f99565y;
    }

    @Override // com.tencent.mobileqq.app.AppStatusCallbackSingleton.IAppStatusCallback
    public Notification makeFakeNotificationForProcessKeepAlive(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Notification) iPatchRedirector.redirect((short) 6, (Object) this, z16);
        }
        return CoreService.fakeNotification(z16);
    }
}
