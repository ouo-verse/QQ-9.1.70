package com.tencent.statemachine.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.statemachine.MainStateManager;
import com.tencent.statemachine.api.IStateManager;
import com.tencent.statemachine.api.StateObserver;

/* compiled from: P */
/* loaded from: classes26.dex */
public class StateManagerImpl implements IStateManager {
    static IPatchRedirector $redirector_;

    public StateManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.statemachine.api.IStateManager
    public void addMainStateObserver(StateObserver stateObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) stateObserver);
        } else {
            MainStateManager.getInstance().addMainStateObserver(stateObserver);
        }
    }

    @Override // com.tencent.statemachine.api.IStateManager
    public void onMainDrawerChange(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            MainStateManager.getInstance().onMainDrawerChange(z16);
        }
    }

    @Override // com.tencent.statemachine.api.IStateManager
    public void onMainFragmentChange(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            MainStateManager.getInstance().onMainFragmentChange(i3, z16);
        }
    }

    @Override // com.tencent.statemachine.api.IStateManager
    public void onMainTabChange(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            MainStateManager.getInstance().onMainTabChange(i3);
        }
    }

    @Override // com.tencent.statemachine.api.IStateManager
    public void removeMainStateObserver(StateObserver stateObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) stateObserver);
        } else {
            MainStateManager.getInstance().removeMainStateObserver(stateObserver);
        }
    }
}
