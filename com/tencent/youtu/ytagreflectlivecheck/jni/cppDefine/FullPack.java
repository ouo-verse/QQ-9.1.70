package com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class FullPack {
    static IPatchRedirector $redirector_;
    public DataPack AGin;
    public CAPTCHA CP;
    public int endFrameIndex;
    public byte[] frames;
    public int startFrameIndex;

    public FullPack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
