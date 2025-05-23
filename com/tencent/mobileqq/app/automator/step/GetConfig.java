package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.PluginConfigProxy;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.util.BadgeUtils;
import cooperation.plugin.IPluginManager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GetConfig extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ResourcePluginListener f195346d;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class a extends ResourcePluginListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GetConfig.this);
            }
        }

        @Override // com.tencent.mobileqq.leba.observer.ResourcePluginListener
        public void b(byte b16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Byte.valueOf(b16));
            } else {
                ((Automator) GetConfig.this.mAutomator).E.removeAboutListener(this);
            }
        }

        @Override // com.tencent.mobileqq.leba.observer.ResourcePluginListener
        public void c(byte b16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Byte.valueOf(b16));
                return;
            }
            GetConfig getConfig = GetConfig.this;
            if (getConfig.mStepId == 20) {
                if (b16 != 2) {
                }
                ((ILebaHelperService) ((Automator) getConfig.mAutomator).E.getRuntimeService(ILebaHelperService.class, "")).removeLebaListener(GetConfig.this.f195346d);
                GetConfig.this.setResult(7);
            }
        }
    }

    public GetConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) ((Automator) this.mAutomator).E.getRuntimeService(IFeatureRuntimeService.class, "all");
        com.tencent.mobileqq.activity.aio.l.f179534j = iFeatureRuntimeService.isFeatureSwitchEnable("aio_handle_lrm_char");
        BadgeUtils.o(iFeatureRuntimeService.isFeatureSwitchEnable("badge_support_miui12"));
        ((ILebaHelperService) ((Automator) this.mAutomator).E.getRuntimeService(ILebaHelperService.class, "")).getAllPluginList(((Automator) this.mAutomator).E);
        PluginConfigProxy pluginConfigProxy = new PluginConfigProxy();
        ((Automator) this.mAutomator).E.getAboutConfig().r(pluginConfigProxy);
        pluginConfigProxy.b(((Automator) this.mAutomator).E);
        ((IPluginManager) ((Automator) this.mAutomator).E.getManager(QQManagerFactory.MGR_PLUGIN)).G5();
        ((IEarlyDownloadService) ((Automator) this.mAutomator).E.getRuntimeService(IEarlyDownloadService.class, "")).updateConfigs(true);
        ConfigHandler configHandler = (ConfigHandler) ((Automator) this.mAutomator).E.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
        configHandler.y3(null, configHandler.N2(), configHandler.K2(), configHandler.R2(), configHandler.H2(), configHandler.L2());
        return 7;
    }

    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (this.f195346d == null) {
            this.f195346d = new a();
            ((ILebaHelperService) ((Automator) this.mAutomator).E.getRuntimeService(ILebaHelperService.class, "")).addLebaListener(this.f195346d);
            ((Automator) this.mAutomator).E.addAboutListener(this.f195346d);
        }
    }

    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f195346d = null;
        }
    }
}
