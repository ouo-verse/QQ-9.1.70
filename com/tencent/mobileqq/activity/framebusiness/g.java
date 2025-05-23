package com.tencent.mobileqq.activity.framebusiness;

import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.leba.ILebaFrameApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes10.dex */
public class g extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f182384d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68304);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f182384d = false;
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void a(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) frameFragment);
        } else if (frameFragment != null && f182384d) {
            f182384d = false;
            frameFragment.mTabIndicator.setCurrentTabByTag(((ILebaFrameApi) QRoute.api(ILebaFrameApi.class)).getLebaFrameClass().getName());
        }
    }

    @Override // com.tencent.mobileqq.activity.home.w
    public String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "MATCH_FRIEND";
    }
}
