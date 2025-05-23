package cooperation.qzone.webviewwrapper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.mobileqq.webview.m;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.CloseGuard;
import cooperation.qzone.webviewwrapper.QzoneWebViewBaseBuilder;

/* compiled from: P */
/* loaded from: classes38.dex */
public class WebviewWrapper implements IWebviewWrapper {
    private static final String TAG = "WebviewWrapper";
    private boolean forceSysWebView;
    private final CloseGuard guard;
    private Context mContext;
    private QzoneWebViewBaseBuilder mWebViewBuilder;
    private TouchWebView mWebview;
    private long mWebviewStartTime;

    public WebviewWrapper(Context context) {
        this(context, false);
    }

    @Override // cooperation.qzone.webviewwrapper.IWebviewWrapper
    public void callJs(String str) {
        QzoneWebViewBaseBuilder qzoneWebViewBaseBuilder = this.mWebViewBuilder;
        if (qzoneWebViewBaseBuilder != null) {
            qzoneWebViewBaseBuilder.callJs(str);
        }
    }

    protected void finalize() throws Throwable {
        try {
            this.guard.warnIfOpen();
        } finally {
            super.finalize();
        }
    }

    @Override // cooperation.qzone.webviewwrapper.IWebviewWrapper
    public WebView getWebview() {
        return this.mWebview;
    }

    @Override // cooperation.qzone.webviewwrapper.IWebviewWrapper
    public void onDestroy() {
        this.guard.close();
        onDetach();
        QzoneWebViewBaseBuilder qzoneWebViewBaseBuilder = this.mWebViewBuilder;
        if (qzoneWebViewBaseBuilder != null) {
            qzoneWebViewBaseBuilder.onDestroy();
        }
        this.mWebview = null;
        this.mContext = null;
    }

    @Override // cooperation.qzone.webviewwrapper.IWebviewWrapper
    public void onDetach() {
        ViewParent parent;
        TouchWebView touchWebView = this.mWebview;
        if (touchWebView == null || (parent = touchWebView.getParent()) == null || !(parent instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) parent).removeAllViewsInLayout();
    }

    @Override // cooperation.qzone.webviewwrapper.IWebviewWrapper
    public void onInit(Activity activity, Intent intent, String str, final IWebviewListener iWebviewListener) {
        this.guard.open(MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.mWebViewBuilder = new QzoneWebViewBaseBuilder(this.mContext, activity, intent, QzoneWebViewPluginManager.getInstance().getRuntime(), true);
        this.mWebview.setVisibility(4);
        this.mWebViewBuilder.setWebView(this.mWebview);
        this.mWebViewBuilder.setWebviewStatusListener(new QzoneWebViewBaseBuilder.WebviewStatusListener() { // from class: cooperation.qzone.webviewwrapper.WebviewWrapper.1
            @Override // cooperation.qzone.webviewwrapper.QzoneWebViewBaseBuilder.WebviewStatusListener
            public void onPageFinished() {
                if (WebviewWrapper.this.mWebview == null) {
                    return;
                }
                if (WebviewWrapper.this.mWebview.getVisibility() != 0) {
                    WebviewWrapper.this.mWebview.setVisibility(0);
                }
                IWebviewListener iWebviewListener2 = iWebviewListener;
                if (iWebviewListener2 != null) {
                    iWebviewListener2.onPageFinished();
                }
            }

            @Override // cooperation.qzone.webviewwrapper.QzoneWebViewBaseBuilder.WebviewStatusListener
            public void onReceiveError(int i3, String str2, String str3) {
                IWebviewListener iWebviewListener2 = iWebviewListener;
                if (iWebviewListener2 != null) {
                    iWebviewListener2.onReceiveError(i3, str2, str3);
                }
            }
        });
        new m(this.mWebViewBuilder).a(null, QzoneWebViewPluginManager.getInstance().getRuntime(), null);
    }

    @Override // cooperation.qzone.webviewwrapper.IWebviewWrapper
    public void onPause() {
        QzoneWebViewBaseBuilder qzoneWebViewBaseBuilder = this.mWebViewBuilder;
        if (qzoneWebViewBaseBuilder != null) {
            qzoneWebViewBaseBuilder.onPause();
        }
    }

    @Override // cooperation.qzone.webviewwrapper.IWebviewWrapper
    public void onResume() {
        QzoneWebViewBaseBuilder qzoneWebViewBaseBuilder = this.mWebViewBuilder;
        if (qzoneWebViewBaseBuilder != null) {
            qzoneWebViewBaseBuilder.onResume();
        }
    }

    @Override // cooperation.qzone.webviewwrapper.IWebviewWrapper
    public void preInit() {
        if (this.mWebview == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.forceSysWebView) {
                QbSdk.forceSysWebView();
            }
            TouchWebView touchWebView = new TouchWebView(this.mContext);
            this.mWebview = touchWebView;
            WebSettings settings = touchWebView.getSettings();
            if (settings != null) {
                settings.setMixedContentMode(0);
                settings.setMixedContentMode(0);
            }
            QLog.i(TAG, 2, "saxon@ new TouchWebView cost " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public WebviewWrapper(Context context, boolean z16) {
        this.guard = CloseGuard.get();
        this.mWebviewStartTime = System.currentTimeMillis();
        this.forceSysWebView = z16;
        this.mContext = context;
        preInit();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    @Override // cooperation.qzone.webviewwrapper.IWebviewWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onWebViewReady(Intent intent, boolean z16) {
        if (intent == null || this.mWebview == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(QzoneCoverConst.WebViewConst.KEY_WNS_PROXY_HTTP_DATA);
        String stringExtra2 = intent.getStringExtra("url");
        boolean isEmpty = TextUtils.isEmpty(stringExtra);
        if (isEmpty && TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        if (!z16 && isEmpty) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("key_wns_cache_hit", false);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "CoverQzoneShowWebView load Url: " + stringExtra2 + ", wns proxy html hit caches:" + booleanExtra);
        }
        if (booleanExtra) {
            QLog.i(TAG, 2, "bHitCache is true");
            return;
        }
        if (z16 && isEmpty) {
            this.mWebview.loadUrl(stringExtra2);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "CoverQzoneShowWebView load Url: " + stringExtra2 + ", wns proxy html return failed!");
                return;
            }
            return;
        }
        String url = this.mWebview.getUrl();
        boolean z17 = TextUtils.isEmpty(url) || "about:blank".equals(url);
        if (!z17) {
            try {
                if (intent.getBooleanExtra("need_force_refresh", false)) {
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "saxon@ onwebview ready exception", e16);
            }
            if (QLog.isColorLevel()) {
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("CoverQzoneShowWebView load Url: ");
            sb5.append(stringExtra2);
            sb5.append(", htmlBody(true), currentUrl(");
            sb5.append(!z17);
            sb5.append(")");
            QLog.i(TAG, 2, sb5.toString());
            return;
        }
        QLog.i(TAG, 2, "saxon@ isCurrentUrlEmpty loadDataWithBaseURL");
        WebSoPlugin.z(this.mWebview, stringExtra2, stringExtra);
        if (QLog.isColorLevel()) {
        }
    }

    @Override // cooperation.qzone.webviewwrapper.IWebviewWrapper
    public void setOnWebviewTouchListener(View.OnTouchListener onTouchListener) {
    }
}
