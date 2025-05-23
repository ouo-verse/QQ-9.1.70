package com.tencent.mobileqq.triton.internal.script.plugin;

import android.text.TextUtils;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.utils.ApiUtil;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.script.ComposableScriptPlugin;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/script/plugin/FontPlugin;", "Lcom/tencent/mobileqq/triton/script/ComposableScriptPlugin;", "engineContext", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "(Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;)V", "supportedEvents", "", "", "getSupportedEvents", "()Ljava/util/Set;", FontPlugin.API_GET_TEXT_LINE_HEIGHT, "", "arguments", "Lcom/tencent/mobileqq/triton/script/Argument;", FontPlugin.API_LOAD_FONT, "onCall", AdMetricTag.EVENT_NAME, "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class FontPlugin implements ComposableScriptPlugin {
    private static final String API_GET_TEXT_LINE_HEIGHT = "getTextLineHeight";
    private static final String API_LOAD_FONT = "loadFont";
    private static final Set<String> supportedEvents;
    private final EngineContext engineContext;

    static {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{API_LOAD_FONT, API_GET_TEXT_LINE_HEIGHT});
        supportedEvents = of5;
    }

    public FontPlugin(@NotNull EngineContext engineContext) {
        Intrinsics.checkParameterIsNotNull(engineContext, "engineContext");
        this.engineContext = engineContext;
    }

    private final int getTextLineHeight(Argument arguments) {
        return this.engineContext.getFontBitmapManager().getTextLineHeight(arguments.getParams().optString("fontStyle"), arguments.getParams().optString("fontWeight"), arguments.getParams().optInt("fontSize", 0), arguments.getParams().optString("fontFamily"), arguments.getParams().optString("text"));
    }

    private final String loadFont(Argument arguments) {
        String path = arguments.getParams().optString("path");
        GameDataFileSystem dataFileSystem = this.engineContext.getDataFileSystem();
        Intrinsics.checkExpressionValueIsNotNull(path, "path");
        return this.engineContext.getFontBitmapManager().loadFont(dataFileSystem.getFile(path));
    }

    @Override // com.tencent.mobileqq.triton.script.ComposableScriptPlugin
    @NotNull
    public Set<String> getSupportedEvents() {
        return supportedEvents;
    }

    @Override // com.tencent.mobileqq.triton.script.ScriptPlugin
    @Nullable
    public String onCall(@NotNull String eventName, @NotNull Argument arguments) {
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        int hashCode = eventName.hashCode();
        if (hashCode != -876445634) {
            if (hashCode != 1845191253 || !eventName.equals(API_LOAD_FONT)) {
                return null;
            }
            String loadFont = loadFont(arguments);
            if (!TextUtils.isEmpty(loadFont)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CommonConstant.KEY_FAMILY_NAME, loadFont);
                return ApiUtil.wrapCallbackOk(eventName, jSONObject).toString();
            }
            return ApiUtil.wrapCallbackFail(eventName, null).toString();
        }
        if (!eventName.equals(API_GET_TEXT_LINE_HEIGHT)) {
            return null;
        }
        int textLineHeight = getTextLineHeight(arguments);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(NodeProps.LINE_HEIGHT, textLineHeight);
        String jSONObject3 = ApiUtil.wrapCallbackOk(eventName, jSONObject2).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject3, "ApiUtil.wrapCallbackOk(e\u2026tName, resObj).toString()");
        arguments.callback(jSONObject3);
        return jSONObject3;
    }

    @Override // com.tencent.mobileqq.triton.script.ScriptPlugin
    public void onCreate(@NotNull TritonEngine engine) {
        Intrinsics.checkParameterIsNotNull(engine, "engine");
        ComposableScriptPlugin.DefaultImpls.onCreate(this, engine);
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onDestroy() {
        ComposableScriptPlugin.DefaultImpls.onDestroy(this);
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onFirstFrame() {
        ComposableScriptPlugin.DefaultImpls.onFirstFrame(this);
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onGameLaunched(@NotNull TritonEngine engine) {
        Intrinsics.checkParameterIsNotNull(engine, "engine");
        ComposableScriptPlugin.DefaultImpls.onGameLaunched(this, engine);
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onStart() {
        ComposableScriptPlugin.DefaultImpls.onStart(this);
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onStop() {
        ComposableScriptPlugin.DefaultImpls.onStop(this);
    }
}
