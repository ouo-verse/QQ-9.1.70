package com.tencent.xweb.pinus;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.print.PrintDocumentAdapter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.textclassifier.TextClassifier;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ar.g0;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.t0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.sq.a;
import com.tencent.luggage.wxa.sq.c;
import com.tencent.luggage.wxa.sq.d;
import com.tencent.luggage.wxa.sq.e;
import com.tencent.luggage.wxa.wq.f;
import com.tencent.luggage.wxa.wq.i;
import com.tencent.luggage.wxa.wq.m;
import com.tencent.mobileqq.R;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.GetImageBitmapToFileFinishedCallback;
import com.tencent.xweb.RenderProcessGoneDetail;
import com.tencent.xweb.VideoControl;
import com.tencent.xweb.VideoJsCallback;
import com.tencent.xweb.WebDebugCfg;
import com.tencent.xweb.WebSettings;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebViewCallbackClient;
import com.tencent.xweb.WebViewDatabase;
import com.tencent.xweb.WebViewJSExceptionListener;
import com.tencent.xweb.WebViewRenderProcessClient;
import com.tencent.xweb.XWebKeyEventHandler;
import com.tencent.xweb.XWebSdk;
import com.tencent.xweb.XWebTranslateLogic;
import com.tencent.xweb.XWebWebViewClientExtensionInterceptor;
import com.tencent.xweb.internal.ConstValue;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.ProxyWebViewClientExtension;
import com.tencent.xweb.pinus.PinusWebDataTrans;
import com.tencent.xweb.pinus.sdk.HitTestResultInterface;
import com.tencent.xweb.pinus.sdk.HttpAuthHandlerInterface;
import com.tencent.xweb.pinus.sdk.JsResultInterface;
import com.tencent.xweb.pinus.sdk.JsResultInterfaceImpl;
import com.tencent.xweb.pinus.sdk.SslErrorHandlerInterface;
import com.tencent.xweb.pinus.sdk.WebChromeClient;
import com.tencent.xweb.pinus.sdk.WebResourceErrorInterface;
import com.tencent.xweb.pinus.sdk.WebView;
import com.tencent.xweb.pinus.sdk.WebViewClient;
import java.util.Map;
import java.util.concurrent.Executor;
import org.xwalk.core.XWalkEnvironment;

/* loaded from: classes27.dex */
public class PinusWebView implements IWebView, XWebTranslateLogic.TranslateLogicCallback {
    private static final String TAG = "PinusWebView";
    private static volatile boolean sEnforceThreadChecking = false;
    private final int mApkVersion;
    private final XWebWebViewClientExtensionInterceptor mClientExtensionInterceptor;
    private final ProxyWebViewClientExtension mPinusProxyWebViewClientExtension;
    private final PinusWebViewSettings mPinusWebViewSettings;
    private final AbsoluteLayout mTopView;
    private final XWebTranslateLogic mTranslateLogic;
    private final WebChromeClient mWebChromeClient;
    private final CustomPsWeb mWebView;
    private WebViewCallbackClient mWebViewCallbackClient;
    private com.tencent.xweb.WebChromeClient mWebViewChromeClientEx;
    private final WebViewClient mWebViewClient;
    private com.tencent.xweb.WebViewClient mWebViewClientEx;
    private final Looper mWebViewThread;
    private final WebView mWebviewWraper;
    private a mXWebNativeInterface;
    private long mLoadStartTimestamp = 0;
    private boolean bIsIn404Stage = false;
    private boolean mIsClampedY = false;
    private int mReferType = 0;
    private ProxyWebViewClientExtension mWebViewClientExtension = new ProxyWebViewClientExtension();
    private WebViewJSExceptionListener jsExceptionListener = null;
    private WebChromeClient.CustomViewCallback mFullscreenCallback = null;
    private boolean mIsFullscreen = false;
    private boolean mIsMediaPlaybackRequiresUserGesture = false;
    private boolean mIsVideoPlaybackRequiresUserGesture = false;

    public PinusWebView(WebView webView) {
        boolean z16;
        com.tencent.xweb.pinus.sdk.WebChromeClient webChromeClient = new com.tencent.xweb.pinus.sdk.WebChromeClient() { // from class: com.tencent.xweb.pinus.PinusWebView.4
            @Override // com.tencent.xweb.pinus.sdk.WebChromeClient
            public View getVideoLoadingProgressView() {
                if (PinusWebView.this.mWebViewChromeClientEx != null) {
                    return PinusWebView.this.mWebViewChromeClientEx.getVideoLoadingProgressView();
                }
                return LayoutInflater.from(PinusWebView.this.mWebviewWraper.getContext()).inflate(R.layout.i8q, (ViewGroup) null);
            }

            @Override // com.tencent.xweb.pinus.sdk.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (ConsoleMessage.MessageLevel.ERROR == consoleMessage.messageLevel() && PinusWebView.this.jsExceptionListener != null) {
                    String[] split = consoleMessage.message().split(":");
                    if (split.length == 2) {
                        PinusWebView.this.jsExceptionListener.onJsException(consoleMessage.sourceId(), split[0], split[1]);
                        n0.z();
                    }
                }
                if (PinusWebView.this.mWebViewChromeClientEx != null) {
                    return PinusWebView.this.mWebViewChromeClientEx.onConsoleMessage(consoleMessage);
                }
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // com.tencent.xweb.pinus.sdk.WebChromeClient
            public boolean onCreateWindow(com.tencent.xweb.pinus.sdk.WebView webView2, boolean z17, boolean z18, Message message) {
                if (PinusWebView.this.mWebViewChromeClientEx != null) {
                    return PinusWebView.this.mWebViewChromeClientEx.onCreateWindow(PinusWebView.this.mWebviewWraper, z17, z18, message);
                }
                return super.onCreateWindow(webView2, z17, z18, message);
            }

            @Override // com.tencent.xweb.pinus.sdk.WebChromeClient
            public void onExitFullscreenVideo(Bitmap bitmap) {
                x0.d(PinusWebView.TAG, "onExitFullscreenVideo");
                if (PinusWebView.this.mWebViewChromeClientEx != null) {
                    PinusWebView.this.mWebViewChromeClientEx.onExitFullscreenVideo(bitmap);
                }
            }

            @Override // com.tencent.xweb.pinus.sdk.WebChromeClient
            public void onGeolocationPermissionsHidePrompt() {
                x0.d(PinusWebView.TAG, "onGeolocationPermissionsHidePrompt");
                if (PinusWebView.this.mWebViewChromeClientEx != null) {
                    PinusWebView.this.mWebViewChromeClientEx.onGeolocationPermissionsHidePrompt();
                } else {
                    super.onGeolocationPermissionsHidePrompt();
                }
            }

            @Override // com.tencent.xweb.pinus.sdk.WebChromeClient
            public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                x0.d(PinusWebView.TAG, "onGeolocationPermissionsShowPrompt");
                if (PinusWebView.this.mWebViewChromeClientEx != null) {
                    PinusWebView.this.mWebViewChromeClientEx.onGeolocationPermissionsShowPrompt(str, callback);
                } else {
                    super.onGeolocationPermissionsShowPrompt(str, callback);
                }
            }

            @Override // com.tencent.xweb.pinus.sdk.WebChromeClient
            public void onGetSampleString(com.tencent.xweb.pinus.sdk.WebView webView2, Map<String, String> map) {
                PinusWebView.this.mTranslateLogic.onGetSampleString(map);
            }

            @Override // com.tencent.xweb.pinus.sdk.WebChromeClient
            public void onGetTranslateString(com.tencent.xweb.pinus.sdk.WebView webView2, Map<String, String> map) {
                PinusWebView.this.mTranslateLogic.onGetTranslateString(map);
            }

