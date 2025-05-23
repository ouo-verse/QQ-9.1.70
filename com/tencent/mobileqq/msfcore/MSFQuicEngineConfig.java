package com.tencent.mobileqq.msfcore;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MSFQuicEngineConfig implements MSFConfig {
    static IPatchRedirector $redirector_;
    int mActiveCheckPingInterval;
    int mBackgroundCheckPingInterval;
    int mCheckPingTimeout;
    boolean mEnableHandshakePersist;
    boolean mIsEnableHearbeatOpt;
    double mParallelConnInterval;
    int mParallelConnNum;
    int mSideWayConnLimit;
    int mType;

    public MSFQuicEngineConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public int getActiveCheckPingInterval() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.mActiveCheckPingInterval;
    }

    public int getBackgroundCheckPingInterval() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.mBackgroundCheckPingInterval;
    }

    public int getCheckPingTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.mCheckPingTimeout;
    }

    public boolean getEnableHandshakePersist() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.mEnableHandshakePersist;
    }

    public boolean getIsEnableHearbeatOpt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.mIsEnableHearbeatOpt;
    }

    public double getParallelConnInterval() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Double) iPatchRedirector.redirect((short) 5, (Object) this)).doubleValue();
        }
        return this.mParallelConnInterval;
    }

    public int getParallelConnNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mParallelConnNum;
    }

    public int getSideWayConnLimit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.mSideWayConnLimit;
    }

    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mType;
    }

    public void setActiveCheckPingInterval(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            this.mActiveCheckPingInterval = i3;
        }
    }

    public void setBackgroundCheckPingInterval(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.mBackgroundCheckPingInterval = i3;
        }
    }

    public void setCheckPingTimeout(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            this.mCheckPingTimeout = i3;
        }
    }

    public void setEnableHandshakePersist(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else {
            this.mEnableHandshakePersist = z16;
        }
    }

    public void setIsEnableHearbeatOpt(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.mIsEnableHearbeatOpt = z16;
        }
    }

    public void setParallelConnInterval(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Double.valueOf(d16));
        } else {
            this.mParallelConnInterval = d16;
        }
    }

    public void setParallelConnNum(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.mParallelConnNum = i3;
        }
    }

    public void setSideWayConnLimit(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.mSideWayConnLimit = i3;
        }
    }

    public void setType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.mType = i3;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return "MSFQuicEngineConfig{mType=" + this.mType + ",mParallelConnNum=" + this.mParallelConnNum + ",mParallelConnInterval=" + this.mParallelConnInterval + ",mSideWayConnLimit=" + this.mSideWayConnLimit + ",mIsEnableHearbeatOpt=" + this.mIsEnableHearbeatOpt + ",mCheckPingTimeout=" + this.mCheckPingTimeout + ",mActiveCheckPingInterval=" + this.mActiveCheckPingInterval + ",mBackgroundCheckPingInterval=" + this.mBackgroundCheckPingInterval + ",mEnableHandshakePersist=" + this.mEnableHandshakePersist + ",}";
    }

    public MSFQuicEngineConfig(int i3, int i16, double d16, int i17, boolean z16, int i18, int i19, int i26, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Double.valueOf(d16), Integer.valueOf(i17), Boolean.valueOf(z16), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Boolean.valueOf(z17));
            return;
        }
        this.mType = i3;
        this.mParallelConnNum = i16;
        this.mParallelConnInterval = d16;
        this.mSideWayConnLimit = i17;
        this.mIsEnableHearbeatOpt = z16;
        this.mCheckPingTimeout = i18;
        this.mActiveCheckPingInterval = i19;
        this.mBackgroundCheckPingInterval = i26;
        this.mEnableHandshakePersist = z17;
    }
}
