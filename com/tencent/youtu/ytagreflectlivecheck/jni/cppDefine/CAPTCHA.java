package com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class CAPTCHA {
    static IPatchRedirector $redirector_;
    public int fixedInterval;
    public int[] intervals;
    public int randInv;
    public int randShift;
    public byte[] seqID;
    public int unit;

    public CAPTCHA() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
