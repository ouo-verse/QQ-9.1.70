package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg$StructMsg;

/* compiled from: P */
/* loaded from: classes7.dex */
public class aa implements j {
    static IPatchRedirector $redirector_;

    public aa() {
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
        int i3 = message.msgtype;
        if (i3 == -2018 || i3 == -2050) {
            try {
                structmsg$StructMsg structmsg_structmsg = new structmsg$StructMsg();
                structmsg_structmsg.mergeFrom(message.msgData);
                message.f203106msg = MessageForSystemMsg.getSysMsgDesc(appRuntime.getApp().getResources(), structmsg_structmsg);
            } catch (Exception e16) {
                throw e16;
            }
        }
    }
}
