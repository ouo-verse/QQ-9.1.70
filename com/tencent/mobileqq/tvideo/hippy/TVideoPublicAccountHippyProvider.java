package com.tencent.mobileqq.tvideo.hippy;

import com.tencent.mobileqq.tvideo.hippy.TVideoPublicAccountHippyProvider;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes19.dex */
public class TVideoPublicAccountHippyProvider implements HippyAPIProvider {

    /* renamed from: com.tencent.mobileqq.tvideo.hippy.TVideoPublicAccountHippyProvider$1, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass1 extends HashMap<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> {
        final /* synthetic */ HippyEngineContext val$hippyEngineContext;

        AnonymousClass1(final HippyEngineContext hippyEngineContext) {
            this.val$hippyEngineContext = hippyEngineContext;
            put(TVideoPublicAccountHippyModule.class, new Provider() { // from class: com.tencent.mobileqq.tvideo.hippy.b
                @Override // com.tencent.mtt.hippy.common.Provider
                public final Object get() {
                    HippyNativeModuleBase d16;
                    d16 = TVideoPublicAccountHippyProvider.AnonymousClass1.d(HippyEngineContext.this);
                    return d16;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ HippyNativeModuleBase d(HippyEngineContext hippyEngineContext) {
            return new TVideoPublicAccountHippyModule(hippyEngineContext);
        }
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyViewController>> getControllers() {
        return null;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules() {
        return null;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(HippyEngineContext hippyEngineContext) {
        return new AnonymousClass1(hippyEngineContext);
    }
}
