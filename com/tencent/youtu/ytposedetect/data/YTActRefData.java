package com.tencent.youtu.ytposedetect.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YTActRefData {
    static IPatchRedirector $redirector_;
    public YTActRefImage best;
    public YTActRefImage eye;
    public YTActRefImage mouth;

    public YTActRefData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
