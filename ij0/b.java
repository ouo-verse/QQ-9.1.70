package ij0;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.biz.taskcenter.hippy.module.ECBizModule;
import com.tencent.ecommerce.biz.taskcenter.hippy.module.ECOpenTelemetryModule;
import com.tencent.ecommerce.biz.taskcenter.hippy.module.QQUiModule;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b implements HippyAPIProvider {

    /* renamed from: a, reason: collision with root package name */
    private final String f407797a;

    public b(String str) {
        this.f407797a = str;
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
        HashMap hashMap = new HashMap();
        hashMap.put(ECBizModule.class, new ECBizModule(hippyEngineContext));
        hashMap.put(QQUiModule.class, new QQUiModule(hippyEngineContext));
        hashMap.put(ECOpenTelemetryModule.class, new ECOpenTelemetryModule(hippyEngineContext, this.f407797a));
        HashMap hashMap2 = new HashMap(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getHippyProxy().getPublicModules(hippyEngineContext));
        for (final Map.Entry entry : hashMap.entrySet()) {
            hashMap2.put(entry.getKey(), new Provider() { // from class: ij0.a
                @Override // com.tencent.mtt.hippy.common.Provider
                public final Object get() {
                    return (HippyNativeModuleBase) entry.getValue();
                }
            });
        }
        return hashMap2;
    }
}
