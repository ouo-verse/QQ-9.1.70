package com.tencent.mobileqq.springhb.entry.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.en;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TimeInfo implements Serializable {
    static IPatchRedirector $redirector_;
    public long begin;
    public long end;

    public TimeInfo(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16));
        } else {
            this.begin = j3;
            this.end = j16;
        }
    }

    public static TimeInfo newEmpty() {
        return new TimeInfo(0L, 0L);
    }

    public void copyFrom(TimeInfo timeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) timeInfo);
        } else {
            this.begin = timeInfo.begin;
            this.end = timeInfo.end;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TimeInfo{begin=" + en.i(this.begin) + ", end=" + en.i(this.end) + '}';
    }
}
