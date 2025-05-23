package com.tencent.mobileqq.doodle.impl;

import com.tencent.mobileqq.doodle.IDoodleXPanelContainer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.XPanelContainer;

/* loaded from: classes10.dex */
public class DoodleXPanelContainerImpl implements IDoodleXPanelContainer {
    static IPatchRedirector $redirector_;

    public DoodleXPanelContainerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.doodle.IDoodleXPanelContainer
    public int getExternalPanelheight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return XPanelContainer.f384714h0;
    }

    @Override // com.tencent.mobileqq.doodle.IDoodleXPanelContainer
    public int getXPanelContainerNONE() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.doodle.IDoodleXPanelContainer
    public void setExternalPanelheight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            XPanelContainer.f384714h0 = i3;
        }
    }
}
