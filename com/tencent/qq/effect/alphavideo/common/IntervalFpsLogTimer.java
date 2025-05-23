package com.tencent.qq.effect.alphavideo.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class IntervalFpsLogTimer {
    static IPatchRedirector $redirector_;
    private int mFps;
    protected long mInterval;
    private long mLastTime;

    public IntervalFpsLogTimer(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.mFps = 0;
        this.mLastTime = 0L;
        long j3 = i3;
        this.mInterval = j3;
        this.mLastTime = (System.currentTimeMillis() - j3) - 1;
    }

    public int getFps() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        long j3 = this.mInterval;
        if (j3 != 0) {
            i3 = (this.mFps * 1000) / ((int) j3);
        } else {
            i3 = this.mFps;
        }
        this.mFps = 0;
        return i3;
    }

    public boolean isTimeToWriteLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        this.mFps++;
        if (this.mLastTime + this.mInterval < System.currentTimeMillis()) {
            this.mLastTime = System.currentTimeMillis();
            return true;
        }
        return false;
    }
}
