package com.tencent.mobileqq.leba.business.more;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.business.b;
import com.tencent.mobileqq.leba.entity.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.JumpActionLegacy;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a extends b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.leba.business.b
    public boolean b(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) iVar)).booleanValue();
        }
        if (iVar.f240490e && iVar.f240491f == 1) {
            new JumpActionLegacy((QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null), a()).o();
            return true;
        }
        return false;
    }
}
