package com.tencent.upload.uinterface.data;

import FileUpload.UploadPicInfoRsp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.uinterface.AbstractUploadResult;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class BatchCommitUploadResult extends AbstractUploadResult {
    static IPatchRedirector $redirector_;
    public Map<String, UploadPicInfoRsp> mapPicInfoRsp;

    public BatchCommitUploadResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
