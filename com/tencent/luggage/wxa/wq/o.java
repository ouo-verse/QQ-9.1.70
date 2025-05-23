package com.tencent.luggage.wxa.wq;

import com.tencent.luggage.wxa.ar.i0;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.v0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.yq.n;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.XWebSdk;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class o {
    public static void a(n.d dVar, String str, String str2) {
        String str3;
        String str4 = str2 + "," + XWebSdk.getXWebSdkVersion() + "," + dVar.f146103c + "," + dVar.f146104d + "," + dVar.f146106f + "," + dVar.f146107g + "," + dVar.f146108h + "," + str;
        if (XWalkEnvironment.getBuildConfigThirdPartyRelease() && CommandCfg.getInstance().getEnableThirdAppReport()) {
            str3 = str4 + "," + XWalkEnvironment.getApplicationContext().getPackageName() + "," + v0.b() + "," + dVar.f146101a;
        } else {
            str3 = str4 + "," + dVar.f146101a + "," + XWalkEnvironment.getApplicationContext().getPackageName() + "," + v0.b();
        }
        String str5 = str3 + "," + dVar.f146110j + "," + dVar.f146111k + "," + dVar.f146113m + "," + dVar.f146112l + "," + dVar.f146114n + "," + i0.getFetchConfigPeriod();
        x0.d("KVReportForUpdateConfig", "report:" + str5);
        if (XWalkEnvironment.getBuildConfigThirdPartyRelease() && CommandCfg.getInstance().getEnableThirdAppReport()) {
            n0.a(10124, str5);
        } else {
            n0.a(15123, str5);
        }
    }
}
