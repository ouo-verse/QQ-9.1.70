package com.tencent.imcore.message.msgproxy;

import com.tencent.imcore.message.MsgPool;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.Metadata;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class e extends d {
    static IPatchRedirector $redirector_;

    @Metadata
    public e(AppRuntime appRuntime, BaseProxyManager baseProxyManager, MsgPool msgPool) {
        super(appRuntime, baseProxyManager, msgPool);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, baseProxyManager, msgPool);
        }
    }

    protected int J0(MessageRecord messageRecord) {
        MessageRecord z06;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) messageRecord)).intValue();
        }
        if (messageRecord.extraflag == 32772) {
            z06 = t0(messageRecord, false);
        } else {
            z06 = z0(messageRecord, -2006);
        }
        if (z06 == null) {
            return -1;
        }
        if (z06.isread) {
            return 1;
        }
        return 2;
    }

    @Override // com.tencent.imcore.message.msgproxy.d, com.tencent.imcore.message.f
    public int u(MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, messageRecord, Boolean.valueOf(z16))).intValue();
        }
        if (f.e(messageRecord)) {
            return J0(messageRecord);
        }
        return super.u(messageRecord, z16);
    }
}
