package com.tencent.ams.mosaic.jsengine.component.webview;

import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface WebViewComponent {
    void canGoBack(JSFunction jSFunction);

    void canGoForward(JSFunction jSFunction);

    void evaluateJavaScript(String str, JSFunction jSFunction);

    void getUserAgent(JSFunction jSFunction);

    void goBack();

    void goForward();

    void loadUrlWithString(String str);

    void platformViewEvent(JSFunction jSFunction);

    void reload();

    void setScrollChangeNotiDurationMS(long j3);

    void setScrollEnabled(boolean z16);

    void setUserAgent(String str);

    void stopLoading();
}
