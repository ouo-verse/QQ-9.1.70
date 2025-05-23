package com.tencent.thumbplayer.core.hdr.capability.device;

import androidx.annotation.NonNull;
import com.tencent.thumbplayer.core.utils.TPMethodCalledByNative;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes26.dex */
public class TPDeviceDisplayInfo {
    private static final float DEFAULT_HDR_MAX_LUMINANCE_NITS = 500.0f;
    private static final String DEFAULT_LUMINANCE_INFO_KEY = "TP_DEFAULT_LUMINANCE_INFO_KEY";
    private static final float DEFAULT_MIN_LUMINANCE_NITS = 0.0f;
    private static final float DEFAULT_SDR_MAX_LUMINANCE_NITS = 500.0f;
    private static HashMap<String, TPDeviceDisplayLuminanceInfo> sDeviceDisplayMaxLuminanceNitsMap;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class TPDeviceDisplayLuminanceInfo implements Serializable {
        public float hdrMaxLuminanceNits;
        public float minLuminanceNits;
        public float sdrMaxLuminanceNits;

        public TPDeviceDisplayLuminanceInfo(float f16, float f17) {
            this(f16, 500.0f, f17);
        }

        public TPDeviceDisplayLuminanceInfo(float f16, float f17, float f18) {
            this.hdrMaxLuminanceNits = f16;
            this.sdrMaxLuminanceNits = f17;
            this.minLuminanceNits = f18;
        }
    }

    static {
        HashMap<String, TPDeviceDisplayLuminanceInfo> hashMap = new HashMap<>();
        sDeviceDisplayMaxLuminanceNitsMap = hashMap;
        hashMap.put(DEFAULT_LUMINANCE_INFO_KEY, new TPDeviceDisplayLuminanceInfo(500.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("NTH-AN00", new TPDeviceDisplayLuminanceInfo(450.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("LSA-AN00", new TPDeviceDisplayLuminanceInfo(450.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("FNE-AN00", new TPDeviceDisplayLuminanceInfo(700.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("ELZ-AN00", new TPDeviceDisplayLuminanceInfo(450.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("NAM-AL00", new TPDeviceDisplayLuminanceInfo(450.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("ABR-AL00", new TPDeviceDisplayLuminanceInfo(500.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("PEEM00", new TPDeviceDisplayLuminanceInfo(500.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("PEUM00", new TPDeviceDisplayLuminanceInfo(500.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("PGJM10", new TPDeviceDisplayLuminanceInfo(500.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("PHM110", new TPDeviceDisplayLuminanceInfo(500.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("PGW110", new TPDeviceDisplayLuminanceInfo(500.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("PFFM10", new TPDeviceDisplayLuminanceInfo(500.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("PFFM20", new TPDeviceDisplayLuminanceInfo(500.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("V2241A", new TPDeviceDisplayLuminanceInfo(500.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("V2183A", new TPDeviceDisplayLuminanceInfo(500.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("V2145A", new TPDeviceDisplayLuminanceInfo(500.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("V2170A", new TPDeviceDisplayLuminanceInfo(500.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("V2178A", new TPDeviceDisplayLuminanceInfo(500.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("V2049A", new TPDeviceDisplayLuminanceInfo(500.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("V2231A", new TPDeviceDisplayLuminanceInfo(450.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("V2243A", new TPDeviceDisplayLuminanceInfo(900.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("V2254A", new TPDeviceDisplayLuminanceInfo(900.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("V2242A", new TPDeviceDisplayLuminanceInfo(800.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("22011211C", new TPDeviceDisplayLuminanceInfo(500.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("21121210C", new TPDeviceDisplayLuminanceInfo(500.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("m2381", new TPDeviceDisplayLuminanceInfo(500.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("m2391", new TPDeviceDisplayLuminanceInfo(500.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("MEIZU 20 Inf", new TPDeviceDisplayLuminanceInfo(600.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("MEIZU 21", new TPDeviceDisplayLuminanceInfo(900.0f, 0.0f));
        sDeviceDisplayMaxLuminanceNitsMap.put("MEIZU 21 Pro", new TPDeviceDisplayLuminanceInfo(1200.0f, 0.0f));
    }

    @NonNull
    private static TPDeviceDisplayLuminanceInfo getDeviceDisplayLuminanceInfo() {
        TPDeviceDisplayLuminanceInfo tPDeviceDisplayLuminanceInfo = sDeviceDisplayMaxLuminanceNitsMap.get(TPSystemInfo.getDeviceName());
        if (tPDeviceDisplayLuminanceInfo == null) {
            return sDeviceDisplayMaxLuminanceNitsMap.get(DEFAULT_LUMINANCE_INFO_KEY);
        }
        return tPDeviceDisplayLuminanceInfo;
    }

    @TPMethodCalledByNative
    private static float getMaxLuminanceNits() {
        return getDeviceDisplayLuminanceInfo().hdrMaxLuminanceNits;
    }

    @TPMethodCalledByNative
    private static float getMinLuminanceNits() {
        return getDeviceDisplayLuminanceInfo().minLuminanceNits;
    }

    @TPMethodCalledByNative
    private static float getSdrMaxLuminanceNits() {
        return getDeviceDisplayLuminanceInfo().sdrMaxLuminanceNits;
    }
}
