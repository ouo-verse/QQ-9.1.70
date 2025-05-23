package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TransferResult {
    static IPatchRedirector $redirector_ = null;
    public static final int RESULT_FAIL = -1;
    public static final int RESULT_NOT_SET = -2;
    public static final int RESULT_OK = 0;
    public long mErrCode;
    public String mErrDesc;
    public TransferRequest mOrigReq;
    public int mResult;

    public TransferResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mResult = -2;
        }
    }
}
