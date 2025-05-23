package com.tencent.thumbplayer.core.hdr.capability.device.vendor;

import android.os.Build;
import com.huawei.hms.videokit.hdrability.ability.HdrAbility;
import com.tencent.thumbplayer.core.hdr.capability.device.ITPManufactureHDRCapabilityInterface;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;
import java.util.HashMap;

/* loaded from: classes26.dex */
public class TPHuaWeiHDRCapability implements ITPManufactureHDRCapabilityInterface {
    private static String HDR_TYPE_DOLBY = "DolbyVision";
    private static String HDR_TYPE_HDR10 = "Hdr10";
    private static String HDR_TYPE_HDR10Plus = "Hdr10+";
    private static String HDR_TYPE_HLG = "Hlg";
    private static String HDR_TYPE_VIVID = "HdrVivid";
    private static String TAG = "TPHuaWeiHDRCapability";
    private HashMap<Integer, String> mHDRTypeToHDRNameTable;

    public TPHuaWeiHDRCapability() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        this.mHDRTypeToHDRNameTable = hashMap;
        hashMap.put(0, HDR_TYPE_HDR10);
        this.mHDRTypeToHDRNameTable.put(1, HDR_TYPE_HDR10Plus);
        this.mHDRTypeToHDRNameTable.put(2, HDR_TYPE_DOLBY);
        this.mHDRTypeToHDRNameTable.put(3, HDR_TYPE_HLG);
        this.mHDRTypeToHDRNameTable.put(4, HDR_TYPE_VIVID);
    }

    private String getHDRName(int i3) {
        String str = this.mHDRTypeToHDRNameTable.get(Integer.valueOf(i3));
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.thumbplayer.core.hdr.capability.device.ITPManufactureHDRCapabilityInterface
    public boolean isHDRSupport(int i3) {
        if (i3 == 0) {
            i3 = 4;
        }
        if (Build.VERSION.SDK_INT >= 24 && TPSystemInfo.isHarmonyOS()) {
            String hDRName = getHDRName(i3);
            String supportedHdrType = HdrAbility.getSupportedHdrType();
            if (supportedHdrType == null) {
                supportedHdrType = "";
            }
            for (String str : supportedHdrType.split("\\,")) {
                if (str.equalsIgnoreCase(hDRName)) {
                    return true;
                }
            }
        }
        return false;
    }
}
