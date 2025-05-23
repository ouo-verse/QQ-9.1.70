package com.tencent.luggage.wxa.wq;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.v0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.z;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.WebView;
import com.tencent.xweb.XWebSdk;
import java.net.URLEncoder;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i {
    public static void a(int i3, String str, int i16, int i17, int i18, int i19, String str2, WebView.WebViewKind webViewKind) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(XWebSdk.getXWebSdkVersion());
        sb5.append(",");
        sb5.append(XWebSdk.getAvailableVersion());
        sb5.append(",");
        sb5.append(webViewKind.ordinal());
        sb5.append(",");
        sb5.append(i3);
        sb5.append(",");
        sb5.append(str);
        sb5.append(",");
        sb5.append(z.a(XWalkEnvironment.getApplicationContext()));
        sb5.append(",");
        sb5.append(100);
        sb5.append(",");
        sb5.append(-1);
        sb5.append(",");
        sb5.append(i16);
        sb5.append(",");
        sb5.append(i17);
        sb5.append(",");
        sb5.append(i18);
        sb5.append(",");
        sb5.append(i19);
        sb5.append(",");
        sb5.append(XWalkEnvironment.getApplicationContext().getPackageName());
        sb5.append(",");
        sb5.append(a(URLEncoder.encode(str2)));
        sb5.append(",");
        sb5.append(XWalkEnvironment.getMultiProcessType());
        sb5.append(",");
        sb5.append(XWalkEnvironment.getEnableSandbox() ? 1 : 2);
        sb5.append(",");
        sb5.append(XWalkEnvironment.getProcessName());
        sb5.append(",");
        sb5.append(v0.b());
        sb5.append(",");
        sb5.append(CommandCfg.getInstance().getConfigVersion());
        String sb6 = sb5.toString();
        x0.d("KVReportForLoadUrl", "report:" + sb6);
        if (XWalkEnvironment.getBuildConfigThirdPartyRelease() && CommandCfg.getInstance().getEnableThirdAppReport()) {
            n0.a(10129, sb6);
        } else {
            n0.a(15003, sb6);
        }
    }

    public static String a(String str) {
        return !TextUtils.isEmpty(str) ? str.length() <= 200 ? str : str.substring(0, 200) : "";
    }
}
