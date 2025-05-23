package com.tencent.ams.dsdk.view.webview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.core.DKCustomAbilityProvider;
import com.tencent.ams.dsdk.core.mosaic.DKMosaicEngine;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.ams.dsdk.view.webview.DKWebView;
import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.component.BasicComponent;
import com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKMosaicWebViewComponentImpl extends BasicComponent implements WebViewComponent, DKWebView.DKWebViewEventListener, DKWebView.OnScrollChangeListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKMosaicWebViewComponentImpl";
    private Context mContext;
    private volatile DKWebView mDKWebView;
    private AtomicBoolean mIsWebViewHasInit;
    private long mLastActionTimeMS;
    private DKMosaicEngine mMosaicEngine;
    private JSFunction mPlatformViewEventCallBack;
    private com.tencent.ams.mosaic.jsengine.a mQuickJSEngine;
    private long mScrollChangeNotiDurationMS;
    private final com.tencent.ams.mosaic.jsengine.common.thread.a mWebViewHasInitLatch;

    public DKMosaicWebViewComponentImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.mScrollChangeNotiDurationMS = 0L;
        this.mWebViewHasInitLatch = new com.tencent.ams.mosaic.jsengine.common.thread.a(1);
        this.mIsWebViewHasInit = new AtomicBoolean(false);
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackResult(JSFunction jSFunction, int i3, String str, Object obj, Map map) {
        if (this.mQuickJSEngine == null) {
            f.b(TAG, "callBackResult: mQuickJSEngine is null");
            return;
        }
        if (jSFunction == null) {
            f.b(TAG, "callBackResult: callback is null");
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str) && obj != null) {
                hashMap.put(str, obj);
            }
            if (map != null) {
                hashMap.put("eventParams", map);
            }
            f.e(TAG, "callBackResult callJsFunction start respMap = " + hashMap);
            this.mQuickJSEngine.u(jSFunction, new Object[]{Integer.valueOf(i3), hashMap}, null);
        } catch (Throwable th5) {
            f.c(TAG, "callBackResult", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initWebView(Context context) {
        Class<? extends DKWebView> dKWebView;
        DKCustomAbilityProvider customAbilityProvider;
        DLog.i(TAG, "initWebView");
        if (this.mIsWebViewHasInit.get()) {
            DLog.i(TAG, "initWebView, webview has init");
            return;
        }
        this.mIsWebViewHasInit.set(true);
        DKMosaicEngine dKMosaicEngine = this.mMosaicEngine;
        if (dKMosaicEngine != null && (customAbilityProvider = dKMosaicEngine.getCustomAbilityProvider()) != null) {
            DLog.i(TAG, "use engine provider video player.");
            this.mDKWebView = customAbilityProvider.getDKWebView(context);
        }
        if (this.mDKWebView == null && (dKWebView = DKConfiguration.getDKWebView()) != null && context != null) {
            try {
                DLog.i(TAG, "use outside WebView");
                Constructor<? extends DKWebView> constructor = dKWebView.getConstructor(Context.class);
                if (constructor != null) {
                    this.mDKWebView = constructor.newInstance(context);
                }
            } catch (Throwable th5) {
                DLog.e(TAG, "reflect outside WebView error.", th5);
            }
        }
        if (this.mDKWebView == null) {
            DLog.i(TAG, "use default WebView");
            this.mDKWebView = new DKDefaultWebView(context);
        }
        this.mDKWebView.registerWebViewEventListener(this);
        this.mDKWebView.registerOnScrollChangedListener(this);
        View dKWebView2 = this.mDKWebView.getDKWebView();
        if (dKWebView2 != null) {
            dKWebView2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.tencent.ams.dsdk.view.webview.DKMosaicWebViewComponentImpl.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKMosaicWebViewComponentImpl.this);
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                    } else {
                        DLog.i(DKMosaicWebViewComponentImpl.TAG, " onViewAttachedToWindow");
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
                        return;
                    }
                    DLog.i(DKMosaicWebViewComponentImpl.TAG, " onViewDetachedFromWindow");
                    DKWebView dKWebView3 = DKMosaicWebViewComponentImpl.this.mDKWebView;
                    if (dKWebView3 != null) {
                        dKWebView3.unRegisterOnScrollChangedListener(DKMosaicWebViewComponentImpl.this);
                    }
                }
            });
        }
        this.mWebViewHasInitLatch.countDown();
    }

    private void scrollChangeNoti(int i3, int i16, int i17, int i18) {
        HashMap hashMap = new HashMap();
        hashMap.put(HippyTKDListViewAdapter.X, Float.valueOf(MosaicUtils.E(i3)));
        hashMap.put("y", Float.valueOf(MosaicUtils.E(i16)));
        hashMap.put("oldx", Float.valueOf(MosaicUtils.E(i17)));
        hashMap.put("oldy", Float.valueOf(MosaicUtils.E(i18)));
        f.e(TAG, "onScrollChange webView didScrollNoti scrollX\uff1a" + i3 + " scrollY\uff1a" + i16 + " oldX\uff1a" + i17 + " oldY\uff1a" + i18);
        callBackResult(this.mPlatformViewEventCallBack, 0, "event", "onWebViewScrolled", hashMap);
    }

    private void scrollChangeNotiWithDuration(int i3, int i16, int i17, int i18) {
        long j3 = this.mScrollChangeNotiDurationMS;
        if (j3 <= 0) {
            scrollChangeNoti(i3, i16, i17, i18);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mLastActionTimeMS == 0) {
            this.mLastActionTimeMS = System.currentTimeMillis();
        }
        if (currentTimeMillis - this.mLastActionTimeMS >= j3) {
            this.mLastActionTimeMS = currentTimeMillis;
            scrollChangeNoti(i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void canGoBack(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) jSFunction);
        } else {
            MosaicUtils.I(new Runnable(jSFunction) { // from class: com.tencent.ams.dsdk.view.webview.DKMosaicWebViewComponentImpl.7
                static IPatchRedirector $redirector_;
                final /* synthetic */ JSFunction val$callback;

                {
                    this.val$callback = jSFunction;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKMosaicWebViewComponentImpl.this, (Object) jSFunction);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DKWebView dKWebView = DKMosaicWebViewComponentImpl.this.mDKWebView;
                        if (dKWebView == null) {
                            DKMosaicWebViewComponentImpl.this.callBackResult(this.val$callback, -1, null, null, null);
                            return;
                        }
                        boolean canGoBack = dKWebView.canGoBack();
                        f.e(DKMosaicWebViewComponentImpl.TAG, "canGoBack: " + canGoBack);
                        DKMosaicWebViewComponentImpl.this.callBackResult(this.val$callback, 0, DKWebViewController.DKHippyWebviewFunction.CAN_GO_BACK, Boolean.valueOf(canGoBack), null);
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void canGoForward(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) jSFunction);
        } else {
            MosaicUtils.I(new Runnable(jSFunction) { // from class: com.tencent.ams.dsdk.view.webview.DKMosaicWebViewComponentImpl.9
                static IPatchRedirector $redirector_;
                final /* synthetic */ JSFunction val$callback;

                {
                    this.val$callback = jSFunction;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKMosaicWebViewComponentImpl.this, (Object) jSFunction);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DKWebView dKWebView = DKMosaicWebViewComponentImpl.this.mDKWebView;
                        if (dKWebView == null) {
                            DKMosaicWebViewComponentImpl.this.callBackResult(this.val$callback, -1, null, null, null);
                            return;
                        }
                        boolean canGoForward = dKWebView.canGoForward();
                        f.e(DKMosaicWebViewComponentImpl.TAG, "canGoForward: " + canGoForward);
                        DKMosaicWebViewComponentImpl.this.callBackResult(this.val$callback, 0, DKWebViewController.DKHippyWebviewFunction.CAN_GO_FORWARD, Boolean.valueOf(canGoForward), null);
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void evaluateJavaScript(String str, JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) jSFunction);
            return;
        }
        DLog.i(TAG, "evaluateJavaScript: " + str);
        DynamicUtils.runOnUiThread(new Runnable(str, jSFunction) { // from class: com.tencent.ams.dsdk.view.webview.DKMosaicWebViewComponentImpl.11
            static IPatchRedirector $redirector_;
            final /* synthetic */ JSFunction val$jsFunction;
            final /* synthetic */ String val$script;

            {
                this.val$script = str;
                this.val$jsFunction = jSFunction;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, DKMosaicWebViewComponentImpl.this, str, jSFunction);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    DKWebView dKWebView = DKMosaicWebViewComponentImpl.this.mDKWebView;
                    if (dKWebView != null && !TextUtils.isEmpty(this.val$script)) {
                        try {
                            dKWebView.evaluateJavaScript(this.val$script, new ValueCallback<String>() { // from class: com.tencent.ams.dsdk.view.webview.DKMosaicWebViewComponentImpl.11.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass11.this);
                                    }
                                }

                                @Override // android.webkit.ValueCallback
                                public void onReceiveValue(String str2) {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this, (Object) str2);
                                    } else {
                                        AnonymousClass11 anonymousClass11 = AnonymousClass11.this;
                                        DKMosaicWebViewComponentImpl.this.callBackResult(anonymousClass11.val$jsFunction, 0, "data", str2, null);
                                    }
                                }
                            });
                            return;
                        } catch (Throwable th5) {
                            DLog.e(DKMosaicWebViewComponentImpl.TAG, "evaluateJavaScript catch\uff1a", th5);
                            HashMap hashMap = new HashMap();
                            hashMap.put("error", th5.getMessage());
                            DKMosaicWebViewComponentImpl.this.callBackResult(this.val$jsFunction, -1, null, null, hashMap);
                            return;
                        }
                    }
                    DLog.e(DKMosaicWebViewComponentImpl.TAG, "evaluateJavaScript error");
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("error", "evaluateJavaScript error");
                    DKMosaicWebViewComponentImpl.this.callBackResult(this.val$jsFunction, -1, null, null, hashMap2);
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void getUserAgent(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) jSFunction);
        } else {
            MosaicUtils.I(new Runnable(jSFunction) { // from class: com.tencent.ams.dsdk.view.webview.DKMosaicWebViewComponentImpl.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ JSFunction val$callback;

                {
                    this.val$callback = jSFunction;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKMosaicWebViewComponentImpl.this, (Object) jSFunction);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DKWebView dKWebView = DKMosaicWebViewComponentImpl.this.mDKWebView;
                        if (dKWebView == null) {
                            DKMosaicWebViewComponentImpl.this.callBackResult(this.val$callback, -1, null, null, null);
                            return;
                        }
                        String userAgent = dKWebView.getUserAgent();
                        f.e(DKMosaicWebViewComponentImpl.TAG, "getUserAgent: " + userAgent);
                        DKMosaicWebViewComponentImpl.this.callBackResult(this.val$callback, 0, "userAgent", userAgent, null);
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (View) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        if (this.mDKWebView != null) {
            return this.mDKWebView.getDKWebView();
        }
        if (DynamicUtils.isMainThread()) {
            DLog.i(TAG, "getView in main thread and mDKWebView hasn't init, do init");
            initWebView(this.mContext);
        } else {
            DLog.i(TAG, "getView not in main thread and mDKWebView hasn't init, await init");
            this.mWebViewHasInitLatch.await();
        }
        if (this.mDKWebView == null) {
            f.b(TAG, "getView return null, mDKWebView = " + this.mDKWebView);
            return null;
        }
        return this.mDKWebView.getDKWebView();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void goBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            DynamicUtils.runOnUiThread(new Runnable() { // from class: com.tencent.ams.dsdk.view.webview.DKMosaicWebViewComponentImpl.8
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKMosaicWebViewComponentImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DKWebView dKWebView = DKMosaicWebViewComponentImpl.this.mDKWebView;
                        if (dKWebView != null) {
                            dKWebView.goBack();
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void goForward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            DynamicUtils.runOnUiThread(new Runnable() { // from class: com.tencent.ams.dsdk.view.webview.DKMosaicWebViewComponentImpl.10
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKMosaicWebViewComponentImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DKWebView dKWebView = DKMosaicWebViewComponentImpl.this.mDKWebView;
                        if (dKWebView != null) {
                            dKWebView.goForward();
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void loadUrlWithString(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            DynamicUtils.runOnUiThread(new Runnable(str) { // from class: com.tencent.ams.dsdk.view.webview.DKMosaicWebViewComponentImpl.4
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$url;

                {
                    this.val$url = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKMosaicWebViewComponentImpl.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DKWebView dKWebView = DKMosaicWebViewComponentImpl.this.mDKWebView;
                        DLog.i(DKMosaicWebViewComponentImpl.TAG, "loadUrl: " + this.val$url);
                        if (dKWebView != null && !TextUtils.isEmpty(this.val$url)) {
                            dKWebView.loadUrl(this.val$url);
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView.DKWebViewEventListener
    public void onPageFinished(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        callBackResult(this.mPlatformViewEventCallBack, 0, "event", "onWebViewLoadFinish", hashMap);
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView.DKWebViewEventListener
    public void onPageStart(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        callBackResult(this.mPlatformViewEventCallBack, 0, "event", "onWebViewLoadStart", hashMap);
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView.DKWebViewEventListener
    public void onReceivedError(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3, (Object) str);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("error", Integer.valueOf(i3));
        callBackResult(this.mPlatformViewEventCallBack, 0, "event", "onWebViewLoadError", hashMap);
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView.OnScrollChangeListener
    public void onScrollChange(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            scrollChangeNotiWithDuration(i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void platformViewEvent(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSFunction);
        } else {
            this.mPlatformViewEventCallBack = jSFunction;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void reload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            DynamicUtils.runOnUiThread(new Runnable() { // from class: com.tencent.ams.dsdk.view.webview.DKMosaicWebViewComponentImpl.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKMosaicWebViewComponentImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DKWebView dKWebView = DKMosaicWebViewComponentImpl.this.mDKWebView;
                        if (dKWebView != null) {
                            dKWebView.reload();
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.component.Component
    public void setJSEngine(com.tencent.ams.mosaic.jsengine.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) aVar);
            return;
        }
        DLog.i(TAG, "setJSEngine");
        super.setJSEngine(aVar);
        this.mMosaicEngine = DKMosaicEngine.getDKMosaicEngine(aVar);
        this.mQuickJSEngine = aVar;
        DynamicUtils.runOnUiThread(new Runnable() { // from class: com.tencent.ams.dsdk.view.webview.DKMosaicWebViewComponentImpl.12
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKMosaicWebViewComponentImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    DKMosaicWebViewComponentImpl dKMosaicWebViewComponentImpl = DKMosaicWebViewComponentImpl.this;
                    dKMosaicWebViewComponentImpl.initWebView(dKMosaicWebViewComponentImpl.mContext);
                }
            }
        });
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void setScrollChangeNotiDurationMS(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
        } else {
            this.mScrollChangeNotiDurationMS = j3;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void setScrollEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
            return;
        }
        DKWebView dKWebView = this.mDKWebView;
        if (dKWebView != null) {
            f.e(TAG, "setScrollEnabled\uff1a" + z16);
            dKWebView.setIsWebViewScrollEnabled(z16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void setUserAgent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        DLog.i(TAG, "setUserAgent: " + str);
        DynamicUtils.runOnUiThread(new Runnable(str) { // from class: com.tencent.ams.dsdk.view.webview.DKMosaicWebViewComponentImpl.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$userAgent;

            {
                this.val$userAgent = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKMosaicWebViewComponentImpl.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    DKWebView dKWebView = DKMosaicWebViewComponentImpl.this.mDKWebView;
                    if (dKWebView != null && !TextUtils.isEmpty(this.val$userAgent)) {
                        dKWebView.setUserAgent(this.val$userAgent);
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView.DKWebViewEventListener
    public boolean shouldOverrideUrlLoading(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void stopLoading() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            DynamicUtils.runOnUiThread(new Runnable() { // from class: com.tencent.ams.dsdk.view.webview.DKMosaicWebViewComponentImpl.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKMosaicWebViewComponentImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        DKWebView dKWebView = DKMosaicWebViewComponentImpl.this.mDKWebView;
                        if (dKWebView != null) {
                            dKWebView.stopLoading();
                            return;
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return TAG;
    }
}
