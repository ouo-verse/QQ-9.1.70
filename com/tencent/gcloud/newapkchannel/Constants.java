package com.tencent.gcloud.newapkchannel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class Constants {
    static IPatchRedirector $redirector_ = null;
    public static final int CODE_IN_FILE_PATH_NULL = 1000;
    public static final int CODE_PARSER_APK_VERIFIED_FALSE = 1002;
    public static final int CODE_PARSER_FILE_ERROR = 1001;

    public Constants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
