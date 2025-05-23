package com.tencent.mobileqq.automator.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.automator.a;
import com.tencent.mobileqq.automator.api.IAutomatorApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AutomatorApiImpl implements IAutomatorApi {
    static IPatchRedirector $redirector_;

    public AutomatorApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.automator.api.IAutomatorApi
    public int getInActionLoginB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        if (MobileQQ.sProcessId == 1) {
            return ((QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).mAutomator.getInActionLoginB();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.automator.api.IAutomatorApi
    public boolean isFirstLaunchNew() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return a.f199910a;
    }

    @Override // com.tencent.mobileqq.automator.api.IAutomatorApi
    public boolean isInRealActionLoginB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (MobileQQ.sProcessId == 1) {
            return ((QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).mAutomator.isInRealActionLoginB();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.automator.api.IAutomatorApi
    public boolean isLogining() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (MobileQQ.sProcessId != 1 || ((QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).mAutomator.f195305d != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.automator.api.IAutomatorApi
    public boolean isSyncNormalMsgFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (MobileQQ.sProcessId == 1) {
            return ((QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).mAutomator.isSyncNormalMsgFinish();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.automator.api.IAutomatorApi
    public boolean isSyncingMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (MobileQQ.sProcessId != 1) {
            return true;
        }
        return !((QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).mAutomator.H2();
    }
}
