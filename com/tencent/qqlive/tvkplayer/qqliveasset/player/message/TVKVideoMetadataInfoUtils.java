package com.tencent.qqlive.tvkplayer.qqliveasset.player.message;

import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.thumbplayer.api.common.TPPropertyID;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVideoMetadataInfoUtils {
    private static final String KEY_BIT_DEPTH = "\u91cf\u5316\u6bd4\u7279\u6570";
    private static final String KEY_COLOR_SPACE = "\u8272\u57df";
    private static final String KEY_FPS = "\u5e27\u7387";
    private static final String KEY_PIXEL_ARRANGEMENT_ORDER = "\u50cf\u7d20\u6392\u5217\u987a\u5e8f";
    private static final String KEY_PIXEL_FORMAT = "\u8272\u5ea6\u53d6\u6837";
    private static final String KEY_PIXEL_SHAPE = "\u50cf\u7d20\u5f62\u72b6";
    private static final String KEY_SAMPLING_STRUCTURE = "\u53d6\u6837\u7ed3\u6784";
    private static final String KEY_SCAN_MODE = "\u626b\u63cf\u6a21\u5f0f";
    private static final String KEY_TRANSFER_CHARACTERISTIC = "\u975e\u7ebf\u6027\u8f6c\u6362\u66f2\u7ebf";
    private static final String KEY_VALID_PIXEL_NUM = "\u6709\u6548\u50cf\u7d20\u6570";
    private static final String TAG = "TVKVideoMetadataInfoUtils";
    private static final String VALUE_BIT_DEPTH = "bit";
    private static final String VALUE_COLOR_SPACE_BT2020 = "ITU-R BT.2020";
    private static final String VALUE_COLOR_SPACE_BT2100 = "ITU-R BT.2100-0";
    private static final String VALUE_COLOR_SPACE_BT470 = "ITU-R BT.470";
    private static final String VALUE_COLOR_SPACE_BT709 = "ITU-R BT.709";
    private static final String VALUE_COLOR_SPACE_SMPLE2085 = "SMPTE 2085";
    private static final String VALUE_DEFAULT = "";
    private static final String VALUE_PIXEL_ARRANGEMENT_ORDER = "\u4ece\u5de6\u5230\u53f3\u3001\u4ece\u4e0a\u5230\u4e0b";
    private static final String VALUE_PIXEL_FORMAT_420 = "4:2:0";
    private static final String VALUE_PIXEL_SHAPE = "\u65b9\u5f62\uff081:1\uff09";
    private static final String VALUE_SAMPLING_STRUCTURE = "\u6b63\u4ea4";
    private static final String VALUE_SCAN_MODE_PROGRESSIVE = "\u9010\u884c";
    private static final String VALUE_TRANSFER_CHARACTERISTIC_BT709 = "ITU-R BT.709";
    private static final String VALUE_TRANSFER_CHARACTERISTIC_GAMMA22 = "Gamma 2.2";
    private static final String VALUE_TRANSFER_CHARACTERISTIC_GAMMA28 = "Gamma 2.8";
    private static final String VALUE_TRANSFER_CHARACTERISTIC_HLG = "HLG";
    private static final String VALUE_TRANSFER_CHARACTERISTIC_PQ = "PQ";
    private static final String VALUE_UNKNOWN = "\u672a\u77e5";
    private static final Map<Integer, String> sColorSpaceMap;
    private static final Map<Integer, String> sColorTransferCharacteristicMap;
    private static final Map<Integer, String> sPixelFormatMap;

    static {
        HashMap hashMap = new HashMap();
        sColorSpaceMap = hashMap;
        sColorTransferCharacteristicMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        sPixelFormatMap = hashMap2;
        hashMap.put(1, "ITU-R BT.709");
        hashMap.put(9, VALUE_COLOR_SPACE_BT2020);
        hashMap.put(10, VALUE_COLOR_SPACE_BT2020);
        hashMap.put(5, VALUE_COLOR_SPACE_BT470);
        hashMap.put(11, VALUE_COLOR_SPACE_SMPLE2085);
        hashMap.put(14, VALUE_COLOR_SPACE_BT2100);
        hashMap2.put(0, VALUE_PIXEL_FORMAT_420);
        hashMap2.put(12, VALUE_PIXEL_FORMAT_420);
    }

    public static LinkedHashMap<String, String> buildVideoMetadataMap(Map<String, String> map, TVKNetVideoInfo tVKNetVideoInfo) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(KEY_VALID_PIXEL_NUM, getValidPixelNum(map));
        linkedHashMap.put(KEY_FPS, getFps(map));
        linkedHashMap.put(KEY_SCAN_MODE, VALUE_SCAN_MODE_PROGRESSIVE);
        linkedHashMap.put(KEY_COLOR_SPACE, getColorSpace(map, tVKNetVideoInfo));
        linkedHashMap.put(KEY_TRANSFER_CHARACTERISTIC, getTransferCharacteristic(map, tVKNetVideoInfo));
        linkedHashMap.put(KEY_PIXEL_FORMAT, getPixelFormat(map));
        linkedHashMap.put(KEY_BIT_DEPTH, getBitDepth(map));
        linkedHashMap.put(KEY_SAMPLING_STRUCTURE, VALUE_SAMPLING_STRUCTURE);
        linkedHashMap.put(KEY_PIXEL_SHAPE, VALUE_PIXEL_SHAPE);
        linkedHashMap.put(KEY_PIXEL_ARRANGEMENT_ORDER, VALUE_PIXEL_ARRANGEMENT_ORDER);
        return linkedHashMap;
    }

    private static String getBitDepth(Map<String, String> map) {
        return "";
    }

    private static String getColorSpace(Map<String, String> map, TVKNetVideoInfo tVKNetVideoInfo) {
        if (!map.containsKey(TPPropertyID.TP_PROPERTY_ID_LONG_VIDEO_COLOR_SPACE)) {
            return "";
        }
        try {
            int parseInt = Integer.parseInt(map.get(TPPropertyID.TP_PROPERTY_ID_LONG_VIDEO_COLOR_SPACE));
            Map<Integer, String> map2 = sColorSpaceMap;
            if (map2.containsKey(Integer.valueOf(parseInt))) {
                return map2.get(Integer.valueOf(parseInt));
            }
            if (parseInt == 2) {
                if (isSDR(tVKNetVideoInfo)) {
                    return "ITU-R BT.709";
                }
                return VALUE_COLOR_SPACE_BT2020;
            }
            return VALUE_UNKNOWN;
        } catch (Exception e16) {
            TVKLogUtil.w(TAG, "getColorSpace has exception:" + e16.getMessage());
            return VALUE_UNKNOWN;
        }
    }

    private static String getFps(Map<String, String> map) {
        float f16;
        if (!map.containsKey(TPPropertyID.TP_PROPERTY_ID_FLOAT_VIDEO_FRAMERATE)) {
            return "";
        }
        try {
            f16 = Float.valueOf(map.get(TPPropertyID.TP_PROPERTY_ID_FLOAT_VIDEO_FRAMERATE)).floatValue();
        } catch (Exception e16) {
            TVKLogUtil.w(TAG, "getFps has exception:" + e16.getMessage());
            f16 = 0.0f;
        }
        int i3 = (int) f16;
        if (f16 - i3 == 0.0f) {
            return String.valueOf(i3);
        }
        return String.format("%.2f", Float.valueOf(f16));
    }

    private static String getPixelFormat(Map<String, String> map) {
        return VALUE_UNKNOWN;
    }

    private static String getTransferCharacteristic(Map<String, String> map, TVKNetVideoInfo tVKNetVideoInfo) {
        return VALUE_UNKNOWN;
    }

    private static String getValidPixelNum(Map<String, String> map) {
        return "";
    }

    private static boolean isSDR(TVKNetVideoInfo tVKNetVideoInfo) {
        if (tVKNetVideoInfo != null && (tVKNetVideoInfo.isDolbyVision() || tVKNetVideoInfo.isHDR())) {
            return false;
        }
        return true;
    }
}
