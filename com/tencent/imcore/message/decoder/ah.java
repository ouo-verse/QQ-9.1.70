package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ah implements j {
    static IPatchRedirector $redirector_;

    public ah() {
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
        if (message.msgtype == -2025 && message.msgData != null) {
            try {
                MessageForQQWalletMsg messageForQQWalletMsg = new MessageForQQWalletMsg();
                messageForQQWalletMsg.msgData = message.msgData;
                messageForQQWalletMsg.parse();
                message.f203106msg = messageForQQWalletMsg.getMsgSummary();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.msg.BaseMessageManager", 2, e16.toString());
                }
            }
        }
    }
}
