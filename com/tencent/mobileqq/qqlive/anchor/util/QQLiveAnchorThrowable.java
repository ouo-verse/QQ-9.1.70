package com.tencent.mobileqq.qqlive.anchor.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorThrowable extends Throwable {
    static IPatchRedirector $redirector_;
    public String message;
    public int originCode;
    public String originMsg;

    public QQLiveAnchorThrowable(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.message = str;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public static final QQLiveErrorMsg covert(int i3, Throwable th5) {
        QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
        qQLiveErrorMsg.bizModule = 2;
        qQLiveErrorMsg.bizErrCode = i3;
        if (th5 != null) {
            if (th5 instanceof QQLiveAnchorThrowable) {
                QQLiveAnchorThrowable qQLiveAnchorThrowable = (QQLiveAnchorThrowable) th5;
                qQLiveErrorMsg.bizErrMsg = qQLiveAnchorThrowable.message;
                qQLiveErrorMsg.originErrCode = qQLiveAnchorThrowable.originCode;
                qQLiveErrorMsg.originErrMsg = qQLiveAnchorThrowable.originMsg;
            } else {
                qQLiveErrorMsg.bizErrMsg = th5.getMessage();
            }
        }
        return qQLiveErrorMsg;
    }

    public QQLiveAnchorThrowable(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2);
            return;
        }
        this.message = str;
        this.originCode = i3;
        this.originMsg = str2;
    }
}
