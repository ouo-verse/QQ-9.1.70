package com.tencent.luggage.wxa.wq;

import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.XWebSdk;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {
    public static void a(int i3, boolean z16, String str, int i16, String str2, String str3) {
        String str4 = XWebSdk.getXWebSdkVersion() + "," + i3 + "," + str + "," + (z16 ? 1 : 0) + "," + i16 + "," + str2 + "," + a(str3);
        x0.d("KVReportForChildProcessException", "report:" + str4);
        n0.a(26120, str4);
    }

    public static String a(String str) {
        return str.replaceAll(",", " ");
    }
}
