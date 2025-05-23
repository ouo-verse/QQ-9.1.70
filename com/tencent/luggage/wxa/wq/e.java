package com.tencent.luggage.wxa.wq;

import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.XWebSdk;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {
    public static void a(int i3, boolean z16, String str, String str2, long j3, long j16, long j17, long j18, long j19, long j26, long j27, long j28) {
        String str3 = XWebSdk.getXWebSdkVersion() + "," + i3 + "," + str + "," + (z16 ? 1 : 0) + "," + str2 + "," + j3 + "," + j16 + "," + j17 + "," + j18 + "," + j19 + "," + j26 + "," + j27 + "," + j28;
        x0.d("KVReportForChildProcessService", "report:" + str3);
        n0.a(26129, str3);
    }
}
