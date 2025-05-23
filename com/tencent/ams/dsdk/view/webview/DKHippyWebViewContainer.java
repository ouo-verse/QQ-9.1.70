package com.tencent.ams.dsdk.view.webview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.core.DKHippyViewEvent;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.ams.dsdk.view.webview.DKWebView;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import java.lang.reflect.Constructor;
import java.net.URLDecoder;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKHippyWebViewContainer extends FrameLayout implements HippyViewBase, DKWebView.DKWebViewEventListener, DKWebView.OnScrollChangeListener, DKWebView.OnTouchDownListener {
    static IPatchRedirector $redirector_ = null;
    public static final String POST_MESSAGE_URL_PRE = "hippy://postMessage?data=";
    private static final String TAG = "DKHippyWebViewContainer";
    private DKWebView mDKHippyWebView;
    private final DKHippyViewEvent mEventOnError;
    private final DKHippyViewEvent mEventOnLoadEnd;
    private final DKHippyViewEvent mEventOnLoadStart;
    private final DKHippyViewEvent mEventOnMessage;
    private final DKHippyViewEvent mEventOnScrollChanged;
    private final DKHippyViewEvent mEventOnTouchDown;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class DKHippyWebViewJSBridge {
        static IPatchRedirector $redirector_;

        DKHippyWebViewJSBridge() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKHippyWebViewContainer.this);
        }

        @JavascriptInterface
        public void postMessage(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                DKHippyWebViewContainer.this.handlePostMessage(str);
            }
        }

        /* synthetic */ DKHippyWebViewJSBridge(DKHippyWebViewContainer dKHippyWebViewContainer, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dKHippyWebViewContainer, (Object) anonymousClass1);
        }
    }

    public DKHippyWebViewContainer(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mEventOnError = new DKHippyViewEvent("onError");
        this.mEventOnLoadEnd = new DKHippyViewEvent(HippyQQPagView.EventName.ON_LOAD_END);
        this.mEventOnLoadStart = new DKHippyViewEvent(HippyQQPagView.EventName.ON_LOAD_START);
        this.mEventOnMessage = new DKHippyViewEvent("onMessage");
        this.mEventOnScrollChanged = new DKHippyViewEvent("onScrollChange");
        this.mEventOnTouchDown = new DKHippyViewEvent("onWebViewTouchDown");
        init(context);
    }

    private void init(Context context) {
        Class<? extends DKWebView> dKWebView = DKConfiguration.getDKWebView();
        if (dKWebView != null) {
            try {
                DLog.i(TAG, "use outside WebView");
                Constructor<? extends DKWebView> constructor = dKWebView.getConstructor(Context.class);
                if (constructor != null) {
                    this.mDKHippyWebView = constructor.newInstance(context);
                }
            } catch (Throwable th5) {
                DLog.e(TAG, "reflect outside WebView error.", th5);
            }
        }
        if (this.mDKHippyWebView == null) {
            DLog.i(TAG, "use default WebView");
            this.mDKHippyWebView = new DKDefaultWebView(context);
        }
        this.mDKHippyWebView.registerWebViewEventListener(this);
        this.mDKHippyWebView.addJavascriptInterface(new DKHippyWebViewJSBridge(this, null), "hippy");
        this.mDKHippyWebView.registerOnScrollChangedListener(this);
        this.mDKHippyWebView.registerOnTouchDownListener(this);
        if (this.mDKHippyWebView instanceof View) {
            addView((View) this.mDKHippyWebView, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean canGoBack() {
        DKWebView dKWebView = this.mDKHippyWebView;
        if (dKWebView != null && dKWebView.canGoBack()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean canGoForward() {
        DKWebView dKWebView = this.mDKHippyWebView;
        if (dKWebView != null && dKWebView.canGoForward()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
        DLog.i(TAG, "destroy");
        DKWebView dKWebView = this.mDKHippyWebView;
        if (dKWebView != null) {
            dKWebView.unRegisterOnScrollChangedListener(this);
            this.mDKHippyWebView.unRegisterOnTouchDownListener(this);
            if (this.mDKHippyWebView instanceof View) {
                DynamicUtils.runOnUiThread(new Runnable() { // from class: com.tencent.ams.dsdk.view.webview.DKHippyWebViewContainer.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKHippyWebViewContainer.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        try {
                            DKHippyWebViewContainer dKHippyWebViewContainer = DKHippyWebViewContainer.this;
                            dKHippyWebViewContainer.removeView((View) dKHippyWebViewContainer.mDKHippyWebView);
                        } catch (Throwable th5) {
                            DLog.e(DKHippyWebViewContainer.TAG, "remove view error.", th5);
                        }
                    }
                });
            }
            this.mDKHippyWebView.onDestroy();
        }
        this.mDKHippyWebView = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void evaluateJavaScript(String str, ValueCallback<String> valueCallback) {
        DKWebView dKWebView = this.mDKHippyWebView;
        if (dKWebView != null) {
            dKWebView.evaluateJavaScript(str, valueCallback);
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (NativeGestureDispatcher) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getUserAgent() {
        DKWebView dKWebView = this.mDKHippyWebView;
        if (dKWebView != null) {
            return dKWebView.getUserAgent();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void goBack() {
        DKWebView dKWebView = this.mDKHippyWebView;
        if (dKWebView != null) {
            dKWebView.goBack();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void goForward() {
        DKWebView dKWebView = this.mDKHippyWebView;
        if (dKWebView != null) {
            dKWebView.goForward();
        }
    }

    void handlePostMessage(String str) {
        DLog.i(TAG, "postMessage, message: " + str);
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("data", str);
        this.mEventOnMessage.send(this, hippyMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadUrl(String str) {
        DLog.i(TAG, "loadUrl: " + str);
        if (this.mDKHippyWebView != null && !TextUtils.isEmpty(str)) {
            this.mDKHippyWebView.loadUrl(str);
        }
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView.DKWebViewEventListener
    public void onPageFinished(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        DLog.i(TAG, "onPageFinished, url: " + str);
        new HippyMap().pushString("url", str);
        this.mEventOnLoadEnd.send(this, str);
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView.DKWebViewEventListener
    public void onPageStart(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        DLog.i(TAG, "onPageStart, url: " + str);
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("url", str);
        this.mEventOnLoadStart.send(this, hippyMap);
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView.DKWebViewEventListener
    public void onReceivedError(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) str);
            return;
        }
        DLog.i(TAG, "onReceivedError, errorCode: " + i3 + ", error: " + str);
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("error", str);
        hippyMap.pushInt("errorCode", i3);
        this.mEventOnError.send(this, hippyMap);
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView.OnScrollChangeListener
    public void onScrollChange(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        DLog.d(TAG, "onScrollChange, scrollX: " + i3 + ", scrollY: " + i16);
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("scrollX", i3);
        hippyMap.pushInt("scrollY", i16);
        this.mEventOnScrollChanged.send(this, hippyMap);
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView.OnTouchDownListener
    public void onTouchDown(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        DLog.d(TAG, "onTouchDown, x" + f16 + ", y" + f17);
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushDouble(HippyTKDListViewAdapter.X, (double) f16);
        hippyMap.pushDouble("y", (double) f17);
        this.mEventOnTouchDown.send(this, hippyMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reload() {
        DKWebView dKWebView = this.mDKHippyWebView;
        if (dKWebView != null) {
            dKWebView.reload();
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) nativeGestureDispatcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLaunchMode(int i3) {
        DKWebView dKWebView = this.mDKHippyWebView;
        if (dKWebView == null) {
            DLog.e(TAG, "[setLaunchMode] error, mDKHippyWebView is null");
        } else {
            dKWebView.setLaunchMode(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSource(HippyMap hippyMap) {
        DLog.i(TAG, "setSource, source: " + hippyMap);
        if (hippyMap == null) {
            DLog.w(TAG, "source is empty.");
        } else {
            setUserAgent(hippyMap.getString("userAgent"));
            loadUrl(hippyMap.getString(LayoutAttrDefine.CLICK_URI));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUserAgent(String str) {
        DKWebView dKWebView;
        DLog.i(TAG, "setUserAgent, ua: " + str);
        if (!TextUtils.isEmpty(str) && (dKWebView = this.mDKHippyWebView) != null) {
            dKWebView.setUserAgent(str);
        }
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView.DKWebViewEventListener
    public boolean shouldOverrideUrlLoading(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).booleanValue();
        }
        DLog.i(TAG, "shouldOverrideUrlLoading, url: " + str);
        if (!TextUtils.isEmpty(str) && str.startsWith(POST_MESSAGE_URL_PRE)) {
            DLog.i(TAG, "post message url: " + str);
            handlePostMessage(URLDecoder.decode(str.substring(25)));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopLoading() {
        DKWebView dKWebView = this.mDKHippyWebView;
        if (dKWebView != null) {
            dKWebView.stopLoading();
        }
    }

    public DKHippyWebViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mEventOnError = new DKHippyViewEvent("onError");
        this.mEventOnLoadEnd = new DKHippyViewEvent(HippyQQPagView.EventName.ON_LOAD_END);
        this.mEventOnLoadStart = new DKHippyViewEvent(HippyQQPagView.EventName.ON_LOAD_START);
        this.mEventOnMessage = new DKHippyViewEvent("onMessage");
        this.mEventOnScrollChanged = new DKHippyViewEvent("onScrollChange");
        this.mEventOnTouchDown = new DKHippyViewEvent("onWebViewTouchDown");
        init(context);
    }

    public DKHippyWebViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mEventOnError = new DKHippyViewEvent("onError");
        this.mEventOnLoadEnd = new DKHippyViewEvent(HippyQQPagView.EventName.ON_LOAD_END);
        this.mEventOnLoadStart = new DKHippyViewEvent(HippyQQPagView.EventName.ON_LOAD_START);
        this.mEventOnMessage = new DKHippyViewEvent("onMessage");
        this.mEventOnScrollChanged = new DKHippyViewEvent("onScrollChange");
        this.mEventOnTouchDown = new DKHippyViewEvent("onWebViewTouchDown");
        init(context);
    }

    public DKHippyWebViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.mEventOnError = new DKHippyViewEvent("onError");
        this.mEventOnLoadEnd = new DKHippyViewEvent(HippyQQPagView.EventName.ON_LOAD_END);
        this.mEventOnLoadStart = new DKHippyViewEvent(HippyQQPagView.EventName.ON_LOAD_START);
        this.mEventOnMessage = new DKHippyViewEvent("onMessage");
        this.mEventOnScrollChanged = new DKHippyViewEvent("onScrollChange");
        this.mEventOnTouchDown = new DKHippyViewEvent("onWebViewTouchDown");
        init(context);
    }
}
