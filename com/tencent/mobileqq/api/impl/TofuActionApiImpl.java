package com.tencent.mobileqq.api.impl;

import com.tencent.mobileqq.api.ITofuActionApi;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tofumsg.b;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class TofuActionApiImpl implements ITofuActionApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TofuActionApiImpl";

    public TofuActionApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.api.ITofuActionApi
    public void enableNewYearTofuUpdate(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime, (Object) str);
        } else if (appRuntime == null) {
            QLog.i(TAG, 1, "enableNewYearTofuUpdate::: appRuntime is null, return");
        } else {
            ((b) appRuntime.getManager(QQManagerFactory.NEW_TOFU_MANAGER)).S1(str);
        }
    }

    @Override // com.tencent.mobileqq.api.ITofuActionApi
    public int getNormalOnlineStatusBeancurdBusId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 18;
    }

    @Override // com.tencent.mobileqq.api.ITofuActionApi
    public int getOnlineStatusBeancurdBusiId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 16;
    }

    @Override // com.tencent.mobileqq.api.ITofuActionApi
    public boolean isEnableNewYearTofu(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) appRuntime)).booleanValue();
        }
        if (appRuntime == null) {
            QLog.i(TAG, 1, "isEnableNewYearTofu::: appRuntime is null, return");
            return false;
        }
        return ((b) appRuntime.getManager(QQManagerFactory.NEW_TOFU_MANAGER)).g4();
    }

    @Override // com.tencent.mobileqq.api.ITofuActionApi
    public boolean isEnableTofuMsgDelete(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) appRuntime)).booleanValue();
        }
        if (appRuntime == null) {
            QLog.i(TAG, 1, "isEnableTofuMsgDelete::: appRuntime is null, return");
            return false;
        }
        return ((b) appRuntime.getManager(QQManagerFactory.NEW_TOFU_MANAGER)).e3();
    }

    @Override // com.tencent.mobileqq.api.ITofuActionApi
    public void saveAvatarStatusView(AppRuntime appRuntime, com.tencent.mobileqq.beancurd.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime, (Object) bVar);
        } else if (appRuntime == null) {
            QLog.i(TAG, 1, "saveAvatarStatusView::: appRuntime is null, return");
        } else {
            ((b) appRuntime.getManager(QQManagerFactory.NEW_TOFU_MANAGER)).saveAvatarStatusView(appRuntime, bVar);
        }
    }

    @Override // com.tencent.mobileqq.api.ITofuActionApi
    public void trigToGetAvatarStatusInfo(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime, (Object) str);
        } else if (appRuntime == null) {
            QLog.i(TAG, 1, "trigToGetAvatarStatusInfo::: appRuntime is null, return");
        } else {
            ((b) appRuntime.getManager(QQManagerFactory.NEW_TOFU_MANAGER)).C3(str);
        }
    }

    @Override // com.tencent.mobileqq.api.ITofuActionApi
    public void tryUpdateFriendAvatarSwitch(AppRuntime appRuntime, ec2.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appRuntime, (Object) bVar);
        } else if (appRuntime == null) {
            QLog.i(TAG, 1, "tryUpdateFriendAvatarSwitch::: appRuntime is null, return");
        } else {
            ((b) appRuntime.getManager(QQManagerFactory.NEW_TOFU_MANAGER)).h2(bVar);
        }
    }
}
