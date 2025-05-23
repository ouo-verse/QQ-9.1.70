package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ThreadType {
    static IPatchRedirector $redirector_ = null;
    protected static final int ASYNCTASK = 256;
    public static final int DB = 32;
    public static final int FILE = 64;
    public static final int NETWORK = 128;
    protected static final int NONE = 512;
    public static final int NORMAL = 16;
    public static final int VALID = 240;

    public ThreadType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
