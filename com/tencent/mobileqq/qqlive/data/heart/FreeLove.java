package com.tencent.mobileqq.qqlive.data.heart;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class FreeLove {
    static IPatchRedirector $redirector_;
    public String likeResId;
    public int loveNum;
    public String loveType;

    public FreeLove() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public FreeLove(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        } else {
            this.loveType = str;
            this.loveNum = i3;
        }
    }

    public FreeLove(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, Integer.valueOf(i3));
            return;
        }
        this.loveType = str;
        this.likeResId = str2;
        this.loveNum = i3;
    }
}