            @Override // com.tencent.xweb.pinus.sdk.WebChromeClient
            public void onHideCustomView() {
                boolean z17;
                x0.d(PinusWebView.TAG, "onHideCustomView");
                PinusWebView.this.mFullscreenCallback = null;
                if (PinusWebView.this.mIsFullscreen) {
                    PinusWebView.this.mIsFullscreen = false;
                    x0.d(PinusWebView.TAG, "onHideCustomView, mIsMediaPlaybackRequiresUserGesture:" + PinusWebView.this.mIsMediaPlaybackRequiresUserGesture + ", mIsVideoPlaybackRequiresUserGesture:" + PinusWebView.this.mIsVideoPlaybackRequiresUserGesture);
                    PinusWebView.this.mWebView.getSettings().setMediaPlaybackRequiresUserGesture(PinusWebView.this.mIsMediaPlaybackRequiresUserGesture);
                    PinusWebView.this.mWebView.getSettings().setVideoPlaybackRequiresUserGesture(PinusWebView.this.mIsVideoPlaybackRequiresUserGesture);
                }
                if (PinusWebView.this.mWebViewChromeClientEx != null) {
                    z17 = PinusWebView.this.mWebViewChromeClientEx.onExitFullscreen();
                } else {
                    z17 = false;
                }
                if (z17) {
                    x0.d(PinusWebView.TAG, "onHideCustomView isHandled:true");
                    return;
                }
                PinusWebView.this.mTopView.setVisibility(0);
                if (PinusWebView.this.mXWebNativeInterface != null) {
                    PinusWebView.this.mXWebNativeInterface.a();
                } else if (PinusWebView.this.mWebViewChromeClientEx != null) {
                    PinusWebView.this.mWebViewChromeClientEx.onHideCustomView();
                } else {
                    super.onHideCustomView();
                }
            }

            @Override // com.tencent.xweb.pinus.sdk.WebChromeClient
            public boolean onJsAlert(com.tencent.xweb.pinus.sdk.WebView webView2, String str, String str2, JsResultInterface jsResultInterface) {
                x0.d(PinusWebView.TAG, "onJsAlert, message:" + str2);
                if (PinusWebView.this.mWebViewChromeClientEx != null) {
                    return PinusWebView.this.mWebViewChromeClientEx.onJsAlert(PinusWebView.this.mWebviewWraper, str, str2, new PinusWebDataTrans.PsWebJsResultImpl(jsResultInterface));
                }
                return super.onJsAlert(webView2, str, str2, jsResultInterface);
            }

            @Override // com.tencent.xweb.pinus.sdk.WebChromeClient
            public boolean onJsAlertInner(com.tencent.xweb.pinus.sdk.WebView webView2, String str, String str2, Object obj) {
                return onJsAlert(webView2, str, str2, new JsResultInterfaceImpl(obj));
            }

            @Override // com.tencent.xweb.pinus.sdk.WebChromeClient
            public boolean onJsConfirm(com.tencent.xweb.pinus.sdk.WebView webView2, String str, String str2, JsResultInterface jsResultInterface) {
                x0.d(PinusWebView.TAG, "onJsConfirm, message:" + str2);
                if (PinusWebView.this.mWebViewChromeClientEx != null) {
                    return PinusWebView.this.mWebViewChromeClientEx.onJsConfirm(PinusWebView.this.mWebviewWraper, str, str2, new PinusWebDataTrans.PsWebJsResultImpl(jsResultInterface));
                }
                return super.onJsConfirm(webView2, str, str2, jsResultInterface);
            }

            @Override // com.tencent.xweb.pinus.sdk.WebChromeClient
            public boolean onJsConfirmInner(com.tencent.xweb.pinus.sdk.WebView webView2, String str, String str2, Object obj) {
                return onJsConfirm(webView2, str, str2, new JsResultInterfaceImpl(obj));
            }

            @Override // com.tencent.xweb.pinus.sdk.WebChromeClient
            public boolean onJsPrompt(com.tencent.xweb.pinus.sdk.WebView webView2, String str, String str2, String str3, JsResultInterface jsResultInterface) {
                x0.d(PinusWebView.TAG, "onJsPrompt, message:" + str2);
                if (PinusWebView.this.mWebViewChromeClientEx != null) {
                    return PinusWebView.this.mWebViewChromeClientEx.onJsPrompt(PinusWebView.this.mWebviewWraper, str, str2, str3, new PinusWebDataTrans.PsWebJsPromptResultImpl(jsResultInterface));
                }
                return super.onJsPrompt(webView2, str, str2, str3, jsResultInterface);
            }

            @Override // com.tencent.xweb.pinus.sdk.WebChromeClient
            public boolean onJsPromptInner(com.tencent.xweb.pinus.sdk.WebView webView2, String str, String str2, String str3, Object obj) {
                return onJsPrompt(webView2, str, str2, str3, new JsResultInterfaceImpl(obj));
            }

            @Override // com.tencent.xweb.pinus.sdk.WebChromeClient
            public void onPermissionRequest(PermissionRequest permissionRequest) {
                if (PinusWebView.this.mWebViewChromeClientEx != null) {
                    PinusWebView.this.mWebViewChromeClientEx.onPermissionRequest(permissionRequest);
                } else {
                    super.onPermissionRequest(permissionRequest);
                }
            }

