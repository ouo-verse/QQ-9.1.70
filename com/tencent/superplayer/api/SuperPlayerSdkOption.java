package com.tencent.superplayer.api;

import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.superplayer.config.ConfigManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class SuperPlayerSdkOption {
    public static final boolean DEFAULT_SERVER_CONFIG_ENABLE = false;
    public String serverConfig = "{\"EnableUseQuic\":true}";
    public String userConfig = "";
    public String deviceId = "";
    public String uid = "";
    public boolean serverConfigEnable = false;
    public int configRequestIntervalInHour = 12;
    public boolean isAsyncInit = false;
    public int backgroundAliveTime = 60;
    public int quickDeinitTime = 5;
    public String beaconQimei36 = null;
    public String deviceModel = null;
    public String pcdnBizID = "";
    public int[] bandwidthReportSceneId = null;
    public long bandwidthReportIntervalMs = 60000;
    public boolean allowP2PUploadDefault = true;
    public double tpCoreSampleRate = 1.0d;
    public Map<String, String> superSampleConfig = new HashMap();
    public int[] dropFrameReportSceneId = null;
    public Executor threadPool = null;
    public HandlerThread subThread = null;
    public int tvideoThreadSize = 2;
    public boolean tvideoUseResidentThread = true;
    public int tvideoThreadAliveTimeSecond = 30;
    public boolean mediaCodecStuckCheckEnable = false;
    public boolean demuxerReadPacketErrorCheckEof = false;
    public boolean enableErrorWhenThreadCreateFailed = false;
    public boolean enableReleaseByJoin = false;
    public String sceneReleaseWhiteString = "";

    SuperPlayerSdkOption() {
    }

    private JSONObject mergeJson(JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            try {
                jSONObject.put(str, jSONObject2.get(str));
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static SuperPlayerSdkOption option() {
        return new SuperPlayerSdkOption();
    }

    public String getDownloadProxyConfig() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("AppToBackTime", this.backgroundAliveTime);
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(this.serverConfig)) {
                jSONObject2 = new JSONObject(this.serverConfig);
            }
            JSONObject jSONObject3 = new JSONObject();
            if (!TextUtils.isEmpty(this.userConfig)) {
                jSONObject3 = new JSONObject(this.userConfig);
            }
            mergeJson(jSONObject, jSONObject2);
            mergeJson(jSONObject, jSONObject3);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadConfigFromConfigManager() {
        this.serverConfig = ConfigManager.get().getConfig("sdkOption").getString("proxyConfigStr", this.serverConfig);
    }

    public String toString() {
        return "SuperPlayerSdkOption{serverConfig=" + this.serverConfig + "\nuserConfig=" + this.userConfig + "\ndeviceId=" + this.deviceId + "\nuid=" + this.uid + "\nserverConfigEnable=" + this.serverConfigEnable + "\nconfigRequestIntervalInHour:" + this.configRequestIntervalInHour + "\nbeaconQimei36:" + this.beaconQimei36 + "\n}";
    }
}
