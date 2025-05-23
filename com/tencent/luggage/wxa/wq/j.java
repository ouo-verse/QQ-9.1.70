package com.tencent.luggage.wxa.wq;

import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.XWebSdk;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j {
    public static void a() {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(XWebSdk.getXWebSdkVersion());
        sb5.append(",");
        sb5.append(XWalkEnvironment.getAvailableVersion());
        sb5.append(",");
        sb5.append(XWalkEnvironment.getProcessName());
        sb5.append(",");
        sb5.append(XWalkEnvironment.getPackageName());
        sb5.append(",");
        sb5.append(XWalkEnvironment.getMultiProcessType());
        sb5.append(",");
        if (XWalkEnvironment.getEnableSandbox()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        sb5.append(i3);
        sb5.append(",");
        sb5.append(XWebSdk.getWebViewModeCommandForMM().ordinal());
        sb5.append(",");
        sb5.append(0);
        sb5.append(",");
        sb5.append(CommandCfg.getInstance().getConfigVersion());
        String sb6 = sb5.toString();
        x0.d("KVReportForMultiProcess", "report:" + sb6);
        n0.a(26290, sb6);
    }
}
