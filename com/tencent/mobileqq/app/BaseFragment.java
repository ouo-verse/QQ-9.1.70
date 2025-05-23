package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@Deprecated
/* loaded from: classes11.dex */
public class BaseFragment extends QBaseFragment {
    static IPatchRedirector $redirector_ = null;

    @Deprecated
    public static final String SHOULD_RESTORE_FROM_KILL = "should_restore_from_kill";

    public BaseFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final BaseActivity getBaseActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseActivity) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (BaseActivity) getActivity();
    }
}
