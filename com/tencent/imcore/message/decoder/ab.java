package com.tencent.imcore.message.decoder;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import localpb.richMsg.RichMsg$FoldMsg;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ab implements j {
    static IPatchRedirector $redirector_;

    public ab() {
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
        if (message.msgtype == -1000 && message.getExtInfoFromExtStr("redbag_fold_msg").equals("true") && message.msgData != null) {
            RichMsg$FoldMsg richMsg$FoldMsg = new RichMsg$FoldMsg();
            try {
                richMsg$FoldMsg.mergeFrom(message.msgData);
                message.f203106msg = richMsg$FoldMsg.msg_content.get().toStringUtf8();
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.e("msgFold", 2, "MessageForFoldMsg decodeMsg error\uff0c " + e16.getMessage());
                }
            }
        }
    }
}
