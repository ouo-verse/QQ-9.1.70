package com.tencent.mobileqq.troop.creditlevel.api.impl;

import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.creditlevel.api.ITroopCreditLevelEntryApi;
import com.tencent.mobileqq.troop.creditlevel.config.a;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopCreditLevelEntryApiImpl implements ITroopCreditLevelEntryApi {
    static IPatchRedirector $redirector_;

    public TroopCreditLevelEntryApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.creditlevel.api.ITroopCreditLevelEntryApi
    public boolean isShowEntry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        a aVar = (a) am.s().x(844);
        if (aVar != null && aVar.a()) {
            return true;
        }
        return false;
    }
}
