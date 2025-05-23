package com.tencent.mobileqq.app.messageobserver;

import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class i implements d {
    static IPatchRedirector $redirector_;

    public i() {
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
        if (i3 != 999) {
            if (i3 != 1000) {
                if (i3 != 3011) {
                    if (i3 != 3012) {
                        switch (i3) {
                            case 1002:
                                bsVar.msgDelFriend(objArr);
                                return;
                            case 1003:
                                bsVar.delRoamChatFriend(z16);
                                return;
                            case 1004:
                                bsVar.getRoamChat(z16, obj);
                                return;
                            case 1005:
                                bsVar.setRoamChat(z16);
                                return;
                            default:
                                switch (i3) {
                                    case 2000:
                                        bsVar.friendsListRefresh();
                                        return;
                                    case 2001:
                                        bsVar.troopListRefresh();
                                        return;
                                    case 2002:
                                        bsVar.recentListRefresh();
                                        return;
                                    default:
                                        return;
                                }
                        }
                    }
                    bsVar.transserviceTempChatDownloadPic(z16, objArr);
                    return;
                }
                bsVar.transserviceC2CUploadStreamPtt(z16, objArr);
                return;
            }
            bsVar.comenMsgReceived();
            return;
        }
        bsVar.commenMsgContentChanged(z16, obj);
    }
}
