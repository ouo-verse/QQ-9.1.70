package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQText;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class i implements j {
    static IPatchRedirector $redirector_;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean b(Message message) {
        int i3 = message.msgtype;
        if (i3 != -5000 && i3 != -5001) {
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
            MessageForNewGrayTips messageForNewGrayTips = new MessageForNewGrayTips();
            messageForNewGrayTips.msgData = message.msgData;
            messageForNewGrayTips.parse();
            String str = messageForNewGrayTips.f203106msg;
            message.f203106msg = str;
            if (str != null && !"".equals(str)) {
                message.emoRecentMsg = new QQText(message.f203106msg, 3, 16);
            }
        }
    }
}
