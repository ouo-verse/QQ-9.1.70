package com.tencent.video.decode;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class AVAudioParam {
    static IPatchRedirector $redirector_;
    public int channels;
    public int duration;
    public int errcode;
    public int frameIndex;
    public int numsample;
    public int sample_rate;
    public int stream_kind;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AVAudioParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
