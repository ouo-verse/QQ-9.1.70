package com.tencent.qqmini.minigame;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.EngineData;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.mobileqq.triton.script.ScriptPlugin;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.tritonaudio.WebAudioPlugin;
import com.tencent.qqmini.minigame.plugins.AudioRecorderJsPlugin;
import com.tencent.qqmini.minigame.report.MiniGameBeaconReport;
import com.tencent.qqmini.minigame.utils.LogFilterUtil;
import com.tencent.qqmini.minigame.utils.PluginLogger;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.plugins.engine.MiniGameJsPluginEngine;
import com.tencent.qqmini.sdk.utils.BrotliUtil;
import com.tencent.qqmini.sdk.utils.d;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 E2\u00020\u0001:\u0001EB\u0011\b\u0000\u0012\u0006\u0010B\u001a\u00020A\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R2\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001b0&j\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001b`'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R \u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0013\u0010<\u001a\u0004\u0018\u0001098F\u00a2\u0006\u0006\u001a\u0004\b:\u0010;R\u0013\u0010@\u001a\u0004\u0018\u00010=8F\u00a2\u0006\u0006\u001a\u0004\b>\u0010?\u00a8\u0006F"}, d2 = {"Lcom/tencent/qqmini/minigame/GameJsPluginEngine;", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "", "loadMiniGameSoAsync", "Lcom/tencent/mobileqq/triton/script/Argument;", "arguments", "cacheCommonJsService", "", AdMetricTag.EVENT_NAME, "", "startTime", "recordJsEventCost", "reportJsEventCostDurLaunch", "onCall", "Lcom/tencent/mobileqq/triton/TritonEngine;", EnginePathProvider.ENGINE_DIR, "onCreate", "onStart", DKHippyEvent.EVENT_STOP, "onActStart", "onActStop", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onFirstFrame", "handleFocusLoss", "handleFocusGain", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "contextType", "Lcom/tencent/qqmini/sdk/launcher/core/IJsService;", "getCommonJsService", "Lcom/tencent/qqmini/sdk/auth/a;", "authChecker", "setAuthChecker", "Lcom/tencent/qqmini/minigame/GameRuntime;", "gameRuntime", "Lcom/tencent/qqmini/minigame/GameRuntime;", "Lcom/tencent/qqmini/sdk/plugins/engine/MiniGameJsPluginEngine;", "jsPluginEngine", "Lcom/tencent/qqmini/sdk/plugins/engine/MiniGameJsPluginEngine;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "commonJsServiceMap", "Ljava/util/HashMap;", "Lcom/tencent/qqmini/minigame/utils/PluginLogger;", "logger", "Lcom/tencent/qqmini/minigame/utils/PluginLogger;", "Lcom/tencent/mobileqq/tritonaudio/InnerAudioPlugin;", "innerAudio", "Lcom/tencent/mobileqq/tritonaudio/InnerAudioPlugin;", "Lcom/tencent/mobileqq/tritonaudio/WebAudioPlugin;", "webAudio", "Lcom/tencent/mobileqq/tritonaudio/WebAudioPlugin;", "", "mFirstFrameFinished", "Z", "Ljava/util/concurrent/ConcurrentHashMap;", "mLaunchJsEventRecord", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/qqmini/sdk/launcher/core/BaseRuntime;", "getRuntime", "()Lcom/tencent/qqmini/sdk/launcher/core/BaseRuntime;", "runtime", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/engine/IJsPluginEngine;", "getRealPluginEngine", "()Lcom/tencent/qqmini/sdk/launcher/core/plugins/engine/IJsPluginEngine;", "realPluginEngine", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Companion", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class GameJsPluginEngine implements ScriptPlugin {
    private static final String BROTLI_SO_NAME = "brotli";
    private static final String LAMEMP3_SO_NAME = "lamemp3";
    private static final String TAG = "GameJsPluginEngine";
    private static final String WEBAUDIO_SO_NAME = "webaudio";
    private HashMap<ScriptContextType, IJsService> commonJsServiceMap;
    private GameRuntime gameRuntime;
    private final InnerAudioPlugin innerAudio;
    private MiniGameJsPluginEngine jsPluginEngine;
    private final PluginLogger logger;
    private boolean mFirstFrameFinished;
    private final ConcurrentHashMap<String, Long> mLaunchJsEventRecord;
    private final WebAudioPlugin webAudio;

    public GameJsPluginEngine(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.jsPluginEngine = new MiniGameJsPluginEngine(context);
        this.commonJsServiceMap = new HashMap<>();
        PluginLogger pluginLogger = new PluginLogger();
        this.logger = pluginLogger;
        this.innerAudio = new InnerAudioPlugin();
        this.webAudio = new WebAudioPlugin();
        this.mLaunchJsEventRecord = new ConcurrentHashMap<>();
        Map<String, Set<String>> logWhiteList = LogFilterUtil.getLogWhiteList();
        Intrinsics.checkExpressionValueIsNotNull(logWhiteList, "LogFilterUtil.getLogWhiteList()");
        Map<String, Set<String>> logBlackList = LogFilterUtil.getLogBlackList();
        Intrinsics.checkExpressionValueIsNotNull(logBlackList, "LogFilterUtil.getLogBlackList()");
        pluginLogger.setConfig(logWhiteList, logBlackList);
    }

    private final void cacheCommonJsService(final Argument arguments) {
        if (this.commonJsServiceMap.get(arguments.getContextType()) == null) {
            this.commonJsServiceMap.put(arguments.getContextType(), new IJsService() { // from class: com.tencent.qqmini.minigame.GameJsPluginEngine$cacheCommonJsService$jsService$1
                @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
                public int createNativeBuffer(@NotNull byte[] buffer, long offset, long length) {
                    Intrinsics.checkParameterIsNotNull(buffer, "buffer");
                    return arguments.createBuffer(buffer, offset, length);
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
                public void evaluateCallbackJs(int callbackId, @Nullable String result) {
                    onInvokeForbiddenMethod("evaluateCallbackJs");
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
                public void evaluateJs(@Nullable String js5, @Nullable ValueCallback<?> valueCallback) {
                    onInvokeForbiddenMethod("evaluateJs");
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
                public void evaluateSubscribeJS(@NotNull String eventName, @Nullable String data, int webviweId) {
                    PluginLogger pluginLogger;
                    Intrinsics.checkParameterIsNotNull(eventName, "eventName");
                    pluginLogger = GameJsPluginEngine.this.logger;
                    pluginLogger.printEndLog(eventName, data);
                    arguments.subscribe(eventName, data);
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
                @Nullable
                public byte[] getNativeBuffer(int bufferId) {
                    return arguments.getBuffer(bufferId);
                }

                public final void onInvokeForbiddenMethod(@NotNull String method) {
                    Intrinsics.checkParameterIsNotNull(method, "method");
                    MiniAppProxy proxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
                    Intrinsics.checkExpressionValueIsNotNull(proxy, "proxy");
                    if (!proxy.isDebugVersion()) {
                        QMLog.e("GameJsPluginEngine", "can not invoke " + method + " on minigame common JsService");
                        return;
                    }
                    throw new RuntimeException("can not invoke " + method + " on minigame common JsService");
                }
            });
        }
    }

    private final void loadMiniGameSoAsync() {
        ThreadManager.runNetTask(new Runnable() { // from class: com.tencent.qqmini.minigame.GameJsPluginEngine$loadMiniGameSoAsync$1

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqmini/minigame/GameJsPluginEngine$loadMiniGameSoAsync$1$a", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$SoLoadListener;", "", "soPath", "", "onSuccess", "", "errorCode", "onFail", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
            /* loaded from: classes23.dex */
            public static final class a implements DownloaderProxy.SoLoadListener {
                a() {
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.SoLoadListener
                public void onFail(int errorCode) {
                    QMLog.e("GameJsPluginEngine", "brotliLoadListener fail, errorCode=" + errorCode);
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.SoLoadListener
                public void onSuccess(@NotNull String soPath) {
                    Intrinsics.checkParameterIsNotNull(soPath, "soPath");
                    BrotliUtil.f348352b.b(soPath);
                    d.c(soPath);
                }
            }

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqmini/minigame/GameJsPluginEngine$loadMiniGameSoAsync$1$b", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$SoLoadListener;", "", "soPath", "", "onSuccess", "", "errorCode", "onFail", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
            /* loaded from: classes23.dex */
            public static final class b implements DownloaderProxy.SoLoadListener {
                b() {
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.SoLoadListener
                public void onFail(int errorCode) {
                    QMLog.e("GameJsPluginEngine", "lameMp3LoadListener fail, errorCode=" + errorCode);
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.SoLoadListener
                public void onSuccess(@NotNull String soPath) {
                    GameRuntime gameRuntime;
                    Intrinsics.checkParameterIsNotNull(soPath, "soPath");
                    gameRuntime = GameJsPluginEngine.this.gameRuntime;
                    if (gameRuntime == null) {
                        Intrinsics.throwNpe();
                    }
                    AudioRecorderJsPlugin.setLameMp3SoPath(gameRuntime.getContext(), soPath);
                    d.c(soPath);
                }
            }

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqmini/minigame/GameJsPluginEngine$loadMiniGameSoAsync$1$c", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/DownloaderProxy$SoLoadListener;", "", "soPath", "", "onSuccess", "", "errorCode", "onFail", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
            /* loaded from: classes23.dex */
            public static final class c implements DownloaderProxy.SoLoadListener {
                c() {
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.SoLoadListener
                public void onFail(int errorCode) {
                    QMLog.e("GameJsPluginEngine", "webAudioLoadListener fail, errorCode=" + errorCode);
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.SoLoadListener
                public void onSuccess(@NotNull String soPath) {
                    Intrinsics.checkParameterIsNotNull(soPath, "soPath");
                    WebAudioPlugin.INSTANCE.loadWebAudioSo(soPath);
                    d.c(soPath);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                DownloaderProxy downloaderProxy = (DownloaderProxy) ProxyManager.get(DownloaderProxy.class);
                downloaderProxy.loadMiniGameSo("webaudio", new c());
                downloaderProxy.loadMiniGameSo("lamemp3", new b());
                downloaderProxy.loadMiniGameSo("brotli", new a());
            }
        });
    }

    private final void recordJsEventCost(String eventName, long startTime) {
        if (!this.mFirstFrameFinished) {
            long currentTimeMillis = System.currentTimeMillis() - startTime;
            Long l3 = this.mLaunchJsEventRecord.get(eventName);
            if (l3 == null || currentTimeMillis > l3.longValue()) {
                this.mLaunchJsEventRecord.put(eventName, Long.valueOf(currentTimeMillis));
            }
        }
    }

    private final void reportJsEventCostDurLaunch() {
        BaseRuntime runtime;
        MiniAppInfo miniAppInfo;
        String str;
        Map<String, Long> map;
        if ((!this.mLaunchJsEventRecord.isEmpty()) && (runtime = getRuntime()) != null && (miniAppInfo = runtime.getMiniAppInfo()) != null && (str = miniAppInfo.appId) != null) {
            MiniGameBeaconReport miniGameBeaconReport = MiniGameBeaconReport.INSTANCE;
            map = MapsKt__MapsKt.toMap(this.mLaunchJsEventRecord);
            miniGameBeaconReport.reportGameLaunchJsEventCost(str, map);
            this.mLaunchJsEventRecord.clear();
        }
    }

    @Nullable
    public final IJsService getCommonJsService(@NotNull ScriptContextType contextType) {
        Intrinsics.checkParameterIsNotNull(contextType, "contextType");
        return this.commonJsServiceMap.get(contextType);
    }

    @Nullable
    public final IJsPluginEngine getRealPluginEngine() {
        return this.jsPluginEngine;
    }

    @Nullable
    public final BaseRuntime getRuntime() {
        return this.gameRuntime;
    }

    public final void handleFocusGain() {
        this.innerAudio.handleFocusGain();
    }

    public final void handleFocusLoss() {
        this.innerAudio.handleFocusLoss();
    }

    public final void onActStart() {
        this.jsPluginEngine.onStart();
    }

    public final void onActStop() {
        this.jsPluginEngine.onStop();
    }

    @Override // com.tencent.mobileqq.triton.script.ScriptPlugin
    @Nullable
    public String onCall(@NotNull String eventName, @NotNull Argument arguments) throws IllegalArgumentException {
        String handleNativeRequest;
        String str;
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        cacheCommonJsService(arguments);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.innerAudio.support(eventName)) {
            handleNativeRequest = this.innerAudio.onCall(eventName, arguments);
        } else if (this.webAudio.support(eventName)) {
            handleNativeRequest = this.webAudio.onCall(eventName, arguments);
        } else {
            handleNativeRequest = this.jsPluginEngine.handleNativeRequest(eventName, arguments.getRawParams(), new GameJsService(arguments, this.logger), arguments.getCallbackId(), 0);
        }
        recordJsEventCost(eventName, currentTimeMillis);
        PluginLogger pluginLogger = this.logger;
        ScriptContextType contextType = arguments.getContextType();
        String rawParams = arguments.getRawParams();
        int callbackId = arguments.getCallbackId();
        if (handleNativeRequest != null) {
            str = handleNativeRequest;
        } else {
            str = "{}";
        }
        pluginLogger.printStartLog(contextType, eventName, rawParams, callbackId, str);
        return handleNativeRequest;
    }

    @Override // com.tencent.mobileqq.triton.script.ScriptPlugin
    public void onCreate(@NotNull TritonEngine engine) {
        Intrinsics.checkParameterIsNotNull(engine, "engine");
        EngineData data = engine.getData();
        boolean z16 = GameRuntime.sStorageReport;
        Intrinsics.checkExpressionValueIsNotNull(GameRuntime.class, "Class.forName(\"com.tence\u2026ni.minigame.GameRuntime\")");
        Object obj = data.get(GameRuntime.class);
        if (obj != null) {
            GameRuntime gameRuntime = (GameRuntime) obj;
            this.gameRuntime = gameRuntime;
            this.jsPluginEngine.onCreate(gameRuntime);
            GameRuntime gameRuntime2 = this.gameRuntime;
            if (gameRuntime2 == null) {
                Intrinsics.throwNpe();
            }
            gameRuntime2.setJsPluginEngine(this);
            this.innerAudio.onCreate(engine);
            this.webAudio.onCreate(engine);
            loadMiniGameSoAsync();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.qqmini.minigame.GameRuntime");
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onDestroy() {
        ScriptPlugin.DefaultImpls.onDestroy(this);
        this.jsPluginEngine.onDestroy();
        this.innerAudio.onDestroy();
        this.webAudio.onDestroy();
        this.commonJsServiceMap.clear();
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onFirstFrame() {
        ScriptPlugin.DefaultImpls.onFirstFrame(this);
        this.mFirstFrameFinished = true;
        reportJsEventCostDurLaunch();
        this.jsPluginEngine.e();
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onGameLaunched(@NotNull TritonEngine engine) {
        Intrinsics.checkParameterIsNotNull(engine, "engine");
        ScriptPlugin.DefaultImpls.onGameLaunched(this, engine);
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onStart() {
        ScriptPlugin.DefaultImpls.onStart(this);
        this.jsPluginEngine.onResume();
        this.innerAudio.onStart();
        this.webAudio.onStart();
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onStop() {
        ScriptPlugin.DefaultImpls.onStop(this);
        this.jsPluginEngine.onPause();
        this.innerAudio.onStop();
        this.webAudio.onStop();
        this.logger.printFailedApi();
    }

    public final void setAuthChecker(@NotNull com.tencent.qqmini.sdk.auth.a authChecker) {
        Intrinsics.checkParameterIsNotNull(authChecker, "authChecker");
        this.jsPluginEngine.f(authChecker);
    }
}
