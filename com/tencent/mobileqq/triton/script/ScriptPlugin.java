package com.tencent.mobileqq.triton.script;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "onCall", "", AdMetricTag.EVENT_NAME, "arguments", "Lcom/tencent/mobileqq/triton/script/Argument;", "onCreate", "", EnginePathProvider.ENGINE_DIR, "Lcom/tencent/mobileqq/triton/TritonEngine;", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface ScriptPlugin extends LifeCycle {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class DefaultImpls {
        public static void onCreate(ScriptPlugin scriptPlugin, @NotNull TritonEngine engine) {
            Intrinsics.checkParameterIsNotNull(engine, "engine");
        }

        public static void onDestroy(ScriptPlugin scriptPlugin) {
            LifeCycle.DefaultImpls.onDestroy(scriptPlugin);
        }

        public static void onFirstFrame(ScriptPlugin scriptPlugin) {
            LifeCycle.DefaultImpls.onFirstFrame(scriptPlugin);
        }

        public static void onGameLaunched(ScriptPlugin scriptPlugin, @NotNull TritonEngine engine) {
            Intrinsics.checkParameterIsNotNull(engine, "engine");
            LifeCycle.DefaultImpls.onGameLaunched(scriptPlugin, engine);
        }

        public static void onStart(ScriptPlugin scriptPlugin) {
            LifeCycle.DefaultImpls.onStart(scriptPlugin);
        }

        public static void onStop(ScriptPlugin scriptPlugin) {
            LifeCycle.DefaultImpls.onStop(scriptPlugin);
        }
    }

    @Nullable
    String onCall(@NotNull String eventName, @NotNull Argument arguments) throws IllegalArgumentException;

    void onCreate(@NotNull TritonEngine engine);
}
