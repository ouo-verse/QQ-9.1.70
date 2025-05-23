package com.tencent.ams.dsdk.view.webview;

import android.view.View;
import android.webkit.ValueCallback;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface DKWebView {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface DKWebViewEventListener {
        void onPageFinished(String str);

        void onPageStart(String str);

        void onReceivedError(int i3, String str);

        boolean shouldOverrideUrlLoading(String str);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface OnScrollChangeListener {
        void onScrollChange(int i3, int i16, int i17, int i18);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface OnTouchDownListener {
        void onTouchDown(float f16, float f17);
    }

    void addJavascriptInterface(Object obj, String str);

    boolean canGoBack();

    boolean canGoForward();

    void evaluateJavaScript(String str, ValueCallback<String> valueCallback);

    View getDKWebView();

    String getUserAgent();

    void goBack();

    void goForward();

    void loadUrl(String str);

    void onDestroy();

    void registerOnScrollChangedListener(OnScrollChangeListener onScrollChangeListener);

    void registerOnTouchDownListener(OnTouchDownListener onTouchDownListener);

    void registerWebViewEventListener(DKWebViewEventListener dKWebViewEventListener);

    void reload();

    void setIsWebViewScrollEnabled(boolean z16);

    void setLaunchMode(int i3);

    void setUserAgent(String str);

    void stopLoading();

    void unRegisterOnScrollChangedListener(OnScrollChangeListener onScrollChangeListener);

    void unRegisterOnTouchDownListener(OnTouchDownListener onTouchDownListener);
}
