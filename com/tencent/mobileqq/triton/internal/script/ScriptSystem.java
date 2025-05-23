package com.tencent.mobileqq.triton.internal.script;

import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.utils.Consts;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.mobileqq.triton.script.ScriptPlugin;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@NativeProxy(allFields = false, allMethods = false, namespace = Consts.JNI_NAMESPACE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\tJ\"\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0003J\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem;", "", "engineContext", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "scriptPlugin", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "(Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;Lcom/tencent/mobileqq/triton/script/ScriptPlugin;)V", "engineMap", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "Lcom/tencent/mobileqq/triton/internal/script/ScriptRuntime;", "Lkotlin/collections/HashMap;", "getScriptEngine", "type", "onScriptEngineChange", "createOrDestroy", "", TagName.ENGINE_TYPE, "", "ptr", "", "saveCodeCache", "", "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class ScriptSystem {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "ScriptSystem";
    private final EngineContext engineContext;
    private final HashMap<ScriptContextType, ScriptRuntime> engineMap;
    private final ScriptPlugin scriptPlugin;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0002J\f\u0010\b\u001a\u00020\u0007*\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem$Companion;", "", "()V", "TAG", "", "toNative", "", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "toScriptContextType", "Triton_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
        /* loaded from: classes19.dex */
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ScriptContextType.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[ScriptContextType.MAIN.ordinal()] = 1;
                iArr[ScriptContextType.OPEN_DATA.ordinal()] = 2;
                iArr[ScriptContextType.WORKER.ordinal()] = 3;
            }
        }

        Companion() {
        }

        private final int toNative(@NotNull ScriptContextType scriptContextType) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[scriptContextType.ordinal()];
            if (i3 == 1) {
                return 1;
            }
            if (i3 == 2) {
                return 2;
            }
            if (i3 == 3) {
                return 3;
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ScriptContextType toScriptContextType(int i3) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        return ScriptContextType.WORKER;
                    }
                    throw new IllegalArgumentException();
                }
                return ScriptContextType.OPEN_DATA;
            }
            return ScriptContextType.MAIN;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ScriptSystem(@NotNull EngineContext engineContext, @NotNull ScriptPlugin scriptPlugin) {
        Intrinsics.checkParameterIsNotNull(engineContext, "engineContext");
        Intrinsics.checkParameterIsNotNull(scriptPlugin, "scriptPlugin");
        this.engineContext = engineContext;
        this.scriptPlugin = scriptPlugin;
        this.engineMap = new HashMap<>();
    }

    @NativeMethodProxy
    private final ScriptRuntime onScriptEngineChange(boolean createOrDestroy, int engineType, long ptr) {
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        long id5 = currentThread.getId();
        ScriptContextType scriptContextType = INSTANCE.toScriptContextType(engineType);
        Logger.i$default(TAG, "onScriptEngineChange, createOrDestroy:" + createOrDestroy + ", contextType:" + scriptContextType + ", ptr:" + ptr + ", threadId:" + id5, null, 4, null);
        if (createOrDestroy) {
            this.engineMap.put(scriptContextType, new ScriptRuntime(this.engineContext, this.scriptPlugin, ptr, scriptContextType, id5));
            return this.engineMap.get(scriptContextType);
        }
        ScriptRuntime remove = this.engineMap.remove(scriptContextType);
        if (remove == null) {
            Intrinsics.throwNpe();
        }
        remove.destroy();
        return null;
    }

    @NotNull
    public final ScriptRuntime getScriptEngine(@NotNull ScriptContextType type) {
        Object value;
        Intrinsics.checkParameterIsNotNull(type, "type");
        value = MapsKt__MapsKt.getValue(this.engineMap, type);
        return (ScriptRuntime) value;
    }

    public final void saveCodeCache() {
        this.engineContext.getTtEngine().saveScriptCodeCache();
    }
}
