package com.tencent.shadow.core.runtime;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes25.dex */
public class PluginPartInfoManager {
    private static Map<ClassLoader, PluginPartInfo> sPluginInfos = new HashMap();

    public static void addPluginInfo(ClassLoader classLoader, PluginPartInfo pluginPartInfo) {
        sPluginInfos.put(classLoader, pluginPartInfo);
    }

    public static Collection<PluginPartInfo> getAllPluginInfo() {
        return sPluginInfos.values();
    }

    public static PluginPartInfo getPluginInfo(ClassLoader classLoader) {
        PluginPartInfo pluginPartInfo = sPluginInfos.get(classLoader);
        if (pluginPartInfo != null) {
            return pluginPartInfo;
        }
        throw new RuntimeException("\u6ca1\u6709\u627e\u5230classLoader\u5bf9\u5e94\u7684pluginInfo classLoader:" + classLoader);
    }
}
