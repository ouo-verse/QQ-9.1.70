package com.tencent.mobileqq.qshadow.interfaces;

/* loaded from: classes17.dex */
public interface IQShadowPluginManager {
    boolean installPlugin();

    long installedPluginSize();

    boolean isPluginInstalled();

    boolean isPluginRunning();

    boolean uninstallPlugin();
}
