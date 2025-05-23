package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.jsp.ap;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vaswebviewplugin.VasBaseWebviewUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.webview.swift.injector.f;
import com.tencent.mobileqq.webview.swift.utils.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.task.ServiceCreateTask;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SwiftBrowserTBSHandler extends b.C8976b implements Handler.Callback {
    static IPatchRedirector $redirector_;
    Boolean C;
    long D;
    String E;
    boolean F;
    BroadcastReceiver G;
    private HashSet<String> H;

    @NonNull
    private final com.tencent.mobileqq.webview.swift.injector.p I;

    /* renamed from: e, reason: collision with root package name */
    Activity f314413e;

    /* renamed from: f, reason: collision with root package name */
    WebViewProvider f314414f;

    /* renamed from: h, reason: collision with root package name */
    WeakReferenceHandler f314415h;

    /* renamed from: i, reason: collision with root package name */
    final Object f314416i;

    /* renamed from: m, reason: collision with root package name */
    Dialog f314417m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler$5, reason: invalid class name */
    /* loaded from: classes20.dex */
    class AnonymousClass5 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ SwiftBrowserTBSHandler this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            SwiftBrowserTBSHandler swiftBrowserTBSHandler = this.this$0;
            swiftBrowserTBSHandler.j(MsfSdkUtils.insertMtype(GdtLog.WEB_TAG, swiftBrowserTBSHandler.E), 0);
            synchronized (this.this$0.f314416i) {
                SwiftBrowserTBSHandler swiftBrowserTBSHandler2 = this.this$0;
                swiftBrowserTBSHandler2.C = Boolean.TRUE;
                swiftBrowserTBSHandler2.f314416i.notifyAll();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements f.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftBrowserTBSHandler.this);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.f.a
        public String a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            SwiftBrowserTBSHandler.this.j(MsfSdkUtils.insertMtype(GdtLog.WEB_TAG, str), 0);
            return SwiftBrowserTBSHandler.this.E;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b implements TbsDownloader.TbsDownloaderCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<com.tencent.mobileqq.webview.util.j> f314429a;

        public b(com.tencent.mobileqq.webview.util.j jVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) jVar);
            } else {
                this.f314429a = new WeakReference<>(jVar);
            }
        }

        @Override // com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback
        public void onNeedDownloadFinish(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            if (z16) {
                if (QLog.isColorLevel()) {
                    QLog.d("TBS_update", 2, "tbs need download");
                }
                WeakReference<com.tencent.mobileqq.webview.util.j> weakReference = this.f314429a;
                if (weakReference != null && weakReference.get() != null) {
                    this.f314429a.get().d(false);
                }
            }
        }
    }

    public SwiftBrowserTBSHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f314415h = null;
        this.f314416i = new Object();
        this.f314417m = null;
        this.C = Boolean.FALSE;
        this.D = 0L;
        this.E = null;
        this.F = false;
        this.I = (com.tencent.mobileqq.webview.swift.injector.p) com.tencent.mobileqq.webview.swift.injector.aa.d(com.tencent.mobileqq.webview.swift.injector.p.class);
    }

    private static Pair<Integer, Integer> i(String str) {
        int i3;
        int i16;
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (parse.isHierarchical()) {
                String host = parse.getHost();
                if (!TextUtils.isEmpty(host) && AuthorizeConfig.y().m(host)) {
                    i3 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
                    i16 = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
                    if (!host.contains("cmshow")) {
                        i16 -= Utils.n(54.0f, BaseApplication.getContext().getResources());
                    }
                    return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
                }
            }
        }
        i3 = 0;
        i16 = 0;
        return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.tencent.mobileqq.webview.util.j k(AppRuntime appRuntime) {
        if (appRuntime instanceof com.tencent.mobileqq.webview.util.j) {
            return (com.tencent.mobileqq.webview.util.j) appRuntime;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p(boolean z16, int i3) {
        String str;
        com.tencent.mobileqq.webview.swift.injector.m mVar = (com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("tbs_cover_");
        if (z16) {
            if (i3 > 0) {
                str = "tbs";
            } else {
                str = NotificationCompat.CATEGORY_SYSTEM;
            }
        } else {
            str = "dis";
        }
        sb5.append(str);
        mVar.a(null, "P_CliOper", "BizTechReport", "", "web", sb5.toString(), 0, 1, i3, "", "", "", "");
    }

    private void q(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(WebView webView, String str, String str2) {
        String b16;
        Pair<Integer, Integer> i3 = i(str);
        int intValue = ((Integer) i3.first).intValue();
        int intValue2 = ((Integer) i3.second).intValue();
        if (intValue > 0 && intValue2 > 0 && webView != null && webView.getX5WebViewExtension() != null) {
            if (TextUtils.isEmpty(str2)) {
                b16 = "";
            } else {
                b16 = com.tencent.mobileqq.webview.util.q.b(str2);
            }
            ThreadManager.getUIHandler().post(new Runnable(str2, str, webView, intValue, intValue2, b16) { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.10
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f314419d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f314420e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ WebView f314421f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f314422h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ int f314423i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ String f314424m;

                {
                    this.f314419d = str2;
                    this.f314420e = str;
                    this.f314421f = webView;
                    this.f314422h = intValue;
                    this.f314423i = intValue2;
                    this.f314424m = b16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, str2, str, webView, Integer.valueOf(intValue), Integer.valueOf(intValue2), b16);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!TextUtils.isEmpty(this.f314419d)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("TYPE", "4");
                        hashMap.put("mimeType", "text/html");
                        hashMap.put("encoding", "utf-8");
                        hashMap.put("baseUrl", this.f314420e);
                        this.f314421f.getX5WebViewExtension().preLoad(this.f314419d, this.f314422h, this.f314423i, hashMap);
                        if (QLog.isColorLevel()) {
                            QLog.d("SwiftBrowserTBSHandler", 2, "webView.getX5WebViewExtension().preLoad offline data:" + this.f314420e + ", sha1: " + this.f314424m);
                            return;
                        }
                        return;
                    }
                    this.f314421f.getX5WebViewExtension().preLoad(this.f314420e, this.f314422h, this.f314423i, null);
                    if (QLog.isColorLevel()) {
                        QLog.d("SwiftBrowserTBSHandler", 2, "webView.getX5WebViewExtension().preLoad: " + this.f314420e);
                    }
                }
            });
        }
    }

    public static void s(String str, WebView webView) {
        ThreadManagerV2.post(new Runnable(str, webView) { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.9
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f314426d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ WebView f314427e;

            {
                this.f314426d = str;
                this.f314427e = webView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) webView);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String str2;
                g.a b16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (QbSdk.getTbsVersion(BaseApplication.getContext()) >= 43810) {
                    if (com.tencent.mobileqq.webview.swift.utils.g.e(this.f314426d) && (b16 = com.tencent.mobileqq.webview.swift.utils.g.b(this.f314426d)) != null) {
                        str2 = b16.f314753b;
                    } else {
                        str2 = null;
                    }
                    if (!TextUtils.isEmpty(this.f314426d)) {
                        SwiftBrowserTBSHandler.r(this.f314427e, this.f314426d, str2);
                    }
                }
            }
        }, 5, null, true);
    }

    private void t(Bundle bundle) {
        String str;
        long j3;
        long j16;
        long j17;
        String str2;
        long j18;
        long j19;
        long j26;
        if (QLog.isDevelopLevel()) {
            QLog.i("SwiftBrowserTBSHandler", 2, "netTimeConsumingReport start");
        }
        if (bundle.containsKey("firstbyte")) {
            try {
                String string = bundle.getString("firstbyte");
                String string2 = bundle.getString("firstscreen");
                String string3 = bundle.getString("firstword");
                if (!TextUtils.isEmpty(string)) {
                    j3 = Long.parseLong(string);
                } else {
                    j3 = 0;
                }
                if (!TextUtils.isEmpty(string2)) {
                    j16 = Long.parseLong(string2);
                } else {
                    j16 = 0;
                }
                if (!TextUtils.isEmpty(string3)) {
                    j17 = Long.parseLong(string3);
                } else {
                    j17 = 0;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i("SwiftBrowserTBSHandler", 2, String.format("receive firstByteStr: %s, receive firstScreenStr: %s, firstWordStr:%s", string, string2, string3));
                }
                try {
                    SwiftBrowserStatistics swiftBrowserStatistics = (SwiftBrowserStatistics) this.f314441d.getProvider().a(-2);
                    if (swiftBrowserStatistics == null) {
                        str2 = "SwiftBrowserTBSHandler";
                        j18 = 0;
                        j19 = 0;
                        j26 = 0;
                    } else {
                        long j27 = swiftBrowserStatistics.f314358f;
                        str2 = "SwiftBrowserTBSHandler";
                        try {
                            long j28 = swiftBrowserStatistics.f314361h;
                            long j29 = swiftBrowserStatistics.R;
                            swiftBrowserStatistics.E = j3;
                            swiftBrowserStatistics.F = j16;
                            swiftBrowserStatistics.D = j17;
                            j26 = j27;
                            j18 = j29;
                            j19 = j28;
                        } catch (Exception e16) {
                            e = e16;
                            str = str2;
                            QLog.e(str, 2, "", e);
                        }
                    }
                    VasBaseWebviewUtil.reportX5SpeedData(swiftBrowserStatistics);
                    if (QLog.isDevelopLevel()) {
                        long j36 = j3 - j18;
                        long j37 = j16 - j3;
                        str = str2;
                        try {
                            QLog.i(str, 2, String.format("webview start - click start: %d, loadurl - webview start: %d, first byte - loadurl: %d, first screen - first byte: %d", Long.valueOf(j19 - j26), Long.valueOf(j18 - j19), Long.valueOf(j36), Long.valueOf(j37)));
                            QLog.i(str, 1, "Web_qqbrowser_X5_from_loadUrl_to_FirstByte, cost=" + j36);
                            QLog.i(str, 1, "Web_qqbrowser_X5_from_FirstByte_to_FirstScreen, cost=" + j37);
                            QLog.i(str, 1, "from click to firstWord time = " + (j17 - j26));
                        } catch (Exception e17) {
                            e = e17;
                            QLog.e(str, 2, "", e);
                        }
                    }
                } catch (Exception e18) {
                    e = e18;
                    str = "SwiftBrowserTBSHandler";
                    QLog.e(str, 2, "", e);
                }
            } catch (Exception e19) {
                e = e19;
            }
        }
    }

    private void u(Bundle bundle) {
        if (bundle.containsKey("url")) {
            String string = bundle.getString("url");
            if (!TextUtils.isEmpty(string) && string.startsWith("http")) {
                String queryParameter = Uri.parse(string).getQueryParameter("_bid");
                if (!TextUtils.isEmpty(queryParameter)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("SwiftBrowserTBSHandler", 2, "ServiceWorkerOffline Notify Resource RequestURL: " + bundle.getString("url"));
                    }
                    if (this.H == null) {
                        this.H = new HashSet<>(6);
                    }
                    if (!this.H.contains(queryParameter)) {
                        this.H.add(queryParameter);
                        ThreadManager.getUIHandler().postDelayed(new Runnable(string) { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.4
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ String f314425d;

                            {
                                this.f314425d = string;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftBrowserTBSHandler.this, (Object) string);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                } else {
                                    HtmlOffline.e(this.f314425d, MobileQQ.sMobileQQ.waitAppRuntime(null), null);
                                }
                            }
                        }, 5000L);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.C8976b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.e();
        Activity activity = this.f314441d.getActivity();
        if (activity instanceof QQBrowserActivity) {
            this.f314413e = activity;
        } else {
            this.f314413e = null;
        }
        this.f314414f = this.f314441d.getWebViewProvider();
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.C8976b
    public void f(int i3, Bundle bundle) {
        ap apVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) bundle);
            return;
        }
        CustomWebView customWebView = null;
        if (i3 != 3) {
            if (i3 == 8 && !this.F) {
                this.F = true;
                this.I.a(this.f314441d);
                WebViewProvider webViewProvider = this.f314414f;
                if (webViewProvider != null) {
                    customWebView = webViewProvider.getWebView();
                }
                if (customWebView != null && (apVar = (ap) customWebView.getPluginEngine().m(ServiceCreateTask.SERVICE_TYPE_X5)) != null) {
                    apVar.t();
                    return;
                }
                return;
            }
            return;
        }
        Dialog dialog = this.f314417m;
        if (dialog != null && dialog.isShowing()) {
            this.f314417m.dismiss();
        }
        BroadcastReceiver broadcastReceiver = this.G;
        if (broadcastReceiver != null) {
            this.f314413e.unregisterReceiver(broadcastReceiver);
            this.G = null;
        }
        this.I.onDestroy();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        WebViewProvider webViewProvider;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) message)).booleanValue();
        }
        switch (message.what) {
            case 100:
                try {
                    JSONObject jSONObject = new JSONObject((String) message.obj);
                    JSONObject jSONObject2 = jSONObject.getJSONObject("icon");
                    JSONObject jSONObject3 = jSONObject.getJSONObject("content");
                    String string = jSONObject2.getString("timestamp");
                    String string2 = jSONObject2.getString("url");
                    String string3 = jSONObject3.getString("timestamp");
                    String string4 = jSONObject3.getString("memo");
                    SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("qb_info", 0);
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString("icon_time", string);
                        edit.putString("icon_url", string2);
                        edit.putString("content_time", string3);
                        edit.putString("content_memo", string4);
                        edit.commit();
                        break;
                    }
                } catch (Exception unused) {
                    break;
                }
                break;
            case 101:
                if (!this.f314413e.isFinishing() && (webViewProvider = this.f314414f) != null && !webViewProvider.isDestroyed()) {
                    ((com.tencent.mobileqq.webview.swift.injector.f) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.f.class)).c((Bundle) message.obj, this.f314413e, this.f314414f.getWebView().getUrl(), this.f314414f.getWebView().getSettings().getUserAgentString());
                    ((v) this.f314414f.getComponentProvider().a(2)).Z.setVisibility(8);
                    break;
                }
                break;
            case 102:
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SwiftBrowserTBSHandler.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bundle i3;
                        com.tencent.mobileqq.webview.swift.injector.f fVar;
                        Activity activity;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        synchronized (SwiftBrowserTBSHandler.this.f314416i) {
                            try {
                                try {
                                    if (!SwiftBrowserTBSHandler.this.C.booleanValue()) {
                                        LockMethodProxy.wait(SwiftBrowserTBSHandler.this.f314416i);
                                    }
                                    i3 = ((com.tencent.mobileqq.webview.swift.injector.f) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.f.class)).i("QQ\u6d4f\u89c8\u5668", "801097412", SwiftBrowserTBSHandler.this.E, TbsConfig.APP_QB);
                                    fVar = (com.tencent.mobileqq.webview.swift.injector.f) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.f.class);
                                    activity = SwiftBrowserTBSHandler.this.f314413e;
                                } catch (Throwable th5) {
                                    ((com.tencent.mobileqq.webview.swift.injector.f) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.f.class)).a(SwiftBrowserTBSHandler.this.f314413e, ((com.tencent.mobileqq.webview.swift.injector.f) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.f.class)).i("QQ\u6d4f\u89c8\u5668", "801097412", SwiftBrowserTBSHandler.this.E, TbsConfig.APP_QB));
                                    throw th5;
                                }
                            } catch (InterruptedException unused2) {
                                i3 = ((com.tencent.mobileqq.webview.swift.injector.f) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.f.class)).i("QQ\u6d4f\u89c8\u5668", "801097412", SwiftBrowserTBSHandler.this.E, TbsConfig.APP_QB);
                                fVar = (com.tencent.mobileqq.webview.swift.injector.f) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.f.class);
                                activity = SwiftBrowserTBSHandler.this.f314413e;
                            }
                            fVar.a(activity, i3);
                        }
                    }
                }, 8, null, true);
                break;
            case 103:
                Drawable drawable = (Drawable) message.obj;
                Dialog dialog = this.f314417m;
                if (dialog != null && dialog.isShowing() && drawable != null) {
                    ImageView imageView = (ImageView) this.f314417m.findViewById(R.id.khs);
                    imageView.setImageDrawable(null);
                    imageView.setImageDrawable(drawable);
                    break;
                }
                break;
            case 104:
                String str = (String) message.obj;
                Dialog dialog2 = this.f314417m;
                if (dialog2 != null && dialog2.isShowing() && str != null) {
                    ((TextView) this.f314417m.findViewById(R.id.khu)).setText(str);
                    break;
                }
                break;
        }
        return true;
    }

    void j(String str, int i3) {
        String str2;
        if (i3 < 12) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 301 && responseCode != 302) {
                    if (responseCode == 200) {
                        this.D = httpURLConnection.getContentLength();
                        this.E = httpURLConnection.getURL().toString();
                    }
                    httpURLConnection.disconnect();
                }
                Iterator<String> it = httpURLConnection.getHeaderFields().keySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        String next = it.next();
                        if ("location".equalsIgnoreCase(next)) {
                            str2 = httpURLConnection.getHeaderField(next);
                            break;
                        }
                    } else {
                        str2 = null;
                        break;
                    }
                }
                if (str2 != null) {
                    j(MsfSdkUtils.insertMtype(GdtLog.WEB_TAG, str2), i3 + 1);
                    return;
                }
                httpURLConnection.disconnect();
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("SwiftBrowserTBSHandler", 2, th5.getMessage());
                }
            }
        }
    }

    public void l(int i3, String str) {
        CustomWebView customWebView;
        ap apVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3, (Object) str);
            return;
        }
        VasBaseWebviewUtil.reportVasStatus("WebViewStatus", "x5_preload", "0", 0, 0, i3, 0, str, "");
        if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserTBSHandler", 2, "handlePreloadCallback: type=" + i3 + ", url=" + str);
        }
        WebViewProvider webViewProvider = this.f314414f;
        if (webViewProvider != null) {
            customWebView = webViewProvider.getWebView();
        } else {
            customWebView = null;
        }
        if (customWebView != null && (apVar = (ap) customWebView.getPluginEngine().m(ServiceCreateTask.SERVICE_TYPE_X5)) != null) {
            apVar.u(i3, str);
        }
    }

    void m(Bundle bundle) {
        String str;
        String str2;
        String str3 = "";
        if (bundle != null) {
            try {
                if (!bundle.containsKey("url")) {
                    str2 = "";
                } else {
                    str2 = bundle.getString("url");
                }
                try {
                    if (!bundle.containsKey("requestTime")) {
                        str = "";
                    } else {
                        str = bundle.getString("requestTime");
                    }
                } catch (Throwable th5) {
                    th = th5;
                    str = "";
                }
            } catch (Throwable th6) {
                th = th6;
                str = "";
                str2 = str;
            }
            try {
                if (bundle.containsKey("upstreamResponseTime")) {
                    str3 = bundle.getString("upstreamResponseTime");
                }
            } catch (Throwable th7) {
                th = th7;
                QLog.e("SwiftBrowserTBSHandler", 1, "handleStgwTime error!", th);
                QLog.d("SwiftBrowserTBSHandler", 1, "handle stgw time, requestTime: " + str + "s, responseTime: " + str3 + "s, url: " + com.tencent.mobileqq.webview.util.s.d(str2, new String[0]));
                return;
            }
            QLog.d("SwiftBrowserTBSHandler", 1, "handle stgw time, requestTime: " + str + "s, responseTime: " + str3 + "s, url: " + com.tencent.mobileqq.webview.util.s.d(str2, new String[0]));
            return;
        }
        QLog.d("SwiftBrowserTBSHandler", 1, "handleStgwTime error, data is not JSONObject!");
    }

    public Object n(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) bundle);
        }
        if (this.f314413e == null) {
            return null;
        }
        if ("openBrowserList".equals(str)) {
            QLog.d("SwiftBrowserTBSHandler", 1, "XChooserActivity \u5df2\u5728725\u4e0b\u67b6");
            return null;
        }
        if ("addDownloadTask".equals(str)) {
            if (bundle == null) {
                return null;
            }
            String string = bundle.getString("task_name");
            String string2 = bundle.getString("task_url");
            String string3 = bundle.getString("appid");
            this.E = string2;
            if (string3 != null && string != null) {
                ((com.tencent.mobileqq.webview.swift.injector.f) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.f.class)).d(this.f314413e, string, string2, string3, new a());
            }
            return string3;
        }
        if ("cancelDownloadTask".equals(str)) {
            String string4 = bundle.getString("download_id");
            if (!((com.tencent.mobileqq.webview.swift.injector.f) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.f.class)).g(string4)) {
                return Boolean.FALSE;
            }
            ((com.tencent.mobileqq.webview.swift.injector.f) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.f.class)).k(string4);
            return Boolean.TRUE;
        }
        if ("queryDownloadTask".equals(str)) {
            return Integer.valueOf(((com.tencent.mobileqq.webview.swift.injector.f) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.f.class)).f(bundle.getString("download_id")));
        }
        if ("installDownloadTask".equals(str)) {
            return Boolean.valueOf(((com.tencent.mobileqq.webview.swift.injector.f) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.f.class)).e(this.f314413e, bundle.getString("download_id")));
        }
        if ("notifyQBiconShine".equals(str)) {
            v vVar = (v) this.f314441d.getProvider().a(2);
            if (vVar != null) {
                vVar.f314512m.M = true;
                if (QLog.isColorLevel()) {
                    QLog.d("SwiftBrowserTBSHandler", 2, "QQBrowser has related content.");
                }
            }
        } else if ("netTimeConsumingReport".equals(str)) {
            t(bundle);
        } else if (str.equalsIgnoreCase("onReportStgwTime")) {
            m(bundle);
        } else if ("onNotifyResourceRequestURL".equals(str)) {
            u(bundle);
        } else {
            this.I.handlerMiscCallback(str, bundle);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ea A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o() {
        boolean z16;
        boolean z17;
        b.c cVar;
        SwiftBrowserStatistics swiftBrowserStatistics;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f314414f != null && this.f314413e != null) {
            if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                z16 = ((Boolean) com.tencent.mobileqq.webview.util.t.j().b("isWebViewDebugLayerShow", Boolean.FALSE)).booleanValue();
            } else {
                z16 = false;
            }
            String tBSDpcParam = WebAccelerateHelper.getInstance().getTBSDpcParam();
            final boolean z18 = true;
            if (!TextUtils.isEmpty(tBSDpcParam)) {
                if (tBSDpcParam.charAt(0) != '1') {
                    if (QLog.isColorLevel()) {
                        QLog.i("SwiftBrowserTBSHandler", 2, "warning: disable tbs, " + tBSDpcParam);
                    }
                    z17 = false;
                    if (k(this.f314414f.getAppRuntime()) == null && z17) {
                        if (LocaleManager.MOBILE_COUNTRY_CODE_CN_STR.equals(Locale.getDefault().getCountry())) {
                            com.tencent.mobileqq.webview.util.j k3 = k(this.f314414f.getAppRuntime());
                            if (TbsDownloader.needDownload(BaseApplication.getContext(), false, false, new b(k3))) {
                                q("TBS_update", "tbs need download");
                                k3.d(false);
                            } else {
                                q("TBS_update", "tbs no need download");
                            }
                            cVar = this.f314441d;
                            if (cVar != null) {
                                swiftBrowserStatistics = (SwiftBrowserStatistics) cVar.getProvider().a(-2);
                            } else {
                                swiftBrowserStatistics = null;
                            }
                            if (!z16 || ((swiftBrowserStatistics != null && swiftBrowserStatistics.f314379w0) || QLog.isColorLevel())) {
                                final int tbsVersion = QbSdk.getTbsVersion(BaseApplication.getContext());
                                if (z16) {
                                    ThreadManager.getUIHandler().post(new Runnable(tbsVersion) { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.1
                                        static IPatchRedirector $redirector_;

                                        /* renamed from: d, reason: collision with root package name */
                                        final /* synthetic */ int f314418d;

                                        {
                                            this.f314418d = tbsVersion;
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SwiftBrowserTBSHandler.this, tbsVersion);
                                            }
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            String str2;
                                            IPatchRedirector iPatchRedirector2 = $redirector_;
                                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                                return;
                                            }
                                            TextView textView = new TextView(SwiftBrowserTBSHandler.this.f314413e);
                                            textView.setBackgroundColor(HWColorFormat.COLOR_FormatVendorStartUnused);
                                            textView.setTextColor(Integer.MAX_VALUE);
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append(textView.getResources().getString(R.string.f214355so));
                                            if (this.f314418d == 0) {
                                                str2 = "\u7cfb\u7edfWebView";
                                            } else {
                                                str2 = "x5 " + this.f314418d;
                                            }
                                            sb5.append(str2);
                                            textView.setText(sb5.toString());
                                            SwiftBrowserTBSHandler.this.f314413e.addContentView(textView, new RelativeLayout.LayoutParams(-2, -2));
                                        }
                                    });
                                }
                                if (QLog.isColorLevel()) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("tbs current webview:");
                                    if (tbsVersion == 0) {
                                        str = NotificationCompat.CATEGORY_SYSTEM;
                                    } else {
                                        str = "x5_" + tbsVersion;
                                    }
                                    sb5.append(str);
                                    QLog.d("TBS_update", 2, sb5.toString());
                                }
                                if (swiftBrowserStatistics != null && swiftBrowserStatistics.f314379w0) {
                                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.component.t
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            SwiftBrowserTBSHandler.p(z18, tbsVersion);
                                        }
                                    }, 16, null, false);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        q("TBS_update", "tbs loc/tz not match");
                    } else {
                        q("TBS_update", "tbs update disabled");
                    }
                    z18 = false;
                    cVar = this.f314441d;
                    if (cVar != null) {
                    }
                    if (!z16) {
                    }
                    final int tbsVersion2 = QbSdk.getTbsVersion(BaseApplication.getContext());
                    if (z16) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    if (swiftBrowserStatistics != null) {
                        return;
                    } else {
                        return;
                    }
                }
            } else {
                QLog.e("SwiftBrowserTBSHandler", 1, "error: no dpc param!");
            }
            z17 = true;
            if (k(this.f314414f.getAppRuntime()) == null) {
            }
            q("TBS_update", "tbs update disabled");
            z18 = false;
            cVar = this.f314441d;
            if (cVar != null) {
            }
            if (!z16) {
            }
            final int tbsVersion22 = QbSdk.getTbsVersion(BaseApplication.getContext());
            if (z16) {
            }
            if (QLog.isColorLevel()) {
            }
            if (swiftBrowserStatistics != null) {
            }
        }
    }
}
