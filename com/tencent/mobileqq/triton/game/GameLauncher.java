package com.tencent.mobileqq.triton.game;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.triton.engine.GameLaunchCallback;
import com.tencent.mobileqq.triton.engine.GameLaunchParam;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.filesystem.ScriptPackage;
import com.tencent.mobileqq.triton.internal.engine.init.ScriptLoader;
import com.tencent.mobileqq.triton.internal.script.ScriptRuntime;
import com.tencent.mobileqq.triton.internal.script.ScriptSystem;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.internal.utils.Utils;
import com.tencent.mobileqq.triton.jni.JNICaller;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.mobileqq.triton.script.ScriptFile;
import com.tencent.mobileqq.triton.statistic.EngineInitStatistic;
import com.tencent.mobileqq.triton.statistic.FirstFrameStatistic;
import com.tencent.mobileqq.triton.statistic.GameLaunchStatistic;
import com.tencent.mobileqq.triton.statistic.NativeLibraryLoadStatistic;
import com.tencent.mobileqq.triton.statistic.ScriptLoadResult;
import com.tencent.mobileqq.triton.statistic.ScriptLoadStatistic;
import com.tencent.mobileqq.triton.statistic.SubpackageLoadStatisticsCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 E2\u00020\u0001:\u0001EB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0001H\u0002J\u001c\u0010\u0013\u001a\u00020\u00112\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001dJi\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001126\u0010 \u001a2\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\"\u0012\b\b\u001f\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\"\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00170!2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\"\u0012\b\b\u001f\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00170&J(\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u000f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u0006\u0010.\u001a\u00020\u0017Jd\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000f2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u00107\u001a\u0004\u0018\u0001082\f\u00109\u001a\b\u0012\u0004\u0012\u00020:0\n2\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u000fJ;\u0010=\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00112!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\"\u0012\b\b\u001f\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00170&2\u0006\u0010'\u001a\u00020\u000bH\u0002J\u0006\u0010>\u001a\u00020\u0017J&\u0010?\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001dH\u0002JI\u0010@\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00112\f\u0010A\u001a\b\u0012\u0004\u0012\u00020C0B2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\"\u0012\b\b\u001f\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00170&H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010DR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/triton/game/GameLauncher;", "", "mTritonEngine", "Lcom/tencent/mobileqq/triton/engine/TTEngine;", "(Lcom/tencent/mobileqq/triton/engine/TTEngine;)V", "mEngineInitStatistic", "Lcom/tencent/mobileqq/triton/statistic/EngineInitStatistic;", "mGameLaunchCallback", "Lcom/tencent/mobileqq/triton/engine/GameLaunchCallback;", "mGameScriptLoadStatics", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "mLaunchAfterInit", "Ljava/lang/Runnable;", "mLaunchGameEndTime", "", "genConfig", "", "value", "getOptionConfig", "map", "", "injectGameInfo", "", "launchGame", "param", "Lcom/tencent/mobileqq/triton/engine/GameLaunchParam;", "callback", "onLaunchBegin", "Lkotlin/Function0;", "loadSubpackage", "name", "onProgress", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "totalBytes", "currentBytes", "onComplete", "Lkotlin/Function1;", "statistics", "notifyGameLaunched", "launchTimesMs", "gameScriptLoadStatics", "", "failure", "", "onFirstRender", "onInitDone", "error", "Lcom/tencent/mobileqq/triton/exception/ErrorCodes;", "loadSoTimeMs", "loadEngineScriptTimeMs", "createEGLContextTimeMs", "initTimeMs", "statics", "engineScriptInitException", "Lcom/tencent/mobileqq/triton/exception/TritonException;", "nativeLibraryLoadStatistics", "Lcom/tencent/mobileqq/triton/statistic/NativeLibraryLoadStatistic;", "initEngineStartTimeMs", "loadEngineScriptStartTimeMs", "onSubpackageLoaded", "onV8OOM", "performLaunch", "performLoadSubpackage", "result", "Lkotlin/Result;", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class GameLauncher {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String ENV_VERSION_PREFIX = "\n__wxConfig.envVersion = ";
    private static final String GAME_JSON_PREFIX = "\n__wxConfig.gameJson = ";
    private static final String INIT_JSLIB = "\nif (typeof global.__ttObjdec__.iniJsLib === 'function') {global.__ttObjdec__.iniJsLib()}";
    private static final String INIT_WXCONFIG = "var __wxConfig = __wxConfig || {};";

    @NotNull
    public static final String TAG = "GameLauncher";
    private static final String WINDOW_UNDEFINED = "\nwindow = undefined";
    private volatile EngineInitStatistic mEngineInitStatistic;
    private GameLaunchCallback mGameLaunchCallback;
    private final ArrayList<ScriptLoadStatistic> mGameScriptLoadStatics;
    private Runnable mLaunchAfterInit;
    private long mLaunchGameEndTime;
    private final TTEngine mTritonEngine;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/triton/game/GameLauncher$Companion;", "", "()V", "ENV_VERSION_PREFIX", "", "GAME_JSON_PREFIX", "INIT_JSLIB", "INIT_WXCONFIG", "TAG", "WINDOW_UNDEFINED", "isAllSuccess", "", "statics", "", "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "Triton_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isAllSuccess(List<ScriptLoadStatistic> statics) {
            boolean z16;
            if (!statics.isEmpty()) {
                List<ScriptLoadStatistic> list = statics;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (!((ScriptLoadStatistic) it.next()).getLoadResult().getIsSuccess()) {
                            z16 = false;
                            break;
                        }
                    }
                }
                z16 = true;
                if (z16) {
                    return true;
                }
            }
            return false;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GameLauncher(@NotNull TTEngine mTritonEngine) {
        Intrinsics.checkParameterIsNotNull(mTritonEngine, "mTritonEngine");
        this.mTritonEngine = mTritonEngine;
        this.mGameScriptLoadStatics = new ArrayList<>();
    }

    private final String genConfig(Object value) {
        if (value instanceof Map) {
            return new JSONObject((Map) value).toString();
        }
        if (value instanceof String) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append('\"');
            sb5.append(value);
            sb5.append('\"');
            return sb5.toString();
        }
        return String.valueOf(value);
    }

    private final String getOptionConfig(Map<String, ? extends Object> map) {
        String str = "\n//optional properties\n";
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            str = str + "__wxConfig." + entry.getKey() + " = " + genConfig(entry.getValue()) + '\n';
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void injectGameInfo() {
        ScriptRuntime scriptEngine = this.mTritonEngine.getEngineContext().getScriptSystem().getScriptEngine(ScriptContextType.MAIN);
        ScriptRuntime scriptEngine2 = this.mTritonEngine.getEngineContext().getScriptSystem().getScriptEngine(ScriptContextType.OPEN_DATA);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(INIT_WXCONFIG);
        sb5.append(ENV_VERSION_PREFIX);
        sb5.append('\'' + this.mTritonEngine.getEngineContext().getGamePackage().getEnvironment().getEnvironment() + '\'');
        sb5.append(GAME_JSON_PREFIX);
        sb5.append(this.mTritonEngine.getEngineContext().getGamePackage().getGameConfig());
        sb5.append(getOptionConfig(this.mTritonEngine.getEngineContext().getGamePackage().getOptionConfig()));
        sb5.append(INIT_JSLIB);
        sb5.append(WINDOW_UNDEFINED);
        String sb6 = sb5.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb6, "StringBuilder().apply(builderAction).toString()");
        scriptEngine.evaluateJs(sb6);
        scriptEngine2.evaluateJs(sb6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyGameLaunched(long launchTimesMs, List<ScriptLoadStatistic> gameScriptLoadStatics, Throwable failure) {
        boolean z16;
        TritonException tritonException;
        TritonException tritonException2;
        this.mLaunchGameEndTime = SystemClock.uptimeMillis();
        EngineInitStatistic engineInitStatistic = this.mEngineInitStatistic;
        if (engineInitStatistic == null) {
            Intrinsics.throwNpe();
        }
        if (engineInitStatistic.getSuccess() && failure == null && INSTANCE.isAllSuccess(gameScriptLoadStatics)) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z17 = z16;
        if (failure == null) {
            EngineInitStatistic engineInitStatistic2 = this.mEngineInitStatistic;
            if (engineInitStatistic2 == null) {
                Intrinsics.throwNpe();
            }
            failure = engineInitStatistic2.getException();
        }
        if (failure != null) {
            ErrorCodes errorCodes = ErrorCodes.SCRIPT_LOAD_FAIL;
            if (failure instanceof TritonException) {
                tritonException2 = (TritonException) failure;
            } else {
                String message = failure.getMessage();
                if (message == null) {
                    message = "";
                }
                tritonException2 = new TritonException(message, errorCodes, failure);
            }
            tritonException = tritonException2;
        } else {
            tritonException = null;
        }
        EngineInitStatistic engineInitStatistic3 = this.mEngineInitStatistic;
        if (engineInitStatistic3 == null) {
            Intrinsics.throwNpe();
        }
        GameLaunchStatistic gameLaunchStatistic = new GameLaunchStatistic(z17, tritonException, launchTimesMs, gameScriptLoadStatics, engineInitStatistic3);
        GameLaunchCallback gameLaunchCallback = this.mGameLaunchCallback;
        if (gameLaunchCallback == null) {
            Intrinsics.throwNpe();
        }
        gameLaunchCallback.onGameLaunched(null, gameLaunchStatistic);
        this.mEngineInitStatistic = null;
        if (!gameLaunchStatistic.getSuccess()) {
            Logger.e(TAG, "launchGame failed " + gameLaunchStatistic, gameLaunchStatistic.getException());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSubpackageLoaded(final String name, Function1<? super ScriptLoadStatistic, Unit> onComplete, final ScriptLoadStatistic statistics) {
        onComplete.invoke(statistics);
        final SubpackageLoadStatisticsCallback value = this.mTritonEngine.getEngineContext().getStatisticsManager().getSubpackageLoadStatisticsCallback().getValue();
        if (value != null) {
            this.mTritonEngine.getEngineContext().getMainThreadExecutor().execute(new Runnable() { // from class: com.tencent.mobileqq.triton.game.GameLauncher$onSubpackageLoaded$$inlined$let$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    SubpackageLoadStatisticsCallback.this.onSubpackageLoaded(name, statistics);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performLaunch(GameLaunchCallback callback, final GameLaunchParam param, final Function0<Unit> onLaunchBegin) {
        this.mGameLaunchCallback = callback;
        EngineInitStatistic engineInitStatistic = this.mEngineInitStatistic;
        if (engineInitStatistic == null) {
            Intrinsics.throwNpe();
        }
        if (!engineInitStatistic.getSuccess()) {
            GameLaunchCallback gameLaunchCallback = this.mGameLaunchCallback;
            if (gameLaunchCallback == null) {
                Intrinsics.throwNpe();
            }
            ArrayList<ScriptLoadStatistic> arrayList = this.mGameScriptLoadStatics;
            EngineInitStatistic engineInitStatistic2 = this.mEngineInitStatistic;
            if (engineInitStatistic2 == null) {
                Intrinsics.throwNpe();
            }
            gameLaunchCallback.onGameLaunched(null, new GameLaunchStatistic(false, null, 0L, arrayList, engineInitStatistic2));
            return;
        }
        this.mTritonEngine.setInspectorAgent(param.getInspectorAgent());
        this.mTritonEngine.initGameInfo();
        this.mTritonEngine.postRunnable(new Runnable() { // from class: com.tencent.mobileqq.triton.game.GameLauncher$performLaunch$1
            @Override // java.lang.Runnable
            public final void run() {
                TTEngine tTEngine;
                TTEngine tTEngine2;
                TTEngine tTEngine3;
                ArrayList arrayList2;
                TTEngine tTEngine4;
                TTEngine tTEngine5;
                ArrayList arrayList3;
                Object value;
                TTEngine tTEngine6;
                ArrayList arrayList4;
                long uptimeMillis = SystemClock.uptimeMillis();
                tTEngine = GameLauncher.this.mTritonEngine;
                tTEngine2 = GameLauncher.this.mTritonEngine;
                JNICaller.TTEngine.nativeSetWebglTwoEnable(tTEngine, tTEngine2.getNativeTTAppHandle(), param.isWebgl2Enable());
                try {
                    onLaunchBegin.invoke();
                    GameLauncher.this.injectGameInfo();
                    ScriptLoader scriptLoader = ScriptLoader.INSTANCE;
                    tTEngine4 = GameLauncher.this.mTritonEngine;
                    Map<ScriptContextType, ScriptFile> gameScripts = scriptLoader.getGameScripts(tTEngine4.getEngineContext().getGamePackage());
                    ScriptContextType scriptContextType = ScriptContextType.OPEN_DATA;
                    ScriptFile scriptFile = gameScripts.get(scriptContextType);
                    if (scriptFile != null && scriptFile.getValid()) {
                        tTEngine6 = GameLauncher.this.mTritonEngine;
                        ScriptRuntime scriptEngine = tTEngine6.getEngineContext().getScriptSystem().getScriptEngine(scriptContextType);
                        arrayList4 = GameLauncher.this.mGameScriptLoadStatics;
                        arrayList4.add(scriptEngine.loadScript(scriptFile));
                    }
                    tTEngine5 = GameLauncher.this.mTritonEngine;
                    ScriptSystem scriptSystem = tTEngine5.getEngineContext().getScriptSystem();
                    ScriptContextType scriptContextType2 = ScriptContextType.MAIN;
                    ScriptRuntime scriptEngine2 = scriptSystem.getScriptEngine(scriptContextType2);
                    arrayList3 = GameLauncher.this.mGameScriptLoadStatics;
                    value = MapsKt__MapsKt.getValue(gameScripts, scriptContextType2);
                    if (value == null) {
                        Intrinsics.throwNpe();
                    }
                    arrayList3.add(scriptEngine2.loadScript((ScriptFile) value));
                    th = null;
                } catch (Throwable th5) {
                    th = th5;
                }
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("launch game [");
                tTEngine3 = GameLauncher.this.mTritonEngine;
                sb5.append(tTEngine3.getEngineContext().getGamePackage().getId());
                sb5.append("] cost time: ");
                sb5.append(uptimeMillis2);
                sb5.append(" ms");
                Logger.i$default(GameLauncher.TAG, sb5.toString(), null, 4, null);
                GameLauncher gameLauncher = GameLauncher.this;
                arrayList2 = gameLauncher.mGameScriptLoadStatics;
                gameLauncher.notifyGameLaunched(uptimeMillis2, arrayList2, th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performLoadSubpackage(final String name, Object result, final Function1<? super ScriptLoadStatistic, Unit> onComplete) {
        Object value;
        String str;
        File path;
        try {
            ResultKt.throwOnFailure(result);
            Map<ScriptContextType, ScriptFile> subPackageScripts = ScriptLoader.INSTANCE.getSubPackageScripts(Utils.decorateSubPackage((ScriptPackage) result, this.mTritonEngine.getEngineContext().getEnableCodeCache(), name));
            ScriptContextType scriptContextType = ScriptContextType.MAIN;
            value = MapsKt__MapsKt.getValue(subPackageScripts, scriptContextType);
            final ScriptFile scriptFile = (ScriptFile) value;
            if (scriptFile != null && scriptFile.getValid()) {
                final ScriptRuntime scriptEngine = this.mTritonEngine.getEngineContext().getScriptSystem().getScriptEngine(scriptContextType);
                scriptEngine.runOnScriptThread(new Runnable() { // from class: com.tencent.mobileqq.triton.game.GameLauncher$performLoadSubpackage$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameLauncher.this.onSubpackageLoaded(name, onComplete, scriptEngine.loadScript(scriptFile));
                    }
                });
                return;
            }
            ScriptLoadResult scriptLoadResult = ScriptLoadResult.SUCCESS_WITHOUT_CACHE;
            String str2 = "subPackage " + name;
            if (!(scriptFile instanceof ScriptFile.Path)) {
                scriptFile = null;
            }
            ScriptFile.Path path2 = (ScriptFile.Path) scriptFile;
            if (path2 == null || (path = path2.getPath()) == null || (str = path.getAbsolutePath()) == null) {
                str = "";
            }
            onSubpackageLoaded(name, onComplete, new ScriptLoadStatistic(scriptLoadResult, scriptContextType, str2, str, 0L, 0L, 0L, 0L, "no script file", 0L, 512, null));
        } catch (Throwable th5) {
            onSubpackageLoaded(name, onComplete, new ScriptLoadStatistic(ScriptLoadResult.FAIL_READ_SCRIPT, ScriptContextType.MAIN, "subPackage " + name, "game.js", 0L, 0L, 0L, 0L, th5.getClass().getName() + TokenParser.SP + th5.getMessage() + TokenParser.SP + Log.getStackTraceString(th5), 0L, 512, null));
        }
    }

    public final void launchGame(@NotNull final GameLaunchParam param, @NotNull final GameLaunchCallback callback, @NotNull final Function0<Unit> onLaunchBegin) {
        Intrinsics.checkParameterIsNotNull(param, "param");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        Intrinsics.checkParameterIsNotNull(onLaunchBegin, "onLaunchBegin");
        this.mTritonEngine.getRenderContext().attachGameView(param.getGameView());
        synchronized (this) {
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.triton.game.GameLauncher$launchGame$$inlined$synchronized$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    GameLauncher.this.performLaunch(callback, param, onLaunchBegin);
                }
            };
            if (this.mEngineInitStatistic == null) {
                this.mLaunchAfterInit = runnable;
            } else {
                runnable.run();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void loadSubpackage(@NotNull final String name, @NotNull final Function2<? super Long, ? super Long, Unit> onProgress, @NotNull final Function1<? super ScriptLoadStatistic, Unit> onComplete) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(onProgress, "onProgress");
        Intrinsics.checkParameterIsNotNull(onComplete, "onComplete");
        this.mTritonEngine.getEngineContext().getWorkerExecutor().execute(new Runnable() { // from class: com.tencent.mobileqq.triton.game.GameLauncher$loadSubpackage$1
            @Override // java.lang.Runnable
            public final void run() {
                TTEngine tTEngine;
                tTEngine = GameLauncher.this.mTritonEngine;
                tTEngine.getEngineContext().getGamePackage().getSubpackage(name, new GamePackage.SubpackageListener() { // from class: com.tencent.mobileqq.triton.game.GameLauncher$loadSubpackage$1.1
                    @Override // com.tencent.mobileqq.triton.filesystem.GamePackage.SubpackageListener
                    public void onComplete(@NotNull Object result) {
                        GameLauncher$loadSubpackage$1 gameLauncher$loadSubpackage$1 = GameLauncher$loadSubpackage$1.this;
                        GameLauncher.this.performLoadSubpackage(name, result, onComplete);
                    }

                    @Override // com.tencent.mobileqq.triton.filesystem.GamePackage.SubpackageListener
                    public void onProgress(long totalBytes, long currentBytes) {
                        onProgress.invoke(Long.valueOf(totalBytes), Long.valueOf(currentBytes));
                    }
                });
            }
        });
    }

    public final void onFirstRender() {
        GameLaunchCallback gameLaunchCallback = this.mGameLaunchCallback;
        if (gameLaunchCallback == null) {
            Intrinsics.throwNpe();
        }
        gameLaunchCallback.onFirstFrame(new FirstFrameStatistic(SystemClock.uptimeMillis() - this.mLaunchGameEndTime, this.mTritonEngine.getCurrentDrawCount()));
    }

    public final synchronized void onInitDone(@NotNull ErrorCodes error, long loadSoTimeMs, long loadEngineScriptTimeMs, long createEGLContextTimeMs, long initTimeMs, @NotNull ArrayList<ScriptLoadStatistic> statics, @Nullable TritonException engineScriptInitException, @NotNull ArrayList<NativeLibraryLoadStatistic> nativeLibraryLoadStatistics, long initEngineStartTimeMs, long loadEngineScriptStartTimeMs) {
        TritonException tritonException;
        boolean z16;
        Object obj;
        Intrinsics.checkParameterIsNotNull(error, "error");
        Intrinsics.checkParameterIsNotNull(statics, "statics");
        Intrinsics.checkParameterIsNotNull(nativeLibraryLoadStatistics, "nativeLibraryLoadStatistics");
        boolean isAllSuccess = INSTANCE.isAllSuccess(statics);
        if (engineScriptInitException == null && !isAllSuccess) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("init engine failed to load script ");
            Iterator<T> it = statics.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (!((ScriptLoadStatistic) obj).getLoadResult().getIsSuccess()) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            sb5.append((ScriptLoadStatistic) obj);
            tritonException = new TritonException(sb5.toString(), ErrorCodes.SCRIPT_LOAD_FAIL, null, 4, null);
        } else {
            tritonException = engineScriptInitException;
        }
        if (tritonException == null && !error.getSuccess()) {
            tritonException = new TritonException("failed to Init Engine", error, null, 4, null);
        }
        TritonException tritonException2 = tritonException;
        if (tritonException2 == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mEngineInitStatistic = new EngineInitStatistic(z16, tritonException2, loadSoTimeMs, loadEngineScriptTimeMs, createEGLContextTimeMs, initTimeMs, statics, nativeLibraryLoadStatistics, initEngineStartTimeMs, loadEngineScriptStartTimeMs);
        Runnable runnable = this.mLaunchAfterInit;
        if (runnable != null) {
            if (runnable == null) {
                Intrinsics.throwNpe();
            }
            runnable.run();
            this.mLaunchAfterInit = null;
        }
    }

    public final void onV8OOM() {
        GameLaunchCallback gameLaunchCallback = this.mGameLaunchCallback;
        if (gameLaunchCallback != null) {
            gameLaunchCallback.onV8OOM();
        }
    }
}
