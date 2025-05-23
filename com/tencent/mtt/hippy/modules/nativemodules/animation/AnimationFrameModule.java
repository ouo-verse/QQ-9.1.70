package com.tencent.mtt.hippy.modules.nativemodules.animation;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.dom.e;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

/* compiled from: P */
@HippyNativeModule(name = "AnimationFrameModule", thread = HippyNativeModule.Thread.MAIN)
/* loaded from: classes20.dex */
public class AnimationFrameModule extends HippyNativeModuleBase {
    public AnimationFrameModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    @HippyMethod(name = "requestAnimationFrame")
    public void requestAnimationFrame(final Promise promise) {
        com.tencent.mtt.hippy.dom.f.a().a(new e.a() { // from class: com.tencent.mtt.hippy.modules.nativemodules.animation.AnimationFrameModule.1
            @Override // com.tencent.mtt.hippy.dom.e.a
            public void a(long j3) {
                Promise promise2 = promise;
                if (promise2 != null) {
                    promise2.resolve(null);
                }
            }
        });
    }
}
