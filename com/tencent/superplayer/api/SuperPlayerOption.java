package com.tencent.superplayer.api;

import com.tencent.superplayer.config.ConfigManager;
import com.tencent.superplayer.utils.LogUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class SuperPlayerOption {
    public static final long DEFAULT_DROP_FRAME_TIME_UNIT = 1000;
    public static final float DEFAULT_MIN_DROP_FRAME_RATE = 0.06f;
    private static final String TAG = "SuperPlayerOption";
    public boolean accurateSeekOnOpen;
    public SuperPlayerAudioInfo audioFrameOutputOption;
    public long bufferPacketMinTotalDurationMs;
    public long bufferTimeoutMs;
    public boolean enableAudioFrameOutput;
    public boolean enableCodecReuse;
    public Boolean enableDownloadProxy;
    public boolean enableVideoFrameCheck;
    public boolean enableVideoFrameOutput;
    public Map<String, String> httpHeader;
    public boolean isPrePlay;
    public long minBufferingPacketDurationMs;
    public long preloadPacketDurationMs;
    public long prepareTimeoutMs;
    private int sceneId;
    public boolean stopPlayerInBackground = true;
    public boolean quickStopPlayerInBackground = false;
    public boolean enableListenerPlayerBuffer = true;
    public double tpCoreSampleRate = SuperPlayerSDKMgr.getTPCoreSampleRate();
    public boolean disableSuperSample = false;
    public SuperPlayerDownOption superPlayerDownOption = SuperPlayerDownOption.obtain();
    public boolean enableDropFrameDetect = false;
    public long dropFrameDetectTimeMs = 1000;
    public float minDropFrameRate = 0.06f;
    public boolean enabledBluetoothLatencyOptimize = false;
    public boolean forceSystemPlayerForNoAudio = false;
    public boolean notifyPreparedPlayMsgAhead = false;
    public String invalidContentType = "";

    SuperPlayerOption(int i3) {
        this.sceneId = i3;
        loadConfigFromConfigManager();
    }

    private void loadConfigFromConfigManager() {
        if (ConfigManager.needLoadConfig(this.sceneId)) {
            this.enableCodecReuse = ConfigManager.get().getConfig("codecReuse").getBoolean("video_codec_reuse_enable", this.enableCodecReuse);
            this.enableVideoFrameCheck = ConfigManager.get().getConfig("codecReuse").getBoolean("video_frame_check_enable", this.enableVideoFrameCheck);
        }
    }

    public static SuperPlayerOption obtain() {
        return obtain(0);
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isPrePlay", this.isPrePlay);
            jSONObject.put("enableCodecReuse", this.enableCodecReuse);
            jSONObject.put("accurateSeekOnOpen", this.accurateSeekOnOpen);
            jSONObject.put("enableVideoFrameCheck", this.enableVideoFrameCheck);
            jSONObject.put("bufferPacketMinTotalDurationMs", this.bufferPacketMinTotalDurationMs);
            jSONObject.put("preloadPacketDurationMs", this.preloadPacketDurationMs);
            jSONObject.put("minBufferingPacketDurationMs", this.minBufferingPacketDurationMs);
            jSONObject.put("audioFrameOutputOption", this.audioFrameOutputOption);
            jSONObject.put("enabledBluetoothLatencyOptimize", this.enabledBluetoothLatencyOptimize);
            jSONObject.put("superPlayerDownOption", this.superPlayerDownOption.toJsonString());
        } catch (JSONException unused) {
            LogUtil.e(TAG, "");
        }
        return jSONObject.toString();
    }

    public Map<String, String> toReportMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("isPrePlay", String.valueOf(this.isPrePlay));
        hashMap.put("enableCodecReuse", String.valueOf(this.enableCodecReuse));
        hashMap.put("accurateSeekOnOpen", String.valueOf(this.accurateSeekOnOpen));
        hashMap.put("enableVideoFrameCheck", String.valueOf(this.enableVideoFrameCheck));
        hashMap.put("bufferPacketMinTotalDurationMs", String.valueOf(this.bufferPacketMinTotalDurationMs));
        hashMap.put("preloadPacketDurationMs", String.valueOf(this.preloadPacketDurationMs));
        hashMap.put("minBufferingPacketDurationMs", String.valueOf(this.minBufferingPacketDurationMs));
        hashMap.put("audioFrameOutputOption", String.valueOf(this.audioFrameOutputOption));
        hashMap.putAll(this.superPlayerDownOption.toReportMap());
        return hashMap;
    }

    public String toString() {
        return "SuperPlayerOption[\nisPrePlay:" + this.isPrePlay + "\nenableCodecReuse:" + this.enableCodecReuse + "\naccurateSeekOnOpen:" + this.accurateSeekOnOpen + "\nenableVideoFrameCheck:" + this.enableVideoFrameCheck + "\nbufferPacketMinTotalDurationMs:" + this.bufferPacketMinTotalDurationMs + "\npreloadPacketDurationMs:" + this.preloadPacketDurationMs + "\nminBufferingPacketDurationMs:" + this.minBufferingPacketDurationMs + "\naudioFrameOutputOption:" + this.audioFrameOutputOption + "\nhttpHeader:" + this.httpHeader + "\nsuperPlayerDownOption" + this.superPlayerDownOption + "\n]";
    }

    public static SuperPlayerOption obtain(int i3) {
        return new SuperPlayerOption(i3);
    }
}
