package com.tencent.mobileqq.leba.business.itemfilter;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.leba.business.c;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b implements c {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean b(n nVar) {
        if (AppSetting.o(BaseApplication.getContext()) && nVar.f240505b.uiResId == 4040) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.leba.business.c
    public boolean a(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) nVar)).booleanValue();
        }
        if (b(nVar)) {
            com.tencent.xaction.log.b.a("PadPluginFilter", 1, "filterMgrList: " + nVar.f240505b.uiResId);
            return true;
        }
        return false;
    }
}
