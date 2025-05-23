package com.tencent.thumbplayer.core.hdr.capability;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.thumbplayer.core.utils.TPNativeLog;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;
import java.util.HashMap;

/* loaded from: classes26.dex */
public class TPHdrVividBlackWhiteListForHuaWei {
    private static final String TAG = "TPHdrVividDeviceBlackWhiteList";
    private static final String sDisplayVersion;
    private static HashMap<String, HdrVividSupportedMinVersion> sHdrVividMediaCodecWhiteListMap;
    private static final String sPatchVersion;

    /* loaded from: classes26.dex */
    private static class HdrVividSupportedMinVersion {
        int minSystemVersion;
        int minsPatchVersion;

        public HdrVividSupportedMinVersion(int i3, int i16) {
            this.minSystemVersion = i3;
            this.minsPatchVersion = i16;
        }
    }

    static {
        HashMap<String, HdrVividSupportedMinVersion> hashMap = new HashMap<>();
        sHdrVividMediaCodecWhiteListMap = hashMap;
        hashMap.put("TAS-AL00", new HdrVividSupportedMinVersion(1100165, 3));
        sHdrVividMediaCodecWhiteListMap.put("TAS-TL00", new HdrVividSupportedMinVersion(1100165, 3));
        sHdrVividMediaCodecWhiteListMap.put("TAS-AN00", new HdrVividSupportedMinVersion(1100165, 3));
        sHdrVividMediaCodecWhiteListMap.put("LIO-AN00", new HdrVividSupportedMinVersion(1100165, 3));
        sHdrVividMediaCodecWhiteListMap.put("LIO-AN00P", new HdrVividSupportedMinVersion(1100165, 3));
        sHdrVividMediaCodecWhiteListMap.put("LIO-AN00m", new HdrVividSupportedMinVersion(1100165, 3));
        sHdrVividMediaCodecWhiteListMap.put("LIO-TL00", new HdrVividSupportedMinVersion(1100165, 3));
        sHdrVividMediaCodecWhiteListMap.put("LIO-AL00", new HdrVividSupportedMinVersion(1100165, 3));
        sHdrVividMediaCodecWhiteListMap.put("ANA-AN00", new HdrVividSupportedMinVersion(1100165, 3));
        sHdrVividMediaCodecWhiteListMap.put("ANA-TN00", new HdrVividSupportedMinVersion(1100165, 3));
        sHdrVividMediaCodecWhiteListMap.put("ELS-AN00", new HdrVividSupportedMinVersion(1100165, 3));
        sHdrVividMediaCodecWhiteListMap.put("ELS-TN00", new HdrVividSupportedMinVersion(1100165, 3));
        sHdrVividMediaCodecWhiteListMap.put("ELS-AN10", new HdrVividSupportedMinVersion(1100166, 3));
        sHdrVividMediaCodecWhiteListMap.put("MRX-AL09", new HdrVividSupportedMinVersion(1100150, 5));
        sHdrVividMediaCodecWhiteListMap.put("MRX-AL19", new HdrVividSupportedMinVersion(1100150, 5));
        sHdrVividMediaCodecWhiteListMap.put("MRX-W09", new HdrVividSupportedMinVersion(1100150, 5));
        sHdrVividMediaCodecWhiteListMap.put("MRX-W19", new HdrVividSupportedMinVersion(1100150, 5));
        sHdrVividMediaCodecWhiteListMap.put("MRX-AN19", new HdrVividSupportedMinVersion(1100150, 5));
        sHdrVividMediaCodecWhiteListMap.put("MRX-W29", new HdrVividSupportedMinVersion(1100150, 5));
        sHdrVividMediaCodecWhiteListMap.put("MRX-W39", new HdrVividSupportedMinVersion(1100150, 5));
        sHdrVividMediaCodecWhiteListMap.put("OCE-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("OCE-AN10", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("OCE-AL50", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("OCE-AN50", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("NOH-NX9", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("NOH-AL00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("JAD-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("JAD-AN10", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("JAD-AL60", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("JAD-N29", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("JAD-N09", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("JAD-AL00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("CET-AL00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("DCO-AL00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("HEGE-550", new HdrVividSupportedMinVersion(200187, 0));
        sHdrVividMediaCodecWhiteListMap.put("HEGE-550B", new HdrVividSupportedMinVersion(200187, 0));
        sHdrVividMediaCodecWhiteListMap.put("HEGE-550C", new HdrVividSupportedMinVersion(200187, 0));
        sHdrVividMediaCodecWhiteListMap.put("HEGE-550X", new HdrVividSupportedMinVersion(200187, 0));
        sHdrVividMediaCodecWhiteListMap.put("HEGE-550AX", new HdrVividSupportedMinVersion(200187, 0));
        sHdrVividMediaCodecWhiteListMap.put("HEGE-560", new HdrVividSupportedMinVersion(200187, 0));
        sHdrVividMediaCodecWhiteListMap.put("HEGE-560B", new HdrVividSupportedMinVersion(200187, 0));
        sHdrVividMediaCodecWhiteListMap.put("HEGE-570", new HdrVividSupportedMinVersion(200187, 0));
        sHdrVividMediaCodecWhiteListMap.put("PLAT-760", new HdrVividSupportedMinVersion(200172, 0));
        sHdrVividMediaCodecWhiteListMap.put("KANT-350", new HdrVividSupportedMinVersion(200185, 0));
        sHdrVividMediaCodecWhiteListMap.put("KANT-350B", new HdrVividSupportedMinVersion(200185, 0));
        sHdrVividMediaCodecWhiteListMap.put("KANT-350C", new HdrVividSupportedMinVersion(200185, 0));
        sHdrVividMediaCodecWhiteListMap.put("KANT-350S", new HdrVividSupportedMinVersion(200185, 0));
        sHdrVividMediaCodecWhiteListMap.put("KANT-360", new HdrVividSupportedMinVersion(200185, 0));
        sHdrVividMediaCodecWhiteListMap.put("KANT-360S", new HdrVividSupportedMinVersion(200185, 0));
        sHdrVividMediaCodecWhiteListMap.put("KANT-370", new HdrVividSupportedMinVersion(200185, 0));
        sHdrVividMediaCodecWhiteListMap.put("KANT-370S", new HdrVividSupportedMinVersion(200185, 0));
        sHdrVividMediaCodecWhiteListMap.put("KANT-359", new HdrVividSupportedMinVersion(200183, 0));
        sHdrVividMediaCodecWhiteListMap.put("KANT-369", new HdrVividSupportedMinVersion(200183, 0));
        sHdrVividMediaCodecWhiteListMap.put("THAL-550", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("THAL-560", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("THAL-570", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("THAL-580", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("FREG-770", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("DESC-220", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("DESC-250SY", new HdrVividSupportedMinVersion(10200557, 0));
        sHdrVividMediaCodecWhiteListMap.put("DESC-250S", new HdrVividSupportedMinVersion(10200557, 0));
        sHdrVividMediaCodecWhiteListMap.put("DESC-250SZ", new HdrVividSupportedMinVersion(10200557, 0));
        sHdrVividMediaCodecWhiteListMap.put("DESC-250", new HdrVividSupportedMinVersion(10200557, 0));
        sHdrVividMediaCodecWhiteListMap.put("DESC-260SY", new HdrVividSupportedMinVersion(10200557, 0));
        sHdrVividMediaCodecWhiteListMap.put("DESC-260S", new HdrVividSupportedMinVersion(10200557, 0));
        sHdrVividMediaCodecWhiteListMap.put("DESC-260SZ", new HdrVividSupportedMinVersion(10200557, 0));
        sHdrVividMediaCodecWhiteListMap.put("DESC-260", new HdrVividSupportedMinVersion(10200557, 0));
        sHdrVividMediaCodecWhiteListMap.put("DESC-270", new HdrVividSupportedMinVersion(10200547, 0));
        sHdrVividMediaCodecWhiteListMap.put("SOKR-790A", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("VOLT-350S", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("HPB-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("MHS-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("MHS-AN10", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("MHS-AN20", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("MHS-N09", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("MHS-N19", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("PGT-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("PGT-AN10", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("PGT-AN20", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("PGT-N09", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("PGT-N19", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("GOA-AL80", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("GOA-LX9", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("SJC-AL80", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("SJC-LX9", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("FOA-AL00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("FOA-LX9", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("SFO-AL00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("SFO-LX9", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("REA-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("REA-NX9", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("REP-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("RTG-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("RTG-NX9", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("PFM-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("VER-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("VER-AN10", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("VCA-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("MAA-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("MAA-AN10", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("MAG-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("FCP-AN10", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("FLC-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("ROD2-W69", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("ROD2-W09", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("ELP-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("ELI-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("FCP-AN20", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("LMR-AN20", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("PTP-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("PTP-AN60", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("PTP-AN10", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("PTP-AN70", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("PTP-AN20", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("AMM-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("AMP-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("AMP-AN10", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("AMG-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("ROL-W00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("ROL-W10", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("AROL-W60", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("HEY3-W00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("HEY3-W10", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("HEY3-N09", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("DVD-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("DVD-AN80", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("PPG-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("DNN-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("DNY-NX9", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("DNP-AN00", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("DNP-NX9", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("MBH-AN10", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("MBH-N49", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("CYN-AN10", new HdrVividSupportedMinVersion(0, 0));
        sHdrVividMediaCodecWhiteListMap.put("CYN-N49", new HdrVividSupportedMinVersion(0, 0));
        String displayVersion = getDisplayVersion();
        sDisplayVersion = displayVersion;
        String systemsPatchVersion = getSystemsPatchVersion();
        sPatchVersion = systemsPatchVersion;
        TPNativeLog.printLog(2, TAG, "display version:" + displayVersion + ", patch version:" + systemsPatchVersion);
    }

    private static int convertDisplayVersion() {
        String str;
        String str2 = sDisplayVersion;
        if (TextUtils.isEmpty(str2)) {
            return 0;
        }
        int[] iArr = {1, 1, 3};
        int indexOf = str2.indexOf(" ");
        if (indexOf != -1) {
            str2 = str2.substring(indexOf + 1);
        }
        int indexOf2 = str2.indexOf("(");
        if (indexOf2 != -1) {
            str2 = str2.substring(0, indexOf2);
        }
        String[] split = str2.split("\\.");
        if (split.length == 4 && (str = split[0]) != null && str.length() != 0) {
            for (int i3 = 1; i3 < 4; i3++) {
                String str3 = split[i3];
                if (str3 == null || str3.length() != iArr[i3 - 1]) {
                    return 0;
                }
            }
            try {
                return (Integer.parseInt(split[0]) * 100000) + (Integer.parseInt(split[1]) * 10000) + (Integer.parseInt(split[2]) * 1000) + Integer.parseInt(split[3]);
            } catch (NumberFormatException e16) {
                TPNativeLog.printLog(0, TAG, "convertDisplayVersion failed:" + e16.getMessage());
            }
        }
        return 0;
    }

    private static int convertPatchVersion() {
        String str;
        String str2 = sPatchVersion;
        if (TextUtils.isEmpty(str2)) {
            return 0;
        }
        String[] split = str2.split("patch");
        if (split.length == 2 && (str = split[1]) != null && str.length() == 3) {
            try {
                return Integer.parseInt(split[1].substring(0, 2));
            } catch (NumberFormatException e16) {
                TPNativeLog.printLog(0, TAG, "convertsPatchVersion failed:" + e16.getMessage());
            }
        }
        return 0;
    }

    private static String getDisplayVersion() {
        if (!TextUtils.equals(Build.BRAND, "HUAWEI") && !TextUtils.equals(Build.MANUFACTURER, CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR)) {
            return null;
        }
        return TPSystemInfo.getSystemProp("ro.build.display.id", "");
    }

    private static String getSystemsPatchVersion() {
        if (!TextUtils.equals(Build.BRAND, "HUAWEI")) {
            return null;
        }
        return TPSystemInfo.getSystemProp("hwouc.hwpatch.version", "");
    }

    public static boolean isDeviceInHdrVividMediaCodecWhiteList() {
        HdrVividSupportedMinVersion hdrVividSupportedMinVersion;
        String deviceName = TPSystemInfo.getDeviceName();
        if (!sHdrVividMediaCodecWhiteListMap.containsKey(deviceName) || (hdrVividSupportedMinVersion = sHdrVividMediaCodecWhiteListMap.get(deviceName)) == null) {
            return false;
        }
        int convertDisplayVersion = convertDisplayVersion();
        int convertPatchVersion = convertPatchVersion();
        if (convertDisplayVersion < hdrVividSupportedMinVersion.minSystemVersion || convertPatchVersion < hdrVividSupportedMinVersion.minsPatchVersion) {
            return false;
        }
        return true;
    }
}
