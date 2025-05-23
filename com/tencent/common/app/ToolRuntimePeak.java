package com.tencent.common.app;

import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgift.runtime.QQGiftToolAppInterface;
import com.tencent.mobileqq.qqlive.runtime.QQLiveToolAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes5.dex */
public class ToolRuntimePeak extends ToolRuntimeBase {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final String f99534d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66019);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f99534d = ToolAppRuntime.class.getSimpleName();
        }
    }

    public ToolRuntimePeak() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private AppRuntime f() {
        if (isModuleRunning("peak")) {
            return getAppRuntime("peak");
        }
        return null;
    }

    @Override // mqq.app.AppRuntime
    public boolean highPriorityWhenBackground() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        AppRuntime f16 = f();
        if (f16 != null) {
            z16 = f16.highPriorityWhenBackground();
            QLog.e(f99534d, 1, "highPriorityWhenBackground isWinkLive=" + z16);
        } else {
            z16 = false;
        }
        if (z16 || super.highPriorityWhenBackground()) {
            return true;
        }
        return false;
    }

    @Override // mqq.app.AppRuntime
    public AppRuntime onGetSubRuntime(String str) {
        AppRuntime appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if ("peak".equals(str)) {
            appRuntime = new PeakAppInterface(application, "peak");
        } else if ("qq_live_tool".equals(str)) {
            appRuntime = new QQLiveToolAppInterface(application, MobileQQ.processName);
        } else if ("qq_gift_tool".equals(str)) {
            appRuntime = new QQGiftToolAppInterface(application, MobileQQ.processName);
        } else {
            appRuntime = null;
        }
        if (QLog.isColorLevel()) {
            QLog.i(f99534d, 2, "ToolRuntimePeak.onGetSubRuntime() moduleId " + str + " appInstance = " + appRuntime);
        }
        return appRuntime;
    }
}
