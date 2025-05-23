package com.tencent.qqlive.tvkplayer.tpplayer.tools;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import android.util.Range;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKSystemInfoForHuawei;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import com.tencent.thumbplayer.api.capability.TPDecoderCapability;
import com.tencent.thumbplayer.api.capability.TPDrmCapAttribute;
import com.tencent.thumbplayer.api.capability.TPDrmCapability;
import com.tencent.thumbplayer.api.capability.TPHdrCapAttribute;
import com.tencent.thumbplayer.api.capability.TPHdrCapability;
import com.tencent.thumbplayer.api.capability.TPHdrCapabilityQueryParams;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportMgr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes23.dex */
public class TVKTPCapability {
    private static final int DISPLAY_HDR_NOT_SUPPORT = 0;
    private static final int DISPLAY_HDR_SUPPORT = 1;
    private static final int DISPLAY_HDR_UNKNOWN = -1;
    public static final int FHD_HEIGHT = 1080;
    public static final int FHD_WIDTH = 1920;
    public static final int FRAME_RATE_120 = 120;
    public static final int FRAME_RATE_240 = 240;
    public static final int FRAME_RATE_30 = 30;
    public static final int FRAME_RATE_60 = 60;
    public static final int HD_HEIGHT = 480;
    public static final int HD_WIDTH = 848;
    private static final Map<String, String> HEVC_BLACK_LIST;
    private static final Map<String, String> HEVC_BLACK_LIST_422;
    private static final Map<String, String> HEVC_BLACK_LIST_444;
    private static final int HEVC_MEDIACODEC_10BIT_NOT_SUPPORT = 0;
    private static final int HEVC_MEDIACODEC_10BIT_SUPPORT = 1;
    private static final int HEVC_MEDIACODEC_10BIT_UNKNOWN = -1;
    public static final int SD_HEIGHT = 270;
    public static final int SD_WIDTH = 480;
    public static final int SHD_HEIGHT = 720;
    public static final int SHD_WIDTH = 1280;
    private static final String TAG = "TVKTPCapability";
    public static final int UHD_HEIGHT = 2160;
    public static final int UHD_WIDTH = 3840;
    private static Map<Integer, SupportMaxFrameRateInfo> mCodecSupportMaxFrameRateMap;
    private static ArrayList<Integer> mFrameRateList;
    private static final Map<String, Integer> sDefnToSupportMaxFrameRateForHevc10bit;
    private static int sDisplayHdrSupportType;
    private static int sHevc10BitSupportType;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class SupportMaxFrameRateInfo {
        int mHWSupportMaxFrameRate;
        int mSWSupportMaxFrameRate;

        SupportMaxFrameRateInfo() {
        }
    }

    static {
        HashMap hashMap = new HashMap();
        HEVC_BLACK_LIST = hashMap;
        HashMap hashMap2 = new HashMap();
        HEVC_BLACK_LIST_422 = hashMap2;
        HashMap hashMap3 = new HashMap();
        HEVC_BLACK_LIST_444 = hashMap3;
        sDisplayHdrSupportType = -1;
        sHevc10BitSupportType = -1;
        sDefnToSupportMaxFrameRateForHevc10bit = new HashMap();
        mFrameRateList = new ArrayList<>();
        mCodecSupportMaxFrameRateMap = new ConcurrentHashMap();
        hashMap.put("OPPO", "OPPO A79,OPPO A73,OPPO A83,OPPO A73t,OPPO A79t,OPPO A79k,OPPO A79kt");
        hashMap.put("KTE", "VPad-A107");
        hashMap3.put(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI, "MI PAD");
        hashMap2.put("BBKH9", "H9,H8S");
        hashMap2.put("OKii", "K1,K2");
        hashMap2.put("EEBBK", "Kids,S1");
        mFrameRateList.add(120);
        mFrameRateList.add(60);
    }

