package com.tencent.comic.hippy.api;

import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes32.dex */
public abstract class HippyApiProviderWrapper implements HippyAPIProvider {
    protected HippyAPIProvider mProviderImp;

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyViewController>> getControllers() {
        initProviderImp();
        HippyAPIProvider hippyAPIProvider = this.mProviderImp;
        List<Class<? extends HippyViewController>> controllers = hippyAPIProvider != null ? hippyAPIProvider.getControllers() : null;
        return controllers == null ? new ArrayList() : controllers;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules() {
        initProviderImp();
        HippyAPIProvider hippyAPIProvider = this.mProviderImp;
        if (hippyAPIProvider != null) {
            return hippyAPIProvider.getJavaScriptModules();
        }
        return null;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(HippyEngineContext hippyEngineContext) {
        initProviderImp();
        HippyAPIProvider hippyAPIProvider = this.mProviderImp;
        if (hippyAPIProvider != null) {
            return hippyAPIProvider.getNativeModules(hippyEngineContext);
        }
        return null;
    }

    protected abstract void initProviderImp();
}
