package com.tencent.mobileqq.webview.swift.component;

import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.managers.PushNoticeManager;
import com.tencent.mobileqq.perf.report.PerfFeature;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.k;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SwiftBrowserStatisticInjectorImpl implements com.tencent.mobileqq.webview.swift.injector.o {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f314322a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f314323b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f314324c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f314325d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f314326e;

    /* renamed from: f, reason: collision with root package name */
    private String f314327f;

    /* renamed from: g, reason: collision with root package name */
    private String f314328g;

    /* renamed from: h, reason: collision with root package name */
    private int f314329h;

    /* renamed from: i, reason: collision with root package name */
    private int f314330i;

    /* renamed from: j, reason: collision with root package name */
    private int f314331j;

    /* renamed from: k, reason: collision with root package name */
    private String f314332k;

    /* renamed from: l, reason: collision with root package name */
    private String f314333l;

    public SwiftBrowserStatisticInjectorImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f314324c = false;
            this.f314325d = false;
        }
    }

    private void q(String str) {
        if (MobileQQ.sProcessId == 1) {
            if ("main.guild".equals(str)) {
                PerfFeature.a(PerfFeature.CustomFlag.WVMainProcInUse);
                if (QLog.isDevelopLevel()) {
                    QLog.i("SwiftBrowserStatistics", 1, "WVMAINPROC_REPORT_use from SOURCE_MAIN_GUILD");
                    return;
                }
                return;
            }
            if (!"test.entry".equals(str)) {
                String str2 = "Using WebView in main process from [" + str + "] is not allowed!!!";
                QLog.e("SwiftBrowserStatistics", 1, str2);
                if (!AppSetting.isPublicVersion()) {
                    throw new RuntimeException(str2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        if (!com.tencent.mobileqq.statistics.k.f290018a) {
            k.a aVar = new k.a();
            aVar.f290023e = "0X8009242";
            aVar.f290022d = "\u79bb\u5f00\u70b9\u51fbPush";
            com.tencent.mobileqq.statistics.k.b(str, aVar);
            com.tencent.mobileqq.statistics.k.d(null, aVar);
            com.tencent.mobileqq.statistics.k.f290018a = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str) {
        if (!com.tencent.mobileqq.statistics.k.f290018a) {
            PushNoticeManager.h(null, this.f314327f, this.f314328g, str, "0X8009242", "\u79bb\u5f00\u70b9\u51fbPush");
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.o
    public String a(AppRuntime appRuntime) {
        AppInterface appInterface;
        List<String> list;
        List<BusinessInfoCheckUpdate.AppInfo> list2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) appRuntime);
        }
        StringBuilder sb5 = new StringBuilder();
        BusinessInfoCheckUpdate.AppInfo appInfo = null;
        if (appRuntime instanceof AppInterface) {
            appInterface = (AppInterface) appRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return "";
        }
        String decodeString = QMMKV.from(appInterface.getApp(), "vas_mmkv_configurations").decodeString("redTouchPreflastClickPath", "");
        if (!"".equals(decodeString)) {
            BusinessInfoCheckUpdate.TimeRspBody r16 = r(appInterface);
            if (r16 != null && (list2 = r16.rptMsgAppInfo.get()) != null) {
                Iterator<BusinessInfoCheckUpdate.AppInfo> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    BusinessInfoCheckUpdate.AppInfo next = it.next();
                    if (next.path.get().equals(decodeString)) {
                        appInfo = next;
                        break;
                    }
                }
            }
            if (appInfo != null && (list = appInfo.missions.get()) != null) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    sb5.append(list.get(i3));
                    if (i3 != list.size() - 1) {
                        sb5.append("_");
                    }
                }
            }
        }
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.o
    public void b(boolean z16, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), str, Long.valueOf(j3));
            return;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if ((this.f314325d || this.f314326e) && !z16 && !com.tencent.mobileqq.statistics.k.f290018a) {
            ThreadManager.getFileThreadHandler().postDelayed(new Runnable(runtime, str) { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatisticInjectorImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ AppRuntime f314334d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f314335e;

                {
                    this.f314334d = runtime;
                    this.f314335e = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SwiftBrowserStatisticInjectorImpl.this, runtime, str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!com.tencent.mobileqq.statistics.k.f290018a) {
                        boolean k3 = QQUtils.k(BaseApplicationImpl.getApplication());
                        if (QLog.isColorLevel()) {
                            QLog.d("SwiftBrowserStatistics", 1, "reportPushEvent isScreenLock=", Boolean.valueOf(k3), ",isBackground=", Boolean.valueOf(this.f314334d.isBackgroundStop));
                        }
                        if (k3 || this.f314334d.isBackgroundStop) {
                            SwiftBrowserStatisticInjectorImpl swiftBrowserStatisticInjectorImpl = SwiftBrowserStatisticInjectorImpl.this;
                            if (swiftBrowserStatisticInjectorImpl.f314325d) {
                                swiftBrowserStatisticInjectorImpl.s(this.f314335e);
                            } else if (swiftBrowserStatisticInjectorImpl.f314326e) {
                                SwiftBrowserStatisticInjectorImpl.this.t(this.f314335e);
                            }
                        }
                    }
                }
            }, 1000L);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.o
    public long c(Intent intent, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, this, intent, Long.valueOf(j3))).longValue();
        }
        long longExtra = intent.getLongExtra("plugin_start_time", j3);
        if (longExtra != j3) {
            intent.putExtra("plugin_start_time", j3);
        }
        return longExtra;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.o
    public boolean d(Intent intent, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, intent, Boolean.valueOf(z16))).booleanValue();
        }
        return intent.getBooleanExtra("is_from_leba", z16);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.o
    public void e(WebViewProvider webViewProvider, String str, long j3, AppRuntime appRuntime, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, webViewProvider, str, Long.valueOf(j3), appRuntime, str2);
        } else {
            if (!GameCenterActivity.isContainsGameUrl(str)) {
                return;
            }
            SwiftBrowserStatistics swiftBrowserStatistics = (SwiftBrowserStatistics) webViewProvider.getComponentProvider().a(-2);
            SwiftBrowserStatistics.b bVar = swiftBrowserStatistics.T0;
            GameCenterActivity.reportStep(str, bVar.f314408a, true, bVar.f314409b);
            swiftBrowserStatistics.X(str, j3, appRuntime, str2, "WebStatusReportV2");
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.o
    public void f(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Long.valueOf(j3));
        } else if (lr2.a.e(str)) {
            lr2.a.l("SwiftBrowserStatistics", "onPageStarted_url", str);
            lr2.a.k(String.valueOf(j3));
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.o
    public void g(Intent intent, String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) str);
            return;
        }
        boolean z17 = true;
        GameCenterActivity.reportStep(str, 1, false, false);
        this.f314323b = intent.getBooleanExtra("fromAio", false);
        this.f314322a = intent.getStringExtra("op_type");
        if (intent.getIntExtra("uintype", -1) == 1030) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f314325d = z16;
        if (intent.getIntExtra("uintype", -1) != 1035) {
            z17 = false;
        }
        this.f314326e = z17;
        this.f314327f = intent.getStringExtra("push_notice_service_id");
        this.f314328g = intent.getStringExtra("push_notice_content_id");
        this.f314329h = intent.getIntExtra("KEY_MAIN_BUSINESS_ID", -1);
        this.f314330i = intent.getIntExtra("KEY_SUB_BUSINESS_ID", 0);
        this.f314331j = intent.getIntExtra("KEY_PUSH_ID", 0);
        this.f314332k = intent.getStringExtra("KEY_PUSH_TRIGGER_INFO");
        this.f314333l = intent.getStringExtra("KEY_PUSH_IS_FROM");
        q(intent.getStringExtra("key_url_source"));
        com.tencent.mobileqq.notification.modularize.i.f(this.f314329h, this.f314330i, this.f314331j, this.f314332k, this.f314333l);
        if (this.f314325d || this.f314326e) {
            com.tencent.mobileqq.statistics.k.f290018a = false;
        }
        long j3 = BaseApplicationImpl.sAttachBaseContextTime;
        long j16 = com.tencent.mobileqq.startup.a.f289662c;
        long uptimeMillis = SystemClock.uptimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.tencent.mobileqq.webview.swift.v.g(com.tencent.mobileqq.webview.swift.v.f314807c, elapsedRealtime - (uptimeMillis - j3));
        com.tencent.mobileqq.webview.swift.v.g(com.tencent.mobileqq.webview.swift.v.f314808d, elapsedRealtime - (uptimeMillis - j16));
        com.tencent.mobileqq.webview.swift.v.g(com.tencent.mobileqq.webview.swift.v.f314809e, SwiftBrowserStatistics.U0);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.o
    public void h(TouchWebView touchWebView, int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, touchWebView, Integer.valueOf(i3), str, str2);
            return;
        }
        if (lr2.a.e(str2)) {
            lr2.a.i(null, lr2.a.g(str2), "0X8009E9F", "fail", lr2.a.h(str2), "err=" + i3);
        }
        lr2.a.o(str2, "SwiftBrowserStatistics", "web_loaded_url_err", "errorCode = " + i3 + " description = " + str);
        lr2.a.o(str2, "SwiftBrowserStatistics", "failingUrl", str2);
        lr2.a.n(str2, "SwiftBrowserStatistics", "cookie");
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.o
    public boolean i(Intent intent, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, intent, Boolean.valueOf(z16))).booleanValue();
        }
        return intent.getBooleanExtra(QCircleScheme.AttrDetail.HAS_RED_DOT, z16);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.o
    public long j(Intent intent, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, this, intent, Long.valueOf(j3))).longValue();
        }
        long longExtra = intent.getLongExtra("click_start_time", j3);
        if (longExtra != j3) {
            intent.putExtra("click_start_time", j3);
        }
        return longExtra;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.o
    public void k(String str, long j3, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Long.valueOf(j3), str2, str3);
            return;
        }
        if (lr2.a.e(str3) && TextUtils.equals(str, "webview_init")) {
            lr2.a.i(null, lr2.a.g(str3), "0X8009E9D", String.valueOf(j3), lr2.a.h(str3), "err=" + str2);
        }
        lr2.a.o(str3, "SwiftBrowserStatistics", str, String.valueOf(j3));
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.o
    public void l(TouchWebView touchWebView, String str, boolean z16, int i3, long j3) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, touchWebView, str, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        if (z16 && this.f314323b && !this.f314324c) {
            this.f314324c = true;
            if (str != null) {
                str2 = str;
            } else {
                str2 = "unknown";
            }
            ReportController.n(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "msg_webview_url", "msg_webview_pvqq", 0, 1, 0, com.tencent.biz.common.util.k.f(URLEncoder.encode(str2), new String[0]), "", "", "" + i3);
        }
        if (lr2.a.e(str)) {
            long b16 = lr2.a.b(String.valueOf(j3));
            String h16 = lr2.a.h(str);
            String g16 = lr2.a.g(str);
            if (b16 != 0) {
                lr2.a.i(null, g16, "0X8009E9F", "success", h16, "");
                lr2.a.i(null, g16, "0X8009E9E", String.valueOf(b16), h16, "");
            }
            if (TextUtils.isEmpty(g16)) {
                lr2.a.l("SwiftBrowserStatistics", "url_load_time", String.valueOf(b16));
            } else {
                lr2.a.m("SwiftBrowserStatistics", "url_load_time", String.valueOf(b16), g16);
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.o
    public void m(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), str);
        } else if (this.f314325d && !z16) {
            s(str);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.o
    public void onDetectedBlankScreen(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, i3);
        } else {
            GameCenterActivity.reportDetectedBlankScreen(str, i3);
        }
    }

    public BusinessInfoCheckUpdate.TimeRspBody r(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (BusinessInfoCheckUpdate.TimeRspBody) iPatchRedirector.redirect((short) 8, (Object) this, (Object) appInterface);
        }
        if (appInterface != null && appInterface.getApplication() != null) {
            File file = new File(appInterface.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + appInterface.getCurrentAccountUin());
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
            byte[] fileToBytes = FileUtils.fileToBytes(file);
            if (fileToBytes == null) {
                return null;
            }
            BusinessInfoCheckUpdate.TimeRspBody timeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
            try {
                timeRspBody.mergeFrom(fileToBytes);
                return timeRspBody;
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
        return null;
    }
}
