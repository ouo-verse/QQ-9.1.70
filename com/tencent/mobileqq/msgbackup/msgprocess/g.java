package com.tencent.mobileqq.msgbackup.msgprocess;

import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g extends i<MessageForPtt> {
    static IPatchRedirector $redirector_;

    public g(MessageForPtt messageForPtt) {
        super(messageForPtt);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) messageForPtt);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.msgprocess.i
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        T t16 = this.f251278b;
        ((MessageForPtt) this.f251278b).richText = ((MessageForPtt) t16).getRichText();
    }
}
