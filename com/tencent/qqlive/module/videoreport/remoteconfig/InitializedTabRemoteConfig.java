package com.tencent.qqlive.module.videoreport.remoteconfig;

import com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class InitializedTabRemoteConfig implements RemoteConfig {
    private RemoteConfig.OnConfigLoadedListener listener;

    private Set<String> filterKeysByPrefix(String str, Set<String> set) {
        if (BaseUtils.isEmpty(set)) {
            return null;
        }
        HashSet hashSet = new HashSet(set.size());
        for (String str2 : set) {
            if (str2.startsWith(str)) {
                hashSet.add(str2);
            }
        }
        return hashSet;
    }

    protected abstract Set<String> allKeys();

    @Override // com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig
    public Set<String> allKeys(String str, String str2) {
        return filterKeysByPrefix(str2, allKeys());
    }

    @Override // com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig
    public String getConfigByKey(String str, String str2) {
        return getConfigByKey(str2);
    }

    @Override // com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig
    public void loadByScene(String str) {
        RemoteConfig.OnConfigLoadedListener onConfigLoadedListener = this.listener;
        if (onConfigLoadedListener != null) {
            onConfigLoadedListener.onConfigLoaded();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig
    public boolean multiSlice() {
        return true;
    }

    @Override // com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig
    public void setOnConfigLoadedListener(RemoteConfig.OnConfigLoadedListener onConfigLoadedListener) {
        this.listener = onConfigLoadedListener;
    }

    @Override // com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig
    public void init(String str) {
    }
}
