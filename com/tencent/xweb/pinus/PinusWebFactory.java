package com.tencent.xweb.pinus;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.tq.a;
import com.tencent.luggage.wxa.tq.b;
import com.tencent.luggage.wxa.tq.c;
import com.tencent.luggage.wxa.tq.d;
import com.tencent.luggage.wxa.tq.e;
import com.tencent.luggage.wxa.tq.f;
import com.tencent.xweb.WebView;
import com.tencent.xweb.XWebWebViewDatabase;
import com.tencent.xweb.internal.IWebView;
import org.xwalk.core.XWalkEnvironment;

/* loaded from: classes27.dex */
public class PinusWebFactory implements f {
    private static final String TAG = "PinusWebFactory";
    private boolean mHasInitedWebViewCore;

    /* loaded from: classes27.dex */
    public static class SingletonHolder {
        private static final PinusWebFactory sInstance = new PinusWebFactory();

        SingletonHolder() {
        }
    }

    public static PinusWebFactory getInstance() {
        return SingletonHolder.sInstance;
    }

    private boolean initWebViewCoreInternal() {
        if (this.mHasInitedWebViewCore) {
            return true;
        }
        x0.d(TAG, "initWebViewCoreInternal start");
        PSInitializerWrapper.getInstance().initWebViewCore();
        if (PSInitializerWrapper.getInstance().isWebViewCoreReady()) {
            x0.d(TAG, "initWebViewCoreInternal finished");
            this.mHasInitedWebViewCore = true;
        } else {
            x0.d(TAG, "initWebViewCoreInternal failed, pinus is not available");
        }
        return this.mHasInitedWebViewCore;
    }

    @Override // com.tencent.luggage.wxa.tq.f
    public void clearAllWebViewCache(Context context, boolean z16) {
        a cookieManager;
        if (WebView.getCurrentModuleWebCoreType() != WebView.WebViewKind.WV_KIND_PINUS) {
            x0.f(TAG, "clearAllWebViewCache, not pinus");
            return;
        }
        try {
            if (XWalkEnvironment.getAvailableVersion() <= 0) {
                x0.f(TAG, "clearAllWebViewCache, no available version");
                return;
            }
            com.tencent.xweb.pinus.sdk.WebView webView = new com.tencent.xweb.pinus.sdk.WebView(new PSContextWrapper(XWalkEnvironment.getApplicationContext(), XWalkEnvironment.getAvailableVersion()));
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
            webView.clearCache(true);
            if (z16 && (cookieManager = getCookieManager()) != null) {
                cookieManager.removeAllCookie();
            }
        } catch (Throwable th5) {
            x0.a(TAG, "clearAllWebViewCache, error", th5);
        }
    }

    @Override // com.tencent.luggage.wxa.tq.f
    public void clearClientCertPreferences(@Nullable Runnable runnable) {
        PinusWebView.clearClientCertPreferences(runnable);
    }

    @Override // com.tencent.luggage.wxa.tq.f
    public IWebView createWebView(WebView webView) {
        if (initWebViewCoreInternal()) {
            x0.d(TAG, "createWebView, PinusWebView is available");
            return new PinusWebView(webView);
        }
        return null;
    }

    @Override // com.tencent.luggage.wxa.tq.f
    public String findAddress(String str) {
        return PinusWebView.findAddress(str);
    }

    @Override // com.tencent.luggage.wxa.tq.f
    public a getCookieManager() {
        return new PinusCookieManagerWrapper();
    }

    @Override // com.tencent.luggage.wxa.tq.f
    @Nullable
    public c getWebViewContextWrapper() {
        return PSInitializerWrapper.getInstance().getWebViewContextWrapper();
    }

    @Override // com.tencent.luggage.wxa.tq.f
    @Nullable
    public d getWebViewCoreWrapper() {
        return PSCoreWrapper.getInstance();
    }

    @Override // com.tencent.luggage.wxa.tq.f
    public e getWebViewDatabase(Context context) {
        return new XWebWebViewDatabase(context);
    }

    @Override // com.tencent.luggage.wxa.tq.f
    public b getWebviewStorage() {
        return new PinusStorage();
    }

    @Override // com.tencent.luggage.wxa.tq.f
    public boolean hasInitedWebViewCore() {
        return this.mHasInitedWebViewCore;
    }

    @Override // com.tencent.luggage.wxa.tq.f
    public boolean initWebviewCore(Context context, WebView.PreInitCallback preInitCallback) {
        x0.d(TAG, "initWebviewCore");
        boolean initWebViewCoreInternal = initWebViewCoreInternal();
        if (preInitCallback != null) {
            if (initWebViewCoreInternal) {
                preInitCallback.onCoreInitFinished();
            } else {
                preInitCallback.onCoreInitFailed();
            }
        }
        return initWebViewCoreInternal;
    }

    public boolean isSupportTranslateWebSite() {
        d webViewCoreWrapper = getWebViewCoreWrapper();
        if (webViewCoreWrapper == null) {
            return false;
        }
        Object invokeRuntimeChannel = webViewCoreWrapper.invokeRuntimeChannel(80011, null);
        if (!(invokeRuntimeChannel instanceof Boolean)) {
            return false;
        }
        return ((Boolean) invokeRuntimeChannel).booleanValue();
    }

    PinusWebFactory() {
        this.mHasInitedWebViewCore = false;
    }
}
