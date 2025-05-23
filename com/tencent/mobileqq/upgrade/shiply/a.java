package com.tencent.mobileqq.upgrade.shiply;

import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.upgrade.UpgradeConfigTypeParser;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.e;
import com.tencent.mobileqq.upgrade.k;
import com.tencent.mobileqq.upgrade.n;
import com.tencent.mobileqq.upgrade.unitedconfig.UpgradeConfigParser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upgrade.bean.UpgradeStrategy;
import mqq.app.MobileQQ;
import protocol.KQQConfig.UpgradeInfo;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements com.tencent.mobileqq.upgrade.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f306317a;

    /* renamed from: b, reason: collision with root package name */
    private MMKVOptionEntity f306318b;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f306317a = false;
        }
    }

    private MMKVOptionEntity e() {
        if (this.f306318b == null) {
            this.f306318b = QMMKV.from(MobileQQ.sMobileQQ, "BuglySdkInfos");
        }
        return this.f306318b;
    }

    @NonNull
    private UpgradeDetailWrapper g(@NonNull UpgradeStrategy upgradeStrategy) {
        UpgradeDetailWrapper j3 = k.i().j();
        if (!j3.j(upgradeStrategy)) {
            this.f306317a = true;
        }
        return j3;
    }

    @Override // com.tencent.mobileqq.upgrade.b
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (UpgradeConfigTypeParser.f()) {
            UpgradeConfigParser.c();
        }
    }

    @Override // com.tencent.mobileqq.upgrade.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (!UpgradeConfigTypeParser.f()) {
            return;
        }
        int i3 = k.i().j().f306170d.iUpgradeSdkId64;
        QLog.i("ShiplyUpgradeManager", 1, "doOnDownloadSuccess installAppID = " + i3);
        MMKVOptionEntity e16 = e();
        e16.encodeInt("last_shiply_install_appid", i3);
        e16.encodeInt("last_upgrade_current_appid", AppSetting.f());
    }

    @Override // com.tencent.mobileqq.upgrade.b
    public void c(UpgradeStrategy upgradeStrategy, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, upgradeStrategy, Boolean.valueOf(z16));
            return;
        }
        if (upgradeStrategy == null) {
            this.f306317a = true;
            f();
            return;
        }
        this.f306317a = false;
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().peekAppRuntime();
        if (qQAppInterface == null) {
            QLog.w("ShiplyUpgradeManager", 1, "onShiplyUpgradeStrategyBack|GET_CONFIG_UPGRADE QQAppInterface is null!!");
            return;
        }
        UpgradeDetailWrapper g16 = g(upgradeStrategy);
        ConfigHandler configHandler = (ConfigHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
        if (this.f306317a) {
            if (z16) {
                configHandler.t3();
            }
            configHandler.m3(g16);
            return;
        }
        UpgradeInfo upgradeInfo = g16.f306171e;
        if (upgradeInfo != null && upgradeInfo.isValid) {
            QLog.d("ShiplyUpgradeManager", 1, String.format("onShiplyUpgradeStrategyBack|GET_CONFIG_UPGRADE localAppID=%s configAppID=%s", Integer.valueOf(AppSetting.f()), Integer.valueOf(g16.f306171e.iUpgradeSdkId)));
            n.a(g16);
            if (AppSetting.f() >= g16.f306171e.iUpgradeSdkId) {
                QLog.d("ShiplyUpgradeManager", 1, "processLastConfig|GET_CONFIG_UPGRADE config APP_ID not correctly?");
                g16.f306171e.iUpgradeType = 0;
                configHandler.m3(g16);
                configHandler.t3();
                return;
            }
            synchronized (g16) {
                QLog.d("ShiplyUpgradeManager", 1, "processLastConfig|GET_CONFIG_UPGRADE do upgrade.");
                if (g16.D == 0) {
                    if (g16.C == 1) {
                        z17 = true;
                    }
                    ConfigHandler.w3(qQAppInterface, z17);
                }
                if (z16) {
                    configHandler.t3();
                }
                k.i().o(g16.f306171e, configHandler);
            }
            return;
        }
        QLog.d("ShiplyUpgradeManager", 1, "onShiplyUpgradeStrategyBack|GET_CONFIG_UPGRADE config invalid.");
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        MMKVOptionEntity e16 = e();
        int decodeInt = e16.decodeInt("last_shiply_install_appid", -1);
        int decodeInt2 = e16.decodeInt("last_upgrade_current_appid", -1);
        int f16 = AppSetting.f();
        if (decodeInt > 0) {
            if (f16 == decodeInt) {
                e.e().o(true);
            }
            if (f16 != decodeInt2) {
                e16.encodeInt("last_shiply_install_appid", -1);
                e16.encodeInt("last_upgrade_current_appid", -1);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("ShiplyUpgradeManager", 2, "doOnInit lastInstallAppID = " + decodeInt + " | currentAppid = " + f16);
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        e.e().b();
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().peekAppRuntime();
        if (qQAppInterface == null) {
            QLog.w("ShiplyUpgradeManager", 1, "defaultConfig|GET_CONFIG_UPGRADE QQAppInterface is null!!");
            return;
        }
        UpgradeDetailWrapper j3 = k.i().j();
        ConfigHandler configHandler = (ConfigHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
        configHandler.t3();
        configHandler.m3(j3);
    }
}
