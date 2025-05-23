package com.tencent.mobileqq.triton.internal.script.plugin;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.utils.ApiUtil;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.script.ComposableScriptPlugin;
import com.tencent.mobileqq.triton.statistic.ScriptLoadResult;
import com.tencent.mobileqq.triton.statistic.ScriptLoadStatistic;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/script/plugin/SubpackagePlugin;", "Lcom/tencent/mobileqq/triton/script/ComposableScriptPlugin;", "engineContext", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "(Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;)V", "subpackageTaskId", "Ljava/util/concurrent/atomic/AtomicInteger;", "supportedEvents", "", "", "getSupportedEvents", "()Ljava/util/Set;", "createSubPackageTask", "arguments", "Lcom/tencent/mobileqq/triton/script/Argument;", "onCall", AdMetricTag.EVENT_NAME, "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class SubpackagePlugin implements ComposableScriptPlugin {
    private static final String API_CREATE_LOAD_SUBPACKAGE_TASK = "createLoadSubPackageTask";
    private static final String EVENT_ON_LOAD_SUBPACKAGE_TASK_STATE_CHANGE = "onLoadSubPackageTaskStateChange";
    private static final String TAG = "SubpackagePlugin";
    private static final Set<String> supportedEvents;
    private final EngineContext engineContext;
    private final AtomicInteger subpackageTaskId;

    static {
        Set<String> of5;
        of5 = SetsKt__SetsJVMKt.setOf("createLoadSubPackageTask");
        supportedEvents = of5;
    }

    public SubpackagePlugin(@NotNull EngineContext engineContext) {
        Intrinsics.checkParameterIsNotNull(engineContext, "engineContext");
        this.engineContext = engineContext;
        this.subpackageTaskId = new AtomicInteger(0);
    }

    private final String createSubPackageTask(final Argument arguments) {
        boolean z16;
        final int andIncrement = this.subpackageTaskId.getAndIncrement();
        final String optString = arguments.getParams().optString("name");
        if (optString != null && optString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("loadTaskId", andIncrement);
            jSONObject.put("state", "fail");
            String jSONObject2 = ApiUtil.wrapCallbackFail("createLoadSubPackageTask", jSONObject).toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "ApiUtil.wrapCallbackFail\u2026TASK, failObj).toString()");
            return jSONObject2;
        }
        this.engineContext.getTtEngine().getGameLauncher().loadSubpackage(optString, new Function2<Long, Long, Unit>() { // from class: com.tencent.mobileqq.triton.internal.script.plugin.SubpackagePlugin$createSubPackageTask$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Long l3, Long l16) {
                invoke(l3.longValue(), l16.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j3, long j16) {
                long coerceAtLeast;
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, andIncrement);
                jSONObject3.put("state", "progressUpdate");
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(j3, 1L);
                jSONObject3.put("progress", j16 / coerceAtLeast);
                jSONObject3.put("totalBytesWritten", j16);
                jSONObject3.put("totalBytesExpectedToWrite", j3);
                arguments.subscribe("onLoadSubPackageTaskStateChange", jSONObject3.toString());
            }
        }, new Function1<ScriptLoadStatistic, Unit>() { // from class: com.tencent.mobileqq.triton.internal.script.plugin.SubpackagePlugin$createSubPackageTask$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScriptLoadStatistic scriptLoadStatistic) {
                invoke2(scriptLoadStatistic);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ScriptLoadStatistic it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                Logger.i$default("SubpackagePlugin", "loadSubpackage name:" + optString + " result:" + it.getLoadResult(), null, 4, null);
                if (!it.getLoadResult().getIsSuccess() && it.getLoadResult() == ScriptLoadResult.FAIL_COMPILE) {
                    Logger.w$default("SubpackagePlugin", "retry loadSubpackage name:" + optString + " for js compile fail", null, 4, null);
                    return;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, andIncrement);
                jSONObject3.put("state", it.getLoadResult().getIsSuccess() ? "success" : "fail");
                arguments.subscribe("onLoadSubPackageTaskStateChange", jSONObject3.toString());
            }
        });
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("loadTaskId", andIncrement);
        String jSONObject4 = ApiUtil.wrapCallbackOk("createLoadSubPackageTask", jSONObject3).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject4, "ApiUtil.wrapCallbackOk(A\u2026SK, resultObj).toString()");
        return jSONObject4;
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
        if (eventName.hashCode() == 541681965 && eventName.equals("createLoadSubPackageTask")) {
            return createSubPackageTask(arguments);
        }
        return null;
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
