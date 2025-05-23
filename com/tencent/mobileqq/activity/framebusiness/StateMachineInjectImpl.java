package com.tencent.mobileqq.activity.framebusiness;

import android.view.View;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyPlatform;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.widget.TabViewMap;
import com.tencent.statemachine.api.IStateManager;

/* compiled from: P */
/* loaded from: classes10.dex */
public class StateMachineInjectImpl extends a {
    static IPatchRedirector $redirector_;

    public StateMachineInjectImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void B(FrameFragment frameFragment) {
        View view;
        TabViewMap tabViewMap = frameFragment.mTabViewMap;
        if (tabViewMap != null && (view = tabViewMap.get(TabDataHelper.TAB_CONVERSATION)) != null) {
            ((IQQKuiklyPlatform) QRoute.api(IQQKuiklyPlatform.class)).updateTabBarHeight(view.getHeight());
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void a(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) frameFragment);
        } else if (frameFragment instanceof MainFragment) {
            ThreadManagerV2.excute(new Runnable(frameFragment.getCurrentTab()) { // from class: com.tencent.mobileqq.activity.framebusiness.StateMachineInjectImpl.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f182310d;

                {
                    this.f182310d = r5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StateMachineInjectImpl.this, r5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ((IStateManager) QRoute.api(IStateManager.class)).onMainFragmentChange(this.f182310d, true);
                    }
                }
            }, 16, null, true);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.w
    public String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "STATE_MACHINE";
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void l(FrameFragment frameFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) frameFragment);
        } else if (frameFragment instanceof MainFragment) {
            ((IStateManager) QRoute.api(IStateManager.class)).onMainFragmentChange(frameFragment.getCurrentTab(), false);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void y(FrameFragment frameFragment, int i3, be beVar, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, frameFragment, Integer.valueOf(i3), beVar, Integer.valueOf(i16));
        } else if (frameFragment instanceof MainFragment) {
            ThreadManagerV2.excute(new Runnable(i16, i3) { // from class: com.tencent.mobileqq.activity.framebusiness.StateMachineInjectImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f182308d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f182309e;

                {
                    this.f182308d = i16;
                    this.f182309e = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, StateMachineInjectImpl.this, Integer.valueOf(i16), Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ((IStateManager) QRoute.api(IStateManager.class)).onMainTabChange(this.f182308d);
                        ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).onMainTabChange(this.f182309e, this.f182308d);
                    }
                }
            }, 16, null, true);
        }
    }

    @Override // com.tencent.mobileqq.activity.framebusiness.a, com.tencent.mobileqq.activity.home.w
    public void z(TabFrameControllerImpl tabFrameControllerImpl, FrameFragment frameFragment, com.tencent.mobileqq.activity.home.impl.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, tabFrameControllerImpl, frameFragment, dVar);
        } else if (frameFragment instanceof MainFragment) {
            B(frameFragment);
        }
    }
}
