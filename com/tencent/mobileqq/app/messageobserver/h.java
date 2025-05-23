package com.tencent.mobileqq.app.messageobserver;

import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class h implements d {
    static IPatchRedirector $redirector_;

    public h() {
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
        if (i3 != 6008) {
            if (i3 != 8011) {
                if (i3 != 8013) {
                    if (i3 != 8015) {
                        if (i3 != 8003) {
                            if (i3 != 8004) {
                                switch (i3) {
                                    case 6014:
                                        bsVar.iPadOnlinesStatus(objArr);
                                        return;
                                    case 6015:
                                        bsVar.receiptRead((Long[]) obj);
                                        return;
                                    case 6016:
                                        bsVar.pushUpdateLoginDevStatus(objArr);
                                        return;
                                    default:
                                        return;
                                }
                            }
                            bsVar.subaccountPushMsg(z16, obj);
                            return;
                        }
                        bsVar.subaccountGetMsg(z16, obj);
                        return;
                    }
                    bsVar.roamMessageSearchInCloud(z16, obj);
                    return;
                }
                bsVar.pcActiveNotify(z16, objArr);
                return;
            }
            bsVar.subaccountMsgNumReadedConfirm(z16, obj);
            return;
        }
        bsVar.refreshRecentListFinish(z16);
    }
}
