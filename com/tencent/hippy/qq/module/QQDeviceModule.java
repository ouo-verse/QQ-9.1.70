package com.tencent.hippy.qq.module;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.hippy.qq.utils.DeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasReaderApi;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;

/* compiled from: P */
@HippyNativeModule(name = QQDeviceModule.CLASSNAME)
/* loaded from: classes7.dex */
public class QQDeviceModule extends QQBaseModule {
    static final String CLASSNAME = "QQDeviceModule";
    static final int NETWORK_TYPE_5G = 5;

    public QQDeviceModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    @HippyMethod(name = "getClientInfo")
    public void getClientInfo(Promise promise) {
        promise.resolve(DeviceInfoUtils.getClientInfo());
    }

    @HippyMethod(name = "getDeviceBrightness")
    public void getDeviceBrightness(Promise promise) {
        promise.resolve(Float.valueOf(((IVasReaderApi) QRoute.api(IVasReaderApi.class)).getDeviceBrightness(getActivity())));
    }

    @HippyMethod(name = "getDeviceInfo")
    public void getDeviceInfo(Promise promise) {
        promise.resolve(DeviceInfoUtils.getDeviceInfo());
    }

    @HippyMethod(name = "getGdtDeviceInfo")
    public void getGdtDeviceInfo(HippyMap hippyMap, Promise promise) {
        promise.resolve(DeviceInfoUtils.getGdtDeviceInfo(hippyMap));
    }

    @HippyMethod(name = "getNetworkType")
    public void getNetworkType(Promise promise) {
        int netWorkTypeContain5G = HttpUtil.getNetWorkTypeContain5G();
        if (netWorkTypeContain5G != 6) {
            promise.resolve(Integer.valueOf(netWorkTypeContain5G));
        } else {
            promise.resolve(5);
        }
    }

    @HippyMethod(name = "setDeviceBrightness")
    public void setDeviceBrightness(float f16, Promise promise) {
        promise.resolve(Integer.valueOf(((IVasReaderApi) QRoute.api(IVasReaderApi.class)).setDeviceBrightness(getActivity(), f16)));
    }
}
