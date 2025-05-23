package com.tencent.tuxmetersdk.impl;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.model.BeaconInfo;
import com.tencent.tuxmetersdk.model.SignInfo;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SDKConfig {
    static IPatchRedirector $redirector_;

    @SerializedName("beacon_info")
    private BeaconInfo beaconInfo;

    @SerializedName("contain_permanent")
    private boolean containPermanent;

    @SerializedName("is_white")
    private boolean isWhite;

    @SerializedName("sign_info")
    private SignInfo signInfo;

    @SerializedName("silent_period")
    private int silentPeriod;

    @SerializedName("toggle")
    private boolean toggle;

    public SDKConfig(boolean z16, SignInfo signInfo, BeaconInfo beaconInfo, int i3, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), signInfo, beaconInfo, Integer.valueOf(i3), Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        this.isWhite = z16;
        this.signInfo = signInfo;
        this.beaconInfo = beaconInfo;
        this.silentPeriod = i3;
        this.toggle = z17;
        this.containPermanent = z18;
    }

    public BeaconInfo getBeaconInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BeaconInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.beaconInfo;
    }

    public SignInfo getSignInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SignInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.signInfo;
    }

    public int getSilentPeriod() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.silentPeriod;
    }

    public boolean isContainPermanent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.containPermanent;
    }

    public boolean isToggle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.toggle;
    }

    public boolean isWhite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isWhite;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "SDKConfig{isWhite=" + this.isWhite + ", signInfo=" + this.signInfo + ", beaconInfo=" + this.beaconInfo + ", silentPeriod=" + this.silentPeriod + ", toggle=" + this.toggle + ", containPermanent=" + this.containPermanent + '}';
    }
}
