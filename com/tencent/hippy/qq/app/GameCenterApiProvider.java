package com.tencent.hippy.qq.app;

import com.tencent.hippy.qq.module.gamecenter.QQGameCenterModule;
import com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoViewController;
import com.tencent.mobileqq.gamecenter.hippy.view.GpImageViewController;
import com.tencent.mobileqq.gamecenter.hippy.view.GpTextViewController;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.javascriptmodules.HippyJavaScriptModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class GameCenterApiProvider implements HippyAPIProvider {
    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyViewController>> getControllers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(GameCenterVideoViewController.class);
        arrayList.add(GpImageViewController.class);
        arrayList.add(GpTextViewController.class);
        return arrayList;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public List<Class<? extends HippyJavaScriptModule>> getJavaScriptModules() {
        return null;
    }

    @Override // com.tencent.mtt.hippy.HippyAPIProvider
    public Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> getNativeModules(final HippyEngineContext hippyEngineContext) {
        HashMap hashMap = new HashMap();
        hashMap.put(QQGameCenterModule.class, new Provider<HippyNativeModuleBase>() { // from class: com.tencent.hippy.qq.app.GameCenterApiProvider.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.mtt.hippy.common.Provider
            public HippyNativeModuleBase get() {
                return new QQGameCenterModule(hippyEngineContext);
            }
        });
        return hashMap;
    }
}
