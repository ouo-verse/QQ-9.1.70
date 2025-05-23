package com.tencent.mobileqq.app.messageobserver;

import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b implements d {
    static IPatchRedirector $redirector_;

    public b() {
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
        if (i3 != 3021) {
            switch (i3) {
                case 4001:
                    bsVar.getMsgFin(z16);
                    return;
                case 4002:
                    bsVar.getDiscussionMsgFin(z16);
                    return;
                case 4003:
                    bsVar.getTroopMsgFin(z16, objArr);
                    return;
                case 4004:
                    bsVar.registerProxyFin(z16, obj);
                    return;
                case 4005:
                    bsVar.getSystemMsgFin(z16, false, (List) obj);
                    return;
                case 4006:
                    bsVar.getSystemMsgFin(false, true, null);
                    return;
                default:
                    switch (i3) {
                        case 4011:
                            bsVar.sendSystemMsgActionFin(z16, (ToServiceMsg) obj);
                            return;
                        case 4012:
                            bsVar.sendSystemMsgActionError((ToServiceMsg) obj);
                            return;
                        case 4013:
                            bsVar.getAllProxyTroopMsg(z16, objArr);
                            return;
                        default:
                            return;
                    }
            }
        }
        bsVar.receiptErrorRsp((Long[]) obj);
    }
}
