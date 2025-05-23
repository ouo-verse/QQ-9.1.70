package com.tencent.xweb;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.print.PrintDocumentAdapter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.textclassifier.TextClassifier;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.s0;
import com.tencent.luggage.wxa.ar.t0;
import com.tencent.luggage.wxa.ar.v0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.tq.f;
import com.tencent.luggage.wxa.tq.g;
import com.tencent.luggage.wxa.vq.d;
import com.tencent.luggage.wxa.wq.r;
import com.tencent.luggage.wxa.wq.s;
import com.tencent.luggage.wxa.yq.u;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xweb.debug.b;
import com.tencent.xweb.debug.c;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.ProxyWebViewClientExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WebView extends FrameLayout implements IWebView {

    /* renamed from: a, reason: collision with root package name */
    public WebViewKind f385002a;

    /* renamed from: b, reason: collision with root package name */
    public IWebView f385003b;

    /* renamed from: c, reason: collision with root package name */
    public b f385004c;

    /* renamed from: d, reason: collision with root package name */
    public View.OnLongClickListener f385005d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f385006e;

    /* renamed from: f, reason: collision with root package name */
    public final r f385007f;
    public static final WebViewKind sDefaultWebViewKind = WebViewKind.WV_KIND_PINUS;

    /* renamed from: g, reason: collision with root package name */
    public static WebViewKind f384997g = WebViewKind.WV_KIND_NONE;

    /* renamed from: h, reason: collision with root package name */
    public static String f384998h = "";

    /* renamed from: i, reason: collision with root package name */
    public static boolean f384999i = false;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f385000j = false;

    /* renamed from: k, reason: collision with root package name */
    public static final s f385001k = new s();

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum FullscreenVideoKind {
        NOT_HOOK,
        HOOK_NOT_EVALUTE_JS,
        HOOK_EVALUTE_JS
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
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
        public int f385010a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f385011b;

        public String getExtra() {
            return this.f385011b;
        }

        public int getType() {
            return this.f385010a;
        }

        public void setExtra(String str) {
            this.f385011b = str;
        }

        public void setType(int i3) {
            this.f385010a = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface PreInitCallback {
        void onCoreInitFailed();

        void onCoreInitFinished();
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static abstract class VisualStateCallback {
        public abstract void onComplete(long j3);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum WebViewKind {
        WV_KIND_NONE,
        WV_KIND_CW,
        WV_KIND_X5,
        WV_KIND_SYS,
        WV_KIND_PINUS
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class WebViewTransport {

        /* renamed from: a, reason: collision with root package name */
        public WebView f385013a;

        public WebViewTransport() {
        }

        @Nullable
        public synchronized WebView getWebView() {
            return this.f385013a;
        }

        public synchronized void setWebView(@Nullable WebView webView) {
            this.f385013a = webView;
        }
    }

    public WebView(Context context) throws CreateWebViewException {
        this(context, null);
    }

    public static void D() {
        boolean enableRemoteDebug = WebDebugCfg.getInst().getEnableRemoteDebug();
        x0.d("WebView", "initRemoteDebug, enableRemoteDebug:" + enableRemoteDebug + ", testMode:" + XWalkEnvironment.getBuildConfigXWebTestMode());
        if (enableRemoteDebug || XWalkEnvironment.getBuildConfigXWebTestMode()) {
            XWebSdk.setEnableRemoteDebug(true);
        }
        boolean remoteDebugStarted = WebDebugCfg.getInst().getRemoteDebugStarted();
        x0.d("WebView", "initRemoteDebug, remoteDebugStarted:" + remoteDebugStarted);
        if (remoteDebugStarted) {
            d.b(WebDebugCfg.getInst().getRemoteDebugToken());
        }
    }

    public static void E() {
        x0.a("WebView", "reinitToPinus");
        f384997g = WebViewKind.WV_KIND_NONE;
        XWalkEnvironment.refreshVersionInfo();
        initWebviewCore(XWalkEnvironment.getApplicationContext(), WebViewKind.WV_KIND_PINUS, f384998h, (PreInitCallback) null);
        n0.a(1749L, 66L, 1L);
    }

    public static Context b(Context context) {
        return context instanceof MutableContextWrapper ? new WebViewContextWrapper(((MutableContextWrapper) context).getBaseContext()) : context;
    }

    public static String c(String str) {
        if (str == null || str.isEmpty()) {
            str = "tools";
        }
        f384998h = str;
        n0.f(str);
        return str;
    }

    public static void clearClientCertPreferences(@Nullable Runnable runnable) {
        f b16 = g.b(getCurrentModuleWebCoreType());
        if (b16 != null) {
            b16.clearClientCertPreferences(runnable);
            return;
        }
        x0.c("WebView", "need init first clearClientCertPreferences error, getCurWebType:" + getCurrentModuleWebCoreType());
    }

    public static String findAddress(String str) {
        f b16 = g.b(getCurrentModuleWebCoreType());
        if (b16 != null) {
            return b16.findAddress(str);
        }
        x0.c("WebView", "need init first findAddress error, getCurWebType:" + getCurrentModuleWebCoreType());
        return "";
    }

    public static WebViewKind getCurrentModuleWebCoreType() {
        return f384997g;
    }

    public static String getModuleName() {
        return f384998h;
    }

    public static WebViewKind getPreferedWebviewType(WebViewKind webViewKind, String str) {
        x0.a("WebView", "getPreferedWebviewType start, kind:" + webViewKind + ", module:" + str);
        WebViewKind webViewKind2 = f384997g;
        WebViewKind webViewKind3 = WebViewKind.WV_KIND_NONE;
        if (webViewKind2 != webViewKind3) {
            x0.a("WebView", "getPreferedWebviewType end, already get webview type:" + f384997g);
            return f384997g;
        }
        if (com.tencent.luggage.wxa.ar.b.e()) {
            x0.a("WebView", "getPreferedWebviewType end, x86 device, use sys");
            n0.a(69L, 1);
            return WebViewKind.WV_KIND_SYS;
        }
        WebViewKind webViewKind4 = WebDebugCfg.getInst().getWebViewKind(str);
        if (webViewKind4 != webViewKind3) {
            x0.a("WebView", "use hard code webview type:" + webViewKind4);
            webViewKind = webViewKind4;
        } else if (XWalkEnvironment.getBuildConfigForceXWebCore()) {
            webViewKind = sDefaultWebViewKind;
            x0.a("WebView", "use compile config force to xweb");
        } else if (CommandCfg.getInstance().getWebKind(str) != webViewKind3) {
            webViewKind = CommandCfg.getInstance().getWebKind(str);
            x0.a("WebView", "use cmd config webview type:" + webViewKind);
        }
        n0.e(webViewKind);
        if ((webViewKind == WebViewKind.WV_KIND_CW || webViewKind == WebViewKind.WV_KIND_PINUS) && !XWalkEnvironment.hasAvailableVersion()) {
            webViewKind = WebViewKind.WV_KIND_SYS;
            f384999i = true;
            x0.a("WebView", "xweb is not available, use sys");
        }
        x0.a("WebView", "getPreferedWebviewType end, final webview type:" + webViewKind);
        return webViewKind;
    }

    private static WebViewKind[] getWebViewKindList() {
        String[] split;
        String cmd = CommandCfg.getInstance().getCmd("webview_kind_list", getModuleName());
        if (cmd != null && !cmd.equalsIgnoreCase("") && (split = cmd.split(",")) != null && split.length > 0) {
            WebViewKind[] webViewKindArr = new WebViewKind[split.length];
            for (int i3 = 0; i3 < split.length; i3++) {
                WebViewKind b16 = CommandCfg.getInstance().b(split[i3]);
                if (b16 != WebViewKind.WV_KIND_NONE) {
                    webViewKindArr[i3] = b16;
                } else {
                    x0.f("WebView", "getWebViewKindList, error config:" + cmd);
                    return new WebViewKind[0];
                }
            }
            x0.d("WebView", "getWebViewKindList:" + Arrays.toString(webViewKindArr));
            return webViewKindArr;
        }
        return new WebViewKind[]{WebViewKind.WV_KIND_PINUS, WebViewKind.WV_KIND_SYS};
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static boolean hasInited() {
        if (getCurrentModuleWebCoreType() == WebViewKind.WV_KIND_NONE) {
            x0.d("WebView", "hasInited false, current webview type is NONE");
            return false;
        }
        f b16 = g.b(getCurrentModuleWebCoreType());
        if (b16 == null) {
            x0.d("WebView", "hasInited false, current webview provider is null");
            return false;
        }
        return b16.hasInitedWebViewCore();
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static synchronized void initWebviewCore(Context context, WebViewKind webViewKind, String str, PreInitCallback preInitCallback) {
        synchronized (WebView.class) {
            x0.a("WebView", "initWebviewCore start, kind:" + webViewKind + ", module:" + str);
            if (f384997g != WebViewKind.WV_KIND_NONE) {
                if (f384997g != webViewKind) {
                    x0.a("WebView", "initWebviewCore, set invalid webview kind:" + webViewKind + ", expected:" + f384997g);
                    if (preInitCallback != null) {
                        preInitCallback.onCoreInitFailed();
                    }
                } else {
                    x0.a("WebView", "initWebviewCore, already init webview kind:" + webViewKind);
                    if (preInitCallback != null) {
                        preInitCallback.onCoreInitFinished();
                    }
                }
                return;
            }
            s sVar = f385001k;
            sVar.c();
            String c16 = c(str);
            XWalkEnvironment.ensureInitEnvironment(context);
            u.f();
            sVar.a(initWebviewCore(context, getPreferedWebviewType(webViewKind, c16), preInitCallback, true), f384997g.ordinal(), c16);
            x0.f("WebView", "###### initWebviewCore costTime:" + sVar.a() + ", stack:" + Log.getStackTraceString(new Throwable("please ignore this exception")));
        }
    }

    public static boolean isPinus() {
        if (f384997g == WebViewKind.WV_KIND_PINUS) {
            return true;
        }
        return false;
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static boolean isSys() {
        if (f384997g == WebViewKind.WV_KIND_SYS) {
            return true;
        }
        return false;
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static boolean isXWeb() {
        if (f384997g == WebViewKind.WV_KIND_PINUS) {
            return true;
        }
        return false;
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static boolean isXWebCoreInited() {
        return f385000j;
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static boolean needRebootProcess() {
        if (f384999i && s0.a(XWalkEnvironment.getApplicationContext()) > 0) {
            x0.d("WebView", "needRebootProcess, true because of has installed xweb core");
            return true;
        }
        if (isXWeb() && XWalkEnvironment.getAvailableVersion() > 0 && XWalkEnvironment.getInstalledNewstVersionForCurAbi() > XWalkEnvironment.getAvailableVersion()) {
            x0.d("WebView", "needRebootProcess, true because of has newer xweb version");
            return true;
        }
        return false;
    }

    public static void onXWebCoreInited() {
        f385000j = true;
    }

    public static void reinitToXWeb() {
        WebViewKind webViewKindFromInstalledNewstVersion = XWalkEnvironment.getWebViewKindFromInstalledNewstVersion(XWalkEnvironment.getApplicationContext());
        x0.a("WebView", "reinitToXWeb, webViewKind:" + webViewKindFromInstalledNewstVersion);
        if (webViewKindFromInstalledNewstVersion == WebViewKind.WV_KIND_PINUS) {
            E();
        }
    }

    public final String C() {
        return c(XWalkEnvironment.getSafeModuleName("tools"));
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int addDocumentStartJavaScript(String str, String[] strArr) {
        return this.f385003b.addDocumentStartJavaScript(str, strArr);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void addJavascriptInterface(Object obj, String str) {
        this.f385003b.addJavascriptInterface(obj, str);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean canGoBack() {
        return this.f385003b.canGoBack();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean canGoBackOrForward(int i3) {
        return this.f385003b.canGoBackOrForward(i3);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean canGoForward() {
        return this.f385003b.canGoForward();
    }

    @Deprecated
    public boolean canZoomIn() {
        return false;
    }

    @Deprecated
    public boolean canZoomOut() {
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void captureBitmap(IWebView.ICaptureBitmapCallback iCaptureBitmapCallback) {
        this.f385003b.captureBitmap(iCaptureBitmapCallback);
    }

    @Deprecated
    public Picture capturePicture() {
        return null;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void clearCache(boolean z16) {
        this.f385003b.clearCache(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void clearHistory() {
        this.f385003b.clearHistory();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void clearMatches() {
        this.f385003b.clearMatches();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void clearSslPreferences() {
        this.f385003b.clearSslPreferences();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void clearView() {
        this.f385003b.clearView();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public WebBackForwardList copyBackForwardList() {
        return this.f385003b.copyBackForwardList();
    }

    @Deprecated
    public PrintDocumentAdapter createPrintDocumentAdapter() {
        return null;
    }

    @Override // com.tencent.xweb.internal.IWebView
    @NonNull
    public WebMessagePort[] createWebMessageChannel() {
        return this.f385003b.createWebMessageChannel();
    }

    public void destroy() {
        Context context = getContext();
        if (context instanceof WebViewContextWrapper) {
            ((WebViewContextWrapper) context).setBindedWebview(null);
        }
        this.f385003b.destroy();
        if (!this.f385006e) {
            this.f385006e = true;
            WebViewCounter.decrease();
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void disablePlatformNotifications() {
        this.f385003b.disablePlatformNotifications();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void disableVideoJsCallback(boolean z16) {
        this.f385003b.disableVideoJsCallback(z16);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void documentHasImages(Message message) {
        this.f385003b.documentHasImages(message);
    }

    public void drawCanvas(Canvas canvas) {
        if (isXWebKernel()) {
            long currentTimeMillis = System.currentTimeMillis();
            for (TextureView textureView : a((View) this)) {
                Bitmap bitmap = textureView.getBitmap();
                x0.c("WebView", "drawCanvas, costTime1:" + (System.currentTimeMillis() - currentTimeMillis));
                if (bitmap != null) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    canvas.drawBitmap(bitmap, textureView.getLeft(), textureView.getTop(), (Paint) null);
                    x0.c("WebView", "drawCanvas, costTime2:" + (System.currentTimeMillis() - currentTimeMillis2) + ", view:" + textureView);
                } else {
                    x0.c("WebView", "drawCanvas, textureViewBitmap is null");
                }
            }
            getTopView().draw(canvas);
            x0.c("WebView", "drawCanvas, costTime:" + (System.currentTimeMillis() - currentTimeMillis));
            return;
        }
        draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j3) {
        try {
            return super.drawChild(canvas, view, j3);
        } catch (Throwable th5) {
            x0.f("WebView", "drawChild error:" + Log.getStackTraceString(th5));
            return false;
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void enablePlatformNotifications() {
        this.f385003b.enablePlatformNotifications();
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.f385003b.evaluateJavascript(str, valueCallback);
    }

    @Deprecated
    public int findAll(String str) {
        findAllAsync(str);
        return 0;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void findAllAsync(String str) {
        this.f385003b.findAllAsync(str);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void findNext(boolean z16) {
        this.f385003b.findNext(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void flingScroll(int i3, int i16) {
        this.f385003b.flingScroll(i3, i16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String getAbstractInfo() {
        return this.f385003b.getAbstractInfo();
    }

    public Bitmap getBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        if (createBitmap != null) {
            createBitmap.eraseColor(-1);
            Canvas canvas = new Canvas(createBitmap);
            if (isXWebKernel()) {
                try {
                    Paint paint = new Paint();
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
                    Iterator it = a((View) this).iterator();
                    while (it.hasNext()) {
                        Bitmap bitmap = ((TextureView) it.next()).getBitmap();
                        if (bitmap != null) {
                            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                        } else {
                            x0.c("WebView", "getBitmap, textureViewBitmap = null");
                        }
                    }
                    Bitmap createBitmap2 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                    getTopView().draw(new Canvas(createBitmap2));
                    canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, paint);
                } catch (Throwable th5) {
                    x0.a("WebView", "getBitmap, error", th5);
                }
            } else {
                draw(canvas);
            }
        }
        return createBitmap;
    }

    @Override // com.tencent.xweb.internal.IWebView
    @Nullable
    public SslCertificate getCertificate() {
        return this.f385003b.getCertificate();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getContentHeight() {
        return this.f385003b.getContentHeight();
    }

    public com.tencent.luggage.wxa.tq.a getCookieManager() {
        return null;
    }

    public WebViewKind getCurrentInstanceWebCoreType() {
        return this.f385002a;
    }

    @NonNull
    public b getDebugView() {
        return this.f385004c;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public Bitmap getFavicon() {
        return this.f385003b.getFavicon();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public FullscreenVideoKind getFullscreenVideoKind() {
        return this.f385003b.getFullscreenVideoKind();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public HitTestResult getHitTestResult() {
        return this.f385003b.getHitTestResult();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return this.f385003b.getHttpAuthUsernamePassword(str, str2);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean getImageBitmapToFile(String str, String str2, String str3, GetImageBitmapToFileFinishedCallback getImageBitmapToFileFinishedCallback) {
        return this.f385003b.getImageBitmapToFile(str, str2, str3, getImageBitmapToFileFinishedCallback);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String getOriginalUrl() {
        return this.f385003b.getOriginalUrl();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getProgress() {
        return this.f385003b.getProgress();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public float getScale() {
        return this.f385003b.getScale();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getScrollHeight() {
        return this.f385003b.getScrollHeight();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public WebSettings getSettings() {
        return this.f385003b.getSettings();
    }

    @Override // com.tencent.xweb.internal.IWebView
    @Nullable
    public TextClassifier getTextClassifier() {
        return this.f385003b.getTextClassifier();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String getTitle() {
        return this.f385003b.getTitle();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public ViewGroup getTopView() {
        return this.f385003b.getTopView();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String getUrl() {
        return this.f385003b.getUrl();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String getVersionInfo() {
        return this.f385003b.getVersionInfo();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public View getView() {
        return this.f385003b.getView();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getVisibleTitleHeight() {
        return this.f385003b.getVisibleTitleHeight();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public WebChromeClient getWebChromeClient() {
        return this.f385003b.getWebChromeClient();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getWebScrollX() {
        return this.f385003b.getWebScrollX();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getWebScrollY() {
        return this.f385003b.getWebScrollY();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public WebViewCallbackClient getWebViewCallbackClient() {
        return this.f385003b.getWebViewCallbackClient();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public WebViewClient getWebViewClient() {
        return this.f385003b.getWebViewClient();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public Looper getWebViewLooper() {
        return this.f385003b.getWebViewLooper();
    }

    @Override // com.tencent.xweb.internal.IWebView
    @Nullable
    public WebViewRenderProcessClient getWebViewRenderProcessClient() {
        return this.f385003b.getWebViewRenderProcessClient();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public View getWebViewUI() {
        return this.f385003b.getWebViewUI();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void goBack() {
        this.f385003b.goBack();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void goBackOrForward(int i3) {
        this.f385003b.goBackOrForward(i3);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void goForward() {
        this.f385003b.goForward();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean hasEnteredFullscreen() {
        return this.f385003b.hasEnteredFullscreen();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public Bundle invokeMiscMethod(String str, Bundle bundle) {
        return this.f385003b.invokeMiscMethod(str, bundle);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean isOverScrollStart() {
        return this.f385003b.isOverScrollStart();
    }

    @CalledByRuntime
    public boolean isSysKernel() {
        if (this.f385002a == WebViewKind.WV_KIND_SYS) {
            return true;
        }
        return false;
    }

    @CalledByRuntime
    @Deprecated
    public boolean isXWalkKernel() {
        if (this.f385002a == WebViewKind.WV_KIND_PINUS) {
            return true;
        }
        return false;
    }

    public boolean isXWebKernel() {
        if (this.f385002a == WebViewKind.WV_KIND_PINUS) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void leaveFullscreen() {
        this.f385003b.leaveFullscreen();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void loadData(String str, String str2, String str3) {
        this.f385003b.loadData(str, str2, str3);
        n0.a(str, this);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.f385003b.loadDataWithBaseURL(str, str2, str3, str4, str5);
        n0.a(str, this);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void loadUrl(String str, Map<String, String> map) {
        HashMap hashMap;
        if (this.f385004c.a(str)) {
            this.f385003b.loadUrl("http://weixin.qq.com/");
            return;
        }
        if (a(str)) {
            return;
        }
        if (map != null) {
            synchronized (map) {
                hashMap = new HashMap();
                hashMap.putAll(map);
            }
        } else {
            hashMap = null;
        }
        this.f385003b.loadUrl(str, hashMap);
        n0.a(str, this);
    }

    public void onHide() {
        this.f385003b.onHide();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void onPause() {
        this.f385003b.onPause();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void onResume() {
        this.f385003b.onResume();
    }

    public void onShow() {
        this.f385003b.onShow();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        IWebView iWebView = this.f385003b;
        if (iWebView != null) {
            iWebView.getView().setVisibility(i3);
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean overlayHorizontalScrollbar() {
        return this.f385003b.overlayHorizontalScrollbar();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean overlayVerticalScrollbar() {
        return this.f385003b.overlayVerticalScrollbar();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean pageDown(boolean z16) {
        return this.f385003b.pageDown(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean pageUp(boolean z16) {
        return this.f385003b.pageUp(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void pauseTimers() {
        this.f385003b.pauseTimers();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void postUrl(@NonNull String str, @NonNull byte[] bArr) {
        this.f385003b.postUrl(str, bArr);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void postVisualStateCallback(long j3, VisualStateCallback visualStateCallback) {
        this.f385003b.postVisualStateCallback(j3, visualStateCallback);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void postWebMessage(@NonNull WebMessage webMessage, @NonNull Uri uri) {
        this.f385003b.postWebMessage(webMessage, uri);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void reload() {
        this.f385003b.reload();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void removeDocumentStartJavaScript(int i3) {
        this.f385003b.removeDocumentStartJavaScript(i3);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void removeJavascriptInterface(String str) {
        this.f385003b.removeJavascriptInterface(str);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void requestFocusNodeHref(@Nullable Message message) {
        this.f385003b.requestFocusNodeHref(message);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void requestImageRef(@NonNull Message message) {
        this.f385003b.requestImageRef(message);
    }

    @Override // com.tencent.xweb.internal.IWebView
    @Nullable
    public WebBackForwardList restoreState(Bundle bundle) {
        return this.f385003b.restoreState(bundle);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void resumeTimers() {
        this.f385003b.resumeTimers();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean savePage(String str, String str2, int i3) {
        return this.f385003b.savePage(str, str2, i3);
    }

    @Override // com.tencent.xweb.internal.IWebView
    @Nullable
    public WebBackForwardList saveState(Bundle bundle) {
        return this.f385003b.saveState(bundle);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void saveWebArchive(String str) {
        this.f385003b.saveWebArchive(str);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setAudioMuted(boolean z16) {
        this.f385003b.setAudioMuted(z16);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        x0.d("WebView", "setBackgroundColor, color:" + Integer.toHexString(i3));
        super.setBackgroundColor(i3);
        IWebView iWebView = this.f385003b;
        if (iWebView != null) {
            iWebView.getWebViewUI().setBackgroundColor(i3);
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setBottomHeight(int i3) {
        this.f385003b.setBottomHeight(i3);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setDownloadListener(DownloadListener downloadListener) {
        this.f385003b.setDownloadListener(downloadListener);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setFindListener(WebView.FindListener findListener) {
        this.f385003b.setFindListener(findListener);
    }

    @Override // android.view.View
    public void setFocusable(boolean z16) {
        if (!z16) {
            setDescendantFocusability(393216);
            super.setFocusable(false);
        } else {
            setDescendantFocusability(131072);
            super.setFocusable(false);
        }
    }

    @Override // android.view.View
    public void setFocusableInTouchMode(boolean z16) {
        if (!z16) {
            setDescendantFocusability(393216);
            super.setFocusableInTouchMode(false);
        } else {
            setDescendantFocusability(131072);
            super.setFocusableInTouchMode(false);
        }
    }

    @Override // android.view.View, com.tencent.xweb.internal.IWebView
    public void setHorizontalScrollBarEnabled(boolean z16) {
        this.f385003b.setHorizontalScrollBarEnabled(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setHorizontalScrollbarOverlay(boolean z16) {
        this.f385003b.setHorizontalScrollbarOverlay(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        this.f385003b.setHttpAuthUsernamePassword(str, str2, str3, str4);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setInitialScale(int i3) {
        this.f385003b.setInitialScale(i3);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setJSExceptionListener(WebViewJSExceptionListener webViewJSExceptionListener) {
        this.f385003b.setJSExceptionListener(webViewJSExceptionListener);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setNetworkAvailable(boolean z16) {
        this.f385003b.setNetworkAvailable(z16);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f385005d = onLongClickListener;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f385003b.getWebViewUI().setOnTouchListener(onTouchListener);
    }

    @Override // com.tencent.xweb.internal.IWebView
    @Deprecated
    public void setPictureListener(WebView.PictureListener pictureListener) {
        this.f385003b.setPictureListener(pictureListener);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setTextClassifier(@Nullable TextClassifier textClassifier) {
        this.f385003b.setTextClassifier(textClassifier);
    }

    @Override // android.view.View, com.tencent.xweb.internal.IWebView
    public void setVerticalScrollBarEnabled(boolean z16) {
        this.f385003b.setVerticalScrollBarEnabled(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setVerticalScrollbarOverlay(boolean z16) {
        this.f385003b.setVerticalScrollbarOverlay(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public VideoControl setVideoJsCallback(VideoJsCallback videoJsCallback) {
        return this.f385003b.setVideoJsCallback(videoJsCallback);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f385003b.setWebChromeClient(webChromeClient);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setWebContentsSize(int i3, int i16) {
        this.f385003b.setWebContentsSize(i3, i16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setWebViewCallbackClient(WebViewCallbackClient webViewCallbackClient) {
        this.f385003b.setWebViewCallbackClient(webViewCallbackClient);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setWebViewClient(WebViewClient webViewClient) {
        this.f385003b.setWebViewClient(webViewClient);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setWebViewClientExtension(ProxyWebViewClientExtension proxyWebViewClientExtension) {
        this.f385003b.setWebViewClientExtension(proxyWebViewClientExtension);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setWebViewRenderProcessClient(@NonNull Executor executor, @NonNull WebViewRenderProcessClient webViewRenderProcessClient) {
        this.f385003b.setWebViewRenderProcessClient(executor, webViewRenderProcessClient);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setXWebKeyEventHandler(XWebKeyEventHandler xWebKeyEventHandler) {
        this.f385003b.setXWebKeyEventHandler(xWebKeyEventHandler);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void smoothScroll(int i3, int i16, long j3) {
        this.f385003b.smoothScroll(i3, i16, j3);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void stopLoading() {
        this.f385003b.stopLoading();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean supportFeature(int i3) {
        return this.f385003b.supportFeature(i3);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean supportSetWebContentsSize() {
        return this.f385003b.supportSetWebContentsSize();
    }

    public final void u() {
        try {
            this.f385004c = new c(this);
        } catch (Throwable th5) {
            x0.a("WebView", "initDebugView, create dummy one, error", th5);
            this.f385004c = new com.tencent.xweb.debug.a();
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void zoomBy(float f16) {
        this.f385003b.zoomBy(f16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean zoomIn() {
        return this.f385003b.zoomIn();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean zoomOut() {
        return this.f385003b.zoomOut();
    }

    public WebView(Context context, AttributeSet attributeSet) throws CreateWebViewException {
        this(context, attributeSet, 0);
    }

    public final void a(WebViewKind webViewKind) {
        String str;
        x0.a("WebView", "createWebView start, prefer type:" + getCurrentModuleWebCoreType() + ", force type:" + webViewKind);
        XWalkEnvironment.ensureInitEnvironment(getContext());
        WebViewKind webViewKind2 = this.f385002a;
        WebViewKind webViewKind3 = WebViewKind.WV_KIND_NONE;
        if (webViewKind2 != webViewKind3) {
            this.f385007f.a(true);
            x0.a("WebView", "createWebView, already init, webview type:" + this.f385002a);
            return;
        }
        WebViewKind currentModuleWebCoreType = getCurrentModuleWebCoreType();
        if (XWebChildProcessMonitor.getShouldSwitchToSys()) {
            WebViewKind webViewKind4 = WebViewKind.WV_KIND_SYS;
            this.f385002a = webViewKind4;
            x0.a("WebView", "createWebView, XWebChildProcessMonitor force to use sys");
            a(getContext(), webViewKind4);
            str = "ChildProcessMonitor";
        } else {
            WebViewKind webViewKind5 = WebViewKind.WV_KIND_SYS;
            if (webViewKind == webViewKind5) {
                this.f385002a = webViewKind;
                x0.a("WebView", "createWebView, force to use sys by webview param");
                a(getContext(), webViewKind5);
                str = "WebViewParam";
            } else {
                if (getCurrentModuleWebCoreType() == webViewKind3) {
                    this.f385007f.b(false);
                    WebViewKind b16 = b(C());
                    x0.a("WebView", "createWebView, not init core, use prefer type:" + b16);
                    if (b16 != webViewKind3) {
                        this.f385002a = b16;
                        if (a(getContext(), this.f385002a) && isXWebKernel()) {
                            f384997g = this.f385002a;
                            x0.d("WebView", "createWebView, sProcessWebViewKind:" + f384997g);
                        }
                    } else {
                        this.f385002a = webViewKind5;
                        a(getContext(), webViewKind5);
                        str = "NonePreferWebViewKind";
                    }
                } else {
                    this.f385002a = getCurrentModuleWebCoreType();
                }
                str = "";
            }
        }
        String str2 = str;
        this.f385007f.a(str2);
        this.f385007f.b(getModuleName());
        this.f385007f.c(this.f385002a.ordinal());
        x0.a("WebView", "createWebView, try create webview type:" + this.f385002a);
        IWebView a16 = g.a(this.f385002a, this);
        this.f385003b = a16;
        if (a16 == null) {
            this.f385007f.a(2);
            this.f385007f.d();
            x0.a("WebView", "createWebView failed, try other webview types");
            WebViewKind[] webViewKindList = getWebViewKindList();
            int i3 = 0;
            while (true) {
                if (i3 >= webViewKindList.length) {
                    break;
                }
                if (webViewKindList[i3] != this.f385002a && initWebviewCore(getContext(), webViewKindList[i3], (PreInitCallback) null, false)) {
                    IWebView a17 = g.a(webViewKindList[i3], this);
                    this.f385003b = a17;
                    if (a17 != null) {
                        this.f385002a = getCurrentModuleWebCoreType();
                        break;
                    }
                }
                i3++;
            }
            if (this.f385003b != null) {
                this.f385007f.a(1, this.f385002a.ordinal());
            } else {
                this.f385007f.a(2, 0);
                String a18 = a(webViewKind, this.f385002a, webViewKindList, currentModuleWebCoreType, str2);
                x0.c("WebView", a18);
                n0.t();
                throw new CreateWebViewException(a18);
            }
        } else {
            this.f385007f.a(1);
        }
        com.tencent.luggage.wxa.ar.s.a();
        this.f385007f.d(this.f385002a.ordinal());
        addView(this.f385003b.getWebViewUI());
        x0.d("WebView", "createWebView success, webview type:" + this.f385002a);
        this.f385003b.getView().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.xweb.WebView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                boolean z16;
                EventCollector.getInstance().onViewLongClickedBefore(view);
                if (WebView.this.f385005d != null) {
                    z16 = WebView.this.f385005d.onLongClick(WebView.this);
                } else {
                    z16 = false;
                }
                EventCollector.getInstance().onViewLongClicked(view);
                return z16;
            }
        });
        u();
        D();
        if (isXWebKernel()) {
            Context context = getContext();
            if (context instanceof WebViewContextWrapper) {
                ((WebViewContextWrapper) context).setBindedWebview(this.f385003b);
            }
        }
        String userAgentString = getSettings().getUserAgentString();
        getSettings().setUserAgentString(userAgentString + " MMWEBID/" + v0.b());
        WebViewCounter.increase();
        this.f385007f.a();
    }

    public Bitmap captureBitmap() {
        return this.f385003b.captureBitmap();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void clearHistory(int i3, int i16) {
        this.f385003b.clearHistory(i3, i16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public PrintDocumentAdapter createPrintDocumentAdapter(String str) {
        return this.f385003b.createPrintDocumentAdapter(str);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void saveWebArchive(String str, boolean z16, @Nullable ValueCallback<String> valueCallback) {
        this.f385003b.saveWebArchive(str, z16, valueCallback);
    }

    public void setWebViewRenderProcessClient(@Nullable WebViewRenderProcessClient webViewRenderProcessClient) {
        this.f385003b.setWebViewRenderProcessClient(null, webViewRenderProcessClient);
    }

    public WebView(Context context, AttributeSet attributeSet, int i3) throws CreateWebViewException {
        this(context, attributeSet, i3, WebViewKind.WV_KIND_NONE);
    }

    public static WebViewKind b(String str) {
        return getPreferedWebviewType(sDefaultWebViewKind, str);
    }

    public WebView(Context context, AttributeSet attributeSet, int i3, WebViewKind webViewKind) throws CreateWebViewException {
        super(b(context), attributeSet, i3);
        this.f385002a = WebViewKind.WV_KIND_NONE;
        this.f385006e = false;
        r rVar = new r();
        this.f385007f = rVar;
        rVar.e();
        try {
            try {
                a(webViewKind);
                rVar.b(1);
                x0.f("WebView", "###### createWebView costTime:" + rVar.b() + ", result:true, stack:" + Log.getStackTraceString(new Throwable("please ignore this exception")));
            } catch (CreateWebViewException e16) {
                throw e16;
            }
        } catch (Throwable th5) {
            this.f385007f.b(2);
            x0.f("WebView", "###### createWebView costTime:" + this.f385007f.b() + ", result:false, stack:" + Log.getStackTraceString(new Throwable("please ignore this exception")));
            throw th5;
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void loadUrl(String str) {
        if (this.f385004c.a(str)) {
            this.f385003b.loadUrl("http://weixin.qq.com/");
        } else {
            if (a(str)) {
                return;
            }
            this.f385003b.loadUrl(str);
            n0.a(str, this);
        }
    }

    public static synchronized boolean initWebviewCore(Context context, WebViewKind webViewKind, PreInitCallback preInitCallback, boolean z16) {
        synchronized (WebView.class) {
            x0.a("WebView", "initWebviewCore, kind:" + webViewKind + ", bTryOtherWebtype:" + z16);
            boolean a16 = a(context, webViewKind);
            if (!a16 && z16) {
                x0.f("WebView", "initWebviewCore failed, type:" + webViewKind + ", try other webview types");
                WebViewKind[] webViewKindList = getWebViewKindList();
                int i3 = 0;
                while (true) {
                    if (i3 >= webViewKindList.length) {
                        break;
                    }
                    WebViewKind webViewKind2 = webViewKindList[i3];
                    if (webViewKind2 != webViewKind && (a16 = a(context, webViewKind2))) {
                        f384997g = webViewKindList[i3];
                        break;
                    }
                    i3++;
                }
            } else if (a16) {
                f384997g = webViewKind;
            }
            if (!a16) {
                x0.c("WebView", "initWebviewCore failed finally");
                if (preInitCallback != null) {
                    preInitCallback.onCoreInitFailed();
                }
                n0.y();
                return false;
            }
            if (preInitCallback != null) {
                preInitCallback.onCoreInitFinished();
            }
            x0.a("WebView", "initWebviewCore success, type:" + f384997g + ", sdkVer:" + XWebSdk.getXWebSdkVersion() + ", apkVer:" + XWalkEnvironment.getAvailableVersion());
            return true;
        }
    }

    public final String a(WebViewKind webViewKind, WebViewKind webViewKind2, WebViewKind[] webViewKindArr, WebViewKind webViewKind3, String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("create webview instance failed. ExpectedKind:");
        sb5.append(webViewKind);
        sb5.append(",PreferredKind:");
        sb5.append(webViewKind2);
        sb5.append(",AllSupportKind:");
        for (WebViewKind webViewKind4 : webViewKindArr) {
            sb5.append(webViewKind4);
            sb5.append(",");
        }
        sb5.append(",ModuleKindBeforeInit:");
        sb5.append(webViewKind3);
        if (!TextUtils.isEmpty(str)) {
            sb5.append("downgradeReason:");
            sb5.append(str);
        }
        sb5.append(",AllCrashStacks:\n");
        List<String> b16 = com.tencent.luggage.wxa.ar.s.b();
        if (b16.size() != 0) {
            for (String str2 : b16) {
                sb5.append("<<<<<<--->>>>>>\n");
                sb5.append(str2);
            }
        }
        return sb5.toString();
    }

    public static boolean a(Context context, WebViewKind webViewKind) {
        WebViewKind webViewKindFromAvailableVersion;
        boolean z16;
        x0.a("WebView", "tryInitWebViewCore start, type:" + webViewKind);
        if ((webViewKind == WebViewKind.WV_KIND_CW || webViewKind == WebViewKind.WV_KIND_PINUS) && (webViewKindFromAvailableVersion = XWalkEnvironment.getWebViewKindFromAvailableVersion()) != WebViewKind.WV_KIND_NONE && webViewKind != webViewKindFromAvailableVersion) {
            x0.a("WebView", "tryInitWebViewCore, type:" + webViewKind + ", but actual type:" + webViewKindFromAvailableVersion);
            return false;
        }
        if (com.tencent.luggage.wxa.ar.s.a(webViewKind)) {
            x0.a("WebView", "tryInitWebViewCore, has recent crash");
            n0.c(webViewKind);
            return false;
        }
        com.tencent.luggage.wxa.ar.s c16 = com.tencent.luggage.wxa.ar.s.c("LOAD_CORE", webViewKind);
        c16.g();
        try {
            f b16 = g.b(webViewKind);
            if (b16 != null) {
                z16 = b16.initWebviewCore(context, null);
                if (z16) {
                    CookieManager.getInstance().setCookieManagerWrapper(b16.getCookieManager());
                    x0.a("WebView", "tryInitWebViewCore success");
                    n0.d(webViewKind);
                    c16.f();
                    return z16;
                }
            } else {
                z16 = false;
            }
            x0.a("WebView", "tryInitWebViewCore failed");
            return z16;
        } catch (Throwable th5) {
            n0.b(webViewKind);
            String stackTraceString = Log.getStackTraceString(th5);
            com.tencent.luggage.wxa.ar.s.a(stackTraceString);
            x0.a("WebView", "tryInitWebViewCore failed, type:" + webViewKind + ", error:" + stackTraceString);
            com.tencent.luggage.wxa.wq.f.a(1, stackTraceString, webViewKind.ordinal());
            return false;
        }
    }

    public final List a(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof TextureView) {
            arrayList.add((TextureView) view);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                arrayList.addAll(a(viewGroup.getChildAt(i3)));
            }
        }
        return arrayList;
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("chrome://")) {
            return false;
        }
        x0.d("WebView", "Intercept chrome scheme url success, show the 404 page.");
        loadDataWithBaseURL("file:///android_asset/", t0.a(getContext(), 404, "Not found", str), "text/html", "utf-8", null);
        return true;
    }

    public void onWebViewScrollChanged(int i3, int i16, int i17, int i18) {
    }
}
