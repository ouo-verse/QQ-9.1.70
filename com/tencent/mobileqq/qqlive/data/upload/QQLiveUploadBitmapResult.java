package com.tencent.mobileqq.qqlive.data.upload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveUploadBitmapResult {
    static IPatchRedirector $redirector_;
    public String errorMsg;
    public boolean isSuccess;
    public QQLiveUploadBitmapParams reqParams;
    public int retCode;
    public long timeStamp;
    public String url;

    public QQLiveUploadBitmapResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public QQLiveUploadBitmapResult(int i3, boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), str);
            return;
        }
        this.retCode = i3;
        this.isSuccess = z16;
        this.errorMsg = str;
    }

    public QQLiveUploadBitmapResult(QQLiveUploadBitmapResult qQLiveUploadBitmapResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveUploadBitmapResult);
            return;
        }
        if (qQLiveUploadBitmapResult == null) {
            return;
        }
        this.retCode = qQLiveUploadBitmapResult.retCode;
        this.isSuccess = qQLiveUploadBitmapResult.isSuccess;
        this.errorMsg = qQLiveUploadBitmapResult.errorMsg;
        this.url = qQLiveUploadBitmapResult.url;
        this.timeStamp = qQLiveUploadBitmapResult.timeStamp;
        this.reqParams = new QQLiveUploadBitmapParams(qQLiveUploadBitmapResult.reqParams);
    }
}
