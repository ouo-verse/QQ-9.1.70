package com.tencent.qqlive.tvkplayer.report.capability.decode;

import com.tencent.qqlive.tvkplayer.report.capability.ITVKDeviceCapabilityReportGenerator;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKTPCapability;
import com.tencent.tavcut.core.render.exporter.ExportOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKDeviceDecodeCapabilityReportGenerator implements ITVKDeviceCapabilityReportGenerator {
    private static final List<Integer> DECODING_TEST_FRAME_RATE_LIST;
    private static final List<ResolutionInfo> DECODING_TEST_RESOLUTION_LIST;
    private static final String TAG = "TVKDeviceDecodeCapabilityReportGenerator";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class ResolutionInfo {
        public int height;
        public String name;
        public int width;

        public ResolutionInfo(String str, int i3, int i16) {
            this.name = str;
            this.width = i3;
            this.height = i16;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ResolutionInfo("270P", 480, 270));
        arrayList.add(new ResolutionInfo(ExportOutput.KEY_LEVEL_480P, TVKTPCapability.HD_WIDTH, 480));
        arrayList.add(new ResolutionInfo(ExportOutput.KEY_LEVEL_720P, 1280, 720));
        arrayList.add(new ResolutionInfo(ExportOutput.KEY_LEVEL_1080P, 1920, 1080));
        arrayList.add(new ResolutionInfo(ExportOutput.KEY_LEVEL_4K, 3840, 2160));
        DECODING_TEST_RESOLUTION_LIST = Collections.unmodifiableList(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(240);
        arrayList2.add(120);
        arrayList2.add(60);
        arrayList2.add(30);
        arrayList2.add(0);
        DECODING_TEST_FRAME_RATE_LIST = Collections.unmodifiableList(arrayList2);
    }

    private String convertCodecIdToCodecName(int i3) {
        if (i3 != 26) {
            if (i3 != 138) {
                if (i3 != 166) {
                    if (i3 != 172) {
                        if (i3 != 1029) {
                            if (i3 != 192) {
                                if (i3 != 193) {
                                    return "UNKNOWN";
                                }
                                return "VVC";
                            }
                            return "AVS3";
                        }
                        return "AV1";
                    }
                    return "HEVC";
                }
                return "VP9";
            }
            return "VP8";
        }
        return "AVC";
    }

    private String convertDecoderTypeToDecoderName(int i3) {
        if (i3 != 101) {
            if (i3 != 102) {
                if (i3 != 104) {
                    return "Unknown";
                }
                return "Standalone";
            }
            return "MediaCodec";
        }
        return "FFMPEG";
    }

    private JSONObject generateDecodingCapability(int i3, int i16) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("codec_name", convertCodecIdToCodecName(i3));
        jSONObject.put(TVKDeviceDecodeCapabilityReportConstant.DECODING_CAPABILITY_PARAM_DECODER_NAME, convertDecoderTypeToDecoderName(i16));
        jSONObject.put(TVKDeviceDecodeCapabilityReportConstant.DECODING_CAPABILITY_PARAM_FRAME_RATE, generateDecodingFrameRate(i3, i16));
        return jSONObject;
    }

    private JSONArray generateDecodingCapabilityArray() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        String[] splitStringToArray = TVKUtils.splitStringToArray(TVKMediaPlayerConfig.PlayerConfig.decoding_capability_report_codec_id_list, ",");
        String[] splitStringToArray2 = TVKUtils.splitStringToArray(TVKMediaPlayerConfig.PlayerConfig.decoding_capability_report_decoder_type_list, ",");
        for (String str : splitStringToArray) {
            for (String str2 : splitStringToArray2) {
                try {
                    jSONArray.mo162put(generateDecodingCapability(Integer.parseInt(str), Integer.parseInt(str2)));
                } catch (NumberFormatException unused) {
                    TVKLogUtil.e(TAG, "[generateDecodingCapabilityArray] wrong config. codecIdString=" + str + ", decoderTypeString=" + str2);
                }
            }
        }
        return jSONArray;
    }

    private JSONObject generateDecodingFrameRate(int i3, int i16) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Iterator<Integer> it = DECODING_TEST_FRAME_RATE_LIST.iterator();
        int intValue = it.next().intValue();
        for (ResolutionInfo resolutionInfo : DECODING_TEST_RESOLUTION_LIST) {
            while (!TVKTPCapability.isVideoDecoderSupported(i3, i16, resolutionInfo.width, resolutionInfo.height, intValue) && it.hasNext()) {
                intValue = it.next().intValue();
            }
            jSONObject.put(resolutionInfo.name, intValue);
        }
        return jSONObject;
    }

    @Override // com.tencent.qqlive.tvkplayer.report.capability.ITVKDeviceCapabilityReportGenerator
    public JSONArray generateReportObject() {
        try {
            return generateDecodingCapabilityArray();
        } catch (JSONException e16) {
            TVKLogUtil.e(TAG, e16, "[generateDeviceCapability] there is a exception: ");
            return null;
        }
    }
}
