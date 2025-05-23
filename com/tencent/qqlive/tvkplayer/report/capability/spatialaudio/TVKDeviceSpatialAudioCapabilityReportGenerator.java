package com.tencent.qqlive.tvkplayer.report.capability.spatialaudio;

import com.tencent.qqlive.tvkplayer.report.capability.ITVKDeviceCapabilityReportGenerator;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKAudioSpatializer;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKDeviceSpatialAudioCapabilityReportGenerator implements ITVKDeviceCapabilityReportGenerator {
    private static final String TAG = "TVKDeviceSpatialAudioCapabilityReportGenerator";

    private JSONObject generateSpatialAudioCapability() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT, TVKAudioSpatializer.getInstance().isSpatialAudioSupported());
        return jSONObject;
    }

    private JSONArray generateSpatialAudioCapabilityArray() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        jSONArray.mo162put(generateSpatialAudioCapability());
        return jSONArray;
    }

    @Override // com.tencent.qqlive.tvkplayer.report.capability.ITVKDeviceCapabilityReportGenerator
    public JSONArray generateReportObject() {
        try {
            return generateSpatialAudioCapabilityArray();
        } catch (JSONException e16) {
            TVKLogUtil.e(TAG, e16, "[generateDeviceCapability] there is a exception: ");
            return null;
        }
    }
}
