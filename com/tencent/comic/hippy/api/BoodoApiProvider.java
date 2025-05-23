package com.tencent.comic.hippy.api;

import com.tencent.comic.hippy.module.BoodoModule;
import com.tencent.comic.hippy.module.QQGdtModule;
import com.tencent.comic.hippy.view.QQHippyWebViewController;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes32.dex */
public class BoodoApiProvider extends HippyApiProviderWrapper {
    private static final String TAG = "BoodoApiProviderWrapper";

    @Override // com.tencent.comic.hippy.api.HippyApiProviderWrapper, com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyViewController>> getControllers() {
        List<Class<? extends HippyViewController>> controllers = super.getControllers();
        if (controllers == null) {
            controllers = new ArrayList<>();
        }
        controllers.add(QQHippyWebViewController.class);
        return controllers;
    }

    @Override // com.tencent.comic.hippy.api.HippyApiProviderWrapper, com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules() {
        return super.getJavaScriptModules();
    }

    @Override // com.tencent.comic.hippy.api.HippyApiProviderWrapper, com.tencent.mtt.hippy.HippyAPIProvider
    public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(final HippyEngineContext hippyEngineContext) {
        Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> nativeModules = super.getNativeModules(hippyEngineContext);
        if (nativeModules == null) {
            nativeModules = new HashMap<>();
        }
        nativeModules.put(BoodoModule.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.comic.hippy.api.BoodoApiProvider.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.mtt.hippy.common.Provider
            public HippyNativeModuleBase get() {
                return new BoodoModule(hippyEngineContext);
            }
        });
        nativeModules.put(QQGdtModule.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.comic.hippy.api.BoodoApiProvider.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.mtt.hippy.common.Provider
            public HippyNativeModuleBase get() {
                return new QQGdtModule(hippyEngineContext);
            }
        });
        return nativeModules;
    }

    @Override // com.tencent.comic.hippy.api.HippyApiProviderWrapper
    protected void initProviderImp() {
    }
}
