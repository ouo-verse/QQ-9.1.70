package com.tencent.sonic.sdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SonicSessionStatistics {
    static IPatchRedirector $redirector_;
    public long cacheVerifyTime;
    public long connectionConnectTime;
    public long connectionFlowFinishTime;
    public long connectionFlowStartTime;
    public long connectionRecDataEndTime;
    public long connectionRecDataStartTime;
    public long connectionRespondTime;
    public long diffDataCallbackTime;
    public int finalMode;
    public boolean isDirectAddress;
    public int originalMode;
    public long sonicFlowStartTime;
    public long sonicStartTime;
    public String srcUrl;

    public SonicSessionStatistics() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
