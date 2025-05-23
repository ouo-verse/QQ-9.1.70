package com.tencent.mobileqq.troop.troopgag.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.troopgag.api.a;
import com.tencent.mobileqq.troop.troopgag.api.b;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopGagHandler extends TroopBaseHandler implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    HashMap<String, Long> f300220e;

    public TroopGagHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f300220e = new HashMap<>();
        }
    }

    @Override // com.tencent.mobileqq.troop.troopgag.api.a
    public void C(com.tencent.mobileqq.troop.troopgag.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else {
            notifyUI(b.f300219e, true, aVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopGagHandler";
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopgag.api.a
    public void u0(String str, String str2, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, Boolean.valueOf(z16), Long.valueOf(j3));
            return;
        }
        com.tencent.mobileqq.troop.troopgag.data.a aVar = new com.tencent.mobileqq.troop.troopgag.data.a(str, str2, new com.tencent.mobileqq.troop.troopgag.data.b(z16, j3));
        aVar.f300229i = 3;
        C(aVar);
    }
}
