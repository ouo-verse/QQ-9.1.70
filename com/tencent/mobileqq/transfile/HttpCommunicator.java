package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@Deprecated
/* loaded from: classes19.dex */
public class HttpCommunicator {
    static IPatchRedirector $redirector_ = null;
    public static final int STATUS_ADD = 0;
    public static final int STATUS_END = 5;
    public static final int STATUS_GOT_DATA = 4;
    public static final int STATUS_GOT_HEAD = 3;
    public static final int STATUS_OPEN = 1;
    public static final int STATUS_OPENED = 2;

    public HttpCommunicator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
