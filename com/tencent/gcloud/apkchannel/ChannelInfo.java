package com.tencent.gcloud.apkchannel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ChannelInfo {
    static IPatchRedirector $redirector_;
    public long offset;
    public int signatrueType;
    public long size;

    public ChannelInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
