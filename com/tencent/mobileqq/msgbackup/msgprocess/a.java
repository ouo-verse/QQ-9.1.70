package com.tencent.mobileqq.msgbackup.msgprocess;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a extends i<MessageRecord> {
    static IPatchRedirector $redirector_;

    public a(MessageRecord messageRecord) {
        super(messageRecord);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) messageRecord);
            return;
        }
        this.f251270a += "." + messageRecord.getClass().getSimpleName();
    }

    @Override // com.tencent.mobileqq.msgbackup.msgprocess.i
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
