package com.tencent.aekit.plugin.core;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IModule {
    String getModuleName();

    String getModuleType();

    boolean onModuleInstall(String str, String str2);

    void onModuleUninstall();
}
