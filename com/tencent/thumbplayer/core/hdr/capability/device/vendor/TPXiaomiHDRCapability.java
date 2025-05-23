package com.tencent.thumbplayer.core.hdr.capability.device.vendor;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.thumbplayer.core.hdr.capability.TPDisplayHdrCapability;
import com.tencent.thumbplayer.core.hdr.capability.device.ITPManufactureHDRCapabilityInterface;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes26.dex */
public class TPXiaomiHDRCapability implements ITPManufactureHDRCapabilityInterface {
    private static final int FIRMWARE_VERSION_MIN_PART_NUM = 3;
    private static final String MIN_SYSTEM_VERSION = "1.0.29";
    private static final String XIAO_MI_14_MODEL = "23127PN0CC";
    private static final String XIAO_MI_14_PRO_MODEL = "23116PN5BC";

    private static int compareVersion(String str, String str2, int i3) throws NumberFormatException {
        int i16;
        int i17;
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(Math.max(split.length, split2.length), i3);
        for (int i18 = 0; i18 < min; i18++) {
            if (i18 < split.length) {
                i16 = Integer.parseInt(split[i18]);
            } else {
                i16 = 0;
            }
            if (i18 < split2.length) {
                i17 = Integer.parseInt(split2[i18]);
            } else {
                i17 = 0;
            }
            if (i16 > i17) {
                return 1;
            }
            if (i16 < i17) {
                return -1;
            }
        }
        return 0;
    }

    private static String extractVersionNumbers(String str) {
        Matcher matcher = Pattern.compile("OS(\\d+\\.\\d+\\.\\d+)").matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    private boolean isDiffVersionDiffHDRSupportDevice() {
        String deviceName = TPSystemInfo.getDeviceName();
        if (!XIAO_MI_14_PRO_MODEL.equals(deviceName) && !XIAO_MI_14_MODEL.equals(deviceName)) {
            return false;
        }
        return true;
    }

    private boolean isDisplayHDR10PlusSupport() {
        if (Build.VERSION.SDK_INT >= 29 && TPDisplayHdrCapability.isHdrSupported(4)) {
            return true;
        }
        return false;
    }

    private boolean isDisplayHDR10Support() {
        if (Build.VERSION.SDK_INT >= 24 && TPDisplayHdrCapability.isHdrSupported(2)) {
            return true;
        }
        return false;
    }

    private boolean isDisplayHDRDolbySupport() {
        if (Build.VERSION.SDK_INT >= 24 && TPDisplayHdrCapability.isHdrSupported(1)) {
            return true;
        }
        return false;
    }

    private boolean isHDR10OrHDRVividSupportVersion() {
        String systemProp = TPSystemInfo.getSystemProp("ro.mi.os.version.incremental", "");
        if (TextUtils.isEmpty(systemProp)) {
            return false;
        }
        String extractVersionNumbers = extractVersionNumbers(systemProp);
        if (TextUtils.isEmpty(extractVersionNumbers)) {
            return false;
        }
        if (compareVersion(extractVersionNumbers, MIN_SYSTEM_VERSION, 3) < 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.thumbplayer.core.hdr.capability.device.ITPManufactureHDRCapabilityInterface
    public boolean isHDRSupport(int i3) {
        boolean isDisplayHDR10Support;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    isDisplayHDR10Support = false;
                } else {
                    isDisplayHDR10Support = isDisplayHDRDolbySupport();
                }
            } else {
                isDisplayHDR10Support = isDisplayHDR10PlusSupport();
            }
        } else {
            isDisplayHDR10Support = isDisplayHDR10Support();
        }
        if (isDiffVersionDiffHDRSupportDevice()) {
            if (i3 == 0 || i3 == 4) {
                return isHDR10OrHDRVividSupportVersion();
            }
            return isDisplayHDR10Support;
        }
        return isDisplayHDR10Support;
    }
}
