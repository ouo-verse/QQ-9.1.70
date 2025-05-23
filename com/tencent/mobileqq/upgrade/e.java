package com.tencent.mobileqq.upgrade;

import android.os.Build;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.privacy.PrivacyPolicyHelper;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.impl.ShiplyImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upgrade.bean.UpgradeConfig;
import com.tencent.upgrade.bean.UpgradeStrategy;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicBoolean f306296d;

    /* renamed from: a, reason: collision with root package name */
    private b f306297a;

    /* renamed from: b, reason: collision with root package name */
    private UpgradeStrategy f306298b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f306299c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static e f306300a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35471);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f306300a = new e();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35479);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            f306296d = new AtomicBoolean(false);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f306297a = null;
        this.f306298b = null;
        this.f306299c = false;
    }

    @NonNull
    private static Map<String, String> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("appid", AppSetting.f() + "");
        return hashMap;
    }

    private String d() {
        if (PrivacyPolicyHelper.isUserAllow()) {
            return DeviceInfoMonitor.getModel();
        }
        return "default_model";
    }

    public static e e() {
        return a.f306300a;
    }

    private String g() {
        SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        if (firstSimpleAccount != null) {
            try {
                return firstSimpleAccount.getUin();
            } catch (NumberFormatException e16) {
                QLog.e("ShiplyUpgradeManager", 1, "getUin error", e16);
            }
        }
        return MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN;
    }

    private void i() {
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        String g16 = g();
        String d16 = d();
        d dVar = new d();
        UpgradeConfig.Builder builder = new UpgradeConfig.Builder();
        Map<String, String> c16 = c();
        if (1 == MobileQQ.sProcessId) {
            z16 = true;
        } else {
            z16 = false;
        }
        UpgradeConfig.Builder cacheExpireTime = builder.appId(ShiplyImpl.APP_ID).appKey(ShiplyImpl.APP_KEY).userId(g16).systemVersion(String.valueOf(Build.VERSION.SDK_INT)).devModel(d16).cacheExpireTime(21600000L);
        Boolean bool = Boolean.FALSE;
        cacheExpireTime.internalInitMMKVForRDelivery(bool).customLogger(dVar).useSPStorage(bool).monitorLifecycle(false).customParams(c16).isMainProcess(Boolean.valueOf(z16)).enableBuglyQQCrashReport(bool);
        com.tencent.upgrade.core.j.l().p(BaseApplication.getContext(), builder.build());
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        Object m3 = com.tencent.upgrade.core.j.l().m();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("initInner end, cost:");
        sb5.append(currentTimeMillis2);
        sb5.append(" upgradeRDeliveryImpl is ");
        if (m3 == null) {
            m3 = "null";
        }
        sb5.append(m3);
        QLog.d("ShiplyUpgradeManager", 1, sb5.toString());
    }

    public void a(boolean z16, boolean z17, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Boolean.valueOf(z17), map);
            return;
        }
        if (!f306296d.get()) {
            return;
        }
        b bVar = this.f306297a;
        if (bVar != null) {
            bVar.a();
        }
        this.f306298b = com.tencent.upgrade.core.j.l().h();
        com.tencent.upgrade.core.j.l().b(z16, z17, false, map, new c());
        if (QLog.isColorLevel()) {
            QLog.d("ShiplyUpgradeManager", 2, "checkUpgrade end forceRequestRemoteStrategy:" + z16);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (f306296d.get()) {
            com.tencent.upgrade.core.j.l().c();
            this.f306298b = null;
        }
    }

    public UpgradeStrategy f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (UpgradeStrategy) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f306298b;
    }

    public synchronized void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            if (f306296d.compareAndSet(false, true)) {
                i();
            }
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (this.f306299c) {
            try {
                if (com.tencent.upgrade.core.j.l().m() != null) {
                    com.tencent.upgrade.core.g.a();
                } else {
                    QLog.e("ShiplyUpgradeManager", 1, "notifyFirstActiveSuccess jump for upgradeRDeliveryImpl is null!");
                }
            } catch (Throwable th5) {
                QLog.e("ShiplyUpgradeManager", 1, "notifyFirstActiveSuccess has Exception!", th5);
            }
            this.f306299c = false;
        }
    }

    public void k(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        if (!UpgradeConfigTypeParser.f()) {
            return;
        }
        if (f306296d.get()) {
            try {
                com.tencent.upgrade.core.g.b(z16);
            } catch (Throwable th5) {
                QLog.e("ShiplyUpgradeManager", 1, "notifyUpgradeDownloadSuccess has Exception!", th5);
            }
        }
        b bVar = this.f306297a;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (!f306296d.get() || !UpgradeConfigTypeParser.f()) {
            return;
        }
        try {
            com.tencent.upgrade.core.g.c(true);
        } catch (Throwable th5) {
            QLog.e("ShiplyUpgradeManager", 1, "notifyUpgradeInstall has Exception!", th5);
        }
        QLog.d("ShiplyUpgradeManager", 1, "notifyUpgradeInstall invoke success");
    }

    public void m(@NonNull UpgradeStrategy upgradeStrategy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) upgradeStrategy);
            return;
        }
        boolean z16 = true;
        if (!UpgradeConfigTypeParser.f()) {
            QLog.w("ShiplyUpgradeManager", 1, "parseUpgradeStrategy UpgradeConfigTypeParser isShiplyConfigEnable false.");
            return;
        }
        UpgradeStrategy f16 = f();
        if (f16 != null) {
            z16 = new com.tencent.upgrade.checker.b().a(f16, upgradeStrategy);
        }
        b bVar = this.f306297a;
        if (bVar != null) {
            bVar.c(upgradeStrategy, z16);
        }
    }

    public void n(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            return;
        }
        if (!f306296d.get() || !UpgradeConfigTypeParser.f()) {
            return;
        }
        String g16 = g();
        if (str == null) {
            str2 = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
        } else {
            str2 = str;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("updateUin", g16);
        hashMap.put("updateVersion", str2);
        hashMap.put("dialogTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(System.currentTimeMillis())));
        StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(g16, "shiply_upgrade_dialog_show", true, 0L, 0L, hashMap, "", false);
        QLog.d("ShiplyUpgradeManager", 1, "reportDialogShow invoke success version is " + str);
    }

    public void o(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.f306299c = z16;
        }
    }

    public void p(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bVar);
        } else {
            this.f306297a = bVar;
        }
    }

    public void q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        if (str == null) {
            return;
        }
        if (f306296d.get()) {
            this.f306298b = null;
            com.tencent.upgrade.core.j.l().x(str);
        } else {
            h();
        }
    }
}
