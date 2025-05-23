package com.tencent.ams.dsdk.download;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DownloadException extends Exception {
    static IPatchRedirector $redirector_ = null;
    public static final int ERROR_CODE_CANCELLED = 4;
    public static final int ERROR_CODE_HTTP_ERROR = 6;
    public static final int ERROR_CODE_IO_ERROR = 3;
    public static final int ERROR_CODE_OTHER = 7;
    public static final int ERROR_CODE_PARAMS_ERROR = 1;
    public static final int ERROR_CODE_REDIRECT_LIMIT_EXCEED = 5;
    public static final int ERROR_CODE_RNS_LIMIT_EXCEED = 8;
    public static final int ERROR_CODE_VAILD_FAILED = 2;
    private int errorCode;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class CancelledException extends DownloadException {
        static IPatchRedirector $redirector_;

        public CancelledException() {
            super(4, "\u4efb\u52a1\u53d6\u6d88");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public DownloadException() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Throwable) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this;
    }

    public int getErrorCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.errorCode;
    }

    public void setErrorCode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.errorCode = i3;
        }
    }

    public DownloadException(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
    }

    public DownloadException(int i3, String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.errorCode = i3;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
        }
    }

    public DownloadException(int i3, Throwable th5) {
        super(th5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.errorCode = i3;
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) th5);
        }
    }

    public DownloadException(int i3, String str, Throwable th5) {
        super(str, th5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.errorCode = i3;
        } else {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), str, th5);
        }
    }

    public DownloadException(Throwable th5) {
        super(th5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) th5);
    }
}
