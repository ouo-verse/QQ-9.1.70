package com.tencent.qqmini.miniapp.widget;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f346336b;

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, WebView> f346337a = new HashMap();

    public static a b() {
        if (f346336b == null) {
            synchronized (a.class) {
                if (f346336b == null) {
                    f346336b = new a();
                }
            }
        }
        return f346336b;
    }

    public void a() {
        for (WebView webView : this.f346337a.values()) {
            webView.loadUrl("about:blank");
            webView.clearView();
            webView.destroy();
        }
        this.f346337a.clear();
        QMLog.i("InnerWebViewManager", "clearAllWebViewsAndDestroy!");
    }

    public WebView c(int i3) {
        return this.f346337a.get(Integer.valueOf(i3));
    }

    public WebView d(int i3) {
        return this.f346337a.remove(Integer.valueOf(i3));
    }

    public void e(int i3, WebView webView) {
        this.f346337a.put(Integer.valueOf(i3), webView);
    }
}
