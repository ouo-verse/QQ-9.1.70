package com.tencent.mobileqq.dt.app;

import com.tencent.mobileqq.channel.ChannelManager;
import com.tencent.mobileqq.dt.app.O3MainProcessChannel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;

/* loaded from: classes5.dex */
class O3MainProcessChannel$O3MainProcessChannelBusinessObserver$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ FromServiceMsg f203716d;
    final /* synthetic */ O3MainProcessChannel.a this$0;

    @Override // java.lang.Runnable
    public void run() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        ChannelManager channelManager = ChannelManager.getInstance();
        String serviceCmd = this.f203716d.getServiceCmd();
        byte[] wupBuffer = this.f203716d.getWupBuffer();
        if (this.f203716d.getBusinessFailCode() == 1000) {
            z16 = true;
        } else {
            z16 = false;
        }
        channelManager.onReceive(serviceCmd, wupBuffer, z16, O3MainProcessChannel.a.d(null));
    }
}
