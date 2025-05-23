package com.tencent.hippy.qq.interpolators;

import com.tencent.hippy.qq.api.HippyInterpolator;
import com.tencent.hippy.qq.api.ISSRBundleRequester;
import com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MetaDreamInterpolator extends HippyInterpolator {
    @Override // com.tencent.hippy.qq.api.HippyInterpolator
    public JSONObject getBusinessData() {
        return ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).getHippyBusinessData();
    }

    @Override // com.tencent.hippy.qq.api.HippyInterpolator
    public HashMap<String, Long> getPerformanceData() {
        return ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).getPerformanceData();
    }

    @Override // com.tencent.hippy.qq.api.HippyInterpolator
    public ISSRBundleRequester getSSRBundleRequester() {
        return (ISSRBundleRequester) ((IMetaDreamApi) QRoute.api(IMetaDreamApi.class)).getSSRBundleRequester();
    }
}
