package com.tencent.paysdk.vipauth.requestdata;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LiveAuthRequestData extends BaseRequestData {
    static IPatchRedirector $redirector_;

    @SerializedName("chid")
    private String mChid;

    @SerializedName("pid")
    private String mPid;

    @SerializedName("player_platform")
    private int playerPlatform;

    public LiveAuthRequestData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private int getIntFromString(String str) {
        if (str == null) {
            return 0;
        }
        return Integer.parseInt(str);
    }

    public String getChid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mChid;
    }

    public String getPid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mPid;
    }

    public void setChid(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.mChid = str;
        }
    }

    public void setPid(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.mPid = str;
        }
    }

    public void setPlayerPlatform(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            this.playerPlatform = i3;
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
    }

    public void setPlayerPlatform(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            this.playerPlatform = getIntFromString(str);
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
    }
}
