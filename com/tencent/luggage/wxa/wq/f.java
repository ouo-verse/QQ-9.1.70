package com.tencent.luggage.wxa.wq;

import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.WebView;
import com.tencent.xweb.XWebSdk;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {
    public static void a(int i3, String str, int i16) {
        a(i3, str, i16, "");
    }

    public static void a(int i3, String str, int i16, String str2) {
        String str3 = XWebSdk.getXWebSdkVersion() + "," + XWebSdk.getAvailableVersion() + "," + i16 + "," + WebView.getModuleName() + "," + i3 + "," + a(str) + "," + a(str2);
        x0.d("KVReportForCrash", "report:" + str3);
        n0.a(25407, str3);
    }

    public static String a(String str) {
        return str.replaceAll(",", " ");
    }
}
