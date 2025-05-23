package com.tencent.thumbplayer.core.codec.capability;

import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.thumbplayer.core.hdr.capability.TPHdrSystemRenderBlackWhiteList;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;
import java.util.HashMap;

/* loaded from: classes26.dex */
public class TPMediaCodecDeviceBlackWhiteList {
    private static final String AUDIO_ALL_CODEC = "audio";
    private static final String VIDEO_ALL_CODEC = "video";
    private static String[] sMediaCodecMultiInstancesBlackList;
    private static HashMap<String, String[]> sCodecModelWhiteListMap = new HashMap<>();
    private static HashMap<String, String[]> sCodecModelBlackListMap = new HashMap<>();
    private static HashMap<String, DeviceInfo[]> sCodecDeviceInfoBlackListMap = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class DeviceInfo {
        public String mDeviceName;
        public String mOsVersion;

        public DeviceInfo(String str, String str2) {
            this.mDeviceName = str;
            this.mOsVersion = str2;
        }
    }

    static {
        sMediaCodecMultiInstancesBlackList = null;
        sCodecModelWhiteListMap.put("video/avc", new String[]{"NX511J", "Hi3798MV100", "\u957f\u8679\u667a\u80fd\u7535\u89c6", "Android TV on Tcl 901", "xt880b"});
        sCodecModelWhiteListMap.put("video/hevc", new String[]{"NX511J", "Hi3798MV100", "\u957f\u8679\u667a\u80fd\u7535\u89c6", "Android TV on Tcl 901", "xt880b"});
        sCodecModelWhiteListMap.put("audio/mp4a-latm", new String[]{"NX511J", "Hi3798MV100", "\u957f\u8679\u667a\u80fd\u7535\u89c6", "Android TV on Tcl 901", "xt880b"});
        sCodecModelBlackListMap.put("video", new String[]{"SM-J7008", "SM-J5008", "TCL i806", "NX511J", "vivo Y11i T", "\u957f\u8679\u667a\u80fd\u7535\u89c6", "MI 1S", "SP9832A", "SP9830A", "VOTO GT17", "EVA-AL10"});
        sCodecModelBlackListMap.put("video/hevc", new String[]{"PRO 7 Plus", "PRO 7-H", "PRO+7+Plus", "OPPO A79", "OPPO A73", "OPPO A83", "OPPO A73t", "OPPO A79t", "OPPO A79k", "OPPO A79kt", "VPad-A107"});
        sCodecDeviceInfoBlackListMap.put("video/hevc", new DeviceInfo[]{new DeviceInfo("MI PAD", "4.4.4"), new DeviceInfo("H9,H8S", TbsConfig.TBS_SDK_VERSIONNAME), new DeviceInfo("K1,K2", TbsConfig.TBS_SDK_VERSIONNAME), new DeviceInfo("Kids,S1", TbsConfig.TBS_SDK_VERSIONNAME)});
        sMediaCodecMultiInstancesBlackList = new String[]{"PRO 7", "PRO 7 Plus"};
    }

    public static boolean isCurrentDeviceInBlackList(String str) {
        if (str.isEmpty()) {
            return false;
        }
        if (!isInDeviceInfoList(sCodecDeviceInfoBlackListMap.get(str)) && !TPSystemInfo.isCurrentDeviceInList(sCodecModelBlackListMap.get(str)) && ((!str.contains("video") || !TPSystemInfo.isCurrentDeviceInList(sCodecModelBlackListMap.get("video"))) && (!str.contains("audio") || !TPSystemInfo.isCurrentDeviceInList(sCodecModelBlackListMap.get("audio"))))) {
            return false;
        }
        return true;
    }

    public static boolean isCurrentDeviceInHdrMediaCodecWhiteList(int i3) {
        return TPHdrSystemRenderBlackWhiteList.isCurrentDeviceOrManufacturerInHdrWhiteList(i3);
    }

    public static boolean isCurrentDeviceInMultiInstancesBlackList() {
        return TPSystemInfo.isCurrentDeviceInList(sMediaCodecMultiInstancesBlackList);
    }

    public static boolean isCurrentDeviceInWhiteList(String str) {
        if (str.isEmpty()) {
            return false;
        }
        if (!TPSystemInfo.isCurrentDeviceInList(sCodecModelWhiteListMap.get(str)) && ((!str.contains("video") || !TPSystemInfo.isCurrentDeviceInList(sCodecModelWhiteListMap.get("video"))) && (!str.contains("audio") || !TPSystemInfo.isCurrentDeviceInList(sCodecModelWhiteListMap.get("audio"))))) {
            return false;
        }
        return true;
    }

    private static boolean isInDeviceInfoList(DeviceInfo[] deviceInfoArr) {
        if (deviceInfoArr != null && deviceInfoArr.length != 0) {
            String deviceName = TPSystemInfo.getDeviceName();
            String osVersion = TPSystemInfo.getOsVersion();
            for (DeviceInfo deviceInfo : deviceInfoArr) {
                if (deviceInfo.mOsVersion.equals(osVersion) && deviceInfo.mDeviceName.equals(deviceName)) {
                    return true;
                }
            }
        }
        return false;
    }
}
