package cooperation.qzone.webviewwrapper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ProgressBar;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.api.IJsApi;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.a;
import com.tencent.mobileqq.webview.util.m;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import cooperation.qzone.webviewplugin.QZoneWebViewPlugin;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QzoneWebViewBaseBuilder extends AbsWebView implements m {
    public static final a QZONE_SHOW_COMMON_JS = new a() { // from class: cooperation.qzone.webviewwrapper.QzoneWebViewBaseBuilder.1
        @Override // com.tencent.mobileqq.webview.swift.a
        public List<WebViewPlugin> getCommonJsPlugin() {
            ArrayList arrayList = new ArrayList();
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getAntiphingHandlerPlugin());
            arrayList.add(new OfflinePlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getReportPlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getPtloginPlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getWebViewJumpPlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getVasWebReportPlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getEventApiPlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getOpenCenterPlugin());
            arrayList.add((WebViewPlugin) ((IMiniAppService) QRoute.api(IMiniAppService.class)).createMiniAppWebViewPlugin());
            arrayList.add((WebViewPlugin) ((IQzoneWebViewPluginHelper) QRoute.api(IQzoneWebViewPluginHelper.class)).getQzoneWebViewOfflinePlugin());
            arrayList.add(new QzoneWebMusicJsPlugin());
            arrayList.add((WebViewPlugin) ((IJsApi) QRoute.api(IJsApi.class)).getWebSoPlugin());
            return arrayList;
        }
    };
    protected Intent mIntent;
    private boolean mIsSmallWebview;
    protected int mWebViewResId;
    private WebviewStatusListener mWebviewStatusListener;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface WebviewStatusListener {
        void onPageFinished();

        void onReceiveError(int i3, String str, String str2);
    }

    public QzoneWebViewBaseBuilder(Context context, Activity activity, Intent intent, AppInterface appInterface, boolean z16) {
        super(context, activity, appInterface);
        this.mIntent = intent;
        this.mIsSmallWebview = z16;
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void bindJavaScript(ArrayList<WebViewPlugin> arrayList) {
        if (this.mPluginList == null) {
            this.mPluginList = new ArrayList<>();
        }
        this.mPluginList.add(new QZoneWebViewPlugin());
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public final void buildWebView(AppRuntime appRuntime) {
        super.buildBaseWebView(appRuntime);
        onWebViewReady();
    }

    public void callJs(String str) {
        TouchWebView touchWebView = this.mWebview;
        if (touchWebView != null) {
            touchWebView.callJs(str);
        }
    }

    public boolean handleMessageImp(Message message) {
        return false;
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    protected a myCommonJsPlugins() {
        if (this.mIsSmallWebview) {
            return QZONE_SHOW_COMMON_JS;
        }
        return new a();
    }

    public void onBackPressed() {
        super.doOnBackPressed(this.mInterface);
    }

    public void onCreate(Bundle bundle) {
        super.doOnCreate(this.mIntent);
    }

    public void onDestroy() {
        try {
            super.doOnDestroy();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void onPageFinished(WebView webView, String str) {
        WebviewStatusListener webviewStatusListener = this.mWebviewStatusListener;
        if (webviewStatusListener != null) {
            try {
                webviewStatusListener.onPageFinished();
            } catch (Exception unused) {
            }
        }
    }

    public void onPause() {
        super.doOnPause();
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void onReceivedError(WebView webView, int i3, String str, String str2) {
        WebviewStatusListener webviewStatusListener = this.mWebviewStatusListener;
        if (webviewStatusListener != null) {
            try {
                webviewStatusListener.onReceiveError(i3, str, str2);
            } catch (Exception unused) {
            }
        }
    }

    public void onResume() {
        super.doOnResume();
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void preInitWebviewPlugin() {
        super.preInitPluginEngine();
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.mLoadProgress = progressBar;
    }

    public void setWebView(TouchWebView touchWebView) {
        this.mWebview = touchWebView;
    }

    public void setWebViewResId(int i3) {
        this.mWebViewResId = i3;
    }

    public void setWebviewStatusListener(WebviewStatusListener webviewStatusListener) {
        this.mWebviewStatusListener = webviewStatusListener;
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("QzoneWebViewBaseBuilder", 2, "loadUrl in shouldOverrideUrlLoading url=" + str);
        }
        if (!TextUtils.isEmpty(str) && str.startsWith("jsbridge://")) {
            return true;
        }
        webView.loadUrl(str);
        return true;
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildBottomBar() {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildData() {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildLayout() {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildTitleBar() {
    }

    public void finish() {
    }

    public void onStop() {
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void onWebViewReady() {
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildContentView(Bundle bundle) {
    }

    public void onNewIntent(Intent intent) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onWindowFocusChanged(boolean z16) {
    }

    public void onActivityResult(int i3, int i16, Intent intent) {
    }
}
