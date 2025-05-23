package com.tencent.hippy.qq.interpolators;

import com.tencent.hippy.qq.api.HippyInterpolator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.hippy.api.IZplanVasHippyApi;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ZplanVasSmallHomeInterpolator extends HippyInterpolator {
    @Override // com.tencent.hippy.qq.api.HippyInterpolator
    public JSONObject getBusinessData() {
        return ((IZplanVasHippyApi) QRoute.api(IZplanVasHippyApi.class)).getBusinessData();
    }
}
