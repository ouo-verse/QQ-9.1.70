package com.tencent.upload.request.impl;

import SLICE_UPLOAD.FileCommitReq;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.request.UploadRequest;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FileCommitRequest extends UploadRequest {
    static IPatchRedirector $redirector_;
    private FileCommitReq req;

    public FileCommitRequest(FileCommitReq fileCommitReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fileCommitReq);
        } else {
            this.req = fileCommitReq;
        }
    }

    @Override // com.tencent.upload.request.UploadRequest
    protected JceStruct createJceRequest() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JceStruct) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.req;
    }
}
