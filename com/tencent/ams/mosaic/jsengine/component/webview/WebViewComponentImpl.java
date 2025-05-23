package com.tencent.ams.mosaic.jsengine.component.webview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.common.thread.a;
import com.tencent.ams.mosaic.jsengine.component.BasicComponent;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class WebViewComponentImpl extends BasicComponent implements WebViewComponent {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private MosaicWebView f71426d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f71427e;

    /* renamed from: f, reason: collision with root package name */
    private Context f71428f;

    /* compiled from: P */
    /* renamed from: com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponentImpl$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.ams.mosaic.jsengine.a f71436d;

        /* compiled from: P */
        /* renamed from: com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponentImpl$2$a */
        /* loaded from: classes3.dex */
        class a implements View.OnAttachStateChangeListener {
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            /* renamed from: com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponentImpl$2$a$a, reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            class ViewOnTouchListenerC0695a implements View.OnTouchListener {
                static IPatchRedirector $redirector_;

                ViewOnTouchListenerC0695a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                    }
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
                    }
                    if (view instanceof WebView) {
                        ((WebView) view).requestDisallowInterceptTouchEvent(WebViewComponentImpl.this.f71427e);
                        return false;
                    }
                    return false;
                }
            }

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                    return;
                }
                f.e("WebViewComponentImpl", " onViewAttachedToWindow");
                if (view instanceof WebView) {
                    WebViewComponentImpl.this.t((WebView) view);
                }
                view.setOnTouchListener(new ViewOnTouchListenerC0695a());
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
                } else {
                    f.e("WebViewComponentImpl", " onViewDetachedFromWindow");
                }
            }
        }

        AnonymousClass2(com.tencent.ams.mosaic.jsengine.a aVar) {
            this.f71436d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebViewComponentImpl.this, (Object) aVar);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            WebViewComponentImpl.this.f71426d = new MosaicWebView(WebViewComponentImpl.this.f71428f);
            WebViewComponentImpl.this.f71426d.setMosaicWebViewClient();
            WebViewComponentImpl.this.f71426d.setWebViewSettings(WebViewComponentImpl.this.f71428f);
            WebViewComponentImpl.this.f71426d.setMosaicJSEngine(this.f71436d);
            WebViewComponentImpl.this.f71426d.addOnAttachStateChangeListener(new a());
        }
    }

    public WebViewComponentImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.f71427e = true;
            this.f71428f = context;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(WebView webView) {
        if (webView != null) {
            ViewParent parent = webView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).setDescendantFocusability(393216);
            }
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void canGoBack(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) jSFunction);
        } else {
            MosaicUtils.I(new Runnable(jSFunction) { // from class: com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponentImpl.9
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ JSFunction f71443d;

                {
                    this.f71443d = jSFunction;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebViewComponentImpl.this, (Object) jSFunction);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (WebViewComponentImpl.this.f71426d != null) {
                        boolean canGoBack = WebViewComponentImpl.this.f71426d.canGoBack();
                        f.e("WebViewComponentImpl", "canGoBack: " + canGoBack);
                        WebViewComponentImpl.this.f71426d.b(this.f71443d, 0, DKWebViewController.DKHippyWebviewFunction.CAN_GO_BACK, Boolean.valueOf(canGoBack), null);
                        return;
                    }
                    WebViewComponentImpl.this.f71426d.b(this.f71443d, -1, null, null, null);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void canGoForward(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) jSFunction);
        } else {
            MosaicUtils.I(new Runnable(jSFunction) { // from class: com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponentImpl.11
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ JSFunction f71431d;

                {
                    this.f71431d = jSFunction;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebViewComponentImpl.this, (Object) jSFunction);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (WebViewComponentImpl.this.f71426d != null) {
                        boolean canGoForward = WebViewComponentImpl.this.f71426d.canGoForward();
                        f.e("WebViewComponentImpl", "canGoForward: " + canGoForward);
                        WebViewComponentImpl.this.f71426d.b(this.f71431d, 0, DKWebViewController.DKHippyWebviewFunction.CAN_GO_FORWARD, Boolean.valueOf(canGoForward), null);
                        return;
                    }
                    WebViewComponentImpl.this.f71426d.b(this.f71431d, -1, null, null, null);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void evaluateJavaScript(String str, JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, (Object) jSFunction);
            return;
        }
        f.e("WebViewComponentImpl", "script: " + str);
        MosaicUtils.I(new Runnable(str, jSFunction) { // from class: com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponentImpl.13
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f71432d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ JSFunction f71433e;

            /* compiled from: P */
            /* renamed from: com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponentImpl$13$a */
            /* loaded from: classes3.dex */
            class a implements ValueCallback<String> {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass13.this);
                    }
                }

                @Override // android.webkit.ValueCallback
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(String str) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                    } else {
                        WebViewComponentImpl.this.f71426d.b(AnonymousClass13.this.f71433e, 0, "data", str, null);
                    }
                }
            }

            {
                this.f71432d = str;
                this.f71433e = jSFunction;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, WebViewComponentImpl.this, str, jSFunction);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (WebViewComponentImpl.this.f71426d != null) {
                    try {
                        WebViewComponentImpl.this.f71426d.evaluateJavascript(this.f71432d, new a());
                    } catch (Throwable th5) {
                        f.c("WebViewComponentImpl", "evaluateJavaScript catch\uff1a", th5);
                        HashMap hashMap = new HashMap();
                        hashMap.put("error", th5.getMessage());
                        WebViewComponentImpl.this.f71426d.b(this.f71433e, -1, null, null, hashMap);
                    }
                }
            }
        });
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void getUserAgent(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) jSFunction);
        } else {
            MosaicUtils.I(new Runnable(jSFunction) { // from class: com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponentImpl.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ JSFunction f71441d;

                {
                    this.f71441d = jSFunction;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebViewComponentImpl.this, (Object) jSFunction);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    WebSettings settings;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (WebViewComponentImpl.this.f71426d != null && (settings = WebViewComponentImpl.this.f71426d.getSettings()) != null) {
                        String userAgentString = settings.getUserAgentString();
                        f.e("WebViewComponentImpl", "getUserAgent: " + userAgentString);
                        WebViewComponentImpl.this.f71426d.b(this.f71441d, 0, "userAgent", userAgentString, null);
                        return;
                    }
                    WebViewComponentImpl.this.f71426d.b(this.f71441d, -1, null, null, null);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        MosaicWebView mosaicWebView = this.f71426d;
        if (mosaicWebView != null) {
            return mosaicWebView;
        }
        a aVar = new a(1);
        MosaicWebView[] mosaicWebViewArr = {null};
        MosaicUtils.I(new Runnable(mosaicWebViewArr, aVar) { // from class: com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponentImpl.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ MosaicWebView[] f71429d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ a f71430e;

            {
                this.f71429d = mosaicWebViewArr;
                this.f71430e = aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, WebViewComponentImpl.this, mosaicWebViewArr, aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    this.f71429d[0] = WebViewComponentImpl.this.f71426d;
                    this.f71430e.countDown();
                }
            }
        });
        aVar.await();
        return mosaicWebViewArr[0];
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void goBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponentImpl.10
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebViewComponentImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (WebViewComponentImpl.this.f71426d != null) {
                        WebViewComponentImpl.this.f71426d.goBack();
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void goForward() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponentImpl.12
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebViewComponentImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (WebViewComponentImpl.this.f71426d != null) {
                        WebViewComponentImpl.this.f71426d.goForward();
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void loadUrlWithString(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        f.e("WebViewComponentImpl", "loadUrlWithString: " + str);
        MosaicUtils.I(new Runnable(str) { // from class: com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponentImpl.6
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f71442d;

            {
                this.f71442d = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebViewComponentImpl.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (WebViewComponentImpl.this.f71426d != null) {
                    WebViewComponentImpl.this.f71426d.loadUrl(this.f71442d);
                }
            }
        });
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void platformViewEvent(JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) jSFunction);
        } else {
            MosaicUtils.I(new Runnable(jSFunction) { // from class: com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponentImpl.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ JSFunction f71439d;

                {
                    this.f71439d = jSFunction;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebViewComponentImpl.this, (Object) jSFunction);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (WebViewComponentImpl.this.f71426d != null) {
                        WebViewComponentImpl.this.f71426d.setPlatformViewEventCallBack(this.f71439d);
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void reload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponentImpl.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebViewComponentImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (WebViewComponentImpl.this.f71426d != null) {
                        WebViewComponentImpl.this.f71426d.reload();
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.component.Component
    public void setJSEngine(com.tencent.ams.mosaic.jsengine.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            super.setJSEngine(aVar);
            MosaicUtils.I(new AnonymousClass2(aVar));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void setScrollChangeNotiDurationMS(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, j3);
        } else {
            MosaicUtils.I(new Runnable(j3) { // from class: com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponentImpl.14
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f71435d;

                {
                    this.f71435d = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, WebViewComponentImpl.this, Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (WebViewComponentImpl.this.f71426d != null) {
                        WebViewComponentImpl.this.f71426d.setWebViewScrollChangeNotiDurationMS(this.f71435d);
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void setScrollEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.f71427e = z16;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void setUserAgent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        f.e("WebViewComponentImpl", "setUserAgent: " + str);
        MosaicUtils.I(new Runnable(str) { // from class: com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponentImpl.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f71440d;

            {
                this.f71440d = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebViewComponentImpl.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (WebViewComponentImpl.this.f71426d != null) {
                    WebViewComponentImpl.this.f71426d.getSettings().setUserAgentString(this.f71440d);
                }
            }
        });
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponent
    public void stopLoading() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.webview.WebViewComponentImpl.8
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebViewComponentImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (WebViewComponentImpl.this.f71426d != null) {
                        WebViewComponentImpl.this.f71426d.stopLoading();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "WebViewComponentImpl";
    }
}
