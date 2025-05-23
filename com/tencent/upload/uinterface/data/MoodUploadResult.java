package com.tencent.upload.uinterface.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.AbstractUploadResult;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MoodUploadResult extends AbstractUploadResult {
    static IPatchRedirector $redirector_;
    public final byte[] vBusiNessDataRsp;

    public MoodUploadResult(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bArr);
        } else {
            this.vBusiNessDataRsp = bArr;
        }
    }
}
