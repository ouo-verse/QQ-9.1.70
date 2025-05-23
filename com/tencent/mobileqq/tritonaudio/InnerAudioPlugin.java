package com.tencent.mobileqq.tritonaudio;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.zd.n;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.script.ComposableScriptPlugin;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.tritonaudio.inneraudio.AudioPlayerManager;
import com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener;
import com.tencent.mobileqq.tritonaudio.internal.ApiUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.tvkplayer.report.capability.spatialaudio.TVKDeviceSpatialAudioCapabilityReportConstant;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 32\u00020\u0001:\u000234B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\fH\u0002J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\u0006\u0010!\u001a\u00020\u001cJ\u0006\u0010\"\u001a\u00020\u001cJ\u0010\u0010#\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u001a\u0010$\u001a\u0004\u0018\u00010\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u001cH\u0016J\b\u0010*\u001a\u00020\u001cH\u0016J\b\u0010+\u001a\u00020\u001cH\u0016J\u0010\u0010,\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0018\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u0010/\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u00100\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u00101\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\u000e\u00102\u001a\u00020\f2\u0006\u0010%\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/tritonaudio/InnerAudioPlugin;", "Lcom/tencent/mobileqq/triton/script/ComposableScriptPlugin;", "()V", "audioPlayerManager", "Lcom/tencent/mobileqq/tritonaudio/inneraudio/AudioPlayerManager;", "context", "Landroid/content/Context;", "interruptionMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/triton/script/Argument;", "isActivityPaused", "", "logger", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "mixWithOther", "onAudioFocusChangeListener", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "sId", "Ljava/util/concurrent/atomic/AtomicInteger;", "supportedEvents", "", "getSupportedEvents", "()Ljava/util/Set;", "createAudioInstance", "arguments", "destroyAudioInstance", "execAudioFocus", "", NodeProps.REQUEST_FOCUS, "getAudioState", "getAvailableAudioSources", "handleAbandonFocus", "handleFocusGain", "handleFocusLoss", InnerAudioPlugin.API_ON_AUDIO_TIME_UPDATE_REGISTER, "onCall", AdMetricTag.EVENT_NAME, "onCreate", EnginePathProvider.ENGINE_DIR, "Lcom/tencent/mobileqq/triton/TritonEngine;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onStart", DKHippyEvent.EVENT_STOP, "operateAudio", "saveAudioInterruptionCaller", "event", "setAudioState", n.NAME, "setMixWithOther", TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT, "Companion", "GameAudioStateChangeListener", "TritonAudio_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class InnerAudioPlugin implements ComposableScriptPlugin {

    @NotNull
    public static final String API_CREATE_AUDIO_INSTANCE = "createAudioInstance";

    @NotNull
    public static final String API_DESTROY_AUDIO_INSTANCE = "destroyAudioInstance";

    @NotNull
    public static final String API_GET_AUDIO_STATE = "getAudioState";

    @NotNull
    public static final String API_GET_AVAILABLE_AUDIO_SOURCES = "getAvailableAudioSources";

    @NotNull
    public static final String API_ON_AUDIO_TIME_UPDATE_REGISTER = "onAudioTimeUpdateRegister";

    @NotNull
    public static final String API_OPERATE_AUDIO = "operateAudio";

    @NotNull
    public static final String API_SET_AUDIO_STATE = "setAudioState";

    @NotNull
    public static final String API_SET_INNER_AUDIO_OPTION = "setInnerAudioOptionQGame";

    @NotNull
    public static final String AUDIO_OPERATE_PAUSE = "pause";

    @NotNull
    public static final String AUDIO_OPERATE_PLAY = "play";

    @NotNull
    public static final String AUDIO_OPERATE_SEEK = "seek";

    @NotNull
    public static final String AUDIO_OPERATE_STOP = "stop";

    @NotNull
    public static final String AUDIO_PROPERTY_AUTOPLAY = "autoplay";

    @NotNull
    public static final String AUDIO_PROPERTY_BUFFERED = "buffered";

    @NotNull
    public static final String AUDIO_PROPERTY_CURRENTTIME = "currentTime";

    @NotNull
    public static final String AUDIO_PROPERTY_DURATIOIN = "duration";

    @NotNull
    public static final String AUDIO_PROPERTY_LOOP = "loop";

    @NotNull
    public static final String AUDIO_PROPERTY_PAUSED = "paused";

    @NotNull
    public static final String AUDIO_PROPERTY_SRC = "src";

    @NotNull
    public static final String AUDIO_PROPERTY_STARTTIME = "startTime";

    @NotNull
    public static final String AUDIO_PROPERTY_VOLUME = "volume";

    @NotNull
    public static final String AUDIO_STATE_CANPLAY = "canplay";

    @NotNull
    public static final String AUDIO_STATE_ENDED = "ended";

    @NotNull
    public static final String AUDIO_STATE_ERROR = "error";

    @NotNull
    public static final String AUDIO_STATE_PAUSE = "pause";

    @NotNull
    public static final String AUDIO_STATE_PLAY = "play";

    @NotNull
    public static final String AUDIO_STATE_SEEKED = "seeked";

    @NotNull
    public static final String AUDIO_STATE_SEEKING = "seeking";

    @NotNull
    public static final String AUDIO_STATE_STOP = "stop";

    @NotNull
    public static final String AUDIO_STATE_TIMEUPDATE = "timeUpdate";

    @NotNull
    public static final String AUDIO_STATE_WAITING = "waiting";
    public static final int ERROR_FILE = 10003;
    public static final int ERROR_FORMAT = 10004;
    public static final int ERROR_NETWORK = 10002;
    public static final int ERROR_SYSTEM = 10001;
    public static final int ERROR_UNKNOWN = -1;

    @NotNull
    public static final String EVENT_INTERRUPTION_BEGIN = "onAudioInterruptionBegin";

    @NotNull
    public static final String EVENT_INTERRUPTION_END = "onAudioInterruptionEnd";

    @NotNull
    public static final String EVENT_ON_AUDIO_STATE_CHANGE = "onAudioStateChange";
    private static final String TAG = "[audio]InnerAudioPlugin";
    private static final Set<String> supportedEvents;
    private AudioPlayerManager audioPlayerManager;
    private Context context;
    private boolean isActivityPaused;
    private LogDelegate logger;
    private final AtomicInteger sId = new AtomicInteger();
    private volatile boolean mixWithOther = true;
    private final AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.tencent.mobileqq.tritonaudio.InnerAudioPlugin$onAudioFocusChangeListener$1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i3) {
            LogDelegate logDelegate;
            logDelegate = InnerAudioPlugin.this.logger;
            if (logDelegate != null) {
                LogDelegate.DefaultImpls.printLog$default(logDelegate, LogDelegate.Level.INFO, "[audio]InnerAudioPlugin", "onAudioFocusChange focusChange=" + i3, null, 8, null);
            }
            if (i3 != -2) {
                if (i3 == -1) {
                    InnerAudioPlugin.this.handleAbandonFocus();
                    return;
                } else {
                    if (i3 == 1) {
                        InnerAudioPlugin.this.handleFocusGain();
                        return;
                    }
                    return;
                }
            }
            InnerAudioPlugin.this.handleFocusLoss();
        }
    };
    private final HashMap<String, Argument> interruptionMap = new HashMap<>();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/tritonaudio/InnerAudioPlugin$GameAudioStateChangeListener;", "Lcom/tencent/mobileqq/tritonaudio/inneraudio/IAudioStateChangeListener;", WebAudioPlugin.AUDIO_ID, "", "arguments", "Lcom/tencent/mobileqq/triton/script/Argument;", "(ILcom/tencent/mobileqq/triton/script/Argument;)V", "evaluateAudioError", "", "what", "evaluateAudioState", "state", "", "onCanPlay", "onEnded", "onError", "errCode", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onPlay", "onSeeked", "onSeeking", DKHippyEvent.EVENT_STOP, "onTimeUpdate", "onWaiting", "TritonAudio_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class GameAudioStateChangeListener implements IAudioStateChangeListener {
        private final Argument arguments;
        private final int audioId;

        public GameAudioStateChangeListener(int i3, @NotNull Argument arguments) {
            Intrinsics.checkParameterIsNotNull(arguments, "arguments");
            this.audioId = i3;
            this.arguments = arguments;
        }

        private final void evaluateAudioError(int what) {
            String str;
            if (what != -1010) {
                if (what != -1007) {
                    if (what != -1004 && what != -110) {
                        if (what != 1) {
                            if (what != 100 && what != 200) {
                                switch (what) {
                                }
                            }
                        }
                        what = -1;
                    } else {
                        what = 10002;
                    }
                }
                what = 10001;
            } else {
                what = 10003;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WebAudioPlugin.AUDIO_ID, this.audioId);
            jSONObject.put("state", "error");
            jSONObject.put("errCode", what);
            if (what == 10001) {
                str = "\u7cfb\u7edf\u9519\u8bef";
            } else {
                str = "\u672a\u77e5\u9519\u8bef, \u8bf7\u590d\u7528InnerAudioContext\u5b9e\u4f8b\u3001\u53ca\u65f6\u91ca\u653e\u65e0\u7528\u5b9e\u4f8b";
            }
            jSONObject.put("errMsg", str);
            this.arguments.subscribe(InnerAudioPlugin.EVENT_ON_AUDIO_STATE_CHANGE, jSONObject.toString());
        }

        private final void evaluateAudioState(String state) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WebAudioPlugin.AUDIO_ID, this.audioId);
            jSONObject.put("state", state);
            this.arguments.subscribe(InnerAudioPlugin.EVENT_ON_AUDIO_STATE_CHANGE, jSONObject.toString());
        }

        @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener
        public void onCanPlay() {
            evaluateAudioState("canplay");
        }

        @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener
        public void onEnded() {
            evaluateAudioState("ended");
        }

        @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener
        public void onError(int errCode) {
            evaluateAudioError(errCode);
        }

        @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener
        public void onPause() {
            evaluateAudioState("pause");
        }

        @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener
        public void onPlay() {
            evaluateAudioState("play");
        }

        @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener
        public void onSeeked() {
            evaluateAudioState("seeked");
        }

        @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener
        public void onSeeking() {
            evaluateAudioState("seeking");
        }

        @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener
        public void onStop() {
            evaluateAudioState("stop");
        }

        @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener
        public void onTimeUpdate() {
            evaluateAudioState("timeUpdate");
        }

        @Override // com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener
        public void onWaiting() {
            evaluateAudioState("waiting");
        }
    }

    static {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"createAudioInstance", "destroyAudioInstance", "operateAudio", "setAudioState", "getAudioState", API_SET_INNER_AUDIO_OPTION, "getAvailableAudioSources", API_ON_AUDIO_TIME_UPDATE_REGISTER, EVENT_INTERRUPTION_BEGIN, EVENT_INTERRUPTION_END});
        supportedEvents = of5;
    }

    private final String createAudioInstance(final Argument arguments) {
        final int incrementAndGet = this.sId.incrementAndGet();
        TritonAudioThreadPool.getAudioExecutorService().execute(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.InnerAudioPlugin$createAudioInstance$1
            @Override // java.lang.Runnable
            public final void run() {
                AudioPlayerManager audioPlayerManager;
                InnerAudioPlugin.GameAudioStateChangeListener gameAudioStateChangeListener = new InnerAudioPlugin.GameAudioStateChangeListener(incrementAndGet, arguments);
                audioPlayerManager = InnerAudioPlugin.this.audioPlayerManager;
                if (audioPlayerManager != null) {
                    audioPlayerManager.createAudioContext(incrementAndGet, gameAudioStateChangeListener);
                }
            }
        });
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(WebAudioPlugin.AUDIO_ID, incrementAndGet);
        String jSONObject2 = ApiUtil.wrapCallbackOk("createAudioInstance", jSONObject).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "ApiUtil.wrapCallbackOk(A\u2026 audioContext).toString()");
        return jSONObject2;
    }

    private final String destroyAudioInstance(Argument arguments) {
        final int optInt = arguments.getParams().optInt(WebAudioPlugin.AUDIO_ID, -1);
        TritonAudioThreadPool.getAudioExecutorService().execute(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.InnerAudioPlugin$destroyAudioInstance$1
            @Override // java.lang.Runnable
            public final void run() {
                AudioPlayerManager audioPlayerManager;
                audioPlayerManager = InnerAudioPlugin.this.audioPlayerManager;
                if (audioPlayerManager != null) {
                    audioPlayerManager.destroyAudioContext(optInt);
                }
            }
        });
        String jSONObject = ApiUtil.wrapCallbackOk("destroyAudioInstance", null).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "ApiUtil.wrapCallbackOk(A\u2026NSTANCE, null).toString()");
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void execAudioFocus(boolean requestFocus) {
        Object obj;
        AudioPlayerManager audioPlayerManager;
        Argument argument;
        LogDelegate logDelegate = this.logger;
        if (logDelegate != null) {
            LogDelegate.DefaultImpls.printLog$default(logDelegate, LogDelegate.Level.INFO, TAG, "execAudioFocus focus=" + requestFocus, null, 8, null);
        }
        Context context = this.context;
        if (context != null) {
            obj = context.getSystemService("audio");
        } else {
            obj = null;
        }
        if (obj instanceof AudioManager) {
            if (requestFocus) {
                if (((AudioManager) obj).requestAudioFocus(this.onAudioFocusChangeListener, 3, 1) == 1 && (audioPlayerManager = this.audioPlayerManager) != null && audioPlayerManager.execAudioFocus() && (argument = this.interruptionMap.get(EVENT_INTERRUPTION_END)) != null) {
                    argument.subscribe(EVENT_INTERRUPTION_END, null);
                    return;
                }
                return;
            }
            ((AudioManager) obj).abandonAudioFocus(this.onAudioFocusChangeListener);
        }
    }

    private final String getAudioState(Argument arguments) {
        Double d16;
        Double d17;
        Double d18;
        Boolean bool;
        Float f16;
        Boolean bool2;
        int optInt = arguments.getParams().optInt(WebAudioPlugin.AUDIO_ID, -1);
        Boolean bool3 = null;
        if (optInt == -1) {
            String jSONObject = ApiUtil.wrapCallbackFail("getAudioState", null, "param error").toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject, "ApiUtil.wrapCallbackFail\u2026              .toString()");
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        AudioPlayerManager audioPlayerManager = this.audioPlayerManager;
        if (audioPlayerManager != null) {
            d16 = Double.valueOf(audioPlayerManager.getDuration(optInt));
        } else {
            d16 = null;
        }
        jSONObject2.put("duration", d16);
        AudioPlayerManager audioPlayerManager2 = this.audioPlayerManager;
        if (audioPlayerManager2 != null) {
            d17 = Double.valueOf(audioPlayerManager2.getCurPosition(optInt));
        } else {
            d17 = null;
        }
        jSONObject2.put(AUDIO_PROPERTY_CURRENTTIME, d17);
        AudioPlayerManager audioPlayerManager3 = this.audioPlayerManager;
        if (audioPlayerManager3 != null) {
            d18 = Double.valueOf(audioPlayerManager3.getBuffered(optInt));
        } else {
            d18 = null;
        }
        jSONObject2.put(AUDIO_PROPERTY_BUFFERED, d18);
        AudioPlayerManager audioPlayerManager4 = this.audioPlayerManager;
        if (audioPlayerManager4 != null) {
            bool = Boolean.valueOf(audioPlayerManager4.getPaused(optInt));
        } else {
            bool = null;
        }
        jSONObject2.put("paused", bool);
        AudioPlayerManager audioPlayerManager5 = this.audioPlayerManager;
        if (audioPlayerManager5 != null) {
            f16 = Float.valueOf(audioPlayerManager5.getStartTime(optInt));
        } else {
            f16 = null;
        }
        jSONObject2.put("startTime", f16);
        AudioPlayerManager audioPlayerManager6 = this.audioPlayerManager;
        if (audioPlayerManager6 != null) {
            bool2 = Boolean.valueOf(audioPlayerManager6.getAutoplay(optInt));
        } else {
            bool2 = null;
        }
        jSONObject2.put("autoplay", bool2);
        AudioPlayerManager audioPlayerManager7 = this.audioPlayerManager;
        if (audioPlayerManager7 != null) {
            bool3 = Boolean.valueOf(audioPlayerManager7.getLoop(optInt));
        }
        jSONObject2.put("loop", bool3);
        String jSONObject3 = ApiUtil.wrapCallbackOk("getAudioState", jSONObject2).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject3, "ApiUtil.wrapCallbackOk(A\u2026E, audioState).toString()");
        return jSONObject3;
    }

    private final String getAvailableAudioSources(Argument arguments) {
        JSONObject jSONObject = new JSONObject();
        String arrays = Arrays.toString(new String[]{"auto"});
        Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
        jSONObject.put("audioSources", arrays);
        String jSONObject2 = ApiUtil.wrapCallbackOk("getAvailableAudioSources", jSONObject).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "ApiUtil.wrapCallbackOk(A\u2026URCES, resObj).toString()");
        arguments.callback(jSONObject2);
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleAbandonFocus() {
        Object obj;
        Context context = this.context;
        if (context != null) {
            obj = context.getSystemService("audio");
        } else {
            obj = null;
        }
        if (obj instanceof AudioManager) {
            ((AudioManager) obj).abandonAudioFocus(this.onAudioFocusChangeListener);
        }
    }

    private final String onAudioTimeUpdateRegister(Argument arguments) {
        int optInt = arguments.getParams().optInt(WebAudioPlugin.AUDIO_ID, -1);
        LogDelegate logDelegate = this.logger;
        if (logDelegate != null) {
            LogDelegate.DefaultImpls.printLog$default(logDelegate, LogDelegate.Level.INFO, TAG, "onAudioTimeUpdateRegister id=" + optInt, null, 8, null);
        }
        AudioPlayerManager audioPlayerManager = this.audioPlayerManager;
        if (audioPlayerManager != null) {
            audioPlayerManager.onAudioTimeUpdateRegister(optInt);
        }
        String jSONObject = ApiUtil.wrapCallbackOk(API_ON_AUDIO_TIME_UPDATE_REGISTER, new JSONObject()).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "ApiUtil.wrapCallbackOk(A\u2026 ScriptData()).toString()");
        arguments.callback(jSONObject);
        return jSONObject;
    }

    private final String operateAudio(final Argument arguments) {
        TritonAudioThreadPool.getAudioExecutorService().execute(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.InnerAudioPlugin$operateAudio$1
            /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
            
                r1 = r4.this$0.audioPlayerManager;
             */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
            
                r1 = r4.this$0.audioPlayerManager;
             */
            /* JADX WARN: Code restructure failed: missing block: B:7:0x0031, code lost:
            
                r1 = r4.this$0.audioPlayerManager;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void run() {
                boolean z16;
                AudioPlayerManager audioPlayerManager;
                boolean z17;
                AudioPlayerManager audioPlayerManager2;
                AudioPlayerManager audioPlayerManager3;
                AudioPlayerManager audioPlayerManager4;
                int optInt = arguments.getParams().optInt(WebAudioPlugin.AUDIO_ID, -1);
                String optString = arguments.getParams().optString("operationType");
                if (optString != null) {
                    switch (optString.hashCode()) {
                        case 3443508:
                            if (optString.equals("play")) {
                                z16 = InnerAudioPlugin.this.isActivityPaused;
                                if (!z16) {
                                    audioPlayerManager = InnerAudioPlugin.this.audioPlayerManager;
                                    if (audioPlayerManager != null) {
                                        audioPlayerManager.playMusic(optInt);
                                    }
                                    z17 = InnerAudioPlugin.this.mixWithOther;
                                    if (!z17) {
                                        InnerAudioPlugin.this.execAudioFocus(true);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        case 3526264:
                            if (optString.equals(InnerAudioPlugin.AUDIO_OPERATE_SEEK) && audioPlayerManager2 != null) {
                                audioPlayerManager2.seekTo(optInt, (float) arguments.getParams().optDouble(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME));
                                return;
                            }
                            return;
                        case 3540994:
                            if (optString.equals("stop") && audioPlayerManager3 != null) {
                                audioPlayerManager3.stopMusic(optInt);
                                return;
                            }
                            return;
                        case 106440182:
                            if (optString.equals("pause") && audioPlayerManager4 != null) {
                                audioPlayerManager4.pauseMusic(optInt);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        String jSONObject = ApiUtil.wrapCallbackOk("operateAudio", null).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "ApiUtil.wrapCallbackOk(A\u2026E_AUDIO, null).toString()");
        return jSONObject;
    }

    private final String saveAudioInterruptionCaller(String event, Argument arguments) {
        if (!this.interruptionMap.containsKey(event)) {
            this.interruptionMap.put(event, arguments);
        }
        String jSONObject = ApiUtil.wrapCallbackOk(event, null).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "ApiUtil.wrapCallbackOk(event, null).toString()");
        return jSONObject;
    }

    private final String setAudioState(final Argument arguments) {
        TritonAudioThreadPool.getAudioExecutorService().execute(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.InnerAudioPlugin$setAudioState$1
            @Override // java.lang.Runnable
            public final void run() {
                LogDelegate logDelegate;
                AudioPlayerManager audioPlayerManager;
                AudioPlayerManager audioPlayerManager2;
                AudioPlayerManager audioPlayerManager3;
                AudioPlayerManager audioPlayerManager4;
                AudioPlayerManager audioPlayerManager5;
                try {
                    int optInt = arguments.getParams().optInt(WebAudioPlugin.AUDIO_ID, -1);
                    if (arguments.getParams().has("src")) {
                        String string = arguments.getParams().getString("src");
                        audioPlayerManager5 = InnerAudioPlugin.this.audioPlayerManager;
                        if (audioPlayerManager5 != null) {
                            audioPlayerManager5.setMusicPath(optInt, string);
                        }
                    } else if (arguments.getParams().has("autoplay")) {
                        boolean z16 = arguments.getParams().getBoolean("autoplay");
                        audioPlayerManager4 = InnerAudioPlugin.this.audioPlayerManager;
                        if (audioPlayerManager4 != null) {
                            audioPlayerManager4.setAutoplay(optInt, z16);
                        }
                    } else if (arguments.getParams().has("startTime")) {
                        double d16 = arguments.getParams().getDouble("startTime");
                        audioPlayerManager3 = InnerAudioPlugin.this.audioPlayerManager;
                        if (audioPlayerManager3 != null) {
                            audioPlayerManager3.setStartTime(optInt, (float) d16);
                        }
                    } else if (arguments.getParams().has("loop")) {
                        boolean z17 = arguments.getParams().getBoolean("loop");
                        audioPlayerManager2 = InnerAudioPlugin.this.audioPlayerManager;
                        if (audioPlayerManager2 != null) {
                            audioPlayerManager2.setLoop(optInt, z17);
                        }
                    } else if (arguments.getParams().has(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME)) {
                        double d17 = arguments.getParams().getDouble(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME);
                        audioPlayerManager = InnerAudioPlugin.this.audioPlayerManager;
                        if (audioPlayerManager != null) {
                            audioPlayerManager.setVolume(optInt, (float) d17);
                        }
                    }
                } catch (JSONException e16) {
                    logDelegate = InnerAudioPlugin.this.logger;
                    if (logDelegate != null) {
                        logDelegate.printLog(LogDelegate.Level.ERROR, "[audio]InnerAudioPlugin", "setAudioState exception:", e16);
                    }
                }
            }
        });
        String jSONObject = ApiUtil.wrapCallbackOk("setAudioState", null).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "ApiUtil.wrapCallbackOk(A\u2026O_STATE, null).toString()");
        return jSONObject;
    }

    private final String setInnerAudioOption(Argument arguments) {
        boolean optBoolean = arguments.getParams().optBoolean("mixWithOther", true);
        boolean optBoolean2 = arguments.getParams().optBoolean("obeyMuteSwitch", true);
        setMixWithOther(optBoolean);
        AudioPlayerManager audioPlayerManager = this.audioPlayerManager;
        if (audioPlayerManager != null) {
            audioPlayerManager.setMusicSwitch(optBoolean2);
        }
        String jSONObject = ApiUtil.wrapCallbackOk(API_SET_INNER_AUDIO_OPTION, null).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "ApiUtil.wrapCallbackOk(A\u2026_OPTION, null).toString()");
        arguments.callback(jSONObject);
        return jSONObject;
    }

    private final void setMixWithOther(boolean mixWithOther) {
        this.mixWithOther = mixWithOther;
        execAudioFocus(!mixWithOther);
    }

    @Override // com.tencent.mobileqq.triton.script.ComposableScriptPlugin
    @NotNull
    public Set<String> getSupportedEvents() {
        return supportedEvents;
    }

    public final void handleFocusGain() {
        TritonAudioThreadPool.getAudioExecutorService().execute(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.InnerAudioPlugin$handleFocusGain$1
            @Override // java.lang.Runnable
            public final void run() {
                AudioPlayerManager audioPlayerManager;
                audioPlayerManager = InnerAudioPlugin.this.audioPlayerManager;
                if (audioPlayerManager != null) {
                    audioPlayerManager.handleFocusGain();
                }
            }
        });
        Argument argument = this.interruptionMap.get(EVENT_INTERRUPTION_END);
        if (argument != null) {
            argument.subscribe(EVENT_INTERRUPTION_END, null);
        }
    }

    public final void handleFocusLoss() {
        TritonAudioThreadPool.getAudioExecutorService().execute(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.InnerAudioPlugin$handleFocusLoss$1
            @Override // java.lang.Runnable
            public final void run() {
                AudioPlayerManager audioPlayerManager;
                audioPlayerManager = InnerAudioPlugin.this.audioPlayerManager;
                if (audioPlayerManager != null) {
                    audioPlayerManager.handleFocusLoss();
                }
            }
        });
        Argument argument = this.interruptionMap.get(EVENT_INTERRUPTION_BEGIN);
        if (argument != null) {
            argument.subscribe(EVENT_INTERRUPTION_BEGIN, null);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
    
        if (r2.equals(com.tencent.mobileqq.tritonaudio.InnerAudioPlugin.EVENT_INTERRUPTION_END) != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        return saveAudioInterruptionCaller(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
    
        if (r2.equals(com.tencent.mobileqq.tritonaudio.InnerAudioPlugin.EVENT_INTERRUPTION_BEGIN) != false) goto L22;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0010. Please report as an issue. */
    @Override // com.tencent.mobileqq.triton.script.ScriptPlugin
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String onCall(@NotNull String eventName, @NotNull Argument arguments) {
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        switch (eventName.hashCode()) {
            case -2107296591:
                if (eventName.equals("destroyAudioInstance")) {
                    return destroyAudioInstance(arguments);
                }
                return null;
            case -1618442571:
                if (eventName.equals("getAvailableAudioSources")) {
                    return getAvailableAudioSources(arguments);
                }
                return null;
            case -430902094:
                if (eventName.equals("operateAudio")) {
                    return operateAudio(arguments);
                }
                return null;
            case -393505712:
                if (eventName.equals(API_ON_AUDIO_TIME_UPDATE_REGISTER)) {
                    return onAudioTimeUpdateRegister(arguments);
                }
                return null;
            case -334343059:
                break;
            case 17532319:
                break;
            case 244868847:
                if (eventName.equals("createAudioInstance")) {
                    return createAudioInstance(arguments);
                }
                return null;
            case 1240524369:
                if (eventName.equals("getAudioState")) {
                    return getAudioState(arguments);
                }
                return null;
            case 1868086796:
                if (eventName.equals(API_SET_INNER_AUDIO_OPTION)) {
                    return setInnerAudioOption(arguments);
                }
                return null;
            case 2014655581:
                if (eventName.equals("setAudioState")) {
                    return setAudioState(arguments);
                }
                return null;
            default:
                return null;
        }
    }

    @Override // com.tencent.mobileqq.triton.script.ScriptPlugin
    public void onCreate(@NotNull TritonEngine engine) {
        Intrinsics.checkParameterIsNotNull(engine, "engine");
        this.context = engine.getData().getContext();
        LogDelegate logDelegate = engine.getData().getLogDelegate();
        this.logger = logDelegate;
        final AudioPlayerManager audioPlayerManager = this.audioPlayerManager;
        if (audioPlayerManager != null) {
            if (logDelegate != null) {
                LogDelegate.DefaultImpls.printLog$default(logDelegate, LogDelegate.Level.ERROR, TAG, "lastPlayerManager is not null", null, 8, null);
            }
            TritonAudioThreadPool.getAudioExecutorService().execute(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.InnerAudioPlugin$onCreate$1$1
                @Override // java.lang.Runnable
                public final void run() {
                    AudioPlayerManager.this.onDestroy();
                }
            });
        }
        this.audioPlayerManager = new AudioPlayerManager(engine.getData().getContext(), engine.getData().getDataFileSystem(), engine.getData().getDownloader(), engine.getData().getLogDelegate(), engine.getData().isMute());
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onDestroy() {
        execAudioFocus(false);
        TritonAudioThreadPool.getAudioExecutorService().execute(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.InnerAudioPlugin$onDestroy$1
            @Override // java.lang.Runnable
            public final void run() {
                AudioPlayerManager audioPlayerManager;
                audioPlayerManager = InnerAudioPlugin.this.audioPlayerManager;
                if (audioPlayerManager != null) {
                    audioPlayerManager.onDestroy();
                }
            }
        });
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
        if (!this.mixWithOther) {
            execAudioFocus(true);
        }
        TritonAudioThreadPool.getAudioExecutorService().execute(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.InnerAudioPlugin$onStart$1
            @Override // java.lang.Runnable
            public final void run() {
                AudioPlayerManager audioPlayerManager;
                audioPlayerManager = InnerAudioPlugin.this.audioPlayerManager;
                if (audioPlayerManager != null) {
                    audioPlayerManager.resumeMusic();
                }
            }
        });
        this.isActivityPaused = false;
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onStop() {
        execAudioFocus(false);
        TritonAudioThreadPool.getAudioExecutorService().execute(new Runnable() { // from class: com.tencent.mobileqq.tritonaudio.InnerAudioPlugin$onStop$1
            @Override // java.lang.Runnable
            public final void run() {
                AudioPlayerManager audioPlayerManager;
                audioPlayerManager = InnerAudioPlugin.this.audioPlayerManager;
                if (audioPlayerManager != null) {
                    audioPlayerManager.pauseMusic();
                }
            }
        });
        this.isActivityPaused = true;
    }

    public final boolean support(@NotNull String eventName) {
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        return getSupportedEvents().contains(eventName);
    }
}
