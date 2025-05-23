package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes12.dex */
public class VasQuickUpdateManagerProxy extends AbsEmoRuntimeServiceProxy<IVasQuickUpdateService> {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "VasQuickUpdateManagerProxy";

    public VasQuickUpdateManagerProxy(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface, IVasQuickUpdateService.class);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
        }
    }

    public void removeCallBacker(CallBacker callBacker) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) callBacker);
        } else if (this.manager != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "do removeCallBacker.");
            }
            ((IVasQuickUpdateService) this.manager).removeCallBacker(callBacker);
        }
    }
}
