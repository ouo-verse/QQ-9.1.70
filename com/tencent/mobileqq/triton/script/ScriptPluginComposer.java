package com.tencent.mobileqq.triton.script;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/triton/script/ScriptPluginComposer;", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "composedScriptPlugins", "", "(Ljava/util/List;)V", "map", "", "", "getMap", "()Ljava/util/Map;", "nonComposablePlugins", "onCall", AdMetricTag.EVENT_NAME, "arguments", "Lcom/tencent/mobileqq/triton/script/Argument;", "onCreate", "", EnginePathProvider.ENGINE_DIR, "Lcom/tencent/mobileqq/triton/TritonEngine;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onFirstFrame", "onGameLaunched", "onStart", DKHippyEvent.EVENT_STOP, "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class ScriptPluginComposer implements ScriptPlugin {
    private final List<ScriptPlugin> composedScriptPlugins;

    @NotNull
    private final Map<String, ScriptPlugin> map;
    private final List<ScriptPlugin> nonComposablePlugins;

    public ScriptPluginComposer(@NotNull List<ScriptPlugin> composedScriptPlugins) {
        Intrinsics.checkParameterIsNotNull(composedScriptPlugins, "composedScriptPlugins");
        this.composedScriptPlugins = composedScriptPlugins;
        this.nonComposablePlugins = new ArrayList();
        HashMap hashMap = new HashMap();
        for (ScriptPlugin scriptPlugin : composedScriptPlugins) {
            if (scriptPlugin instanceof ScriptPluginComposer) {
                hashMap.putAll(((ScriptPluginComposer) scriptPlugin).map);
            } else if (scriptPlugin instanceof ComposableScriptPlugin) {
                Iterator<T> it = ((ComposableScriptPlugin) scriptPlugin).getSupportedEvents().iterator();
                while (it.hasNext()) {
                    hashMap.put((String) it.next(), scriptPlugin);
                }
            } else {
                this.nonComposablePlugins.add(scriptPlugin);
            }
        }
        this.map = hashMap;
    }

    @NotNull
    public final Map<String, ScriptPlugin> getMap() {
        return this.map;
    }

    @Override // com.tencent.mobileqq.triton.script.ScriptPlugin
    @Nullable
    public String onCall(@NotNull String eventName, @NotNull Argument arguments) {
        String str;
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        ScriptPlugin scriptPlugin = this.map.get(eventName);
        if (scriptPlugin != null) {
            str = scriptPlugin.onCall(eventName, arguments);
        } else {
            str = null;
        }
        if (str != null) {
            return str;
        }
        Iterator<T> it = this.nonComposablePlugins.iterator();
        while (it.hasNext()) {
            String onCall = ((ScriptPlugin) it.next()).onCall(eventName, arguments);
            if (onCall != null) {
                return onCall;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.triton.script.ScriptPlugin
    public void onCreate(@NotNull TritonEngine engine) {
        Intrinsics.checkParameterIsNotNull(engine, "engine");
        Iterator<T> it = this.composedScriptPlugins.iterator();
        while (it.hasNext()) {
            ((ScriptPlugin) it.next()).onCreate(engine);
        }
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onDestroy() {
        Iterator<T> it = this.composedScriptPlugins.iterator();
        while (it.hasNext()) {
            ((ScriptPlugin) it.next()).onDestroy();
        }
        this.composedScriptPlugins.clear();
        this.nonComposablePlugins.clear();
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onFirstFrame() {
        Iterator<T> it = this.composedScriptPlugins.iterator();
        while (it.hasNext()) {
            ((ScriptPlugin) it.next()).onFirstFrame();
        }
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onGameLaunched(@NotNull TritonEngine engine) {
        Intrinsics.checkParameterIsNotNull(engine, "engine");
        Iterator<T> it = this.composedScriptPlugins.iterator();
        while (it.hasNext()) {
            ((ScriptPlugin) it.next()).onGameLaunched(engine);
        }
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onStart() {
        Iterator<T> it = this.composedScriptPlugins.iterator();
        while (it.hasNext()) {
            ((ScriptPlugin) it.next()).onStart();
        }
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onStop() {
        Iterator<T> it = this.composedScriptPlugins.iterator();
        while (it.hasNext()) {
            ((ScriptPlugin) it.next()).onStop();
        }
    }
}
