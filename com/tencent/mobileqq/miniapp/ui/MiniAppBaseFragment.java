package com.tencent.mobileqq.miniapp.ui;

import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MiniAppBaseFragment extends BaseFragment {
    static IPatchRedirector $redirector_;

    public MiniAppBaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
