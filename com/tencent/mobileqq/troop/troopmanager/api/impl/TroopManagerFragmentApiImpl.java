package com.tencent.mobileqq.troop.troopmanager.api.impl;

import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopmanager.TroopJumpQRPageFragment;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerFragmentApi;
import com.tencent.mobileqq.troop.troopmanager.guildmanage.guildlist.TroopBindGuildListFragment;
import com.tencent.mobileqq.troop.troopmanager.modules.memberdistinct.TroopMemberDistinctFragment;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopManagerFragmentApiImpl implements ITroopManagerFragmentApi {
    static IPatchRedirector $redirector_;

    public TroopManagerFragmentApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerFragmentApi
    public Class<? extends QPublicBaseFragment> getTroopBindGuildListFragmentClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return TroopBindGuildListFragment.class;
    }

    @Override // com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerFragmentApi
    public Class<? extends QPublicBaseFragment> getTroopJumpQRPageFragmentClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return TroopJumpQRPageFragment.class;
    }

    @Override // com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerFragmentApi
    public Class<? extends QPublicBaseFragment> getTroopMemberDistinctFragmentClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TroopMemberDistinctFragment.class;
    }
}
