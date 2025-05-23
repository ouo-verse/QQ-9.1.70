package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class z implements j {
    static IPatchRedirector $redirector_;

    public z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        SystemMsg decode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, message, iMessageManager, appRuntime);
            return;
        }
        if (AppConstants.QQBROADCAST_MSG_UIN.equals(message.senderuin) && message.msgtype == -2011) {
            decode = null;
        } else {
            decode = SystemMsg.decode((QQAppInterface) appRuntime, message.f203106msg, message.senderuin, message.msgtype);
        }
        if (message.isFromLS) {
            ((BaseMessageManager) iMessageManager).L(message);
        } else {
            ((BaseMessageManager) iMessageManager).K(message);
        }
        if (decode != null) {
            message.f203106msg = decode.message;
            if (QLog.isDevelopLevel()) {
                QLog.d("Q.msg.BaseMessageManager", 4, "addFrindSystemMsg decode end" + message.f203106msg);
            }
        }
    }
}
