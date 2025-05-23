package com.tencent.intervideo.nowproxy;

import android.app.Activity;
import android.webkit.WebView;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface WebCallHandler {
    void getCookieInfo(NowCookieEvent nowCookieEvent);

    boolean onCallScheme(String str);

    void onWebPageReady(Activity activity, WebView webView);
}
