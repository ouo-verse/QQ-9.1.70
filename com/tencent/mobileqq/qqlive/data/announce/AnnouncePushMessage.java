package com.tencent.mobileqq.qqlive.data.announce;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes17.dex */
public class AnnouncePushMessage {
    static IPatchRedirector $redirector_;
    public String announce;
    public boolean approved;
    public long roomId;
    public long uid;

    public AnnouncePushMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
