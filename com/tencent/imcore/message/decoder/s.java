package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class s implements j {
    static IPatchRedirector $redirector_;

    public s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean b(Message message) {
        int i3 = message.msgtype;
        if (i3 != -2002 && i3 != -1031) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, message, iMessageManager, appRuntime);
            return;
        }
        if (b(message)) {
            message.f203106msg = appRuntime.getApp().getString(R.string.ael);
            try {
                MessageForPtt messageForPtt = (MessageForPtt) ((IMessageFacade) appRuntime.getRuntimeService(IMessageFacade.class, "")).getMsgItemByUniseq(message.frienduin, message.istroop, message.uniseq);
                if (messageForPtt != null) {
                    message.pttUrl = messageForPtt.url;
                    message.f203106msg = messageForPtt.getSummaryMsg();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }
}
