package bj2;

import com.tencent.mobileqq.qqnews.hippy.module.QQNewsHippyModule;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\b\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00070\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u000b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\n0\u0005\u0018\u00010\tH\u0016J\u0018\u0010\r\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0005\u0018\u00010\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lbj2/b;", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "context", "", "Ljava/lang/Class;", "Lcom/tencent/mtt/hippy/modules/nativemodules/HippyNativeModuleBase;", "Lcom/tencent/mtt/hippy/common/Provider;", "getNativeModules", "", "Lcom/tencent/mtt/hippy/uimanager/HippyViewController;", "getControllers", "Lcom/tencent/mtt/hippy/modules/javascriptmodules/HippyJavaScriptModule;", "getJavaScriptModules", "<init>", "()V", "qqnews-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b implements HippyAPIProvider {
    /* JADX INFO: Access modifiers changed from: private */
    public static final HippyNativeModuleBase b(HippyEngineContext hippyEngineContext) {
        return new QQNewsHippyModule(hippyEngineContext);
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    @Nullable
    public List<Class<? extends HippyViewController<?>>> getControllers() {
        return null;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    @Nullable
    public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules() {
        return null;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    @NotNull
    public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(@Nullable final HippyEngineContext context) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(QQNewsHippyModule.class, new Provider() { // from class: bj2.a
            @Override // com.tencent.mtt.hippy.common.Provider
            public final Object get() {
                HippyNativeModuleBase b16;
                b16 = b.b(HippyEngineContext.this);
                return b16;
            }
        });
        return linkedHashMap;
    }
}
