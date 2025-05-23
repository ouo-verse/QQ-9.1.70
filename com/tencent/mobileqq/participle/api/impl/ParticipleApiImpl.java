package com.tencent.mobileqq.participle.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.participle.ParticipleHandler;
import com.tencent.mobileqq.participle.api.IParticipleApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class ParticipleApiImpl implements IParticipleApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ParticipleApiImpl";

    public ParticipleApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private ParticipleHandler getHandler(AppInterface appInterface) {
        return (ParticipleHandler) appInterface.getBusinessHandler(ParticipleHandler.class.getName());
    }

    @Override // com.tencent.mobileqq.participle.api.IParticipleApi
    public void participleTheContent(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            participleTheContent(appInterface, str, "");
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.participle.api.IParticipleApi
    public void participleTheContent(AppInterface appInterface, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appInterface, str, str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "participleTheContent : content -> " + str + ", senderUin -> " + str2);
        }
        getHandler(appInterface).participleTheContent(appInterface, str, str2);
    }
}
