package com.tencent.shadow.core.runtime;

import android.content.res.Resources;

/* loaded from: classes25.dex */
public class PluginPartInfo {
    public ShadowApplication application;
    public ClassLoader classLoader;
    PluginPackageManager packageManager;
    public Resources resources;

    public PluginPartInfo(ShadowApplication shadowApplication, Resources resources, ClassLoader classLoader, PluginPackageManager pluginPackageManager) {
        this.application = shadowApplication;
        this.resources = resources;
        this.classLoader = classLoader;
        this.packageManager = pluginPackageManager;
    }
}
