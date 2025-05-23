package com.tencent.qqlive.module.videoreport.remoteconfig;

import com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class CommonRemoteConfig implements RemoteConfig {
    private RemoteConfig.OnConfigLoadedListener listener;

    @Override // com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig
    public Set<String> allKeys(String str, String str2) {
        return null;
    }

    @Override // com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig
    public String getConfigByKey(String str, String str2) {
        return null;
    }

    @Override // com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig
    public void init(String str) {
        onInit(str);
    }

    @Override // com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig
    public void loadByScene(String str) {
        onLoad();
    }

    @Override // com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig
    public boolean multiSlice() {
        return false;
    }

    protected abstract void onInit(String str);

    protected abstract void onLoad();

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRemoteConfigLoaded() {
        RemoteConfig.OnConfigLoadedListener onConfigLoadedListener = this.listener;
        if (onConfigLoadedListener != null) {
            onConfigLoadedListener.onConfigLoaded();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig
    public void setOnConfigLoadedListener(RemoteConfig.OnConfigLoadedListener onConfigLoadedListener) {
        this.listener = onConfigLoadedListener;
    }
}
