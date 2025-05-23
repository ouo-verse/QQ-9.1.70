package com.tencent.luggage.wxa.wq;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.WebView;
import com.tencent.xweb.XWebSdk;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class q {
    public static int a(WebView.WebViewKind webViewKind) {
        if (webViewKind == WebView.WebViewKind.WV_KIND_SYS) {
            return 1;
        }
        if (webViewKind == WebView.WebViewKind.WV_KIND_CW) {
            return 3;
        }
        return webViewKind == WebView.WebViewKind.WV_KIND_PINUS ? 4 : 0;
    }

    public static void a(WebView.WebViewKind webViewKind, int i3, int i16, boolean z16, String str) {
        int a16 = a(webViewKind);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(XWebSdk.getAvailableVersion());
        sb5.append(",");
        sb5.append(XWebSdk.getXWebSdkVersion());
        sb5.append(",");
        sb5.append(a16);
        sb5.append(",");
        sb5.append(i3);
        sb5.append(",");
        sb5.append(i16);
        sb5.append(",");
        sb5.append(z16 ? 1 : 0);
        sb5.append(",");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sb5.append(str);
        String sb6 = sb5.toString();
        x0.d("KVReportForVideoFullscreen", "report:" + sb6);
        n0.a(24151, sb6);
    }
}
