package com.tencent.nativevue.hippy;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.utils.UIThreadUtils;

/* compiled from: P */
@HippyNativeModule(init = true, name = "NativeVueModule")
/* loaded from: classes21.dex */
public class NVHippyModule extends HippyNativeModuleBase {
    private a viewModel;

    public NVHippyModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.viewModel = null;
    }

    @HippyMethod(name = "hideNativeVueView")
    public void hideNativeVueView() {
        UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.nativevue.hippy.NVHippyModule.1
            @Override // java.lang.Runnable
            public void run() {
                if (NVHippyModule.this.viewModel != null) {
                    NVHippyModule.this.viewModel.f();
                    NVHippyModule.this.viewModel = null;
                }
            }
        });
    }

    public void setViewModel(a aVar) {
        this.viewModel = aVar;
    }
}
