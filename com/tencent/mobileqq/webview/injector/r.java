package com.tencent.mobileqq.webview.injector;

import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes35.dex */
public class r implements com.tencent.mobileqq.webprocess.a {
    @Override // com.tencent.mobileqq.webprocess.a
    public String a() {
        return ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.WebViewFeature.name(), "");
    }

    @Override // com.tencent.mobileqq.webprocess.a
    public String b() {
        return ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.WebViewConfig.name(), "");
    }

    @Override // com.tencent.mobileqq.webprocess.a
    public String c() {
        return ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.tbs_switch.name(), "1|1|0|1|0|0");
    }

    @Override // com.tencent.mobileqq.webprocess.a
    public String d() {
        return ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.RemoveSessionConfig.name());
    }

    @Override // com.tencent.mobileqq.webprocess.a
    public int parseComplexParamsByStringToIntParser(String str, Integer[] numArr) {
        return ((IDPCApi) QRoute.api(IDPCApi.class)).parseComplexParamsByStringToIntParser(str, numArr);
    }
}