    public static boolean checkHevcProfileMain10Support() {
        int i3 = sHevc10BitSupportType;
        if (i3 != -1) {
            if (i3 != 1) {
                return false;
            }
            return true;
        }
        sHevc10BitSupportType = 0;
        try {
            for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
                if (!mediaCodecInfo.isEncoder()) {
                    for (String str : mediaCodecInfo.getSupportedTypes()) {
                        if (str.equalsIgnoreCase("video/hevc")) {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                            if (!capabilitiesForType.isFeatureSupported("secure-playback")) {
                                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : capabilitiesForType.profileLevels) {
                                    if (codecProfileLevel.profile == 2) {
                                        sHevc10BitSupportType = 1;
                                        initDefnToSupportMaxFrameRateMapForHevc10Bit(capabilitiesForType.getVideoCapabilities());
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16, "checkHevcProfileMain10Support failed");
        }
        return false;
    }

    public static int getDecLevel(int i3, int i16) {
        TVKLogUtil.i(TAG, "[getDecLevel] codecId=" + i3 + ", decType=" + i16);
        if (isVideoDecoderSupported(i3, i16, 3840, 2160, 60)) {
            TVKLogUtil.i(TAG, "return PLAYER_LEVEL_UHD");
            return 8;
        }
        if (isVideoDecoderSupported(i3, i16, 1920, 1080, 30)) {
            TVKLogUtil.i(TAG, "return PLAYER_LEVEL_FHD");
            return 6;
        }
        if (isVideoDecoderSupported(i3, i16, 1280, 720, 30)) {
            TVKLogUtil.i(TAG, "return PLAYER_LEVEL_SHD");
            return 5;
        }
        if (isVideoDecoderSupported(i3, i16, HD_WIDTH, 480, 30)) {
            TVKLogUtil.i(TAG, "return PLAYER_LEVEL_HD");
            return 4;
        }
        if (isVideoDecoderSupported(i3, i16, 480, 270, 30)) {
            TVKLogUtil.i(TAG, "return PLAYER_LEVEL_SD");
            return 3;
        }
        TVKLogUtil.i(TAG, "return PLAYER_LEVEL_MIN");
        return 1;
    }

    public static Map<String, Integer> getDefnToMaxFrameRateForHevc10Bit() {
        return sDefnToSupportMaxFrameRateForHevc10bit;
    }

    public static int getDisplaySupportHdrType(Context context) {
        Display.HdrCapabilities hdrCapabilities;
        int[] supportedHdrTypes;
        int i3 = sDisplayHdrSupportType;
        if (i3 != -1) {
            return i3;
        }
        sDisplayHdrSupportType = 0;
        if (Build.VERSION.SDK_INT < 24) {
            return sDisplayHdrSupportType;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            hdrCapabilities = windowManager.getDefaultDisplay().getHdrCapabilities();
            if (hdrCapabilities != null) {
                supportedHdrTypes = hdrCapabilities.getSupportedHdrTypes();
                for (int i16 : supportedHdrTypes) {
                    if (i16 == 3) {
                        sDisplayHdrSupportType |= 1;
                    } else if (i16 == 2) {
                        sDisplayHdrSupportType |= 2;
                    } else if (i16 == 4) {
                        sDisplayHdrSupportType |= 4;
                    } else if (i16 == 1) {
                        sDisplayHdrSupportType |= 8;
                    }
                }
                return sDisplayHdrSupportType;
            }
            return sDisplayHdrSupportType;
        }
        return sDisplayHdrSupportType;
    }

    @Nullable
    public static TPDrmCapAttribute getDrmCapAttribute(int i3) {
        int i16;
        if (i3 != 4) {
            if (i3 != 5) {
                i16 = -1;
            } else {
                i16 = 3;
            }
        } else {
            i16 = 0;
        }
        if (i16 == -1) {
            return null;
        }
        try {
            return TPDrmCapability.getDrmCapAttribute(i16);
        } catch (TPLoadLibraryException e16) {
            TVKLogUtil.e(TAG, "getDrmAttribute, has exception:" + e16);
            return null;
        }
    }

    @Nullable
    public static TPHdrCapAttribute getHdrCapAttribute(int i3) {
        try {
            return TPHdrCapability.getHdrCapAttribute(i3);
        } catch (TPLoadLibraryException e16) {
            TVKLogUtil.e(TAG, "getHdrCapAttribute, has exception:" + e16);
            return null;
        }
    }

    public static int getMaxFrameRate(int i3) {
        return getMaxFrameRate(i3, TVKPlayerStrategy.isEnabledMediaCodec());
    }

    private static int getMediaCodecMaxFrameRate(int i3, int i16, int i17) {
        Iterator<Integer> it = mFrameRateList.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            TVKLogUtil.i(TAG, "[getMediaCodecMaxFrameRate] codecId=" + i3 + ", frameRate=" + next);
            if (isVideoDecoderSupported(i3, 102, i16, i17, next.intValue())) {
                TVKLogUtil.i(TAG, "[getMediaCodecMaxFrameRate] mediacodec return frameRate=" + next);
                return next.intValue();
            }
        }
        TVKLogUtil.i(TAG, "[getMediaCodecMaxFrameRate] return default frameRate=30");
        return 30;
    }

    private static int getSoftDecodeMaxFrameRate(int i3, int i16, int i17) {
        Iterator<Integer> it = mFrameRateList.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            TVKLogUtil.i(TAG, "[getSoftDecodeMaxFrameRate] codecId=" + i3 + ", frameRate=" + next);
            if (isVideoDecoderSupported(i3, 101, i16, i17, next.intValue())) {
                TVKLogUtil.i(TAG, "[getSoftDecodeMaxFrameRate] ffmpeg return frameRate=" + next);
                return next.intValue();
            }
        }
        TVKLogUtil.i(TAG, "[getSoftDecodeMaxFrameRate] return default frameRate=30");
        return 30;
    }

    public static void init() {
        initCodecSupportMaxFrameRateMap(172);
        initCodecSupportMaxFrameRateMap(192);
        initCodecSupportMaxFrameRateMap(193);
        TVKLogUtil.i(TAG, "[init] end");
    }

    private static void initCodecSupportMaxFrameRateMap(int i3) {
        SupportMaxFrameRateInfo supportMaxFrameRateInfo = new SupportMaxFrameRateInfo();
        supportMaxFrameRateInfo.mHWSupportMaxFrameRate = getMediaCodecMaxFrameRate(i3, 1920, 1080);
        supportMaxFrameRateInfo.mSWSupportMaxFrameRate = getSoftDecodeMaxFrameRate(i3, 1920, 1080);
        mCodecSupportMaxFrameRateMap.put(Integer.valueOf(i3), supportMaxFrameRateInfo);
    }

    private static void initDefnToSupportMaxFrameRateMapForHevc10Bit(@NonNull MediaCodecInfo.VideoCapabilities videoCapabilities) {
        Range<Double> supportedFrameRatesFor = videoCapabilities.getSupportedFrameRatesFor(3840, 2160);
        Map<String, Integer> map = sDefnToSupportMaxFrameRateForHevc10bit;
        map.put("uhd", Integer.valueOf(supportedFrameRatesFor.getUpper().intValue()));
        map.put("fhd", Integer.valueOf(videoCapabilities.getSupportedFrameRatesFor(1920, 1080).getUpper().intValue()));
        map.put("shd", Integer.valueOf(videoCapabilities.getSupportedFrameRatesFor(1280, 720).getUpper().intValue()));
        map.put("hd", Integer.valueOf(videoCapabilities.getSupportedFrameRatesFor(HD_WIDTH, 480).getUpper().intValue()));
        map.put("sd", Integer.valueOf(videoCapabilities.getSupportedFrameRatesFor(480, 270).getUpper().intValue()));
    }

    public static boolean isAdaptiveSwitchDefinitionSupported(Context context) {
        if (TVKMediaPlayerConfig.PlayerConfig.qqlive_asset_player_use_proxy && TPDataTransportMgr.isNativeInit() && TVKPlayerStrategy.isSelfPlayerAvailable(context)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
    
        r5 = r5.getDefaultDisplay().getHdrCapabilities();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isHdr10SupportedByDisplay(Context context) {
        Display.HdrCapabilities hdrCapabilities;
        int[] supportedHdrTypes;
        if (Build.VERSION.SDK_INT >= 24 && (r5 = (WindowManager) context.getSystemService("window")) != null && hdrCapabilities != null) {
            supportedHdrTypes = hdrCapabilities.getSupportedHdrTypes();
            for (int i3 : supportedHdrTypes) {
                if (i3 == 2) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean isHdrSupported(int i3) {
        int i16;
        int i17;
        int i18 = 120;
        int i19 = 2160;
        int i26 = 3840;
        switch (i3) {
            case 8:
                i18 = 30;
                i19 = 1080;
                i26 = 1920;
                i16 = 172;
                i17 = 4;
                break;
            case 9:
                i18 = 60;
                i19 = 1080;
                i26 = 1920;
                i16 = 172;
                i17 = 4;
                break;
            case 10:
                i19 = 1080;
                i26 = 1920;
                i16 = 172;
                i17 = 4;
                break;
            case 11:
                i18 = 30;
                i16 = 172;
                i17 = 4;
                break;
            case 12:
                i18 = 60;
                i16 = 172;
                i17 = 4;
                break;
            case 13:
                i16 = 172;
                i17 = 4;
                break;
            default:
                i17 = -1;
                i18 = Integer.MAX_VALUE;
                i19 = Integer.MAX_VALUE;
                i26 = Integer.MAX_VALUE;
                i16 = -1;
                break;
        }
        try {
            TPHdrCapabilityQueryParams build = new TPHdrCapabilityQueryParams.Builder().setHdrType(i17).setVideoCodecType(i16).setWidth(i26).setHeight(i19).setFrameRate(i18).build();
            if (i17 != 4) {
                if (1 != TPHdrCapability.getHdrCapability(build)) {
                    return false;
                }
                return true;
            }
            TPHdrCapAttribute hdrCapAttribute = TPHdrCapability.getHdrCapAttribute(build);
            if (hdrCapAttribute == null || hdrCapAttribute.getSupportedMappingTypes().isEmpty()) {
                return false;
            }
            return hdrCapAttribute.getSupportedMappingTypes().contains(3);
        } catch (TPLoadLibraryException e16) {
            TVKLogUtil.e(TAG, "[isHdrSupported] exception:" + e16);
            return false;
        }
    }

    public static boolean isModelInHdrVividList(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        TVKLogUtil.i(TAG, "HdrVivid modelListStr: " + str);
        int[] parseHdrVividSupportRangeFromListStr = parseHdrVividSupportRangeFromListStr(str, str2);
        if (parseHdrVividSupportRangeFromListStr == null) {
            TVKLogUtil.i(TAG, "current model:" + TVKVcSystemInfo.getDeviceModel() + " not in HdrVividList");
            return false;
        }
        int displayVersion = TVKSystemInfoForHuawei.getDisplayVersion();
        int patchVersion = TVKSystemInfoForHuawei.getPatchVersion();
        TVKLogUtil.i(TAG, "current model display version:" + displayVersion + ", current patch version:" + patchVersion + ", upperDisplayVersion:" + parseHdrVividSupportRangeFromListStr[0] + ", lowerDisplayVersion:" + parseHdrVividSupportRangeFromListStr[1] + ", upperPatchVersion:" + parseHdrVividSupportRangeFromListStr[2] + ", lowerPatchVersion:" + parseHdrVividSupportRangeFromListStr[3]);
        if (displayVersion > parseHdrVividSupportRangeFromListStr[0] || displayVersion < parseHdrVividSupportRangeFromListStr[1] || patchVersion > parseHdrVividSupportRangeFromListStr[2] || patchVersion < parseHdrVividSupportRangeFromListStr[3]) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isModelInHevcBlackList() {
        boolean z16;
        Map<String, String> map;
        String manufacturer = TVKVcSystemInfo.getManufacturer();
        String osVersion = TVKVcSystemInfo.getOsVersion();
        if ("4.4.4".equals(osVersion)) {
            Map<String, String> map2 = HEVC_BLACK_LIST_444;
            if (map2.containsKey(manufacturer)) {
                z16 = TVKUtils.isModelInList(map2.get(manufacturer));
                if ("4.2.2".equals(osVersion)) {
                    Map<String, String> map3 = HEVC_BLACK_LIST_422;
                    if (map3.containsKey(manufacturer)) {
                        z16 = TVKUtils.isModelInList(map3.get(manufacturer));
                    }
                }
                map = HEVC_BLACK_LIST;
                if (map.containsKey(manufacturer)) {
                    z16 = TVKUtils.isModelInList(map.get(manufacturer));
                }
                TVKLogUtil.i(TAG, "[isModelInHevcBlackList] OS version: " + osVersion + ", is model in list? " + z16);
                return z16;
            }
        }
        z16 = false;
        if ("4.2.2".equals(osVersion)) {
        }
        map = HEVC_BLACK_LIST;
        if (map.containsKey(manufacturer)) {
        }
        TVKLogUtil.i(TAG, "[isModelInHevcBlackList] OS version: " + osVersion + ", is model in list? " + z16);
        return z16;
    }

    public static boolean isSupportCuvaHdr() {
        try {
            TPHdrCapAttribute hdrCapAttribute = TPHdrCapability.getHdrCapAttribute(4);
            if (hdrCapAttribute == null || hdrCapAttribute.getSupportedMappingTypes().isEmpty()) {
                return false;
            }
            return hdrCapAttribute.getSupportedMappingTypes().contains(3);
        } catch (TPLoadLibraryException e16) {
            TVKLogUtil.e(TAG, "isSupportCuvaHdr, has exception:" + e16);
            return false;
        }
    }

    public static boolean isSupportDolbyAudio() {
        if (!isSupportHardDecodeDolbyAudio() && !isSupportSoftDecodeDolbyAudio()) {
            return false;
        }
        return true;
    }

    public static boolean isSupportDolbyVision() {
        try {
            if (TPHdrCapability.getHdrCapability(2) != 1) {
                return false;
            }
            return true;
        } catch (TPLoadLibraryException e16) {
            TVKLogUtil.e(TAG, "isSupportDolbyVision, has exception:" + e16);
            return false;
        }
    }

    public static boolean isSupportHDR10() {
        try {
            if (TPHdrCapability.getHdrCapability(0) != 1) {
                return false;
            }
            return true;
        } catch (TPLoadLibraryException e16) {
            TVKLogUtil.e(TAG, "isSupportHDR10, has exception:" + e16);
            return false;
        }
    }

    public static boolean isSupportHardDecodeDolbyAudio() {
        if (!TVKMediaPlayerConfig.PlayerConfig.enable_dolby_audio_mediacodec) {
            return false;
        }
        try {
            if (TPDecoderCapability.getAudioDecoderCapability(5040, 2) != 1) {
                return false;
            }
            return true;
        } catch (TPLoadLibraryException e16) {
            TVKLogUtil.e(TAG, "isAudioDecoderSupported, has exception:" + e16);
            return false;
        }
    }

    public static boolean isSupportSoftDecodeDolbyAudio() {
        if (!TVKMediaPlayerConfig.PlayerConfig.enable_dolby_audio_softdecoder) {
            return false;
        }
        try {
            if (TPDecoderCapability.getAudioDecoderCapability(5040, 4) != 1) {
                return false;
            }
            return true;
        } catch (TPLoadLibraryException e16) {
            TVKLogUtil.e(TAG, "isAudioDecoderSupported, has exception:" + e16);
            return false;
        }
    }

    public static boolean isVideoDecoderSupported(int i3, int i16, int i17, int i18, int i19) {
        try {
            if (TPDecoderCapability.getVideoDecoderCapability(i3, i16, i17, i18, i19) != 1) {
                return false;
            }
            return true;
        } catch (TPLoadLibraryException e16) {
            TVKLogUtil.e(TAG, "isVideoDecoderSupported, has exception:" + e16);
            return false;
        }
    }

    @Nullable
    private static int[] parseHdrVividSupportRangeFromListStr(String str, String str2) {
        String deviceModel = TVKVcSystemInfo.getDeviceModel();
        for (String str3 : str.split(",")) {
            if (str3.startsWith(deviceModel)) {
                String substring = str3.substring(deviceModel.length());
                if (!TextUtils.isEmpty(substring) && substring.startsWith("(") && substring.endsWith(")")) {
                    TVKLogUtil.i(TAG, "your phone :" + deviceModel + " in hdrVivid " + str2 + ", support version=" + substring);
                    String substring2 = substring.substring(1, substring.length() - 1);
                    String[] split = substring2.split("/");
                    if (split.length != 4) {
                        TVKLogUtil.e(TAG, "parseHdrVividSupportRangeFromListStr " + str2 + ", range define error=" + substring2);
                        return null;
                    }
                    try {
                        return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3])};
                    } catch (NumberFormatException e16) {
                        TVKLogUtil.e(TAG, e16, "parseHdrVividSupportRangeFromListStr " + str2);
                        return null;
                    }
                }
            }
        }
        return null;
    }

    private static int getMaxFrameRate(int i3, boolean z16) {
        int i16;
        int i17;
        String str = TVKMediaPlayerConfig.PlayerConfig.frame_rate_test_start_def;
        if ("uhd".equalsIgnoreCase(str)) {
            i17 = 3840;
            i16 = 2160;
        } else {
            if (!"fhd".equalsIgnoreCase(str)) {
                if ("shd".equalsIgnoreCase(str)) {
                    i17 = 1280;
                    i16 = 720;
                } else if ("hd".equalsIgnoreCase(str)) {
                    i17 = HD_WIDTH;
                    i16 = 480;
                } else if ("sd".equalsIgnoreCase(str)) {
                    i16 = 270;
                    i17 = 480;
                }
            }
            i17 = 1920;
            i16 = 1080;
        }
        SupportMaxFrameRateInfo supportMaxFrameRateInfo = mCodecSupportMaxFrameRateMap.get(Integer.valueOf(i3));
        if (supportMaxFrameRateInfo != null && i17 == 1920 && i16 == 1080) {
            return z16 ? supportMaxFrameRateInfo.mHWSupportMaxFrameRate : supportMaxFrameRateInfo.mSWSupportMaxFrameRate;
        }
        if (z16) {
            return getMediaCodecMaxFrameRate(i3, i17, i16);
        }
        return getSoftDecodeMaxFrameRate(i3, i17, i16);
    }
}
