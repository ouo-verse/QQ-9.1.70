package com.tencent.mobileqq.triton.lifecycle;

import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "onFirstFrame", "onGameLaunched", EnginePathProvider.ENGINE_DIR, "Lcom/tencent/mobileqq/triton/TritonEngine;", "onStart", DKHippyEvent.EVENT_STOP, "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface LifeCycle {
    void onDestroy();

    void onFirstFrame();

    void onGameLaunched(@NotNull TritonEngine engine);

    void onStart();

    void onStop();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class DefaultImpls {
        public static void onGameLaunched(LifeCycle lifeCycle, @NotNull TritonEngine engine) {
            Intrinsics.checkParameterIsNotNull(engine, "engine");
        }

        public static void onDestroy(LifeCycle lifeCycle) {
        }

        public static void onFirstFrame(LifeCycle lifeCycle) {
        }

        public static void onStart(LifeCycle lifeCycle) {
        }

        public static void onStop(LifeCycle lifeCycle) {
        }
    }
}
