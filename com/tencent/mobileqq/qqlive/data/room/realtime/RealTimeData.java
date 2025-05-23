package com.tencent.mobileqq.qqlive.data.room.realtime;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class RealTimeData {
    static IPatchRedirector $redirector_;
    public boolean isShow;
    public String name;
    public MetricsType type;
    public long value;

    public RealTimeData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
