package com.tencent.mobileqq.troop.troopcard.api.impl;

import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopcard.api.IVisitorTroopCardApi;
import com.tencent.mobileqq.troop.troopcard.reborn.TroopInfoCardFragment;

/* compiled from: P */
/* loaded from: classes19.dex */
public class VisitorTroopCardApiImpl implements IVisitorTroopCardApi {
    static IPatchRedirector $redirector_;

    public VisitorTroopCardApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopcard.api.IVisitorTroopCardApi
    public Class<? extends QPublicBaseFragment> getVisitorTroopCardFragmentClass(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        return TroopInfoCardFragment.class;
    }
}
