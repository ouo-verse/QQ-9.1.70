package com.tencent.upload.uinterface.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.AbstractUploadResult;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VideoUploadResult extends AbstractUploadResult {
    static IPatchRedirector $redirector_;
    public int iBusiNessType;
    public boolean isControlPkg;
    public String sVid;
    public byte[] vBusiNessData;

    public VideoUploadResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.sVid = "";
        this.iBusiNessType = 0;
        this.vBusiNessData = null;
        this.isControlPkg = false;
    }
}
