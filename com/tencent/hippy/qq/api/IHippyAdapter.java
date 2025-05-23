package com.tencent.hippy.qq.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.adapter.HippyLogAdapter;
import com.tencent.mtt.hippy.adapter.device.HippyDeviceAdapter;
import com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter;
import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter;
import com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface IHippyAdapter extends QRouteApi {
    IBaseHttpAdapter createBaseHttpAdapter(boolean z16);

    HippyEngineMonitorAdapter createEngineMonitorAdapter();

    HippyFontScaleAdapter createFontScaleAdapter();

    HippyDeviceAdapter createHippyDeviceAdapter();

    HippyLogAdapter createHippyLogAdapter();

    HippyHttpAdapter createHttpAdapter(IBaseHttpAdapter iBaseHttpAdapter, OpenHippyInfo openHippyInfo);

    HippyImageLoader createImageLoader();

    HippyThirdPartyAdapter createThirdPartyAdapter();

    void saveNodeSnapShotData(HippyThirdPartyAdapter hippyThirdPartyAdapter, JSONObject jSONObject);
}
