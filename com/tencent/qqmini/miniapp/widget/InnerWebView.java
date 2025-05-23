package com.tencent.qqmini.miniapp.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.luggage.wxa.f3.a;
import com.tencent.luggage.wxa.l6.i;
import com.tencent.luggage.wxa.l6.l;
import com.tencent.qimei.webview.QmX5Webview;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmini.miniapp.R;
import com.tencent.qqmini.miniapp.core.page.AppBrandPage;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.miniapp.util.FileChooserHelper;
import com.tencent.qqmini.miniapp.util.IPV6OnlyUtils;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.action.a;
import com.tencent.qqmini.sdk.browser.BrowserUtils;
import com.tencent.qqmini.sdk.core.BaseRuntimeImpl;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.IPermissionManagerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.Permissions;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.utils.FastClickUtils;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;
import com.tencent.qqmini.sdk.utils.DomainUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class InnerWebView extends QmX5Webview implements IJsService {
    public static final String API_BATCH_CARD = "batchAddCard";
    public static final String API_CHECK_JS_API = "checkJsApi";
    public static final String API_CHOOSE_CARD = "chooseCard";
    public static final String API_CLOSE_WINDOW = "closeWindow";
    public static final String API_DOWNLOAD_IMAGE = "downloadImage";
    public static final String API_DOWNLOAD_VOICE = "downloadVoice";
    public static final String API_GET_BRAND_WCPAY_REQUEST = "getBrandWCPayRequest";
    public static final String API_GET_LOCAL_IMGDATA = "getLocalImgData";
    public static final String API_HIDE_ALL_NONBASE_MENU_ITEM = "hideAllNonBaseMenuItem";
    public static final String API_HIDE_MENU_ITEMS = "hideMenuItems";
    public static final String API_HIDE_OPTION_MENU = "hideOptionMenu";
    public static final String API_OPEN_CARD = "openCard";
    public static final String API_OPEN_PPRODUCT_VIEW_WITH_PID = "openProductViewWithPid";
    public static final String API_SCAN_QRCODE = "scanQRCode";
    public static final String API_SHOW_ALL_NONBASE_MENU_ITEM = "showAllNonBaseMenuItem";
    public static final String API_SHOW_MENU_ITEMS = "showMenuItems";
    public static final String API_SHOW_OPTION_MENU = "showOptionMenu";
    public static final String API_TRANSLATE_VOICE = "translateVoice";
    public static final String API_UPLOAD_IMAGE = "uploadImage";
    public static final String API_UPLOAD_VOICE = "uploadVoice";
    public static final int REQUEST_CODE = 2019;
    private static final String TAG = "InnerWebView";
    private static final String TAG_JS = "InnerWebView_js";
    private static final String WEB_BASE64_PREFIX_JPEG = "data:image/jpeg;base64,";
    private static final String WEB_BASE64_PREFIX_JPG = "data:image/jpg;base64,";
    private static final String WEB_BASE64_PREFIX_PNG = "data:image/png;base64,";
    public int htmlId;
    private WeakReference<Activity> mActivity;
    private FileChooserHelper mFileChooserHelper;
    private IMiniAppContext mMiniAppContext;
    private String miniAppWebviewStr;
    private Set<String> supportApiMap;
    private WebView webView;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class QQJSCoreInterface {
        QQJSCoreInterface() {
        }

        @JavascriptInterface
        public String invokeHandler(final String str, final String str2, final int i3) {
            if (l.NAME.equals(str)) {
                InnerWebView.this.handleCallbackOK(str, null, i3);
                return "";
            }
            if (i.NAME.equals(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    if (InnerWebView.this.mMiniAppContext == null) {
                        InnerWebView.this.handleCallbackFail(str, null, null, i3);
                    } else {
                        InnerWebView.this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain("onWebInvokeAppService", jSONObject.toString(), 0));
                        InnerWebView.this.handleCallbackOK(str, null, i3);
                    }
                    return "";
                } catch (Exception unused) {
                    InnerWebView.this.handleCallbackFail(str, null, null, i3);
                    return "";
                }
            }
            if ("checkJsApi".equals(str)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    JSONArray optJSONArray = jSONObject2.optJSONArray("jsApiList");
                    if (optJSONArray.length() > 0) {
                        for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                            jSONObject4.put(optJSONArray.get(i16).toString(), true);
                        }
                    }
                    jSONObject3.put("checkResult", jSONObject4.toString());
                    InnerWebView.this.handleCallbackOK(str, jSONObject3, i3);
                    return "";
                } catch (Exception unused2) {
                    InnerWebView.this.handleCallbackFail(str, null, null, i3);
                    return "";
                }
            }
            if (InnerWebView.this.mMiniAppContext != null) {
                InnerWebView.this.mMiniAppContext.performAction(new Action<String>() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.QQJSCoreInterface.1
                    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
                    public String perform(BaseRuntime baseRuntime) {
                        IJsPluginEngine jsPluginEngine = baseRuntime.getJsPluginEngine();
                        if (!(jsPluginEngine instanceof JsPluginEngine)) {
                            return null;
                        }
                        JsPluginEngine jsPluginEngine2 = (JsPluginEngine) jsPluginEngine;
                        QMLog.d(Action.TAG, "Dispatch repeat RequestEvent=" + str);
                        return jsPluginEngine2.handleNativeRequest(str, str2, (IJsService) InnerWebView.this.webView, i3, 0);
                    }
                });
                return "";
            }
            return "";
        }
    }

    public InnerWebView(Activity activity) {
        super(activity);
        String str;
        String str2;
        this.mActivity = new WeakReference<>(activity);
        WebSettings settings = getSettings();
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.getMiniAppInfo() != null) {
            str = this.mMiniAppContext.getMiniAppInfo().appId;
        } else {
            str = "";
        }
        if (channelProxy != null && channelProxy.isGooglePlayVersion()) {
            str2 = settings.getUserAgentString() + " QQ/" + QUAUtil.getPlatformVersionString() + "_GM " + QUAUtil.getPlatformQUA() + " miniProgram miniprogramhtmlwebview QMA/" + str;
        } else {
            str2 = settings.getUserAgentString() + " QQ/" + QUAUtil.getPlatformVersionString() + " " + QUAUtil.getPlatformQUA() + " miniProgram miniprogramhtmlwebview QMA/" + str;
        }
        settings.setUserAgent(str2);
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setPluginsEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        settings.setCacheMode(-1);
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        settings.setMixedContentMode(0);
        settings.setAllowContentAccess(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setMixedContentMode(0);
        try {
            requestFocus();
        } catch (Exception unused) {
        }
    }

    private boolean checkEnableIPV6Only() {
        if (WnsConfig.getConfig("qqminiapp", "ipv6_proxy_enable", 0) != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse doIPV6OnlyRequest(WebView webView, WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        try {
            String str = WnsConfig.getConfig("qqminiapp", "ipv6_http_proxy_url", "https://proxy.gtimg.cn/tx_tls_gate=") + uri;
            QMLog.e(TAG, "shouldInterceptRequest url = " + str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod(webResourceRequest.getMethod());
            if (webResourceRequest.getRequestHeaders() != null) {
                for (Map.Entry<String, String> entry : webResourceRequest.getRequestHeaders().entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            httpURLConnection.setConnectTimeout(6000);
            httpURLConnection.setReadTimeout(6000);
            String str2 = "";
            if (httpURLConnection.getHeaderFields() != null && httpURLConnection.getHeaderFields().containsKey("Content-Type")) {
                str2 = httpURLConnection.getHeaderFields().get("Content-Type").get(0);
            }
            String mimeType = IPV6OnlyUtils.getMimeType(str2);
            String encoding = IPV6OnlyUtils.getEncoding(str2);
            QMLog.e(TAG, "ipv6 code:" + httpURLConnection.getResponseCode() + "  url:" + str);
            QMLog.e(TAG, "ipv6 mimeType = " + mimeType + "encoding:" + encoding);
            return new WebResourceResponse(mimeType, encoding, httpURLConnection.getInputStream());
        } catch (Exception e16) {
            QMLog.e(TAG, "shouldInterceptRequest: failed ", e16);
            return null;
        }
    }

    private String getImageFileType(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            return ImageUtil.getType(options);
        } catch (Throwable th5) {
            QMLog.e(TAG, "decodeFile error", th5);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCallbackFail(String str, JSONObject jSONObject, String str2, int i3) {
        String str3;
        JSONObject wrapCallbackFail = ApiUtil.wrapCallbackFail(str, null, str2);
        if (wrapCallbackFail != null) {
            str3 = wrapCallbackFail.toString();
        } else {
            str3 = "";
        }
        webViewEvaluteJs(str3, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCallbackOK(String str, JSONObject jSONObject, int i3) {
        String str2;
        JSONObject wrapCallbackOk = ApiUtil.wrapCallbackOk(str, jSONObject);
        if (wrapCallbackOk != null) {
            str2 = wrapCallbackOk.toString();
        } else {
            str2 = "";
        }
        webViewEvaluteJs(str2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleProgressChanged(final int i3) {
        QMLog.d(TAG, "onProgressChanged : " + i3);
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null) {
            iMiniAppContext.performAction(new Action<Void>() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.4
                @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
                public Void perform(BaseRuntime baseRuntime) {
                    IPage page = baseRuntime.getPage();
                    if (!(page instanceof AppBrandPageContainer)) {
                        QMLog.d(Action.TAG, "Page is invalid");
                        return null;
                    }
                    AppBrandPage showingPage = ((AppBrandPageContainer) page).getShowingPage();
                    if (showingPage != null && showingPage.getNavBar() != null) {
                        showingPage.getNavBar().updateProgress((byte) 1);
                        if (i3 == 100) {
                            showingPage.getNavBar().updateProgress((byte) 2);
                        }
                    }
                    return null;
                }
            });
        }
    }

    private void handleSaveWithBase64(String str) {
        String str2;
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null) {
            str2 = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPathByUrl(str);
        } else {
            str2 = "";
        }
        if (str.startsWith(WEB_BASE64_PREFIX_JPG)) {
            str2 = str2 + ".jpg";
        } else if (str.startsWith(WEB_BASE64_PREFIX_PNG)) {
            str2 = str2 + ".png";
        } else if (str.startsWith(WEB_BASE64_PREFIX_JPEG)) {
            str2 = str2 + ".jpeg";
        }
        if (savaBase64DataToLocalPath(str, str2)) {
            saveImageToAlbum(str2);
        } else {
            QMLog.e(TAG, "saveImageToAlbum savaBase64DataToLocalPath failed.");
        }
    }

    private void handleSaveWithNetworkUrl(String str) {
        String str2;
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null) {
            str2 = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPathByUrl(str);
        } else {
            str2 = "";
        }
        final String str3 = str2;
        DownloaderProxy downloaderProxy = (DownloaderProxy) ProxyManager.get(DownloaderProxy.class);
        if (downloaderProxy == null) {
            QMLog.e(TAG, "savaPicToAlbum proxy is null");
        } else {
            downloaderProxy.download(str, null, str3, 60, new DownloaderProxy.DownloadListener() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.10
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                public void onDownloadFailed(int i3, String str4) {
                    AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QMLog.e(InnerWebView.TAG, "savaPicToAlbum failed, because of picture downloadFailed");
                            if (InnerWebView.this.mActivity != null && InnerWebView.this.mActivity.get() != null) {
                                MiniToast.makeText((Context) InnerWebView.this.mActivity.get(), 1, "\u4fdd\u5b58\u5931\u8d25", 0).show();
                            }
                        }
                    });
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                public void onDownloadSucceed(int i3, String str4, DownloaderProxy.DownloadListener.DownloadResult downloadResult) {
                    AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.10.2
                        @Override // java.lang.Runnable
                        public void run() {
                            File file = new File(str3);
                            if (file.exists()) {
                                InnerWebView.this.saveImageToAlbum(file.getAbsolutePath());
                            } else if (InnerWebView.this.mActivity != null && InnerWebView.this.mActivity.get() != null) {
                                QMLog.e(InnerWebView.TAG, "savaPicToAlbum failed, because of picture downloadFailed");
                                MiniToast.makeText((Context) InnerWebView.this.mActivity.get(), 1, "\u4fdd\u5b58\u5931\u8d25", 0).show();
                            }
                        }
                    });
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                public void onDownloadHeadersReceived(int i3, Map<String, List<String>> map) {
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                public void onDownloadProgress(float f16, long j3, long j16) {
                }
            });
        }
    }

    private void handleShareBase64Image(String str) {
        String str2;
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null) {
            str2 = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPathByUrl(str);
        } else {
            str2 = "";
        }
        if (str.startsWith(WEB_BASE64_PREFIX_JPG)) {
            str2 = str2 + ".jpg";
        } else if (str.startsWith(WEB_BASE64_PREFIX_PNG)) {
            str2 = str2 + ".png";
        } else if (str.startsWith(WEB_BASE64_PREFIX_JPEG)) {
            str2 = str2 + ".jpeg";
        }
        if (savaBase64DataToLocalPath(str, str2)) {
            realSharePicToQQ(str2);
        } else {
            QMLog.e(TAG, "startSharePicToQQ savaBase64DataToLocalPath failed.");
        }
    }

    private void handleShareWebImage(String str) {
        String str2;
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null) {
            str2 = ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPathByUrl(str);
        } else {
            str2 = "";
        }
        final String str3 = str2;
        DownloaderProxy downloaderProxy = (DownloaderProxy) ProxyManager.get(DownloaderProxy.class);
        if (downloaderProxy == null) {
            QMLog.e(TAG, "savaPicToAlbum proxy is null");
        } else {
            downloaderProxy.download(str, null, str3, 60, new DownloaderProxy.DownloadListener() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.11
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                public void onDownloadFailed(int i3, String str4) {
                    AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QMLog.e(InnerWebView.TAG, "sharePicToQQ failed, because of picture downloadFailed");
                            if (InnerWebView.this.mActivity != null && InnerWebView.this.mActivity.get() != null) {
                                MiniToast.makeText((Context) InnerWebView.this.mActivity.get(), 1, ShareJsPlugin.ERRMSG_INVITE_REQUIRE, 0).show();
                            }
                        }
                    });
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                public void onDownloadSucceed(int i3, String str4, DownloaderProxy.DownloadListener.DownloadResult downloadResult) {
                    AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.11.2
                        @Override // java.lang.Runnable
                        public void run() {
                            File file = new File(str3);
                            if (file.exists()) {
                                InnerWebView.this.realSharePicToQQ(file.getAbsolutePath());
                            } else if (InnerWebView.this.mActivity != null && InnerWebView.this.mActivity.get() != null) {
                                QMLog.e(InnerWebView.TAG, "sharePicToQQ failed, because of picture downloadFailed");
                                MiniToast.makeText((Context) InnerWebView.this.mActivity.get(), 1, ShareJsPlugin.ERRMSG_INVITE_REQUIRE, 0).show();
                            }
                        }
                    });
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                public void onDownloadHeadersReceived(int i3, Map<String, List<String>> map) {
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                public void onDownloadProgress(float f16, long j3, long j16) {
                }
            });
        }
    }

    private void initWebChromeClient() {
        setWebChromeClient(new WebChromeClient() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.2

            /* compiled from: P */
            /* renamed from: com.tencent.qqmini.miniapp.widget.InnerWebView$2$a */
            /* loaded from: classes23.dex */
            class a implements a.b {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ GeolocationPermissionsCallback f346330a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ String f346331b;

                a(GeolocationPermissionsCallback geolocationPermissionsCallback, String str) {
                    this.f346330a = geolocationPermissionsCallback;
                    this.f346331b = str;
                }

                @Override // com.tencent.qqmini.sdk.action.a.b
                public void onCheckLocationPermissionAction(boolean z16) {
                    QMLog.w(InnerWebView.TAG, "onGeolocationPermissionsShowPrompt isConfirm : " + z16);
                    this.f346330a.invoke(this.f346331b, z16, false);
                }
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (QMLog.isColorLevel() && !FastClickUtils.isFastDoubleClick(InnerWebView.TAG, 200L)) {
                    QMLog.e(InnerWebView.TAG_JS, consoleMessage.message());
                }
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient
            public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
                InnerWebView.this.mMiniAppContext.performAction(com.tencent.qqmini.sdk.action.a.b(new a(geolocationPermissionsCallback, str)));
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
                if (InnerWebView.this.mMiniAppContext.getAttachActivity() != null && !InnerWebView.this.mMiniAppContext.getAttachActivity().isFinishing()) {
                    DialogUtil.createCustomDialog(InnerWebView.this.mMiniAppContext.getAttachActivity(), 230, "", str2, R.string.mini_sdk_cancel, R.string.mini_sdk_ok, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.2.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            jsResult.confirm();
                            dialogInterface.dismiss();
                        }
                    }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.2.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            jsResult.confirm();
                            dialogInterface.dismiss();
                        }
                    }).show();
                    return true;
                }
                QMLog.e(InnerWebView.TAG, "onJsAlert getAttachedActivity is null or finish");
                return false;
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient
            public void onProgressChanged(WebView webView, int i3) {
                JsInjector.getInstance().onProgressChanged(webView, i3);
                super.onProgressChanged(webView, i3);
                InnerWebView.this.handleProgressChanged(i3);
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                InnerWebView.this.handleReceivedTitle(str);
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                if (InnerWebView.this.mFileChooserHelper == null) {
                    InnerWebView.this.mFileChooserHelper = new FileChooserHelper();
                }
                if (InnerWebView.this.mActivity != null && InnerWebView.this.mActivity.get() != null) {
                    ActivityResultManager.g().addActivityResultListener(new IActivityResultListener() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.2.3
                        @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
                        public boolean doOnActivityResult(int i3, int i16, Intent intent) {
                            if (i3 == 2019) {
                                InnerWebView.this.onActivityResult(i3, i16, intent);
                                ActivityResultManager.g().removeActivityResultListener(this);
                                return true;
                            }
                            return false;
                        }
                    });
                    return InnerWebView.this.mFileChooserHelper.onShowFileChooser((Activity) InnerWebView.this.mActivity.get(), 2019, valueCallback, fileChooserParams);
                }
                return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient
            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                if (InnerWebView.this.mFileChooserHelper == null) {
                    InnerWebView.this.mFileChooserHelper = new FileChooserHelper();
                }
                if (InnerWebView.this.mActivity != null && InnerWebView.this.mActivity.get() != null) {
                    ActivityResultManager.g().addActivityResultListener(new IActivityResultListener() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.2.4
                        @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
                        public boolean doOnActivityResult(int i3, int i16, Intent intent) {
                            if (i3 == 2019) {
                                InnerWebView.this.onActivityResult(i3, i16, intent);
                                ActivityResultManager.g().removeActivityResultListener(this);
                                return true;
                            }
                            return false;
                        }
                    });
                    InnerWebView.this.mFileChooserHelper.showFileChooser((Activity) InnerWebView.this.mActivity.get(), 2019, valueCallback, str, str2);
                } else {
                    super.openFileChooser(valueCallback, str, str2);
                }
            }
        });
    }

    private void initWebviewClient() {
        setWebViewClient(new WebViewClient() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.5
            @Override // com.tencent.smtt.sdk.WebViewClient
            public void doUpdateVisitedHistory(WebView webView, final String str, boolean z16) {
                QMLog.d(InnerWebView.TAG, "doUpdateVisitedHistory " + str);
                if (InnerWebView.this.mMiniAppContext != null && str != null && !str.equals("about:blank")) {
                    InnerWebView.this.mMiniAppContext.performAction(new Action<Void>() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.5.1
                        @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
                        public Void perform(BaseRuntime baseRuntime) {
                            IPage page = baseRuntime.getPage();
                            if (!(page instanceof AppBrandPageContainer)) {
                                QMLog.d(Action.TAG, "Page is invalid");
                                return null;
                            }
                            AppBrandPageContainer appBrandPageContainer = (AppBrandPageContainer) page;
                            InnerWebView.this.updateProgressBar(appBrandPageContainer.getShowingPage());
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("htmlId", InnerWebView.this.htmlId);
                                jSONObject.put("src", str);
                                int pageId = PageAction.obtain(InnerWebView.this.mMiniAppContext).getPageId();
                                if (appBrandPageContainer.getShowingPage() != null && appBrandPageContainer.getShowingPage().getBrandPageWebview() != null) {
                                    appBrandPageContainer.getShowingPage().getBrandPageWebview().evaluateSubscribeJS(a.k.NAME, jSONObject.toString(), pageId);
                                }
                            } catch (Exception e16) {
                                QMLog.e(Action.TAG, "onPageStarted error." + e16);
                            }
                            return null;
                        }
                    });
                }
                super.doUpdateVisitedHistory(webView, str, z16);
            }

            @Override // com.tencent.smtt.sdk.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                QMLog.d(InnerWebView.TAG, "onPageFinished " + str);
                InnerWebView innerWebView = InnerWebView.this;
                innerWebView.evaluateJavascript(innerWebView.miniAppWebviewStr, new ValueCallback<String>() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.5.2
                    @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                    public void onReceiveValue(String str2) {
                        QMLog.e(InnerWebView.TAG, "evaluateJavascript miniAppWebviewStr callback");
                    }
                });
                InnerWebView.this.onWebviewPageFinished(str);
            }

            @Override // com.tencent.smtt.sdk.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                JsInjector.getInstance().onPageStarted(webView);
                super.onPageStarted(webView, str, bitmap);
                QMLog.d(InnerWebView.TAG, "onPageStarted " + str);
            }

            @Override // com.tencent.smtt.sdk.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                String str;
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                String url = webView.getUrl();
                InnerWebView.this.onWebviewPageError(url);
                if (!FastClickUtils.isFastDoubleClick(InnerWebView.TAG, 200L)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onReceivedError ");
                    sb5.append(url);
                    sb5.append("; webResourceError : ");
                    if (webResourceError != null) {
                        str = ((Object) webResourceError.getDescription()) + " " + webResourceError.getErrorCode();
                    } else {
                        str = null;
                    }
                    sb5.append(str);
                    QMLog.d(InnerWebView.TAG, sb5.toString());
                }
            }

            @Override // com.tencent.smtt.sdk.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                WebResourceResponse doIPV6OnlyRequest;
                if (IPV6OnlyUtils.isIPV6Enable(webResourceRequest.getUrl().toString()) && (doIPV6OnlyRequest = InnerWebView.this.doIPV6OnlyRequest(webView, webResourceRequest)) != null) {
                    return doIPV6OnlyRequest;
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }

            @Override // com.tencent.smtt.sdk.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                WebView.HitTestResult hitTestResult;
                if (InnerWebView.this.shouldOverrideUrlDomain(str) || InnerWebView.this.shouldOverrideUrlTel(str)) {
                    return true;
                }
                String schemeFromUrl = BrowserUtils.getSchemeFromUrl(str);
                if ((schemeFromUrl.startsWith("http") || schemeFromUrl.startsWith("https")) && (hitTestResult = webView.getHitTestResult()) != null && hitTestResult.getType() == 0) {
                    QMLog.i(InnerWebView.TAG, "shouldOverrideUrlLoading detect 302, url: " + str);
                    ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).buildCookieForRedirect(str);
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        });
    }

    private boolean isBase64(String str) {
        if (!str.startsWith(WEB_BASE64_PREFIX_JPG) && !str.startsWith(WEB_BASE64_PREFIX_PNG) && !str.startsWith(WEB_BASE64_PREFIX_JPEG)) {
            return false;
        }
        return true;
    }

    private boolean isNetworkUrl(String str) {
        if (!str.toLowerCase().startsWith("http://") && !str.toLowerCase().startsWith("https://")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWebviewPageError(final String str) {
        if (this.mMiniAppContext != null && str != null && !str.equals("about:blank")) {
            this.mMiniAppContext.performAction(new Action<Void>() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.7
                @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
                public Void perform(BaseRuntime baseRuntime) {
                    IPage page = baseRuntime.getPage();
                    if (!(page instanceof AppBrandPageContainer)) {
                        QMLog.d(Action.TAG, "Page is invalid");
                        return null;
                    }
                    AppBrandPageContainer appBrandPageContainer = (AppBrandPageContainer) page;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("htmlId", InnerWebView.this.htmlId);
                        jSONObject.put("src", str);
                        int pageId = PageAction.obtain(InnerWebView.this.mMiniAppContext).getPageId();
                        if (appBrandPageContainer.getShowingPage() != null && appBrandPageContainer.getShowingPage().getBrandPageWebview() != null) {
                            appBrandPageContainer.getShowingPage().getBrandPageWebview().evaluateSubscribeJS(a.l.NAME, jSONObject.toString(), pageId);
                        }
                    } catch (Exception e16) {
                        QMLog.e(Action.TAG, "onPageStarted error." + e16);
                    }
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWebviewPageFinished(final String str) {
        if (this.mMiniAppContext != null && str != null && !str.equals("about:blank")) {
            this.mMiniAppContext.performAction(new Action<Void>() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.6
                @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
                public Void perform(BaseRuntime baseRuntime) {
                    IPage page = baseRuntime.getPage();
                    if (!(page instanceof AppBrandPageContainer)) {
                        QMLog.d(Action.TAG, "Page is invalid");
                        return null;
                    }
                    AppBrandPageContainer appBrandPageContainer = (AppBrandPageContainer) page;
                    AppBrandPage showingPage = appBrandPageContainer.getShowingPage();
                    if (showingPage != null && showingPage.getNavBar() != null) {
                        showingPage.getNavBar().updateProgress((byte) 2);
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("htmlId", InnerWebView.this.htmlId);
                        jSONObject.put("src", str);
                        int pageId = PageAction.obtain(InnerWebView.this.mMiniAppContext).getPageId();
                        if (appBrandPageContainer.getShowingPage() != null && appBrandPageContainer.getShowingPage().getBrandPageWebview() != null) {
                            appBrandPageContainer.getShowingPage().getBrandPageWebview().evaluateSubscribeJS(a.j.NAME, jSONObject.toString(), pageId);
                        }
                    } catch (Exception e16) {
                        QMLog.e(Action.TAG, "onPageStarted error." + e16);
                    }
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realSharePicToQQ(String str) {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.getAttachActivity() != null && !TextUtils.isEmpty(str)) {
            InnerShareData build = new InnerShareData.Builder().setShareTarget(0).setSharePicPath(str).build();
            ShareProxy shareProxy = (ShareProxy) ProxyManager.get(ShareProxy.class);
            if (shareProxy != null) {
                shareProxy.sharePic(this.mMiniAppContext.getAttachActivity(), build);
                return;
            } else {
                QMLog.i(TAG, "proxy null");
                return;
            }
        }
        QMLog.e(TAG, "param error," + str);
    }

    private boolean savaBase64DataToLocalPath(String str, String str2) {
        String replace = str.replace(WEB_BASE64_PREFIX_JPG, "").replace(WEB_BASE64_PREFIX_JPEG, "").replace(WEB_BASE64_PREFIX_PNG, "");
        if (TextUtils.isEmpty(str2)) {
            QMLog.e(TAG, "getTempFilePath return null !");
            return false;
        }
        try {
            boolean saveByteBufferToLocalFile = saveByteBufferToLocalFile(Base64.decode(replace.getBytes(), 2), str2);
            QMLog.d(TAG, "saveByteBufferToLocalFile ret:" + saveByteBufferToLocalFile);
            return saveByteBufferToLocalFile;
        } catch (Exception e16) {
            QMLog.d(TAG, "Base64.decode Exception: " + e16.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void savaPicToAlbum(String str) {
        QMLog.d(TAG, "savaPicToAlbum : " + str);
        WeakReference<Activity> weakReference = this.mActivity;
        if (weakReference != null && weakReference.get() != null && !this.mActivity.get().isFinishing()) {
            if (TextUtils.isEmpty(str)) {
                QMLog.e(TAG, "savaPicToAlbum failed, because of sourceUrl is empty");
                MiniToast.makeText(this.mActivity.get(), 1, "\u4fdd\u5b58\u5931\u8d25", 0).show();
                return;
            } else if (isNetworkUrl(str)) {
                handleSaveWithNetworkUrl(str);
                return;
            } else if (isBase64(str)) {
                handleSaveWithBase64(str);
                return;
            } else {
                saveImageToAlbum(str);
                return;
            }
        }
        QMLog.e(TAG, "savaPicToAlbum failed, because of mActivity is empty");
        MiniToast.makeText(this.mActivity.get(), 1, "\u4fdd\u5b58\u5931\u8d25", 0).show();
    }

    protected static boolean saveByteBufferToLocalFile(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e16) {
                        QMLog.d(TAG, "fos close " + e16);
                    }
                    return true;
                } catch (IOException e17) {
                    e = e17;
                    fileOutputStream = fileOutputStream2;
                    QMLog.d(TAG, "save bytes to local file " + e);
                    if (fileOutputStream == null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Exception e18) {
                        QMLog.d(TAG, "fos close " + e18);
                        return false;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e19) {
                            QMLog.d(TAG, "fos close " + e19);
                        }
                    }
                    throw th;
                }
            } catch (IOException e26) {
                e = e26;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImageToAlbum(String str) {
        String str2;
        WeakReference<Activity> weakReference = this.mActivity;
        if (weakReference != null && weakReference.get() != null && !this.mActivity.get().isFinishing()) {
            String localPathSuffix = MiniAppFileManager.getLocalPathSuffix(str);
            File file = new File(str);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(System.currentTimeMillis() / 1000);
            sb5.append("_");
            sb5.append(file.getName());
            if (TextUtils.isEmpty(localPathSuffix)) {
                str2 = "." + getImageFileType(str);
            } else {
                str2 = "";
            }
            sb5.append(str2);
            String sb6 = sb5.toString();
            QMLog.d(TAG, "saveImageToAlbum savePath : " + sb6);
            IPermissionManagerProxy iPermissionManagerProxy = (IPermissionManagerProxy) ProxyManager.get(IPermissionManagerProxy.class);
            if (Build.VERSION.SDK_INT < 29) {
                Activity activity = this.mActivity.get();
                Permissions permissions = Permissions.WRITE_EXTERNAL_STORAGE;
                if (!iPermissionManagerProxy.isPermissionGranted(activity, permissions)) {
                    iPermissionManagerProxy.requestForPermission(this.mActivity.get(), permissions, new a(file, sb6));
                    return;
                }
            }
            if (FileUtils.saveToSharedStorageCompat(this.mMiniAppContext.getContext(), file, sb6, FileUtils.MediaType.PICTURE)) {
                if (QMLog.isColorLevel()) {
                    QMLog.d(TAG, "savaPicToAlbum success.");
                }
                MiniToast.makeText(this.mActivity.get(), 2, "\u4fdd\u5b58\u6210\u529f", 0).show();
                return;
            } else {
                QMLog.e(TAG, "savaPicToAlbum failed.");
                MiniToast.makeText(this.mActivity.get(), 1, "\u4fdd\u5b58\u5931\u8d25", 0).show();
                return;
            }
        }
        QMLog.e(TAG, "savaPicToAlbum failed. activity error.");
        MiniToast.makeText(this.mActivity.get(), 1, "\u4fdd\u5b58\u5931\u8d25", 0).show();
    }

    private void setLongClickLisener() {
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                boolean z16;
                EventCollector.getInstance().onViewLongClickedBefore(view);
                WebView.HitTestResult hitTestResult = InnerWebView.this.webView.getHitTestResult();
                if (hitTestResult.getType() != 5 && hitTestResult.getType() != 8) {
                    z16 = false;
                } else {
                    final String extra = hitTestResult.getExtra();
                    if (QMLog.isColorLevel()) {
                        QMLog.e(InnerWebView.TAG, "onLongClick : " + extra);
                    }
                    final ActionSheet create = ActionSheet.create(InnerWebView.this.webView.getContext());
                    create.addButton("\u53d1\u9001\u7ed9\u670b\u53cb", 7);
                    create.addButton("\u4fdd\u5b58\u5230\u624b\u673a", 7);
                    create.addCancelButton("\u53d6\u6d88");
                    create.setOutsideDismissEnableCompat(true);
                    create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.1.1
                        @Override // com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet.OnButtonClickListener
                        public void onClick(View view2, int i3) {
                            create.dismiss();
                            String content = create.getContent(i3);
                            if ("\u53d1\u9001\u7ed9\u670b\u53cb".equals(content)) {
                                InnerWebView.this.sharePicToQQ(extra);
                            } else if ("\u4fdd\u5b58\u5230\u624b\u673a".equals(content)) {
                                InnerWebView.this.savaPicToAlbum(extra);
                            }
                        }
                    });
                    create.show();
                    z16 = true;
                }
                EventCollector.getInstance().onViewLongClicked(view);
                return z16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sharePicToQQ(String str) {
        WeakReference<Activity> weakReference;
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "sharePicToQQ : " + str);
        }
        if (TextUtils.isEmpty(str) && (weakReference = this.mActivity) != null && weakReference.get() != null) {
            QMLog.e(TAG, "sharePicToQQ failed, because of sourceUrl is empty");
            MiniToast.makeText(this.mActivity.get(), 1, ShareJsPlugin.ERRMSG_INVITE_REQUIRE, 0).show();
        } else if (isNetworkUrl(str)) {
            handleShareWebImage(str);
        } else if (isBase64(str)) {
            handleShareBase64Image(str);
        } else {
            realSharePicToQQ(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldOverrideUrlDomain(String str) {
        if ((this.mMiniAppContext != null && !TextUtils.isEmpty(str) && str.startsWith("https:")) || str.startsWith("http:")) {
            boolean isDomainValid = DomainUtil.isDomainValid(this.mMiniAppContext.getMiniAppInfo(), false, str, 4);
            QMLog.i(TAG, "shouldOverrideUrlLoading url = " + str + "; ret = " + isDomainValid);
            if (!isDomainValid) {
                String config = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_MINI_APP_WEBVIEWCCOMPONENT_ERRORPAGE, WnsConfig.SECONDARY_MINI_APP_WEBVIEWCCOMPONENT_ERRORPAGE);
                if (!TextUtils.isEmpty(config)) {
                    config = config.replace("{url}", str).replace("{appid}", this.mMiniAppContext.getMiniAppInfo().appId);
                }
                loadUrl(config);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldOverrideUrlTel(String str) {
        WeakReference<Activity> weakReference;
        if (!TextUtils.isEmpty(str) && str.startsWith(WebView.SCHEME_TEL) && (weakReference = this.mActivity) != null && weakReference.get() != null && !this.mActivity.get().isFinishing()) {
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
            intent.putExtra("big_brother_source_key", "biz_src_miniapp");
            try {
                this.mActivity.get().startActivity(intent);
                return true;
            } catch (Throwable th5) {
                QMLog.e(TAG, "error happend:" + th5);
                return true;
            }
        }
        return false;
    }

    private void webViewEvaluteJs(String str, int i3) {
        final String format = String.format("__WeixinJSBridge__.invokeCallbackHandler(%d, %s)", Integer.valueOf(i3), str);
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.9
            @Override // java.lang.Runnable
            public void run() {
                InnerWebView.this.webView.evaluateJavascript(format, null);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public int createNativeBuffer(byte[] bArr, long j3, long j16) {
        return 0;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public void evaluateCallbackJs(int i3, String str) {
        webViewEvaluteJs(str, i3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public void evaluateSubscribeJS(String str, String str2, int i3) {
        QMLog.i(TAG, "evaluateSubcribeJS : eventName " + str + "; data : " + str2 + "; webviweId : " + i3);
        final String str3 = "__WeixinJSBridge__.subscribeHandler(\"" + str + "\"," + str2 + ",\"" + i3 + "\")";
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.8
            @Override // java.lang.Runnable
            public void run() {
                if (InnerWebView.this.webView != null) {
                    InnerWebView.this.webView.evaluateJavascript(str3, null);
                }
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public byte[] getNativeBuffer(int i3) {
        return new byte[0];
    }

    protected void handleReceivedTitle(final String str) {
        QMLog.d(TAG, "onReceivedTitle title : " + str);
        if (!TextUtils.isEmpty(str) && !str.equals("about:blank")) {
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (InnerWebView.this.mMiniAppContext != null) {
                        InnerWebView.this.mMiniAppContext.performAction(new Action<Void>() { // from class: com.tencent.qqmini.miniapp.widget.InnerWebView.3.1
                            @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
                            public Void perform(BaseRuntime baseRuntime) {
                                IPage page = baseRuntime.getPage();
                                if (!(page instanceof AppBrandPageContainer)) {
                                    QMLog.d(Action.TAG, "Page is invalid");
                                    return null;
                                }
                                AppBrandPage showingPage = ((AppBrandPageContainer) page).getShowingPage();
                                if (showingPage != null && showingPage.getNavBar() != null) {
                                    showingPage.getNavBar().setInnerWebViewCanGoBack(InnerWebView.this.canGoBack());
                                    showingPage.getNavBar().setTitleTextFromMiniApp(str);
                                }
                                return null;
                            }
                        });
                    }
                }
            });
        }
    }

    public void init(IMiniAppContext iMiniAppContext) {
        BaselibLoader.BaselibContent baselibContent;
        this.mMiniAppContext = iMiniAppContext;
        if (StringUtil.isEmpty(this.miniAppWebviewStr) && (baselibContent = ((BaseRuntimeImpl.BaselibProvider) iMiniAppContext.getManager(BaseRuntimeImpl.BaselibProvider.class)).getBaselibContent()) != null) {
            this.miniAppWebviewStr = baselibContent.miniappWebviewStr;
        }
        this.webView = this;
        addJavascriptInterface(new QQJSCoreInterface(), "QQJSCore");
        initWebChromeClient();
        initWebviewClient();
        setLongClickLisener();
    }

    public void onActivityResult(int i3, int i16, Intent intent) {
        FileChooserHelper fileChooserHelper = this.mFileChooserHelper;
        if (fileChooserHelper != null && fileChooserHelper.doOnActivityResult(i3, i16, intent) && QMLog.isColorLevel()) {
            QMLog.d(TAG, "Activity result handled by FileChooserHelper.");
        }
    }

    protected void updateProgressBar(AppBrandPage appBrandPage) {
        if (appBrandPage != null && appBrandPage.getNavBar() != null) {
            appBrandPage.getNavBar().updateProgress((byte) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a implements RequestPermissionCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f346333a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f346334b;

        a(File file, String str) {
            this.f346333a = file;
            this.f346334b = str;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onFail() {
            QMLog.e(InnerWebView.TAG, "savaPicToAlbum failed.");
            MiniToast.makeText((Context) InnerWebView.this.mActivity.get(), 1, "\u4fdd\u5b58\u5931\u8d25", 0).show();
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onSuccess() {
            if (FileUtils.saveToSharedStorageCompat(InnerWebView.this.mMiniAppContext.getContext(), this.f346333a, this.f346334b, FileUtils.MediaType.PICTURE)) {
                if (QMLog.isColorLevel()) {
                    QMLog.d(InnerWebView.TAG, "savaPicToAlbum success.");
                }
                MiniToast.makeText((Context) InnerWebView.this.mActivity.get(), 2, "\u4fdd\u5b58\u6210\u529f", 0).show();
            } else {
                QMLog.e(InnerWebView.TAG, "savaPicToAlbum failed.");
                MiniToast.makeText((Context) InnerWebView.this.mActivity.get(), 1, "\u4fdd\u5b58\u5931\u8d25", 0).show();
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
        public void onPartialGrant() {
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public void evaluateJs(String str, android.webkit.ValueCallback valueCallback) {
    }
}
