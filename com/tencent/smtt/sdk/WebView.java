package com.tencent.smtt.sdk;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qimei.webview.QmWebview;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.miniapp.util.DebugUtils;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.recorder.TbsWebViewPerformanceRecorder;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.QZoneHelper;
import java.io.BufferedWriter;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class WebView extends FrameLayout implements View.OnLongClickListener {
    public static int NIGHT_MODE_ALPHA = 153;
    public static final int NIGHT_MODE_COLOR = -16777216;
    public static final int NORMAL_MODE_ALPHA = 255;
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";

    /* renamed from: i, reason: collision with root package name */
    private static Context f369205i = null;

    /* renamed from: l, reason: collision with root package name */
    private static Method f369206l = null;
    public static boolean mSysWebviewCreated = false;
    public static boolean mWebViewCreated = false;

    /* renamed from: o, reason: collision with root package name */
    private static String f369207o = null;

    /* renamed from: u, reason: collision with root package name */
    private static Paint f369208u = null;

    /* renamed from: v, reason: collision with root package name */
    private static boolean f369209v = true;

    /* renamed from: a, reason: collision with root package name */
    volatile int f369210a;

    /* renamed from: b, reason: collision with root package name */
    private final String f369211b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f369212c;

    /* renamed from: d, reason: collision with root package name */
    private IX5WebViewBase f369213d;

    /* renamed from: e, reason: collision with root package name */
    private a f369214e;

    /* renamed from: f, reason: collision with root package name */
    private WebSettings f369215f;

    /* renamed from: g, reason: collision with root package name */
    private Context f369216g;

    /* renamed from: h, reason: collision with root package name */
    private TbsWebViewPerformanceRecorder f369217h;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f369218j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f369219k;

    /* renamed from: m, reason: collision with root package name */
    private WebViewClient f369220m;
    public WebViewCallbackClient mWebViewCallbackClient;

    /* renamed from: n, reason: collision with root package name */
    private WebChromeClient f369221n;

    /* renamed from: p, reason: collision with root package name */
    private final int f369222p;

    /* renamed from: q, reason: collision with root package name */
    private final int f369223q;

    /* renamed from: r, reason: collision with root package name */
    private final int f369224r;

    /* renamed from: s, reason: collision with root package name */
    private final String f369225s;

    /* renamed from: t, reason: collision with root package name */
    private final String f369226t;

    /* renamed from: w, reason: collision with root package name */
    private Object f369227w;

    /* renamed from: x, reason: collision with root package name */
    private View.OnLongClickListener f369228x;

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes23.dex */
    public interface PictureListener {
        @Deprecated
        void onNewPicture(WebView webView, Picture picture);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class WebViewTransport {

        /* renamed from: b, reason: collision with root package name */
        private WebView f369242b;

        public WebViewTransport() {
        }

        public synchronized WebView getWebView() {
            return this.f369242b;
        }

        public synchronized void setWebView(WebView webView) {
            this.f369242b = webView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a extends QmWebview {
        public a(WebView webView, Context context) {
            this(context, null);
        }

        public void a(int i3, int i16, int i17, int i18) {
            super.onScrollChanged(i3, i16, i17, i18);
        }

        public boolean b(MotionEvent motionEvent) {
            return super.dispatchTouchEvent(motionEvent);
        }

        public boolean c(MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.webkit.WebView, android.view.View
        public void computeScroll() {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.computeScroll(this);
            } else {
                super.computeScroll();
            }
        }

        @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            try {
                super.dispatchDraw(canvas);
                if (!WebView.f369209v && WebView.f369208u != null) {
                    canvas.save();
                    canvas.drawPaint(WebView.f369208u);
                    canvas.restore();
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                return webViewCallbackClient.dispatchTouchEvent(motionEvent, this);
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        @Override // android.webkit.WebView
        public android.webkit.WebSettings getSettings() {
            try {
                return super.getSettings();
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }

        @Override // android.view.View
        public void invalidate() {
            super.invalidate();
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.invalidate();
            }
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                return webViewCallbackClient.onInterceptTouchEvent(motionEvent, this);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.webkit.WebView, android.view.View
        @TargetApi(9)
        public void onOverScrolled(int i3, int i16, boolean z16, boolean z17) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.onOverScrolled(i3, i16, z16, z17, this);
            } else {
                super.onOverScrolled(i3, i16, z16, z17);
            }
        }

        @Override // android.webkit.WebView, android.view.View
        protected void onScrollChanged(int i3, int i16, int i17, int i18) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                webViewCallbackClient.onScrollChanged(i3, i16, i17, i18, this);
            } else {
                super.onScrollChanged(i3, i16, i17, i18);
                WebView.this.onScrollChanged(i3, i16, i17, i18);
            }
        }

        @Override // android.webkit.WebView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!hasFocus()) {
                requestFocus();
            }
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                return webViewCallbackClient.onTouchEvent(motionEvent, this);
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Throwable th5) {
                th5.printStackTrace();
                return false;
            }
        }

        @Override // android.view.View
        @TargetApi(9)
        public boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
            WebViewCallbackClient webViewCallbackClient = WebView.this.mWebViewCallbackClient;
            if (webViewCallbackClient != null) {
                return webViewCallbackClient.overScrollBy(i3, i16, i17, i18, i19, i26, i27, i28, z16, this);
            }
            return super.overScrollBy(i3, i16, i17, i18, i19, i26, i27, i28, z16);
        }

        @Override // android.webkit.WebView, android.view.View
        public void setOverScrollMode(int i3) {
            try {
                super.setOverScrollMode(i3);
            } catch (Exception unused) {
            }
        }

        public a(Context context, AttributeSet attributeSet) {
            super(WebView.this.c(context), attributeSet);
            WebView.mSysWebviewCreated = true;
            if (QbSdk.getIsSysWebViewForcedByOuter() && TbsShareManager.isThirdPartyApp(context)) {
                return;
            }
            CookieSyncManager.createInstance(WebView.this.f369216g).startSync();
            try {
                Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                declaredMethod.setAccessible(true);
                ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new h());
            } catch (Exception unused) {
            }
        }

        public void a() {
            super.computeScroll();
        }

        public boolean a(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        @TargetApi(9)
        public boolean a(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
            return super.overScrollBy(i3, i16, i17, i18, i19, i26, i27, i28, z16);
        }

        @TargetApi(9)
        public void a(int i3, int i16, boolean z16, boolean z17) {
            super.onOverScrolled(i3, i16, z16, z17);
        }
    }

    @Deprecated
    public WebView(Context context, boolean z16) {
        super(context);
        this.f369211b = "WebView";
        this.f369212c = false;
        this.f369215f = null;
        this.f369216g = null;
        this.f369217h = new TbsWebViewPerformanceRecorder();
        this.f369210a = 0;
        this.f369218j = false;
        this.f369219k = false;
        this.f369220m = null;
        this.f369221n = null;
        this.f369222p = 1;
        this.f369223q = 2;
        this.f369224r = 3;
        this.f369225s = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.f369226t = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.f369227w = null;
        this.f369228x = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context c(Context context) {
        return context;
    }

    @Deprecated
    public static void disablePlatformNotifications() {
        if (!p.a().b()) {
            com.tencent.smtt.utils.k.a("android.webkit.WebView", "disablePlatformNotifications");
        }
    }

    @Deprecated
    public static void enablePlatformNotifications() {
        if (!p.a().b()) {
            com.tencent.smtt.utils.k.a("android.webkit.WebView", "enablePlatformNotifications");
        }
    }

    @Deprecated
    public static String findAddress(String str) {
        if (!p.a().b()) {
            return android.webkit.WebView.findAddress(str);
        }
        return null;
    }

    private void g() {
        if (!this.f369218j && this.f369210a != 0) {
            j();
        }
        if (!this.f369212c) {
            this.f369214e.destroy();
            try {
                TbsLog.i("sdkreport", "webview.destroyImplNow mQQMusicCrashFix is " + this.f369219k);
                if (this.f369219k) {
                    return;
                }
                Field declaredField = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
                declaredField.setAccessible(true);
                ComponentCallbacks componentCallbacks = (ComponentCallbacks) declaredField.get(null);
                if (componentCallbacks != null) {
                    declaredField.set(null, null);
                    Field declaredField2 = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
                    declaredField2.setAccessible(true);
                    Object obj = declaredField2.get(null);
                    if (obj != null) {
                        List list = (List) obj;
                        synchronized (list) {
                            list.remove(componentCallbacks);
                        }
                        return;
                    }
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        this.f369213d.destroy();
    }

    public static String getCrashExtraCacheInfo(Context context) {
        Map<String, Object> map;
        if (context == null) {
            return "";
        }
        String str = "tbs_core_version:" + QbSdk.getTbsVersionForCrash(context) + ";tbs_sdk_version:44357;";
        StringBuilder sb5 = new StringBuilder();
        sb5.append(g.a(true).f());
        sb5.append("\n");
        sb5.append(str);
        if (!TbsShareManager.isThirdPartyApp(context) && (map = QbSdk.f369007q) != null && map.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) && QbSdk.f369007q.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY)) {
            String str2 = "weapp_id:" + QbSdk.f369007q.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) + ";" + TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY + ":" + QbSdk.f369007q.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY) + ";";
            sb5.append("\n");
            sb5.append(str2);
        }
        if (sb5.length() > 8192) {
            return sb5.substring(sb5.length() - 8192);
        }
        return sb5.toString();
    }

    public static String getCrashExtraMessage(Context context) {
        Map<String, Object> map;
        if (context == null) {
            return "";
        }
        String str = "tbs_core_version:" + QbSdk.getTbsVersionForCrash(context) + ";tbs_sdk_version:44357;";
        StringBuilder sb5 = new StringBuilder();
        sb5.append(g.a(true).e());
        sb5.append("\n");
        sb5.append(str);
        if (!TbsShareManager.isThirdPartyApp(context) && (map = QbSdk.f369007q) != null && map.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) && QbSdk.f369007q.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY)) {
            String str2 = "weapp_id:" + QbSdk.f369007q.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) + ";" + TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY + ":" + QbSdk.f369007q.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY) + ";";
            sb5.append("\n");
            sb5.append(str2);
        }
        if (sb5.length() > 8192) {
            return sb5.substring(sb5.length() - 8192);
        }
        return sb5.toString();
    }

    public static PackageInfo getCurrentWebViewPackage() {
        if (p.a().b() || Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            return (PackageInfo) com.tencent.smtt.utils.k.a("android.webkit.WebView", "getCurrentWebViewPackage");
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public static synchronized Object getPluginList() {
        synchronized (WebView.class) {
            if (!p.a().b()) {
                return com.tencent.smtt.utils.k.a("android.webkit.WebView", "getPluginList");
            }
            return null;
        }
    }

    public static int getTbsCoreVersion(Context context) {
        return QbSdk.getTbsVersion(context);
    }

    public static boolean getTbsNeedReboot() {
        c();
        return g.a(true).g();
    }

    public static int getTbsSDKVersion(Context context) {
        return 44357;
    }

    private void h() {
        try {
            if ("com.xunmeng.pinduoduo".equals(this.f369216g.getApplicationInfo().packageName)) {
                new BaseThread("WebviewDestroy") { // from class: com.tencent.smtt.sdk.WebView.2
                    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
                    public void run() {
                        WebView.this.a(false);
                    }
                }.start();
                if (this.f369212c) {
                    this.f369213d.destroy();
                } else {
                    this.f369214e.destroy();
                }
            } else {
                a(true);
            }
        } catch (Throwable unused) {
            a(true);
        }
    }

    public static boolean hasCreatedSysWebViewInstance() {
        return mSysWebviewCreated;
    }

    private long i() {
        long j3;
        synchronized (QbSdk.f368999i) {
            if (QbSdk.f368996f) {
                QbSdk.f368998h += System.currentTimeMillis() - QbSdk.f368997g;
                TbsLog.d("sdkreport", "pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=" + QbSdk.f368998h);
            }
            j3 = QbSdk.f368998h / 1000;
            QbSdk.f368998h = 0L;
            QbSdk.f368997g = System.currentTimeMillis();
        }
        return j3;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void j() {
        Bundle sdkQBStatisticsInfo;
        Handler tbsLogHandler;
        Context applicationContext = this.f369216g.getApplicationContext();
        if (this.f369212c) {
            try {
                sdkQBStatisticsInfo = this.f369213d.getX5WebViewExtension().getSdkQBStatisticsInfo();
            } catch (Exception unused) {
            }
            Bundle bundle = sdkQBStatisticsInfo;
            long i3 = i();
            if (!this.f369218j && this.f369210a != 0) {
                synchronized (this) {
                    if (!this.f369218j && this.f369210a != 0) {
                    }
                    return;
                }
            }
            com.tencent.smtt.utils.h hVar = new com.tencent.smtt.utils.h(applicationContext, this.f369210a, this.f369212c, i3, bundle);
            tbsLogHandler = TbsLog.getTbsLogHandler();
            if (tbsLogHandler == null) {
                Message obtain = Message.obtain(tbsLogHandler, 501);
                obtain.obj = hVar;
                obtain.sendToTarget();
            } else {
                BaseThread baseThread = new BaseThread(hVar);
                baseThread.setName("TbsPV");
                baseThread.start();
            }
            this.f369218j = false;
            this.f369210a = 0;
        }
        sdkQBStatisticsInfo = null;
        Bundle bundle2 = sdkQBStatisticsInfo;
        long i36 = i();
        if (!this.f369218j) {
            synchronized (this) {
            }
        }
        com.tencent.smtt.utils.h hVar2 = new com.tencent.smtt.utils.h(applicationContext, this.f369210a, this.f369212c, i36, bundle2);
        tbsLogHandler = TbsLog.getTbsLogHandler();
        if (tbsLogHandler == null) {
        }
        this.f369218j = false;
        this.f369210a = 0;
    }

    public static void setDataDirectorySuffix(String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                com.tencent.smtt.utils.k.a(Class.forName("android.webkit.WebView"), "setDataDirectorySuffix", (Class<?>[]) new Class[]{String.class}, str);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data_directory_suffix", str);
        QbSdk.initTbsSettings(hashMap);
    }

    public static synchronized void setSysDayOrNight(boolean z16) {
        synchronized (WebView.class) {
            if (z16 == f369209v) {
                return;
            }
            f369209v = z16;
            if (f369208u == null) {
                Paint paint = new Paint();
                f369208u = paint;
                paint.setColor(-16777216);
            }
            if (!z16) {
                int alpha = f369208u.getAlpha();
                int i3 = NIGHT_MODE_ALPHA;
                if (alpha != i3) {
                    f369208u.setAlpha(i3);
                }
            } else if (f369208u.getAlpha() != 255) {
                f369208u.setAlpha(255);
            }
        }
    }

    public static void setWebContentsDebuggingEnabled(boolean z16) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            a16.c().a(z16);
            return;
        }
        try {
            Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", Boolean.TYPE);
            f369206l = declaredMethod;
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                f369206l.invoke(null, Boolean.valueOf(z16));
            }
        } catch (Exception e16) {
            TbsLog.e("QbSdk", "Exception:" + e16.getStackTrace());
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(android.webkit.WebView webView) {
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (!this.f369212c) {
            this.f369214e.addJavascriptInterface(obj, str);
        } else {
            this.f369213d.addJavascriptInterface(obj, str);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (!this.f369212c) {
            this.f369214e.addView(view);
            return;
        }
        View view2 = this.f369213d.getView();
        try {
            Method a16 = com.tencent.smtt.utils.k.a(view2, "addView", View.class);
            a16.setAccessible(true);
            a16.invoke(view2, view);
        } catch (Throwable unused) {
        }
    }

    public boolean canGoBack() {
        if (!this.f369212c) {
            return this.f369214e.canGoBack();
        }
        return this.f369213d.canGoBack();
    }

    public boolean canGoBackOrForward(int i3) {
        if (!this.f369212c) {
            return this.f369214e.canGoBackOrForward(i3);
        }
        return this.f369213d.canGoBackOrForward(i3);
    }

    public boolean canGoForward() {
        if (!this.f369212c) {
            return this.f369214e.canGoForward();
        }
        return this.f369213d.canGoForward();
    }

    @Deprecated
    public boolean canZoomIn() {
        if (!this.f369212c) {
            Object a16 = com.tencent.smtt.utils.k.a(this.f369214e, "canZoomIn");
            if (a16 == null) {
                return false;
            }
            return ((Boolean) a16).booleanValue();
        }
        return this.f369213d.canZoomIn();
    }

    @Deprecated
    public boolean canZoomOut() {
        if (!this.f369212c) {
            Object a16 = com.tencent.smtt.utils.k.a(this.f369214e, "canZoomOut");
            if (a16 == null) {
                return false;
            }
            return ((Boolean) a16).booleanValue();
        }
        return this.f369213d.canZoomOut();
    }

    @Deprecated
    public Picture capturePicture() {
        if (!this.f369212c) {
            Object a16 = com.tencent.smtt.utils.k.a(this.f369214e, "capturePicture");
            if (a16 == null) {
                return null;
            }
            return (Picture) a16;
        }
        return this.f369213d.capturePicture();
    }

    public void clearCache(boolean z16) {
        if (!this.f369212c) {
            this.f369214e.clearCache(z16);
        } else {
            this.f369213d.clearCache(z16);
        }
    }

    public void clearFormData() {
        if (!this.f369212c) {
            this.f369214e.clearFormData();
        } else {
            this.f369213d.clearFormData();
        }
    }

    public void clearHistory() {
        if (!this.f369212c) {
            this.f369214e.clearHistory();
        } else {
            this.f369213d.clearHistory();
        }
    }

    @TargetApi(3)
    public void clearMatches() {
        if (!this.f369212c) {
            this.f369214e.clearMatches();
        } else {
            this.f369213d.clearMatches();
        }
    }

    public void clearSslPreferences() {
        if (!this.f369212c) {
            this.f369214e.clearSslPreferences();
        } else {
            this.f369213d.clearSslPreferences();
        }
    }

    @Deprecated
    public void clearView() {
        if (!this.f369212c) {
            com.tencent.smtt.utils.k.a(this.f369214e, "clearView");
        } else {
            this.f369213d.clearView();
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        try {
            if (this.f369212c) {
                Method a16 = com.tencent.smtt.utils.k.a(this.f369213d.getView(), "computeHorizontalScrollExtent", new Class[0]);
                a16.setAccessible(true);
                return ((Integer) a16.invoke(this.f369213d.getView(), new Object[0])).intValue();
            }
            Method a17 = com.tencent.smtt.utils.k.a(this.f369214e, "computeHorizontalScrollExtent", new Class[0]);
            a17.setAccessible(true);
            return ((Integer) a17.invoke(this.f369214e, new Object[0])).intValue();
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        try {
            if (this.f369212c) {
                Method a16 = com.tencent.smtt.utils.k.a(this.f369213d.getView(), "computeHorizontalScrollOffset", new Class[0]);
                a16.setAccessible(true);
                return ((Integer) a16.invoke(this.f369213d.getView(), new Object[0])).intValue();
            }
            Method a17 = com.tencent.smtt.utils.k.a(this.f369214e, "computeHorizontalScrollOffset", new Class[0]);
            a17.setAccessible(true);
            return ((Integer) a17.invoke(this.f369214e, new Object[0])).intValue();
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        try {
            if (this.f369212c) {
                return ((Integer) com.tencent.smtt.utils.k.a(this.f369213d.getView(), "computeHorizontalScrollRange", (Class<?>[]) new Class[0], new Object[0])).intValue();
            }
            Method a16 = com.tencent.smtt.utils.k.a(this.f369214e, "computeHorizontalScrollRange", new Class[0]);
            a16.setAccessible(true);
            return ((Integer) a16.invoke(this.f369214e, new Object[0])).intValue();
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.f369212c) {
            this.f369214e.computeScroll();
        } else {
            this.f369213d.computeScroll();
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        try {
            if (this.f369212c) {
                Method a16 = com.tencent.smtt.utils.k.a(this.f369213d.getView(), "computeVerticalScrollExtent", new Class[0]);
                a16.setAccessible(true);
                return ((Integer) a16.invoke(this.f369213d.getView(), new Object[0])).intValue();
            }
            Method a17 = com.tencent.smtt.utils.k.a(this.f369214e, "computeVerticalScrollExtent", new Class[0]);
            a17.setAccessible(true);
            return ((Integer) a17.invoke(this.f369214e, new Object[0])).intValue();
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        try {
            if (this.f369212c) {
                Method a16 = com.tencent.smtt.utils.k.a(this.f369213d.getView(), "computeVerticalScrollOffset", new Class[0]);
                a16.setAccessible(true);
                return ((Integer) a16.invoke(this.f369213d.getView(), new Object[0])).intValue();
            }
            Method a17 = com.tencent.smtt.utils.k.a(this.f369214e, "computeVerticalScrollOffset", new Class[0]);
            a17.setAccessible(true);
            return ((Integer) a17.invoke(this.f369214e, new Object[0])).intValue();
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        try {
            if (this.f369212c) {
                return ((Integer) com.tencent.smtt.utils.k.a(this.f369213d.getView(), "computeVerticalScrollRange", (Class<?>[]) new Class[0], new Object[0])).intValue();
            }
            Method a16 = com.tencent.smtt.utils.k.a(this.f369214e, "computeVerticalScrollRange", new Class[0]);
            a16.setAccessible(true);
            return ((Integer) a16.invoke(this.f369214e, new Object[0])).intValue();
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    public WebBackForwardList copyBackForwardList() {
        if (this.f369212c) {
            return WebBackForwardList.a(this.f369213d.copyBackForwardList());
        }
        return WebBackForwardList.a(this.f369214e.copyBackForwardList());
    }

    public Object createPrintDocumentAdapter(String str) {
        if (this.f369212c) {
            try {
                return this.f369213d.createPrintDocumentAdapter(str);
            } catch (Throwable th5) {
                th5.printStackTrace();
                return null;
            }
        }
        return com.tencent.smtt.utils.k.a(this.f369214e, "createPrintDocumentAdapter", (Class<?>[]) new Class[]{String.class}, str);
    }

    public void customDiskCachePathEnabled(boolean z16, String str) {
        if (this.f369212c && getX5WebViewExtension() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(NodeProps.ENABLED, z16);
            bundle.putString("path", str);
            getX5WebViewExtension().invokeMiscMethod("customDiskCachePathEnabled", bundle);
        }
    }

    public void destroy() {
        this.f369219k = false;
        try {
            this.f369216g.getApplicationInfo().packageName.contains(QZoneHelper.PACKAGENAME_QQMUSIC);
        } catch (Throwable th5) {
            TbsLog.i("webview", "stack is " + Log.getStackTraceString(th5));
        }
        TbsLog.i("webview", "destroy forceDestoyOld is false");
        g();
    }

    public void documentHasImages(Message message) {
        if (!this.f369212c) {
            this.f369214e.documentHasImages(message);
        } else {
            this.f369213d.documentHasImages(message);
        }
    }

    public void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i3) {
        if (!this.f369212c) {
            com.tencent.smtt.utils.k.a(this.f369214e, "dumpViewHierarchyWithProperties", (Class<?>[]) new Class[]{BufferedWriter.class, Integer.TYPE}, bufferedWriter, Integer.valueOf(i3));
        } else {
            this.f369213d.dumpViewHierarchyWithProperties(bufferedWriter, i3);
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (this.f369212c) {
            try {
                Method a16 = com.tencent.smtt.utils.k.a(this.f369213d.getView(), DebugUtils.Command.EVALUATE_JAVASCRIPT, String.class, android.webkit.ValueCallback.class);
                a16.setAccessible(true);
                a16.invoke(this.f369213d.getView(), str, valueCallback);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                loadUrl(str);
                return;
            }
        }
        try {
            Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod(DebugUtils.Command.EVALUATE_JAVASCRIPT, String.class, android.webkit.ValueCallback.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.f369214e, str, valueCallback);
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    @Deprecated
    public int findAll(String str) {
        if (!this.f369212c) {
            Object a16 = com.tencent.smtt.utils.k.a(this.f369214e, "findAll", (Class<?>[]) new Class[]{String.class}, str);
            if (a16 == null) {
                return 0;
            }
            return ((Integer) a16).intValue();
        }
        return this.f369213d.findAll(str);
    }

    @TargetApi(16)
    public void findAllAsync(String str) {
        if (!this.f369212c) {
            com.tencent.smtt.utils.k.a(this.f369214e, "findAllAsync", (Class<?>[]) new Class[]{String.class}, str);
        } else {
            this.f369213d.findAllAsync(str);
        }
    }

    public View findHierarchyView(String str, int i3) {
        if (!this.f369212c) {
            return (View) com.tencent.smtt.utils.k.a(this.f369214e, "findHierarchyView", (Class<?>[]) new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i3));
        }
        return this.f369213d.findHierarchyView(str, i3);
    }

    @TargetApi(3)
    public void findNext(boolean z16) {
        if (!this.f369212c) {
            this.f369214e.findNext(z16);
        } else {
            this.f369213d.findNext(z16);
        }
    }

    public void flingScroll(int i3, int i16) {
        if (!this.f369212c) {
            this.f369214e.flingScroll(i3, i16);
        } else {
            this.f369213d.flingScroll(i3, i16);
        }
    }

    @Deprecated
    public void freeMemory() {
        if (!this.f369212c) {
            com.tencent.smtt.utils.k.a(this.f369214e, "freeMemory");
        } else {
            this.f369213d.freeMemory();
        }
    }

    public SslCertificate getCertificate() {
        if (!this.f369212c) {
            return this.f369214e.getCertificate();
        }
        return this.f369213d.getCertificate();
    }

    public int getContentHeight() {
        if (!this.f369212c) {
            return this.f369214e.getContentHeight();
        }
        return this.f369213d.getContentHeight();
    }

    public int getContentWidth() {
        if (!this.f369212c) {
            Object a16 = com.tencent.smtt.utils.k.a(this.f369214e, "getContentWidth");
            if (a16 == null) {
                return 0;
            }
            return ((Integer) a16).intValue();
        }
        return this.f369213d.getContentWidth();
    }

    public Bitmap getFavicon() {
        if (!this.f369212c) {
            return this.f369214e.getFavicon();
        }
        return this.f369213d.getFavicon();
    }

    public HitTestResult getHitTestResult() {
        if (!this.f369212c) {
            return new HitTestResult(this.f369214e.getHitTestResult());
        }
        return new HitTestResult(this.f369213d.getHitTestResult());
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        if (!this.f369212c) {
            return this.f369214e.getHttpAuthUsernamePassword(str, str2);
        }
        return this.f369213d.getHttpAuthUsernamePassword(str, str2);
    }

    public boolean getIsX5Core() {
        return this.f369212c;
    }

    @TargetApi(3)
    public String getOriginalUrl() {
        if (!this.f369212c) {
            return this.f369214e.getOriginalUrl();
        }
        return this.f369213d.getOriginalUrl();
    }

    public TbsWebViewPerformanceRecorder getPerformanceRecorder() {
        return this.f369217h;
    }

    public int getProgress() {
        if (!this.f369212c) {
            return this.f369214e.getProgress();
        }
        return this.f369213d.getProgress();
    }

    public boolean getRendererPriorityWaivedWhenNotVisible() {
        Object a16;
        try {
            if (!this.f369212c && Build.VERSION.SDK_INT >= 26 && (a16 = com.tencent.smtt.utils.k.a(this.f369214e, "getRendererPriorityWaivedWhenNotVisible")) != null) {
                return ((Boolean) a16).booleanValue();
            }
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public int getRendererRequestedPriority() {
        Object a16;
        try {
            if (!this.f369212c && Build.VERSION.SDK_INT >= 26 && (a16 = com.tencent.smtt.utils.k.a(this.f369214e, "getRendererRequestedPriority")) != null) {
                return ((Integer) a16).intValue();
            }
            return 0;
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Deprecated
    public float getScale() {
        if (!this.f369212c) {
            Object a16 = com.tencent.smtt.utils.k.a(this.f369214e, "getScale");
            if (a16 == null) {
                return 0.0f;
            }
            return ((Float) a16).floatValue();
        }
        return this.f369213d.getScale();
    }

    @Override // android.view.View
    public int getScrollBarDefaultDelayBeforeFade() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarDefaultDelayBeforeFade();
    }

    @Override // android.view.View
    public int getScrollBarFadeDuration() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarFadeDuration();
    }

    @Override // android.view.View
    public int getScrollBarSize() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarSize();
    }

    @Override // android.view.View
    public int getScrollBarStyle() {
        if (getView() == null) {
            return 0;
        }
        return getView().getScrollBarStyle();
    }

    public WebSettings getSettings() {
        WebSettings webSettings = this.f369215f;
        if (webSettings != null) {
            return webSettings;
        }
        if (this.f369212c) {
            WebSettings webSettings2 = new WebSettings(this.f369213d.getSettings());
            this.f369215f = webSettings2;
            return webSettings2;
        }
        WebSettings webSettings3 = new WebSettings(this.f369214e.getSettings());
        this.f369215f = webSettings3;
        return webSettings3;
    }

    public IX5WebSettingsExtension getSettingsExtension() {
        if (!this.f369212c) {
            return null;
        }
        return this.f369213d.getX5WebViewExtension().getSettingsExtension();
    }

    public int getSysNightModeAlpha() {
        return NIGHT_MODE_ALPHA;
    }

    public String getTitle() {
        if (!this.f369212c) {
            return this.f369214e.getTitle();
        }
        return this.f369213d.getTitle();
    }

    public String getUrl() {
        if (!this.f369212c) {
            return this.f369214e.getUrl();
        }
        return this.f369213d.getUrl();
    }

    public View getView() {
        if (!this.f369212c) {
            return this.f369214e;
        }
        return this.f369213d.getView();
    }

    public int getVisibleTitleHeight() {
        if (!this.f369212c) {
            Object a16 = com.tencent.smtt.utils.k.a(this.f369214e, "getVisibleTitleHeight");
            if (a16 == null) {
                return 0;
            }
            return ((Integer) a16).intValue();
        }
        return this.f369213d.getVisibleTitleHeight();
    }

    public WebChromeClient getWebChromeClient() {
        return this.f369221n;
    }

    public IX5WebChromeClientExtension getWebChromeClientExtension() {
        if (!this.f369212c) {
            return null;
        }
        return this.f369213d.getX5WebViewExtension().getWebChromeClientExtension();
    }

    public int getWebScrollX() {
        if (this.f369212c) {
            return this.f369213d.getView().getScrollX();
        }
        return this.f369214e.getScrollX();
    }

    public int getWebScrollY() {
        if (this.f369212c) {
            return this.f369213d.getView().getScrollY();
        }
        return this.f369214e.getScrollY();
    }

    public WebViewClient getWebViewClient() {
        return this.f369220m;
    }

    public IX5WebViewClientExtension getWebViewClientExtension() {
        if (!this.f369212c) {
            return null;
        }
        return this.f369213d.getX5WebViewExtension().getWebViewClientExtension();
    }

    public IX5WebViewBase.HitTestResult getX5HitTestResult() {
        if (!this.f369212c) {
            return null;
        }
        return this.f369213d.getHitTestResult();
    }

    public IX5WebViewExtension getX5WebViewExtension() {
        if (!this.f369212c) {
            return null;
        }
        return this.f369213d.getX5WebViewExtension();
    }

    @Deprecated
    public View getZoomControls() {
        if (!this.f369212c) {
            return (View) com.tencent.smtt.utils.k.a(this.f369214e, "getZoomControls");
        }
        return this.f369213d.getZoomControls();
    }

    public void goBack() {
        if (!this.f369212c) {
            this.f369214e.goBack();
        } else {
            this.f369213d.goBack();
        }
    }

    public void goBackOrForward(int i3) {
        if (!this.f369212c) {
            this.f369214e.goBackOrForward(i3);
        } else {
            this.f369213d.goBackOrForward(i3);
        }
    }

    public void goForward() {
        if (!this.f369212c) {
            this.f369214e.goForward();
        } else {
            this.f369213d.goForward();
        }
    }

    public void invokeZoomPicker() {
        if (!this.f369212c) {
            this.f369214e.invokeZoomPicker();
        } else {
            this.f369213d.invokeZoomPicker();
        }
    }

    public boolean isDayMode() {
        return f369209v;
    }

    public boolean isPrivateBrowsingEnabled() {
        if (!this.f369212c) {
            Object a16 = com.tencent.smtt.utils.k.a(this.f369214e, "isPrivateBrowsingEnabled");
            if (a16 == null) {
                return false;
            }
            return ((Boolean) a16).booleanValue();
        }
        return this.f369213d.isPrivateBrowsingEnable();
    }

    public void loadData(String str, String str2, String str3) {
        if (!this.f369212c) {
            this.f369214e.loadData(str, str2, str3);
        } else {
            this.f369213d.loadData(str, str2, str3);
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!this.f369212c) {
            this.f369214e.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            this.f369213d.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @TargetApi(8)
    public void loadUrl(String str, Map<String, String> map) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || showDebugView(str)) {
            return;
        }
        if (!this.f369212c) {
            this.f369214e.loadUrl(str, map);
        } else {
            this.f369213d.loadUrl(str, map);
        }
        this.f369217h.recordUrlLoadTime(System.currentTimeMillis() - currentTimeMillis, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!this.f369218j && this.f369210a != 0) {
            j();
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        boolean a16;
        EventCollector.getInstance().onViewLongClickedBefore(view);
        View.OnLongClickListener onLongClickListener = this.f369228x;
        if (onLongClickListener != null) {
            if (!onLongClickListener.onLongClick(view)) {
                a16 = a(view);
            } else {
                a16 = true;
            }
        } else {
            a16 = a(view);
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return a16;
    }

    public void onPause() {
        if (!this.f369212c) {
            com.tencent.smtt.utils.k.a(this.f369214e, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        } else {
            this.f369213d.onPause();
        }
    }

    public void onResume() {
        if (!this.f369212c) {
            com.tencent.smtt.utils.k.a(this.f369214e, "onResume");
        } else {
            this.f369213d.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    @TargetApi(11)
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (a(this.f369216g) && isHardwareAccelerated() && i3 > 0 && i16 > 0) {
            getLayerType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onVisibilityChanged(View view, int i3) {
        Context context = this.f369216g;
        if (context == null) {
            super.onVisibilityChanged(view, i3);
            return;
        }
        if (f369207o == null) {
            f369207o = context.getApplicationInfo().packageName;
        }
        String str = f369207o;
        if (str != null && (str.equals("com.tencent.mm") || f369207o.equals("com.tencent.mobileqq"))) {
            super.onVisibilityChanged(view, i3);
            return;
        }
        if (i3 != 0 && !this.f369218j && this.f369210a != 0) {
            j();
        }
        super.onVisibilityChanged(view, i3);
    }

    public boolean overlayHorizontalScrollbar() {
        if (!this.f369212c) {
            return this.f369214e.overlayHorizontalScrollbar();
        }
        return this.f369213d.overlayHorizontalScrollbar();
    }

    public boolean overlayVerticalScrollbar() {
        if (this.f369212c) {
            return this.f369213d.overlayVerticalScrollbar();
        }
        return this.f369214e.overlayVerticalScrollbar();
    }

    public boolean pageDown(boolean z16) {
        if (!this.f369212c) {
            return this.f369214e.pageDown(z16);
        }
        return this.f369213d.pageDown(z16, -1);
    }

    public boolean pageUp(boolean z16) {
        if (!this.f369212c) {
            return this.f369214e.pageUp(z16);
        }
        return this.f369213d.pageUp(z16, -1);
    }

    public void pauseTimers() {
        if (!this.f369212c) {
            this.f369214e.pauseTimers();
        } else {
            this.f369213d.pauseTimers();
        }
    }

    @TargetApi(5)
    public void postUrl(String str, byte[] bArr) {
        if (!this.f369212c) {
            this.f369214e.postUrl(str, bArr);
        } else {
            this.f369213d.postUrl(str, bArr);
        }
    }

    @Deprecated
    public void refreshPlugins(boolean z16) {
        if (!this.f369212c) {
            com.tencent.smtt.utils.k.a(this.f369214e, "refreshPlugins", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z16));
        } else {
            this.f369213d.refreshPlugins(z16);
        }
    }

    public void reload() {
        if (!this.f369212c) {
            this.f369214e.reload();
        } else {
            this.f369213d.reload();
        }
    }

    @TargetApi(11)
    public void removeJavascriptInterface(String str) {
        if (!this.f369212c) {
            com.tencent.smtt.utils.k.a(this.f369214e, "removeJavascriptInterface", (Class<?>[]) new Class[]{String.class}, str);
        } else {
            this.f369213d.removeJavascriptInterface(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (!this.f369212c) {
            this.f369214e.removeView(view);
            return;
        }
        View view2 = this.f369213d.getView();
        try {
            Method a16 = com.tencent.smtt.utils.k.a(view2, "removeView", View.class);
            a16.setAccessible(true);
            a16.invoke(view2, view);
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public JSONObject reportInitPerformance(long j3, int i3, long j16, long j17) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z16) {
        if (this.f369212c) {
            View view2 = this.f369213d.getView();
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                if (view == this) {
                    view = view2;
                }
                return viewGroup.requestChildRectangleOnScreen(view, rect, z16);
            }
            return false;
        }
        a aVar = this.f369214e;
        if (view == this) {
            view = aVar;
        }
        return aVar.requestChildRectangleOnScreen(view, rect, z16);
    }

    public void requestFocusNodeHref(Message message) {
        if (!this.f369212c) {
            this.f369214e.requestFocusNodeHref(message);
        } else {
            this.f369213d.requestFocusNodeHref(message);
        }
    }

    public void requestImageRef(Message message) {
        if (!this.f369212c) {
            this.f369214e.requestImageRef(message);
        } else {
            this.f369213d.requestImageRef(message);
        }
    }

    @Deprecated
    public boolean restorePicture(Bundle bundle, File file) {
        if (!this.f369212c) {
            Object a16 = com.tencent.smtt.utils.k.a(this.f369214e, "restorePicture", (Class<?>[]) new Class[]{Bundle.class, File.class}, bundle, file);
            if (a16 == null) {
                return false;
            }
            return ((Boolean) a16).booleanValue();
        }
        return this.f369213d.restorePicture(bundle, file);
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        if (!this.f369212c) {
            return WebBackForwardList.a(this.f369214e.restoreState(bundle));
        }
        return WebBackForwardList.a(this.f369213d.restoreState(bundle));
    }

    public void resumeTimers() {
        if (!this.f369212c) {
            this.f369214e.resumeTimers();
        } else {
            this.f369213d.resumeTimers();
        }
    }

    @Deprecated
    public void savePassword(String str, String str2, String str3) {
        if (!this.f369212c) {
            com.tencent.smtt.utils.k.a(this.f369214e, "savePassword", (Class<?>[]) new Class[]{String.class, String.class, String.class}, str, str2, str3);
        } else {
            this.f369213d.savePassword(str, str2, str3);
        }
    }

    @Deprecated
    public boolean savePicture(Bundle bundle, File file) {
        if (!this.f369212c) {
            Object a16 = com.tencent.smtt.utils.k.a(this.f369214e, "savePicture", (Class<?>[]) new Class[]{Bundle.class, File.class}, bundle, file);
            if (a16 == null) {
                return false;
            }
            return ((Boolean) a16).booleanValue();
        }
        return this.f369213d.savePicture(bundle, file);
    }

    public WebBackForwardList saveState(Bundle bundle) {
        if (!this.f369212c) {
            return WebBackForwardList.a(this.f369214e.saveState(bundle));
        }
        return WebBackForwardList.a(this.f369213d.saveState(bundle));
    }

    @TargetApi(11)
    public void saveWebArchive(String str) {
        if (!this.f369212c) {
            com.tencent.smtt.utils.k.a(this.f369214e, "saveWebArchive", (Class<?>[]) new Class[]{String.class}, str);
        } else {
            this.f369213d.saveWebArchive(str);
        }
    }

    public void setARModeEnable(boolean z16) {
        try {
            if (this.f369212c) {
                getSettingsExtension().setARModeEnable(z16);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        if (!this.f369212c) {
            this.f369214e.setBackgroundColor(i3);
        } else {
            this.f369213d.setBackgroundColor(i3);
        }
        super.setBackgroundColor(i3);
    }

    @Deprecated
    public void setCertificate(SslCertificate sslCertificate) {
        if (!this.f369212c) {
            this.f369214e.setCertificate(sslCertificate);
        } else {
            this.f369213d.setCertificate(sslCertificate);
        }
    }

    public void setDayOrNight(boolean z16) {
        try {
            if (this.f369212c) {
                getSettingsExtension().setDayOrNight(z16);
            }
            setSysDayOrNight(z16);
            getView().postInvalidate();
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void setDownloadListener(final DownloadListener downloadListener) {
        boolean z16 = this.f369212c;
        if (!z16) {
            this.f369214e.setDownloadListener(new android.webkit.DownloadListener() { // from class: com.tencent.smtt.sdk.WebView.4
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str, String str2, String str3, String str4, long j3) {
                    ApplicationInfo applicationInfo;
                    DownloadListener downloadListener2 = downloadListener;
                    if (downloadListener2 == null) {
                        if (WebView.this.f369216g == null) {
                            applicationInfo = null;
                        } else {
                            applicationInfo = WebView.this.f369216g.getApplicationInfo();
                        }
                        if (applicationInfo == null || !"com.tencent.mm".equals(applicationInfo.packageName)) {
                            MttLoader.loadUrl(WebView.this.f369216g, str, null, null);
                            return;
                        }
                        return;
                    }
                    downloadListener2.onDownloadStart(str, str2, str3, str4, j3);
                }
            });
        } else {
            this.f369213d.setDownloadListener(new b(this, downloadListener, z16));
        }
    }

    @TargetApi(16)
    public void setFindListener(final IX5WebViewBase.FindListener findListener) {
        if (!this.f369212c) {
            this.f369214e.setFindListener(new WebView.FindListener() { // from class: com.tencent.smtt.sdk.WebView.3
                @Override // android.webkit.WebView.FindListener
                public void onFindResultReceived(int i3, int i16, boolean z16) {
                    findListener.onFindResultReceived(i3, i16, z16);
                }
            });
        } else {
            this.f369213d.setFindListener(findListener);
        }
    }

    public void setHorizontalScrollbarOverlay(boolean z16) {
        if (!this.f369212c) {
            this.f369214e.setHorizontalScrollbarOverlay(z16);
        } else {
            this.f369213d.setHorizontalScrollbarOverlay(z16);
        }
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        if (!this.f369212c) {
            this.f369214e.setHttpAuthUsernamePassword(str, str2, str3, str4);
        } else {
            this.f369213d.setHttpAuthUsernamePassword(str, str2, str3, str4);
        }
    }

    public void setInitialScale(int i3) {
        if (!this.f369212c) {
            this.f369214e.setInitialScale(i3);
        } else {
            this.f369213d.setInitialScale(i3);
        }
    }

    @Deprecated
    public void setMapTrackballToArrowKeys(boolean z16) {
        if (!this.f369212c) {
            com.tencent.smtt.utils.k.a(this.f369214e, "setMapTrackballToArrowKeys", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z16));
        } else {
            this.f369213d.setMapTrackballToArrowKeys(z16);
        }
    }

    public void setNetworkAvailable(boolean z16) {
        if (!this.f369212c) {
            this.f369214e.setNetworkAvailable(z16);
        } else {
            this.f369213d.setNetworkAvailable(z16);
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        if (!this.f369212c) {
            this.f369214e.setOnLongClickListener(onLongClickListener);
            return;
        }
        View view = this.f369213d.getView();
        try {
            if (this.f369227w == null) {
                Method a16 = com.tencent.smtt.utils.k.a(view, "getListenerInfo", new Class[0]);
                a16.setAccessible(true);
                Object invoke = a16.invoke(view, null);
                Field declaredField = invoke.getClass().getDeclaredField("mOnLongClickListener");
                declaredField.setAccessible(true);
                this.f369227w = declaredField.get(invoke);
            }
            this.f369228x = onLongClickListener;
            getView().setOnLongClickListener(this);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        getView().setOnTouchListener(onTouchListener);
    }

    @Deprecated
    public void setPictureListener(final PictureListener pictureListener) {
        if (!this.f369212c) {
            if (pictureListener == null) {
                this.f369214e.setPictureListener(null);
                return;
            } else {
                this.f369214e.setPictureListener(new WebView.PictureListener() { // from class: com.tencent.smtt.sdk.WebView.5
                    @Override // android.webkit.WebView.PictureListener
                    public void onNewPicture(android.webkit.WebView webView, Picture picture) {
                        WebView.this.a(webView);
                        pictureListener.onNewPicture(WebView.this, picture);
                    }
                });
                return;
            }
        }
        if (pictureListener == null) {
            this.f369213d.setPictureListener(null);
        } else {
            this.f369213d.setPictureListener(new IX5WebViewBase.PictureListener() { // from class: com.tencent.smtt.sdk.WebView.6
                @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener
                public void onNewPicture(IX5WebViewBase iX5WebViewBase, Picture picture, boolean z16) {
                    WebView.this.a(iX5WebViewBase);
                    pictureListener.onNewPicture(WebView.this, picture);
                }

                @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener
                public void onNewPictureIfHaveContent(IX5WebViewBase iX5WebViewBase, Picture picture) {
                }
            });
        }
    }

    public void setRendererPriorityPolicy(int i3, boolean z16) {
        try {
            if (this.f369212c || Build.VERSION.SDK_INT < 26) {
                return;
            }
            com.tencent.smtt.utils.k.a(this.f369214e, "setRendererPriorityPolicy", (Class<?>[]) new Class[]{Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i3), Boolean.valueOf(z16));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.view.View
    public void setScrollBarStyle(int i3) {
        if (this.f369212c) {
            this.f369213d.getView().setScrollBarStyle(i3);
        } else {
            this.f369214e.setScrollBarStyle(i3);
        }
    }

    public void setSysNightModeAlpha(int i3) {
        NIGHT_MODE_ALPHA = i3;
    }

    public void setVerticalScrollbarOverlay(boolean z16) {
        if (!this.f369212c) {
            this.f369214e.setVerticalScrollbarOverlay(z16);
        } else {
            this.f369213d.setVerticalScrollbarOverlay(z16);
        }
    }

    public boolean setVideoFullScreen(Context context, boolean z16) {
        if (context.getApplicationInfo().processName.contains(SDKConst.SELF_PACKAGENAME) && this.f369213d != null) {
            Bundle bundle = new Bundle();
            if (z16) {
                bundle.putInt("DefaultVideoScreen", 2);
            } else {
                bundle.putInt("DefaultVideoScreen", 1);
            }
            this.f369213d.getX5WebViewExtension().invokeMiscMethod("setVideoParams", bundle);
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        if (getView() == null) {
            return;
        }
        getView().setVisibility(i3);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        i iVar = null;
        if (this.f369212c) {
            IX5WebViewBase iX5WebViewBase = this.f369213d;
            if (webChromeClient != null) {
                iVar = new i(p.a().a(true).i(), this, webChromeClient);
            }
            iX5WebViewBase.setWebChromeClient(iVar);
        } else if (webChromeClient != null) {
            if (a(webChromeClient)) {
                this.f369214e.setWebChromeClient(new c(this, webChromeClient));
            } else {
                this.f369214e.setWebChromeClient(new SystemWebChromeClient(this, webChromeClient));
            }
        } else {
            this.f369214e.setWebChromeClient(null);
        }
        this.f369221n = webChromeClient;
    }

    public void setWebChromeClientExtension(IX5WebChromeClientExtension iX5WebChromeClientExtension) {
        if (!this.f369212c) {
            return;
        }
        this.f369213d.getX5WebViewExtension().setWebChromeClientExtension(iX5WebChromeClientExtension);
    }

    public void setWebViewCallbackClient(WebViewCallbackClient webViewCallbackClient) {
        this.mWebViewCallbackClient = webViewCallbackClient;
        if (this.f369212c && getX5WebViewExtension() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("flag", true);
            getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", bundle);
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        SystemWebViewClient systemWebViewClient = null;
        j jVar = null;
        if (this.f369212c) {
            IX5WebViewBase iX5WebViewBase = this.f369213d;
            if (webViewClient != null) {
                jVar = new j(p.a().a(true).j(), this, webViewClient);
            }
            iX5WebViewBase.setWebViewClient(jVar);
        } else {
            a aVar = this.f369214e;
            if (webViewClient != null) {
                systemWebViewClient = new SystemWebViewClient(this, webViewClient);
            }
            aVar.setWebViewClient(systemWebViewClient);
        }
        this.f369220m = webViewClient;
    }

    public void setWebViewClientExtension(IX5WebViewClientExtension iX5WebViewClientExtension) {
        if (!this.f369212c) {
            return;
        }
        this.f369213d.getX5WebViewExtension().setWebViewClientExtension(iX5WebViewClientExtension);
    }

    @SuppressLint({"NewApi"})
    public boolean showDebugView(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("https://debugtbs.qq.com")) {
            getView().setVisibility(4);
            com.tencent.smtt.utils.d.a(this.f369216g).a(lowerCase, this, this.f369216g, null);
            return true;
        }
        if (lowerCase.startsWith("https://debugx5.qq.com")) {
            if (this.f369212c) {
                return false;
            }
            loadDataWithBaseURL(null, "<!DOCTYPE html><html><body><head><title>\u65e0\u6cd5\u6253\u5f00debugx5</title><meta name=\"viewport\" content=\"width=device-width, user-scalable=no\" /></head><br/><br /><h2>debugx5\u9875\u9762\u4ec5\u5728\u4f7f\u7528\u4e86X5\u5185\u6838\u65f6\u6709\u6548\uff0c\u7531\u4e8e\u5f53\u524d\u6ca1\u6709\u4f7f\u7528X5\u5185\u6838\uff0c\u65e0\u6cd5\u6253\u5f00debugx5\uff01</h2><br />\u5c1d\u8bd5<a href=\"https://debugtbs.qq.com?10000\">\u8fdb\u5165DebugTbs\u5b89\u88c5\u6216\u6253\u5f00X5\u5185\u6838</a></body></html>", "text/html", "utf-8", null);
            return true;
        }
        if (!lowerCase.startsWith("http://debugtmf.qq.com")) {
            return false;
        }
        getView().setVisibility(4);
        com.tencent.smtt.sdk.plugin.c.a(this, this.f369216g);
        return true;
    }

    public boolean showFindDialog(String str, boolean z16) {
        return false;
    }

    public void stopLoading() {
        if (!this.f369212c) {
            this.f369214e.stopLoading();
        } else {
            this.f369213d.stopLoading();
        }
    }

    public void super_computeScroll() {
        if (!this.f369212c) {
            this.f369214e.a();
            return;
        }
        try {
            com.tencent.smtt.utils.k.a(this.f369213d.getView(), "super_computeScroll");
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.f369212c) {
            return this.f369214e.b(motionEvent);
        }
        try {
            Object a16 = com.tencent.smtt.utils.k.a(this.f369213d.getView(), "super_dispatchTouchEvent", (Class<?>[]) new Class[]{MotionEvent.class}, motionEvent);
            if (a16 == null) {
                return false;
            }
            return ((Boolean) a16).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f369212c) {
            return this.f369214e.c(motionEvent);
        }
        try {
            Object a16 = com.tencent.smtt.utils.k.a(this.f369213d.getView(), "super_onInterceptTouchEvent", (Class<?>[]) new Class[]{MotionEvent.class}, motionEvent);
            if (a16 == null) {
                return false;
            }
            return ((Boolean) a16).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void super_onOverScrolled(int i3, int i16, boolean z16, boolean z17) {
        if (!this.f369212c) {
            this.f369214e.a(i3, i16, z16, z17);
            return;
        }
        View view = this.f369213d.getView();
        try {
            Class cls = Integer.TYPE;
            Class cls2 = Boolean.TYPE;
            com.tencent.smtt.utils.k.a(view, "super_onOverScrolled", (Class<?>[]) new Class[]{cls, cls, cls2, cls2}, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17));
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void super_onScrollChanged(int i3, int i16, int i17, int i18) {
        if (!this.f369212c) {
            this.f369214e.a(i3, i16, i17, i18);
            return;
        }
        View view = this.f369213d.getView();
        try {
            Class cls = Integer.TYPE;
            com.tencent.smtt.utils.k.a(view, "super_onScrollChanged", (Class<?>[]) new Class[]{cls, cls, cls, cls}, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent) {
        if (!this.f369212c) {
            return this.f369214e.a(motionEvent);
        }
        try {
            Object a16 = com.tencent.smtt.utils.k.a(this.f369213d.getView(), "super_onTouchEvent", (Class<?>[]) new Class[]{MotionEvent.class}, motionEvent);
            if (a16 == null) {
                return false;
            }
            return ((Boolean) a16).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean super_overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16) {
        if (!this.f369212c) {
            return this.f369214e.a(i3, i16, i17, i18, i19, i26, i27, i28, z16);
        }
        View view = this.f369213d.getView();
        try {
            Class cls = Integer.TYPE;
            Object a16 = com.tencent.smtt.utils.k.a(view, "super_overScrollBy", (Class<?>[]) new Class[]{cls, cls, cls, cls, cls, cls, cls, cls, Boolean.TYPE}, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Boolean.valueOf(z16));
            if (a16 == null) {
                return false;
            }
            return ((Boolean) a16).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public void switchNightMode(boolean z16) {
        if (z16 == f369209v) {
            return;
        }
        f369209v = z16;
        if (z16) {
            TbsLog.e("QB_SDK", "deleteNightMode");
            loadUrl("javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));");
        } else {
            TbsLog.e("QB_SDK", "nightMode");
            loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        }
    }

    public void switchToNightMode() {
        TbsLog.e("QB_SDK", "switchToNightMode 01");
        if (!f369209v) {
            TbsLog.e("QB_SDK", "switchToNightMode");
            loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        }
    }

    public boolean zoomIn() {
        if (!this.f369212c) {
            return this.f369214e.zoomIn();
        }
        return this.f369213d.zoomIn();
    }

    public boolean zoomOut() {
        if (!this.f369212c) {
            return this.f369214e.zoomOut();
        }
        return this.f369213d.zoomOut();
    }

    private void b(Context context) {
        p a16 = p.a();
        if (QbSdk.f369008r) {
            long currentTimeMillis = System.currentTimeMillis();
            a16.a(context);
            this.f369217h.recordCoreInitTime(System.currentTimeMillis() - currentTimeMillis);
        } else {
            TbsLog.w("WebView", "not Enable WebView init Wait X5.");
        }
        boolean b16 = a16.b();
        this.f369212c = b16;
        if (b16 || QbSdk.f369008r) {
            return;
        }
        TbsLog.w("WebView", "engine status: " + a16.e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        try {
            new BaseThread(new Runnable() { // from class: com.tencent.smtt.sdk.WebView.7
                @Override // java.lang.Runnable
                public void run() {
                    if (WebView.f369205i == null) {
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
                        return;
                    }
                    g a16 = g.a(true);
                    if (g.f369356b) {
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
                        return;
                    }
                    m a17 = m.a(WebView.f369205i);
                    int c16 = a17.c();
                    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = " + c16);
                    if (c16 == 2) {
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
                        a16.a(String.valueOf(a17.b()));
                        a16.b(true);
                        return;
                    }
                    int b16 = a17.b("copy_status");
                    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = " + b16);
                    if (b16 == 1) {
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
                        a16.a(String.valueOf(a17.c("copy_core_ver")));
                        a16.b(true);
                    } else if (!p.a().b()) {
                        if (c16 == 3 || b16 == 3) {
                            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
                            a16.a(String.valueOf(g.d()));
                            a16.b(true);
                        }
                    }
                }
            }).start();
        } catch (Throwable th5) {
            TbsLog.e("webview", "updateRebootStatus excpetion: " + th5);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class HitTestResult {

        @Deprecated
        public static final int ANCHOR_TYPE = 1;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;

        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int IMAGE_TYPE = 5;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int UNKNOWN_TYPE = 0;

        /* renamed from: a, reason: collision with root package name */
        private IX5WebViewBase.HitTestResult f369239a;

        /* renamed from: b, reason: collision with root package name */
        private WebView.HitTestResult f369240b;

        public HitTestResult() {
            this.f369239a = null;
            this.f369240b = null;
        }

        public String getExtra() {
            IX5WebViewBase.HitTestResult hitTestResult = this.f369239a;
            if (hitTestResult != null) {
                return hitTestResult.getExtra();
            }
            WebView.HitTestResult hitTestResult2 = this.f369240b;
            if (hitTestResult2 != null) {
                return hitTestResult2.getExtra();
            }
            return "";
        }

        public int getType() {
            IX5WebViewBase.HitTestResult hitTestResult = this.f369239a;
            if (hitTestResult != null) {
                return hitTestResult.getType();
            }
            WebView.HitTestResult hitTestResult2 = this.f369240b;
            if (hitTestResult2 != null) {
                return hitTestResult2.getType();
            }
            return 0;
        }

        public HitTestResult(IX5WebViewBase.HitTestResult hitTestResult) {
            this.f369239a = hitTestResult;
            this.f369240b = null;
        }

        public HitTestResult(WebView.HitTestResult hitTestResult) {
            this.f369239a = null;
            this.f369240b = hitTestResult;
        }
    }

    @TargetApi(11)
    public void saveWebArchive(String str, boolean z16, ValueCallback<String> valueCallback) {
        if (!this.f369212c) {
            com.tencent.smtt.utils.k.a(this.f369214e, "saveWebArchive", (Class<?>[]) new Class[]{String.class, Boolean.TYPE, android.webkit.ValueCallback.class}, str, Boolean.valueOf(z16), valueCallback);
        } else {
            this.f369213d.saveWebArchive(str, z16, valueCallback);
        }
    }

    private boolean a(Context context) {
        try {
            return context.getPackageName().indexOf("com.tencent.mobileqq") >= 0;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    public void loadUrl(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || showDebugView(str)) {
            return;
        }
        if (!this.f369212c) {
            this.f369214e.loadUrl(str);
        } else {
            this.f369213d.loadUrl(str);
        }
        this.f369217h.recordUrlLoadTime(System.currentTimeMillis() - currentTimeMillis, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z16) {
        if (!this.f369218j && this.f369210a != 0) {
            j();
        }
        if (!this.f369212c) {
            try {
                Class<?> cls = Class.forName("android.webkit.WebViewClassic");
                Method method = cls.getMethod("fromWebView", android.webkit.WebView.class);
                method.setAccessible(true);
                Object invoke = method.invoke(null, this.f369214e);
                if (invoke != null) {
                    Field declaredField = cls.getDeclaredField("mListBoxDialog");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(invoke);
                    if (obj != null) {
                        Dialog dialog = (Dialog) obj;
                        dialog.setOnCancelListener(null);
                        Class<?> cls2 = Class.forName("android.app.Dialog");
                        Field declaredField2 = cls2.getDeclaredField("CANCEL");
                        declaredField2.setAccessible(true);
                        int intValue = ((Integer) declaredField2.get(dialog)).intValue();
                        Field declaredField3 = cls2.getDeclaredField("mListenersHandler");
                        declaredField3.setAccessible(true);
                        ((Handler) declaredField3.get(dialog)).removeMessages(intValue);
                    }
                }
            } catch (Exception unused) {
            }
            if (z16) {
                this.f369214e.destroy();
            }
            try {
                TbsLog.i("sdkreport", "webview.tbsWebviewDestroy mQQMusicCrashFix is " + this.f369219k);
                if (this.f369219k) {
                    return;
                }
                Field declaredField4 = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
                declaredField4.setAccessible(true);
                ComponentCallbacks componentCallbacks = (ComponentCallbacks) declaredField4.get(null);
                if (componentCallbacks != null) {
                    declaredField4.set(null, null);
                    Field declaredField5 = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
                    declaredField5.setAccessible(true);
                    Object obj2 = declaredField5.get(null);
                    if (obj2 != null) {
                        List list = (List) obj2;
                        synchronized (list) {
                            list.remove(componentCallbacks);
                        }
                    }
                }
            } catch (Exception unused2) {
            }
        } else if (z16) {
            this.f369213d.destroy();
        }
        TbsLog.i("WebView", "X5 GUID = " + QbSdk.b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IX5WebViewBase b() {
        return this.f369213d;
    }

    public WebView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, false);
    }

    @Deprecated
    public WebView(Context context, AttributeSet attributeSet, int i3, boolean z16) {
        this(context, attributeSet, i3, null, z16);
    }

    @TargetApi(11)
    public WebView(Context context, AttributeSet attributeSet, int i3, Map<String, Object> map, boolean z16) {
        super(context, attributeSet, i3);
        this.f369211b = "WebView";
        this.f369212c = false;
        this.f369215f = null;
        this.f369216g = null;
        this.f369217h = new TbsWebViewPerformanceRecorder();
        this.f369210a = 0;
        this.f369218j = false;
        this.f369219k = false;
        this.f369220m = null;
        this.f369221n = null;
        this.f369222p = 1;
        this.f369223q = 2;
        this.f369224r = 3;
        this.f369225s = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.f369226t = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.f369227w = null;
        this.f369228x = null;
        long currentTimeMillis = System.currentTimeMillis();
        mWebViewCreated = true;
        if (QbSdk.getIsSysWebViewForcedByOuter() && TbsShareManager.isThirdPartyApp(context)) {
            this.f369216g = context;
            this.f369213d = null;
            this.f369212c = false;
            QbSdk.a(context, "failed to createTBSWebview!");
            this.f369214e = new a(context, attributeSet);
            CookieSyncManager.createInstance(this.f369216g).startSync();
            try {
                Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                declaredMethod.setAccessible(true);
                ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new h());
            } catch (Exception unused) {
            }
            CookieManager.getInstance().a();
            this.f369214e.setFocusableInTouchMode(true);
            addView(this.f369214e, new FrameLayout.LayoutParams(-1, -1));
            TbsLog.i("WebView", "SystemWebView Created Success! #3, SysWebViewForcedByOuter.");
            TbsLog.e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
            Log.i("[TBS]", "QbSdk.forceSysWebView() is called, use System Core");
            this.f369217h.recordWebViewConstruct(System.currentTimeMillis() - currentTimeMillis);
            return;
        }
        if (TbsShareManager.isThirdPartyApp(context)) {
            TbsLog.initIfNeed(context);
            TbsLog.i("webview", "new WebView, thread is " + Thread.currentThread() + "stack: " + Log.getStackTraceString(new Throwable("new WebView Detect")));
        }
        TbsLog.initIfNeed(context);
        if (context != null) {
            b(context);
            this.f369216g = context;
            f369205i = context.getApplicationContext();
            if (this.f369212c && !QbSdk.f368992b) {
                IX5WebViewBase a16 = p.a().a(true).a(context);
                this.f369213d = a16;
                if (a16 != null && a16.getView() != null) {
                    TbsLog.i("WebView", "X5 WebView Created Success!!");
                    this.f369213d.getView().setFocusableInTouchMode(true);
                    a(attributeSet);
                    addView(this.f369213d.getView(), new FrameLayout.LayoutParams(-1, -1));
                    this.f369213d.setDownloadListener(new b(this, null, this.f369212c));
                    this.f369213d.getX5WebViewExtension().setWebViewClientExtension(new X5ProxyWebViewClientExtension(p.a().a(true).k()) { // from class: com.tencent.smtt.sdk.WebView.1
                        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
                        public void onScrollChanged(int i16, int i17, int i18, int i19) {
                            super.onScrollChanged(i16, i17, i18, i19);
                            WebView.this.onScrollChanged(i18, i19, i16, i17);
                        }

                        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
                        public void invalidate() {
                        }
                    });
                    ProxyController.getInstance().syncSetProxy();
                } else {
                    TbsLog.e("WebView", "sys WebView: failed to createTBSWebview", true);
                    this.f369213d = null;
                    this.f369212c = false;
                    QbSdk.a(context, "failed to createTBSWebview!");
                    b(context);
                    if (TbsShareManager.isThirdPartyApp(this.f369216g)) {
                        this.f369214e = new a(context, attributeSet);
                    } else {
                        this.f369214e = new a(this, context);
                    }
                    TbsLog.i("WebView", "SystemWebView Created Success! #1");
                    CookieManager.getInstance().a();
                    this.f369214e.setFocusableInTouchMode(true);
                    addView(this.f369214e, new FrameLayout.LayoutParams(-1, -1));
                    try {
                        removeJavascriptInterface("searchBoxJavaBridge_");
                        removeJavascriptInterface("accessibility");
                        removeJavascriptInterface("accessibilityTraversal");
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                    TbsLog.writeLogToDisk();
                    n.a(context);
                    this.f369217h.recordWebViewConstruct(System.currentTimeMillis() - currentTimeMillis);
                    return;
                }
            } else {
                this.f369213d = null;
                if (TbsShareManager.isThirdPartyApp(this.f369216g)) {
                    this.f369214e = new a(context, attributeSet);
                } else {
                    this.f369214e = new a(this, context);
                }
                TbsLog.i("WebView", "SystemWebView Created Success! #2");
                CookieManager.getInstance().a();
                this.f369214e.setFocusableInTouchMode(true);
                addView(this.f369214e, new FrameLayout.LayoutParams(-1, -1));
                setDownloadListener(null);
                TbsLog.writeLogToDisk();
                n.a(context);
            }
            try {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
            if (("com.tencent.mobileqq".equals(this.f369216g.getApplicationInfo().packageName) || "com.tencent.mm".equals(this.f369216g.getApplicationInfo().packageName)) && g.a(true).i()) {
                setLayerType(1, null);
            }
            if (this.f369213d != null) {
                TbsLog.writeLogToDisk();
            }
            this.f369217h.recordWebViewConstruct(System.currentTimeMillis() - currentTimeMillis);
            this.f369217h.setX5Webview(this.f369213d);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("newWebView -> isX5webview:");
            sb5.append(this.f369213d != null);
            sb5.append(",X5CoreVersion:");
            sb5.append(QbSdk.a());
            Log.i("[TBS]", sb5.toString());
            return;
        }
        throw new IllegalArgumentException("Invalid context argument");
    }

    private boolean a(WebChromeClient webChromeClient) {
        if (webChromeClient == null) {
            return false;
        }
        boolean z16 = false;
        boolean z17 = false;
        for (Class<?> cls = webChromeClient.getClass(); cls != WebChromeClient.class && (!z16 || !z17); cls = cls.getSuperclass()) {
            if (!z16) {
                try {
                    cls.getDeclaredMethod("onShowCustomView", View.class, IX5WebChromeClient.CustomViewCallback.class);
                    z16 = true;
                } catch (NoSuchMethodException unused) {
                }
            }
            if (!z17) {
                try {
                    cls.getDeclaredMethod("onHideCustomView", new Class[0]);
                    z17 = true;
                } catch (NoSuchMethodException unused2) {
                }
            }
        }
        return z16 && z17;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public android.webkit.WebView a() {
        if (this.f369212c) {
            return null;
        }
        return this.f369214e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(IX5WebViewBase iX5WebViewBase) {
        this.f369213d = iX5WebViewBase;
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            try {
                int attributeCount = attributeSet.getAttributeCount();
                for (int i3 = 0; i3 < attributeCount; i3++) {
                    if (attributeSet.getAttributeName(i3).equalsIgnoreCase("scrollbars")) {
                        int[] intArray = getResources().getIntArray(R.attr.scrollbars);
                        int attributeIntValue = attributeSet.getAttributeIntValue(i3, -1);
                        if (attributeIntValue == intArray[1]) {
                            this.f369213d.getView().setVerticalScrollBarEnabled(false);
                            this.f369213d.getView().setHorizontalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[2]) {
                            this.f369213d.getView().setVerticalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[3]) {
                            this.f369213d.getView().setHorizontalScrollBarEnabled(false);
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private boolean a(View view) {
        Object a16;
        Context context = this.f369216g;
        if ((context == null || getTbsCoreVersion(context) <= 36200) && (a16 = com.tencent.smtt.utils.k.a(this.f369227w, NodeProps.ON_LONG_CLICK, (Class<?>[]) new Class[]{View.class}, view)) != null) {
            return ((Boolean) a16).booleanValue();
        }
        return false;
    }
}
