package com.tencent.mobileqq.app.messageobserver;

import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g implements d {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.messageobserver.d
    public void a(bs bsVar, int i3, boolean z16, Object obj, Object[] objArr, StatictisInfo statictisInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, bsVar, Integer.valueOf(i3), Boolean.valueOf(z16), obj, objArr, statictisInfo);
            return;
        }
        if (i3 != 8038) {
            if (i3 != 8039) {
                if (i3 != 8046) {
                    switch (i3) {
                        case MessageHandlerConstants.NOTIFY_TYPE_MAC_ONLINES_STATUS /* 8033 */:
                            bsVar.macOnlinesStatus(objArr);
                            return;
                        case MessageHandlerConstants.NOTIFY_TYPE_DANCE_MACHINE /* 8034 */:
                            bsVar.danceMachine(obj);
                            return;
                        case MessageHandlerConstants.NOTIFY_TYPE_CONFESS_TMP /* 8035 */:
                            bsVar.handle_NOTIFY_TYPE_CONFESS_TMP(z16, objArr);
                            return;
                        default:
                            return;
                    }
                }
                bsVar.sendResultWithTransinfo(z16, obj);
                return;
            }
            bsVar.deleteAllSystemMsg(z16, objArr);
            return;
        }
        bsVar.watchOnlineStatus(objArr);
    }
}
