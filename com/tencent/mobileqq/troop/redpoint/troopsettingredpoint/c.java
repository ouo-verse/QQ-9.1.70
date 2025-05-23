package com.tencent.mobileqq.troop.redpoint.troopsettingredpoint;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.redpoint.RedPointItem;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointInfoService;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends a {
    static IPatchRedirector $redirector_;

    public c(QQAppInterface qQAppInterface, String str) {
        super(qQAppInterface, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.a
    public void a() {
        RedPointItem a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.mobileqq.troop.redpoint.b redPointInfo = ((IRedPointInfoService) this.f298278b.getRuntimeService(IRedPointInfoService.class, "")).getRedPointInfo(this.f298277a, "troop");
        if (redPointInfo != null && (a16 = redPointInfo.a(5)) != null && a16.unReadNum != 0) {
            ((IRedPointUtilsApi) QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(this.f298278b, this.f298277a, "troop", 5, 0);
            ((qt2.a) this.f298278b.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).v2(this.f298277a, 101913298);
        }
    }

    @Override // com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.a
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TroopMgrAppProcessor";
    }

    @Override // com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.a
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        TroopInfo k3 = ((TroopManager) this.f298278b.getManager(QQManagerFactory.TROOP_MANAGER)).k(this.f298277a);
        if (k3 == null || !k3.isOwnerOrAdmin(this.f298278b.getCurrentAccountUin())) {
            ((IRedPointUtilsApi) QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(this.f298278b, this.f298277a, "troop", 5, 0);
        }
    }
}
