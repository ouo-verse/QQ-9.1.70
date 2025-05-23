package com.tencent.mobileqq.upgrade;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.apkupdate.ApkUpdateParam;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.home.chats.biz.z;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;
import com.tencent.mobileqq.upgrade.download.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.UpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntstartup.nativeinterface.StartupSessionConstant;
import com.tencent.util.URLUtil;
import java.io.File;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import protocol.KQQConfig.UpgradeInfo;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class k implements UpdateManager.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private BaseApplicationImpl f306306a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f306307b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f306308c;

    /* renamed from: d, reason: collision with root package name */
    private volatile UpgradeDetailWrapper f306309d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f306310e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.mobileqq.upgrade.download.c f306311f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.mobileqq.upgrade.download.b f306312g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final k f306313a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77131);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f306313a = new k();
            }
        }
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f306310e = false;
            v(false);
        }
    }

    public static String e(String str) {
        return URLUtil.addParameter(str, StartupSessionConstant.KNTMODULENAME, g.b());
    }

    public static String g() {
        UpgradeDetailWrapper upgradeDetailWrapper;
        k i3 = i();
        if (i3 == null || (upgradeDetailWrapper = i3.f306309d) == null || upgradeDetailWrapper.f306170d == null) {
            return "";
        }
        return "" + upgradeDetailWrapper.f306170d.iUpgradeSdkId;
    }

    public static com.tencent.mobileqq.upgrade.download.b h() {
        return i().f306312g;
    }

    public static k i() {
        return a.f306313a;
    }

    public static com.tencent.mobileqq.upgrade.download.c m() {
        return i().f306311f;
    }

    public static String n() {
        int i3;
        UpgradeDetailWrapper upgradeDetailWrapper;
        UpgradeInfo upgradeInfo;
        k i16 = i();
        if (i16 != null && (upgradeDetailWrapper = i16.f306309d) != null && (upgradeInfo = upgradeDetailWrapper.f306170d) != null) {
            i3 = upgradeInfo.iTipsType;
        } else {
            i3 = 0;
        }
        return String.valueOf(i3);
    }

    private synchronized void p() {
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController", 2, "initDownloadEnv: " + this.f306308c);
        }
        if (!this.f306308c) {
            UpdateManager.d().g(this);
            DownloadApi.o(this.f306311f.e());
            this.f306308c = true;
        }
    }

    private boolean q(boolean z16) {
        String O2 = ConfigHandler.O2(this.f306306a);
        QLog.d("UpgradeController", 1, "isTopActivityMatch, ", O2, " topActivity:", BaseActivity.sTopActivity);
        if (z16) {
            if (O2 == null || O2.equals("com.tencent.mobileqq.activity.UserguideActivity")) {
                return false;
            }
            return true;
        }
        if (O2 == null || O2.startsWith("com.tencent.av.") || O2.equals("com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity") || O2.equals("com.tencent.mobileqq.upgrade.activity.UpgradeActivity")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r() {
        int i3;
        try {
            if (this.f306310e) {
                i3 = R.string.coa;
            } else {
                i3 = R.string.co_;
            }
            QQToast.makeText(this.f306306a, i3, 0).show();
            com.tencent.mobileqq.upgrade.banner.b.f(false);
        } catch (Throwable th5) {
            QLog.e("UpgradeController", 1, "downloadFileError", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(boolean z16) {
        BaseActivity baseActivity;
        if (this.f306309d != null && this.f306309d.f306174i != null && this.f306309d.f306174i.dialog != null) {
            Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) UpgradeActivity.class);
            try {
                NewUpgradeConfig.a aVar = this.f306309d.f306174i.dialog;
                intent.putExtra("StrTitle", aVar.f306153e);
                intent.putExtra("StrNewTitle", aVar.f306154f);
                intent.putExtra("StrUpgradeDesc", aVar.f306155g);
                String P = m.P(this.f306309d.f306170d.strProgressName);
                if (!TextUtils.isEmpty(P)) {
                    intent.putExtra("StrVersion", P);
                }
                if (z16) {
                    intent.putExtra("strDesc", aVar.f306156h);
                }
                intent.putExtra("lBtnText", aVar.f306162n);
                intent.putExtra("rBtnText", aVar.f306163o);
                intent.putExtra("StrUrl", "");
                intent.putExtra("iUpgradeType", this.f306309d.f306170d.iUpgradeType);
                intent.putExtra("iTipsType", this.f306309d.f306170d.iTipsType);
                intent.putExtra("strConfirmBtnText", this.f306309d.f306170d.strButtonDesc);
                intent.putExtra("strCancelButtonDesc", this.f306309d.f306170d.strCancelButtonDesc);
                intent.putExtra("iUpgradeSdkId", this.f306309d.f306170d.iUpgradeSdkId);
                if (this.f306309d.f306174i != null && this.f306309d.f306174i.dialog != null) {
                    intent.putExtra("rate", this.f306309d.f306174i.dialog.f306159k);
                }
                intent.putExtra("activity_type", 4096);
                intent.putExtra("mode", 0);
                if (q(true) && (baseActivity = BaseActivity.sTopActivity) != null) {
                    z.D = null;
                    baseActivity.startActivity(intent);
                    return;
                } else {
                    z.D = intent;
                    QLog.d("UpgradeController", 1, "showUpgradeDialog ignore, top activity name not match");
                    return;
                }
            } catch (NullPointerException e16) {
                QLog.w("UpgradeController", 1, "showUpgradeDialog fail, invalid param. happen nullPointException!", e16);
                return;
            }
        }
        QLog.d("UpgradeController", 1, "showUpgradeDialog fail, invalid param.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        if (this.f306309d != null && this.f306309d.f306174i != null && this.f306309d.f306174i.dialog != null) {
            if (this.f306309d.f306174i.dialog.f306157i.equals("1")) {
                QLog.d("UpgradeController", 1, "showUpgradeTip config do not allow to tip");
                return;
            }
            if (com.tencent.mobileqq.service.message.e.K0() < this.f306309d.f306174i.dialog.f306152d / 1000) {
                QLog.d("UpgradeController", 1, "showUpgradeTip want to tip but is not time to show");
                return;
            }
            if (k() == 4 && com.tencent.mobileqq.upgrade.download.a.a(this.f306311f.d())) {
                DownloadInfo d16 = this.f306311f.d();
                if (d16 != null && !TextUtils.isEmpty(d16.L)) {
                    this.f306310e = true;
                    File file = new File(d16.L);
                    if (file.exists()) {
                        QLog.d("UpgradeController", 1, "showUpgradeTip the jacked apk has been removed, " + file.delete());
                        return;
                    }
                    return;
                }
                return;
            }
            QQAppInterface qQAppInterface = (QQAppInterface) this.f306306a.getRuntime();
            if (qQAppInterface == null) {
                QLog.d("UpgradeController", 1, "showUpgradeTip, app is null");
                return;
            }
            UpgradeInfo upgradeInfo = this.f306309d.f306170d;
            boolean e36 = ConfigHandler.e3(qQAppInterface);
            if (e36 && upgradeInfo != null && upgradeInfo.iUpgradeType == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!e36 || z17) {
                boolean c16 = n.c(this.f306309d);
                boolean b16 = n.b(this.f306309d);
                if (c16 && b16) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                QLog.d("UpgradeController", 1, "showUpgradeTip, isAutoWifiDownload: ", Boolean.valueOf(e36), ", needDialog:", Boolean.valueOf(z16), ", dialogTimesMatch:", Boolean.valueOf(z18));
                if ((e36 || z16) && z18) {
                    w(e36);
                    return;
                }
                if (upgradeInfo != null && !n.d(upgradeInfo.iNewTimeStamp)) {
                    z19 = false;
                } else {
                    z19 = true;
                }
                boolean z27 = !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105469", false);
                Object[] objArr = new Object[8];
                objArr[0] = "showUpgradeTip, need show banner, switch:";
                objArr[1] = Boolean.valueOf(z27);
                objArr[2] = ", remindLater:";
                objArr[3] = Boolean.valueOf(z19);
                objArr[4] = ", matchMaxDialogTimes:";
                objArr[5] = Boolean.valueOf(c16);
                objArr[6] = ", mUpgradeInfoIsNull:";
                if (this.f306309d.f306170d == null) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                objArr[7] = Boolean.valueOf(z26);
                QLog.d("UpgradeController", 1, objArr);
                if (z27 && !z19 && !c16) {
                    com.tencent.mobileqq.upgrade.banner.b.j(false);
                }
            }
        }
    }

    private synchronized void u() {
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController", 2, "releaseDownloadEnv: " + this.f306308c);
        }
        if (this.f306308c) {
            UpdateManager.d().h(this);
            UpdateManager.d().c();
            h().h();
            this.f306312g.mDownloadingVersionCode = 0;
            DownloadApi.t(this.f306311f.e());
            this.f306308c = false;
        }
    }

    @Override // com.tencent.open.downloadnew.UpdateManager.a
    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController", 2, "onCheckUpdateFailed");
        }
        this.f306312g.d(false);
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.upgrade.j
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.r();
                }
            });
        }
    }

    public UpgradeDetailWrapper j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (UpgradeDetailWrapper) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.f306309d;
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f306311f.f();
    }

    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f306312g.mDownloadingVersionCode;
    }

    public void o(UpgradeInfo upgradeInfo, b.InterfaceC8883b interfaceC8883b) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) upgradeInfo, (Object) interfaceC8883b);
            return;
        }
        this.f306309d.f306170d = upgradeInfo;
        this.f306309d.f306173h = UpgradeDetailWrapper.a(upgradeInfo);
        if (upgradeInfo != null && this.f306309d.f306173h != null && upgradeInfo.iUpgradeType != 0 && !this.f306307b) {
            UpgradeDetailWrapper.b bVar = this.f306309d.f306173h;
            if (bVar == null) {
                QLog.d("UpgradeController", 2, "handleUpgradeInfo, newApkInfo is null");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("UpgradeController", 2, "handleUpgradeInfo, packageName = " + MobileQQ.PACKAGE_NAME + ", bGray = " + ((int) upgradeInfo.bGray) + ", versioncode = " + bVar.f306179d);
            }
            p();
            this.f306312g.j(interfaceC8883b);
            ApkUpdateParam apkUpdateParam = new ApkUpdateParam(MobileQQ.PACKAGE_NAME, upgradeInfo.bGray, bVar.f306179d);
            ArrayList arrayList = new ArrayList();
            arrayList.add(apkUpdateParam);
            UpdateManager.d().b(arrayList);
            return;
        }
        QLog.d("UpgradeController", 1, "handleUpgradeInfo return, logout:", Boolean.valueOf(this.f306307b), ", ", upgradeInfo);
    }

    @Override // com.tencent.open.downloadnew.UpdateManager.a
    public void onResult(ArrayList<ApkUpdateDetail> arrayList) {
        ApkUpdateDetail apkUpdateDetail;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) arrayList);
            return;
        }
        if (this.f306309d == null) {
            QLog.e("UpgradeController", 1, "onResult, mDetailWrapper is null.");
            return;
        }
        if (arrayList != null && !arrayList.isEmpty() && (apkUpdateDetail = arrayList.get(0)) != null) {
            if (this.f306309d.f306173h != null) {
                if (this.f306309d.f306173h.f306179d == apkUpdateDetail.versioncode) {
                    this.f306309d.f306172f = apkUpdateDetail;
                }
            } else {
                QLog.e("UpgradeController", 1, "onResult, mDetailWrapper.mNewApkInfo is null");
            }
            if (QLog.isColorLevel()) {
                QLog.d("UpgradeController", 2, "onCheckUpdateSucceed:" + apkUpdateDetail.url + ", " + apkUpdateDetail.updatemethod);
            }
        }
        this.f306312g.d(true);
    }

    public void v(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        if (z16 && this.f306309d != null && this.f306309d.f306170d != null && this.f306309d.f306170d.iUpgradeType == 2) {
            QLog.d("UpgradeController", 1, "no need reset");
            return;
        }
        QLog.d("UpgradeController", 1, "reset, " + z16);
        com.tencent.mobileqq.upgrade.download.c cVar = this.f306311f;
        if (cVar != null) {
            cVar.s();
        }
        this.f306307b = z16;
        u();
        this.f306306a = BaseApplicationImpl.getApplication();
        if (z16 || this.f306309d == null) {
            this.f306309d = new UpgradeDetailWrapper(null, null);
            com.tencent.mobileqq.upgrade.download.c cVar2 = new com.tencent.mobileqq.upgrade.download.c(this.f306309d, this);
            this.f306311f = cVar2;
            cVar2.o(null);
            this.f306312g = new com.tencent.mobileqq.upgrade.download.b(this.f306309d);
        }
        this.f306312g.i(z16);
    }

    public void w(final boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeController", 2, "showUpgradeDialog needDesc=" + z16);
        }
        if (q(false)) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.upgrade.h
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.s(z16);
                }
            });
        }
    }

    public void x(final boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            QLog.d("UpgradeController", 1, "showUpgradeTip");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.upgrade.i
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.t(z16);
                }
            }, 16, null, false);
        }
    }

    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) this.f306306a.getRuntime();
        if (this.f306309d != null && this.f306309d.f306170d != null && this.f306309d.f306170d.iUpgradeType == 1) {
            DownloadInfo d16 = this.f306311f.d();
            if (d16 != null && d16.J == 1) {
                if (QLog.isColorLevel()) {
                    QLog.d("UpgradeController", 2, "MYAPP has work, do not allow download by wifi");
                }
                ConfigHandler.i3(qQAppInterface, false);
                x(false);
                return;
            }
            this.f306311f.r(ConfigHandler.g3(qQAppInterface, false));
        }
    }

    public void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.f306311f.t();
        }
    }
}
