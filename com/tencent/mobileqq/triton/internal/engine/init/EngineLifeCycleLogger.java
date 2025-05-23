package com.tencent.mobileqq.triton.internal.engine.init;

import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/engine/init/EngineLifeCycleLogger;", "Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "()V", "TAG", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "onFirstFrame", "onGameLaunched", EnginePathProvider.ENGINE_DIR, "Lcom/tencent/mobileqq/triton/TritonEngine;", "onStart", DKHippyEvent.EVENT_STOP, "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
final class EngineLifeCycleLogger implements LifeCycle {
    public static final EngineLifeCycleLogger INSTANCE = new EngineLifeCycleLogger();
    private static final String TAG = "TritonLifeCycle";

    EngineLifeCycleLogger() {
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onDestroy() {
        Logger.v$default(TAG, "onDestroy()", null, 4, null);
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onFirstFrame() {
        Logger.v$default(TAG, "onFirstFrame()", null, 4, null);
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onGameLaunched(@NotNull TritonEngine engine) {
        Intrinsics.checkParameterIsNotNull(engine, "engine");
        Logger.v$default(TAG, "onGameLaunched() called with: engine = " + engine, null, 4, null);
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onStart() {
        Logger.v$default(TAG, "onStart()", null, 4, null);
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onStop() {
        Logger.v$default(TAG, "onStop()", null, 4, null);
    }
}
