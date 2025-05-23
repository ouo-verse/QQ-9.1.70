package com.tencent.qqlive.tvkplayer.report.capability.postprocess;

import com.tencent.qqlive.tvkplayer.postprocess.api.TVKMonetCapability;
import com.tencent.qqlive.tvkplayer.report.capability.ITVKDeviceCapabilityReportGenerator;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class TVKDevicePostProcessCapabilityReportGenerator implements ITVKDeviceCapabilityReportGenerator {
    private static final String TAG = "TVKDevicePostProcessCapabilityReportGenerator";

    private JSONArray generatePostProcessCapabilityArray() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        jSONArray.mo162put(generateVideoTVMSuperResolutionCapability());
        return jSONArray;
    }

    private JSONObject generateVideoTVMSuperResolutionCapability() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TVKDevicePostProcessCapabilityReportConstant.POST_PROCESS_TYPE, TVKDevicePostProcessCapabilityReportConstant.POST_PROCESS_TYPE_TVMSR);
        jSONObject.put("value", TVKMonetCapability.getTVMSuperResolutionSupportType());
        return jSONObject;
    }

    @Override // com.tencent.qqlive.tvkplayer.report.capability.ITVKDeviceCapabilityReportGenerator
    public JSONArray generateReportObject() {
        try {
            return generatePostProcessCapabilityArray();
        } catch (JSONException e16) {
            TVKLogUtil.e(TAG, e16, "[generateDeviceCapability] there is a exception: ");
            return null;
        }
    }
}
