package com.tencent.mobileqq.soload.biz.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AsyncFailInfo {
    static IPatchRedirector $redirector_;
    public int lastFailCode;
    public long lastFailTime;
    public int lastSubFailCode;
    public int netType;

    public AsyncFailInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.lastFailCode = 0;
        this.netType = 0;
        this.lastFailTime = 0L;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "FailInfo{lastFCode=" + this.lastFailCode + ", lastSubFCode=" + this.lastSubFailCode + ", netType=" + this.netType + ", lastFTime=" + this.lastFailTime + '}';
    }
}
