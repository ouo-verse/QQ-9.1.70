package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes19.dex */
public class ChatPicDownloadFailedException extends RuntimeException {
    static IPatchRedirector $redirector_;
    int errorCode;
    long errorDetailCode;
    boolean needReport;
    private boolean needRetry;

    public ChatPicDownloadFailedException(int i3, long j3, String str, boolean z16, boolean z17) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), str, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.errorCode = i3;
        this.errorDetailCode = j3;
        this.needRetry = z16;
        this.needReport = z17;
    }
}
