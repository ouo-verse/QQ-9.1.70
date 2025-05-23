package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.activity.StructMsgObserver;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.gamecenter.api.ISearchPopService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.preload.SpringHbPreloadManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.unitedconfig_android.api.impl.UnitedConfigManagerImpl;
import com.tencent.mobileqq.upgrade.UpgradeConfigTypeParser;
import com.tencent.mobileqq.upgrade.unitedconfig.UpgradeConfigParser;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GetSplashConfig extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public GetSplashConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        T t16 = this.mAutomator;
        com.tencent.mobileqq.config.e config = ((Automator) t16).E.getConfig(((Automator) t16).E.getCurrentAccountUin(), true);
        if (QLog.isColorLevel()) {
            QLog.i("PushBannerConfig", 2, String.format(Locale.getDefault(), "GetSplashConfig config: %s", config));
        }
        T t17 = this.mAutomator;
        ConfigServlet.m(((Automator) t17).E, ((Automator) t17).E.getCurrentAccountUin());
        T t18 = this.mAutomator;
        com.tencent.mobileqq.config.splashlogo.a.b(((Automator) t18).E, ((Automator) t18).E.getCurrentUin());
        AEOldShortVideoResManager.K(((Automator) this.mAutomator).E, 1);
        ShortVideoResourceManager.I(((Automator) this.mAutomator).E, 1);
        T t19 = this.mAutomator;
        ConfigServlet.o(((Automator) t19).E, ((Automator) t19).E.getCurrentAccountUin());
        ((com.tencent.mobileqq.springhb.config.g) ((Automator) this.mAutomator).E.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER)).f(((Automator) this.mAutomator).E, 0);
        ((SpringHbPreloadManager) ((Automator) this.mAutomator).E.getManager(QQManagerFactory.SPRING_HB_PRELOAD_MANAGER)).v(false, 1);
        ISearchPopService iSearchPopService = (ISearchPopService) ((Automator) this.mAutomator).E.getRuntimeService(ISearchPopService.class, "all");
        if (iSearchPopService != null) {
            iSearchPopService.requestPreloadConfig(false);
        }
        ((Automator) this.mAutomator).E.getRuntimeService(ISpringHbReportApi.class);
        cooperation.vip.manager.h.c().a(((Automator) this.mAutomator).E);
        ((Automator) this.mAutomator).E.getMessageFacade().addObserver(new StructMsgObserver());
        ((Automator) this.mAutomator).E.getSignInInfo(1);
        if (UpgradeConfigTypeParser.e()) {
            UpgradeConfigParser.c();
        }
        UnitedConfigManagerImpl unitedConfigManagerImpl = (UnitedConfigManagerImpl) QRoute.api(IUnitedConfigManager.class);
        unitedConfigManagerImpl.fetchAll();
        unitedConfigManagerImpl.fetchNoLogin();
        if (UpgradeConfigTypeParser.e()) {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.app.automator.step.GetSplashConfig.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GetSplashConfig.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        UpgradeConfigParser.f();
                    }
                }
            }, 16, null, true, 3000L);
            return 7;
        }
        return 7;
    }
}
