package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQText;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class n implements j {
    static IPatchRedirector $redirector_;

    public n() {
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
        if (message.msgtype == -1035) {
            MessageForMixedMsg messageForMixedMsg = new MessageForMixedMsg();
            messageForMixedMsg.frienduin = message.frienduin;
            messageForMixedMsg.msgData = message.msgData;
            messageForMixedMsg.extStr = message.extStr;
            messageForMixedMsg.extLong |= 1;
            messageForMixedMsg.parse();
            message.f203106msg = messageForMixedMsg.f203106msg;
            String str = messageForMixedMsg.msg2;
            message.msg2 = str;
            if (str != null && !"".equals(str)) {
                message.emoRecentMsg = new QQText(message.msg2, 3, 16);
                return;
            }
            String str2 = message.f203106msg;
            if (str2 != null && !"".equals(str2)) {
                message.emoRecentMsg = new QQText(message.f203106msg, 3, 16);
            }
        }
    }
}
