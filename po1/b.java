package po1;

import com.tencent.mobileqq.guild.hippy.GuildHippyUIModule;
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
/* loaded from: classes13.dex */
public class b implements HippyAPIProvider {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase b(HippyEngineContext hippyEngineContext) {
        return new GuildHippyUIModule(hippyEngineContext);
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
    public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(final HippyEngineContext hippyEngineContext) {
        HashMap hashMap = new HashMap();
        hashMap.put(GuildHippyUIModule.class, new Provider() { // from class: po1.a
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase b16;
                b16 = b.b(HippyEngineContext.this);
                return b16;
            }
        });
        return hashMap;
    }
}
