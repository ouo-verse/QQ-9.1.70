package com.tencent.comic.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.comic.VipComicHelper;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.comic.jsp.QQComicJsPlugin;
import com.tencent.comic.utils.QQComicPluginBridge;
import com.tencent.comic.webbundle.WebBundleFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.f;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.webview.swift.h;
import com.tencent.mobileqq.webview.swift.u;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.mobileqq.webview.swift.x;
import com.tencent.mobileqq.webview.util.k;
import com.tencent.mobileqq.webviewplugin.q;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.LiuHaiUtils;
import com.tencent.webbundle.sdk.IWebBundleRuntime;
import com.tencent.webbundle.sdk.WebBundleConstants;
import com.tencent.webbundle.sdk.WebBundleManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QQComicFragment extends WebViewFragment implements h {
    private QQComicJsPlugin C;
    private long D;
    private Observer E;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements Observer {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WebView f99413d;

        a(WebView webView) {
            this.f99413d = webView;
        }

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            if (QQComicPluginBridge.f99474c != null) {
                QLog.d(WebViewFragment.TAG, 4, "RuntimeCreateObserver update ");
                QQComicPluginBridge.f99474c.a(this.f99413d.getContext());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c extends com.tencent.mobileqq.webview.swift.proxy.a {
        c(t tVar) {
            super(tVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public String getUAMark() {
            return "VipComic";
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(Bundle bundle) {
            QQComicFragment.this.onFinalState(bundle, this.webViewKernelCallBack);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageFinished(WebView webView, String str) {
            QQComicFragment.this.yh(webView, str, this.webViewKernelCallBack);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onWebViewInit(Bundle bundle, TouchWebView touchWebView) {
            QQComicFragment.this.zh(bundle, touchWebView, this.webViewKernelCallBack);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class d extends com.tencent.mobileqq.webview.swift.proxy.b {
        d(q qVar) {
            super(qVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.b, com.tencent.mobileqq.webviewplugin.q
        public void Ad(boolean z16) {
            this.f314614d.Ad(z16);
            QQComicFragment.this.sh();
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.b, com.tencent.mobileqq.webviewplugin.q
        public void Kb(int i3, int i16) {
            int statusBarHeight = ImmersiveUtils.isSupporImmersive() == 1 ? ImmersiveUtils.getStatusBarHeight(com.tencent.comic.utils.a.b()) : 0;
            if (!QQComicFragment.this.getUIStyleHandler().f314512m.f314619b && !QQComicFragment.this.getUIStyle().f314641x && (QQComicFragment.this.D & 1) == 1 && LiuHaiUtils.sHasNotch) {
                i16 -= statusBarHeight;
                i3 -= statusBarHeight;
            }
            super.Kb(i3, i16);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.b, com.tencent.mobileqq.webviewplugin.q
        public void u5(boolean z16) {
            this.f314614d.u5(z16);
            QQComicFragment.this.sh();
        }
    }

    private void Ah() {
        long currentTimeMillis = System.currentTimeMillis();
        CookieManager cookieManager = CookieManager.getInstance();
        String qimei = ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).getQimei();
        if (TextUtils.isEmpty(qimei)) {
            if (QLog.isColorLevel()) {
                QLog.d(WebViewFragment.TAG, 2, "the qimei is null");
                return;
            }
            return;
        }
        if (cookieManager != null) {
            String cookie = cookieManager.getCookie(this.mUrl);
            if (cookie != null) {
                if (cookie.contains("qimei=")) {
                    if (QLog.isColorLevel()) {
                        QLog.d(WebViewFragment.TAG, 2, "the cookie has qimei!");
                    }
                    QLog.i(WebViewFragment.TAG, 1, "get qimei cost: " + (System.currentTimeMillis() - currentTimeMillis));
                    return;
                }
                String rh5 = rh(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, qimei, "vip.qq.com");
                QLog.d(WebViewFragment.TAG, 4, "new cookie:" + rh5);
                String str = this.mUrl;
                if (str != null && !str.isEmpty()) {
                    cookieManager.setCookie(this.mUrl, rh5);
                }
                Bh();
                if (QLog.isColorLevel()) {
                    QLog.d(WebViewFragment.TAG, 2, "cookieManager sync after cookie is " + cookieManager.getCookie(this.mUrl));
                }
            } else {
                QLog.e(WebViewFragment.TAG, 1, "cookie is null");
            }
            QLog.i(WebViewFragment.TAG, 1, "set qimei cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private void Bh() {
        try {
            QLog.d(WebViewFragment.TAG, 1, "[cookie] sync cookie.");
            CookieSyncManager.getInstance().sync();
        } catch (IllegalStateException unused) {
            if (getAppRuntime().getApp() != null) {
                CookieSyncManager.createInstance(getAppRuntime().getApp());
                CookieSyncManager.getInstance().sync();
                QLog.w(WebViewFragment.TAG, 2, "sync failed, createInstance first");
                return;
            }
            QLog.w(WebViewFragment.TAG, 2, "application is null");
        } catch (Exception unused2) {
            QLog.e(WebViewFragment.TAG, 1, "sync failed, encounter unexpected problem! ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sh() {
        if (getHostActivity() == null || this.contentView == null) {
            return;
        }
        LiuHaiUtils.initLiuHaiProperty(getHostActivity());
        LiuHaiUtils.enableNotch(getHostActivity());
        if (LiuHaiUtils.sHasNotch) {
            int i3 = (this.D & 1) == 1 ? LiuHaiUtils.sNotchHeight : 0;
            FrameLayout c16 = this.contentView.c();
            if (c16 != null) {
                c16.setPadding(0, i3, 0, 0);
                c16.setBackgroundColor(-16777216);
            }
        }
    }

    public static WebViewFragment wh(Intent intent) {
        WebViewFragment qQComicFragment;
        if (Boolean.valueOf(intent.getBooleanExtra(WebBundleConstants.OPEN_WITH_WEBBUNDLE, false)).booleanValue()) {
            qQComicFragment = new WebBundleFragment();
        } else {
            qQComicFragment = new QQComicFragment();
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent", intent);
        qQComicFragment.setArguments(bundle);
        ((IQQComicUtil) QRoute.api(IQQComicUtil.class)).fetchReportInfo(intent, true);
        return qQComicFragment;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public com.tencent.mobileqq.webview.swift.component.b createComponentsProvider() {
        return new com.tencent.mobileqq.webview.swift.component.b(this, 1023, new b());
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public q getWebTitleBarInterface() {
        return new d(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public t getWebViewKernelCallBack() {
        return new c(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.webview.swift.h
    public WebViewFragment newInstance(int i3, u uVar, WebViewTabBarData webViewTabBarData, Intent intent) {
        String stringExtra = intent.getStringExtra("url");
        if (TextUtils.isEmpty(Uri.parse(stringExtra).getQueryParameter("_titleBarHeight"))) {
            int dimensionPixelSize = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height) + ImmersiveUtils.getStatusBarHeight(MobileQQ.sMobileQQ.getApplicationContext());
            intent.putExtra("url", ((IQQComicUtil) QRoute.api(IQQComicUtil.class)).addParamToUrl(stringExtra, "_titleBarHeight=" + dimensionPixelSize));
        }
        return wh(intent);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == getSwiftTitleUI().E || view == getSwiftTitleUI().D) && getSwiftTitleUI().T) {
            getSwiftTitleUI().d0(false);
            if (getAppRuntime() != null && getAppRuntime().getApp() != null) {
                getAppRuntime().getApp().getSharedPreferences("boodo_" + getAppRuntime().getCurrentAccountUin(), 0).edit().putBoolean("private_read_red_dot", true).apply();
            }
        }
        super.onClick(view);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Parcelable parcelableExtra = this.intent.getParcelableExtra("defaultResultData");
        if (parcelableExtra instanceof Intent) {
            getQBaseActivity().setResult(0, (Intent) parcelableExtra);
        }
        vh();
        VipComicHelper.c(getAppRuntime());
        VipComicHelper.d(getHostActivity());
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QQComicPluginBridge.j(this.E);
        this.E = null;
        FragmentActivity activity = getActivity();
        IWebBundleRuntime runtime = WebBundleManager.getInstance("comic").getRuntime();
        if (activity == null || !activity.isFinishing() || runtime == null || activity != runtime.getContext()) {
            return;
        }
        WebBundleManager.getInstance("comic").destroy();
        QLog.w(WebViewFragment.TAG, 1, "activity finish and destroy webBundle");
    }

    public void onFinalState(Bundle bundle, t tVar) {
        sh();
        tVar.onFinalState(bundle);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        QQComicJsPlugin th5 = th();
        if (th5 != null) {
            th5.B();
        }
    }

    public QQComicJsPlugin th() {
        QQComicJsPlugin qQComicJsPlugin = this.C;
        if (qQComicJsPlugin != null) {
            return qQComicJsPlugin;
        }
        if (getWebView() == null || getWebView().getPluginEngine() == null) {
            return null;
        }
        WebViewPlugin m3 = getWebView().getPluginEngine().m("comic");
        if (!(m3 instanceof QQComicJsPlugin)) {
            return null;
        }
        QQComicJsPlugin qQComicJsPlugin2 = (QQComicJsPlugin) m3;
        this.C = qQComicJsPlugin2;
        return qQComicJsPlugin2;
    }

    public boolean xh() {
        QQComicJsPlugin th5 = th();
        if (th5 != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("status", th5.f99386f.get());
                jSONObject.put("data", jSONObject2);
            } catch (Exception unused) {
            }
            if (QLog.isColorLevel()) {
                QLog.d(WebViewFragment.TAG, 2, "notifySecretModeChange. status=" + th5.f99386f.get());
            }
            if (!TextUtils.isEmpty(th5.f99385e)) {
                getWebView().callJs(th5.f99385e, jSONObject.toString());
            }
        }
        return true;
    }

    public void yh(WebView webView, String str, t tVar) {
        tVar.onPageFinished(webView, str);
        QLog.d(WebViewFragment.TAG, 4, "QQComicFragment onPageFinished ");
        if (QQComicPluginBridge.f99474c != null) {
            QLog.d(WebViewFragment.TAG, 4, "QQComicPluginBridge sFirstInObservable is not null ");
            QQComicPluginBridge.f99474c.a(webView.getContext());
        }
        a aVar = new a(webView);
        this.E = aVar;
        QQComicPluginBridge.l(aVar);
    }

    public void zh(Bundle bundle, TouchWebView touchWebView, t tVar) {
        try {
            String str = this.mUrl;
            if (str != null && this.D == 0) {
                QLog.d(WebViewFragment.TAG, 2, "dealWithWvx: url=", str);
                String queryParameter = Uri.parse(this.mUrl).getQueryParameter("_wvx");
                if (queryParameter != null) {
                    this.D = Long.parseLong(queryParameter, 10);
                }
            }
        } catch (Exception e16) {
            QLog.e(WebViewFragment.TAG, 2, "dealWithWvx: ", e16);
        }
        tVar.onWebViewInit(bundle, touchWebView);
        Ah();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class e extends SwiftBrowserShareMenuHandler {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes32.dex */
        public class a implements f {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f99419d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f99420e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f99421f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ byte[] f99422h;

            a(String str, String str2, String str3, byte[] bArr) {
                this.f99419d = str;
                this.f99420e = str2;
                this.f99421f = str3;
                this.f99422h = bArr;
            }

            @Override // com.tencent.mobileqq.colornote.f
            public ColorNote getColorNote() {
                return new ColorNote.a().g(android.R.id.empty).i(this.f99419d).d(this.f99420e).h(this.f99421f).e("resdrawable://2131232261").f(this.f99422h).a();
            }
        }

        e() {
        }

        private void U() {
            k webColorNoteInjector = ((QQBrowserActivity) this.f314297f).getWebColorNoteInjector();
            if (webColorNoteInjector != null) {
                webColorNoteInjector.d();
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler, com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            int i3;
            this.C.dismiss();
            int i16 = actionSheetItem.action;
            String shareUrl = getShareUrl();
            String[] uh5 = QQComicFragment.this.uh();
            String str = uh5[0];
            String str2 = uh5[1];
            String str3 = uh5[2];
            String str4 = uh5[3];
            String str5 = uh5[4];
            if (i16 == 2 || i16 == 73) {
                if (TextUtils.isEmpty(this.f314302i.f97463p0)) {
                    this.f314302i.E(shareUrl, 1, false);
                    return;
                } else {
                    this.f314302i.R(shareUrl, 1, false);
                    return;
                }
            }
            if (i16 == 3) {
                if (TextUtils.isEmpty(this.f314302i.f97463p0)) {
                    this.f314302i.E(shareUrl, 2, false);
                    return;
                } else {
                    this.f314302i.R(shareUrl, 2, false);
                    return;
                }
            }
            if (i16 == 9 || i16 == 10) {
                if (WXShareHelper.b0().e0()) {
                    i3 = !WXShareHelper.b0().f0() ? R.string.f173258ih2 : -1;
                } else {
                    i3 = R.string.f173257ih1;
                }
                if (i3 != -1) {
                    QQToast.makeText(QQComicFragment.this.getContext(), 0, i3, 1).show(QQComicFragment.this.getResources().getDimensionPixelSize(R.dimen.f12828i));
                    return;
                }
                if (i16 == 9) {
                    if (TextUtils.isEmpty(this.f314302i.f97463p0)) {
                        this.f314302i.E(shareUrl, 3, true);
                        return;
                    } else {
                        this.f314302i.R(shareUrl, 3, false);
                        return;
                    }
                }
                if (TextUtils.isEmpty(this.f314302i.f97463p0)) {
                    this.f314302i.E(shareUrl, 4, true);
                    return;
                } else {
                    this.f314302i.R(shareUrl, 4, false);
                    return;
                }
            }
            if (i16 == 14) {
                if (TextUtils.isEmpty(this.f314302i.f97463p0)) {
                    return;
                }
                QQComicFragment.this.getWebView().callJs(this.f314302i.f97463p0, "6");
                com.tencent.comic.h.b((AppInterface) QQComicFragment.this.getAppRuntime(), str, str2, str3, "1", str4, str5);
                return;
            }
            if (i16 == 117) {
                com.tencent.comic.h.b((AppInterface) QQComicFragment.this.getAppRuntime(), str, str2, str3, "5", str4, str5);
                QQComicFragment.this.xh();
                return;
            }
            if (i16 == 116) {
                com.tencent.comic.h.b((AppInterface) QQComicFragment.this.getAppRuntime(), str, str2, str3, "4", str4, str5);
                QQComicFragment.this.xh();
                return;
            }
            if (i16 == 70) {
                com.tencent.comic.h.b((AppInterface) QQComicFragment.this.getAppRuntime(), str, str2, str3, "2", str4, str5);
                U();
                return;
            }
            if (i16 == 82) {
                com.tencent.comic.h.b((AppInterface) QQComicFragment.this.getAppRuntime(), str, str2, str3, "3", str4, str5);
                U();
                return;
            }
            if (i16 != 72) {
                if (i16 == 40) {
                    if (TextUtils.isEmpty(this.f314302i.f97463p0)) {
                        return;
                    }
                    com.tencent.comic.h.b((AppInterface) QQComicFragment.this.getAppRuntime(), str, str2, str3, "10", str4, str5);
                    QQComicFragment.this.getWebView().callJs(this.f314302i.f97463p0, "7");
                    return;
                }
                if (i16 != 11 || TextUtils.isEmpty(this.f314302i.f97463p0)) {
                    return;
                }
                com.tencent.comic.h.b((AppInterface) QQComicFragment.this.getAppRuntime(), str, str2, str3, "9", str4, str5);
                QQComicFragment.this.getWebView().callJs(this.f314302i.f97463p0, "8");
                return;
            }
            if (this.f314301h0 == null) {
                this.f314301h0 = new Bundle();
            }
            this.f314301h0.putString("to_qq", actionSheetItem.uin);
            this.f314301h0.putString("to_uin_name", actionSheetItem.label);
            this.f314301h0.putInt(ShortVideoConstants.TO_UIN_TYPE, actionSheetItem.uinType);
            if (TextUtils.isEmpty(this.f314302i.f97463p0)) {
                this.f314302i.E(shareUrl, 1, false);
                return;
            }
            Share share = this.f314302i;
            if (share.W != null) {
                share.getSharePD().show();
                Share share2 = this.f314302i;
                share2.W.callJs(share2.f97463p0, String.valueOf(101));
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler
        public List<ShareActionSheetBuilder.ActionSheetItem>[] q() {
            ArrayList arrayList;
            QQComicJsPlugin qQComicJsPlugin;
            x xVar;
            int i3;
            String str;
            String str2;
            ArrayList arrayList2 = new ArrayList();
            String[] uh5 = QQComicFragment.this.uh();
            String str3 = uh5[0];
            String str4 = uh5[1];
            String str5 = uh5[2];
            String str6 = uh5[3];
            String str7 = uh5[4];
            com.tencent.comic.h.d((AppInterface) QQComicFragment.this.getAppRuntime(), str3, str4, str5, "6", str6, str7);
            if ((this.E & 8) == 0) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
                com.tencent.comic.h.d((AppInterface) QQComicFragment.this.getAppRuntime(), str3, str4, str5, "1", str6, str7);
            }
            if ((this.E & 16) == 0) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
                com.tencent.comic.h.d((AppInterface) QQComicFragment.this.getAppRuntime(), str3, str4, str5, "2", str6, str7);
            }
            boolean e06 = WXShareHelper.b0().e0();
            if ((this.E & 16384) == 0 && e06) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
                com.tencent.comic.h.d((AppInterface) QQComicFragment.this.getAppRuntime(), str3, str4, str5, "3", str6, str7);
            }
            if ((this.E & 32768) == 0 && e06) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
                com.tencent.comic.h.d((AppInterface) QQComicFragment.this.getAppRuntime(), str3, str4, str5, "4", str6, str7);
            }
            ArrayList arrayList3 = new ArrayList();
            if ((this.E & 8192) == 0) {
                arrayList3.add(ShareActionSheetBuilder.ActionSheetItem.build(14));
                arrayList = arrayList3;
                com.tencent.comic.h.c((AppInterface) QQComicFragment.this.getAppRuntime(), str3, str4, str5, "1", str6, str7);
            } else {
                arrayList = arrayList3;
            }
            QQComicJsPlugin th5 = QQComicFragment.this.th();
            if (th5 == null || th5.f99386f.get() < 0) {
                qQComicJsPlugin = th5;
            } else {
                boolean z16 = th5.f99386f.get() == 1;
                arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(z16 ? 117 : 116));
                if (z16) {
                    str2 = "5";
                } else {
                    str2 = "4";
                }
                qQComicJsPlugin = th5;
                com.tencent.comic.h.c((AppInterface) QQComicFragment.this.getAppRuntime(), str3, str4, str5, str2, str6, str7);
            }
            QQBrowserActivity qQBrowserActivity = (QQBrowserActivity) this.f314297f;
            String originalUrl = qQBrowserActivity.getOriginalUrl();
            if (originalUrl != null && originalUrl.indexOf("cancelColorTab=1") == -1 && (xVar = (x) qQBrowserActivity.getWebColorNoteInjector()) != null) {
                V(xVar, qQBrowserActivity);
                if (xVar.a(originalUrl)) {
                    if (xVar.isColorNoteExist()) {
                        i3 = 82;
                        str = "3";
                    } else {
                        i3 = 70;
                        str = "2";
                    }
                    arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(i3));
                    com.tencent.comic.h.c((AppInterface) QQComicFragment.this.getAppRuntime(), str3, str4, str5, str, str6, str7);
                }
            }
            if (qQComicJsPlugin != null && (qQComicJsPlugin.f99389m & 2) > 0) {
                arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(11));
                com.tencent.comic.h.c((AppInterface) QQComicFragment.this.getAppRuntime(), str3, str4, str5, "9", str6, str7);
            }
            if (qQComicJsPlugin != null && (qQComicJsPlugin.f99389m & 1) > 0) {
                arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(40));
                com.tencent.comic.h.c((AppInterface) QQComicFragment.this.getAppRuntime(), str3, str4, str5, "10", str6, str7);
            }
            return new ArrayList[]{arrayList2, arrayList};
        }

        /* JADX WARN: Can't wrap try/catch for region: R(17:4|(1:6)(1:37)|7|(2:11|(1:13)(13:14|15|(2:17|(1:19)(10:20|21|(1:23)|24|25|26|27|(1:29)|30|31))|35|21|(0)|24|25|26|27|(0)|30|31))|36|15|(0)|35|21|(0)|24|25|26|27|(0)|30|31) */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x009d, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x009e, code lost:
        
            r0.printStackTrace();
         */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a7  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void V(x xVar, QQBrowserActivity qQBrowserActivity) {
            String str;
            String str2;
            String str3;
            String str4;
            if (xVar == null) {
                return;
            }
            QQComicJsPlugin th5 = QQComicFragment.this.th();
            if (th5 != null) {
                str = th5.f99387h;
                str2 = th5.f99388i;
            } else {
                str = "";
                str2 = "";
            }
            if (str.isEmpty() && QQComicFragment.this.getSwiftTitleUI() != null) {
                if (QQComicFragment.this.getSwiftTitleUI().e().isEmpty()) {
                    str3 = "\u6ce2\u6d1e\u52a8\u6f2b";
                    if (str2.isEmpty()) {
                        if (!str3.equals("\u6ce2\u6d1e\u52a8\u6f2b")) {
                            str4 = "\u6ce2\u6d1e\u52a8\u6f2b";
                            String originalUrl = qQBrowserActivity.getOriginalUrl();
                            String f16 = com.tencent.comic.utils.h.f(com.tencent.comic.utils.h.b(originalUrl, "from", "1041001"), "from", "1041001");
                            if (QLog.isColorLevel()) {
                                QLog.d(WebViewFragment.TAG, 2, "originalUrl is " + originalUrl + " ,newUrl is " + f16);
                            }
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("colorNoteType", 2);
                            if (QLog.isColorLevel()) {
                                QLog.d(WebViewFragment.TAG, 2, "ColorNote mainTitle is " + str3 + ",subTitle is " + str4 + ",subType is " + f16);
                            }
                            xVar.e(new a(f16, str3, str4, jSONObject.toString().getBytes()));
                        }
                        str2 = qQBrowserActivity.getOriginalUrl();
                    }
                    str4 = str2;
                    String originalUrl2 = qQBrowserActivity.getOriginalUrl();
                    String f162 = com.tencent.comic.utils.h.f(com.tencent.comic.utils.h.b(originalUrl2, "from", "1041001"), "from", "1041001");
                    if (QLog.isColorLevel()) {
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("colorNoteType", 2);
                    if (QLog.isColorLevel()) {
                    }
                    xVar.e(new a(f162, str3, str4, jSONObject2.toString().getBytes()));
                }
                str = QQComicFragment.this.getSwiftTitleUI().e();
            }
            str3 = str;
            if (str2.isEmpty()) {
            }
            str4 = str2;
            String originalUrl22 = qQBrowserActivity.getOriginalUrl();
            String f1622 = com.tencent.comic.utils.h.f(com.tencent.comic.utils.h.b(originalUrl22, "from", "1041001"), "from", "1041001");
            if (QLog.isColorLevel()) {
            }
            JSONObject jSONObject22 = new JSONObject();
            jSONObject22.put("colorNoteType", 2);
            if (QLog.isColorLevel()) {
            }
            xVar.e(new a(f1622, str3, str4, jSONObject22.toString().getBytes()));
        }
    }

    private String rh(String str, String str2, String str3) {
        return String.format("%s=%s; PATH=/; DOMAIN=.%s; Max-Age=31556926;", str, str2, str3);
    }

    String[] uh() {
        String[] strArr = new String[5];
        th();
        return strArr;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements b.d {
        b() {
        }

        @Override // com.tencent.mobileqq.webview.swift.component.b.d
        public Object a(int i3) {
            if (i3 != 4) {
                return null;
            }
            return new e();
        }
    }

    private void vh() {
    }
}
