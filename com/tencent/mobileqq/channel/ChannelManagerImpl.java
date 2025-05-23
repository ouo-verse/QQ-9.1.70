package com.tencent.mobileqq.channel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ChannelManagerImpl {
    static IPatchRedirector $redirector_;

    public ChannelManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void onChannelReady() {
        ChannelReport.getInstance().reportInitTime();
        ChannelReport.getInstance().reportTZ();
        ChannelReport.getInstance().reportLoadFixedSo();
    }
}
