package com.tencent.mobileqq.triton.internal.engine.init;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.lifecycle.LifeCycleOwner;
import com.tencent.mobileqq.triton.internal.script.plugin.FontPlugin;
import com.tencent.mobileqq.triton.internal.script.plugin.SubpackagePlugin;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.script.ScriptPlugin;
import com.tencent.mobileqq.triton.script.ScriptPluginComposer;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0001J\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016R\u001e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0001X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/engine/init/ScriptPluginWrapper;", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "()V", "<set-?>", "externalPlugin", "getExternalPlugin", "()Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "realPlugin", "init", "", "engineContext", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "onCall", "", AdMetricTag.EVENT_NAME, "arguments", "Lcom/tencent/mobileqq/triton/script/Argument;", "onCreate", EnginePathProvider.ENGINE_DIR, "Lcom/tencent/mobileqq/triton/TritonEngine;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onFirstFrame", "onGameLaunched", "onStart", DKHippyEvent.EVENT_STOP, "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class ScriptPluginWrapper implements ScriptPlugin {

    @NotNull
    private ScriptPlugin externalPlugin;
    private ScriptPlugin realPlugin;

    @NotNull
    public final ScriptPlugin getExternalPlugin() {
        ScriptPlugin scriptPlugin = this.externalPlugin;
        if (scriptPlugin == null) {
            Intrinsics.throwUninitializedPropertyAccessException("externalPlugin");
        }
        return scriptPlugin;
    }

    public final void init(@NotNull EngineContext engineContext, @NotNull ScriptPlugin externalPlugin) {
        List mutableListOf;
        Intrinsics.checkParameterIsNotNull(engineContext, "engineContext");
        Intrinsics.checkParameterIsNotNull(externalPlugin, "externalPlugin");
        this.externalPlugin = externalPlugin;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(externalPlugin, new SubpackagePlugin(engineContext), new FontPlugin(engineContext));
        this.realPlugin = new ScriptPluginComposer(mutableListOf);
        LifeCycleOwner lifeCycleOwner = engineContext.getLifeCycleOwner();
        ScriptPlugin scriptPlugin = this.realPlugin;
        if (scriptPlugin == null) {
            Intrinsics.throwUninitializedPropertyAccessException("realPlugin");
        }
        lifeCycleOwner.observeLifeCycle(scriptPlugin);
    }

    @Override // com.tencent.mobileqq.triton.script.ScriptPlugin
    @Nullable
    public String onCall(@NotNull String eventName, @NotNull Argument arguments) {
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        ScriptPlugin scriptPlugin = this.realPlugin;
        if (scriptPlugin == null) {
            Intrinsics.throwUninitializedPropertyAccessException("realPlugin");
        }
        return scriptPlugin.onCall(eventName, arguments);
    }

    @Override // com.tencent.mobileqq.triton.script.ScriptPlugin
    public void onCreate(@NotNull TritonEngine engine) {
        Intrinsics.checkParameterIsNotNull(engine, "engine");
        ScriptPlugin scriptPlugin = this.realPlugin;
        if (scriptPlugin == null) {
            Intrinsics.throwUninitializedPropertyAccessException("realPlugin");
        }
        scriptPlugin.onCreate(engine);
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onDestroy() {
        ScriptPlugin scriptPlugin = this.realPlugin;
        if (scriptPlugin == null) {
            Intrinsics.throwUninitializedPropertyAccessException("realPlugin");
        }
        scriptPlugin.onDestroy();
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onFirstFrame() {
        ScriptPlugin scriptPlugin = this.realPlugin;
        if (scriptPlugin == null) {
            Intrinsics.throwUninitializedPropertyAccessException("realPlugin");
        }
        scriptPlugin.onFirstFrame();
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onGameLaunched(@NotNull TritonEngine engine) {
        Intrinsics.checkParameterIsNotNull(engine, "engine");
        ScriptPlugin scriptPlugin = this.realPlugin;
        if (scriptPlugin == null) {
            Intrinsics.throwUninitializedPropertyAccessException("realPlugin");
        }
        scriptPlugin.onGameLaunched(engine);
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onStart() {
        ScriptPlugin scriptPlugin = this.realPlugin;
        if (scriptPlugin == null) {
            Intrinsics.throwUninitializedPropertyAccessException("realPlugin");
        }
        scriptPlugin.onStart();
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onStop() {
        ScriptPlugin scriptPlugin = this.realPlugin;
        if (scriptPlugin == null) {
            Intrinsics.throwUninitializedPropertyAccessException("realPlugin");
        }
        scriptPlugin.onStop();
    }
}
