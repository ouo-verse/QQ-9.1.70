package com.tencent.hippy.qq.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface IHippyModules extends QRouteApi {
    Object createQQBridgeModule(HippyEngineContext hippyEngineContext);

    Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getDebugModules(HippyEngineContext hippyEngineContext);

    Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getReleaseModules(HippyEngineContext hippyEngineContext);
}
