package com.tencent.gcloud.qr.defines;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QRRetCode {
    static IPatchRedirector $redirector_ = null;
    public static final int DiskError = 12;
    public static final int Failed = 1;
    public static final int GenerateError = 21;
    public static final int NoMessage = 14;
    public static final int NoPermission = 13;
    public static final int ParamError = 10;
    public static final int QRError = 20;
    public static final int SavePathError = 23;
    public static final int ScanError = 22;
    public static final int Success = 0;
    public static final int SystemError = 11;

    public QRRetCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
