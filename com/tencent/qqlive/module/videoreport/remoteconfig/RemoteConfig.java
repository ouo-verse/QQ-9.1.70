package com.tencent.qqlive.module.videoreport.remoteconfig;

import java.util.Set;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface RemoteConfig {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface OnConfigLoadedListener {
        void onConfigLoaded();
    }

    Set<String> allKeys(String str, String str2);

    String getConfigByKey(String str);

    String getConfigByKey(String str, String str2);

    void init(String str);

    boolean isInitialized();

    void loadByScene(String str);

    boolean multiSlice();

    void setOnConfigLoadedListener(OnConfigLoadedListener onConfigLoadedListener);
}
