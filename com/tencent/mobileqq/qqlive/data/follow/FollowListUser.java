package com.tencent.mobileqq.qqlive.data.follow;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class FollowListUser {
    static IPatchRedirector $redirector_;
    public long fansNum;
    public long giftNum;
    public String icon;
    public boolean isLiving6;
    public String nick;
    public long uid;

    public FollowListUser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
