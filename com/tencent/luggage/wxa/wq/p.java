package com.tencent.luggage.wxa.wq;

import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.XWebSdk;
import java.net.URLEncoder;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class p {
    public static void a(String str, int i3) {
        String str2 = XWebSdk.getXWebSdkVersion() + "," + XWebSdk.getAvailableVersion() + "," + XWalkEnvironment.getApplicationContext().getPackageName() + "," + i3 + "," + URLEncoder.encode(str);
        x0.d("KVReportForUrlDispatch", "report:" + str2);
        n0.a(26621, str2);
    }
}
