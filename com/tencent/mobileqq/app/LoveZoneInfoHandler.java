package com.tencent.mobileqq.app;

import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_PAIR.sweet_pair_check_rsp;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.lovechat.api.ILoveStateData;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class LoveZoneInfoHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f194791d;

    protected LoveZoneInfoHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f194791d = qQAppInterface;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    public void D2(boolean z16, sweet_pair_check_rsp sweet_pair_check_rspVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), sweet_pair_check_rspVar);
            return;
        }
        if (z16 && sweet_pair_check_rspVar != null) {
            if (sweet_pair_check_rspVar.host_state != 3) {
                i3 = 0;
            }
            sweet_req_comm sweet_req_commVar = sweet_pair_check_rspVar.req_comm;
            if (sweet_req_commVar != null) {
                str = String.valueOf(sweet_req_commVar.loveuin);
            } else {
                str = "0";
            }
            E2(i3, str);
        }
    }

    public void E2(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
            return;
        }
        ((ILoveStateData) QRoute.api(ILoveStateData.class)).setLoveState(i3);
        ((ILoveStateData) QRoute.api(ILoveStateData.class)).setLoveUin(str);
        notifyUI(1, true, Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return bn.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
        }
    }

    protected LoveZoneInfoHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
        } else if (appInterface instanceof QQAppInterface) {
            this.f194791d = (QQAppInterface) appInterface;
        }
    }
}
