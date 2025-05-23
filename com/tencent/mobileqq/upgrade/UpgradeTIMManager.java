package com.tencent.mobileqq.upgrade;

import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.api.IOfflineApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes20.dex */
public class UpgradeTIMManager implements Manager, INetInfoHandler {
    static IPatchRedirector $redirector_;
    private static final String D;
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    private px.c f306180d;

    /* renamed from: e, reason: collision with root package name */
    private File f306181e;

    /* renamed from: f, reason: collision with root package name */
    private DownloadTask f306182f;

    /* renamed from: h, reason: collision with root package name */
    private QQAppInterface f306183h;

    /* renamed from: i, reason: collision with root package name */
    private UpgradeTIMWrapper f306184i;

    /* renamed from: m, reason: collision with root package name */
    private Handler f306185m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class DownloadTask implements Runnable, com.tencent.biz.common.offline.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        String f306186d;

        /* renamed from: e, reason: collision with root package name */
        String f306187e;

        /* renamed from: f, reason: collision with root package name */
        int f306188f;

        /* renamed from: h, reason: collision with root package name */
        boolean f306189h;

        public DownloadTask(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, UpgradeTIMManager.this, str, str2);
            } else {
                this.f306186d = str;
                this.f306187e = str2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            if (this.f306189h) {
                ThreadManagerV2.post(this, 5, null, false);
                this.f306189h = false;
            }
        }

        private void f() {
            UpgradeTIMManager.this.f306185m.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.upgrade.UpgradeTIMManager.DownloadTask.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) DownloadTask.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        ThreadManagerV2.post(DownloadTask.this, 5, null, true);
                    }
                }
            }, 3000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stop() {
            if (!this.f306189h) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.upgrade.UpgradeTIMManager.DownloadTask.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) DownloadTask.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            UpgradeTIMManager.this.f306180d.pauseDownload(DownloadTask.this.f306186d);
                        }
                    }
                }, 8, null, false);
                this.f306189h = true;
            }
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
                return;
            }
            QLog.d("UpgradeTIMManager", 2, "on download result, code=", Integer.valueOf(i3));
            if (i3 == 0) {
                UpgradeTIMManager.this.g();
                return;
            }
            if (i3 == 10) {
                int i16 = this.f306188f;
                this.f306188f = i16 + 1;
                if (i16 < 3) {
                    f();
                    return;
                }
            }
            UpgradeTIMManager.this.k();
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else if (QLog.isDevelopLevel()) {
                QLog.d("UpgradeTIMManager", 4, "downloading,  progress = ", Integer.valueOf(i3));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("UpgradeTIMManager", 2, "start download...");
            }
            if (!NetworkUtil.isWifiConnected(BaseApplication.getContext())) {
                if (QLog.isColorLevel()) {
                    QLog.d("UpgradeTIMManager", 2, "run download, wifi not connected...");
                }
                UpgradeTIMManager.this.k();
            } else {
                ReportController.o(UpgradeTIMManager.this.f306183h, "CliOper", "", "", "0X8008A47", "0X8008A47", 0, 0, "", "", "", "");
                UpgradeTIMManager.this.f306180d.c(BaseApplication.getContext(), this.f306186d, this.f306187e, this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77141);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        D = AppConstants.SDCARD_PATH + "tim";
    }

    public UpgradeTIMManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f306185m = new Handler(Looper.getMainLooper());
        this.f306183h = qQAppInterface;
        this.f306180d = ((IOfflineApi) QRoute.api(IOfflineApi.class)).getOfflineDownloader();
        this.f306181e = new File(D, "tim.apk");
    }

    private boolean f() {
        if (!this.f306181e.exists()) {
            return false;
        }
        if ((System.currentTimeMillis() - this.f306181e.lastModified()) / 86400000 > 14) {
            this.f306181e.delete();
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        ReportController.o(this.f306183h, "CliOper", "", "", "0X8008A48", "0X8008A48", 0, 0, "", "", "", "");
        if (this.f306181e.exists()) {
            PackageInfo packageArchiveInfo = BaseApplication.getContext().getPackageManager().getPackageArchiveInfo(this.f306181e.getAbsolutePath(), 64);
            if (packageArchiveInfo != null) {
                if (!AppConstants.TIM_PACKAGE_NAME.equals(packageArchiveInfo.packageName)) {
                    this.f306181e.delete();
                }
            } else {
                this.f306181e.delete();
            }
        }
        k();
    }

    private void j() {
        AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this);
        this.C = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f306182f = null;
        n();
        UpgradeTIMWrapper upgradeTIMWrapper = this.f306184i;
        if (upgradeTIMWrapper != null) {
            l(this.f306183h, upgradeTIMWrapper);
        }
    }

    private void l(QQAppInterface qQAppInterface, UpgradeTIMWrapper upgradeTIMWrapper) {
        if (QLog.isColorLevel()) {
            QLog.i("UpgradeTIMWrapper", 2, "UpgradeTIMManager |showUpgradeInfo");
        }
        MqqHandler handler = qQAppInterface.getHandler(Conversation.class);
        if (handler != null) {
            handler.obtainMessage(Conversation.MSG_TIM_UPGRADE_SHOW, upgradeTIMWrapper).sendToTarget();
        }
    }

    private void m(String str, String str2) {
        DownloadTask downloadTask = new DownloadTask(str, str2);
        this.f306182f = downloadTask;
        ThreadManagerV2.post(downloadTask, 5, null, true);
        j();
    }

    private void n() {
        if (!this.C) {
            return;
        }
        AppNetConnInfo.unregisterNetInfoHandler(this);
        this.C = false;
    }

    public void h(QQAppInterface qQAppInterface, UpgradeTIMWrapper upgradeTIMWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface, (Object) upgradeTIMWrapper);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeTIMManager", 2, "onReceiveUpgradeInfo, with wrapper");
        }
        if (this.f306182f != null) {
            this.f306184i = upgradeTIMWrapper;
            return;
        }
        if (f()) {
            l(qQAppInterface, upgradeTIMWrapper);
            return;
        }
        if (!NetworkUtil.isWifiConnected(BaseApplication.getContext())) {
            if (QLog.isColorLevel()) {
                QLog.d("UpgradeTIMManager", 2, "onReceiveUpgradeInfo, wifi not connected...");
            }
            l(qQAppInterface, upgradeTIMWrapper);
        } else {
            this.f306184i = upgradeTIMWrapper;
            m(upgradeTIMWrapper.f306194f, this.f306181e.getPath());
        }
    }

    public void i(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeTIMManager", 2, "onReceiveUpgradeInfo");
        }
        if (this.f306182f == null && !f() && NetworkUtil.isWifiConnected(BaseApplication.getContext())) {
            m(str, this.f306181e.getPath());
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            n();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeTIMManager", 2, "onNetWifi2None, resume download");
        }
        DownloadTask downloadTask = this.f306182f;
        if (downloadTask != null) {
            downloadTask.e();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeTIMManager", 2, "onNetNone2Mobile, pause download");
        }
        DownloadTask downloadTask = this.f306182f;
        if (downloadTask != null) {
            downloadTask.stop();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeTIMManager", 2, "onNetWifi2None, resume download");
        }
        DownloadTask downloadTask = this.f306182f;
        if (downloadTask != null) {
            downloadTask.e();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeTIMManager", 2, "onNetWifi2Mobile, pause download");
        }
        DownloadTask downloadTask = this.f306182f;
        if (downloadTask != null) {
            downloadTask.stop();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeTIMManager", 2, "onNetWifi2None, pause download");
        }
        DownloadTask downloadTask = this.f306182f;
        if (downloadTask != null) {
            downloadTask.stop();
        }
    }
}
