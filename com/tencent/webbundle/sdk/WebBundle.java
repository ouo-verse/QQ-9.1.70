package com.tencent.webbundle.sdk;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.webkit.JavascriptInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.tmdownloader.a;
import com.tencent.webbundle.sdk.IWebBundleWebView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WebBundle implements IStateHolder<WebBundlePreloadState> {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "WebBundle.WebBundle";
    private String mBizId;
    private final MutableContextWrapper mContext;
    private ArrayList<PreloadStateListener> mListeners;
    private WebBundlePreloadState mPreloadState;
    private final Runnable mPreloadTimeOutChecker;
    private final WebBundleInterface mWebBundleInterface;
    private String preloadUrl;
    private String realUrl;
    private IWebBundleWebView webView;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface PreloadStateListener {
        void onStateChange(WebBundle webBundle, WebBundlePreloadState webBundlePreloadState);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class WebBundleInterface {
        static IPatchRedirector $redirector_;
        private WeakReference<IStateHolder<WebBundlePreloadState>> holderRef;
        private String json;

        public WebBundleInterface(IStateHolder<WebBundlePreloadState> iStateHolder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebBundle.this, (Object) iStateHolder);
            } else {
                this.json = "";
                this.holderRef = new WeakReference<>(iStateHolder);
            }
        }

        @JavascriptInterface
        public String getData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            IStateHolder<WebBundlePreloadState> iStateHolder = this.holderRef.get();
            if (iStateHolder != null) {
                WebBundleManager.getInstance(WebBundle.this.mBizId).log(3, WebBundle.TAG, "[use][step 2][#", String.valueOf(iStateHolder.hashCode()), "] h5 get real data: ", this.json);
            }
            return this.json;
        }

        public String getJson() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.json;
        }

        @JavascriptInterface
        public void preloadViewSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            IStateHolder<WebBundlePreloadState> iStateHolder = this.holderRef.get();
            if (iStateHolder != null) {
                WebBundleManager.getInstance(WebBundle.this.mBizId).log(3, WebBundle.TAG, "[preload][step 3][#", String.valueOf(iStateHolder.hashCode()), "] receive preload success callback from h5.");
                iStateHolder.setPreloadState(WebBundlePreloadState.SUCCESS);
            }
        }

        public void setJson(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                this.json = str;
            }
        }

        @JavascriptInterface
        public void setWebBundleOption(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
                return;
            }
            IStateHolder<WebBundlePreloadState> iStateHolder = this.holderRef.get();
            boolean z16 = true;
            if (iStateHolder != null) {
                WebBundleManager.getInstance(WebBundle.this.mBizId).log(3, WebBundle.TAG, "[@", String.valueOf(iStateHolder.hashCode()), "][setWebBundleOption] useWebBundle = ", String.valueOf(i3));
            }
            WebBundleConfig config = WebBundleManager.getInstance(WebBundle.this.mBizId).getConfig();
            if (config != null && config.getOptionListener() != null) {
                WebBundleH5OptionListner optionListener = config.getOptionListener();
                if (i3 == 0) {
                    z16 = false;
                }
                optionListener.enableWebBundle(z16);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class WebBundlePreloadState {
        private static final /* synthetic */ WebBundlePreloadState[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final WebBundlePreloadState ANALYSIS_JS_BUNDLE;
        public static final WebBundlePreloadState CREATE_WEBVIEW;
        public static final WebBundlePreloadState FAILED;
        public static final WebBundlePreloadState INIT;
        public static final WebBundlePreloadState LOAD_PAGE;
        public static final WebBundlePreloadState SUCCESS;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10912);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            WebBundlePreloadState webBundlePreloadState = new WebBundlePreloadState(a.CONNTECTSTATE_INIT, 0);
            INIT = webBundlePreloadState;
            WebBundlePreloadState webBundlePreloadState2 = new WebBundlePreloadState("CREATE_WEBVIEW", 1);
            CREATE_WEBVIEW = webBundlePreloadState2;
            WebBundlePreloadState webBundlePreloadState3 = new WebBundlePreloadState("LOAD_PAGE", 2);
            LOAD_PAGE = webBundlePreloadState3;
            WebBundlePreloadState webBundlePreloadState4 = new WebBundlePreloadState("ANALYSIS_JS_BUNDLE", 3);
            ANALYSIS_JS_BUNDLE = webBundlePreloadState4;
            WebBundlePreloadState webBundlePreloadState5 = new WebBundlePreloadState("SUCCESS", 4);
            SUCCESS = webBundlePreloadState5;
            WebBundlePreloadState webBundlePreloadState6 = new WebBundlePreloadState("FAILED", 5);
            FAILED = webBundlePreloadState6;
            $VALUES = new WebBundlePreloadState[]{webBundlePreloadState, webBundlePreloadState2, webBundlePreloadState3, webBundlePreloadState4, webBundlePreloadState5, webBundlePreloadState6};
        }

        WebBundlePreloadState(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static WebBundlePreloadState valueOf(String str) {
            return (WebBundlePreloadState) Enum.valueOf(WebBundlePreloadState.class, str);
        }

        public static WebBundlePreloadState[] values() {
            return (WebBundlePreloadState[]) $VALUES.clone();
        }
    }

    public WebBundle(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
            return;
        }
        this.mWebBundleInterface = new WebBundleInterface(this);
        this.mPreloadState = WebBundlePreloadState.INIT;
        this.mListeners = new ArrayList<>();
        this.preloadUrl = "";
        this.realUrl = "";
        this.webView = null;
        this.mPreloadTimeOutChecker = new Runnable() { // from class: com.tencent.webbundle.sdk.WebBundle.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebBundle.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    WebBundle.this.forceStop("preload timeout");
                }
            }
        };
        this.mContext = new MutableContextWrapper(context);
        this.mBizId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPreloadStateChanged(@NotNull WebBundlePreloadState webBundlePreloadState) {
        for (int i3 = 0; i3 < this.mListeners.size(); i3++) {
            this.mListeners.get(i3).onStateChange(this, webBundlePreloadState);
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        ThreadManager.getUiHandler().removeCallbacks(this.mPreloadTimeOutChecker);
        resetContext(this.mContext.getApplicationContext());
        IWebBundleWebView iWebBundleWebView = this.webView;
        if (iWebBundleWebView != null) {
            iWebBundleWebView.destroy();
            this.webView = null;
        }
        this.mListeners.clear();
    }

    public void forceStop(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else if (getPreloadState() != WebBundlePreloadState.SUCCESS) {
            WebBundleManager.getInstance(this.mBizId).log(3, TAG, "stop preloading webbundle because ", str);
            setPreloadState(WebBundlePreloadState.FAILED);
        }
    }

    public String getPreloadUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.preloadUrl;
    }

    public String getRealUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.realUrl;
    }

    public IWebBundleWebView getWebView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (IWebBundleWebView) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.webView;
    }

    public void resetContext(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        } else {
            this.mContext.setBaseContext(context);
        }
    }

    public void startPreload(@NotNull String str, @NotNull JSONObject jSONObject, PreloadStateListener preloadStateListener) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, jSONObject, preloadStateListener);
            return;
        }
        ThreadManager.checkMainThread("startPreload");
        IWebBundleRuntime runtime = WebBundleManager.getInstance(this.mBizId).getRuntime();
        if (runtime == null) {
            ThreadManager.getUiHandler().post(new Runnable() { // from class: com.tencent.webbundle.sdk.WebBundle.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebBundle.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        WebBundle.this.setPreloadState(WebBundlePreloadState.FAILED);
                    }
                }
            });
            return;
        }
        this.preloadUrl = str;
        if (preloadStateListener != null) {
            this.mListeners.add(preloadStateListener);
        }
        WebBundleConfig config = WebBundleManager.getInstance(this.mBizId).getConfig();
        if (config != null) {
            j3 = config.getPreloadTimeoutLimit();
        } else {
            j3 = 15000;
        }
        ThreadManager.getUiHandler().postDelayed(this.mPreloadTimeOutChecker, j3);
        setPreloadState(WebBundlePreloadState.CREATE_WEBVIEW);
        IWebBundleWebView createWebView = runtime.createWebView(this.mContext);
        this.webView = createWebView;
        if (createWebView != null) {
            createWebView.enableJavaScript(true);
            this.webView.addJavascriptInterface(this.mWebBundleInterface, "webbundle");
            this.webView.setOnPageFinishedListener(new IWebBundleWebView.OnPageFinishedListener(jSONObject) { // from class: com.tencent.webbundle.sdk.WebBundle.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ JSONObject val$pendingData;

                {
                    this.val$pendingData = jSONObject;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebBundle.this, (Object) jSONObject);
                    }
                }

                @Override // com.tencent.webbundle.sdk.IWebBundleWebView.OnPageFinishedListener
                public void onPageFinished(@NotNull IWebBundleWebView iWebBundleWebView, @NotNull String str2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iWebBundleWebView, (Object) str2);
                    } else {
                        if (WebBundle.this.getPreloadState() == WebBundlePreloadState.FAILED) {
                            return;
                        }
                        WebBundle.this.setPreloadState(WebBundlePreloadState.ANALYSIS_JS_BUNDLE);
                        iWebBundleWebView.dispatchJsEvent(WebBundleConstants.EVENT_NAME_OF_WEB_BUNDLE, this.val$pendingData, null);
                        WebBundleManager.getInstance(WebBundle.this.mBizId).log(3, WebBundle.TAG, "[preload][step 2][#", String.valueOf(WebBundle.this.hashCode()), "] send message to h5 to load template. pendingData = ", this.val$pendingData.toString());
                    }
                }
            });
            setPreloadState(WebBundlePreloadState.LOAD_PAGE);
            this.webView.loadUrl(str);
        }
        WebBundleManager.getInstance(this.mBizId).log(3, TAG, "[preload][step 1][#", String.valueOf(hashCode()), "] init webview finish..");
    }

    public void use(@NotNull JSONObject jSONObject) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) jSONObject);
            return;
        }
        ThreadManager.checkMainThread(TransFileControllerImpl.VALUE_USE_PRE_CONN);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            str = optJSONObject.toString();
        } else {
            str = "";
        }
        this.mWebBundleInterface.setJson(str);
        this.realUrl = jSONObject.optString("url");
        jSONObject.remove("data");
        IWebBundleWebView iWebBundleWebView = this.webView;
        if (iWebBundleWebView != null) {
            iWebBundleWebView.dispatchJsEvent(WebBundleConstants.EVENT_NAME_OF_WEB_BUNDLE, jSONObject, null);
        }
        WebBundleManager.getInstance(this.mBizId).log(3, TAG, "[use][step 1][#", String.valueOf(hashCode()), "] send message to h5 for push view. url = ", this.realUrl, ", data = ", this.mWebBundleInterface.json);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.webbundle.sdk.IStateHolder
    public WebBundlePreloadState getPreloadState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? this.mPreloadState : (WebBundlePreloadState) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // com.tencent.webbundle.sdk.IStateHolder
    public void setPreloadState(@NotNull WebBundlePreloadState webBundlePreloadState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            ThreadManager.executeOnUiThread(new Runnable(webBundlePreloadState) { // from class: com.tencent.webbundle.sdk.WebBundle.4
                static IPatchRedirector $redirector_;
                final /* synthetic */ WebBundlePreloadState val$state;

                {
                    this.val$state = webBundlePreloadState;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebBundle.this, (Object) webBundlePreloadState);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (WebBundle.this.mPreloadState.ordinal() < this.val$state.ordinal()) {
                        WebBundle.this.mPreloadState = this.val$state;
                        WebBundle.this.notifyPreloadStateChanged(this.val$state);
                        if (WebBundle.this.mPreloadState == WebBundlePreloadState.SUCCESS) {
                            ThreadManager.getUiHandler().removeCallbacks(WebBundle.this.mPreloadTimeOutChecker);
                            WebBundle webBundle = WebBundle.this;
                            webBundle.resetContext(webBundle.mContext.getApplicationContext());
                            return;
                        } else {
                            if (WebBundle.this.mPreloadState == WebBundlePreloadState.FAILED) {
                                WebBundle.this.destroy();
                                return;
                            }
                            return;
                        }
                    }
                    WebBundleManager.getInstance(WebBundle.this.mBizId).log(6, WebBundle.TAG, "ignore this invalidate state. current state is ", String.valueOf(WebBundle.this.mPreloadState), " new state is ", String.valueOf(this.val$state));
                }
            });
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) webBundlePreloadState);
        }
    }
}
