package com.tencent.upload.network.route;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes27.dex */
public class RecentRouteRecord implements Serializable {
    static IPatchRedirector $redirector_;
    private UploadRoute mRecentRoute;
    private long mTimeStamp;

    public RecentRouteRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mRecentRoute = null;
            this.mTimeStamp = 0L;
        }
    }

    public UploadRoute getRecentRoute() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (UploadRoute) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mRecentRoute;
    }

    public long getTimeStamp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.mTimeStamp;
    }

    public void setRecentRoute(UploadRoute uploadRoute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) uploadRoute);
        } else {
            this.mRecentRoute = uploadRoute;
        }
    }

    public void setTimeStamp(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, j3);
        } else {
            this.mTimeStamp = j3;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "mRecentRoute = " + this.mRecentRoute + ",mTimeStamp = " + this.mTimeStamp;
    }
}
