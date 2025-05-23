package com.tencent.mobileqq.qqlive.data.follow;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes17.dex */
public class FollowPushMessage {
    static IPatchRedirector $redirector_ = null;
    public static final int FOLLOW = 1;
    public static final int UN_FOLLOW = 0;
    public String icon;
    public String nick;
    public long toUid;
    public int type;
    public long uid;

    public FollowPushMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "FollowPushMessage{uid=" + this.uid + ", nick='" + this.nick + "', toUid=" + this.toUid + ", type=" + this.type + ", icon='" + this.icon + "'}";
    }
}
