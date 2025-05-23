package com.tencent.mobileqq.triton.script;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.script.ScriptPlugin;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/triton/script/ComposableScriptPlugin;", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "supportedEvents", "", "", "getSupportedEvents", "()Ljava/util/Set;", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface ComposableScriptPlugin extends ScriptPlugin {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class DefaultImpls {
        public static void onCreate(ComposableScriptPlugin composableScriptPlugin, @NotNull TritonEngine engine) {
            Intrinsics.checkParameterIsNotNull(engine, "engine");
            ScriptPlugin.DefaultImpls.onCreate(composableScriptPlugin, engine);
        }

        public static void onDestroy(ComposableScriptPlugin composableScriptPlugin) {
            ScriptPlugin.DefaultImpls.onDestroy(composableScriptPlugin);
        }

        public static void onFirstFrame(ComposableScriptPlugin composableScriptPlugin) {
            ScriptPlugin.DefaultImpls.onFirstFrame(composableScriptPlugin);
        }

        public static void onGameLaunched(ComposableScriptPlugin composableScriptPlugin, @NotNull TritonEngine engine) {
            Intrinsics.checkParameterIsNotNull(engine, "engine");
            ScriptPlugin.DefaultImpls.onGameLaunched(composableScriptPlugin, engine);
        }

        public static void onStart(ComposableScriptPlugin composableScriptPlugin) {
            ScriptPlugin.DefaultImpls.onStart(composableScriptPlugin);
        }

        public static void onStop(ComposableScriptPlugin composableScriptPlugin) {
            ScriptPlugin.DefaultImpls.onStop(composableScriptPlugin);
        }
    }

    @NotNull
    Set<String> getSupportedEvents();
}
