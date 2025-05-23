package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.ads.data.AdParam;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.ecshopassit.BusinessReporter;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.activities.SingleTaskQQBrowser;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerViewModel;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bigbrother.TeleScreenRunnable;
import com.tencent.mobileqq.ecshop.api.IEcshopUtilApi;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.utils.IPayInterceptApi;
import com.tencent.mobileqq.screendetect.ScreenShotFragment;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.w;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.ScreenShotUtil;
import com.tencent.mobileqq.utils.bg;
import com.tencent.mobileqq.vas.URLInterceptManager;
import com.tencent.mobileqq.wbapi.WBShareHelper;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.webview.webso.WebSoScreenshot;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.sdk.WebView;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import cooperation.peak.PeakConstants;
import cooperation.pluginbridge.BridgeHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService;
import cooperation.qzone.report.lp.LpReportInfo_dc02216;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.opengroup.AppUrlOpenGroup$ReqBody;
import tencent.im.opengroup.AppUrlOpenGroup$RspBody;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WebViewSurfaceInjectorImpl implements com.tencent.mobileqq.webview.swift.injector.y {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    private static int f314125k;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f314126l;

    /* renamed from: m, reason: collision with root package name */
    private static Boolean f314127m;

    /* renamed from: a, reason: collision with root package name */
    private boolean f314128a;

    /* renamed from: b, reason: collision with root package name */
    private int f314129b;

    /* renamed from: c, reason: collision with root package name */
    private String f314130c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f314131d;

    /* renamed from: e, reason: collision with root package name */
    private JefsClass.Cancelable f314132e;

    /* renamed from: f, reason: collision with root package name */
    private int f314133f;

    /* renamed from: g, reason: collision with root package name */
    private int f314134g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f314135h;

    /* renamed from: i, reason: collision with root package name */
    private String f314136i;

    /* renamed from: j, reason: collision with root package name */
    private String f314137j;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends SosoInterfaceOnLocationListener {
        static IPatchRedirector $redirector_;

        a(int i3, boolean z16, boolean z17, long j3, boolean z18, boolean z19, String str) {
            super(i3, z16, z17, j3, z18, z19, str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, WebViewSurfaceInjectorImpl.this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), Boolean.valueOf(z18), Boolean.valueOf(z19), str);
            }
        }

        @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) sosoLbsInfo);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b extends SosoInterfaceOnLocationListener {
        static IPatchRedirector $redirector_;

        b(int i3, boolean z16, boolean z17, long j3, boolean z18, boolean z19, String str) {
            super(i3, z16, z17, j3, z18, z19, str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, WebViewSurfaceInjectorImpl.this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), Boolean.valueOf(z18), Boolean.valueOf(z19), str);
            }
        }

        @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) sosoLbsInfo);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WebViewProvider f314149d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ SwiftIphoneTitleBarUI f314150e;

        c(WebViewProvider webViewProvider, SwiftIphoneTitleBarUI swiftIphoneTitleBarUI) {
            this.f314149d = webViewProvider;
            this.f314150e = swiftIphoneTitleBarUI;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, WebViewSurfaceInjectorImpl.this, webViewProvider, swiftIphoneTitleBarUI);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("WebViewSurfaceInjectorImpl", 2, " checkAppUrl,onReceive:isSuccess=" + z16);
            }
            if (this.f314149d.getHostActivity() != null && !this.f314149d.getHostActivity().isFinishing() && z16) {
                SwiftBrowserShareMenuHandler swiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler) this.f314149d.getComponentProvider().a(4);
                ((SwiftBrowserStatistics) this.f314149d.getComponentProvider().a(-2)).C0 = true;
                byte[] byteArray = bundle.getByteArray("data");
                AppUrlOpenGroup$RspBody appUrlOpenGroup$RspBody = new AppUrlOpenGroup$RspBody();
                try {
                    appUrlOpenGroup$RspBody.mergeFrom(byteArray);
                    swiftBrowserShareMenuHandler.Q = appUrlOpenGroup$RspBody.bytes_company.get().toStringUtf8();
                    swiftBrowserShareMenuHandler.S = appUrlOpenGroup$RspBody.bytes_info_url.get().toStringUtf8();
                    swiftBrowserShareMenuHandler.R = appUrlOpenGroup$RspBody.bytes_share_url.get().toStringUtf8();
                    if (this.f314150e.f314059m.getVisibility() != 8) {
                        this.f314150e.f314059m.setVisibility(8);
                    }
                    if (this.f314150e.N.getVisibility() != 0) {
                        this.f314150e.N.setVisibility(0);
                    }
                    TextView textView = (TextView) this.f314150e.N.findViewById(R.id.jq5);
                    TextView textView2 = (TextView) this.f314150e.N.findViewById(R.id.joi);
                    textView.setText(this.f314150e.f314059m.getText());
                    textView2.setText(R.string.f173225i54);
                    this.f314150e.E.setVisibility(0);
                    this.f314150e.E.setImageResource(R.drawable.header_btn_more);
                } catch (InvalidProtocolBufferMicroException | Exception unused) {
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class d implements ScreenShotUtil.e<String> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebViewProvider f314152a;

        d(WebViewProvider webViewProvider) {
            this.f314152a = webViewProvider;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebViewSurfaceInjectorImpl.this, (Object) webViewProvider);
            }
        }

        @Override // com.tencent.mobileqq.util.ScreenShotUtil.e
        public void b(Exception exc) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) exc);
                return;
            }
            QLog.e("WebViewSurfaceInjectorImpl", 1, "onScreenShotError, error is " + exc.getMessage());
            if (this.f314152a.getHostActivity() == null) {
                QLog.e("WebViewSurfaceInjectorImpl", 1, "screen long shot onScreenShotError, activity is null");
            } else {
                QQToast.makeText(this.f314152a.getHostActivity(), R.string.vxv, 0).show();
            }
        }

        @Override // com.tencent.mobileqq.util.ScreenShotUtil.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public String c(Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
            }
            String str = ScreenShotUtil.b() + System.currentTimeMillis() + ".jpg";
            z81.b.a(bitmap, str, Bitmap.CompressFormat.JPEG, 100, true);
            return str;
        }

        @Override // com.tencent.mobileqq.util.ScreenShotUtil.e
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(String str, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) bitmap);
                return;
            }
            if (this.f314152a.getHostActivity() == null) {
                QLog.e("WebViewSurfaceInjectorImpl", 1, "screen long shot error, activity is null");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra("screen_path", str);
            intent.putExtra("is_web_screen_long_shot", true);
            PublicFragmentActivity.b.a(this.f314152a.getHostActivity(), intent, PublicTransFragmentActivity.class, ScreenShotFragment.class);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77326);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
            return;
        }
        f314125k = -1;
        f314126l = true;
        f314127m = null;
    }

    public WebViewSurfaceInjectorImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f314128a = false;
        this.f314129b = 0;
        this.f314130c = "";
        this.f314131d = false;
        this.f314135h = false;
        this.f314136i = "";
        this.f314137j = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(WebViewProvider webViewProvider) {
        NewerGuideBannerViewModel.Q1(webViewProvider.getIntent().getStringExtra("source_from"));
    }

    private void I(WebViewProvider webViewProvider) {
        ThreadManagerV2.excute(new Runnable(webViewProvider) { // from class: com.tencent.mobileqq.webview.swift.WebViewSurfaceInjectorImpl.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ WebViewProvider f314139d;

            {
                this.f314139d = webViewProvider;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebViewSurfaceInjectorImpl.this, (Object) webViewProvider);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    WebViewSurfaceInjectorImpl.this.H(this.f314139d);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, 16, null, true);
    }

    private void J(WebViewProvider webViewProvider, Intent intent, int i3, int i16) {
        QLog.d("WebViewSurfaceInjectorImpl", 1, "Activity result  to weibo plugin.");
        if (webViewProvider.getWebView() == null) {
            QLog.d("WebViewSurfaceInjectorImpl", 1, "Activity result weibo null == webView.");
            return;
        }
        WebViewPluginEngine pluginEngine = webViewProvider.getWebView().getPluginEngine();
        if (pluginEngine == null) {
            QLog.d("WebViewSurfaceInjectorImpl", 1, "Activity result weibo null == engine.");
            return;
        }
        WebViewPlugin m3 = pluginEngine.m("share");
        if (m3 == null) {
            QLog.d("WebViewSurfaceInjectorImpl", 1, "Activity result weibo null == plugin.");
        } else {
            m3.onActivityResult(intent, (byte) i3, i16);
        }
    }

    private void K(WebViewProvider webViewProvider) {
        if (!this.f314135h) {
            this.f314135h = true;
            String stringExtra = webViewProvider.getIntent().getStringExtra("url");
            if (com.tencent.mobileqq.webview.webso.e.E(stringExtra)) {
                ThreadManagerV2.postImmediately(new Runnable(stringExtra) { // from class: com.tencent.mobileqq.webview.swift.WebViewSurfaceInjectorImpl.8
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f314146d;

                    {
                        this.f314146d = stringExtra;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebViewSurfaceInjectorImpl.this, (Object) stringExtra);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            WebSoService.j().E(this.f314146d, null);
                        }
                    }
                }, null, false);
            }
        }
    }

    private void M(WebViewProvider webViewProvider) {
        String N = N(this.f314137j, "window.OPEN_DATA = [\\s\\S]*window.OPEN_DATA.loadTimes =");
        this.f314136i = N;
        String replace = N.replace("window.OPEN_DATA = ", "");
        this.f314136i = replace;
        String replace2 = replace.replace("window.OPEN_DATA.loadTimes =", "");
        this.f314136i = replace2;
        this.f314136i = replace2.trim();
        if (QLog.isColorLevel()) {
            QLog.d("WebViewSurfaceInjectorImpl", 2, "OPEN_DATA from htmlBody get success: " + this.f314136i);
        }
    }

    private String N(String str, String str2) {
        Matcher matcher = Pattern.compile(str2).matcher(str);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O() {
        if (QQBrowserActivity.sQQBrowserActivityCounter > 0 && !((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).doBindService(BaseApplicationImpl.getApplication(), MessengerService.class);
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("WebViewSurfaceInjectorImpl", 2, "postBindService real bind");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P() {
        if (QQBrowserActivity.sQQBrowserActivityCounter == 0) {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).doUnbindService(BaseApplicationImpl.getApplication());
            if (QLog.isDevelopLevel()) {
                QLog.i("WebViewSurfaceInjectorImpl", 2, "postUnBindService real bind");
            }
        }
    }

    private void Q() {
        if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.al
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewSurfaceInjectorImpl.O();
                }
            });
        }
    }

    private void R() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.am
            @Override // java.lang.Runnable
            public final void run() {
                WebViewSurfaceInjectorImpl.P();
            }
        });
    }

    private boolean S(CustomWebView customWebView, SwiftIphoneTitleBarUI swiftIphoneTitleBarUI) {
        if (customWebView != null) {
            JsBridgeListener jsBridgeListener = swiftIphoneTitleBarUI.S;
            if (jsBridgeListener != null && jsBridgeListener.f314008c) {
                customWebView.callJs4OpenApi(jsBridgeListener, 0, "");
                return true;
            }
            if (!TextUtils.isEmpty(swiftIphoneTitleBarUI.Q)) {
                customWebView.callJs(swiftIphoneTitleBarUI.Q, "");
                return true;
            }
            com.tencent.mobileqq.webview.nativeapi.a aVar = swiftIphoneTitleBarUI.R;
            if (aVar != null) {
                DoraemonUtil.f((com.tencent.mobileqq.Doraemon.a) com.tencent.mobileqq.webview.util.b.b(com.tencent.mobileqq.Doraemon.a.class, aVar), com.tencent.mobileqq.Doraemon.c.f154094a);
                return true;
            }
        }
        return false;
    }

    private void T(WebViewProvider webViewProvider, boolean z16) {
        ((com.tencent.mobileqq.webview.swift.component.v) webViewProvider.getComponentProvider().a(2)).U(z16);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public boolean A(b.C8976b c8976b, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, (Object) c8976b, (Object) view)).booleanValue();
        }
        if (!(c8976b instanceof SwiftBrowserLongClickHandler)) {
            return false;
        }
        return ((SwiftBrowserLongClickHandler) c8976b).m(view);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public boolean B(WebViewProvider webViewProvider, int i3, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, webViewProvider, Integer.valueOf(i3), intent)).booleanValue();
        }
        switch (i3) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                if (intent == null) {
                    return true;
                }
                String stringExtra = intent.getStringExtra("callbackSn");
                String stringExtra2 = intent.getStringExtra("result");
                webViewProvider.getWebView().loadUrl("javascript:window.JsBridge&&JsBridge.callback('" + stringExtra + "',{'r':0,'result':" + stringExtra2 + "});");
                try {
                    ((IQzoneWebViewPluginHelper) QRoute.api(IQzoneWebViewPluginHelper.class)).savePayActionResult(webViewProvider, stringExtra2);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("WebViewSurfaceInjectorImpl", 2, "onActivityResult: mPayActionException=" + e16.getMessage());
                    }
                }
                return true;
            default:
                return false;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public void C(WebViewProvider webViewProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) webViewProvider);
            return;
        }
        String a16 = BridgeHelper.b(webViewProvider.getHostActivity(), webViewProvider.getUin()).a("buscard_registerNFC");
        if (TextUtils.isEmpty(a16) || "true".equals(a16)) {
            ActivityLifecycle.onPause(webViewProvider.getHostActivity());
        }
        if (this.f314131d && com.tencent.mobileqq.simpleui.b.c()) {
            QzoneOnlineTimeCollectRptService.getInstance().closeTrace();
        }
    }

    void G(int i3, String str, BusinessObserver businessObserver, WebViewProvider webViewProvider) {
        AppUrlOpenGroup$ReqBody appUrlOpenGroup$ReqBody = new AppUrlOpenGroup$ReqBody();
        appUrlOpenGroup$ReqBody.uint32_appid.set(i3);
        appUrlOpenGroup$ReqBody.bytes_url.set(ByteStringMicro.copyFromUtf8(webViewProvider.getCurrentUrl()));
        appUrlOpenGroup$ReqBody.bytes_param.set(ByteStringMicro.copyFromUtf8(str));
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), com.tencent.biz.m.class);
        newIntent.putExtra("cmd", "GroupOpen.CheckAppUrl");
        newIntent.putExtra("data", appUrlOpenGroup$ReqBody.toByteArray());
        newIntent.setObserver(businessObserver);
        webViewProvider.getAppRuntime().startServlet(newIntent);
    }

    void L(WebViewProvider webViewProvider) {
        String stringExtra = webViewProvider.getIntent().getStringExtra("url");
        if (com.tencent.mobileqq.webview.webso.e.E(stringExtra)) {
            WebSoScreenshot.d(webViewProvider.getHostActivity(), stringExtra);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public void a(WebViewProvider webViewProvider, String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        String str2;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, webViewProvider, str, geolocationPermissionsCallback);
            return;
        }
        if (str != null && str.indexOf(58) == -1 && webViewProvider.getWebView() != null && webViewProvider.getWebView().getX5WebViewExtension() != null) {
            str = "https://" + str + "/";
        }
        boolean F = AuthorizeConfig.y().F(str, "publicAccount.getLocation");
        if (webViewProvider.getWebView() != null) {
            str2 = com.tencent.mobileqq.webview.util.s.h(webViewProvider.getWebView().getUrl(), 2);
        } else {
            str2 = "";
        }
        String uin = webViewProvider.getUin();
        boolean locationPermissionGrant = ((IPublicAccountJavascriptInterface) QRoute.api(IPublicAccountJavascriptInterface.class)).getLocationPermissionGrant(uin, str2);
        if (locationPermissionGrant && F) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WebViewSurfaceInjectorImpl", 2, "onGeolocationPermissionsShowPrompt allow:", Boolean.valueOf(F), " granted:", Boolean.valueOf(locationPermissionGrant), " hasRight:", Boolean.valueOf(z16), " uin:", uin, " urlHost:", str2);
        }
        geolocationPermissionsCallback.invoke(str, z16, false);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public boolean b(WebViewProvider webViewProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, (Object) webViewProvider)).booleanValue();
        }
        if (bg.f().i(webViewProvider.getCurrentUrl())) {
            webViewProvider.getWebView().loadUrl("file:///android_asset/error.html");
            QLog.d("WebViewSurfaceInjectorImpl", 1, "url:", webViewProvider.getCurrentUrl(), "in black");
        } else if (!TextUtils.isEmpty(webViewProvider.getCurrentUrl())) {
            webViewProvider.getWebView().loadUrl(webViewProvider.getCurrentUrl());
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public void c(WebViewProvider webViewProvider, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) webViewProvider, (Object) bundle);
        } else {
            L(webViewProvider);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public void d(WebViewProvider webViewProvider, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) webViewProvider, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public void e(WebViewProvider webViewProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) webViewProvider);
        } else {
            ((SwiftBrowserShareMenuHandler) webViewProvider.getComponentProvider().a(4)).D();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public void f(WebViewProvider webViewProvider, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) webViewProvider, (Object) bundle);
            return;
        }
        Bundle extras = webViewProvider.getIntent().getExtras();
        if (extras != null) {
            Boolean valueOf = Boolean.valueOf(extras.getBoolean(QQBrowserActivity.IS_OPENING_QUN_APP));
            this.f314133f = extras.getInt("appid");
            this.f314134g = extras.getInt(QQBrowserActivity.TROOP_ID);
            String string = extras.getString(QQBrowserActivity.APP_PARAM);
            if (string == null) {
                string = "";
            }
            if (valueOf.booleanValue()) {
                SwiftIphoneTitleBarUI swiftIphoneTitleBarUI = ((com.tencent.mobileqq.webview.swift.component.v) webViewProvider.getComponentProvider().a(2)).C;
                if (swiftIphoneTitleBarUI.f314054i.getBackground() == null) {
                    swiftIphoneTitleBarUI.f314054i.setText(webViewProvider.getResource().getString(R.string.close));
                }
                G(this.f314133f, string, new c(webViewProvider, swiftIphoneTitleBarUI), webViewProvider);
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public void g(WebViewProvider webViewProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) webViewProvider);
            return;
        }
        Intent intent = new Intent("tencent.notify.foreground");
        intent.setPackage(BaseApplication.getContext().getPackageName());
        intent.putExtra("selfuin", webViewProvider.getUin());
        intent.putExtra("AccountInfoSync", AppConstants.SYNCWEB);
        intent.putExtra("classname", getClass().getName());
        BaseApplicationImpl.getApplication().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        String a16 = BridgeHelper.b(webViewProvider.getHostActivity(), webViewProvider.getUin()).a("buscard_registerNFC");
        if (TextUtils.isEmpty(a16) || "true".equals(a16)) {
            ActivityLifecycle.onResume(webViewProvider.getHostActivity());
        }
        ThreadManagerV2.executeOnSubThread(new Runnable(new WeakReference(webViewProvider)) { // from class: com.tencent.mobileqq.webview.swift.WebViewSurfaceInjectorImpl.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ WeakReference f314138d;

            {
                this.f314138d = r5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebViewSurfaceInjectorImpl.this, (Object) r5);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                WebViewProvider webViewProvider2 = (WebViewProvider) this.f314138d.get();
                if (webViewProvider2 != null && MyAppApi.F()) {
                    MyAppApi.z().T(webViewProvider2.getHostActivity());
                }
            }
        });
        if (this.f314131d && com.tencent.mobileqq.simpleui.b.c()) {
            QzoneOnlineTimeCollectRptService.getInstance().beginTrace(1);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public void h(WebViewProvider webViewProvider, Bundle bundle, TouchWebView touchWebView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, webViewProvider, bundle, touchWebView);
        } else {
            SwiftBrowserStatistics swiftBrowserStatistics = (SwiftBrowserStatistics) webViewProvider.getComponentProvider().a(-2);
            MobileReportManager.getInstance().reportH5Trace(webViewProvider.getCurrentUrl(), 130, System.currentTimeMillis() - swiftBrowserStatistics.f314361h, "0", swiftBrowserStatistics.M0, swiftBrowserStatistics.N0);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public boolean i(WebViewProvider webViewProvider, WebView webView, SslError sslError) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, this, webViewProvider, webView, sslError)).booleanValue();
        }
        SwiftBrowserStatistics swiftBrowserStatistics = (SwiftBrowserStatistics) webViewProvider.getComponentProvider().a(-2);
        MobileReportManager.getInstance().reportH5Trace(webViewProvider.getCurrentUrl(), 132, System.currentTimeMillis() - swiftBrowserStatistics.f314361h, String.valueOf(sslError.getPrimaryError()), swiftBrowserStatistics.M0, swiftBrowserStatistics.N0);
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public boolean j(b.C8976b c8976b) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, (Object) c8976b)).booleanValue();
        }
        if (!(c8976b instanceof SwiftBrowserLongClickHandler)) {
            return false;
        }
        return ((SwiftBrowserLongClickHandler) c8976b).k();
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public void k(WebViewProvider webViewProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) webViewProvider);
            return;
        }
        SwiftBrowserStatistics swiftBrowserStatistics = (SwiftBrowserStatistics) webViewProvider.getComponentProvider().a(-2);
        MobileReportManager.getInstance().reportH5Trace(webViewProvider.getCurrentUrl(), 133, System.currentTimeMillis() - swiftBrowserStatistics.f314369m0, "0", swiftBrowserStatistics.M0, swiftBrowserStatistics.N0);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102509", true)) {
            I(webViewProvider);
        } else {
            H(webViewProvider);
        }
        Long valueOf = Long.valueOf(webViewProvider.getIntent().getLongExtra("Gif_msg_uniseq_key", 0L));
        if (valueOf.longValue() > 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("Gif_msg_uniseq_key", valueOf.longValue());
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("close_annimate", null, -1, bundle));
        }
        JefsClass.Cancelable cancelable = this.f314132e;
        if (cancelable != null) {
            cancelable.setCanceled();
        }
        if (QQBrowserActivity.sQQBrowserActivityCounter == 0) {
            R();
            SwiftBrowserStatistics.b.f314406g = -1;
        }
        w.a d16 = com.tencent.mobileqq.statistics.w.d(getClass(), hashCode());
        if (d16 != null) {
            String str = d16.f290173d;
            ReportController.o(null, "CliOper", "", "", str, str, d16.f290174e, 0, Long.toString(SystemClock.elapsedRealtime() - d16.f290172c), "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public void l(WebViewProvider webViewProvider, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) webViewProvider, (Object) bundle);
            return;
        }
        this.f314129b = webViewProvider.getIntent().getIntExtra("articalChannelId", 100);
        this.f314130c = webViewProvider.getIntent().getStringExtra(QQBrowserActivity.ARTICAL_CHANNEL_EXTRAL_INFO);
        this.f314131d = webViewProvider.getIntent().getBooleanExtra("fromQZone", false);
        boolean booleanExtra = webViewProvider.getIntent().getBooleanExtra(QQBrowserActivity.KEY_FROM_NEARBY, false);
        com.tencent.mobileqq.statistics.w.a(getClass(), hashCode(), booleanExtra ? 1 : 0, webViewProvider.getCurrentUrl());
        K(webViewProvider);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public void m(WebViewProvider webViewProvider, WebView webView, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, webViewProvider, webView, str, bitmap);
        } else {
            H(webViewProvider);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public void n(WebViewProvider webViewProvider, WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, webViewProvider, webView, str);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public void o(WebViewProvider webViewProvider, WebView webView, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, webViewProvider, webView, str, bitmap);
            return;
        }
        if (!this.f314128a && ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).articleReport(str, this.f314129b, this.f314130c)) {
            this.f314128a = true;
        }
        T(webViewProvider, false);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public void p(WebViewProvider webViewProvider, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) webViewProvider, (Object) bundle);
            return;
        }
        com.tencent.biz.common.util.k.a("Web_IPCSetup");
        Q();
        com.tencent.biz.common.util.k.d("Web_IPCSetup");
        if ((((com.tencent.mobileqq.webview.swift.component.v) webViewProvider.getComponentProvider().a(2)).f314512m.f314620c & 4194304) > 0) {
            if (f314127m == null) {
                f314127m = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102363", false));
                QLog.d("WebViewSurfaceInjectorImpl", 1, "s_isPreLocationCutOff=" + f314127m);
            }
            if (f314127m.booleanValue()) {
                return;
            }
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(new a(0, false, false, 600000L, false, false, "webview"));
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(new b(0, true, false, 600000L, false, false, "webview"));
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public void q(WebViewProvider webViewProvider, WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, webViewProvider, webView, str);
            return;
        }
        this.f314128a = true;
        this.f314129b = 100;
        SwiftBrowserStatistics swiftBrowserStatistics = (SwiftBrowserStatistics) webViewProvider.getComponentProvider().a(-2);
        if (swiftBrowserStatistics.f314381y0) {
            MobileReportManager.getInstance().reportH5Trace(str, 131, swiftBrowserStatistics.f314369m0 - swiftBrowserStatistics.f314365j0, "0", swiftBrowserStatistics.M0, swiftBrowserStatistics.N0);
            MobileReportManager.getInstance().reportH5Trace(str, 129, swiftBrowserStatistics.f314369m0 - swiftBrowserStatistics.f314361h, "0", swiftBrowserStatistics.M0, swiftBrowserStatistics.N0);
        }
        Activity hostActivity = webViewProvider.getHostActivity();
        if (hostActivity instanceof QQBrowserActivity) {
            ((QQBrowserActivity) hostActivity).onPageFinished(webView, str);
        }
        if (webView instanceof CustomWebView) {
            BusinessReporter.c((CustomWebView) webView);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public boolean r(WebViewProvider webViewProvider, WebView webView, String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, webViewProvider, webView, str)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean tryIntercept = ((IPayInterceptApi) QRoute.api(IPayInterceptApi.class)).tryIntercept(str, (WebViewFragment) webViewProvider);
        QLog.i("WebViewSurfaceInjectorImpl", 1, "TryPayIntercept result:" + tryIntercept + " cost:" + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
        if (tryIntercept) {
            return true;
        }
        Uri parse = Uri.parse(str);
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, parse);
        intent.addFlags(268435456);
        try {
            intent.putExtra("url", webViewProvider.getCurrentUrl());
            ActivityInfo resolveActivityInfo = intent.resolveActivityInfo(webViewProvider.getHostActivity().getPackageManager(), 0);
            if (resolveActivityInfo == null) {
                str2 = "";
            } else {
                str2 = resolveActivityInfo.packageName;
            }
            StartAppCheckHandler.I2(ZPlanPublishSource.FROM_SCHEME, webView.getUrl(), str2, "1", "web", webViewProvider.getHostActivity().getClass().getName());
            Intent intent2 = webViewProvider.getIntent();
            boolean booleanExtra = intent2.getBooleanExtra(AppConstants.Key.H5_ARK_IS_FROM_SHARE, false);
            long longExtra = intent2.getLongExtra(AppConstants.Key.SHARE_REQ_APP_ID, -1L);
            intent.putExtra(AppConstants.Key.H5_ARK_IS_FROM_SHARE, booleanExtra);
            intent.putExtra(AppConstants.Key.SHARE_REQ_APP_ID, longExtra);
            JefsClass.Cancelable cancelable = this.f314132e;
            if (cancelable != null) {
                cancelable.setCanceled();
            }
            try {
                boolean booleanExtra2 = webViewProvider.getIntent().getBooleanExtra("keyForForceCloseAfterJump", false);
                if ("biz_src_qqgw_choice".equals(JefsClass.getInstance().getSourceId(webViewProvider.getHostActivity(), intent))) {
                    for (EcshopConfBean.ForbidJumpThirdAppRule forbidJumpThirdAppRule : ((IEcshopUtilApi) QRoute.api(IEcshopUtilApi.class)).getEcshopForbidJumpThirdAppRule()) {
                        String[] split = forbidJumpThirdAppRule.keyPath.split("\\.");
                        if (split.length > 1) {
                            try {
                                if (TextUtils.equals(new JSONObject(parse.getQueryParameter(split[0])).optString(split[1]), forbidJumpThirdAppRule.value)) {
                                    return true;
                                }
                            } catch (Exception e16) {
                                QLog.e("WebViewSurfaceInjectorImpl", 1, "parse params error", e16);
                            }
                        }
                    }
                }
                this.f314132e = JefsClass.getInstance().checkAndDoAsync(webViewProvider.getHostActivity(), intent, str, new TeleScreenRunnable(webViewProvider, intent, booleanExtra2, str2, booleanExtra, longExtra) { // from class: com.tencent.mobileqq.webview.swift.WebViewSurfaceInjectorImpl.3
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ WebViewProvider f314140d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ Intent f314141e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ boolean f314142f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ String f314143h;

                    /* renamed from: i, reason: collision with root package name */
                    final /* synthetic */ boolean f314144i;

                    /* renamed from: m, reason: collision with root package name */
                    final /* synthetic */ long f314145m;

                    {
                        this.f314140d = webViewProvider;
                        this.f314141e = intent;
                        this.f314142f = booleanExtra2;
                        this.f314143h = str2;
                        this.f314144i = booleanExtra;
                        this.f314145m = longExtra;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, WebViewSurfaceInjectorImpl.this, webViewProvider, intent, Boolean.valueOf(booleanExtra2), str2, Boolean.valueOf(booleanExtra), Long.valueOf(longExtra));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        String valueOf;
                        String valueOf2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        try {
                            this.f314140d.getHostActivity().startActivity(this.f314141e);
                            if (this.f314142f && !TextUtils.isEmpty(this.f314143h)) {
                                boolean booleanExtra3 = this.f314141e.getBooleanExtra(JefsClass.KEY_IS_TO_DOWNLOAD, false);
                                this.f314140d.getHostActivity().finish();
                                if (QLog.isColorLevel()) {
                                    QLog.d("WebViewSurfaceInjectorImpl", 2, "forcedClosedAfterJump appName=" + this.f314143h);
                                }
                                boolean z16 = this.f314144i;
                                if (z16 && !booleanExtra3) {
                                    long j3 = this.f314145m;
                                    if (j3 == -1) {
                                        valueOf2 = "";
                                    } else {
                                        valueOf2 = String.valueOf(j3);
                                    }
                                    ReportController.o(null, "dc00898", "", "", "0X800A86A", "0X800A86A", 0, 0, valueOf2, "", "", "");
                                    return;
                                }
                                if (z16) {
                                    long j16 = this.f314145m;
                                    if (j16 == -1) {
                                        valueOf = "";
                                    } else {
                                        valueOf = String.valueOf(j16);
                                    }
                                    ReportController.o(null, "dc00898", "", "", "0X800A86B", "0X800A86B", 0, 0, valueOf, "", "", "");
                                }
                            }
                        } catch (Throwable th5) {
                            QLog.e("WebViewSurfaceInjectorImpl", 1, th5, new Object[0]);
                        }
                    }
                });
            } catch (Throwable th5) {
                QLog.e("WebViewSurfaceInjectorImpl", 1, th5, new Object[0]);
            }
            return true;
        } catch (Exception e17) {
            QLog.e("WebViewSurfaceInjectorImpl", 1, "afterWebViewEngineHandleOverrideUrl error!", e17);
            return true;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public void s(WebViewProvider webViewProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) webViewProvider);
            return;
        }
        if (webViewProvider.getIntent().getBooleanExtra("flow_key_from_guide", false)) {
            Intent intent = new Intent();
            intent.setComponent(SplashActivity.getAliasComponent(BaseApplicationImpl.getApplication()));
            intent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
            intent.addFlags(67108864);
            webViewProvider.getHostActivity().startActivity(intent);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public boolean t(WebViewProvider webViewProvider, Intent intent) {
        String stringExtra;
        WebViewPluginEngine pluginEngine;
        WebViewPlugin l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) webViewProvider, (Object) intent)).booleanValue();
        }
        int i3 = 0;
        if ("actionSelectPicture".equals(intent.getStringExtra("keyAction"))) {
            int intExtra = intent.getIntExtra("requestCode", -1);
            int i16 = intExtra & 255;
            int i17 = (intExtra >> 8) & 255;
            if (i17 > 0) {
                if (webViewProvider.getWebView() != null && (pluginEngine = webViewProvider.getWebView().getPluginEngine()) != null && (l3 = pluginEngine.l(i17, true)) != null) {
                    if (intent.hasExtra("PhotoConst.PHOTO_PATHS")) {
                        i3 = -1;
                    }
                    l3.onActivityResult(intent, (byte) i16, i3);
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.w("WebViewSurfaceInjectorImpl", 2, "Caution! activity result not handled!");
                }
            }
        }
        if ("actionSelectPicture".equals(intent.getStringExtra("keyAction")) || "android.nfc.action.TECH_DISCOVERED".equals(intent.getAction()) || intent.getBooleanExtra("fromNotification", false)) {
            return true;
        }
        if (intent.getBooleanExtra("keyFromUpdateAvatar", false) && (stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH")) != null) {
            Bundle bundle = new Bundle();
            bundle.putString("path", stringExtra);
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(com.tencent.mobileqq.emosm.a.a("ipc_update_avatar", "", 0, bundle));
            return true;
        }
        boolean booleanExtra = intent.getBooleanExtra(PeakConstants.SEND_FLAG, false);
        if (QLog.isColorLevel()) {
            QLog.d("WebViewSurfaceInjectorImpl", 2, "doOnNewIntent, isPhotoPlusEditSend = " + booleanExtra);
        }
        if (booleanExtra) {
            intent.removeExtra(PeakConstants.SEND_FLAG);
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                String str = stringArrayListExtra.get(0);
                QLog.d("WebViewSurfaceInjectorImpl", 2, "editScreenShotBack:" + str);
                SwiftBrowserScreenShotHandler swiftBrowserScreenShotHandler = (SwiftBrowserScreenShotHandler) webViewProvider.getComponentProvider().a(64);
                if (swiftBrowserScreenShotHandler != null) {
                    swiftBrowserScreenShotHandler.i(str, intent.getStringExtra(EditPicActivity.IMAGE_PATH), intent.getIntExtra("EditPicType", 0));
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public void u(View view, WebViewProvider webViewProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) view, (Object) webViewProvider);
            return;
        }
        view.setBackgroundResource(R.drawable.qui_bg_nav_secondary);
        int g16 = ie0.a.f().g(BaseApplication.getContext(), com.tencent.mobileqq.webview.swift.utils.n.token_color_navText, 1000);
        if (g16 != f314125k) {
            f314125k = g16;
            f314126l = !UiApiPlugin.U(g16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("WebViewSurfaceInjectorImpl", 2, "setDefaultImmersiveBg useLight: " + f314126l);
        }
        SimpleUIUtil.adjustColorForQQBrowserActivity(f314126l, webViewProvider.getHostActivity().getWindow());
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public void v(WebViewProvider webViewProvider, View view) {
        ViewParent parent;
        String title;
        WebViewPluginEngine pluginEngine;
        ViewParent parent2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) webViewProvider, (Object) view);
            return;
        }
        com.tencent.mobileqq.webview.swift.component.v vVar = (com.tencent.mobileqq.webview.swift.component.v) webViewProvider.getComponentProvider().a(2);
        SwiftIphoneTitleBarUI swiftIphoneTitleBarUI = vVar.C;
        r rVar = vVar.f314512m;
        if (view != swiftIphoneTitleBarUI.E && view != swiftIphoneTitleBarUI.D) {
            if (view == swiftIphoneTitleBarUI.C) {
                String currentUrl = webViewProvider.getCurrentUrl();
                if (currentUrl != null && currentUrl.contains("checkin/index")) {
                    Intent intent = new Intent();
                    intent.setAction("SignInSbumited");
                    BaseApplicationImpl.getApplication().sendBroadcast(intent);
                }
                if (!S(webViewProvider.getWebView(), swiftIphoneTitleBarUI)) {
                    if (rVar.f314640w) {
                        webViewProvider.doOnBackEvent();
                    } else {
                        ReportCenter.f().p("", "", "", "1000", "100", "0", false);
                        webViewProvider.showActionSheet();
                    }
                }
                View view2 = vVar.Q;
                if (view2 != null && (parent2 = view2.getParent()) != null && (parent2 instanceof ViewGroup)) {
                    ((ViewGroup) parent2).removeView(vVar.Q);
                    return;
                }
                return;
            }
            SwiftFloatViewUI swiftFloatViewUI = vVar.D;
            if (view == swiftFloatViewUI.f314015f) {
                if (rVar.W) {
                    LpReportInfo_dc02216.reportExit();
                    if (webViewProvider.getWebView() != null && (pluginEngine = webViewProvider.getWebView().getPluginEngine()) != null && pluginEngine.s(webViewProvider.getCurrentUrl(), 8589934615L, null)) {
                        vVar.D.f314013d.setVisibility(8);
                        SwiftFloatViewUI swiftFloatViewUI2 = vVar.D;
                        swiftFloatViewUI2.g(swiftFloatViewUI2.f314012c, true);
                        vVar.D.f314020k.setVisibility(8);
                        return;
                    }
                }
                vVar.D.f314013d.setVisibility(8);
                SwiftFloatViewUI swiftFloatViewUI3 = vVar.D;
                swiftFloatViewUI3.g(swiftFloatViewUI3.f314012c, true);
                vVar.D.f314020k.setVisibility(8);
                webViewProvider.getHostActivity().finish();
                ReportController.n(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "exit", "", "", "");
                return;
            }
            if (view == swiftFloatViewUI.f314017h) {
                if (SwiftBrowserShareMenuHandler.f314290n0 != -1) {
                    SwiftBrowserShareMenuHandler.f314290n0 = -1L;
                }
                swiftFloatViewUI.f314013d.setVisibility(8);
                SwiftFloatViewUI swiftFloatViewUI4 = vVar.D;
                swiftFloatViewUI4.g(swiftFloatViewUI4.f314012c, true);
                vVar.D.f314020k.setVisibility(8);
                webViewProvider.showActionSheet();
                ReportCenter.f().p("", "", "", "1000", "100", "0", false);
                ReportController.n(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "share", "", "", "");
                if (rVar.W) {
                    LpReportInfo_dc02216.reportShare();
                    return;
                }
                return;
            }
            if (view == swiftFloatViewUI.f314019j) {
                Intent intent2 = new Intent(webViewProvider.getHostActivity(), (Class<?>) QQBrowserActivity.class);
                intent2.putExtra("key_isReadModeEnabled", true);
                intent2.putExtra("url", "https://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155");
                webViewProvider.getHostActivity().startActivity(intent2);
                webViewProvider.getHostActivity().finish();
                ReportController.n(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "mUIStyleHandler.moreGame", "https://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155", "", "");
                if (QLog.isColorLevel()) {
                    QLog.d("zivonchen", 2, "QQBrowserActivity 1 loadUrl = https://h5.qzone.qq.com/wanba/index?_bid=2044&_wv=2097155");
                    return;
                }
                return;
            }
            if (view == swiftFloatViewUI.f314018i) {
                swiftFloatViewUI.f314013d.setVisibility(8);
                SwiftFloatViewUI swiftFloatViewUI5 = vVar.D;
                swiftFloatViewUI5.g(swiftFloatViewUI5.f314012c, true);
                vVar.D.f314020k.setVisibility(8);
                if (webViewProvider instanceof com.tencent.mobileqq.webviewplugin.n) {
                    Share share = (Share) ((com.tencent.mobileqq.webviewplugin.n) webViewProvider).getShare();
                    if (share != null && !TextUtils.isEmpty(share.f97470w0)) {
                        webViewProvider.getWebView().callJs(share.f97470w0, "");
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("WebViewSurfaceInjectorImpl", 2, "call js function getShare().mOnShareHandler");
                    }
                }
                ReportController.n(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, "senddesk", "", "", "");
                if (rVar.W) {
                    LpReportInfo_dc02216.reportExit();
                    return;
                }
                return;
            }
            if (view == swiftFloatViewUI.f314016g) {
                swiftFloatViewUI.f314013d.setVisibility(8);
                SwiftFloatViewUI swiftFloatViewUI6 = vVar.D;
                swiftFloatViewUI6.g(swiftFloatViewUI6.f314012c, true);
                vVar.D.f314020k.setVisibility(8);
                if (rVar.V) {
                    if (TextUtils.isEmpty(webViewProvider.getWebView().getTitle())) {
                        title = HardCodeUtil.qqStr(R.string.vk6);
                    } else {
                        title = webViewProvider.getWebView().getTitle();
                    }
                    com.tencent.mobileqq.webview.swift.utils.s.f(String.format(HardCodeUtil.qqStr(R.string.f172920vk1), title), R.drawable.c47, null, SingleTaskQQBrowser.class.getName(), webViewProvider);
                    ReportController.n(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_click", 0, 1, 0, QCircleDaTongConstant.ElementParamValue.PYMK_FOLD, "", "", "");
                    return;
                }
                if (rVar.U) {
                    com.tencent.mobileqq.webview.swift.utils.s.e(webViewProvider);
                    return;
                }
                return;
            }
            if (view == swiftFloatViewUI.f314021l) {
                swiftFloatViewUI.f314013d.setVisibility(8);
                SwiftFloatViewUI swiftFloatViewUI7 = vVar.D;
                swiftFloatViewUI7.g(swiftFloatViewUI7.f314012c, true);
                vVar.D.f314020k.setVisibility(8);
                try {
                    this.f314137j = WebSoService.j().h();
                    M(webViewProvider);
                    JSONObject jSONObject = new JSONObject(this.f314136i);
                    String str = "https://h5.qzone.qq.com/miniapp/act/h5gameSetting?" + ("pf=" + jSONObject.getString(AdParam.PF) + ContainerUtils.FIELD_DELIMITER) + ("openid=" + jSONObject.getString("openid") + ContainerUtils.FIELD_DELIMITER) + ("openkey=" + jSONObject.getString("openkey") + ContainerUtils.FIELD_DELIMITER) + ("appid=" + jSONObject.getString("appid") + ContainerUtils.FIELD_DELIMITER) + ("loginType=" + jSONObject.getString(TangramHippyConstants.LOGIN_TYPE));
                    Intent intent3 = new Intent(webViewProvider.getHostActivity(), (Class<?>) QQBrowserActivity.class);
                    intent3.putExtra("url", str);
                    webViewProvider.getHostActivity().startActivity(intent3);
                    QLog.d("WebViewSurfaceInjectorImpl", 2, "OPEN_DATA AUTHORIZATION_SETTING_URL " + str);
                    return;
                } catch (JSONException e16) {
                    T(webViewProvider, true);
                    QLog.e("WebViewSurfaceInjectorImpl", 2, "OPEN_DATA PARSE ERROR: " + e16);
                    return;
                }
            }
            if (view == vVar.N) {
                HashMap hashMap = new HashMap();
                hashMap.put("intent", webViewProvider.getIntent());
                webViewProvider.getWebView().getPluginEngine().s(webViewProvider.getWebView().getUrl(), 8589934622L, hashMap);
                return;
            }
            return;
        }
        if (SwiftBrowserShareMenuHandler.f314290n0 != -1) {
            SwiftBrowserShareMenuHandler.f314290n0 = -1L;
        }
        Intent intent4 = new Intent();
        intent4.setAction("SignInSbumited");
        BaseApplicationImpl.getApplication().sendBroadcast(intent4);
        if (!S(webViewProvider.getWebView(), swiftIphoneTitleBarUI)) {
            ReportCenter.f().p("", "", "", "1000", "100", "0", false);
            webViewProvider.showActionSheet();
        }
        View view3 = vVar.Q;
        if (view3 != null && (parent = view3.getParent()) != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(vVar.Q);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public void w(WebViewProvider webViewProvider, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) webViewProvider, (Object) bundle);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public void x(WebViewProvider webViewProvider, WebView webView, int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, webViewProvider, webView, Integer.valueOf(i3), str, str2);
        } else {
            SwiftBrowserStatistics swiftBrowserStatistics = (SwiftBrowserStatistics) webViewProvider.getComponentProvider().a(-2);
            MobileReportManager.getInstance().reportH5Trace(webViewProvider.getCurrentUrl(), 132, System.currentTimeMillis() - swiftBrowserStatistics.f314361h, String.valueOf(i3), swiftBrowserStatistics.M0, swiftBrowserStatistics.N0);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public boolean y(WebViewProvider webViewProvider, WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, this, webViewProvider, webView, str)).booleanValue();
        }
        String k3 = com.tencent.mobileqq.webview.swift.utils.i.k(str);
        if (("http".equals(k3) || "data".equals(k3)) && (webViewProvider.getHostActivity() instanceof QQBrowserActivity)) {
            if (webViewProvider.getAppRuntime() != null) {
                AppRuntime appRuntime = webViewProvider.getAppRuntime();
                int i3 = QQManagerFactory.URL_INTECEPT_MANAGER;
                if (appRuntime.getManager(i3) != null) {
                    String a16 = ((URLInterceptManager) webViewProvider.getAppRuntime().getManager(i3)).a(str);
                    if (a16 != null) {
                        Intent intent = new Intent(webViewProvider.getHostActivity(), (Class<?>) JumpActivity.class);
                        intent.setData(Uri.parse(a16));
                        intent.putExtra("from", "webview");
                        webViewProvider.getHostActivity().startActivity(intent);
                        return true;
                    }
                    return false;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("WebViewSurfaceInjectorImpl", 2, "URLInterceptManager = null");
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.y
    public boolean z(WebViewProvider webViewProvider, int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, webViewProvider, Integer.valueOf(i3), Integer.valueOf(i16), intent)).booleanValue();
        }
        if (i16 == -1) {
            if (i3 != 2) {
                if (i3 != 11) {
                    if (i3 == 28675) {
                        if (intent != null) {
                            String stringExtra = intent.getStringExtra("DELETE_BLOG");
                            if (webViewProvider.getWebView() != null) {
                                webViewProvider.getWebView().loadUrl(stringExtra);
                            }
                        }
                    }
                }
                if (intent != null) {
                    boolean booleanExtra = intent.getBooleanExtra("click_long_screen_shot", false);
                    QLog.d("WebViewSurfaceInjectorImpl", 1, "REQUEST_TO_SCREEN_SHOT_PAGE. clickLongScreenShot is " + booleanExtra);
                    if (booleanExtra && webViewProvider.getWebView() != null) {
                        QLog.d("WebViewSurfaceInjectorImpl", 1, "start screen long shot");
                        ScreenShotUtil.g(webViewProvider.getWebView(), new d(webViewProvider));
                    }
                }
            } else {
                QfavBuilder.l0(webViewProvider.getHostActivity(), intent);
                return true;
            }
        }
        if (!TextUtils.isEmpty(webViewProvider.getCurrentUrl()) && webViewProvider.getCurrentUrl().contains("closeSpecialLogic=1") && intent != null && intent.getBooleanExtra("closeSpecialLogic", false)) {
            webViewProvider.getHostActivity().setResult(-1, intent);
            webViewProvider.getHostActivity().finish();
            return true;
        }
        if (i3 == 21) {
            if (intent != null && intent.getExtras() != null && !intent.getExtras().isEmpty() && intent.getExtras().getInt("uintype", 0) != 10027) {
                Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(webViewProvider.getHostActivity()), null);
                m3.putExtras(new Bundle(intent.getExtras()));
                webViewProvider.getHostActivity().startActivity(m3);
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WebViewSurfaceInjectorImpl", 2, "onActivityResult, requestCode=" + i3 + ", resultCode=" + i16);
        }
        if (!WBShareHelper.k(intent, i3)) {
            return false;
        }
        J(webViewProvider, intent, i3, i16);
        return true;
    }
}
