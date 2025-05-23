package com.tencent.qqlive.tvkplayer.report.capability.hdr;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.report.capability.ITVKDeviceCapabilityReportGenerator;
import com.tencent.qqlive.tvkplayer.report.utils.TVKReportUtils;
import com.tencent.qqlive.tvkplayer.tools.config.TVKDVMAConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKTPCapability;
import com.tencent.thumbplayer.api.capability.TPHdrCapAttribute;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKDeviceHdrCapabilityReportGenerator implements ITVKDeviceCapabilityReportGenerator {
    private static final String TAG = "TVKDeviceHdrCapabilityReportGenerator";
    private HashMap<Integer, String> mHdrTypeToNameMap = null;

    public TVKDeviceHdrCapabilityReportGenerator() {
        initHdrNameMap();
    }

    @NonNull
    private JSONObject generateHdrCapability(@NonNull String str, Set<Integer> set) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TVKDeviceHdrCapabilityReportConstant.HDR_TYPE, str);
        JSONArray jSONArray = new JSONArray();
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(TVKReportUtils.getMappingTypeName(it.next().intValue()));
        }
        jSONObject.put(TVKDeviceHdrCapabilityReportConstant.HDR_MAPPING_TYPE, jSONArray);
        return jSONObject;
    }

    @NonNull
    private JSONArray generateHdrCapabilityArray() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<Integer, String> entry : this.mHdrTypeToNameMap.entrySet()) {
            TPHdrCapAttribute hdrCapAttribute = getHdrCapAttribute(entry.getKey().intValue());
            if (hdrCapAttribute != null && hdrCapAttribute.getSupportedMappingTypes().size() > 0) {
                jSONArray.mo162put(generateHdrCapability(entry.getValue(), hdrCapAttribute.getSupportedMappingTypes()));
            }
        }
        return jSONArray;
    }

    @Override // com.tencent.qqlive.tvkplayer.report.capability.ITVKDeviceCapabilityReportGenerator
    public JSONArray generateReportObject() {
        try {
            return generateHdrCapabilityArray();
        } catch (JSONException e16) {
            TVKLogUtil.e(TAG, e16, "[generateDeviceCapability] there is a exception: ");
            return null;
        }
    }

    @Nullable
    public TPHdrCapAttribute getHdrCapAttribute(int i3) {
        TPHdrCapAttribute hdrCapAttribute = TVKTPCapability.getHdrCapAttribute(i3);
        if (i3 == 2 && TVKDVMAConfig.isSupportDolbyVisionSoftRender()) {
            if (hdrCapAttribute == null) {
                TPHdrCapAttribute tPHdrCapAttribute = new TPHdrCapAttribute();
                tPHdrCapAttribute.setHdrType(2);
                hdrCapAttribute = tPHdrCapAttribute;
            }
            hdrCapAttribute.addSupportedMappingType(5);
        }
        return hdrCapAttribute;
    }

    void initHdrNameMap() {
        if (this.mHdrTypeToNameMap == null) {
            HashMap<Integer, String> hashMap = new HashMap<>();
            this.mHdrTypeToNameMap = hashMap;
            hashMap.put(0, "hdr10");
            this.mHdrTypeToNameMap.put(1, TVKDeviceHdrCapabilityReportConstant.HDR_TYPE_HDR10_PLUS);
            this.mHdrTypeToNameMap.put(2, TVKDeviceHdrCapabilityReportConstant.HDR_TYPE_DOLBY_VISION);
            this.mHdrTypeToNameMap.put(3, TVKDeviceHdrCapabilityReportConstant.HDR_TYPE_HLG);
            this.mHdrTypeToNameMap.put(4, TVKDeviceHdrCapabilityReportConstant.HDR_TYPE_HDRVIVID);
        }
    }
}
