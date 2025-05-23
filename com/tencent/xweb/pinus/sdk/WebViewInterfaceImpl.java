package com.tencent.xweb.pinus.sdk;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Message;
import android.print.PrintDocumentAdapter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeProvider;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.luggage.wxa.ar.g0;
import com.tencent.qqmini.miniapp.util.DebugUtils;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.xweb.XWEB_BUILDFLAG;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WebViewInterfaceImpl implements WebViewInterface {
    private static final String TAG = "WebViewInterfaceImpl";
    private g0 addDocumentStartJavaScriptStringStringMethod;
    private g0 addJavascriptInterfaceObjectStringMethod;
    private g0 canGoBackMethod;
    private g0 canGoBackOrForwardintMethod;
    private g0 canGoForwardMethod;
    private g0 clearCachebooleanMethod;
    private g0 clearFormDataMethod;
    private g0 clearHistoryInRangeMethod;
    private g0 clearHistoryMethod;
    private g0 clearMatchesMethod;
    private g0 clearSslPreferencesMethod;
    private g0 clearViewMethod;
    private g0 copyBackForwardListMethod;
    private g0 createPrintDocumentAdapterStringMethod;
    private g0 destroyMethod;
    private g0 dispatchKeyEventKeyEventMethod;
    private g0 documentHasImagesMessageMethod;
    private g0 evaluateJavascriptStringValueCallbackStringMethod;
    private g0 findAllAsyncStringMethod;
    private g0 findNextbooleanMethod;
    private g0 flingScrollintintMethod;
    private g0 getAccessibilityNodeProviderMethod;
    private g0 getCertificateMethod;
    private g0 getContentHeightMethod;
    private g0 getContentViewMethod;
    private g0 getFaviconMethod;
    private g0 getHitTestResultInnerMethod;

    @XWEB_BUILDFLAG.XWEB_IMAGE_TO_FILE
    private g0 getImageBitmapToFileStringStringStringObjectMethod;
    private g0 getOriginalUrlMethod;
    private g0 getProgressMethod;
    private g0 getScaleMethod;
    private g0 getSettingsInnerMethod;
    private g0 getTitleMethod;

    @XWEB_BUILDFLAG.XWEB_TRANSLATE
    private g0 getTranslateSampleStringintMethod;
    private g0 getUrlMethod;
    private g0 goBackMethod;
    private g0 goBackOrForwardintMethod;
    private g0 goForwardMethod;
    private final Object inner;
    private g0 invokeZoomPickerMethod;
    private g0 isPrivateBrowsingEnabledMethod;
    private g0 loadDataStringStringStringMethod;
    private g0 loadDataWithBaseURLStringStringStringStringStringMethod;
    private g0 loadUrlStringMapStringStringMethod;
    private g0 loadUrlStringMethod;
    private g0 onCheckIsTextEditorMethod;

    @XWEB_BUILDFLAG.XWEB_INPUT
    private g0 onExtendInputKeyboardHeightChangedbooleanintbooleanMethod;

    @XWEB_BUILDFLAG.XWEB_TEXT_AREA
    private g0 onExtendTextAreaKeyboardHeightChangedbooleanintbooleanMethod;

    @XWEB_BUILDFLAG.XWEB_COMMON
    private g0 onHideMethod;
    private g0 onPauseMethod;
    private g0 onResumeMethod;

    @XWEB_BUILDFLAG.XWEB_COMMON
    private g0 onShowMethod;
    private g0 onTouchEventMotionEventMethod;
    private g0 pageDownbooleanMethod;
    private g0 pageUpbooleanMethod;
    private g0 pauseTimersMethod;
    private g0 postUrlStringbyteMethod;
    private g0 reloadMethod;
    private g0 removeDocumentStartJavaScriptintMethod;
    private g0 removeJavascriptInterfaceStringMethod;

    @XWEB_BUILDFLAG.XWEB_TRANSLATE
    private g0 replaceTranslatedStringMapStringStringMethod;
    private g0 requestFocusNodeHrefMessageMethod;
    private g0 requestImageRefMessageMethod;
    private g0 restoreStateBundleMethod;
    private g0 resumeTimersMethod;

    @XWEB_BUILDFLAG.XWEB_COMMON
    private g0 savePageStringStringintMethod;
    private g0 saveStateBundleMethod;
    private g0 saveWebArchiveStringMethod;
    private g0 saveWebArchiveStringbooleanValueCallbackStringMethod;

    @XWEB_BUILDFLAG.XWEB_AUDIO_MUTED
    private g0 setAudioMutedbooleanMethod;
    private g0 setBackgroundColorintMethod;

    @XWEB_BUILDFLAG.XWEB_COMMON
    private g0 setBottomHeightintMethod;
    private g0 setDownloadListenerDownloadListenerMethod;

    @XWEB_BUILDFLAG.XWEB_INPUT
    private g0 setExtendInputClientObjectMethod;

    @XWEB_BUILDFLAG.XWEB_SAME_LAYER
    private g0 setExtendPluginClientObjectMethod;

    @XWEB_BUILDFLAG.XWEB_TEXT_AREA
    private g0 setExtendTextAreaClientObjectMethod;
    private g0 setFindListenerandroidwebkitWebViewFindListenerMethod;

    @XWEB_BUILDFLAG.XWEB_SCROLLBAR
    private g0 setHorizontalScrollBarEnablebooleanMethod;
    private g0 setInitialScaleintMethod;
    private g0 setNetworkAvailablebooleanMethod;
    private g0 setOnTouchListenerOnTouchListenerMethod;

    @XWEB_BUILDFLAG.XWEB_SAME_LAYER
    private g0 setPluginTextureScaleStringintfloatfloatMethod;

    @XWEB_BUILDFLAG.XWEB_COMMON
    private g0 setProxyWebViewClientExtensionObjectMethod;

    @XWEB_BUILDFLAG.XWEB_TRANSLATE
    private g0 setTranslateModebooleanMethod;

    @XWEB_BUILDFLAG.XWEB_SCROLLBAR
    private g0 setVerticalScrollBarEnablebooleanMethod;
    private g0 setWebChromeClientObjectMethod;
    private g0 setWebContentsDebuggingEnabledbooleanMethod;

    @XWEB_BUILDFLAG.XWEB_SET_WEB_CONTENTS_SIZE
    private g0 setWebContentsSizeintintMethod;
    private g0 setWebViewClientObjectMethod;
    private g0 smoothScrollintintlongMethod;
    private g0 stopLoadingMethod;

    @XWEB_BUILDFLAG.XWEB_SAME_LAYER
    private g0 takePluginScreenshotStringintMethod;
    private g0 view_computeHorizontalScrollOffsetMethod;
    private g0 view_computeHorizontalScrollRangeMethod;
    private g0 view_computeVerticalScrollExtentMethod;
    private g0 view_computeVerticalScrollOffsetMethod;
    private g0 view_computeVerticalScrollRangeMethod;
    private g0 view_scrollByintintMethod;
    private g0 view_scrollTointintMethod;
    private g0 zoomByfloatMethod;
    private g0 zoomInMethod;
    private g0 zoomOutMethod;

    public WebViewInterfaceImpl(Object obj) {
        this.inner = obj;
    }

    private synchronized g0 getAddDocumentStartJavaScriptStringStringMethod() {
        g0 g0Var;
        g0Var = this.addDocumentStartJavaScriptStringStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "addDocumentStartJavaScript", String.class, String[].class);
            this.addDocumentStartJavaScriptStringStringMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getAddJavascriptInterfaceObjectStringMethod() {
        g0 g0Var;
        g0Var = this.addJavascriptInterfaceObjectStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "addJavascriptInterface", Object.class, String.class);
            this.addJavascriptInterfaceObjectStringMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getCanGoBackMethod() {
        g0 g0Var;
        g0Var = this.canGoBackMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, DKWebViewController.DKHippyWebviewFunction.CAN_GO_BACK, new Class[0]);
            this.canGoBackMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getCanGoBackOrForwardintMethod() {
        g0 g0Var;
        g0Var = this.canGoBackOrForwardintMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "canGoBackOrForward", Integer.TYPE);
            this.canGoBackOrForwardintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getCanGoForwardMethod() {
        g0 g0Var;
        g0Var = this.canGoForwardMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, DKWebViewController.DKHippyWebviewFunction.CAN_GO_FORWARD, new Class[0]);
            this.canGoForwardMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getClearCachebooleanMethod() {
        g0 g0Var;
        g0Var = this.clearCachebooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, HippyReporter.RemoveEngineReason.CLEAR_CACHE, Boolean.TYPE);
            this.clearCachebooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getClearFormDataMethod() {
        g0 g0Var;
        g0Var = this.clearFormDataMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "clearFormData", new Class[0]);
            this.clearFormDataMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getClearHistoryInRangeMethod() {
        g0 g0Var;
        g0Var = this.clearHistoryInRangeMethod;
        if (g0Var == null) {
            Object obj = this.inner;
            Class cls = Integer.TYPE;
            g0Var = new g0(obj, "clearHistory", cls, cls);
            this.clearHistoryInRangeMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getClearHistoryMethod() {
        g0 g0Var;
        g0Var = this.clearHistoryMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "clearHistory", new Class[0]);
            this.clearHistoryMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getClearMatchesMethod() {
        g0 g0Var;
        g0Var = this.clearMatchesMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "clearMatches", new Class[0]);
            this.clearMatchesMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getClearSslPreferencesMethod() {
        g0 g0Var;
        g0Var = this.clearSslPreferencesMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "clearSslPreferences", new Class[0]);
            this.clearSslPreferencesMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getClearViewMethod() {
        g0 g0Var;
        g0Var = this.clearViewMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "clearView", new Class[0]);
            this.clearViewMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getCopyBackForwardListMethod() {
        g0 g0Var;
        g0Var = this.copyBackForwardListMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "copyBackForwardList", new Class[0]);
            this.copyBackForwardListMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getCreatePrintDocumentAdapterStringMethod() {
        g0 g0Var;
        g0Var = this.createPrintDocumentAdapterStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "createPrintDocumentAdapter", String.class);
            this.createPrintDocumentAdapterStringMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getDestroyMethod() {
        g0 g0Var;
        g0Var = this.destroyMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "destroy", new Class[0]);
            this.destroyMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getDispatchKeyEventKeyEventMethod() {
        g0 g0Var;
        g0Var = this.dispatchKeyEventKeyEventMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "dispatchKeyEvent", KeyEvent.class);
            this.dispatchKeyEventKeyEventMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getDocumentHasImagesMessageMethod() {
        g0 g0Var;
        g0Var = this.documentHasImagesMessageMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "documentHasImages", Message.class);
            this.documentHasImagesMessageMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getEvaluateJavascriptStringValueCallbackStringMethod() {
        g0 g0Var;
        g0Var = this.evaluateJavascriptStringValueCallbackStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, DebugUtils.Command.EVALUATE_JAVASCRIPT, String.class, ValueCallback.class);
            this.evaluateJavascriptStringValueCallbackStringMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getFindAllAsyncStringMethod() {
        g0 g0Var;
        g0Var = this.findAllAsyncStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "findAllAsync", String.class);
            this.findAllAsyncStringMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getFindNextbooleanMethod() {
        g0 g0Var;
        g0Var = this.findNextbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "findNext", Boolean.TYPE);
            this.findNextbooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getFlingScrollintintMethod() {
        g0 g0Var;
        g0Var = this.flingScrollintintMethod;
        if (g0Var == null) {
            Object obj = this.inner;
            Class cls = Integer.TYPE;
            g0Var = new g0(obj, "flingScroll", cls, cls);
            this.flingScrollintintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetAccessibilityNodeProviderMethod() {
        g0 g0Var;
        g0Var = this.getAccessibilityNodeProviderMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getAccessibilityNodeProvider", new Class[0]);
            this.getAccessibilityNodeProviderMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetCertificateMethod() {
        g0 g0Var;
        g0Var = this.getCertificateMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getCertificate", new Class[0]);
            this.getCertificateMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetContentHeightMethod() {
        g0 g0Var;
        g0Var = this.getContentHeightMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getContentHeight", new Class[0]);
            this.getContentHeightMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetContentViewMethod() {
        g0 g0Var;
        g0Var = this.getContentViewMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getContentView", new Class[0]);
            this.getContentViewMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetFaviconMethod() {
        g0 g0Var;
        g0Var = this.getFaviconMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getFavicon", new Class[0]);
            this.getFaviconMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetHitTestResultInnerMethod() {
        g0 g0Var;
        g0Var = this.getHitTestResultInnerMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getHitTestResultInner", new Class[0]);
            this.getHitTestResultInnerMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_IMAGE_TO_FILE
    private synchronized g0 getGetImageBitmapToFileStringStringStringObjectMethod() {
        g0 g0Var;
        g0Var = this.getImageBitmapToFileStringStringStringObjectMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getImageBitmapToFile", String.class, String.class, String.class, Object.class);
            this.getImageBitmapToFileStringStringStringObjectMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetOriginalUrlMethod() {
        g0 g0Var;
        g0Var = this.getOriginalUrlMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getOriginalUrl", new Class[0]);
            this.getOriginalUrlMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetProgressMethod() {
        g0 g0Var;
        g0Var = this.getProgressMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, HippyQQPagView.FunctionName.GET_PROGRESS, new Class[0]);
            this.getProgressMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetScaleMethod() {
        g0 g0Var;
        g0Var = this.getScaleMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getScale", new Class[0]);
            this.getScaleMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetSettingsInnerMethod() {
        g0 g0Var;
        g0Var = this.getSettingsInnerMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getSettingsInner", new Class[0]);
            this.getSettingsInnerMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetTitleMethod() {
        g0 g0Var;
        g0Var = this.getTitleMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getTitle", new Class[0]);
            this.getTitleMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_TRANSLATE
    private synchronized g0 getGetTranslateSampleStringintMethod() {
        g0 g0Var;
        g0Var = this.getTranslateSampleStringintMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getTranslateSampleString", Integer.TYPE);
            this.getTranslateSampleStringintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGetUrlMethod() {
        g0 g0Var;
        g0Var = this.getUrlMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "getUrl", new Class[0]);
            this.getUrlMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGoBackMethod() {
        g0 g0Var;
        g0Var = this.goBackMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, DKWebViewController.DKHippyWebviewFunction.GO_BAC, new Class[0]);
            this.goBackMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGoBackOrForwardintMethod() {
        g0 g0Var;
        g0Var = this.goBackOrForwardintMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "goBackOrForward", Integer.TYPE);
            this.goBackOrForwardintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getGoForwardMethod() {
        g0 g0Var;
        g0Var = this.goForwardMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, DKWebViewController.DKHippyWebviewFunction.GO_FORWARD, new Class[0]);
            this.goForwardMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getInvokeZoomPickerMethod() {
        g0 g0Var;
        g0Var = this.invokeZoomPickerMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "invokeZoomPicker", new Class[0]);
            this.invokeZoomPickerMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getIsPrivateBrowsingEnabledMethod() {
        g0 g0Var;
        g0Var = this.isPrivateBrowsingEnabledMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "isPrivateBrowsingEnabled", new Class[0]);
            this.isPrivateBrowsingEnabledMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getLoadDataStringStringStringMethod() {
        g0 g0Var;
        g0Var = this.loadDataStringStringStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "loadData", String.class, String.class, String.class);
            this.loadDataStringStringStringMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getLoadDataWithBaseURLStringStringStringStringStringMethod() {
        g0 g0Var;
        g0Var = this.loadDataWithBaseURLStringStringStringStringStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "loadDataWithBaseURL", String.class, String.class, String.class, String.class, String.class);
            this.loadDataWithBaseURLStringStringStringStringStringMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getLoadUrlStringMapStringStringMethod() {
        g0 g0Var;
        g0Var = this.loadUrlStringMapStringStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, DKWebViewController.DKHippyWebviewFunction.LOAD_URL, String.class, Map.class);
            this.loadUrlStringMapStringStringMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getLoadUrlStringMethod() {
        g0 g0Var;
        g0Var = this.loadUrlStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, DKWebViewController.DKHippyWebviewFunction.LOAD_URL, String.class);
            this.loadUrlStringMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getOnCheckIsTextEditorMethod() {
        g0 g0Var;
        g0Var = this.onCheckIsTextEditorMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "onCheckIsTextEditor", new Class[0]);
            this.onCheckIsTextEditorMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_INPUT
    private synchronized g0 getOnExtendInputKeyboardHeightChangedbooleanintbooleanMethod() {
        g0 g0Var;
        g0Var = this.onExtendInputKeyboardHeightChangedbooleanintbooleanMethod;
        if (g0Var == null) {
            Object obj = this.inner;
            Class cls = Boolean.TYPE;
            g0Var = new g0(obj, "onExtendInputKeyboardHeightChanged", cls, Integer.TYPE, cls);
            this.onExtendInputKeyboardHeightChangedbooleanintbooleanMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_TEXT_AREA
    private synchronized g0 getOnExtendTextAreaKeyboardHeightChangedbooleanintbooleanMethod() {
        g0 g0Var;
        g0Var = this.onExtendTextAreaKeyboardHeightChangedbooleanintbooleanMethod;
        if (g0Var == null) {
            Object obj = this.inner;
            Class cls = Boolean.TYPE;
            g0Var = new g0(obj, "onExtendTextAreaKeyboardHeightChanged", cls, Integer.TYPE, cls);
            this.onExtendTextAreaKeyboardHeightChangedbooleanintbooleanMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_COMMON
    private synchronized g0 getOnHideMethod() {
        g0 g0Var;
        g0Var = this.onHideMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "onHide", new Class[0]);
            this.onHideMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getOnPauseMethod() {
        g0 g0Var;
        g0Var = this.onPauseMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, new Class[0]);
            this.onPauseMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getOnResumeMethod() {
        g0 g0Var;
        g0Var = this.onResumeMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "onResume", new Class[0]);
            this.onResumeMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_COMMON
    private synchronized g0 getOnShowMethod() {
        g0 g0Var;
        g0Var = this.onShowMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "onShow", new Class[0]);
            this.onShowMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getOnTouchEventMotionEventMethod() {
        g0 g0Var;
        g0Var = this.onTouchEventMotionEventMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "onTouchEvent", MotionEvent.class);
            this.onTouchEventMotionEventMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getPageDownbooleanMethod() {
        g0 g0Var;
        g0Var = this.pageDownbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "pageDown", Boolean.TYPE);
            this.pageDownbooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getPageUpbooleanMethod() {
        g0 g0Var;
        g0Var = this.pageUpbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "pageUp", Boolean.TYPE);
            this.pageUpbooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getPauseTimersMethod() {
        g0 g0Var;
        g0Var = this.pauseTimersMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "pauseTimers", new Class[0]);
            this.pauseTimersMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getPostUrlStringbyteMethod() {
        g0 g0Var;
        g0Var = this.postUrlStringbyteMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "postUrl", String.class, byte[].class);
            this.postUrlStringbyteMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getReloadMethod() {
        g0 g0Var;
        g0Var = this.reloadMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, DKWebViewController.DKHippyWebviewFunction.RELOAD, new Class[0]);
            this.reloadMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getRemoveDocumentStartJavaScriptintMethod() {
        g0 g0Var;
        g0Var = this.removeDocumentStartJavaScriptintMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "removeDocumentStartJavaScript", Integer.TYPE);
            this.removeDocumentStartJavaScriptintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getRemoveJavascriptInterfaceStringMethod() {
        g0 g0Var;
        g0Var = this.removeJavascriptInterfaceStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "removeJavascriptInterface", String.class);
            this.removeJavascriptInterfaceStringMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_TRANSLATE
    private synchronized g0 getReplaceTranslatedStringMapStringStringMethod() {
        g0 g0Var;
        g0Var = this.replaceTranslatedStringMapStringStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "replaceTranslatedString", Map.class);
            this.replaceTranslatedStringMapStringStringMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getRequestFocusNodeHrefMessageMethod() {
        g0 g0Var;
        g0Var = this.requestFocusNodeHrefMessageMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "requestFocusNodeHref", Message.class);
            this.requestFocusNodeHrefMessageMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getRequestImageRefMessageMethod() {
        g0 g0Var;
        g0Var = this.requestImageRefMessageMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "requestImageRef", Message.class);
            this.requestImageRefMessageMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getRestoreStateBundleMethod() {
        g0 g0Var;
        g0Var = this.restoreStateBundleMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "restoreState", Bundle.class);
            this.restoreStateBundleMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getResumeTimersMethod() {
        g0 g0Var;
        g0Var = this.resumeTimersMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "resumeTimers", new Class[0]);
            this.resumeTimersMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_COMMON
    private synchronized g0 getSavePageStringStringintMethod() {
        g0 g0Var;
        g0Var = this.savePageStringStringintMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "savePage", String.class, String.class, Integer.TYPE);
            this.savePageStringStringintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSaveStateBundleMethod() {
        g0 g0Var;
        g0Var = this.saveStateBundleMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "saveState", Bundle.class);
            this.saveStateBundleMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSaveWebArchiveStringMethod() {
        g0 g0Var;
        g0Var = this.saveWebArchiveStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "saveWebArchive", String.class);
            this.saveWebArchiveStringMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSaveWebArchiveStringbooleanValueCallbackStringMethod() {
        g0 g0Var;
        g0Var = this.saveWebArchiveStringbooleanValueCallbackStringMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "saveWebArchive", String.class, Boolean.TYPE, ValueCallback.class);
            this.saveWebArchiveStringbooleanValueCallbackStringMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_AUDIO_MUTED
    private synchronized g0 getSetAudioMutedbooleanMethod() {
        g0 g0Var;
        g0Var = this.setAudioMutedbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setAudioMuted", Boolean.TYPE);
            this.setAudioMutedbooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetBackgroundColorintMethod() {
        g0 g0Var;
        g0Var = this.setBackgroundColorintMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setBackgroundColor", Integer.TYPE);
            this.setBackgroundColorintMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_COMMON
    private synchronized g0 getSetBottomHeightintMethod() {
        g0 g0Var;
        g0Var = this.setBottomHeightintMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setBottomHeight", Integer.TYPE);
            this.setBottomHeightintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetDownloadListenerDownloadListenerMethod() {
        g0 g0Var;
        g0Var = this.setDownloadListenerDownloadListenerMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setDownloadListener", DownloadListener.class);
            this.setDownloadListenerDownloadListenerMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_INPUT
    private synchronized g0 getSetExtendInputClientObjectMethod() {
        g0 g0Var;
        g0Var = this.setExtendInputClientObjectMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setExtendInputClient", Object.class);
            this.setExtendInputClientObjectMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_SAME_LAYER
    private synchronized g0 getSetExtendPluginClientObjectMethod() {
        g0 g0Var;
        g0Var = this.setExtendPluginClientObjectMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setExtendPluginClient", Object.class);
            this.setExtendPluginClientObjectMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_TEXT_AREA
    private synchronized g0 getSetExtendTextAreaClientObjectMethod() {
        g0 g0Var;
        g0Var = this.setExtendTextAreaClientObjectMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setExtendTextAreaClient", Object.class);
            this.setExtendTextAreaClientObjectMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetFindListenerandroidwebkitWebViewFindListenerMethod() {
        g0 g0Var;
        g0Var = this.setFindListenerandroidwebkitWebViewFindListenerMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setFindListener", WebView.FindListener.class);
            this.setFindListenerandroidwebkitWebViewFindListenerMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_SCROLLBAR
    private synchronized g0 getSetHorizontalScrollBarEnablebooleanMethod() {
        g0 g0Var;
        g0Var = this.setHorizontalScrollBarEnablebooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setHorizontalScrollBarEnable", Boolean.TYPE);
            this.setHorizontalScrollBarEnablebooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetInitialScaleintMethod() {
        g0 g0Var;
        g0Var = this.setInitialScaleintMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setInitialScale", Integer.TYPE);
            this.setInitialScaleintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetNetworkAvailablebooleanMethod() {
        g0 g0Var;
        g0Var = this.setNetworkAvailablebooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setNetworkAvailable", Boolean.TYPE);
            this.setNetworkAvailablebooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetOnTouchListenerOnTouchListenerMethod() {
        g0 g0Var;
        g0Var = this.setOnTouchListenerOnTouchListenerMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setOnTouchListener", View.OnTouchListener.class);
            this.setOnTouchListenerOnTouchListenerMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_SAME_LAYER
    private synchronized g0 getSetPluginTextureScaleStringintfloatfloatMethod() {
        g0 g0Var;
        g0Var = this.setPluginTextureScaleStringintfloatfloatMethod;
        if (g0Var == null) {
            Object obj = this.inner;
            Class cls = Float.TYPE;
            g0Var = new g0(obj, "setPluginTextureScale", String.class, Integer.TYPE, cls, cls);
            this.setPluginTextureScaleStringintfloatfloatMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_COMMON
    private synchronized g0 getSetProxyWebViewClientExtensionObjectMethod() {
        g0 g0Var;
        g0Var = this.setProxyWebViewClientExtensionObjectMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setProxyWebViewClientExtension", Object.class);
            this.setProxyWebViewClientExtensionObjectMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_TRANSLATE
    private synchronized g0 getSetTranslateModebooleanMethod() {
        g0 g0Var;
        g0Var = this.setTranslateModebooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setTranslateMode", Boolean.TYPE);
            this.setTranslateModebooleanMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_SCROLLBAR
    private synchronized g0 getSetVerticalScrollBarEnablebooleanMethod() {
        g0 g0Var;
        g0Var = this.setVerticalScrollBarEnablebooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setVerticalScrollBarEnable", Boolean.TYPE);
            this.setVerticalScrollBarEnablebooleanMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetWebChromeClientObjectMethod() {
        g0 g0Var;
        g0Var = this.setWebChromeClientObjectMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setWebChromeClient", Object.class);
            this.setWebChromeClientObjectMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetWebContentsDebuggingEnabledbooleanMethod() {
        g0 g0Var;
        g0Var = this.setWebContentsDebuggingEnabledbooleanMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setWebContentsDebuggingEnabled", Boolean.TYPE);
            this.setWebContentsDebuggingEnabledbooleanMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_SET_WEB_CONTENTS_SIZE
    private synchronized g0 getSetWebContentsSizeintintMethod() {
        g0 g0Var;
        g0Var = this.setWebContentsSizeintintMethod;
        if (g0Var == null) {
            Object obj = this.inner;
            Class cls = Integer.TYPE;
            g0Var = new g0(obj, "setWebContentsSize", cls, cls);
            this.setWebContentsSizeintintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSetWebViewClientObjectMethod() {
        g0 g0Var;
        g0Var = this.setWebViewClientObjectMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "setWebViewClient", Object.class);
            this.setWebViewClientObjectMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getSmoothScrollintintlongMethod() {
        g0 g0Var;
        g0Var = this.smoothScrollintintlongMethod;
        if (g0Var == null) {
            Object obj = this.inner;
            Class cls = Integer.TYPE;
            g0Var = new g0(obj, "smoothScroll", cls, cls, Long.TYPE);
            this.smoothScrollintintlongMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getStopLoadingMethod() {
        g0 g0Var;
        g0Var = this.stopLoadingMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, DKWebViewController.DKHippyWebviewFunction.STOP_LOADING, new Class[0]);
            this.stopLoadingMethod = g0Var;
        }
        return g0Var;
    }

    @XWEB_BUILDFLAG.XWEB_SAME_LAYER
    private synchronized g0 getTakePluginScreenshotStringintMethod() {
        g0 g0Var;
        g0Var = this.takePluginScreenshotStringintMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "takePluginScreenshot", String.class, Integer.TYPE);
            this.takePluginScreenshotStringintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getView_computeHorizontalScrollOffsetMethod() {
        g0 g0Var;
        g0Var = this.view_computeHorizontalScrollOffsetMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "view_computeHorizontalScrollOffset", new Class[0]);
            this.view_computeHorizontalScrollOffsetMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getView_computeHorizontalScrollRangeMethod() {
        g0 g0Var;
        g0Var = this.view_computeHorizontalScrollRangeMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "view_computeHorizontalScrollRange", new Class[0]);
            this.view_computeHorizontalScrollRangeMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getView_computeVerticalScrollExtentMethod() {
        g0 g0Var;
        g0Var = this.view_computeVerticalScrollExtentMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "view_computeVerticalScrollExtent", new Class[0]);
            this.view_computeVerticalScrollExtentMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getView_computeVerticalScrollOffsetMethod() {
        g0 g0Var;
        g0Var = this.view_computeVerticalScrollOffsetMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "view_computeVerticalScrollOffset", new Class[0]);
            this.view_computeVerticalScrollOffsetMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getView_computeVerticalScrollRangeMethod() {
        g0 g0Var;
        g0Var = this.view_computeVerticalScrollRangeMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "view_computeVerticalScrollRange", new Class[0]);
            this.view_computeVerticalScrollRangeMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getView_scrollByintintMethod() {
        g0 g0Var;
        g0Var = this.view_scrollByintintMethod;
        if (g0Var == null) {
            Object obj = this.inner;
            Class cls = Integer.TYPE;
            g0Var = new g0(obj, "view_scrollBy", cls, cls);
            this.view_scrollByintintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getView_scrollTointintMethod() {
        g0 g0Var;
        g0Var = this.view_scrollTointintMethod;
        if (g0Var == null) {
            Object obj = this.inner;
            Class cls = Integer.TYPE;
            g0Var = new g0(obj, "view_scrollTo", cls, cls);
            this.view_scrollTointintMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getZoomByfloatMethod() {
        g0 g0Var;
        g0Var = this.zoomByfloatMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "zoomBy", Float.TYPE);
            this.zoomByfloatMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getZoomInMethod() {
        g0 g0Var;
        g0Var = this.zoomInMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "zoomIn", new Class[0]);
            this.zoomInMethod = g0Var;
        }
        return g0Var;
    }

    private synchronized g0 getZoomOutMethod() {
        g0 g0Var;
        g0Var = this.zoomOutMethod;
        if (g0Var == null) {
            g0Var = new g0(this.inner, "zoomOut", new Class[0]);
            this.zoomOutMethod = g0Var;
        }
        return g0Var;
    }

    @SuppressLint({"LongLogTag"})
    public static void handleRuntimeError(Exception exc) {
        Log.e(TAG, "This API is incompatible with the xweb pinus library");
        exc.printStackTrace();
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public int addDocumentStartJavaScript(String str, String[] strArr) {
        try {
            return ((Integer) getAddDocumentStartJavaScriptStringStringMethod().a(str, strArr)).intValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void addJavascriptInterface(Object obj, String str) {
        try {
            getAddJavascriptInterfaceObjectStringMethod().a(obj, str);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean canGoBack() {
        try {
            return ((Boolean) getCanGoBackMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean canGoBackOrForward(int i3) {
        try {
            return ((Boolean) getCanGoBackOrForwardintMethod().a(Integer.valueOf(i3))).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean canGoForward() {
        try {
            return ((Boolean) getCanGoForwardMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void clearCache(boolean z16) {
        try {
            getClearCachebooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void clearFormData() {
        try {
            getClearFormDataMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void clearHistory() {
        try {
            getClearHistoryMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void clearMatches() {
        try {
            getClearMatchesMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void clearSslPreferences() {
        try {
            getClearSslPreferencesMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void clearView() {
        try {
            getClearViewMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public WebBackForwardList copyBackForwardList() {
        try {
            return (WebBackForwardList) getCopyBackForwardListMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public PrintDocumentAdapter createPrintDocumentAdapter(String str) {
        try {
            return (PrintDocumentAdapter) getCreatePrintDocumentAdapterStringMethod().a(str);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void destroy() {
        try {
            getDestroyMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        try {
            return ((Boolean) getDispatchKeyEventKeyEventMethod().a(keyEvent)).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void documentHasImages(Message message) {
        try {
            getDocumentHasImagesMessageMethod().a(message);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        try {
            getEvaluateJavascriptStringValueCallbackStringMethod().a(str, valueCallback);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void findAllAsync(String str) {
        try {
            getFindAllAsyncStringMethod().a(str);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void findNext(boolean z16) {
        try {
            getFindNextbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void flingScroll(int i3, int i16) {
        try {
            getFlingScrollintintMethod().a(Integer.valueOf(i3), Integer.valueOf(i16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        try {
            return (AccessibilityNodeProvider) getGetAccessibilityNodeProviderMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public SslCertificate getCertificate() {
        try {
            return (SslCertificate) getGetCertificateMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public int getContentHeight() {
        try {
            return ((Integer) getGetContentHeightMethod().a(new Object[0])).intValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public ViewGroup getContentView() {
        try {
            return (ViewGroup) getGetContentViewMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public Bitmap getFavicon() {
        try {
            return (Bitmap) getGetFaviconMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public Object getHitTestResultInner() {
        try {
            return getGetHitTestResultInnerMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    @XWEB_BUILDFLAG.XWEB_IMAGE_TO_FILE
    public boolean getImageBitmapToFile(String str, String str2, String str3, Object obj) {
        try {
            return ((Boolean) getGetImageBitmapToFileStringStringStringObjectMethod().a(str, str2, str3, obj)).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public String getOriginalUrl() {
        try {
            return (String) getGetOriginalUrlMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public int getProgress() {
        try {
            return ((Integer) getGetProgressMethod().a(new Object[0])).intValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public float getScale() {
        try {
            return ((Float) getGetScaleMethod().a(new Object[0])).floatValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0.0f;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public Object getSettingsInner() {
        try {
            return getGetSettingsInnerMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public String getTitle() {
        try {
            return (String) getGetTitleMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    @XWEB_BUILDFLAG.XWEB_TRANSLATE
    public void getTranslateSampleString(int i3) {
        try {
            getGetTranslateSampleStringintMethod().a(Integer.valueOf(i3));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public String getUrl() {
        try {
            return (String) getGetUrlMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void goBack() {
        try {
            getGoBackMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void goBackOrForward(int i3) {
        try {
            getGoBackOrForwardintMethod().a(Integer.valueOf(i3));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void goForward() {
        try {
            getGoForwardMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void invokeZoomPicker() {
        try {
            getInvokeZoomPickerMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean isPrivateBrowsingEnabled() {
        try {
            return ((Boolean) getIsPrivateBrowsingEnabledMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void loadData(String str, String str2, String str3) {
        try {
            getLoadDataStringStringStringMethod().a(str, str2, str3);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        try {
            getLoadDataWithBaseURLStringStringStringStringStringMethod().a(str, str2, str3, str4, str5);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void loadUrl(String str) {
        try {
            getLoadUrlStringMethod().a(str);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean onCheckIsTextEditor() {
        try {
            return ((Boolean) getOnCheckIsTextEditorMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    @XWEB_BUILDFLAG.XWEB_INPUT
    public void onExtendInputKeyboardHeightChanged(boolean z16, int i3, boolean z17) {
        try {
            getOnExtendInputKeyboardHeightChangedbooleanintbooleanMethod().a(Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    @XWEB_BUILDFLAG.XWEB_TEXT_AREA
    public void onExtendTextAreaKeyboardHeightChanged(boolean z16, int i3, boolean z17) {
        try {
            getOnExtendTextAreaKeyboardHeightChangedbooleanintbooleanMethod().a(Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    @XWEB_BUILDFLAG.XWEB_COMMON
    public void onHide() {
        try {
            getOnHideMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void onPause() {
        try {
            getOnPauseMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void onResume() {
        try {
            getOnResumeMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    @XWEB_BUILDFLAG.XWEB_COMMON
    public void onShow() {
        try {
            getOnShowMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return ((Boolean) getOnTouchEventMotionEventMethod().a(motionEvent)).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean pageDown(boolean z16) {
        try {
            return ((Boolean) getPageDownbooleanMethod().a(Boolean.valueOf(z16))).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean pageUp(boolean z16) {
        try {
            return ((Boolean) getPageUpbooleanMethod().a(Boolean.valueOf(z16))).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void pauseTimers() {
        try {
            getPauseTimersMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void postUrl(String str, byte[] bArr) {
        try {
            getPostUrlStringbyteMethod().a(str, bArr);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void reload() {
        try {
            getReloadMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void removeDocumentStartJavaScript(int i3) {
        try {
            getRemoveDocumentStartJavaScriptintMethod().a(Integer.valueOf(i3));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void removeJavascriptInterface(String str) {
        try {
            getRemoveJavascriptInterfaceStringMethod().a(str);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    @XWEB_BUILDFLAG.XWEB_TRANSLATE
    public void replaceTranslatedString(Map<String, String> map) {
        try {
            getReplaceTranslatedStringMapStringStringMethod().a(map);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void requestFocusNodeHref(Message message) {
        try {
            getRequestFocusNodeHrefMessageMethod().a(message);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void requestImageRef(Message message) {
        try {
            getRequestImageRefMessageMethod().a(message);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public WebBackForwardList restoreState(Bundle bundle) {
        try {
            return (WebBackForwardList) getRestoreStateBundleMethod().a(bundle);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void resumeTimers() {
        try {
            getResumeTimersMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    @XWEB_BUILDFLAG.XWEB_COMMON
    public boolean savePage(String str, String str2, int i3) {
        try {
            return ((Boolean) getSavePageStringStringintMethod().a(str, str2, Integer.valueOf(i3))).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public WebBackForwardList saveState(Bundle bundle) {
        try {
            return (WebBackForwardList) getSaveStateBundleMethod().a(bundle);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return null;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void saveWebArchive(String str) {
        try {
            getSaveWebArchiveStringMethod().a(str);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    @XWEB_BUILDFLAG.XWEB_AUDIO_MUTED
    public void setAudioMuted(boolean z16) {
        try {
            getSetAudioMutedbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setBackgroundColor(int i3) {
        try {
            getSetBackgroundColorintMethod().a(Integer.valueOf(i3));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    @XWEB_BUILDFLAG.XWEB_COMMON
    public void setBottomHeight(int i3) {
        try {
            getSetBottomHeightintMethod().a(Integer.valueOf(i3));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setDownloadListener(DownloadListener downloadListener) {
        try {
            getSetDownloadListenerDownloadListenerMethod().a(downloadListener);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    @XWEB_BUILDFLAG.XWEB_INPUT
    public void setExtendInputClient(Object obj) {
        try {
            getSetExtendInputClientObjectMethod().a(obj);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    @XWEB_BUILDFLAG.XWEB_SAME_LAYER
    public void setExtendPluginClient(Object obj) {
        try {
            getSetExtendPluginClientObjectMethod().a(obj);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    @XWEB_BUILDFLAG.XWEB_TEXT_AREA
    public void setExtendTextAreaClient(Object obj) {
        try {
            getSetExtendTextAreaClientObjectMethod().a(obj);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setFindListener(WebView.FindListener findListener) {
        try {
            getSetFindListenerandroidwebkitWebViewFindListenerMethod().a(findListener);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    @XWEB_BUILDFLAG.XWEB_SCROLLBAR
    public void setHorizontalScrollBarEnable(boolean z16) {
        try {
            getSetHorizontalScrollBarEnablebooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setInitialScale(int i3) {
        try {
            getSetInitialScaleintMethod().a(Integer.valueOf(i3));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setNetworkAvailable(boolean z16) {
        try {
            getSetNetworkAvailablebooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        try {
            getSetOnTouchListenerOnTouchListenerMethod().a(onTouchListener);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    @XWEB_BUILDFLAG.XWEB_SAME_LAYER
    public void setPluginTextureScale(String str, int i3, float f16, float f17) {
        try {
            getSetPluginTextureScaleStringintfloatfloatMethod().a(str, Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    @XWEB_BUILDFLAG.XWEB_COMMON
    public void setProxyWebViewClientExtension(Object obj) {
        try {
            getSetProxyWebViewClientExtensionObjectMethod().a(obj);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    @XWEB_BUILDFLAG.XWEB_TRANSLATE
    public void setTranslateMode(boolean z16) {
        try {
            getSetTranslateModebooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    @XWEB_BUILDFLAG.XWEB_SCROLLBAR
    public void setVerticalScrollBarEnable(boolean z16) {
        try {
            getSetVerticalScrollBarEnablebooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setWebChromeClient(Object obj) {
        try {
            getSetWebChromeClientObjectMethod().a(obj);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setWebContentsDebuggingEnabled(boolean z16) {
        try {
            getSetWebContentsDebuggingEnabledbooleanMethod().a(Boolean.valueOf(z16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    @XWEB_BUILDFLAG.XWEB_SET_WEB_CONTENTS_SIZE
    public void setWebContentsSize(int i3, int i16) {
        try {
            getSetWebContentsSizeintintMethod().a(Integer.valueOf(i3), Integer.valueOf(i16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void setWebViewClient(Object obj) {
        try {
            getSetWebViewClientObjectMethod().a(obj);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void smoothScroll(int i3, int i16, long j3) {
        try {
            getSmoothScrollintintlongMethod().a(Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void stopLoading() {
        try {
            getStopLoadingMethod().a(new Object[0]);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    @XWEB_BUILDFLAG.XWEB_SAME_LAYER
    public void takePluginScreenshot(String str, int i3) {
        try {
            getTakePluginScreenshotStringintMethod().a(str, Integer.valueOf(i3));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public int view_computeHorizontalScrollOffset() {
        try {
            return ((Integer) getView_computeHorizontalScrollOffsetMethod().a(new Object[0])).intValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public int view_computeHorizontalScrollRange() {
        try {
            return ((Integer) getView_computeHorizontalScrollRangeMethod().a(new Object[0])).intValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public int view_computeVerticalScrollExtent() {
        try {
            return ((Integer) getView_computeVerticalScrollExtentMethod().a(new Object[0])).intValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public int view_computeVerticalScrollOffset() {
        try {
            return ((Integer) getView_computeVerticalScrollOffsetMethod().a(new Object[0])).intValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public int view_computeVerticalScrollRange() {
        try {
            return ((Integer) getView_computeVerticalScrollRangeMethod().a(new Object[0])).intValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return 0;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void view_scrollBy(int i3, int i16) {
        try {
            getView_scrollByintintMethod().a(Integer.valueOf(i3), Integer.valueOf(i16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void view_scrollTo(int i3, int i16) {
        try {
            getView_scrollTointintMethod().a(Integer.valueOf(i3), Integer.valueOf(i16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void zoomBy(float f16) {
        try {
            getZoomByfloatMethod().a(Float.valueOf(f16));
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean zoomIn() {
        try {
            return ((Boolean) getZoomInMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public boolean zoomOut() {
        try {
            return ((Boolean) getZoomOutMethod().a(new Object[0])).booleanValue();
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
            return false;
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void clearHistory(int i3, int i16) {
        g0 clearHistoryInRangeMethod = getClearHistoryInRangeMethod();
        if (clearHistoryInRangeMethod == null) {
            Log.i(TAG, "Current xweb core isn't supported.");
            return;
        }
        try {
            clearHistoryInRangeMethod.a(Integer.valueOf(i3), Integer.valueOf(i16));
        } catch (Exception e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void loadUrl(String str, Map<String, String> map) {
        try {
            getLoadUrlStringMapStringStringMethod().a(str, map);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }

    @Override // com.tencent.xweb.pinus.sdk.WebViewInterface
    public void saveWebArchive(String str, boolean z16, ValueCallback<String> valueCallback) {
        try {
            getSaveWebArchiveStringbooleanValueCallbackStringMethod().a(str, Boolean.valueOf(z16), valueCallback);
        } catch (UnsupportedOperationException e16) {
            handleRuntimeError(e16);
        }
    }
}
