package com.tencent.mtt.hippy.modules.nativemodules.network;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

/* compiled from: P */
@HippyNativeModule(name = "network")
/* loaded from: classes20.dex */
public class NetworkModule extends HippyNativeModuleBase {
    public NetworkModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    @HippyMethod(name = "fetch")
    public void fetch(HippyMap hippyMap, Promise promise) {
        HippyHttpAdapter httpAdapter = this.mContext.getGlobalConfigs().getHttpAdapter();
        if (httpAdapter != null) {
            httpAdapter.fetch(hippyMap, promise, this.mContext.getNativeParams());
        }
    }

    @HippyMethod(name = "getCookie")
    public void getCookie(String str, Promise promise) {
        HippyHttpAdapter httpAdapter = this.mContext.getGlobalConfigs().getHttpAdapter();
        if (httpAdapter != null) {
            httpAdapter.getCookie(str, promise);
        }
    }

    @HippyMethod(name = "setCookie")
    public void setCookie(String str, String str2, String str3) {
        HippyHttpAdapter httpAdapter = this.mContext.getGlobalConfigs().getHttpAdapter();
        if (httpAdapter != null) {
            httpAdapter.setCookie(str, str2, str3);
        }
    }
}
