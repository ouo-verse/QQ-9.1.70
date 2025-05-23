package com.tencent.luggage.wxa.wq;

import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.XWebSdk;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class k {
    public static void a(int i3, int i16, int i17, int i18, String str) {
        String str2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(XWebSdk.getXWebSdkVersion());
        sb5.append(",");
        sb5.append(XWebSdk.getAvailableVersion());
        sb5.append(",");
        sb5.append(i16);
        sb5.append(",");
        sb5.append(i3);
        sb5.append(",");
        sb5.append(i17);
        sb5.append(",");
        sb5.append(i18);
        sb5.append(",");
        if (str == null) {
            str = "";
        }
        sb5.append(str);
        sb5.append(",");
        sb5.append(CommandCfg.getInstance().getWebViewModeCommandForMM());
        sb5.append(",");
        String str3 = "2";
        if (CommandCfg.getInstance().getDisableChildProcessStartCrashCount()) {
            str2 = "2";
        } else {
            str2 = "1";
        }
        sb5.append(str2);
        sb5.append(",");
        if (!CommandCfg.getInstance().getDisableChildProcessStartTimeOut()) {
            str3 = "1";
        }
        sb5.append(str3);
        sb5.append(",");
        sb5.append(CommandCfg.getInstance().getChildProcessStartTimeOutCount());
        sb5.append(",");
        sb5.append(CommandCfg.getInstance().getChildProcessStartTimeOutThreshold());
        String sb6 = sb5.toString();
        x0.d("KVReportForMultiProcessDowngrade", "report:" + sb6);
        n0.a(26528, sb6);
    }
}
