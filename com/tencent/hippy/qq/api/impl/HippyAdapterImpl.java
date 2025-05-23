package com.tencent.hippy.qq.api.impl;

import com.tencent.hippy.qq.adapter.HippyQQDeviceAdapter;
import com.tencent.hippy.qq.adapter.HippyQQEngineMonitorAdapter;
import com.tencent.hippy.qq.adapter.HippyQQFontAdapter;
import com.tencent.hippy.qq.adapter.HippyQQHttpAdapter;
import com.tencent.hippy.qq.adapter.HippyQQImageLoader;
import com.tencent.hippy.qq.adapter.HippyQQLogAdapter;
import com.tencent.hippy.qq.adapter.HippyQQNewHttpAdapter;
import com.tencent.hippy.qq.adapter.HippyQQThirdPartyAdapter;
import com.tencent.hippy.qq.api.IBaseHttpAdapter;
import com.tencent.hippy.qq.api.IHippyAdapter;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.IBaseHttpAdapterFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.mtt.hippy.adapter.HippyLogAdapter;
import com.tencent.mtt.hippy.adapter.device.HippyDeviceAdapter;
import com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter;
import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter;
import com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyAdapterImpl implements IHippyAdapter {
    private static final String TAG = "HippyAdapterImpl";

    @Override // com.tencent.hippy.qq.api.IHippyAdapter
    public IBaseHttpAdapter createBaseHttpAdapter(boolean z16) {
        return ((IBaseHttpAdapterFactory) QRoute.api(IBaseHttpAdapterFactory.class)).create(z16);
    }

    @Override // com.tencent.hippy.qq.api.IHippyAdapter
    public HippyEngineMonitorAdapter createEngineMonitorAdapter() {
        return new HippyQQEngineMonitorAdapter();
    }

    @Override // com.tencent.hippy.qq.api.IHippyAdapter
    public HippyFontScaleAdapter createFontScaleAdapter() {
        return new HippyQQFontAdapter();
    }

    @Override // com.tencent.hippy.qq.api.IHippyAdapter
    public HippyDeviceAdapter createHippyDeviceAdapter() {
        return new HippyQQDeviceAdapter();
    }

    @Override // com.tencent.hippy.qq.api.IHippyAdapter
    public HippyLogAdapter createHippyLogAdapter() {
        return new HippyQQLogAdapter();
    }

    @Override // com.tencent.hippy.qq.api.IHippyAdapter
    public HippyHttpAdapter createHttpAdapter(IBaseHttpAdapter iBaseHttpAdapter, OpenHippyInfo openHippyInfo) {
        if (((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).isSwitchOn(IGameCenterUnitedConfigApi.HIPPY_USE_CUSTOM_COOKIE_MANAGER, true)) {
            QLog.i(TAG, 1, "createHttpAdapter use new http adapter");
            return new HippyQQNewHttpAdapter(iBaseHttpAdapter, openHippyInfo);
        }
        QLog.i(TAG, 1, "createHttpAdapter use old http adapter");
        return new HippyQQHttpAdapter(iBaseHttpAdapter, openHippyInfo);
    }

    @Override // com.tencent.hippy.qq.api.IHippyAdapter
    public HippyImageLoader createImageLoader() {
        return new HippyQQImageLoader();
    }

    @Override // com.tencent.hippy.qq.api.IHippyAdapter
    public HippyThirdPartyAdapter createThirdPartyAdapter() {
        return new HippyQQThirdPartyAdapter();
    }

    @Override // com.tencent.hippy.qq.api.IHippyAdapter
    public void saveNodeSnapShotData(HippyThirdPartyAdapter hippyThirdPartyAdapter, JSONObject jSONObject) {
        if ((hippyThirdPartyAdapter instanceof HippyQQThirdPartyAdapter) && jSONObject != null) {
            ((HippyQQThirdPartyAdapter) hippyThirdPartyAdapter).initSnapShotData(jSONObject);
        }
    }
}
