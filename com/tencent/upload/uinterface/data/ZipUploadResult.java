package com.tencent.upload.uinterface.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.AbstractUploadResult;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ZipUploadResult extends AbstractUploadResult {
    static IPatchRedirector $redirector_;
    public int result;
    public String zip_id;
    public int zip_length;

    public ZipUploadResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.zip_length = 0;
        this.result = 0;
        this.zip_id = "";
    }
}
