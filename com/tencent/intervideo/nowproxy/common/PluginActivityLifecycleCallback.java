package com.tencent.intervideo.nowproxy.common;

/* loaded from: classes7.dex */
public interface PluginActivityLifecycleCallback {
    void onActivityCreated(String str);

    void onActivityDestroyed(String str);

    void onActivityPaused(String str);

    void onActivityResumed(String str);

    void onActivitySaveInstanceState(String str);

    void onActivityStarted(String str);

    void onActivityStopped(String str);
}
