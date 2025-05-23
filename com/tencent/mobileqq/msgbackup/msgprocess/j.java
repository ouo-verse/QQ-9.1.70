package com.tencent.mobileqq.msgbackup.msgprocess;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class j extends i<MessageForShortVideo> {
    static IPatchRedirector $redirector_;

    public j(MessageForShortVideo messageForShortVideo) {
        super(messageForShortVideo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) messageForShortVideo);
        }
    }

    @Override // com.tencent.mobileqq.msgbackup.msgprocess.i
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            ((MessageForShortVideo) this.f251278b).richText = ((MessageForShortVideo) this.f251278b).getRichText();
        }
    }
}
