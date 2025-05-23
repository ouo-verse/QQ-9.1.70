package com.tencent.mobileqq.msgbackup.msgprocess;

import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.api.IMsgMixed;
import com.tencent.mobileqq.msgbackup.controller.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d extends i<MessageRecord> {
    static IPatchRedirector $redirector_;

    public d(MessageRecord messageRecord) {
        super(messageRecord);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) messageRecord);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.msgprocess.i
    public void d() {
        i h16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        for (MessageRecord messageRecord : ((IMsgMixed) QRoute.api(IMsgMixed.class)).getElementList(this.f251278b)) {
            if ((messageRecord instanceof MessageForPic) && (h16 = l.h(messageRecord)) != null && h16.f251278b != 0) {
                h16.d();
            }
        }
    }
}
