package com.tencent.mobileqq.qqlive.data.user;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LiveUserInfo {
    static IPatchRedirector $redirector_;
    public String headUrl;
    public String nick;
    public int sex;
    public String showNick;
    public long uid;

    public LiveUserInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.uid = 0L;
        this.headUrl = "";
        this.nick = "";
        this.showNick = "";
        this.sex = 1;
    }

    public void copyFrom(LiveUserInfo liveUserInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) liveUserInfo);
            return;
        }
        this.uid = liveUserInfo.uid;
        this.headUrl = liveUserInfo.headUrl;
        this.nick = liveUserInfo.nick;
        this.sex = liveUserInfo.sex;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "LiveUserInfo{uid=" + this.uid + ", headUrl='" + this.headUrl + "', nick='" + this.nick + "', sex=" + this.sex + '}';
    }

    public LiveUserInfo(long j3, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str, str2, Integer.valueOf(i3));
            return;
        }
        this.showNick = "";
        this.uid = j3;
        this.headUrl = str;
        this.nick = str2;
        this.sex = i3;
    }
}
