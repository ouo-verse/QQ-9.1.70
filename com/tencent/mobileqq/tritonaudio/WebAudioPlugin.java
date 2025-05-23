package com.tencent.mobileqq.tritonaudio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.script.ComposableScriptPlugin;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.mobileqq.tritonaudio.internal.ApiUtil;
import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import com.tencent.mobileqq.tritonaudio.webaudio.NativeBuffer;
import com.tencent.mobileqq.tritonaudio.webaudio.WebAudioManager;
import com.tencent.qqlive.tvkplayer.report.capability.spatialaudio.TVKDeviceSpatialAudioCapabilityReportConstant;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.File;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 72\u00020\u0001:\u00017B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010 \u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010#\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001a\u0010%\u001a\u0004\u0018\u00010\r2\u0006\u0010&\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0013H\u0016J\b\u0010+\u001a\u00020\u0013H\u0016J\b\u0010,\u001a\u00020\u0013H\u0016J\u0010\u0010-\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010.\u001a\u00020\u0013H\u0002J\u0010\u0010/\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u00100\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u00101\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u00102\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u00103\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u00104\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u00105\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\rJ\b\u00106\u001a\u00020\u0013H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/tritonaudio/WebAudioPlugin;", "Lcom/tencent/mobileqq/triton/script/ComposableScriptPlugin;", "()V", "context", "Landroid/content/Context;", "isActivityPaused", "", "logger", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "sId", "Ljava/util/concurrent/atomic/AtomicInteger;", "supportedEvents", "", "", "getSupportedEvents", "()Ljava/util/Set;", "webAudioManager", "Lcom/tencent/mobileqq/tritonaudio/webaudio/WebAudioManager;", WebAudioPlugin.API_CLOSE_WEB_AUDIO_CONTEXT, "", "arguments", "Lcom/tencent/mobileqq/triton/script/Argument;", "connectWebAudioNode", "copyFormChannel", "copyToChannel", "createBuffer", "createGainNode", WebAudioPlugin.API_CREATE_BUFFER_SOURCE, WebAudioPlugin.API_CREATE_AUDIO_CONTEXT, WebAudioPlugin.API_CREATE_WEB_AUDIO_SCRIPT_PROCESSOR, WebAudioPlugin.API_DECODE_AUDIO_DATA, "getBufferChannelData", "getCurrentGain", WebAudioPlugin.API_GET_WEB_AUDIO_CURRENT_TIME, WebAudioPlugin.API_GET_WEB_AUDIO_DESTINATION, WebAudioPlugin.API_GET_WEBAUDIO_SAMPLE_RATE, WebAudioPlugin.API_GET_WEB_AUDIO_STATE, "onCall", AdMetricTag.EVENT_NAME, "onCreate", EnginePathProvider.ENGINE_DIR, "Lcom/tencent/mobileqq/triton/TritonEngine;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onStart", DKHippyEvent.EVENT_STOP, "oprateWebAudioContext", "resumeWebAudioContext", "setBufferSourceLoop", "setCurrentGain", "setQueueBuffer", "setSourceBuffer", WebAudioPlugin.API_SOURCE_START, WebAudioPlugin.API_SOURCE_STOP, TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT, "suspendWebAudioContext", "Companion", "TritonAudio_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class WebAudioPlugin implements ComposableScriptPlugin {

    @NotNull
    public static final String API_CLOSE_WEB_AUDIO_CONTEXT = "closeWebAudioContext";

    @NotNull
    public static final String API_COPY_FROM_CHANNEL = "audioBufferCopyFromChannel";

    @NotNull
    public static final String API_COPY_TO_CHANNEL = "audioBufferCopyToChannel";

    @NotNull
    public static final String API_CREATE_AUDIO_CONTEXT = "createWebAudioContext";

    @NotNull
    public static final String API_CREATE_BUFFER = "createWebAudioContextBuffer";

    @NotNull
    public static final String API_CREATE_BUFFER_SOURCE = "createWebAudioBufferSource";

    @NotNull
    public static final String API_CREATE_GAIN = "createWebAudioGain";

    @NotNull
    public static final String API_CREATE_WEB_AUDIO_SCRIPT_PROCESSOR = "createWebAudioScriptProcessor";

    @NotNull
    public static final String API_DECODE_AUDIO_DATA = "decodeWebAudioData";

    @NotNull
    public static final String API_GET_BUFFTER_CHANNEL_DATA = "getWebAudioBufferChannelData";

    @NotNull
    public static final String API_GET_CURRENT_GAIN = "getWebAudioCurrentGain";

    @NotNull
    public static final String API_GET_WEBAUDIO_SAMPLE_RATE = "getWebAudioSampleRate";

    @NotNull
    public static final String API_GET_WEB_AUDIO_CURRENT_TIME = "getWebAudioCurrentTime";

    @NotNull
    public static final String API_GET_WEB_AUDIO_DESTINATION = "getWebAudioDestination";

    @NotNull
    public static final String API_GET_WEB_AUDIO_STATE = "getWebAudioState";

    @NotNull
    public static final String API_ON_SOURCE_ENDED = "onWebAudioSourceEnded";

    @NotNull
    public static final String API_ON_WEB_AUDIO_SCRIPT_PROCESSOR = "onWebAudioScriptProcessorAudioProcess";

    @NotNull
    public static final String API_OPERATE_WEB_AUDIO_CONTEXT = "operateWebAudioContext";

    @NotNull
    public static final String API_SET_BUFFER_SOURCE_LOOP = "setWebAudioBufferSourceLoop";

    @NotNull
    public static final String API_SET_CURRENT_GAIN = "setWebAudioCurrentGain";

    @NotNull
    public static final String API_SET_QUEUE_BUFFER = "audioProcessingEventSetQueueBuffer";

    @NotNull
    public static final String API_SET_SOURCE_BUFFER = "setWebAudioSourceBuffer";

    @NotNull
    public static final String API_SOURCE_START = "sourceStart";

    @NotNull
    public static final String API_SOURCE_STOP = "sourceStop";

    @NotNull
    public static final String API_WEB_AUDIO_CONNECT_AUDIO_NODE = "webAudioConnectAudioNode";

    @NotNull
    public static final String AUDIO_ID = "audioId";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "[audio]WebAudioPlugin";
    private static volatile boolean sHasWebAudioSoLoaded;
    private static final Set<String> supportedEvents;
    private Context context;
    private boolean isActivityPaused;
    private LogDelegate logger;
    private final AtomicInteger sId = new AtomicInteger();
    private WebAudioManager webAudioManager;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/tritonaudio/WebAudioPlugin$Companion;", "", "()V", "API_CLOSE_WEB_AUDIO_CONTEXT", "", "API_COPY_FROM_CHANNEL", "API_COPY_TO_CHANNEL", "API_CREATE_AUDIO_CONTEXT", "API_CREATE_BUFFER", "API_CREATE_BUFFER_SOURCE", "API_CREATE_GAIN", "API_CREATE_WEB_AUDIO_SCRIPT_PROCESSOR", "API_DECODE_AUDIO_DATA", "API_GET_BUFFTER_CHANNEL_DATA", "API_GET_CURRENT_GAIN", "API_GET_WEBAUDIO_SAMPLE_RATE", "API_GET_WEB_AUDIO_CURRENT_TIME", "API_GET_WEB_AUDIO_DESTINATION", "API_GET_WEB_AUDIO_STATE", "API_ON_SOURCE_ENDED", "API_ON_WEB_AUDIO_SCRIPT_PROCESSOR", "API_OPERATE_WEB_AUDIO_CONTEXT", "API_SET_BUFFER_SOURCE_LOOP", "API_SET_CURRENT_GAIN", "API_SET_QUEUE_BUFFER", "API_SET_SOURCE_BUFFER", "API_SOURCE_START", "API_SOURCE_STOP", "API_WEB_AUDIO_CONNECT_AUDIO_NODE", "AUDIO_ID", "TAG", "sHasWebAudioSoLoaded", "", "supportedEvents", "", "loadWebAudioSo", "soPath", "TritonAudio_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final class Companion {
        Companion() {
        }

        @SuppressLint({"UnsafeDynamicallyLoadedCode"})
        public final boolean loadWebAudioSo(@Nullable String soPath) {
            boolean contains$default;
            boolean z16 = false;
            if (TextUtils.isEmpty(soPath)) {
                return false;
            }
            if (WebAudioPlugin.sHasWebAudioSoLoaded) {
                return true;
            }
            if (soPath == null) {
                Intrinsics.throwNpe();
            }
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) soPath, File.separatorChar, false, 2, (Object) null);
            try {
                if (!contains$default) {
                    System.loadLibrary(soPath);
                } else {
                    System.load(soPath);
                }
                z16 = true;
            } catch (UnsatisfiedLinkError e16) {
                Log.e(WebAudioManager.TAG, "loadWebAudioSo failed:", e16);
            }
            WebAudioPlugin.sHasWebAudioSoLoaded = z16;
            return WebAudioPlugin.sHasWebAudioSoLoaded;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{API_CREATE_AUDIO_CONTEXT, API_DECODE_AUDIO_DATA, API_CLOSE_WEB_AUDIO_CONTEXT, API_GET_WEBAUDIO_SAMPLE_RATE, API_GET_WEB_AUDIO_DESTINATION, API_GET_WEB_AUDIO_CURRENT_TIME, API_OPERATE_WEB_AUDIO_CONTEXT, API_GET_WEB_AUDIO_STATE, API_CREATE_BUFFER, API_GET_BUFFTER_CHANNEL_DATA, API_COPY_FROM_CHANNEL, API_COPY_TO_CHANNEL, API_CREATE_BUFFER_SOURCE, API_SET_SOURCE_BUFFER, API_SOURCE_START, API_SOURCE_STOP, API_SET_BUFFER_SOURCE_LOOP, API_WEB_AUDIO_CONNECT_AUDIO_NODE, API_CREATE_GAIN, API_GET_CURRENT_GAIN, API_SET_CURRENT_GAIN, API_CREATE_WEB_AUDIO_SCRIPT_PROCESSOR, API_SET_QUEUE_BUFFER});
        supportedEvents = of5;
    }

    private final String closeWebAudioContext(Argument arguments) {
        int i3 = arguments.getParams().getInt(AUDIO_ID);
        WebAudioManager webAudioManager = this.webAudioManager;
        if (webAudioManager != null) {
            webAudioManager.closeAudioContext(i3);
        }
        String jSONObject = ApiUtil.wrapCallbackOk(API_CLOSE_WEB_AUDIO_CONTEXT, null).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "ApiUtil.wrapCallbackOk(A\u2026CONTEXT, null).toString()");
        return jSONObject;
    }

    private final String connectWebAudioNode(Argument arguments) {
        WebAudioManager webAudioManager;
        int optInt = arguments.getParams().optInt("oriAudioNodeType", -1);
        int i3 = arguments.getParams().getInt(AUDIO_ID);
        if (optInt == WebAudioManager.SCRIPT_PROCESSOR_AUDIO_NODE_TYPE && (webAudioManager = this.webAudioManager) != null) {
            webAudioManager.startAudioProcess(arguments, i3);
        }
        String jSONObject = ApiUtil.wrapCallbackOk(API_WEB_AUDIO_CONNECT_AUDIO_NODE, null).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "ApiUtil.wrapCallbackOk(A\u2026IO_NODE, null).toString()");
        return jSONObject;
    }

    private final String copyFormChannel(Argument arguments) {
        String jSONObject = ApiUtil.wrapCallbackOk(API_COPY_FROM_CHANNEL, null).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "ApiUtil.wrapCallbackOk(A\u2026CHANNEL, null).toString()");
        return jSONObject;
    }

    private final String copyToChannel(Argument arguments) {
        byte[] bArr;
        int i3 = arguments.getParams().getInt("bufferId");
        int i16 = -1;
        int optInt = arguments.getParams().optInt("sourceId", -1);
        int i17 = arguments.getParams().getInt("channelId");
        int optInt2 = arguments.getParams().optInt("startInChannel", 0);
        NativeBuffer unpackNativeBuffer = NativeBuffer.unpackNativeBuffer(arguments, arguments.getParams(), "data");
        if (unpackNativeBuffer != null && (bArr = unpackNativeBuffer.buf) != null && bArr.length != 0) {
            WebAudioManager webAudioManager = this.webAudioManager;
            if (webAudioManager != null) {
                i16 = webAudioManager.copyToChannel(bArr, i3, optInt, i17, optInt2);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bufferId", i16);
            String jSONObject2 = ApiUtil.wrapCallbackOk(API_COPY_TO_CHANNEL, jSONObject).toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "ApiUtil.wrapCallbackOk(A\u2026_CHANNEL, res).toString()");
            return jSONObject2;
        }
        String jSONObject3 = ApiUtil.wrapCallbackFail(API_COPY_TO_CHANNEL, null).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject3, "ApiUtil.wrapCallbackFail\u2026CHANNEL, null).toString()");
        return jSONObject3;
    }

    private final String createBuffer(Argument arguments) {
        JSONObject jSONObject;
        int optInt = arguments.getParams().optInt("numOfChannels", 1);
        int optInt2 = arguments.getParams().optInt("length");
        int optInt3 = arguments.getParams().optInt("sampleRate");
        int i3 = arguments.getParams().getInt(AUDIO_ID);
        WebAudioManager webAudioManager = this.webAudioManager;
        if (webAudioManager != null) {
            jSONObject = webAudioManager.createBuffer(i3, optInt, optInt2, optInt3);
        } else {
            jSONObject = null;
        }
        String jSONObject2 = ApiUtil.wrapCallbackOk(API_CREATE_BUFFER, jSONObject).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "ApiUtil.wrapCallbackOk(A\u2026, sampleRate)).toString()");
        return jSONObject2;
    }

    private final String createGainNode(Argument arguments) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("audioNodeType", 5);
        jSONObject.put("channelId", -1);
        String jSONObject2 = ApiUtil.wrapCallbackOk(API_CREATE_GAIN, jSONObject).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "ApiUtil.wrapCallbackOk(A\u2026ATE_GAIN, res).toString()");
        return jSONObject2;
    }

    private final String createWebAudioBufferSource(Argument arguments) {
        JSONObject jSONObject;
        int i3 = arguments.getParams().getInt(AUDIO_ID);
        WebAudioManager webAudioManager = this.webAudioManager;
        if (webAudioManager != null) {
            jSONObject = webAudioManager.createBufferSource(i3);
        } else {
            jSONObject = null;
        }
        String jSONObject2 = ApiUtil.wrapCallbackOk(API_CREATE_BUFFER_SOURCE, jSONObject).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "ApiUtil.wrapCallbackOk(A\u2026urce(audioId)).toString()");
        return jSONObject2;
    }

    private final String createWebAudioContext(Argument arguments) {
        JSONObject jSONObject;
        WebAudioManager webAudioManager = this.webAudioManager;
        if (webAudioManager != null) {
            jSONObject = webAudioManager.createAudioContext();
        } else {
            jSONObject = null;
        }
        String jSONObject2 = ApiUtil.wrapCallbackOk(API_CREATE_AUDIO_CONTEXT, jSONObject).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "ApiUtil.wrapCallbackOk(A\u2026udioContext()).toString()");
        LogDelegate logDelegate = this.logger;
        if (logDelegate != null) {
            LogDelegate.DefaultImpls.printLog$default(logDelegate, LogDelegate.Level.INFO, TAG, "createWebAudioContext rsp=" + jSONObject2, null, 8, null);
        }
        return jSONObject2;
    }

    private final String createWebAudioScriptProcessor(Argument arguments) {
        int optInt = arguments.getParams().optInt("bufferSize");
        int optInt2 = arguments.getParams().optInt("inputChannelNum");
        int optInt3 = arguments.getParams().optInt("outputChannelNum");
        int i3 = arguments.getParams().getInt(AUDIO_ID);
        WebAudioManager webAudioManager = this.webAudioManager;
        if (webAudioManager != null) {
            webAudioManager.createScriptProcessor(i3, optInt, optInt2, optInt3);
        }
        String jSONObject = ApiUtil.wrapCallbackOk(API_CREATE_WEB_AUDIO_SCRIPT_PROCESSOR, null).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "ApiUtil.wrapCallbackOk(A\u2026OCESSOR, null).toString()");
        return jSONObject;
    }

    private final String decodeWebAudioData(Argument arguments) {
        int incrementAndGet = this.sId.incrementAndGet();
        NativeBuffer unpackNativeBuffer = NativeBuffer.unpackNativeBuffer(arguments, arguments.getParams(), "data");
        if (unpackNativeBuffer != null) {
            byte[] bArr = unpackNativeBuffer.buf;
            WebAudioManager webAudioManager = this.webAudioManager;
            if (webAudioManager != null) {
                webAudioManager.decodeAudioDataAndReturnBufferIdAsync(incrementAndGet, bArr, arguments);
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("decodeId", incrementAndGet);
        String jSONObject2 = ApiUtil.wrapCallbackOk(API_DECODE_AUDIO_DATA, jSONObject).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "ApiUtil.wrapCallbackOk(A\u2026DIO_DATA, res).toString()");
        return jSONObject2;
    }

    private final String getBufferChannelData(Argument arguments) {
        byte[] bArr;
        int i3 = arguments.getParams().getInt("bufferId");
        int i16 = arguments.getParams().getInt("channelId");
        WebAudioManager webAudioManager = this.webAudioManager;
        if (webAudioManager == null || (bArr = webAudioManager.getBufferChannelData(i3, i16)) == null) {
            bArr = new byte[0];
        }
        JSONObject jSONObject = new JSONObject();
        NativeBuffer.packNativeBuffer(arguments, bArr, NativeBuffer.TYPE_BUFFER_NATIVE, "data", jSONObject);
        String jSONObject2 = ApiUtil.wrapCallbackOk(API_GET_BUFFTER_CHANNEL_DATA, jSONObject).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "ApiUtil.wrapCallbackOk(A\u2026_DATA, resObj).toString()");
        return jSONObject2;
    }

    private final String getCurrentGain(Argument arguments) {
        float f16;
        int i3 = arguments.getParams().getInt("channelId");
        int i16 = arguments.getParams().getInt(AUDIO_ID);
        WebAudioManager webAudioManager = this.webAudioManager;
        if (webAudioManager != null) {
            f16 = webAudioManager.getCurrentGain(i16, i3);
        } else {
            f16 = 1.0f;
        }
        return String.valueOf(f16);
    }

    private final String getWebAudioCurrentTime(Argument arguments) {
        AudioContext audioContext;
        long j3;
        int i3 = arguments.getParams().getInt(AUDIO_ID);
        WebAudioManager webAudioManager = this.webAudioManager;
        if (webAudioManager != null) {
            audioContext = webAudioManager.getAudioContext(i3);
        } else {
            audioContext = null;
        }
        if (audioContext != null) {
            j3 = audioContext.getCurrentTime();
        } else {
            j3 = 0;
        }
        return String.valueOf(j3 / 1000.0d);
    }

    private final String getWebAudioDestination(Argument arguments) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("audioNodeType", 4);
        String jSONObject2 = ApiUtil.wrapCallbackOk(API_GET_WEB_AUDIO_DESTINATION, jSONObject).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "ApiUtil.wrapCallbackOk(A\u2026TINATION, res).toString()");
        return jSONObject2;
    }

    private final String getWebAudioSampleRate(Argument arguments) {
        String jSONObject = ApiUtil.wrapCallbackOk(API_GET_WEBAUDIO_SAMPLE_RATE, null).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "ApiUtil.wrapCallbackOk(A\u2026LE_RATE, null).toString()");
        return jSONObject;
    }

    private final String getWebAudioState(Argument arguments) {
        AudioContext audioContext;
        int i3 = arguments.getParams().getInt(AUDIO_ID);
        WebAudioManager webAudioManager = this.webAudioManager;
        if (webAudioManager != null) {
            audioContext = webAudioManager.getAudioContext(i3);
        } else {
            audioContext = null;
        }
        if (audioContext == null) {
            return null;
        }
        return audioContext.getState();
    }

    private final String oprateWebAudioContext(Argument arguments) {
        WebAudioManager webAudioManager;
        String string = arguments.getParams().getString("operationType");
        int i3 = arguments.getParams().getInt(AUDIO_ID);
        if (Intrinsics.areEqual(string, QCircleDaTongConstant.ElementParamValue.SUSPEND)) {
            WebAudioManager webAudioManager2 = this.webAudioManager;
            if (webAudioManager2 != null) {
                webAudioManager2.suspendAudioContext(i3);
            }
        } else if (Intrinsics.areEqual(string, "resume") && (webAudioManager = this.webAudioManager) != null) {
            webAudioManager.resumeAudioContext(i3);
        }
        String jSONObject = ApiUtil.wrapCallbackOk(API_OPERATE_WEB_AUDIO_CONTEXT, null).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "ApiUtil.wrapCallbackOk(A\u2026CONTEXT, null).toString()");
        return jSONObject;
    }

    private final void resumeWebAudioContext() {
        if (!sHasWebAudioSoLoaded) {
            LogDelegate logDelegate = this.logger;
            if (logDelegate != null) {
                logDelegate.printLog(LogDelegate.Level.INFO, TAG, "resumeWebAudioContext fail so has not loaded", null);
                return;
            }
            return;
        }
        WebAudioManager webAudioManager = this.webAudioManager;
        if (webAudioManager != null) {
            webAudioManager.resumeAudioContext();
        }
    }

    private final String setBufferSourceLoop(Argument arguments) {
        WebAudioManager webAudioManager;
        boolean z16 = arguments.getParams().getBoolean("loop");
        int i3 = arguments.getParams().getInt("channelId");
        int i16 = arguments.getParams().getInt(AUDIO_ID);
        if (z16 && (webAudioManager = this.webAudioManager) != null) {
            webAudioManager.setBufferSourceLoop(i16, i3, z16);
        }
        String jSONObject = ApiUtil.wrapCallbackOk(API_SET_BUFFER_SOURCE_LOOP, null).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "ApiUtil.wrapCallbackOk(A\u2026CE_LOOP, null).toString()");
        return jSONObject;
    }

    private final String setCurrentGain(Argument arguments) {
        int i3 = arguments.getParams().getInt("channelId");
        double d16 = arguments.getParams().getDouble("data");
        int i16 = arguments.getParams().getInt(AUDIO_ID);
        WebAudioManager webAudioManager = this.webAudioManager;
        if (webAudioManager != null) {
            webAudioManager.setCurrentGain(i16, i3, d16);
        }
        String jSONObject = ApiUtil.wrapCallbackOk(API_SET_CURRENT_GAIN, null).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "ApiUtil.wrapCallbackOk(A\u2026NT_GAIN, null).toString()");
        return jSONObject;
    }

    private final String setQueueBuffer(Argument arguments) {
        int optInt = arguments.getParams().optInt("channelId", -2);
        int optInt2 = arguments.getParams().optInt("bufferId");
        WebAudioManager webAudioManager = this.webAudioManager;
        if (webAudioManager != null) {
            webAudioManager.setQueueBuffer(optInt, optInt2);
        }
        String jSONObject = ApiUtil.wrapCallbackOk(API_SET_QUEUE_BUFFER, null).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "ApiUtil.wrapCallbackOk(A\u2026_BUFFER, null).toString()");
        return jSONObject;
    }

    private final String setSourceBuffer(Argument arguments) {
        int i3 = arguments.getParams().getInt("channelId");
        int optInt = arguments.getParams().optInt("bufferId", -1);
        int optInt2 = arguments.getParams().optInt("decodeId", -1);
        JSONObject jSONObject = null;
        if (optInt != -1) {
            WebAudioManager webAudioManager = this.webAudioManager;
            if (webAudioManager != null) {
                jSONObject = webAudioManager.setSourceBuffer(i3, optInt);
            }
            String jSONObject2 = ApiUtil.wrapCallbackOk(API_SET_SOURCE_BUFFER, jSONObject).toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "ApiUtil.wrapCallbackOk(A\u2026Id, bufferId)).toString()");
            return jSONObject2;
        }
        if (optInt2 != -1) {
            WebAudioManager webAudioManager2 = this.webAudioManager;
            if (webAudioManager2 != null) {
                jSONObject = webAudioManager2.setDecodingQueueBuffer(i3, optInt2);
            }
            String jSONObject3 = ApiUtil.wrapCallbackOk(API_SET_SOURCE_BUFFER, jSONObject).toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject3, "ApiUtil.wrapCallbackOk(A\u2026Id, decodeId)).toString()");
            return jSONObject3;
        }
        String jSONObject4 = ApiUtil.wrapCallbackFail(API_SET_SOURCE_BUFFER, null).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject4, "ApiUtil.wrapCallbackFail\u2026_BUFFER, null).toString()");
        return jSONObject4;
    }

    private final String sourceStart(Argument arguments) {
        JSONObject jSONObject;
        int i3 = arguments.getParams().getInt(AUDIO_ID);
        int i16 = arguments.getParams().getInt("channelId");
        int optInt = arguments.getParams().optInt(RemoteMessageConst.Notification.WHEN, 0);
        int optInt2 = arguments.getParams().optInt("offset", 0);
        int optInt3 = arguments.getParams().optInt("duration", -1);
        WebAudioManager webAudioManager = this.webAudioManager;
        if (webAudioManager != null) {
            jSONObject = webAudioManager.sourceStart(arguments, i3, i16, optInt, optInt2, optInt3);
        } else {
            jSONObject = null;
        }
        String jSONObject2 = ApiUtil.wrapCallbackOk(API_SOURCE_START, jSONObject).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "ApiUtil.wrapCallbackOk(A\u2026et, duration)).toString()");
        return jSONObject2;
    }

    private final String sourceStop(Argument arguments) {
        JSONObject jSONObject;
        int i3 = arguments.getParams().getInt(AUDIO_ID);
        int i16 = arguments.getParams().getInt("channelId");
        int optInt = arguments.getParams().optInt(RemoteMessageConst.Notification.WHEN, 0);
        WebAudioManager webAudioManager = this.webAudioManager;
        if (webAudioManager != null) {
            jSONObject = webAudioManager.sourceStop(i3, i16, optInt);
        } else {
            jSONObject = null;
        }
        String jSONObject2 = ApiUtil.wrapCallbackOk(API_SOURCE_STOP, jSONObject).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "ApiUtil.wrapCallbackOk(A\u2026ceId, `when`)).toString()");
        return jSONObject2;
    }

    private final void suspendWebAudioContext() {
        if (!sHasWebAudioSoLoaded) {
            LogDelegate logDelegate = this.logger;
            if (logDelegate != null) {
                logDelegate.printLog(LogDelegate.Level.INFO, TAG, "suspendWebAudioContext fail so has not loaded", null);
                return;
            }
            return;
        }
        WebAudioManager webAudioManager = this.webAudioManager;
        if (webAudioManager != null) {
            webAudioManager.suspendAudioContext();
        }
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
        if (!sHasWebAudioSoLoaded) {
            LogDelegate logDelegate = this.logger;
            if (logDelegate != null) {
                LogDelegate.DefaultImpls.printLog$default(logDelegate, LogDelegate.Level.ERROR, TAG, "onCall event=" + eventName + " failed, so is not loaded", null, 8, null);
            }
            return null;
        }
        switch (eventName.hashCode()) {
            case -2076546886:
                if (!eventName.equals(API_DECODE_AUDIO_DATA)) {
                    return null;
                }
                return decodeWebAudioData(arguments);
            case -1809797821:
                if (!eventName.equals(API_SET_BUFFER_SOURCE_LOOP)) {
                    return null;
                }
                return setBufferSourceLoop(arguments);
            case -1544927456:
                if (!eventName.equals(API_GET_CURRENT_GAIN)) {
                    return null;
                }
                return getCurrentGain(arguments);
            case -1544532370:
                if (!eventName.equals(API_GET_WEB_AUDIO_CURRENT_TIME)) {
                    return null;
                }
                return getWebAudioCurrentTime(arguments);
            case -1513995947:
                if (!eventName.equals(API_CLOSE_WEB_AUDIO_CONTEXT)) {
                    return null;
                }
                return closeWebAudioContext(arguments);
            case -1365570487:
                if (!eventName.equals(API_OPERATE_WEB_AUDIO_CONTEXT)) {
                    return null;
                }
                return oprateWebAudioContext(arguments);
            case -1131299979:
                if (!eventName.equals(API_GET_BUFFTER_CHANNEL_DATA)) {
                    return null;
                }
                return getBufferChannelData(arguments);
            case -1111466307:
                if (!eventName.equals(API_SOURCE_STOP)) {
                    return null;
                }
                return sourceStop(arguments);
            case -817189219:
                if (!eventName.equals(API_CREATE_GAIN)) {
                    return null;
                }
                return createGainNode(arguments);
            case -231799148:
                if (!eventName.equals(API_SET_CURRENT_GAIN)) {
                    return null;
                }
                return setCurrentGain(arguments);
            case -106116946:
                if (!eventName.equals(API_COPY_FROM_CHANNEL)) {
                    return null;
                }
                return copyFormChannel(arguments);
            case -95730425:
                if (!eventName.equals(API_SOURCE_START)) {
                    return null;
                }
                return sourceStart(arguments);
            case 141268433:
                if (!eventName.equals(API_CREATE_AUDIO_CONTEXT)) {
                    return null;
                }
                return createWebAudioContext(arguments);
            case 212415010:
                if (!eventName.equals(API_GET_WEBAUDIO_SAMPLE_RATE)) {
                    return null;
                }
                return getWebAudioSampleRate(arguments);
            case 294903293:
                if (!eventName.equals(API_COPY_TO_CHANNEL)) {
                    return null;
                }
                return copyToChannel(arguments);
            case 719352470:
                if (!eventName.equals(API_GET_WEB_AUDIO_DESTINATION)) {
                    return null;
                }
                return getWebAudioDestination(arguments);
            case 799668671:
                if (!eventName.equals(API_SET_SOURCE_BUFFER)) {
                    return null;
                }
                return setSourceBuffer(arguments);
            case 1135871536:
                if (!eventName.equals(API_WEB_AUDIO_CONNECT_AUDIO_NODE)) {
                    return null;
                }
                return connectWebAudioNode(arguments);
            case 1360624096:
                if (!eventName.equals(API_SET_QUEUE_BUFFER)) {
                    return null;
                }
                return setQueueBuffer(arguments);
            case 1451060777:
                if (!eventName.equals(API_CREATE_WEB_AUDIO_SCRIPT_PROCESSOR)) {
                    return null;
                }
                return createWebAudioScriptProcessor(arguments);
            case 1902976409:
                if (!eventName.equals(API_CREATE_BUFFER_SOURCE)) {
                    return null;
                }
                return createWebAudioBufferSource(arguments);
            case 1943975281:
                if (!eventName.equals(API_CREATE_BUFFER)) {
                    return null;
                }
                return createBuffer(arguments);
            case 2003597593:
                if (!eventName.equals(API_GET_WEB_AUDIO_STATE)) {
                    return null;
                }
                return getWebAudioState(arguments);
            default:
                return null;
        }
    }

    @Override // com.tencent.mobileqq.triton.script.ScriptPlugin
    public void onCreate(@NotNull TritonEngine engine) {
        Intrinsics.checkParameterIsNotNull(engine, "engine");
        this.context = engine.getData().getContext();
        this.logger = engine.getData().getLogDelegate();
        this.webAudioManager = new WebAudioManager(this.logger);
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onDestroy() {
        closeWebAudioContext();
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
        this.isActivityPaused = false;
        resumeWebAudioContext();
    }

    @Override // com.tencent.mobileqq.triton.lifecycle.LifeCycle
    public void onStop() {
        this.isActivityPaused = true;
        suspendWebAudioContext();
    }

    public final boolean support(@NotNull String eventName) {
        Intrinsics.checkParameterIsNotNull(eventName, "eventName");
        return getSupportedEvents().contains(eventName);
    }

    private final void closeWebAudioContext() {
        if (!sHasWebAudioSoLoaded) {
            LogDelegate logDelegate = this.logger;
            if (logDelegate != null) {
                logDelegate.printLog(LogDelegate.Level.INFO, TAG, "closeWebAudioContext fail so has not loaded", null);
                return;
            }
            return;
        }
        WebAudioManager webAudioManager = this.webAudioManager;
        if (webAudioManager != null) {
            webAudioManager.closeAudioContext();
        }
    }
}
