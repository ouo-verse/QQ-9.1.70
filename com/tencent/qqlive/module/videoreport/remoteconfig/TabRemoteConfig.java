package com.tencent.qqlive.module.videoreport.remoteconfig;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class TabRemoteConfig implements RemoteConfig {
    protected RemoteConfig.OnConfigLoadedListener listener;

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

    @Override // com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig
    public Set<String> allKeys(String str, String str2) {
        return filterKeysByPrefix(str2, getAllKeys(str));
    }

    protected abstract Set<String> getAllKeys(String str);

    @Override // com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig
    public void init(String str) {
        initTabSDK(str);
    }

    protected abstract void initTabSDK(String str);

    @Override // com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig
    public void loadByScene(String str) {
        Log.i(DTConstants.TAG.REMOTE_CONFIG, "RemoteConfig start load");
        tabStart(str);
    }

    @Override // com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig
    public boolean multiSlice() {
        return true;
    }

    protected void onRemoteConfigLoaded() {
        RemoteConfig.OnConfigLoadedListener onConfigLoadedListener = this.listener;
        if (onConfigLoadedListener != null) {
            onConfigLoadedListener.onConfigLoaded();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.remoteconfig.RemoteConfig
    public void setOnConfigLoadedListener(RemoteConfig.OnConfigLoadedListener onConfigLoadedListener) {
        this.listener = onConfigLoadedListener;
    }

    protected abstract void tabStart(String str);
}
