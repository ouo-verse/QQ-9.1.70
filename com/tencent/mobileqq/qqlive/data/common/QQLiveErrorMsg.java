package com.tencent.mobileqq.qqlive.data.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveErrorMsg {
    static IPatchRedirector $redirector_;
    public int bizErrCode;
    public String bizErrMsg;
    public int bizModule;
    public int originErrCode;
    public String originErrMsg;

    public QQLiveErrorMsg(int i3, int i16, String str, int i17, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), str, Integer.valueOf(i17), str2);
            return;
        }
        this.bizModule = i3;
        this.bizErrCode = i16;
        this.bizErrMsg = str;
        this.originErrCode = i17;
        this.originErrMsg = str2;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "QQLiveErrorMsg{bizModule=" + this.bizModule + ", bizErrCode=" + this.bizErrCode + ", bizErrMsg='" + this.bizErrMsg + "', originErrCode=" + this.originErrCode + ", originErrMsg='" + this.originErrMsg + "'}";
    }

    public QQLiveErrorMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.bizModule = 0;
            this.originErrCode = -1;
        }
    }

    public QQLiveErrorMsg(QQLiveErrorMsg qQLiveErrorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveErrorMsg);
            return;
        }
        this.bizModule = 0;
        this.originErrCode = -1;
        if (qQLiveErrorMsg == null) {
            return;
        }
        this.bizModule = qQLiveErrorMsg.bizModule;
        this.bizErrCode = qQLiveErrorMsg.bizErrCode;
        this.bizErrMsg = qQLiveErrorMsg.bizErrMsg;
        this.originErrCode = qQLiveErrorMsg.originErrCode;
        this.originErrMsg = qQLiveErrorMsg.originErrMsg;
    }
}
