package com.tencent.upload.uinterface.data;

import SLICE_UPLOAD.FileControlRsp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.AbstractUploadResult;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class BatchControlResult extends AbstractUploadResult {
    static IPatchRedirector $redirector_;
    Map<String, FileControlRsp> mMap;

    public BatchControlResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mMap = new HashMap();
        }
    }
}
