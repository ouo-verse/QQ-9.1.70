package com.tencent.mobileqq.service.message;

import MessageSvcPack.SvcResponseGetMsgV2;
import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.k;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qqperf.monitor.crash.ReportLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class l implements k.a {
    static IPatchRedirector $redirector_;

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.service.message.k.a
    public void a(FromServiceMsg fromServiceMsg, SvcResponseGetMsgV2 svcResponseGetMsgV2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fromServiceMsg, (Object) svcResponseGetMsgV2);
            return;
        }
        ReportLog.b(ComponentFactory.ComponentType.VIDEO, "Receive message packet: seq = " + fromServiceMsg.getRequestSsoSeq() + " size = " + svcResponseGetMsgV2.vMsgInfos.size());
    }

    @Override // com.tencent.mobileqq.service.message.k.a
    public String b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        return com.tencent.mobileqq.streamtransfile.b.n(i3, 0);
    }
}
