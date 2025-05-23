package com.tencent.qqlive.tvkplayer.api.asset;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKOnlineSimulatedLiveAsset extends TVKAssetBase {
    private final String mAppScene;
    private final String mChid;
    private final String mPid;

    public TVKOnlineSimulatedLiveAsset(String str, String str2, String str3) {
        this.mPid = TextUtils.isEmpty(str) ? "" : str;
        this.mChid = TextUtils.isEmpty(str2) ? "" : str2;
        this.mAppScene = TextUtils.isEmpty(str3) ? "" : str3;
    }

    public String getAppScene() {
        return this.mAppScene;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset
    public int getAssetType() {
        return 1048576;
    }

    public String getChid() {
        return this.mChid;
    }

    public String getPid() {
        return this.mPid;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset
    public boolean isAssetValid() {
        return !TextUtils.isEmpty(this.mPid);
    }

    @NonNull
    public String toString() {
        return "TVKOnlineSimulatedLiveAsset: pid:" + this.mPid + ", chid:" + this.mChid + ", appScene:" + this.mAppScene + ", assetType:" + getAssetType();
    }
}
