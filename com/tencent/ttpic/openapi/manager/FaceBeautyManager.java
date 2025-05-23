package com.tencent.ttpic.openapi.manager;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FaceBeautyManager {
    private static Map<String, Class> faceBeautys = new HashMap();

    public static boolean registerFaceBeauty(String str, Class cls) {
        if (faceBeautys == null) {
            faceBeautys = new HashMap();
        }
        faceBeautys.put(str, cls);
        return true;
    }

    public static void removeFaceBeauty(String str) {
        Map<String, Class> map = faceBeautys;
        if (map != null && str != null) {
            map.remove(str);
        }
    }
}
