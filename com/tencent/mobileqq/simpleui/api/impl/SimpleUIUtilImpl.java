package com.tencent.mobileqq.simpleui.api.impl;

import android.view.Window;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.simpleui.api.ISimpleUIUtil;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.SystemBarCompact;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SimpleUIUtilImpl implements ISimpleUIUtil {
    static IPatchRedirector $redirector_;

    public SimpleUIUtilImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.simpleui.api.ISimpleUIUtil
    public void adjustSimpleStatusBar(ImmersiveTitleBar2 immersiveTitleBar2, Window window) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            SimpleUIUtil.adjustSimpleStatusBar(immersiveTitleBar2, window);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) immersiveTitleBar2, (Object) window);
        }
    }

    @Override // com.tencent.mobileqq.simpleui.api.ISimpleUIUtil
    public boolean getSimpleUISwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return SimpleUIUtil.getSimpleUISwitch();
    }

    @Override // com.tencent.mobileqq.simpleui.api.ISimpleUIUtil
    public void adjustSimpleStatusBar(SystemBarCompact systemBarCompact, Window window) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            SimpleUIUtil.adjustSimpleStatusBar(systemBarCompact, window);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) systemBarCompact, (Object) window);
        }
    }
}
