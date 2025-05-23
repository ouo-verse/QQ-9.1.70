package com.tencent.luggage.wxa.wq;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.XWebSdk;
import com.tencent.xweb.pinus.sdk.WebView;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class m {
    public static void a(WebView webView, boolean z16, int i3) {
        String str = "";
        int i16 = 0;
        if (webView != null) {
            try {
                String url = webView.getUrl();
                if (url != null) {
                    str = URLEncoder.encode(url, "UTF-8");
                }
                i16 = a(webView);
            } catch (Exception e16) {
                x0.a("KVReportForRenderProcessGone", "report, error", e16);
            }
        }
        String str2 = i16 + "," + (z16 ? 1 : 0) + "," + i3 + "," + str + "," + XWebSdk.getXWebSdkVersion() + "," + XWebSdk.getAvailableVersion();
        x0.d("KVReportForRenderProcessGone", "report:" + str2);
        n0.a(26011, str2);
    }

    public static int a(WebView webView) {
        if (webView == null) {
            return 0;
        }
        Context context = webView.getContext();
        if (context instanceof MutableContextWrapper) {
            context = ((MutableContextWrapper) context).getBaseContext();
        }
        if (context == null) {
            return 0;
        }
        return context instanceof Activity ? 1 : 2;
    }
}
