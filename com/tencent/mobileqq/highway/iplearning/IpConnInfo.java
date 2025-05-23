package com.tencent.mobileqq.highway.iplearning;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class IpConnInfo {
    static IPatchRedirector $redirector_;
    public int iFailCount;
    public boolean isConnSucc;
    public boolean isSameIsp;
    public long lLastSuccTimeMills;
    public String mHost;
    public int mPort;

    public IpConnInfo(String str, int i3, boolean z16, boolean z17, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3));
            return;
        }
        this.isSameIsp = false;
        this.isConnSucc = z16;
        this.mHost = str;
        this.mPort = i3;
        this.lLastSuccTimeMills = j3;
        this.iFailCount = 0;
    }

    public void markAsFailOnceMore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.isConnSucc = false;
            this.iFailCount++;
        }
    }

    public void markAsSucc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.isConnSucc = true;
        this.iFailCount = 0;
        this.lLastSuccTimeMills = SystemClock.uptimeMillis();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "_IpConnInfo_ Host:" + this.mHost + " Succ:" + this.isConnSucc + " Fail:" + this.iFailCount + " Time:" + this.lLastSuccTimeMills;
    }
}
