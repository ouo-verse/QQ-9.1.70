package com.tencent.mobileqq.upgrade.unitedconfig;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.upgrade.UpgradeConfigTypeParser;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.k;
import com.tencent.mobileqq.upgrade.n;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.UpgradeInfo;

/* loaded from: classes20.dex */
public class UpgradeConfigParser extends BaseConfigParser<UpgradeDetailWrapper> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f306319d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f306320e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77173);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f306319d = false;
            f306320e = false;
        }
    }

    public UpgradeConfigParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void c() {
        QLog.d("UpgradeConfigParser", 1, "doBeforeLoadConfig|GET_CONFIG_UPGRADE start");
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().peekAppRuntime();
        if (qQAppInterface == null) {
            QLog.w("UpgradeConfigParser", 1, "doBeforeLoadConfig|GET_CONFIG_UPGRADE QQAppInterface is null!!");
            return;
        }
        qQAppInterface.getPreloadSwitch();
        OpenConfig.i(qQAppInterface.getApp(), String.valueOf(AppSetting.f()));
        ((ConfigHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).q3();
    }

    public static void f() {
        UpgradeDetailWrapper upgradeDetailWrapper = (UpgradeDetailWrapper) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100749");
        boolean z16 = true;
        QLog.d("UpgradeConfigParser", 1, "processLastConfig|GET_CONFIG_UPGRADE hasUpdated: " + f306319d + ", isParseConfigEmpty: " + f306320e);
        if (upgradeDetailWrapper == null) {
            QLog.d("UpgradeConfigParser", 1, "processLastConfig|GET_CONFIG_UPGRADE config is null.");
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().peekAppRuntime();
        if (qQAppInterface == null) {
            QLog.w("UpgradeConfigParser", 1, "processLastConfig|GET_CONFIG_UPGRADE QQAppInterface is null!!");
            return;
        }
        ConfigHandler configHandler = (ConfigHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
        if (f306320e) {
            if (f306319d) {
                configHandler.t3();
            }
            configHandler.m3(upgradeDetailWrapper);
        } else {
            UpgradeInfo upgradeInfo = upgradeDetailWrapper.f306171e;
            if (upgradeInfo != null && upgradeInfo.isValid) {
                QLog.d("UpgradeConfigParser", 1, String.format("processLastConfig|GET_CONFIG_UPGRADE localAppID=%s configAppID=%s", Integer.valueOf(AppSetting.f()), Integer.valueOf(upgradeDetailWrapper.f306171e.iUpgradeSdkId)));
                n.a(upgradeDetailWrapper);
                if (AppSetting.f() >= upgradeDetailWrapper.f306171e.iUpgradeSdkId) {
                    QLog.d("UpgradeConfigParser", 1, "processLastConfig|GET_CONFIG_UPGRADE config APP_ID not correctly?");
                    upgradeDetailWrapper.f306171e.iUpgradeType = 0;
                    configHandler.m3(upgradeDetailWrapper);
                    configHandler.t3();
                } else {
                    synchronized (upgradeDetailWrapper) {
                        if (!upgradeDetailWrapper.f306175m) {
                            QLog.d("UpgradeConfigParser", 1, "processLastConfig|GET_CONFIG_UPGRADE waiting switch bit.");
                            return;
                        }
                        QLog.d("UpgradeConfigParser", 1, "processLastConfig|GET_CONFIG_UPGRADE do upgrade.");
                        if (upgradeDetailWrapper.D == 0) {
                            if (upgradeDetailWrapper.C != 1) {
                                z16 = false;
                            }
                            ConfigHandler.w3(qQAppInterface, z16);
                        }
                        if (f306319d) {
                            configHandler.t3();
                        }
                        k.i().o(upgradeDetailWrapper.f306171e, configHandler);
                    }
                }
            } else {
                QLog.d("UpgradeConfigParser", 1, "processLastConfig|GET_CONFIG_UPGRADE config invalid.");
                return;
            }
        }
        f306319d = false;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public UpgradeDetailWrapper defaultConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (UpgradeDetailWrapper) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        QLog.d("UpgradeConfigParser", 1, "[defaultConfig]|GET_CONFIG_UPGRADE get config fail. use defaultConfig");
        f306320e = true;
        UpgradeDetailWrapper j3 = k.i().j();
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().peekAppRuntime();
        if (qQAppInterface == null) {
            QLog.w("UpgradeConfigParser", 1, "defaultConfig|GET_CONFIG_UPGRADE QQAppInterface is null!!");
            return j3;
        }
        ((ConfigHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).m3(j3);
        return j3;
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable UpgradeDetailWrapper upgradeDetailWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) upgradeDetailWrapper);
            return;
        }
        super.doOnConfigUpdate(upgradeDetailWrapper);
        QLog.d("UpgradeConfigParser", 1, "doOnConfigUpdate|GET_CONFIG_UPGRADE UpgradeDetailWrapper: " + upgradeDetailWrapper);
        if (!UpgradeConfigTypeParser.e()) {
            QLog.d("UpgradeConfigParser", 1, "doOnConfigUpdate|GET_CONFIG_UPGRADE useFreesia is false");
        } else {
            f306319d = true;
            f();
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NonNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public UpgradeDetailWrapper parse(@NonNull byte[] bArr) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (UpgradeDetailWrapper) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
        }
        if (bArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        f306320e = z16;
        if (z16) {
            return defaultConfig();
        }
        UpgradeDetailWrapper j3 = k.i().j();
        j3.e(new String(bArr), "freesia");
        return j3;
    }
}
