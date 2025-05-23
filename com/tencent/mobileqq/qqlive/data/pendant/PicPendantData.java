package com.tencent.mobileqq.qqlive.data.pendant;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes17.dex */
public class PicPendantData {
    static IPatchRedirector $redirector_ = null;
    public static final int VISIBLE = 1;
    public long actionLimit;
    public String coverUrl;
    public long endTs;
    public long number;
    public String picPendantId;
    public String redirectUrl;
    public long serverTs;
    public long startTs;
    public long viewTime;
    public int visible;

    public PicPendantData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
