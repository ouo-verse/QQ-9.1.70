package com.tencent.qqmini.minigame;

import android.webkit.ValueCallback;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.qqmini.minigame.utils.PluginLogger;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0016H\u0016J \u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001e\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqmini/minigame/GameJsService;", "Lcom/tencent/qqmini/sdk/launcher/core/IJsService;", "arguments", "Lcom/tencent/mobileqq/triton/script/Argument;", "logger", "Lcom/tencent/qqmini/minigame/utils/PluginLogger;", "(Lcom/tencent/mobileqq/triton/script/Argument;Lcom/tencent/qqmini/minigame/utils/PluginLogger;)V", "createNativeBuffer", "", "buffer", "", "offset", "", "length", "evaluateCallbackJs", "", "callbackId", "result", "", "evaluateJs", EnginePathProvider.ENGINE_JS_DIR, "valueCallback", "Landroid/webkit/ValueCallback;", "evaluateSubscribeJS", AdMetricTag.EVENT_NAME, "data", "webviweId", "getContextType", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "getNativeBuffer", "bufferId", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class GameJsService implements IJsService {
    private final Argument arguments;
    private final PluginLogger logger;

    public GameJsService(@NotNull Argument arguments, @NotNull PluginLogger logger) {
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        Intrinsics.checkParameterIsNotNull(logger, "logger");
        this.arguments = arguments;
        this.logger = logger;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public int createNativeBuffer(@NotNull byte[] buffer, long offset, long length) {
        Intrinsics.checkParameterIsNotNull(buffer, "buffer");
        return this.arguments.createBuffer(buffer, offset, length);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public void evaluateCallbackJs(int callbackId, @NotNull String result) {
        Intrinsics.checkParameterIsNotNull(result, "result");
        this.logger.printEndLog(callbackId, result);
        this.arguments.callback(result);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public void evaluateJs(@NotNull String js5, @Nullable ValueCallback<?> valueCallback) {
        Intrinsics.checkParameterIsNotNull(js5, "js");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public void evaluateSubscribeJS(@NotNull String eventName, @NotNull String data, int webviweId) {
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        Intrinsics.checkParameterIsNotNull(data, "data");
        this.logger.printEndLog(eventName, data);
        this.arguments.subscribe(eventName, data);
    }

    @NotNull
    public final ScriptContextType getContextType() {
        return this.arguments.getContextType();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    @Nullable
    public byte[] getNativeBuffer(int bufferId) {
        return this.arguments.getBuffer(bufferId);
    }
}
