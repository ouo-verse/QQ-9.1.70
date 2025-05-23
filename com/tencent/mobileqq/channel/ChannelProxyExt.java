package com.tencent.mobileqq.channel;

import com.tencent.mobileqq.fe.FEKit;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes11.dex */
public abstract class ChannelProxyExt extends ChannelProxy {
    static IPatchRedirector $redirector_;

    public ChannelProxyExt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.channel.ChannelProxy
    public void sendMessage(String str, byte[] bArr, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, bArr, Long.valueOf(j3));
        } else {
            sendMessage(str, bArr, FEKit.getInstance().getCurUin(), j3);
        }
    }

    public abstract void sendMessage(String str, byte[] bArr, String str2, long j3);
}
