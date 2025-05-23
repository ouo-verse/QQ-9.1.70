package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.mobileqq.DebugTrace;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.nearby.api.IOldBigDataChannelManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCClient;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.unifiedebug.SnapshotService;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.ei;
import com.tencent.mobileqq.vas.URLInterceptManager;
import com.tencent.mobileqq.vashealth.api.IPathTraceManager;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebCoreService;
import com.tencent.mobileqq.webview.api.IOfflineApi;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.utils.TbsLogClient;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.IToolProcEventListener;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.TicketManagerImpl;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BrowserAppInterface extends BaseToolAppInterface implements IToolProcEventListener, com.tencent.mobileqq.webview.util.j {
    static IPatchRedirector $redirector_;
    public static final AtomicBoolean H;
    public static final AtomicBoolean I;
    public static final String J;
    public boolean C;
    public boolean D;
    private EntityManagerFactory E;
    private int F;
    protected IOldBigDataChannelManager G;

    /* renamed from: d, reason: collision with root package name */
    long f194447d;

    /* renamed from: e, reason: collision with root package name */
    com.tencent.mobileqq.app.utils.a f194448e;

    /* renamed from: f, reason: collision with root package name */
    int f194449f;

    /* renamed from: h, reason: collision with root package name */
    boolean f194450h;

    /* renamed from: i, reason: collision with root package name */
    Intent f194451i;

    /* renamed from: m, reason: collision with root package name */
    Map<Integer, Manager> f194452m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class TBSLogRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private String f194453d;

        TBSLogRunnable(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            } else {
                this.f194453d = str;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (!TextUtils.isEmpty(this.f194453d)) {
                QQToast.makeText(BaseApplication.getContext(), this.f194453d, 1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements TbsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SharedPreferences f194454a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f194455b;

        a(SharedPreferences sharedPreferences, long j3) {
            this.f194454a = sharedPreferences;
            this.f194455b = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, BrowserAppInterface.this, sharedPreferences, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadFinish(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            QLog.d("TBS_update", 1, "tbs download finish result=" + i3);
            if (i3 != 100 && i3 != 120 && i3 != 122) {
                if (BrowserAppInterface.H.compareAndSet(true, false)) {
                    QbSdk.setTbsListener(null);
                    int i16 = this.f194454a.getInt("tbs_download_count", 0) + 1;
                    long j3 = this.f194454a.getLong("tbs_download_cost", 0L) + (System.currentTimeMillis() - this.f194455b);
                    SharedPreferences.Editor edit = this.f194454a.edit();
                    edit.putInt("tbs_download_count", i16);
                    edit.putLong("tbs_download_cost", j3);
                    edit.commit();
                    ReportController.n(null, "P_CliOper", "BizTechReport", "", "web", "tbs_download_error", 0, 1, i3, "", "", "", "");
                    if (QLog.isColorLevel()) {
                        QLog.d("TBS_update", 2, "tbs download aborted:" + i3);
                    }
                }
                SharedPreferences.Editor edit2 = this.f194454a.edit();
                edit2.putInt("tbs_download_complete", i3);
                edit2.remove("tbs_downloading");
                edit2.remove("tbs_download_progress");
                edit2.commit();
                BrowserAppInterface browserAppInterface = BrowserAppInterface.this;
                if (browserAppInterface.f194450h) {
                    browserAppInterface.h(browserAppInterface.f194451i);
                    return;
                }
                return;
            }
            ReportController.n(null, "P_CliOper", "BizTechReport", "", "web", "tbs_download_ok", 0, 1, i3, "", "", "", "");
            QLog.d("PERF_LOG", 1, "NF.TBS download");
            if (QLog.isColorLevel()) {
                QLog.d("TBS_update", 2, "tbs download finished");
            }
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadProgress(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else if (QLog.isColorLevel()) {
                QLog.d("TBS_update", 2, "tbs download progress " + i3);
            }
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onInstallFinish(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
                return;
            }
            QLog.d("TBS_update", 1, "tbs download install finish result=" + i3);
            if (i3 == 200) {
                return;
            }
            if (BrowserAppInterface.H.compareAndSet(true, false)) {
                QbSdk.setTbsListener(null);
                if (i3 != 232 && i3 != 220) {
                    int i16 = this.f194454a.getInt("tbs_download_count", 0) + 1;
                    long j3 = this.f194454a.getLong("tbs_download_cost", 0L) + (System.currentTimeMillis() - this.f194455b);
                    SharedPreferences.Editor edit = this.f194454a.edit();
                    edit.putInt("tbs_download_count", i16);
                    edit.putLong("tbs_download_cost", j3);
                    edit.commit();
                    ReportController.n(null, "P_CliOper", "BizTechReport", "", "web", "tbs_install_error", 0, 1, i3, "", "", "", "");
                    if (QLog.isColorLevel()) {
                        QLog.d("TBS_update", 2, "tbs install error:" + i3);
                    }
                } else {
                    int i17 = this.f194454a.getInt("tbs_download_count", 0) + 1;
                    long j16 = this.f194454a.getLong("tbs_download_cost", 0L) + (System.currentTimeMillis() - this.f194455b);
                    SharedPreferences.Editor edit2 = this.f194454a.edit();
                    edit2.remove("tbs_download_count");
                    edit2.remove("tbs_download_cost");
                    edit2.commit();
                    ReportController.n(null, "P_CliOper", "BizTechReport", "", "web", "tbs_install_ok", 0, 1, i3, Long.toString(j16), Integer.toString(i17), "", "");
                    if (QLog.isColorLevel()) {
                        QLog.d("TBS_update", 2, "tbs install finished:" + i3);
                    }
                    WebpSoLoader.e(false);
                }
                SharedPreferences.Editor edit3 = this.f194454a.edit();
                edit3.putInt("tbs_download_complete", i3);
                edit3.remove("tbs_downloading");
                edit3.remove("tbs_download_progress");
                edit3.commit();
            }
            BrowserAppInterface browserAppInterface = BrowserAppInterface.this;
            if (browserAppInterface.f194450h) {
                browserAppInterface.h(browserAppInterface.f194451i);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class b extends TbsLogClient {
        static IPatchRedirector $redirector_;

        /* renamed from: j, reason: collision with root package name */
        private WeakReference<AppInterface> f194457j;

        /* renamed from: k, reason: collision with root package name */
        private int f194458k;

        public b(Context context, AppInterface appInterface) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) appInterface);
                return;
            }
            this.f194457j = null;
            this.f194458k = -1;
            this.f194457j = new WeakReference<>(appInterface);
        }

        @Override // com.tencent.smtt.utils.TbsLogClient
        public void d(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            } else if (QLog.isColorLevel()) {
                QLog.d(str, 2, str2);
            }
        }

        @Override // com.tencent.smtt.utils.TbsLogClient
        public void e(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            } else if (QLog.isColorLevel()) {
                QLog.e(str, 2, str2);
            }
        }

        @Override // com.tencent.smtt.utils.TbsLogClient
        public void i(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            } else if (QLog.isColorLevel()) {
                QLog.i(str, 2, str2);
            }
        }

        @Override // com.tencent.smtt.utils.TbsLogClient
        public void showLog(String str) {
            AppInterface appInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            if (this.f194458k == -1) {
                this.f194458k = 0;
            }
            if (this.f194458k == 1 && (appInterface = this.f194457j.get()) != null) {
                appInterface.getHandler(BrowserAppInterface.class).post(new TBSLogRunnable(str));
            }
        }

        @Override // com.tencent.smtt.utils.TbsLogClient
        public void w(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
            } else if (QLog.isColorLevel()) {
                QLog.w(str, 2, str2);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69591);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
            return;
        }
        H = new AtomicBoolean(false);
        I = new AtomicBoolean(false);
        J = EcshopReportHandler.class.getName();
    }

    public BrowserAppInterface(BaseApplicationImpl baseApplicationImpl, String str) {
        super(baseApplicationImpl, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseApplicationImpl, (Object) str);
            return;
        }
        this.f194449f = 0;
        this.f194450h = false;
        this.f194452m = new HashMap(20);
        this.C = false;
        this.D = false;
        this.F = 0;
        this.G = null;
        this.f194448e = new com.tencent.mobileqq.app.utils.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(Intent intent) {
        boolean z16;
        int i3;
        boolean isPreloadWebProcess = ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).isPreloadWebProcess();
        int runningModuleSize = BaseApplicationImpl.getApplication().getRuntime().getRunningModuleSize();
        if (intent != null && intent.getBooleanExtra("qq_mode_foreground", false)) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isModuleRunning = BaseApplicationImpl.getApplication().getRuntime().isModuleRunning("modular_web");
        boolean z17 = !WebAccelerateHelper.isWebViewEntered;
        if (QLog.isColorLevel()) {
            QLog.d("BrowserAppInterface", 2, String.format("qq_mode_foreground= %b, runningModuleSize: %d, isPreloadWebProcess: %b, isWebModuleExit: %b, isPreloadSucess: %b", Boolean.valueOf(z16), Integer.valueOf(runningModuleSize), Boolean.valueOf(isPreloadWebProcess), Boolean.valueOf(isModuleRunning), Boolean.valueOf(z17)));
        }
        if (z16) {
            if (isPreloadWebProcess && isModuleRunning && z17 && runningModuleSize <= 1) {
                if (QLog.isColorLevel()) {
                    QLog.d("BrowserAppInterface", 2, "don't need kill web process!");
                }
                return true;
            }
            if (SnapshotService.Q2() && (i3 = this.F) < 10) {
                this.F = i3 + 1;
                if (QLog.isColorLevel()) {
                    QLog.d("BrowserAppInterface", 2, "don't kill web process for debug snapshot, " + this.F + Element.ELEMENT_NAME_TIMES);
                }
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BrowserAppInterface", 2, "try restart web process");
            }
            this.F = 0;
            this.C = true;
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("BrowserAppInterface", 2, "exit web process");
            }
            if (isPreloadWebProcess) {
                this.D = true;
            }
        }
        return false;
    }

    private boolean i() {
        int i3;
        int netWorkTypeContain5G = HttpUtil.getNetWorkTypeContain5G();
        if (netWorkTypeContain5G <= 0) {
            return false;
        }
        String tBSDpcParam = WebAccelerateHelper.getInstance().getTBSDpcParam();
        QLog.d("TBS_update", 1, "checkTbsDownloadNetWork curNetType=" + netWorkTypeContain5G + ",dpc=" + tBSDpcParam);
        String[] split = tBSDpcParam.split("\\|");
        if (split.length <= 3) {
            if (netWorkTypeContain5G != 1) {
                return false;
            }
            return true;
        }
        try {
            i3 = Integer.parseInt(split[3]);
        } catch (Throwable th5) {
            QLog.e("TBS_update", 1, th5.getMessage(), th5);
            i3 = 1;
        }
        if (i3 == 1) {
            if (netWorkTypeContain5G != i3) {
                return false;
            }
            return true;
        }
        if (i3 == 0 || i3 <= 1) {
            return false;
        }
        if (netWorkTypeContain5G < i3 && netWorkTypeContain5G != 1) {
            return false;
        }
        return true;
    }

    private boolean j(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            return false;
        }
        QLog.e("BrowserAppInterface", 1, "exitBrowserRunTime: receiveAction: " + action);
        if (action.equals("com.tencent.process.exit")) {
            boolean M = RemoteWebRenderIPCClient.y().M();
            if (QLog.isColorLevel()) {
                QLog.i("BrowserAppInterface", 2, "highPriorityWhenBackground isWebRender=" + M);
            }
            if (M || ((IQWalletApi) QRoute.api(IQWalletApi.class)).isQWalletAtTop(context)) {
                return true;
            }
            if (H.get()) {
                this.f194450h = true;
                this.f194451i = intent;
                return true;
            }
            try {
                IPathTraceManager iPathTraceManager = (IPathTraceManager) getRuntimeService(IPathTraceManager.class, "tool");
                if (iPathTraceManager != null) {
                    if (iPathTraceManager.isRunning()) {
                        return true;
                    }
                }
            } catch (IllegalStateException e16) {
                QLog.e("BrowserAppInterface", 1, "Error when get RuntimeService IPathTraceManager", e16);
            }
            if (!com.tencent.mobileqq.intervideo.yiqikan.f.f() && intent.getBooleanExtra("qq_mode_foreground", false)) {
                if (QLog.isColorLevel()) {
                    QLog.d("BrowserAppInterface", 2, " has floating window\uff0c not exit tool process");
                }
                return true;
            }
            return h(intent);
        }
        if (!action.equals(NewIntent.ACTION_ACCOUNT_CHANGED) && !action.equals(NewIntent.ACTION_ACCOUNT_KICKED)) {
            if (isLogin() || !action.equals(NewIntent.ACTION_ACCOUNT_EXPIRED)) {
                return false;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ACTION_ACCOUNT_EXPIRED, need remove all cookie: ");
            AtomicBoolean atomicBoolean = I;
            sb5.append(atomicBoolean.get());
            QLog.e("BrowserAppInterface", 1, sb5.toString());
            if (atomicBoolean.compareAndSet(false, true)) {
                com.tencent.mobileqq.webview.swift.cookie.c.h(1);
            }
            return true;
        }
        com.tencent.mobileqq.webview.swift.cookie.c.h(1);
        return h(intent);
    }

    @Override // com.tencent.mobileqq.webview.util.j
    public void a(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        if (!z16 && !i()) {
            return;
        }
        if (H.compareAndSet(false, true)) {
            long currentTimeMillis = System.currentTimeMillis();
            SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 4);
            QbSdk.setTbsListener(new a(sharedPreferences, currentTimeMillis));
            QLog.d("TBS_update", 1, "tbs start download");
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("tbs_downloading", true);
            edit.remove("tbs_download_complete");
            edit.remove("tbs_download_progress");
            edit.commit();
            this.f194449f = 0;
            if (!AppNetConnInfo.isWifiConn()) {
                QbSdk.setDownloadWithoutWifi(true);
            }
            TbsDownloader.startDownload(BaseApplication.getContext(), z17);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TBS_update", 2, "tbs has started downloading");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void addManager(int i3, Manager manager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3, (Object) manager);
            return;
        }
        synchronized (this.f194452m) {
            if (this.f194452m.get(Integer.valueOf(i3)) != null) {
                return;
            }
            this.f194452m.put(Integer.valueOf(i3), manager);
        }
    }

    @Override // com.tencent.mobileqq.webview.util.j
    public void d(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            a(z16, false);
        }
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public BaseApplication getApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BaseApplication) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.app;
    }

    @Override // com.tencent.common.app.AppInterface
    public int getAppid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return getAccount();
    }

    @Override // mqq.app.AppRuntime
    public EntityManagerFactory getEntityManagerFactory(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (EntityManagerFactory) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (this.E == null) {
            this.E = com.tencent.mobileqq.persistence.l.d(getAccount(), super.getEntityManagerFactory());
        }
        return this.E;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0071 A[Catch: all -> 0x007c, TryCatch #0 {, blocks: (B:18:0x002f, B:20:0x003d, B:23:0x0041, B:26:0x0071, B:27:0x007a, B:29:0x0048, B:31:0x004c, B:34:0x0055, B:35:0x005b, B:37:0x005f, B:38:0x0065, B:40:0x0069), top: B:17:0x002f }] */
    @Override // mqq.app.AppRuntime
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Manager getManager(int i3) {
        Manager uRLInterceptManager;
        Manager manager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Manager) iPatchRedirector.redirect((short) 21, (Object) this, i3);
        }
        int i16 = QQManagerFactory.DOWNLOADER_FACTORY;
        if (i3 == i16 && (manager = super.getManager(i3)) != null) {
            return manager;
        }
        Manager manager2 = this.f194452m.get(Integer.valueOf(i3));
        if (manager2 == null) {
            synchronized (this.f194452m) {
                manager2 = this.f194452m.get(Integer.valueOf(i3));
                if (manager2 != null) {
                    return manager2;
                }
                if (i3 == i16) {
                    uRLInterceptManager = new DownloaderFactory(this);
                } else if (i3 == QQManagerFactory.TROOP_GIFT_MANAGER) {
                    uRLInterceptManager = new com.tencent.mobileqq.troop.utils.al(this);
                } else if (i3 == 2) {
                    uRLInterceptManager = new TicketManagerImpl(this);
                } else if (i3 == QQManagerFactory.ZHITU_MANAGER) {
                    uRLInterceptManager = new ZhituManager(this);
                } else {
                    if (i3 == QQManagerFactory.URL_INTECEPT_MANAGER) {
                        uRLInterceptManager = new URLInterceptManager();
                    }
                    if (manager2 != null) {
                        this.f194452m.put(Integer.valueOf(i3), manager2);
                    }
                }
                manager2 = uRLInterceptManager;
                if (manager2 != null) {
                }
            }
        }
        if (manager2 == null) {
            return super.getManager(i3);
        }
        return manager2;
    }

    @Override // mqq.app.AppRuntime
    public String[] getMessagePushSSOCommands() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String[]) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return new String[]{"OnlinePush.ReqPush.GameStatusPush"};
    }

    @Override // mqq.app.AppRuntime
    protected Class<? extends MSFServlet>[] getMessagePushServlets() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Class[]) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return new Class[]{com.tencent.biz.game.a.class};
    }

    @Override // com.tencent.common.app.AppInterface
    public MobileQQServiceBase getMobileQQService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (MobileQQServiceBase) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.f194448e;
    }

    @Override // mqq.app.AppRuntime
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return "modular_web";
    }

    @Override // com.tencent.common.app.business.BaseToolAppInterface
    @NonNull
    public <T extends IRuntimeService> T getRuntimeService(Class<T> cls) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (T) iPatchRedirector.redirect((short) 23, (Object) this, (Object) cls);
        }
        if (MobileQQ.sProcessId == 1) {
            str = "";
        } else {
            str = "tool";
        }
        return (T) getRuntimeService(cls, str);
    }

    public String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return null;
    }

    @Override // mqq.app.IToolProcEventListener
    public void onBeforeExitProc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("BrowserAppInterface", 2, "onBeforeExitProc, now it will exit web process!");
        }
        boolean isPreloadWebProcess = ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).isPreloadWebProcess();
        ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).setPreloadWebProcess(false);
        if (this.C) {
            this.C = false;
            Intent intent = new Intent();
            intent.setAction("com.tencent.mobileqq.webprocess.restart_web_process");
            intent.putExtra("isPreloadWebProcess", isPreloadWebProcess);
            BaseApplication.getContext().sendBroadcast(intent);
            return;
        }
        if (this.D) {
            this.D = false;
            Intent intent2 = new Intent();
            intent2.setAction("com.tencent.mobileqq.webprocess.report");
            BaseApplication.getContext().sendBroadcast(intent2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        final int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        ei.a(null, "web_browserAppinterface_onCreate");
        DebugTrace.Step step = DebugTrace.Step.app_onCreate;
        DebugTrace.g(step);
        super.onCreate(bundle);
        this.f194447d = System.currentTimeMillis();
        SwiftBrowserIdleTaskHelper.j(this);
        QbSdk.setTbsLogClient(new b(BaseApplication.getContext(), this));
        final String account = getAccount();
        if (TextUtils.isEmpty(account)) {
            str = null;
        } else {
            str = QbSdk.TID_QQNumber_Prefix + account;
        }
        QbSdk.setCurrentID(str);
        HtmlOffline.L(((IOfflineApi) QRoute.api(IOfflineApi.class)).getOfflineDownloader());
        HtmlOffline.M(new px.d());
        HtmlOffline.K(BaseApplication.getContext());
        if (getLongAccountUin() % 10 == 6) {
            z16 = true;
        } else {
            z16 = false;
        }
        HtmlOffline.f78406i = z16;
        if (com.tencent.mobileqq.webview.swift.utils.m.e()) {
            i3 = 3;
        }
        if (com.tencent.mobileqq.webview.swift.cookie.c.e(account, i3)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.d
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.mobileqq.webview.swift.cookie.c.i(account, i3);
                }
            }, 16, null, true);
        }
        SwiftBrowserStatistics.U0 = SystemClock.elapsedRealtime();
        ei.a("web_browserAppinterface_onCreate", null);
        DebugTrace.e(step);
        DebugTrace.Step step2 = DebugTrace.Step.app_attachBasecontext;
        DebugTrace.h(step2, BaseApplicationImpl.sAttachBaseContextTime);
        DebugTrace.f(step2, BaseApplicationImpl.sAttachBaseDoneContextTime);
        try {
            QQSysAndEmojiResMgr.getInstance().checkInitConfig();
        } catch (Throwable th5) {
            QLog.e("BrowserAppInterface", 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        IOldBigDataChannelManager iOldBigDataChannelManager = this.G;
        if (iOldBigDataChannelManager != null) {
            try {
                iOldBigDataChannelManager.onDestroy();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            this.G = null;
        }
        synchronized (this.f194452m) {
            Set<Integer> keySet = this.f194452m.keySet();
            if (keySet != null && keySet.size() > 0) {
                Iterator<Integer> it = keySet.iterator();
                while (it.hasNext()) {
                    try {
                        Manager manager = this.f194452m.get(it.next());
                        if (manager != null) {
                            manager.onDestroy();
                        }
                    } catch (Exception e17) {
                        e17.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.e("BrowserAppInterface", 2, "onDesotry", e17);
                        }
                    }
                }
            }
            this.f194452m.clear();
        }
        onRelease();
        InnerDns.onAppDestroy();
        com.tencent.mobileqq.jsp.h.x();
        UiApiPlugin.G0();
    }

    @Override // mqq.app.IToolProcEventListener
    public boolean onReceiveAccountAction(String str, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) intent)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i("BrowserAppInterface", 2, "onReceiveAccountAction");
        }
        return j(BaseApplication.getContext(), intent);
    }

    @Override // mqq.app.IToolProcEventListener
    public boolean onReceiveLegalExitProcAction(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) intent)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i("BrowserAppInterface", 2, "onReceiveLegalExitProcAction");
        }
        return j(BaseApplication.getContext(), intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void onRunningBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        super.onRunningBackground();
        boolean tbsNeedReboot = WebView.getTbsNeedReboot();
        if (QLog.isColorLevel()) {
            QLog.d("BrowserAppInterface", 2, "tbs need reboot: " + tbsNeedReboot);
        }
        if (tbsNeedReboot) {
            getHandler(BrowserAppInterface.class).postDelayed(new Runnable() { // from class: com.tencent.mobileqq.app.BrowserAppInterface.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BrowserAppInterface.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (BrowserAppInterface.this.isBackgroundStop && BaseActivity.sTopActivity == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("BrowserAppInterface", 2, "no activity running, reboot for tbs now");
                        }
                        Intent intent = new Intent();
                        intent.putExtra("qq_mode_foreground", true);
                        BrowserAppInterface.this.h(intent);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("BrowserAppInterface", 2, "activity still running, cannot reboot");
                    }
                }
            }, 3000L);
        }
        if (WebCoreService.f313722f && (com.tencent.mobileqq.utils.ah.X() >>> 20) < 20) {
            WebCoreService.f();
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_osVer", String.valueOf(Build.VERSION.SDK_INT));
                hashMap.put("param_totalMem", String.valueOf(com.tencent.mobileqq.utils.m.c()));
                hashMap.put("param_availableMem", String.valueOf(com.tencent.mobileqq.utils.ah.X()));
                hashMap.put("param_cpuNum", String.valueOf(com.tencent.mobileqq.utils.ah.n()));
                hashMap.put("param_cpuFreq", String.valueOf(com.tencent.mobileqq.utils.ah.l()));
                hashMap.put("param_releaseType", String.valueOf(1));
                if (QLog.isColorLevel()) {
                    QLog.d("BrowserAppInterface", 2, "releaseWebCoreServiceReport:" + hashMap.toString());
                }
                StatisticCollector.getInstance(getApplication()).collectPerformance(getCurrentAccountUin(), StatisticCollector.READINJOY_RELEASE_WEB_SERVICE, true, 0L, 0L, hashMap, "");
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void onRunningForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        super.onRunningForeground();
        this.f194450h = false;
        this.f194451i = null;
        AccessibilityUtil.A(getApp());
    }
}
