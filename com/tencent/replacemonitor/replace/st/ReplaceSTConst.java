package com.tencent.replacemonitor.replace.st;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ReplaceSTConst {
    static IPatchRedirector $redirector_ = null;
    public static final int ST_TYPE_REPLACE = 5001;
    public static final int ST_TYPE_REPLACE_DOWNLOAD_FINISH = 5003;
    public static final int ST_TYPE_REPLACE_DOWNLOAD_START = 5002;
    public static final int ST_TYPE_REPLACE_INSTALL_END = 5005;
    public static final int ST_TYPE_REPLACE_INSTALL_START = 5004;

    public ReplaceSTConst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
