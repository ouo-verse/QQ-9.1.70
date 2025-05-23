package com.tencent.ams.dsdk.core.hippy;

import android.view.ViewGroup;
import com.tencent.ams.dsdk.core.hippy.DKHippyEngine;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.mtt.hippy.common.HippyJsException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKHippyEngineHelper {
    public static void destroyEngine(DKHippyEngine dKHippyEngine, ViewGroup viewGroup) {
        HippyEngine hippyEngine;
        if (dKHippyEngine == null) {
            hippyEngine = null;
        } else {
            hippyEngine = dKHippyEngine.getHippyEngine();
        }
        if (hippyEngine != null) {
            if (viewGroup instanceof HippyRootView) {
                hippyEngine.destroyModule((HippyRootView) viewGroup);
            }
            DKEngineInstanceManager.removeEngine(dKHippyEngine);
            hippyEngine.destroyEngine();
        }
    }

    public static int getEngineId(HippyEngine hippyEngine) {
        if (hippyEngine == null) {
            return -1;
        }
        return hippyEngine.getId();
    }

    public static ViewGroup loadModule(HippyEngine hippyEngine, HippyEngine.ModuleLoadParams moduleLoadParams, final DKHippyEngine.CreateHippyViewListener createHippyViewListener) {
        if (hippyEngine != null && moduleLoadParams != null && createHippyViewListener != null) {
            return hippyEngine.loadModule(moduleLoadParams, new HippyEngine.ModuleListener() { // from class: com.tencent.ams.dsdk.core.hippy.DKHippyEngineHelper.1
                @Override // com.tencent.mtt.hippy.HippyEngine.ModuleListener
                public boolean onJsException(HippyJsException hippyJsException) {
                    DKHippyEngine.CreateHippyViewListener.this.onJsException(hippyJsException);
                    return false;
                }

                @Override // com.tencent.mtt.hippy.HippyEngine.ModuleListener
                public void onLoadCompleted(HippyEngine.ModuleLoadStatus moduleLoadStatus, String str, HippyRootView hippyRootView) {
                    DKHippyEngine.CreateHippyViewListener.this.onLoadCompleted(moduleLoadStatus, str);
                }
            }, new HippyRootView.OnLoadCompleteListener() { // from class: com.tencent.ams.dsdk.core.hippy.DKHippyEngineHelper.2
                @Override // com.tencent.mtt.hippy.HippyRootView.OnLoadCompleteListener
                public void onLoadComplete(int i3, List<HippyEngineMonitorEvent> list) {
                    DKHippyEngine.CreateHippyViewListener.this.onFirstViewAdded();
                }
            });
        }
        return null;
    }

    public static void mergeInitParams(HippyEngine.EngineInitParams engineInitParams, HippyEngine.EngineInitParams engineInitParams2) {
        if (engineInitParams2 != null && engineInitParams != null) {
            HippyImageLoader hippyImageLoader = engineInitParams2.imageLoader;
            if (hippyImageLoader != null) {
                engineInitParams.imageLoader = hippyImageLoader;
            }
            List<HippyAPIProvider> list = engineInitParams2.providers;
            if (list != null && list.size() > 0) {
                if (engineInitParams.providers == null) {
                    engineInitParams.providers = new ArrayList();
                }
                engineInitParams.providers.addAll(engineInitParams2.providers);
            }
        }
    }
}
