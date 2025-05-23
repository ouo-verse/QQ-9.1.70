package com.tencent.mobileqq.app.messageobserver;

import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a implements d {
    static IPatchRedirector $redirector_;

    public a() {
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
        if (i3 != 5006) {
            if (i3 != 5010) {
                if (i3 != 5012) {
                    if (i3 != 8047) {
                        if (i3 != 6017) {
                            if (i3 != 6018) {
                                switch (i3) {
                                    case 6001:
                                        bsVar.reqInsertBlacklist(z16, obj);
                                        return;
                                    case 6002:
                                        bsVar.reqDeleteBlacklist(z16, (Object[]) obj);
                                        return;
                                    case 6003:
                                        bsVar.sendResult(z16, objArr);
                                        return;
                                    case 6004:
                                        bsVar.pushReadedNotify(z16, obj);
                                        return;
                                    case 6005:
                                        bsVar.getOfflineFinish(z16);
                                        return;
                                    case 6006:
                                        bsVar.getOfflineStart(z16);
                                        return;
                                    case 6007:
                                        bsVar.pcOnlinesStatus(objArr);
                                        return;
                                    default:
                                        return;
                                }
                            }
                            bsVar.onRegisterProxyReceiving();
                            return;
                        }
                        bsVar.recvEmoticonRandomResult(z16, objArr);
                        return;
                    }
                    bsVar.updateSelfMsgSeqAndTime(obj);
                    return;
                }
                bsVar.c2cOnlineFile(z16, objArr);
                return;
            }
            bsVar.updateSecretfileStatus();
            return;
        }
        bsVar.richSendNotifyMsg(z16, objArr, statictisInfo);
    }
}
