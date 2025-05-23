package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class StatictisInfo {
    static IPatchRedirector $redirector_ = null;
    public static final long DETAIL_REASON_DECODE_FAIL = 2139062143;
    public static final long DETAIL_REASON_UNKNOWN = 2139062142;
    public static final long NO_DETAIL_REASON = Long.MAX_VALUE;
    public static final int REPORT_AS_SUCC_FLAG = 1;
    public int appSeq;
    public long detailErrorReason;
    public int errCode;
    public int reportSucc;
    public int retryCount;
    public String timeoutReason;

    public StatictisInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.appSeq = 0;
        this.errCode = 1000;
        this.retryCount = 0;
        this.detailErrorReason = Long.MAX_VALUE;
        this.timeoutReason = null;
        this.reportSucc = -1;
    }
}
