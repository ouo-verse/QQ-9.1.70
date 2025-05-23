package com.tencent.thumbplayer.core.hdr.capability.device;

import android.os.Build;
import com.tencent.thumbplayer.core.hdr.capability.device.vendor.TPHuaWeiHDRCapability;
import com.tencent.thumbplayer.core.hdr.capability.device.vendor.TPXiaomiHDRCapability;
import java.util.HashMap;

/* loaded from: classes26.dex */
public class TPManufacturerHDRCapabilityManager {
    private static String TAG = "TPManufacturerHDRCapability";
    private static HashMap<String, ITPManufactureHDRCapabilityInterface> manufactureHDRCapabilityMap;

    static {
        HashMap<String, ITPManufactureHDRCapabilityInterface> hashMap = new HashMap<>();
        manufactureHDRCapabilityMap = hashMap;
        hashMap.put("HUAWEI", new TPHuaWeiHDRCapability());
        manufactureHDRCapabilityMap.put("XIAOMI", new TPXiaomiHDRCapability());
    }

    public static ITPManufactureHDRCapabilityInterface getManufactureHDRCapability() {
        String upperCase;
        String str = Build.BRAND;
        if (str == null) {
            upperCase = "";
        } else {
            upperCase = str.toUpperCase();
        }
        return manufactureHDRCapabilityMap.get(upperCase);
    }
}
