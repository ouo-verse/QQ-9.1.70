package com.tencent.tuxmeterqui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.webview.QmWebview;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.tuxmeterqui.TuxMeterUI;
import com.tencent.tuxmeterqui.config.TuxEventListener;
import com.tencent.tuxmetersdk.export.config.TriggerErrorCode;
import com.tencent.tuxmetersdk.impl.TuxSurveyConfig;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxSurveyWebView extends TuxBaseNativeView {
    static IPatchRedirector $redirector_;
    private WebView webView;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class MyWebViewClient extends WebViewClient {
        static IPatchRedirector $redirector_;

        MyWebViewClient() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) webView, (Object) str);
            } else {
                super.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, webView, str, bitmap);
            } else {
                super.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) webView, (Object) webResourceRequest)).booleanValue();
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        /* synthetic */ MyWebViewClient(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) anonymousClass1);
        }
    }

    public TuxSurveyWebView(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // com.tencent.tuxmeterqui.view.TuxBaseNativeView
    protected void initView(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        this.webView = new QmWebview(context);
        this.webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.webView);
        this.webView.setWebViewClient(new MyWebViewClient(null));
        WebSettings settings = this.webView.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(-1);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setGeolocationEnabled(true);
        this.webView.addJavascriptInterface(new Object() { // from class: com.tencent.tuxmeterqui.view.TuxSurveyWebView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TuxSurveyWebView.this);
                }
            }

            @JavascriptInterface
            public String getPf() {
                String pf5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    return (String) iPatchRedirector2.redirect((short) 4, (Object) this);
                }
                TuxSurveyConfig tuxSurveyConfig = TuxSurveyWebView.this.surveyConfig;
                if (tuxSurveyConfig == null || (pf5 = tuxSurveyConfig.getPf()) == null) {
                    return "";
                }
                return pf5;
            }

            @JavascriptInterface
            public String getTuxExtInfo() {
                String base64ExtInfoJson;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return (String) iPatchRedirector2.redirect((short) 3, (Object) this);
                }
                TuxSurveyConfig tuxSurveyConfig = TuxSurveyWebView.this.surveyConfig;
                if (tuxSurveyConfig == null || (base64ExtInfoJson = tuxSurveyConfig.getBase64ExtInfoJson()) == null) {
                    return "";
                }
                return base64ExtInfoJson;
            }

            @JavascriptInterface
            public void onH5SubmitAnswer() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    TuxSurveyWebView.this.webView.post(new Runnable() { // from class: com.tencent.tuxmeterqui.view.TuxSurveyWebView.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            TuxSurveyWebView tuxSurveyWebView = TuxSurveyWebView.this;
                            TuxEventListener tuxEventListener = tuxSurveyWebView.tuxEventListener;
                            if (tuxEventListener != null) {
                                tuxEventListener.onSurveySubmit(tuxSurveyWebView.surveyConfig);
                            }
                        }
                    });
                }
            }
        }, "tux");
    }

    @Override // com.tencent.tuxmeterqui.view.TuxBaseNativeView
    protected void updateUIWithData() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        TuxSurveyConfig tuxSurveyConfig = this.surveyConfig;
        if (tuxSurveyConfig != null && tuxSurveyConfig.getResource() != null) {
            str = this.surveyConfig.getResource().getUrlOfParam();
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            TuxMeterUI.getInstance().reportSurveyFailedEvent(this.surveyConfig, TriggerErrorCode.FAIL);
        } else {
            this.webView.loadUrl(str);
        }
    }

    public TuxSurveyWebView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public TuxSurveyWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
