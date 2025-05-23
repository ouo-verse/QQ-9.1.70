package com.qq.e.comm.pi;

import android.view.View;
import android.webkit.ValueCallback;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface ITGWebView extends TangramWidget {
    void bindAdData(String str, String str2);

    boolean canGoBack();

    void create();

    void destroySafely();

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    View getView();

    void goBack();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void pauseTimers();

    void reload();

    void resumeTimers();

    void setInnerWebViewListener(TGWebViewListener tGWebViewListener);
}
