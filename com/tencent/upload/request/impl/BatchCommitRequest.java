package com.tencent.upload.request.impl;

import SLICE_UPLOAD.FileBatchCommitReq;
import SLICE_UPLOAD.FileCommitReq;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.request.UploadRequest;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class BatchCommitRequest extends UploadRequest {
    static IPatchRedirector $redirector_;
    public Map<String, FileCommitReq> mMap;

    public BatchCommitRequest(Map<String, FileCommitReq> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mMap = map;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) map);
        }
    }

    @Override // com.tencent.upload.request.UploadRequest
    public JceStruct createJceRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (JceStruct) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new FileBatchCommitReq(this.mMap);
    }

    @Override // com.tencent.upload.request.UploadRequest, com.tencent.upload.request.IActionRequest
    public int getCmdId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 3;
    }

    public BatchCommitRequest(FileBatchCommitReq fileBatchCommitReq, int i3) {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mMap = fileBatchCommitReq.commit_req;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fileBatchCommitReq, i3);
        }
    }
}
