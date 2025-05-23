package com.tencent.xweb.pinus.sdk;

import android.graphics.Bitmap;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Message;
import android.print.PrintDocumentAdapter;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeProvider;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import com.tencent.xweb.XWEB_BUILDFLAG;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface WebViewInterface {
    int addDocumentStartJavaScript(String str, String[] strArr);

    void addJavascriptInterface(Object obj, String str);

    boolean canGoBack();

    boolean canGoBackOrForward(int i3);

    boolean canGoForward();

    void clearCache(boolean z16);

    void clearFormData();

    void clearHistory();

    void clearHistory(int i3, int i16);

    void clearMatches();

    void clearSslPreferences();

    void clearView();

    WebBackForwardList copyBackForwardList();

    PrintDocumentAdapter createPrintDocumentAdapter(String str);

    void destroy();

    boolean dispatchKeyEvent(KeyEvent keyEvent);

    void documentHasImages(Message message);

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    void findAllAsync(String str);

    void findNext(boolean z16);

    void flingScroll(int i3, int i16);

    AccessibilityNodeProvider getAccessibilityNodeProvider();

    SslCertificate getCertificate();

    int getContentHeight();

    ViewGroup getContentView();

    Bitmap getFavicon();

    Object getHitTestResultInner();

    @XWEB_BUILDFLAG.XWEB_IMAGE_TO_FILE
    boolean getImageBitmapToFile(String str, String str2, String str3, Object obj);

    String getOriginalUrl();

    int getProgress();

    float getScale();

    Object getSettingsInner();

    String getTitle();

    @XWEB_BUILDFLAG.XWEB_TRANSLATE
    void getTranslateSampleString(int i3);

    String getUrl();

    void goBack();

    void goBackOrForward(int i3);

    void goForward();

    void invokeZoomPicker();

    boolean isPrivateBrowsingEnabled();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void loadUrl(String str, Map<String, String> map);

    boolean onCheckIsTextEditor();

    @XWEB_BUILDFLAG.XWEB_INPUT
    void onExtendInputKeyboardHeightChanged(boolean z16, int i3, boolean z17);

    @XWEB_BUILDFLAG.XWEB_TEXT_AREA
    void onExtendTextAreaKeyboardHeightChanged(boolean z16, int i3, boolean z17);

    @XWEB_BUILDFLAG.XWEB_COMMON
    void onHide();

    void onPause();

    void onResume();

    @XWEB_BUILDFLAG.XWEB_COMMON
    void onShow();

    boolean onTouchEvent(MotionEvent motionEvent);

    boolean pageDown(boolean z16);

    boolean pageUp(boolean z16);

    void pauseTimers();

    void postUrl(String str, byte[] bArr);

    void reload();

    void removeDocumentStartJavaScript(int i3);

    void removeJavascriptInterface(String str);

    @XWEB_BUILDFLAG.XWEB_TRANSLATE
    void replaceTranslatedString(Map<String, String> map);

    void requestFocusNodeHref(Message message);

    void requestImageRef(Message message);

    WebBackForwardList restoreState(Bundle bundle);

    void resumeTimers();

    @XWEB_BUILDFLAG.XWEB_COMMON
    boolean savePage(String str, String str2, int i3);

    WebBackForwardList saveState(Bundle bundle);

    void saveWebArchive(String str);

    void saveWebArchive(String str, boolean z16, ValueCallback<String> valueCallback);

    @XWEB_BUILDFLAG.XWEB_AUDIO_MUTED
    void setAudioMuted(boolean z16);

    void setBackgroundColor(int i3);

    @XWEB_BUILDFLAG.XWEB_COMMON
    void setBottomHeight(int i3);

    void setDownloadListener(DownloadListener downloadListener);

    @XWEB_BUILDFLAG.XWEB_INPUT
    void setExtendInputClient(Object obj);

    @XWEB_BUILDFLAG.XWEB_SAME_LAYER
    void setExtendPluginClient(Object obj);

    @XWEB_BUILDFLAG.XWEB_TEXT_AREA
    void setExtendTextAreaClient(Object obj);

    void setFindListener(WebView.FindListener findListener);

    @XWEB_BUILDFLAG.XWEB_SCROLLBAR
    void setHorizontalScrollBarEnable(boolean z16);

    void setInitialScale(int i3);

    void setNetworkAvailable(boolean z16);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    @XWEB_BUILDFLAG.XWEB_SAME_LAYER
    void setPluginTextureScale(String str, int i3, float f16, float f17);

    @XWEB_BUILDFLAG.XWEB_COMMON
    void setProxyWebViewClientExtension(Object obj);

    @XWEB_BUILDFLAG.XWEB_TRANSLATE
    void setTranslateMode(boolean z16);

    @XWEB_BUILDFLAG.XWEB_SCROLLBAR
    void setVerticalScrollBarEnable(boolean z16);

    void setWebChromeClient(Object obj);

    void setWebContentsDebuggingEnabled(boolean z16);

    @XWEB_BUILDFLAG.XWEB_SET_WEB_CONTENTS_SIZE
    void setWebContentsSize(int i3, int i16);

    void setWebViewClient(Object obj);

    void smoothScroll(int i3, int i16, long j3);

    void stopLoading();

    @XWEB_BUILDFLAG.XWEB_SAME_LAYER
    void takePluginScreenshot(String str, int i3);

    int view_computeHorizontalScrollOffset();

    int view_computeHorizontalScrollRange();

    int view_computeVerticalScrollExtent();

    int view_computeVerticalScrollOffset();

    int view_computeVerticalScrollRange();

    void view_scrollBy(int i3, int i16);

    void view_scrollTo(int i3, int i16);

    void zoomBy(float f16);

    boolean zoomIn();

    boolean zoomOut();
}