            @Override // com.tencent.xweb.pinus.sdk.WebChromeClient
            public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
                if (PinusWebView.this.mWebViewChromeClientEx != null) {
                    PinusWebView.this.mWebViewChromeClientEx.onPermissionRequestCanceled(permissionRequest);
                } else {
                    super.onPermissionRequestCanceled(permissionRequest);
                }
            }

            @Override // com.tencent.xweb.pinus.sdk.WebChromeClient
            public void onProgressChanged(com.tencent.xweb.pinus.sdk.WebView webView2, int i3) {
                if (PinusWebView.this.mWebViewChromeClientEx != null) {
                    PinusWebView.this.mWebViewChromeClientEx.onProgressChanged(PinusWebView.this.mWebviewWraper, i3);
                } else {
                    super.onProgressChanged(webView2, i3);
                }
            }

            @Override // com.tencent.xweb.pinus.sdk.WebChromeClient
            public void onReceivedTitle(com.tencent.xweb.pinus.sdk.WebView webView2, String str) {
                boolean z17;
                x0.d(PinusWebView.TAG, "onReceivedTitle: " + str);
                if (PinusWebView.this.mWebViewChromeClientEx != null) {
                    PinusWebView.this.mWebViewChromeClientEx.onReceivedTitle(PinusWebView.this.mWebviewWraper, str);
                } else {
                    super.onReceivedTitle(webView2, str);
                }
                if (PinusWebView.this.mXWebNativeInterface != null) {
                    a aVar = PinusWebView.this.mXWebNativeInterface;
                    if (PinusWebView.this.mWebviewWraper.getFullscreenVideoKind() == WebView.FullscreenVideoKind.HOOK_EVALUTE_JS) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    aVar.a(true, z17);
                }
            }

            @Override // com.tencent.xweb.pinus.sdk.WebChromeClient
            public void onRequestFocus(com.tencent.xweb.pinus.sdk.WebView webView2) {
                if (PinusWebView.this.mWebViewChromeClientEx != null) {
                    PinusWebView.this.mWebViewChromeClientEx.onRequestFocus(PinusWebView.this.mWebviewWraper);
                } else {
                    super.onRequestFocus(webView2);
                }
            }

            @Override // com.tencent.xweb.pinus.sdk.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                x0.d(PinusWebView.TAG, "onShowCustomView");
                PinusWebView.this.mFullscreenCallback = customViewCallback;
                boolean z17 = false;
                if (!PinusWebView.this.mIsFullscreen) {
                    PinusWebView.this.mIsFullscreen = true;
                    PinusWebView pinusWebView = PinusWebView.this;
                    pinusWebView.mIsMediaPlaybackRequiresUserGesture = pinusWebView.mWebView.getSettings().getMediaPlaybackRequiresUserGesture();
                    PinusWebView pinusWebView2 = PinusWebView.this;
                    pinusWebView2.mIsVideoPlaybackRequiresUserGesture = pinusWebView2.mWebView.getSettings().getVideoPlaybackRequiresUserGesture();
                    x0.d(PinusWebView.TAG, "onShowCustomView, mIsMediaPlaybackRequiresUserGesture:" + PinusWebView.this.mIsMediaPlaybackRequiresUserGesture + ", mIsVideoPlaybackRequiresUserGesture:" + PinusWebView.this.mIsVideoPlaybackRequiresUserGesture);
                    PinusWebView.this.mWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
                    PinusWebView.this.mWebView.getSettings().setVideoPlaybackRequiresUserGesture(false);
                }
                if (PinusWebView.this.mWebViewChromeClientEx != null) {
                    z17 = PinusWebView.this.mWebViewChromeClientEx.onEnterFullscreen(view, customViewCallback);
                }
                n0.U();
                if (z17) {
                    x0.d(PinusWebView.TAG, "onShowCustomView isHandled:true");
                    return;
                }
                PinusWebView.this.mTopView.setVisibility(4);
                if (PinusWebView.this.mXWebNativeInterface != null) {
                    n0.a(WebView.WebViewKind.WV_KIND_PINUS, PinusWebView.this.mXWebNativeInterface instanceof d, PinusWebView.this.getUrl());
                    PinusWebView.this.mXWebNativeInterface.a(view, customViewCallback);
                } else if (PinusWebView.this.mWebViewChromeClientEx != null) {
                    PinusWebView.this.mWebViewChromeClientEx.onShowCustomView(view, customViewCallback);
                } else {
                    super.onShowCustomView(view, customViewCallback);
                }
            }

            @Override // com.tencent.xweb.pinus.sdk.WebChromeClient
            public boolean onShowFileChooser(com.tencent.xweb.pinus.sdk.WebView webView2, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                x0.d(PinusWebView.TAG, "onShowFileChooser last method");
                if (PinusWebView.this.mWebViewChromeClientEx != null) {
                    return PinusWebView.this.mWebViewChromeClientEx.onShowFileChooser(PinusWebView.this.mWebviewWraper, valueCallback, new PinusWebDataTrans.PsWebFileChooserParamsImpl(fileChooserParams));
                }
                return super.onShowFileChooser(webView2, valueCallback, fileChooserParams);
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback) {
                x0.d(PinusWebView.TAG, "openFileChooser with one param");
                if (PinusWebView.this.mWebViewChromeClientEx != null) {
                    PinusWebView.this.mWebViewChromeClientEx.openFileChooser(valueCallback, null, null);
                } else {
                    valueCallback.onReceiveValue(null);
                }
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
                x0.d(PinusWebView.TAG, "openFileChooser with two param");
                if (PinusWebView.this.mWebViewChromeClientEx != null) {
                    PinusWebView.this.mWebViewChromeClientEx.openFileChooser(valueCallback, str, null);
                } else {
                    valueCallback.onReceiveValue(null);
                }
            }

            public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
                x0.d(PinusWebView.TAG, "openFileChooser with three param");
                if (PinusWebView.this.mWebViewChromeClientEx != null) {
                    PinusWebView.this.mWebViewChromeClientEx.openFileChooser(valueCallback, str, str2);
                } else {
                    valueCallback.onReceiveValue(null);
                }
            }
        };
        this.mWebChromeClient = webChromeClient;
        WebViewClient webViewClient = new WebViewClient() { // from class: com.tencent.xweb.pinus.PinusWebView.5
            private String mPreUrl = null;
            private String mStrLastFinishedUrl = null;
            private String mSessionId = null;

            @Override // com.tencent.xweb.pinus.sdk.WebViewClient
            public void doUpdateVisitedHistory(com.tencent.xweb.pinus.sdk.WebView webView2, String str, boolean z17) {
                if (str != null && str.startsWith("data:text/html;charset=utf-8")) {
                    x0.f(PinusWebView.TAG, "doUpdateVisitedHistory, ignore");
                } else if (PinusWebView.this.mWebViewClientEx != null) {
                    PinusWebView.this.mWebViewClientEx.doUpdateVisitedHistory(PinusWebView.this.mWebviewWraper, str, z17);
                } else {
                    super.doUpdateVisitedHistory(webView2, str, z17);
                }
            }

            @Override // com.tencent.xweb.pinus.sdk.WebViewClient
            public void onLoadResource(com.tencent.xweb.pinus.sdk.WebView webView2, String str) {
                if (PinusWebView.this.mWebViewClientEx != null) {
                    PinusWebView.this.mWebViewClientEx.onLoadResource(PinusWebView.this.mWebviewWraper, str);
                } else {
                    super.onLoadResource(webView2, str);
                }
            }

            @Override // com.tencent.xweb.pinus.sdk.WebViewClient
            public void onPageCommitVisible(com.tencent.xweb.pinus.sdk.WebView webView2, String str) {
                x0.d(PinusWebView.TAG, "onPageCommitVisible, webview:" + webView2.hashCode() + ", url:" + str);
                if (PinusWebView.this.mWebViewClientEx != null) {
                    PinusWebView.this.mWebViewClientEx.onPageCommitVisible(PinusWebView.this.mWebviewWraper, str);
                }
            }

            @Override // com.tencent.xweb.pinus.sdk.WebViewClient
            public void onPageFinished(com.tencent.xweb.pinus.sdk.WebView webView2, String str) {
                boolean z17;
                String str2 = this.mStrLastFinishedUrl;
                if (str2 != null && str2.equals(str)) {
                    x0.d(PinusWebView.TAG, "onPageFinished abandoned, url:" + str);
                    return;
                }
                x0.d(PinusWebView.TAG, "onPageFinished, webview:" + webView2.hashCode() + ", url:" + str);
                if (PinusWebView.this.mXWebNativeInterface != null) {
                    a aVar = PinusWebView.this.mXWebNativeInterface;
                    if (PinusWebView.this.mWebviewWraper.getFullscreenVideoKind() == WebView.FullscreenVideoKind.HOOK_EVALUTE_JS) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    aVar.a(false, z17);
                }
                this.mStrLastFinishedUrl = str;
                if (PinusWebView.this.mWebViewClientEx != null) {
                    PinusWebView.this.mWebViewClientEx.onPageFinished(PinusWebView.this.mWebviewWraper, str);
                } else {
                    super.onPageFinished(webView2, str);
                }
                long currentTimeMillis = System.currentTimeMillis() - PinusWebView.this.mLoadStartTimestamp;
                n0.f(currentTimeMillis);
                i.a(n0.a(str), this.mSessionId, 1, 0, (int) currentTimeMillis, PinusWebView.this.mReferType, str, WebView.WebViewKind.WV_KIND_PINUS);
                PinusWebView.this.mLoadStartTimestamp = System.currentTimeMillis();
                PinusWebView.this.mWebviewWraper.getDebugView().f();
            }

            @Override // com.tencent.xweb.pinus.sdk.WebViewClient
            public void onPageStarted(com.tencent.xweb.pinus.sdk.WebView webView2, String str, Bitmap bitmap) {
                boolean z17;
                x0.d(PinusWebView.TAG, "onPageStarted, webview:" + webView2.hashCode() + ", url:" + str);
                if (PinusWebView.this.mWebViewClientEx != null) {
                    PinusWebView.this.mWebViewClientEx.onPageStarted(PinusWebView.this.mWebviewWraper, str, bitmap);
                } else {
                    super.onPageStarted(webView2, str, bitmap);
                }
                this.mStrLastFinishedUrl = null;
                this.mSessionId = n0.a();
                String str2 = this.mPreUrl;
                if (str2 != null && str != null && !str.equals(str2) && n0.a(str) != n0.a(this.mPreUrl)) {
                    if (n0.a(this.mPreUrl) == 1 && n0.a(str) == 2) {
                        PinusWebView.this.mReferType = 1;
                    } else if (n0.a(this.mPreUrl) == 2 && n0.a(str) == 1) {
                        PinusWebView.this.mReferType = 2;
                    }
                }
                this.mPreUrl = str;
                PinusWebView.this.mLoadStartTimestamp = System.currentTimeMillis();
                n0.d(str);
                i.a(n0.a(str), this.mSessionId, 0, 0, 0, PinusWebView.this.mReferType, str, WebView.WebViewKind.WV_KIND_PINUS);
                if (PinusWebView.this.mXWebNativeInterface != null) {
                    a aVar = PinusWebView.this.mXWebNativeInterface;
                    if (PinusWebView.this.mWebviewWraper.getFullscreenVideoKind() == WebView.FullscreenVideoKind.HOOK_EVALUTE_JS) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    aVar.a(true, z17);
                }
                PinusWebView.this.mTranslateLogic.onPageLoadStarted();
            }

            @Override // com.tencent.xweb.pinus.sdk.WebViewClient
            public void onReceivedError(com.tencent.xweb.pinus.sdk.WebView webView2, int i3, String str, String str2) {
                x0.d(PinusWebView.TAG, "onReceivedError, webview:" + webView2.hashCode() + ", errorCode:" + i3 + ", desc:" + str + ", url:" + str2);
                PinusWebView.this.bIsIn404Stage = true;
                if (PinusWebView.this.mWebViewClientEx != null) {
                    PinusWebView.this.mWebViewClientEx.onReceivedError(PinusWebView.this.mWebviewWraper, i3, str, str2);
                } else {
                    super.onReceivedError(webView2, i3, str, str2);
                }
                n0.S();
                i.a(n0.a(str2), this.mSessionId, 1, i3, (int) (System.currentTimeMillis() - PinusWebView.this.mLoadStartTimestamp), PinusWebView.this.mReferType, str2, WebView.WebViewKind.WV_KIND_PINUS);
                if (PinusWebView.this.mWebViewClientEx == null || !PinusWebView.this.mWebViewClientEx.shouldInterceptLoadError(PinusWebView.this.mWebviewWraper, i3, str, str2)) {
                    PinusWebView.this.mWebView.loadDataWithBaseURL("file:///android_asset/", t0.a(PinusWebView.this.mWebviewWraper.getContext(), i3, str, str2), "text/html", "utf-8", null);
                }
            }

            @Override // com.tencent.xweb.pinus.sdk.WebViewClient
            public void onReceivedHttpAuthRequest(com.tencent.xweb.pinus.sdk.WebView webView2, HttpAuthHandlerInterface httpAuthHandlerInterface, String str, String str2) {
                x0.d(PinusWebView.TAG, "onReceivedHttpAuthRequest, host:" + str + ", realm:" + str2);
                if (PinusWebView.this.mWebViewClientEx != null) {
                    PinusWebView.this.mWebViewClientEx.onReceivedHttpAuthRequest(PinusWebView.this.mWebviewWraper, new PinusWebDataTrans.PsWebHttpAuthHandler(httpAuthHandlerInterface), str, str2);
                } else {
                    super.onReceivedHttpAuthRequest(webView2, httpAuthHandlerInterface, str, str2);
                }
            }

            @Override // com.tencent.xweb.pinus.sdk.WebViewClient
            public void onReceivedHttpError(com.tencent.xweb.pinus.sdk.WebView webView2, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                String str;
                x0.d(PinusWebView.TAG, "onReceivedHttpError, webview:" + webView2.hashCode() + ", errorCode:" + String.valueOf(webResourceResponse.getStatusCode()));
                if (PinusWebView.this.mWebViewClientEx != null) {
                    PinusWebView.this.mWebViewClientEx.onReceivedHttpError(PinusWebView.this.mWebviewWraper, new PinusWebDataTrans.WebResourceRequestImpl(webResourceRequest), PinusWebDataTrans.createWCWebResponse(webResourceResponse));
                } else {
                    super.onReceivedHttpError(webView2, webResourceRequest, webResourceResponse);
                }
                if (webResourceRequest.isForMainFrame()) {
                    if (webResourceRequest.getUrl() != null) {
                        str = webResourceRequest.getUrl().toString();
                    } else {
                        str = "";
                    }
                    onPageFinished(webView2, str);
                }
            }

            @Override // com.tencent.xweb.pinus.sdk.WebViewClient
            public void onReceivedSslError(com.tencent.xweb.pinus.sdk.WebView webView2, SslErrorHandlerInterface sslErrorHandlerInterface, SslError sslError) {
                x0.d(PinusWebView.TAG, "onReceivedSslError, webview:" + webView2.hashCode() + ", error:" + sslError.getPrimaryError());
                if (PinusWebView.this.mWebViewClientEx != null) {
                    PinusWebView.this.mWebViewClientEx.onReceivedSslError(PinusWebView.this.mWebviewWraper, new PinusWebDataTrans.SslErrorHandlerImp(sslErrorHandlerInterface), sslError);
                } else {
                    super.onReceivedSslError(webView2, sslErrorHandlerInterface, sslError);
                }
            }

            @Override // com.tencent.xweb.pinus.sdk.WebViewClient
            public boolean onRenderProcessGone(com.tencent.xweb.pinus.sdk.WebView webView2, final RenderProcessGoneDetail renderProcessGoneDetail) {
                x0.d(PinusWebView.TAG, "onRenderProcessGone, webview:" + webView2.hashCode() + ", didCrash:" + renderProcessGoneDetail.didCrash() + ", rendererPriorityAtExit:" + renderProcessGoneDetail.rendererPriorityAtExit());
                m.a(webView2, renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
                if (PinusWebView.this.mWebViewClientEx != null) {
                    return PinusWebView.this.mWebViewClientEx.onRenderProcessGone(PinusWebView.this.mWebviewWraper, new RenderProcessGoneDetail() { // from class: com.tencent.xweb.pinus.PinusWebView.5.1
                        @Override // com.tencent.xweb.RenderProcessGoneDetail
                        public boolean didCrash() {
                            return renderProcessGoneDetail.didCrash();
                        }

                        @Override // com.tencent.xweb.RenderProcessGoneDetail
                        public int rendererPriorityAtExit() {
                            return renderProcessGoneDetail.rendererPriorityAtExit();
                        }
                    });
                }
                return super.onRenderProcessGone(webView2, renderProcessGoneDetail);
            }

            @Override // com.tencent.xweb.pinus.sdk.WebViewClient
            public void onScaleChanged(com.tencent.xweb.pinus.sdk.WebView webView2, float f16, float f17) {
                if (PinusWebView.this.mWebViewClientEx != null) {
                    PinusWebView.this.mWebViewClientEx.onScaleChanged(PinusWebView.this.mWebviewWraper, f16, f17);
                } else {
                    super.onScaleChanged(webView2, f16, f17);
                }
            }

            @Override // com.tencent.xweb.pinus.sdk.WebViewClient
            public WebResourceResponse shouldInterceptRequest(com.tencent.xweb.pinus.sdk.WebView webView2, String str) {
                if (PinusWebView.this.mWebViewClientEx != null) {
                    return PinusWebDataTrans.createWebKitResponse(PinusWebView.this.mWebViewClientEx.shouldInterceptRequest(PinusWebView.this.mWebviewWraper, str));
                }
                return super.shouldInterceptRequest(webView2, str);
            }

            @Override // com.tencent.xweb.pinus.sdk.WebViewClient
            public boolean shouldOverrideUrlLoading(com.tencent.xweb.pinus.sdk.WebView webView2, String str) {
                if (PinusWebView.this.mWebviewWraper.getDebugView().b(str)) {
                    return true;
                }
                if (PinusWebView.this.mWebViewClientEx != null) {
                    boolean shouldOverrideUrlLoading = PinusWebView.this.mWebViewClientEx.shouldOverrideUrlLoading(PinusWebView.this.mWebviewWraper, str);
                    x0.d(PinusWebView.TAG, "shouldOverrideUrlLoading, ret:" + shouldOverrideUrlLoading + ", url:" + str);
                    return shouldOverrideUrlLoading;
                }
                return super.shouldOverrideUrlLoading(webView2, str);
            }

            @Override // com.tencent.xweb.pinus.sdk.WebViewClient
            public WebResourceResponse shouldInterceptRequest(com.tencent.xweb.pinus.sdk.WebView webView2, WebResourceRequest webResourceRequest) {
                if (PinusWebView.this.mWebViewClientEx != null) {
                    PinusWebDataTrans.WebResourceRequestImpl webResourceRequestImpl = new PinusWebDataTrans.WebResourceRequestImpl(webResourceRequest);
                    Bundle bundle = webResourceRequestImpl.getBundle();
                    com.tencent.xweb.WebResourceResponse shouldInterceptRequest = bundle != null ? PinusWebView.this.mWebViewClientEx.shouldInterceptRequest(PinusWebView.this.mWebviewWraper, webResourceRequestImpl, bundle) : null;
                    if (shouldInterceptRequest == null) {
                        shouldInterceptRequest = PinusWebView.this.mWebViewClientEx.shouldInterceptRequest(PinusWebView.this.mWebviewWraper, webResourceRequestImpl);
                    }
                    if (shouldInterceptRequest == null) {
                        shouldInterceptRequest = PinusWebView.this.mWebViewClientEx.shouldInterceptRequest(PinusWebView.this.mWebviewWraper, webResourceRequest.getUrl().toString());
                    }
                    return PinusWebDataTrans.createWebKitResponse(shouldInterceptRequest);
                }
                return super.shouldInterceptRequest(webView2, webResourceRequest);
            }

            @Override // com.tencent.xweb.pinus.sdk.WebViewClient
            public boolean shouldOverrideUrlLoading(com.tencent.xweb.pinus.sdk.WebView webView2, WebResourceRequest webResourceRequest) {
                if (PinusWebView.this.mWebviewWraper.getDebugView().b(webResourceRequest.getUrl().toString())) {
                    return true;
                }
                if (PinusWebView.this.mWebViewClientEx != null) {
                    boolean shouldOverrideUrlLoading = PinusWebView.this.mWebViewClientEx.shouldOverrideUrlLoading(PinusWebView.this.mWebviewWraper, new PinusWebDataTrans.WebResourceRequestImpl(webResourceRequest));
                    x0.d(PinusWebView.TAG, "shouldOverrideUrlLoading, ret:" + shouldOverrideUrlLoading + ", url:" + webResourceRequest.getUrl().toString());
                    return shouldOverrideUrlLoading;
                }
                return super.shouldOverrideUrlLoading(webView2, webResourceRequest);
            }

            @Override // com.tencent.xweb.pinus.sdk.WebViewClient
            public void onReceivedError(com.tencent.xweb.pinus.sdk.WebView webView2, WebResourceRequest webResourceRequest, WebResourceErrorInterface webResourceErrorInterface) {
                x0.d(PinusWebView.TAG, "onReceivedError, webview:" + webView2.hashCode() + ", errorCode:" + webResourceErrorInterface.getErrorCode() + ", desc:" + ((Object) webResourceErrorInterface.getDescription()) + ", url:" + webResourceRequest.getUrl());
                if (PinusWebView.this.mWebViewClientEx != null) {
                    PinusWebView.this.mWebViewClientEx.onReceivedError(PinusWebView.this.mWebviewWraper, new PinusWebDataTrans.WebResourceRequestImpl(webResourceRequest), PinusWebDataTrans.createPSWebResourceError(webResourceErrorInterface));
                } else {
                    super.onReceivedError(webView2, webResourceRequest, webResourceErrorInterface);
                }
            }
        };
        this.mWebViewClient = webViewClient;
        ProxyWebViewClientExtension proxyWebViewClientExtension = new ProxyWebViewClientExtension() { // from class: com.tencent.xweb.pinus.PinusWebView.6
            @Override // com.tencent.xweb.internal.ProxyWebViewClientExtension
            public Object onMiscCallBack(String str, Bundle bundle) {
                if (PinusWebView.this.mClientExtensionInterceptor != null) {
                    XWebWebViewClientExtensionInterceptor.InterceptResult interceptOnMiscCallback = PinusWebView.this.mClientExtensionInterceptor.interceptOnMiscCallback(str, bundle);
                    if (interceptOnMiscCallback.intercepted) {
                        x0.d(PinusWebView.TAG, "onMiscCallBack, method(" + str + ") intercepted, result:" + interceptOnMiscCallback.result);
                        return interceptOnMiscCallback.result;
                    }
                }
                if (PinusWebView.this.mWebViewClientExtension != null) {
                    return PinusWebView.this.mWebViewClientExtension.onMiscCallBack(str, bundle);
                }
                return null;
            }
        };
        this.mPinusProxyWebViewClientExtension = proxyWebViewClientExtension;
        this.mWebViewThread = Looper.myLooper();
        if (webView.getContext().getApplicationInfo().targetSdkVersion >= 18) {
            z16 = true;
        } else {
            z16 = false;
        }
        sEnforceThreadChecking = z16;
        int availableVersion = XWalkEnvironment.getAvailableVersion();
        this.mApkVersion = availableVersion;
        PSContextWrapper pSContextWrapper = new PSContextWrapper(webView.getContext(), availableVersion);
        CustomPsWeb customPsWeb = new CustomPsWeb(pSContextWrapper);
        this.mWebView = customPsWeb;
        AbsoluteLayout absoluteLayout = new AbsoluteLayout(pSContextWrapper);
        this.mTopView = absoluteLayout;
        customPsWeb.getContentView().addView(absoluteLayout);
        customPsWeb.setCustomOnScrollChangedListener(new WebView.ScrollChangedListener() { // from class: com.tencent.xweb.pinus.PinusWebView.1
            @Override // com.tencent.xweb.pinus.sdk.WebView.ScrollChangedListener
            public void onScrollChanged(int i3, int i16, int i17, int i18) {
                PinusWebView.this.mTopView.scrollTo(i3, i16);
                if (PinusWebView.this.mWebViewCallbackClient != null) {
                    PinusWebView.this.mWebViewCallbackClient.onScrollChanged(i3, i16, i17, i18, PinusWebView.this.mWebView);
                }
            }
        });
        customPsWeb.setCustomOnOverScrolledListener(new WebView.OverScrolledListener() { // from class: com.tencent.xweb.pinus.PinusWebView.2
            @Override // com.tencent.xweb.pinus.sdk.WebView.OverScrolledListener
            public void onOverScrolled(boolean z17) {
                PinusWebView.this.mIsClampedY = z17;
            }

            @Override // com.tencent.xweb.pinus.sdk.WebView.OverScrolledListener
            public boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z17, View view) {
                if (PinusWebView.this.mWebViewCallbackClient != null) {
                    return PinusWebView.this.mWebViewCallbackClient.overScrollBy(i3, i16, i17, i18, i19, i26, i27, i28, z17, view);
                }
                return false;
            }

            @Override // com.tencent.xweb.pinus.sdk.WebView.OverScrolledListener
            public void onOverScrolled(int i3, int i16, boolean z17, boolean z18, View view) {
                if (PinusWebView.this.mWebViewCallbackClient != null) {
                    PinusWebView.this.mWebViewCallbackClient.onOverScrolled(i3, i16, z17, z18, view);
                }
            }
        });
        customPsWeb.setBackgroundColor(0);
        this.mWebviewWraper = webView;
        this.mPinusWebViewSettings = new PinusWebViewSettings(customPsWeb);
        customPsWeb.setWebChromeClient(webChromeClient);
        customPsWeb.setWebViewClient(webViewClient);
        this.mClientExtensionInterceptor = new XWebWebViewClientExtensionInterceptor(this);
        customPsWeb.setProxyWebViewClientExtension(proxyWebViewClientExtension);
        this.mTranslateLogic = new XWebTranslateLogic(webView, this);
        initFullscreenVideo(customPsWeb.getContext());
    }

    private void checkThread() {
        if (this.mWebViewThread != null && Looper.myLooper() != this.mWebViewThread) {
            Throwable th5 = new Throwable("A WebView method was called on thread '" + Thread.currentThread().getName() + "'. All WebView methods must be called on the same thread. (Expected Looper " + this.mWebViewThread + " called on " + Looper.myLooper() + ", FYI main Looper is " + Looper.getMainLooper() + ")");
            String stackTraceString = Log.getStackTraceString(th5);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("checkThread error:");
            sb5.append(stackTraceString);
            x0.f(TAG, sb5.toString());
            f.a(3, stackTraceString, WebView.WebViewKind.WV_KIND_PINUS.ordinal());
            if (sEnforceThreadChecking) {
                throw new RuntimeException(th5);
            }
        }
    }

    public static void clearClientCertPreferences(@Nullable Runnable runnable) {
        if (PSCoreWrapper.getInstance() != null) {
            g0 g0Var = new g0((Class) PSCoreWrapper.getInstance().getBridgeClass("AwContentsStatics"), "clearClientCertPreferences", Runnable.class);
            if (!g0Var.a()) {
                g0Var.a(runnable);
                return;
            } else {
                x0.c(TAG, "AwContentsStatics clearClientCertPreferences function not found");
                return;
            }
        }
        x0.c(TAG, "AwContentsStatics clearClientCertPreferences error, not inited");
    }

    public static String findAddress(String str) {
        if (PSCoreWrapper.getInstance() != null) {
            g0 g0Var = new g0((Class) PSCoreWrapper.getInstance().getBridgeClass("AwContentsStatics"), "findAddress", String.class);
            if (!g0Var.a()) {
                return (String) g0Var.a(str);
            }
            x0.c(TAG, "AwContentsStatics findAddress function not found");
            return "";
        }
        x0.c(TAG, "AwContentsStatics findAddress error, not inited");
        return "";
    }

    private void initFullscreenVideo(Context context) {
        x0.d(TAG, "initFullscreenVideo, kind:" + getFullscreenVideoKind() + ", activity:" + context);
        this.mXWebNativeInterface = e.a(this.mWebviewWraper.getCurrentInstanceWebCoreType(), context, this.mWebviewWraper, this.mWebView, c.a());
        if (getFullscreenVideoKind() == WebView.FullscreenVideoKind.HOOK_EVALUTE_JS) {
            this.mXWebNativeInterface.b(this.mWebView);
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int addDocumentStartJavaScript(String str, String[] strArr) {
        return this.mWebView.addDocumentStartJavaScript(str, strArr);
    }

    @Override // com.tencent.xweb.internal.IWebView
    @SuppressLint({"JavascriptInterface"})
    public void addJavascriptInterface(Object obj, String str) {
        this.mWebView.addJavascriptInterface(obj, str);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean canGoBack() {
        if (this.bIsIn404Stage) {
            return false;
        }
        return this.mWebView.canGoBack();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean canGoBackOrForward(int i3) {
        return this.mWebView.canGoBackOrForward(i3);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean canGoForward() {
        return this.mWebView.canGoForward();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void captureBitmap(final IWebView.ICaptureBitmapCallback iCaptureBitmapCallback) {
        final View childAt = ((ViewGroup) ((ViewGroup) this.mWebView.getChildAt(0)).getChildAt(0)).getChildAt(0);
        if (childAt instanceof TextureView) {
            com.tencent.luggage.wxa.lq.d.a(new Runnable() { // from class: com.tencent.xweb.pinus.PinusWebView.7
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap = ((TextureView) childAt).getBitmap();
                    x0.d(PinusWebView.TAG, "captureBitmap, onFinishGetBitmap:" + bitmap);
                    iCaptureBitmapCallback.onBitmapCaptureFinished(bitmap);
                }
            });
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void clearCache(boolean z16) {
        this.mWebView.clearCache(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void clearHistory() {
        this.mWebView.clearHistory();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void clearMatches() {
        this.mWebView.clearMatches();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void clearSslPreferences() {
        this.mWebView.clearSslPreferences();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void clearView() {
        this.mWebView.clearView();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public WebBackForwardList copyBackForwardList() {
        return this.mWebView.copyBackForwardList();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public PrintDocumentAdapter createPrintDocumentAdapter(String str) {
        return this.mWebView.createPrintDocumentAdapter(str);
    }

    @Override // com.tencent.xweb.internal.IWebView
    @NonNull
    public WebMessagePort[] createWebMessageChannel() {
        return null;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void destroy() {
        this.mWebView.destroy();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void disableVideoJsCallback(boolean z16) {
        a aVar = this.mXWebNativeInterface;
        if (aVar != null) {
            aVar.a(z16);
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void documentHasImages(Message message) {
        this.mWebView.documentHasImages(message);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.mWebView.evaluateJavascript(str, valueCallback);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void findAllAsync(String str) {
        this.mWebView.findAllAsync(str);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void findNext(boolean z16) {
        this.mWebView.findNext(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void flingScroll(int i3, int i16) {
        this.mWebView.flingScroll(i3, i16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String getAbstractInfo() {
        return "pinus, sdk ver = " + XWebSdk.getXWebSdkVersion() + "\napk ver = " + XWalkEnvironment.getAvailableVersion() + "\ndetail = " + XWalkEnvironment.getAvailableVersionDetail();
    }

    public Object getBridge() {
        CustomPsWeb customPsWeb = this.mWebView;
        if (customPsWeb == null) {
            x0.c(TAG, "getPinusBridge, mWebview is null");
            return null;
        }
        return customPsWeb.getBridge();
    }

    @Override // com.tencent.xweb.internal.IWebView
    @Nullable
    public SslCertificate getCertificate() {
        return this.mWebView.getCertificate();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getContentHeight() {
        return this.mWebView.getContentHeight();
    }

    public com.tencent.luggage.wxa.tq.a getCookieManager() {
        return new PinusCookieManagerWrapper();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public Bitmap getFavicon() {
        return this.mWebView.getFavicon();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public WebView.FullscreenVideoKind getFullscreenVideoKind() {
        return CommandCfg.getInstance().getFullscreenVideoKind(com.tencent.xweb.WebView.getModuleName());
    }

    @Override // com.tencent.xweb.internal.IWebView
    public WebView.HitTestResult getHitTestResult() {
        WebView.HitTestResult hitTestResult = new WebView.HitTestResult();
        HitTestResultInterface hitTestResult2 = this.mWebView.getHitTestResult();
        hitTestResult.setType(hitTestResult2.getType());
        hitTestResult.setExtra(hitTestResult2.getExtra());
        return hitTestResult;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        return WebViewDatabase.getInstance(this.mWebView.getContext()).getHttpAuthUsernamePassword(str, str2);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean getImageBitmapToFile(String str, String str2, String str3, GetImageBitmapToFileFinishedCallback getImageBitmapToFileFinishedCallback) {
        return this.mWebView.getImageBitmapToFile(str, str2, str3, getImageBitmapToFileFinishedCallback);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String getOriginalUrl() {
        return this.mWebView.getOriginalUrl();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getProgress() {
        return this.mWebView.getProgress();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public float getScale() {
        return this.mWebView.getScale();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getScrollHeight() {
        return this.mWebView.computeVerticalScrollRange();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public WebSettings getSettings() {
        if (WebDebugCfg.getInst().getEnableCheckThread()) {
            checkThread();
        }
        return this.mPinusWebViewSettings;
    }

    @Override // com.tencent.xweb.internal.IWebView
    @Nullable
    public TextClassifier getTextClassifier() {
        return null;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String getTitle() {
        return this.mWebView.getTitle();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public ViewGroup getTopView() {
        return this.mTopView;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String getUrl() {
        return this.mWebView.getUrl();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String getVersionInfo() {
        return "pinus, sdkver:" + XWebSdk.getXWebSdkVersion() + ", apkver:" + this.mApkVersion;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public View getView() {
        return this.mWebView;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getVisibleTitleHeight() {
        return 0;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public com.tencent.xweb.WebChromeClient getWebChromeClient() {
        return this.mWebViewChromeClientEx;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getWebScrollX() {
        View webViewUI = getWebViewUI();
        if (webViewUI instanceof com.tencent.xweb.pinus.sdk.WebView) {
            return ((com.tencent.xweb.pinus.sdk.WebView) webViewUI).computeHorizontalScrollOffset();
        }
        return webViewUI.getScrollX();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getWebScrollY() {
        return this.mWebView.computeVerticalScrollOffset();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public WebViewCallbackClient getWebViewCallbackClient() {
        return this.mWebViewCallbackClient;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public com.tencent.xweb.WebViewClient getWebViewClient() {
        return this.mWebViewClientEx;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public Looper getWebViewLooper() {
        return this.mWebViewThread;
    }

    @Override // com.tencent.xweb.internal.IWebView
    @Nullable
    public WebViewRenderProcessClient getWebViewRenderProcessClient() {
        return null;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public View getWebViewUI() {
        return this.mWebView;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void goBack() {
        this.mWebView.goBack();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void goBackOrForward(int i3) {
        this.mWebView.goBackOrForward(i3);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void goForward() {
        this.mWebView.goForward();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean hasEnteredFullscreen() {
        return this.mIsFullscreen;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public Bundle invokeMiscMethod(String str, Bundle bundle) {
        if (str != null && str.length() != 0) {
            x0.b(TAG, "invokeMiscMethod, method:" + str);
            if (str.equals("supportTranslateWebSite")) {
                boolean isSupportTranslateWebSite = PinusWebFactory.getInstance().isSupportTranslateWebSite();
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("result", isSupportTranslateWebSite);
                x0.d(TAG, "translate: xweb is supportTranslateWebSite = " + isSupportTranslateWebSite);
                return bundle2;
            }
            if (str.equals("getTranslateSampleString")) {
                x0.d(TAG, "translate: xweb is detectTranslateWebSiteIsNeeded, getTranslateSampleString");
                this.mWebView.getTranslateSampleString(0);
                return null;
            }
            if (str.equals("translateWebSite")) {
                this.mTranslateLogic.setIsInTranslateMode(true);
                return null;
            }
            if (str.equals("replaceTranslatedString")) {
                this.mTranslateLogic.replaceTranslatedString(bundle);
            }
            return null;
        }
        x0.b(TAG, "invokeMiscMethod, method string is null or empty");
        return null;
    }

    public boolean isClampedY() {
        return this.mIsClampedY;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean isOverScrollStart() {
        int scrollY;
        boolean isClampedY = isClampedY();
        View webViewUI = getWebViewUI();
        if (webViewUI instanceof com.tencent.xweb.pinus.sdk.WebView) {
            scrollY = ((com.tencent.xweb.pinus.sdk.WebView) webViewUI).computeVerticalScrollOffset();
        } else {
            scrollY = webViewUI.getScrollY();
        }
        if (scrollY == 0 && isClampedY) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void leaveFullscreen() {
        WebChromeClient.CustomViewCallback customViewCallback = this.mFullscreenCallback;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void loadData(String str, String str2, String str3) {
        this.mWebView.loadData(str, str2, str3);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.mWebView.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void loadUrl(String str) {
        if (str != null && str.trim().startsWith(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX)) {
            this.mWebView.evaluateJavascript(str, null);
        } else {
            this.bIsIn404Stage = false;
            this.mWebView.loadUrl(str);
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void onHide() {
        this.mWebView.onHide();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void onPause() {
        this.mWebView.onPause();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void onResume() {
        this.mWebView.onResume();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void onShow() {
        this.mWebView.onShow();
    }

    @Override // com.tencent.xweb.XWebTranslateLogic.TranslateLogicCallback
    public void onTranslateFinish() {
        ProxyWebViewClientExtension proxyWebViewClientExtension = this.mWebViewClientExtension;
        if (proxyWebViewClientExtension != null) {
            proxyWebViewClientExtension.onMiscCallBack("onTranslateFinish", new Bundle());
        }
    }

    @Override // com.tencent.xweb.XWebTranslateLogic.TranslateLogicCallback
    public void onTranslateMiscCallBack(String str, Bundle bundle) {
        ProxyWebViewClientExtension proxyWebViewClientExtension = this.mWebViewClientExtension;
        if (proxyWebViewClientExtension != null) {
            proxyWebViewClientExtension.onMiscCallBack(str, bundle);
        }
    }

    @Override // com.tencent.xweb.XWebTranslateLogic.TranslateLogicCallback
    public void onTranslateStart() {
        ProxyWebViewClientExtension proxyWebViewClientExtension = this.mWebViewClientExtension;
        if (proxyWebViewClientExtension != null) {
            proxyWebViewClientExtension.onMiscCallBack("onTranslateStart", new Bundle());
        }
        this.mWebView.setTranslateMode(true);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean overlayHorizontalScrollbar() {
        int scrollBarStyle = this.mWebView.getScrollBarStyle();
        if (scrollBarStyle != 0 && scrollBarStyle != 33554432) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean overlayVerticalScrollbar() {
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean pageDown(boolean z16) {
        return this.mWebView.pageDown(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean pageUp(boolean z16) {
        return this.mWebView.pageUp(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void pauseTimers() {
        this.mWebView.pauseTimers();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void postUrl(@NonNull String str, @NonNull byte[] bArr) {
        if (URLUtil.isNetworkUrl(str)) {
            this.mWebView.postUrl(str, bArr);
        } else {
            this.mWebView.loadUrl(str);
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void reload() {
        this.mWebView.reload();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void removeDocumentStartJavaScript(int i3) {
        this.mWebView.removeDocumentStartJavaScript(i3);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void removeJavascriptInterface(String str) {
        this.mWebView.removeJavascriptInterface(str);
    }

    @Override // com.tencent.xweb.XWebTranslateLogic.TranslateLogicCallback
    public void replaceTranslatedString(Map<String, String> map) {
        this.mWebView.replaceTranslatedString(map);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void requestFocusNodeHref(@Nullable Message message) {
        this.mWebView.requestFocusNodeHref(message);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void requestImageRef(@NonNull Message message) {
        this.mWebView.requestImageRef(message);
    }

    @Override // com.tencent.xweb.internal.IWebView
    @Nullable
    public WebBackForwardList restoreState(Bundle bundle) {
        return this.mWebView.restoreState(bundle);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void resumeTimers() {
        this.mWebView.resumeTimers();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean savePage(String str, String str2, int i3) {
        return this.mWebView.savePage(str, str2, i3);
    }

    @Override // com.tencent.xweb.internal.IWebView
    @Nullable
    public WebBackForwardList saveState(Bundle bundle) {
        return this.mWebView.saveState(bundle);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void saveWebArchive(String str) {
        this.mWebView.saveWebArchive(str);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setAudioMuted(boolean z16) {
        this.mWebView.setAudioMuted(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setBottomHeight(int i3) {
        this.mWebView.setBottomHeight(i3);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setDownloadListener(DownloadListener downloadListener) {
        this.mWebView.setDownloadListener(downloadListener);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setFindListener(WebView.FindListener findListener) {
        this.mWebView.setFindListener(findListener);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setHorizontalScrollBarEnabled(boolean z16) {
        this.mWebView.setHorizontalScrollBarEnable(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        WebViewDatabase.getInstance(this.mWebView.getContext()).setHttpAuthUsernamePassword(str, str2, str3, str4);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setInitialScale(int i3) {
        this.mWebView.setInitialScale(i3);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setJSExceptionListener(WebViewJSExceptionListener webViewJSExceptionListener) {
        this.jsExceptionListener = webViewJSExceptionListener;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setNetworkAvailable(boolean z16) {
        this.mWebView.setNetworkAvailable(z16);
    }

    public void setScrollBarStyle(int i3) {
        this.mWebView.setScrollBarStyle(i3);
    }

    public void setScrollbarFadingEnabled(boolean z16) {
        this.mWebView.setScrollbarFadingEnabled(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setVerticalScrollBarEnabled(boolean z16) {
        this.mWebView.setVerticalScrollBarEnable(z16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public VideoControl setVideoJsCallback(VideoJsCallback videoJsCallback) {
        a aVar = this.mXWebNativeInterface;
        if (aVar != null && aVar.a(videoJsCallback)) {
            return new VideoControl() { // from class: com.tencent.xweb.pinus.PinusWebView.3
                @Override // com.tencent.xweb.VideoControl
                public boolean supportSetRequestedOrientationCallback() {
                    if (PinusWebView.this.mXWebNativeInterface != null) {
                        return PinusWebView.this.mXWebNativeInterface.supportSetRequestedOrientationCallback();
                    }
                    return false;
                }

                @Override // com.tencent.xweb.VideoControl
                public void videoChangeStatus() {
                    if (PinusWebView.this.mXWebNativeInterface != null) {
                        PinusWebView.this.mXWebNativeInterface.videoChangeStatus();
                    }
                }

                @Override // com.tencent.xweb.VideoControl
                public void videoExitFullscreen() {
                    if (PinusWebView.this.mXWebNativeInterface != null) {
                        PinusWebView.this.mXWebNativeInterface.videoExitFullscreen();
                    }
                }

                @Override // com.tencent.xweb.VideoControl
                public void videoMute(boolean z16) {
                    if (PinusWebView.this.mXWebNativeInterface != null) {
                        PinusWebView.this.mXWebNativeInterface.videoMute(z16);
                    }
                }

                @Override // com.tencent.xweb.VideoControl
                public void videoPause() {
                    if (PinusWebView.this.mXWebNativeInterface != null) {
                        PinusWebView.this.mXWebNativeInterface.videoPause();
                    }
                }

                @Override // com.tencent.xweb.VideoControl
                public void videoPlay() {
                    if (PinusWebView.this.mXWebNativeInterface != null) {
                        PinusWebView.this.mXWebNativeInterface.videoPlay();
                    }
                }

                @Override // com.tencent.xweb.VideoControl
                public void videoPlaybackRate(double d16) {
                    if (PinusWebView.this.mXWebNativeInterface != null) {
                        PinusWebView.this.mXWebNativeInterface.videoPlaybackRate(d16);
                    }
                }

                @Override // com.tencent.xweb.VideoControl
                public void videoSeek(double d16) {
                    if (PinusWebView.this.mXWebNativeInterface != null) {
                        PinusWebView.this.mXWebNativeInterface.videoSeek(d16);
                    }
                }
            };
        }
        x0.d(TAG, "setVideoJsCallback not support");
        return null;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setWebChromeClient(com.tencent.xweb.WebChromeClient webChromeClient) {
        this.mWebViewChromeClientEx = webChromeClient;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setWebContentsSize(int i3, int i16) {
        this.mWebView.setWebContentsSize(i3, i16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setWebViewCallbackClient(WebViewCallbackClient webViewCallbackClient) {
        this.mWebViewCallbackClient = webViewCallbackClient;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setWebViewClient(com.tencent.xweb.WebViewClient webViewClient) {
        this.mWebViewClientEx = webViewClient;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setWebViewClientExtension(ProxyWebViewClientExtension proxyWebViewClientExtension) {
        this.mWebViewClientExtension = proxyWebViewClientExtension;
        this.mWebView.setProxyWebViewClientExtension(this.mPinusProxyWebViewClientExtension);
    }

    public void setWebViewRenderProcessClient(@Nullable WebViewRenderProcessClient webViewRenderProcessClient) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setXWebKeyEventHandler(XWebKeyEventHandler xWebKeyEventHandler) {
        PinusStandAloneChannel.getInstance().invokeRuntimeChannel(ConstValue.INVOKE_RUNTIME_ID_SET_INTERCEPT_DISPATCH_KEY_HANDLER, new Object[]{getBridge(), xWebKeyEventHandler});
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void smoothScroll(int i3, int i16, long j3) {
        this.mWebView.smoothScroll(i3, i16, j3);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void stopLoading() {
        this.mWebView.stopLoading();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean supportFeature(int i3) {
        return PSCoreWrapper.getInstance().hasFeature(i3);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean supportSetWebContentsSize() {
        return supportFeature(1042);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void zoomBy(float f16) {
        this.mWebView.zoomBy(f16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean zoomIn() {
        return this.mWebView.zoomIn();
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean zoomOut() {
        return this.mWebView.zoomOut();
    }

    /* loaded from: classes27.dex */
    public class CustomPsWeb extends com.tencent.xweb.pinus.sdk.WebView {
        public CustomPsWeb(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void onScrollChanged(int i3, int i16, int i17, int i18) {
            super.onScrollChanged(i3, i16, i17, i18);
            if (PinusWebView.this.mWebviewWraper != null) {
                PinusWebView.this.mWebviewWraper.onWebViewScrollChanged(i3, i16, i17, i18);
            }
        }

        public CustomPsWeb(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void clearHistory(int i3, int i16) {
        this.mWebView.clearHistory(i3, i16);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void saveWebArchive(String str, boolean z16, @Nullable ValueCallback<String> valueCallback) {
        this.mWebView.saveWebArchive(str, z16, valueCallback);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setWebViewRenderProcessClient(@NonNull Executor executor, @NonNull WebViewRenderProcessClient webViewRenderProcessClient) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public Bitmap captureBitmap() {
        x0.d(TAG, "captureBitmap, start");
        View childAt = ((ViewGroup) ((ViewGroup) this.mWebView.getChildAt(0)).getChildAt(0)).getChildAt(0);
        if (!(childAt instanceof TextureView)) {
            return null;
        }
        Bitmap bitmap = ((TextureView) childAt).getBitmap();
        x0.d(TAG, "captureBitmap, bitmap:" + bitmap);
        return bitmap;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void loadUrl(String str, Map<String, String> map) {
        this.mWebView.loadUrl(str, map);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void disablePlatformNotifications() {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void enablePlatformNotifications() {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setHorizontalScrollbarOverlay(boolean z16) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    @Deprecated
    public void setPictureListener(WebView.PictureListener pictureListener) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setTextClassifier(@Nullable TextClassifier textClassifier) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setVerticalScrollbarOverlay(boolean z16) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void postVisualStateCallback(long j3, WebView.VisualStateCallback visualStateCallback) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void postWebMessage(@NonNull WebMessage webMessage, @NonNull Uri uri) {
    }
}
