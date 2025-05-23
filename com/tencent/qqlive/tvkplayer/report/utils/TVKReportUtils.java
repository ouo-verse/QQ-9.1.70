package com.tencent.qqlive.tvkplayer.report.utils;

import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.TVKAudioEffectType;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.video.TVKVideoFxType;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.postprocess.api.TVKMonetCapability;
import com.tencent.qqlive.tvkplayer.report.capability.hdr.TVKDeviceHdrCapabilityReportConstant;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKReportUtils {
    private static final int AUDIO_ENCODE_TYPE_AAC = 1;
    private static final int AUDIO_ENCODE_TYPE_DOLBY = 2;
    private static final String NETWORK_TYPE_CHINA_CMCC = "cmcc";
    private static final String NETWORK_TYPE_CHINA_TELCOM = "telcom";
    private static final String NETWORK_TYPE_CHINA_UNICOM = "unicomtype";
    private static final int REPORT_TYPE_AFD_TYPE = 8;
    private static final int REPORT_TYPE_LIVE_PID = 4;
    private static final int REPORT_TYPE_LIVE_SID = 5;
    private static final int REPORT_TYPE_OFFLINE_VOD_VID = 6;
    private static final int REPORT_TYPE_ONLINE_VOD_QUICK_PLAY = 9;
    private static final int REPORT_TYPE_ONLINE_VOD_VID = 2;
    private static final int REPORT_TYPE_ONLINE_VOD_XML = 1;
    private static final int REPORT_TYPE_PFD_TYPE = 7;
    private static final int REPORT_TYPE_SIMULATED_LIVE = 10;
    private static final int REPORT_TYPE_UNKNOWN = 0;
    private static final int REPORT_TYPE_URL = 3;
    private static final String TAG = "TVKPlayer[TVKReportUtils]";
    private static final String TESTID_DELIMITER = "#";
    public static final int TVK_AUDIO_EFFECT_TYPE_NONE = 0;
    public static final int TVK_REPORT_AUDIO_EFFECT_TYPE_CLEAR_VOICE = 4;
    public static final int TVK_REPORT_AUDIO_EFFECT_TYPE_LIVE_CONCERT = 8;
    public static final int TVK_REPORT_AUDIO_EFFECT_TYPE_PANO_SURROUND = 2;
    public static final int TVK_REPORT_AUDIO_EFFECT_TYPE_SURROUND = 1;
    public static final int TVK_VIDEO_POST_PROCESS_COLORBLINDNESS = 4;
    public static final int TVK_VIDEO_POST_PROCESS_NONE = 0;
    public static final int TVK_VIDEO_POST_PROCESS_TVMSR = 1;
    public static final int TVK_VIDEO_POST_PROCESS_VR = 2;
    private static final int VIDEO_ENCODE_TYPE_H264 = 1;
    private static final int VIDEO_ENCODE_TYPE_HEVC = 2;
    private static final Map<Integer, Integer> sAssetTypeToReportType;
    private static final Map<Integer, String> sHdrMappingTypeToNameMap;
    private static final Map<TVKAudioEffectType, Integer> sReportAudioEffectTypeMap;
    private static final Map<TVKVideoFxType, Integer> sReportEffectTypeMap;

    static {
        HashMap hashMap = new HashMap();
        sHdrMappingTypeToNameMap = hashMap;
        HashMap hashMap2 = new HashMap();
        sAssetTypeToReportType = hashMap2;
        HashMap hashMap3 = new HashMap();
        sReportEffectTypeMap = hashMap3;
        HashMap hashMap4 = new HashMap();
        sReportAudioEffectTypeMap = hashMap4;
        hashMap.put(0, TVKDeviceHdrCapabilityReportConstant.HDR_MAPPING_NAME_NONE);
        hashMap.put(1, TVKDeviceHdrCapabilityReportConstant.HDR_MAPPING_NAME_HARD_HDR_MAPPING);
        hashMap.put(2, TVKDeviceHdrCapabilityReportConstant.HDR_MAPPING_NAME_SOFT_HDR_MAPPING);
        hashMap.put(3, TVKDeviceHdrCapabilityReportConstant.HDR_MAPPING_NAME_HARD_HDR10_MAPPING);
        hashMap.put(4, TVKDeviceHdrCapabilityReportConstant.HDR_MAPPING_NAME_SOFT_HDR10_MAPPING);
        hashMap.put(5, TVKDeviceHdrCapabilityReportConstant.HDR_MAPPING_NAME_SOFT_SDR_MAPPING);
        hashMap.put(6, TVKDeviceHdrCapabilityReportConstant.HDR_MAPPING_NAME_HARD_HLG_MAPPING);
        hashMap.put(7, TVKDeviceHdrCapabilityReportConstant.HDR_MAPPING_NAME_SOFT_HLG_MAPPING);
        hashMap2.put(65536, 1);
        hashMap2.put(131072, 2);
        hashMap2.put(2, 3);
        hashMap2.put(256, 4);
        hashMap2.put(512, 5);
        hashMap2.put(262144, 6);
        hashMap2.put(4, 7);
        hashMap2.put(8, 8);
        hashMap2.put(524288, 9);
        hashMap2.put(1048576, 10);
        hashMap3.put(TVKVideoFxType.EFFECT_TVM_SUPER_RESOLUTION, 1);
        hashMap3.put(TVKVideoFxType.EFFECT_VR, 2);
        hashMap3.put(TVKVideoFxType.EFFECT_COLOR_BLINDNESS, 4);
        hashMap4.put(TVKAudioEffectType.TVK_AUDIO_EFFECT_TYPE_SURROUND, 1);
        hashMap4.put(TVKAudioEffectType.TVK_AUDIO_EFFECT_TYPE_PANO_SURROUND, 2);
        hashMap4.put(TVKAudioEffectType.TVK_AUDIO_EFFECT_TYPE_CLEAR_VOICE, 4);
        hashMap4.put(TVKAudioEffectType.TVK_AUDIO_EFFECT_TYPE_LIVE_CONCERT, 8);
    }

    public static String concatTestIdFromAbTestInfo(String str, Map<String, Integer> map) {
        if (map != null && !map.isEmpty()) {
            HashSet<Integer> hashSet = new HashSet(map.values());
            if (!TextUtils.isEmpty(str)) {
                for (String str2 : str.split(TESTID_DELIMITER)) {
                    try {
                        hashSet.add(Integer.valueOf(Integer.parseInt(str2)));
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            StringBuilder sb5 = new StringBuilder();
            for (Integer num : hashSet) {
                sb5.append(TESTID_DELIMITER);
                sb5.append(num.toString());
            }
            if (sb5.length() < 1) {
                return "";
            }
            return sb5.substring(1);
        }
        return str;
    }

    public static int convertToReportAssetTypeEnum(int i3) {
        Integer num = sAssetTypeToReportType.get(Integer.valueOf(i3));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static int getAudioEffectTypeList(List<TVKAudioEffectType> list) {
        int i3 = 0;
        if (list != null && !list.isEmpty()) {
            Iterator<TVKAudioEffectType> it = list.iterator();
            while (it.hasNext()) {
                Integer num = sReportAudioEffectTypeMap.get(it.next());
                if (num != null) {
                    i3 |= num.intValue();
                }
            }
        }
        return i3;
    }

    public static int getFreeTypeForReport() {
        Map<String, String> freeNetFlowRequestMap = TVKCommParams.getFreeNetFlowRequestMap();
        if (freeNetFlowRequestMap != null) {
            String str = freeNetFlowRequestMap.get(NETWORK_TYPE_CHINA_UNICOM);
            if (str != null && !TextUtils.isEmpty(str)) {
                return getUnicomFreeTypeForReport(str);
            }
            String str2 = freeNetFlowRequestMap.get(NETWORK_TYPE_CHINA_TELCOM);
            if (str2 != null && !TextUtils.isEmpty(str2)) {
                return 20;
            }
            String str3 = freeNetFlowRequestMap.get("cmcc");
            if (str3 != null && !TextUtils.isEmpty(str3)) {
                return 30;
            }
            return 0;
        }
        return 0;
    }

    public static String getMappingTypeName(int i3) {
        Map<Integer, String> map = sHdrMappingTypeToNameMap;
        if (map.containsKey(Integer.valueOf(i3))) {
            return map.get(Integer.valueOf(i3));
        }
        return Integer.toString(i3);
    }

    public static String getOmgid(TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        if (tVKPlayerVideoInfo != null && tVKPlayerVideoInfo.getReportInfoProperties() != null && tVKPlayerVideoInfo.getReportInfoProperties().getProperties().get("omgid") != null) {
            return (String) tVKPlayerVideoInfo.getReportInfoProperties().getProperties().get("omgid");
        }
        return "";
    }

    public static int getReportEffectType(TVKNetVideoInfo tVKNetVideoInfo) {
        if (needSuperResolution(tVKNetVideoInfo)) {
            return 1;
        }
        if (needHdr10Enhance(tVKNetVideoInfo)) {
            return 4;
        }
        return 0;
    }

    public static int getReportLiveType(TVKLiveVideoInfo tVKLiveVideoInfo) {
        int i3;
        int i16;
        int i17;
        int i18 = 0;
        if (tVKLiveVideoInfo == null) {
            return 0;
        }
        if (tVKLiveVideoInfo.getStream() == 2) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (tVKLiveVideoInfo.getvCode() == 2) {
            i17 = 0;
            i16 = 1;
        } else {
            i16 = 0;
            i17 = 1;
        }
        int live360 = tVKLiveVideoInfo.getLive360();
        if (tVKLiveVideoInfo.getaCode() == 2) {
            i18 = 1;
        }
        return (i3 << 4) | (i17 << 3) | (i16 << 2) | (live360 << 1) | i18;
    }

    private static int getUnicomFreeTypeForReport(String str) {
        int optInt = TVKUtils.optInt(str, -1);
        if (optInt != 0) {
            if (optInt != 1) {
                if (optInt != 2) {
                    if (optInt != 3) {
                        return 0;
                    }
                } else {
                    return 12;
                }
            } else {
                return 11;
            }
        }
        return 10;
    }

    public static int getVideoPostProcessEffectTypeList(List<TVKVideoFxType> list) {
        int i3 = 0;
        if (list != null && !list.isEmpty()) {
            Iterator<TVKVideoFxType> it = list.iterator();
            while (it.hasNext()) {
                Integer num = sReportEffectTypeMap.get(it.next());
                if (num != null) {
                    i3 |= num.intValue();
                }
            }
        }
        return i3;
    }

    public static boolean needHdr10Enhance(TVKNetVideoInfo tVKNetVideoInfo) {
        if (tVKNetVideoInfo == null) {
            return false;
        }
        try {
            if (tVKNetVideoInfo.getCurDefinition() == null || !tVKNetVideoInfo.getCurDefinition().getDefn().equals("hdr10") || tVKNetVideoInfo.getCurDefinition().getVideoCodec() == 3) {
                return false;
            }
            if (tVKNetVideoInfo.getCurDefinition().getHdr10EnHance() != 1) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            TVKLogUtil.e(TAG, "needHdr10Enhance,data is null");
            return false;
        }
    }

    public static boolean needSuperResolution(TVKNetVideoInfo tVKNetVideoInfo) {
        if (tVKNetVideoInfo != null) {
            try {
                if (tVKNetVideoInfo.getCurDefinition() != null && tVKNetVideoInfo.getCurDefinition().getSuperResolution() <= 0) {
                    TVKLogUtil.w(TAG, "definition not need sr");
                    return false;
                }
            } catch (Exception unused) {
                TVKLogUtil.e(TAG, "needSuperResolution,data is null");
                return false;
            }
        }
        if (!TVKMonetCapability.isSuperResolutionSupported()) {
            TVKLogUtil.w(TAG, "system not support sr");
            return false;
        }
        TVKLogUtil.i(TAG, "needSuperResolution");
        return true;
    }
}
