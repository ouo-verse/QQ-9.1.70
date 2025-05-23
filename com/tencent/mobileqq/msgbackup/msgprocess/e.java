package com.tencent.mobileqq.msgbackup.msgprocess;

import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e extends i<MessageForPic> {
    static IPatchRedirector $redirector_;

    public e(MessageForPic messageForPic) {
        super(messageForPic);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) messageForPic);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.msgprocess.i
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        MessageForPic messageForPic = (MessageForPic) this.f251278b;
        b("packMsg uinType:" + messageForPic.istroop);
        messageForPic.richText = messageForPic.getRichText();
    }
}
