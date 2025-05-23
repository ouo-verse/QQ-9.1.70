package com.tencent.qqlive.tvkplayer.tools.utils;

import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineSimulatedLiveAsset;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class TVKSimulatedLivePrevidGenerator {
    private static final String PREVID_JSON_PARAM_KEY_APP_SCENE = "app_scene";
    private static final String PREVID_JSON_PARAM_KEY_CHID = "chid";
    private static final String PREVID_JSON_PARAM_KEY_PID = "pid";

    public static String generate(TVKOnlineSimulatedLiveAsset tVKOnlineSimulatedLiveAsset) {
        String pid = tVKOnlineSimulatedLiveAsset.getPid();
        String chid = tVKOnlineSimulatedLiveAsset.getChid();
        String appScene = tVKOnlineSimulatedLiveAsset.getAppScene();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pid", pid);
            jSONObject.put("chid", chid);
            jSONObject.put(PREVID_JSON_PARAM_KEY_APP_SCENE, appScene);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
