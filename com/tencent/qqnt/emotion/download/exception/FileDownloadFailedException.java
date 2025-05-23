package com.tencent.qqnt.emotion.download.exception;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes24.dex */
public class FileDownloadFailedException extends RuntimeException {
    static IPatchRedirector $redirector_;
    int errorCode;
    long errorDetailCode;
    boolean needReport;
    private boolean needRetry;

    public FileDownloadFailedException(int i3, long j3, String str, boolean z16) {
        this(i3, j3, str, z16, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), str, Boolean.valueOf(z16));
    }

    public FileDownloadFailedException(int i3, int i16, String str, Throwable th5, boolean z16) {
        super(str, th5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str, th5, Boolean.valueOf(z16));
            return;
        }
        this.needReport = true;
        this.errorCode = i3;
        this.errorDetailCode = i16;
        this.needRetry = z16;
    }

    public FileDownloadFailedException(int i3, long j3, String str, boolean z16, boolean z17) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Long.valueOf(j3), str, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.errorCode = i3;
        this.errorDetailCode = j3;
        this.needRetry = z16;
        this.needReport = z17;
    }
}
