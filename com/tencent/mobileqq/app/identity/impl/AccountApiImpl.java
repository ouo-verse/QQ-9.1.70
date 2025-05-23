package com.tencent.mobileqq.app.identity.impl;

import android.app.Activity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.identity.AccountIdentityManager;
import com.tencent.mobileqq.app.identity.AccountLifeCycleClient;
import com.tencent.mobileqq.app.identity.IAccountApi;
import com.tencent.mobileqq.app.identity.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AccountApiImpl implements IAccountApi {
    static IPatchRedirector $redirector_;
    boolean destroyANRBugfix;

    public AccountApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.destroyANRBugfix = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("account_api_impl_destroy_anr_bugfix", true);
        }
    }

    @Override // com.tencent.mobileqq.app.identity.IAccountApi
    public void checkAccountIdentity(AppRuntime appRuntime, int i3, com.tencent.mobileqq.identification.a aVar, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, appRuntime, Integer.valueOf(i3), aVar, fVar);
        } else {
            AccountIdentityManager.p().j(appRuntime, i3, aVar, fVar);
        }
    }

    @Override // com.tencent.mobileqq.app.identity.IAccountApi
    public void clearAccountIdentityStatus(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            AccountIdentityManager.p().m(str);
        }
    }

    @Override // com.tencent.mobileqq.app.identity.IAccountApi
    public boolean isIdentityFirstInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return AccountLifeCycleClient.b().c();
    }

    @Override // com.tencent.mobileqq.app.identity.IAccountApi
    public void onAccountLoginOrSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            AccountLifeCycleClient.b().onAccountLoginOrSwitch();
        }
    }

    @Override // com.tencent.mobileqq.app.identity.IAccountApi
    public void onActivityDestroy(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        if (this.destroyANRBugfix) {
            if (!MobileQQ.PACKAGE_NAME.equals(BaseApplication.processName)) {
                return;
            }
            ThreadManagerV2.excute(new Runnable(activity) { // from class: com.tencent.mobileqq.app.identity.impl.AccountApiImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Activity f195786d;

                {
                    this.f195786d = activity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountApiImpl.this, (Object) activity);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        AccountLifeCycleClient.b().d(true);
                        AccountLifeCycleClient.b().onActivityDestroy(this.f195786d);
                    }
                }
            }, 16, null, false);
        } else {
            AccountLifeCycleClient.b().d(false);
            AccountLifeCycleClient.b().onActivityDestroy(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.identity.IAccountApi
    public void onActivityResume(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
        } else {
            ThreadManagerV2.excute(new Runnable(activity) { // from class: com.tencent.mobileqq.app.identity.impl.AccountApiImpl.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Activity f195787d;

                {
                    this.f195787d = activity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountApiImpl.this, (Object) activity);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        AccountLifeCycleClient.b().onActivityResume(this.f195787d);
                    }
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.mobileqq.app.identity.IAccountApi
    public void onBackgroundSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            AccountLifeCycleClient.b().onBackgroundSwitch();
        }
    }

    @Override // com.tencent.mobileqq.app.identity.IAccountApi
    public void onConversationResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            AccountLifeCycleClient.b().onConversationResume();
        }
    }

    @Override // com.tencent.mobileqq.app.identity.IAccountApi
    public void onForegroundSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            AccountLifeCycleClient.b().onForegroundSwitch();
        }
    }

    @Override // com.tencent.mobileqq.app.identity.IAccountApi
    public void onPreloadEveryLogin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            AccountLifeCycleClient.b().onPreloadEveryLogin();
        }
    }

    @Override // com.tencent.mobileqq.app.identity.IAccountApi
    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            AccountLifeCycleClient.b().release();
        }
    }

    @Override // com.tencent.mobileqq.app.identity.IAccountApi
    public void setForegroundANRBugfixSwitch(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            AccountLifeCycleClient.b().e(z16);
        }
    }
}
