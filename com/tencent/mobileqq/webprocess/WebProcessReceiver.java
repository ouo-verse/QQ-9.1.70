package com.tencent.mobileqq.webprocess;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.widget.Toast;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCClient;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.mobileqq.webview.swift.utils.i;
import com.tencent.mobileqq.webview.util.j;
import com.tencent.mobileqq.webview.util.l;
import com.tencent.mobileqq.webview.util.t;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qimei.webview.QmX5Webview;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.xweb.FileReaderHelper;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.QQBroadcastReceiver;

/* loaded from: classes20.dex */
public class WebProcessReceiver extends QQBroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static int f313723b;

    /* renamed from: c, reason: collision with root package name */
    public static long f313724c;

    /* renamed from: d, reason: collision with root package name */
    public static long f313725d;

    /* renamed from: a, reason: collision with root package name */
    private l f313726a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48424);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f313723b = -1;
        f313724c = 0L;
        f313725d = 0L;
    }

    public WebProcessReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(AppRuntime appRuntime, Context context, Intent intent) {
        a(context);
        SwiftBrowserCookieMonster.H();
        t.m("busi_html_offline_").f().a();
        i.e();
        this.f313726a.c(appRuntime, context, intent);
        com.tencent.mobileqq.webview.html.c.f313882a.a();
    }

    private void c(AppRuntime appRuntime, Intent intent) {
        boolean z16;
        String tBSDpcParam = WebAccelerateHelper.getInstance().getTBSDpcParam();
        if (tBSDpcParam != null && tBSDpcParam.charAt(0) == '1') {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean booleanExtra = intent.getBooleanExtra("isDownloadForeground", false);
        int intExtra = intent.getIntExtra("from", 0);
        boolean booleanExtra2 = intent.getBooleanExtra(FileReaderHelper.OPEN_FILE_FROM_FORCE, false);
        if (QLog.isColorLevel()) {
            QLog.d(com.tencent.qqmini.miniapp.receiver.WebProcessReceiver.TAG, 1, "[processDownloadTBS] from: " + intExtra + ", force: " + booleanExtra2);
        }
        if (z16) {
            ThreadManagerV2.excute(new Runnable(booleanExtra, appRuntime, booleanExtra2) { // from class: com.tencent.mobileqq.webprocess.WebProcessReceiver.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f313727d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ AppRuntime f313728e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f313729f;

                {
                    this.f313727d = booleanExtra;
                    this.f313728e = appRuntime;
                    this.f313729f = booleanExtra2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, WebProcessReceiver.this, Boolean.valueOf(booleanExtra), appRuntime, Boolean.valueOf(booleanExtra2));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (TbsDownloader.needDownload(BaseApplication.getContext(), this.f313727d)) {
                        Object obj = this.f313728e;
                        if (obj instanceof j) {
                            ((j) obj).a(this.f313729f, this.f313727d);
                            if (((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                                this.f313728e.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.webprocess.WebProcessReceiver.1.1
                                    static IPatchRedirector $redirector_;

                                    {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            iPatchRedirector2.redirect((short) 2, (Object) this);
                                        } else {
                                            QQToast.makeText(BaseApplication.getContext(), "\u542f\u52a8tbs\u4e0b\u8f7d", 0).show();
                                        }
                                    }
                                });
                            }
                        }
                    }
                }
            }, 128, null, false);
        }
    }

    private void d(AppRuntime appRuntime, Context context, Intent intent) {
        f313724c = intent.getLongExtra("com.tencent.mobileqq.webprocess.start_time", System.currentTimeMillis());
        f313725d = System.currentTimeMillis();
        try {
            f313723b = intent.getIntExtra("from", -1);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        QLog.d(com.tencent.qqmini.miniapp.receiver.WebProcessReceiver.TAG, 1, "[processPreload] fromOfPreload: " + f313723b);
        if (3 == f313723b) {
            SwiftBrowserIdleTaskHelper.h().f(new SwiftBrowserIdleTaskHelper.c(1));
        }
        this.f313726a.a(appRuntime, context, intent, f313723b);
    }

    protected void a(Context context) {
        int lastIndexOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        try {
            QmX5Webview qmX5Webview = new QmX5Webview(context);
            if (qmX5Webview.getX5WebViewExtension() == null) {
                WebSettings settings = qmX5Webview.getSettings();
                if (settings != null) {
                    String str = "";
                    String qQProcessName = MobileQQ.getMobileQQ().getQQProcessName();
                    if (qQProcessName != null && (lastIndexOf = qQProcessName.lastIndexOf(58)) > -1) {
                        str = "_" + qQProcessName.substring(lastIndexOf);
                    }
                    settings.setDatabasePath(context.getDir("database" + str, 0).getPath());
                    settings.setAppCachePath(context.getDir("appcache" + str, 0).getPath());
                }
                qmX5Webview.clearCache(true);
                qmX5Webview.clearFormData();
                qmX5Webview.clearSslPreferences();
                qmX5Webview.clearHistory();
                qmX5Webview.clearMatches();
                CookieSyncManager.createInstance(context);
                CookieManager.getInstance().removeAllCookie();
            } else {
                QbSdk.clearAllWebViewCache(context, true);
            }
            qmX5Webview.destroy();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(com.tencent.qqmini.miniapp.receiver.WebProcessReceiver.TAG, 2, "clear webview cache got exception:", e16);
            }
        }
    }

    @Override // mqq.app.QQBroadcastReceiver
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "modular_web";
    }

    @Override // mqq.app.QQBroadcastReceiver
    public void onReceive(AppRuntime appRuntime, Context context, Intent intent) {
        String action;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, context, intent);
            return;
        }
        if (intent != null && (action = intent.getAction()) != null) {
            if (QLog.isColorLevel()) {
                QLog.d(com.tencent.qqmini.miniapp.receiver.WebProcessReceiver.TAG, 2, "action=" + action);
            }
            RemoteWebRenderIPCClient.y().register();
            if (this.f313726a == null) {
                this.f313726a = (l) aa.d(l.class);
            }
            if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() && "action_kill_web".equals(action)) {
                QLog.d(com.tencent.qqmini.miniapp.receiver.WebProcessReceiver.TAG, 1, "WVPerf.DebugTrace_Testreceive ACTION_KILL_WEB");
                System.exit(0);
                return;
            }
            if ("com.tencent.mobileqq.webprocess.preload_web_process".equals(action)) {
                d(appRuntime, context, intent);
                return;
            }
            if ("action_clear_cache_exit".equals(action)) {
                b(appRuntime, context, intent);
                QLog.e(com.tencent.qqmini.miniapp.receiver.WebProcessReceiver.TAG, 1, "WVPerf.DebugTrace_Test self kill onReceive ACTION_CLEAR_CACHE_EXIT");
                SystemMethodProxy.killProcess(Process.myPid());
                return;
            }
            if ("action_reset_tbs".equals(action)) {
                QbSdk.reset(context.getApplicationContext());
                if (((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                    Toast.makeText(context, "TBS\u91cd\u7f6e\u5b8c\u6210", 0).show();
                    return;
                }
                return;
            }
            if (com.tencent.qqmini.miniapp.receiver.WebProcessReceiver.ACTION_DOWNLOAD_TBS.equals(action)) {
                c(appRuntime, intent);
                return;
            }
            if ("com.tencent.mobileqq.webprocess.stop_web_core_service".equals(action)) {
                QLog.i(com.tencent.qqmini.miniapp.receiver.WebProcessReceiver.TAG, 1, "Receive action stop web core service");
                WebCoreService.f();
                return;
            }
            if ("com.tencent.mobileqq.webprocess.release_tool_process".equals(action)) {
                if (WebCoreService.f313722f) {
                    WebCoreService.f();
                }
                boolean z16 = SwiftWebAccelerator.h().f314720b;
                QLog.i(com.tencent.qqmini.miniapp.receiver.WebProcessReceiver.TAG, 1, "Receive action release tool process, isInRealWorld:" + z16);
                if (!z16) {
                    System.exit(0);
                    return;
                }
                return;
            }
            this.f313726a.b(appRuntime, context, intent, action);
        }
    }
}
