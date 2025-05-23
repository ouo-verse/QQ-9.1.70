package com.tencent.mobileqq.qqcommon.api.impl;

import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqcommon.api.IHapticManagerApi;

/* compiled from: P */
/* loaded from: classes16.dex */
public class HapticManagerApiImpl implements IHapticManagerApi {
    static IPatchRedirector $redirector_;

    public HapticManagerApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IHapticManagerApi
    public void addEffects() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            HapticManager.m().e();
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IHapticManagerApi
    public void pauseEffect(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            HapticManager.m().r(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IHapticManagerApi
    public int playEffect(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3)).intValue();
        }
        return HapticManager.m().s(str, i3);
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IHapticManagerApi
    public void resumeEffect(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            HapticManager.m().u(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IHapticManagerApi
    public void stopEffect(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            HapticManager.m().w(i3);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IHapticManagerApi
    public void update(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            HapticManager.m().x(i3, i16);
        }
    }
}
