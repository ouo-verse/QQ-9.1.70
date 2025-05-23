package com.tencent.qqlive.tvkplayer.tools.utils;

import androidx.annotation.NonNull;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class TVKDrmTypeUtil {
    private static final String DRM_SCHEME_NAME_CHACHA20 = "chacha20";
    private static final String DRM_SCHEME_NAME_CHINA_DRM = "chinaDRM1.0";
    private static final String DRM_SCHEME_NAME_CHINA_DRM_2_0 = "chinaDRM2.0";
    private static final String DRM_SCHEME_NAME_COMMON = "common";
    private static final String DRM_SCHEME_NAME_FAIRPLAY = "fairplay";
    private static final String DRM_SCHEME_NAME_NONE = "none";
    private static final String DRM_SCHEME_NAME_TAIHE = "taihe(unitend)";
    private static final String DRM_SCHEME_NAME_UNKNOWN = "unknown";
    private static final String DRM_SCHEME_NAME_WIDEVINE = "widevine";
    static HashMap<Integer, String> sDrmSchemeTypeToDRMSchemeNameTable;

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        sDrmSchemeTypeToDRMSchemeNameTable = hashMap;
        hashMap.put(0, "none");
        sDrmSchemeTypeToDRMSchemeNameTable.put(1, "common");
        sDrmSchemeTypeToDRMSchemeNameTable.put(2, DRM_SCHEME_NAME_TAIHE);
        sDrmSchemeTypeToDRMSchemeNameTable.put(3, DRM_SCHEME_NAME_CHACHA20);
        sDrmSchemeTypeToDRMSchemeNameTable.put(4, DRM_SCHEME_NAME_FAIRPLAY);
        sDrmSchemeTypeToDRMSchemeNameTable.put(5, DRM_SCHEME_NAME_WIDEVINE);
        sDrmSchemeTypeToDRMSchemeNameTable.put(6, DRM_SCHEME_NAME_CHINA_DRM);
        sDrmSchemeTypeToDRMSchemeNameTable.put(7, DRM_SCHEME_NAME_CHINA_DRM_2_0);
    }

    @NonNull
    public static String drmTypeToName(int i3) {
        String str = sDrmSchemeTypeToDRMSchemeNameTable.get(Integer.valueOf(i3));
        if (str == null) {
            return "unknown";
        }
        return str;
    }
}
