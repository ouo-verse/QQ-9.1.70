package com.tencent.mtt.hippy;

import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.List;
import java.util.Map;

/* loaded from: classes20.dex */
public interface HippyAPIProvider {
    List<Class<? extends HippyViewController>> getControllers();

    List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules();

    Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(HippyEngineContext hippyEngineContext);
}
