package cooperation.vip.ad;

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
/* loaded from: classes28.dex */
public class f implements HippyAPIProvider {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements Provider<HippyNativeModuleBase> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HippyEngineContext f391160a;

        a(HippyEngineContext hippyEngineContext) {
            this.f391160a = hippyEngineContext;
        }

        @Override // com.tencent.mtt.hippy.common.Provider
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HippyNativeModuleBase get() {
            return new QQVASGuideHippyModule(this.f391160a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class b implements Provider<HippyNativeModuleBase> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HippyEngineContext f391162a;

        b(HippyEngineContext hippyEngineContext) {
            this.f391162a = hippyEngineContext;
        }

        @Override // com.tencent.mtt.hippy.common.Provider
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HippyNativeModuleBase get() {
            return new QQVASHippySSOModule(this.f391162a);
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
        HashMap hashMap = new HashMap();
        hashMap.put(QQVASGuideHippyModule.class, new a(hippyEngineContext));
        hashMap.put(QQVASHippySSOModule.class, new b(hippyEngineContext));
        return hashMap;
    }
}
