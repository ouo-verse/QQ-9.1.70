package com.tencent.ttpic.openapi.plugin;

import com.tencent.aekit.plugin.core.IDetect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes27.dex */
public class PTPluginManager {
    public static final String ASSETS_DIR = "assets://";
    private static Map<String, Class<? extends IDetect>> detectors = new HashMap();

    public static Class<? extends IDetect> getDetectClass(String str) {
        return detectors.get(str);
    }

    public static List<Class<? extends IDetect>> getDetectorSet() {
        return new ArrayList(detectors.values());
    }

    public static boolean isDetectorReady(String str) {
        if (detectors.get(str) == null) {
            return false;
        }
        return true;
    }

    public static void registerDetectClass(String str, Class<? extends IDetect> cls) {
        detectors.put(str, cls);
    }

    public static void unregisterDetectClass(String str) {
        detectors.remove(str);
    }
}
