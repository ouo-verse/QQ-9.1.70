package com.tencent.luggage.wxa.wq;

import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.XWebSdk;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f144335a;

    /* renamed from: b, reason: collision with root package name */
    public static String f144336b;

    public static void a() {
        f144335a = null;
        f144336b = null;
    }

    public static void b(String str) {
        f144335a = str;
    }

    public static void a(String str) {
        f144336b = str;
    }

    public static void a(boolean z16, boolean z17, boolean z18) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(XWebSdk.getXWebSdkVersion());
        sb5.append(",");
        sb5.append(XWebSdk.getAvailableVersion());
        sb5.append(",");
        sb5.append(z16 ? 1 : 2);
        sb5.append(",");
        sb5.append(z17 ? 1 : 2);
        sb5.append(",");
        sb5.append(z18 ? 1 : 2);
        sb5.append(",");
        String str = f144335a;
        if (str == null) {
            str = "";
        }
        sb5.append(str);
        sb5.append(",");
        String str2 = f144336b;
        sb5.append(str2 != null ? str2 : "");
        String sb6 = sb5.toString();
        x0.d("KVReportForCheckFiles", "report:" + sb6);
        n0.a(24525, sb6);
    }
}
