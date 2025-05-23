package com.tencent.mtt.hippy;

import androidx.annotation.Nullable;
import com.tencent.mtt.hippy.a.o;
import com.tencent.mtt.hippy.bridge.a;
import com.tencent.mtt.hippy.common.ThreadExecutor;
import com.tencent.mtt.hippy.dom.b;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.uimanager.RenderManager;
import com.tencent.mtt.hippy.utils.TimeMonitor;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface HippyEngineContext {
    void addApiProviders(List<HippyAPIProvider> list);

    void addEngineLifecycleEventListener(HippyEngineLifecycleEventListener hippyEngineLifecycleEventListener);

    void addInstanceLifecycleEventListener(HippyInstanceLifecycleEventListener hippyInstanceLifecycleEventListener);

    a getBridgeManager();

    String getComponentName();

    o getDevSupportManager();

    b getDomManager();

    IDomOperate getDomOperateInterceptor();

    int getEngineId();

    HippyGlobalConfigs getGlobalConfigs();

    HippyRootView getInstance(int i3);

    HippyModuleManager getModuleManager();

    @Nullable
    Map<String, Object> getNativeParams();

    RenderManager getRenderManager();

    TimeMonitor getStartTimeMonitor();

    ThreadExecutor getThreadExecutor();

    void handleException(Throwable th5);

    boolean isRunningOnTVPlatform();

    void removeEngineLifecycleEventListener(HippyEngineLifecycleEventListener hippyEngineLifecycleEventListener);

    void removeInstanceLifecycleEventListener(HippyInstanceLifecycleEventListener hippyInstanceLifecycleEventListener);
}
