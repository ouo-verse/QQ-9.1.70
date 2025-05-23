package com.tencent.qqmini.container.core;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qimei.webview.QmX5Webview;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmini.container.core.MiniWebView;
import com.tencent.qqmini.container.core.aq;
import com.tencent.qqmini.miniapp.plugin.EmbeddedWidgetClientFactory;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.core.BaseRuntimeImpl;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes23.dex */
public class MiniWebView extends QmX5Webview implements IJsService {
    private static final AtomicInteger U = new AtomicInteger(1);
    private String C;
    private int D;
    private final int E;
    private final ax F;
    private final com.tencent.qqmini.container.core.c G;
    private final Set<c> H;
    private String I;
    private JSONObject J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private l P;
    private NativeContainer Q;
    private d R;
    private EmbeddedWidgetClientFactory S;
    private boolean T;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a extends eu3.i {
        a(IMiniAppContext iMiniAppContext) {
            super(iMiniAppContext);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (!MiniWebView.this.N) {
                MiniWebView.this.g0();
            }
        }

        @Override // eu3.i, com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            super.onPageStarted(webView, str, bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class b implements aq.b {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(String str, ApkgInfo apkgInfo) {
            a(false, str, apkgInfo);
        }

        @Override // com.tencent.qqmini.container.core.aq.b
        public void a(boolean z16, final String str, final ApkgInfo apkgInfo) {
            if (z16) {
                MiniWebView.this.k0();
                QMLog.d("Mini-MiniWebView", "reloadMainPackage success\uff01");
            } else {
                eu3.f.i(new Runnable() { // from class: com.tencent.qqmini.container.core.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniWebView.b.this.c(str, apkgInfo);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface c {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface d {
        void onScroll(int i3, int i16);
    }

    public MiniWebView(ax axVar) {
        super(axVar.getContext());
        this.D = 0;
        this.T = false;
        this.F = axVar;
        this.E = U.getAndIncrement();
        this.G = axVar.p();
        this.H = new CopyOnWriteArraySet();
        M();
        axVar.K(this);
    }

    private void E() {
        if (!this.M) {
            return;
        }
        this.T = true;
        D("onHide");
    }

    private void F() {
        if (!this.M || !this.T) {
            return;
        }
        D("onShow");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void b0(String str, String str2) {
        QMLog.i("Mini-MiniWebView", "evaluatePageScript" + L());
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            QMLog.w("Mini-MiniWebView", "evaluatePageScript, pageFrame is empty:" + TextUtils.isEmpty(str) + ", pageScript is empty:" + TextUtils.isEmpty(str2));
        }
        H(str, "page-frame.js", null);
        H(str2, "page-script.js", null);
        h0(true, "");
    }

    private String L() {
        return ", instance: " + hashCode() + ", viewId: " + this.E + ", path: " + this.I;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void M() {
        setOverScrollMode(2);
        setHorizontalScrollBarEnabled(false);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalScrollBarEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        IX5WebViewExtension x5WebViewExtension = getX5WebViewExtension();
        if (x5WebViewExtension != null) {
            x5WebViewExtension.setVerticalTrackDrawable(null);
            EmbeddedWidgetClientFactory embeddedWidgetClientFactory = new EmbeddedWidgetClientFactory();
            this.S = embeddedWidgetClientFactory;
            boolean registerEmbeddedWidget = x5WebViewExtension.registerEmbeddedWidget(new String[]{"video"}, embeddedWidgetClientFactory);
            this.K = registerEmbeddedWidget;
            this.F.l(registerEmbeddedWidget);
            QMLog.i("Mini-MiniWebView", "registerEmbeddedWidget, success: " + this.K);
        }
        WebSettings settings = getSettings();
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(2);
        WebView.setWebContentsDebuggingEnabled(this.F.w());
        settings.setMixedContentMode(0);
        settings.setUserAgent(settings.getUserAgentString() + "QQ/MiniApp");
        try {
            if (getSettingsExtension() != null) {
                getSettingsExtension().setFirstScreenDetect(false);
            }
        } catch (Throwable th5) {
            QMLog.e("Mini-MiniWebView", "webView init exception!", th5);
        }
        addJavascriptInterface(this, "WeixinJSCore");
        setWebViewClient(new a(this.F));
        setWebChromeClient(new eu3.h());
        f0();
        o0();
        N();
        QMLog.i("Mini-MiniWebView", "webImpl: " + getView());
    }

    private void N() {
        NativeContainer nativeContainer = new NativeContainer(this.F, this);
        this.Q = nativeContainer;
        nativeContainer.setBackgroundColor(0);
        addView(this.Q, new FrameLayout.LayoutParams(-1, -1));
        setOnScrollListener(new d() { // from class: com.tencent.qqmini.container.core.y
            @Override // com.tencent.qqmini.container.core.MiniWebView.d
            public final void onScroll(int i3, int i16) {
                MiniWebView.this.V(i3, i16);
            }
        });
    }

    private void O() {
        l lVar = this.P;
        if (lVar != null) {
            int i3 = 2;
            if (this.D == 2) {
                i3 = 0;
            }
            lVar.onLoaded(i3, this.C);
        }
    }

    private boolean P(ApkgInfo apkgInfo, String str) {
        if (apkgInfo != null) {
            MiniAppInfo miniAppInfo = apkgInfo.mMiniAppInfo;
            try {
                String rootPath = apkgInfo.getRootPath(str);
                if (TextUtils.isEmpty(rootPath) || TextUtils.isEmpty(new File(ApkgManager.getApkgFolderPath(miniAppInfo), rootPath).getAbsolutePath())) {
                    return true;
                }
                if (!TextUtils.isEmpty(apkgInfo.readApkgToString(str))) {
                    return !r5.contains(new String(new byte[20]));
                }
            } catch (Throwable th5) {
                QMLog.e("Mini-MiniWebView", "cache is invalid path: " + this.I, th5);
            }
        }
        return true;
    }

    private boolean Q(ApkgInfo apkgInfo, String str) {
        if (apkgInfo != null) {
            try {
                String readApkgToString = apkgInfo.readApkgToString(AppBrandUtil.getUrlWithoutParams(str));
                if (!TextUtils.isEmpty(readApkgToString) && readApkgToString.contains("<script>")) {
                    if (readApkgToString.contains("</script>")) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th5) {
                QMLog.e("Mini-MiniWebView", "html is invalid path: " + this.I, th5);
            }
        }
        return true;
    }

    private Boolean R() {
        if (this.F.getMiniAppInfo() == null) {
            return Boolean.FALSE;
        }
        ApkgInfo apkgInfo = (ApkgInfo) this.F.getMiniAppInfo().apkgInfo;
        if (apkgInfo == null) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(new File(apkgInfo.getApkgFolderPath(), ApkgInfo.NAME_MAIN_APKG).exists());
    }

    private boolean S(ApkgInfo apkgInfo, String str) {
        if (apkgInfo.isUrlResReady(str, apkgInfo.mMiniAppInfo) && apkgInfo.isUrlFileExist(str)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(String str, ValueCallback valueCallback) {
        evaluateJavascript(str, com.tencent.qqmini.miniapp.util.AppBrandUtil.convertValueCallback(valueCallback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void U(ValueCallback valueCallback, Object obj) {
        if (valueCallback != null) {
            valueCallback.onReceiveValue(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(int i3, int i16) {
        this.Q.scrollTo(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W() {
        if (R().booleanValue()) {
            k0();
        } else {
            l0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(String str) {
        h0(false, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z() {
        Iterator<c> it = this.H.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.H.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(WeakReference weakReference, int i3, ApkgInfo apkgInfo, final String str) {
        QMLog.i("Mini-MiniWebView", "loadSubpackage finish, code: " + i3 + ", message: " + str + L());
        if (((MiniWebView) weakReference.get()) == null) {
            return;
        }
        if (i3 != 0) {
            eu3.f.i(new Runnable() { // from class: com.tencent.qqmini.container.core.v
                @Override // java.lang.Runnable
                public final void run() {
                    MiniWebView.this.X(str);
                }
            });
            return;
        }
        this.F.k(this.I);
        final String pageFrameJSStr = apkgInfo.getPageFrameJSStr(this.I);
        final String pageJsStr = apkgInfo.getPageJsStr(this.I);
        eu3.f.i(new Runnable() { // from class: com.tencent.qqmini.container.core.w
            @Override // java.lang.Runnable
            public final void run() {
                MiniWebView.this.Y(pageFrameJSStr, pageJsStr);
            }
        });
    }

    private void e0() {
        QMLog.i("Mini-MiniWebView", "loadContent, loadState: " + this.D + L());
        int i3 = this.D;
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3) {
                this.D = 1;
                eu3.f.h(new Runnable() { // from class: com.tencent.qqmini.container.core.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniWebView.this.W();
                    }
                });
            } else {
                O();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        QMLog.i("Mini-MiniWebView", "onFrameReady" + L());
        this.N = true;
        ApkgInfo v3 = this.F.v();
        BaselibLoader.BaselibContent o16 = this.F.o();
        H(eu3.c.d(), "default-config.js", null);
        H(o16.waWebviewJsStr, "QView.js", null);
        H(eu3.c.g(this.K), "default-config.js", null);
        H(eu3.c.a(v3), "app-config.json", null);
        if (this.F.w()) {
            H(o16.waRemoteDebugStr, "QRemoteDebug.js", null);
            H(o16.waConsoleJsStr, "QVConsole.js", null);
        }
        H(v3.getRootWxssJsContent(), "app-wxss.js", null);
        H(v3.getPageHtmlContent(((BaseRuntimeImpl.BaselibProvider) this.F.getManager(BaseRuntimeImpl.BaselibProvider.class)).getBasePageFrameStr()).jsStr, "page-frame.html", null);
        if (!TextUtils.isEmpty(this.I)) {
            e0();
        }
    }

    private void h0(boolean z16, String str) {
        int i3;
        if (z16) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        this.D = i3;
        this.C = str;
        O();
    }

    private void j0(String str, String str2) {
        ax axVar = this.F;
        if (axVar != null && this.M) {
            axVar.performAction(ServiceSubscribeEvent.obtain(str, str2, J()));
            evaluateSubscribeJS(str, str2, J());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        boolean z16;
        final WeakReference weakReference = new WeakReference(this);
        ApkgInfo apkgInfo = (ApkgInfo) this.F.getMiniAppInfo().apkgInfo;
        boolean S = S(apkgInfo, this.I);
        if (Q(apkgInfo, this.I) && P(apkgInfo, this.I)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (S && z16) {
            this.F.k(this.I);
            final String pageFrameJSStr = apkgInfo.getPageFrameJSStr(this.I);
            final String pageJsStr = apkgInfo.getPageJsStr(this.I);
            if (((MiniWebView) weakReference.get()) == null) {
                return;
            }
            eu3.f.i(new Runnable() { // from class: com.tencent.qqmini.container.core.u
                @Override // java.lang.Runnable
                public final void run() {
                    MiniWebView.this.b0(pageFrameJSStr, pageJsStr);
                }
            });
            return;
        }
        QMLog.d("Mini-MiniWebView", "isResourceReady:" + S + " , isCacheValid = " + z16);
        aq.e().l(apkgInfo, this.I, new ApkgManager.OnInitApkgListener() { // from class: com.tencent.qqmini.container.core.t
            @Override // com.tencent.qqmini.sdk.manager.ApkgManager.OnInitApkgListener
            public final void onInitApkgInfo(int i3, ApkgInfo apkgInfo2, String str) {
                MiniWebView.this.a0(weakReference, i3, apkgInfo2, str);
            }
        });
    }

    private void l0() {
        MiniAppInfo miniAppInfo = this.F.getMiniAppInfo();
        QMLog.d("Mini-MiniWebView", "deleteDirectory size:" + FileUtils.deleteDirectory(((ApkgInfo) this.F.getMiniAppInfo().apkgInfo).getApkgFolderPath()));
        aq.e().k(miniAppInfo, new b());
    }

    private void o0() {
        View view = getView();
        if (view == null) {
            return;
        }
        view.setBackgroundColor(0);
        Drawable background = view.getBackground();
        if (background != null) {
            background.setAlpha(0);
        }
    }

    public void B(final c cVar) {
        if (this.L) {
            cVar.getClass();
            eu3.f.i(new Runnable() { // from class: com.tencent.qqmini.container.core.x
                @Override // java.lang.Runnable
                public final void run() {
                    MiniWebView.c.this.a();
                }
            });
        } else {
            this.H.add(cVar);
        }
    }

    public final void C(String str, String str2, int i3) {
        H(eu3.c.f(str, str2, i3), null, null);
    }

    public void D(String str) {
        ax axVar;
        QMLog.d("Mini-MiniWebView", "dispatchLifecycleEvent:" + str + L());
        if (!TextUtils.isEmpty(str) && (axVar = this.F) != null && axVar.getJsService() != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event", str);
                if ("onLaunch".equals(str)) {
                    jSONObject.put("path", com.tencent.qqmini.sdk.launcher.utils.AppBrandUtil.getUrlWithoutParams(this.I));
                    jSONObject.put("query", com.tencent.qqmini.sdk.launcher.utils.AppBrandUtil.getQueryJson(this.I));
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            this.F.getJsService().evaluateSubscribeJS("onContainerLifecycle", jSONObject.toString(), this.E);
            return;
        }
        QMLog.e("Mini-MiniWebView", "dispatchLifecycleEvent, state error " + str + L());
    }

    public void H(String str, String str2, final ValueCallback valueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (valueCallback != null) {
                valueCallback.onReceiveValue("");
                return;
            }
            return;
        }
        evaluateJs(str, new ValueCallback() { // from class: com.tencent.qqmini.container.core.s
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                MiniWebView.U(valueCallback, obj);
            }
        });
    }

    public JSONObject I() {
        return this.J;
    }

    public int J() {
        return this.E;
    }

    public EmbeddedWidgetClientFactory K() {
        return this.S;
    }

    public void c0(String str) {
        d0(str, null);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public int createNativeBuffer(byte[] bArr, long j3, long j16) {
        return 0;
    }

    public void d0(String str, JSONObject jSONObject) {
        QMLog.d("Mini-MiniWebView", "load, path: " + str + ", params: " + jSONObject);
        this.I = str;
        this.J = jSONObject;
        if (this.N) {
            e0();
        }
    }

    @Override // com.tencent.smtt.sdk.WebView
    @UiThread
    public void destroy() {
        QMLog.i("Mini-MiniWebView", "destroy, isLogicReady: " + this.M + L());
        super.destroy();
        EmbeddedWidgetClientFactory embeddedWidgetClientFactory = this.S;
        if (embeddedWidgetClientFactory != null) {
            embeddedWidgetClientFactory.destroy();
        }
        NativeContainer nativeContainer = this.Q;
        if (nativeContainer != null) {
            nativeContainer.r();
        }
        D(MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.F.L(this);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public final void evaluateCallbackJs(int i3, String str) {
        H(eu3.c.c(i3, str), null, null);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public final void evaluateJs(final String str, final ValueCallback valueCallback) {
        eu3.f.i(new Runnable() { // from class: com.tencent.qqmini.container.core.q
            @Override // java.lang.Runnable
            public final void run() {
                MiniWebView.this.T(str, valueCallback);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public final void evaluateSubscribeJS(String str, String str2, int i3) {
        H(eu3.c.e(str, str2, i3), null, null);
    }

    public void f0() {
        loadUrl("https://appservice.qq.com/page-frame.html");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public byte[] getNativeBuffer(int i3) {
        return new byte[0];
    }

    public void i0() {
        QMLog.i("Mini-MiniWebView", "pause, isLogicReady: " + this.M + L());
        E();
        EmbeddedWidgetClientFactory embeddedWidgetClientFactory = this.S;
        if (embeddedWidgetClientFactory != null) {
            embeddedWidgetClientFactory.pause();
        }
        NativeContainer nativeContainer = this.Q;
        if (nativeContainer != null) {
            nativeContainer.b0();
        }
    }

    @JavascriptInterface
    public String invokeHandler(String str, String str2, int i3) {
        com.tencent.qqmini.container.core.c cVar;
        if ("initWeixinJSBridgeFinish".equals(str) || (cVar = this.G) == null) {
            return "";
        }
        return cVar.onWebViewNativeRequest(str, str2, this, i3, this.E);
    }

    public void m0() {
        QMLog.i("Mini-MiniWebView", "resume, isLogicReady: " + this.M + L());
        F();
        EmbeddedWidgetClientFactory embeddedWidgetClientFactory = this.S;
        if (embeddedWidgetClientFactory != null) {
            embeddedWidgetClientFactory.resume();
        }
        NativeContainer nativeContainer = this.Q;
        if (nativeContainer != null) {
            nativeContainer.k0();
        }
    }

    public void n0() {
        if (this.D != 3) {
            return;
        }
        this.D = 0;
        this.C = "";
        e0();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QMLog.d("Mini-MiniWebView", "onAttachedWindow isHardwareAccelerated: " + isHardwareAccelerated());
    }

    @Override // android.view.View
    protected void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
        d dVar = this.R;
        if (dVar != null) {
            dVar.onScroll(i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.smtt.sdk.WebView, android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (i3 != 0 && i16 != 0) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                float density = DisplayUtil.getDensity(getContext());
                jSONObject.put("windowWidth", (int) (i3 / density));
                jSONObject.put("windowHeight", (int) (i16 / density));
                jSONObject2.put("size", jSONObject);
            } catch (JSONException e16) {
                QMLog.e("Mini-MiniWebView", "onSizeChanged, JSONException!", e16);
            }
            j0("onViewDidResize", jSONObject2.toString());
        }
    }

    @JavascriptInterface
    public void publishHandler(String str, String str2, String str3) {
        com.tencent.qqmini.container.core.c cVar = this.G;
        if (cVar != null) {
            cVar.onWebViewEvent(str, str2, this.E);
        }
        if (str.equals("custom_event_GenerateFuncReady") && this.G != null) {
            this.M = true;
            D("onLaunch");
        }
        if (str.equals("custom_event_PAGE_EVENT") && !TextUtils.isEmpty(str2) && str2.contains("DOMReady")) {
            this.L = true;
            eu3.f.i(new Runnable() { // from class: com.tencent.qqmini.container.core.r
                @Override // java.lang.Runnable
                public final void run() {
                    MiniWebView.this.Z();
                }
            });
            this.F.performAction(AppStateEvent.obtain(11));
        }
    }

    public void setLoadCallback(l lVar) {
        this.P = lVar;
    }

    public void setOnScrollListener(d dVar) {
        this.R = dVar;
    }
}
