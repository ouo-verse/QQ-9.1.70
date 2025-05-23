package po4;

import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.timi.game.web.business.impl.plugin.ESportsModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class k implements HippyAPIProvider {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements Provider<HippyNativeModuleBase> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HippyEngineContext f426649a;

        a(HippyEngineContext hippyEngineContext) {
            this.f426649a = hippyEngineContext;
        }

        @Override // com.tencent.mtt.hippy.common.Provider
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HippyNativeModuleBase get() {
            return new ESportsModule(this.f426649a);
        }
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyViewController>> getControllers() {
        return new ArrayList();
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules() {
        return null;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(HippyEngineContext hippyEngineContext) {
        HashMap hashMap = new HashMap();
        hashMap.put(ESportsModule.class, new a(hippyEngineContext));
        return hashMap;
    }
}
