package com.tencent.mobileqq.intervideo.impl;

import com.tencent.mobileqq.intervideo.IPluginEnterManager;
import com.tencent.mobileqq.intervideo.shadow.PluginProcessKiller;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;

/* loaded from: classes33.dex */
public class PluginEnterManagerImpl implements IPluginEnterManager {
    private static PluginEnterManagerImpl sInstance = new PluginEnterManagerImpl();
    private PluginProcessKiller mLastListener;
    private DynamicPluginManager mLastPluginManager;
    private String sLatestOpenType;

    public static PluginEnterManagerImpl getInstance() {
        return sInstance;
    }

    @Override // com.tencent.mobileqq.intervideo.IPluginEnterManager
    public String getLastBizType() {
        return this.sLatestOpenType;
    }

    @Override // com.tencent.mobileqq.intervideo.IPluginEnterManager
    public void switchBiz(String str, PluginProcessKiller pluginProcessKiller) {
        switchBiz(str, null, pluginProcessKiller);
    }

    @Override // com.tencent.mobileqq.intervideo.IPluginEnterManager
    public void switchBiz(String str, DynamicPluginManager dynamicPluginManager) {
        switchBiz(str, dynamicPluginManager, null);
    }

    private void switchBiz(String str, DynamicPluginManager dynamicPluginManager, PluginProcessKiller pluginProcessKiller) {
        PluginProcessKiller pluginProcessKiller2;
        boolean z16 = str != null && str.equals("Now");
        String str2 = this.sLatestOpenType;
        boolean z17 = str2 != null && str2.equals("Now");
        if (z16 || z17) {
            return;
        }
        if (str != null && !str.equals(this.sLatestOpenType)) {
            DynamicPluginManager dynamicPluginManager2 = this.mLastPluginManager;
            if (dynamicPluginManager2 != null && (pluginProcessKiller2 = (PluginProcessKiller) dynamicPluginManager2.getManagerImpl()) != null) {
                pluginProcessKiller2.onKillPluginProcess();
            }
            PluginProcessKiller pluginProcessKiller3 = this.mLastListener;
            if (pluginProcessKiller3 != null) {
                pluginProcessKiller3.onKillPluginProcess();
            }
        }
        this.sLatestOpenType = str;
        this.mLastPluginManager = dynamicPluginManager;
        this.mLastListener = pluginProcessKiller;
    }
}
