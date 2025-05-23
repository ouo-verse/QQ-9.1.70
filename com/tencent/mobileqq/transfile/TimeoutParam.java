package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes19.dex */
public class TimeoutParam {
    static IPatchRedirector $redirector_ = null;
    public static final int TIMEOUT_STEP = 2000;
    private int connectTimeoutBias;
    public int connectTimeoutFor2G;
    public int connectTimeoutFor3G;
    public int connectTimeoutForWifi;
    public int readTimeoutFor2G;
    public int readTimeoutFor3G;
    public int readTimeoutForWifi;

    public TimeoutParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.readTimeoutFor2G = 40000;
        this.readTimeoutFor3G = 30000;
        this.readTimeoutForWifi = 20000;
        this.connectTimeoutFor2G = 20000;
        this.connectTimeoutFor3G = 15000;
        this.connectTimeoutForWifi = 10000;
        this.connectTimeoutBias = 0;
    }

    public void adjustConnectTimeout(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.connectTimeoutBias = i3 * 2000;
        }
    }

    public int getConnectTimeout(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
        }
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 != 4 && i3 != 5) {
                    return this.connectTimeoutFor2G + this.connectTimeoutBias;
                }
            } else {
                return this.connectTimeoutFor3G + this.connectTimeoutBias;
            }
        }
        return this.connectTimeoutForWifi + this.connectTimeoutBias;
    }

    public int getReadTimeout(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
        }
        if (i3 != 1) {
            if (i3 != 3) {
                if (i3 != 4 && i3 != 5) {
                    return this.readTimeoutFor2G;
                }
            } else {
                return this.readTimeoutFor3G;
            }
        }
        return this.readTimeoutForWifi;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TimeoutParam m223clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? new TimeoutParam(this) : (TimeoutParam) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    TimeoutParam(TimeoutParam timeoutParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) timeoutParam);
            return;
        }
        this.readTimeoutFor2G = 40000;
        this.readTimeoutFor3G = 30000;
        this.readTimeoutForWifi = 20000;
        this.connectTimeoutFor2G = 20000;
        this.connectTimeoutFor3G = 15000;
        this.connectTimeoutForWifi = 10000;
        this.connectTimeoutBias = 0;
        this.readTimeoutFor2G = timeoutParam.readTimeoutFor2G;
        this.readTimeoutFor3G = timeoutParam.readTimeoutFor3G;
        this.readTimeoutForWifi = timeoutParam.readTimeoutForWifi;
        this.connectTimeoutFor2G = timeoutParam.connectTimeoutFor2G;
        this.connectTimeoutFor3G = timeoutParam.connectTimeoutFor3G;
        this.connectTimeoutForWifi = timeoutParam.connectTimeoutForWifi;
    }
}
