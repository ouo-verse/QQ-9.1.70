package com.tencent.youtu.ytposedetect.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ActionData {
    static IPatchRedirector $redirector_;
    public boolean isSuccess;
    public String sdMD;
    public byte[] video;
    public String videoMD;

    public ActionData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
