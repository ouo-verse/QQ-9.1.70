package com.tencent.upload.request.impl;

import SLICE_UPLOAD.FileBatchControlReq;
import SLICE_UPLOAD.FileControlReq;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.request.UploadRequest;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class BatchControlRequest extends UploadRequest {
    static IPatchRedirector $redirector_;
    Map<String, FileControlReq> mMap;

    public BatchControlRequest(Map<String, FileControlReq> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) map);
        } else {
            this.mMap = map;
        }
    }

    @Override // com.tencent.upload.request.UploadRequest
    public JceStruct createJceRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JceStruct) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new FileBatchControlReq(this.mMap);
    }
}
