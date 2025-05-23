package com.tencent.mobileqq.troop.api.config;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496$AioKeyword;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496$GroupMsgConfig;

/* compiled from: P */
/* loaded from: classes19.dex */
public class g {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AppInterface appInterface, oidb_0x496$AioKeyword oidb_0x496_aiokeyword) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface, (Object) oidb_0x496_aiokeyword);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(AppInterface appInterface, oidb_0x496$GroupMsgConfig oidb_0x496_groupmsgconfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) oidb_0x496_groupmsgconfig);
        }
    }
}
