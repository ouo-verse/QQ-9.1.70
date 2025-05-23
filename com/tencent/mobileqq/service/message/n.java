package com.tencent.mobileqq.service.message;

import MessageSvcPack.SvcRequestSendVideoMsg;
import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.m;
import com.tencent.mobileqq.streamtransfile.IStreamDataManager;
import com.tencent.qqperf.monitor.crash.ReportLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class n implements m.a {
    static IPatchRedirector $redirector_;

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.service.message.m.a
    public short a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Short) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).shortValue();
        }
        return com.tencent.mobileqq.streamtransfile.b.m(str);
    }

    @Override // com.tencent.mobileqq.service.message.m.a
    public void b(SvcRequestSendVideoMsg svcRequestSendVideoMsg, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) svcRequestSendVideoMsg, (Object) str);
            return;
        }
        ReportLog.b(ComponentFactory.ComponentType.VIDEO, "Send video message :selfUin = " + svcRequestSendVideoMsg.lUin + " toUin = " + svcRequestSendVideoMsg.lPeerUin + " buffer[2] = " + str);
    }

    @Override // com.tencent.mobileqq.service.message.m.a
    public byte[] c(String str, short s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, this, str, Short.valueOf(s16));
        }
        return com.tencent.mobileqq.streamtransfile.b.v(str, s16);
    }

    @Override // com.tencent.mobileqq.service.message.m.a
    public boolean d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        return com.tencent.mobileqq.streamtransfile.b.p(str);
    }

    @Override // com.tencent.mobileqq.service.message.m.a
    public byte[] e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (byte[]) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        return b.b(str);
    }

    @Override // com.tencent.mobileqq.service.message.m.a
    public int f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).intValue();
        }
        return com.tencent.mobileqq.streamtransfile.b.t(str);
    }

    @Override // com.tencent.mobileqq.service.message.m.a
    public short g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Short) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).shortValue();
        }
        return com.tencent.mobileqq.streamtransfile.b.o(str);
    }

    @Override // com.tencent.mobileqq.service.message.m.a
    public boolean removeStreamTaskToMemoryPool(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        return ((IStreamDataManager) QRoute.api(IStreamDataManager.class)).removeStreamTaskToMemoryPool(str);
    }
}
