package com.tencent.mobileqq.app.msgnotify.api.impl;

import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog;
import com.tencent.mobileqq.app.msgnotify.api.IMsgNotifyPushDialog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* loaded from: classes11.dex */
public class MsgNotifyPushDialogImpl implements IMsgNotifyPushDialog {
    static IPatchRedirector $redirector_;

    public MsgNotifyPushDialogImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.msgnotify.api.IMsgNotifyPushDialog
    public void parsePushOpenNotifyXML(AppRuntime appRuntime, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, str, Boolean.valueOf(z16));
        } else {
            MsgNotifyPushDialog.c0(appRuntime, str, z16);
        }
    }
}
