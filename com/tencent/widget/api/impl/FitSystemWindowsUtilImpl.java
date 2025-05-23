package com.tencent.widget.api.impl;

import android.view.View;
import com.tencent.mobileqq.activity.fling.ChatFragmentTopGestureLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.api.IFitSystemWindowsUtil;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FitSystemWindowsUtilImpl implements IFitSystemWindowsUtil {
    static IPatchRedirector $redirector_;

    public FitSystemWindowsUtilImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.widget.api.IFitSystemWindowsUtil
    public int getTopInset(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).intValue();
        }
        if (view instanceof ChatFragmentTopGestureLayout) {
            return ((ChatFragmentTopGestureLayout) view).getTopInst();
        }
        return -1;
    }
}
