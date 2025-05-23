package com.tencent.upload.uinterface.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.AbstractUploadResult;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MobileLogUploadResult extends AbstractUploadResult {
    static IPatchRedirector $redirector_;
    public long iUin;

    public MobileLogUploadResult(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3));
        } else {
            this.iUin = j3;
            this.flowId = i3;
        }
    }
}
