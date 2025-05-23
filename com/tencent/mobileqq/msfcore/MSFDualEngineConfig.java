package com.tencent.mobileqq.msfcore;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MSFDualEngineConfig implements MSFConfig {
    static IPatchRedirector $redirector_;
    int mActiveCheckPingInterval;
    int mBackgroundCheckPingInterval;
    int mCheckPingTimeout;
    boolean mEnable0RTTPing;
    boolean mEnableDynamicSideConnPool;
    boolean mEnableHandshakePersist;
    boolean mIsEnableHeartBeatOpt;
    int mMainConnType;
    int mSideWayConnLimit;
    int mSideWayConnType;
    int mType;

    public MSFDualEngineConfig() {
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

    public boolean getEnable0RTTPing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.mEnable0RTTPing;
    }

    public boolean getEnableDynamicSideConnPool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.mEnableDynamicSideConnPool;
    }

    public boolean getEnableHandshakePersist() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.mEnableHandshakePersist;
    }

    public boolean getIsEnableHeartBeatOpt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.mIsEnableHeartBeatOpt;
    }

    public int getMainConnType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mMainConnType;
    }

    public int getSideWayConnLimit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.mSideWayConnLimit;
    }

    public int getSideWayConnType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mSideWayConnType;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            this.mActiveCheckPingInterval = i3;
        }
    }

    public void setBackgroundCheckPingInterval(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.mBackgroundCheckPingInterval = i3;
        }
    }

    public void setCheckPingTimeout(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.mCheckPingTimeout = i3;
        }
    }

    public void setEnable0RTTPing(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
        } else {
            this.mEnable0RTTPing = z16;
        }
    }

    public void setEnableDynamicSideConnPool(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        } else {
            this.mEnableDynamicSideConnPool = z16;
        }
    }

    public void setEnableHandshakePersist(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
        } else {
            this.mEnableHandshakePersist = z16;
        }
    }

    public void setIsEnableHeartBeatOpt(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        } else {
            this.mIsEnableHeartBeatOpt = z16;
        }
    }

    public void setMainConnType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.mMainConnType = i3;
        }
    }

    public void setSideWayConnLimit(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            this.mSideWayConnLimit = i3;
        }
    }

    public void setSideWayConnType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else {
            this.mSideWayConnType = i3;
        }
    }

    public void setType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.mType = i3;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return "MSFDualEngineConfig{mType=" + this.mType + ",mMainConnType=" + this.mMainConnType + ",mSideWayConnType=" + this.mSideWayConnType + ",mSideWayConnLimit=" + this.mSideWayConnLimit + ",mIsEnableHeartBeatOpt=" + this.mIsEnableHeartBeatOpt + ",mCheckPingTimeout=" + this.mCheckPingTimeout + ",mActiveCheckPingInterval=" + this.mActiveCheckPingInterval + ",mBackgroundCheckPingInterval=" + this.mBackgroundCheckPingInterval + ",mEnableDynamicSideConnPool=" + this.mEnableDynamicSideConnPool + ",mEnableHandshakePersist=" + this.mEnableHandshakePersist + ",mEnable0RTTPing=" + this.mEnable0RTTPing + ",}";
    }

    public MSFDualEngineConfig(int i3, int i16, int i17, int i18, boolean z16, int i19, int i26, int i27, boolean z17, boolean z18, boolean z19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19));
            return;
        }
        this.mType = i3;
        this.mMainConnType = i16;
        this.mSideWayConnType = i17;
        this.mSideWayConnLimit = i18;
        this.mIsEnableHeartBeatOpt = z16;
        this.mCheckPingTimeout = i19;
        this.mActiveCheckPingInterval = i26;
        this.mBackgroundCheckPingInterval = i27;
        this.mEnableDynamicSideConnPool = z17;
        this.mEnableHandshakePersist = z18;
        this.mEnable0RTTPing = z19;
    }
}
