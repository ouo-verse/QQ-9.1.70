package com.tencent.xweb.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.print.PrintDocumentAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.textclassifier.TextClassifier;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebView;
import com.tencent.xweb.CalledByApi;
import com.tencent.xweb.GetImageBitmapToFileFinishedCallback;
import com.tencent.xweb.VideoControl;
import com.tencent.xweb.VideoJsCallback;
import com.tencent.xweb.WebChromeClient;
import com.tencent.xweb.WebSettings;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebViewCallbackClient;
import com.tencent.xweb.WebViewClient;
import com.tencent.xweb.WebViewJSExceptionListener;
import com.tencent.xweb.WebViewRenderProcessClient;
import com.tencent.xweb.XWebKeyEventHandler;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IWebView {

    /* compiled from: P */
    @CalledByApi
    /* loaded from: classes27.dex */
    public interface ICaptureBitmapCallback {
        void onBitmapCaptureFinished(Bitmap bitmap);
    }

    int addDocumentStartJavaScript(String str, String[] strArr);

    void addJavascriptInterface(Object obj, String str);

    boolean canGoBack();

    boolean canGoBackOrForward(int i3);

    boolean canGoForward();

    Bitmap captureBitmap();

    void captureBitmap(ICaptureBitmapCallback iCaptureBitmapCallback);

    void clearCache(boolean z16);

    void clearHistory();

    void clearHistory(int i3, int i16);

    void clearMatches();

    void clearSslPreferences();

    void clearView();

    WebBackForwardList copyBackForwardList();

    PrintDocumentAdapter createPrintDocumentAdapter(String str);

    WebMessagePort[] createWebMessageChannel();

    void destroy();

    void disablePlatformNotifications();

    void disableVideoJsCallback(boolean z16);

    void documentHasImages(Message message);

    void enablePlatformNotifications();

    void evaluateJavascript(String str, ValueCallback valueCallback);

    void findAllAsync(String str);

    void findNext(boolean z16);

    void flingScroll(int i3, int i16);

    String getAbstractInfo();

    SslCertificate getCertificate();

    int getContentHeight();

    Bitmap getFavicon();

    WebView.FullscreenVideoKind getFullscreenVideoKind();

    WebView.HitTestResult getHitTestResult();

    String[] getHttpAuthUsernamePassword(String str, String str2);

    boolean getImageBitmapToFile(String str, String str2, String str3, GetImageBitmapToFileFinishedCallback getImageBitmapToFileFinishedCallback);

    String getOriginalUrl();

    int getProgress();

    float getScale();

    int getScrollHeight();

    WebSettings getSettings();

    TextClassifier getTextClassifier();

    String getTitle();

    ViewGroup getTopView();

    String getUrl();

    String getVersionInfo();

    View getView();

    int getVisibleTitleHeight();

    WebChromeClient getWebChromeClient();

    int getWebScrollX();

    int getWebScrollY();

    WebViewCallbackClient getWebViewCallbackClient();

    WebViewClient getWebViewClient();

    Looper getWebViewLooper();

    WebViewRenderProcessClient getWebViewRenderProcessClient();

    View getWebViewUI();

    void goBack();

    void goBackOrForward(int i3);

    void goForward();

    boolean hasEnteredFullscreen();

    Bundle invokeMiscMethod(String str, Bundle bundle);

    boolean isOverScrollStart();

    void leaveFullscreen();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void loadUrl(String str, Map map);

    void onHide();

    void onPause();

    void onResume();

    void onShow();

    boolean overlayHorizontalScrollbar();

    boolean overlayVerticalScrollbar();

    boolean pageDown(boolean z16);

    boolean pageUp(boolean z16);

    void pauseTimers();

    void postUrl(String str, byte[] bArr);

    void postVisualStateCallback(long j3, WebView.VisualStateCallback visualStateCallback);

    void postWebMessage(WebMessage webMessage, Uri uri);

    void reload();

    void removeDocumentStartJavaScript(int i3);

    void removeJavascriptInterface(String str);

    void requestFocusNodeHref(Message message);

    void requestImageRef(Message message);

    WebBackForwardList restoreState(Bundle bundle);

    void resumeTimers();

    boolean savePage(String str, String str2, int i3);

    WebBackForwardList saveState(Bundle bundle);

    void saveWebArchive(String str);

    void saveWebArchive(String str, boolean z16, ValueCallback valueCallback);

    void setAudioMuted(boolean z16);

    void setBottomHeight(int i3);

    void setDownloadListener(DownloadListener downloadListener);

    void setFindListener(WebView.FindListener findListener);

    void setHorizontalScrollBarEnabled(boolean z16);

    void setHorizontalScrollbarOverlay(boolean z16);

    void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4);

    void setInitialScale(int i3);

    void setJSExceptionListener(WebViewJSExceptionListener webViewJSExceptionListener);

    void setNetworkAvailable(boolean z16);

    void setPictureListener(WebView.PictureListener pictureListener);

    void setTextClassifier(TextClassifier textClassifier);

    void setVerticalScrollBarEnabled(boolean z16);

    void setVerticalScrollbarOverlay(boolean z16);

    VideoControl setVideoJsCallback(VideoJsCallback videoJsCallback);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebContentsSize(int i3, int i16);

    void setWebViewCallbackClient(WebViewCallbackClient webViewCallbackClient);

    void setWebViewClient(WebViewClient webViewClient);

    void setWebViewClientExtension(ProxyWebViewClientExtension proxyWebViewClientExtension);

    void setWebViewRenderProcessClient(Executor executor, WebViewRenderProcessClient webViewRenderProcessClient);

    void setXWebKeyEventHandler(XWebKeyEventHandler xWebKeyEventHandler);

    void smoothScroll(int i3, int i16, long j3);

    void stopLoading();

    boolean supportFeature(int i3);

    boolean supportSetWebContentsSize();

    void zoomBy(float f16);

    boolean zoomIn();

    boolean zoomOut();
}
