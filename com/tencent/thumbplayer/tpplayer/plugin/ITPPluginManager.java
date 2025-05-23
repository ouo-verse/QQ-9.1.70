package com.tencent.thumbplayer.tpplayer.plugin;

/* loaded from: classes26.dex */
public interface ITPPluginManager extends ITPPluginBase {
    void addPlugin(ITPPluginBase iTPPluginBase);

    void release();

    void removePlugin(ITPPluginBase iTPPluginBase);
}
