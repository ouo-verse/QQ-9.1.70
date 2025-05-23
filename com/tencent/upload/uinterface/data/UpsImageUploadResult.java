package com.tencent.upload.uinterface.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.AbstractUploadResult;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UpsImageUploadResult extends AbstractUploadResult {
    static IPatchRedirector $redirector_;
    public int dataType;
    public int photoType;
    public int rawHeight;
    public int rawWidth;
    public String url;
    public byte[] vBusiNessData;

    public UpsImageUploadResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
