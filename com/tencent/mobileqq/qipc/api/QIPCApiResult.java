package com.tencent.mobileqq.qipc.api;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class QIPCApiResult {
    static IPatchRedirector $redirector_ = null;
    public static final int CODE_CONNECTION_INVALID = -2;
    public static final int CODE_CONNECT_FAILED = -105;
    public static final int CODE_ERR = -102;
    public static final int CODE_HAS_EXCEPTION = -101;
    public static final int CODE_NO_CONNECT = -1;
    public static final int CODE_NO_ERR = 0;
    public static final int CODE_UNKOWN = -100;
    public int code;
    public Bundle data;

    /* renamed from: e, reason: collision with root package name */
    private Throwable f261900e;

    public QIPCApiResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static QIPCApiResult createExceptionResult(Throwable th5) {
        QIPCApiResult qIPCApiResult = new QIPCApiResult();
        qIPCApiResult.code = -101;
        qIPCApiResult.f261900e = th5;
        return qIPCApiResult;
    }

    public static QIPCApiResult createSuccessResult(Bundle bundle) {
        QIPCApiResult qIPCApiResult = new QIPCApiResult();
        qIPCApiResult.code = 0;
        qIPCApiResult.data = bundle;
        return qIPCApiResult;
    }

    public boolean isSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.code == 0) {
            return true;
        }
        return false;
    }
}
