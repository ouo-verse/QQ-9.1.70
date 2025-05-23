package com.tencent.mobileqq.minigame.minigamecenter.hippy;

import com.tencent.mobileqq.minigame.minigamecenter.hippy.module.MiniAppWadlModule;
import com.tencent.mobileqq.minigame.minigamecenter.hippy.module.MiniGameCenterNativeModule;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0016\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u0018\u00010\u0004H\u0016J\u0018\u0010\u0007\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0005\u0018\u00010\u0004H\u0016J,\u0010\t\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\f0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/minigame/minigamecenter/hippy/MiniGameCenterApiProvider;", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "()V", "getControllers", "", "Ljava/lang/Class;", "Lcom/tencent/mtt/hippy/uimanager/HippyViewController;", "getJavaScriptModules", "Lcom/tencent/mtt/hippy/modules/javascriptmodules/HippyJavaScriptModule;", "getNativeModules", "", "Lcom/tencent/mtt/hippy/modules/nativemodules/HippyNativeModuleBase;", "Lcom/tencent/mtt/hippy/common/Provider;", "hippyEngineContext", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameCenterApiProvider implements HippyAPIProvider {
    /* JADX INFO: Access modifiers changed from: private */
    public static final HippyNativeModuleBase getNativeModules$lambda$0(HippyEngineContext hippyEngineContext) {
        Intrinsics.checkNotNullParameter(hippyEngineContext, "$hippyEngineContext");
        return new MiniGameCenterNativeModule(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HippyNativeModuleBase getNativeModules$lambda$1(HippyEngineContext hippyEngineContext) {
        Intrinsics.checkNotNullParameter(hippyEngineContext, "$hippyEngineContext");
        return new MiniAppWadlModule(hippyEngineContext);
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyViewController<?>>> getControllers() {
        return null;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules() {
        return null;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(final HippyEngineContext hippyEngineContext) {
        Intrinsics.checkNotNullParameter(hippyEngineContext, "hippyEngineContext");
        HashMap hashMap = new HashMap();
        hashMap.put(MiniGameCenterNativeModule.class, new Provider() { // from class: com.tencent.mobileqq.minigame.minigamecenter.hippy.a
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase nativeModules$lambda$0;
                nativeModules$lambda$0 = MiniGameCenterApiProvider.getNativeModules$lambda$0(HippyEngineContext.this);
                return nativeModules$lambda$0;
            }
        });
        hashMap.put(MiniAppWadlModule.class, new Provider() { // from class: com.tencent.mobileqq.minigame.minigamecenter.hippy.b
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase nativeModules$lambda$1;
                nativeModules$lambda$1 = MiniGameCenterApiProvider.getNativeModules$lambda$1(HippyEngineContext.this);
                return nativeModules$lambda$1;
            }
        });
        return hashMap;
    }
}
