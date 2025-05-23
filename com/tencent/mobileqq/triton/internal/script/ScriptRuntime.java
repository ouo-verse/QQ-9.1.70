package com.tencent.mobileqq.triton.internal.script;

import androidx.annotation.VisibleForTesting;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.script.ScriptRuntime;
import com.tencent.mobileqq.triton.internal.utils.ApiUtil;
import com.tencent.mobileqq.triton.internal.utils.Consts;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.mobileqq.triton.script.ScriptFile;
import com.tencent.mobileqq.triton.script.ScriptPlugin;
import com.tencent.mobileqq.triton.statistic.ErrorCallback;
import com.tencent.mobileqq.triton.statistic.ScriptLoadResult;
import com.tencent.mobileqq.triton.statistic.ScriptLoadStatistic;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import io.github.landerlyoung.jenny.NativeClass;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import java.io.File;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@NativeClass(namespace = Consts.JNI_NAMESPACE)
@NativeProxy(allFields = false, allMethods = false, namespace = Consts.JNI_NAMESPACE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 62\u00020\u0001:\u000267B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015JO\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150 H\u0003\u00a2\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0015J\b\u0010&\u001a\u00020\u0011H\u0002J\u000e\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)J*\u0010'\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010+\u001a\u0004\u0018\u00010\u0015H\u0002J(\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u0013H\u0007J\u0010\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u000202H\u0002J\u000e\u00103\u001a\u00020#2\u0006\u00101\u001a\u000202J\u0018\u00104\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u00152\b\u0010.\u001a\u0004\u0018\u00010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/script/ScriptRuntime;", "", "engineContext", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "scriptPlugin", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "nativeHandle", "", "type", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "threadId", "(Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;Lcom/tencent/mobileqq/triton/script/ScriptPlugin;JLcom/tencent/mobileqq/triton/script/ScriptContextType;J)V", "nativeBufferManager", "Lcom/tencent/mobileqq/triton/internal/script/NativeBufferManager;", "getType", "()Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "callback2Script", "", "callbackId", "", "result", "", "convertToScriptLoadStatus", "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "scriptName", "contextType", "scriptPath", "codeLoadResult", "startTime", "timeCost", "", "outException", "", "(Ljava/lang/String;Lcom/tencent/mobileqq/triton/script/ScriptContextType;Ljava/lang/String;IJ[J[Ljava/lang/String;)Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "destroy", "", "evaluateJs", EnginePathProvider.ENGINE_JS_DIR, "isScriptThread", "loadScript", "scriptFile", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "scriptContent", "codeCacheAbsolutePath", "onScriptCall", "event", "params", "scriptObjectHandle", "postScriptThread", "task", "Ljava/lang/Runnable;", "runOnScriptThread", "subscribe2Script", AdMetricTag.EVENT_NAME, "Companion", "ScriptArgumentImpl", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class ScriptRuntime {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NATIVE_BUFFERS = "__nativeBuffers__";
    private static final String TAG = "ScriptRuntime <API>";
    private final EngineContext engineContext;
    private final NativeBufferManager nativeBufferManager;
    private long nativeHandle;
    private final ScriptPlugin scriptPlugin;
    private final long threadId;

    @NotNull
    private final ScriptContextType type;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J+\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0083 J\u0019\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0004H\u0083 JT\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0018H\u0083 \u00a2\u0006\u0002\u0010\u0019J+\u0010\u001a\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0083 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/script/ScriptRuntime$Companion;", "", "()V", "NATIVE_BUFFERS", "", "TAG", "nativeCallback2Script", "", "nativeHandle", "", "callbackId", "", "functionName", "params", "nativeEvaluateScript", "content", "nativeLoadScriptWithCodeCache", "scriptPath", "scriptContent", "scriptName", "codeCacheAbsolutePath", "timeCost", "", "outException", "", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[J[Ljava/lang/String;)I", "nativeSubscribe2Script", AdMetricTag.EVENT_NAME, "Triton_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativeCallback2Script(long nativeHandle, int callbackId, String functionName, String params) {
            ScriptRuntime.nativeCallback2Script(nativeHandle, callbackId, functionName, params);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativeEvaluateScript(long nativeHandle, String content) {
            ScriptRuntime.nativeEvaluateScript(nativeHandle, content);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int nativeLoadScriptWithCodeCache(long nativeHandle, String scriptPath, String scriptContent, String scriptName, String codeCacheAbsolutePath, long[] timeCost, String[] outException) {
            return ScriptRuntime.nativeLoadScriptWithCodeCache(nativeHandle, scriptPath, scriptContent, scriptName, codeCacheAbsolutePath, timeCost, outException);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void nativeSubscribe2Script(long nativeHandle, String functionName, String eventName, String params) {
            ScriptRuntime.nativeSubscribe2Script(nativeHandle, functionName, eventName, params);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0016J \u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\"\u001a\u00020\u0005H\u0016J\u001a\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001f\u0010\u000e\u001a\u00060\u000fj\u0002`\u00108VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/script/ScriptRuntime$ScriptArgumentImpl;", "Lcom/tencent/mobileqq/triton/script/Argument;", "paramStr", "", "callbackId", "", "scriptObjectHandle", "(Lcom/tencent/mobileqq/triton/internal/script/ScriptRuntime;Ljava/lang/String;II)V", "getCallbackId", "()I", "contextType", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "getContextType", "()Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "params", "Lorg/json/JSONObject;", "Lcom/tencent/mobileqq/triton/script/ScriptData;", "getParams", "()Lorg/json/JSONObject;", "params$delegate", "Lkotlin/Lazy;", "rawParams", "getRawParams", "()Ljava/lang/String;", "callback", "", "result", "createBuffer", "buffer", "", "offset", "", "length", "getBuffer", "bufferId", "subscribe", AdMetricTag.EVENT_NAME, "Triton_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    private final class ScriptArgumentImpl implements Argument {
        private final int callbackId;

        /* renamed from: params$delegate, reason: from kotlin metadata */
        @NotNull
        private final Lazy params;

        @NotNull
        private final String rawParams;
        final /* synthetic */ ScriptRuntime this$0;

        public ScriptArgumentImpl(@NotNull ScriptRuntime scriptRuntime, final String paramStr, int i3, int i16) {
            Lazy lazy;
            Intrinsics.checkParameterIsNotNull(paramStr, "paramStr");
            this.this$0 = scriptRuntime;
            this.rawParams = paramStr;
            this.callbackId = i3;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<JSONObject>() { // from class: com.tencent.mobileqq.triton.internal.script.ScriptRuntime$ScriptArgumentImpl$params$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final JSONObject invoke() {
                    return new JSONObject(paramStr);
                }
            });
            this.params = lazy;
        }

        @Override // com.tencent.mobileqq.triton.script.Argument
        public boolean callback(@Nullable String result) {
            return this.this$0.callback2Script(getCallbackId(), result);
        }

        @Override // com.tencent.mobileqq.triton.script.Argument
        public int createBuffer(@NotNull byte[] buffer, long offset, long length) {
            Intrinsics.checkParameterIsNotNull(buffer, "buffer");
            EngineContext engineContext = this.this$0.engineContext;
            ReentrantLock lock = engineContext.getLock();
            lock.lock();
            try {
                if (engineContext.isAlive()) {
                    return this.this$0.nativeBufferManager.createBuffer(buffer, offset, length);
                }
                lock.unlock();
                return 0;
            } finally {
                lock.unlock();
            }
        }

        @Override // com.tencent.mobileqq.triton.script.Argument
        @Nullable
        public byte[] getBuffer(int bufferId) {
            EngineContext engineContext = this.this$0.engineContext;
            ReentrantLock lock = engineContext.getLock();
            lock.lock();
            try {
                if (engineContext.isAlive()) {
                    return this.this$0.nativeBufferManager.getBuffer(bufferId);
                }
                lock.unlock();
                return null;
            } finally {
                lock.unlock();
            }
        }

        @Override // com.tencent.mobileqq.triton.script.Argument
        public int getCallbackId() {
            return this.callbackId;
        }

        @Override // com.tencent.mobileqq.triton.script.Argument
        @NotNull
        public ScriptContextType getContextType() {
            return this.this$0.getType();
        }

        @Override // com.tencent.mobileqq.triton.script.Argument
        @NotNull
        public JSONObject getParams() {
            return (JSONObject) this.params.getValue();
        }

        @Override // com.tencent.mobileqq.triton.script.Argument
        @NotNull
        public String getRawParams() {
            return this.rawParams;
        }

        @Override // com.tencent.mobileqq.triton.script.Argument
        public boolean subscribe(@NotNull String eventName, @Nullable String params) {
            Intrinsics.checkParameterIsNotNull(eventName, "eventName");
            return this.this$0.subscribe2Script(eventName, params);
        }
    }

    public ScriptRuntime(@NotNull EngineContext engineContext, @NotNull ScriptPlugin scriptPlugin, long j3, @NotNull ScriptContextType type, long j16) {
        Intrinsics.checkParameterIsNotNull(engineContext, "engineContext");
        Intrinsics.checkParameterIsNotNull(scriptPlugin, "scriptPlugin");
        Intrinsics.checkParameterIsNotNull(type, "type");
        this.engineContext = engineContext;
        this.scriptPlugin = scriptPlugin;
        this.nativeHandle = j3;
        this.type = type;
        this.threadId = j16;
        this.nativeBufferManager = new NativeBufferManager(j3);
    }

    @VisibleForTesting
    private final ScriptLoadStatistic convertToScriptLoadStatus(String scriptName, ScriptContextType contextType, String scriptPath, int codeLoadResult, long startTime, long[] timeCost, String[] outException) {
        ScriptLoadResult scriptLoadResult;
        String str;
        String str2;
        switch (codeLoadResult) {
            case -4:
                scriptLoadResult = ScriptLoadResult.FAIL_INVALID_STATE;
                break;
            case -3:
                scriptLoadResult = ScriptLoadResult.FAIL_EXECUTE;
                break;
            case -2:
                scriptLoadResult = ScriptLoadResult.FAIL_COMPILE;
                break;
            case -1:
                scriptLoadResult = ScriptLoadResult.FAIL_READ_SCRIPT;
                break;
            case 0:
                scriptLoadResult = ScriptLoadResult.SUCCESS_WITH_CACHE;
                break;
            case 1:
                scriptLoadResult = ScriptLoadResult.SUCCESS_WITHOUT_CACHE;
                break;
            case 2:
                scriptLoadResult = ScriptLoadResult.SUCCESS_BUT_CACHE_REJECTED;
                break;
            default:
                scriptLoadResult = ScriptLoadResult.FAIL_INVALID_STATE;
                break;
        }
        ScriptLoadResult scriptLoadResult2 = scriptLoadResult;
        if (scriptPath == null) {
            str = "";
        } else {
            str = scriptPath;
        }
        long j3 = timeCost[0];
        long j16 = timeCost[1];
        long j17 = timeCost[2];
        long j18 = timeCost[3];
        String str3 = outException[0];
        if (str3 == null) {
            str2 = "";
        } else {
            str2 = str3;
        }
        return new ScriptLoadStatistic(scriptLoadResult2, contextType, scriptName, str, j3, j16, j17, j18, str2, startTime);
    }

    private final boolean isScriptThread() {
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        if (currentThread.getId() == this.threadId) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void nativeCallback2Script(long j3, int i3, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void nativeEvaluateScript(long j3, String str);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int nativeLoadScriptWithCodeCache(long j3, String str, String str2, String str3, String str4, long[] jArr, String[] strArr);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void nativeSubscribe2Script(long j3, String str, String str2, String str3);

    private final boolean postScriptThread(Runnable task) {
        return this.engineContext.getTtEngine().postRunnable(task);
    }

    public final boolean callback2Script(int callbackId, @Nullable String result) {
        try {
            this.engineContext.getLock().lock();
            if (this.engineContext.getEngineState() != EngineState.DESTROYED) {
                INSTANCE.nativeCallback2Script(this.nativeHandle, callbackId, "WeixinJSBridge.invokeCallbackHandler", result);
                this.engineContext.getLock().unlock();
                return true;
            }
            this.engineContext.getLock().unlock();
            return false;
        } catch (Throwable th5) {
            this.engineContext.getLock().unlock();
            throw th5;
        }
    }

    public final void destroy() {
        synchronized (this) {
            this.nativeHandle = 0L;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void evaluateJs(@NotNull final String js5) {
        Intrinsics.checkParameterIsNotNull(js5, "js");
        runOnScriptThread(new Runnable() { // from class: com.tencent.mobileqq.triton.internal.script.ScriptRuntime$evaluateJs$1
            @Override // java.lang.Runnable
            public final void run() {
                long j3;
                long j16;
                try {
                    ScriptRuntime.Companion companion = ScriptRuntime.INSTANCE;
                    j16 = ScriptRuntime.this.nativeHandle;
                    companion.nativeEvaluateScript(j16, js5);
                    Unit unit = Unit.INSTANCE;
                } catch (UnsatisfiedLinkError unused) {
                    ScriptRuntime.Companion companion2 = ScriptRuntime.INSTANCE;
                    j3 = ScriptRuntime.this.nativeHandle;
                    companion2.nativeEvaluateScript(j3, js5);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        });
    }

    @NotNull
    public final ScriptContextType getType() {
        return this.type;
    }

    @NotNull
    public final ScriptLoadStatistic loadScript(@NotNull ScriptFile scriptFile) {
        Intrinsics.checkParameterIsNotNull(scriptFile, "scriptFile");
        if (isScriptThread()) {
            if (scriptFile instanceof ScriptFile.Path) {
                ScriptFile.Path path = (ScriptFile.Path) scriptFile;
                String absolutePath = path.getPath().getAbsolutePath();
                Intrinsics.checkExpressionValueIsNotNull(absolutePath, "scriptFile.path.absolutePath");
                String name = path.getName();
                File codeCache = path.getCodeCache();
                return loadScript(absolutePath, "", name, codeCache != null ? codeCache.getAbsolutePath() : null);
            }
            ScriptFile.Content content = (ScriptFile.Content) scriptFile;
            String content2 = content.getContent();
            String name2 = content.getName();
            File codeCache2 = content.getCodeCache();
            return loadScript("", content2, name2, codeCache2 != null ? codeCache2.getAbsolutePath() : null);
        }
        throw new IllegalStateException(("loadScript " + scriptFile + " not on script thread").toString());
    }

    @NativeMethodProxy
    @NotNull
    public final String onScriptCall(@NotNull String event, @NotNull String params, int callbackId, int scriptObjectHandle) {
        TritonException tritonException;
        Intrinsics.checkParameterIsNotNull(event, "event");
        Intrinsics.checkParameterIsNotNull(params, "params");
        try {
            String onCall = this.scriptPlugin.onCall(event, new ScriptArgumentImpl(this, params, callbackId, scriptObjectHandle));
            if (onCall == null) {
                return "{}";
            }
            return onCall;
        } catch (IllegalArgumentException e16) {
            String jSONObject = ApiUtil.wrapCallbackFail(event, null, e16.getMessage()).toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject, "ApiUtil.wrapCallbackFail\u2026ll, e.message).toString()");
            return jSONObject;
        } catch (Throwable th5) {
            String str = "ScriptPlugin handle event " + event + " failed";
            ErrorCallback value = this.engineContext.getStatisticsManager().getErrorCallback().getValue();
            if (value != null) {
                ErrorCodes errorCodes = ErrorCodes.SCRIPT_PLUGIN_CALL_FAIL;
                if (th5 instanceof TritonException) {
                    tritonException = th5;
                } else {
                    String message = th5.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    tritonException = new TritonException(message, errorCodes, th5);
                }
                value.onError(str, tritonException);
            }
            String jSONObject2 = ApiUtil.wrapCallbackFail(event, null, th5.getMessage()).toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "ApiUtil.wrapCallbackFail\u2026ll, e.message).toString()");
            return jSONObject2;
        }
    }

    public final void runOnScriptThread(@NotNull Runnable task) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        if (isScriptThread()) {
            task.run();
        } else {
            postScriptThread(task);
        }
    }

    public final boolean subscribe2Script(@NotNull String eventName, @Nullable String params) {
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        try {
            this.engineContext.getLock().lock();
            if (this.engineContext.getEngineState() != EngineState.DESTROYED) {
                INSTANCE.nativeSubscribe2Script(this.nativeHandle, "WeixinJSBridge.subscribeHandler", eventName, params);
                this.engineContext.getLock().unlock();
                return true;
            }
            this.engineContext.getLock().unlock();
            return false;
        } catch (Throwable th5) {
            this.engineContext.getLock().unlock();
            throw th5;
        }
    }

    private final ScriptLoadStatistic loadScript(String scriptPath, String scriptContent, String scriptName, String codeCacheAbsolutePath) {
        int nativeLoadScriptWithCodeCache;
        long currentTimeMillis = System.currentTimeMillis();
        long[] jArr = new long[4];
        String[] strArr = new String[1];
        try {
            nativeLoadScriptWithCodeCache = INSTANCE.nativeLoadScriptWithCodeCache(this.nativeHandle, scriptPath, scriptContent, scriptName, codeCacheAbsolutePath, jArr, strArr);
        } catch (UnsatisfiedLinkError unused) {
            nativeLoadScriptWithCodeCache = INSTANCE.nativeLoadScriptWithCodeCache(this.nativeHandle, scriptPath, scriptContent, scriptName, codeCacheAbsolutePath, jArr, strArr);
        }
        return convertToScriptLoadStatus(scriptName, this.type, scriptPath, nativeLoadScriptWithCodeCache, currentTimeMillis, jArr, strArr);
    }
}
