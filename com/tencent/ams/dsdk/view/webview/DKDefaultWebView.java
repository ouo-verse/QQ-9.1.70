package com.tencent.ams.dsdk.view.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.view.webview.DKWebView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.webview.QmWebview;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKDefaultWebView extends QmWebview implements DKWebView {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKDefaultHippyWebiew";
    private Boolean mIsWebViewScrollEnabledBoolean;
    private DKWebView.DKWebViewEventListener mListener;
    private DKWebView.OnScrollChangeListener mOnScrollChangeListener;

    public DKDefaultWebView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            init(context);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void init(Context context) {
        WebSettings settings = getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(true);
            settings.setAllowFileAccess(true);
            settings.setGeolocationEnabled(true);
            settings.setDatabaseEnabled(true);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setAppCacheEnabled(false);
            settings.setSupportMultipleWindows(false);
            settings.setLoadsImagesAutomatically(true);
            settings.setAllowContentAccess(false);
            settings.setDatabaseEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
            settings.setSupportZoom(true);
            settings.setAppCachePath(context.getDir("hwebview_appcache", 0).getPath());
            settings.setDatabasePath(context.getDir("hwebview_databases", 0).getPath());
            settings.setGeolocationDatabasePath(context.getDir("hwebview_geolocation", 0).getPath());
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            if (Build.VERSION.SDK_INT >= 26) {
                settings.setSafeBrowsingEnabled(true);
            }
        }
        setWebViewClient(new WebViewClient() { // from class: com.tencent.ams.dsdk.view.webview.DKDefaultWebView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKDefaultWebView.this);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) webView, (Object) str);
                    return;
                }
                super.onPageFinished(webView, str);
                if (DKDefaultWebView.this.mListener != null) {
                    DKDefaultWebView.this.mListener.onPageFinished(str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                JsInjector.getInstance().onPageStarted(webView);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, webView, str, bitmap);
                    return;
                }
                DLog.i(DKDefaultWebView.TAG, "onPageStarted, url: " + str);
                super.onPageStarted(webView, str, bitmap);
                if (DKDefaultWebView.this.mListener != null) {
                    DKDefaultWebView.this.mListener.onPageStart(str);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                int i3;
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, this, webView, webResourceRequest, webResourceError);
                    return;
                }
                Log.d(DKDefaultWebView.TAG, "onReceivedError, request: " + webResourceRequest + ", error: " + webResourceError);
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (DKDefaultWebView.this.mListener != null) {
                    if (webResourceError != null) {
                        i3 = webResourceError.getErrorCode();
                    } else {
                        i3 = -1;
                    }
                    if (webResourceError != null) {
                        str = (String) webResourceError.getDescription();
                    } else {
                        str = "http error.";
                    }
                    DKDefaultWebView.this.mListener.onReceivedError(i3, str);
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) webView, (Object) str)).booleanValue();
                }
                DLog.i(DKDefaultWebView.TAG, "shouldOverrideUrlLoading, url: " + str);
                if (DKDefaultWebView.this.mListener != null && DKDefaultWebView.this.mListener.shouldOverrideUrlLoading(str)) {
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        });
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public void evaluateJavaScript(String str, ValueCallback<String> valueCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) valueCallback);
        } else {
            super.evaluateJavascript(str, valueCallback);
        }
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public View getDKWebView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (View) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this;
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public String getUserAgent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        WebSettings settings = getSettings();
        if (settings != null) {
            return settings.getUserAgentString();
        }
        return null;
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        DLog.i(TAG, "onDestroy " + this);
        this.mListener = null;
        clearHistory();
        destroy();
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onScrollChanged(i3, i16, i17, i18);
        DKWebView.OnScrollChangeListener onScrollChangeListener = this.mOnScrollChangeListener;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScrollChange(i3, i16, i17, i18);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) motionEvent)).booleanValue();
        }
        Boolean bool = this.mIsWebViewScrollEnabledBoolean;
        if (bool != null) {
            requestDisallowInterceptTouchEvent(bool.booleanValue());
            DLog.d(TAG, " onTouchEvent\uff0cset is webView scroll enabled\uff1a" + this.mIsWebViewScrollEnabledBoolean.booleanValue());
        }
        DLog.d(TAG, " onTouchEvent triggered");
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public void registerOnScrollChangedListener(DKWebView.OnScrollChangeListener onScrollChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) onScrollChangeListener);
        } else {
            this.mOnScrollChangeListener = onScrollChangeListener;
        }
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public void registerOnTouchDownListener(DKWebView.OnTouchDownListener onTouchDownListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) onTouchDownListener);
        }
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public void registerWebViewEventListener(DKWebView.DKWebViewEventListener dKWebViewEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) dKWebViewEventListener);
        } else {
            this.mListener = dKWebViewEventListener;
        }
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public void setIsWebViewScrollEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
            return;
        }
        this.mIsWebViewScrollEnabledBoolean = Boolean.valueOf(z16);
        DLog.i(TAG, " setIsWebViewScrollEnabled\uff1a" + z16);
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public void setLaunchMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        }
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public void setUserAgent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        WebSettings settings = getSettings();
        if (settings != null) {
            settings.setUserAgentString(str);
        }
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public void unRegisterOnScrollChangedListener(DKWebView.OnScrollChangeListener onScrollChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) onScrollChangeListener);
        } else {
            this.mOnScrollChangeListener = null;
        }
    }

    @Override // com.tencent.ams.dsdk.view.webview.DKWebView
    public void unRegisterOnTouchDownListener(DKWebView.OnTouchDownListener onTouchDownListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) onTouchDownListener);
        }
    }

    public DKDefaultWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            init(context);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public DKDefaultWebView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            init(context);
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }

    public DKDefaultWebView(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            init(context);
        } else {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public DKDefaultWebView(Context context, AttributeSet attributeSet, int i3, boolean z16) {
        super(context, attributeSet, i3, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            init(context);
        } else {
            iPatchRedirector.redirect((short) 5, this, context, attributeSet, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
    }
}
