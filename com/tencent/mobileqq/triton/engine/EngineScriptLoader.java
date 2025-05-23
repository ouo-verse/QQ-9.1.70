package com.tencent.mobileqq.triton.engine;

import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.engine.init.ScriptLoader;
import com.tencent.mobileqq.triton.internal.script.ScriptRuntime;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.mobileqq.triton.script.ScriptFile;
import com.tencent.mobileqq.triton.statistic.ScriptLoadStatistic;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0010@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0010@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/triton/engine/EngineScriptLoader;", "", "engineContext", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "(Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;)V", "<set-?>", "Lcom/tencent/mobileqq/triton/exception/TritonException;", "engineScriptInitException", "getEngineScriptInitException", "()Lcom/tencent/mobileqq/triton/exception/TritonException;", "engineScriptLoadStatics", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "Lkotlin/collections/ArrayList;", "getEngineScriptLoadStatics", "()Ljava/util/ArrayList;", "", "loadEngineScriptEndTime", "getLoadEngineScriptEndTime", "()J", "loadScriptScriptTimeMs", "getLoadScriptScriptTimeMs", "initJsRuntime", "", "injectGlobalConfig", "contextType", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class EngineScriptLoader {
    private static final String DEFAULT_GLOBAL_CONFIG = "self = GameGlobal = __TT__GLOBAL__ = global = window = this;\nself.__ttObjdec__ = {};\nself.wx = self.wx || {};\nself.WeixinNativeBuffer = Triton.WeixinNativeBuffer;\nvar __wxConfig = __wxConfig || {};\n__wxConfig.env = {};\n__wxConfig.env.USER_DATA_PATH = 'wxfile://usr';\n__wxConfig.platform = 'android';\nwx.env = __wxConfig.env;\nvar __qqConfig = __wxConfig || {};";
    private final EngineContext engineContext;

    @Nullable
    private TritonException engineScriptInitException;

    @NotNull
    private final ArrayList<ScriptLoadStatistic> engineScriptLoadStatics;
    private long loadEngineScriptEndTime;
    private long loadScriptScriptTimeMs;

    public EngineScriptLoader(@NotNull EngineContext engineContext) {
        Intrinsics.checkParameterIsNotNull(engineContext, "engineContext");
        this.engineContext = engineContext;
        this.engineScriptLoadStatics = new ArrayList<>();
    }

    private final void injectGlobalConfig(ScriptContextType contextType) {
        ScriptRuntime scriptEngine = this.engineContext.getScriptSystem().getScriptEngine(contextType);
        String globalConfig = this.engineContext.getEnginePackage().getGlobalConfig();
        if (globalConfig == null) {
            globalConfig = DEFAULT_GLOBAL_CONFIG;
        }
        scriptEngine.evaluateJs(globalConfig);
    }

    @Nullable
    public final TritonException getEngineScriptInitException() {
        return this.engineScriptInitException;
    }

    @NotNull
    public final ArrayList<ScriptLoadStatistic> getEngineScriptLoadStatics() {
        return this.engineScriptLoadStatics;
    }

    public final long getLoadEngineScriptEndTime() {
        return this.loadEngineScriptEndTime;
    }

    public final long getLoadScriptScriptTimeMs() {
        return this.loadScriptScriptTimeMs;
    }

    public final void initJsRuntime() {
        TritonException tritonException;
        Object value;
        Object value2;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Map<ScriptContextType, ScriptFile> engineScripts = ScriptLoader.INSTANCE.getEngineScripts(this.engineContext.getEnginePackage());
            ScriptContextType scriptContextType = ScriptContextType.MAIN;
            injectGlobalConfig(scriptContextType);
            ScriptRuntime scriptEngine = this.engineContext.getScriptSystem().getScriptEngine(scriptContextType);
            ArrayList<ScriptLoadStatistic> arrayList = this.engineScriptLoadStatics;
            value = MapsKt__MapsKt.getValue(engineScripts, scriptContextType);
            arrayList.add(scriptEngine.loadScript((ScriptFile) value));
            ScriptContextType scriptContextType2 = ScriptContextType.OPEN_DATA;
            injectGlobalConfig(scriptContextType2);
            ScriptRuntime scriptEngine2 = this.engineContext.getScriptSystem().getScriptEngine(scriptContextType2);
            ArrayList<ScriptLoadStatistic> arrayList2 = this.engineScriptLoadStatics;
            value2 = MapsKt__MapsKt.getValue(engineScripts, scriptContextType2);
            arrayList2.add(scriptEngine2.loadScript((ScriptFile) value2));
            this.loadEngineScriptEndTime = System.currentTimeMillis();
            this.loadScriptScriptTimeMs = System.currentTimeMillis() - currentTimeMillis;
        } catch (Throwable th5) {
            ErrorCodes errorCodes = ErrorCodes.SCRIPT_LOAD_FAIL;
            if (th5 instanceof TritonException) {
                tritonException = th5;
            } else {
                String message = th5.getMessage();
                if (message == null) {
                    message = "";
                }
                tritonException = new TritonException(message, errorCodes, th5);
            }
            this.engineScriptInitException = tritonException;
        }
    }
}
