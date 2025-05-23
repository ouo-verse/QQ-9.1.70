package com.tencent.imcore.message;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import msf.msgcomm.msg_comm$Msg;

/* compiled from: P */
/* loaded from: classes7.dex */
public class e extends BaseMessageProcessor {
    static IPatchRedirector $redirector_;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36651);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            s.a();
        }
    }

    public e(AppInterface appInterface, BaseMessageHandler baseMessageHandler) {
        super(appInterface, baseMessageHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface, (Object) baseMessageHandler);
        }
    }

    @Override // com.tencent.imcore.message.BaseMessageProcessor
    protected String e(msg_comm$Msg msg_comm_msg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg_comm_msg);
        }
        long j3 = msg_comm_msg.msg_head.get().msg_seq.get();
        StringBuilder sb5 = new StringBuilder(64);
        sb5.append("key_seq_");
        sb5.append(j3);
        return sb5.toString();
    }
}
