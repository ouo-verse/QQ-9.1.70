package com.tencent.avcore.jni.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class NtrtcVideoParam {
    static IPatchRedirector $redirector_;
    public String configFromQqmc;
    public String hardwareDetectSoDir;
    public String hevcDecSoDir;
    public String hevcEncSoDir;
    public String hwCodecAbility;
    public boolean isUseServerVideoConfig;
    public String r265EncSoDir;
    public int screenShareDecLevel;
    public int screenShareEncLevel;
    public int sharpVideo;
    public String videoSrSoDir;

    public NtrtcVideoParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
