package com.tencent.tedger.outapi.beans;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class EdgeStatus extends TEdgeRSBase {
    static IPatchRedirector $redirector_;
    public boolean mAutoPrintError;
    private long mCode;
    private String mMsg;
    private String mReportMsg;

    public EdgeStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mAutoPrintError = true;
        this.mCode = 0L;
        this.mMsg = null;
        this.mReportMsg = null;
    }

    public long getCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.mCode;
    }

    public String getMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (TextUtils.isEmpty(this.mMsg)) {
            return b.a(this.mCode);
        }
        return this.mMsg;
    }

    public String getReportMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mReportMsg;
    }

    @Override // com.tencent.tedger.outapi.beans.TEdgeRSBase
    public byte[] readBussinessData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (byte[]) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return null;
    }

    public void setCode(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        } else {
            this.mCode = j3;
        }
    }

    public void setMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.mMsg = str;
        }
    }

    public void setReportMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.mReportMsg = str;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "EdgeStatus{mCode=" + this.mCode + ", mMsg='" + this.mMsg + ", mReportMsg='" + this.mReportMsg + "'}";
    }
}
