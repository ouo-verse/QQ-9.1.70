package ai0;

import androidx.fragment.app.Fragment;
import com.tencent.ecommerce.biz.hippy.api.IECHippyEngine;
import com.tencent.ecommerce.biz.hippy.api.IECHippyProxy;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ,\u0010\b\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J:\u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u001c"}, d2 = {"Lai0/a;", "Lcom/tencent/ecommerce/biz/hippy/api/IECHippyProxy;", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "context", "", "Ljava/lang/Class;", "Lcom/tencent/mtt/hippy/modules/nativemodules/HippyNativeModuleBase;", "Lcom/tencent/mtt/hippy/common/Provider;", "getPublicModules", "Landroidx/fragment/app/Fragment;", "fragment", "", "moduleName", "hippyUrl", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "provider", "Lcom/tencent/mtt/hippy/uimanager/HippyCustomViewCreator;", "customViewCreator", "", "minModuleVersion", "Lcom/tencent/ecommerce/biz/hippy/api/IECHippyEngine;", "newEngine", "engineId", "getEngine", "", "preloadJsBundle", "<init>", "()V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class a implements IECHippyProxy {
    @Override // com.tencent.ecommerce.biz.hippy.api.IECHippyProxy
    @Nullable
    public IECHippyEngine getEngine(int engineId) {
        return null;
    }

    @Override // com.tencent.ecommerce.biz.hippy.api.IECHippyProxy
    @NotNull
    public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getPublicModules(@NotNull HippyEngineContext context) {
        Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        return emptyMap;
    }

    @Override // com.tencent.ecommerce.biz.hippy.api.IECHippyProxy
    @NotNull
    public IECHippyEngine newEngine(@NotNull Fragment fragment, @NotNull String moduleName, @NotNull String hippyUrl, @NotNull HippyAPIProvider provider, @Nullable HippyCustomViewCreator customViewCreator, int minModuleVersion) {
        return new b(fragment);
    }

    @Override // com.tencent.ecommerce.biz.hippy.api.IECHippyProxy
    public void preloadJsBundle(@NotNull String moduleName) {
    }
}
