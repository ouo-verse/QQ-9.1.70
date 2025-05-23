package com.tencent.gdtad.hippy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class GdtApiProvider implements HippyAPIProvider {
    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    @Nullable
    public List<Class<? extends HippyViewController>> getControllers() {
        return null;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    @Nullable
    public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules() {
        return null;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    @NonNull
    public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(final HippyEngineContext hippyEngineContext) {
        HashMap hashMap = new HashMap();
        hashMap.put(GdtTangramModule.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.gdtad.hippy.GdtApiProvider.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.mtt.hippy.common.Provider
            @NonNull
            public HippyNativeModuleBase get() {
                return new GdtTangramModule(hippyEngineContext);
            }
        });
        return hashMap;
    }
}
