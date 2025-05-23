package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ap implements IFrameInjectInterface {
    static IPatchRedirector $redirector_;

    public ap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.IFrameInjectInterface
    public void frameDrawerCleanAnim(Frame frame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) frame);
            return;
        }
        FrameHelperActivity ji5 = FrameHelperActivity.ji((BaseActivity) frame.getActivity());
        if (ji5 != null) {
            ji5.Xh();
        }
    }

    @Override // com.tencent.mobileqq.app.IFrameInjectInterface
    public boolean handleCloseDrawer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (FrameHelperActivity.Gi()) {
            FrameHelperActivity.Zh();
            return true;
        }
        return false;
    }
}
