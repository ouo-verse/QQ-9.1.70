package com.tencent.mobileqq.highway.conn;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ConnReportInfo {
    static IPatchRedirector $redirector_;
    public long connElapseTime;
    public String connIp;
    public long connLifeBegin;
    public long connLifeLong;
    public long connStartTime;
    public int failDeail;
    public boolean finished;
    public boolean killSelf;
    public int netType;
    public int port;
    public long receiveDataLen;
    public int recvRespCount;
    public boolean result;
    public long sentDataLen;
    public int sentRequestCount;
    public int sentRetryCount;
    public String serverIp;

    public ConnReportInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.receiveDataLen = 0L;
        this.sentDataLen = 0L;
        this.sentRetryCount = 0;
        this.sentRequestCount = 0;
        this.recvRespCount = 0;
    }
}
