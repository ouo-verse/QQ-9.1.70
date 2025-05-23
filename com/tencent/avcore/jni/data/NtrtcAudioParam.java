package com.tencent.avcore.jni.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class NtrtcAudioParam {
    static IPatchRedirector $redirector_;
    public String aiDenoiseModelDir;
    public int audioMode;
    public int audioStreamType;
    public String configFromQqmc;
    public boolean isUseOpenSLESInterface;
    public int openSlesUnintPlayWaitTimeLenMs;
    public String penguinsCodecModelDir;
    public String penguinsCodecSoDir;
    public String traeSoFullFilename;

    public NtrtcAudioParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.audioMode = -1;
        this.audioStreamType = -1;
        this.openSlesUnintPlayWaitTimeLenMs = 0;
    }
}
