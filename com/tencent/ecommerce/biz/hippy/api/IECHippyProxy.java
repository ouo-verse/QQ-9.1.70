package com.tencent.ecommerce.biz.hippy.api;

import androidx.fragment.app.Fragment;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J,\u0010\u0006\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\n0\u00072\u0006\u0010\u000b\u001a\u00020\fH&J<\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0005H&J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/hippy/api/IECHippyProxy;", "", "getEngine", "Lcom/tencent/ecommerce/biz/hippy/api/IECHippyEngine;", "engineId", "", "getPublicModules", "", "Ljava/lang/Class;", "Lcom/tencent/mtt/hippy/modules/nativemodules/HippyNativeModuleBase;", "Lcom/tencent/mtt/hippy/common/Provider;", "context", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "newEngine", "fragment", "Landroidx/fragment/app/Fragment;", "moduleName", "", "hippyUrl", "provider", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "customViewCreator", "Lcom/tencent/mtt/hippy/uimanager/HippyCustomViewCreator;", "minModuleVersion", "preloadJsBundle", "", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECHippyProxy {
    @Nullable
    IECHippyEngine getEngine(int engineId);

    @NotNull
    Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getPublicModules(@NotNull HippyEngineContext context);

    @NotNull
    IECHippyEngine newEngine(@NotNull Fragment fragment, @NotNull String moduleName, @NotNull String hippyUrl, @NotNull HippyAPIProvider provider, @Nullable HippyCustomViewCreator customViewCreator, int minModuleVersion);

    void preloadJsBundle(@NotNull String moduleName);
}
