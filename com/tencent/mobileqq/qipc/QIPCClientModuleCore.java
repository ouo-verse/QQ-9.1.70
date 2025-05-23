package com.tencent.mobileqq.qipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.MobileQQ;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes16.dex */
public class QIPCClientModuleCore extends QIPCModule {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_IS_MODULE_RUNNING = "isrun";
    public static final String NAME = "QIPCClientModuleCore";
    public static final String PARAM_KEY_MODULEID = "module_id";

    public QIPCClientModuleCore() {
        super(NAME);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public EIPCResult isModuleRunning(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) bundle);
        }
        boolean z16 = false;
        try {
            String string = bundle.getString("module_id");
            z16 = MobileQQ.sMobileQQ.isModuleLoaded(string);
            if (!z16) {
                z16 = MobileQQ.sMobileQQ.waitAppRuntime().isModuleRunning(string);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (z16) {
            return EIPCResult.createSuccessResult(null);
        }
        return EIPCResult.createResult(-102, null);
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.name, 2, "action = " + str + ", params = " + bundle);
        }
        if (TextUtils.equals(str, ACTION_IS_MODULE_RUNNING)) {
            return isModuleRunning(str, bundle);
        }
        return null;
    }
}
