package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class w implements j {
    static IPatchRedirector $redirector_;

    public w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, message, iMessageManager, appRuntime);
            return;
        }
        if (message.msgtype == -2020) {
            message.f203106msg = appRuntime.getApp().getString(R.string.hid);
            if (com.tencent.mobileqq.service.message.remote.a.b(message.issend)) {
                message.f203106msg = appRuntime.getApp().getString(R.string.hie, com.tencent.mobileqq.utils.ac.s((QQAppInterface) appRuntime, message.frienduin, "", 0, 0));
            } else {
                message.f203106msg = appRuntime.getApp().getString(R.string.hid);
            }
        }
    }
}
