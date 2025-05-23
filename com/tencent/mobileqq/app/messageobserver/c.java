package com.tencent.mobileqq.app.messageobserver;

import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c implements d {
    static IPatchRedirector $redirector_;

    public c() {
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
        switch (i3) {
            case 4014:
                bsVar.getDelSystemMsgFin(z16);
                return;
            case 4015:
                bsVar.getDelSystemMsgError();
                return;
            case 4016:
                bsVar.getPAFin(z16);
                return;
            case 4017:
                bsVar.getGroupFirstMsgFin(z16);
                return;
            case 4018:
                bsVar.newRegisterProxyFin(z16);
                return;
            default:
                switch (i3) {
                    case 5002:
                        bsVar.sendGetSig(z16);
                        return;
                    case 5003:
                        bsVar.sendGetC2CSig(z16, objArr, statictisInfo);
                        return;
                    case 5004:
                        bsVar.sendOfflineFile(z16, objArr, statictisInfo);
                        return;
                    case 5005:
                        bsVar.setOfflineFileState(z16, objArr);
                        return;
                    default:
                        return;
                }
        }
    }
}
